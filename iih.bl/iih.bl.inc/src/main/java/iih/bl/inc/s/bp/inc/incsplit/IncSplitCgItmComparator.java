package iih.bl.inc.s.bp.inc.incsplit;

import java.util.Comparator;

import xap.mw.core.data.BaseDO;

/**
 * 分票记账明细数据排序比较器(新版)
 * 
 * @author ly 2018/08/21
 *
 */
public class IncSplitCgItmComparator implements Comparator<BaseDO> {

	private String[] keys = null;

	public IncSplitCgItmComparator(String[] keys) {
		this.keys = keys;
	}

	@Override
	public int compare(BaseDO o1, BaseDO o2) {
		
		for (String key : keys) {
			
			String str1 = o1.getAttrVal(key) == null ? "" : o1.getAttrVal(key).toString();
			String str2 = o2.getAttrVal(key) == null ? "" : o2.getAttrVal(key).toString();
			
			int rlt = str1.compareTo(str2);
			
			if(rlt == 0)
				continue;
			
			return rlt;
		}
		
		return 0;
	}
}
