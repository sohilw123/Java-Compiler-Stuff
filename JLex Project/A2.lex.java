import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


class A2 {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

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
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private boolean yy_at_bol;
	private int yy_lexical_state;

	A2 (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	A2 (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private A2 () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private void yy_do_eof () {
		if (false == yy_eof_done) {

try{
f2.write(str, 0, str.length());
f2.close(); 
} catch (java.io.IOException e){}
		}
		yy_eof_done = true;
	}
	private final int new_state = 1;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0,
		21
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NOT_ACCEPT,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NOT_ACCEPT,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NOT_ACCEPT,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NOT_ACCEPT,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NOT_ACCEPT,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NOT_ACCEPT,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NOT_ACCEPT,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"22:10,23,22:2,23,22:20,21,22:7,20,22:3,18,19,17:10,22:7,6,13,16,7,5,8,14,16" +
",3,16:2,9,15,12,16:3,2,10,4,11,16,1,16:3,22:6,16:26,22:5,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,47,
"0,1,2,3,1:2,4,1:3,5,6,5,7,8,9,10,11,12,10,13,14,15,16,17,18,19,20,21,22,23," +
"24,25,26,27,28,29,30,31,32,33,34,35,36,4,37,38")[0];

	private int yy_nxt[][] = unpackFromString(39,24,
"1,2,37,11,44,27,44:4,45,44:2,46,44,38,44,3,4,13,28,16,4,5,-1:25,44,39,44:15" +
",-1:23,3,10,-1:6,44:17,-1:23,12,-1:7,44:7,6,44:3,15,44:5,-1:26,14,-1:23,8,-" +
"1:4,44:3,6,44:13,-1:7,19:20,7,19:2,-1:19,8,-1:5,44:6,6,44:10,-1:7,44:6,6,44" +
",6,44:8,-1:6,1,4:18,30,32,4:2,5,-1,44:4,6,44:12,-1:26,9,-1:4,44:11,6,44:5,-" +
"1:25,9,-1:5,44:13,6,44:3,-1:7,44:8,31,44:2,18,44:5,-1:26,17,-1:4,44:3,42,44" +
",20,44:11,-1:26,23,-1:4,44:9,22,44:7,-1:26,25,-1:4,44:2,24,44:14,-1:7,44:3," +
"22,44:13,-1:7,44,24,44:15,-1:7,44:11,26,44:5,-1:7,44:4,29,44:12,-1:7,44:5,3" +
"3,44:11,-1:7,44:2,34,44:14,-1:7,44,43,44:15,-1:7,44:13,33,44:3,-1:7,44:10,3" +
"5,44:6,-1:7,44:2,36,44:14,-1:7,44:3,40,44:13,-1:7,44:4,41,44:12,-1:6");

	public void yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				yy_do_eof();
 return;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ numID++; }
					case -3:
						break;
					case 3:
						{ numN++; }
					case -4:
						break;
					case 4:
						{}
					case -5:
						break;
					case 5:
						{
str = "identifiers :" + numID + "\nkeywords: " + numKW + "\nnumbers: " + numN + "\ncomments: " + numComment + "\nquotedString: " + numQD + "\n";
System.out.print(str);
// f2.write(str, 0, str.length());
}
					case -6:
						break;
					case 6:
						{numKW++; }
					case -7:
						break;
					case 7:
						{numQD++; }
					case -8:
						break;
					case 8:
						{numComment++; yybegin(new_state);}
					case -9:
						break;
					case 9:
						{yybegin(YYINITIAL);}
					case -10:
						break;
					case 11:
						{ numID++; }
					case -11:
						break;
					case 12:
						{ numN++; }
					case -12:
						break;
					case 13:
						{}
					case -13:
						break;
					case 15:
						{ numID++; }
					case -14:
						break;
					case 16:
						{}
					case -15:
						break;
					case 18:
						{ numID++; }
					case -16:
						break;
					case 20:
						{ numID++; }
					case -17:
						break;
					case 22:
						{ numID++; }
					case -18:
						break;
					case 24:
						{ numID++; }
					case -19:
						break;
					case 26:
						{ numID++; }
					case -20:
						break;
					case 27:
						{ numID++; }
					case -21:
						break;
					case 28:
						{}
					case -22:
						break;
					case 29:
						{ numID++; }
					case -23:
						break;
					case 30:
						{}
					case -24:
						break;
					case 31:
						{ numID++; }
					case -25:
						break;
					case 32:
						{}
					case -26:
						break;
					case 33:
						{ numID++; }
					case -27:
						break;
					case 34:
						{ numID++; }
					case -28:
						break;
					case 35:
						{ numID++; }
					case -29:
						break;
					case 36:
						{ numID++; }
					case -30:
						break;
					case 37:
						{ numID++; }
					case -31:
						break;
					case 38:
						{ numID++; }
					case -32:
						break;
					case 39:
						{ numID++; }
					case -33:
						break;
					case 40:
						{ numID++; }
					case -34:
						break;
					case 41:
						{ numID++; }
					case -35:
						break;
					case 42:
						{ numID++; }
					case -36:
						break;
					case 43:
						{ numID++; }
					case -37:
						break;
					case 44:
						{ numID++; }
					case -38:
						break;
					case 45:
						{ numID++; }
					case -39:
						break;
					case 46:
						{ numID++; }
					case -40:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
