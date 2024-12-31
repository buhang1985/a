package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetEn4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetEn4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
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
		param.addParam(codePat);
		for (String string : billNos) {
			param.addParam(string);
		}
		return param;
	}

//	PATIENTID	--患者基本信息ID
//	REGION_CODE	--就诊地区代码
//	ORGANIZATION_GROUP	--就诊医疗集团       en_ent.id_grp
//	ORGANIZATION_ID	--医疗机构代码              en_ent.id_org
//	CODE	--病人类别                         
//	VISIT_NO	--就诊号                    en_ent.code
//	PID	--患者ID                   pi_pat id_pat 或者code 请根据业务判定
//	PATIENTNAME	--患者姓名         pi_pat.name
//	RESPONSE_TYPE	--病人身份             en_ent.id_patca
//	CHARGE_TYPE	--病人费别
//	OUT_VISIT_TIMES	--门诊就诊次数     en_ent_op.times_op
//	GH_DEPT	--挂号科室                 en_ent_op.id_dep_reg
//	  
//	GH_DOCTOR	--挂号医生           en_ent_op.id_emp_reg
//	VISIT_DEPT	--门诊就诊科室      en_ent.id_dep_phy
//	VISIT_DEPT_NM	--门诊就诊科室名称
//	VISIT_DOCTOR	--门诊就诊医生    en_ent.id_emp_phy
//	VISIT_DOCTOR_NM	--门诊就诊医生姓名
//	EFFECTIVE_B	--就诊开始时间     en_ent.dt_acpt
//	EFFECTIVE_E	--就诊结束时间     en_ent.dt_end
//	ADMITTER_MODE	--入院方式         en_ent_ip.id_referalsrc 自定义档案 住院来院方式
//	REASON_CODE	--就诊原因         
//	ADMITTER_SOURCE	--病人来源
//	IN_VISIT_TIMES	--住院次数          en_ent_ip.times_ip
//	ADMISS_DEPT	--入院科室           en_ent_ip.id_dep_phyadm
//	ADMISS_DEPT_NM	--入院科室名称       
//	ADMISS_WARD	--入院病区           en_ent_ip.id_dep_nuradm
//	ADMITTER	--入院医生             en_ent_emp.sd_emprole ='11'--住院医师
//	ATTENDER	--主管医生
//	NURSER	--主管护士                     en_ent_emp.sd_emprole ='20'--住院医师
//	DISCHARGER_DEPT	--出院科室
//	DISCHARGER_DEPT_NM	--出院科室名称    en_ent_ip.id_dep_phydisc
//	DIS_WARD	--出院病区                 en_ent_ip.id_dep_nurdisc
//	BED_NO	--床号                             en_ent_ip.id_bed bd_bed.name
//	DISCHARGER	--出院医生
//	DIS_STATUS	--出院状态
//	DEPT_DIRECTOR	--科室主任               en_ent_emp.sd_emprole ='13'--主任医师
//	PATIENT_STATUS	--病情状态               en_ent_ip.id_level_dise
//	TYPER	--录入者                         en_ent.id_emp_entry
//	TYPER_TIME	--录入时间
//	STATUS_CODE	--标志
//	VISIT_ORDER_NUMBER	--挂号交易流水号

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" SELECT");
		sql.append(" PAT.CODE PATIENTID"); //患者基本信息ID
//		sql.append(" --REGION_CODE"); //就诊地区代码
		sql.append(" ,GRP.CODE ORGANIZATION_GROUP"); //就诊医疗集团
		sql.append(" ,ORG.CODE ORGANIZATION_ID"); //医疗机构代码
		//sql.append(" PATCA.CODE CODE"); //病人类别
		sql.append(" ,ENT.CODE VISIT_NO"); //就诊号
		sql.append(" ,PAT.CODE PID"); //患者ID
		sql.append(" ,PAT.NAME PATIENTNAME"); //患者姓名
		sql.append(" ,PATCA.CODE RESPONSE_TYPE"); //病人身份
