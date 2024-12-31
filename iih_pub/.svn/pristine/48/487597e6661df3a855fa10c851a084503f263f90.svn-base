package iih.bd.mhi.referralapprcate.refs;

import iih.bd.mhi.referralapprcate.d.ReferralApprCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ReferralApprCateModel  extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { ReferralApprCateDO.CODE, ReferralApprCateDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ReferralApprCateDO.ID_REFERAPPCATE, ReferralApprCateDO.ID_HP, ReferralApprCateDO.PYCODE, ReferralApprCateDO.WBCODE,
				ReferralApprCateDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { ReferralApprCateDO.CODE, ReferralApprCateDO.NAME, ReferralApprCateDO.PYCODE, ReferralApprCateDO.WBCODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return ReferralApprCateDO.ID_REFERAPPCATE;
	}

	@Override
	public String getRefCodeField() {
		return ReferralApprCateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ReferralApprCateDO.NAME;
	}

	@Override
	public String getTableName() {
		return new ReferralApprCateDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ReferralApprCateDO(), false);
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
		stringBuilder.append(String.format("%s", ReferralApprCateDO.CODE));
		return stringBuilder.toString();
	}
}
