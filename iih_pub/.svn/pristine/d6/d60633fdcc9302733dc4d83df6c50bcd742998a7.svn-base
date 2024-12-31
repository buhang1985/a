package iih.bd.bc.cdsys.refs;

import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class MedCdSysRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { MedCdSystemDO.CODE, MedCdSystemDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MedCdSystemDO.ID_CDSYS };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getTableName() {
		return new MedCdSystemDO().getTableName();
	}

	@Override
	public String getPkFieldCode() {
		return MedCdSystemDO.ID_CDSYS;
	}

	@Override
	public String getRefCodeField() {
		return MedCdSystemDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MedCdSystemDO.NAME;
	}

	@Override
	public void addWherePart(String wherePart) {
		getWherePart().add(wherePart);
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { MedCdSystemDO.NAME, MedCdSystemDO.CODE, MedCdSystemDO.PYCODE, MedCdSystemDO.MNECODE };
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
		stringBuilder.append(" and ds = '0' and activestate = '2' ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new MedCdSystemDO(), false);
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
		stringBuilder.append(String.format("%s", MedCdSystemDO.CODE));
		return stringBuilder.toString();
	}
}
