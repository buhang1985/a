package iih.bd.bs.workcalendarrule.refs;

import iih.bd.bs.workcalendarrule.d.WorkCalendarRuleDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 工作日历规则参照
 * 
 * @author hao_wu
 *
 */
public class WorkCalendarRuleRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return (new String[] { WorkCalendarRuleDO.CODE, WorkCalendarRuleDO.NAME });
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { WorkCalendarRuleDO.ID_WORKCALENDARRULE });
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "编码", "名称" });
	}

	@Override
	public String getPkFieldCode() {
		return WorkCalendarRuleDO.ID_WORKCALENDARRULE;
	}

	@Override
	public String getRefCodeField() {
		return WorkCalendarRuleDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return WorkCalendarRuleDO.NAME;
	}

	@Override
	public String getTableName() {
		return new WorkCalendarRuleDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { WorkCalendarRuleDO.NAME, WorkCalendarRuleDO.CODE };
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
		stringBuilder.append(" and ds = '0' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new WorkCalendarRuleDO(), false);
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
		stringBuilder.append(String.format("%s", WorkCalendarRuleDO.CODE));
		return stringBuilder.toString();
	}
}
