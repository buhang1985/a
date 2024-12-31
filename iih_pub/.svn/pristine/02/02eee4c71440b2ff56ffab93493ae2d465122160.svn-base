package iih.bd.srv.srvrtctlcate.refs;

import iih.bd.srv.srvrtctlcate.d.SrvRtCtlCateDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class SrvrtctlcateRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { SrvRtCtlCateDO.CODE, SrvRtCtlCateDO.NAME };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return SrvRtCtlCateDO.ID_SRVRTCA;
	}

	@Override
	public String getTableName() {
		return new SrvRtCtlCateDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return SrvRtCtlCateDO.CODE;

	}

	@Override
	public String getRefNameField() {
		return SrvRtCtlCateDO.NAME;

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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new SrvRtCtlCateDO(), false);
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
