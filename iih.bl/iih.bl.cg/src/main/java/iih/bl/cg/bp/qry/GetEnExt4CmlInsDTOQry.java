package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEnExt4CmlInsDTOQry implements ITransQry {

	String billNo;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetEnExt4CmlInsDTOQry(String billNo, String codePat) throws BizException {
		
		this.billNo = billNo;
		this.codePat = codePat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(codePat);
		
		param.addParam(billNo);
		
		return param;
	}
	

//	select 
//
//	bd_udidoc.name DOCTORLEVEL , --医师职称
//	--PRESCRIBEFLAG  --代开药标识
//	ci_ap_sug.id_srv_code OPERATIONCODE,  --手术编码
//	ci_order.name_or nOPERATION,  --手术名称
//
//	ci_order.des_or REMARK,  --备注
//	ci_order.createdtime CREATEDATE,  --创建时间
//	ci_order.createdby CREATEUSERID , --创建人
//	ci_order.modifiedtime  UPDATEDATE,  --更新时间
//	 ci_order.modifiedby UPDATEUSERID,  --更新人
//	 ci_order.dt_effe OPERATIONDATE,  --手术时间
//	 ci_ap_sug_emp.id_emp OPERATIONDOCTOR,  --手术医师
//	 ci_ap_sug.sd_anestp ANAESTHESIATYPE,  --麻醉方式
//	 bd_udidoc2.name ANAESTHESIADOCTOR  --麻醉医师
//	--PROCESS  --手术过程 
//	from ci_ap_sug ci_ap_sug
//	left join ci_ap_sug_emp  ci_ap_sug_emp on ci_ap_sug_emp.id_apop = ci_ap_sug.id_apop 
//	left join  bd_udidoc  bd_udidoc on bd_udidoc.id_udidoc= ci_ap_sug_emp.id_role  and ci_ap_sug_emp.sd_role='00' 
//	left join  bd_udidoc  bd_udidoc2 on bd_udidoc2.id_udidoc= ci_ap_sug_emp.id_role  and ci_ap_sug_emp.sd_role='03' 
//	left join ci_order ci_order on ci_order.id_or = ci_ap_sug.id_or

//	SELECT
//	PAT.CODE PID	--患者ID
//	,ENT.CODE VISIT_NO	--就诊号
//	,ENT.ID_ENT
//	,MR.ILLNESSHISTORY	--病历信息
//	--DOCTORLEVEL	--医师职称
//	--PRESCRIBEFLAG	--代开药标识
//	--OPERATIONCODE	--手术编码
//	--OPERATION	--手术名称
//	--UPFLAG	--更新标
//	,MR.ZHUSHU	--主诉识
//	,MR.HISTORY	--既往史
//	--INVOICETYEPE	--单据类型
//	,MR.PRESENTHISTORY	--现病史
//	,MR.GENETICDISEASE	--家族史（遗传病）
//	,MR.EXAMINATION	--体格检查
//	FROM EN_ENT ENT,(SELECT
//		*
//	FROM
//		(
//			SELECT
//	ID_ENT ,
//				CONTENT,
//				code_element
//			FROM
//				ci_mr_doc_reference_value
//		) PIVOT (
//			MAX (CONTENT) FOR code_element IN (
//				'S.02' AS EXAMINATION,
//				'S.04.013' AS GENETICDISEASE,
//				'S.03' AS PRESENTHISTORY,
//				'S.01' AS ZHUSHU,
//				'S.04' AS HISTORY,
//				'S.04.009' AS ILLNESSHISTORY
//			)
//		) )MR,PI_PAT PAT 
//	WHERE ENT.ID_ENT=MR.ID_ENT AND PAT.ID_PAT=ENT.ID_PAT AND PAT.CODE='100000606200'
	

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();                                                                                       
	sql.append("select ");
	sql.append("bd_udidoc.name ");
	sql.append("DOCTORLEVEL ,  ");//--医师职称  
	//sql.append("--PRESCRIBEFLAG  --代开药标识  ");
	sql.append("INCOEP.INCNO ,");
	sql.append("ci_ap_sug.id_srv_code OPERATIONCODE,  ");// --手术编码                                                                      
	sql.append("ci_order.name_or OPERATION, ");// --手术名称                                                                               
	sql.append("ci_order.des_or REMARK, ");//  --备注                                                                                       
	sql.append("ci_order.createdtime CREATEDATE, ");// --创建时间                                                                           
	sql.append("ci_order.createdby CREATEUSERID ,  ");//--创建人                                                                            
	sql.append("ci_order.modifiedtime  UPDATEDATE,    ");//--更新时间                                                                       
	sql.append(" ci_order.modifiedby UPDATEUSERID,  ");//--更新人                                                                           
	sql.append(" ci_order.dt_effe OPERATIONDATE,  ");//--手术时间                                                                           
	sql.append(" ci_ap_sug_emp.id_emp OPERATIONDOCTOR,  ");// --手术医师                                                                    
	sql.append(" ci_ap_sug.sd_anestp ANAESTHESIATYPE,  ");// --麻醉方式                                                                     
	sql.append(" bd_udidoc2.name  ");
	sql.append(" ANAESTHESIADOCTOR  ");//--麻醉医师                                                                                         
	//sql.append("--PROCESS  --手术过程                                                                                                  ");
	sql.append("from ci_ap_sug ci_ap_sug  ");
	sql.append("left join ci_ap_sug_emp  ci_ap_sug_emp on ci_ap_sug_emp.id_apop = ci_ap_sug.id_apop ");
	sql.append("left join  bd_udidoc  bd_udidoc on bd_udidoc.id_udidoc= ci_ap_sug_emp.id_role  and ci_ap_sug_emp.sd_role='00'  ");
	sql.append("left join  bd_udidoc  bd_udidoc2 on bd_udidoc2.id_udidoc= ci_ap_sug_emp.id_role  and ci_ap_sug_emp.sd_role='03'  ");
	sql.append("left join ci_order ci_order on ci_order.id_or = ci_ap_sug.id_or    ");
	sql.append("	LEFT JOIN BL_ST_OEP stoep on stoep.id_ent=CI_ORDER.id_en");
	sql.append("	LEFT JOIN BL_INC_OEP incoep on incoep.id_stoep=stoep.id_stoep");
	sql.append(" LEFT JOIN PI_PAT pat on pat.id_pat=stoep.id_pat");
	sql.append(" WHERE PAT.code=? ");
	sql.append(" AND INCOEP.INCNO = ? ");

		return sql.toString();
	}
}
