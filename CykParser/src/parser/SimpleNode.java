/* Generated By:JJTree: Do not edit this line. SimpleNode.java Version 4.3 */
/* JavaCCOptions:MULTI=false,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;

public
class SimpleNode implements Node {

	 protected Node parent;
	  protected Node[] children;
	  protected int id;
	  protected Object value;
	  protected CYKPARSER parser;

	  public String var="";
	  public String prod1="";
	  public String prod2="";
	  
	  public SimpleNode(int i) {
	    id = i;
	  }

	  public SimpleNode(CYKPARSER p, int i) {
	    this(i);
	    parser = p;
	  }

  public void jjtOpen() {
  }

  public void jjtClose() {
  }

  public void jjtSetParent(Node n) { parent = n; }
  public Node jjtGetParent() { return parent; }

  public void jjtAddChild(Node n, int i) {
    if (children == null) {
      children = new Node[i + 1];
    } else if (i >= children.length) {
      Node c[] = new Node[i + 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = n;
  }

  public Node jjtGetChild(int i) {
    return children[i];
  }

  public int jjtGetNumChildren() {
    return (children == null) ? 0 : children.length;
  }

  public void jjtSetValue(Object value) { this.value = value; }
  public Object jjtGetValue() { return value; }

  /* You can override these two methods in subclasses of SimpleNode to
     customize the way the node appears when the tree is dumped.  If
     your output uses more than one line you should override
     toString(String), otherwise overriding toString() is probably all
     you need to do. */

  public String toString() { return CYKPARSERTreeConstants.jjtNodeName[id]; }
  public String toString(String prefix) { return prefix + toString(); }

  /* Override this method if you want to customize how the node dumps
     out its children. */

  public void dump(String prefix) {
	    System.out.println(toString(prefix));
		if(this.var!="") {
				System.out.println("     |    ");
				System.out.println("     " + this.var + "    ");
				if(this.prod1!="" && this.prod2!="")
				{
					System.out.println("    / \\    ");
					System.out.println("   " + this.prod1 + "   " + this.prod2 + "  ");
				}
				else if(this.prod2.equals("")) {
					System.out.println("     |    ");
					System.out.println("     " + this.prod1 + "    ");
				}
		}
		System.out.println();
	    if (children != null) {
	      for (int i = 0; i < children.length; ++i) {
	        SimpleNode n = (SimpleNode)children[i];
	        if (n != null) {
				n.dump(prefix + " ");
	        }
	      }
	    }
	  }
}

/* JavaCC - OriginalChecksum=400e12a32ae8bd47aaab0ba38b162f30 (do not edit this line) */
