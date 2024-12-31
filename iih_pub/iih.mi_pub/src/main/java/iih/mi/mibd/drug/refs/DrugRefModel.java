package iih.mi.mibd.drug.refs;

import iih.mi.mibd.drug.d.DrugDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 药品对照服务
 *
 *@author hexx
 */
public class DrugRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;
	@Override
	public String[] getShowFieldCode() {
		return new String[]{DrugDO.CODE,DrugDO.NAME};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码", "名称"};
	}
	@Override
	public String getPkFieldCode() {
		return DrugDO.CODE;
	}
	@Override
	public String getRefCodeField() {
		return DrugDO.CODE;
	}
	@Override
	public String getRefNameField() {
		return DrugDO.NAME;
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[]{DrugDO.NAME,DrugDO.CODE,DrugDO.PYCODE,DrugDO.WBCODE};
	}

	@Override
	public String getTableName() {
		return new DrugDO().getTableName();
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
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DrugDO(), false);
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
		stringBuilder.append(String.format("%s", DrugDO.CODE));
		return stringBuilder.toString();
		
	}
}
