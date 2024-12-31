package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSrvReactItemDOQry implements ITransQry {
	private String  ids;
	
	public GetSrvReactItemDOQry(String ids){
		this.ids=ids;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append(" select id_udidoc as Id_srvtp,name as Name_srvtp from bd_udidoc");
		String[] idArr = ids.split(",");
		sb.append(" where id_udidoc in (");
		for(int i=0;i<idArr.length;i++){
			if(i==idArr.length-1){
				sb.append("'"+idArr[i]+"'");
			}else{
				sb.append("'"+idArr[i]+"',");
			}
			
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}
}
