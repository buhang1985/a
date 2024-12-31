package iih.bl.inc.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.dto.blcgprinfo.d.BlCgPrInfoDTO;
import iih.bl.comm.util.BlSqlQueryUtil;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取发票明细
 * @author hanjq 下午4:49:53
 *
 */
public class IncItmBP {

	
	public BlStReFundBillDTO[] exec(String[] incOepIds) throws BizException {
		return GetBlStReFundBillDTO(incOepIds);
	}
	
	private BlStReFundBillDTO[] GetBlStReFundBillDTO(String[] incOepIds) throws BizException {
		
		DAFacade daf = new DAFacade();
		SqlParam sqlparam = new SqlParam();
		String tempSql = getQrySQLStr(incOepIds,sqlparam);
		
		List<BlStReFundBillDTO> list = (List<BlStReFundBillDTO>) daf.execQuery(tempSql, sqlparam,new BeanListHandler(BlStReFundBillDTO.class));
		if(list == null || list.size() == 0){
			return null;
		}
		BlStReFundBillDTO[] blStReFundBillDTOs = list.toArray(new BlStReFundBillDTO[0]);

		//补充订单信息
		//this.addApplyInfo(blStReFundBillDTOs);
		
		// id_or的集合(调用查询执行信息的入参)
		List<String> ordIdList = new ArrayList<String>();

		// 1调用药品接口，获得可退数量
		List<String> Refund_mm_id_orsrv = new ArrayList<String>();
		List<OpDgRtnAmountDTO> opDgRtnAmountDTOLst = new ArrayList<OpDgRtnAmountDTO>();

		for (int i = 0; i < blStReFundBillDTOs.length; i++) {
			// 判断是否是物品 药品
			if (blStReFundBillDTOs[i].getSd_srvtp() != null && blStReFundBillDTOs[i].getSd_srvtp().indexOf("01") == 0) {
				Refund_mm_id_orsrv.add(blStReFundBillDTOs[i].getId_orsrv());
				OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
				opDgRtnAmountDTO.setId_orsrv(blStReFundBillDTOs[i].getId_orsrv());
				opDgRtnAmountDTO.setCharged_amount(blStReFundBillDTOs[i].getQuan());
				opDgRtnAmountDTOLst.add(opDgRtnAmountDTO);
			} else {
				// 医技
				if (blStReFundBillDTOs[i].getFg_feertnable() != null
						&& !blStReFundBillDTOs[i].getFg_feertnable().booleanValue()) {
					blStReFundBillDTOs[i].setCan_quan(new FDouble(0));
				}
				if (!StringUtil.isEmpty(blStReFundBillDTOs[i].getId_or())) {
					ordIdList.add(blStReFundBillDTOs[i].getId_or());
				}
			}
		}

		if (!ListUtil.isEmpty(ordIdList)) {
			// 给非药品医嘱的执行人员和执行状态赋值
			BlCgPrInfoDTO[] blCgPrInfoDTOs = BlSqlQueryUtil.getOrdPrInfo(ordIdList.toArray(new String[] {}));
			for (BlStReFundBillDTO itm : blStReFundBillDTOs) {
				if (!ArrayUtil.isEmpty(blCgPrInfoDTOs)) {
					for (BlCgPrInfoDTO itmChild : blCgPrInfoDTOs) {
						if (!StringUtil.isEmpty(itm.getId_or())) {
							if (itm.getId_or().equals(itmChild.getId_or())) {
								itm.setName_emp_cg(itmChild.getName_emp_mp());
								itm.setName_su_mp(itmChild.getName_eusu());
								break;
							}
						}
					}
				}
			}
		}

		// TODO 此方法可以优化为 map 可以减少一次循环
		// 2.调用物品域接口 设置可退数量与 是否领药的状态
		if (opDgRtnAmountDTOLst.size() > 0) {
			IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
			OpDgRtnAmountDTO[] opDgRtnAmountDTOs = iMpDgOutService
					.getOpDgRtnAmount(opDgRtnAmountDTOLst.toArray(new OpDgRtnAmountDTO[0]));

			if (opDgRtnAmountDTOs != null && opDgRtnAmountDTOs.length > 0) {
				for (int i = 0; i < blStReFundBillDTOs.length; i++) {
					if (blStReFundBillDTOs[i].getSd_srvtp() != null
							&& blStReFundBillDTOs[i].getSd_srvtp().indexOf("01") > -1) {
						for (int j = 0; j < opDgRtnAmountDTOs.length; j++) {
							if (opDgRtnAmountDTOs[j].getId_orsrv().equals(blStReFundBillDTOs[i].getId_orsrv())) {
								// 设置可退数
								blStReFundBillDTOs[i].setCan_quan(opDgRtnAmountDTOs[j].getRtn_amount());
								// 是否领药
								if (opDgRtnAmountDTOs[j].getFg_get().booleanValue()) {
									blStReFundBillDTOs[i].setFg_pat_getmm(FBoolean.TRUE); // 已领药
								} else {
									blStReFundBillDTOs[i].setFg_pat_getmm(FBoolean.FALSE); // 未发药
								}

								// 药品医嘱设置执行状态
								if (blStReFundBillDTOs[i].getCan_quan() == FDouble.ZERO_DBL) {
									blStReFundBillDTOs[i].setName_su_mp("已领用，不可退");
									// 药品医嘱设置执行人员（发药人员）
									blStReFundBillDTOs[i].setName_emp_cg(opDgRtnAmountDTOs[j].getName_emp_dp());// 物品接口返回
								} else if (!blStReFundBillDTOs[i].getFg_pat_getmm().booleanValue()) {
									blStReFundBillDTOs[i].setName_su_mp("未领用");
									// 药品医嘱设置执行人员（发药人员）
									blStReFundBillDTOs[i].setName_emp_cg("");// 物品接口返回
								} else {
									blStReFundBillDTOs[i].setName_su_mp("已退药");
									// 药品医嘱设置执行人员（发药人员）
									blStReFundBillDTOs[i].setName_emp_cg("");// 物品接口返回
								}
								break;
							}
						}
					}
				}
			}
			// //记日志，便于查询
			// BlCgLogsRecordUtil.setIBlCgLogsRecordService(ServiceFinder.find(IBlCgLogsRecordService.class));
			// BlCgLogsRecordUtil.getIBlCgLogsRecordService().recordBlCgVsMMLogs(timeService.getUFDateTime(),info.toString());
		}

		return blStReFundBillDTOs;
	}
	
