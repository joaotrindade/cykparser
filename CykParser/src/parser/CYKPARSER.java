/* Generated By:JJTree&JavaCC: Do not edit this line. CYKPARSER.java */
package parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.lang.Integer;
import java.lang.String;
import java.util.Iterator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CYKPARSER/*@bgen(jjtree)*/implements CYKPARSERTreeConstants, CYKPARSERConstants {/*@bgen(jjtree)*/
  protected JJTCYKPARSERState jjtree = new JJTCYKPARSERState();static int error = 0;
        static CYKPARSER myCYK;
        static SimpleNode Tree;
        static int term=0;
        static int x=0;
        static String id=null;
        static String[] var = new String[1000];
        static ArrayList<String[]> variables = new ArrayList<String[]>();
        static ArrayList<String[]> terminals = new ArrayList<String[]>();
  public static void main(String args [])
  {
    int op = 0;
                do {
                        System.out.println("Deseja:");
                    System.out.println("1-Inserir a gramatica");
                    System.out.println("2-Ler de um ficheiro de texto");
                    Scanner inn = new Scanner(System.in);
                    op = inn.nextInt();
                        if(op==1)
                        {
                                numberOne();
                        }
                        else if(op==2)
                        {
                                numberTwo();
                        }
                }while(op!=3);
  }

public static void numberOne() {
        terminals.clear();
        variables.clear();
        myCYK = new CYKPARSER(System.in);
        try {
                Tree = myCYK.Expression();
        }
        catch(ParseException ex) {
                System.out.println("A producao inserida esta incorrecta");
                return;
        }
        for(int g=0;g<terminals.size();g++) {
                        String[] rule = (String[]) terminals.get(g);
                        System.out.print(rule[0] + " -> ");
                        for(int a=1;a<rule.length;a++)
                        {
                                System.out.print(rule[a]+ " ");
                        }
                        System.out.println();
                }
                for(int g=0;g<variables.size();g++) {
                        String[] rule = (String[]) variables.get(g);
                        System.out.print(rule[0] + " -> ");
                        for(int a=1;a<rule.length;a++)
                        {
                                System.out.print(rule[a]+ " ");
                        }
                        System.out.println();
                }
                System.out.println("Escolha a frase a testar:");
                Scanner t = new Scanner(System.in);
                String teste = t.nextLine();
                try {
                        System.out.println(cyk(teste));
                }
                catch(InterruptedException ie) {
                        System.out.println("Nao foi possivel fazer o parse da sua gramatica, por favor verifique se a sua gramatica contem todos os simbolos usados na frase");
                        return;
                }
                catch(java.lang.ArrayIndexOutOfBoundsException arr) {
                                System.out.println("Existe algum simbolo na frase que nao esta definido na gramatica, por favor corrija a gramatica ou teste outra frase");
                                return;
                }
                System.out.println();
        Tree.dump("");
}

public static void numberTwo() {
                        terminals.clear();
                        variables.clear();
                                System.out.println("Insira o nome do ficheiro");
                                Scanner n = new Scanner(System.in);
                                String nome = n.nextLine();
                                try {
                                        myCYK = new CYKPARSER(new java.io.FileInputStream(nome));
                                }
                                catch(java.io.FileNotFoundException e) {
                                        System.out.println ("CYKPARSER: O ficheiro " + nome + " nao foi encontrado.");
                                        return;
                                }
                                try {
                                        Tree = myCYK.Expression();
                                }
                                catch(ParseException ex) {
                                        System.out.println("A sua gramatica esta incorrecta, por favor corrija e volte a tentar. Apenas pode conter ate 2 simbolos terminais ou nao terminais");
                                        return;
                                }
                                for(int g=0;g<terminals.size();g++) {
                        String[] rule = (String[]) terminals.get(g);
                        System.out.print(rule[0] + " -> ");
                        for(int a=1;a<rule.length;a++)
                        {
                                System.out.print(rule[a]+ " ");
                        }
                        System.out.println();
                }
                for(int g=0;g<variables.size();g++) {
                        String[] rule = (String[]) variables.get(g);
                        System.out.print(rule[0] + " -> ");
                        for(int a=1;a<rule.length;a++)
                        {
                                System.out.print(rule[a]+ " ");
                        }
                        System.out.println();
                }
                   System.out.println("Escolha a frase a testar:");
                   Scanner t = new Scanner(System.in);
                   String teste = t.nextLine();
                   try {
                                System.out.println(cyk(teste));
                        }
                        catch(InterruptedException ie) {
                                System.out.println("Nao foi possivel fazer o parse da sua gramatica, por favor verifique se a sua gramatica contem todos os simbolos usados na frase");
                                return;
                        }
                        catch(java.lang.ArrayIndexOutOfBoundsException arr) {
                                System.out.println("Existe algum simbolo na frase que nao esta definido na gramatica, por favor corrija a gramatica ou teste outra frase");
                                return;
                        }
                System.out.println();
                Tree.dump("");
}

public static String[] returnPosT(String prod) {
        int x=0;
        int contador=0;
        for(int a=0;a<terminals.size();a++)
        {
                String rule[] = terminals.get(a);
                if(prod.equals(rule[1]))
                {
                        contador++;
                }
        }
        String[] pos = new String[contador];
        for(int a=0;a<terminals.size();a++)
        {
                String rule[] = terminals.get(a);
                if(prod.equals(rule[1]))
                {
                        pos[x] = rule[0];
                        x++;
                }
        }
        return pos;
}

public static String[] returnPosNT(String prod, String prod2) {
        if(prod==null | prod2==null)
                return null;
        else
        {
                int x=0;
                int contador=0;
                for(int a=0;a<variables.size();a++)
                {
                        String rule[] = variables.get(a);
                        if(prod.equals(rule[1]) && prod2.equals(rule[2]))
                        {
                                        contador++;
                        }
                }
                String[] pos = new String[contador];
                for(int a=0;a<variables.size();a++)
                {
                        String rule[] = variables.get(a);
                        if(prod.equals(rule[1]) && prod2.equals(rule[2]))
                        {
                                        pos[x] = rule[0];
                                        x++;
                        }
                }
                return pos;
        }
}

public static boolean cyk(String entrada) throws InterruptedException {
        String ent[] = entrada.split("\u005c\u005cs");
        int n=ent.length;

        String[][][] table =new String[n+1][][];
        String[][] temp = new String[n][];
        table[0] = temp;
        for(int x=1;x<=n;++x) {
                int n_temp = n-(x-1);
                String[][] temp1 = new String[n_temp][];
                table[x] = temp1;
        }


        for(int x=0;x<n;x++) {
                String[] novo = returnPosT(ent[x]);
                table[0][x] = novo;
        }
        System.out.println("");

        for(int i=0;i<n;i++)
        {
                System.out.println("table[0]["+i+"] ->  " + table[0][i][0] + " ");
        }
        System.out.println("");

        for (int i = 1; i < n; ++i) {

        for (int j = 0; j < n - i; ++j) {
          System.out.print("table["+ i + "]" + "["+ j + "] ->");

                  String[] prod = table[i][j];

                   for (int k = i - 1; k >= 0; --k) {

                        String[] downprod = table[k][j];
            String[] diagprod = table[i - k - 1][j + k + 1];

                        if(diagprod == null || downprod == null)
                        {

                        }
                        else
                        {
                                if (downprod[0] != null && diagprod[0] != null) {
                                  for (int ii = 0; ii < downprod.length; ++ii) {
                                        String prod1 = downprod[ii];

                                        for (int jj = 0; jj < diagprod.length; ++jj) {
                                          String prod2 = diagprod[jj];
                                          String[] rightside = returnPosNT(prod1,prod2);
                                          if (rightside==null || rightside.length == 0) {

                                          }
                                          else
                                          {
                                                if (prod == null) {
                                                        prod = new String[100];
                                                        table[i][j] = prod;
                                                }

                                                  String[] arr = new String[1000];
                                                  boolean found=false;
                                                  boolean vainada=false;
                                                  int kk=0;

                                                        for(int verifyNULLS=0;verifyNULLS<prod.length;verifyNULLS++)
                                                        {
                                                                if(prod[verifyNULLS] != null)
                                                                {
                                                                        vainada=true;
                                                                }
                                                        }

                                                        if(vainada==true)
                                                        {
                                                                for(kk = 0 ; kk < prod.length; kk++) arr[kk] = prod[kk];
                                                        }

                                                        for(int ll = 0 ; ll < rightside.length; ll++)
                                                        {
                                                                found = false;
                                                                for(int pp = 0; pp < kk; pp++)
                                                                {
                                                                        if (rightside[ll] == arr[pp]) found = true;
                                                                }

                                                                if (found == false) arr[kk] = rightside[ll];
                                                                kk++;
                                                        }

                                                  table[i][j]=arr;
                                                  for(int a=0;a<kk;a++)
                                                  {
                                                        if(table[i][j][a]!="")
                                                                System.out.print(table[i][j][a]);
                                                  }
                                                  System.out.println("");
                                                }
                                        }
                                  }
                                }
                        }
                }
                }
                System.out.println();
        }

        if(table[n-1][0] != null)
        {
                if(table[n-1][0][0] != null)
                {
                        return true;
                }
                else
                        return false;
        }
        else
                return false;
        }

  final public SimpleNode Expression() throws ParseException {
                                  /*@bgen(jjtree) START */
  SimpleNode jjtn000 = new SimpleNode(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VARIABLE:
      case TS:
        label_1:
        while (true) {
          Expr1();
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case VARIABLE:
          case TS:
            ;
            break;
          default:
            jj_la1[0] = jj_gen;
            break label_1;
          }
        }
                             jjtree.closeNodeScope(jjtn000, true);
                             jjtc000 = false;
                            {if (true) return jjtn000;}
        break;
      case LFLF:
        jj_consume_token(LFLF);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
                  if (jjtc000) {
                    jjtree.clearNodeScope(jjtn000);
                    jjtc000 = false;
                  } else {
                    jjtree.popNode();
                  }
                  if (jjte000 instanceof RuntimeException) {
                    {if (true) throw (RuntimeException)jjte000;}
                  }
                  if (jjte000 instanceof ParseException) {
                    {if (true) throw (ParseException)jjte000;}
                  }
                  {if (true) throw (Error)jjte000;}
    } finally {
                  if (jjtc000) {
                    jjtree.closeNodeScope(jjtn000, true);
                  }
    }
    throw new Error("Missing return statement in function");
  }

  final public void Expr1() throws ParseException {
                           /*@bgen(jjtree) ASSIGNMNT */
                            SimpleNode jjtn000 = new SimpleNode(JJTASSIGNMNT);
                            boolean jjtc000 = true;
                            jjtree.openNodeScope(jjtn000);Token t,t2,t3,t4;
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VARIABLE:
        t = jj_consume_token(VARIABLE);
                jjtn000.var = t.image;
                id=t.image;
        jj_consume_token(DIVISION);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case VARIABLE:
          t2 = jj_consume_token(VARIABLE);
                jjtn000.prod1 = t2.image;
                var[x]=t2.image;
                x++;
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case VARIABLE:
            t3 = jj_consume_token(VARIABLE);
                jjtn000.prod2 = t3.image;
                var[x]=t3.image;
                x++;
            break;
          case TS:
            t4 = jj_consume_token(TS);
                jjtn000.prod2 = t4.image;
                var[x]=t4.image;
                x++;
            break;
          default:
            jj_la1[2] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
        case TS:
          t2 = jj_consume_token(TS);
                jjtn000.prod1 = t2.image;
                var[x]=t2.image;
                x++;
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case VARIABLE:
            t3 = jj_consume_token(VARIABLE);
                jjtn000.prod2 = t3.image;
                var[x]=t3.image;
                x++;
            break;
          case TS:
            t4 = jj_consume_token(TS);
                jjtn000.prod2 = t4.image;
                var[x]=t4.image;
                x++;
            break;
          default:
            jj_la1[3] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          break;
        case TERMINAL:
          t2 = jj_consume_token(TERMINAL);
                jjtn000.prod1 = t2.image;
                term=1;
                var[x]=t2.image;
                x++;
          break;
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      case TS:
        t = jj_consume_token(TS);
                jjtn000.var = t.image;
                id=t.image;
        jj_consume_token(DIVISION);
        t2 = jj_consume_token(TERMINAL);
                jjtn000.prod1 = t2.image;
                term=1;
                var[x]=t2.image;
                x++;
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t3 = jj_consume_token(LF);
          jjtree.closeNodeScope(jjtn000, true);
          jjtc000 = false;
                if(term==0)
                {
                        String[] total = new String[x+1];
                        total[0]=id;
                        for(int i=0;i<x;i++)
                        {
                                total[i+1]=var[i];
                        }
                        variables.add(total);
                }
                else
                {
                        String[] total = new String[2];
                        total[0]=id;
                        total[1]=var[0];
                        terminals.add(total);
                }
                x=0;
                term=0;
                var = new String[1000];
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  /** Generated Token Manager. */
  public CYKPARSERTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xc0,0xe0,0xc0,0xc0,0x1c0,0xc0,};
   }

  /** Constructor with InputStream. */
  public CYKPARSER(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CYKPARSER(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CYKPARSERTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CYKPARSER(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CYKPARSERTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CYKPARSER(CYKPARSERTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CYKPARSERTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[10];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 10; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
