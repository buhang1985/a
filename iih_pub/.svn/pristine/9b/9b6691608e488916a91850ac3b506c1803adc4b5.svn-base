package iih.bd.pp.incca.refs;

import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class InccaItmRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { IncCaItmDO.CODE, IncCaItmDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { IncCaItmDO.ID_INCCAITM };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return IncCaItmDO.ID_INCCAITM;
	}

	@Override
	public String getRefCodeField() {
		return IncCaItmDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return IncCaItmDO.NAME;
	}

	@Override
	public String getTableName() {
		return new IncCaItmDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {

		return new String[] { IncCaItmDO.NAME, IncCaItmDO.CODE, IncCaItmDO.MNECODE, IncCaItmDO.PYCODE,
				IncCaItmDO.WBCODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new IncCaItmDO(), false);
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
		stringBuilder.append(String.format("%s", IncCaItmDO.CODE));
		stringBuilder.append(String.format(",%s", IncCaItmDO.NAME));
		return stringBuilder.toString();
	}
}
