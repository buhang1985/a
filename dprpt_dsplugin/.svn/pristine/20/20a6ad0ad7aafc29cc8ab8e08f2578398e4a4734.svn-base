package iih.mp.nr.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @Description:检验标本信息获取
 * @author: xu_xing@founder.com.cn
 * @version：2018年8月28日 下午2:09:42 创建
 */
public class GetTestLableSql implements ITransQry {

	private String fg_prnt;
	private String[] id_samtps;
	private String nameTable;

	public void setTemTableName(String nameTable) {
		this.nameTable = nameTable;
	}

	public GetTestLableSql(String fg_prnt, String[] id_samtps) {
		this.fg_prnt = fg_prnt;
		this.id_samtps = id_samtps;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (id_samtps != null && id_samtps.length > 0) {
			for (String id_samtp : id_samtps) {
				param.addParam(id_samtp);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                  ");
		sqlStr.append(" sam.id_labsamp,                                                         ");
		sqlStr.append(" sam.no_bar,                                                             ");
		sqlStr.append(" sam.name_lab,                                                           ");
		sqlStr.append(" enent.name_pat,                                                         ");
		sqlStr.append(" enentip.name_bed,                                                       ");
		sqlStr.append(" pat.code as code_pat,                                                   ");
		sqlStr.append(" enentip.code_amr_ip,                                                    ");
		sqlStr.append(" enent.dt_birth_pat,                                                     ");
		sqlStr.append(" enentip.name_bed,                                                       ");
		sqlStr.append(" docsex.name as name_sex,                                                ");
		sqlStr.append(" docsamtp.name as name_samtp,                                            ");
		sqlStr.append(" docstube.name as name_tubetp,                                           ");
		sqlStr.append(" (case sam.fg_urgent when 'Y' then '急' else '普' end) as name_urgnt,    ");
		sqlStr.append(" sam.quan,                                                               ");
		sqlStr.append(" measdoc.name as name_measdoc,                                           ");
		sqlStr.append(" depphy.name as name_dep_phy,                                            ");
		sqlStr.append(" depnur.name as name_dep_nur                                             ");
		sqlStr.append(" from mp_ne_lab_samp sam                                                 ");
		sqlStr.append(" inner join " + this.nameTable + " temtable on temtable.id_ent = sam.id_ent ");
		sqlStr.append(" left join bd_udidoc docsamtp on docsamtp.id_udidoc = sam.id_labsamptp   ");
		sqlStr.append(" left join bd_udidoc docstube on docstube.id_udidoc = sam.id_tubetp      ");
		sqlStr.append(" left join en_ent enent on enent.id_ent = sam.id_ent                     ");
		sqlStr.append(" left join en_ent_ip enentip on enent.id_ent = enentip.id_ent            ");
		sqlStr.append(" left join pi_pat pat on enent.id_pat = pat.id_pat                       ");
		sqlStr.append(" left join bd_udidoc docsex on docsex.id_udidoc = enent.id_sex_pat       ");
		sqlStr.append(" left join bd_measdoc measdoc on measdoc.id_measdoc = sam.id_unit_quan   ");
		sqlStr.append(" left join bd_dep depphy on depphy.id_dep = enent.id_dep_phy             ");
		sqlStr.append(" left join bd_dep depnur on depnur.id_dep = enent.id_dep_nur             ");
		sqlStr.append(" where enent.fg_ip = 'Y'                                                 ");
		sqlStr.append(" and enent.code_entp = '10'                                              ");
		if (!StringUtil.isEmptyWithTrim(this.fg_prnt) && !"0".equals(this.fg_prnt)) {
			if ("1".equals(this.fg_prnt))
				//已打印
				sqlStr.append(" and sam.ct_prn > 0                                               ");
			else
				sqlStr.append(" and sam.ct_prn = 0                                               ");
		}
		if (id_samtps != null && id_samtps.length > 0) {
			String whereStr = "";
			for (int i = 0; i < id_samtps.length; i++) {
				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}
			if (!StringUtil.isEmptyWithTrim(whereStr))
				sqlStr.append(" and sam.id_labsamptp in ( " + whereStr + " )                    ");
		}
		return sqlStr.toString();
	}
}
