package iih.bd.fc.enstate.refs;

import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class BdEnStateRefsModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdEnStateDO.VAL, BdEnStateDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdEnStateDO.ID_ENSTATE, BdEnStateDO.ID_ENSTATETP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "状况值", "状况名称" };
	}

	@Override
	public String getTableName() {
		return new BdEnStateDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return BdEnStateDO.ID_ENSTATE;
	}

	@Override
	public String getRefCodeField() {
		return BdEnStateDO.VAL;
	}

	@Override
	public String getRefNameField() {
		return BdEnStateDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdEnStateDO(), false);
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
