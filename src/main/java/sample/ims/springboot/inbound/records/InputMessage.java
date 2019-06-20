package sample.ims.springboot.inbound.records;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import com.ibm.etools.marshall.util.*;

/**
 * @generated Generated Class: InputMessage
 * @type-descriptor.aggregate-instance-td accessor="readWrite" contentSize="59" offset="0"
 * size="59"
 * @type-descriptor.platform-compiler-info language="COBOL" defaultBigEndian="true"
 * defaultCodepage="1141" defaultExternalDecimalSign="ebcdic" defaultFloatType="ibm390Hex"
 */

@SuppressWarnings({"serial", "rawtypes", "unused", "unchecked"})
public class InputMessage implements javax.resource.cci.Record, javax.resource.cci.Streamable,
    com.ibm.etools.marshall.RecordBytes {

  private byte[] buffer_ = null;
  private static final int bufferSize_;
  private static final byte[] initializedBuffer_;
  private static java.util.HashMap getterMap_ = null;
  private java.util.HashMap valFieldNameMap_ = null;

  static {
    bufferSize_ = 59;
    initializedBuffer_ = new byte[bufferSize_];
    String in__fillInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__fillInitialValue, initializedBuffer_, 10, "1141",
            4, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    String in__commandInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__commandInitialValue, initializedBuffer_, 14,
            "1141", 8, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    String in__last__nameInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__last__nameInitialValue, initializedBuffer_, 22,
            "1141", 10, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    String in__zip__codeInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__zip__codeInitialValue, initializedBuffer_, 52,
            "1141", 7, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    String in__first__nameInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__first__nameInitialValue, initializedBuffer_, 32,
            "1141", 10, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    String in__trancodeInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__trancodeInitialValue, initializedBuffer_, 4,
            "1141", 6, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    String in__extensionInitialValue = " ";
    MarshallStringUtils
        .marshallFixedLengthStringIntoBuffer(in__extensionInitialValue, initializedBuffer_, 42,
            "1141", 10, MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
  }

  public InputMessage() {
    initialize();
  }

  public InputMessage(java.util.HashMap valFieldNameMap) {
    valFieldNameMap_ = valFieldNameMap;
    initialize();
  }

  public void initialize() {
    buffer_ = new byte[bufferSize_];
    System.arraycopy(initializedBuffer_, 0, buffer_, 0, bufferSize_);
  }

  public void read(java.io.InputStream inputStream)
      throws java.io.IOException {
    byte[] input = new byte[inputStream.available()];
    inputStream.read(input);
    buffer_ = input;
  }

  public void write(java.io.OutputStream outputStream) throws java.io.IOException {
    outputStream.write(buffer_, 0, getSize());
  }

  public String getRecordName() {
    return (this.getClass().getName());
  }

  public void setRecordName(String recordName) {
    return;
  }

  public void setRecordShortDescription(String shortDescription) {
    return;
  }

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

  public byte[] getBytes() {
    return (buffer_);
  }

  public void setBytes(byte[] bytes) {
    if ((bytes != null) && (bytes.length != 0)) {
      buffer_ = bytes;
    }
  }

  public int getSize() {
    return (59);
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
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="2" offset="0" size="2"
   * @type-descriptor.integer-td signCoding="twosComplement"
   */
  public short getIn__ll() {
    short in__ll = 0;
    in__ll = MarshallIntegerUtils.unmarshallTwoByteIntegerFromBuffer(
        buffer_, 0, true,
        MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
    return (in__ll);
  }

  public void setIn__ll(short in__ll) {
    MarshallIntegerUtils.marshallTwoByteIntegerIntoBuffer(in__ll, buffer_,
        0, true, MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
  }

  /**
   * @generated
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="2" offset="2" size="2"
   * @type-descriptor.integer-td signCoding="twosComplement"
   */
  public short getIn__zz() {
    short in__zz = 0;
    in__zz = MarshallIntegerUtils.unmarshallTwoByteIntegerFromBuffer(
        buffer_, 2, true,
        MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
    return (in__zz);
  }

  public void setIn__zz(short in__zz) {
    MarshallIntegerUtils.marshallTwoByteIntegerIntoBuffer(in__zz, buffer_,
        2, true, MarshallIntegerUtils.SIGN_CODING_TWOS_COMPLEMENT);
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="6"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="6" offset="4" size="6"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__trancode() {
    String in__trancode = null;
    in__trancode = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 4, "1141", 6);
    return (in__trancode);
  }

  public void setIn__trancode(String in__trancode) {
    if (in__trancode != null) {
      if (in__trancode.length() > 6) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__trancode,
                "6", "in__trancode"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          in__trancode, buffer_, 4, "1141", 6,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="4"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="4" offset="10" size="4"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__fill() {
    String in__fill = null;
    in__fill = MarshallStringUtils.unmarshallFixedLengthStringFromBuffer(
        buffer_, 10, "1141", 4);
    return (in__fill);
  }

  public void setIn__fill(String in__fill) {
    if (in__fill != null) {
      if (in__fill.length() > 4) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__fill, "4",
                "in__fill"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(in__fill,
          buffer_, 10, "1141", 4,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="8"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="8" offset="14" size="8"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__command() {
    String in__command = null;
    in__command = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 14, "1141", 8);
    return (in__command);
  }

  public void setIn__command(String in__command) {
    if (in__command != null) {
      if (in__command.length() > 8) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__command,
                "8", "in__command"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          in__command, buffer_, 14, "1141", 8,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="3"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="3" offset="14" size="3"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getTemp__iocmd() {
    String temp__iocmd = null;
    temp__iocmd = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 14, "1141", 3);
    return (temp__iocmd);
  }

  public void setTemp__iocmd(String temp__iocmd) {
    if (temp__iocmd != null) {
      if (temp__iocmd.length() > 3) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, temp__iocmd,
                "3", "temp__iocmd"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          temp__iocmd, buffer_, 14, "1141", 3,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="5"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="5" offset="17" size="5"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getTemp__filler() {
    String temp__filler = null;
    temp__filler = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 17, "1141", 5);
    return (temp__filler);
  }

  public void setTemp__filler(String temp__filler) {
    if (temp__filler != null) {
      if (temp__filler.length() > 5) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, temp__filler,
                "5", "temp__filler"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          temp__filler, buffer_, 17, "1141", 5,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="10"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="10" offset="22"
   * size="10"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__last__name() {
    String in__last__name = null;
    in__last__name = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 22, "1141", 10);
    return (in__last__name);
  }

  public void setIn__last__name(String in__last__name) {
    if (in__last__name != null) {
      if (in__last__name.length() > 10) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__last__name,
                "10", "in__last__name"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          in__last__name, buffer_, 22, "1141", 10,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="10"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="10" offset="32"
   * size="10"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__first__name() {
    String in__first__name = null;
    in__first__name = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 32, "1141", 10);
    return (in__first__name);
  }

  public void setIn__first__name(String in__first__name) {
    if (in__first__name != null) {
      if (in__first__name.length() > 10) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__first__name,
                "10", "in__first__name"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          in__first__name, buffer_, 32, "1141", 10,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="10"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="10" offset="42"
   * size="10"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__extension() {
    String in__extension = null;
    in__extension = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 42, "1141", 10);
    return (in__extension);
  }

  public void setIn__extension(String in__extension) {
    if (in__extension != null) {
      if (in__extension.length() > 10) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__extension,
                "10", "in__extension"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          in__extension, buffer_, 42, "1141", 10,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

  /**
   * @generated
   * @type-descriptor.restriction maxLength="7"
   * @type-descriptor.initial-value kind="SPACE"
   * @type-descriptor.simple-instance-td accessor="readWrite" contentSize="7" offset="52" size="7"
   * @type-descriptor.string-td characterSize="1" lengthEncoding="fixedLength" paddingCharacter=" "
   * prefixLength="0"
   */
  public String getIn__zip__code() {
    String in__zip__code = null;
    in__zip__code = MarshallStringUtils
        .unmarshallFixedLengthStringFromBuffer(buffer_, 52, "1141", 7);
    return (in__zip__code);
  }

  public void setIn__zip__code(String in__zip__code) {
    if (in__zip__code != null) {
      if (in__zip__code.length() > 7) {
        throw new IllegalArgumentException(MarshallResource.instance()
            .getString(MarshallResource.IWAA0124E, in__zip__code,
                "7", "in__zip__code"));
      }
      MarshallStringUtils.marshallFixedLengthStringIntoBuffer(
          in__zip__code, buffer_, 52, "1141", 7,
          MarshallStringUtils.STRING_JUSTIFICATION_LEFT, " ");
    }
  }

}