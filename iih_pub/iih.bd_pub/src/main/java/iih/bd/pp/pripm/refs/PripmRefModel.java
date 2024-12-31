package iih.bd.pp.pripm.refs;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class PripmRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PriPmDO.CODE, PriPmDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PriPmDO.ID_PM, PriPmDO.FG_PAYNO };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PriPmDO.NAME, PriPmDO.CODE, PriPmDO.PYCODE, PriPmDO.WBCODE, PriPmDO.MNECODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return PriPmDO.ID_PM;
	}

	@Override
	public String getRefCodeField() {
		return PriPmDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PriPmDO.NAME;
	}

	@Override
	public String getTableName() {
		return new PriPmDO().getTableName();
	}

	@Override
	public String afterBuilderSql(String sql) {
		return super.afterBuilderSql(sql);
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PriPmDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String code1 = (String) this.getExtendAttributeValue("Code1");
		if (code1 != null && !code1.equals("")) {
			stringBuilder.append("and code = '" + code1 + "' ");
		}

		String code2 = (String) this.getExtendAttributeValue("Code2");
		if (code2 != null && !code2.equals("")) {
			stringBuilder.append(" or code='" + code2 + "' ");
		}

		String code3 = (String) this.getExtendAttributeValue("Code3");
		if (code3 != null && !code3.equals("")) {
			stringBuilder.append(" or code='" + code3 + "' ");
		}

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", PriPmDO.CODE));
		return stringBuilder.toString();
	}
}
