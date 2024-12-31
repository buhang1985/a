package iih.sfda.adsa.yearsstatistics.qry;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import iih.sfda.adsa.yearsstatistics.GetConstant;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取发生部门
 * @author 于德义
 *
 */
public class GetOccurDepSql implements ITransQry{
	String startTime;
	String endTime;
	String sd_coll_ref;
	String id_org;
	String id_grp;
	String wherePart;
	
	public GetOccurDepSql(String startTime,String endTime,String sd_coll_ref, String id_org, String id_grp, String wherePart) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.id_org = id_org;
		this.id_grp = id_grp;
		this.wherePart = wherePart;
		this.sd_coll_ref = sd_coll_ref;
	}
	
	public RptSqlParam[] getSqlParams() {
		RptSqlParam[] arr_params = new RptSqlParam[] { new RptSqlParam(startTime, String.class),
				new RptSqlParam(endTime, String.class), new RptSqlParam(id_org, String.class),
				new RptSqlParam(id_grp, String.class)};
		return arr_params;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                              ");
		sqlStr.append(" occurdep.name as name ,                                             ");
		if(GetConstant.getOccurDate().equals(sd_coll_ref)){
			sqlStr.append(" aerev.dt_occur dateTime                                         ");
		}else{
			sqlStr.append(" aerev.createdtime dateTime                                      ");
		}
		sqlStr.append(" from SFDA_AER_EV aerev                                              ");
		sqlStr.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = aerev.id_psndoc                  ");
		sqlStr.append(" inner join bd_dep occurdep on aerev.id_dep_occur =occurdep.id_dep   ");
		if (GetConstant.getOccurDate().equals(sd_coll_ref)) {
			sqlStr.append(" where aerev.dt_occur >=  ?               ");
			sqlStr.append(" and aerev.dt_occur <=   ?              ");
		} else {
			sqlStr.append(" where aerev.createdtime >=  ?               ");
			sqlStr.append(" and aerev.createdtime <=   ?              ");
		}
	    sqlStr.append(" and aerev.id_org= ?     ");
		sqlStr.append(" and aerev.id_grp=  ?     ");
		if (wherePart != null) {
			sqlStr.append(" and" + wherePart + "                ");
		}
		return sqlStr.toString();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
