package iih.ci.mrm.healthsystem.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mrm.healthsystem.d.ValueContrastDO;
import iih.ci.mrm.healthsystem.d.desc.ValueContrastDODesc;
import xap.sys.appfw.refinfo.RefGridModel;

public class ValueContrastRefModel extends RefGridModel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { ValueContrastDO.SD_VALUE_COMPARISON, ValueContrastDO.NAME_VALUE_COMPARISON };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ValueContrastDO.ID_VALUE_COMPARISON };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { ValueContrastDO.SD_VALUE_COMPARISON, ValueContrastDO.NAME_VALUE_COMPARISON };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return ValueContrastDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return ValueContrastDO.ID_VALUE_COMPARISON;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return ValueContrastDO.SD_VALUE_COMPARISON;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return ValueContrastDO.NAME_VALUE_COMPARISON;
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
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ValueContrastDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", ValueContrastDO.SD_VALUE_COMPARISON));
		return stringBuilder.toString();
	}
	
}
