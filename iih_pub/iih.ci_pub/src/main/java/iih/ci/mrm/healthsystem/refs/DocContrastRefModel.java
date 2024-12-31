package iih.ci.mrm.healthsystem.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.mrm.healthsystem.d.DocContrastDO;
import iih.ci.mrm.healthsystem.d.desc.DocContrastDODesc;
import xap.sys.appfw.refinfo.RefGridModel;

public class DocContrastRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "转换编码", "转换名称" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DocContrastDO.CODE_DOC_COMPARISON, DocContrastDO.NAME_DOC_COMPARISON };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DocContrastDO.ID_DOC_COMPARISON };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { DocContrastDO.CODE_DOC_COMPARISON, DocContrastDO.NAME_DOC_COMPARISON };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return DocContrastDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return DocContrastDO.ID_DOC_COMPARISON;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return DocContrastDO.CODE_DOC_COMPARISON;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return DocContrastDO.NAME_DOC_COMPARISON;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DocContrastDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DocContrastDO.CODE_DOC_COMPARISON));
		return stringBuilder.toString();
	}
	
}
