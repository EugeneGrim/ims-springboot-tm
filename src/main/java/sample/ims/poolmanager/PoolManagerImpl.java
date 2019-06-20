package sample.ims.poolmanager;

import com.ibm.connector2.spi.ConnectionPoolProperties;
import com.ibm.connector2.spi.ConnectionStateChangeObserver;
import com.ibm.connector2.spi.ConnectionStateChangeParticipant;
import com.ibm.connector2.spi.PoolManager;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.security.auth.Subject;

public class PoolManagerImpl implements PoolManager {

  private PrintWriter printWriter = null;
  private List<ManagedConnection> connectionPool = null;
  private int totalConnections = 0;

  public void addConnectionStateChangeObserver(ConnectionStateChangeObserver arg0) { }

  public void addConnectionStateChangeParticipant(ConnectionStateChangeParticipant arg0) { }

  public PrintWriter getLogWriter() {
    return printWriter;
  }

  public void removeConnectionStateChangeObserver(ConnectionStateChangeObserver arg0) { }

  public void removeConnectionStateChangeParticipant(ConnectionStateChangeParticipant arg0) { }

  public void setLogWriter(PrintWriter pw) {
    this.printWriter = pw;
  }

  public void clearForAffinityID(Object arg0) {}

  public void delete(ManagedConnection managedConnection, Object unusedArg) {
    try {
      totalConnections--;
      if (managedConnection != null) {
        managedConnection.destroy();
      }
    } catch (ResourceException e) {
      e.printStackTrace();
    }
  }

  public ManagedConnectionFactory lookupFactory(ManagedConnection arg0) { return null; }

  public Subject lookupSubject(ManagedConnection arg0) { return null; }

  public void release(ManagedConnection managedConnection, Object unusedArg) {
    try {
      managedConnection.cleanup();
      putConnection(managedConnection);
    } catch (ResourceException e) {
      e.printStackTrace();
    }
  }

  public ManagedConnection reserve(ManagedConnectionFactory connectionFactory, ConnectionPoolProperties poolProperties, Subject subject, ConnectionRequestInfo connectionRequestInfo, Object unusedArg1, boolean unusedArg2) {
    if (connectionPool == null) {
      initialize(connectionFactory, poolProperties, connectionRequestInfo);
    }
    return get(connectionFactory, poolProperties, connectionRequestInfo);
  }

  private void initialize(ManagedConnectionFactory factory, ConnectionPoolProperties connectionPoolProperties, ConnectionRequestInfo requestInfo) {
    connectionPool = new ArrayList<>();
    Stream.iterate(0, i -> i++)
        .limit(connectionPoolProperties.getMinConnections())
        .forEach(item -> createConnection(factory, requestInfo));
  }

  private void createConnection(ManagedConnectionFactory factory, ConnectionRequestInfo requestInfo) {
    try {
      connectionPool.add(factory.createManagedConnection(null, requestInfo));
      totalConnections++;
    } catch (ResourceException e) {
      e.printStackTrace();
    }
  }

  private ManagedConnection get(ManagedConnectionFactory connectionFactory, ConnectionPoolProperties connectionPoolProperties, ConnectionRequestInfo requestInfo) {
    if (connectionPool.size() > 0) {
      return connectionPool.remove(0);
    } else if (totalConnections < connectionPoolProperties.getMaxConnections()) {
      totalConnections++;
      try {
        return connectionFactory.createManagedConnection(null, requestInfo);
      } catch (ResourceException e) {
        e.printStackTrace();
        return null;
      }
    } else {
      return null;
    }
  }

  private void putConnection(ManagedConnection connection) {
    connectionPool.add(connection);
  }

  public void stop() {
    if (connectionPool != null) {
      connectionPool.forEach(this::cleanupConnection);
      connectionPool.clear();
      connectionPool = null;
    }
  }

  private void cleanupConnection(ManagedConnection connection) {
    try {
      connection.cleanup();
    } catch (ResourceException e) {
      e.printStackTrace();
    }
    try {
      connection.destroy();
    } catch (ResourceException e) {
      e.printStackTrace();
    }
    totalConnections--;
  }

}
