import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
%%
%{
    static String str = "";
    static int numID = 0;
    static int numKW = 0;
    static int numN = 0;
    static int numComment = 0;
    static int numQD = 0;
    // static FileWriter f2 = new FileWriter("A2.output");
    static FileWriter f2;

    public static void main(String argv[]) throws java.io.IOException {
	  FileReader f1 = new FileReader("A2.input");
	  f2 = new FileWriter("A2.output");

	  A2 yy = new A2(f1);
	  while (true){
	     yy.yylex();
        }
        // f2.write(str, 0, str.length());
        // f2.close();
      }
      
%}

%eof{
try{
f2.write(str, 0, str.length());
f2.close(); 
} catch (java.io.IOException e){}
%eof}

%notunix
%type void
%class A2
%eofval{ return;
%eofval}

KEYWORD = WRITE|READ|IF|ELSE|RETURN|BEGIN|END|MAIN|STRING|INT|REAL
IDENTIFIER = [a-zA-Z][a-zA-Z0-9]*
NUMBER = ([0-9]+(\.[0-9]+)?)
COMMENTS = (\/\*\*)|(\*\*\/)
QUOTEDSTRING = \"[^\"]*\"
%state new_state

%%
<YYINITIAL>{KEYWORD} {numKW++; }
<YYINITIAL>{IDENTIFIER} { numID++; }
<YYINITIAL>{NUMBER} { numN++; }
<YYINITIAL>{COMMENTS} {numComment++; yybegin(new_state);}
<new_state>{COMMENTS} {yybegin(YYINITIAL);}
<YYINITIAL>{QUOTEDSTRING} {numQD++; }
\r|\n {
str = "identifiers :" + numID + "\nkeywords: " + numKW + "\nnumbers: " + numN + "\ncomments: " + numComment + "\nquotedString: " + numQD + "\n";
System.out.print(str);
// f2.write(str, 0, str.length());
}
. {}
