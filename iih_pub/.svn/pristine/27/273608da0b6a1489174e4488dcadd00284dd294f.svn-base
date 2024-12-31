package iih.bd.srv.medsrv.refs;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;

public class MedSrvSetItemModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedSrvDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedSrvDO.ID_SRV, MedSrvDO.ID_UNIT_MED, MedSrvDO.QUAN_MED, MedSrvDO.MED_NAME };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedSrvDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "服务名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MedSrvDO.ID_SRV;
	}

	@Override
	public String getRefNameField() {
		return MedSrvDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MedSrvDO().getTableName();
	}

	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		String[] fields = this.getBlurFields();
		if (fields == null) {
			fields = this.getShowFieldCode();
		}
		StringBuilder buf = new StringBuilder();

		for (String item : fields) {
			buf.append(buf.length() > 0 ? " or " : "(");

			buf.append("lower(bd_srv." + item + ") like '%" + blurValue.toLowerCase() + "%'");
		}

		buf.append(")");

		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}

	@Override
	public String getRefSql() {
		String fg_set = (String) this.getExtendAttributeValue("Fg_set");
		String id_srv = (String) this.getExtendAttributeValue("Id_srv");
		StringBuffer sql = new StringBuffer();
		if (fg_set != null && fg_set.equals("Y")) {
			sql.append("select ");
			sql.append(
					"bd_srv.name as name,bd_srv.id_srv as id_srv,def.id_medu as id_unit_med ,def.quan_medu as quan_med,mc.name as Med_name ");
			sql.append("from bd_srv bd_srv  inner join bd_srvset_def def ");
			sql.append("on bd_srv.id_srv = def.id_srv_itm ");
			sql.append("inner join bd_measdoc mc ");
			sql.append("on def.id_medu = mc.id_measdoc ");
			sql.append("where def.fg_clinical = 'Y' ");
			sql.append("and def.id_srv = '" + id_srv + "' and def.ds = 0 ");
		} else {
			sql.append("select ");
			sql.append(
					"bd_srv.name as name,bd_srv.id_srv as id_srv,bd_srv.id_unit_med as id_unit_med,bd_srv.quan_med as quan_med,mc.name as Med_name ");
			sql.append("from bd_srv bd_srv ");
			sql.append("inner join bd_measdoc mc ");
			sql.append("on bd_srv.id_unit_med = mc.id_measdoc ");
			if (!StringUtil.isEmptyWithTrim(id_srv))
				sql.append("where bd_srv.id_srv='" + id_srv + "'");
		}
		List<String> whereParts = this.getWherePart();
		for (String wherepart : whereParts) {
			sql.append(" and " + wherepart);
		}

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "bd_srv");
		sql.append(String.format(" and %s ", BdModeWherePart));

		return sql.toString();
	}
}
