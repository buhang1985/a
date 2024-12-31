package iih.bd.bs.workcalendar.refs;

import iih.bd.bs.workcalendar.d.WorkCalendarDO;
import iih.bd.bs.workcalendar.d.desc.WorkCalendarDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class WorkCalendarRefModel extends RefGridModel {

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[]{ "编码", "名称" };
	}
	
	/**
	 * 显示字段
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[]{ WorkCalendarDO.CODE, WorkCalendarDO.NAME };
	}
	
	/**
	 * 隐藏字段
	 */
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{ WorkCalendarDO.ID_WORKCALENDAR };
	}
	
	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[]{ WorkCalendarDO.CODE,WorkCalendarDO.NAME };
	}
	
	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return WorkCalendarDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return WorkCalendarDO.ID_WORKCALENDAR;
	}
	
	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return WorkCalendarDO.CODE;
	}
	
	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return WorkCalendarDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new WorkCalendarDO(), false);
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
		stringBuilder.append(String.format("%s", WorkCalendarDO.CODE));
		return stringBuilder.toString();
	}
}
