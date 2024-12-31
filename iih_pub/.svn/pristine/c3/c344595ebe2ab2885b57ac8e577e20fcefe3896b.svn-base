package iih.bd.mhi.hpfeeca.refs;

import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医保产品费用类别字典标准参照模型
 * 
 * @author dj.zhang
 *
 */
public class HpFeecaRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HpFeecaDO.CODE, HpFeecaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HpFeecaDO.ID_HPFEECA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HpFeecaDO.CODE, HpFeecaDO.NAME };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HpFeecaDO.ID_HPFEECA;
	}

	@Override
	public String getRefCodeField() {
		return HpFeecaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HpFeecaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HpFeecaDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HpFeecaDO(), false);
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
		stringBuilder.append(String.format("%s", HpFeecaDO.CODE));
		return stringBuilder.toString();
	}
}
