package iih.mi.mibd.mis.refs;

import iih.mi.mibd.mis.d.MisDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 医保系统标准参照模型
 * 
 * @author hao_wu
 *
 */
public class MisRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MisDO.CODE, MisDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MisDO.ID_MIS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MisDO.ID_MIS;
	}

	@Override
	public String getRefCodeField() {
		return MisDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MisDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MisDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MisDO.NAME, MisDO.CODE, MisDO.PYCODE, MisDO.WBCODE, MisDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MisDO(), false);
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
		stringBuilder.append(String.format("%s", MisDO.CODE));
		return stringBuilder.toString();
	}
}
