package iih.bd.mhi.hpentp.refs;

import iih.bd.mhi.hpentp.d.HpEnTpDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医保产品就诊类型标准参照模型
 * 
 * @author hao_wu
 *
 */
public class HpEnTpRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpEnTpDO.CODE, HpEnTpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpEnTpDO.ID_HPENTP ,HpEnTpDO.ID_HP, HpEnTpDO.PYCODE, HpEnTpDO.WBCODE, HpEnTpDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpEnTpDO.CODE, HpEnTpDO.NAME, HpEnTpDO.PYCODE, HpEnTpDO.WBCODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HpEnTpDO.CODE;
	}

	@Override
	public String getRefCodeField() {
		return HpEnTpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpEnTpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HpEnTpDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpEnTpDO(), false);
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
		stringBuilder.append(String.format("%s", HpEnTpDO.CODE));
		return stringBuilder.toString();
	}
}
