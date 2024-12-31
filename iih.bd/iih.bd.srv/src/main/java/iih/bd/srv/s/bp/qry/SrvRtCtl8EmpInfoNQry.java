package iih.bd.srv.s.bp.qry;

import iih.bd.srv.pub.BdSrvUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SrvRtCtl8EmpInfoNQry implements ITransQry {
	private String _id_org;
	private String _id_emp;
	private String _id_entp;
	
	public SrvRtCtl8EmpInfoNQry(String id_org,String id_emp,String id_entp){
		this._id_org=id_org;
		this._id_emp=id_emp;
		this._id_entp=id_entp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		param.addParam(_id_emp);
	//	param.addParam(_id_org);

		return param;
	}

	@Override
	public String getQrySQLStr() {
		
//		return " select t.* "
//			  +" from bd_srv_rt_emp_ref t left outer join bd_srv_rt s on t.id_srvrt=s.id_srvrt "
//			  +" where t.id_emp_phy= ?  and s.id_org= ?  and s.fg_use_"+getEnttpFgField(_id_entp)+"='Y'";
		return " select B.Id_Srvrtca as id_srvrtempref, A.id_srvrt, A.id_emp_phy, A.id_emptitle, "
			  +" A.sd_emptitle, A.id_humantype, A.sd_humantype, A.Code,B.Code as Ds "
			  +" from bd_srv_rt_emp_ref A left outer join bd_srv_rt B on A.Id_Srvrt=B.Id_Srvrt "
			  +" where A.id_emp_phy=?   and B.fg_use_"+getEnttpFgField(_id_entp)+"='Y' ";
	}
	
	
	private String getEnttpFgField(String entp){
		return BdSrvUtils.getEntpFldNameStr8Id(entp);
	}

}
