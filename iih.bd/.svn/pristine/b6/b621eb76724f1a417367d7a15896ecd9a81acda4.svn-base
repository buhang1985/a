package iih.bd.pp.pripat.s;

import java.math.BigDecimal;

import iih.bd.pp.pripat.i.IPripatCalService;
import iih.bd.pp.pripat.s.bp.PriPatRate;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

@Service(serviceInterfaces={IPripatCalService.class}, binding=Binding.JSONRPC)
public class PripatCalServiceImpl implements IPripatCalService{
	PriPatRate priPatRateIns=new PriPatRate();
	/**
	 * 根据价格分类返回价格系统
	 */
	@Override
	public FDouble GetPriPatRate(String id_pripat) throws BizException {
		ColumnHandler handler = new ColumnHandler();
    	String sql=priPatRateIns.GetPriPatRateSql();
    	SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pripat);
    	DAFacade cade = new DAFacade();
    	Object result=cade.execQuery(sql,sqlParam,handler);
    	if(result==null)
    	{    		
    		//throw new BizException("该价格分类不存在或不存在价格系数");
    		return new FDouble(1); //该价格分类不存在或不存在价格系数时，默认为1
    	}
		return new FDouble((BigDecimal)result);
		
	}

}
