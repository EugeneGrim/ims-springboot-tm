package sample.ims.springboot.inbound.records;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibm.etools.marshall.util.ConversionUtils;
import com.ibm.etools.marshall.util.MarshallIntegerUtils;
import com.ibm.etools.marshall.util.MarshallResource;
import com.ibm.etools.marshall.util.MarshallStringUtils;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * @generated Generated Class: OutputMessage
 * @type-descriptor.aggregate-instance-td accessor="readWrite" contentSize="93" offset="0"
 * size="93"
 * @type-descriptor.platform-compiler-info language="COBOL" defaultBigEndian="true"
 * defaultCodepage="1141" defaultExternalDecimalSign="ebcdic" defaultFloatType="ibm390Hex"
 */

@SuppressWarnings({"serial", "rawtypes", "unused", "unchecked"})
//@JsonRootName("result")
public class OutputMessage implements javax.resource.cci.Record,
    javax.resource.cci.Streamable, com.ibm.etools.marshall.RecordBytes {

  private byte[] buffer_ = null;
  private static final int bufferSize_;
  private static final byte[] initializedBuffer_;
  private static java.util.HashMap getterMap_ = null;
  private java.util.HashMap valFieldNameMap_ = null;

  static {
    bufferSize_ = 93;
    initializedBuffer_ = new byte[bufferSize_];
    String out__segment__noInitialValue = "0001";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(out__segment__noInitialValue, initializedBuffer_, 89,
            "1141", 4, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    short out__llInitialValue = (short) +95;
    MarshallIntegerUtils
        .marshallTwoByteIntegerIntoBuffer(out__llInitialValue, initializedBuffer_, 0, true,
            MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
    String output__lineInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(output__lineInitialValue, initializedBuffer_, 4,
            "1141", 85, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    short out__zzInitialValue = (short) +0;
    MarshallIntegerUtils
        .marshallTwoByteIntegerIntoBuffer(out__zzInitialValue, initializedBuffer_, 2, true,
            MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
  }

  public OutputMessage() {
    initialize();
  }

  public OutputMessage(java.util.HashMap valFieldNameMap) {
    valFieldNameMap_ = valFieldNameMap;
    initialize();
  }

  public void initialize() {
    buffer_ = new byte[bufferSize_];
    System.arraycopy(initializedBuffer_, 0, buffer_, 0, bufferSize_);
  }

  public void read(java.io.InputStream inputStream) throws java.io.IOException {
    byte[] input = new byte[inputStream.available()];
    inputStream.read(input);
    buffer_ = input;
  }

  public void write(java.io.OutputStream outputStream)
      throws java.io.IOException {
    outputStream.write(buffer_, 0, getSize());
  }

  @JsonIgnore
  public String getRecordName() {
    return (this.getClass().getName());
  }

  public void setRecordName(String recordName) {
    return;
  }

  public void setRecordShortDescription(String shortDescription) {
    return;
  }

  @JsonIgnore
  public String getRecordShortDescription() {
    return (this.getClass().getName());
  }

  public Object clone() throws CloneNotSupportedException {
    return (super.clone());
  }

  public boolean equals(Object object) {
    return (super.equals(object));
  }

  public int hashCode() {
    return (super.hashCode());
  }

  @JsonIgnore
  public byte[] getBytes() {
    return (buffer_);
  }

  public void setBytes(byte[] bytes) {
    if ((bytes != null) && (bytes.length != 0)) {
      buffer_ = bytes;
    }
  }

  @JsonIgnore
  public int getSize() {
    return (93);
  }

  public boolean match(Object obj) {
    if (obj == null) {
      return (false);
    }
    if (obj.getClass().isArray()) {
      byte[] currBytes = buffer_;
      try {
        byte[] objByteArray = (byte[]) obj;
        if (objByteArray.length != buffer_.length) {
          return (false);
        }
        buffer_ = objByteArray;
      } catch (ClassCastException exc) {
        return (false);
      } finally {
        buffer_ = currBytes;
      }
    } else {
      return (false);
    }
    return (true);
  }

  public void populate(Object obj) {
    if (obj.getClass().isArray()) {
      try {
        buffer_ = (byte[]) obj;
      } catch (ClassCastException exc) {
      }
    }
  }

  public String toString() {
    StringBuffer sb = new StringBuffer(super.toString());
    sb.append("\n");
    ConversionUtils.dumpBytes(sb, buffer_);
    return (sb.toString());
  }

  public Number wrappedGetNumber(String propertyName) {
    Number result = null;

    if (getterMap_ == null) {
      synchronized (initializedBuffer_) {
        if (getterMap_ == null) {
          java.util.HashMap getterMap = new java.util.HashMap();
          try {
            BeanInfo info = Introspector.getBeanInfo(this
                .getClass());
            PropertyDescriptor[] props = info
                .getPropertyDescriptors();

            for (int i = 0; i < props.length; i++) {
              String propName = props[i].getName();
              getterMap.put(propName, props[i].getReadMethod());
            }
          } catch (IntrospectionException exc) {
          }
          getterMap_ = getterMap;
        }
      }
    }

    Method method = (Method) getterMap_.get(propertyName);
    if (method != null) {
      try {
        result = (Number) method.invoke(this, new Object[0]);
      } catch (Exception exc) {
      }
    }

    return (result);
  }

  public java.util.HashMap evaluateMap(java.util.HashMap valFieldNameMap) {
    if (valFieldNameMap == null) {
      return (null);
    }
    java.util.HashMap returnMap = new java.util.HashMap(
        valFieldNameMap.size());
    java.util.Set aSet = valFieldNameMap.entrySet();

    for (java.util.Iterator cursor = aSet.iterator(); cursor.hasNext(); ) {
      java.util.Map.Entry element = (java.util.Map.Entry) cursor.next();
      String key = (String) element.getKey();
      String fieldName = (String) element.getValue();
      Number fieldValue = wrappedGetNumber(fieldName);
      if (fieldValue == null) {
        fieldValue = new Integer(0);
      }
      returnMap.put(key, fieldValue);
    }

    return (returnMap);
  }

  public int evaluateFormula(String formula, java.util.HashMap valFieldNameMap)
      throws IllegalArgumentException {
    if (formula == null) {
      throw new IllegalArgumentException(MarshallResource.instance()
          .getString(MarshallResource.MARSHRT_FORMULA_NULL));
    }

    int result = 0;

    int index = formula.indexOf("(");

    if (index == -1) // It's a number not an expression
    {
      try {
        result = Integer.parseInt(formula);
      } catch (Exception exc) {
      }

      return (result);
    }

    // Determine the outermost function
    String function = formula.substring(0, index);

    if (function.equalsIgnoreCase("val")) {
      Object field = valFieldNameMap.get(formula);
      if (field == null) {
        return (0);
      }

      if (field instanceof String) {
        Number num = wrappedGetNumber((String) field);
        if (num == null) // Element does not exist
        {
          return (0);
        }
        result = num.intValue();
      } else if (field instanceof Number) {
        result = ((Number) field).intValue();
      } else {
        return (0);
      }

      return (result);
    } else if (function.equalsIgnoreCase("neg")) {
      // The new formula is the content between the brackets
      formula = formula.substring(index + 1, formula.length() - 1);
      result = -1 * evaluateFormula(formula, valFieldNameMap);
      return (result);
    } else {
      // Get the contents between the outermost brackets
      formula = formula.substring(index + 1, formula.length() - 1);
      char[] formulaChars = formula.toCharArray();

      // Get the left side and the right side of the operation

      int brackets = 0;
      int i = 0;

      for (; i < formulaChars.length; i++) {
        if (formulaChars[i] == '(') {
          brackets++;
        } else if (formulaChars[i] == ')') {
          brackets--;
        } else if (formulaChars[i] == ',') {
          if (brackets == 0) {
            break;
          }
        }
      }

      String leftSide = "0";
      String rightSide = "0";

      leftSide = formula.substring(0, i);
      rightSide = formula.substring(i + 1);

      if (function.equalsIgnoreCase("add")) {
        result = evaluateFormula(leftSide, valFieldNameMap)
            + evaluateFormula(rightSide, valFieldNameMap);
      } else if (function.equalsIgnoreCase("mpy")) {
        result = evaluateFormula(leftSide, valFieldNameMap)
            * evaluateFormula(rightSide, valFieldNameMap);
      } else if (function.equalsIgnoreCase("sub")) {
        result = evaluateFormula(leftSide, valFieldNameMap)
            - evaluateFormula(rightSide, valFieldNameMap);
      } else if (function.equalsIgnoreCase("div")) {
        result = evaluateFormula(leftSide, valFieldNameMap)
            / evaluateFormula(rightSide, valFieldNameMap);
      } else if (function.equalsIgnoreCase("max")) {
        result = Math.max(evaluateFormula(leftSide, valFieldNameMap),
            evaluateFormula(rightSide, valFieldNameMap));
      } else if (function.equalsIgnoreCase("min")) {
        result = Math.min(evaluateFormula(leftSide, valFieldNameMap),
            evaluateFormula(rightSide, valFieldNameMap));
      } else if (function.equalsIgnoreCase("mod")) {
        result = evaluateFormula(leftSide, valFieldNameMap)
            % evaluateFormula(rightSide, valFieldNameMap);
      }
    }

    return (result);
  }

  /**
   * @generated
   * @type-descriptor.initial-value kind="string_value" value="+95"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="2" offset="0" size="2"
   * @type-descriptor.integer-td signCoding="twosComplement"
   */
  @JsonIgnore
  public short getOut__ll() {
    short out__ll = 0;
    out__ll = MarshallIntegerUtils.unmarshallTwoByteIntegerFromBuffer(
        buffer_, 0, true,
        MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
    return (out__ll);
  }

  public void setOut__ll(short out__ll) {
    MarshallIntegerUtils.marshallTwoByteIntegerIntoBuffer(out__ll, buffer_,
        0, true, MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
  }

  /**
   * @generated
   * @type-descriptor.initial-value kind="string_value" value="+0"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="2" offset="2" size="2"
   * @type-descriptor.integer-td signCoding="twosComplement"
   */
  @JsonIgnore
  public short getOut__zz() {
    short out__zz = 0;
    out__zz = MarshallIntegerUtils.unmarshallTwoByteIntegerFromBuffer(
        buffer_, 2, true,
        MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
    return (out__zz);
  }

  public void setOut__zz(short out__zz) {
    MarshallIntegerUtils.marshallTwoByteIntegerIntoBuffer(out__zz, buffer_,
        2, true, MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="85"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="85" offset="4" size="85"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  @JsonIgnore
  public String getOutput__line() {
    String output__line = null;
    output__line = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 4, "1141", 85);
    return (output__line);
  }

  public void setOutput__line(String output__line) {
    if (output__line != null) {
      if (output__line.length() > 85) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, output__line,
                "85", "output__line"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          output__line, buffer_, 4, "1141", 85,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="40"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="40" offset="4" size="40"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("message")
  public String getOut__message() {
    String out__message = null;
    out__message = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 4, "1141", 40);
    return (out__message);
  }

  public void setOut__message(String out__message) {
    if (out__message != null) {
      if (out__message.length() > 40) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, out__message,
                "40", "out__message"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__message, buffer_, 4, "1141", 40,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="8"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="8" offset="44" size="8"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("command")
  public String getOut__command() {
    String out__command = null;
    out__command = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 44, "1141", 8);
    return (out__command);
  }

  public void setOut__command(String out__command) {
    if (out__command != null) {
      if (out__command.length() > 8) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, out__command,
                "8", "out__command"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__command, buffer_, 44, "1141", 8,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="10"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="10" offset="52"
   * size="10"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("lastname")
  public String getOut__last__name() {
    String out__last__name = null;
    out__last__name = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 52, "1141", 10);
    return (out__last__name);
  }

  public void setOut__last__name(String out__last__name) {
    if (out__last__name != null) {
      if (out__last__name.length() > 10) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, out__last__name,
                "10", "out__last__name"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__last__name, buffer_, 52, "1141", 10,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="10"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="10" offset="62"
   * size="10"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("firstname")
  public String getOut__first__name() {
    String out__first__name = null;
    out__first__name = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 62, "1141", 10);
    return (out__first__name);
  }

  public void setOut__first__name(String out__first__name) {
    if (out__first__name != null) {
      if (out__first__name.length() > 10) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E,
                out__first__name, "10", "out__first__name"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__first__name, buffer_, 62, "1141", 10,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="10"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="10" offset="72"
   * size="10"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("extension")
  public String getOut__extension() {
    String out__extension = null;
    out__extension = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 72, "1141", 10);
    return (out__extension);
  }

  public void setOut__extension(String out__extension) {
    if (out__extension != null) {
      if (out__extension.length() > 10) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, out__extension,
                "10", "out__extension"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__extension, buffer_, 72, "1141", 10,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="7"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="7" offset="82" size="7"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("zipcode")
  public String getOut__zip__code() {
    String out__zip__code = null;
    out__zip__code = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 82, "1141", 7);
    return (out__zip__code);
  }

  public void setOut__zip__code(String out__zip__code) {
    if (out__zip__code != null) {
      if (out__zip__code.length() > 7) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, out__zip__code,
                "7", "out__zip__code"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__zip__code, buffer_, 82, "1141", 7,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="4"
   * @type-descriptor.initial-value kind="string_value" value="0001"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="4" offset="89" size="4"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  //@JsonProperty("segmentnumber")
  public String getOut__segment__no() {
    String out__segment__no = null;
    out__segment__no = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 89, "1141", 4);
    return (out__segment__no);
  }

  public void setOut__segment__no(String out__segment__no) {
    if (out__segment__no != null) {
      if (out__segment__no.length() > 4) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E,
                out__segment__no, "4", "out__segment__no"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          out__segment__no, buffer_, 89, "1141", 4,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

}