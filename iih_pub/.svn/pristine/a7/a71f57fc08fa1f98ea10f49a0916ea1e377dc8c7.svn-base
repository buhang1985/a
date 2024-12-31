package iih.mkr.std.commonde.refs;

import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.deca.d.DataElemCateDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeGridModel;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;

/**
 * 公共数据元树表参照模型
 * 
 * @author hao_wu
 *
 */
public class DeTreeGridRefModel extends RefTreeGridModel {
	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElementDO.ID_DE };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME };
	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementDO.CODE, DataElementDO.NAME };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return new DataElementDO().getTableName();
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return DataElementDO.ID_DE;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return DataElementDO.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return DataElementDO.NAME;
	}

	/**
	 * 分类表名
	 */
	@Override
	public String getClassTableName() {
		return new DataElemCateDO().getTableName();
	}

	/**
	 * 分类字段名数组
	 */
	@Override
	public String[] getClassFieldCode() {
		return new String[] { DataElemCateDO.CODE, DataElemCateDO.NAME, DataElemCateDO.ID_DECA,
				DataElemCateDO.ID_PARENT };
	}

	/**
	 * 分类名称字段
	 */
	@Override
	public String getClassRefNameField() {
		return DataElemCateDO.NAME;
	}

	/**
	 * 分类编码字段
	 */
	@Override
	public String getClassRefCodeField() {
		return DataElemCateDO.CODE;
	}

	/**
	 * 分类主键字段
	 */
	@Override
	public String getClassPkFieldCode() {
		return DataElemCateDO.ID_DECA;
	}

	/**
	 * 档案表中和分类连接的字段
	 */
	@Override
	public String getDocJoinField() {
		return DataElementDO.ID_DECA;
	}

	/**
	 * 分类表中和档案连接的字段---一般是分类主键
	 */
	@Override
	public String getClassJoinField() {
		return DataElemCateDO.ID_DECA;
	}

	/**
	 * 父子键树结构：子字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getChildField() {
		return DataElemCateDO.ID_DECA;
	}

	/**
	 * 父子键树结构：父字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getFatherField() {
		return DataElemCateDO.ID_PARENT;
	}

	/**
	 * 返回分类数据查询过滤条件数组
	 */
	@Override
	public String[] getClassWherePart() {
		return new String[] { "ds = '0'" };
	}

	/**
	 * 返回分类数据查询排序条件
	 */
	@Override
	public String[] getClassOrderPart() {
		return new String[] { DataElemCateDO.CODE, DataElemCateDO.NAME };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
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
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DataElementDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		stringBuilder.append(String.format(" AND fg_active = '%s' ", ActiveStateEnum.ACTIVE));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s,%s", DataElementDO.CODE, DataElementDO.NAME));
		return stringBuilder.toString();
	}
}
