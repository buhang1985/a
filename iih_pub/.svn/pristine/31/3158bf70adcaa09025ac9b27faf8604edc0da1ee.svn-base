package iih.bd.fc.querule.refs;

import org.apache.commons.lang3.StringUtils;

import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class QueRuleRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { QueRuleDO.CODE, QueRuleDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QueRuleDO.ID_QUERULE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return QueRuleDO.ID_QUERULE;
	}

	@Override
	public String getRefCodeField() {
		return QueRuleDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QueRuleDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QueRuleDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { QueRuleDO.CODE, QueRuleDO.NAME, QueRuleDO.PYCODE, QueRuleDO.WBCODE, QueRuleDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QueRuleDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));

		String sd_quebentp = (String) this.getExtendAttributeValue("sd_quebentp");
		if (!StringUtils.isBlank(sd_quebentp)) {
			String str = String.format(" and sd_quebentp = '%s'", sd_quebentp);
			stringBuilder.append(str);
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
		stringBuilder.append(String.format("%s", QueRuleDO.CODE));
		return stringBuilder.toString();
	}
}
