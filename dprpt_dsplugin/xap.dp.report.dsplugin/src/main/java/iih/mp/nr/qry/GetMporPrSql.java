package iih.mp.nr.qry;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询符合条件的计划建临时表
 * @author hjh
 *
 */
public class GetMporPrSql implements ITransQry{

	private String dt_begin;
	private String dt_end;
	private String fg_long;
	private String eu_prnt;
	private String paramcode;
	private String nameTable;
	

	public void setTemTableName(String nameTable) {
		this.nameTable = nameTable;
	}

	public GetMporPrSql(String dt_begin, String dt_end, String fg_long,String paramcode, String eu_prnt){
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.fg_long = fg_long;
		this.paramcode = paramcode;
		this.eu_prnt = eu_prnt;
	}

	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.dt_begin);
		param.addParam(this.dt_end);
		if (!StringUtil.isEmptyWithTrim(fg_long))
			param.addParam(this.fg_long);
		if(!StringUtil.isEmptyWithTrim(paramcode)){
			param.addParam(this.dt_begin);
			param.addParam(dt_end);
			if (!StringUtil.isEmptyWithTrim(fg_long))
				param.addParam(this.fg_long);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                        ");
		sqlStr.append(" distinct                                                                                       ");
		sqlStr.append(" orpr.id_or_pr,                                                                                ");
		sqlStr.append(" orpr.id_or,                                                                                   ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                                ");
		sqlStr.append(" orpr.no_bar                                                                                   ");
		sqlStr.append(" from mp_or_pr orpr                                                                            ");
		sqlStr.append(" inner join " + this.nameTable + " tementtable on tementtable.id_ent = orpr.id_ent             ");
		sqlStr.append(" inner join " + this.nameTable + " temroutetable on temroutetable.id_route = orpr.id_route     ");
		sqlStr.append(" inner join ci_or_srv orsrv on orsrv.id_or = orpr.id_or                                        ");
		sqlStr.append(" where substr(orpr.sd_srvtp,0,2) = '01'                                                        ");
		sqlStr.append(" and orpr.eu_su <> 3                                                                           ");
		sqlStr.append(" and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?                                             ");
		if (!StringUtil.isEmptyWithTrim(fg_long))
			sqlStr.append(" and orpr.fg_long = ?                                                                      ");
		if (!StringUtil.isEmptyWithTrim(this.eu_prnt) && !"0".equals(this.eu_prnt)) {
			if ("1".equals(this.eu_prnt))
				//已打印
				sqlStr.append(" and orpr.ct_prn > 0                                                                   ");
			else
				sqlStr.append(" and orpr.ct_prn = 0                                                                   ");
		}
		if(!StringUtil.isEmptyWithTrim(paramcode)){
			sqlStr.append(" and orsrv.id_dep_wh <> '"+paramcode+"'                                                                  ");
		}
		
		if(!StringUtil.isEmptyWithTrim(paramcode)){
			
			sqlStr.append(" union all                                                                                     ");
			sqlStr.append(" select                                                                                        ");
			sqlStr.append(" distinct                                                                                       ");
			sqlStr.append(" orpr.id_or_pr,                                                                                ");
			sqlStr.append(" orpr.id_or,                                                                                   ");
			sqlStr.append(" to_char(to_date(orpr.dt_mp_plan,'yyyy-mm-dd hh24:mi:ss') -1,'yyyy-mm-dd hh24:mi:ss')  as dt_mp_plan,   ");
			sqlStr.append(" orpr.no_bar                                                                                   ");
			sqlStr.append(" from mp_or_pr orpr                                                                            ");
			sqlStr.append(" inner join " + this.nameTable + " tementtable on tementtable.id_ent = orpr.id_ent             ");
			sqlStr.append(" inner join " + this.nameTable + " temroutetable on temroutetable.id_route = orpr.id_route     ");
			sqlStr.append(" inner join ci_order ci on ci.id_or = orpr.id_or                                               ");
			sqlStr.append(" inner join ci_or_srv orsrv on orsrv.id_or = orpr.id_or                                        ");
			sqlStr.append(" where substr(orpr.sd_srvtp,0,2) = '01'                                                        ");
			sqlStr.append(" and orpr.eu_su <> 3                                                                           ");
			sqlStr.append(" and ci.dt_effe >= ? and ci.dt_effe <= ?                                            ");
			
			if(!StringUtil.isEmptyWithTrim(paramcode)){
				sqlStr.append(" and orsrv.id_dep_wh = '"+paramcode+"'                                                                  ");
			}
			
			if (!StringUtil.isEmptyWithTrim(fg_long))
				sqlStr.append(" and orpr.fg_long = ?                                                                      ");
			if (!StringUtil.isEmptyWithTrim(this.eu_prnt) && !"0".equals(this.eu_prnt)) {
				if ("1".equals(this.eu_prnt))
					//已打印
					sqlStr.append(" and orpr.ct_prn > 0                                                                   ");
				else
					sqlStr.append(" and orpr.ct_prn = 0                                                                   ");
			}
			sqlStr.append(" and to_date(substr(orpr.dt_mp_plan,1,10),'yyyy-mm-dd') -to_date(substr(ci.dt_effe,1,10),'yyyy-mm-dd') = 1 ");
		}
		
		return sqlStr.toString();
	}

}
