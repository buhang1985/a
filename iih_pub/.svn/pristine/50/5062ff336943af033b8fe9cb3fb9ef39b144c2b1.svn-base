package iih.bd.res.place.refs;

import iih.bd.res.place.d.PlaceDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

@SuppressWarnings("serial")
public class PlaceTreeModel extends RefTreeModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { PlaceDO.CODE, PlaceDO.NAME, PlaceDO.NAME_PATH };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PlaceDO.ID_PLC, PlaceDO.ID_PARENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "全局名称" };
	}

	@Override
	public String getPkFieldCode() {
		return PlaceDO.ID_PLC;
	}

	@Override
	public String getRefCodeField() {
		return PlaceDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PlaceDO.NAME_PATH;
	}

	@Override
	public String getFatherField() {
		return PlaceDO.ID_PARENT;
	}

	@Override
	public String getTableName() {
		return new PlaceDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PlaceDO.CODE, PlaceDO.NAME, PlaceDO.PYCODE, PlaceDO.WBCODE, PlaceDO.MNECODE };
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
		stringBuilder.append(" and ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PlaceDO(), false);
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
		stringBuilder.append(String.format("%s", PlaceDO.CODE));
		return stringBuilder.toString();
	}
}
