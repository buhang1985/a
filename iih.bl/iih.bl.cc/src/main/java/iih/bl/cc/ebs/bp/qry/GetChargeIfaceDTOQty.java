package iih.bl.cc.ebs.bp.qry;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetChargeIfaceDTOQty implements ITransQry {

	Integer groupNum;
	String execDate;
	String hospitalCode = "100";
	Integer[] indexNums = { 1, 2 ,3,4,5};
	Integer ifaceInteger;

	public GetChargeIfaceDTOQty(Integer groupNum, FDate execDate)
			throws BizException {
		if (Arrays.asList(indexNums).contains(groupNum)) {
			this.groupNum = groupNum;
			this.ifaceInteger = this.groupNum;
			if (execDate != null)
				this.execDate = new SimpleDateFormat("yyyy-MM-dd")
						.format(execDate.toDate());
			else
				throw new BizException("请录入执行日期");
		} else {
			throw new BizException("现只支持【门诊普通挂号】 与 【门诊收费】，数据查询");
		}
	}

	public GetChargeIfaceDTOQty(Integer groupNum, FDate execDate,
			Integer ifaceid) throws BizException {
		if (Arrays.asList(indexNums).contains(groupNum)) {
			this.groupNum = groupNum;
			this.ifaceInteger = ifaceid;
			if (execDate != null)
				this.execDate = new SimpleDateFormat("yyyy-MM-dd")
						.format(execDate.toDate());
			else
				throw new BizException("请录入执行日期");
		} else {
			throw new BizException("现只支持【门诊普通挂号】 与 【门诊收费】，数据查询");
		}
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		return param;
	}

	@Override
	public String getQrySQLStr() {
		String selSql = "";
		String eu_sttp="";
		switch (this.groupNum) {
		case 1:
			//selSql = getSqlStringBy1();
			selSql = getSqlByOutpatientRegistration("J3","'31', '43'");
			break;
		case 2:
			//selSql = getSqlStringBy2();
			selSql =getSqlByOutpatientRegistration("J4","'30', '40', '41'");
			break;
		case 3:	
			selSql =getSqlByPrepaidPayment();
			break;
		case 4:
			selSql=getSqlByPrepaidPaymentJS();
			break;
		case 5:
			selSql = getSqlByPrepaidPaymentDeposit();
			break;
		default:
			break;
		}
		return selSql;
	}
	/**
	 * 获取门诊挂号SQL by li 2017-05-22
	 * @return
	 */
private String getSqlByOutpatientRegistration(String type,String eu_sttp){
	StringBuffer sb = new StringBuffer();
	sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
	sb.append(" (( ");
	// 现金、支付宝、微信、合同单位、银行卡、预付款
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" '"+type+"' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" NULL as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	// 支付方式
	sb.append(" tbl.pri_pmconcode as CHARGE_TYPE, ");
	// 支付方式名称
	sb.append(" tbl.pri_pmconname as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" tbl.Name_CUST as RECEIVABLE_COMP_NAME, ");
	sb.append(" tbl.CODE_CUST as RECEIVABLE_COMP, ");
	sb.append(" NULL as SYNC_DATE, ");
	sb.append(" NULL as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" tbl.pri_pmconname as DESCRIPTION ");
	sb.append(" FROM  ");
	// 查询数据
	sb.append(" (select SUBSTR(D.DT_CC,0,10) DT,con.pri_pmconcode,con.pri_pmconname,E.CODE as CODE_CUST, E.NAME as Name_CUST ,sum(b.amt*b.eu_direct) as AMT ");
	sb.append("   FROM BL_PAY_PAT_OEP A");
	sb.append("   INNER JOIN BL_PAY_ITM_PAT_OEP B ");
	sb.append("     ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
	sb.append("   inner join bd_pri_contrast con on b.sd_pm= con.pri_pmcode  ");
	sb.append("     INNER JOIN BL_ST_OEP C ");
	sb.append("  ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
	sb.append(" 		INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC  ");
	sb.append("  LEFT JOIN BD_CUST E ");
	sb.append("     ON B.ID_BANK = E.ID_CUST ");
	sb.append("   LEFT JOIN BD_BANK F ");
	sb.append("     ON B.ID_BANK = F.ID_BANK ");
	sb.append("  WHERE");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");
	// 结算类型
	sb.append("    AND C.EU_STTP IN ("+eu_sttp+") ");
	sb.append("    group by SUBSTR(D.DT_CC,0,10),con.pri_pmconcode,con.pri_pmconname,B.SD_PM,E.CODE, E.NAME");
	sb.append(" ) tbl ");
	sb.append(" union ");
	//按照账单项目分组，开单科室、执行科室分组查询
		sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" '"+type+"' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" tbl.id_dep_or as CHARGE_DEPT, ");
	sb.append(" tbl.id_dep_mp as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" tbl.code_inccaitm as CHARGE_ITEM, ");
	sb.append(" tbl.name_inccaitm as CHARGE_ITEM_NAME, ");
	// 支付方式
	sb.append(" Null as CHARGE_TYPE, ");
	// 支付方式名称
	sb.append(" Null as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" NULL as SYNC_DATE, ");
	sb.append(" tbl.name_dep_or as CHARGE_DEPT_NAME, ");
	sb.append(" tbl.name_dep_mp as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" NULL as DESCRIPTION ");
	sb.append(" FROM  ");
	// 现金查询数据
	sb.append(" (select SUBSTR(D.DT_CC,0,10) DT,code_inccaitm,name_inccaitm,b.id_dep_or,depor.name as name_dep_or,b.id_dep_mp,depmp.name  as name_dep_mp,sum(a.eu_direct*b.amt-b.amt_hp)*-1 as AMT ");
	sb.append("   FROM BL_CG_OEP a");
	sb.append("   left join BL_CG_ITM_OEP b on a.ID_CGOEP=b.ID_CGOEP ");
	sb.append("   INNER JOIN BL_ST_OEP C on b.id_stoep=c.id_stoep");
	sb.append("    INNER JOIN BL_CC D on c.id_cc=d.id_cc ");
	sb.append("     left join bd_dep depor on b.id_dep_or=depor.id_dep");
	sb.append("  left join bd_dep depmp on b.id_dep_mp=depmp.id_dep ");
	sb.append("  WHERE");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");
	// 结算类型：挂号结算、挂号取消结算
	sb.append("   and  c.EU_STTP IN ("+eu_sttp+") ");
	sb.append("    group by SUBSTR(D.DT_CC, 0, 10),code_inccaitm,name_inccaitm,b.id_dep_or,b.id_dep_mp,depor.name,depmp.name ");
	sb.append(" )tbl ");
	sb.append(" )) alltbl ");
	sb.append(" WHERE ");
	sb.append(" alltbl.AMOUNT <> 0 ");
	
	return sb.toString();
}
/**
 * 获取预交金收费sql by li
 * @return
 */
private String getSqlByPrepaidPayment() {
	StringBuffer sb = new StringBuffer();
	sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
	sb.append(" (");
	// 现金、支付宝、微信、合同单位、银行卡、预付款
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JN' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" NULL as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	sb.append(" NULL as CHARGE_TYPE, ");
	sb.append(" NULL as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" NULL as SYNC_DATE, ");
	sb.append(" NULL as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" '门诊预付费记账' as DESCRIPTION ");
	sb.append(" FROM  ");	
	// 查询数据
	sb.append(" (select b.DT, b.AMT-a.AMT as AMT from ");
	//--未结算的退预交金
	sb.append("   (select SUBSTR(D.DT_CC, 0, 10) DT,NVL(sum(a.eu_direct * b.amt_acc),0) as AMT");
	sb.append("  FROM BL_CG_OEP a");
	sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
	sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
	sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append(" and c.id_paypatoep is null and b.amt_acc is not null  and fg_pricinginsertcg='N' ");
	sb.append(" and  a.eu_direct='-1'");
	//--预交金记账正值 
	sb.append(" group by  SUBSTR(D.DT_CC, 0, 10))a,");
	//--预交金记账正值 
	sb.append(" （  select SUBSTR(D.DT_CC, 0, 10) DT,sum(a.eu_direct * b.amt_acc)as AMT");
	sb.append(" FROM BL_CG_OEP a");
	sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
	sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
	sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");
	sb.append(" and a.eu_direct='1'and fg_pricinginsertcg='N'");
	sb.append(" group by  SUBSTR(D.DT_CC, 0, 10) )b");
	sb.append(" ) tbl ");
	sb.append(" union (");	
	// 预付费卡结算后退费金额 
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JN' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" NULL as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	// 支付方式
	sb.append(" NULL as CHARGE_TYPE, ");
	// 支付方式名称
	sb.append(" NULL as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" NULL as SYNC_DATE, ");
	sb.append(" NULL as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" '门诊预付费记账' as DESCRIPTION ");
	sb.append(" FROM  ");	
	// 查询数据//--未结算的退预交金
	sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,sum(a.eu_direct * b.amt_acc) as AMT");
	sb.append("  FROM BL_CG_OEP a");
	sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
	sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
	sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append("  and c.id_paypatoep is not null ");
	sb.append(" and b.amt_acc is not null  and fg_pricinginsertcg='N' and  a.eu_direct='-1' ");
	sb.append(" group by  SUBSTR(D.DT_CC, 0, 10)");
	sb.append(" ) tbl) ");
	sb.append(" union (");	
	// 预付费卡结算后退费金额 
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JN' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" NULL as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	// 支付方式
	sb.append(" NULL as CHARGE_TYPE, ");
	// 支付方式名称
	sb.append(" NULL as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" NULL as SYNC_DATE, ");
	sb.append(" NULL as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" '门诊预付费记账' as DESCRIPTION ");
	sb.append(" FROM  ");	
	// 查询数据//--未结算的退预交金
	sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,sum(a.eu_direct * b.amt_acc) as AMT");
	sb.append("  FROM BL_CG_OEP a");
	sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
	sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
	sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append(" and c.id_paypatoep is not null ");
	sb.append(" and b.amt_acc is not null  and fg_pricinginsertcg='Y' ");
	sb.append(" group by  SUBSTR(D.DT_CC, 0, 10)");
	sb.append(" ) tbl) ");	
	sb.append(" union (");	
	// 预付费卡结算后退费金额 
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JN' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" tbl.id_dep_or as CHARGE_DEPT, ");
	sb.append(" tbl.id_dep_mp as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" tbl.code_inccaitm as CHARGE_ITEM, ");
	sb.append(" tbl.name_inccaitm as CHARGE_ITEM_NAME, ");
	// 支付方式
	sb.append(" NULL as CHARGE_TYPE, ");
	// 支付方式名称
	sb.append(" NULL as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" NULL as SYNC_DATE, ");
	sb.append(" tbl.name_dep_or as CHARGE_DEPT_NAME, ");
	sb.append(" tbl.name_dep_mp as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" tbl.name_inccaitm as DESCRIPTION ");
	sb.append(" FROM  ");	
	// 查询数据按开单科室 执行科室 门诊项目
	sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,code_inccaitm,name_inccaitm,b.id_dep_or,depor.name as name_dep_or,b.id_dep_mp,depmp.name as name_dep_mp,sum(a.eu_direct * b.amt_acc)*-1 as AMT");
	sb.append("  FROM BL_CG_OEP a");
	sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
	sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
	sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
	sb.append(" left join bd_dep depor on b.id_dep_or = depor.id_dep");
	sb.append(" left join bd_dep depmp on b.id_dep_mp = depmp.id_dep");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append(" and amt_acc is not null and fg_pricinginsertcg='Y'  ");
	sb.append(" group by  SUBSTR(D.DT_CC, 0, 10),code_inccaitm,name_inccaitm,b.id_dep_or, b.id_dep_mp,depor.name,depmp.name ");
	sb.append(" ) tbl ");	
	sb.append(" )) alltbl ");
	sb.append(" WHERE ");
	sb.append(" alltbl.AMOUNT <> 0 ");
		
	return sb.toString();
	
}
/**
 * 预交金结算 JO by li
 * @return
 */
private String getSqlByPrepaidPaymentJS(){
	StringBuffer sb = new StringBuffer();
	sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
	sb.append(" (");
	//取预交金结算金额，方向为正的
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JO' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" tbl.PRI_PMCONCODE as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	sb.append(" NULL as CHARGE_TYPE, ");
	sb.append(" NULL as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" tbl.DT as SYNC_DATE, ");
	sb.append(" tbl.PRI_PMCONNAME as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" '门诊预付费结算' as DESCRIPTION ");
	sb.append(" FROM  ");	
	sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,con.PRI_PMCONCODE,con.PRI_PMCONNAME,sum(B.AMT) as AMT");
	sb.append("   FROM BL_PAY_PAT_OEP A");
	sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
	sb.append(" INNER JOIN BL_ST_OEP C ON A.ID_PAYPATOEP = C.ID_PAYPATOEP");
	sb.append(" INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC");
	sb.append(" inner join bd_pri_contrast con on B.sd_pm = con.pri_pmcode");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append(" and  C.EU_STTP IN ('30', '40', '41') AND B.SD_PM = '05' and B.eu_direct='1' ");
	sb.append(" group by SUBSTR(D.DT_CC, 0, 10) ,con.PRI_PMCONCODE,con.PRI_PMCONNAME");
	sb.append(" ) tbl ");
	sb.append(" union (");	
	//取预交金结算金额，方向为正的，然后取反， 
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JO' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" NULL as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	sb.append(" NULL as CHARGE_TYPE, ");
	sb.append(" NULL as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" tbl.DT as SYNC_DATE, ");
	sb.append(" NULL as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'Y' AS RECEIVABLE_FLAG, ");
	sb.append(" '门诊预付费记账' as DESCRIPTION ");
	sb.append(" FROM  ");	
	sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,con.PRI_PMCONCODE,con.PRI_PMCONNAME,sum(B.AMT)*-1 as AMT");
	sb.append("   FROM BL_PAY_PAT_OEP A");
	sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
	sb.append(" INNER JOIN BL_ST_OEP C ON A.ID_PAYPATOEP = C.ID_PAYPATOEP");
	sb.append(" INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC");
	sb.append(" inner join bd_pri_contrast con on B.sd_pm = con.pri_pmcode");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append(" and  C.EU_STTP IN ('30', '40', '41') AND B.SD_PM = '05' and B.eu_direct='1' ");
	sb.append(" group by SUBSTR(D.DT_CC, 0, 10) ,con.PRI_PMCONCODE,con.PRI_PMCONNAME");
	sb.append(" ) tbl ");	
	sb.append(" )) alltbl ");
	sb.append(" WHERE ");
	sb.append(" alltbl.AMOUNT <> 0 ");	
	return sb.toString();
}
/**
 * JY预付费押金
 * @return
 */

private String getSqlByPrepaidPaymentDeposit(){
	StringBuffer sb = new StringBuffer();
	sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
	sb.append(" (");
	//取预交金押金
	sb.append(" SELECT  ");
	sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
	sb.append(" 'JY' as BUSINESS_TYPE, ");
	sb.append(" '100' as HOSPITAL_CODE, ");
	sb.append(" 'OP' as OP_IP_FLAG, ");
	sb.append(" NULL as CHARGE_DEPT, ");
	sb.append(" NULL as EXECUTE_DEPT, ");
	sb.append(" NULL as UNDER_DEPT, ");
	sb.append(" NULL as CHARGE_ITEM, ");
	sb.append(" NULL as CHARGE_ITEM_NAME, ");
	sb.append(" tbl.PRI_PMCONCODE as CHARGE_TYPE, ");
	sb.append(" tbl.PRI_PMCONNAME as CHARGE_TYPE_NAME, ");
	// 支付金额
	sb.append(" tbl.AMT as AMOUNT, ");
	// 支付日期
	sb.append(" tbl.DT as OPERATING_DATE, ");
	sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
	sb.append(" NULL as RECEIVABLE_COMP, ");
	sb.append(" tbl.DT as SYNC_DATE, ");
	sb.append(" NULL as CHARGE_DEPT_NAME, ");
	sb.append(" NULL as EXECUTE_DEPT_NAME, ");
	sb.append(" NULL as UNDER_DEPT_NAME, ");
	sb.append(" NULL as BILL_NUM, ");
	sb.append(" NULL as BILL_DATE, ");
	sb.append(" 'N' as PROCESS_FLAG, ");
	sb.append(" 'N' as PREPAY_FLAG, ");
	sb.append(" 'N' AS RECEIVABLE_FLAG, ");
	sb.append(" tbl.PRI_PMCONNAME as DESCRIPTION ");
	sb.append(" FROM  ");	
	sb.append(" (select SUBSTR(A.dt_pay, 0, 10) DT ,con.PRI_PMCONCODE,con.PRI_PMCONNAME,sum(eu_direct*AMT) AMT");
	sb.append("   from BL_PREPAY_PAT  A ");
	sb.append(" inner join bd_pri_contrast con on A.sd_pm = con.pri_pmcode");
	sb.append(" where ");
	// 当日结账
	sb.append(" TRUNC(TO_DATE(dt_pay,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
			+ this.execDate + "','yyyy-MM-dd')");	
	sb.append(" group by SUBSTR(A.dt_pay, 0, 10) ,con.PRI_PMCONCODE,con.PRI_PMCONNAME");
	sb.append(" ) tbl ");	
	sb.append(" ) alltbl ");
	sb.append(" WHERE ");
	sb.append(" alltbl.AMOUNT <> 0 ");	
	return sb.toString();
}
/**
	 * 获取门诊挂号SQL
	 * 
	 * @return
	 */
	private String getSqlStringBy1() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
		sb.append(" (( ");
		// 现金、支付宝、微信、合同单位、银行卡、预付款
		sb.append(" SELECT  ");
		sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
		sb.append(" 'J3' as BUSINESS_TYPE, ");
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付方式
		sb.append(" CHARGE_TYPE, ");
		// 支付方式名称
		sb.append(" as CHARGE_TYPE_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" DECODE(tbl.SD_PM,'09',tbl.Name_CUST,NULL) as RECEIVABLE_COMP_NAME, ");
		sb.append(" DECODE(tbl.SD_PM,'09',tbl.CODE_CUST,NULL) as RECEIVABLE_COMP, ");
		sb.append(" NULL as SYNC_DATE, ");
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" DECODE(tbl.SD_PM,'01','现金','02','银行卡','05','门诊预付费结算','09','合同单位','11','支付宝','12','微信') as DESCRIPTION ");
		sb.append(" FROM  ");
		// 现金查询数据
		sb.append(" (SELECT SUM(B.AMT*B.EU_DIRECT) AMT,SUBSTR(D.DT_CC,0,10) DT, B.SD_PM, ");
		sb.append(" E.Name as Name_CUST,E.CODE AS CODE_CUST,F.NAME AS NAME_BANK,F.CODE AS CODE_BANK ");
		sb.append("   FROM BL_PAY_PAT_OEP A ");
		sb.append("  INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("     ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append("  INNER JOIN BL_ST_OEP C ");
		sb.append("     ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append("  INNER JOIN BL_CC D ");
		sb.append(" 		ON A.ID_CC = D.ID_CC ");
		sb.append("  LEFT JOIN BD_CUST E ");
		sb.append("     ON B.ID_BANK = E.ID_CUST ");
		sb.append("   LEFT JOIN BD_BANK F ");
		sb.append("     ON B.ID_BANK = F.ID_BANK ");
		sb.append("  WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：挂号结算、挂号取消结算
		sb.append("    AND C.EU_STTP IN ('31', '43') ");
		// 支付方式：微信
		sb.append("    AND B.SD_PM IN ('01','11','12','09','02','05')   ");
		sb.append(" and d.id_emp ='0001Z7100000000GJRMW' ");
		sb.append("    group by SUBSTR(D.DT_CC,0,10),B.SD_PM ,E.Name,E.CODE ,F.Name,F.CODE ");
		sb.append(" ) tbl ");
		sb.append(" ) ");
		sb.append("  ");
		sb.append(" UNION ");
		sb.append(" ( ");
		// 门诊挂号收入（非特需）,门诊挂号收入（特需）,门诊诊察收入（非特需）,门诊诊察收入（特需）
		sb.append(" SELECT ");
		sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
		sb.append(" 'J3' as BUSINESS_TYPE, ");
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" tbl.DEPCODE as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");
		sb.append(" tbl.INCCACODE as CHARGE_ITEM, ");
		sb.append(" tbl.INCCANAME as CHARGE_ITEM_NAME, ");
		sb.append(" NULL  as CHARGE_TYPE, ");
		sb.append(" NULL as CHARGE_TYPE_NAME, ");
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
		sb.append(" NULL as RECEIVABLE_COMP, ");
		sb.append(" NULL as SYNC_DATE, ");
		sb.append(" tbl.DEPNAME as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'Y' AS RECEIVABLE_FLAG, ");
		sb.append(" DECODE(tbl.CODE,'060','门诊挂号收入','门诊诊察收入')|| '-' ||tbl.SD_SVRTP as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" (SELECT -1*SUM(D.EU_DIRECT * C.AMT_RATIO) AMT,DEP.CODE DEPCODE,DEP.NAME DEPNAME,Y.CODE INCCACODE,SUBSTR(B.DT_CC,0,10) DT, ");
		sb.append(" DECODE(Y.CODE,'019','其它','063','诊疗费',Y.NAME) INCCANAME, ");
		sb.append(" DECODE(E.SD_SVRTP,'090104','特需','非特需') SD_SVRTP, Y.CODE ");
		sb.append(" FROM BL_ST_OEP A ");
		sb.append(" INNER JOIN BL_CC B ON A .ID_CC = B.ID_CC ");
		sb.append(" INNER JOIN BL_CG_ITM_OEP C ON A .ID_STOEP = C.ID_STOEP ");
		sb.append(" INNER JOIN BL_CG_OEP D ON C.ID_CGOEP = D .ID_CGOEP ");
		sb.append(" INNER JOIN EN_ENT_OP E ON A .ID_ENT = E .ID_ENT ");
		sb.append(" INNER JOIN BD_DEP DEP ON DEP.ID_DEP = E .ID_DEP_REG ");
		sb.append(" INNER JOIN BD_INCCA_ITM_REL Z ON C.ID_SRV = Z.ID_SRV ");
		sb.append(" INNER JOIN BD_INCCA_ITM Y ON Z.ID_INCCAITM = Y.ID_INCCAITM ");
		sb.append(" INNER JOIN BD_INCCA X ON Y.ID_INCCA = X.ID_INCCA ");
		sb.append(" WHERE  ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(B.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		sb.append("  AND A.EU_STTP IN ('31', '43') ");
		// 门诊发票
		sb.append("  AND X.CODE = '11'  ");
		sb.append("  ");
		sb.append("  AND Y.CODE <> '061'  ");
		sb.append(" and b.id_emp ='0001Z7100000000GJRMW' ");
		sb.append("  GROUP BY SUBSTR(B.DT_CC,0,10),DEP.CODE,DEP.NAME,Y.NAME,DECODE (E.SD_SVRTP,'090104','特需','非特需'), Y.CODE) tbl  ");
		
		sb.append(" union ");
		sb.append(" SELECT  ");		
		sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
		sb.append(" 'J3' as BUSINESS_TYPE, ");
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付方式
		sb.append(" DECODE(tbl.SD_PM,'09','j','15','019','03','2','04','3','51','7','02','c','08','d','11','f','12','v')  as CHARGE_TYPE, ");		
		// 支付方式名称
		sb.append(" DECODE(tbl.SD_PM,'09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信') as CHARGE_TYPE_NAME, ");
		
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");		
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" DECODE(tbl.SD_PM,'09',tbl.Name_CUST,NULL) as RECEIVABLE_COMP_NAME, ");
		sb.append(" DECODE(tbl.SD_PM,'09',tbl.CODE_CUST,NULL) as RECEIVABLE_COMP, ");
		sb.append(" NULL as SYNC_DATE, ");
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'Y' AS RECEIVABLE_FLAG, ");		
		sb.append(" DECODE(tbl.SD_PM,'09','昌平总工会-合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信')as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" ( ");
		
		sb.append(" SELECT SUM(B.AMT*B.EU_DIRECT) AMT, ");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,E.NAME NAME_CUST,E.CODE CODE_CUST,B.SD_PM SD_PM ");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append(" LEFT JOIN BD_PRI_PM PM ");
		sb.append("    ON B.ID_PM = PM.ID_PM ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
		sb.append(" LEFT JOIN BD_CUST E ");
		sb.append("    ON B.ID_BANK = E.ID_CUST ");
		sb.append(" WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  C.EU_STTP IN ('31', '43') ");
		// 支付方式：昌平总工会
		sb.append(" AND B.SD_PM = '09' ");
		sb.append(" AND E.code = '62' ");
		sb.append(" and d.id_emp ='0001Z7100000000GJRMW' ");
		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),e.code,E.NAME,B.SD_PM ");
		sb.append(" ORDER BY DT ");
		sb.append(" ) tbl  ");
		sb.append(" )) alltbl ");
		sb.append(" WHERE ");
		sb.append(" alltbl.AMOUNT <> 0 ");
		return sb.toString();
	}

	/**
	 * 获取门诊收费SQL
	 */
	private String getSqlStringBy2() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT '" + ifaceInteger + "' as IFACE_BATCH_ID, ");
		sb.append(" ROWNUM as LINE_NUM,  ");
		sb.append(" 'J4' as BUSINESS_TYPE, ");
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" alltbl.* FROM ");
		sb.append(" ( ");
		
		sb.append(" SELECT  ");			
		sb.append(" tbl.ORCODE as CHARGE_DEPT, ");
		sb.append(" tbl.MPCODE as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
//		sb.append(" DECODE(tbl.SD_PM,'15','019','03','2','04','3','51','7','02','c','08','d','11','f','12','v','09','j')  as CHARGE_TYPE, ");
		sb.append(" NULL as CHARGE_TYPE, ");
		// 支付方式名称
//		sb.append(" DECODE(tbl.SD_PM,'15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信','09','合同单位记账') as CHARGE_TYPE_NAME, ");
		sb.append(" NULL as CHARGE_TYPE_NAME, ");
		sb.append(" DECODE(TBL.SD_PM,'15','019',NULL) as CHARGE_ITEM, ");
		sb.append(" DECODE(TBL.SD_PM,'15','其它',NULL) as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
		sb.append(" NULL as RECEIVABLE_COMP, ");		
		sb.append(" tbl.ORNAME AS CHARGE_DEPT_NAME, ");
		sb.append(" tbl.MPNAME as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL AS BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");
		sb.append(" DECODE( tbl.SD_PM,'15','减免方式',NULL) as DESCRIPTION ");
		sb.append(" FROM  ");

		// 减免方式查询数据
		sb.append("(");
		sb.append(" SELECT SUM(B.AMT*B.EU_DIRECT) AMT, DEPOR.CODE ORCODE,DEPOR.NAME ORNAME,DEPMP.CODE MPCODE,DEPMP.NAME MPNAME, ");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,E.CODE_INCCAITM CODE_INCCAITM, E.NAME_INCCAITM NAME_INCCAITM,B.SD_PM SD_PM");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
		sb.append(" INNER JOIN BL_CG_ITM_OEP E ");
		sb.append("    ON C.ID_STOEP = E.ID_STOEP ");
		sb.append(" INNER JOIN BD_DEP DEPOR ");
		sb.append("    ON E.ID_DEP_OR = DEPOR.ID_DEP ");
		sb.append(" INNER JOIN BD_DEP DEPMP ");
		sb.append("    ON E.ID_DEP_MP = DEPMP.ID_DEP ");
		sb.append("  WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
		// 支付方式：减免方式
		sb.append(" AND B.SD_PM = '15' ");
		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),E.CODE_INCCAITM,E.NAME_INCCAITM,DEPOR.CODE,DEPOR.NAME,DEPMP.CODE,DEPMP.NAME,B.SD_PM ");
		sb.append(" ORDER BY SUBSTR(D.DT_CC,0,10) ");
		sb.append(" ) tbl ");
		
		sb.append(" union ");
		
		sb.append(" SELECT  ");		
		
		sb.append(" tbl.ORCODE as CHARGE_DEPT, ");
		sb.append(" tbl.MPCODE as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
//		sb.append(" DECODE(tbl.SD_PM,'15','019','03','2','04','3','51','7','02','c','08','d','11','f','12','v','09','j')  as CHARGE_TYPE, ");
		sb.append(" NULL as CHARGE_TYPE, ");
		// 支付方式名称
//		sb.append(" DECODE(tbl.SD_PM,'15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信','09','合同单位记账') as CHARGE_TYPE_NAME, ");
		sb.append(" NULL as CHARGE_TYPE_NAME, ");
		sb.append(" tbl.CODE_INCCAITM as CHARGE_ITEM, ");
		sb.append(" tbl.NAME_INCCAITM as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
		sb.append(" NULL as RECEIVABLE_COMP, ");		
		sb.append(" tbl.ORNAME AS CHARGE_DEPT_NAME, ");
		sb.append(" tbl.MPNAME as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL AS BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");	
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");	
		sb.append(" DECODE(tbl.NAME_INCCAITM,NULL,NULL,'总收入-') || tbl.NAME_INCCAITM as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" ( ");
		
		sb.append(" SELECT -1*SUM(E.AMT*F.EU_DIRECT) AMT, DEPOR.CODE ORCODE,DEPOR.NAME ORNAME,DEPMP.CODE MPCODE,DEPMP.NAME MPNAME, ");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,E.CODE_INCCAITM CODE_INCCAITM, E.NAME_INCCAITM NAME_INCCAITM");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
		sb.append(" INNER JOIN BL_CG_ITM_OEP E ");
		sb.append("    ON C.ID_STOEP = E.ID_STOEP ");
		sb.append(" INNER JOIN BD_DEP DEPOR ");
		sb.append("    ON E.ID_DEP_OR = DEPOR.ID_DEP ");
		sb.append(" INNER JOIN BD_DEP DEPMP ");
		sb.append("    ON E.ID_DEP_MP = DEPMP.ID_DEP ");
		sb.append(" INNER JOIN BL_CG_OEP F ");
		sb.append("    ON E.ID_CGOEP = F.ID_CGOEP ");
		sb.append("  WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
		// 支付方式： 总收入（负值）
		sb.append(" AND B.SD_PM <> '15' ");		
		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),E.CODE_INCCAITM,E.NAME_INCCAITM,DEPOR.CODE,DEPOR.NAME,DEPMP.CODE,DEPMP.NAME ");
		sb.append(" ORDER BY SUBSTR(D.DT_CC,0,10) ");	
		
		sb.append(" ) tbl ");	
		
		sb.append(" union ");
		
		sb.append(" SELECT  ");		
		
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
		sb.append(" DECODE(tbl.SD_PM,'15','019','03','2','04','3','51','7','02','c','08','d','11','f','12','v','09','j')  as CHARGE_TYPE, ");		
		// 支付方式名称
		sb.append(" DECODE(tbl.SD_PM,'15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信','09','合同单位记账') as CHARGE_TYPE_NAME, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
		sb.append(" NULL as RECEIVABLE_COMP, ");		
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" tbl.PAYMODENUM as BILL_NUM, ");
		sb.append(" tbl.dt as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");	
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");
		sb.append(" DECODE(tbl.SD_PM,'15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信','09','合同单位记账')as DESCRIPTION ");
		sb.append(" FROM  ");
		
		sb.append(" ( ");
		
		sb.append(" SELECT SUM(B.AMT*B.EU_DIRECT) AMT, ");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,B.PAYMODENODE PAYMODENUM,B.SD_PM SD_PM ");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
//		sb.append(" LEFT JOIN BD_PRI_PM PM ");
//		sb.append("    ON B.ID_PM = PM.ID_PM ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
		sb.append(" LEFT JOIN BD_BANK E ");
		sb.append("    ON B.ID_BANK = E.ID_BANK ");
		sb.append(" WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
		// 支付方式：支票/汇票/内部转账/支付宝/微信
		sb.append(" AND B.SD_PM in ('03','04','51','11','12') ");
		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),B.PAYMODENODE,B.SD_PM ");
		sb.append(" ORDER BY SUBSTR(D.DT_CC,0,10) ");
	
		sb.append(" ) tbl ");	
		sb.append(" union ");
		
		sb.append(" SELECT  ");		
		
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
		sb.append(" DECODE(tbl.SD_PM,'09','j','15','019','03','2','04','3','51','7','02','c','08','d','11','f','12','v')  as CHARGE_TYPE, ");		
		// 支付方式名称
		sb.append(" DECODE(tbl.SD_PM,'09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信') as CHARGE_TYPE_NAME, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" DECODE(tbl.SD_PM,'09',tbl.Name_CUST,NULL) as RECEIVABLE_COMP_NAME, ");
		sb.append(" DECODE(tbl.SD_PM,'09',tbl.CODE_CUST,NULL) as RECEIVABLE_COMP, ");;		
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");	
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");
		sb.append(" DECODE(tbl.SD_PM,'09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','02','MIS银行卡','08','POS银行卡','11','支付宝','12','微信')as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" ( ");
		sb.append(" SELECT SUM(B.AMT*B.EU_DIRECT) AMT, ");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,E.NAME NAME_CUST,E.CODE CODE_CUST,B.SD_PM SD_PM ");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
//		sb.append(" LEFT JOIN BD_PRI_PM PM ");
//		sb.append("    ON B.ID_PM = PM.ID_PM ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
		sb.append(" LEFT JOIN BD_CUST E ");
		sb.append("    ON B.ID_BANK = E.ID_CUST ");
		sb.append(" WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
		// 支付方式：合同单位
		sb.append(" AND B.SD_PM = '09' ");
		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),E.CODE,E.NAME,B.SD_PM ");
		sb.append(" ORDER BY SUBSTR(D.DT_CC,0,10) ");
	
		sb.append(" ) tbl ");
			// by li 2017-05-20 将银行卡收费和退费合并
		sb.append(" union ");
		sb.append(" SELECT  ");		
		
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
		sb.append(" DECODE(tbl.SD_PM,'02','c','08','d','09','j','15','019','03','2','04','3','51','7','11','f','12','v')  as CHARGE_TYPE, ");		
		// 支付方式名称
		sb.append(" DECODE(tbl.SD_PM,'02','MIS银行卡','08','POS银行卡','09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','11','支付宝','12','微信') as CHARGE_TYPE_NAME, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
		sb.append(" NULL as RECEIVABLE_COMP, ");;		
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");		
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");
		sb.append(" DECODE(tbl.SD_PM,'02','MIS银行卡-收','08','POS银行卡-收','09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','11','支付宝','12','微信') as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" ( ");
		
		sb.append(" SELECT SUM(B.AMT) AMT, ");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,B.SD_PM SD_PM ");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
//		sb.append(" LEFT JOIN BD_PRI_PM PM ");
//		sb.append("    ON B.ID_PM = PM.ID_PM ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
//		sb.append(" LEFT JOIN BD_BANK E ");
//		sb.append("    ON B.ID_BANK = E.ID_BANK ");
		sb.append(" WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
		// 支付方式：银行卡收费
		sb.append(" AND (B.EU_DIRECT = -1 or B.EU_DIRECT = 1)");
		sb.append(" AND B.SD_PM in ('02','08') ");
		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),B.SD_PM ,B.EU_DIRECT");
		sb.append(" ORDER BY DT ");
		
		sb.append(" ) tbl ");				
//		sb.append(" union ");
//		sb.append(" SELECT  ");		
//		
//		sb.append(" NULL as CHARGE_DEPT, ");
//		sb.append(" NULL as EXECUTE_DEPT, ");
//		sb.append(" NULL as UNDER_DEPT, ");
//
//		// 支付方式
//		sb.append(" DECODE(tbl.SD_PM,'02','c','08','d','09','j','15','019','03','2','04','3','51','7','11','f','12','v')  as CHARGE_TYPE, ");		
//		// 支付方式名称
//		sb.append(" DECODE(tbl.SD_PM,'02','MIS银行卡','08','POS银行卡','09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','11','支付宝','12','微信') as CHARGE_TYPE_NAME, ");
//		sb.append(" NULL as CHARGE_ITEM, ");
//		sb.append(" NULL as CHARGE_ITEM_NAME, ");
//		// 支付金额
//		sb.append(" tbl.AMT as AMOUNT, ");
//		sb.append(" NULL as SYNC_DATE, ");
//		// 支付日期
//		sb.append(" tbl.DT as OPERATING_DATE, ");
//		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
//		sb.append(" NULL as RECEIVABLE_COMP, ");;		
//		sb.append(" NULL as CHARGE_DEPT_NAME, ");
//		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
//		sb.append(" NULL as UNDER_DEPT_NAME, ");
//		sb.append(" NULL as BILL_NUM, ");
//		sb.append(" NULL as BILL_DATE, ");
//		sb.append(" 'N' as PROCESS_FLAG, ");		
//		sb.append(" 'N' as PREPAY_FLAG, ");
//		sb.append(" 'N' as RECEIVABLE_FLAG, ");
//		sb.append(" DECODE(tbl.SD_PM,'02','MIS银行卡-收','08','POS银行卡-收','09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','11','支付宝','12','微信') as DESCRIPTION ");
//		sb.append(" FROM  ");
//		sb.append(" ( ");
//		
//		sb.append(" SELECT SUM(B.AMT) AMT, ");
//		sb.append(" SUBSTR(D.DT_CC,0,10) DT,B.SD_PM SD_PM ");
//		sb.append("  FROM BL_PAY_PAT_OEP A ");
//		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
//		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
//		sb.append(" INNER JOIN BL_ST_OEP C ");
//		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
////		sb.append(" LEFT JOIN BD_PRI_PM PM ");
////		sb.append("    ON B.ID_PM = PM.ID_PM ");
//		sb.append(" INNER JOIN BL_CC D ");
//		sb.append("    ON A.ID_CC = D.ID_CC ");
////		sb.append(" LEFT JOIN BD_BANK E ");
////		sb.append("    ON B.ID_BANK = E.ID_BANK ");
//		sb.append(" WHERE");
//		// 当日结账
//		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
//				+ this.execDate + "','yyyy-MM-dd')");
//		// 结算类型：收费结算、收费取红冲算、收费取消结算
//		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
//		// 支付方式：银行卡收费
//		sb.append(" AND B.EU_DIRECT = 1 ");
//		sb.append(" AND B.SD_PM in ('02','08') ");
//		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),B.SD_PM ");
//		sb.append(" ORDER BY DT ");
//		
//		sb.append(" ) tbl ");		
//		sb.append(" union ");
//		sb.append(" SELECT  ");		
//	
//		sb.append(" NULL as CHARGE_DEPT, ");
//		sb.append(" NULL as EXECUTE_DEPT, ");
//		sb.append(" NULL as UNDER_DEPT, ");
//
//		// 支付方式
//		sb.append(" DECODE(tbl.SD_PM,'02','c','08','d','09','j','15','019','03','2','04','3','51','7','11','f','12','v')  as CHARGE_TYPE, ");		
//		// 支付方式名称
//		sb.append(" DECODE(tbl.SD_PM,'02','MIS银行卡','08','POS银行卡','09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','11','支付宝','12','微信') as CHARGE_TYPE_NAME, ");
//		sb.append(" NULL as CHARGE_ITEM, ");
//		sb.append(" NULL as CHARGE_ITEM_NAME, ");
//		// 支付金额
//		sb.append(" tbl.AMT as AMOUNT, ");
//		sb.append(" NULL as SYNC_DATE, ");
//		// 支付日期
//		sb.append(" tbl.DT as OPERATING_DATE, ");
//		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
//		sb.append(" NULL as RECEIVABLE_COMP, ");;		
//		sb.append(" NULL as CHARGE_DEPT_NAME, ");
//		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
//		sb.append(" NULL as UNDER_DEPT_NAME, ");
//		sb.append(" NULL as BILL_NUM, ");
//		sb.append(" NULL as BILL_DATE, ");
//		sb.append(" 'N' as PROCESS_FLAG, ");	
//		sb.append(" 'N' as PREPAY_FLAG, ");
//		sb.append(" 'N' as RECEIVABLE_FLAG, ");
//		sb.append(" DECODE(tbl.SD_PM,'02','MIS银行卡-退','08','POS银行卡-退','09','合同单位记账','15','其它','03','支票','04','汇票','51','内部转账','11','支付宝','12','微信') as DESCRIPTION ");
//		sb.append(" FROM  ");
//		sb.append(" ( ");
//		
//		sb.append(" SELECT SUM(B.AMT) AMT,");
//		sb.append(" SUBSTR(D.DT_CC,0,10) DT,B.SD_PM SD_PM ");
//		sb.append("  FROM BL_PAY_PAT_OEP A ");
//		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
//		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
//		sb.append(" INNER JOIN BL_ST_OEP C ");
//		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
////		sb.append(" LEFT JOIN BD_PRI_PM PM ");
////		sb.append("    ON B.ID_PM = PM.ID_PM ");
//		sb.append(" INNER JOIN BL_CC D ");
//		sb.append("    ON A.ID_CC = D.ID_CC ");
////		sb.append(" LEFT JOIN BD_BANK E ");
////		sb.append("    ON B.ID_BANK = E.ID_BANK ");
//		sb.append(" WHERE");
//		// 当日结账
//		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
//				+ this.execDate + "','yyyy-MM-dd')");
//		// 结算类型：收费结算、收费取红冲算、收费取消结算
//		sb.append(" AND  C.EU_STTP IN ('30', '40', '41') ");
//		// 支付方式：银行卡退费
//		sb.append(" AND B.EU_DIRECT = -1 ");
//		sb.append(" AND B.SD_PM in ('02','08') ");
//		sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),B.SD_PM ");
//		sb.append(" ORDER BY DT ");
//		sb.append(" ) tbl  ");
		sb.append(" union ");
		sb.append(" SELECT  ");		
		
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
		sb.append(" TBL.PAYCODE  as CHARGE_TYPE, ");		
		// 支付方式名称
		sb.append(" TBL.PAYNAME as CHARGE_TYPE_NAME, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NULL as RECEIVABLE_COMP_NAME, ");
		sb.append(" NULL as RECEIVABLE_COMP, ");;		
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");	
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");
		sb.append(" DECODE(tbl.PAYNAME,NULL,NULL,'其它收入-') || tbl.PAYNAME as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" ( ");
		sb.append(" SELECT SUM(B.AMT) AMT,");
		sb.append(" SUBSTR(D.DT_CC,0,10) DT,PM.CODE PAYCODE,PM.NAME PAYNAME ");
		sb.append("  FROM BL_PAY_PAT_OEP A ");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ");
		sb.append("    ON A.ID_PAYPATOEP = B.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_ST_OEP C ");
		sb.append("    ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append(" LEFT JOIN BD_PRI_PM PM ");
		sb.append("    ON B.ID_PM = PM.ID_PM ");
		sb.append(" INNER JOIN BL_CC D ");
		sb.append("    ON A.ID_CC = D.ID_CC ");
//		sb.append(" LEFT JOIN BD_BANK E ");
//		sb.append("    ON B.ID_BANK = E.ID_BANK ");
		sb.append(" WHERE");
		// 当日结账
	    sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
					+ this.execDate + "','yyyy-MM-dd')");
	    sb.append(" AND  C.EU_STTP IN ('30', '40', '41') "); // 结算类型：收费结算、收费取红冲算、收费取消结算
	    // 支付方式不属于：支票、汇票、内部转账，预付费卡、银行卡、支付宝，微信、合同单位、代金卡、减免（其中内部转账和代金卡系统内部还不支持，不需要考虑）
        sb.append("  AND B.SD_PM NOT IN ( '03', '04', '51', '05', '02', '08', '11', '12', '09', '15') "); 
        sb.append(" GROUP BY SUBSTR(D.DT_CC,0,10),PM.CODE,PM.NAME ");
		sb.append(" ORDER BY DT ");
		sb.append(" ) tbl  ");
		// by li 2017-05-20 将商保和医保合并
		sb.append(" union ");
		sb.append(" SELECT  ");		
		
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");

		// 支付方式
		sb.append("case when SD_HPTP LIKE '1%'then 'y'else's'end as CHARGE_TYPE,");		
		// 支付方式名称
		sb.append("  case when SD_HPTP LIKE '1%'then '医保中心'else '商保中心'end as CHARGE_TYPE_NAME,");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		// 支付金额
		sb.append(" tbl.AMT as AMOUNT, ");
		sb.append(" NULL as SYNC_DATE, ");
		// 支付日期
		sb.append(" tbl.DT as OPERATING_DATE, ");
		sb.append(" NAME_CUST as RECEIVABLE_COMP_NAME, ");
		sb.append(" CODE_CUST as RECEIVABLE_COMP, ");;		
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" NULL as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' as RECEIVABLE_FLAG, ");
		sb.append(" NAME_CUST as DESCRIPTION ");
		sb.append(" FROM  ");
		sb.append(" ( ");
		sb.append(" SELECT SUM(D.AMT_HP*D.EU_DIRECT) AMT, F.CODE CODE_CUST, F.NAME NAME_CUST, ");
		sb.append(" SUBSTR(B.DT_CC,0,10) DT,E.SD_HPTP ");
		sb.append("  FROM BL_ST_OEP A ");
		sb.append(" INNER JOIN BL_CC B ");
		sb.append("    ON A.ID_CC = B.ID_CC ");		
		sb.append(" INNER JOIN BL_PROP_OEP C ");	
		sb.append("    ON A.ID_STOEP = C.ID_STOEP ");		
		sb.append(" INNER JOIN BL_PROP_AR_OEP D ");
		sb.append("    ON C.ID_PROPOEP = D.ID_PROPOEP ");
		sb.append(" INNER JOIN BD_HP E ");
		sb.append("    ON D.ID_HP = E.ID_HP ");		
		sb.append(" LEFT JOIN BD_CUST F ");
		sb.append("    ON E.ID_CUST = E.ID_CUST ");
		sb.append(" WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(B.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		// 结算类型：收费结算、收费取红冲算、收费取消结算
		sb.append(" AND  A.EU_STTP IN ('30', '40', '41') ");
		// 支付方式：1 医保中心 2 商保
		sb.append(" AND (E.SD_HPTP LIKE '1%' or  E.SD_HPTP LIKE '2%') ");
		sb.append(" GROUP BY SUBSTR(B.DT_CC,0,10),E.ID_CUST,F.CODE,F.NAME,E.SD_HPTP ");
		sb.append(" ORDER BY DT ");
		sb.append(" ) tbl  ");		
//		sb.append(" union ");
//		sb.append(" SELECT  ");		
//		
//		sb.append(" NULL as CHARGE_DEPT, ");
//		sb.append(" NULL as EXECUTE_DEPT, ");
//		sb.append(" NULL as UNDER_DEPT, ");
//
//		// 支付方式
//		sb.append(" 'y' as CHARGE_TYPE, ");		
//		// 支付方式名称
//		sb.append(" '医保中心' as CHARGE_TYPE_NAME, ");
//		sb.append(" NULL as CHARGE_ITEM, ");
//		sb.append(" NULL as CHARGE_ITEM_NAME, ");
//		// 支付金额
//		sb.append(" tbl.AMT as AMOUNT, ");
//		sb.append(" NULL as SYNC_DATE, ");
//		// 支付日期
//		sb.append(" tbl.DT as OPERATING_DATE, ");
//		sb.append(" NAME_CUST as RECEIVABLE_COMP_NAME, ");
//		sb.append(" CODE_CUST as RECEIVABLE_COMP, ");;		
//		sb.append(" NULL as CHARGE_DEPT_NAME, ");
//		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
//		sb.append(" NULL as UNDER_DEPT_NAME, ");
//		sb.append(" NULL as BILL_NUM, ");
//		sb.append(" NULL as BILL_DATE, ");
//		sb.append(" 'N' as PROCESS_FLAG, ");
//		sb.append(" 'N' as PREPAY_FLAG, ");
//		sb.append(" 'N' as RECEIVABLE_FLAG, ");
//		sb.append(" NAME_CUST as DESCRIPTION ");
//		sb.append(" FROM  ");
//		sb.append(" ( ");
//		sb.append(" SELECT SUM(D.AMT_HP*D.EU_DIRECT) AMT, F.CODE CODE_CUST, F.NAME NAME_CUST, ");
//		sb.append(" SUBSTR(B.DT_CC,0,10) DT");
//		sb.append("  FROM BL_ST_OEP A ");
//		sb.append(" INNER JOIN BL_CC B ");
//		sb.append("    ON A.ID_CC = B.ID_CC ");		
//		sb.append(" INNER JOIN BL_PROP_OEP C ");	
//		sb.append("    ON A.ID_STOEP = C.ID_STOEP ");		
//		sb.append(" INNER JOIN BL_PROP_AR_OEP D ");
//		sb.append("    ON C.ID_PROPOEP = D.ID_PROPOEP ");
//		sb.append(" INNER JOIN BD_HP E ");
//		sb.append("    ON D.ID_HP = E.ID_HP ");		
//		sb.append(" LEFT JOIN BD_CUST F ");
//		sb.append("    ON E.ID_CUST = E.ID_CUST ");
//		sb.append(" WHERE");
//		// 当日结账
//		sb.append(" TRUNC(TO_DATE(B.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
//				+ this.execDate + "','yyyy-MM-dd')");
//		// 结算类型：收费结算、收费取红冲算、收费取消结算
//		sb.append(" AND  A.EU_STTP IN ('30', '40', '41') ");
//		// 支付方式：医保中心
//		sb.append(" AND E.SD_HPTP LIKE '1%' ");
//		sb.append(" GROUP BY SUBSTR(B.DT_CC,0,10),E.ID_CUST,F.CODE,F.NAME ");
//		sb.append(" ORDER BY DT ");
//		sb.append(" ) tbl  ");
//		sb.append(" union ");
//		sb.append(" SELECT  ");		
//		
//		sb.append(" NULL as CHARGE_DEPT, ");
//		sb.append(" NULL as EXECUTE_DEPT, ");
//		sb.append(" NULL as UNDER_DEPT, ");
//
//		// 支付方式
//		sb.append(" 's' as CHARGE_TYPE, ");		
//		// 支付方式名称
//		sb.append(" '商保中心' as CHARGE_TYPE_NAME, ");
//		sb.append(" NULL as CHARGE_ITEM, ");
//		sb.append(" NULL as CHARGE_ITEM_NAME, ");
//		// 支付金额
//		sb.append(" tbl.AMT as AMOUNT, ");
//		sb.append(" NULL as SYNC_DATE, ");
//		// 支付日期
//		sb.append(" tbl.DT as OPERATING_DATE, ");
//		sb.append(" NAME_CUST as RECEIVABLE_COMP_NAME, ");
//		sb.append(" CODE_CUST as RECEIVABLE_COMP, ");;		
//		sb.append(" NULL as CHARGE_DEPT_NAME, ");
//		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
//		sb.append(" NULL as UNDER_DEPT_NAME, ");
//		sb.append(" NULL as BILL_NUM, ");
//		sb.append(" NULL as BILL_DATE, ");
//		sb.append(" 'N' as PROCESS_FLAG, ");	
//		sb.append(" 'N' as PREPAY_FLAG, ");
//		sb.append(" 'N' as RECEIVABLE_FLAG, ");
//		sb.append(" NAME_CUST as DESCRIPTION ");
//		sb.append(" FROM  ");
//		sb.append(" ( ");
//		sb.append(" SELECT SUM(D.AMT_HP*D.EU_DIRECT) AMT, F.CODE CODE_CUST, F.NAME NAME_CUST, ");
//		sb.append(" SUBSTR(B.DT_CC,0,10) DT");
//		sb.append("  FROM BL_ST_OEP A ");
//		sb.append(" INNER JOIN BL_CC B ");
//		sb.append("    ON A.ID_CC = B.ID_CC ");		
//		sb.append(" INNER JOIN BL_PROP_OEP C ");	
//		sb.append("    ON A.ID_STOEP = C.ID_STOEP ");		
//		sb.append(" INNER JOIN BL_PROP_AR_OEP D ");
//		sb.append("    ON C.ID_PROPOEP = D.ID_PROPOEP ");
//		sb.append(" INNER JOIN BD_HP E ");
//		sb.append("    ON D.ID_HP = E.ID_HP ");		
//		sb.append(" LEFT JOIN BD_CUST F ");
//		sb.append("    ON E.ID_CUST = E.ID_CUST ");
//		sb.append(" WHERE");
//		// 当日结账
//		sb.append(" TRUNC(TO_DATE(B.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
//				+ this.execDate + "','yyyy-MM-dd')");
//		// 结算类型：收费结算、收费取红冲算、收费取消结算
//		sb.append(" AND  A.EU_STTP IN ('30', '40', '41') ");
//		// 支付方式：商保中心
//		sb.append(" AND E.SD_HPTP LIKE '2%' ");
//		sb.append(" GROUP BY SUBSTR(B.DT_CC,0,10),E.ID_CUST,F.CODE,F.NAME ");
//		sb.append(" ORDER BY DT ");
//		sb.append(" ) tbl  ");
		sb.append(" ) alltbl ");
		sb.append(" WHERE ");
		sb.append(" alltbl.AMOUNT <> 0 ");
		return sb.toString();
	}

	/**
	 * 获取门诊预交SQL
	 * 
	 * @return
	 */
	private String getSqlStringBy5() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT ROWNUM AS LINE_NUM,alltbl.*");
		sb.append(" FROM ");
		sb.append(" (SELECT ");
		sb.append(" '" + ifaceInteger + "' as IFACE_BATCH_ID,");
		sb.append(" 'J3' as BUSINESS_TYPE,");
		sb.append(" '100' as HOSPITAL_CODE,");
		sb.append(" 'OP' as OP_IP_FLAG,");
		sb.append(" NULL as CHARGE_DEPT,");
		sb.append(" NULL as UNDER_DEPT,");
		sb.append(" NULL as CHARGE_ITEM,");
		sb.append(" NULL as CHARGE_ITEM_NAME,");
		sb.append(" '1'  as CHARGE_TYPE,");
		sb.append(" '现金' as CHARGE_TYPE_NAME,");
		sb.append(" tbl.AMT as AMOUNT,");
		sb.append(" tbl.DT as OPERATING_DATE,");
		sb.append(" NULL as RECEIVABLE_COMP_NAME,");
		sb.append(" NULL as RECEIVABLE_COMP,");
		sb.append(" NULL as SYNC_DATE,");
		sb.append(" NULL as CHARGE_DEPT_NAME,");
		sb.append(" NULL as UNDER_DEPT_NAME,");
		sb.append(" 'N' as PROCESS_FLAG,");
		sb.append(" 'N' as PREPAY_FLAG,");
		sb.append("  'N' AS RECEIVABLE_FLAG,");
		sb.append(" '现金' as DESCRIPTION");
		sb.append(" FROM ");
		sb.append(" (");
		sb.append(" SELECT sum(prepay.AMT*prepay.EU_DIRECT) AMT,SUBSTR(cc.DT_CC,0,10) DT from  bl_cc cc   ");
		sb.append(" left join bl_prepay_pat prepay on cc.id_cc = prepay.id_cc ");
		sb.append(" WHERE ");
		sb.append(" TRUNC(TO_DATE(cc.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.execDate + "','yyyy-MM-dd')");
		sb.append(" AND prepay.SD_PM = '01'");
		sb.append(" group by SUBSTR(cc.DT_CC,0,10)");
		sb.append(" ) tbl) alltbl");
		return sb.toString();
	}
}
