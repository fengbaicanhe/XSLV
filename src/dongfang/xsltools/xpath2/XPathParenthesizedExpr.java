/* Generated By:JJTree: Do not edit this line. XPathParenthesizedExpr.java */

package dongfang.xsltools.xpath2;

public class XPathParenthesizedExpr extends XPathPredicateCarrier implements
    XPathFilterExpr {
  public XPathParenthesizedExpr(int id) {
    super(id);
  }

  public XPathParenthesizedExpr(XPathParser p, int id) {
    super(p, id);
  }

  public short getType() {
    return TYPE_ANY;
  }

  @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    if (jjtGetNumChildren() > 1)
      sb.append(jjtGetChild(0).toString());
    sb.append(")");
    // predicates
    sb.append(jjtGetChild(jjtGetNumChildren() - 1).toString());
    return sb.toString();
  }
}
