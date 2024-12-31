package iih.en.pv.pub.listener;

import iih.en.que.dto.d.OpQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊队列上屏监听器
 * @author yank
 *
 */
public interface IEnOpQue4DisplayListener extends IBusinessListener {
	/**
	 * 发送上屏消息
	 * 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	void sendWfInfo(OpQue4EsDTO opQue4EsDTO, String eventType) throws BizException;
}
