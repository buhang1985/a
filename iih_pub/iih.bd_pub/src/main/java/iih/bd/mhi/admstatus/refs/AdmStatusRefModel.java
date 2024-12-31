package iih.bd.mhi.admstatus.refs;

import iih.bd.mhi.admstatus.d.AdmStatusDO;
import iih.bd.mhi.admstatus.d.desc.AdmStatusDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class AdmStatusRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { AdmStatusDO.CODE, AdmStatusDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { AdmStatusDO.ID_ADMSTATUS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { AdmStatusDO.CODE, AdmStatusDO.NAME, AdmStatusDO.PYCODE, AdmStatusDO.WBCODE,
				AdmStatusDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return AdmStatusDO.ID_ADMSTATUS;
	}

	@Override
	public String getRefCodeField() {
		return AdmStatusDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return AdmStatusDO.NAME;
	}

	@Override
	public String getTableName() {
		return AdmStatusDODesc.TABLE_NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new AdmStatusDO(), false);
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
		stringBuilder.append(String.format("%s", AdmStatusDO.CODE));
		return stringBuilder.toString();
	}
}
