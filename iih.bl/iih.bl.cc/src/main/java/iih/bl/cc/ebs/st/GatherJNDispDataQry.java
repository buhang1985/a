package iih.bl.cc.ebs.st;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GatherJNDispDataQry implements ITransQry{
	 private String selectDate = null;
	 
	 public GatherJNDispDataQry()  {
		 
	 }
	 
	 public GatherJNDispDataQry(String sDate) {
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
		// 现金、支付宝、微信、合同单位、银行卡、预付款
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" 'Y' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" '门诊预付费记账' as DESCRIPTION ");
		sb.append(" FROM  ");	
		// 1 查询数据 预付费卡所有记账金额(包含未结算退记账）
		sb.append(" (select SUBSTR(b.dt_cg, 0, 10) DT,sum(A.AMT_acc*b.eu_direct)  as AMT");
		sb.append("  FROM BL_CG_ITM_OEP A  inner join BL_CG_OEP b on a.id_cgoep=b.id_cgoep ");
		sb.append("  where TRUNC(TO_DATE(b.dt_cg, 'yyyy-MM-dd hh24:mi:ss')) =");
		sb.append("  TO_DATE('"+ this.selectDate + "', 'yyyy-MM-dd') and fg_acc='Y' and b.eu_direct='1' ");
		sb.append("  group by SUBSTR(b.dt_cg, 0, 10) ");
		sb.append(" ) tbl ");
		sb.append(" union (");	
		// 2 预付费卡结算后退费金额 
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" 'Y' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" '门诊预付费记账' as DESCRIPTION ");
		sb.append(" FROM  ");	
		// 查询数据
		sb.append(" (select SUBSTR(a.dt_cg, 0, 10) DT,sum(a.eu_direct * b.amt_acc) as AMT");
		sb.append("  FROM BL_CG_OEP a");
		sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
		//sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
		//sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
		sb.append(" where ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(a.dt_cg,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.selectDate + "','yyyy-MM-dd')");	
		sb.append(" and fg_acc='Y' and  a.eu_direct='-1' ");
		sb.append(" group by  SUBSTR(a.dt_cg, 0, 10)");
		sb.append(" ) tbl) ");
		sb.append(" union (");	
		// 3 预付费卡直接结算金额（没有先记账）
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" 'Y' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" '门诊预付费记账' as DESCRIPTION ");
		sb.append(" FROM  ");	
		// 查询数据预付费卡直接结算金额（没有先记账）
		sb.append(" (select SUBSTR(a.dt_cg, 0, 10) DT, sum(a.eu_direct * b.amt_ratio) as AMT ");
		sb.append("  FROM BL_CG_OEP a");
		sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
		sb.append(" where ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(a.dt_cg,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.selectDate + "','yyyy-MM-dd')");	
		sb.append("  and b.fg_acc='N'");	 
		sb.append(" and b.id_stoep in( select id_stoep from bl_st_oep a inner join bl_cc b on a.id_cc=b.id_cc");	
		sb.append("  inner join BL_PAY_ITM_PAT_OEP c on a.id_paypatoep = c.id_paypatoep where c.sd_pm='05'");	
		sb.append("  and TRUNC(TO_DATE(DT_St, 'yyyy-MM-dd hh24:mi:ss')) =TO_DATE('2017-07-13', 'yyyy-MM-dd'))");	
		//sb.append("and fg_pricinginsertcg='N'");
		sb.append(" group by  SUBSTR(a.dt_cg, 0, 10)");
		sb.append(" ) tbl) ");	
		sb.append(" union (");	
		// 4 按照收费类别统计
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
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
		sb.append(" (select SUBSTR(a.dt_cg, 0, 10) DT,code_inccaitm,name_inccaitm,depor.code as id_dep_or,depor.name as name_dep_or,depmp.code as id_dep_mp,depmp.name as name_dep_mp,sum(a.eu_direct * b.amt_ratio)*-1 as AMT");
		sb.append("  FROM BL_CG_OEP a");
		sb.append(" left join BL_CG_ITM_OEP b on a.ID_CGOEP = b.ID_CGOEP");
		//sb.append(" INNER JOIN BL_ST_OEP C on b.id_stoep = c.id_stoep");
		//sb.append(" INNER JOIN BL_CC D on c.id_cc = d.id_cc");
		sb.append(" left join bd_dep depor on b.id_dep_or = depor.id_dep");
		sb.append(" left join bd_dep depmp on b.id_dep_mp = depmp.id_dep");
		sb.append(" where ");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(a.dt_cg,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ this.selectDate + "','yyyy-MM-dd')");	
		sb.append(" and (b.fg_acc='Y' or id_stoep in( select id_stoep from bl_st_oep a inner join bl_cc b on a.id_cc=b.id_cc");
		sb.append(" inner join BL_PAY_ITM_PAT_OEP c on a.id_paypatoep = c.id_paypatoep where c.sd_pm='05'");
		sb.append(" and TRUNC(TO_DATE(DT_St, 'yyyy-MM-dd hh24:mi:ss')) =TO_DATE('"
				+ this.selectDate + "', 'yyyy-MM-dd') ))  ");
		sb.append(" group by  SUBSTR(a.dt_cg, 0, 10),code_inccaitm,name_inccaitm,depor.code, depmp.code,depor.name,depmp.name ");
		sb.append(" ) tbl ");	
		sb.append(" )) alltbl ");
		sb.append(" WHERE ");
		sb.append(" alltbl.AMOUNT <> 0 ");
			
		return sb.toString();
		
	}
}
