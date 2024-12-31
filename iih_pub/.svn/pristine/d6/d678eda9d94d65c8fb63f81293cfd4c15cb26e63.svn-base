package iih.bd.mm.intelcabinet.refs;

import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class IntelCabinetRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { IntelCabinetDO.SMC_CODE, IntelCabinetDO.SMC_NAME, IntelCabinetDO.WBCODE,
				IntelCabinetDO.PYCODE, IntelCabinetDO.MNECODE, IntelCabinetDO.DEP_NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { IntelCabinetDO.ID_MMSMC };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "五笔码", "拼音码", "助记码", "放置部门" };
	}

	@Override
	public String getPkFieldCode() {
		return IntelCabinetDO.ID_MMSMC;
	}

	@Override
	public String getRefCodeField() {
		return IntelCabinetDO.SMC_CODE;
	}

	@Override
	public String getRefNameField() {
		return IntelCabinetDO.SMC_NAME;
	}

	@Override
	public String getTableName() {
		return new IntelCabinetDO().getTableName();
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
		stringBuilder.append(" ds = 0 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new IntelCabinetDO(), false);
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
		stringBuilder.append(String.format("%s", IntelCabinetDO.SMC_CODE));
		return stringBuilder.toString();
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { IntelCabinetDO.SMC_CODE, IntelCabinetDO.SMC_NAME, IntelCabinetDO.WBCODE,
				IntelCabinetDO.PYCODE, IntelCabinetDO.MNECODE, IntelCabinetDO.DEP_NAME };
	}
}
