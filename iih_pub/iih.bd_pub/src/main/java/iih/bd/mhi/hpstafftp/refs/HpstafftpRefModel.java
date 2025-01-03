package iih.bd.mhi.hpstafftp.refs;

import iih.bd.mhi.hpstafftp.d.HpStaffTpDO;
import iih.bd.mhi.referralapprcate.d.ReferralApprCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class HpstafftpRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpStaffTpDO.CODE, HpStaffTpDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpStaffTpDO.ID_HPSTAFFTP, ReferralApprCateDO.ID_HP, HpStaffTpDO.PYCODE, HpStaffTpDO.WBCODE ,HpStaffTpDO.MNECODE};
	}

	@Override
	public String getPkFieldCode() {
		return HpStaffTpDO.ID_HPSTAFFTP;
	}

	@Override
	public String getRefCodeField() {
		return HpStaffTpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpStaffTpDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpStaffTpDO.NAME, HpStaffTpDO.CODE, HpStaffTpDO.PYCODE, HpStaffTpDO.WBCODE ,HpStaffTpDO.MNECODE};
	}

	@Override
	public String getTableName() {
		return new HpStaffTpDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpStaffTpDO(), false);
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
		stringBuilder.append(String.format("%s", HpStaffTpDO.CODE));
		return stringBuilder.toString();

	}
}