//		sql.append(" --CHARGE_TYPE"); //病人费别
		sql.append(" ,ENTOP.TIMES_OP OUT_VISIT_TIMES"); //门诊就诊次数
		sql.append(" ,REDEP.CODE GH_DEPT"); //挂号科室
		sql.append(" ,REDOC.NAME GH_DOCTOR"); //挂号医生
		sql.append(" ,PYDEP.CODE VISIT_DEPT"); //门诊就诊科室
		sql.append(" ,PYDEP.NAME VISIT_DEPT_NM"); //门诊就诊科室名称
		sql.append(" ,PYDOC.CODE VISIT_DOCTOR"); //门诊就诊医生
		sql.append(" ,PYDOC.NAME VISIT_DOCTOR_NM"); //门诊就诊医生姓名
		sql.append(" ,ENT.DT_INSERT EFFECTIVE_B"); //就诊开始时间
		sql.append(" ,NVL(ENT.dt_end, (SELECT dt_inc from bl_inc_oep WHERE id_stoep=(SELECT id_stoep from bl_st_oep WHERE ENT.ID_ENT=id_ent and ROWNUM=1) and ROWNUM=1))  EFFECTIVE_E"); //就诊结束时间
		sql.append(" ,REFDOC.NAME ADMITTER_MODE"); //入院方式
//		sql.append(" --REASON_CODE"); //就诊原因
//		sql.append(" --ADMITTER_SOURCE"); //病人来源
		sql.append(" ,ENTIP.times_ip IN_VISIT_TIMES"); //住院次数
		sql.append(" ,ADMDEP.CODE ADMISS_DEPT"); //入院科室
		sql.append(" ,ADMDEP.NAME ADMISS_DEPT_NM"); //入院科室名称
		sql.append(" ,NURDEP.CODE ADMISS_WARD"); //入院病区
//		sql.append(" --ADMITTER"); //入院医生
//		sql.append(" --ATTENDER"); //主管医生
//		sql.append(" --NURSER"); //主管护士
//		sql.append(" --DISCHARGER_DEPT"); //出院科室
//		sql.append(" --DISCHARGER_DEPT_NM"); //出院科室名称
//		sql.append(" --DIS_WARD"); //出院病区
//		sql.append(" --BED_NO"); //床号
//		sql.append(" --DISCHARGER"); //出院医生
//		sql.append(" --DIS_STATUS"); //出院状态
//		sql.append(" --DEPT_DIRECTOR"); //科室主任
//		sql.append(" --PATIENT_STATUS"); //病情状态
//		sql.append(" --TYPER"); //录入者
//		sql.append(" --TYPER_TIME"); //录入时间
//		sql.append(" --STATUS_CODE"); //标志
//		sql.append(" --VISIT_ORDER_NUMBER"); //挂号交易流水号
		sql.append(" FROM EN_ENT ENT");
		sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT=ENT.ID_PAT");
		sql.append(" LEFT JOIN EN_ENT_OP ENTOP ON ENTOP.ID_ENT=ENT.ID_ENT");
		sql.append(" LEFT JOIN BD_DEP PYDEP ON PYDEP.ID_DEP=ENT.id_dep_phy");
		sql.append(" LEFT JOIN BD_DEP REDEP ON REDEP.ID_DEP=ENTOP.id_dep_reg");
		sql.append(" LEFT JOIN BD_PSNDOC REDOC ON REDOC.ID_PSNDOC=ENTOP.id_emp_reg");
		sql.append(" LEFT JOIN BD_PSNDOC PYDOC ON PYDOC.ID_PSNDOC=ENT.id_emp_phy");
		sql.append(" LEFT JOIN en_ent_ip ENTIP ON ENTIP.ID_ENT=ENT.ID_ENT");
		sql.append(" LEFT JOIN BD_UDIDOC REFDOC ON REFDOC.ID_UDIDOC=ENTIP.id_referalsrc");
		sql.append(" LEFT JOIN BD_DEP ADMDEP ON ADMDEP.ID_DEP=ENTIP.id_dep_phyadm");
		sql.append(" LEFT JOIN BD_DEP NURDEP ON NURDEP.ID_DEP=ENTIP.id_dep_nuradm");
		sql.append(" LEFT JOIN BD_GRP GRP ON GRP.id_grp=ENT.id_grp");
		sql.append(" LEFT JOIN BD_ORG ORG ON ORG.id_org=ENT.id_org");
		sql.append(" LEFT JOIN PI_PAT_CA PATCA ON PATCA.id_patca=ENT.id_patca ");
		
		sql.append(" WHERE PAT.code=? ");
		sql.append(" AND ENT.ID_ENT IN (SELECT nvl(ID_ENT,'0') FROM BL_CG_ITM_OEP WHERE id_stoep in (SELECT nvl(ID_STOEP,'0') FROM BL_INC_OEP WHERE INCNO IN (");
		for (int i = 0; i < billNos.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")))");
		return sql.toString();
	}
}
