package iih.mc.itf.ws.i;

import iih.mc.itf.ws.d.FindSrvIdByBarCodeParamDTO;
import iih.mc.itf.ws.d.FindSrvIdByBarCodeResultDTO;

/**
 * 耗材管理_调用HRPWebService
 * 
 * @author hao_wu 2018-11-23
 *
 */
public interface IMcCallHRPWebService {

	/**
	 * 根据耗材条码查询医疗服务主键
	 * 
	 * @param paramDto
	 * @return
	 */
	public abstract FindSrvIdByBarCodeResultDTO findSrvIdByBarCode(FindSrvIdByBarCodeParamDTO paramDto);
}
