package iih.ci.ord.i.external.provide;

import java.util.Map;
import xap.mw.core.data.BizException;

/**
 * 临床对第三方接口
 * @author Young
 *
 */

public interface ICiOrdIpPartnerService {

	/**
	 * 住院医嘱查询接口
	 * @param xmlStr
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpOrders(String xmlParam) throws BizException;
	/**
	 * 患者历史医嘱数量接口
	 * @param xmlParam
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpOrdersAmount8En(String xmlParam) throws BizException;
	/**
	 * 查询指定医嘱是否已经确认作废
	 * @param xmlParam
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpOrderCancelState(String xmlParam) throws BizException;
	/**
	 * 查询护理天数
	 * @return
	 * @throws BizException
	 */
	public abstract Map<String ,Integer> getNursingDays(String id_ent)throws BizException;
}
