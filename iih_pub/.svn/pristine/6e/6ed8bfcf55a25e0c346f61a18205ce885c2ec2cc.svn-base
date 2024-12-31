package iih.bd.srv.ortpl.refs;

import iih.bd.srv.ortpl.d.OrTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

@SuppressWarnings("serial")
public class SrvOrTplRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { OrTplDO.CODE, OrTplDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OrTplDO.ID_SRVORTPL, OrTplDO.ID_SRVORTPLCA, OrTplDO.ID_GRP, OrTplDO.ID_ORG };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return OrTplDO.ID_SRVORTPL;
	}

	@Override
	public String getRefCodeField() {
		return OrTplDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return OrTplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new OrTplDO().getTableName();
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
		stringBuilder.append(" and ds = 0");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new OrTplDO(), false);
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

	@Override
	public String[] getBlurFields() {
		return new String[] { "name", "code", "wbcode", "pycode" };
	}
}
