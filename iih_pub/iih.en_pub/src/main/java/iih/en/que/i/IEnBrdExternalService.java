package iih.en.que.i;

import xap.mw.core.data.BizException;
import iih.en.pv.outpatient.dto.d.ResultBean;

public interface IEnBrdExternalService {

	/***
	 * 发送站点上屏消息
	 * @author fanlq 2018年1月26日
	 * @return
	 * @throws BizException
	 */
	ResultBean sendSiteInfo(String param) throws BizException;
	/***
	 * 发送叫号消息
	 * @author fanlq 2018年1月26日
	 * @return
	 * @throws BizException
	 */
	ResultBean sendCallInfo(String param) throws BizException;
}
