package iih.bd.pp.anhuiinsur.i.refs;

import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class FwssOrginalRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6450128870058791878L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpFwssOrginalDO.CODE, BdHpFwssOrginalDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpFwssOrginalDO.ID_HPFWSSORGINAL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return BdHpFwssOrginalDO.CODE;
	}

	@Override
	public String getRefCodeField() {
		return BdHpFwssOrginalDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdHpFwssOrginalDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdHpFwssOrginalDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdHpFwssOrginalDO.NAME, BdHpFwssOrginalDO.CODE, BdHpFwssOrginalDO.PY_CODE,
				BdHpFwssOrginalDO.WB_CODE, BdHpFwssOrginalDO.ZDY_CODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpFwssOrginalDO(), false);
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
		stringBuilder.append(String.format("%s", BdHpFwssOrginalDO.CODE));
		return stringBuilder.toString();
	}

}
