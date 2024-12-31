package iih.bd.res.dayslotca.refs;

import iih.bd.res.dayslotca.d.DaysLotcaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DaySlotcaRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DaysLotcaDO.CODE, DaysLotcaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DaysLotcaDO.ID_DAYSLOTCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DaysLotcaDO.ID_DAYSLOTCA;
	}

	@Override
	public String getRefCodeField() {
		return DaysLotcaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DaysLotcaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new DaysLotcaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DaysLotcaDO.CODE, DaysLotcaDO.NAME, DaysLotcaDO.PYCODE, DaysLotcaDO.WBCODE,
				DaysLotcaDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DaysLotcaDO(), false);
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
		stringBuilder.append(String.format("%s", DaysLotcaDO.CODE));
		return stringBuilder.toString();
	}

}
