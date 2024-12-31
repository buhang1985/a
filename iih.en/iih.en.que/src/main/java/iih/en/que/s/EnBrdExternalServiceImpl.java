package iih.en.que.s;

import iih.bd.utils.WsXmlUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.que.dto.d.EnBrdCallDateDTO;
import iih.en.que.dto.d.EnBrdSiteDateDTO;
import iih.en.que.i.IEnBrdExternalService;
import iih.en.que.s.bp.SendBrdCallInfoBP;
import iih.en.que.s.bp.SendBrdSiteInfoBP;
import xap.mw.core.data.BizException;

public class EnBrdExternalServiceImpl implements IEnBrdExternalService{

	/***
	 * 发送站点上屏消息
	 * @author fanlq 2018年1月26日
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultBean sendSiteInfo(String param) throws BizException{
		EnLogUtil.getInstance().logInfo("方法：sendSiteInfo参数为:param:" + param);
		final EnBrdSiteDateDTO enBrdSiteDTO = WsXmlUtils.deSerializeBaseDO(param, EnBrdSiteDateDTO.class);
		SendBrdSiteInfoBP bp = new SendBrdSiteInfoBP();
		return bp.siteExec(enBrdSiteDTO);
	}
	/***
	 * 发送叫号消息
	 * @author fanlq 2018年1月26日
	 * @return
	 * @throws BizException
	 */
	@Override
	public ResultBean sendCallInfo(String param) throws BizException{
		EnLogUtil.getInstance().logInfo("方法：sendCallInfo参数为:param:" + param);
		final EnBrdCallDateDTO enBrdCallDTO = WsXmlUtils.deSerializeBaseDO(param, EnBrdCallDateDTO.class);
		SendBrdCallInfoBP bp = new SendBrdCallInfoBP();
		return bp.callExec(enBrdCallDTO);
	}
}
