package iih.bd.srv.paragraphtype.refs;

import iih.bd.srv.paragraphtype.d.ParagraphTypeDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ParagraphTypeRefs extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { ParagraphTypeDO.CODE, ParagraphTypeDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ParagraphTypeDO.ID_PARAGRAPHTYPE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return ParagraphTypeDO.ID_PARAGRAPHTYPE;
	}

	@Override
	public String getTableName() {
		return new ParagraphTypeDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return ParagraphTypeDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ParagraphTypeDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ParagraphTypeDO(), false);
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
		stringBuilder.append(String.format("%s", ParagraphTypeDO.CODE));
		return stringBuilder.toString();
	}

}
