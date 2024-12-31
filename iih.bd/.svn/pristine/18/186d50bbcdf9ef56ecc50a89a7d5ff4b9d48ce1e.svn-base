package iih.bd.srv.medsrv.bf.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医疗服务定价模式相关信息查询实体
 */
public class MedSrvPriDtoQry implements ITransQry {

	private String _id;
	private String _fldname;
	public MedSrvPriDtoQry(String id,String fldname){
		_id=id;
		_fldname=fldname;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return getQrySQLStr_();
	}
	
	private String getQrySQLStr_(){
		return " select  p.id_srv, p.code as code, p.name as name,p.id_srvca,p.id_unit_med," 
			 + " t.code  as code_unit_med,t.name as name_unit_med, p.quan_med, p.fg_set,p.id_primd,"
			 + " c.name as srvca_name,pri.name as pri_name  from bd_srv p"
			 + "  left outer join bd_measdoc t on p.id_unit_med = t.id_measdoc left join bd_srvca c on p.id_srvca= c.id_srvca"
			 + " left join bd_pri pri on p.id_primd=pri.id_pri "
			 + " where p."+_fldname+"=? ";
	}


}
