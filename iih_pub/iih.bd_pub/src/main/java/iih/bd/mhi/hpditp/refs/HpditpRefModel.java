package iih.bd.mhi.hpditp.refs;

import iih.bd.mhi.hpditp.d.HpDiTpDO;
import iih.bd.mhi.referralapprcate.d.ReferralApprCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class HpditpRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpDiTpDO.CODE, HpDiTpDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpDiTpDO.ID_HPDITP, ReferralApprCateDO.ID_HP, HpDiTpDO.PYCODE, HpDiTpDO.WBCODE ,HpDiTpDO.MNECODE};
	}

	@Override
	public String getPkFieldCode() {
		return HpDiTpDO.ID_HPDITP;
	}

	@Override
	public String getRefCodeField() {
		return HpDiTpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpDiTpDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpDiTpDO.NAME, HpDiTpDO.CODE, HpDiTpDO.PYCODE, HpDiTpDO.WBCODE ,HpDiTpDO.MNECODE};
	}

	@Override
	public String getTableName() {
		return new HpDiTpDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpDiTpDO(), false);
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
		stringBuilder.append(String.format("%s", HpDiTpDO.CODE));
		return stringBuilder.toString();

	}
}
