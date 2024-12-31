package iih.ci.ord.s.external.provide.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.iemsg.d.AddSugDTO;
import iih.ci.ord.iemsg.d.SugApplyInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.external.provide.qry.CiIpAddSugInfoQry;
import iih.ci.ord.s.external.provide.qry.CiIpSugEmpInfoQry;
import iih.ci.ord.s.external.provide.qry.CiIpSugMmInfoQry;
import iih.ci.ord.s.external.provide.qry.CiIpSugOrInfoQry;
import iih.ci.ord.s.external.provide.qry.CiIpSugViewItemInfoQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpSugInfoBp {

	/**
	 * 
	 * @param id_pat
	 *            患者id
	 * @param id_ent
	 *            就诊id
	 * @param dt_b
	 *            查询开始时间
	 * @param dt_e
	 *            查询结束时间
	 * @param id_dep_mp
	 *            执行科室
	 * @param code_entp
	 *            就诊类型
	 * @param fg_aptapp1
	 *            是否已预约标志
	 * @param fg_confirm
	 *            是否已确认标志
	 * @return
	 * @throws BizException
	 */
	public List<SugApplyInfoDTO> exec(String id_pat, String id_ent, String dt_b, String dt_e, String id_dep_mp,
			String code_entp, String fg_aptapp1, String fg_confirm) throws BizException {
		
		// 查询并获得返回值
		CiIpSugOrInfoQry qry = new CiIpSugOrInfoQry(id_pat, id_ent, dt_b, dt_e, id_dep_mp, code_entp, fg_aptapp1,
				fg_confirm);
		String sql = qry.getQrySQLStr();
		SqlParam param = qry.getQryParameter(new StringBuffer());
		List<Map<String, Object>> maps = CiOrdUtils.getRsMapList(sql, param);
		List<SugApplyInfoDTO> sugOrlist = new ArrayList<>();
		for (Map<String, Object> map2 : maps) {
			SugApplyInfoDTO ieOpOrEnDTO = new SugApplyInfoDTO();
			setSugOrInfo8Map(ieOpOrEnDTO, map2);

			sugOrlist.add(ieOpOrEnDTO);
		}

		return sugOrlist;
	}

	/**
	 * 手术申请集合
	 * 
	 * @param ieOpOrEnDTO
	 * @param map
	 * @throws BizException
	 */
	private void setSugOrInfo8Map(SugApplyInfoDTO ieOpOrEnDTO, Map<String, Object> map) throws BizException {

		ieOpOrEnDTO.setPatientid(CiOrdUtils.nullHandle(map.get("patientid")));
		ieOpOrEnDTO.setName(CiOrdUtils.nullHandle(map.get("name")));
		ieOpOrEnDTO.setSexid(CiOrdUtils.nullHandle(map.get("sexid")));
		ieOpOrEnDTO.setSexcode(CiOrdUtils.nullHandle(map.get("sexcode")));
		ieOpOrEnDTO.setBirthdaydate(CiOrdUtils.nullHandle(map.get("birthdaydate")));// 出生日期
		ieOpOrEnDTO.setId_ent(CiOrdUtils.nullHandle(map.get("id_ent")));
		ieOpOrEnDTO.setCode_ent(CiOrdUtils.nullHandle(map.get("code_ent")));
		ieOpOrEnDTO.setCode_entp(CiOrdUtils.nullHandle(map.get("code_entp")));
		ieOpOrEnDTO.setCode_amr_ip(CiOrdUtils.nullHandle(map.get("code_amr_ip")));
		ieOpOrEnDTO.setId_bed(CiOrdUtils.nullHandle(map.get("id_bed")));
		ieOpOrEnDTO.setName_bed(CiOrdUtils.nullHandle(map.get("name_bed")));
		ieOpOrEnDTO.setId_or(CiOrdUtils.nullHandle(map.get("id_or")));
		ieOpOrEnDTO.setId_srv(CiOrdUtils.nullHandle(map.get("id_srv")));
		ieOpOrEnDTO.setCode_srv(CiOrdUtils.nullHandle(map.get("code_srv")));
		ieOpOrEnDTO.setName_or(CiOrdUtils.nullHandle(map.get("name_or")));
		ieOpOrEnDTO.setCode_or(CiOrdUtils.nullHandle(map.get("code_or")));
		ieOpOrEnDTO.setContent_or(CiOrdUtils.nullHandle(map.get("content_or")));
		ieOpOrEnDTO.setDes_or(CiOrdUtils.nullHandle(map.get("des_or")));
		ieOpOrEnDTO.setSd_su_or(CiOrdUtils.nullHandle(map.get("sd_su_or")));
		ieOpOrEnDTO.setDt_entry(CiOrdUtils.nullHandle(map.get("dt_entry")));
		ieOpOrEnDTO.setId_emp_sign(CiOrdUtils.nullHandle(map.get("id_emp_sign")));
		ieOpOrEnDTO.setId_dep_sign(CiOrdUtils.nullHandle(map.get("id_dep_sign")));
		ieOpOrEnDTO.setDt_effe(CiOrdUtils.nullHandle(map.get("dt_effe")));
		ieOpOrEnDTO.setFg_urgent(CiOrdUtils.nullHandle(map.get("fg_urgent")));
		ieOpOrEnDTO.setId_dep_mp(CiOrdUtils.nullHandle(map.get("id_dep_mp")));
		ieOpOrEnDTO.setNo_applyform(CiOrdUtils.nullHandle(map.get("id_dep_mp")));
		ieOpOrEnDTO.setName_diag(CiOrdUtils.nullHandle(map.get("name_diag")));
		ieOpOrEnDTO.setFg_new_sug(CiOrdUtils.nullHandle(map.get("fg_new_sug")));
		ieOpOrEnDTO.setId_lvlsug(CiOrdUtils.nullHandle(map.get("id_lvlsug")));
		ieOpOrEnDTO.setSd_lvlsug(CiOrdUtils.nullHandle(map.get("sd_lvlsug")));
		ieOpOrEnDTO.setId_anestp(CiOrdUtils.nullHandle(map.get("Id_anestp")));
		ieOpOrEnDTO.setSd_anestp(CiOrdUtils.nullHandle(map.get("sd_anestp")));
		ieOpOrEnDTO.setFg_allergy(CiOrdUtils.nullHandle(map.get("fg_allergy")));
		ieOpOrEnDTO.setFg_patho(CiOrdUtils.nullHandle(map.get("fg_patho")));
		ieOpOrEnDTO.setId_su_op(CiOrdUtils.nullHandle(map.get("id_su_op")));
		ieOpOrEnDTO.setSd_su_op(CiOrdUtils.nullHandle(map.get("sd_su_op")));
		ieOpOrEnDTO.setQuan_bt_paln(CiOrdUtils.nullHandle(map.get("quan_bt_paln")));
		ieOpOrEnDTO.setId_emp_operate(CiOrdUtils.nullHandle(map.get("id_emp_operate")));
		ieOpOrEnDTO.setId_emp_helper(CiOrdUtils.nullHandle(map.get("id_emp_helper")));
		ieOpOrEnDTO.setId_sugbody(CiOrdUtils.nullHandle(map.get("id_sugbody")));
		ieOpOrEnDTO.setSd_sugbody(CiOrdUtils.nullHandle(map.get("sd_sugbody")));
		ieOpOrEnDTO.setSpecialreq(CiOrdUtils.nullHandle(map.get("specialreq")));
		ieOpOrEnDTO.setSpecialinstrument(CiOrdUtils.nullHandle(map.get("specialinstrument")));
		ieOpOrEnDTO.setSpecialdes(CiOrdUtils.nullHandle(map.get("specialdes")));
		ieOpOrEnDTO.setFg_xq_sug(CiOrdUtils.nullHandle(map.get("fg_xq_sug")));
		ieOpOrEnDTO.setFg_zq_sug(CiOrdUtils.nullHandle(map.get("fg_zq_sug")));
		ieOpOrEnDTO.setFg_er_sug(CiOrdUtils.nullHandle(map.get("fg_er_sug")));
		ieOpOrEnDTO.setFg_daysug(CiOrdUtils.nullHandle(map.get("fg_daysug")));
		ieOpOrEnDTO.setId_ieoporen(CiOrdUtils.nullHandle(map.get("id_ieoporen")));
		ieOpOrEnDTO.setApply_dept_name(CiOrdUtils.nullHandle(map.get("apply_dept_name")));//申请科室名称
		ieOpOrEnDTO.setExec_dept_name(CiOrdUtils.nullHandle(map.get("exec_dept_name")));//执行科室名称
		// 手术人员集合
		FArrayList2 faIesugors = new FArrayList2();
		FArrayList2 faIesugors1 = new FArrayList2();
		FArrayList2 faIesugors2 = new FArrayList2();
		FArrayList2 faIesugors3 = new FArrayList2();
		sendSugInfo4ScAptAppl(map, faIesugors, faIesugors1, faIesugors2, faIesugors3);
		ieOpOrEnDTO.setOrdaddsugs(faIesugors);// 附加手术集合
		ieOpOrEnDTO.setOrdopemps(faIesugors1);// 手术人员集合
		ieOpOrEnDTO.setOrdapsugviewitems(faIesugors2);// 动态指标集合
		ieOpOrEnDTO.setOrdopmms(faIesugors3);// 手术卫材集合

	}

	/**
	 * 
	 * @param map
	 * @throws BizException
	 */
	private void sendSugInfo4ScAptAppl(Map<String, Object> map, FArrayList2 faIesugors, FArrayList2 faIesugors1,
			FArrayList2 faIesugors2, FArrayList2 faIesugors3) throws BizException {

		String idOr = (String) map.get("id_or");
		// 获取附加手术集合
		CiIpAddSugInfoQry addSugQry = new CiIpAddSugInfoQry(idOr);
		AddSugDTO[] rtns = (AddSugDTO[]) AppFwUtil.getDORstWithDao(addSugQry, AddSugDTO.class);
		faIesugors.add(rtns);

		// 获取手术人员集合
		CiIpSugEmpInfoQry sugEmpQry = new CiIpSugEmpInfoQry(idOr);
		OrdOpEmpDO[] ordOpEmpDO = (OrdOpEmpDO[]) AppFwUtil.getDORstWithDao(sugEmpQry, OrdOpEmpDO.class);
		faIesugors1.add(ordOpEmpDO);
		
		// 获取手术卫材集合
		CiIpSugMmInfoQry sugMmQry = new CiIpSugMmInfoQry(idOr);
		OrdOpMmDO[] ordOpMmDO = (OrdOpMmDO[]) AppFwUtil.getDORstWithDao(sugMmQry, OrdOpMmDO.class);
		faIesugors3.add(ordOpMmDO);
		
		//获取动态指标集合
		CiIpSugViewItemInfoQry sugViewItemQry = new CiIpSugViewItemInfoQry(idOr);
		OrdApSugViewItemDO[] ordApSugViewItemDO = (OrdApSugViewItemDO[]) AppFwUtil.getDORstWithDao(sugEmpQry, OrdApSugViewItemDO.class);
		faIesugors2.add(ordApSugViewItemDO);
	}

}
