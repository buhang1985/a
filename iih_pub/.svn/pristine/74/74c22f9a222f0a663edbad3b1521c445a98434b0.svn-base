package iih.mkr.std.deset.refs;

import iih.mkr.std.deset.d.DeDataSetDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 数据集参照模型
 * 
 * @author hao_wu
 *
 */
public class DeSetRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6704217322120840129L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DeDataSetDO.CODE, DeDataSetDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DeDataSetDO.ID_SET, DeDataSetDO.WBCODE, DeDataSetDO.PYCODE };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DeDataSetDO.CODE, DeDataSetDO.WBCODE, DeDataSetDO.PYCODE, DeDataSetDO.NAME,
				DeDataSetDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DeDataSetDO.ID_SET;
	}

	@Override
	public String getTableName() {
		return new DeDataSetDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return DeDataSetDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return DeDataSetDO.NAME;

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
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DeDataSetDO(), false);
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
		stringBuilder.append(String.format("%s", DeDataSetDO.CODE));
		return stringBuilder.toString();
	}
}
