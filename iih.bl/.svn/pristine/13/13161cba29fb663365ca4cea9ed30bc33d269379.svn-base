package iih.bl.cc.ebs.st;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GatherJODispDataQry implements ITransQry {
	 private String selectDate = null;
	 
	 public GatherJODispDataQry()  {
		 
	 }
	 
	 public GatherJODispDataQry(String sDate) {
		 this.selectDate = sDate;
	 }

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		return  new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
		sb.append(" (");
		//取预交金结算金额，方向为正的
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,con.PRI_PMCONCODE,con.PRI_PMCONNAME,sum(A.Eu_Direct*B.AMT) as AMT");
		sb.append("   FROM BL_PAY_PAT_OEP A");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
		sb.append(" INNER JOIN BL_ST_OEP C ON A.ID_PAYPATOEP = C.ID_PAYPATOEP");
		sb.append(" INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC");
		sb.append(" inner join bd_pri_contrast con on B.sd_pm = con.pri_pmcode");
		sb.append(" where ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.selectDate + "','yyyy-MM-dd')");	
		sb.append(" and  C.EU_STTP IN ('30','31', '40', '41','43') AND B.SD_PM = '05' ");
		sb.append(" group by SUBSTR(D.DT_CC, 0, 10) ,con.PRI_PMCONCODE,con.PRI_PMCONNAME");
		sb.append(" ) tbl ");
		sb.append(" union (");	
		//取预交金结算金额，方向为正的，然后取反， 
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" (select SUBSTR(D.DT_CC, 0, 10) DT,con.PRI_PMCONCODE,con.PRI_PMCONNAME,sum(A.Eu_Direct*B.AMT)*-1 as AMT");
		sb.append("   FROM BL_PAY_PAT_OEP A");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
		sb.append(" INNER JOIN BL_ST_OEP C ON A.ID_PAYPATOEP = C.ID_PAYPATOEP");
		sb.append(" INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC");
		sb.append(" inner join bd_pri_contrast con on B.sd_pm = con.pri_pmcode");
		sb.append(" where ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.selectDate + "','yyyy-MM-dd')");	
		sb.append(" and  C.EU_STTP IN ('30','31', '40', '41','43') AND B.SD_PM = '05' ");
		sb.append(" group by SUBSTR(D.DT_CC, 0, 10) ,con.PRI_PMCONCODE,con.PRI_PMCONNAME");
		sb.append(" ) tbl ");	
		sb.append(" )) alltbl ");
		sb.append(" WHERE ");
		sb.append(" alltbl.AMOUNT <> 0 ");	
		return sb.toString();
	}
}
