package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.comm.util.OpInccaJudgeUtil;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.s.bp.opinc.incsplit.IncSplitOepBP;
import iih.bl.inc.s.bp.opinc.util.OpIncAssembleUtil;
import iih.bl.params.BlParamsAnalysisUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊记账数据预分票
 * @author ly 2019/05/08
 *
 */
public class OpIncPreSplitBP {

	/**
	 * 门诊记账数据预分票
	 * @param cgItmDos 记账明细
	 * @return 发票数据
	 * @throws BizException
	 */
	public BlincoepAggDO[] exec(BlCgItmOepDO[] cgItmDos) throws BizException{
		
		if(ArrayUtil.isEmpty(cgItmDos)){
			throw new BizException("门诊记账数据预分票:入参记账明细为空");
		}
		
		// 判断票据类型
		String inccaId = OpInccaJudgeUtil.getInvoiceTp(cgItmDos[0].getId_stoep());

		// 判断是否开启电子发票
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(inccaId);
		
		Map<String, List<BlCgItmOepDO>> splitMap = null;
		if(FBoolean.FALSE.equals(fgEcInc)){
			splitMap = new IncSplitOepBP().split(Arrays.asList(cgItmDos));
		}else{
			// 开启电子发票后不进行分票业务
			splitMap = new IncSplitOepBP().noSplit(Arrays.asList(cgItmDos));
		}
	
		List<BlincoepAggDO> aggList = new ArrayList<BlincoepAggDO>();
		for (Entry<String, List<BlCgItmOepDO>> entry : splitMap.entrySet()) {
			//组装数据
			BlincoepAggDO incAggDO = OpIncAssembleUtil.assemble(entry.getValue(), inccaId);
			aggList.add(incAggDO);
		}
		
		return aggList.toArray(new BlincoepAggDO[0]);
	}
}
