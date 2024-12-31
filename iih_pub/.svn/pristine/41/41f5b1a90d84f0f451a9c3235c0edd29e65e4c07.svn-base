package iih.bd.srv.ortpl.ref;

import iih.bd.srv.ortpl.d.OrTmplDO;

import java.util.List;

import xap.mw.core.data.Context;
import xap.sys.appfw.refinfo.RefGridModel;

import com.mysql.jdbc.StringUtils;

public class OrTmplRefExModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { OrTmplDO.CODE, OrTmplDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OrTmplDO.ID_ORTMPL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return OrTmplDO.ID_ORTMPL;
	}

	@Override
	public String getRefCodeField() {
		return OrTmplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return OrTmplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new OrTmplDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public String getRefSql() {
		String sql = "SELECT bd_srv_ortmpl.code, bd_srv_ortmpl.name, bd_srv_ortmpl.id_ortmpl " 
	            + " FROM bd_srv_ortmpl"
				+ " LEFT OUTER JOIN bd_srv_ortmpl_ca_rel ORTMPLCAREL ON ORTMPLCAREL.id_ortmpl = bd_srv_ortmpl.id_ortmpl"
				+ " LEFT OUTER JOIN bd_srv_ortmpl_ca ORTMPLCA ON ORTMPLCA.id_ortmplca = ORTMPLCAREL.id_ortmplca"
				+ " WHERE ORTMPLCAREL.fg_sync='Y' AND bd_srv_ortmpl.fg_sync='N' AND bd_srv_ortmpl.fg_active='Y'"
		        + " and bd_srv_ortmpl.id_grp = '" + Context.get().getGroupId() + "' and bd_srv_ortmpl.id_org = '" + Context.get().getOrgId() + "'";
		String wherePart = "";
		String id_org = (String) this.getExtendAttributeValue("Id_org");
		String id_dep = (String) this.getExtendAttributeValue("Id_dep");
		String id_emp = (String) this.getExtendAttributeValue("Id_emp");

		if(!StringUtils.isNullOrEmpty(id_org)){
			if(wherePart.length()>0)
				wherePart += "or";
			wherePart += " (ORTMPLCA.sd_srvorrt='0' AND ORTMPLCA.id_org='" + id_org + "')";
		}
		if(!StringUtils.isNullOrEmpty(id_dep)){
			if(wherePart.length()>0)
				wherePart += "or";
			wherePart += " (ORTMPLCA.sd_srvorrt='1' AND ORTMPLCA.id_dep='" + id_dep + "')";
		}
		if(!StringUtils.isNullOrEmpty(id_emp)){
			if(wherePart.length()>0)
				wherePart += "or";
			wherePart += " (ORTMPLCA.sd_srvorrt='2' AND ORTMPLCA.id_emp='" + id_emp + "')";
		}

		List<String> wherepartArr = this.getWherePart();
		for (String strWhere : wherepartArr) {
			sql = sql + " AND " + strWhere;
		}
		
		if(!StringUtils.isNullOrEmpty(wherePart)) {
			
			sql = sql + " AND (" + wherePart + ")";
		}

		return sql;
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { OrTmplDO.NAME, OrTmplDO.CODE, OrTmplDO.MNECODE, OrTmplDO.PYCODE, OrTmplDO.WBCODE };
	}
}
