package iih.sc.apt.s.event;

import java.util.List;
import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 科室手术确认事件
 * 
 * @author yzh
 *
 */
public class OptAptConfirmEvent {
	/**
	 * 触发科室手术确认事件
	 * 
	 * @param 科室手术确认事件源DTOiih.sc.apt.dto.d.OptApt4OrmDTO
	 * @throws BizException
	 */
	public void invoke(List<OptApt4OrmDTO> optApt4OrmList) throws BizException {
		BusinessEvent mtAptEvent = new BusinessEvent(IScEventConst.EVENT_SOURCE_SC_OPT_APT, IScEventConst.EVENT_SC_OPT_APT_CONFIRM,
				optApt4OrmList);
		EventDispatcher.fireEvent(mtAptEvent);
	}
}
