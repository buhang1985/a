package iih.mkr.std.dedg.refs;

import iih.mkr.std.dedg.d.DeDataGrpDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

/**
 * 公共数据组参照
 * 
 * @author hao_wu
 *
 */
public class DgRefModel extends RefTreeModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8227287665193603520L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DeDataGrpDO.CODE, DeDataGrpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DeDataGrpDO.ID_DG, DeDataGrpDO.ID_PARENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return new DeDataGrpDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return DeDataGrpDO.ID_DG;
	}

	@Override
	public String getRefCodeField() {
		return DeDataGrpDO.CODE;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DeDataGrpDO.CODE, DeDataGrpDO.WBCODE, DeDataGrpDO.PYCODE, DeDataGrpDO.NAME,
				DeDataGrpDO.MNECODE };
	}

	@Override
	public String getRefNameField() {
		return DeDataGrpDO.NAME;
	}

	@Override
	public String getChildField() {
		return DeDataGrpDO.ID_DG;
	}

	@Override
	public String getFatherField() {
		return DeDataGrpDO.ID_PARENT;
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
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DeDataGrpDO(), false);
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
		stringBuilder.append(String.format("%s", DeDataGrpDO.CODE));
		return stringBuilder.toString();
	}

}
