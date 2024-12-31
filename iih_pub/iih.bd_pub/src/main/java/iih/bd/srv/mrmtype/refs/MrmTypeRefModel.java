package iih.bd.srv.mrmtype.refs;

import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 病案分类参照
 * @author guoyang
 *
 */
public class MrmTypeRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4289448127722574762L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MrmTypeDO.CODE, MrmTypeDO.NAME };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrmTypeDO.ID_BD_MRM_TP };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}
	
	@Override
	public String getPkFieldCode() {
		return MrmTypeDO.ID_BD_MRM_TP;
	}
	
	@Override
	public String getTableName() {
		return new MrmTypeDO().getTableName();
	}
	
	@Override
	public String getRefCodeField() {
		return MrmTypeDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return MrmTypeDO.NAME;

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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrmTypeDO(), false);
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
		stringBuilder.append(String.format("%s", MrmTypeDO.CODE));
		return stringBuilder.toString();
	}

}
