package iih.bd.srv.itmfst.refs;

import iih.bd.srv.itmfst.d.ItmFstDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ItmFstRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { ItmFstDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ItmFstDO.CODE, ItmFstDO.ID_FST };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { ItmFstDO.CODE, ItmFstDO.ID_FST, ItmFstDO.PYCODE, ItmFstDO.WBCODE, ItmFstDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return ItmFstDO.ID_FST;
	}

	@Override
	public String getTableName() {
		return new ItmFstDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return ItmFstDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return ItmFstDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new ItmFstDO(), false);
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
