/*
 * MIT License
 * 
 * Copyright (c) 2017 iting9545
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 * Any questions, please contact me by email 954576654@qq.com
 * 
 * 
 * 
 * 
 */
package org.iting.util.common;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author XingJiang
 */
public final class IStringUtils {

	////////////////////////////////////////////////////////////////////////
	// Constructs
	/**
	 * Default Construct
	 * 
	 * @throws Error 
	 */
	private IStringUtils() {
		throw new Error("Initialize of " + getClass().getName() + " is not allowed!");
	}
	
	////////////////////////////////////////////////////////////////////////
	// Constants
	// ---------------------------------------------------------------------
	// Charset Names
	/**
	 * 
	 */
	public static final String US_ASCII      = "US-ASCII";
	
	/**
	 * 
	 */
	public static final String ISO_8859_1    = "ISO-8859-1";
	
	/**
	 * 
	 */
	public static final String GBK           = "GBK";
	
	/**
	 * 
	 */
	public static final String UTF_8         = "UTF-8";
	
	/**
	 * 
	 */
	public static final String UTF_16        = "UTF-16";
	
	/**
	 * 
	 */
	public static final String UTF_16BE      = "UTF-16BE";
	
	/**
	 * 
	 */
	public static final String UTF_16LE      = "UTF-16LE";
	
	/**
	 * 
	 */
	public static final Set<String> CHARSETS = Charset.availableCharsets().keySet();
	
	// ---------------------------------------------------------------------
	// System Properties
	/**
	 * 
	 */
	public static final String LINE_SEPARATOR  = System.getProperty("line.separator");
	
	/**
	 * 
	 */
	public static final String FILE_SEPARATOR  = System.getProperty("file.separator");
	
	/**
	 * 
	 */
	public static final String SYSTEM_ENCODING = System.getProperty("file.encoding");
	
	/**
	 * 
	 */
	public static final String OS_NAME         = System.getProperty("os.name");
	
	/**
	 * 
	 */
	public static final String USER_HOME       = System.getProperty("user.home");
	
	/**
	 * 
	 */
	public static final String TMP_DIR         = System.getProperty("java.io.tmpdir");
	
