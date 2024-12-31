package iih.bl.inc.s.bp.ipinc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.d.BlAmtDTO;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blinccgip.d.BlIncCgIpDO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blreinccgitmdto.d.BlReIncPageDTO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.utils.CapitalFiguresUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 住院发票数据组装工具类
 * 
 * @author wq.li
 * @date 2018年8月11日
 */
public class IpIncAssembleUtil {

	private static FDateTime nowTime = null;

	/**
	 * 组装发票数据
	 * 
	 * @param cgList
	 * @return
	 * @date 2018年8月11日
	 * @author wq.li
	 * @throws BizException
	 */
	public static BlincipAggDO assemble(List<BlCgIpDO> cgList, List<BlIncCgIpDO> incCgDoList,BlStIpDO stDO) throws BizException {

		nowTime = BlFlowContextUtil.getNowTime();

		BlincipAggDO aggDO = new BlincipAggDO();

		// 计算合计值,返回住院发票费用明细
		BlAmtDTO allAmt = new BlAmtDTO();
		Map<String, BlAmtDTO> incAmtMap = new HashMap<String, BlAmtDTO>();
		calAmt(allAmt, incAmtMap, cgList);

		// 住院发票主表
		BlIncIpDO incDO = assembleParentData(stDO,allAmt);

		// 住院发票明细表
		BlIncItmIpDO[] incitmDOArr = assembleIncItmData(incAmtMap);

		// 住院结算与发票关系表
		BlStIncIpDO[] stIncDOArr = assembleStIncData(stDO);

		// 住院发票费用明细
		incCgDoList = assembleIncCgIpData(cgList, incDO,incCgDoList);

		aggDO.setParentDO(incDO);
		aggDO.setBlIncItmIpDO(incitmDOArr);
		aggDO.setBlStIncIpDO(stIncDOArr);

		return aggDO;
	}

