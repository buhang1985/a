package iih.bd.srv.medsrv.bf.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SrvSetSrvItemInfoQry implements ITransQry {
	private String _id_srv_set;
	
	public SrvSetSrvItemInfoQry(String id_srv_set){
		_id_srv_set=id_srv_set;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_srv_set);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return getQrySQLStr_();
	}
	
	private String getQrySQLStr_(){
		return "select p.id_srv_itm as id_srv,q.code as code,q.name as name,p.id_medu as id_unit_med,t.code as code_unit_med,  "
             + "t.name as name_unit_med,p.quan_medu as quan_med,p.id_srvsetrole,s.code as sd_srvsetrole,s.name as name_srvsetrole, "
             + "p.fg_active,p.fg_clinical,p.fg_edit,p.id_srv as id_srv_set,p.sortno,q.id_primd,q.sd_primd,r.name as primd_name from bd_srvset_def p "
             + "left outer join bd_srv q on q.id_srv=p.id_srv_itm "
             + "left outer join bd_measdoc t on  p.id_medu=t.id_measdoc " 
             + "left outer join bd_udidoc s on s.id_udidoc=p.id_srvsetrole "
             + "left outer join bd_pri r on r.id_pri = q.id_primd "
             + "where p.id_srv=? "; 
	}
}
