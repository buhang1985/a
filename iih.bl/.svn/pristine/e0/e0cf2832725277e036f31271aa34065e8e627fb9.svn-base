package iih.bl.inc.s.bp.opinc.util;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.d.BlAmtDTO;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 门诊发票数据组装工具类
 * @author ly 2018/03/30
 *
 */
public class OpIncAssembleUtil {

	private static FDateTime now = null;
	
	/**
	 * 组装发票数据
	 * @param cgList
	 * @return
	 * @throws BizException
	 */
	public static BlincoepAggDO assemble(List<BlCgItmOepDO> cgList, String inccaId) throws BizException {

		now = AppUtils.getServerDateTime();
		
		// 计算合计值,返回门急诊发票费用明细
		BlAmtDTO allAmt = new BlAmtDTO();
		Map<String,BlAmtDTO>  incAmtMap = new HashMap<String,BlAmtDTO>();
		BlIncCgItmOep[] incCgItmDos = calAmt(allAmt, incAmtMap, cgList);
		
		BlincoepAggDO agg = new BlincoepAggDO();
		// 主表数据
		BlIncOepDO parentDO = assembleParentData(cgList.get(0), allAmt, inccaId);
		// 发票账单项
		BlIncItmOepDO[] incItmDos = assembleIncItmData(incAmtMap);
		// 门急诊结算与发票关系
		BlStIncOepDO stIncDO = assembleStIncData(cgList.get(0));
		
		agg.setParentDO(parentDO);
		agg.setBlIncItmOepDO(incItmDos);
		agg.setBlIncCgItmOep(incCgItmDos);
		agg.setBlStIncOepDO(new BlStIncOepDO[] { stIncDO });
		
		return agg;
	}
	
	/**
	 * 计算合计值
	 * @param allAmt 总金额(出参)
	 * @param incAmtMap 账单项金额
	 * @param cgList 记账明细
	 * @return 发票费用明细
	 */
	private static BlIncCgItmOep[] calAmt(BlAmtDTO allAmt, Map<String, BlAmtDTO> incAmtMap, List<BlCgItmOepDO> cgList) {

		List<BlIncCgItmOep> incCgList = new ArrayList<BlIncCgItmOep>();
		
		//初始化合计值
		allAmt.setAmt(FDouble.ZERO_DBL);
		allAmt.setAmt_pat(FDouble.ZERO_DBL);
		allAmt.setAmt_std(FDouble.ZERO_DBL);
		allAmt.setAmt_ratio(FDouble.ZERO_DBL);
		allAmt.setAmt_hp(FDouble.ZERO_DBL);
		allAmt.setAmt_free(FDouble.ZERO_DBL);
		
		for (BlCgItmOepDO itm : cgList) {
		
			BlAmtDTO incAmt = null;
			String key = String.format("%s,%s", itm.getCode_inccaitm(),itm.getName_inccaitm());
			if(incAmtMap.containsKey(key)){
				incAmt = incAmtMap.get(key);
			}else{
				incAmt = new BlAmtDTO();
				incAmt.setAmt(FDouble.ZERO_DBL);
				incAmt.setAmt_pat(FDouble.ZERO_DBL);
				incAmt.setAmt_std(FDouble.ZERO_DBL);
				incAmt.setAmt_ratio(FDouble.ZERO_DBL);
				incAmt.setAmt_hp(FDouble.ZERO_DBL);
				incAmt.setAmt_free(FDouble.ZERO_DBL);
				
				incAmtMap.put(key, incAmt);
			}
			
			allAmt.setAmt(allAmt.getAmt().add(itm.getAmt()));
			allAmt.setAmt_std(allAmt.getAmt_std().add(itm.getAmt_std()));
			allAmt.setAmt_pat(allAmt.getAmt_pat().add(itm.getAmt_pat()));
			allAmt.setAmt_ratio(allAmt.getAmt_ratio().add(itm.getAmt_ratio()));
			allAmt.setAmt_hp(allAmt.getAmt_hp().add(itm.getAmt_hp()));
			
			incAmt.setAmt(incAmt.getAmt().add(itm.getAmt()));
			incAmt.setAmt_std(incAmt.getAmt_std().add(itm.getAmt_std()));
			incAmt.setAmt_pat(incAmt.getAmt_pat().add(itm.getAmt_pat()));
			incAmt.setAmt_ratio(incAmt.getAmt_ratio().add(itm.getAmt_ratio()));
			incAmt.setAmt_hp(incAmt.getAmt_hp().add(itm.getAmt_hp()));
			
			BlIncCgItmOep incCgItm = new BlIncCgItmOep();
			incCgItm.setId_cgitmoep(itm.getId_cgitmoep());
			incCgItm.setId_or(itm.getId_or());
			incCgItm.setId_orsrv(itm.getId_orsrv());
			incCgItm.setId_pat(itm.getId_pat());
			incCgItm.setId_org(itm.getId_org());
			incCgItm.setStatus(DOStatus.NEW);
			incCgList.add(incCgItm);
		}
		
		return incCgList.toArray(new BlIncCgItmOep[0]);
	}

