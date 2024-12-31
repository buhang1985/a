package iih.bd.pp.hp.refs;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class HpRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HPDO.CODE, HPDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HPDO.ID_HP, HPDO.FG_CARDST, HPDO.FG_REQHPCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HPDO.CODE, HPDO.NAME, HPDO.PYCODE, HPDO.WBCODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return HPDO.ID_HP;
	}

	@Override
	public String getRefCodeField() {
		return HPDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HPDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HPDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HPDO(), false);
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
		stringBuilder.append(String.format("%s", HPDO.CODE));
		return stringBuilder.toString();
	}
}
