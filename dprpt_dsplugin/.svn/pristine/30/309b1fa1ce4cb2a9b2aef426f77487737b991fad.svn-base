package iih.pe.report.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SortOfAbnormalDetecRateQry implements ITransQry {
	
	private String dt_begin;
	
	private String dt_end;
	
	public SortOfAbnormalDetecRateQry(String dt_begin, String dt_end){
		
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam param = new SqlParam();
		if(!dt_begin.equals("")){
			param.addParam(dt_begin);
		}
		if(!dt_end.equals("")){
			param.addParam(dt_end);
		}
		if(!dt_begin.equals("")){
			param.addParam(dt_begin);
		}
		if(!dt_end.equals("")){
			param.addParam(dt_end);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		boolean flag1  = false;
		boolean flag2  = false;
		String key1 = " where ";
		String key2 = " and ";
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select c1.diag,c1.total/c2.total as scale from"); 
		sqlStr.append(" (select b.diag,count(a.ID_PEPSNAPPT) as total");
		sqlStr.append(" from pe_apt_pepsnappt a"); 
		sqlStr.append(" inner join pe_wf_perstdiagsugg b");
		sqlStr.append(" on a.id_pepsnappt = b.id_pepsnappt");
		if(!dt_begin.equals("")){
			sqlStr.append(" where a.dt_pe >= ?");
			flag1 = true;
		}
		if(!dt_end.equals("")){
			if(flag1){
				sqlStr.append(key2 + "a.dt_pe <= ?");
			}else{
				sqlStr.append(key1 + "a.dt_pe <= ?");
			}
		}
		sqlStr.append(" group by b.diag");
		sqlStr.append(" order by total desc) c1,");
		sqlStr.append("(select count(a.ID_PEPSNAPPT) as total");
		sqlStr.append(" from PE_APT_PEPSNAPPT a");
		if(!dt_begin.equals("")){
			sqlStr.append(" where a.dt_pe >= ?");
			flag2 = true;
		}
		if(!dt_end.equals("")){
			if(flag2){
				sqlStr.append(key2 + "a.dt_pe <= ?");
			}else{
				sqlStr.append(key1 + "a.dt_pe <= ?");
			}
		}
		sqlStr.append(") c2");
		sqlStr.append(" where rownum <= 50");
		System.out.println(sqlStr.toString());
		return sqlStr.toString();
	}

}
