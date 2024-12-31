package iih.bd.fc.tagtp.refs;

import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class TapTpRefModel extends RefGridModel {
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdTagTpDO.CODE, BdTagTpDO.NAME, BdTagTpDO.SHORTNAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdTagTpDO.ID_TAGTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称","简称" };
	}

	@Override
	public String getPkFieldCode() {
		return BdTagTpDO.ID_TAGTP;
	}

	@Override
	public String getRefCodeField() {
		return BdTagTpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdTagTpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdTagTpDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdTagTpDO.CODE, BdTagTpDO.NAME, BdTagTpDO.SHORTNAME, BdTagTpDO.PYCODE, BdTagTpDO.WBCODE, BdTagTpDO.MNECODE };
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
	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdTagTpDO(), false);
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
		stringBuilder.append(String.format("%s", BdTagTpDO.CODE));
		return stringBuilder.toString();
	}
}
