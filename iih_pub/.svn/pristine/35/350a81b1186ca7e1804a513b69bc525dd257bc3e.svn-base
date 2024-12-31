package iih.bd.pp.mpayratiodf.refs;

import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 多支付比例字典标准参照模型
 * 
 * @author hao_wu
 *
 */
public class MPayRatioDfRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MPayRatioDfDO.CODE, MPayRatioDfDO.NAME, MPayRatioDfDO.NOTE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MPayRatioDfDO.ID_HPMPAYRATIODF, MPayRatioDfDO.ID_HP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "备注" };
	}

	@Override
	public String getPkFieldCode() {
		return MPayRatioDfDO.ID_HPMPAYRATIODF;
	}

	@Override
	public String getTableName() {
		return new MPayRatioDfDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MPayRatioDfDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return MPayRatioDfDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MPayRatioDfDO.CODE, MPayRatioDfDO.NAME, MPayRatioDfDO.NOTE };
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

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MPayRatioDfDO(), false);
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
		stringBuilder.append(String.format("%s", MPayRatioDfDO.CODE));
		return stringBuilder.toString();
	}
}
