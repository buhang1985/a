package iih.bl.inc.s.bp.ipinc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.cg.blcgquery.d.BlCgIpDO;

/**
 * 住院发票分组
 * 
 * @author wq.li
 * @date 2018年8月11日
 */
public class IpIncSplitCoreBP {
	
	/*
	 * 返回值默认Key
	 */
	private final static String DEFAULT_KEY = "default";
	
	
	/**
	 * 住院发票分票逻辑
	 * 
	 * @return
	 * @date 2018年8月11日
	 * @author wq.li
	 */
	public Map<String, List<BlCgIpDO>> split(List<BlCgIpDO> cgList) {
		// 目前分票逻辑为空，返回全部明细
		Map<String, List<BlCgIpDO>> splitMap = new HashMap<String, List<BlCgIpDO>>();
		splitMap.put(DEFAULT_KEY, cgList);
		return splitMap;
	}
	
	/**
	 * 住院发票不分票逻辑
	 * @param cgList
	 * @return
	 * @author ly 2019/12/16
	 */
	public Map<String, List<BlCgIpDO>> noSplit(List<BlCgIpDO> cgList) {
		Map<String, List<BlCgIpDO>> splitMap = new HashMap<String, List<BlCgIpDO>>();
		splitMap.put(DEFAULT_KEY, cgList);
		return splitMap;
	}
}
