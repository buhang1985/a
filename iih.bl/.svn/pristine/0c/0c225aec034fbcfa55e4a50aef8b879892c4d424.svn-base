package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.comm.util.OpInccaJudgeUtil;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.bl.inc.blincoeppaper.i.IBlincoeppaperCudService;
import iih.bl.inc.s.bp.opinc.util.OpRedIncAssembleUtil;
import iih.bl.inc.s.ep.IncOepEP;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊红冲发票保存类(含打印)
 * @author ly 2018/04/19
 *
 */
public class OpIncSaveRedInvoiceBP {

	/**
	 * 门诊红冲发票保存(含打印)
	 * @param oldStId 原结算id
	 * @param redCgAggDos 红冲记账数据
	 * @param fgPrintInc 是否打印发票
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] exec(String oldStId, BlcgoepAggDO[] redCgAggDos, FBoolean fgPrintInc) throws BizException {

		this.validate(oldStId, redCgAggDos, fgPrintInc);
		
		// 1.查询原发票信息
		BlincoepAggDO[] oldIncAggDos = new IncOepEP().findIncByStId(oldStId);
		if(ArrayUtil.isEmpty(oldIncAggDos)){
			throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
		}
		
		boolean fgEcInc = this.isEcInc(oldIncAggDos);
		
		// 2.构造原记账主键与新记账主键关系
		Map<String,String> cgIdMap = this.makeCgIdMap(redCgAggDos);
		
		String codePkg = null;//票据包编码
		String[] incnos = null;//发票号
		// 3.需要打印时
		if(FBoolean.TRUE.equals(fgPrintInc) && !fgEcInc){
			String inccaId = OpInccaJudgeUtil.getInvoiceTp(oldStId);
			Entry<String,String[]> printInfo = InvoicePrintUtil.print(
					inccaId, redCgAggDos.length, BlFlowContextUtil.getEmpId(), Context.get().getClientHost());
			
			codePkg = printInfo.getKey();
			incnos = printInfo.getValue();
		}
		
		// 4.构造红票数据
		String redStId = redCgAggDos[0].getBlCgItmOepDO()[0].getId_stoep();
		BlincoepAggDO[] redIncAggDos = this.makeRedIncInfo(oldIncAggDos, cgIdMap, codePkg, incnos, fgPrintInc, redStId);
		
		// 5.保存红票数据
		IBlincoepCudService cudService = ServiceFinder.find(IBlincoepCudService.class);
		redIncAggDos = cudService.save(redIncAggDos);
		
		// 6.电子票时处理纸质票红冲
		if(fgEcInc){
			this.redIncPaper(oldStId, redIncAggDos[0].getParentDO().getId_incoep(), redStId);
		}
		
		return this.filterData(redIncAggDos, oldIncAggDos);
	}

	/**
	 * 参数校验
	 * @param oldStId
	 * @param redCgAggDos
	 * @param printInc
	 * @throws BizException
	 */
	private void validate(String oldStId, BlcgoepAggDO[] redCgAggDos, FBoolean printInc) throws BizException {
		
		if(StringUtil.isEmpty(oldStId)){
			 throw new ArgumentNullException("门诊红冲发票保存", "原结算id");
		}
		
		if(ArrayUtil.isEmpty(redCgAggDos)){
			 throw new ArgumentNullException("门诊红冲发票保存", "红冲记账数据");
		}
		
		if(printInc == null){
			throw new ArgumentNullException("门诊红冲发票保存", "是否打印发票");
		}
	}

	/**
	 * 构造原记账主键与新记账主键关系
	 * @param redCgAggDos
	 * @return
	 */
	private Map<String,String> makeCgIdMap(BlcgoepAggDO[] redCgAggDos){
		
		Map<String,String> map = new HashMap<String,String>();
		
		for (BlcgoepAggDO aggDO : redCgAggDos) {
			for (BlCgItmOepDO cgItmDO : aggDO.getBlCgItmOepDO()) {
				map.put(cgItmDO.getId_par(), cgItmDO.getId_cgitmoep());
			}
		}
		
		return map;
	}