	public static BlincipAggDO assembleReInc(BlStIpDO stDO, BlReIncPageDTO incPage) throws BizException{
		nowTime = BlFlowContextUtil.getNowTime();
		BlincipAggDO aggDO = new BlincipAggDO();
		
		
		
		BlAmtDTO allAmt = new BlAmtDTO();
		Map<String, BlAmtDTO> incAmtMap = new HashMap<String, BlAmtDTO>();
		
		allAmt.setAmt(FDouble.ZERO_DBL);
		allAmt.setAmt_pat(FDouble.ZERO_DBL);
		allAmt.setAmt_std(FDouble.ZERO_DBL);
		allAmt.setAmt_ratio(FDouble.ZERO_DBL);
		allAmt.setAmt_hp(FDouble.ZERO_DBL);
		allAmt.setAmt_free(FDouble.ZERO_DBL);

		FArrayList2 incItmList = incPage.getReincitms() ;
		for (int i= 0; i< incItmList.size(); i++) {
			BlStIpInccaInfoDTO itm = (BlStIpInccaInfoDTO)incItmList.get(i);
			
			BlAmtDTO incAmt = null;
			String key = String.format("%s,%s", itm.getCode_inccaitm(), itm.getName_inccaitm());
			if (incAmtMap.containsKey(key)) {
				incAmt = incAmtMap.get(key);
			} else {
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
		}
		
		// 住院发票主表
		BlIncIpDO incDO = assembleParentData(stDO, allAmt);

		// 住院发票明细表
		BlIncItmIpDO[] incitmDOArr = assembleIncItmData(incAmtMap);

		// 住院结算与发票关系表
		BlStIncIpDO[] stIncDOArr = assembleStIncData(stDO);

		aggDO.setParentDO(incDO);
		aggDO.setBlIncItmIpDO(incitmDOArr);
		aggDO.setBlStIncIpDO(stIncDOArr);
		
		return aggDO;
	}
	/**
	 * 住院发票费用明细
	 * 
	 * @param cgList
	 * @param incDO
	 * @return
	 * @date 2018年8月11日
	 * @author wq.li
	 */

	private static List<BlIncCgIpDO> assembleIncCgIpData(List<BlCgIpDO> cgList, BlIncIpDO incDO,List<BlIncCgIpDO> incCgDoList) {

		for (BlCgIpDO cgDO : cgList) {
			BlIncCgIpDO incCgDO = new BlIncCgIpDO();
			incCgDO.setId_cgip(cgDO.getId_cgip());
			incCgDO.setId_incip(incDO.getId_incip());
			incCgDO.setStatus(DOStatus.NEW);
			incCgDoList.add(incCgDO);
		}

		return incCgDoList;
	}

	/**
	 * 计算合计值
	 * 
	 * @param allAmt
	 *            总金额(出参)
	 * @param incAmtMap
	 *            账单项金额
	 * @param cgList
	 *            记账明细
	 */
	private static void calAmt(BlAmtDTO allAmt, Map<String, BlAmtDTO> incAmtMap, List<BlCgIpDO> cgList) {

		// 初始化合计值
		allAmt.setAmt(FDouble.ZERO_DBL);
		allAmt.setAmt_pat(FDouble.ZERO_DBL);
		allAmt.setAmt_std(FDouble.ZERO_DBL);
		allAmt.setAmt_ratio(FDouble.ZERO_DBL);
		allAmt.setAmt_hp(FDouble.ZERO_DBL);
		allAmt.setAmt_free(FDouble.ZERO_DBL);

		for (BlCgIpDO itm : cgList) {

			BlAmtDTO incAmt = null;
			String key = String.format("%s,%s", itm.getCode_inccaitm(), itm.getName_inccaitm());
			if (incAmtMap.containsKey(key)) {
				incAmt = incAmtMap.get(key);
			} else {
				incAmt = new BlAmtDTO();
				incAmt.setAmt(FDouble.ZERO_DBL);
				incAmt.setAmt_pat(FDouble.ZERO_DBL);
				incAmt.setAmt_std(FDouble.ZERO_DBL);
				incAmt.setAmt_ratio(FDouble.ZERO_DBL);
				incAmt.setAmt_hp(FDouble.ZERO_DBL);
				incAmt.setAmt_free(FDouble.ZERO_DBL);

				incAmtMap.put(key, incAmt);
			}

			allAmt.setAmt(allAmt.getAmt().add(itm.getAmt().multiply(itm.getEu_direct())));
			allAmt.setAmt_std(allAmt.getAmt_std().add(itm.getAmt_std().multiply(itm.getEu_direct())));
			allAmt.setAmt_pat(allAmt.getAmt_pat().add(itm.getAmt_pat().multiply(itm.getEu_direct())));
			allAmt.setAmt_ratio(allAmt.getAmt_ratio().add(itm.getAmt_ratio().multiply(itm.getEu_direct())));
			allAmt.setAmt_hp(allAmt.getAmt_hp().add(itm.getAmt_hp().multiply(itm.getEu_direct())));

			incAmt.setAmt(incAmt.getAmt().add(itm.getAmt().multiply(itm.getEu_direct())));
			incAmt.setAmt_std(incAmt.getAmt_std().add(itm.getAmt_std().multiply(itm.getEu_direct())));
			incAmt.setAmt_pat(incAmt.getAmt_pat().add(itm.getAmt_pat().multiply(itm.getEu_direct())));
			incAmt.setAmt_ratio(incAmt.getAmt_ratio().add(itm.getAmt_ratio().multiply(itm.getEu_direct())));
			incAmt.setAmt_hp(incAmt.getAmt_hp().add(itm.getAmt_hp().multiply(itm.getEu_direct())));
		}
	}

	/**
	 * 组装发票主表数据
	 * 
	 * @param stDO
	 * @return
	 * @throws BizException
	 */
	private static BlIncIpDO assembleParentData(BlStIpDO stDO, BlAmtDTO amtDto) throws BizException {
		// 提前生成发票主键
		String[] incIds = new DBUtil().getOIDs(1);
		if (ArrayUtil.isEmpty(incIds)) {
			throw new BizException("生成发票主键失败");
		}
		String incId = incIds[0];

		BlIncIpDO inc = new BlIncIpDO();
		inc.setId_incip(incId);
		inc.setId_grp(Context.get().getGroupId());
		inc.setId_org(Context.get().getOrgId());
		inc.setId_pat(stDO.getId_pat());
		inc.setId_ent(stDO.getId_ent());
		inc.setId_stip(stDO.getId_stip());
		inc.setId_enttp(stDO.getId_enttp());
		inc.setCode_enttp(stDO.getCode_enttp());
		inc.setEu_direct(stDO.getEu_direct());
		inc.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);
		inc.setCode_incpkg(null);
		inc.setIncno(null);
		inc.setDt_inc(nowTime);
		inc.setAmt(amtDto.getAmt());
		inc.setAmt_std(amtDto.getAmt_std());
		inc.setAmt_pat(amtDto.getAmt_pat());
		inc.setAmt_ratio(amtDto.getAmt_ratio());
		inc.setAmt_hp(amtDto.getAmt_hp());
		inc.setId_emp_inc(null);
		String amtCapital = CapitalFiguresUtil.digitUppercase(amtDto.getAmt().doubleValue());// 发票金额描述信息(总金额的大写)
		inc.setNote(amtCapital);
		inc.setTimes_prn(new Integer(0));
		inc.setFg_print(FBoolean.FALSE);
		inc.setFg_canc(FBoolean.FALSE);
		inc.setFg_cc_out(FBoolean.FALSE);
		inc.setId_cc_out(null);
		inc.setFg_cc_in(FBoolean.FALSE);
		inc.setId_cc_in(null);
		inc.setEu_freemd(null);
		inc.setAmt_free(amtDto.getAmt_free());
		inc.setId_dep_inc(null);
		inc.setId_dep_canc(null);
		//inc.setInc_title(BlFlowContextUtil.getCustCmpyName());
		inc.setStatus(DOStatus.NEW);

		return inc;
	}

	/**
	 * 组装发票账单项数据
	 * 
	 * @param incAmtMap
	 * @return
	 * @throws BizException
	 */
	private static BlIncItmIpDO[] assembleIncItmData(Map<String, BlAmtDTO> incAmtMap) throws BizException {
		List<BlIncItmIpDO> list = new ArrayList<BlIncItmIpDO>();
		for (Entry<String, BlAmtDTO> entry : incAmtMap.entrySet()) {

			String[] codeName = entry.getKey().split(",");
			BlAmtDTO amtDto = entry.getValue();

			BlIncItmIpDO incItm = new BlIncItmIpDO();
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

		return list.toArray(new BlIncItmIpDO[0]);
	}

	/**
	 * 组装门急诊结算与发票关系数据
	 * 
	 * @param stDO
	 * @return
	 * @throws BizException
	 */
	private static BlStIncIpDO[] assembleStIncData(BlStIpDO stDO) throws BizException {
		BlStIncIpDO stInc = new BlStIncIpDO();
		stInc.setId_stip(stDO.getId_stip());
		stInc.setCode_hp(null);
		stInc.setFg_active(FBoolean.TRUE);
		stInc.setStatus(DOStatus.NEW);
		return new BlStIncIpDO[] { stInc };
	}

}
