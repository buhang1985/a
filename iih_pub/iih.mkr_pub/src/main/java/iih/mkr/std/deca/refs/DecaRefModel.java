package iih.mkr.std.deca.refs;

import iih.mkr.std.deca.d.DataElemCateDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;;

/**
 * 公共数据元分类树参照
 * 
 * @author hao_wu
 *
 */
public class DecaRefModel extends RefTreeModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424752067019021719L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElemCateDO.CODE, DataElemCateDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DataElemCateDO.ID_DECA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DataElemCateDO.ID_DECA;
	}

	@Override
	public String getRefCodeField() {
		return DataElemCateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DataElemCateDO.NAME;
	}

	@Override
	public String getTableName() {
		return new DataElemCateDO().getTableName();
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
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DataElemCateDO(), false);
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
