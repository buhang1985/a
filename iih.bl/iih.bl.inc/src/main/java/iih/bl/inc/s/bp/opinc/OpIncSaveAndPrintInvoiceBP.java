package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.util.OpInccaJudgeUtil;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlIncPrintMdEnum;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.inc.s.bp.opinc.incsplit.IncSplitOepBP;
import iih.bl.inc.s.bp.opinc.util.OpIncAssembleUtil;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.params.BlParams;
import iih.bl.params.BlParamsAnalysisUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * 保存打印门诊发票(新版收费) 
 * @author ly 2018/12/08
 *
 */
public class OpIncSaveAndPrintInvoiceBP {
	
	/**
	 * 保存打印门诊发票(新版收费) 
	 * 同时处理项目减免逻辑
	 * @param cgAggDos 记账aggdo数组
	 * @param 是否打印
	 * @return 发票数据
	 * @throws BizException
	 */
	public BlincoepAggDO[] exec(BlcgoepAggDO[] cgAggDos, FBoolean fgPrint) throws BizException{
	
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
		
		// 4.发票数据
		List<BlincoepAggDO> aggList = new ArrayList<BlincoepAggDO>();
		for (Entry<String, List<BlCgItmOepDO>> entry : splitMap.entrySet()) {
			//组装数据
			BlincoepAggDO incAggDO = OpIncAssembleUtil.assemble(entry.getValue(), inccaId);
			incAggDO.getParentDO().setFg_ec_inc(fgEcInc);
			//计算减免
			this.calFreeAmt(incAggDO, entry.getValue());
			aggList.add(incAggDO);
		}
		
		if(FBoolean.TRUE.equals(fgPrint) && FBoolean.FALSE.equals(fgEcInc)){
			
			// 5.打印
			Entry<String,String[]> printInfo = InvoicePrintUtil.print(
					inccaId, aggList.size(),Context.get().getStuffId(),Context.get().getClientHost());
			
			String codePkg = printInfo.getKey();
			String[] incnos = printInfo.getValue();
			
			// 6.回写票号
			this.setIncno(aggList, codePkg, incnos);
		}
		
		IBlincoepCudService cudService = ServiceFinder.find(IBlincoepCudService.class);
		return cudService.insert(aggList.toArray(new BlincoepAggDO[0]));
	}
	
	/**
	 * 保存门诊手工拆票
	 * @param cgAggDos 记账aggdo数组
	 * @param incPages 手工拆票分组
	 * @return 发票数据
	 * @throws BizException
	 * @author xb 2019/12/30
	 */
	public BlincoepAggDO[] execReInc(BlcgoepAggDO[] cgAggDos, BlReIncPageDTO[] incPages) throws BizException
	{
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
		
		if(incPages == null || incPages.length == 0)
			return null;
		
		// 判断票据类型
		String inccaId = OpInccaJudgeUtil.getInvoiceTp(cgAggDos[0].getBlCgItmOepDO()[0].getId_stoep());

		// 判断是否开启电子发票
		FBoolean fgEcInc =  FBoolean.FALSE;//BlParamsAnalysisUtil.BLINC0029(inccaId);
		
		// 2.发票分票逻辑
		Map<String, List<BlCgItmOepDO>> splitMap = null;
		if (FBoolean.FALSE.equals(fgEcInc)) {
			OpIncRePreSplitBP bp = new OpIncRePreSplitBP();
			splitMap = bp.exec(itmList, incPages);
		}
		else{
			// 开启电子发票后不进行分票业务
			splitMap = new IncSplitOepBP().noSplit(itmList);
		}
		
		// 4.发票数据
		List<BlincoepAggDO> aggList = new ArrayList<BlincoepAggDO>();
		for (Entry<String, List<BlCgItmOepDO>> entry : splitMap.entrySet()) {
			// 组装数据
			BlincoepAggDO incAggDO = OpIncAssembleUtil.assemble(entry.getValue(), inccaId);
			// 计算减免
			this.calFreeAmt(incAggDO, entry.getValue());
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
	
	/**
	 * 设置票号
	 * @param aggDos
	 * @param codePkg
	 * @param incnos
	 * @return
	 * @throws BizException
	 */
	private void setIncno(List<BlincoepAggDO> aggList, String codePkg, String[] incnos) throws BizException {

		String idPc = BlParams.getRealPcId(Context.get().getClientHost());
		for (int i = 0; i < aggList.size(); i++) {
			BlincoepAggDO aggDO = aggList.get(i);
			BlIncOepDO incDO = aggDO.getParentDO();
			incDO.setCode_incpkg(codePkg);
			incDO.setIncno(incnos[i]);
			incDO.setFg_print(FBoolean.TRUE);
			incDO.setTimes_prn(1);
			incDO.setId_emp_inc(Context.get().getStuffId());
			incDO.setId_dep_inc(Context.get().getDeptId());
			incDO.setId_pc(idPc);
			incDO.setEu_printmd(BlIncPrintMdEnum.PRINTWHENCHARGE);
		}
	}
	
	/**
	 * 计算费用减免
	 * @param aggDos
	 * @param cgItmList
	 * @throws BizException
	 */
	private void calFreeAmt(BlincoepAggDO aggDO, List<BlCgItmOepDO> cgItmList) throws BizException {

		for (BlCgItmOepDO cgItm : cgItmList) {
		
			if(FBoolean.FALSE.equals(cgItm.getFg_free()))
				continue;
			
			FDouble free = cgItm.getAmt_ratio();
			
			//设置主表减免金额
			BlIncOepDO inc = aggDO.getParentDO();
			inc.setEu_freemd(BlFreeMdEnum.ITM_FREE_MD);
			inc.setAmt(inc.getAmt().sub(free));
			inc.setAmt_free(inc.getAmt_free().add(free));
			
			//设置发票项减免金额
			for (BlIncItmOepDO incItm : aggDO.getBlIncItmOepDO()) {
				
				if(cgItm.getCode_inccaitm().equals(incItm.getCode())){
					incItm.setAmt(incItm.getAmt().sub(free));
					incItm.setAmt_free(incItm.getAmt_free().add(free));
					break;
				}
			}
		}
	}
}
