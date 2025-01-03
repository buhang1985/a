package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlIncPrintMdEnum;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincoepcanclog.d.BlIncOepCancLogDO;
import iih.bl.inc.blincoepcanclog.i.IBlincoepcanclogCudService;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.s.bp.inc.util.IncCancAssembleUtil;
import iih.bl.inc.s.bp.opinc.util.OpIncCancLogAssembleUtil;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.params.BlParams;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

/**
 * 门诊发票重打逻辑类
 * @author ly 2018/04/12
 * @author ly 2019/11/01 添加挂号票据处理
 *
 */
public class OpIncReprintInvioceBP {

	/**
	 * 发票重打逻辑类
	 * @param incIds 发票id
	 * @param fgReg 是否挂号发票
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] exec(String[] incIds, BlIncPrintDTO printSet) throws BizException{
		
		this.validate(incIds, printSet);
		
		// 1.准备数据
		// 查询发票信息
		BlincoepAggDO[] aggDos = this.getIncInfo(incIds);
		
		if(FBoolean.TRUE.equals(aggDos[0].getParentDO().getFg_ec_inc()))
			return aggDos;
		
		//校验发票状态
		this.validateInc(aggDos, printSet);
		
		Map<String,List<BlincoepAggDO>> groupMap = new HashMap<String,List<BlincoepAggDO>>();
		//数据分组
		for (BlincoepAggDO blincoepAggDO : aggDos) {
		
			List<BlincoepAggDO> incList = null;
			if(groupMap.containsKey(blincoepAggDO.getParentDO().getId_incca())){
				incList = groupMap.get(blincoepAggDO.getParentDO().getId_incca());
			}else{
				incList = new ArrayList<BlincoepAggDO>();
				groupMap.put(blincoepAggDO.getParentDO().getId_incca(), incList);
			}
			
			incList.add(blincoepAggDO);
		}
		
		// 2.打印
		List<BlincoepAggDO> printedList = new ArrayList<BlincoepAggDO>();
		FBoolean printZero = BlParams.BLSTOEP0008();
		for (String inccaId : groupMap.keySet()) {
			
			List<BlincoepAggDO> incList = groupMap.get(inccaId);
			
			int printLen = 0;
			for (int i = 0; i < incList.size(); i++) {
				BlincoepAggDO aggDO = incList.get(i);
				BlIncOepDO incDO = aggDO.getParentDO();
				if(!(FBoolean.FALSE.equals(printZero) && FDouble.ZERO_DBL.equals(incDO.getAmt_ratio()))){
					printLen++;
				}
			}
			if(printLen > 0){
				Entry<String,String[]> printInfo = InvoicePrintUtil.print(
						inccaId, printLen,Context.get().getStuffId(),Context.get().getClientHost());
				
				String codePkg = printInfo.getKey();
				String[] incnos = printInfo.getValue();
				
				// 3.更新发票数据
				BlincoepAggDO[] updateRlt = this.updateIncData(incList.toArray(new BlincoepAggDO[0]), codePkg ,incnos, printSet);			
				printedList.addAll(Arrays.asList(updateRlt));
			}
		}
		
		//重新排序
		List<BlincoepAggDO> rlt = new ArrayList<BlincoepAggDO>();
		for (BlincoepAggDO blincoepAggDO : aggDos) {
			for (BlincoepAggDO blincoepAggDO2 : printedList) {
				
				if(blincoepAggDO.getParentDO().getId_incoep().equals(
						blincoepAggDO2.getParentDO().getId_incoep())){
					rlt.add(blincoepAggDO2);
					break;
				}
			}
		}
		
		return rlt.toArray(new BlincoepAggDO[0]);
	}
	
	/**
	 * 参数校验
	 * @param incIds
	 * @param fgReg
	 * @throws BizException
	 */
	private void validate(String[] incIds,BlIncPrintDTO printSet) throws BizException{
		
		if(ArrayUtil.isEmpty(incIds)){
			throw new ArgumentNullException("门诊发票重打", "重打发票数组");
		}
		
		if(printSet.getFgreg() == null){
			throw new ArgumentNullException("门诊发票重打", "是否挂号发票");
		}
	}
	
	/**
	 * 发票状态校验
	 * @param aggDos
	 * @param printSet
	 * @throws BizException
	 */
	private void validateInc(BlincoepAggDO[] aggDos,BlIncPrintDTO printSet)throws BizException{
		
		if(FBoolean.FALSE.equals(printSet.getFgreg()))
			return;
		if(aggDos == null || aggDos.length == 0){
			throw new BizException("当前配置不允许打印0元发票");
		}
		for (BlincoepAggDO aggDO : aggDos) {
			if(FBoolean.TRUE.equals(aggDO.getParentDO().getFg_cc_out())){
				throw new BizException(IBlMsgConst.ERROR_INCOEP_CC_OUT + " 票号:"
						+ aggDO.getParentDO().getIncno());
			}
		}
	}
	
	/**
	 * 查询发票信息
	 * @param incIds
	 * @return
	 * @throws BizException
	 */
	private BlincoepAggDO[] getIncInfo(String[] incIds) throws BizException{
		IBlincoepRService rService = ServiceFinder.find(IBlincoepRService.class);
		
		String whereSql = SqlUtils.getInSqlByIds(BlIncOepDODesc.TABLE_ALIAS_NAME 
				+ "." + BlIncOepDO.ID_INCOEP,incIds);
		BlincoepAggDO[] aggDos = rService.find(whereSql,BlIncOepDODesc.TABLE_ALIAS_NAME 
				+ "." + BlIncOepDO.INCNO,FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(aggDos)){
			throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
		}
		return aggDos;
	}

