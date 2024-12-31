package iih.en.er.bp.stayregist.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.validator.EnValidator;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询登记，入科的留观就诊信息
 * 
 * @author liubin
 *
 */
public class FindObsStayEntInfoBP implements ITransQry{
	
	/**
	 * 就诊id
	 */
	private String entId;
	/**
	 * 患者id
	 */
	private String patId;
	
	public FindObsStayEntInfoBP(String entId, String patId){
		this.entId = entId;
		this.patId = patId;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if(!EnValidator.isEmpty(entId)){
			param.addParam(entId);
		}
		if(!EnValidator.isEmpty(patId)){
			param.addParam(patId);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ENT.ID_ENT, ");
		sqlBuilder.append("       ENT.ID_PAT, "); 
		sqlBuilder.append("       ENT.NAME_PAT, "); 
		sqlBuilder.append("       PAT.CODE AS CODE_PAT, "); 
		sqlBuilder.append("       ENT.CODE AS CODE_ENT, "); 
		sqlBuilder.append("       IP.CODE_AMR_IP, "); 
		sqlBuilder.append("       IP.TIMES_IP, "); 
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
		sqlBuilder.append("       IP.SD_STATUS, "); 
		sqlBuilder.append("       ENT.DT_ENTRY, "); 
		sqlBuilder.append("       IP.ID_LEVEL_DISEADM, "); 
		sqlBuilder.append("       IP.SD_LEVEL_DISEADM, "); 
		sqlBuilder.append("       IP.ID_DEP_PHYADM, "); 
		sqlBuilder.append("       IP.ID_DEP_NURADM, "); 
		sqlBuilder.append("       IP.ID_EMP_OPAPPLY, "); 
		sqlBuilder.append("       PSN.NAME AS NAME_EMP_OPAPPLY, "); 
		sqlBuilder.append("       IP.ID_BED, "); 
		sqlBuilder.append("       IP.NAME_BED, "); 
		sqlBuilder.append("       IP.ID_DIAG_OP, "); 
		sqlBuilder.append("       IP.DESC_DIAG_OP, "); 
		sqlBuilder.append("       DI.CODE AS CODE_DIAG_OP, "); 
		sqlBuilder.append("       DI.NAME AS NAME_DIAG_OP, "); 
		sqlBuilder.append("       IPER.ID_ERPRE, "); 
		sqlBuilder.append("       PATCA.ID_PATCA, "); 
		sqlBuilder.append("       PATCA.NAME AS NAME_PATCA, "); 
		sqlBuilder.append("       PRIPAT.ID_PRIPAT, "); 
		sqlBuilder.append("       PRIPAT.NAME AS NAME_PRIPAT, "); 
		sqlBuilder.append("       PATCRET.ID_PATCRET, "); 
		sqlBuilder.append("       PATCRET.NAME AS NAME_PATCRET, "); 
		sqlBuilder.append("       CUST.ID_CUST AS ID_CUST_CMPY, "); 
		sqlBuilder.append("       CUST.NAME AS NAME_CUST_CMPY, "); 
		sqlBuilder.append("       HP.ID_HP, "); 
		sqlBuilder.append("       HP.CODE AS CODE_HP, "); 
		sqlBuilder.append("       HP.NAME AS NAME_HP, "); 
		sqlBuilder.append("       ENTHP.NO_HP, "); 
		sqlBuilder.append("       ENTHP.FG_FUNDPAY, "); 
		sqlBuilder.append("       ENTHP.FG_HP_CARD, "); 
		sqlBuilder.append("       ENTHP.FG_HPSPCL, "); 
		sqlBuilder.append("       ENTHP.CODE_HPKIND, "); 
		sqlBuilder.append("       ENTHP.CODE_HPPATCA, "); 
		sqlBuilder.append("       ENTHP.CODE_HPAREA, "); 
		sqlBuilder.append("       ENTHP.PERSONNO, "); 
		sqlBuilder.append("       ENT.CODE_HPMEDKIND "); 
		sqlBuilder.append(" FROM EN_ENT ENT "); 
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON ENT.ID_ENT = IP.ID_ENT "); 
		sqlBuilder.append(" INNER JOIN EN_ENT_IP_ER IPER ON ENT.ID_ENT = IPER.ID_ENT "); 
		sqlBuilder.append(" INNER JOIN PI_PAT PAT ON ENT.ID_PAT = PAT.ID_PAT "); 
		sqlBuilder.append(" LEFT JOIN BD_PSNDOC PSN ON IP.ID_EMP_OPAPPLY = PSN.ID_PSNDOC "); 
		sqlBuilder.append(" LEFT JOIN BD_DI_DEF DI ON DI.ID_DIDEF = IP.ID_DIAG_OP "); 
		sqlBuilder.append(" LEFT JOIN PI_PAT_CA PATCA ON ENT.ID_PATCA = PATCA.ID_PATCA "); 
		sqlBuilder.append(" LEFT JOIN BD_PRI_PAT PRIPAT ON ENT.ID_PRIPAT = PRIPAT.ID_PRIPAT "); 
		sqlBuilder.append(" LEFT JOIN PI_PAT_CRET PATCRET ON ENT.ID_PATCRET = PATCRET.ID_PATCRET "); 
		sqlBuilder.append(" LEFT JOIN BD_CUST CUST ON ENT.ID_CUST_CMPY = CUST.ID_CUST "); 
		sqlBuilder.append(" LEFT JOIN EN_ENT_HP ENTHP ON ENT.ID_ENT = ENTHP.ID_ENT AND ENT.ID_HP = ENTHP.ID_HP AND ENTHP.FG_MAJ = 'Y' "); 
		sqlBuilder.append(" LEFT JOIN BD_HP HP ON ENTHP.ID_HP = HP.ID_HP "); 
		sqlBuilder.append(" WHERE ENT.FG_CANC = 'N' "); 
		sqlBuilder.append(" AND IP.SD_STATUS IN ('"+IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN+"','"+IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN+"') "); 
		if(!EnValidator.isEmpty(entId)){
			sqlBuilder.append(" AND ENT.ID_ENT = ? ");
		}
		if(!EnValidator.isEmpty(patId)){
			sqlBuilder.append(" AND ENT.ID_PAT = ? "); 
		}
		return sqlBuilder.toString();
	}

}
