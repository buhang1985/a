package iih.mp.nr.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:手术医嘱打印
 * @author:zhongcl@founder.com.cn
 * @version:2019年4月11日下午5:21:23
 */
public class GetSurgicalOrderSql implements ITransQry {

	/**开始时间**/
	private String dt_begin;
	
	/**结束时间**/
	private String dt_end;
	
	/**打印状态**/
	private String eu_prn;
	
	private String sd_exetp;
	
	/**临时表名称 **/
	private String tempTablename;
	
	public void setTempTablename(String tempTablename) {
		this.tempTablename = tempTablename;
	}

	public GetSurgicalOrderSql(String dt_begin, String dt_end, String eu_prn, String sd_exetp) {
		super();
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.eu_prn = eu_prn;
		this.sd_exetp = sd_exetp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param=new SqlParam();
		param.addParam(this.sd_exetp);
		param.addParam(dt_begin);
		param.addParam(dt_end);
		return param;
	}

	

	@Override
	public String getQrySQLStr() {
		
		StringBuilder sql=new StringBuilder();
		sql.append(" select cior.id_or,cior.sortno,entip.name_bed,ent.name_pat,entip.code_amr_ip,cior.content_or,cior.des_or,cior.name_or, cisug.dt_plan,surmeod.name as sugmeod ,surplace.name as sugplace from ci_order cior ");  
		sql.append(" inner join ci_ap_sug cisug on cisug.id_or=cior.id_or                                                            ");
		sql.append(" inner join mp_orm_app_sug orsug on cior.id_or=orsug.id_or                                                       ");  
		sql.append(" inner join en_ent ent on ent.id_ent=cior.id_en                                                                  ");  
		sql.append(" inner join en_ent_ip entip on ent.id_ent=entip.id_ent                                                           ");  
		sql.append(" inner join "+this.tempTablename+" tempent on tempent.id_ent=ent.id_ent                                          ");
		sql.append(" inner join "+this.tempTablename+" tempsrvtp on tempsrvtp.sd_srvtp=cior.sd_srvtp                                 ");
		sql.append(" inner join bd_udidoc surmeod on surmeod.id_udidoc=cisug.id_anestp                                               ");
		sql.append(" inner join bd_udidoc  surplace on surplace.id_udidoc=cisug.id_surgical_site                                    ");
		sql.append(" left join mp_exe_prnt prnt on prnt.id_key=cior.id_or and prnt.sd_exectp=?                                        ");
		sql.append(" where 1=1                                                                                                       ");  
		sql.append(" and cior.fg_chk='Y'                                                                                             ");  
		sql.append(" and cior.fg_canc='N'                                                                                            ");  
		sql.append(" and cior.fg_chk_canc='N'                                                                                        ");  
		sql.append(" and cior.fg_chk_stop='N'                                                                                        ");  
		sql.append(" and orsug.ds='0'                                                                                                 ");
		sql.append(" and cior.dt_effe>=?                                                                                             ");  
		sql.append(" and cior.dt_effe<=?                                                                                             ");  
		if("2".equals(this.eu_prn)){
			sql.append(" and  nvl(prnt.ct_prnt,'0') = 0                                                                                 ");
		}else{
			if("1".equals(this.eu_prn)){
				sql.append("and  prnt.ct_prnt>=1                                                                               ");
			}
		}
		sql.append(" order by cior.sortno,cior.dt_effe asc                                                                                       ");
		return sql.toString();
	}

}
