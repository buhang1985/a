package iih.bd.pp.anhuiinsur.i.refs;

import iih.bd.pp.anhuiinsur.d.BdHpRegionOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 安徽医保地区字典参照模型
 * 
 * @author hao_wu
 *
 */
public class RegionOrginalRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6455177358860670300L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpRegionOrginalDO.CODE, BdHpRegionOrginalDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpRegionOrginalDO.ID_HPREGION };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return BdHpRegionOrginalDO.CODE;
	}

	@Override
	public String getRefCodeField() {
		return BdHpRegionOrginalDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdHpRegionOrginalDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdHpRegionOrginalDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdHpRegionOrginalDO.NAME, BdHpRegionOrginalDO.CODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpRegionOrginalDO(), false);
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
		stringBuilder.append(String.format("%s", BdHpRegionOrginalDO.CODE));
		return stringBuilder.toString();
	}
}