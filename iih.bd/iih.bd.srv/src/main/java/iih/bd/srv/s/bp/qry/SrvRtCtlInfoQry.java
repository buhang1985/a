package iih.bd.srv.s.bp.qry;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.srvrtctl.d.SrvRtCtlParam;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SrvRtCtlInfoQry implements ITransQry {
	private SrvRtCtlParam _rtctlparam;
	
	public SrvRtCtlInfoQry(SrvRtCtlParam rtctlparam){
		this._rtctlparam=rtctlparam;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		param.addParam(_rtctlparam.getId_org());
		param.addParam(_rtctlparam.getId_org());
		if(isSingleIdV()){
			param.addParam(_rtctlparam.getId_srvs());
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		return "select v.id_srvrtca,u.id_srvrt,v.code,v.name,u.id_srv,u.fg_ructr,u.rules from ( "
			  +" select s.id_srvrt,s.id_srv,s.fg_ructr,s.rules,s.direct from ( "
			  +" select r.id_srvrt,r.id_srv,r.fg_ructr,r.rules,sum(r.eu_direct) as direct from  "
			  +"  ( select q.id_srvrt,q.id_srv,q.eu_direct,q.fg_ructr,q.rules from bd_srv_rt_itm q where q.id_org=? and q.id_srv!='~' "
			  +"    union all  "
			  +"    select t.id_srvrt,p.id_srv,t.eu_direct,t.fg_ructr,t.rules  from bd_srv_rt_itm t left outer join bd_srv p on t.id_srvca=p.id_srvca where t.id_org=? and t.id_srv='~') r group by r.id_srvrt,r.id_srv,r.fg_ructr,r.rules "
			  +"  ) s where s.id_srv "+getIdSrvSqlStr()+" and s.direct>0 " //in ('20150808123456789V08','1001HY1000000003HORA','0001AA1000000001IB97','0001AA1000000001T808','0001AA1000000005L9G1')
			  +"  ) u left outer join bd_srv_rt v on u.id_srvrt=v.id_srvrt  order by id_srvrtca, id_srvrt";
	}
	
	private String getIdSrvSqlStr(){
		if(isSingleIdV())return BdSrvUtils.EQUAL_STR+BdSrvUtils.QUESTION_STR;
		String id_srvs=_rtctlparam.getId_srvs();
		return BdSrvUtils.getIdsSqlStrWithInStr(id_srvs);
	}

	/**
	 * 是否单ID值
	 * @return
	 */
	private boolean isSingleIdV(){
		String id_srvs=_rtctlparam.getId_srvs();
		if(BdSrvUtils.isEmpty(id_srvs) || !BdSrvUtils.isInStr(BdSrvUtils.COMMA_STR, id_srvs))return true;
		return false;

	}
}
