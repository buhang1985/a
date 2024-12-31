package iih.bl.cg.bp;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlPsnDocName {
	private String GetBlPsnDocNameSQL()
	{
		
		return "select name from bd_psndoc where id_psndoc=?";
	}
	private String GetBlPsnDocCodeSQL()
	{
		
		return "select code from bd_psndoc where id_psndoc=?";
	}
	public String GetBlPsnDocName(String id_psndoc)   throws BizException 	
	{
		ColumnHandler handler = new ColumnHandler();
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_psndoc);
		DAFacade cade = new DAFacade();
		String  name = cade.execQuery(GetBlPsnDocNameSQL(),sqlParam,handler).toString();
		if (name.isEmpty()) {
			throw new BizException("工作人员名称不存在");
		}
		if( name.equals("Y")){
			throw new BizException("工作人员名称不存在");
		}
		return name;
	}

	public String GetBlPsnDocCode(String id_psndoc)   throws BizException 	
	{
		ColumnHandler handler = new ColumnHandler();
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_psndoc);
		DAFacade cade = new DAFacade();
		String  code = cade.execQuery(GetBlPsnDocCodeSQL(),sqlParam,handler).toString();
		if (code.isEmpty()) {
			throw new BizException("工作人员编号不存在");
		}
		if( code.equals("Y")){
			throw new BizException("工作人员编号不存在");
		}
		return code;
	}
}
