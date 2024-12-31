package iih.en.pv.pub.listener;

import iih.en.que.dto.d.AllQue4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessListener;

public interface IEnAllQue4DisplayListener extends IBusinessListener {
	/**
	 * 发送上屏消息
	 * 
	 * @param opQue4EsDTO
	 * @param eventType
	 * @throws BizException
	 */
	void sendWfInfo(AllQue4EsDTO allQue4EsDTO, String eventType) throws BizException;
}
