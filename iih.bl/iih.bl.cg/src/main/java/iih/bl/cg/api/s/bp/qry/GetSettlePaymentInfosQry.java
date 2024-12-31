package iih.bl.cg.api.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSettlePaymentInfosQry implements ITransQry {

	String pat_code;
	String begindate;
	String enddate;
	
	public GetSettlePaymentInfosQry(String pat_code, String sDate, String eDate) {
		this.pat_code = pat_code;
		this.begindate = sDate;
		this.enddate = eDate;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (this.pat_code != null && this.pat_code != "") {
			param.addParam(this.pat_code);
		}
		if (this.begindate != null && this.begindate != "") {
			param.addParam(this.begindate);
		}
		if (this.enddate != null && this.enddate != "") {
			param.addParam(this.enddate );
		}
//		if (this.pat_code != null && this.pat_code != "") {
//			param.addParam(this.pat_code);
//		}
//		if (this.begindate != null && this.begindate != "") {
//			param.addParam(this.begindate);
//		}
//		if (this.enddate != null && this.enddate != "") {
//			param.addParam(this.enddate );
//		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("  SELECT *");
		sb.append("  FROM (");
		sb.append(getPaySql());
//		sb.append(" union all ");
//		sb.append(getHpSql());
		sb.append(") a");
		sb.append("  ORDER BY");
		sb.append("  opTimes DESC,");
		sb.append("  createDateTime DESC");
		

		return sb.toString();
	}
	private String getPaySql(){
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("  SELECT");
		sb.append("  cg.code_apply applyCode,");
		sb.append("  NVL (cg.code_applytp, '04') applyTpCOde,");
		sb.append("  cg.name_srv srvName,");
		sb.append("  cg.spec SPECIFICATION,");
		sb.append("  cg.price_ratio price,");
		sb.append("  CASE SUBSTR (cg.sd_srvtp, 0, 4) WHEN '0103' THEN ROUND (cg.quan / cior.orders, 4) ELSE cg.quan END quan,");
		sb.append("  CASE SUBSTR (cg.sd_srvtp, 0, 4) WHEN '0103' THEN cior.orders ELSE 1 END quanOrders,");
		sb.append("  NVL (ci.sd_hpsrvtp, '3') srvChargeGrade,");
		sb.append("  pay.sd_pttp terminalType,");
		sb.append("  (SELECT wm_concat(NVL(paymodenode, '')) FROM bl_pay_itm_pat_oep where id_paypatoep= st.id_paypatoep) payOrder,");
		sb.append("  TO_DATE (cg.dt_or,'yyyy-MM-dd hh24:mi:ss') createDateTime,");
		sb.append("  CASE ci.sd_su_mp WHEN '20' THEN '20' ELSE '0' END mpStatus,");
		sb.append("  pi.barcode_chis barCodeChis,");
		sb.append("  en_op.times_op opTimes,");
		sb.append("  dep. NAME orDepName ,");
		sb.append("  mpdep.name as mpDepName , ");
		sb.append("  mpdep.code as mpDepCode ,");
		sb.append("  emp.name as orEmpName");
		sb.append("  FROM ");
		sb.append("  bl_cg_itm_oep cg");
		sb.append("  INNER JOIN bl_st_oep st ON cg.id_stoep = st.id_stoep");
		sb.append("  INNER JOIN ci_order cior ON cg.id_or = cior.id_or");
		sb.append("  INNER JOIN ci_or_srv ci ON cg.id_orsrv = ci.id_orsrv");
		sb.append("  INNER JOIN pi_pat pi ON cg.id_pat = pi.id_pat");
		sb.append("  INNER JOIN bd_dep dep ON cg.id_dep_or = dep.id_dep");
		sb.append("  INNER JOIN bd_dep mpdep on cg.id_dep_mp = mpdep.id_dep ");
		sb.append("  INNER JOIN bd_psndoc emp on cg.id_emp_or = emp.id_psndoc ");
		sb.append("  INNER JOIN en_ent_op en_op ON en_op.id_ent = cg.id_ent");
		sb.append("  INNER JOIN bl_pay_pat_oep pay ON st.id_paypatoep = pay.id_paypatoep");
		sb.append("  WHERE");
		sb.append("  cg.fg_st = 'Y'");
		sb.append("  AND nvl(st.id_paypatoep,'~')<>'~'");
		//不查询已退费信息
		sb.append(" and fg_refund='N' ");
		//sb.append(" and nvl(cg.id_par,'~')='~' ");
		sb.append("  AND pi.code = ?");
		sb.append("  AND cg.dt_st >=?");
		sb.append("  AND cg.dt_st <=?");
		sb.append("  AND st.eu_direct = '1'");
		sb.append("  AND st.fg_canc = 'N'");
		sb.append("  AND cg.FG_REFUND = 'N'");
		//sb.append("  and cg.fg_acc='N' and cg.fg_hpcg='N'");
//		sb.append("  GROUP BY");
//		sb.append("  cg.code_apply ,");
//		sb.append("  cg.code_applytp,");
//		sb.append("  cg.name_srv,");
//		sb.append("  cg.spec,");
//		sb.append("  cg.price_ratio,");
//		sb.append("  cior.orders,");
//		sb.append("  cg.quan,");
//		sb.append("  cg.sd_srvtp,");
//		sb.append("  cior.orders,");
//		sb.append("  ci.sd_hpsrvtp,");
//		sb.append("  pay.sd_pttp,");
//		sb.append("  payitm.paymodenode,");
//		sb.append("  cg.dt_or,");
//		sb.append("  ci.sd_su_mp,");
//		sb.append("  pi.barcode_chis,");
//		sb.append("  en_op.times_op,");
//		sb.append("  dep.NAME,");
//		sb.append("  cg.ID_ORSRV");
		
		
//		sb.append("  ORDER BY");
//		sb.append("  en_op.times_op DESC,");
//		sb.append("  cg.dt_or DESC");
		
//		sb.append(" select cg.code_apply applyCode, ");
//		sb.append(" nvl(cg.code_applytp,'04') applyTpCOde, ");
//		sb.append(" cg.name_srv srvName ,  ");
//		sb.append(" cg.spec specification, ");
//		sb.append(" cg.price_ratio price,  ");
//		sb.append(" case  substr(cg.sd_srvtp,0,4) when '0103' then round(cg.quan/cior.orders,4) else cg.quan end quan, ");
//		sb.append(" case  substr(cg.sd_srvtp,0,4) when '0103' then cior.orders else 1 end quanOrders, ");
//		sb.append(" nvl(ci.sd_hpsrvtp,'3')  srvChargeGrade, ");
//		sb.append(" pay.sd_pttp terminalType, ");
//		sb.append(" payitm.paymodenode payOrder, ");
//		sb.append("  to_date(cg.dt_or,'yyyy-MM-dd hh24:mi:ss') createDateTime , ");
//		sb.append(" case ci.sd_su_mp when '20' then '20' else '0' end mpStatus, ");
//		sb.append(" pi.barcode_chis barCodeChis,    ");
//		sb.append(" en_op.times_op opTimes, ");
//		sb.append(" dep.name orDepName ");
//		sb.append(" from bl_cg_itm_oep cg, ci_order cior,ci_or_srv ci,pi_pat pi, bd_pri_pm pm,bd_dep dep,en_ent_op en_op, bl_st_oep st,bl_pay_pat_oep pay,bl_pay_itm_pat_oep payitm ");
//		sb.append(" where payitm.id_pm = pm.id_pm and cg.id_orsrv = ci.id_orsrv and cg.id_or = cior.id_or and cg.id_pat=pi.id_pat and cg.id_dep_or = dep.id_dep and en_op.id_ent = cg.id_ent and cg.fg_st='Y'  and st.id_paypatoep is not null  ");
//		sb.append(" and cg.id_stoep = st.id_stoep and st.id_paypatoep = pay.id_paypatoep and st.id_paypatoep = payitm.id_paypatoep ");
//		sb.append(" and pi.code = ? and cg.dt_st >= ? and cg.dt_st <= ?  and st.eu_direct = '1' and st.fg_canc = 'N' ");
//		sb.append(" order by en_op.times_op desc,cg.dt_or desc ");
		
		/*SqlParam sqlParam =  new SqlParam();
		sqlParam.addParam(this.pat_code);
		sqlParam.addParam(this.begindate);
		sqlParam.addParam(this.enddate);*/

		return sb.toString();		
	}
	/**
	 * 获取商保和预交金的记录
	 * @return
	 */
	private String getHpSql(){
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("cg.code_apply applyCode,");
		sb.append("NVL (cg.code_applytp, '04') applyTpCOde,");
		sb.append("cg.name_srv srvName,");
		sb.append("cg.spec SPECIFICATION,");
		sb.append("cg.price_ratio price,");
		sb.append("CASE SUBSTR (cg.sd_srvtp, 0, 4) WHEN '0103' THEN ROUND (cg.quan / cior.orders, 4) ELSE cg.quan END quan,");
		sb.append("CASE SUBSTR (cg.sd_srvtp, 0, 4) WHEN '0103' THEN cior.orders ELSE 1 END quanOrders,");
		sb.append("NVL (ci.sd_hpsrvtp, '3') srvChargeGrade,");
		sb.append("'01'as terminalType,");
		sb.append("null as payOrder,");
		sb.append("TO_DATE (cg.dt_or,'yyyy-MM-dd hh24:mi:ss') createDateTime,");
		sb.append("CASE ci.sd_su_mp WHEN '20' THEN '20' ELSE '0' END mpStatus,");
		sb.append("pi.barcode_chis barCodeChis,");
		sb.append("en_op.times_op opTimes,");
		sb.append("dep. NAME orDepName");
		sb.append(" FROM");
		sb.append(" bl_cg_itm_oep cg");
		sb.append(" INNER JOIN bl_st_oep st ON cg.id_stoep = st.id_stoep");
		sb.append(" INNER JOIN ci_order cior ON cg.id_or = cior.id_or");
		sb.append(" INNER JOIN ci_or_srv ci ON cg.id_orsrv = ci.id_orsrv");
		sb.append(" INNER JOIN pi_pat pi ON cg.id_pat = pi.id_pat");
		sb.append(" INNER JOIN bd_dep dep ON cg.id_dep_or = dep.id_dep");
		sb.append(" INNER JOIN en_ent_op en_op ON en_op.id_ent = cg.id_ent");
		sb.append(" WHERE");
		sb.append(" cg.fg_st = 'Y'");
		sb.append(" AND nvl(st.id_paypatoep,'~')='~'");
		sb.append(" and (cg.fg_acc='Y' or cg.fg_hpcg='Y')");
		sb.append(" AND pi.code = ?");
		sb.append(" AND cg.dt_st >=?");
		sb.append(" AND cg.dt_st <=?");
		sb.append(" AND st.eu_direct = '1'");
		sb.append(" AND st.fg_canc = 'N'");
		sb.append(" AND cg.FG_REFUND = 'N'");
		return sb.toString();
	}

}
