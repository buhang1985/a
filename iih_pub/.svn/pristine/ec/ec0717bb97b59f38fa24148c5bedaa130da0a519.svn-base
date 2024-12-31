package iih.ei.std.i;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import xap.mw.core.data.BizException;

/**
 * IIH对外标准接口
 * 
 * @author ly 2019/07/29
 *
 */
@WebService
public interface IIHService {

	/**
	 * 处理
	 * 
	 * @author hao_wu
	 * 
	 * @param itfCode 接口编码
	 * @param param   入参XML
	 * @return 处理结果XML
	 * @throws BizException
	 */
	@WebMethod(operationName = "process")
	public abstract String process(@WebParam(name = "code") String code, @WebParam(name = "xml") String xml);
}
