package iih.bl.cc.ebs.st;

public class GatherJ4DispStrQry {
	String selectDate;
	String eu_sttp;
	String des_Sp_Type="特殊病";
	String des_Minist_Type="副部级医保";
	 public GatherJ4DispStrQry(String selectDate,String eu_sttp) {
		 this.selectDate = selectDate;
		 this.eu_sttp=eu_sttp;
	 }
	/**
	 * 获取J4医保查询数据
	 * @param selectDate
	 * @param eu_sttp
	 * @return
	 */
	public String getHpStrSql(){
		StringBuilder sb = new StringBuilder();
		// 医保持卡 查询数据
		sb.append(getQrySelectStr(""));
		sb.append("  WHERE");
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ selectDate + "','yyyy-MM-dd')");// 当日结账
		sb.append("    AND C.EU_STTP IN ("+eu_sttp+") ");// 结算类型
		sb.append(" and b.sd_pm ='14' ");//医保类型
		//医保持卡 就诊医保计划表中医保基金支付标志=Y，并且医保身份不是副部级持卡， 并且对应处方的医保特殊病标志=N
		//sb.append(" and  hp.fg_fundpay='Y' and hp.code_hppatca not in('29','37','38','44','46') and hp.fg_hpspcl='N'");
		sb.append(" and c.id_stoep not in (select a.id_stoep from BL_CG_ITM_OEP a where id_orsrv in (select id_orsrv from ci_or_srv where  fg_specill='Y')) and hp.code_hppatca not in('29','37','38','39','44','46') ");
		sb.append(getQryGroupStr());//拼接group
		return sb.toString();
	}
	/**
	 * 查询j4特殊病数据
	 * @return
	 */
	public String getSpStrSql(){
		StringBuilder sb = new StringBuilder();
		sb.append(getQrySelectStr(des_Sp_Type));
		sb.append("  WHERE");
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ selectDate + "','yyyy-MM-dd')");// 当日结账
		sb.append("    AND C.EU_STTP IN ("+eu_sttp+") ");// 结算类型
		//处方表中特殊病标志=Y的处方对应的费用
		//sb.append("  and hp.fg_hpspcl='Y'");
		sb.append(" and b.sd_pm ='14' ");// 结算类型
		sb.append("  and c.id_stoep in (select a.id_stoep from BL_CG_ITM_OEP a where id_orsrv in (select id_orsrv from ci_or_srv where  fg_specill='Y')) and hp.code_hppatca not in('29','37','38','39','44','46') ");
		sb.append(getQryGroupStr());//拼接group		
		return sb.toString();
	}
	/**
	 * 返回部级医保持卡查询数据
	 * @return
	 */
	public String getMinistHpStrSql(){
		StringBuilder sb= new StringBuilder();
		sb.append(getQrySelectStr(des_Minist_Type));
		sb.append("  WHERE");
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ selectDate + "','yyyy-MM-dd')");// 当日结账
		sb.append(" and b.sd_pm ='14' ");		
		sb.append(" AND C.EU_STTP IN ("+eu_sttp+") ");// 结算类型
		sb.append("  and hp.code_hppatca in('29','37','38','39','44','46')");//部级医保卡
		sb.append(getQryGroupStr());//拼接group
		return sb.toString();
	}
	/**
	 * 查询费用减免和项目减免的数据
	 * @return
	 */
	public String getFeeDeStrSql(){
		StringBuilder sb= new StringBuilder();
		sb.append("select SUBSTR(D.DT_CC, 0, 10) DT,");
		sb.append("'019' as code_inccaitm,");
		sb.append("'其他' as name_inccaitm,");
		sb.append("max((select  bd_dep.code from BL_CG_ITM_OEP left join bd_dep on  BL_CG_ITM_OEP.id_dep_or=bd_dep.id_dep where BL_CG_ITM_OEP.Id_Stoep= C.id_stoep and  rownum<2)) as id_dep_or,");
		sb.append("max((select  bd_dep.name from BL_CG_ITM_OEP left join bd_dep on  BL_CG_ITM_OEP.id_dep_or=bd_dep.id_dep where BL_CG_ITM_OEP.Id_Stoep= C.id_stoep and  rownum<2)) as name_dep_or,");
		sb.append("'' as id_dep_mp,");
		sb.append("'' as name_dep_mp,");
		sb.append("sum(b.amt * b.eu_direct) as AMT,");
		sb.append("'减免' as DESCRIPTION ");
		sb.append(" FROM BL_PAY_PAT_OEP A");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B");
		sb.append(" ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
		sb.append(" INNER JOIN bd_pri_contrast con");
		sb.append(" on b.sd_pm = con.pri_pmcode");
		sb.append(" INNER JOIN BL_ST_OEP C");
		sb.append(" ON A.ID_PAYPATOEP = C.ID_PAYPATOEP");
		sb.append(" INNER JOIN BL_CC D");
		sb.append(" ON A.ID_CC = D.ID_CC");
		sb.append(" WHERE ");
		sb.append(" TRUNC(TO_DATE(D.DT_CC,'yyyy-MM-dd hh24:mi:ss')) = TO_DATE('"
				+ selectDate + "','yyyy-MM-dd')");// 当日结账
		sb.append(" AND C.EU_STTP IN ("+eu_sttp+")");
		sb.append(" AND b.sd_pm in ('15', '16')");
		//sb.append(" and A.Id_Pat='1001Z71000000001LCU7' ");  
		sb.append(" group by SUBSTR(D.DT_CC, 0, 10)");
		return sb.toString();
	}
	/**
	 * 返回查询的select语句部分
	 * @param des 描述字段
	 * @return
	 */
	private String getQrySelectStr(String des){
		StringBuilder sb= new StringBuilder();
		sb.append(" select SUBSTR(D.DT_CC,0,10) DT,");
		sb.append("con.pri_pmconcode,");
		sb.append("con.pri_pmconname,");
		sb.append("E.CODE as CODE_CUST, ");
		sb.append("E.NAME as Name_CUST ,");
		sb.append("sum(b.amt*b.eu_direct) as AMT,");
		sb.append("'"+ des +"' as DESCRIPTION, ");
		//如果支付方式是支票,汇票、合同单位、代金券（优惠券），则按照收款方信息进行分组
		sb.append("case when B.sd_pm not in('03','04','06','09') then '' else B.PAYMODENODE end  as PAYMODENODE ");
		sb.append(" FROM BL_PAY_PAT_OEP A");
		sb.append(" INNER JOIN BL_PAY_ITM_PAT_OEP B ON A.ID_PAYPATOEP = B.ID_PAYPATOEP");
		sb.append(" INNER JOIN bd_pri_contrast con on b.sd_pm= con.pri_pmcode  ");
		sb.append(" INNER JOIN BL_ST_OEP C ON A.ID_PAYPATOEP = C.ID_PAYPATOEP ");
		sb.append(" INNER JOIN en_ent_hp hp on c.id_ent=hp.id_ent ");
		sb.append(" INNER JOIN BL_CC D ON A.ID_CC = D.ID_CC  ");
		sb.append(" LEFT JOIN BD_CUST E ON B.id_cust = E.ID_CUST ");
		sb.append(" LEFT JOIN BD_BANK F ON B.ID_BANK = F.ID_BANK ");
		return sb.toString();
	}
	private String getQryGroupStr(){
		StringBuilder sb= new StringBuilder();
		sb.append("    group by SUBSTR(D.DT_CC,0,10),con.pri_pmconcode,con.pri_pmconname,B.SD_PM,E.CODE, E.NAME,case when b.sd_pm not in ('03', '04', '06', '09') then ''else b.PAYMODENODE end");	
		return sb.toString();
	}
}
