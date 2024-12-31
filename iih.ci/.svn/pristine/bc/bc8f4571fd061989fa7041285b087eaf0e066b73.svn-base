package iih.ci.mr.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class MrTreeListSql implements ITransQry {
	
	private String name ;

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
	
	private String getSql(){
		
		return "     select  p.id_mrtp,p.code,p.name, p.id_parent, count(*) num    "+
				"    from bd_mrtp p,ci_mr l  where p.id_mrtp = l.id_mrtp "+
                "    group by  p.id_mrtp,p.code,p.name,p.id_parent";
	}

}
