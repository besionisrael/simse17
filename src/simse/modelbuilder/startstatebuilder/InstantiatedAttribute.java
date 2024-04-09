/*
 * This class represents a generic instantiated attribute of a SimSE object. It
 * simply consists of an Attribute and an additional field: value
 */

package simse.modelbuilder.startstatebuilder;

import simse.modelbuilder.objectbuilder.Attribute;

public class InstantiatedAttribute implements Cloneable 
{
  private Object value; // starting value of this attribute
  private Attribute attribute; // Attribute this is based on

  public InstantiatedAttribute(Attribute a) {
    attribute = a;
  }

  public InstantiatedAttribute(Attribute a, Object val) {
    attribute = a;
    value = val;
  }

  public Object clone() {
    try {
      InstantiatedAttribute cl = (InstantiatedAttribute) (super.clone());
      if (value instanceof Integer) {
        cl.value = ((Integer) value);
         // conversion directe en Integer

      } else if (value instanceof Double) {
        cl.value = ((Double) value);
      } else if (value instanceof String) {
        cl.value = value;
      } else if (value instanceof Boolean) {
        cl.value = ((Boolean) value);
      }
      cl.attribute = attribute;
      return cl;
    } catch (CloneNotSupportedException c) {
      System.out.println(c.getMessage());
    }
    return null;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object newVal) {
    value = new Object();
    value = newVal;
  }

  public Attribute getAttribute() {
    return attribute;
  }

  public void setAttribute(Attribute a) {
    attribute = a;
  }

  // returns true if this attribute has a value, false otherwise
  public boolean isInstantiated() { 
    if (value != null) {
      return true;
    } else {
      return false;
    }
  }
}