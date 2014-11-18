package de.hska.scsim.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class ItemConfig {
	private String id;
	private String name;
	private Map<String, Integer> components;

	public ItemConfig() {}
	
	public ItemConfig(String id, String name, Map<String, Integer> components) {
		this.id = id;
		this.name = name;
		this.components = Collections.unmodifiableMap(components);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<String, Integer> getComponents() {
		return components;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(obj == this) {
			return true;
		}
		
		if(!(obj instanceof ItemConfig)) {
			return false;
		}
		
		ItemConfig itemConfig = (ItemConfig) obj;
		return Objects.equals(id, itemConfig.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "ItemConfig [id=" + id + ", name=" + name + ", components=" + components + "]";
	}
}