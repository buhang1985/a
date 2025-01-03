package iih.bl.cg.s.bp.op;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.mp.ot.dto.depitm.d.MpOtDeptDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊综合查询
 * @author:hanjq
 * @date  :2020年7月3日
 */
public class OepChargeQryBP {

	/**
	 * 查询门诊记账明细账单项信息
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param idPat
	 * @param idStOep
	 * @return
	 * @throws DAException 
	 */
	public BlStIpInccaInfoDTO[] findCgOepIncca(String wherePart) throws DAException {
		SqlParam sqlp = new SqlParam();
//		sqlp.addParam(idPat);		
		StringBuffer sql = new StringBuffer();
		// 按新票据分类做的
		sql.append("  SELECT Z.ID_INCCAITM, ");
		sql.append("         Z.code CODE_INCCAITM, ");
		sql.append("         NVL(Z.name, '未知') as NAME_INCCAITM, ");
		sql.append("         SUM(cg.EU_DIRECT * X.Quan) Quan, ");
		sql.append("         trim(to_char(SUM(cg.EU_DIRECT * X.AMT),'9999990.00')) AS AMT, ");
		sql.append("         trim(to_char(SUM(cg.EU_DIRECT * X.AMT_HP),'9999990.00')) AMT_HP, ");
		sql.append("         trim(to_char(SUM(cg.EU_DIRECT * X.AMT_STD),'9999990.00')) AMT_STD, ");
		sql.append("         trim(to_char(SUM(cg.EU_DIRECT * X.AMT_PAT),'9999990.00')) AMT_PAT, ");
		sql.append("         trim(to_char(SUM(cg.EU_DIRECT * X.AMT_RATIO),'9999990.00')) AMT_RATIO ");
		sql.append("    FROM Bl_Cg_Itm_Oep X ");
		sql.append("    join bl_cg_oep cg on cg.Id_Cgoep = X.Id_Cgoep ");
		sql.append("    LEFT JOIN  BD_INCCA_ITM Z  ON  X.CODE_INCCAITM = Z.code ");
		sql.append("   WHERE 1=1 and cg.id_org = Z.Id_Org and cg.id_grp = Z.Id_Grp ");
		sql.append("   		and ").append(wherePart);
//		and X.id_pat = ?
//		if(StringUtils.isNotBlank(idStOep)){
//			sql.append("   AND X.id_stoep = ? ");
//			sqlp.addParam(idStOep);
//		}else{
//			sql.append("   AND X.fg_st = 'N' ");
//		}
		sql.append("   GROUP BY Z.ID_INCCAITM, Z.code, Z.name ");
		
		@SuppressWarnings("unchecked")
		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade()
				.execQuery(sql.toString(), sqlp, new BeanListHandler(
						BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}
	
	/**
	 * 查询记账明细(分组)
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param wherePart
	 * @return
	 * @throws DAException 
	 */
	public BlIpAuditFeeDTO[] findCgItmOepforGroup(String wherePart) throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT			");
		sql.append("	to_char(SUM(A0.AMT_RATIO * cg.EU_DIRECT), '99999990.00') AMT_RATIO,		");
		sql.append("	A0.NAME_SRV,		");
		sql.append("	to_char(SUM(QUAN * cg.EU_DIRECT), '99999990.00') QUAN,		");
		sql.append("	C0.NAME unit_name,		");
		sql.append("	A0.SPEC,		");
		sql.append("	F0.name ITMNAME,		");
		sql.append("	to_char(A0.PRICE, '99999990.0000') price,		");
		sql.append("	to_char(A0.PRICE_RATIO, '99999990.0000') price_ratio,		");
		sql.append("	A0.ID_DEP_OR,		");
		sql.append("	A0.ID_DEP_NUR,		");
		sql.append("	A0.ID_DEP_MP,		");
		sql.append("	A0.ID_SRV,		");
		sql.append("	A0.Id_ent,		");
		sql.append("	A0.ID_EMP_OR,		");
		sql.append("	B0.NAME EMP_NAME_OR,		");
		sql.append("	a0.ratio_pripat		");
		sql.append("FROM BL_CG_itm_oep A0		");
		sql.append("join bl_cg_oep cg on cg.id_cgoep = A0.Id_Cgoep			");
		sql.append("LEFT JOIN BD_INCCA_ITM F0 ON A0.Code_Inccaitm = F0.code	and cg.id_org = F0.Id_Org and cg.id_grp = F0.Id_Grp	");
		sql.append("LEFT outer JOIN BD_PSNDOC B0  ON A0.ID_EMP_OR = B0.ID_PSNDOC			");
		sql.append("LEFT outer JOIN BD_MEASDOC C0  ON A0.SRVU = C0.ID_MEASDOC			");
		sql.append("WHERE	1=1		");		
		sql.append("	AND		").append(wherePart).append("	");
		sql.append("GROUP BY F0.NAME,NAME_SRV, ratio_pripat, PRICE, PRICE_RATIO, SPEC,			");
		sql.append("	A0.Id_ent, A0.ID_SRV, A0.ID_DEP_OR,A0.ID_DEP_NUR,A0.ID_DEP_MP,		");
		sql.append("	A0.ID_EMP_OR, B0.NAME, C0.NAME		");
		sql.append("ORDER BY F0.name		");
		@SuppressWarnings("unchecked")
		List<BlIpAuditFeeDTO> auditList = (List<BlIpAuditFeeDTO>) new DAFacade()
				.execQuery(sql.toString(),  new BeanListHandler(
						BlIpAuditFeeDTO.class));
		if (auditList == null || auditList.size() == 0) {
			return new BlIpAuditFeeDTO[0];
		}
		this.SetDepName(auditList);
		
		return auditList.toArray(new BlIpAuditFeeDTO[0]);
	}
	
	/**
	 * 设置部门信息
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param auditList
	 * @throws DAException
	 */
	private void SetDepName(List<BlIpAuditFeeDTO> auditList) throws DAException{
		HashSet<String> depSet = new HashSet<>();
		for(BlIpAuditFeeDTO itm:auditList){
			if(StringUtils.isNotBlank(itm.getId_dep_mp())){
				depSet.add(itm.getId_dep_mp());
			}
			if(StringUtils.isNotBlank(itm.getId_dep_or())){
				depSet.add(itm.getId_dep_or());
			}
			if(StringUtils.isNotBlank(itm.getId_dep_nur())){
				depSet.add(itm.getId_dep_nur());
			}
		}
		// 2、将查询出来的科室Id结果集放入map
		if(depSet.size() > 0){
			Map<String, String> deptDtoMap = new HashMap<>();
			DAFacade dAFacade = new DAFacade();		
			String depSql = "SELECT ID_DEP,NAME AS NAME_DEP FROM BD_DEP Where ID_DEP in ("+SqlUtils.arrayToStr(depSet.toArray(new String[0]))+")";
			@SuppressWarnings("unchecked")
			List<MpOtDeptDTO> deptDtoList = (List<MpOtDeptDTO>) dAFacade.execQuery(depSql,new BeanListHandler(MpOtDeptDTO.class));
			for(MpOtDeptDTO itm:deptDtoList){
				deptDtoMap.put(itm.getId_dep(), itm.getName_dep());
			}
			
			for(BlIpAuditFeeDTO itm:auditList){
				itm.setName_dep_mp(deptDtoMap.get(itm.getId_dep_mp()));
				itm.setName_dep_or(deptDtoMap.get(itm.getId_dep_or()));
				itm.setName_dep_nur(deptDtoMap.get(itm.getId_dep_nur()));
			}
		}
	}
	
	/**
	 * 查询记账明细
	 * @description:
	 * @author:hanjq  2020年7月3日
	 * @param wherePart
	 * @return
	 * @throws DAException 
	 */
	public BlIpAuditFeeDTO[] findCgItmOep(String wherePart) throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT			");
		sql.append("	to_char(A0.AMT_RATIO * cg.EU_DIRECT, '99999990.00') AMT_RATIO,		");
		sql.append("	A0.NAME_SRV,		");
		sql.append("	to_char(QUAN * cg.EU_DIRECT, '99999990.00') QUAN,		");
		sql.append("	C0.NAME unit_name,		");
		sql.append("	A0.SPEC,		");
		sql.append("	F0.name ITMNAME,		");
		sql.append("	to_char(A0.PRICE, '99999990.0000') price,		");
		sql.append("	to_char(A0.PRICE_RATIO, '99999990.0000') price_ratio,		");
		sql.append("	A0.ID_DEP_OR,		");
		sql.append("	A0.ID_DEP_NUR,		");
		sql.append("	A0.ID_DEP_MP,		");
		sql.append("	A0.ID_SRV,		");
		sql.append("	A0.Id_ent,		");
		sql.append("	A0.ID_EMP_OR,		");
		sql.append("	A0.dt_cg,		");
		sql.append("	A0.dt_srv,		");
		sql.append("	B0.NAME EMP_NAME_OR,		");
		sql.append("	a0.ratio_pripat		");
		sql.append("FROM BL_CG_itm_oep A0		");
		sql.append("join bl_cg_oep cg on cg.id_cgoep = A0.Id_Cgoep			");
		sql.append("LEFT JOIN BD_INCCA_ITM F0 ON A0.Code_Inccaitm = F0.code	 and cg.id_org = F0.Id_Org and cg.id_grp = F0.Id_Grp		");
		sql.append("LEFT outer JOIN BD_PSNDOC B0  ON A0.ID_EMP_OR = B0.ID_PSNDOC			");
		sql.append("LEFT outer JOIN BD_MEASDOC C0  ON A0.SRVU = C0.ID_MEASDOC			");
		sql.append("WHERE	1=1		");		
		sql.append("	AND		").append(wherePart).append("	");
		sql.append("ORDER BY A0.dt_cg		");
		@SuppressWarnings("unchecked")
		List<BlIpAuditFeeDTO> auditList = (List<BlIpAuditFeeDTO>) new DAFacade()
				.execQuery(sql.toString(),  new BeanListHandler(
						BlIpAuditFeeDTO.class));
		if (auditList == null || auditList.size() == 0) {
			return new BlIpAuditFeeDTO[0];
		}
		this.SetDepName(auditList);
		
		return auditList.toArray(new BlIpAuditFeeDTO[0]);
	}

}
