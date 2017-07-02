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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.swing.filechooser.FileSystemView;

import static org.iting.util.common.ICollectionUtils.in;
import static org.iting.util.common.ICollectionUtils.isEmpty;
import static org.iting.util.common.ICollectionUtils.suffixIn;
import static org.iting.util.common.IStringUtils.FILE_SEPARATOR;
import static org.iting.util.common.IStringUtils.LINE_SEPARATOR;
import static org.iting.util.common.IStringUtils.SYSTEM_ENCODING;
import static org.iting.util.common.IStringUtils.isEmpty;
import static org.iting.util.common.IStringUtils.isValidCharset;

/**
 * 
 * 
 * @author XingJiang
 */
public class IFileUtils {

	////////////////////////////////////////////////////////////////////////
	// Constructs
	/**
	 * Default Construct
	 * 
	 * @throws Error
	 */
	private IFileUtils() {
		throw new Error("Initialize of " + getClass().getName() + " is not allowed!");
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 */
	static final int DEFAULT_IO_SIZE = 32 * 1024;
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static boolean isExist(String path) {
		return !isEmpty(path) && new File(path).exists();
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static boolean isFile(String path) {
		return !isEmpty(path) && new File(path).isFile();
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static boolean isDirectory(String path) {
		return !isEmpty(path) && new File(path).isDirectory();
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @return 
	 */
	public static String desktop() {
		return FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath();
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static String standardPath(String path) {
		if (!isEmpty(path)) {
			path = path.replaceAll("[\\\\]|[/]", "\\".equals(FILE_SEPARATOR) ? "\\\\" : FILE_SEPARATOR);
			while (path.matches(".*(([\\\\][\\\\])|[//]).*")) {
				path = path.replaceAll("[\\\\][\\\\]", "\\\\").replaceAll("//", "/");
			}
			if (path.length() > 1 && path.endsWith(FILE_SEPARATOR)) {
				path = path.substring(0, path.length() - 1);
			}
			return path;
		}
		return "";
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param file 
	 * @return 
	 */
	public static long sizeof(File file) {
		return (file == null || !file.exists()) ? 0L : (file.isFile() ? file.length()
				: Arrays.stream(file.listFiles()).parallel().mapToLong(item -> sizeof(item)).sum());
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static long sizeof(String path) {
		return path == null ? 0L : sizeof(new File(path));
	}
	
	////////////////////////////////////////////////////////////////////////
	// 	
	/**
	 * 
	 * 
	 * @param path    
	 * @param charset 
	 * @return 
	 */
	public static String read(String path, String charset) {
		if (isFile(path)) {
			long size = sizeof(path);
			if (size > 0L && size <= Integer.MAX_VALUE) {
				String result = "";
				byte[] bytes  = new byte[(int) size];
				try (FileInputStream fileReader = new FileInputStream(path);
						BufferedInputStream reader = new BufferedInputStream(fileReader);) {
					if (!isValidCharset(charset)) {
						charset = SYSTEM_ENCODING;
					}
					byte[] block = new byte[DEFAULT_IO_SIZE];
					int length = 0;
					int step = 0;
					while ((length = reader.read(block)) != -1) {
						System.arraycopy(block, 0, bytes, step++ * DEFAULT_IO_SIZE, length);
					}
					result = new String(bytes, charset);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return result.trim();
			}
		}
		return "";
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static String read(String path) {
		return read(path, null);
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @return 
	 */
	public static String read2(String path) {
		if (isFile(path)) {
			long size = sizeof(path);
			if (size > 0L && size <= Integer.MAX_VALUE) {
				StringBuffer buffer = new StringBuffer((int) size);
				try (FileReader fileReader = new FileReader(path);
						BufferedReader reader = new BufferedReader(fileReader);) {
					String line = null;
					while ((line = reader.readLine()) != null) {
						buffer.append(line).append(LINE_SEPARATOR);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return buffer.toString().trim();
			}
		}
		return "";
	}
	
	/**
	 * 
	 * 
	 * @param path    
	 * @param data    
	 * @param append  
	 * @param charset 
	 */
	public static void   write(String path, String data, boolean append, String charset) {
		if (path != null && data != null) {
			try (FileOutputStream fileWriter = new FileOutputStream(path, append);
					BufferedOutputStream writer = new BufferedOutputStream(fileWriter);) {
				if (!isValidCharset(charset)) {
					charset = SYSTEM_ENCODING;
				}
				
				int starting = 0;
				int terminal = DEFAULT_IO_SIZE;

				while (terminal <= data.length()) {
					writer.write(data.substring(starting, terminal).getBytes(charset));

					starting += DEFAULT_IO_SIZE;
					terminal += DEFAULT_IO_SIZE;
				}

				writer.write(data.substring(starting).getBytes(charset));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param path    
	 * @param data    
	 * @param charset 
	 */
	public static void   write(String path, String data, String charset) {
		write(path, data, false, charset);
	}
	
	/**
	 * 
	 * 
	 * @param path   
	 * @param data   
	 * @param append 
	 */
	public static void   write(String path, String data, boolean append) {
		write(path, data, append, null);
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 * @param data 
	 */
	public static void   write(String path, String data) {
		write(path, data, false, null);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param resource 
	 * @return 
	 */
	public static Properties getProperties(String resource) {
		Properties properties = new Properties();
		if (isFile(resource)) {
			try (FileInputStream fileReader = new FileInputStream(resource);
					BufferedInputStream reader = new BufferedInputStream(fileReader);) {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param path    
	 * @param ignores 
	 * @param filter  
	 * @return 
	 */
	public static List<String> find(String path, String[] ignores, FileFilter filter) {
		if (isExist(path)) {
			IFileVisitor visitor = new IFileVisitor(ignores, filter);
			try {
				Files.walkFileTree(new File(path).toPath(), visitor);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return visitor.getFiles();
		}
		return new ArrayList<>(0);
	}
	
	/**
	 * 
	 * 
	 * @param path   
	 * @param filter 
	 * @return 
	 */
	public static List<String> find(String path, FileFilter filter) {
		return find(path, null, filter);
	}
	
	/**
	 * 
	 * 
	 * @param path    
	 * @param target  
	 * @param deep    
	 * @param ignores 
	 * @return 
	 */
	public static String       find(String path, String target, int deep, String[] ignores) {
		if (isExist(path) && !isEmpty(target)) {
			File root = new File(path);
			if (root.getName().equals(target)) {
				return root.getAbsolutePath();
			}
			if (root.isDirectory()) {
				for (File file : root.listFiles()) {
					if (file.getName().equals(target)) {
						return file.getAbsolutePath();
					}
				}
				
				if (deep > 1) {
					for (File dir : root.listFiles(DIRECTORY_FILTER)) {
						if (isEmpty(ignores) || !in(dir.getName(), ignores)) {
							String finder = find(dir.getAbsolutePath(), target, deep - 1, ignores);
							if (!isEmpty(finder)) {
								return finder;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @author XingJiang
	 */
	static class IFileVisitor extends SimpleFileVisitor<Path> {

		////////////////////////////////////////////////////////////////////////
		// 
		/**
		 * 
		 */
		private List<String> files   = new ArrayList<>();
		
		/**
		 * 
		 */
		private String[]     ignores = null;

		/**
		 * 
		 */
		private FileFilter   filter  = null;
				
		////////////////////////////////////////////////////////////////////////
		// 
		/**
		 * 
		 */
		public IFileVisitor() {
		}
		
		/**
		 * 
		 * 
		 * @param ignores 
		 * @param filter  
		 */
		public IFileVisitor(String[] ignores, FileFilter filter) {
			this.ignores = ignores;
			this.filter  = filter;
		}
		
		////////////////////////////////////////////////////////////////////////
		// 
		/**
		 * 
		 */
		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
			if (!isEmpty(ignores) && in(dir.toFile().getName(), ignores)) {
				return FileVisitResult.SKIP_SUBTREE;
			}
			
			if (filter == null || filter.accept(dir.toFile())) {
				files.add(dir.toFile().getAbsolutePath());
			}

			return FileVisitResult.CONTINUE;
		}
		
		/**
		 * 
		 */
		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
			if (!isEmpty(ignores) && in(file.toFile().getName(), ignores)) {
				return FileVisitResult.SKIP_SUBTREE;
			}
			
			if (filter == null || filter.accept(file.toFile())) {
				files.add(file.toFile().getAbsolutePath());
			}
			
			return FileVisitResult.CONTINUE;
		}

		////////////////////////////////////////////////////////////////////////
		// Getter
		/**
		 * 
		 * 
		 * @return 
		 */
		public List<String> getFiles() {
			return files;
		}

	}
	
	////////////////////////////////////////////////////////////////////////
	// File Filter
	/**
	 * 
	 */
	public static FileFilter DIRECTORY_FILTER = item -> item.isDirectory();
	
	/**
	 * 
	 */
	public static FileFilter FILE_FILTER      = item -> item.isFile();
	
	/**
	 * 
	 * 
	 * @param suffixes 
	 * @return 
	 */
	public static FileFilter generateFileFilter(String ... suffixes) {
		return item -> item.isFile() && suffixIn(item.getName(), suffixes);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param file 
	 */
	public  static void delete(File file) {
		if (file != null && file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else {
				for (File child : file.listFiles()) {
					delete(child);
				}
				file.delete();
			}
		}
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 */
	public  static void delete(String path) {
		if (isExist(path)) {
			delete(new File(path));
		}
	}
	
	/**
	 * 
	 * 
	 * @param path 
	 */
	public  static void mkdirs(String path) {
		if (!isEmpty(path) && !isExist(path)) {
			new File(path).mkdirs();
		}
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 */
	public  static void move(String source, String target) {
		if (isExist(source)) {
			target = standardPath(target);
			
			if (!isExist(target)) {
				mkdirs(target);
			}
			
			File root = new File(source);
			
			root.renameTo(new File(target + FILE_SEPARATOR + root.getName()));
		}
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 */
	private static void copyFile(String source, String target) {
		try (FileInputStream fileReader = new FileInputStream(source);
				BufferedInputStream reader = new BufferedInputStream(fileReader);
				FileOutputStream fileWriter = new FileOutputStream(target);
				BufferedOutputStream writer = new BufferedOutputStream(fileWriter);) {
			byte[] block  = new byte[DEFAULT_IO_SIZE];
			int    length = 0;
			
			while ((length = reader.read(block)) != -1) {
				writer.write(block, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 */
	public  static void copy(String source, String target) {
		if (isExist(source)) {
			target = standardPath(target);

			if (!isExist(target)) {
				mkdirs(target);
			}
			
			File root = new File(source);
			
			if (root.isFile()) {
				copyFile(source, target + FILE_SEPARATOR + root.getName());
			} else {
				String dir = target + FILE_SEPARATOR + root.getName();
				mkdirs(dir);
				for (File child : root.listFiles()) {
					copy(child.getAbsolutePath(), dir);
				}
			}
		}
	}
	
}
