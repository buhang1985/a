package iih.bd.res.mtassist.refs;

import iih.bd.res.mtassist.d.MtAssistDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MtRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MtAssistDO.CODE, MtAssistDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MtAssistDO.ID_MT, MtAssistDO.PYCODE, MtAssistDO.WBCODE, MtAssistDO.MNECODE };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MtAssistDO.CODE, MtAssistDO.NAME, MtAssistDO.PYCODE, MtAssistDO.WBCODE,
				MtAssistDO.MNECODE };
	}

	@Override
	public String getPkFieldCode() {
		return MtAssistDO.ID_MT;
	}

	@Override
	public String getRefCodeField() {
		return MtAssistDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MtAssistDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MtAssistDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MtAssistDO(), false);
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
		stringBuilder.append(String.format("%s", MtAssistDO.CODE));
		return stringBuilder.toString();
	}

}
