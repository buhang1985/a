package iih.ei.std.viewhigh.v1.s;

import iih.ei.std.viewhigh.v1.s.bp.FindSrvIdByBarCodeBp;
import iih.mc.itf.ws.d.FindSrvIdByBarCodeParamDTO;
import iih.mc.itf.ws.d.FindSrvIdByBarCodeResultDTO;

/**
 * 望海HRPWeb服务
 * 
 * @author hao_wu
 *
 */
public class HRPWebService {

	/**
	 * 根据耗材条码查询医疗服务主键
	 * 
	 * @param paramDto
	 * @return
	 */
	public FindSrvIdByBarCodeResultDTO findSrvIdByBarCode(FindSrvIdByBarCodeParamDTO paramDto) {
		FindSrvIdByBarCodeBp bp = new FindSrvIdByBarCodeBp();
		FindSrvIdByBarCodeResultDTO resultDto = bp.exec(paramDto);
		return resultDto;
	}
}
