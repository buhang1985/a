package iih.sc.apt.s.event;

import java.util.List;

import iih.bd.bc.event.pub.IScEventConst;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;

/**
 * 手术预约事件
 * 
 * @author yzh
 *
 */
public class MakeOptCancAptEvent {
	/**
	 * 触发手术预约退约事件
	 * 
	 * @param apt4EsDTO 医技预约事件源DTOiih.sc.apt.dto.d.OptApt4OrmDTO
	 * @throws BizException
	 */
	public void invoke(List<OptApt4OrmDTO> optApt4OrmList) throws BizException {
		BusinessEvent mtAptEvent = new BusinessEvent(IScEventConst.EVENT_SOURCE_SC_OPT_APT, IScEventConst.EVENT_SC_OPT_CANC_APT,
				optApt4OrmList);
		EventDispatcher.fireEvent(mtAptEvent);
	}
}
