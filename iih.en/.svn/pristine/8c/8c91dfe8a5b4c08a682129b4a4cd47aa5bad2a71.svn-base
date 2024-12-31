package iih.en.que.s.listener.bp;

import iih.en.comm.IEnConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;
/***
 * 调用框架发送大屏消息
 * @author fanlq
 * @date: 2019年9月5日 下午7:17:23
 */
public class SendBrdMsgBP {
	/***
	 * 发送站点消息
	 * @author fanlq 2018年1月25日
	 * @param enBrdSiteDOs
	 * @throws BizException
	 */
	public void sendSiteMsg(EnBrdSiteDO[] enBrdSiteDOs) throws BizException{
		EnLogUtil logUtil =EnLogUtil.getInstance();
		logUtil.logInfo("发送门诊大屏站点消息,enBrdSiteDOs："+enBrdSiteDOs);
		if(enBrdSiteDOs == null || enBrdSiteDOs.length <= 0) return;
		Map<String,Object> variable = this.setMap(enBrdSiteDOs);
		logUtil.logInfo("发送门诊大屏站点消息，时间："+EnAppUtils.getServerDateTime()+"发送数据："+variable);
		if(variable.size() <= 0) return;
		IGenerateMessageExtdService service = ServiceFinder.find(IGenerateMessageExtdService.class);
		service.GenerateMessageAndMap(IEnConst.SEND_BRD_SITE_MSG_CODE, variable, null);
	}
	/***
	 * 发送叫号消息
	 * @author fanlq 2018年1月25日
	 * @param enBrdCallDOs
	 * @throws BizException
	 */
	public void sendCallMsg(EnBrdCallDO[] enBrdCallDOs) throws BizException{
		EnLogUtil logUtil =EnLogUtil.getInstance();
		logUtil.logInfo("发送门诊大屏叫号消息,enBrdCallDOs："+enBrdCallDOs);
		Map<String,Object> variable = this.setMap(enBrdCallDOs);
		logUtil.logInfo("发送门诊大屏叫号消息，时间："+EnAppUtils.getServerDateTime()+"发送数据："+variable);
		if(variable.size() <= 0) return;
		IGenerateMessageExtdService service = ServiceFinder.find(IGenerateMessageExtdService.class);
		service.GenerateMessageAndMap(IEnConst.SEND_BRD_CALL_MSG_CODE, variable,null);
	}
	/***
	 * 拼接消息内容用到的数据
	 * @author fanlq 2017年12月27日
	 * @param enBrdSiteDO
	 * @param opQue4EsDTO
	 * @param infoType
	 * @return
	 * @throws BizException 
	 */
	private Map<String,Object> setMap(Object[] objects) throws BizException
	{
		Map<String, Object> variable = new HashMap<String, Object>();
		for(int i=0;objects != null && i<objects.length;i++){
			variable.put(objects[0].getClass().getSimpleName(),objects[0]);
		}
		return variable;
	}

}
