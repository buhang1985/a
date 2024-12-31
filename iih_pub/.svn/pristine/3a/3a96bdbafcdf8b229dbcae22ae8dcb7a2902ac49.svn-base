package iih.bd.srv.reviewtp.refs;

import iih.bd.srv.reviewtp.d.MrReviewtp;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ReviewtpModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MrReviewtp.CODE, MrReviewtp.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MrReviewtp.ID_REVIEWTP, MrReviewtp.ID_FLOWTYPE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MrReviewtp.ID_REVIEWTP;
	}

	@Override
	public String getTableName() {
		return new MrReviewtp().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return MrReviewtp.CODE;
	}

	@Override
	public String getRefNameField() {
		return MrReviewtp.NAME;
	}

	public String getRefFlowTypeField() {
		return MrReviewtp.ID_FLOWTYPE;
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MrReviewtp(), false);
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
		stringBuilder.append(String.format("%s", MrReviewtp.CODE));
		return stringBuilder.toString();
	}
}
