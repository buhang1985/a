package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBusSt4CmlInsDTOQry implements ITransQry {

	String[] billNos;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetBusSt4CmlInsDTOQry(String[] billNos, String codePat) throws BizException {
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
	
	// patientname --患者姓名
	// sex --性别-
	// cardtype --证件类型
	// cardno --证件号码
	// birthdate --出生日期
	// SSCARDNO --社保号/商保号
	// totalpayamount --费用总金额
	// COLLECTOR --收费员
	// CHARGE_TIME --收费时间
	// jzfs --就诊方式
	
	
	
	// TODO 待询问
	//healthcardno --医保应用号
	// hascalculated --医保是否已结算
	// invoiceno --收费单据号
	// jzstartdate --就诊/住院开始日期
	// jzenddate --就诊/住院结束日期
	
	
	
	
	// MEDICALTYPE --医疗类别
	// yydm --医疗机构编码
	// yymc --医院名称
	
	
	
	
	
	// batchno --批次号
	//TODO 字段都没有
	//DUTYCODE --责任代码
	
	
	/**
	 * BL_ST_OEP   -- 结算表   id_stoep 结算主键
	bl_prop_oep -- 分摊数据  id_propoep 分摊主键 存储关系
	BL_PROP_AR_OEP  --ID_PROPOEP 分摊主键
	outputinfo  医保返回分摊数据集合的XML 
	 */
	
	
	
	
	
	
	
		// selfpay --自费
		// hospitalbreaks --医院减免--
		// xyao --西药
		// zchyao --中成药
		// zcyao --中草药
		// examinecost --检查费
		// radiate --放射
		// bultrasonic --B超
		// nmr --核磁
		// testcost --治疗费
		// materialscost --材料费
		// operationcost --手术费
		// oxygencost --输氧费
		// bloodcost --输血费
		// orthodonticcost --正畸费--
		// inserttoothcost --镶牙费--
		// sfjdcost --司法鉴定--
		// othercost --其他项目
		// diagnosticcost --诊察费--
		// treatcost --化验费
		// medicalservcost --医事服务费
		// consultationcost --一般诊疗费
		// registrationcost --挂号费
		// othermzcost --其他门诊收费--
	
	
	
	
	
	
	
	
	// TRADENO --保险交易流水号
	
	// PERSONALPAYAMOUNT --个人账户支付金额
	// REMAINAMOUNT --个人账户余额
	// OPBIGPAYMOUNT --门诊大额支付金额
	// OPSELFPAYAMOUNT --门诊大额自付金额（自付一）
	// BIGSELFPAYAMOUNT --超大额自付金额
	// INSURANCEAMOUNT --医保内总金额
	// OUTINSURANCEAMOUNT --医保外总金额
	// ADDINSURANCEPAYAYAMOUNT --补充保险支付金额
	// RESIDUALPAYAMOUNT --军残补助保险金额
	// SELFPAYAMOUNT2 --个人自付二
	// BEGINPAYAMOUNT --本次付起付线金额
	// ISSINGLEILL --是否按照单病种结算
	// fundpayamount --基金支付金额
	// cashpayamount --个人支付金额
	
	
	
	
	
	
	
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();

		
		sql.append("SELECT ");
		sql.append("PAT.name as patientname,");//--患者姓名
		sql.append("sexdoc.CODE_IE SEX,");//--患者性别                                                                     
		sql.append("idtpdoc.CODE_IE CREDENTIALTYPE,  ");//--证件类型                                                
		sql.append("pat.id_code CREDENTIALNO,    ");//--证件号码                                                       
		sql.append("pat.dt_birth BIRTHDATE,  ");//--出生日期                                                           
		sql.append("pathp.no_hp SSCARDNO,  ");//--出生日期                                                           
		sql.append("STOEP.code_enttp jzfs,");//就诊类型
		sql.append("psn.code COLLECTOR, ");//结算人员
		sql.append("STOEP.dt_st Charge_time, ");//结算日期
		sql.append("STOEP.AMT COST,");//--总费用        
		sql.append("INCOEP.INCNO , ");
		sql.append("\"DECODE\"(STOEP.id_par, null,'N','~','N', 'Y')  ISBACKCOST ");//是否退费
		//TODO
		// ISBACKCOST --是否退费
		// createuserid --创建人
		// createdate --创建时间
		// updateuserid --更新人
		// updatedate --更新时间
		// upflag --更新标示
		
		
		sql.append("FROM BL_ST_OEP STOEP  ");
		sql.append("INNER JOIN PI_PAT PAT ON PAT.id_pat=STOEP.ID_PAT ");
		sql.append("LEFT JOIN pi_pat_hp pathp ON PAT.id_pat = pathp.id_pat AND pathp.fg_deft = 'Y' ");
		sql.append("LEFT JOIN bd_udidoc sexdoc ON pat.id_sex = sexdoc.id_udidoc ");
		sql.append("LEFT JOIN BD_PSNDOC psn on psn.id_psndoc=STOEP.id_emp_st ");
		sql.append("LEFT JOIN bd_udidoc idtpdoc ON pat.id_idtp = idtpdoc.id_udidoc ");
		sql.append("INNER JOIN BL_INC_OEP INCOEP ON INCOEP.ID_STOEP=STOEP.ID_STOEP ");
		sql.append(" WHERE PAT.CODE=? ");
		sql.append(" AND INCOEP.INCNO in (");
		for (int i = 0; i < billNos.length; i++) {
			if (i != 0) {
				sql.append(",");
			}
			sql.append("?");
		}
		sql.append(")");
		//需测
		return sql.toString();
	}
}
