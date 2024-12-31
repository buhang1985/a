package iih.bd.srv.operatetype.refs;

import iih.bd.srv.operatetype.d.OperateTypeDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 操作类型参照
 * @author guoyang
 *
 */
public class OperateTypeRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2462460927843068890L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { OperateTypeDO.CODE, OperateTypeDO.NAME };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OperateTypeDO.ID_BD_MRM_OT };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return OperateTypeDO.ID_BD_MRM_OT;
	}
	
	@Override
	public String getTableName() {
		return new OperateTypeDO().getTableName();
	}
	
	@Override
	public String getRefCodeField() {
		return OperateTypeDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return OperateTypeDO.NAME;

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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new OperateTypeDO(), false);
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
		stringBuilder.append(String.format("%s", OperateTypeDO.CODE));
		return stringBuilder.toString();
	}

}
