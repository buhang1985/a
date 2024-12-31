package iih.mc.common.util;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BaseDO;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

public class McStringUtil {
	
	//换行符
	public static String WrapChar = System.getProperty("line.separator", "\n");
	
	public static <T extends BaseDO> String[] toArray(T[] baseDOS, String property) {
		
		List<String> result = new ArrayList<String>();
		
		for(T baseDO : baseDOS) {
			
			if(baseDO.getAttrVal(property) == null) {
				
				continue;
			}
			
			String val = baseDO.getAttrVal(property).toString();
			if(result.contains(val)) {
				
				continue;
			}
			result.add(baseDO.getAttrVal(property).toString());
		}
		
		return result.toArray(new String[0]);
	}
	
	public static <T extends BaseAggDO> String[] toItemArray(T[] baseAggDOS, String property) {
		
		List<String> result = new ArrayList<String>();
		
		for(T aggDO : baseAggDOS) {
			BaseDO[] baseDos = aggDO.getAllChildrenDO();
			if(baseDos == null || baseDos.length <= 0) {
				
				continue;
			}
			
			String[] vals = toArray(baseDos, property);
			for(String val : vals) {
				
				if(!result.contains(val)) {
					
					result.add(val);
				}
			}
		}
		
		return result.toArray(new String[0]);
	}
	
	public static <T extends BaseAggDO> String[] toMainArray(T[] baseAggDOS, String property) {
		
		List<String> result = new ArrayList<String>();
		
		for(T aggDO : baseAggDOS) {
			
			BaseDO baseDO = aggDO.getParentDO();
			
			String[] vals = toArray(new BaseDO[]{ baseDO }, property);
			for(String val : vals) {
				
				if(!result.contains(val)) {
					
					result.add(val);
				}
			}
		}
		
		return result.toArray(new String[0]);
	}
}
