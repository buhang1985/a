package iih.nm.nom.wardprint.qry;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import iih.mp.nr.common.MpUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:危重病人信息查询
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月28日下午2:13:02
 */
public class GetNmSeriousDataQry implements ITransQry {

	private String dt_begin;
	private String dt_end;
	private List<String> id_srvs;
	private List<String> id_deps;
	

	public GetNmSeriousDataQry(String dt_begin, String dt_end, List<String> id_srvs, List<String> id_deps) {
		super();
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.id_srvs = id_srvs;
		this.id_deps = id_deps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam param=new SqlParam();
		param.addParam(this.dt_end);
		param.addParam(this.dt_begin);
		if(CollectionUtils.isNotEmpty(this.id_deps)){
		   List<Object> params=param.getParameters();
		   params.addAll(this.id_deps);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sql=new StringBuilder();
		sql.append(" select                                                                           "); 
		sql.append(" dep.id_dep as id_dep_nur,                                                        "); 
		sql.append(" dep.name as dep_name,                                                            "); 
		sql.append(" entip.name_bed as bed_no,                                                        "); 
		sql.append(" ent.name_pat as pat_name,                                                        "); 
		sql.append(" pat.sd_sex as sex_no,                                                            "); 
		sql.append(" pat.dt_birth as dt_birth,                                                        "); 
		sql.append(" entip.code_amr_ip as hospital_num,                                               "); 
		sql.append(" entdep.dt_b as dt_begin,                                                         "); 
		sql.append(" cior.dt_effe  as dt_serious,                                                     "); 
		sql.append(" cior.dt_end as serious_end,                                                      "); 
		sql.append(" ent.dt_end as dt_end,                                                            "); 
		sql.append(" entdi.name_didef_dis as diagnosis                                                "); 
		sql.append(" from ci_order cior                                                               "); 
		sql.append(" inner join en_ent ent on ent.id_ent=cior.id_en                                   "); 
		sql.append(" inner join pi_pat pat on pat.id_pat=ent.id_pat                                   "); 
		sql.append(" inner join bd_dep dep on dep.id_dep=cior.id_dep_mp                               "); 
		sql.append(" left join en_ent_ip entip on entip.id_ent=ent.id_ent                             "); 
		sql.append(" inner join en_ent_dep entdep on entdep.id_ent=ent.id_ent and entdep.fg_admit='Y' "); 
		sql.append(" left join en_ent_di entdi on entdi.id_ent=ent.id_ent and entdi.fg_maj='Y'        "); 
		sql.append(" where                                                                            ");
		sql.append(" 1=1                                                                              ");
		sql.append(" and entdep.sd_entdeprole='2'                                                     ");
		if(CollectionUtils.isNotEmpty(this.id_srvs)){
			String id_srv=MpUtils.getInSqlStr(this.id_srvs.toArray(new String[0])) ;
			sql.append(" and cior.id_srv in ("+ id_srv +" );                                          ");
		}
		sql.append(" and cior.dt_effe <=?                                                             ");
		sql.append(" and cior.dt_end>=?                                                               ");
		if(CollectionUtils.isNotEmpty(this.id_deps)){
			String id_dep_sql="";
			for (String id_dep : id_deps) {
				id_dep_sql+=StringUtils.isBlank(id_dep_sql)? "?" :", ?";
			}
			sql.append(" and cior.id_dep_mp in ("+id_dep_sql+")");
		}
		sql.append(" order by cior.dt_effe                                                             ");
		return sql.toString();
	}

}
