package iih.pe.pbd.qry.refs;

import java.util.List;

import iih.pe.pbd.qry.d.QryDO;
import iih.pe.pbd.qrycond.d.QryCondDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class QryRefsModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {

		return new String[] { QryDO.ID_QRY, QryDO.NAME, };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QryDO.CODE, QryCondDO.DES };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "ID", "值" };
	}

	@Override
	public String getPkFieldCode() {
		return QryDO.ID_QRY;
	}

	@Override
	public String getRefCodeField() {
		return QryDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QryDO.NAME;
	}

	@Override
	public String getRefSql() {

		StringBuffer refSql = new StringBuffer();

		refSql.append("  select id_qry,																  ");
		refSql.append("         name,                                                                 ");
		refSql.append("         code,                                                                 ");
		refSql.append("         des                                                                   ");
		refSql.append("  from (select pe_pitm.id_pitm id_qry,                                         ");
		refSql.append("               pe_pitm.name,                                                   ");
		refSql.append("               pe_pitm.code,                                                   ");
		refSql.append("               'PE_PITM' des                                                   ");
		refSql.append("        from pe_pitm                                                           ");
		refSql.append("        union                                                                  ");
		refSql.append("        select id_pitm_rst id_qry, name, code, 'PE_PITM_RST' des                  ");
		refSql.append("        from PE_PITM_RST                                                       ");
		refSql.append("        union                                                                  ");
		refSql.append("        select id_pitm_diag id_qry, name, code, 'PE_PITM_DIAG' des                ");
		refSql.append("        from PE_PITM_DIAG                                                      ");
		refSql.append("        union                                                                  ");
		refSql.append("        select id_pitm_sugg id_qry, name, code, 'PE_PITM_SUGG' des                ");
		refSql.append("        from PE_PITM_SUGG                                                      ");
		refSql.append("        union                                                                  ");
		refSql.append("        select dep.id_dep id_qry, dep.name, dep.code, 'PE_DEP' des             ");
		refSql.append("        from bd_dep dep where dep.fg_pe = 'Y') cond                            ");
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : whereList) {
				refSql.append(" and (").append(where).append(") ");
			}
		}

		List<String> orderList = this.getOrderPart();
		if (orderList.size() > 0) {
			refSql.append(" order by ");
			for (int i = 0; i < orderList.size(); i++) {
				String order = orderList.get(i);
				refSql.append((i == 0 ? "" : ",") + order);
			}
		}

		return refSql.toString();
	}

	@Override
	public String getTableName() {
		return new QryDO().getTableName();
	}
}
