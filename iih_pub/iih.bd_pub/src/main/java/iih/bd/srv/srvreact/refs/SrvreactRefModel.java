package iih.bd.srv.srvreact.refs;

import iih.bd.srv.srvreact.d.SrvReactDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class SrvreactRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { SrvReactDO.NAME, SrvReactDO.CODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { SrvReactDO.ID_SRVREACT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "互斥组名称名称", "编码" };
	}

	@Override
	public String getPkFieldCode() {
		return SrvReactDO.ID_SRVREACT;
	}

	@Override
	public String getRefCodeField() {
		return SrvReactDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return SrvReactDO.NAME;
	}

	@Override
	public String getTableName() {
		return new SrvReactDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SrvReactDO(), false);
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
