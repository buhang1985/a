package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTemperature implements ITransQry
{
	private static String id_srv="0001Z7100000000EZCIF";
	private String id_ent;
	
	public GetTemperature(String id_ent){
		this.id_ent = id_ent;
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
		 String formatsql="select" 
                  +" vs.dt_vt as createdtime,"
                  +" itm.id_srv,"
                  +" value,"
                  +" doc.name"
                  +" from ci_mr_vs_itm itm"
                  +" inner join ci_mr_vs vs on vs.id_mr_vs = itm.id_mr_vs"
                  +" left join bd_srv_vt srvvt on srvvt.id_srv = itm.id_srv"
                  +" left join bd_measdoc doc on doc.id_measdoc = srvvt.id_unit"
                  +" where itm.id_srv='"+id_srv+"' and vs.id_ent = '"+id_ent+"' order by vs.dt_vt desc";
		 return formatsql;
	 }

}
