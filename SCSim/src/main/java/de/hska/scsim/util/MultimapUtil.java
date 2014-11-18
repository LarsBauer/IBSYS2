package de.hska.scsim.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.collections4.MultiMap;

public class MultimapUtil {

	public static Map<String, Integer> convertToMap(MultiMap<String, Integer> multimap) {
		Map<String, Integer> map = new HashMap<>();
		for(Entry<String, Object> entry : multimap.entrySet()) {
			int sum = 0;
			for(Integer value : (Collection<Integer>)entry.getValue()) {
				sum += value;
			}
			map.put(entry.getKey(), sum);
		}
		return map;
	}
}