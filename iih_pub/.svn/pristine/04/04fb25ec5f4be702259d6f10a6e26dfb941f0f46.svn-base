package iih.bd.fc.triagecmpt.refs;

import iih.bd.fc.triagecmpt.d.TriageCmptDO;
import iih.bd.fc.triagecmpt.d.desc.TriageCmptDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 检伤主诉表格参照模型
 * 
 * @author hao_wu
 *
 */
public class TriageCmptRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { TriageCmptDO.CODE, TriageCmptDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { TriageCmptDO.ID_TRIAGECMPT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { TriageCmptDO.CODE, TriageCmptDO.NAME, TriageCmptDO.PYCODE, TriageCmptDO.WBCODE,
				TriageCmptDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return TriageCmptDO.ID_TRIAGECMPT;
	}

	@Override
	public String getRefCodeField() {
		return TriageCmptDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return TriageCmptDO.NAME;
	}

	@Override
	public String getTableName() {
		return TriageCmptDODesc.TABLE_NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new TriageCmptDO(), false);
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
		stringBuilder.append(String.format("%s", TriageCmptDO.CODE));
		return stringBuilder.toString();
	}
}
