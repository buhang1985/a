package iih.mp.nr.hdvrcd.qry;

import xap.dp.report.data.reader.sqlqryutil.InfRptSql;

import com.software.vtreport.data.reader.sql.RptSqlParam;

/**
 * 查询交班记录
 * 
 * @author zheng.yx
 * @version 2019年10月22日16:44:54
 */
public class GetHdvRcdSql implements InfRptSql {

	private String id_dep;
	private String dt_hdv;

	public GetHdvRcdSql(String id_dep, String dt_hdv) {
		this.id_dep = id_dep;
		this.dt_hdv = dt_hdv;
	}

	@Override
	public RptSqlParam[] getSqlParams() {
		RptSqlParam[] sql_params = new RptSqlParam[]{
			new RptSqlParam(this.id_dep, String.class),
			new RptSqlParam(this.dt_hdv, String.class)
		};
		
		return sql_params;
	}

	@Override
	public String getQrySql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                ");
		sqlStr.append(" hdv.id_hdv,                                                           ");
		sqlStr.append(" hdv.id_hdv_def,                                                       ");
		sqlStr.append(" hdvdef.name as name_hdv_def,                                          ");
		sqlStr.append(" hdv.id_dep_hdv,                                                       ");
		sqlStr.append(" dep.name as name_dep_hdv,                                             ");
		sqlStr.append(" hdv.dt_hdv,                                                           ");
		sqlStr.append(" hdv.num_pat as sum_pat                                                ");
		sqlStr.append(" from mp_hdv hdv                                                       ");
		sqlStr.append(" inner join mp_hdv_def hdvdef on hdvdef.id_hdv_def = hdv.id_hdv_def    ");
		sqlStr.append(" inner join bd_dep dep on dep.id_dep = hdv.id_dep_hdv                  ");
		sqlStr.append(" where hdv.id_dep_hdv = ? and hdv.dt_hdv = ? and hdv.eu_hav_sta = 1    ");
		sqlStr.append(" order by hdvdef.code asc                                              ");
		return sqlStr.toString();
	}

}
