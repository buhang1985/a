package iih.bd.srv.ortpl.ref;

import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class OrTmplcaRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { OrTmplCaDO.CODE, OrTmplCaDO.NAME, OrTmplCaDO.MNECODE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { OrTmplCaDO.ID_ORTMPLCA, OrTmplCaDO.PYCODE, OrTmplCaDO.WBCODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "助记码" };
	}

	@Override
	public String getPkFieldCode() {
		return OrTmplCaDO.ID_ORTMPLCA;
	}

	@Override
	public String getRefCodeField() {
		return OrTmplCaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return OrTmplCaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new OrTmplCaDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { OrTmplCaDO.CODE, OrTmplCaDO.NAME, OrTmplCaDO.PYCODE, OrTmplCaDO.WBCODE,
				OrTmplCaDO.MNECODE };
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new OrTmplCaDO(), false);
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
