package iih.bl.cc.ebs.st;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GatherJ3DispDataQry implements ITransQry{
	 private String selectDate = null;
	 private String type = null;
	 private String eu_sttp=null;
	 
	 public GatherJ3DispDataQry() {
		 
	 }
	 
	 public GatherJ3DispDataQry(String sDate,String beathType,String eu_sttp) {
		 this.selectDate = sDate;
		 this.type=beathType;
		 this.eu_sttp=eu_sttp;
	 }

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		return  new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT ROWNUM as LINE_NUM,alltbl.* FROM  ");
		sb.append(" ( ");
		sb.append(getSqlByPayType());
		if(this.type.equals("J4"))//单独查询医保 特殊病 部级医保
		{
			sb.append(" union ");
			sb.append(getHPQrySQLStr());
		}
		sb.append(" union ");
		sb.append(getSqlBydetail());//按照账单项目分组，开单科室、执行科室分组查询
		sb.append(" ) alltbl ");
		sb.append(" WHERE ");
		sb.append(" alltbl.AMOUNT <> 0 ");
		return sb.toString();
	}
	/**
	 * j4 查询医保 特殊病 部级医保
	 * @return
	 */
	private String getHPQrySQLStr(){
		StringBuffer sb = new StringBuffer();
		GatherJ4DispStrQry getDispStrQry = new GatherJ4DispStrQry(selectDate,eu_sttp);
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
		sb.append(" '"+type+"' as BUSINESS_TYPE, ");//业务类型
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		sb.append(" tbl.pri_pmconcode as CHARGE_TYPE, ");// 支付方式
		sb.append(" tbl.pri_pmconname as CHARGE_TYPE_NAME, ");// 支付方式名称
		sb.append(" tbl.AMT as AMOUNT, ");// 支付金额
		sb.append(" tbl.DT as OPERATING_DATE, ");// 支付日期
		sb.append(" tbl.Name_CUST as RECEIVABLE_COMP_NAME, ");
		sb.append(" tbl.CODE_CUST as RECEIVABLE_COMP, ");
		sb.append(" NULL as SYNC_DATE, ");
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" tbl.PAYMODENODE as BILL_NUM, ");//支付方信息
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" tbl.DESCRIPTION as DESCRIPTION ");//描述信息
		sb.append(" FROM  (");
		// 医保持卡 查询数据
		sb.append(getDispStrQry.getHpStrSql());
		sb.append(" union ");
		// 门诊特殊病 查询数据
		sb.append(getDispStrQry.getSpStrSql());
		sb.append(" union ");
		// 部级医保持卡查询数据
		sb.append(getDispStrQry.getMinistHpStrSql());	
		sb.append(" ) tbl ");	
		return sb.toString();
		
	}
	/**
	 * 按照账单项目分组，开单科室、执行科室分组查询
	 * @return
	 */
	private String getSqlBydetail(){
		StringBuilder sb = new StringBuilder();
		GatherJ4DispStrQry getDispStrQry = new GatherJ4DispStrQry(selectDate,eu_sttp);
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
		sb.append(" '"+type+"' as BUSINESS_TYPE, ");
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" tbl.id_dep_or as CHARGE_DEPT, ");
		sb.append(" tbl.id_dep_mp as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");
		sb.append(" tbl.code_inccaitm as CHARGE_ITEM, ");
		sb.append(" tbl.name_inccaitm as CHARGE_ITEM_NAME, ");	
		sb.append(" Null as CHARGE_TYPE, ");// 支付方式
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
		sb.append(" '' as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" 'N' as PREPAY_FLAG, ");
		sb.append(" 'N' AS RECEIVABLE_FLAG, ");
		sb.append(" tbl.DESCRIPTION as DESCRIPTION ");
		sb.append(" FROM  ");
		// 现金查询数据
		sb.append(" (select SUBSTR(D.DT_CC,0,10) DT,code_inccaitm,name_inccaitm,depor.code as id_dep_or,depor.name as name_dep_or,");
		if(this.type.equals("J4"))
		{
			sb.append(" depmp.code as id_dep_mp,depmp.name  as name_dep_mp,");
		}else{
			sb.append(" '' as id_dep_mp,''  as name_dep_mp,");
		}		
		sb.append(" sum(a.eu_direct*b.amt_ratio)*-1 as AMT, ");
		sb.append(" name_inccaitm as DESCRIPTION ");
		sb.append("   FROM BL_CG_OEP a");
		sb.append("   left join BL_CG_ITM_OEP b on a.ID_CGOEP=b.ID_CGOEP ");
		sb.append("   INNER JOIN BL_ST_OEP C on b.id_stoep=c.id_stoep");
		sb.append("    INNER JOIN BL_CC D on c.id_cc=d.id_cc ");
		sb.append("     left join bd_dep depor on b.id_dep_or=depor.id_dep");
		sb.append("  left join bd_dep depmp on b.id_dep_mp=depmp.id_dep ");
		sb.append("  WHERE");
		// 当日结账
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ selectDate + "','yyyy-MM-dd')");
//		// 结算类型：挂号结算、挂号取消结算
		sb.append("   and  c.EU_STTP IN ("+eu_sttp+") ");
		sb.append("    group by SUBSTR(D.DT_CC, 0, 10),code_inccaitm,name_inccaitm,depor.code,depmp.code,depor.name,depmp.name ");
		//费用减免
		sb.append(" union ");
		sb.append(getDispStrQry.getFeeDeStrSql());	
		sb.append(" )tbl ");
		return sb.toString();
	}
	/**
	 * 根据支付方式查询数据
	 * @return
	 */
	private String getSqlByPayType() {
		StringBuilder sb = new StringBuilder();
		// 现金、支付宝、微信、合同单位、银行卡、预付款
		sb.append(" SELECT  ");
		sb.append(" '1' as IFACE_BATCH_ID, ");
		sb.append(" '"+type+"' as BUSINESS_TYPE, ");
		sb.append(" '100' as HOSPITAL_CODE, ");
		sb.append(" 'OP' as OP_IP_FLAG, ");
		sb.append(" NULL as CHARGE_DEPT, ");
		sb.append(" NULL as EXECUTE_DEPT, ");
		sb.append(" NULL as UNDER_DEPT, ");
		sb.append(" NULL as CHARGE_ITEM, ");
		sb.append(" NULL as CHARGE_ITEM_NAME, ");
		sb.append(" tbl.pri_pmconcode as CHARGE_TYPE, ");// 支付方式
		sb.append(" tbl.pri_pmconname as CHARGE_TYPE_NAME, ");// 支付方式名称
		sb.append(" tbl.AMT as AMOUNT, ");// 支付金额
		sb.append(" tbl.DT as OPERATING_DATE, ");// 支付日期
		sb.append(" tbl.Name_CUST as RECEIVABLE_COMP_NAME, ");
		sb.append(" tbl.CODE_CUST as RECEIVABLE_COMP, ");
		sb.append(" NULL as SYNC_DATE, ");
		sb.append(" NULL as CHARGE_DEPT_NAME, ");
		sb.append(" NULL as EXECUTE_DEPT_NAME, ");
		sb.append(" NULL as UNDER_DEPT_NAME, ");
		sb.append(" tbl.PAYMODENODE as BILL_NUM, ");
		sb.append(" NULL as BILL_DATE, ");
		sb.append(" 'N' as PROCESS_FLAG, ");
		sb.append(" '' as PREPAY_FLAG, ");
		sb.append(" '' AS RECEIVABLE_FLAG, ");
		sb.append(" tbl.pri_pmconname as DESCRIPTION ");
		sb.append(" FROM  ");
		// 查询数据
		sb.append(" (select SUBSTR(D.DT_CC,0,10) DT,");
		sb.append(" con.pri_pmconcode,");
		sb.append("con.pri_pmconname,");
		sb.append("E.CODE as CODE_CUST, E.NAME as Name_CUST ,");
		sb.append("sum(b.amt*b.eu_direct) as AMT,");
		//如果支付方式是支票,汇票、合同单位、代金券（优惠券），则按照收款方信息进行分组
		sb.append("case when b.sd_pm not in('03','04','06','09') then '' else b.PAYMODENODE end  as PAYMODENODE ");
		sb.append(" FROM BL_PAY_PAT_OEP A");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
		sb.append(" INNER JOIN bd_pri_contrast con on b.sd_pm= con.pri_pmcode  ");
		sb.append(" INNER JOIN BL_ST_OEP C ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append(" INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC  ");
		sb.append(" LEFT JOIN BD_CUST E ON B.id_cust = E.ID_CUST ");
		sb.append(" LEFT JOIN BD_BANK F ON B.ID_BANK = F.ID_BANK ");
		sb.append(" WHERE");
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ selectDate + "','yyyy-MM-dd')");// 当日结账
		sb.append("    AND C.EU_STTP IN ("+eu_sttp+") ");// 结算类型
		//不查询收费方式为金额减免和项目减免的数据，将此数据放在收支项目查询中
		sb.append(" AND b.sd_pm not in('15','16') ");
		//J4 此处不查医保类
		if(this.type.equals("J4"))
		{
			sb.append(" and b.sd_pm <>'14' ");
		}	
		sb.append("    group by SUBSTR(D.DT_CC,0,10),con.pri_pmconcode,con.pri_pmconname,B.SD_PM,E.CODE, E.NAME,case when b.sd_pm not in('03','04','06','09') then '' else b.PAYMODENODE end");
		sb.append(" ) tbl ");	
		return sb.toString();
	}
}
