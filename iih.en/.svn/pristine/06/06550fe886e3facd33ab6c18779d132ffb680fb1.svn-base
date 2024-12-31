package iih.en.er.bp.stay.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询留观申请单就诊信息
 * 
 * @author liubin
 *
 */
public class ObsStayEntInfoQry implements ITransQry {
	/**
	 * 申请单id
	 */
	private String entId;
	
	public ObsStayEntInfoQry(String entId){
		this.entId = entId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(entId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_PAT, ");
		sqlBuilder.append("       ENT.ID_ENT, ");
		sqlBuilder.append("       ENTCONT.ID_PATCONTID AS ID_PATCONT, ");
		sqlBuilder.append("       ENTDI.ID_DIDEF_DIS AS ID_DIDEF_OP, ");
		sqlBuilder.append("       ENTDI.NAME_DIDEF_DIS AS NAME_DIDEF_OP, ");
		sqlBuilder.append("       ENTDI.SUPPLEMENT AS SUPPLEMENT_DI, ");
		sqlBuilder.append("       ENT.ID_DEP_PHY AS ID_DEP_OP, ");
		sqlBuilder.append("       ENT.ID_EMP_PHY AS ID_EMP_PHY_OP, ");
		sqlBuilder.append("       ENT.ID_PATCA, ");
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
		sqlBuilder.append("FROM EN_ENT ENT ");
		sqlBuilder.append("INNER JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP OP ON ENT.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append("INNER JOIN EN_ENT_OP_ER OPER ON ENT.ID_ENT = OPER.ID_ENT ");
		sqlBuilder.append("INNER JOIN EN_ERPRE ERPRE ON OPER.ID_ERPRE = ERPRE.ID_ERPRE ");
		sqlBuilder.append("LEFT JOIN PI_PAT_CA PATCA ON ENT.ID_PATCA = PATCA.ID_PATCA ");
		sqlBuilder.append("LEFT JOIN EN_ENT_CONT ENTCONT ON ENT.ID_ENT = ENTCONT.ID_ENT AND ENTCONT.EU_ENTCONTTP = '1' ");
		sqlBuilder.append("LEFT JOIN EN_ENT_DI ENTDI ON ENT.ID_ENT = ENTDI.ID_ENT AND ENTDI.FG_MAJ = 'Y' ");
		sqlBuilder.append("WHERE ENT.ID_ENT = ? ");
		return sqlBuilder.toString();
	}

}
