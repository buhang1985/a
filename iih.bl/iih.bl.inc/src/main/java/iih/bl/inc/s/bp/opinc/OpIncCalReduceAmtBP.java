package iih.bl.inc.s.bp.opinc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.comm.IBlConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.s.ep.IncOepEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发票账单项金额减免计算
 * @author ly 2018/04/09
 * @author ly 2019/10/23 重构算法
 *
 */
public class OpIncCalReduceAmtBP {

	/**
	 * 发票账单项金额减免计算
	 * @param stId 结算id
	 * @param freeAmt 减免金额
	 * @throws BizException
	 */
	public void exec(String stId,FDouble freeAmt) throws BizException{
		
		this.validate(stId, freeAmt);
		
		// 1.检索发票信息
		BlincoepAggDO[] aggDos = new IncOepEP().findIncByStId(stId);
		if(ArrayUtil.isEmpty(aggDos)){
			throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
		}
		
		// 2.计算发票表金额减免
		this.calIncAmt(aggDos, freeAmt);
		
		// 3.计算发票项金额减免
		for (BlincoepAggDO aggDO : aggDos) {
			this.calIncItmAmt(aggDO);
		}
		
		// 4.保存发票数据
		IBlincoepCudService cudService = ServiceFinder.find(IBlincoepCudService.class);
		cudService.update(aggDos);
	}
	
	
	/**
	 * 参数校验
	 * @param stId
	 * @param freeAmt
	 * @throws BizException
	 */
	private void validate(String stId,FDouble freeAmt) throws BizException{
		if(StringUtil.isEmpty(stId)){
			throw new ArgumentNullException("发票账单项金额减免计算", "结算id");
		}
		
		if(freeAmt == null){
			throw new ArgumentNullException("发票账单项金额减免计算", "减免金额");
		}
	}

	/**
	 * 计算主表减免金额
	 * @param aggDos
	 * @param freeAmt
	 */
	private void calIncAmt(BlincoepAggDO[] aggDos, FDouble freeAmt){
		
		FDouble amtAll = FDouble.ZERO_DBL;
		for (BlincoepAggDO incAggDO : aggDos) {
			amtAll = amtAll.add(incAggDO.getParentDO().getAmt_ratio());
		}
		
		if(FDouble.ZERO_DBL.equals(amtAll))
			return;
		
		if(amtAll.equals(freeAmt)){
			//全额减免
			for (int i = 0; i < aggDos.length; i++) {
				
				BlIncOepDO inc = aggDos[i].getParentDO();
				inc.setStatus(DOStatus.UPDATED);
				inc.setEu_freemd(BlFreeMdEnum.AMT_FREE_MD);
				inc.setAmt(FDouble.ZERO_DBL);
				inc.setAmt_free(inc.getAmt_ratio());
			}
		}else{
			//非全额减免，按比例计算
			FDouble notLast = FDouble.ZERO_DBL;
			for (int i = 0; i < aggDos.length; i++) {
				
				BlIncOepDO inc = aggDos[i].getParentDO();
				FDouble feeAmtAvg = (inc.getAmt_ratio().div(amtAll)).multiply(freeAmt, IBlConst.PRECISION_AMOUNT);
				
				FDouble free = null;
				if (i == aggDos.length - 1) {
					free = freeAmt.sub(notLast);
				} else {
					free = feeAmtAvg;
				}
				
				inc.setStatus(DOStatus.UPDATED);
				inc.setEu_freemd(BlFreeMdEnum.AMT_FREE_MD);
				inc.setAmt(inc.getAmt().sub(free));
				inc.setAmt_free(inc.getAmt_free().add(free));
				
				notLast = notLast.add(free);
			}
		}
	}
	
	/**
	 * 计算发票账单表减免金额
	 * @param aggDO
	 */
	private void calIncItmAmt(BlincoepAggDO aggDO){
		
		if(FDouble.ZERO_DBL.equals(aggDO.getParentDO().getAmt())){
			//全额减免
			for (int i = 0; i < aggDO.getBlIncItmOepDO().length; i++) {
				BlIncItmOepDO incItm = aggDO.getBlIncItmOepDO()[i];
				
				incItm.setStatus(DOStatus.UPDATED);
				incItm.setAmt(FDouble.ZERO_DBL);
				incItm.setAmt_free(incItm.getAmt_ratio());
			}
		}else{
			//非全额减免，按比例计算
			FDouble freeAmt = aggDO.getParentDO().getAmt_free();
			FDouble notLast = FDouble.ZERO_DBL;
			for (int i = 0; i < aggDO.getBlIncItmOepDO().length; i++) {

				BlIncItmOepDO incItm = aggDO.getBlIncItmOepDO()[i];
				
				FDouble feeAmtAvg = (incItm.getAmt_ratio().div(aggDO.getParentDO().getAmt_ratio())).multiply(freeAmt, IBlConst.PRECISION_AMOUNT);

				FDouble free = null;
				if (i == aggDO.getBlIncItmOepDO().length - 1) {
					free = freeAmt.sub(notLast);
				} else {
					free = feeAmtAvg;
				}

				incItm.setStatus(DOStatus.UPDATED);
				incItm.setAmt(incItm.getAmt().sub(free));
				incItm.setAmt_free(incItm.getAmt_free().add(free));
				
				notLast = notLast.add(free);
			}
		}
	}
}