	/**
	 * 更新发票数据
	 * @param aggDos
	 * @param codePkg
	 * @param incnos
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] updateIncData(BlincoepAggDO[] aggDos,
			String codePkg,String[] incnos, BlIncPrintDTO printSet) throws BizException {

		List<BlIncCancDO> cancList = new ArrayList<BlIncCancDO>();
		List<BlIncOepCancLogDO> logList = new ArrayList<BlIncOepCancLogDO>();
		
		String idPc = BlParams.getRealPcId(Context.get().getClientHost());
		FBoolean printZero = BlParams.BLSTOEP0008();
		FDateTime now = new FDateTime();
		for (int i = 0; i < aggDos.length; i++) {
			BlincoepAggDO aggDO = aggDos[i];
			BlIncOepDO incDO = aggDO.getParentDO();
			if(!(FBoolean.FALSE.equals(printZero) && FDouble.ZERO_DBL.equals(incDO.getAmt_ratio()))){
				//作废发票数据
				//判断如果原票号不为空才生成作废票据记录（预约挂号时，没有发票信息，导致取号时导致废票表插入票号为空的记录），by lim 2019-09-02
				if(!StringUtils.isEmpty(incDO.getIncno())){
					cancList.add(IncCancAssembleUtil.assemble(incDO));
				}
				
				//作废发票记录
				logList.add(OpIncCancLogAssembleUtil.assemble(incDO, codePkg, incnos[i]));
				
				incDO.setCode_incpkg(codePkg);
				incDO.setIncno(incnos[i]);
				incDO.setFg_print(FBoolean.TRUE);
				if(incDO.getTimes_prn() == null){
					incDO.setTimes_prn(1);
				}else{
					incDO.setTimes_prn(incDO.getTimes_prn() + 1);
				}
				
				incDO.setId_emp_inc(Context.get().getStuffId());
				incDO.setId_dep_inc(Context.get().getDeptId());
				incDO.setId_pc(idPc);
				
				if(IBlDictCodeConst.SD_PTTP_WINDOW.equals(printSet.getSd_pttp())){
					incDO.setEu_printmd(BlIncPrintMdEnum.REPRINGBYWINDOW);
				}else{
					incDO.setEu_printmd(BlIncPrintMdEnum.REPRINTBYSELF);
				}
				incDO.setDt_inc(now);
				incDO.setStatus(DOStatus.UPDATED);
			}
			
		}
		
		IBlincoepCudService incCudService = ServiceFinder.find(IBlincoepCudService.class);
		IBlinccancCudService cancCudService=ServiceFinder.find(IBlinccancCudService.class);
		IBlincoepcanclogCudService logCudService = ServiceFinder.find(IBlincoepcanclogCudService.class);
		
		if(cancList.size() > 0){
			//保存作废票数据
			cancCudService.insert(cancList.toArray(new BlIncCancDO[0]));
			//保存作废票记录
			logCudService.insert(logList.toArray(new BlIncOepCancLogDO[0]));			
		}
		
		return incCudService.update(aggDos);
	}
	
	/**
	 * 门诊重拆票后更新原有发票数据
	 * @param aggDos
	 * @param codePkg
	 * @param incnos
	 * @return
	 * @throws BizException
	 */
	public void updateReIncData(BlincoepAggDO[] aggDos) throws BizException {

		BlRtnReasonDTO reasonDTO = new BlRtnReasonDTO();
		reasonDTO.setId_udidoc(IBdPpCodeTypeConst.ID_REINC);
		reasonDTO.setCode(IBdPpCodeTypeConst.SD_REINC);
		reasonDTO.setName(IBdPpCodeTypeConst.DES_REINC);
		
		List<BlIncCancDO> cancList = new ArrayList<BlIncCancDO>();
		List<BlIncOepCancLogDO> logList = new ArrayList<BlIncOepCancLogDO>();
		
		//String idPc = BlParams.getRealPcId(Context.get().getClientHost());
		FBoolean printZero = BlParams.BLSTOEP0008();
		for (int i = 0; i < aggDos.length; i++) {
			BlincoepAggDO aggDO = aggDos[i];
			BlIncOepDO incDO = aggDO.getParentDO();
			if(!(FBoolean.FALSE.equals(printZero) && FDouble.ZERO_DBL.equals(incDO.getAmt_ratio()))){
				//作废发票数据
				//判断如果原票号不为空才生成作废票据记录（预约挂号时，没有发票信息，导致取号时导致废票表插入票号为空的记录），by lim 2019-09-02
				if(!StringUtils.isEmpty(incDO.getIncno())){
					cancList.add(IncCancAssembleUtil.assembleWithReason(incDO, reasonDTO));
				}
				
				//作废发票记录
				logList.add(OpIncCancLogAssembleUtil.assemble(incDO, incDO.getCode_incpkg(), incDO.getIncno()));
			}
			
		}
		
		IBlincoepCudService incCudService = ServiceFinder.find(IBlincoepCudService.class);
		IBlinccancCudService cancCudService=ServiceFinder.find(IBlinccancCudService.class);
		IBlincoepcanclogCudService logCudService = ServiceFinder.find(IBlincoepcanclogCudService.class);
		
		if(cancList.size() > 0){
			//保存作废票数据
			cancCudService.insert(cancList.toArray(new BlIncCancDO[0]));
			//保存作废票记录
			logCudService.insert(logList.toArray(new BlIncOepCancLogDO[0]));			
		}
		
		incCudService.delete(aggDos);
	}
}
