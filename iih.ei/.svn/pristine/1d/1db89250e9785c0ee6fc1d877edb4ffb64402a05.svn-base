package iih.ei.std.viewhigh.v1.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.ei.std.consis.v1.s.bp.BaseCallWsBp;
import iih.ei.std.viewhigh.v1.s.bp.qry.FindSrvIdByCodeQry;
import iih.mc.itf.ws.d.FindSrvIdByBarCodeParamDTO;
import iih.mc.itf.ws.d.FindSrvIdByBarCodeResultDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 根据耗材条码获取医疗服务主键业务逻辑
 * 
 * @author hao_wu 2018-11-23
 *
 */
public class FindSrvIdByBarCodeBp extends BaseCallWsBp {

	public FindSrvIdByBarCodeResultDTO exec(FindSrvIdByBarCodeParamDTO paramDto) {
		FindSrvIdByBarCodeResultDTO resultDto = null;

		try {
			String wsParamStr = getCallWsParam(paramDto);
			String wsResultStr = callWebService(wsParamStr);
			resultDto = getResultDto(paramDto, wsResultStr);
		} catch (Exception e) {
			writeLog(e);
		}
		return resultDto;
	}

	@Override
	protected String callWebService(String paramStr) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取调用WebService参数
	 * 
	 * @param paramDto
	 * @return
	 */
	protected String getCallWsParam(FindSrvIdByBarCodeParamDTO paramDto) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取结果DTO
	 * 
	 * @param paramDto
	 * @param wsResultStr
	 * @return
	 * @throws BizException
	 */
	protected FindSrvIdByBarCodeResultDTO getResultDto(FindSrvIdByBarCodeParamDTO paramDto, String wsResultStr)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 使用医疗服务编码获取医疗服务主键
	 * 
	 * @param srvCode 医疗服务编码
	 * @return 医疗服务主键
	 * @throws BizException 根据服务编码查询到多个服务主键
	 */
	protected String findSrvIdByCode(String srvCode) throws BizException {

		String[] srvIds = findSrvIdsByCode(srvCode);
		if (ArrayUtils.isEmpty(srvIds)) {
			return null;
		}
		if (srvIds.length > 1) {
			String msg = String.format("根据服务编码查询到多个服务主键，服务编码:%s,服务主键:%s.", srvCode, StringUtils.join(srvIds, ','));
			throw new BizException(msg);
		}

		return srvIds[0];
	}

	/**
	 * 根据医疗服务编码查询医疗服务主键
	 * 
	 * @param srvCode 医疗服务编码
	 * @return 医疗服务主键
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected String[] findSrvIdsByCode(String srvCode) throws BizException {
		FindSrvIdByCodeQry qry = new FindSrvIdByCodeQry(srvCode);

		DAFacade daFacade = new DAFacade();
		ArrayList<String> srvIdList = (ArrayList<String>) daFacade.execQuery(qry.getQrySQLStr(),
				qry.getQryParameter(null), new ColumnListHandler());
		if (srvIdList == null || srvIdList.size() <= 0) {
			return null;
		}
		return srvIdList.toArray(new String[0]);
	}
}
