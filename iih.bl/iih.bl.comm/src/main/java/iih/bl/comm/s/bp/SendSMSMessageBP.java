package iih.bl.comm.s.bp;

import com.sms.i.ISendSMSService;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 发送短信
 * @author hanjq 2019-11-22 16:12:12
 *
 */
public class SendSMSMessageBP {

	
	public int exec(String mobile, String message, String noticecode) throws BizException {
		ISendSMSService service=ServiceFinder.find(ISendSMSService.class);
		return service.sendMessage(mobile, message, noticecode);
	}

}
