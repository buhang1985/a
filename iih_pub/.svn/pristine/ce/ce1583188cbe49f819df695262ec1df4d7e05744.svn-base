package iih.nmr.common.hecp.refs;

import iih.nmr.common.hecp.d.HeduPlanConDO;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 健康教育计划内容参照
 * @author hjh
 *
 */
public class HeduPlanConRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { HeduPlanConDO.CODE, HeduPlanConDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HeduPlanConDO.ID_PKUF_HEPC };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "教育内容" };
	}

	@Override
	public String getPkFieldCode() {
		return HeduPlanConDO.ID_PKUF_HEPC;
	}

	@Override
	public String getRefCodeField() {
		return HeduPlanConDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return HeduPlanConDO.NAME;
	}

	@Override
	public String getTableName() {
		return new HeduPlanConDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { HeduPlanConDO.CODE, HeduPlanConDO.NAME };
	}

	@Override
	public String getRefSql() {
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = super.getRefSql();

		} finally {
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}
		return refSql;
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", HeduPlanConDO.CODE));
		return stringBuilder.toString();
	}
}
