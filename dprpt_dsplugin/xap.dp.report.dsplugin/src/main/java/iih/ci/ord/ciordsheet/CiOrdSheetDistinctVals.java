package iih.ci.ord.ciordsheet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.software.comm.util.ListUtil;
import com.software.comm.util.StringUtil;

/**
 * 报表医生签字逻辑操作
 */
public class CiOrdSheetDistinctVals {
	private static final String STR_POSSIGNMODE_LINE = "______";
	
	private HashMap<String, List<String>> distinctValsHMap = null;
	
	public CiOrdSheetDistinctVals() {
		this.distinctValsHMap = new HashMap<String, List<String>>(5);
	}
	
	public void clear() {
		Collection<List<String>> valLists = distinctValsHMap.values();
		for(List<String> list : valLists) {
			list.clear();
		}
		this.distinctValsHMap.clear();
	}
	
	public void putValue(String grpKey, String value) {
		if(StringUtil.isNullOrEmpty(grpKey)) return;
		if(StringUtil.isNullOrEmpty(value)) return;
		
		List<String> grp_vallist = distinctValsHMap.get(grpKey);
		if(null == grp_vallist) {
			grp_vallist = new ArrayList<String>(20);
			this.distinctValsHMap.put(grpKey, grp_vallist);
		}
		
		// 去重并添加
		if(!grp_vallist.contains(value)) {
			grp_vallist.add(value);
		}
	}
	
	public String mergeAsString(String grpKey, int valsPerLine) {
		List<String> grp_vallist = distinctValsHMap.get(grpKey);
		if(ListUtil.IsEmpty(grp_vallist)) return "";
		
		int vals_cnt = 0;
		StringBuilder str_buf = new StringBuilder(128);
		for(String val : grp_vallist) {
			str_buf.append(val).append(STR_POSSIGNMODE_LINE);
			
			vals_cnt++;
			if(vals_cnt >= valsPerLine) {
				str_buf.append("\r\n");
				vals_cnt = 0;
			}
		}
		
		String res_str = str_buf.toString();
		str_buf.setLength(0);
		
		return res_str;
	}
}
