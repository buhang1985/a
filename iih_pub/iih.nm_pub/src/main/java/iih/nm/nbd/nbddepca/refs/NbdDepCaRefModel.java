package iih.nm.nbd.nbddepca.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nbd.nbddepca.d.NbdDepCaDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class NbdDepCaRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NbdDepCaDO.CODE, NbdDepCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NbdDepCaDO.ID_NBD_DEP_CA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "分类编码", "分类名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NbdDepCaDO.ID_NBD_DEP_CA;
	}

	@Override
	public String getRefCodeField() {
		return NbdDepCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NbdDepCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NbdDepCaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NbdDepCaDO.CODE, NbdDepCaDO.NAME };
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
		String BdModeWherePart = NmEnvContextUtil.processEnvContext(
				new NbdDepCaDO(), false);
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
		stringBuilder.append(NbdDepCaDO.CODE);
		return stringBuilder.toString();
	}
}
