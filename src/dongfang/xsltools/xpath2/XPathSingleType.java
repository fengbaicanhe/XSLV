/* Generated By:JJTree: Do not edit this line. XPathSingleType.java */

package dongfang.xsltools.xpath2;

public class XPathSingleType extends XPathTempQName {
  boolean nillable;

  public XPathSingleType(int id) {
    super(id);
  }

  public XPathSingleType(XPathParser p, int id) {
    super(p, id);
  }

  void setNillable() {
    this.nillable = true;
  }

  @Override
public String toString() {
    return qname.getQualifiedName() + (nillable ? "?" : "");
  }
}
