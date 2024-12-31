package iih.bd.srv.autoitm.refs;

import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 自动质控控制表参照
 * @author guoyang
 *
 */
public class AutoItmRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return (new String[] { AutoItmDO.REQ});
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { AutoItmDO.ID_QA_ITM_CONFIG});
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "自动质控项说明"});
	}

	@Override
	public String getPkFieldCode() {
		return AutoItmDO.ID_QA_ITM_CONFIG;
	}


	@Override
	public String getRefNameField() {
		return AutoItmDO.REQ;
	}

	@Override
	public String getTableName() {
		return new AutoItmDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { AutoItmDO.REQ, AutoItmDO.PYCODE, AutoItmDO.WBCODE, AutoItmDO.MNECODE };
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
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
		stringBuilder.append(" and ds = '0' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new AutoItmDO(), false);
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
		stringBuilder.append(String.format("%s", AutoItmDO.REQ));
		return stringBuilder.toString();
	}
}
