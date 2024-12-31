package iih.bl.cg.bp.self.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取门诊病人处方信息接口
 * @author LIM
 *
 */
public class GetPatPrescriptionInfoQry implements ITransQry  {
	
	String patCode;
	String patType;
	String beginTime;
	String endTime;
	public GetPatPrescriptionInfoQry(String patCode, String patType, String beginTime, String endTime){
		this.patCode=patCode;
		this.patType=patType;
		this.beginTime=beginTime;
		this.endTime=endTime;
		
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (this.patCode != null && this.patCode != "") {
			param.addParam(this.patCode);
		}
		if (this.beginTime != null && this.beginTime != "") {
			param.addParam(this.beginTime);
		}
		if (this.endTime != null && this.endTime != "") {
			param.addParam(this.endTime );
		}		
		return param;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(getMediQry());
		sb.append( "  union all ");
		sb.append(getSqlObs());		
		sb.append( "  union all ");
		sb.append(getSqlLab());
		sb.append( "  union all ");
		sb.append(getSqltreatment());
		sb.append( "  union all ");
		sb.append(getSqlpathology());
		return sb.toString();
	}
	/**
	 * 获取药品处方信息
	 * @return
	 */
	private String getMediQry(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("select oep.code_apply as applyCode,");
		sb.append("'01' as applyTpCode,");
		sb.append("'药品' as applyTpName,");
		sb.append(getSqlFrom());  
		sb.append("where   ci_order.sd_su_or='10'  and ci_or_srv.ds = 0 and ci_order.ds = 0  and  ci_or_srv.fg_self ='N'    and ci_or_srv.fg_bl = 'Y'  ");  
		sb.append("and    ci_or_srv.sd_srvtp  like '01%'  and ent.code=? and ");
		sb.append("TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))>=? and  TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))<=?");
		sb.append(getSqlWhere());
		return sb.toString();
	}
	/**
	 * 获取检查处方信息
	 * @return
	 */
	private String getSqlObs(){
		StringBuilder sb = new StringBuilder();
		sb.append("select  ent.id_hp,oep.code_apply as applyCode,");
		sb.append("'02' as applyTpCode,");
		sb.append("'检查' as applyTpName,");
		sb.append(getSqlFrom());
		sb.append("where   ci_order.sd_su_or in ('10','20','30','40','50','60')        and ci_or_srv.ds = 0   ");
		sb.append(" and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0  ");
		sb.append(" and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '02%' and  ci_or_srv.sd_srvtp not like '0207%')  ");
		sb.append(" and ent.code=? and "); 
		sb.append("TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))>=? and  TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))<=?	");
		
		sb.append(getSqlWhere());
		
		return sb.toString();
	}
	/**
	 * 获取检验处方信息
	 * @return
	 */
	private String getSqlLab(){
		StringBuilder sb = new StringBuilder();
		sb.append("select  ent.id_hp,oep.code_apply as applyCode,");
		sb.append("'03' as applyTpCode,");
		sb.append("'检验' as applyTpName,");
		sb.append(getSqlFrom());  
		sb.append("where   ci_order.sd_su_or in ('10','20','30','40','50','60')        and ci_or_srv.ds = 0   ");
		sb.append(" and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0  ");
		sb.append(" and   ci_or_srv.id_pres ='~' and  ci_or_srv.sd_srvtp like '03%'  ");
		sb.append(" and ent.code=? and "); 
		sb.append("TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))>=? and  TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))<=?	");
		
		sb.append(getSqlWhere());
		
		return sb.toString();
	}
	/**
	 * 获取诊疗处方信息
	 * @return
	 */
	private String getSqltreatment(){
		StringBuilder sb = new StringBuilder();
		sb.append("select  ent.id_hp,oep.code_apply as applyCode,");
		sb.append("'04' as applyTpCode,");
		sb.append("'治疗' as applyTpName,");
		sb.append(getSqlFrom());
		sb.append("where   (ci_order.sd_su_or='10' or  ci_order.eu_orsrcmdtp ='0C' )   ");
		sb.append(" and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 and ci_order.ds = 0  ");
		sb.append(" and   ci_or_srv.id_pres ='~'  ");
		sb.append(" and   ci_or_srv.sd_srvtp  not like '01%'  and   ci_or_srv.sd_srvtp  not like '02%'  and   ci_or_srv.sd_srvtp  not like '03%'   ");
		sb.append(" and ent.code=? and "); 
		sb.append("TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))>=? and  TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))<=?	");
		
		sb.append(getSqlWhere());
		return sb.toString();
	}
	/**
	 * 获取病理处方信息
	 * @return
	 */
	private String getSqlpathology(){

		StringBuilder sb = new StringBuilder();
		sb.append("select  ent.id_hp,oep.code_apply as applyCode,");
		sb.append("'05' as applyTpCode,");
		sb.append("'病理' as applyTpName,");
		sb.append(getSqlFrom());
		sb.append("where   ci_order.sd_su_or in ('10','20','30','40','50','60')        and ci_or_srv.ds = 0   ");
		sb.append(" and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0  ");
		sb.append(" and   ci_or_srv.id_pres ='~' and   ci_or_srv.sd_srvtp like '0207%' ");
		sb.append(" and ent.code=? and "); 
		sb.append("TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))>=? and  TRUNC(TO_DATE(ci_order.dt_sign,'yyyy-MM-dd hh24:mi:ss'))<=?	");
		
		sb.append(getSqlWhere());
		return sb.toString();
	}
	/**
	 * 查询字段
	 * @return
	 */
	private String getSqlFrom(){
		StringBuilder sb= new StringBuilder();
		sb.append("ci_or_srv.code_srv as srvCode,");
		sb.append("ci_or_srv.name as srvName,");
		sb.append("ci_or_srv.id_medu as unit,");
		sb.append("oep.spec as sepcification,");
		sb.append("oep.price_ratio as price,");
		sb.append("(cg.eu_direct*oep.quan) as quan,");
		sb.append("(cg.eu_direct*oep.amt_ratio) as amt,");
		sb.append("nvl(ci_or_srv.sd_hpsrvtp,'3') as srvChargeGrade,");
		sb.append("case when bd_mm.id_mmca='0001Z8100000000MID7D'then ci_order.orders else 1 end as quanOrders,");
		sb.append("ci_order.dt_sign as signTime,");
		sb.append("case ci_order.sd_su_mp when '20' then '20' else '0' end as mpStatus,");
		sb.append("pat.barcode_chis as barCodeChis,");
		sb.append("entop.times_op as opTimes,");
		sb.append("oep.id_dep_or as orDepCode,");
		sb.append("dep.name as orDepName,");
		sb.append("oep.id_emp_or as orEmpCode,");
		sb.append("us.name as orEmpName,");
		sb.append("oep.code_enttp as entpCode,");
		sb.append("0 as observationFlag ");

		sb.append("from BL_CG_ITM_OEP oep ");
		sb.append("inner join en_ent ent on oep.id_ent=ent.id_ent ");
		sb.append("inner join en_ent_op  entop on ent.id_ent=entop.id_ent ");
		sb.append("inner join  ci_order ci_order on oep.id_or=ci_order.id_or ");
		sb.append("inner join ci_or_srv ci_or_srv on ci_order.id_or=ci_or_srv.id_or ");
		sb.append("inner join   bd_dep  dep on dep.id_dep = oep.id_dep_or ");
		sb.append("inner join bd_psndoc us on us.id_psndoc=oep.id_emp_or ");
		sb.append("inner join pi_pat pat on oep.id_pat= pat.id_pat ");
		sb.append("left join ci_or_srv_mm ci_or_srv_mm  on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv  ");
		sb.append("left outer join bd_srv bd_srv  on bd_srv.id_srv = ci_or_srv.id_srv  ");
		sb.append("left outer join  bd_mm  bd_mm  on  bd_mm.id_mm = ci_or_srv_mm.id_mm    ");   
		
		return sb.toString();
	}
	/**
	 * where
	 * @return
	 */
	private String getSqlWhere(){
		StringBuilder sb= new StringBuilder();
		if(this.patType=="0"){
			//自费患者
			sb.append(" and nvl(ent.id_hp,'~')='~'");
		}else{
			//医保患者
			sb.append(" and nvl(ent.id_hp,'~')<>'~'");
		}	
		sb.append(" and oep.fg_st='N'");
		return sb.toString();
	}
}
