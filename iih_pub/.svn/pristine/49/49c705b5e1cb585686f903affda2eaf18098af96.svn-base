package iih.bd.mhi.hptreat.refs;

import iih.bd.mhi.hptreat.d.HpTreatDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class HpTreatRefModel extends RefGridModel{


	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpTreatDO.CODE, HpTreatDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return HpTreatDO.CODE;
	}

	@Override
	public String getRefCodeField() {
		return HpTreatDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpTreatDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpTreatDO.NAME, HpTreatDO.CODE, HpTreatDO.PYCODE, HpTreatDO.WBCODE, HpTreatDO.ZDYCODE };
	}

	@Override
	public String getTableName() {
		return new HpTreatDO().getTableName();
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
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpTreatDO(), false);
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
		stringBuilder.append(String.format("%s", HpTreatDO.CODE));
		return stringBuilder.toString();
	}


}
