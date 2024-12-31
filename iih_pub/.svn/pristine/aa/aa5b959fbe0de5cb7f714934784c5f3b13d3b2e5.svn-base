package iih.bd.srv.qcevent.refs;

import iih.bd.srv.qcevent.d.QcEventDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class QcEventRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { QcEventDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QcEventDO.ID_QC_EVENT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return QcEventDO.ID_QC_EVENT;
	}

	@Override
	public String getRefNameField() {
		return QcEventDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QcEventDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QcEventDO(), false);
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
