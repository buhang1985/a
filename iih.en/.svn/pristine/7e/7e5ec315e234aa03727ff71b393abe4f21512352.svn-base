package iih.en.que.s.listener.bp;

import iih.en.comm.IEnConst;
import iih.en.comm.util.DateTimeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.que.board.d.EnBrdCallDO;
import iih.en.que.board.d.EnBrdSiteDO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;
/***
 * 调用框架发送药房大屏消息
 * @author fanlq
 * @date: 2019年9月18日 下午2:40:40
 */
public class SendDrugBrdMsgBP {
	/***
	 * 发送站点消息
	 * @author fanlq 2018年1月25日
	 * @param enBrdSiteDOs
	 * @throws BizException
	 */
	public void sendSiteMsg(EnBrdSiteDO[] enBrdSiteDOs) throws BizException{
		EnLogUtil logUtil =EnLogUtil.getInstance();
		String nowDate = DateTimeUtils.getNow();
		Map<String,Object> variable = this.setMap(enBrdSiteDOs);
		if(variable == null || variable.size() <= 0){
			return;
		}
		logUtil.logInfo("发送药房站点消息，时间："+nowDate);
		logUtil.logInfo("发送药房站点消息，发送数据："+variable);
		IGenerateMessageExtdService service = ServiceFinder.find(IGenerateMessageExtdService.class);
		service.GenerateMessageAndMap(IEnConst.DRUG_BRD_SITE_MSG_CODE, variable, null);
	}
	/***
	 * 发送叫号消息
	 * @author fanlq 2018年1月25日
	 * @param enBrdCallDOs
	 * @throws BizException
	 */
	public void sendCallMsg(EnBrdCallDO[] enBrdCallDOs) throws BizException{
		EnLogUtil logUtil =EnLogUtil.getInstance();
		String nowDate = DateTimeUtils.getNow();
		Map<String,Object> variable = this.setMap(enBrdCallDOs);
		if(variable == null || variable.size() <= 0){
			return;
		}
		logUtil.logInfo("发送药房叫号消息，时间："+nowDate);
		logUtil.logInfo("发送药房叫号消息，发送数据："+variable);
		IGenerateMessageExtdService service = ServiceFinder.find(IGenerateMessageExtdService.class);
		service.GenerateMessageAndMap(IEnConst.DRUG_BRD_CALL_MSG_CODE, variable,null);
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
