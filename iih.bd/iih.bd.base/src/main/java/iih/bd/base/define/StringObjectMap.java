package iih.bd.base.define;

import java.util.HashMap;

public class StringObjectMap extends HashMap<String,Object>{

	private static final long serialVersionUID = 1L;

	public String[] asKeyArray(){
		return this.keySet().toArray(new String[size()]);
	}
}
