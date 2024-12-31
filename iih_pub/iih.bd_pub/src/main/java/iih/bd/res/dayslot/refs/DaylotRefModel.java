package iih.bd.res.dayslot.refs;

import iih.bd.res.dayslot.d.DaysLotDO;
import iih.bd.res.dayslot.d.desc.DaysLotDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DaylotRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DaysLotDO.ID_DAYSLOT, DaysLotDO.TIME_BEGIN };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DaysLotDO.ID_DAYSLOT;
	}

	@Override
	public String getRefCodeField() {
		return DaysLotDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DaysLotDO.NAME;
	}

	public String getRefTimeEndField() {
		return DaysLotDO.TIME_BEGIN;
	}

	@Override
	public String getTableName() {
		return DaysLotDODesc.TABLE_NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DaysLotDO.CODE, DaysLotDO.NAME, DaysLotDO.PYCODE, DaysLotDO.WBCODE, DaysLotDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DaysLotDO(), false);
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
		stringBuilder.append(String.format("%s", DaysLotDO.SORTNO));
		return stringBuilder.toString();
	}
}
