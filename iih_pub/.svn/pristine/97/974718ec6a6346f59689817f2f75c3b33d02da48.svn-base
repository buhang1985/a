package iih.bd.pp.bdcpnca.refs;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class BdcpncaRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdCpncaDO.CODE, BdCpncaDO.NAME, BdCpncaDO.EU_CPNTP, BdCpncaDO.CODERULE_CPN };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdCpncaDO.ID_CPNCA };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "优惠券类型", "优惠券编码规则" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { BdCpncaDO.CODE, BdCpncaDO.NAME, BdCpncaDO.EU_CPNTP, BdCpncaDO.CODERULE_CPN,
				BdCpncaDO.PYCODE };
	}

	@Override
	public String getRefTitle() {
		return super.getRefTitle();
	}

	@Override
	public String getPkFieldCode() {
		return BdCpncaDO.ID_CPNCA;
	}

	@Override
	public String getRefCodeField() {
		return BdCpncaDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdCpncaDO.NAME;
	}

	@Override
	public String getTableName() {
		return new BdCpncaDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdCpncaDO(), false);
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
		stringBuilder.append(String.format("%s", BdCpncaDO.CODE));
		return stringBuilder.toString();
	}

}
