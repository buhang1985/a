package iih.bd.fc.queben.refs;

import iih.bd.fc.queben.d.QueBenDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 分诊台参照模型
 * 
 * @author liubin
 *
 */
public class QueBenRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { QueBenDO.CODE, QueBenDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QueBenDO.ID_QUEBEN };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return QueBenDO.ID_QUEBEN;
	}

	@Override
	public String getRefCodeField() {
		return QueBenDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QueBenDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QueBenDO().getTableName();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { QueBenDO.CODE, QueBenDO.NAME, QueBenDO.SD_QUEBENTP, QueBenDO.WBCODE, QueBenDO.MNECODE };
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

		StringBuilder stringBuilder = new StringBuilder(" 1 = 1 and Fg_active = 'Y' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QueBenDO(), false);
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
		stringBuilder.append(String.format("%s", QueBenDO.CODE));
		return stringBuilder.toString();
	}
}
