package iih.bl.cg.s.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOpOrderDetailedQry  implements ITransQry {
	String id_ent;
	String [] id_or;
	String [] id_srv;
	String id_srvtp;
	
	public GetOpOrderDetailedQry(BlOrderValuationQueryParamDTO bQueryParamDTO)throws BizException{
		this.id_ent=bQueryParamDTO.getId_ent();
		this.id_or=(bQueryParamDTO.getId_or() == null ? null : bQueryParamDTO.getId_or().split(","));
		this.id_srv=(bQueryParamDTO.getId_srv() == null ? null : bQueryParamDTO.getId_srv().split(","));
		this.id_srvtp=bQueryParamDTO.getId_srvtp();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam=new SqlParam();
		if (!StringUtil.isEmpty(this.id_ent)) {
			sqlParam.addParam(this.id_ent);
		}
		if (!StringUtil.isEmpty(this.id_srvtp)) {
			sqlParam.addParam(this.id_srvtp);
		}
		return sqlParam;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select distinct cg.dt_cg, ");
		sql.append("                 cg.id_cgoep id_cgip, ");
		sql.append("                 cgitm.id_srv, ");
		sql.append("                 cgitm.name_srv, ");
		sql.append("                 cgitm.fg_mm, ");
		sql.append("                 cgitm.spec, ");
		sql.append("                 cgitm.price_ratio, ");
		sql.append("                 cgitm.price price_std, ");
		sql.append("                 mr.dt_mp_plan, ");
		sql.append("                 cgitm.fg_st, ");
		sql.append("                 (cgitm.quan * cg.eu_direct) quan_mend, ");
		sql.append("                 cgitm.amt_ratio* cg.eu_direct amt_ratio, ");
		sql.append("                 cgitm.amt* cg.eu_direct amt_std, ");
		sql.append("                 cgitm.id_dep_or, ");
		sql.append("                 cgitm.name_mm, ");
		sql.append("                 cgitm.id_mm, ");
		sql.append("                 measdoc_cur.id_measdoc idunit, ");
		sql.append("                 dep1.name name_dep_or, ");
		sql.append("                 cgitm.id_dep_mp, ");
		sql.append("                 dep2.name name_dep_mp, ");
		sql.append("                 cgitm.id_or, ");
		sql.append("                 cg.eu_direct, ");
		sql.append("                 null fg_bb, ");
		sql.append("                 cgitm.fg_selfpay, ");
		sql.append("                 cg.id_emp_cg, ");
		sql.append("                 psn.name name_emp_cg, ");
		sql.append("                 cgitm.srcfunc_des, ");
		sql.append("                 apde.code_dgipap, ");
		sql.append("                 ent.id_hp ");
		sql.append("   from bl_cg_itm_oep cgitm ");
		sql.append("   inner join bl_cg_oep cg on cgitm.id_cgoep = cg.id_cgoep  ");
		sql.append("   left outer join bl_st_oep st ");
		sql.append("     on st.id_stoep = cgitm.id_stoep ");
		sql.append("   left outer join bd_psndoc psn ");
		sql.append("     on psn.id_psndoc = cg.id_emp_cg ");
		sql.append("   left outer join bd_dep dep1 ");
		sql.append("     on dep1.id_dep = cgitm.id_dep_or ");
		sql.append("   left outer join bd_dep dep2 ");
		sql.append("     on dep2.id_dep = cgitm.id_dep_mp ");
		sql.append("   left outer join en_ent ent ");
		sql.append("     on ent.id_ent = cgitm.id_ent ");
		sql.append("   left outer join mp_or_pr_srv mr ");
		sql.append("     on mr.id_or_pr_srv = cgitm.id_or_pr_srv ");
		sql.append("   left outer join mp_dg_ip_apde_dt apde ");
		sql.append("     on apde.id_or_pr_srv = cgitm.id_or_pr_srv ");
		sql.append("   left outer join mp_dg_ip_ap ipap ");
		sql.append("     on apde.id_dgipap = ipap.id_dgipap ");
		sql.append("   LEFT outer JOIN BD_MEASDOC measdoc_cur ");
		sql.append("     ON measdoc_cur.id_measdoc = cgitm.pgku_cur ");
		sql.append(" where 1=1 ");
		//增加不再查询已退费数据 by lim 2018-11-08
		//sql.append(" and ((st.fg_canc='N'and st.eu_direct=1) or st.id_stoep is null ) ");
		if (!StringUtil.isEmpty(this.id_ent)) {
			sql.append(" and cgitm.id_ent=?  " );
		}
		sql.append(" and cgitm.id_or!='~' ");
		if (!ArrayUtil.isEmpty(this.id_or)) {
			sql.append(" and ").append(SqlUtils.getInSqlByIds("cgitm.id_or",this.id_or));
		}
		if (!StringUtil.isEmpty(this.id_srvtp)) {
			sql.append(" and cgitm.id_srvtp=? ");
		}
		if (!ArrayUtil.isEmpty(this.id_srv)) {
			sql.append(" and ").append(SqlUtils.getInSqlByIds("cgitm.id_srv",this.id_srv));
		}
		//请领状态编码 0.未发送1.已发送2.已确认3.发药中4.发药完成5.已作废6.取消确认
		sql.append(" and (ipap.sd_dgap in('1','2','3','4')  or ipap.sd_dgap is null)");
		sql.append("   and ((cg.eu_direct = '1' and nvl(ipap.sd_dgtp, '0') = '21') or ");
		sql.append("       (cg.eu_direct = '-1' and nvl(ipap.sd_dgtp, '0') = '22')  or ipap.sd_dgtp is null) ");
		sql.append("   and apde.id_dgipdt not in ");
		sql.append("       (select back.id_dgipdt ");
		sql.append("          from mp_dg_ip_apde_dt back ");
		sql.append("         where back.id_or_pr_srv = apde.id_or_pr_srv ");
		sql.append("           and back.en_opde = 0 ");
		sql.append("           and back.quan_ap < 0) ");
		sql.append(" order by cg.dt_cg ");
		return sql.toString();
	}
}
