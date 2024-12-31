package iih.nm.nbd.nbdkpi.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nbd.nbdkpi.d.NbdKpiDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 指标定义标准参照
 * 
 * @author guoyang
 *
 */
public class NbdKpiRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NbdKpiDO.CODE, NbdKpiDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NbdKpiDO.ID_NBD_KPI };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NbdKpiDO.ID_NBD_KPI;
	}

	@Override
	public String getRefCodeField() {
		return NbdKpiDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NbdKpiDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NbdKpiDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NbdKpiDO.CODE, NbdKpiDO.NAME};
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
		String BdModeWherePart = NmEnvContextUtil.processEnvContext(new NbdKpiDO(), false);
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
		stringBuilder.append(NbdKpiDO.SORTNO);
		return stringBuilder.toString();
	}
}
