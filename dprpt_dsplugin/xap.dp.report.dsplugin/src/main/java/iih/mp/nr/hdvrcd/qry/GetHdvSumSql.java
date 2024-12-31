package iih.mp.nr.hdvrcd.qry;

import iih.mp.nr.common.MpUtils;
import xap.dp.report.data.reader.sqlqryutil.InfRptSql;
import xap.mw.core.utils.StringUtil;

import com.software.vtreport.data.reader.sql.RptSqlParam;

/**
 * 查询交班汇总信息
 * 
 * @author zheng.yx
 * @version 2019年10月22日16:44:54
 */
public class GetHdvSumSql implements InfRptSql {

	private String[] id_hdvs;

	public GetHdvSumSql(String[] id_hdvs) {
		this.id_hdvs = id_hdvs;
	}

	@Override
	public RptSqlParam[] getSqlParams() {
		final int ids_cnt = (null==id_hdvs ? 0 : id_hdvs.length);
		RptSqlParam[] sql_params = new RptSqlParam[ids_cnt];
		
		for(int ix=0; ix<ids_cnt; ix++) {
			sql_params[ix] = new RptSqlParam(id_hdvs[ix], String.class);
		}
		
		return sql_params;
	}

	@Override
	public String getQrySql() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                             ");
		sqlStr.append(" hdvsum.id_hdv_sum,                                                 ");
		sqlStr.append(" hdvsum.id_hdv,                                                     ");
		sqlStr.append(" hdvsum.id_vs_tagt as id_tagt,                                      ");
		sqlStr.append(" tagt.name_short as name_tagt,                                      ");
		sqlStr.append(" hdvsum.val,                                                        ");
		sqlStr.append(" hdvsum.val_auto                                                    ");
		sqlStr.append(" from mp_hdv_sum hdvsum                                             ");
		sqlStr.append(" inner join mp_vs_tagt tagt on tagt.id_vs_tagt = hdvsum.id_vs_tagt  ");
		String whereStr = MpUtils.getSqlParamChars(this.id_hdvs);
		if (!StringUtil.isEmptyWithTrim(whereStr))
			sqlStr.append(" where hdvsum.id_hdv in(" + whereStr + ")                       ");
		sqlStr.append(" order by tagt.code                                                 ");
		return sqlStr.toString();
	}
}
