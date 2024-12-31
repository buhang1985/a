package iih.bd.fc.triageres.refs;

import iih.bd.fc.triageres.d.TriageResDO;
import iih.bd.fc.triageres.d.desc.TriageResDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 检伤判定表格参照模型
 * 
 * @author hao_wu
 *
 */
public class TriageResRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { TriageResDO.CODE, TriageResDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { TriageResDO.ID_TRIAGERES, TriageResDO.SD_SCALE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { TriageResDO.CODE, TriageResDO.NAME, TriageResDO.PYCODE, TriageResDO.WBCODE,
				TriageResDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return TriageResDO.ID_TRIAGERES;
	}

	@Override
	public String getRefCodeField() {
		return TriageResDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return TriageResDO.NAME;
	}

	@Override
	public String getTableName() {
		return TriageResDODesc.TABLE_NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new TriageResDO(), false);
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
		stringBuilder.append(String.format("%s", TriageResDO.CODE));
		return stringBuilder.toString();
	}
}
