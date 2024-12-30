package iih.sc.apt.s.event;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 预约事件
 * 
 * @author yank
 *
 */
public class MakeMtAptEvent {
	/**
	 * 触发医技预约事件
	 * 
	 * @param apt4EsDTO 医技预约事件源DTO
	 * @throws BizException
	 */
	public void invoke(MtApt4EsDTO apt4EsDTO) throws BizException {
		BusinessEvent mtAptEvent = new BusinessEvent(IScEventConst.EVENT_SOURCE_SC_MT_APT, IScEventConst.EVENT_SC_MT_APT,
				apt4EsDTO);
		EventDispatcher.fireEvent(mtAptEvent);
	}
}
