package iih.bl.inc.s.bp.opinc.util;

import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊红冲发票数据组装工具类
 * @author ly 2018/03/30
 *
 */
public class OpRedIncAssembleUtil {

	/**
	 * 组装红冲发票数据
	 * @param oldIncAggDO 原始发票信息
	 * @param cgIdMap 原记账主键与红冲记账主键关系
	 * @param codePkg 票据包编码
	 * @param incNo 发票号
	 * @param redStId 红冲结算id
	 * @return
	 * @throws BizException
	 */
	public static BlincoepAggDO assemble(BlincoepAggDO oldIncAggDO,
			Map<String, String> cgIdMap,String redStId) throws BizException {

		BlincoepAggDO redIncAggDO = new BlincoepAggDO();
		// 主表数据
		BlIncOepDO parentDO = assembleParentData(oldIncAggDO.getParentDO(),redStId);
		// 发票账单项
		BlIncItmOepDO[] incItmDos = assembleIncItmData(oldIncAggDO.getBlIncItmOepDO());
		// 发票费用明细
		BlIncCgItmOep[] incCgItmDos = assembleIncCgItmData(oldIncAggDO.getBlIncCgItmOep(), cgIdMap);
		// 门急诊结算与发票关系
		BlStIncOepDO stIncDO = assembleStIncData(redStId);
		
		redIncAggDO.setParentDO(parentDO);
		redIncAggDO.setBlIncItmOepDO(incItmDos);
		redIncAggDO.setBlIncCgItmOep(incCgItmDos);
		redIncAggDO.setBlStIncOepDO(new BlStIncOepDO[] { stIncDO });
		
		return redIncAggDO;
	}
	
	/**
	 * 组装发票主表数据
	 * @param oldIncDO
	 * @param codePkg
	 * @param incNo
	 * @param redStId
	 * @param fgPrintInc
	 * @return
	 * @throws BizException
	 */
	private static BlIncOepDO assembleParentData(BlIncOepDO oldIncDO, String redStId) throws BizException {
		BlIncOepDO inc = (BlIncOepDO)oldIncDO.clone();

		inc.setId_incoep(null);
		inc.setEu_direct(BookRtnDirectEnum.REFUND);
		inc.setIncno(null);
		inc.setCode_incpkg(null);
		inc.setDt_inc(null);
		inc.setId_emp_inc(null);
		inc.setId_dep_inc(null);
		inc.setTimes_prn(0);
		inc.setFg_print(FBoolean.FALSE);
		inc.setFg_canc(FBoolean.FALSE);
		inc.setSd_reason_canc(null);
		inc.setId_reason_canc(null);
		inc.setDes_reason_canc(null);
		inc.setDt_canc(null);
		inc.setId_emp_canc(null);
		inc.setId_stoep(redStId);
		inc.setFg_cc_in(FBoolean.FALSE);
		inc.setFg_cc_out(FBoolean.FALSE);
		inc.setId_cc_in(null);
		inc.setId_cc_out(null);
		inc.setCreatedby(null);
		inc.setCreatedtime(null);
		inc.setModifiedby(null);
		inc.setModifiedtime(null);
		inc.setStatus(DOStatus.NEW);
		
		return inc;
	}

	/**
	 * 组装发票账单项数据
	 * @param oldIncItmDos
	 * @return
	 * @throws BizException
	 */
	private static BlIncItmOepDO[] assembleIncItmData(BlIncItmOepDO[] oldIncItmDos){
		List<BlIncItmOepDO> list = new ArrayList<BlIncItmOepDO>();
		
		for (BlIncItmOepDO oldIncItm : oldIncItmDos) {
			BlIncItmOepDO incItm = (BlIncItmOepDO)oldIncItm.clone();
			incItm.setId_incoep(null);
			incItm.setId_incitmoep(null);
			incItm.setStatus(DOStatus.NEW);
			list.add(incItm);
		}
		
		return list.toArray(new BlIncItmOepDO[0]);
	}

	/**
	 * 组装费用明细数据
	 * @param oldIncCgItmDos
	 * @param cgIdMap
	 * @return
	 */
	private static BlIncCgItmOep[] assembleIncCgItmData(BlIncCgItmOep[] oldIncCgItmDos,Map<String, String> cgIdMap){
		List<BlIncCgItmOep> list = new ArrayList<BlIncCgItmOep>();
		for (BlIncCgItmOep oldIncCgItm : oldIncCgItmDos) {
			
			BlIncCgItmOep incCgItm = (BlIncCgItmOep)oldIncCgItm.clone();
			incCgItm.setId_incoep(null);
			incCgItm.setId_inccgitmoep(null);
			incCgItm.setId_cgitmoep(cgIdMap.get(incCgItm.getId_cgitmoep()));
			incCgItm.setStatus(DOStatus.NEW);
			list.add(incCgItm);
		}
		
		return list.toArray(new BlIncCgItmOep[0]);
	}
	
	/**
	 * 组装门急诊结算与发票关系数据
	 * @param stId
	 * @return
	 * @throws BizException
	 */
	private static BlStIncOepDO assembleStIncData(String stId) throws BizException {
		BlStIncOepDO stInc = new BlStIncOepDO();
		stInc.setId_stoep(stId);
		stInc.setFg_active(FBoolean.TRUE);
		stInc.setStatus(DOStatus.NEW);
		return stInc;
	}
}
