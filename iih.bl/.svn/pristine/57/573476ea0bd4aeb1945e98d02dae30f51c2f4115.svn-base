package iih.bl.cc.ebs.st;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GatherJYDispDataQry implements ITransQry{
	 private String selectDate = null;
	 
	 public GatherJYDispDataQry()  {
		 
	 }
	 
	 public GatherJYDispDataQry(String sDate) {
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
		//取预交金押金
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" tbl.Paymodenode as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" tbl.PRI_PMCONNAME as DESCRIPTION ");
		sb.append(" FROM  ");	
		//按照支付方式查询收退门诊预交金
		sb.append(" (select SUBSTR(A.dt_pay, 0, 10) DT,con.PRI_PMCONCODE,con.PRI_PMCONNAME,eu_direct,A.Paymodenode,sum(eu_direct * A.AMT) AMT");
		sb.append(" from BL_PREPAY_PAT A");
		sb.append(" inner join bd_pri_contrast con on A.sd_pm = con.pri_pmcode");
		sb.append(" inner join   bl_cc D on A.Id_Cc=D.Id_Cc");
		sb.append(" where TRUNC(TO_DATE(D.DT_CC, 'yyyy-MM-dd hh24:mi:ss')) =");
		sb.append(" TO_DATE('"+ this.selectDate + "', 'yyyy-MM-dd')");
		//门诊收退预交金 
		sb.append(" and A.Sd_Paytp='11'");
		sb.append(" group by SUBSTR(A.dt_pay, 0, 10), con.PRI_PMCONCODE,con.PRI_PMCONNAME,A.Paymodenode,eu_direct");
		sb.append(" union all ");
		//按照收退预交金汇总成两条数据
		sb.append("   select SUBSTR(A.dt_pay, 0, 10) DT,'9' as PRI_PMCONCODE,decode(eu_direct,1,'收门诊预付费','退门诊预付费') PRI_PMCONNAME,eu_direct,'' as Paymodenode,sum(eu_direct * A.AMT)*-1 AMT ");
		sb.append(" from BL_PREPAY_PAT A inner join bd_pri_contrast con on A.sd_pm = con.pri_pmcode ");
		sb.append(" inner join   bl_cc D on A.Id_Cc=D.Id_Cc ");
		sb.append(" where ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.selectDate + "','yyyy-MM-dd')");	
		//门诊收退预交金 
		sb.append(" and A.Sd_Paytp='11'");
		sb.append(" group by SUBSTR(A.dt_pay, 0, 10),eu_direct");
		sb.append(" ) tbl ");	
		sb.append(" ) alltbl ");
		sb.append(" WHERE ");
		sb.append(" alltbl.AMOUNT <> 0 ");	
		return sb.toString();
	}
}
