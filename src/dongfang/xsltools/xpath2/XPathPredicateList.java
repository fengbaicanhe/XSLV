/* Generated By:JJTree: Do not edit this line. XPathPredicateList.java */

package dongfang.xsltools.xpath2;

import java.util.Iterator;

public class XPathPredicateList extends XPathBase {
  public XPathPredicateList(int id) {
    super(id);
  }

  public XPathPredicateList(XPathParser p, int id) {
    super(p, id);
  }

  public XPathPredicateList() {
    this(0);
  }

  boolean hasPredicates() {
    return getPredicateCount() != 0;
  }

  public int getPredicateCount() {
    return jjtGetNumChildren();
  }

  public XPathExpr getPredicate(int i) {
    return (XPathExpr) jjtGetChild(i);
  }

  public Iterator<XPathExpr> predicates() {
    return new Iterator<XPathExpr>() {
      int i = 0;

      public boolean hasNext() {
        return i < jjtGetNumChildren();
      }

      public XPathExpr next() {
        return (XPathExpr) jjtGetChild(i++);
      }

      public void remove() {
      }
    };
  }

  @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < jjtGetNumChildren(); i++) {
      sb.append('[');
      sb.append(jjtGetChild(i).toString());
      sb.append(']');
    }
    return sb.toString();
  }
}