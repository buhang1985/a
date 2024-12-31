package iih.en.pv.s.listener.ip.msg.bp;

import iih.en.comm.EnServiceRepertory;
import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;

/**
 * 发送事件消息定义
 * 
 * @author liubin
 *
 */
public class FireSysMsgEventBP {
	
	private String noticeCode;
	
	public FireSysMsgEventBP(String noticeCode){
		this.noticeCode = noticeCode;
	}
	
	public void exec(IpSysMsgDTO ipSysMsg) throws BizException{
		if(ipSysMsg == null)
			return;
		ipSysMsg.setNoticecode(this.noticeCode);
		try{
			Logger.info("发送消息【" + noticeCode + "】：" + ipSysMsg);
			EnServiceRepertory.getMsgExtServ().GenerateMessageAndMap(noticeCode, 
					assemblyMap(ipSysMsg), null);
			Logger.info("完成消息【" + noticeCode + "】：" + ipSysMsg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 组装字典
	 * 
	 * @param ipSysMsg
	 * @return
	 */
	private Map<String, Object> assemblyMap(IpSysMsgDTO ipSysMsg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IpSysMsgDTO.class.getSimpleName(), ipSysMsg);
		return map;
	}
}
