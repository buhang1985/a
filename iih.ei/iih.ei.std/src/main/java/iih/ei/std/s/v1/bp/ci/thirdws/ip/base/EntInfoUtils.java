package iih.ei.std.s.v1.bp.ci.thirdws.ip.base;

import java.util.List;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class EntInfoUtils {
	
	public static String getipent(String code_pat,String timesen) throws BizException {
		Integer times=Integer.parseInt(timesen);		
		String sql="select b.code from en_ent_ip a left join en_ent b on a.id_ent =b.id_ent left join pi_pat c on c.id_pat=b.id_pat where  c.code=? and a.times_ip=? ";
		SqlParam param=new SqlParam();
		param.addParam(code_pat);	
		param.addParam(times);
	
		List<String> codeens = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler("code"));
	     if(codeens!=null&&codeens.size()>0) {
	    	 return codeens.get(0);
	     }
	     return null;
	}

}
