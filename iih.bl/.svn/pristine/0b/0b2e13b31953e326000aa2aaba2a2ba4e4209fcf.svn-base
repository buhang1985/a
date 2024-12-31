package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.utils.ContextUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

/**
 * 门诊重划 查询就诊信息
 * 
 * @author liwq 2017年7月3日17:23:31
 *
 */
public class GetUnsettledEnInfoBP {
	
	/**
	 * 根据患者id_pat查询门诊未结算Fg_st='N'就诊信息
	 * @param id_pat 病人ID
	 * @return 
	 * @author liwq 2017年6月30日11:53:01
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlRecgOepDTO[] exec(String id_pat) throws BizException {
		// 1. 通过判断记账明细表中是否有未结算的费用，来获取就诊id
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" select  distinct a.id_ent ");
		sqlb.append(" from bl_cg_itm_oep a ");
		sqlb.append(" where (a.fg_st = 'N' or a.fg_st is null ) ");
		sqlb.append("    and a.id_pat = ? ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> patiEntList = (List<PatiVisitDO>) new DAFacade().execQuery(
				sqlb.toString(), sqlp, new BeanListHandler(String.class));
		if (ListUtil.isEmpty(patiEntList)) {
			// 1.1 如果记账明细表中没有就诊费用，则查询CI域中就诊id
			StringBuilder sql_ci = new StringBuilder();
			sql_ci.append(" select  distinct a.id_en as id_ent ");
			sql_ci.append(" from ci_or_srv a ");
			sql_ci.append(" where a.sd_su_bl = '0' and a.code_entp in ('00','01') ");
			sql_ci.append("    and a.id_pat = ? ");
			SqlParam paramCi = new SqlParam();
			paramCi.addParam(id_pat);
			patiEntList = (List<PatiVisitDO>) new DAFacade().execQuery(sql_ci
					.toString(), paramCi, new BeanListHandler(PatiVisitDO.class));
			if (ListUtil.isEmpty(patiEntList)) {
				// 1.2如果记账明细表中没有就诊费用，ci域中也没有费用数据时 则查询就诊域数据
				StringBuilder sql_en = new StringBuilder();
				sql_en.append(" select  id_ent from en_ent where code_entp in ('00','01') and fg_canc = 'N' and id_pat = ? ");
				sql_en.append(" minus ");
				sql_en.append(" select distinct a.id_ent ");
				sql_en.append(" from  ci_or_srv b inner join en_ent a  on a.id_ent = b.id_en ");
				sql_en.append(" where b.sd_su_bl = '0' and b.code_entp in ('00','01')  ");
				sql_en.append(" and a.id_pat = ?  ");
				SqlParam paramEn = new SqlParam();
				paramEn.addParam(id_pat);
				paramEn.addParam(id_pat);
				patiEntList = (List<PatiVisitDO>) new DAFacade()
						.execQuery(sql_en.toString(), paramEn,
								new BeanListHandler(PatiVisitDO.class));
				if (ListUtil.isEmpty(patiEntList)) {
					return null;
				}
			}
		}		
		// 2. 将id_ent结果集转换sql查询条件
		List<String> idEntList = new ArrayList<String>();
		if(!ListUtil.isEmpty(patiEntList)) {
			for(PatiVisitDO itm : patiEntList) {
				idEntList.add(itm.getId_ent());
			}
		}
		String	idEntSql = "";
		if(!ListUtil.isEmpty(idEntList))
			idEntSql = SqlUtils.getInSqlByIds("en_ent.id_ent", idEntList);
		if(StringUtil.isEmptyWithTrim(idEntSql))
			idEntSql = "en_ent.id_ent = null";
	
		// 3. 查询门诊未付款的就诊信息
		StringBuilder sqlb2 = new StringBuilder();
		sqlb2.append(" SELECT PI_PAT.code     Pat_code, ");
		sqlb2.append("        PI_PAT.Name     Pat_name, ");
		sqlb2.append("        bd_pri_pat.name Pat_pripat_name, ");
		sqlb2.append("        bd_dep.name     Id_dep_reg, ");
		sqlb2.append("   CASE WHEN ( en_ent.dt_acpt is null)  THEN en_ent.dt_entry ELSE en_ent.dt_acpt end  Pat_dt_acpt, ");
		sqlb2.append("        bd_pri_pat.id_pripat Pat_id_pripat, ");
		sqlb2.append("        en_ent.id_ent     Pat_id_ent, ");
		sqlb2.append("        PI_PAT.id_pat     Id_pat ");
		sqlb2.append("   FROM PI_PAT ");
		sqlb2.append("   JOIN EN_ENT ");
		sqlb2.append("     ON PI_PAT.ID_PAT = EN_ENT.ID_PAT ");
		sqlb2.append("   join bd_pri_pat ");
		sqlb2.append("     on en_ent.id_pripat = bd_pri_pat.id_pripat ");
		sqlb2.append("   join en_ent_op ");
		sqlb2.append("     on EN_ENT.ID_ENT = en_ent_op.id_ent ");
		sqlb2.append("   join bd_dep ");
		sqlb2.append("     on en_ent_op.id_dep_reg=bd_dep.id_dep ");
		sqlb2.append("  where (en_ent.code_entp = '00' or en_ent.code_entp = '01') ");
		sqlb2.append("    and PI_PAT.id_pat = ? ");
		sqlb2.append("    and  ").append(idEntSql);
		sqlb2.append("    and pi_pat.id_grp=? ");
		sqlb2.append("    and pi_pat.id_org=?  order by en_ent.dt_acpt desc");

		SqlParam parameter = new SqlParam();
		parameter.addParam(id_pat);
		parameter.addParam(ContextUtils.getGrpId());
		parameter.addParam(ContextUtils.getOrgId());

		@SuppressWarnings("unchecked")
		List<BlRecgOepDTO> list = (List<BlRecgOepDTO>) new DAFacade()
				.execQuery(sqlb2.toString(), parameter, new BeanListHandler(
						BlRecgOepDTO.class));

		if (ListUtil.isEmpty(list)) {
			return null;
		} else {
			return list.toArray(new BlRecgOepDTO[list.size()]);
		}
	}
}
