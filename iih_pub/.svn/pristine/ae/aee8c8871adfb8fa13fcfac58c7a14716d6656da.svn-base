package iih.bd.srv.mrbasetpl.refs;

import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class EmrBaseTplRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { EmrBaseTplDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EmrBaseTplDO.ID_BASEMRTPL, EmrBaseTplDO.ID_MRED, EmrBaseTplDO.CODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return EmrBaseTplDO.ID_BASEMRTPL;
	}

	@Override
	public String getRefCodeField() {
		return EmrBaseTplDO.CODE;
	}

	public String getMred() {
		return EmrBaseTplDO.ID_MRED;
	}

	public String getRefNameField() {
		return EmrBaseTplDO.NAME;
	}

	@Override
	public String getTableName() {
		return new EmrBaseTplDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrBaseTplDO(), false);
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
		stringBuilder.append(String.format("%s", EmrBaseTplDO.CODE));
		return stringBuilder.toString();
	}
}
