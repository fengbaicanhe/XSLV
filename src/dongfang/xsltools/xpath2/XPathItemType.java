/* Generated By:JJTree: Do not edit this line. XPathItemType.java */

package dongfang.xsltools.xpath2;

public class XPathItemType extends XPathBase {

  char card;

  public XPathItemType(int id) {
    super(id);
  }

  public XPathItemType(XPathParser p, int id) {
    super(p, id);
  }

  void setCard(Token t) {
    if (t == null)
      card = 0;
    else {
      card = t.image.charAt(0);
    }
  }

  @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(jjtGetChild(0).toString());
    if (card != 0)
      sb.append(card);
    return sb.toString();
  }
}
