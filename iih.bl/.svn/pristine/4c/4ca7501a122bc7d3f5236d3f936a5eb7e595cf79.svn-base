package iih.bl.inc.s.bp.opinc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlIncPrintMdEnum;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.s.ep.IncOepEP;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊发票打印处理类
 * @author ly 2018/04/07
 * @author ly 2019/11/01 添加参数挂号票据相关处理
 *
 */
public class OpIncPrintInvioceBP {

	/**
	 * 门诊发票打印
	 * @param stId 结算id
	 * @param printSet 打印配置
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] exec(String[] stIds, BlIncPrintDTO printSet) throws BizException{
		
		if(ArrayUtil.isEmpty(stIds)){
			throw new ArgumentNullException("门诊发票打印处理", "结算id");
		}
		
		String regIncvoiceTp = BlParams.BLINC0026();
		if(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE.equals(regIncvoiceTp)){
			return this.printOldLogic(stIds, printSet);
		}
		
		return this.printNewLogic(stIds, printSet);
	}

	/**
	 * 打印原逻辑
	 * @param stIds
	 * @param printSet
	 * @return
	 * @throws BizException
	 */
	private BlincoepAggDO[] printOldLogic(String[] stIds, BlIncPrintDTO printSet) throws BizException{
		
		// 1.准备数据
		// 查询费发票信息
		BlincoepAggDO[] aggDos = new IncOepEP().findIncByStId(stIds);
		if(ArrayUtil.isEmpty(aggDos)){
			throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
		}
		if(FBoolean.TRUE.equals(aggDos[0].getParentDO().getFg_ec_inc()))
			return aggDos;
		
		// 2.打印
		Entry<String,String[]> printInfo = InvoicePrintUtil.print(
				IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE, aggDos.length,Context.get().getStuffId(),Context.get().getClientHost());
		
		String codePkg = printInfo.getKey();
		String[] incnos = printInfo.getValue();
		
		// 3.更新发票数据，赋值具体票号
		aggDos = this.updateIncData(aggDos, codePkg, incnos, printSet);
		
		return aggDos;
	}
	
	/**
	 * 打印新逻辑
	 * @param stIds
	 * @param printSet
	 * @return
	 * @throws BizException
	 */
	private BlincoepAggDO[] printNewLogic(String[] stIds, BlIncPrintDTO printSet) throws BizException{
		
		List<BlincoepAggDO> oepIncAggList = new ArrayList<BlincoepAggDO>();
		for (String stId : stIds) {
			
			// 1.准备数据
			// 查询费发票信息
			BlincoepAggDO[] aggDos = new IncOepEP().findIncByStId(stId);
			if(ArrayUtil.isEmpty(aggDos)){
				throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
			}
			if(FBoolean.TRUE.equals(aggDos[0].getParentDO().getFg_ec_inc())){
				oepIncAggList.addAll(Arrays.asList(aggDos));
				continue;
			}
			
			// 2.打印
			Entry<String,String[]> printInfo = InvoicePrintUtil.print(
					aggDos[0].getParentDO().getId_incca() , aggDos.length,Context.get().getStuffId(),Context.get().getClientHost());
			
			String codePkg = printInfo.getKey();
			String[] incnos = printInfo.getValue();
			
			// 3.更新发票数据，赋值具体票号
			aggDos = this.updateIncData(aggDos, codePkg, incnos, printSet);
			oepIncAggList.addAll(Arrays.asList(aggDos));
		}
		
		return oepIncAggList.toArray(new BlincoepAggDO[0]);
	}
	
	/**
	 * 更新发票数据
	 * @param aggDos
	 * @param codePkg
	 * @param incnos
	 * @param printSet
	 * @return
	 * @throws BizException
	 */
	private BlincoepAggDO[] updateIncData(BlincoepAggDO[] aggDos,
			String codePkg, String[] incnos, BlIncPrintDTO printSet) throws BizException {

		String idPc = BlParams.getRealPcId(Context.get().getClientHost());
		for (int i = 0; i < aggDos.length; i++) {
			BlincoepAggDO aggDO = aggDos[i];
			BlIncOepDO incDO = aggDO.getParentDO();
			incDO.setCode_incpkg(codePkg);
			incDO.setIncno(incnos[i]);
			incDO.setFg_print(FBoolean.TRUE);
			incDO.setTimes_prn(1);
			incDO.setId_emp_inc(Context.get().getStuffId());
			incDO.setId_dep_inc(Context.get().getDeptId());
			incDO.setId_pc(idPc);
			incDO.setDt_inc(BlFlowContextUtil.getNowTime());
			incDO.setStatus(DOStatus.UPDATED);
			
			if(FBoolean.TRUE.equals(printSet.getFgpay())){
				incDO.setEu_printmd(BlIncPrintMdEnum.PRINTWHENCHARGE);
			}else{
				if(IBlDictCodeConst.SD_PTTP_WINDOW.equals(printSet.getSd_pttp())){
					incDO.setEu_printmd(BlIncPrintMdEnum.REPRINGBYWINDOW);
				}else{
					incDO.setEu_printmd(BlIncPrintMdEnum.REPRINTBYSELF);
				}
			}
		}
		
		IBlincoepCudService cudService = ServiceFinder.find(IBlincoepCudService.class);
		return cudService.update(aggDos);
	}
}
