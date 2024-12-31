package iih.bd.pp.pripat.refs;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PriPatRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PriPatDO.CODE, PriPatDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PriPatDO.ID_PRIPAT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PriPatDO.CODE, PriPatDO.NAME, PriPatDO.PYCODE, PriPatDO.WBCODE, PriPatDO.MNECODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return PriPatDO.ID_PRIPAT;
	}

	@Override
	public String getRefCodeField() {
		return PriPatDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PriPatDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PriPatDO().getTableName();
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (StringUtils.isNotBlank(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (StringUtils.isNotBlank(orderPart)) {
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

		StringBuilder stringBuilder = new StringBuilder("code <> '999'");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PriPatDO(), false);
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
		stringBuilder.append(String.format("%s", PriPatDO.CODE));
		return stringBuilder.toString();
	}
}
