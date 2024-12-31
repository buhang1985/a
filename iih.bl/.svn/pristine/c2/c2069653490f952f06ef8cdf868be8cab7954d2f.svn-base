package iih.bl.inc.s.bp.opinc.incsplit;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import iih.bd.pp.inccasplit.i.IInccasplitRService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.inc.s.bp.inc.incsplit.IncSplitCoreBP;
import iih.bl.inc.s.bp.inc.incsplit.IncSplitMaskConvertUtil;
import iih.bl.inc.s.bp.inc.incsplit.data.IncSplitMaskDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊发票分票逻辑
 * @author ly 2018/08/22
 *
 */
public class IncSplitOepBP {

	/*
	 * 返回值默认Key
	 */
	private final static String DEFAULT_KEY = "default";
	
	/**
	 * 门诊分票
	 * @param itmList
	 * @return
	 * @throws BizException
	 */
	public Map<String, List<BlCgItmOepDO>> split(List<BlCgItmOepDO> itmList) throws BizException {
		
		Map<String, List<BlCgItmOepDO>> splitMap = null;
		
		//查询分票配置
		BdInccaSplitDO splitSet = this.getSplitSet();
		if (splitSet == null) {
			splitMap = new HashMap<String, List<BlCgItmOepDO>>();
			splitMap.put(DEFAULT_KEY, itmList);
			return splitMap;
		}
		
		//转换mask数据
		List<IncSplitMaskDTO> maskList = IncSplitMaskConvertUtil.covertOepCgToMask(splitSet, itmList);
		
		//分票
		IncSplitCoreBP splitCore = new IncSplitCoreBP();
		Map<String, List<IncSplitMaskDTO>> maskMap = splitCore.split(splitSet, maskList);
		
		//转换门诊数据
		splitMap = IncSplitMaskConvertUtil.convertToOepCgSplitRlt(maskMap);
		
		return splitMap;
	}
	
	/**
	 * 门诊不分票
	 * @param itmList
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/05
	 */
	public Map<String, List<BlCgItmOepDO>> noSplit(List<BlCgItmOepDO> itmList) throws BizException {
		
		Map<String, List<BlCgItmOepDO>> splitMap = new HashMap<String, List<BlCgItmOepDO>>();
		splitMap.put(DEFAULT_KEY, itmList);
		return splitMap;
	}
	
	/**
	 * 获取门诊分票配置
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdInccaSplitDO getSplitSet() throws BizException {

		IInccasplitRService rService = ServiceFinder.find(IInccasplitRService.class);
		String whereSql = String.format("id_incca = '%s' and fg_active = 'Y'",IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);

		BdInccaSplitDO[] splitDos = rService.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(splitDos))
			return null;

		return splitDos[0];
	}
}
