/* Generated By:JJTree: Do not edit this line. XPathAndExpr.java */

package dongfang.xsltools.xpath2;

/*
 * And expr; is a Logical Expression
 */
public abstract class XPathLogicalExpr extends XPathBase implements XPathExpr {
  public XPathLogicalExpr(int id) {
    super(id);
  }

  public XPathLogicalExpr(XPathParser p, int id) {
    super(p, id);
  }

  public short getType() {
    return TYPE_BOOLEAN;
  }

  abstract String getOperatorName();

  @Override
public String toString() {
    StringBuilder res = new StringBuilder();
    boolean needsOper = false;
    for (int i = 0; i < jjtGetNumChildren(); i++) {
      if (needsOper) {
        res.append(' ');
        res.append(getOperatorName());
        res.append(' ');
      } else
        needsOper = true;
      res.append(jjtGetChild(i).toString());
    }
    return res.toString();
  }
}
