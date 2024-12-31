package iih.ci.ord.s.external.provide;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import java.util.Map;

import iih.ci.ord.i.external.provide.ICiOrdIpPartnerService;
import iih.ci.ord.s.external.provide.bp.partner.GetIpOrderCancelStateBP;
import iih.ci.ord.s.external.provide.bp.partner.GetIpOrdersAmount8EnBP;
import iih.ci.ord.s.external.provide.bp.partner.GetIpOrdersBP;
import iih.ci.ord.s.external.provide.bp.partner.getNursingDaysBP;

/**
 * 临床对第三方接口
 * @author Young
 *
 */
@Service(serviceInterfaces = { ICiOrdIpPartnerService.class }, binding = Binding.JSONRPC)
public class CiOrdIpPartnerServiceImpl implements ICiOrdIpPartnerService {

	/**
	 * 住院医嘱查询接口
	 * @param xmlStr
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getIpOrders(String xmlParam) throws BizException {
		GetIpOrdersBP bp = new GetIpOrdersBP();
		return bp.exec(xmlParam);
	}
	/**
	 * 患者历史医嘱数量接口
	 * @param xmlParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getIpOrdersAmount8En(String xmlParam) throws BizException {
		GetIpOrdersAmount8EnBP bp = new GetIpOrdersAmount8EnBP();
		return bp.exec(xmlParam);
	}
	/**
	 * 查询指定医嘱是否已经确认作废
	 * @param xmlParam
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getIpOrderCancelState(String xmlParam) throws BizException {
		GetIpOrderCancelStateBP bp = new GetIpOrderCancelStateBP();
		return bp.exec(xmlParam);
	}
	
	/**
	 * 查询护理天数
	 * @return
	 * @throws BizException
	 */
	@Override
	public  Map<String ,Integer> getNursingDays(String id_ent)throws BizException{
		getNursingDaysBP bp = new getNursingDaysBP();
		return bp.getNursingDays(id_ent);
	}
	
}
