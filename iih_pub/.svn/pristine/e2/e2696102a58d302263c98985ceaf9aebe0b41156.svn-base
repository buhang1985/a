package iih.bd.srv.emrtpl.refs;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class EmrTplRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { EmrTplDO.CODE, EmrTplDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return EmrTplDO.ID_MRTP;
	}

	@Override
	public String getTableName() {
		return new EmrTplDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return EmrTplDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return EmrTplDO.NAME;

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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrTplDO(), false);
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