	/**
	 * 组装发票主表数据
	 * @param firstItm
	 * @return
	 * @throws BizException
	 */
	private static BlIncOepDO assembleParentData(BlCgItmOepDO firstItm, BlAmtDTO amtDto, String inccaId)throws BizException {
		BlIncOepDO inc = new BlIncOepDO();
		inc.setId_grp(Context.get().getGroupId());
		inc.setId_org(Context.get().getOrgId());
		inc.setId_pat(firstItm.getId_pat());
		inc.setId_enttp(firstItm.getId_enttp());
		inc.setCode_enttp(firstItm.getCode_enttp());
		inc.setEu_direct(BookRtnDirectEnum.CHARGES);
		//inc.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		inc.setId_incca(inccaId);
		inc.setCode_incpkg(null);
		inc.setIncno(null);
		inc.setDt_inc(now);
		
		inc.setId_stoep(firstItm.getId_stoep());
		//inc.setId_emp_inc(Context.get().getStuffId());
		//inc.setId_dep_inc(Context.get().getDeptId());
		
		inc.setAmt(amtDto.getAmt());
		inc.setAmt_pat(amtDto.getAmt_pat());
		inc.setAmt_std(amtDto.getAmt_std());
		inc.setAmt_ratio(amtDto.getAmt_ratio());
		inc.setAmt_hp(amtDto.getAmt_hp());
		inc.setAmt_free(amtDto.getAmt_free());
		
		inc.setFg_canc(FBoolean.FALSE);
		inc.setFg_print(FBoolean.FALSE);		
		inc.setFg_cc_in(FBoolean.FALSE);
		inc.setFg_cc_out(FBoolean.FALSE);
		
		inc.setFg_ec_inc(FBoolean.FALSE);
		
		inc.setStatus(DOStatus.NEW);
		return inc;
	}

	/**
	 * 组装发票账单项数据
	 * @param incAmtMap
	 * @return
	 * @throws BizException
	 */
	private static BlIncItmOepDO[] assembleIncItmData(Map<String,BlAmtDTO> incAmtMap) throws BizException {
		List<BlIncItmOepDO> list = new ArrayList<BlIncItmOepDO>();
		for (Entry<String,BlAmtDTO> entry : incAmtMap.entrySet()) {
			
			String[] codeName = entry.getKey().split(",");
			BlAmtDTO amtDto = entry.getValue();
			
			BlIncItmOepDO incItm = new BlIncItmOepDO();
			incItm.setCode(codeName[0]);
			incItm.setName(codeName[1]);
			incItm.setAmt(amtDto.getAmt());
			incItm.setAmt_pat(amtDto.getAmt_pat());
			incItm.setAmt_std(amtDto.getAmt_std());
			incItm.setAmt_ratio(amtDto.getAmt_ratio());
			incItm.setAmt_hp(amtDto.getAmt_hp());
			incItm.setAmt_free(amtDto.getAmt_free());
			
			incItm.setStatus(DOStatus.NEW);
			list.add(incItm);
		}
		
		return list.toArray(new BlIncItmOepDO[0]);
	}

	/**
	 * 组装门急诊结算与发票关系数据
	 * @param firstItm
	 * @return
	 * @throws BizException
	 */
	private static BlStIncOepDO assembleStIncData(BlCgItmOepDO firstItm) throws BizException {
		BlStIncOepDO stInc = new BlStIncOepDO();
		stInc.setId_stoep(firstItm.getId_stoep());
		stInc.setFg_active(FBoolean.TRUE);
		stInc.setStatus(DOStatus.NEW);
		return stInc;
	}
}
