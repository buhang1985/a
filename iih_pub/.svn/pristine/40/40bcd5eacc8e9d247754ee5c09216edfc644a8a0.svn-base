package iih.bd.fc.quesite.refs;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 站点参照模型
 * 
 * @author liubin
 *
 */
public class QueSiteRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { QueSiteDO.CODE, QueSiteDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QueSiteDO.ID_QUESITE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { QueSiteDO.CODE, QueSiteDO.NAME, QueSiteDO.PYCODE, QueSiteDO.WBCODE, QueSiteDO.MNECODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return QueSiteDO.ID_QUESITE;
	}

	@Override
	public String getRefCodeField() {
		return QueSiteDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QueSiteDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QueSiteDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QueSiteDO(), false);
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
		stringBuilder.append(String.format("%s", QueSiteDO.CODE));
		return stringBuilder.toString();
	}
}
