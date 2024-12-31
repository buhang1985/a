package iih.en.er.bp.stay.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询留观申请单信息
 * 
 * @author liubin
 *
 */
public class ObsStayApplyQry implements ITransQry {
	/**
	 * 申请单id
	 */
	private String scAptIp;
	
	public ObsStayApplyQry(String scAptIp){
		this.scAptIp = scAptIp;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(scAptIp);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APTIP.ID_APTIP, ");
		sqlBuilder.append("       APTIP.ID_PAT, ");
		sqlBuilder.append("       APTIP.ID_ENT, ");
		sqlBuilder.append("       APTIP.ID_PATCONT, ");
		sqlBuilder.append("       APTIP.ID_DIDEF_OP, ");
		sqlBuilder.append("       APTIP.NAME_DIDEF_OP, ");
		sqlBuilder.append("       APTIP.SUPPLEMENT_DI, ");
		sqlBuilder.append("       APTIP.ID_DEP_PHY_IP, ");
		sqlBuilder.append("       APTIP.ID_DEP_NUR_IP, ");
		sqlBuilder.append("       APTIP.ID_LEVEL_DISE, ");
		sqlBuilder.append("       APTIP.SD_LEVEL_DISE, ");
		sqlBuilder.append("       APTIP.DT_INSERT, ");
		sqlBuilder.append("       APTIP.AMT_DEPOSIT, ");
		sqlBuilder.append("       APTIP.NOTE, ");
		sqlBuilder.append("       APTIP.ID_DEP_OP, ");
		sqlBuilder.append("       APTIP.ID_EMP_PHY_OP, ");
		sqlBuilder.append("       APTIP.NAME_EMP_PHY_OP, ");
		sqlBuilder.append("       APTIP.SD_STATUS, ");
		sqlBuilder.append("       APTIP.DT_ADMIT_PLAN, ");
		sqlBuilder.append("       APTIP.DT_VALID, ");
		sqlBuilder.append("       APTIP.FG_VIP, ");
		sqlBuilder.append("       APTIP.ID_PATCA, ");
		sqlBuilder.append("       PATCA.NAME AS NAME_PATCA, ");
		sqlBuilder.append("       PAT.CODE AS CODE_PAT, ");
		sqlBuilder.append("       PAT.NAME AS NAME_PAT, ");
		sqlBuilder.append("       PAT.ID_SEX, ");
		sqlBuilder.append("       PAT.SD_SEX, ");
		sqlBuilder.append("       PAT.DT_BIRTH, ");
		sqlBuilder.append("       PAT.ID_MARRY, ");
		sqlBuilder.append("       PAT.ID_IDTP, ");
		sqlBuilder.append("       PAT.SD_IDTP, ");
		sqlBuilder.append("       PAT.ID_CODE, ");
		sqlBuilder.append("       NVL(PAT.MOB,PAT.TEL) AS TEL, ");
		sqlBuilder.append("       OP.SD_STATUS AS SD_STATUS_OP, ");
		sqlBuilder.append("       OPER.ID_SCALE_TRIAGE, ");
		sqlBuilder.append("       OPER.SD_SCALE_TRIAGE, ");
		sqlBuilder.append("       ERPRE.IDS_GREEN_CHANNEL_SYM AS IDS_GREEN_CHANNEL, ");
		sqlBuilder.append("       ERPRE.ID_DEP_TO, ");
		sqlBuilder.append("       ERPRE.DT_ENTRY AS DT_ERPRE ");
		sqlBuilder.append("FROM SC_APT_IP APTIP ");
		sqlBuilder.append("INNER JOIN PI_PAT PAT ON APTIP.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append("INNER JOIN EN_ENT ENT ON APTIP.ID_ENT = ENT.ID_ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP OP ON ENT.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP_ER OPER ON ENT.ID_ENT = OPER.ID_ENT ");
		sqlBuilder.append("INNER JOIN EN_ERPRE ERPRE ON OPER.ID_ERPRE = ERPRE.ID_ERPRE ");
		sqlBuilder.append("LEFT JOIN PI_PAT_CA PATCA ON APTIP.ID_PATCA = PATCA.ID_PATCA ");
		sqlBuilder.append("WHERE APTIP.ID_APTIP = ? ");
		return sqlBuilder.toString();
	}

}
