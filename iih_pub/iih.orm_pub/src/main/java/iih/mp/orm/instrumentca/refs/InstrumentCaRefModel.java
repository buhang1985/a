package iih.mp.orm.instrumentca.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.mp.orm.instrumentca.d.InstrumentCaDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 
 * @author
 *
 */
public class InstrumentCaRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return (new String[] { InstrumentCaDO.CODE, InstrumentCaDO.NAME });
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { InstrumentCaDO.ID_OMCA });
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "编码", "名称" });
	}

	@Override
	public String getPkFieldCode() {
		return InstrumentCaDO.ID_OMCA;
	}

	@Override
	public String getRefCodeField() {
		return InstrumentCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return InstrumentCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new InstrumentCaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { InstrumentCaDO.NAME, InstrumentCaDO.CODE };
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
		stringBuilder.append(" and ds = '0' ");
		String MpModeWherePart = BdEnvContextUtil.processEnvContext(new InstrumentCaDO(), false);
		stringBuilder.append(String.format(" and %s ", MpModeWherePart));

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", InstrumentCaDO.CODE));
		return stringBuilder.toString();
	}
}
