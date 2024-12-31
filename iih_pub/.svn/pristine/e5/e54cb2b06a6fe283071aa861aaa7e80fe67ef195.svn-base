package iih.bd.pp.cust.refs;

import iih.bd.pp.cust.d.CustCaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 客户分类参照
 * 
 * @author Administrator
 *
 */
public class PriCustCaRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { CustCaDO.CODE, CustCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { CustCaDO.ID_CUSTCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { CustCaDO.NAME, CustCaDO.CODE, CustCaDO.MNECODE, CustCaDO.PYCODE, CustCaDO.WBCODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return CustCaDO.ID_CUSTCA;
	}

	@Override
	public String getRefCodeField() {
		return CustCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return CustCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new CustCaDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new CustCaDO(), false);
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
		return stringBuilder.toString();
	}
}
