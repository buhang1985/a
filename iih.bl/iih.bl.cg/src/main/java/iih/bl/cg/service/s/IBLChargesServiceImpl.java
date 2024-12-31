package iih.bl.cg.service.s;

import iih.bl.cg.service.i.IBLChargesService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces={IBLChargesService.class}, binding=Binding.JSONRPC)
public class IBLChargesServiceImpl implements IBLChargesService  {

	@Override
	public FDouble GetInpChargesByIdEnt(String id_ent) throws BizException {
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT SUM(AMT_ratio * eu_DIRECT) charges ");
		sql.append("   FROM BL_CG_IP  ");
		sql.append("  WHERE ID_ENT = ? ");
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_ent);
		ColumnHandler handler=new ColumnHandler();
		DAFacade cade = new DAFacade();
    	Object result=cade.execQuery(sql.toString(),sqlParam,handler);
    	if(result==null)
    	{    
    		return new FDouble(0);
//    		StringBuffer sqlInfo=new StringBuffer();
//    		sqlInfo.append("未找到患者(就诊ID：");
//    		sqlInfo.append(id_ent);
//    		sqlInfo.append(")住院费用");
//    		throw new BizException(sqlInfo.toString());
    	}
    	                                                                                                                        
		return new FDouble(result.toString());
		
	}


}
