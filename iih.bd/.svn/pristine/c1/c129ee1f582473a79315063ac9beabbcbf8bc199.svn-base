package iih.bd.srv.srvortpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 医嘱项目
 * @author li_zh
 *
 */
public class RefSrvItem implements ITransQry{
	
	private String  name;
	private String  pycode;
	private String  wbcode;
	private String  mnecode;
	
	public RefSrvItem(){}
	public RefSrvItem(String  keyword){
		this.name = keyword;
		this.pycode =keyword;
		this.wbcode=keyword;
		this.mnecode = keyword;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(name);
		rtnParam.addParam(pycode);
		rtnParam.addParam(wbcode);
		rtnParam.addParam(mnecode);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	private String getSql(){
		
		return  " select srv.name srv_name,srv.code srv_code,freq.id_freq freq_id_freq,freq.name freq_name,  "+
				" measdoc.id_measdoc measdoc_id_measdoc,measdoc.name measdoc_name,"+
				 "rout.id_route rout_id_route,rout.name rout_name"+
				" from bd_srv srv,  bd_freq freq ,bd_measdoc measdoc, bd_route  rout  "+
				" where srv.id_freq = freq.id_freq  "+
				" and srv.id_unit_med = measdoc.id_measdoc  "+
				" and srv.id_route = rout.id_route  "+
				" or (srv.name  like  ? or srv.pycode like ?  or srv.wbcode like  ? or srv.mnecode like  ?)";
	}
}
