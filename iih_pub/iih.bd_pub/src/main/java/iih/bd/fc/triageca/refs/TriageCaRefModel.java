package iih.bd.fc.triageca.refs;

import iih.bd.fc.triageca.d.TriageCaDO;
import iih.bd.fc.triageca.d.desc.TriageCaDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 检伤分类表格参照模型
 * 
 * @author hao_wu
 *
 */
public class TriageCaRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { TriageCaDO.CODE, TriageCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { TriageCaDO.ID_TRIAGECA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { TriageCaDO.CODE, TriageCaDO.NAME, TriageCaDO.PYCODE, TriageCaDO.WBCODE,
				TriageCaDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return TriageCaDO.ID_TRIAGECA;
	}

	@Override
	public String getRefCodeField() {
		return TriageCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return TriageCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return TriageCaDODesc.TABLE_NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new TriageCaDO(), false);
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
		stringBuilder.append(String.format("%s", TriageCaDO.CODE));
		return stringBuilder.toString();
	}
}
