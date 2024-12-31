package iih.mi.bd.refs;

import iih.bd.srv.emrterm.d.EmrTermCompDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.mi.bd.miudidoc.d.MiUdidocDO;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class MiUdidocModel extends RefGridModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MiUdidocDO.CODE, MiUdidocDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MiUdidocDO.ID_MIUDIDOCLIST,MiUdidocDO.ID_MIUDIDOC };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return  MiUdidocDO.ID_MIUDIDOC;
	}

	@Override
	public String getRefCodeField() {
		return MiUdidocDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MiUdidocDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MiUdidocDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MiUdidocDO(), false);
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

