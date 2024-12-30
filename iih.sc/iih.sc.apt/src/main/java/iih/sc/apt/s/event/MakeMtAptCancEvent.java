package iih.sc.apt.s.event;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 医技预约取消事件
 * @author TFL
 *
 */
public class MakeMtAptCancEvent {
	/**
	 * 触发医技预约取消事件
	 * @param apt4EsDTO
	 * @throws BizException
	 */
	public void invoke(MtApt4EsDTO apt4EsDTO) throws BizException {
		BusinessEvent mtAptEvent = new BusinessEvent(IScEventConst.EVENT_SOURCE_SC_MT_APT, IScEventConst.EVENT_SC_MT_CAN_APT,
				apt4EsDTO);
		EventDispatcher.fireEvent(mtAptEvent);
	}
}
