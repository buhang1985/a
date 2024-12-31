package iih.bl.inc.s.bp.opinc;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.FDoubleUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
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
 * 发票账单项项目减免计算
 * @author ly 2018/04/09
 *
 */
public class OpIncCalReduceItmBP {

	/**
	 * 发票账单项项目减免计算
	 * @param stId 计算id
	 * @param cgItms 记账减免项目
	 * @throws BizException
	 */
	public void exec(String stId,BlCgItmOepDO[] cgItms) throws BizException{
		
		this.validate(stId, cgItms);
		
		// 1.检索发票信息
		BlincoepAggDO[] aggDos = new IncOepEP().findIncByStId(stId);
		if(ArrayUtil.isEmpty(aggDos)){
			throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
		}
		
		// 2.计算个发票金额减免
		this.calFreeAmt(aggDos, cgItms);
		
		// 3.保存发票数据
		IBlincoepCudService cudService = ServiceFinder.find(IBlincoepCudService.class);
		cudService.save(aggDos);
	}
	
	/**
	 * 参数校验
	 * @param stId
	 * @param itmMap
	 * @throws BizException
	 */
	private void validate(String stId,BlCgItmOepDO[] cgItms) throws BizException{
		if(StringUtil.isEmpty(stId)){
			throw new ArgumentNullException("发票账单项项目减免计算", "结算id");
		}
		
		if(ArrayUtil.isEmpty(cgItms)){
			throw new ArgumentNullException("发票账单项金额减免计算", "减免项目");
		}
	}

	/**
	 * 计算费用减免
	 * @param aggDos
	 * @param cgItms
	 * @throws BizException
	 */
	private void calFreeAmt(BlincoepAggDO[] aggDos, BlCgItmOepDO[] cgItms) throws BizException {

		for (BlCgItmOepDO cgItm : cgItms) {
		
			for (BlincoepAggDO aggDO : aggDos) {
				
				boolean contain = false;
				for (BlIncCgItmOep incCgItm : aggDO.getBlIncCgItmOep()) {
					
					if(cgItm.getId_cgitmoep().equals(incCgItm.getId_cgitmoep())){
						contain = true;
						break;
					}
				}
				
				if(!contain){
					continue;
				}
				
				FDouble amt_hp_free =cgItm.getAmt_hp_free()==null?new FDouble(0):cgItm.getAmt_hp_free();
				FDouble amt_pat_free =cgItm.getAmt_pat_free()==null?new FDouble(0):cgItm.getAmt_pat_free();
				FDouble free = amt_hp_free.add(amt_pat_free);
//				FDouble free = cgItm.getAmt_ratio();
				
				//设置主表减免金额
				BlIncOepDO inc = aggDO.getParentDO();
				inc.setStatus(DOStatus.UPDATED);
				inc.setEu_freemd(BlFreeMdEnum.ITM_FREE_MD);
				inc.setAmt(inc.getAmt().sub(free));
				inc.setAmt_free(inc.getAmt_free().add(free));
				inc.setAmt_hp_free(inc.getAmt_hp_free()==null? amt_hp_free:inc.getAmt_hp_free().add(amt_hp_free));
				inc.setAmt_pat_free(inc.getAmt_pat_free()==null? amt_pat_free:inc.getAmt_pat_free().add(amt_pat_free));
				//设置发票项减免金额
				for (BlIncItmOepDO incItm : aggDO.getBlIncItmOepDO()) {
					
					if(cgItm.getCode_inccaitm().equals(incItm.getCode())){
						incItm.setStatus(DOStatus.UPDATED);
						incItm.setAmt(incItm.getAmt().sub(free));
						incItm.setAmt_free(incItm.getAmt_free().add(free));
						incItm.setAmt_hp_free(amt_hp_free);
						incItm.setAmt_pat_free(amt_pat_free);
						break;
					}
				}
				
				break;
			}
		}
		//设置减免方式
		for (BlincoepAggDO aggDO : aggDos) {
			BlIncOepDO inc = aggDO.getParentDO();
			inc.setStatus(DOStatus.UPDATED);
			inc.setEu_freemd(this.getEuFreemd(inc.getAmt_hp_free(), inc.getAmt_pat_free()));
		}
	}
	
	/**
	 * 获取项目减免方式
	 * @param amt_hp_free 医保自付减免
	 * @param amt_pat_free 项目减免
	 * @return
	 */
	private Integer getEuFreemd(FDouble amt_hp_free,FDouble amt_pat_free){
		Integer eu_freemd=BlFreeMdEnum.ITM_FREE_MD;
		if(FDoubleUtils.isMoreThanZero(amt_hp_free)){
			eu_freemd= BlFreeMdEnum.HP_SELF_FREE;
		}
		if(FDoubleUtils.isMoreThanZero(amt_hp_free) && FDoubleUtils.isMoreThanZero(amt_pat_free)){
			eu_freemd= BlFreeMdEnum.ITM_AND_HP_SELF;
		}
		return eu_freemd;
	}
}
