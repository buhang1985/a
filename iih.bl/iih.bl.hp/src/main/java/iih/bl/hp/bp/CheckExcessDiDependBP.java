package iih.bl.hp.bp;

import iih.bd.base.utils.FBooleanUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.dto.d.DiDependDTO;
import iih.bl.hp.dto.d.DiStatsDTO;
import iih.bl.hp.hpque.bp.CheckSpecillBP;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.entplan.d.EntHpDO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 超量开药依赖检查
 * 
 * @author LIM
 *
 */
public class CheckExcessDiDependBP {
	private static final String KEY_DI_DIFFICALT_TO_MOVE = "行动不便";

	/**
	 * 
	 * @param id_ent
	 * @param diIds
	 *            删除诊断
	 * @param diIdsAll
	 *            所有诊断
	 * @return
	 * @throws BizException
	 */
	public DiDependDTO[] exec(String id_ent, String[] diIds, String[] diIdsAll) throws BizException {
		DiDependDTO[] diDependDTO = new DiDependDTO[] {};
		List<DiDependDTO> list = new ArrayList<DiDependDTO>();
		FArrayList2 diagDefDOList = new FArrayList2();
		FArrayList2 diagDefDODelList = new FArrayList2();

		// 1.获取医嘱所有信息
		HashMap<String, CiOrderDO> orderMap = new HashMap<String, CiOrderDO>();
		HashMap<String, OrdSrvDO> orsrvMap = new HashMap<String, OrdSrvDO>();
		HashMap<String, OrdSrvMmDO> ormmMap = new HashMap<String, OrdSrvMmDO>();
		GetCiorderDTOByEntBP getCiorderDTOByEntBP = new GetCiorderDTOByEntBP();
		getCiorderDTOByEntBP.exec(id_ent, orderMap, orsrvMap, ormmMap);
		// 如果医嘱下没有物品，则不再判断
		if (ormmMap.size() <= 0) {
			return new DiDependDTO[] {};
		}

		// 2.查询本次删除诊断明细
		IDiagdefMDORService ser = ServiceFinder.find(IDiagdefMDORService.class);
		DiagDefDO[] diagDefDODel = ser.findByAttrValStrings(DiagDefDO.CODE, diIds);
		if (diagDefDODel.length > 0) {
			for (DiagDefDO itm : diagDefDODel) {
				diagDefDODelList.add(itm);
			}
		}
		// 3.查询本次删除后剩余诊断明细
		// 判断是否删除所有诊断
		// Arrays.equals(diIds,diIdsAll)
		if (diIdsAll.length <= 0) {
			if (orderMap.size() > 0) {// 医嘱不为空
				// 如果剩余医嘱为空，则提示不能删除
				CiOrderDO ciOrderDO = new CiOrderDO();
				OrdSrvDO ordSrvDO = new OrdSrvDO();
				OrdSrvMmDO ordSrvMmDO = new OrdSrvMmDO();
				DiDependDTO diDependDO = new DiDependDTO();
				for (DiagDefDO itm : diagDefDODel) {
					SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();
					diDependDO = setDiDependDTOBP.exec(itm, ciOrderDO, ordSrvDO, ordSrvMmDO, IBlMsgConst.ERROR_DEPEND);
					if (diDependDO != null) {
						list.add(diDependDO);
					}
				}
				return list.toArray(new DiDependDTO[] {});
			} else {
				return new DiDependDTO[] {};
			}
		} else {
			// 查询删除后剩余诊断信息
			DiagDefDO[] diagDefDO = ser.findByAttrValStrings(DiagDefDO.CODE, diIdsAll);
			if (diagDefDO.length > 0) {
				for (DiagDefDO itm : diagDefDO) {
					diagDefDOList.add(itm);
				}
			}
		}

		// 4.调用校验
		diDependDTO = CheckOpBillDaysRule(id_ent, diagDefDOList, diagDefDODelList, orderMap, orsrvMap, ormmMap);

		return diDependDTO;
	}

