package iih.mp.nr.hdvrcd.qry;

import iih.mp.nr.common.MpUtils;
import xap.dp.report.data.reader.sqlqryutil.InfRptSql;
import xap.mw.core.utils.StringUtil;

import com.software.vtreport.data.reader.sql.RptSqlParam;

/**
 * 查询交接班患者信息
 * 
 * @author zheng.yx
 * @version 2019年10月22日16:44:54
 */
public class GetHdvEntSql implements InfRptSql {

	private String[] id_hdvs;

	public GetHdvEntSql(String[] id_hdvs) {
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
		sqlStr.append(" select                                                            ");
		sqlStr.append(" hdvent.id_hdv_ent,                                                ");
		sqlStr.append(" hdvent.id_hdv,                                                    ");
		sqlStr.append(" hdvent.id_ent,                                                    ");
		sqlStr.append(" hdvent.id_pat,                                                    ");
		sqlStr.append(" hdvent.content,                                                   ");
		sqlStr.append(" enent.name_pat,                                                   ");
		sqlStr.append(" enentip.name_bed,                                                 ");
		sqlStr.append(" enttagt.val as lablestr                                           ");
		sqlStr.append(" from mp_hdv_ent hdvent                                            ");
		sqlStr.append(" inner join en_ent enent on enent.id_ent = hdvent.id_ent           ");
		sqlStr.append(" inner join en_ent_ip enentip on enent.id_ent = enentip.id_ent     ");
		sqlStr.append(" left join mp_hdv_ent_tagt enttagt on hdvent.id_hdv_ent = enttagt.id_hdv_ent     ");
		String whereStr = MpUtils.getSqlParamChars(this.id_hdvs);
		if (!StringUtil.isEmptyWithTrim(whereStr))
			sqlStr.append(" where hdvent.id_hdv in(" + whereStr + ")                      ");
		// sqlStr.append(" and rownum < 100 ");
		sqlStr.append(" order by enentip.name_bed                                         ");
		return sqlStr.toString();
	}
}
