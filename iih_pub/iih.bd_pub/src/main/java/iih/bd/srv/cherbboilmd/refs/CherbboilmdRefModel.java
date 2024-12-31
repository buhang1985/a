package iih.bd.srv.cherbboilmd.refs;

import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class CherbboilmdRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { CHerbBoilMdDO.NAME, CHerbBoilMdDO.CODE, CHerbBoilMdDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CHerbBoilMdDO.ID_BOIL, CHerbBoilMdDO.PYCODE, CHerbBoilMdDO.WBCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "煎法名称", "编码", "助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return CHerbBoilMdDO.ID_BOIL;
	}

	@Override
	public String getRefCodeField() {
		return CHerbBoilMdDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CHerbBoilMdDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CHerbBoilMdDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CHerbBoilMdDO.NAME, CHerbBoilMdDO.CODE, CHerbBoilMdDO.MNECODE, CHerbBoilMdDO.WBCODE,
				CHerbBoilMdDO.PYCODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CHerbBoilMdDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

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
