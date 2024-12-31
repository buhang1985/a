package iih.mp.orm.instrumentdic.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.mp.orm.instrumentdic.d.InstrumentDictionaryDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class InstrumentDicRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return (new String[] { InstrumentDictionaryDO.CODE, InstrumentDictionaryDO.NAME });
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { InstrumentDictionaryDO.ID_MMOM, InstrumentDictionaryDO.ID_OMCA,
				InstrumentDictionaryDO.SPEC });
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "编码", "名称" });
	}

	@Override
	public String getPkFieldCode() {
		return InstrumentDictionaryDO.ID_MMOM;
	}

	@Override
	public String getRefCodeField() {
		return InstrumentDictionaryDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return InstrumentDictionaryDO.NAME;
	}

	@Override
	public String getTableName() {
		return new InstrumentDictionaryDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { InstrumentDictionaryDO.NAME, InstrumentDictionaryDO.CODE, InstrumentDictionaryDO.PYCODE,
				InstrumentDictionaryDO.WBCODE, InstrumentDictionaryDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new InstrumentDictionaryDO(), false);
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
		stringBuilder.append(String.format("%s", InstrumentDictionaryDO.CODE));
		return stringBuilder.toString();
	}

}
