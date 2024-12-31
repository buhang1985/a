package iih.bd.srv.srvortplcate.ref;

import iih.bd.srv.srvortplcate.d.SrvOrTplCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class SrvOrTplCateRefModel extends RefTreeModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { SrvOrTplCateDO.CODE, SrvOrTplCateDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SrvOrTplCateDO.ID_SRVORTPLCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return new SrvOrTplCateDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return SrvOrTplCateDO.ID_SRVORTPLCA;
	}

	@Override
	public String getRefCodeField() {
		return SrvOrTplCateDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return SrvOrTplCateDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SrvOrTplCateDO(), false);
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
