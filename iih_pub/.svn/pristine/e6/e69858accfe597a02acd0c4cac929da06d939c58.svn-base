package iih.bd.srv.medsrvbloodquancanap.refs;

import iih.bd.srv.medsrvbloodquancanap.d.MedsrvbloodquancanapDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MedsrvbloodquancanapRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] {MedsrvbloodquancanapDO.QUAN_BLOOD};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedsrvbloodquancanapDO.ID_SRVBLODQUANCANAP };
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[] { "可申请血量" };
	}

	@Override
	public String getPkFieldCode() {
		return MedsrvbloodquancanapDO.ID_SRVBLODQUANCANAP;
	}

	@Override
	public String getTableName() {
		return new MedsrvbloodquancanapDO().getTableName();
	}
	
	@Override
	public String getRefNameField() {
		return MedsrvbloodquancanapDO.QUAN_BLOOD;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedsrvbloodquancanapDO(), false);
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
