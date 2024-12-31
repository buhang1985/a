package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOutlineSrvRefMmQry  implements ITransQry{

	private String[] ids = null;
	
	public  GetOutlineSrvRefMmQry(String[] ids) {
		// TODO Auto-generated constructor stub
		this.ids = ids;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		//SqlParam param = new SqlParam();
		
		
		StringBuilder sb = new StringBuilder("('");
		for(int index = 0; this.ids != null && index <  ids.length; ++index)
		{
			sb.append(ids[index]);
			if (ids.length > 1 && index < ids.length-2)
			{
				sb.append("','");
			}
			
		}
		
		sb.append("')");
		
	//	param.addParam(sb.toString());
		
		arg0.append(" and A.id_srv in ").append(sb);
		
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return "select A.* from bd_mm A where  A.ds=0 and A.Fg_Active='Y'";
	}

}
