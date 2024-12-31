package iih.en.er.bp.stayregist.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取未使用的留观申请单信息
 * 
 * @author liubin
 *
 */
public class FindObsAptIpInfosBP implements ITransQry{
	
	/**
	 * 患者id
	 */
	private String patId;
	
	public FindObsAptIpInfosBP(String patId){
		this.patId = patId;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(IScDictCodeConst.SD_APTIP_STATUS_APPLY);
		param.addParam(EnAppUtils.getServerDateTime());
		param.addParam(patId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APTIP.ID_APTIP, ");
		sqlBuilder.append("       ENT.ID_PAT, "); 
		sqlBuilder.append("       PAT.NAME AS NAME_PAT, "); 
		sqlBuilder.append("       PAT.CODE AS CODE_PAT, "); 
		sqlBuilder.append("       PAT.CODE_AMR_IP, "); 
		sqlBuilder.append("       PAT.LAST_TIMES_IP AS TIMES_IP, "); 
		sqlBuilder.append("       PAT.ID_SEX, "); 
		sqlBuilder.append("       PAT.SD_SEX, "); 
		sqlBuilder.append("       NVL(PAT.MOB, PAT.TEL) AS MOB, "); 
		sqlBuilder.append("       PAT.ID_IDTP, "); 
		sqlBuilder.append("       PAT.SD_IDTP, "); 
		sqlBuilder.append("       PAT.ID_CODE, "); 
		sqlBuilder.append("       PAT.DT_BIRTH, "); 
		sqlBuilder.append("       PAT.ID_MARRY, "); 
		sqlBuilder.append("       PAT.SD_MARRY, "); 
		sqlBuilder.append("       PAT.ID_NATION, "); 
		sqlBuilder.append("       PAT.SD_NATION, "); 
		sqlBuilder.append("       PAT.ID_COUNTRY, "); 
		sqlBuilder.append("       PAT.SD_COUNTRY, "); 
		sqlBuilder.append("       PAT.ID_OCCU, "); 
		sqlBuilder.append("       PAT.SD_OCCU, "); 
		sqlBuilder.append("       PAT.WORKUNIT, "); 
		sqlBuilder.append("       PAT.PHOTO, "); 
		sqlBuilder.append("       APTIP.ID_LEVEL_DISE AS ID_LEVEL_DISEADM, "); 
		sqlBuilder.append("       APTIP.SD_LEVEL_DISE AS SD_LEVEL_DISEADM, "); 
		sqlBuilder.append("       APTIP.ID_DEP_PHY_IP AS ID_DEP_PHYADM, "); 
		sqlBuilder.append("       APTIP.ID_DEP_NUR_IP AS ID_DEP_NURADM, "); 
		sqlBuilder.append("       APTIP.ID_EMP_PHY_OP AS ID_EMP_OPAPPLY, "); 
		sqlBuilder.append("       APTIP.NAME_DEP_OP AS NAME_DEP_OP, "); 
		sqlBuilder.append("       APTIP.DT_ADMIT_PLAN AS DT_ADMIT_PLAN, "); 
		sqlBuilder.append("       APTIP.AMT_DEPOSIT, ");
		sqlBuilder.append("       PSN.NAME AS NAME_EMP_OPAPPLY, "); 
		sqlBuilder.append("       APTIP.ID_DIDEF_OP AS ID_DIAG_OP, "); 
		sqlBuilder.append("       APTIP.SUPPLEMENT_DI AS DESC_DIAG_OP, "); 
		sqlBuilder.append("       DI.CODE AS CODE_DIAG_OP, "); 
		sqlBuilder.append("       DI.NAME AS NAME_DIAG_OP, "); 
		sqlBuilder.append("       APTIP.ID_PATCONT, ");
		sqlBuilder.append("       OPER.ID_ERPRE "); 
		sqlBuilder.append(" FROM SC_APT_IP APTIP "); 
		sqlBuilder.append(" INNER JOIN EN_ENT ENT ON APTIP.ID_ENT = ENT.ID_ENT "); 
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT "); 
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON ENT.ID_ENT = OPER.ID_ENT "); 
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC PSN ON APTIP.ID_EMP_PHY_OP = PSN.ID_PSNDOC "); 
		sqlBuilder.append(" LEFT JOIN BD_DI_DEF DI ON DI.ID_DIDEF = APTIP.ID_DIDEF_OP "); 
		sqlBuilder.append(" WHERE APTIP.FG_CANC = 'N' "); 
		sqlBuilder.append(" AND APTIP.FG_EMGSTAY = 'Y' ");
		sqlBuilder.append(" AND APTIP.SD_STATUS = ? "); 
		sqlBuilder.append(" AND APTIP.DT_VALID >= ? ");
		sqlBuilder.append(" AND ENT.ID_PAT = ? ");
		return sqlBuilder.toString();
	}

}
