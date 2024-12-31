package iih.bd.pp.incca.refs;

import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class InccaRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { IncCaDO.CODE, IncCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { IncCaDO.ID_INCCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return IncCaDO.ID_INCCA;
	}

	@Override
	public String getRefCodeField() {
		return IncCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return IncCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new IncCaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { IncCaDO.NAME, IncCaDO.CODE, IncCaDO.MNECODE, IncCaDO.PYCODE, IncCaDO.WBCODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new IncCaDO(), false);
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
		stringBuilder.append(String.format("%s", IncCaDO.CODE));
		return stringBuilder.toString();
	}
}
