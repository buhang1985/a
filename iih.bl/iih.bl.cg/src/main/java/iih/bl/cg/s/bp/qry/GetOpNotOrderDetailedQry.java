package iih.bl.cg.s.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOpNotOrderDetailedQry  implements ITransQry {
	private String id_ent;
	private String[] id_srv;
	private String Srcfunc_des;
	
	public GetOpNotOrderDetailedQry(BlOrderValuationQueryParamDTO tempDTO, String srcfunc_des)
	{
		this.id_ent = tempDTO.getId_ent();
		this.id_srv = (tempDTO.getId_srv() == null ? null : tempDTO.getId_srv().split(","));
		this.Srcfunc_des = srcfunc_des;
	}
	public GetOpNotOrderDetailedQry(BlOrderValuationQueryParamDTO tempDTO)
	{
		this.id_ent = tempDTO.getId_ent();
		this.id_srv = (tempDTO.getId_srv() == null ? null : tempDTO.getId_srv().split(","));
		this.Srcfunc_des = "";
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		
		if (!StringUtil.isEmpty(this.id_ent)) {
			sqlParam.addParam(this.id_ent);	
		}

		if (!StringUtil.isEmpty(this.Srcfunc_des)) {
			sqlParam.addParam(this.Srcfunc_des);
		}
		return sqlParam;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select cgitm.id_ent, ");
		sql.append("        cg.dt_cg, ");
		sql.append("        cgitm.id_srv, ");
		sql.append("        cgitm.name_srv, ");
		sql.append("        cgitm.fg_mm, ");
		sql.append("        cgitm.spec, ");
		sql.append("        cgitm.price_ratio, ");
		sql.append("        cgitm.price price_std, ");
		sql.append("        cgitm.fg_st, ");
		sql.append("        (cgitm.quan * cg.eu_direct) quan_mend, ");
		sql.append("        cgitm.amt_ratio amt_ratio, ");
		sql.append("        cgitm.amt amt_std, ");
		sql.append("        cgitm.id_dep_or, ");
		sql.append("        cgitm.name_mm, ");
		sql.append("        cgitm.id_mm, ");
		sql.append("        depor.name name_dep_or, ");
		sql.append("        cgitm.id_dep_mp, ");
		sql.append("        depmp.name name_dep_mp, ");
		sql.append("        cg.eu_direct, ");
		sql.append("        null fg_bb, ");// 没有婴儿标记
		sql.append("        cgitm.fg_selfpay, ");
		sql.append("        cg.id_emp_cg, ");
		sql.append("        psn.name name_emp_cg, ");
		sql.append("        nvl(cgitm.srcfunc_des, 1) srcfunc_des, ");
		sql.append("        cgitm.code_apply, ");
		sql.append("        ent.id_hp ");
		sql.append("   from bl_cg_itm_oep cgitm ");
		sql.append("  inner join bl_cg_oep cg ");
		sql.append("     on cgitm.id_cgoep = cg.id_cgoep ");
		sql.append("  inner join bd_psndoc psn ");
		sql.append("     on cg.id_emp_cg = psn.id_psndoc ");
		sql.append("  inner join bd_dep depor ");
		sql.append("     on cgitm.id_dep_or = depor.id_dep ");
		sql.append("  inner join bd_dep depmp ");
		sql.append("     on cgitm.id_dep_mp = depmp.id_dep ");
		sql.append("  inner join en_ent ent ");
		sql.append("     on cgitm.id_ent = ent.id_ent ");
		sql.append("  where 1 = 1 ");
		sql.append(" and cgitm.code_enttp ='"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS+"'  ");
		sql.append(" and cgitm.id_or='~'  ");
		//增加不再查询已退费数据  copy liming
		//sql.append(" and cgitm.fg_refund='N' and cgitm.id_par='~' ");

		if (!StringUtil.isEmpty(this.id_ent)) {
			// 无婴儿标志
			sql.append(" and cgitm.id_ent=?  " );
		}

		if (!StringUtil.isEmpty(this.Srcfunc_des)) {
			sql.append(" and cgitm.Srcfunc_des=? ");
		}
		if (!ArrayUtil.isEmpty(this.id_srv)) {
			sql.append(" and ").append(SqlUtils.getInSqlByIds("cgitm.id_srv", this.id_srv));
		}
		sql.append(" order by cg.dt_cg ");
		return sql.toString();
	}
}
