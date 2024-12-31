package iih.hr.hsc.hscsi.refs;

import iih.hr.Utils.HrEnvContextUtil;
import iih.hr.hsc.hscsi.d.HscSiDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class HscSiRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getBlurFields() {
		return new String[] { HscSiDO.MNECODE, HscSiDO.WBCODE, HscSiDO.PYCODE, HscSiDO.NAME, HscSiDO.NAME_SHORT };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HscSiDO.ID_HSC_SI };
	}

	@Override
	public String getPkFieldCode() {
		return HscSiDO.ID_HSC_SI;
	}

	@Override
	public String getRefCodeField() {
		return HscSiDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HscSiDO.NAME;
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HscSiDO.NAME, HscSiDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "班次", "编码" };
	}

	@Override
	public String getTableName() {
		return new HscSiDO().getTableName();

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
		String BdModeWherePart = HrEnvContextUtil.processEnvContext(new HscSiDO(), false);
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
		stringBuilder.append(HscSiDO.SORTNO);
		return stringBuilder.toString();
	}

}
