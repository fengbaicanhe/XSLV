/* Generated By:JJTree: Do not edit this line. XPathQName.java */

package dongfang.xsltools.xpath2;

import java.util.Set;

import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.QName;

import dongfang.xsltools.exceptions.XSLToolsRuntimeException;
import dongfang.xsltools.exceptions.XSLToolsXPathUnresolvedNamespaceException;
import dongfang.xsltools.model.NamespaceExpander;

public abstract class XPathQNamedNodeTest extends XPathNodeTest implements
    XPathQNamedTerm {
  QName qname;

  /*
   * Whether the name test matches more than a single QName.
   */
  boolean isMultiple;

  public XPathQNamedNodeTest(int id) {
    super(id);
  }

  public XPathQNamedNodeTest(XPathParser p, int id) {
    super(p, id);
  }

  public XPathQNamedNodeTest(QName name) {
    this(0);
    this.qname = name;
    // TODO: Fixup isMultiple
  }

  public QName getQName() {
    return qname;
  }

  public boolean isMultiple() {
    return isMultiple;
  }

  /*
   * void copyQName() { XPathTempQName q = (XPathTempQName)jjtGetChild(0);
   * this.qname = q.getQName(); this.isMultiple = q.isMultiple(); // remove the
   * temp-qname node Node[] ch = new Node[jjtGetNumChildren()-1];
   * System.arraycopy(children, 1, ch, 0, ch.length); this.children = ch; }
   * 
   * void setQName(String prefix, String localName, NamespaceExpander expander)
   * throws XSLToolsXPathUnresolvedNamespaceException { if ("*".equals(prefix)) {
   * qname = QName.get(localName, "", "*"); isMultiple = true; } else { if
   * ("*".equals(localName)) isMultiple = true; String total = "".equals(prefix) ?
   * localName : prefix + ':' + localName; qname =
   * expander.getQNameFromString(total,
   * NamespaceExpander.BIND_PREFIXLESS_TO_NO_NAMESPACE); } }
   * 
   * void setQName(Token prefixT, Token localNameT, NamespaceExpander expander)
   * throws XSLToolsXPathUnresolvedNamespaceException { String prefix =
   * prefixT==null ? "" : prefixT.image; String localName = localNameT==null ? "" :
   * localNameT.image; setQName(prefix, localName, expander); }
   */

  public void setQName(String qname, NamespaceExpander expander, String npb) {
    int cix = qname.indexOf(':');
    if (cix >= 0) {
      String prefix = qname.substring(0, cix);
      String local = qname.substring(cix + 1);
      if ("*".equals(prefix)) {
        isMultiple = true;
        this.qname = QName.get(local, prefix, "*");
      } else {
        isMultiple = "*".equals(local);
        try {
          this.qname = expander.getQNameFromString(qname, npb);
        } catch (XSLToolsXPathUnresolvedNamespaceException ex) {
          throw new XSLToolsRuntimeException(ex);
        }
      }
    } else {
      if ("*".equals(qname)) {
        isMultiple = true;
        this.qname = QName.get("*", "", "*"); // For binding of default to non
        // null URI, alter this.
      } else {
        this.qname = QName.get(qname); // For binding of default to non null
        // URI, alter this.
      }
    }
  }

  public void setQName(Token qnameT, NamespaceExpander expander, String npb) {
    setQName(qnameT.image, expander, npb);
  }

  @Override
public void moreDiagnostics(Element me, DocumentFactory fac, Set<Object> configuration) {
    super.moreDiagnostics(me, fac, configuration);
    me.addAttribute("QName", qname.getQualifiedName());
  }

  @Override
public String toString() {

    return qname.getQualifiedName();
  }
}
