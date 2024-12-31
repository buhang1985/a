package iih.bd.pp.modifypriplan.refs;

import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ModifyPriPlanRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] {ModifyPriPlanDO.CODE, ModifyPriPlanDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ModifyPriPlanDO.ID_MODIFYPRIPLAN };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	
	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}
	
	@Override
	public String getPkFieldCode() {
		return ModifyPriPlanDO.ID_MODIFYPRIPLAN;
	}
	
	@Override
	public String getRefCodeField() {
		return ModifyPriPlanDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return ModifyPriPlanDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new ModifyPriPlanDO().getTableName();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { ModifyPriPlanDO.NAME, ModifyPriPlanDO.CODE, ModifyPriPlanDO.MNECODE, ModifyPriPlanDO.PYCODE, ModifyPriPlanDO.WBCODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ModifyPriPlanDO(), false);
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
		stringBuilder.append(String.format("%s", ModifyPriPlanDO.CODE));
		return stringBuilder.toString();
	}
}
