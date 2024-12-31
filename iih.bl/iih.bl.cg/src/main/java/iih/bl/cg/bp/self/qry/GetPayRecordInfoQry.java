package iih.bl.cg.bp.self.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取门诊交费交易信息
 * @author LIM
 *
 */
public class GetPayRecordInfoQry implements ITransQry {
	
	String patCode;
	String beginTime;
	String endTime;
	public GetPayRecordInfoQry(String patCode, String beginTime, String endTime){
		this.patCode=patCode;
		this.beginTime=beginTime;
		this.endTime=endTime;	
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) 
	{
		SqlParam param= new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.patCode)) {
			param.addParam(this.patCode);
		}		
		if (!StringUtil.isEmptyWithTrim(this.beginTime)) {
			param.addParam(this.beginTime);
		}	
		if (!StringUtil.isEmptyWithTrim(this.endTime)) {
			param.addParam(this.endTime);
		}	
//		if (!StringUtil.isEmptyWithTrim(this.patCode)) {
//			param.addParam(this.patCode);
//		}		
//		if (!StringUtil.isEmptyWithTrim(this.beginTime)) {
//			param.addParam(this.beginTime);
//		}	
//		if (!StringUtil.isEmptyWithTrim(this.endTime)) {
//			param.addParam(this.endTime);
//		}	
//		if (!StringUtil.isEmptyWithTrim(this.patCode)) {
//			param.addParam(this.patCode);
//		}		
//		if (!StringUtil.isEmptyWithTrim(this.beginTime)) {
//			param.addParam(this.beginTime);
//		}	
//		if (!StringUtil.isEmptyWithTrim(this.endTime) ) {
//			param.addParam(this.endTime);
//		}			
		return param;
	}
	@Override
	public String getQrySQLStr() 
	{
		StringBuilder sb= new StringBuilder();
		sb.append(getpaySql());
//		sb.append(" union all ");
//		sb.append(getHpSql());
		return sb.toString();
	}
	/**
	 * 获取付费信息
	 * @return
	 */
	private String getpaySql(){
		StringBuilder sb= new StringBuilder();
		sb.append("select distinct ");
		sb.append("dep.name as orDepName,");
		sb.append("us.name as orEmpName,");
		sb.append("(st.eu_direct* st.Amt_Ratio) as amt,");
		sb.append("st.dt_st as settleTime,");
		sb.append(" case pay.sd_pttp when '01' then '窗口' when '02' then '自助机' when '03' then '微信' when '04' then '手机APP' end  as pttpName,");
		sb.append("st.code_st,");
		sb.append("op.times_op as opTimes");
		sb.append(" from  BL_CG_ITM_OEP oep ");
		sb.append(" inner join Bl_St_Oep st on oep.id_stoep= st.id_stoep");
		sb.append(" inner join BL_PAY_PAT_OEP pay on st.id_paypatoep=pay.id_paypatoep");
		sb.append(" inner join   bd_dep  dep on dep.id_dep = oep.id_dep_or ");
		sb.append(" inner join bd_psndoc us on us.id_psndoc=oep.id_emp_or ");
		sb.append(" inner join pi_pat pat on oep.id_pat= pat.id_pat ");
		//关联医嘱，过滤掉挂号费用
		sb.append(" inner join  ci_order ci_order on oep.id_or=ci_order.id_or  "); 
		sb.append(" INNER JOIN en_ent ent on ent.id_ent=oep.id_ent ");
		sb.append(" INNER JOIN en_ent_op op on op.id_ent=ent.id_ent ");
		sb.append(" where 	");
		//不查询已退费信息
		sb.append("  oep.fg_refund='N' AND st.eu_direct = '1'  AND st.fg_canc = 'N' and oep.fg_st = 'Y'");
		sb.append(" and pat.code=?  and TRUNC(TO_DATE(st.dt_st,'yyyy-MM-dd hh24:mi:ss'))>= TRUNC(TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss')) and TRUNC(TO_DATE(st.dt_st,'yyyy-MM-dd hh24:mi:ss'))<= TRUNC(TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss'))");
		return sb.toString();	
	}
	/**
	 * 获取高端商保和预交金记账数据
	 * @return
	 */
	private String getHpSql(){
		StringBuilder sb= new StringBuilder();
		sb.append("select  ");
		sb.append("dep.name as orDepName,");
		sb.append("us.name as orEmpName,");
		sb.append("(cg.eu_direct * oep.Amt_Ratio) as amt,");
		sb.append("oep.dt_st as settleTime,");
		sb.append("  case when oep.fg_acc='Y'then '预交金'else '高端商保' end as pttpName,");
		sb.append(" '' as code_st,");
		sb.append("op.times_op as opTimes");
		sb.append(" from  BL_CG_ITM_OEP oep ");
		sb.append("  inner join BL_CG_OEP cg on cg.id_cgoep = oep.id_cgoep");
		sb.append(" inner join   bd_dep  dep on dep.id_dep = oep.id_dep_or ");
		sb.append(" inner join bd_psndoc us on us.id_psndoc=oep.id_emp_or ");
		sb.append(" inner join pi_pat pat on oep.id_pat= pat.id_pat ");
		//关联医嘱，过滤掉挂号费用
		sb.append(" inner join  ci_order ci_order on oep.id_or=ci_order.id_or  "); 
		sb.append(" INNER JOIN en_ent ent on ent.id_ent=oep.id_ent ");
		sb.append(" INNER JOIN en_ent_op op on op.id_ent=ent.id_ent ");
		sb.append(" where  (oep.fg_acc='Y' or oep.fg_hpcg='Y') ");
		sb.append(" and nvl(oep.fg_st, '~') <> 'Y'");//未结算
		sb.append(" and nvl(oep.id_par, '~') = '~'");//非退费
		sb.append(" and oep.id_cgitmoep not in ("); //过滤掉高端商保，预交金未结算，直接退费的数据
		sb.append("select distinct id_par ");
		sb.append(" from BL_CG_ITM_OEP itm ");
		sb.append(" inner join pi_pat pat on itm.id_pat = pat.id_pat ");
		sb.append(" where pat.code=?  and TRUNC(TO_DATE(itm.dt_or,'yyyy-MM-dd hh24:mi:ss'))>= TRUNC(TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss')) and TRUNC(TO_DATE(itm.dt_or,'yyyy-MM-dd hh24:mi:ss'))<= TRUNC(TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss'))");
		sb.append(")");
		sb.append(" and pat.code=?  and TRUNC(TO_DATE(oep.dt_or,'yyyy-MM-dd hh24:mi:ss'))>= TRUNC(TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss')) and TRUNC(TO_DATE(oep.dt_or,'yyyy-MM-dd hh24:mi:ss'))<= TRUNC(TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss'))");
		return sb.toString();		
	}
}
