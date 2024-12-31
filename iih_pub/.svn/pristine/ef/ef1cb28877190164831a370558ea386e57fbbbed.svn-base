package iih.bd.srv.nurmrtpl.refs;

import iih.bd.srv.nurmrtpl.d.NurMrConTplCaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

;

public class NurmrtplRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { NurMrConTplCaDO.CODE, NurMrConTplCaDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NurMrConTplCaDO.ID_MRNURCONTPLCA, NurMrConTplCaDO.ID_PARENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return NurMrConTplCaDO.ID_MRNURCONTPLCA;
	}

	@Override
	public String getTableName() {
		return new NurMrConTplCaDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return NurMrConTplCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NurMrConTplCaDO.NAME;
	}

	@Override
	public String getChildField() {
		return NurMrConTplCaDO.ID_MRNURCONTPLCA;
	}

	@Override
	public String getFatherField() {
		return NurMrConTplCaDO.ID_PARENT;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new NurMrConTplCaDO(), false);
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
