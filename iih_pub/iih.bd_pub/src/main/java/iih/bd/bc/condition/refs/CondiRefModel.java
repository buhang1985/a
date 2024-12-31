package iih.bd.bc.condition.refs;

import iih.bd.bc.condition.d.ConditionCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class CondiRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ConditionCateDO.CODE, ConditionCateDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ConditionCateDO.ID_CONTICA, ConditionCateDO.ID_PARENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return ConditionCateDO.ID_CONTICA;
	}

	@Override
	public String getRefCodeField() {
		return ConditionCateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ConditionCateDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ConditionCateDO().getTableName();
	}

	@Override
	public String getFatherField() {
		return ConditionCateDO.ID_PARENT;
	}

	@Override
	public String getChildField() {
		return ConditionCateDO.ID_CONTICA;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ConditionCateDO(), false);
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
