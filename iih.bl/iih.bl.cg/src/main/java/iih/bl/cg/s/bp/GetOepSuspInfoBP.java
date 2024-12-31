package iih.bl.cg.s.bp;

import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOepSuspInfoBP{

	/**
	 * 根据患者id_pat 查询门诊记账明细表bl_cg_itm_oep 是否 含有挂起的数据
	 * 
	 * @param id_pat
	 * @author liwq 2017年6月30日11:32:48
	 */
	public BlRecgOepDTO[] exec(String id_pat) throws BizException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT distinct B.id_ent     Pat_id_ent,  ");
		sql.append("        PI_PAT.Name     Pat_name, ");
		sql.append("        bd_pri_pat.name Pat_pripat_name, ");
		sql.append("        bd_dep.name     Id_dep_reg, ");
		sql.append("        en_ent.dt_acpt  Pat_dt_acpt, ");
		sql.append("        en_ent.code     en_code, ");
		sql.append("        bd_pri_pat.id_pripat Pat_id_pripat, ");
		sql.append("        PI_PAT.code     Pat_code,  ");
		sql.append("        PI_PAT.id_pat     Id_pat ");
		sql.append("   FROM PI_PAT ");
		sql.append("   JOIN EN_ENT ");
		sql.append("     ON PI_PAT.ID_PAT = EN_ENT.ID_PAT ");
		sql.append(" INNER JOIN BL_CG_ITM_OEP B ON EN_ENT.ID_ENT = B.ID_ENT ");
		sql.append("   join bd_pri_pat ");
		sql.append("     on en_ent.id_pripat = bd_pri_pat.id_pripat ");
		sql.append("   join en_ent_op ");
		sql.append("     on EN_ENT.ID_ENT = en_ent_op.id_ent ");
		sql.append("   join bd_dep ");
		sql.append("     on en_ent_op.id_dep_reg=bd_dep.id_dep ");
		sql.append("  where (en_ent.code_entp = '00' or en_ent.code_entp = '01') and b.fg_susp='Y'  ");
		sql.append(" and b.id_pat = ? ");
		sql.append("order by en_ent.code  ");
		
		SqlParam parameter = new SqlParam();
		parameter.addParam(id_pat);

		@SuppressWarnings("unchecked")
		List<BlRecgOepDTO> list = (List<BlRecgOepDTO>) new DAFacade()
				.execQuery(sql.toString(), parameter, new BeanListHandler(
						BlRecgOepDTO.class));

		if (ListUtil.isEmpty(list)) {		
			return null;
		} else {
			return list.toArray(new BlRecgOepDTO[list.size()]);
		}
	}
}
