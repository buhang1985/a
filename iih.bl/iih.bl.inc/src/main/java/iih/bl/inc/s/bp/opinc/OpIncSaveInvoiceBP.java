package iih.bl.inc.s.bp.opinc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.util.OpInccaJudgeUtil;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.s.bp.opinc.incsplit.IncSplitOepBP;
import iih.bl.inc.s.bp.opinc.util.OpIncAssembleUtil;
import iih.bl.params.BlParamsAnalysisUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门急诊生成发票数据处理类
 * @author ly 2017/03/26
 *
 */
public class OpIncSaveInvoiceBP {

	/**
	 * 生成保存发票数据
	 * @param cgAggDos
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] exec(BlcgoepAggDO[] cgAggDos) throws BizException{
		
		// 1.入参验证
		this.validate(cgAggDos);
		
		List<BlCgItmOepDO> itmList = new ArrayList<BlCgItmOepDO>();
		for (BlcgoepAggDO aggDo : cgAggDos) {
			for (BlCgItmOepDO itm : aggDo.getBlCgItmOepDO()) {
				if(!FBoolean.TRUE.equals(itm.getFg_refund())){
					itmList.add(itm);
				}
			}
		}
		
		if(itmList.size() == 0)
			return null;
		
		// 判断票据类型
		String inccaId = OpInccaJudgeUtil.getInvoiceTp(cgAggDos[0].getBlCgItmOepDO()[0].getId_stoep());
		
		// 判断是否开启电子发票
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(inccaId);
		
		// 2.发票分票逻辑
		Map<String, List<BlCgItmOepDO>> splitMap = null;
		if(FBoolean.FALSE.equals(fgEcInc)){
			splitMap = new IncSplitOepBP().split(itmList);
		}else{
			// 开启电子发票后不进行分票业务
			splitMap = new IncSplitOepBP().noSplit(itmList);
		}
		
		// 3.发票数据
		List<BlincoepAggDO> aggList = new ArrayList<BlincoepAggDO>();
		for (Entry<String, List<BlCgItmOepDO>> entry : splitMap.entrySet()) {
			BlincoepAggDO incAggDO = OpIncAssembleUtil.assemble(entry.getValue(), inccaId);
			incAggDO.getParentDO().setFg_ec_inc(fgEcInc);
			aggList.add(incAggDO);
		}
		
		IBlincoepCudService cudService = ServiceFinder.find(IBlincoepCudService.class);
		return cudService.insert(aggList.toArray(new BlincoepAggDO[0]));
	}
	
	/**
	 * 校验入参
	 * @param cgAggDos
	 * @throws BizException
	 */
	private void validate(BlcgoepAggDO[] cgAggDos) throws BizException{
		
		if(ArrayUtil.isEmpty(cgAggDos)){
			throw new ArgumentNullException("门诊发票保存","记账实体数组");
		}
	}
}