	/**
	 * 
	 * @param id_ent
	 *            就诊id
	 * @param cidiagItemList
	 *            剩余诊断
	 * @param cidiagItemDelList
	 *            删除诊断
	 * @param orderMap
	 *            医嘱
	 * @param orsrvMap
	 *            服务
	 * @param ormmMap
	 *            物品
	 * @return
	 * @throws BizException
	 */
	private DiDependDTO[] CheckOpBillDaysRule(String id_ent, FArrayList2 diagDefDOList, FArrayList2 diagDefDODelList, HashMap<String, CiOrderDO> orderMap, HashMap<String, OrdSrvDO> orsrvMap, HashMap<String, OrdSrvMmDO> ormmMap) throws BizException {
		List<DiDependDTO> list = new ArrayList<DiDependDTO>();
		// 1.获取医保计划
		GetMainHpDOBP getMainHpDO = new GetMainHpDOBP();
		EntHpDO mainHpDO = getMainHpDO.exec(id_ent);
		if (mainHpDO == null) {
			return null;
		}
		// 2、通过参数，获取校验天数的限制值
		int haveDays_mxb = BlParams.BLHP000007();// 开单天数默认30天
		int haveDays_xdbb = BlParams.BLHP000008();// 行动不便开单天数默认14天
		int haveDays = BlParams.BLHP000009();// 开单天数 > 7
		// 3、分析诊断
		AnalysisDiBP analysisDi = new AnalysisDiBP();
		DiStatsDTO diStatsDTO = analysisDi.exec(diagDefDOList);
		// 4.开始校验
		Iterator<Entry<String, OrdSrvDO>> iter = orsrvMap.entrySet().iterator();
		while (iter.hasNext()) {
			String strKey;
			Entry<String, OrdSrvDO> itm = iter.next();
			OrdSrvDO ordSrvDO = itm.getValue();
			strKey = ordSrvDO.getId_or();
			CiOrderDO ciOrderDO = orderMap.get(strKey);
			strKey = ordSrvDO.getId_orsrv();
			OrdSrvMmDO ordSrvMmDO = ormmMap.get(strKey);
			DiDependDTO[] diDependDTO = new DiDependDTO[] {};

			// 只校验西药、草药
			if (!ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) && !ordSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {
				continue;
			}
			// 是否特殊病
			CheckSpecillBP checkSpecillBP = new CheckSpecillBP();
			FBoolean isSpecill = checkSpecillBP.exec(ordSrvMmDO.getId_mm(), ciOrderDO.getId_en(), diagDefDOList);
			// (工伤医保,特病医保) || 诊断是慢性病）
			if (IBdPpCodeTypeConst.SD_HP_BJ_KIND_INSUR.equals(mainHpDO.getCode_hpkind()) || FBooleanUtils.isTrue(isSpecill) || FBooleanUtils.isTrue(diStatsDTO.getFg_haschronic())) {
				if (ciOrderDO.getDays_or() > haveDays_mxb) {
					diDependDTO = this.setDiDependDTOBPByFgChronic(diagDefDODelList, haveDays_mxb, ciOrderDO, ordSrvDO, ordSrvMmDO);
				}
			} else if (FBooleanUtils.isTrue(diStatsDTO.getFg_hasmovediff())) {
				// 行动不便
				// 先判断是否存在>14天医嘱，如果存在14天医嘱则查询删除的诊断中的慢病
				if (ciOrderDO.getDays_or() > haveDays_xdbb) {
					diDependDTO = this.setDiDependDTOBPByFgChronic(diagDefDODelList, haveDays_xdbb, ciOrderDO, ordSrvDO, ordSrvMmDO);
				}
			} else if (ciOrderDO.getDays_or() > haveDays) {
				// 普通7天

				// 先判断是否存在>14天医嘱，如果存在14天医嘱则查询删除的诊断中的慢病
				// if (ciOrderDO.getDays_or() > haveDays_xdbb) {
				// diDependDTO =
				// this.setDiDependDTOBPByFgChronic(diagDefDODelList,haveDays_xdbb,ciOrderDO,
				// ordSrvDO, ordSrvMmDO);
				// }
				// 先判断是否存在>7天并且<14天医嘱，如果存在则查询行动不便
				// if (ciOrderDO.getDays_or() > haveDays &&
				// ciOrderDO.getDays_or() <=haveDays_xdbb) {
				// diDependDTO =
				// this.setDiDependDTOBPByDiffMove(diagDefDODelList,haveDays_xdbb,ciOrderDO,
				// ordSrvDO, ordSrvMmDO);
				// 如果不存在行动不便，则提示全部
				// if(diDependDTO.length<=0){
				SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();
				DiagDefDO diagDefDO = new DiagDefDO();
				DiDependDTO diDependDO = new DiDependDTO();
				FArrayList2 mmlist = new FArrayList2();
				mmlist.add(ordSrvMmDO);
				String errorMsg = BlMsgUtils.GetCheckMsg(ciOrderDO.getName_or(), mmlist, haveDays, ciOrderDO.getDays_or());
				diDependDO = setDiDependDTOBP.exec(diagDefDO, ciOrderDO, ordSrvDO, ordSrvMmDO, errorMsg);
				if (!StringUtil.isEmpty(diDependDO.getDesc_dpndrsn())) {
					List diDependDTOList = Arrays.asList(diDependDO);
					list.addAll(diDependDTOList);
				}
				// }
				// }
			}
			if (diDependDTO != null && diDependDTO.length > 0) {
				List diDependDTOList = Arrays.asList(diDependDTO);
				list.addAll(diDependDTOList);
			}

		}
		return list.toArray(new DiDependDTO[] {});
	}

