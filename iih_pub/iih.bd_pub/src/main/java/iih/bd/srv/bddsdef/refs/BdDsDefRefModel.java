package iih.bd.srv.bddsdef.refs;

import iih.bd.srv.bddsdef.d.BdDsDefDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 疾病病种定义参照
 * @author liming
 * @since 2019-06-13
 */
public class BdDsDefRefModel extends RefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return (new String[] { BdDsDefDO.CODE,BdDsDefDO.NAME});
	}

	@Override
	public String[] getHiddenFieldCode() {
		return (new String[] { BdDsDefDO.ID_DSDEF});
	}

	@Override
	public String[] getShowFieldName() {
		return (new String[] { "病种编码","病种名称"});
	}

	@Override
	public String getPkFieldCode() {
		return BdDsDefDO.ID_DSDEF;
	}


	@Override
	public String getRefNameField() {
		return BdDsDefDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdDsDefDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdDsDefDO.PYCODE, BdDsDefDO.WBCODE, BdDsDefDO.MNECODE };
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
		stringBuilder.append(" and ds = '0' and fg_active='Y'  ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdDsDefDO(), false);
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
		stringBuilder.append(String.format("%s", BdDsDefDO.CODE));
		return stringBuilder.toString();
	}
}
