package iih.bd.fc.que.refs;

import iih.bd.fc.que.d.QueDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

/**
 * 队列参照模型
 * @author guoyang
 *
 */
public class QueRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { QueDO.CODE, QueDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { QueDO.ID_QUE , QueDO.ID_QUETP, QueDO.SD_QUETP, QueDO.ID_QUEBEN, QueDO.ID_DEP, QueDO.ID_SCRES, QueDO.ID_SCSRV};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { QueDO.CODE, QueDO.NAME, QueDO.PYCODE, QueDO.WBCODE, QueDO.MNECODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return QueDO.ID_QUE;
	}

	@Override
	public String getRefCodeField() {
		return QueDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return QueDO.NAME;
	}

	@Override
	public String getTableName() {
		return new QueDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new QueDO(), false);
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
		stringBuilder.append(String.format("%s", QueDO.CODE));
		return stringBuilder.toString();
	}

}
