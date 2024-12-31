package iih.bd.srv.medsrv.refs.sql;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

public abstract class OrMedSrvOrderBase {
	private Integer rowsCount = 300;
	protected String getQueryColumn() {
		StringBuffer sb = new StringBuffer("select");
		sb.append(
				" distinct Name_srv_desc, name_srvtp, des_pri, des, sd_hpsrvtp,Id_hpsrvtp , hp_des, Code_hpsrvorca,IdSrvIdMm, id_Srv, Id_mm, sd_srvtp,code,name,wordfreq,wbcode,pycode");
		sb.append(" from ( ");
		;
		return sb.toString();
	}

	public String getMySqlStr(String code_entp, String id_hp, String inputstr,
			String id_pripat, List<String> whereList){
		return getQueryColumn();
	}

	abstract String getSrvMmSql(String code_entp, String id_pripat, List<String> whereList);

	/**
	 * 获得使用范围标识字段名
	 * 
	 * @param code_entp
	 * @return
	 */
	protected String getFgUseFld(String code_entp) {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp))
			return " fg_use_op='Y' ";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp))
			return " fg_use_ip='Y' ";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp))
			return " fg_use_er='Y' ";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp))
			return " fg_use_er1='Y' ";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp))
			return " fg_use_er2='Y' ";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp))
			return " fg_use_pe='Y' ";
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp))
			return " fg_use_fm='Y' ";

		return "";
	}

	public Integer getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}
	
}