	/**
	 * 慢病校验
	 * 
	 * @param cidiagItemDelList
	 * @param haveDays_mxb
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param ordSrvMmDO
	 * @return
	 * @throws BizException
	 */
	private DiDependDTO[] setDiDependDTOBPByFgChronic(FArrayList2 diagDefDODelList, int haveDays_mxb, CiOrderDO ciOrderDO, OrdSrvDO ordSrvDO, OrdSrvMmDO ordSrvMmDO) throws BizException {
		List<DiDependDTO> list = new ArrayList<DiDependDTO>();
		DiDependDTO diDependDTO = new DiDependDTO();
		SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();
		FArrayList2 mmlist = new FArrayList2();
		mmlist.add(ordSrvMmDO);
		String errorMsg = BlMsgUtils.getChronicOrSpecExcessMsg(ciOrderDO.getName_or(), mmlist, haveDays_mxb, ciOrderDO.getDays_or(), IBdSrvDictCodeConst.DAYS_UNIT);
		// 查询删除的诊断中是否存在慢病诊断
		for (Object obj : diagDefDODelList) {
			DiagDefDO diagDefDO = (DiagDefDO) obj;
			// 如果是慢病
			if (FBooleanUtils.isTrue(diagDefDO.getFg_chronic())) {
				diDependDTO = setDiDependDTOBP.exec(diagDefDO, ciOrderDO, ordSrvDO, ordSrvMmDO, errorMsg);
			}
			// 如果没有慢病诊断 直接返回 防止 开立诊断时是慢病， 将诊断档案的慢病诊断再取消 ，然后再去删除诊断
			if (diDependDTO != null && !StringUtil.isEmpty(diDependDTO.getCode_di())) {
				list.add(diDependDTO);
			}
		}
		return list.toArray(new DiDependDTO[] {});
	}

	/**
	 * 行动不便
	 * 
	 * @param cidiagItemDelList
	 * @param haveDays_mxb
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param ordSrvMmDO
	 * @return
	 * @throws BizException
	 */
	private DiDependDTO[] setDiDependDTOBPByDiffMove(FArrayList2 diagDefDODelList, int haveDays_mxb, CiOrderDO ciOrderDO, OrdSrvDO ordSrvDO, OrdSrvMmDO ordSrvMmDO) throws BizException {
		List<DiDependDTO> list = new ArrayList<DiDependDTO>();
		DiDependDTO diDependDTO = new DiDependDTO();
		SetDiDependDTOBP setDiDependDTOBP = new SetDiDependDTOBP();
		FArrayList2 mmlist = new FArrayList2();
		mmlist.add(ordSrvMmDO);
		String errorMsg = BlMsgUtils.getDiffToMoveMsgExcessMsg(ciOrderDO.getName_or(), mmlist, haveDays_mxb, ciOrderDO.getDays_or(), IBdSrvDictCodeConst.DAYS_UNIT);
		// 查询删除的诊断中是否存在慢病诊断
		for (Object obj : diagDefDODelList) {
			DiagDefDO diagDefDO = (DiagDefDO) obj;
			// 如果是行动不便
			if (!StringUtil.isEmpty(diagDefDO.getName()) && diagDefDO.getName().contains(KEY_DI_DIFFICALT_TO_MOVE)) {
				diDependDTO = setDiDependDTOBP.exec(diagDefDO, ciOrderDO, ordSrvDO, ordSrvMmDO, errorMsg);
			}
			if (diDependDTO != null && !StringUtil.isEmpty(diDependDTO.getCode_di())) {
				list.add(diDependDTO);
			}
		}
		return list.toArray(new DiDependDTO[] {});
	}
}
