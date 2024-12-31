package iih.ci.rcm.hospitalreport.refs;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.rcm.hospitalreport.d.HospitalReportDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class HospitalReportRefModel extends RefGridModel{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { HospitalReportDO.ID_HOSPITALREPORT };
	}
	
	@Override
	public String[] getShowFieldCode() {
		return new String[] { HospitalReportDO.SD_PAT, HospitalReportDO.NAME_PAT,HospitalReportDO.FILL_IN_DATE,HospitalReportDO.NAME_STAGE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "姓名","填报日期","审签阶段" };
	}

	@Override
	public String getPkFieldCode() {
		return HospitalReportDO.ID_HOSPITALREPORT;
	}

	@Override
	public String getRefCodeField() {
		return HospitalReportDO.SD_PAT;
	}

	@Override
	public String getRefNameField() {
		return HospitalReportDO.NAME_PAT;
	}


	@Override
	public String getTableName() {
		return new HospitalReportDO().getTableName();
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
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new HospitalReportDO(), false);
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
		stringBuilder.append(String.format("%s", HospitalReportDO.SD_PAT));
		return stringBuilder.toString();
	}

}
