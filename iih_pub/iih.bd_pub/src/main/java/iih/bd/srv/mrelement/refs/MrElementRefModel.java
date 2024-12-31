package iih.bd.srv.mrelement.refs;

import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MrElementRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MrElementDO.CODE, MrElementDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrElementDO.ID_MR_DE, MrElementDO.WBCODE, MrElementDO.PYCODE };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] {MrElementDO.NAME, MrElementDO.CODE, MrElementDO.WBCODE, MrElementDO.PYCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MrElementDO.ID_MR_DE;
	}

	@Override
	public String getTableName() {
		return new MrElementDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MrElementDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return MrElementDO.NAME;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrElementDO(), false);
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
