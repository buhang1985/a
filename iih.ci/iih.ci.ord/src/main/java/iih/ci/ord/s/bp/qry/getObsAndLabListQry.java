package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getObsAndLabListQry implements ITransQry{
	
	public String  _id_ent;
	public String  _type;
	public getObsAndLabListQry(String id_ent,String type){
		this._id_ent= id_ent;
		this._type= type;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam  sqlParam = new SqlParam();
		sqlParam.addParam(this._id_ent);
		//sqlParam.addParam(this.sd_srvtp);
		//sqlParam.addParam(this._id_ent);
		//sqlParam.addParam(this.sd_srvtp);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		if(this._type.equalsIgnoreCase("obs")){
			//return getSql_obs();
			return getCIRptObs();
		} 
		if(this._type.equalsIgnoreCase("lab")){
			return GetCiRptLab();
		}
		
		if(this._type.equalsIgnoreCase("pathol")){
			//return  getSql_lab();
			return getPathol();
		}
		return  null;
	}
	
	
	  private String getCiRptLab(){
		 
		  return "  select  ci.name_or name ,ps.name signname, lab.id_rptlab id , ci.sd_srvtp,ca.ID_SRVCA parent,lab.DT_RPTLAB dtor "
		  		+ " from ci_rpt_lab lab left join CI_ORDER ci on lab.ID_OR=ci.ID_OR left join bd_srv srv on srv.ID_SRV=ci.id_srv "
				  +"   left join bd_srvca ca on ca.ID_SRVCA=srv.ID_SRVCA  "
				  +"   left join BD_PSNDOC ps on ci.ID_EMP_SIGN=ps.ID_PSNDOC  "
				  +"  where ci.id_en =? order by lab.DT_RPTLAB desc ";
	  }
	  
	  private String GetCiRptLab() {
		//  SqlUtils.getInSqlByBigIds(id_ent,);
		  StringBuilder sb = new StringBuilder();
		  sb.append(" select  ci.name_or name ,ps.name signname, lab.id_rptlab id , ci.sd_srvtp,ca.ID_SRVCA parent,lab.DT_RPTLAB dtor ");
		  sb.append(" from ci_rpt_lab lab ");
		  sb.append(" left join CI_ORDER ci on lab.ID_OR=ci.ID_OR ");
		  sb.append(" left join bd_srv srv on srv.ID_SRV=ci.id_srv ");
		  sb.append(" left join bd_srvca ca on ca.ID_SRVCA=srv.ID_SRVCA ");
		  sb.append(" left join BD_PSNDOC ps on ci.ID_EMP_SIGN=ps.ID_PSNDOC ");
		  sb.append(" where ci.id_en = ? ");
		  sb.append(" order by lab.DT_RPTLAB desc ");
		  return sb.toString();
	  }

	
	 private String getCIRptObs(){

		  return "  select  ci.name_or name ,ps.name signname, obs.id_rptobs id , ci.sd_srvtp,ca.ID_SRVCA parent,obs.DT_RPTOBS dtor "
	  		+ " from ci_rpt_obs obs left join CI_ORDER ci on obs.ID_OR=ci.ID_OR left join bd_srv srv on srv.ID_SRV=ci.id_srv "
			  +"   left join bd_srvca ca on ca.ID_SRVCA=srv.ID_SRVCA  "
			  +"   left join BD_PSNDOC ps on ci.ID_EMP_SIGN=ps.ID_PSNDOC  "
			  +"  where ci.id_en =?  order by obs.DT_RPTOBS desc";
	 }
	 
	 private String getPathol(){

		  return "  select  ci.name_or name ,ps.name signname, appa.id_appathgy id , ci.sd_srvtp,ca.ID_SRVCA parent,appa.DT_RPTPATHGY dtor "
	  		+ " from ci_rpt_pathgy appa left join CI_ORDER ci on appa.ID_OR=ci.ID_OR left join bd_srv srv on srv.ID_SRV=ci.id_srv "
			  +"   left join bd_srvca ca on ca.ID_SRVCA=srv.ID_SRVCA  "
			  +"   left join BD_PSNDOC ps on ci.ID_EMP_SIGN=ps.ID_PSNDOC  "
			  +"  where  ci.id_en =?  order by appa.DT_RPTPATHGY desc";
		  
	 }
	
	
//	/**
//	 * 检查
//	 * @return
//	 */
//	 private String getSql_obs(){
//		 return   "  "
//				  +"  select bd.name name, sd_srvtp,  ciorder.id_srvtp id,  null parent   from ci_rpt_obs  obs "
//		          +"  left outer join ci_order ciorder on obs.id_or = ciorder.id_or  "
//				  +"   left outer join bd_udidoc bd  on  bd.id_udidoc = ciorder.id_srvtp "
//				 
//		          +"    where ciorder.id_en=?"
//		         // +" and obs.sd_su_lab = '01' "
//		         // +"    and bdsrv.sd_srvtp  like '02%' "
//		          +"    group by  bd.name, sd_srvtp,ciorder.id_srvtp  "
//		          +"   UNION "
//		          +"   select ciorder.name_or, sd_srvtp, obs.id_rptobs, ciorder.id_srvtp parent    from ci_rpt_obs  obs    "
//		          +"  left outer join ci_order ciorder on obs.id_or = ciorder.id_or  "
//		          +"   where ciorder.id_en=?"
//		          +" ";
//		         // +"   and  ciorsrv.sd_srvtp  like '02%' ";
//	 }
//    /**
//     * 检验
//     * @return
//     */
//	 private String getSql_lab(){
//		 return   "  "
//				  +"  select bd.name name, sd_srvtp,  ciorder.id_srvtp id,  null parent   from ci_rpt_lab  lab "
//		          +"  left outer join ci_order ciorder on lab.id_or = ciorder.id_or  "
//				  +"   left outer join bd_udidoc bd  on  bd.id_udidoc = ciorder.id_srvtp "
//				 
//		          +"    where ciorder.id_en=?"
//		         // +" and lab.sd_su_lab = '01' "
//		         // +"    and bdsrv.sd_srvtp  like '02%' "
//		          +"    group by  bd.name, sd_srvtp,ciorder.id_srvtp  "
//		          +"   UNION "
//		          +"   select ciorder.name_or, sd_srvtp, lab.Id_rptlab id, ciorder.id_srvtp parent    from ci_rpt_lab  lab    "
//		          +"  left outer join ci_order ciorder on lab.id_or = ciorder.id_or  "
//		          +"   where ciorder.id_en=?"
//		          +"  ";
//		         // +"   and  ciorsrv.sd_srvtp  like '02%' ";
//	 }
	 
//测试sql	 
/*     select bd.name name, sd_srvtp,  ciorder.id_srvtp id,  '0' parent   from ci_rpt_lab  lab
     left outer join ci_order ciorder on lab.id_or = ciorder.id_or
     left outer join bd_udidoc bd  osn  bd.id_udidoc = ciorder.id_srvtp
where ciorder.id_en = '0001AA1000000003RP18'
and lab.sd_su_lab = '01'
group by  bd.name, sd_srvtp,ciorder.id_srvtp
union 
select ciorder.name_or, sd_srvtp, ciorder.id_or id, ciorder.id_srvtp parent    from ci_rpt_lab  lab
     left outer join ci_order ciorder on lab.id_or = ciorder.id_or
where ciorder.id_en = '0001AA1000000003RP18'*/
}