	// ---------------------------------------------------------------------
	// Regex
	/**
	 * 
	 */
	public static final String REGEX_NEW_LINE = "\r\n|\r|\n";
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param string 
	 * @return {@code true} if {@code string == null || string.length == 0}, otherwise {@code false}
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return {@code true} if {@code string != null && string.length > 0}, otherwise {@code false}
	 */
	public static boolean isNotEmpty(String string) {
		return string != null && string.length() > 0;
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean isBlank(String string) {
		return isEmpty(string) || string.matches("\\s+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean isNotBlank(String string) {
		return !isEmpty(string) && !string.matches("\\s+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean containsBlank(String string) {
		return isEmpty(string) || !string.matches("\\S+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean containsNonBlank(String string) {
		return !isEmpty(string) && string.matches("\\S+");
	}
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param c 
	 * @return {@code true} if {@code '0' <= c <= '9'}, otherwise {@code false}
	 */
	public static boolean isNumeric(char c) {
		return c >= '0' && c <= '9';
	}
	
	/**
	 * 
	 * 
	 * @param c 
	 * @return {@code true} if {@code 'a' <= c <= 'z'}, otherwise {@code false}
	 */
	public static boolean isLowerCase(char c) {
		return c >= 'a' && c <= 'z';
	}
	
	/**
	 * 
	 * 
	 * @param c 
	 * @return {@code true} if {@code 'A' <= c <= 'Z'}, otherwise {@code false}
	 */
	public static boolean isUpperCase(char c) {
		return c >= 'A' && c <= 'Z';
	}
	
	/**
	 * 
	 * 
	 * @param c 
	 * @return {@code true} if {@code 'a' <= c <= 'z' || 'A' <= c <= 'Z'}, otherwise {@code false}
	 */
	public static boolean isLetter(char c) {
		return isLowerCase(c) || isUpperCase(c);
	}
	
	/**
	 * 
	 * 
	 * @param c 
	 * @return 
	 */
	public static char    toLowerCase(char c) {
		return !isUpperCase(c) ? c : (char) (c + ('a' - 'A'));
	}
	
	/**
	 * 
	 * 
	 * @param c 
	 * @return 
	 */
	public static char    toUpperCase(char c) {
		return !isLowerCase(c) ? c : (char) (c - ('a' - 'A'));
	}
	
	/**
	 * 
	 * 
	 * @param c 
	 * @return 
	 */
	public static int     toNumber(char c) {
		return !isNumeric(c) ? -1 : (c - '0');
	}
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param string 
	 * @param target 
	 * @return 
	 */
	public static int      count(String string, String target) {
		int count = 0;
		if (!isEmpty(string) && !isEmpty(target)) {
			int index = string.indexOf(target);
			while (index != -1) {
				count++;
				index = string.indexOf(target, index + target.length());
			}
		}
		return count;
	}
	
	/**
	 * 
	 * 
	 * @param string    
	 * @param separator 
	 * @return 
	 */
	public static String[] split(String string, String separator) {
		if (isEmpty(string)) {
			return new String[0];
		}
		
		int count = count(string, separator);
		if (count == 0) {
			return new String[]{ string };
		}
		
		List<Integer> points = new ArrayList<>(count + 2);
		points.add(0);
		int point = string.indexOf(separator);
		while (point != -1) {
			points.add(point);
			point = string.indexOf(separator, point + separator.length());
		}
		points.add(string.length());

		String[] result = new String[count + 1];
		result[0] = string.substring(0, points.get(1));
		for (int index = 1; index < result.length; index++) {
			result[index] = string.substring(points.get(index) + separator.length(), points.get(index + 1));
		}

		return result;
	}
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
     * 
	 * @param source 
	 * @param from   
	 * @param to     
	 * @param target 
	 * @return 
	 * 
	 * @throws NullPointerException 
	 * @throws StringIndexOutOfBoundsException 
	 * @throws IllegalArgumentException 
	 */
	public static String replace(String source, int from, int to, String target) {
		if (source == null) {
			throw new NullPointerException("The parameter source is null!");
		}
		if (target == null) {
			throw new NullPointerException("The parameter target is null!");
		}
		
		if (from < 0 || from > source.length()) {
			throw new StringIndexOutOfBoundsException("String index out of range: " + from);
		}
		if (to   < 0 || to   > source.length()) {
			throw new StringIndexOutOfBoundsException("String index out of range: " + to);
		}
		
		if (from > to) {
			throw new IllegalArgumentException("The parameter from is larger than to where from = " + from + " and to = " + to + "!");
		}
		
		return source.substring(0, from) + target + source.substring(to);
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param from   
	 * @param to     
	 * @return 
	 * 
	 * @throws NullPointerException 
	 * @throws StringIndexOutOfBoundsException 
	 * @throws IllegalArgumentException 
	 */
	public static String remove(String source, int from, int to) {
		return replace(source, from, to, "");
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param index  
	 * @return 
	 * 
	 * @throws NullPointerException 
	 * @throws StringIndexOutOfBoundsException 
	 */
	public static String remove(String source, int index) {
		return replace(source, index, index + (index == source.length() ? 0 : 1), "");
	}
	
	/**
	 * 
	 * 
	 * @param unit  
	 * @param times 
	 * @return 
	 * 
	 * @throws IllegalArgumentException 
	 */
	public static String repeat(String unit, int times) {
		if (!isEmpty(unit) && times > 0) {
			long size = (long) unit.length() * (long) times;
			if (size > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("Too many characters of the expected result[0-2147483647]: " + size);
			}
			
			List<Boolean> odds = new ArrayList<Boolean>(); 
			while (times > 0) {
				if ((times & 1) == 1) {
					odds.add(true);
					times--;
				} else {
					odds.add(false);
					times >>= 1;
				}
			}
			
			StringBuffer buffer = new StringBuffer((int) size);
			for (int index = odds.size() - 1; index >= 0; index--) {
				buffer.append(odds.get(index) ? unit : buffer);
			}
			return buffer.toString();
		}

		return "";
	}
	
	/**
	 * 
	 * 
	 * @param times 
	 * @return 
	 * 
	 * @throws IllegalArgumentException 
	 */
	public static String tabs(int times) {
		return repeat("\t", times);
	}
	
	/**
	 * 
	 * 
	 * @param col 
	 * @return 
	 */
	public static String toExcelColReference(int col) {
		String result = "";
		if (col > 0) {
			for (col = col - 1; col >= 0; col = col / 26 - 1) {
				result = (char)(col % 26 + 'A') + result;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @param size   
	 * @return 
	 */
	public static String resize(String string, int size) {
		return isEmpty(string) ? repeat(" ", size) : (string + repeat(" ", size - string.length()));
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @param size   
	 * @return 
	 */
	public static String resizeOnLeft(String string, int size) {
		return isEmpty(string) ? repeat(" ", size) : (repeat(" ", size - string.length()) + string);
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 * 
	 * @see String#trim()
	 */
	public static String trim(String string) {
		if (!isEmpty(string)) {
			char[] value = string.toCharArray();
	        int    from  = 0;
	        int    to    = value.length;

	        while ((from < to) && (value[from] <= ' ' || value[from] == ' ' || value[from] == '　')) {
	            from++;
	        }
	        
	        while ((from < to) && (value[to - 1] <= ' ' || value[to - 1] == ' ' || value[to - 1] == '　')) {
	            to--;
	        }
	        
	        return ((from > 0) || (to < value.length)) ? string.substring(from, to) : string;
		}
		
		return "";
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static String toUnicode(String string) {
		if (!isEmpty(string)) {
			StringBuffer buffer = new StringBuffer(string.length() * 6);
			for (char c : string.toCharArray()) {
				buffer.append("\\u").append(Integer.toHexString((int) c));
			}
			return buffer.toString();
		}
		return "";
	}
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean isNumber(String string) {
		return !isEmpty(string) && string.matches("[\\+|\\-]?((\\d+)|(\\.\\d+)|(\\d+\\.)|(\\d+\\.\\d+)|(\\d+(e|E)([\\+|\\-]?)\\d+)|(\\.\\d+(e|E)([\\+|\\-]?)\\d+)|(\\d+\\.(e|E)([\\+|\\-]?)\\d+)|(\\d+\\.\\d+(e|E)([\\+|\\-]?)\\d+))");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean madeUpByNumeric(String string) {
		return !isEmpty(string) && string.matches("\\d+"); // <==> "[0-9]+"
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean madeUpByLowerCases(String string) {
		return !isEmpty(string) && string.matches("[a-z]+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean madeUpByUpperCases(String string) {
		return !isEmpty(string) && string.matches("[A-Z]+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean madeUpByLetter(String string) {
		return !isEmpty(string) && string.matches("[a-zA-Z]+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean madeUpByLetterOrNumeric(String string) {
		return !isEmpty(string) && string.matches("[a-zA-Z0-9]+");
	}
	
	/**
	 * 
	 * 
	 * @param string 
	 * @return 
	 */
	public static boolean madeUpByWord(String string) {
		return !isEmpty(string) && string.matches("\\w+"); // <==> "[a-zA-Z0-9_]+"
	}
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param route 
	 * @return 
	 */
	public static boolean isLegalPackageName(String route) {
		return !isEmpty(route) && Arrays.stream(split(route, ".")).allMatch(item -> !isEmpty(item) && item.matches("[a-z]([a-z0-9]+)?"));
	}
	
	/**
	 * 
	 * 
	 * @param name 
	 * @return 
	 */
	public static boolean isLegalClassName(String name) {
		return !isEmpty(name) && name.matches("[A-Z]([a-zA-Z0-9]+)?");
	}
	
	/**
	 * 
	 * 
	 * @param name 
	 * @return 
	 */
	public static boolean isLegalAttributeName(String name) {
		return !isEmpty(name) && name.matches("[a-z]([a-zA-Z0-9]+)?");
	}
	
	/**
	 * 
	 * 
	 * @param attribute 
	 * @param isBoolean 
	 * @return 
	 */
	public static String  getter(String attribute, boolean isBoolean) {
		return !isLegalAttributeName(attribute) ? "" 
				: ((isBoolean ? "is" : "get") + toUpperCase(attribute.charAt(0)) + attribute.substring(1));
	}
	
	/**
	 * 
	 * 
	 * @param attribute 
	 * @return 
	 */
	public static String  setter(String attribute) {
		return !isLegalAttributeName(attribute) ? "" : ("set" + toUpperCase(attribute.charAt(0)) + attribute.substring(1));
	}
	
	///////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param charset 
	 * @return 
	 */
	public static boolean isValidCharset(String charset) {
		return !isEmpty(charset) && CHARSETS.stream().anyMatch(item -> charset.equals(item));
	}
	
}
