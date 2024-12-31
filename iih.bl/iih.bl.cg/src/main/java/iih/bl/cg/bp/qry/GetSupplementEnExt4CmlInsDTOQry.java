package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSupplementEnExt4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetSupplementEnExt4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
		if (billNos == null && billNos.length == 0)
			throw new BizException("请录入发票单号！");
		if (StringUtil.isEmpty(codePat))
			throw new BizException("请录入患者编码！");
		this.billNos = billNos;
		this.codePat = codePat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		for (String string : billNos) {
			param.addParam(string);
		}

		param.addParam(codePat);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		
		
		
		sql.append("SELECT                                                                                              "); 
		sql.append("PAT.code,                                                                                           "); 
		sql.append("	PAT.CODE PID, "); //--患者ID 
		sql.append("	ENT.CODE VISIT_NO, "); //--就诊号  
		sql.append("	INCOEP.INCNO,"); //--发票号                                                                           
		sql.append("	ENT.ID_ENT patientEncounterId,                                                                  "); 
		sql.append("	MR.ILLNESSHISTORY Illnesshistory,     "); //--病历信息                                                
		sql.append("	MR.ZHUSHU Zhushu, "); //--主诉识        
		sql.append("	MR.HISTORY,  "); //--既往史                                                                           
		sql.append("	MR.PRESENTHISTORY, "); //--现病史                                                                     
		sql.append("	MR.GENETICDISEASE,     "); //--家族史（遗传病）                                                       
		sql.append("	MR.EXAMINATION                                 "); //--体格检查                                       
		sql.append("FROM                                                                                                "); 
		sql.append("	EN_ENT ENT                                                                                      "); 
		sql.append("inner join  PI_PAT PAT on PAT.ID_PAT = ENT.ID_PAT                                                   "); 
		sql.append("left join (                                                                                         "); 
		sql.append("		SELECT                                                                                      "); 
		sql.append("			*                                                                                       "); 
		sql.append("		FROM                                                                                        "); 
		sql.append("			(                                                                                       "); 
		sql.append("				SELECT                                                                              "); 
		sql.append("					ID_ENT,                                                                         "); 
		sql.append("					CONTENT,                                                                        "); 
		sql.append("					code_element                                                                    "); 
		sql.append("				FROM                                                                                "); 
		sql.append("					ci_mr_doc_reference_value                                                       "); 
		sql.append("			) PIVOT (                                                                               "); 
		sql.append("				MAX (CONTENT) FOR code_element IN (                                                 "); 
		sql.append("					'S.02' AS EXAMINATION,                                                          "); 
		sql.append("					'S.04.013' AS GENETICDISEASE,                                                   "); 
		sql.append("					'S.03' AS PRESENTHISTORY,                                                       "); 
		sql.append("					'S.01' AS ZHUSHU,                                                               "); 
		sql.append("					'S.04' AS HISTORY,                                                              "); 
		sql.append("					'S.04.009' AS ILLNESSHISTORY                                                    "); 
		sql.append("				)                                                                                   "); 
		sql.append("			)                                                                                       "); 
		sql.append("	) MR on ENT.ID_ENT = MR.ID_ENT                                                                  "); 
		sql.append("left  join	BL_ST_OEP STOEP on STOEP.ID_ENT = MR.ID_ENT                                             "); 
		sql.append("left  join	BL_INC_OEP INCOEP on STOEP.ID_STOEP = INCOEP.ID_STOEP and INCOEP.INCNO IN ( "); 
		
		for (int i = 0; i < billNos.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		sql.append("WHERE  PAT.code =?                                                                     "); 
		
		
		
		return sql.toString();
	}
}
