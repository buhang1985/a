package iih.mkr.std.desetca.refs;

import iih.mkr.std.desetca.d.DeSetCaDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 数据集分类参照模型
 * 
 * @author hao_wu
 *
 */
public class DataSetCaRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DeSetCaDO.CODE, DeSetCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DeSetCaDO.ID_SETCA };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DeSetCaDO.ID_SETCA, DeSetCaDO.CODE, DeSetCaDO.NAME, DeSetCaDO.PYCODE, DeSetCaDO.WBCODE,
				DeSetCaDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DeSetCaDO.ID_SETCA;
	}

	@Override
	public String getTableName() {
		return new DeSetCaDO().getTableName();
	}

	@Override
	public String getRefNameField() {
		return DeSetCaDO.NAME;
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
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DeSetCaDO(), false);
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
