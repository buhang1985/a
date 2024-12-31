package iih.bd.srv.freqdef.refs;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class freqdefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { FreqDefDO.CODE, FreqDefDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { FreqDefDO.ID_FREQ, FreqDefDO.FG_LONG, FreqDefDO.FG_PRNOR, FreqDefDO.SD_FREQUNITCT,
				FreqDefDO.FREQCT, FreqDefDO.FG_LONG_EDIT,FreqDefDO.FG_INTERVAL };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return FreqDefDO.ID_FREQ;
	}

	@Override
	public String getRefCodeField() {
		return FreqDefDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return FreqDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new FreqDefDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { FreqDefDO.NAME, FreqDefDO.CODE, FreqDefDO.MNECODE, FreqDefDO.PYCODE, FreqDefDO.WBCODE };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().add(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().add(orderPart);}
			refSql = super.getRefSql();

		} finally {
			if(wherePart != null && !"".equals(wherePart))  {this.getWherePart().remove(wherePart);}
			if(orderPart != null && !"".equals(orderPart))  {this.getOrderPart().remove(orderPart);}
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
		stringBuilder.append(" and fg_active = 'Y' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new FreqDefDO(), false);
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
		stringBuilder.append(String.format("%s", FreqDefDO.SORTNO));
		stringBuilder.append(String.format(",%s", FreqDefDO.SD_FREQUNITCT));
		stringBuilder.append(String.format(",%s", FreqDefDO.CODE));
		stringBuilder.append(String.format(",%s", FreqDefDO.NAME));
		return stringBuilder.toString();
	}

}
