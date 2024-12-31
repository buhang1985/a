package iih.mkr.std.commondeval.refs;

import iih.mkr.std.commondeval.d.DataElementValDO;
import iih.mkr.utils.MkrEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class DataEleValRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3673382584717101735L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DataElementValDO.VALDOMAINCODE, DataElementValDO.VALDOMAINCODENAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "类型编码", "类型编码名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DataElementValDO.VALDOMAINCODE;
	}

	@Override
	public String getRefCodeField() {
		return DataElementValDO.VALDOMAINCODE;
	}

	@Override
	public String getRefNameField() {
		return DataElementValDO.VALDOMAINCODENAME;
	}

	@Override
	public String getTableName() {
		return new DataElementValDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DataElementValDO.VALDOMAINCODE, DataElementValDO.VALDOMAINCODENAME };
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
		String BdModeWherePart = MkrEnvContextUtil.processEnvContext(new DataElementValDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		stringBuilder.append(" and VALDOMAINCODE is not null ");
		stringBuilder.append(" group by VALDOMAINCODE,VALDOMAINCODENAME ");
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DataElementValDO.VALDOMAINCODE));
		return stringBuilder.toString();
	}

}
