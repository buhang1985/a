package iih.bd.srv.emrterm.refs;

import iih.bd.srv.emrterm.d.EmrTermGrpDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class EmrTermGrpRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { EmrTermGrpDO.CODE, EmrTermGrpDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { EmrTermGrpDO.ID_MRATERMGRP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return EmrTermGrpDO.ID_MRATERMGRP;
	}

	@Override
	public String getRefCodeField() {
		return EmrTermGrpDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return EmrTermGrpDO.NAME;
	}

	@Override
	public String getTableName() {
		return new EmrTermGrpDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new EmrTermGrpDO(), false);
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
		stringBuilder.append(String.format("%s", EmrTermGrpDO.CODE));
		return stringBuilder.toString();
	}
}
