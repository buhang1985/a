package iih.cssd.dfp.qry;

import java.util.ArrayList;
import java.util.List;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import xap.dp.report.data.reader.sqlqryutil.InfRptSql;

/**
 * @Description:获取消毒包简要信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年11月26日 上午10:51:50 创建
 */
public class GetShortLabelSql implements InfRptSql {

	private String[] id_dfps;

	public GetShortLabelSql(String[] id_dfps) {
		this.id_dfps = id_dfps;
	}

	@Override
	public RptSqlParam[] getSqlParams() {
		List<RptSqlParam> reList = new ArrayList<RptSqlParam>();
		for (String id_dfp : id_dfps) {
			reList.add(new RptSqlParam(id_dfp, String.class));
		}
		for (String id_dfp : id_dfps) {
			reList.add(new RptSqlParam(id_dfp, String.class));
		}
		return reList.toArray(new RptSqlParam[0]);
	}

	@Override
	public String getQrySql() {
		StringBuffer sqlStr = new StringBuffer();
		String whereIn = "";
		for (int i = 0; i < id_dfps.length; i++) {
			whereIn += (whereIn.length() == 0 ? "" : ",") + "?";
		}
		sqlStr.append(" select                                                                ");
		sqlStr.append(" dfp.id_dfp,                                                           ");
		sqlStr.append(" dfp.name,                                                             ");
		sqlStr.append(" dfp.no_bar,                                                           ");
		sqlStr.append(" docprd.code as name_emp_pro,                                          ");
		sqlStr.append(" temp.dt_stz,                                                          ");
		sqlStr.append(" temp.sortno,                                                          ");
		sqlStr.append(" dfp.dt_inval as dt_end,                                               ");
		sqlStr.append(" temp.name_stz as name_stz_instr,                                      ");
		sqlStr.append(" temp.name_chk as name_emp_chk                                         ");
		sqlStr.append(" from cssd_dfp dfp                                                     ");
		sqlStr.append(" inner join  bd_psndoc docprd on docprd.id_psndoc = dfp.id_emp_prd     ");
		sqlStr.append(" left join                                                             ");
		sqlStr.append(" (                                                                     ");
		sqlStr.append("   select                                                              ");
		sqlStr.append("   stzitm.id_dfp,                                                      ");
		sqlStr.append("   stz.dt_stz,                                                         ");
		sqlStr.append("   stz.sortno,                                                         ");
		sqlStr.append("   ins.code as name_stz,                                               ");
		sqlStr.append("   doc.code as name_chk                                                ");
		sqlStr.append("   from cssd_dfp_stz_itm stzitm                                        ");
		sqlStr.append("   inner join cssd_dfp_stz stz on stz.id_dfp_stz = stzitm.id_dfp_stz   ");
		sqlStr.append("   inner join cssd_instr ins on ins.id_instr = stz.id_dfp_instr        ");
		sqlStr.append("   inner join bd_psndoc doc on doc.id_psndoc = stz.id_emp_stz          ");
		sqlStr.append("   where stzitm.id_dfp in(" + whereIn + ")                             ");
		sqlStr.append(" )temp on temp.id_dfp = dfp.id_dfp                                     ");
		sqlStr.append(" where dfp.id_dfp in(" + whereIn + ")                                  ");
		sqlStr.append(" order by dfp.name                                                     ");
		return sqlStr.toString();
	}

}