	/**
	 * 补充单据信息
	 * 
	 * @param orDtos
	 * @throws BizException
	 */
//	private void addApplyInfo(BlStReFundBillDTO[] orDtos) throws BizException {
//
//		Set<String> drugOrsrvSet = new HashSet<String>();// 药品
//		Set<String> risOrSet = new HashSet<String>(); // 检查
//		Set<String> lisOrSet = new HashSet<String>(); // 检验
//		Set<String> bingliOrSet = new HashSet<String>(); // 病理
//		Set<String> otherOrsrvSet = new HashSet<String>(); // 其他
//
//		for (BlStReFundBillDTO orDto : orDtos) {
//
//			// 暂时只处理原医嘱数据
//			if (StringUtil.isEmpty(orDto.getId_or()) || StringUtil.isEmpty(orDto.getId_orsrv()))
//				continue;
//
//			if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
//				drugOrsrvSet.add(orDto.getId_orsrv());
//			} else if (IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI.equals(orDto.getSd_srvtp())) {
//				bingliOrSet.add(orDto.getId_or());
//			} else if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
//				risOrSet.add(orDto.getId_or());
//			} else if (orDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {
//				lisOrSet.add(orDto.getId_or());
//			} else {
//				otherOrsrvSet.add(orDto.getId_orsrv());
//			}
//		}
//
//		Map<String, BlCgApplyDTO> applyMap = new HashMap<String, BlCgApplyDTO>();
//
//		if (drugOrsrvSet.size() > 0) {
//			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getPresCode(drugOrsrvSet.toArray(new String[0]));
//			if (!ArrayUtil.isEmpty(applyDtos)) {
//				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
//					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
//				}
//			}
//		}
//
//		if (risOrSet.size() > 0) {
//			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getRisCode(risOrSet.toArray(new String[0]));
//			if (!ArrayUtil.isEmpty(applyDtos)) {
//				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
//					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
//				}
//			}
//		}
//
//		if (lisOrSet.size() > 0) {
//			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getLisCode(lisOrSet.toArray(new String[0]));
//			if (!ArrayUtil.isEmpty(applyDtos)) {
//				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
//					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
//				}
//			}
//		}
//
//		if (bingliOrSet.size() > 0) {
//			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getBingliCode(bingliOrSet.toArray(new String[0]));
//			if (!ArrayUtil.isEmpty(applyDtos)) {
//				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
//					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
//				}
//			}
//		}
//
//		if (otherOrsrvSet.size() > 0) {
//			BlCgApplyDTO[] applyDtos = BlSqlQueryUtil.getOtherPrnCode(otherOrsrvSet.toArray(new String[0]));
//			if (!ArrayUtil.isEmpty(applyDtos)) {
//				for (BlCgApplyDTO blCgApplyDTO : applyDtos) {
//					applyMap.put(blCgApplyDTO.getId_key(), blCgApplyDTO);
//				}
//			}
//		}
//
//		// 单据信息
//		for (BlStReFundBillDTO orDto : orDtos) {
//			if (!StringUtil.isEmpty(orDto.getId_or()) && !StringUtil.isEmpty(orDto.getId_orsrv())) {
//
//				BlCgApplyDTO applyDto = applyMap.get(orDto.getId_or());
//				if (applyDto == null) {
//					applyDto = applyMap.get(orDto.getId_orsrv());
//				}
//
//				if (applyDto != null) {
//					orDto.setApplyno(applyDto.getApplyno());
//					orDto.setCode_bill(applyDto.getApplyno());// TODO
//				}
//			}
//		}
//	}

	
	private String getQrySQLStr(String[] incOepIds,  SqlParam sqlparam ) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT ");
		sql.append(" CGITEM.id_pat, ");
		sql.append(" CGITEM.id_ent, ");
		sql.append(" DEP.NAME name_dep_mp, ");
		sql.append(" CIORDER.DES_OR, ");
		sql.append(" CGITEM.id_or, ");
		sql.append(" CGITEM.name_srv, ");
		sql.append(" NVL (CGITEM.CODE_MM, CGITEM.CODE_SRV) code_srv, ");
		sql.append(" CGITEM.sd_srvtp, ");
		sql.append(" '' can_return, ");
		//添加补费数据默认可退
		sql.append(" (CASE CGITEM.FG_ADDITM WHEN 'Y' THEN CGITEM.FG_ADDITM ELSE CIORDERSRV.fg_feertnable END) fg_feertnable, ");
		sql.append(" CGITEM.srvu, ");
		sql.append(" MEASDOC. NAME srvu_name, ");
		sql.append(" CGITEM.price, ");
		sql.append(" CGITEM.price_ratio, ");
		sql.append(" 0 return_quan, ");
		sql.append(" CGITEM.quan can_quan, ");
		sql.append(" CGITEM.quan, ");
		sql.append(" CGITEM.onlycode, ");
		sql.append(" CGITEM.amt, ");
		sql.append(" CGITEM.amt_std, ");
		sql.append(" CGITEM.amt_ratio, ");
		sql.append(" CGITEM.amt_pat, ");
		sql.append(" CGITEM.sd_hpsrvtp, ");
		sql.append(" CGITEM.id_hp, ");
		sql.append(" CGITEM.ratio_hp, ");
		sql.append(" CGITEM.amt_hp, ");
		sql.append(" CGITEM.fg_hp, ");
		sql.append(" CIORDERSRV.fg_specill fg_hpspcl, ");
		sql.append(" CGITEM.id_pres, ");
		sql.append(" CGITEM.id_cgitmoep, ");
		sql.append(" CGITEM.id_cgoep, ");
		sql.append(" CGITEM.Id_hpsrvmpayratio, ");
		// 设置单据分组数据----
		sql.append(" (DECODE(CGITEM.code_applytp, ");
		sql.append("'" + IBdSrvDictCodeConst.DRUG_TYPE + "','药品'");
		sql.append(",'" + IBdSrvDictCodeConst.RIS_TYPE + "','检查'");
		sql.append(",'" + IBdSrvDictCodeConst.LIS_TYPE + "','检验'");
		sql.append(",'" + IBdSrvDictCodeConst.TREATMENT_TYPE + "','诊疗'");
		sql.append(", '诊疗')||'\n'||'就诊次数:'||ENTOP.TIMES_OP||'\n'||'单据号:'||CGITEM.code_apply) code_apply,");
		// ---------------
		sql.append(" CGITEM.id_stoep, ");
		sql.append(" CGITEM.ratio_pripat, ");
		sql.append(" CGITEM.fg_mm, ");
		sql.append(" '' fg_pat_getmm, ");
		sql.append(" CGITEM.id_orsrv, ");
		sql.append(" CGITEM.id_mm, ");
		sql.append(" CGITEM.id_srv, ");
		sql.append(" CGITEM.pgku_cur Req_unit_id, ");
		//sql.append(" CGITEM.id_dep_mp Id_dep, ");
		sql.append(" CGITEM.id_dep_wh Id_dep_wh, ");
		sql.append(" CGITEM.fg_free, ");
		sql.append(" CGITEM.code_mm, ");
		sql.append(" CGITEM.name_mm, ");
		sql.append(" CGITEM.spec, ");
		sql.append(" CGITEM.dt_or, ");
		sql.append(" CGITEM.id_emp_or, ");
		sql.append(" PSN.code code_emp_or, ");
		sql.append(" PSN.name name_emp_or, ");
		sql.append(" CGITEM.id_dep_or, ");
		sql.append(" CGITEM.id_dep_mp, ");
		sql.append(" CGITEM.id_dep_phy, ");
		sql.append(" DEP2.name name_dep_phy, ");
		sql.append(" CGITEM.PGKU_CUR id_pgku_cur, ");
		sql.append(" CGITEM.CODE_INCCAITM , ");
		sql.append(" CGITEM.name_INCCAITM , ");
		
