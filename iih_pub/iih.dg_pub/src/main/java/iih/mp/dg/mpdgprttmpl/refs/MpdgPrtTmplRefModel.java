package iih.mp.dg.mpdgprttmpl.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.mp.dg.mpdgprttmpl.d.MpdgPrtTmplDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class MpdgPrtTmplRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MpdgPrtTmplDO.CODE, MpdgPrtTmplDO.NAME, };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MpdgPrtTmplDO.ID_PRTTMPL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MpdgPrtTmplDO.ID_PRTTMPL;
	}

	@Override
	public String getRefCodeField() {
		return MpdgPrtTmplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MpdgPrtTmplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MpdgPrtTmplDO().getTableName();
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MpdgPrtTmplDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		return stringBuilder.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MpdgPrtTmplDO.PYCODE, MpdgPrtTmplDO.WBCODE, MpdgPrtTmplDO.MNECODE };
	}

}
