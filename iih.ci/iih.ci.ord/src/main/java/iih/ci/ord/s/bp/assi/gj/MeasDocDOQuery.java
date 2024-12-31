package iih.ci.ord.s.bp.assi.gj;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class MeasDocDOQuery implements ITransQry
{
	private String id_unit_med;
	
	public MeasDocDOQuery(String id_unit_med){
		this.id_unit_med = id_unit_med;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){
		 StringBuilder sb = new StringBuilder();
		 sb.append("select * from bd_measdoc where id_measdoc='"+id_unit_med+"'");
		 return sb.toString();
	 }

}
