package iih.bd.srv.cherbboilmd.refs;

import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class CherbboilsRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { CHerbBoilDesDO.NAME, CHerbBoilDesDO.CODE, CHerbBoilDesDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CHerbBoilDesDO.ID_BOILDES, CHerbBoilDesDO.ID_BOIL, CHerbBoilDesDO.WBCODE,
				CHerbBoilDesDO.PYCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "煎法要求", "编码", "助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return CHerbBoilDesDO.ID_BOILDES;
	}

	@Override
	public String getRefCodeField() {
		return CHerbBoilDesDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CHerbBoilDesDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CHerbBoilDesDO().getTableName();
	}

	@Override
	public String afterBuilderSql(String sql) {

		return super.afterBuilderSql(sql);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CHerbBoilDesDO.NAME, CHerbBoilDesDO.CODE, CHerbBoilDesDO.MNECODE, CHerbBoilDesDO.WBCODE,
				CHerbBoilDesDO.PYCODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CHerbBoilDesDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String Id_boil = (String) this.getExtendAttributeValue("Id_boil");

		if (Id_boil != null && !Id_boil.equals("")) {
			stringBuilder.append("and id_boil = '" + Id_boil + "'  ");

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
		return stringBuilder.toString();
	}
}