		sql.append(" inc_itm.id_incoep Id_inccaitm, ");
		
		sql.append(" ordep.code code_dep_or, ");
		sql.append(" ordep.name name_dep_or ");
		
		sql.append(" FROM  ");
		sql.append(" BL_CG_ITM_OEP CGITEM ");
		
		sql.append(" INNER JOIN bl_inc_cg_itm_oep inc_itm ON CGITEM.id_cgitmoep = inc_itm.id_cgitmoep ");
		
		sql.append(" INNER JOIN BD_DEP DEP ON CGITEM.id_dep_mp = DEP.id_dep ");
		sql.append(" LEFT JOIN BD_DEP DEP2 ON CGITEM.id_dep_phy = DEP2.id_dep ");
		sql.append(" LEFT JOIN BD_PSNDOC PSN ON CGITEM.id_emp_or = PSN.id_psndoc ");
		sql.append(" LEFT OUTER JOIN CI_ORDER CIORDER ON CGITEM.id_or = CIORDER.ID_OR ");
		sql.append(" LEFT OUTER JOIN ci_or_srv CIORDERSRV ON CGITEM.Id_Orsrv = CIORDERSRV.Id_Orsrv ");
		sql.append(" LEFT OUTER JOIN bd_measdoc MEASDOC ON CGITEM.srvu = MEASDOC.id_measdoc ");
		sql.append(" LEFT OUTER JOIN EN_ENT_OP ENTOP ON CGITEM.id_ent = ENTOP.id_ent ");
		sql.append(" left join bd_dep ordep on ordep.id_dep=cgitem.id_dep_or ");
		sql.append(" WHERE 1=1 ");
		if(incOepIds != null && incOepIds.length> 0){
			if(incOepIds.length == 1){
				sql.append(" AND inc_itm.id_incoep = ?");
				sqlparam.addParam(incOepIds[0]);
			}else{
				sql.append(" AND inc_itm.id_incoep in (");
				String dh = "";
				for(String incOepId:incOepIds){
					sql.append(dh).append(" ? ");
					dh= ",";
					sqlparam.addParam(incOepId);
				}
				
				sql.append(" )");
			}
		}
		sql.append(" ORDER BY ");
		sql.append(" inc_itm.id_incoep,");
		sql.append(" CGITEM.ID_OR, ");
		sql.append(" CGITEM.ID_ORSRV, ");
		sql.append(" CGITEM.ONLYCODE, ");
		sql.append(" CGITEM.sd_srvtp ");
		return sql.toString();
	}
}
