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

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 
 * 
 * @author XingJiang
 */
public class ICollectionUtils {

	////////////////////////////////////////////////////////////////////////
	// Constructs
	/**
	 * Default Construct
	 * 
	 * @throws Error
	 */
	private ICollectionUtils() {
		throw new Error("Initialize of " + getClass().getName() + " is not allowed!");
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param string 
	 * @return {@code true} if {@code string == null || string.length == 0}, otherwise {@code false}
	 */
	private static boolean isEmpty(String string) {
		return string == null || string.length() == 0;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(boolean[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(char[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(short[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(long[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(float[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(double[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code array == null || array.length == 0}, otherwise {@code false}
	 */
	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code collection == null || collection.size == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(Collection<?> collection) {
		return collection == null || collection.size() == 0;
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return {@code true} if {@code map == null || map.size == 0}, otherwise {@code false}
	 */
	public static     boolean isEmpty(Map<?, ?> map) {
		return map == null || map.size() == 0;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param <T>   
	 * @param array 
	 * @return {@code true} if {@code array != null && array.length > 0 && null in array}, otherwise {@code false}
	 */
	public  static <T> boolean containsNull(T[] array) {
		return !isEmpty(array) && Arrays.stream(array).anyMatch(item -> item == null);
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @return {@code true} if {@code collection != null && collection.size > 0 && null in collection}, otherwise {@code false}
	 */
	public  static     boolean containsNull(Collection<?> collection) {
		return !isEmpty(collection) && collection.stream().anyMatch(item -> item == null);
	}
	
	/**
	 * 
	 * 
	 * @param map 
	 * @return {@code true} if {@code map != null && map.size > 0 && null in map.keys}, otherwise {@code false}
	 */
	public  static     boolean containsNullKey(Map<?, ?> map) {
		return !isEmpty(map) && map.keySet().stream().anyMatch(item -> item == null);
	}
	
	/**
	 * 
	 * 
	 * @param map 
	 * @return {@code true} if {@code map != null && map.size > 0 && null in map.values}, otherwise {@code false}
	 */
	public  static     boolean containsNullVal(Map<?, ?> map) {
		return !isEmpty(map) && map.values().stream().anyMatch(item -> item == null);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param <T>   
	 * @param array 
	 * @return {@code true} if {@code array != null && array.length > 0 && array[i] != null, 0 <= i < array.length}, otherwise {@code false}
	 */
	public  static <T> boolean containsNonNull(T[] array) {
		return !isEmpty(array) && Arrays.stream(array).allMatch(item -> item != null);
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @return {@code true} if {@code collection != null && collection.size > 0 && collection[i] != null, 0 <= i < collection.size}, otherwise {@code false}
	 */
	public  static     boolean containsNonNull(Collection<?> collection) {
		return !isEmpty(collection) && collection.stream().allMatch(item -> item != null);
	}
	
	/**
	 * 
	 * 
	 * @param map 
	 * @return {@code true} if {@code map != null && map.size > 0 && map.keys[i] != null, 0 <= i < map.size}, otherwise {@code false}
	 */
	public  static     boolean containsNonNullKey(Map<?, ?> map) {
		return !isEmpty(map) && map.keySet().stream().allMatch(item -> item != null);
	}
	
	/**
	 * 
	 * 
	 * @param map 
	 * @return {@code true} if {@code map != null && map.size > 0 && map.values[i] != null, 0 <= i < map.size}, otherwise {@code false}
	 */
	public  static     boolean containsNonNullVal(Map<?, ?> map) {
		return !isEmpty(map) && map.values().stream().allMatch(item -> item != null);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param array  
	 * @param target 
	 * @return {@code true} if {@code array != null && array.length > 0 && target in array}, otherwise {@code false}
	 */
	public  static     boolean contains(int[] array, int target) {
		return !isEmpty(array) && Arrays.stream(array).anyMatch(item -> item == target);
	}
	
	/**
	 * 
	 * 
	 * @param stream 
	 * @param target 
	 * @return 
	 */
	private static     boolean contains(Stream<?> stream, Object target) {
		return target == null ? stream.anyMatch(item -> item == null) : stream.anyMatch(item -> target.equals(item));
	}
	
	/**
	 * 
	 * 
	 * @param <T>    
	 * @param array  
	 * @param target 
	 * @return {@code true} if {@code array != null && array.length > 0 && target in array}, otherwise {@code false}
	 */
	public  static <T> boolean contains(T[] array, T target) {
		return !isEmpty(array) && contains(Arrays.stream(array), target);
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @param target     
	 * @return {@code true} if {@code collection != null && collection.size > 0 && target in collection}, otherwise {@code false}
	 */
	public  static     boolean contains(Collection<?> collection, Object target) {
		return !isEmpty(collection) && contains(collection.stream(), target);
	}
	
	/**
	 * 
	 * 
	 * @param <K> 
	 * @param map 
	 * @param key 
	 * @return {@code true} if {@code map != null && map.size > 0 && key in map.keys}, otherwise {@code false}
	 */
	public  static <K> boolean containsKey(Map<K, ?> map, K key) {
		return !isEmpty(map) && contains(map.keySet().stream(), key);
	}
	
	/**
	 * 
	 * 
	 * @param <V> 
	 * @param map 
	 * @param val 
	 * @return {@code true} if {@code map != null && map.size > 0 && val in map.values}, otherwise {@code false}
	 */
	public  static <V> boolean containsVal(Map<?, V> map, V val) {
		return !isEmpty(map) && contains(map.values().stream(), val);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param target 
	 * @param array  
	 * @return {@code true} if {@code array != null && array.length > 0 && target in array}, otherwise {@code false}
	 */
	public  static     boolean in(int target, int[] array) {
		return !isEmpty(array) && Arrays.stream(array).anyMatch(item -> item == target);
	}
	
	/**
	 * 
	 * 
	 * @param target 
	 * @param stream 
	 * @return 
	 */
	private static     boolean in(Object target, Stream<?> stream) {
		return target == null ? stream.anyMatch(item -> item == null) : stream.anyMatch(item -> target.equals(item));
	}
	
	/**
	 * 
	 * 
	 * @param <T>    
	 * @param target 
	 * @param array  
	 * @return {@code true} if {@code array != null && array.length > 0 && target in array}, otherwise {@code false}
	 */
	public  static <T> boolean in(T target, T[] array) {
		return !isEmpty(array) && in(target, Arrays.stream(array));
	}
	
	/**
	 * 
	 * 
	 * @param target     
	 * @param collection 
	 * @return {@code true} if {@code collection != null && collection.size > 0 && target in collection}, otherwise {@code false}
	 */
	public  static     boolean in(Object target, Collection<?> collection) {
		return !isEmpty(collection) && in(target, collection.stream());
	}
	
	/**
	 * 
	 * 
	 * @param <K> 
	 * @param key 
	 * @param map 
	 * @return {@code true} if {@code map != null && map.size > 0 && key in map.keys}, otherwise {@code false}
	 */
	public  static <K> boolean keyIn(K key, Map<K, ?> map) {
		return !isEmpty(map) && in(key, map.keySet().stream());
	}
	
	/**
	 * 
	 * 
	 * @param <V> 
	 * @param val 
	 * @param map 
	 * @return {@code true} if {@code map != null && map.size > 0 && val in map.values}, otherwise {@code false}
	 */
	public  static <V> boolean valIn(V val, Map<?, V> map) {
		return !isEmpty(map) && in(val, map.values().stream());
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static     boolean containsNon(int[] source, int[] target) {
		return isEmpty(source) || isEmpty(target) || Arrays.stream(target).allMatch(item -> !in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param <T>    
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static <T> boolean containsNon(T[] source, T[] target) {
		return isEmpty(source) || isEmpty(target) || Arrays.stream(target).allMatch(item -> !in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static     boolean containsNon(Collection<?> source, Collection<?> target) {
		return isEmpty(source) || isEmpty(target) || target.stream().allMatch(item -> !in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static     boolean containsAny(int[] source, int[] target) {
		return !isEmpty(source) && !isEmpty(target) && Arrays.stream(target).anyMatch(item -> in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param <T>    
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static <T> boolean containsAny(T[] source, T[] target) {
		return !isEmpty(source) && !isEmpty(target) && Arrays.stream(target).anyMatch(item -> in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static     boolean containsAny(Collection<?> source, Collection<?> target) {
		return !isEmpty(source) && !isEmpty(target) && target.stream().anyMatch(item -> in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static     boolean containsAll(int[] source, int[] target) {
		return !isEmpty(source) && !isEmpty(target) && source.length >= target.length 
				&& Arrays.stream(target).allMatch(item -> in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param <T>    
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static <T> boolean containsAll(T[] source, T[] target) {
		return !isEmpty(source) && !isEmpty(target) && source.length >= target.length 
				&& Arrays.stream(target).allMatch(item -> in(item, source));
	}
	
	/**
	 * 
	 * 
	 * @param source 
	 * @param target 
	 * @return 
	 */
	public static     boolean containsAll(Collection<?> source, Collection<?> target) {
		return !isEmpty(source) && !isEmpty(target) && source.size() >= target.size() 
				&& target.stream().allMatch(item -> in(item, source));
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param <T>   
	 * @param array 
	 * @return 
	 */
	public static <T> List<T>  removeNull(T[] array) {
		if (!isEmpty(array)) {
			List<T> result = new ArrayList<>(array.length);
			Arrays.stream(array)
				.filter(item -> item != null)
				.forEachOrdered(item -> result.add(item));
			return result;
		}
		return new ArrayList<>(0);
	}
	
	/**
	 * 
	 * 
	 * @param <T>        
	 * @param collection 
	 * @return 
	 */
	public static <T> List<T>  removeNull(Collection<T> collection) {
		if (!isEmpty(collection)) {
			List<T> result = new ArrayList<>(collection.size());
			collection.stream()
				.filter(item -> item != null)
				.forEachOrdered(item -> result.add(item));
			return result;
		}
		return new ArrayList<>(0);
	}
	
	/**
	 * 
	 * 
	 * @param array 
	 * @return 
	 */
	public static List<String> removeEmptyString(String[] array) {
		if (!isEmpty(array)) {
			List<String> result = new ArrayList<>(array.length);
			Arrays.stream(array)
				.filter(item -> !isEmpty(item))
				.forEachOrdered(item -> result.add(item));
			return result;
		}
		return new ArrayList<>(0);
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @return 
	 */
	public static List<String> removeEmptyString(Collection<String> collection) {
		if (!isEmpty(collection)) {
			List<String> result = new ArrayList<>(collection.size());
			collection.stream()
				.filter(item -> !isEmpty(item))
				.forEachOrdered(item -> result.add(item));
			return result;
		}
		return new ArrayList<>(0);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * A∩B
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> Set<T> intersection(T[] a, T[] b) {
		Set<T> result = new HashSet<>();
		if (!isEmpty(a) && !isEmpty(b)) {
			Arrays.stream(a).filter(item -> in(item, b)).forEach(item -> result.add(item));
		}
		return result;
	}
	
	/**
	 * A∩B
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> Set<T> intersection(Collection<T> a, Collection<T> b) {
		Set<T> result = new HashSet<>();
		if (!isEmpty(a) && !isEmpty(b)) {
			a.stream().filter(item -> in(item, b)).forEach(item -> result.add(item));
		}
		return result;
	}
	
	/**
	 * A∪B
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> Set<T> union(T[] a, T[] b) {
		Set<T> result = new HashSet<>();
		if (!isEmpty(a)) {
			Arrays.stream(a).forEach(item -> result.add(item));
		}
		if (!isEmpty(b)) {
			Arrays.stream(b).forEach(item -> result.add(item));
		}
		return result;
	}
	
	/**
	 * A∪B
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> Set<T> union(Collection<T> a, Collection<T> b) {
		Set<T> result = new HashSet<>();
		if (!isEmpty(a)) {
			a.forEach(item -> result.add(item));
		}
		if (!isEmpty(b)) {
			b.forEach(item -> result.add(item));
		}
		return result;
	}
	
	/**
	 * A\B or A-B
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> Set<T> difference(T[] a, T[] b) {
		Set<T> result = new HashSet<>();
		if (!isEmpty(a)) {
			Arrays.stream(a).filter(item -> !in(item, b)).forEach(item -> result.add(item));
		}
		return result;
	}
	
	/**
	 * A\B or A-B
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> Set<T> difference(Collection<T> a, Collection<T> b) {
		Set<T> result = new HashSet<>();
		if (!isEmpty(a)) {
			a.stream().filter(item -> !in(item, b)).forEach(item -> result.add(item));
		}
		return result;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param array  
	 * @param target 
	 * @return 
	 */
	public static     int indexOf(int[] array, int target) {
		if (!isEmpty(array)) {
			for (int index = 0; index < array.length; index++) {
				if (array[index] == target) {
					return index;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * 
	 * @param <T>    
	 * @param array  
	 * @param target 
	 * @return 
	 */
	public static <T> int indexOf(T[] array, T target) {
		if (!isEmpty(array)) {
			for (int index = 0; index < array.length; index++) {
				if (isEqual(array[index], target)) {
					return index;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @param target     
	 * @return 
	 */
	public static     int indexOf(Collection<?> collection, Object target) {
		if (!isEmpty(collection)) {
			int index = 0;
			Iterator<?> iterator = collection.iterator();
			while (iterator.hasNext()) {
				if (isEqual(iterator.next(), target)) {
					return index;
				}
				index++;
			}
		}
		return -1;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param locale 
	 * @return 
	 */
	public static Comparator<String> getStringComparator(Locale locale) {
		return (a, b) -> Collator.getInstance(locale != null ? locale : Locale.getDefault()).compare(a, b);
	}
	
	/**
	 * 
	 * 
	 * @return 
	 */
	public static Comparator<String> getStringComparator() {
		return getStringComparator(null);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	// ---------------------------------------------------------------------
	// 
	/**
	 * 
	 * 
	 * @param <T>        
	 * @param stream     
	 * @param comparator 
	 * @param size       
	 * @return 
	 */
	private static <T> List<T> getSortedList(Stream<T> stream, Comparator<T> comparator, int size) {
		List<T> list = new ArrayList<>(size);
		if (comparator != null) {
			stream.sorted(comparator).forEachOrdered(item -> list.add(item));
		} else {
			stream.sorted(          ).forEachOrdered(item -> list.add(item));
		}
		return list;
	}
	
	/**
	 * 
	 * 
	 * @param <T>        
	 * @param array      
	 * @param comparator 
	 * @return 
	 */
	public  static <T> List<T> getSortedList(T[] array, Comparator<T> comparator) {
		return !containsNonNull(array) ? new ArrayList<>(0) : getSortedList(Arrays.stream(array), comparator, array.length);
	}
	
	/**
	 * 
	 * 
	 * @param <T>        
	 * @param collection 
	 * @param comparator 
	 * @return 
	 */
	public  static <T> List<T> getSortedList(Collection<T> collection, Comparator<T> comparator) {
		return !containsNonNull(collection) ? new ArrayList<>(0) : getSortedList(collection.stream(), comparator, collection.size());
	}
	
	/**
	 * 
	 * 
	 * @param <K>        
	 * @param map        
	 * @param comparator 
	 * @return 
	 */
	public  static <K> List<K> getSortedListKeys(Map<K, ?> map, Comparator<K> comparator) {
		return !containsNonNullKey(map) ? new ArrayList<>(0) : getSortedList(map.keySet().stream(), comparator, map.size());
	}
	
	// ---------------------------------------------------------------------
	// 
	/**
	 * 
	 * 
	 * @param array 
	 * @return 
	 */
	public static List<String> getSortedStringList(String[] array) {
		return getSortedList(array, getStringComparator());
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @return 
	 */
	public static List<String> getSortedStringList(Collection<String> collection) {
		return getSortedList(collection, getStringComparator());
	}
	
	/**
	 * 
	 * 
	 * @param map 
	 * @return 
	 */
	public static List<String> getSortedStringListKeys(Map<String, ?> map) {
		return getSortedListKeys(map, getStringComparator());
	}
	
	// ---------------------------------------------------------------------
	// 
	/**
	 * 
	 * 
	 * @param array 
	 * @return 
	 */
	public static List<Integer> getSortedIntegerList(Integer[] array) {
		return getSortedList(array, (a, b) -> a.compareTo(b));
	}
	
	/**
	 * 
	 * 
	 * @param collection 
	 * @return 
	 */
	public static List<Integer> getSortedIntegerList(Collection<Integer> collection) {
		return getSortedList(collection, (a, b) -> a.compareTo(b));
	}
	
	/**
	 * 
	 * 
	 * @param map 
	 * @return 
	 */
	public static List<Integer> getSortedIntegerListKeys(Map<Integer, ?> map) {
		return getSortedListKeys(map, (a, b) -> a.compareTo(b));
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param sequence 
	 * @return 
	 */
	public static char[] reverse(char[] sequence) {
		if (isEmpty(sequence)) {
			return new char[0];
		}
		
		char[] result = new char[sequence.length];
		for (int index = 0; index < sequence.length; index++) {
			result[index] = sequence[sequence.length - index - 1];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @return 
	 */
	public static byte[] reverse(byte[] sequence) {
		if (isEmpty(sequence)) {
			return new byte[0];
		}
		
		byte[] result = new byte[sequence.length];
		for (int index = 0; index < sequence.length; index++) {
			result[index] = sequence[sequence.length - index - 1];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @return 
	 */
	public static int[]  reverse(int[]  sequence) {
		if (isEmpty(sequence)) {
			return new int[0];
		}
		
		int[] result = new int[sequence.length];
		for (int index = 0; index < sequence.length; index++) {
			result[index] = sequence[sequence.length - index - 1];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @param from     
	 * @return 
	 */
	public static char[] reverse(char[] sequence, int from) {
		if (isEmpty(sequence) || from < 0 || from >= sequence.length) {
			return new char[0];
		}
		
		char[] result = new char[sequence.length];
		for (int index = 0; index < from; index++) {
			result[index] = sequence[index];
		}
		for (int index = from; index < sequence.length; index++) {
			result[index] = sequence[from + (sequence.length - index) - 1];
		}
		return result;
	}
	
	/**
	 * 
	 * @param sequence 
	 * @param from     
	 * @return 
	 */
	public static byte[] reverse(byte[] sequence, int from) {
		if (isEmpty(sequence) || from < 0 || from >= sequence.length) {
			return new byte[0];
		}
		
		byte[] result = new byte[sequence.length];
		for (int index = 0; index < from; index++) {
			result[index] = sequence[index];
		}
		for (int index = from; index < sequence.length; index++) {
			result[index] = sequence[from + (sequence.length - index) - 1];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @param from     
	 * @return 
	 */
	public static int[]  reverse(int[]  sequence, int from) {
		if (isEmpty(sequence) || from < 0 || from >= sequence.length) {
			return new int[0];
		}
		
		int[] result = new int[sequence.length];
		for (int index = 0; index < from; index++) {
			result[index] = sequence[index];
		}
		for (int index = from; index < sequence.length; index++) {
			result[index] = sequence[from + (sequence.length - index) - 1];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @param from     
	 * @param to       
	 * @return 
	 */
	public static char[] reverse(char[] sequence, int from, int to) {
		if (isEmpty(sequence) || from < 0 || from >= sequence.length || to < from || to > sequence.length) {
			return new char[0];
		}
		
		char[] result = new char[sequence.length];
		for (int index = 0; index < from; index++) {
			result[index] = sequence[index];
		}
		for (int index = from; index < to; index++) {
			result[index] = sequence[from + (to - index) - 1];
		}
		for (int index = to; index < sequence.length; index++) {
			result[index] = sequence[index];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @param from     
	 * @param to       
	 * @return 
	 */
	public static byte[] reverse(byte[] sequence, int from, int to) {
		if (isEmpty(sequence) || from < 0 || from >= sequence.length || to < from || to > sequence.length) {
			return new byte[0];
		}
		
		byte[] result = new byte[sequence.length];
		for (int index = 0; index < from; index++) {
			result[index] = sequence[index];
		}
		for (int index = from; index < to; index++) {
			result[index] = sequence[from + (to - index) - 1];
		}
		for (int index = to; index < sequence.length; index++) {
			result[index] = sequence[index];
		}
		return result;
	}
	
	/**
	 * 
	 * 
	 * @param sequence 
	 * @param from     
	 * @param to       
	 * @return 
	 */
	public static int[]  reverse(int[]  sequence, int from, int to) {
		if (isEmpty(sequence) || from < 0 || from >= sequence.length || to < from || to > sequence.length) {
			return new int[0];
		}
		
		int[] result = new int[sequence.length];
		for (int index = 0; index < from; index++) {
			result[index] = sequence[index];
		}
		for (int index = from; index < to; index++) {
			result[index] = sequence[from + (to - index) - 1];
		}
		for (int index = to; index < sequence.length; index++) {
			result[index] = sequence[index];
		}
		return result;
	}
	
	// ---------------------------------------------------------------------
	// 
	/**
	 * 
	 * 
	 * @param <T>      
	 * @param sequence 
	 * @return 
	 */
	public static <T> List<T> reverse(List<T> sequence) {
		if (!isEmpty(sequence)) {
			List<T> result = new ArrayList<>(sequence.size());
			for (int index = sequence.size() - 1; index >= 0; index--) {
				result.add(sequence.get(index));
			}
			return result;
		}
		return new ArrayList<>(0);
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param string   
	 * @param prefixes 
	 * @return 
	 */
	public static boolean prefixIn(String string, String ... prefixes) {
		return !isEmpty(string) && !isEmpty(prefixes) 
				&& Arrays.stream(prefixes).anyMatch(prefix -> !isEmpty(prefix) && string.startsWith(prefix));
	}
	
	/**
	 * 
	 * 
	 * @param string   
	 * @param suffixes 
	 * @return 
	 */
	public static boolean suffixIn(String string, String ... suffixes) {
		return !isEmpty(string) && !isEmpty(suffixes) 
				&& Arrays.stream(suffixes).anyMatch(suffix -> !isEmpty(suffix) && string.endsWith(suffix));
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> boolean isEqual(T a, T b) {
		return a == null ? b == null : a.equals(b);
	}
	
	/**
	 * 
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> boolean isEqualNonNull(T a, T b) {
		return a != null && a.equals(b);
	}
	
	/**
	 * 
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> boolean isEquals(T[] a, T[] b) {
		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		} else if (a.length != b.length) {
			return false;
		} else {
			for (int index = 0; index < a.length; index++) {
				if (!isEqual(a[index], b[index])) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * 
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> boolean isEqualsNonNull(T[] a, T[] b) {
		if (a == null || b == null || a.length == 0 || a.length != b.length) {
			return false;
		}
		
		for (int index = 0; index < a.length; index++) {
			if (!isEqualNonNull(a[index], b[index])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> boolean isEquals(List<T> a, List<T> b) {
		if (a == null && b == null) {
			return true;
		} else if (a == null || b == null) {
			return false;
		} else if (a.size() != b.size()) {
			return false;
		} else {
			for (int index = 0; index < a.size(); index++) {
				if (!isEqual(a.get(index), b.get(index))) {
					return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * 
	 * 
	 * @param <T> 
	 * @param a   
	 * @param b   
	 * @return 
	 */
	public static <T> boolean isEqualsNonNull(List<T> a, List<T> b) {
		if (a == null || b == null || a.size() == 0 || a.size() != b.size()) {
			return false;
		}

		for (int index = 0; index < a.size(); index++) {
			if (!isEqualNonNull(a.get(index), b.get(index))) {
				return false;
			}
		}
		return true;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param length 
	 * @param value  
	 * @return 
	 * @throws IllegalArgumentException 
	 */
	public static int[] asArray(int value, int length) {
		if (length < 0) {
			throw new IllegalArgumentException("Negative length of the array: " + length);
		}
		
		int[] array = new int[length];
		if (value != 0) {
			for (int index = 0; index < length; index++) {
				array[index] = value;
			}
		}
		return array;
	}
	
	/**
	 * 
	 * 
	 * @param first     
	 * @param tolerance 
	 * @param length    
	 * @return 
	 * @throws IllegalArgumentException 
	 */
	public static int[] asArray(int first, int tolerance, int length) {
		if (length < 0) {
			throw new IllegalArgumentException("Negative length of the array: " + length);
		}
		
		int[] array = new int[length];
		if (length > 0 && (first != 0 || tolerance != 0)) {
			for (int index = 0; index < length; index++) {
				array[index] = first + index * tolerance;
			}
		}
		return array;
	}
	
	////////////////////////////////////////////////////////////////////////
	// 
	/**
	 * 
	 * 
	 * @param <T>   
	 * @param array 
	 * @return 
	 */
	@SafeVarargs
	public static <T> List<T> asList(T ... array) {
		if (!isEmpty(array)) {
			List<T> result = new ArrayList<>(array.length);
			for (T t : array) {
				result.add(t);
			}
			return result;
		}
		return new ArrayList<>(0);
	}
	
	/**
	 * 
	 * 
	 * @param <T>   
	 * @param array 
	 * @return 
	 */
	@SafeVarargs
	public static <T> Set<T>  asSet(T ... array) {
		if (!isEmpty(array)) {
			Set<T> result = new HashSet<>(array.length);
			for (T t : array) {
				result.add(t);
			}
			return result;
		}
		return new HashSet<>(0);
	}
	
}
