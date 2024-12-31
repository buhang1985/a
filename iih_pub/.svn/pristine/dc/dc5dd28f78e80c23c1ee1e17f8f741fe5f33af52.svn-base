package iih.bd.fc.entp.refs;

import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class EntpRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { EnTypeDO.CODE, EnTypeDO.NAME, EnTypeDO.PYCODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EnTypeDO.ID_ENTP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "拼音码" };
	}

	@Override
	public String getPkFieldCode() {
		return EnTypeDO.ID_ENTP;
	}

	@Override
	public String getTableName() {
		return new EnTypeDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return EnTypeDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return EnTypeDO.NAME;

	}

	@Override
	public String[] getBlurFields() {
		return new String[] { EnTypeDO.CODE, EnTypeDO.NAME, EnTypeDO.PYCODE, EnTypeDO.WBCODE, EnTypeDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EnTypeDO(), false);
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
		stringBuilder.append(String.format("%s", EnTypeDO.CODE));
		return stringBuilder.toString();
	}
}