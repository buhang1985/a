package iih.bd.srv.medusage.refs;

import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MedusageDesRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedUsageDesDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedUsageDesDO.ID_ROUTEDES, MedUsageDesDO.WBCODE, MedUsageDesDO.PYCODE,
				MedUsageDesDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "用法名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MedUsageDesDO.ID_ROUTEDES;
	}

	@Override
	public String getRefCodeField() {
		return MedUsageDesDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MedUsageDesDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MedUsageDesDO().getTableName();
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
		}

		return refSql;
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedUsageDesDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String Id_route = (String) this.getExtendAttributeValue("Id_route");
		if (Id_route != null && !Id_route.equals("")) {
			stringBuilder.append(" and id_route = '" + Id_route + "'  ");
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", MedUsageDesDO.NAME));
		return stringBuilder.toString();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedUsageDesDO.CODE, MedUsageDesDO.WBCODE, MedUsageDesDO.PYCODE, MedUsageDesDO.MNECODE,
				MedUsageDesDO.NAME };
	}
}