	/**
	 * 判断是否电子发票
	 * @param oldIncAggDos
	 * @return
	 * @throws BizException
	 */
	private boolean isEcInc(BlincoepAggDO[] oldIncAggDos) throws BizException {
		
		for (BlincoepAggDO blincoepAggDO : oldIncAggDos) {
			
			if(FBoolean.TRUE.equals(blincoepAggDO.getParentDO().getFg_ec_inc())){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 构造红票数据
	 * @param oldIncAggDos
	 * @param cgIdMap
	 * @param codePkg
	 * @param incnos
	 * @param fgPrintInc
	 * @param redStId
	 * @return
	 * @throws BizException
	 */
	private BlincoepAggDO[] makeRedIncInfo(BlincoepAggDO[] oldIncAggDos,
			Map<String, String> cgIdMap, String codePkg, String[] incnos,
			FBoolean fgPrintInc,String redStId) throws BizException {

		String idPc = BlParams.getRealPcId(Context.get().getClientHost());
		FDateTime now = AppUtils.getServerDateTime();
		List<BlincoepAggDO> redIncAggList = new ArrayList<BlincoepAggDO>();
		
		
		for (int i = 0; i < oldIncAggDos.length; i++) {
			
			//构造红冲发票数据
			BlincoepAggDO redIncAgg = OpRedIncAssembleUtil.assemble(oldIncAggDos[i], cgIdMap, redStId);
			//需要打印发票时
			if(FBoolean.TRUE.equals(fgPrintInc)){
				BlIncOepDO inc = redIncAgg.getParentDO();
				inc.setIncno(incnos[i]);
				inc.setCode_incpkg(codePkg);
				inc.setDt_inc(now);
				inc.setId_emp_inc(BlFlowContextUtil.getEmpId());
				inc.setTimes_prn(1);
				inc.setFg_print(FBoolean.TRUE);
				inc.setId_pc(idPc);
			}
			
			redIncAggList.add(redIncAgg);
			
			//修改原发票数据
			BlIncOepDO oldInc = oldIncAggDos[i].getParentDO();
			oldInc.setFg_canc(FBoolean.TRUE);
			oldInc.setId_reason_canc(IBdPpCodeTypeConst.ID_REFUND);
			oldInc.setSd_reason_canc(IBdPpCodeTypeConst.SD_REFUND);
			oldInc.setDes_reason_canc(IBdPpCodeTypeConst.DES_REFUND);
			oldInc.setDt_canc(AppUtils.getServerDateTime());
			oldInc.setId_emp_canc(BlFlowContextUtil.getEmpId());
			oldInc.setId_dep_canc(Context.get().getDeptId());
			oldInc.setStatus(DOStatus.UPDATED);
			
			redIncAggList.add(oldIncAggDos[i]);
		}
		
		return redIncAggList.toArray(new BlincoepAggDO[0]);
	}

	/**
	 * 红冲纸质票据
	 * @param oldStId
	 */
	@SuppressWarnings("unchecked")
	private void redIncPaper(String oldStId,String redIncId,String redStId) throws BizException {
		
		IBlincoeppaperCudService paperServive = ServiceFinder.find(IBlincoeppaperCudService.class);

		DAFacade daf = new DAFacade();
		List<BlIncOepDO> list = (List<BlIncOepDO>)daf.findByAttrValString(BlIncOepDO.class, BlIncOepDO.ID_STOEP, oldStId, null);
		BlIncOepDO incDO = list.get(0);
		List<BlIncOepPaperDO> paperList = (List<BlIncOepPaperDO>)daf.findByAttrValString(BlIncOepPaperDO.class, BlIncOepPaperDO.ID_INCOEP, incDO.getId_incoep(), null);
		if(!ListUtil.isEmpty(paperList)){
			
			//更新原数据
			BlIncOepPaperDO paperDO = paperList.get(0);
			paperDO.setFg_canc(FBoolean.TRUE);
			paperDO.setId_reason_canc(IBdPpCodeTypeConst.ID_REFUND);
			paperDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_REFUND);
			paperDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_REFUND);
			paperDO.setDt_canc(AppUtils.getServerDateTime());
			paperDO.setId_emp_canc(BlFlowContextUtil.getEmpId());
			paperDO.setId_dep_canc(Context.get().getDeptId());
			paperDO.setStatus(DOStatus.UPDATED);
			paperServive.update(new BlIncOepPaperDO[]{paperDO});
			
			//插入红冲数据
			BlIncOepPaperDO redPaperDO = new BlIncOepPaperDO();
			redPaperDO.setId_incoep(redIncId);
			redPaperDO.setId_grp(Context.get().getGroupId());
			redPaperDO.setId_org(Context.get().getOrgId());
			redPaperDO.setId_pat(paperDO.getId_pat());
			redPaperDO.setId_ent(paperDO.getId_ent());
			redPaperDO.setId_entp(paperDO.getId_entp());
			redPaperDO.setCode_entp(paperDO.getCode_entp());
			redPaperDO.setId_incca(paperDO.getId_incca());
			redPaperDO.setEu_direct(-1);
			redPaperDO.setTimes_prn(0);
			redPaperDO.setFg_cc_out(FBoolean.FALSE);
			redPaperDO.setFg_cc_in(FBoolean.FALSE);
			redPaperDO.setId_stoep(redStId);
			redPaperDO.setStatus(DOStatus.NEW);
			
			paperServive.insert(new BlIncOepPaperDO[]{redPaperDO});
		}
	}
	
	/**
	 * 排序和过滤红冲票数据
	 * @param redIncAggDos
	 * @param oldIncAggDos
	 * @return
	 */
	private BlincoepAggDO[] filterData(BlincoepAggDO[] redIncAggDos,BlincoepAggDO[] oldIncAggDos){
		
		List<String> keys = new ArrayList<String>();
		for (BlincoepAggDO aggDO : oldIncAggDos) {
			keys.add(aggDO.getParentDO().getId_incoep());
		}
		
		List<BlincoepAggDO> redIncList = new ArrayList<BlincoepAggDO>();
		for (BlincoepAggDO aggDO : redIncAggDos) {
			
			if(keys.contains(aggDO.getParentDO().getId_stoep()))
				continue;
			
			redIncList.add(aggDO);
		}
		
		return redIncList.toArray(new BlincoepAggDO[0]);
	}
}
