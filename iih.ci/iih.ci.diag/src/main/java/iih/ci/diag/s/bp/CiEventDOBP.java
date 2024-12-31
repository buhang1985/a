package iih.ci.diag.s.bp;

import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.diag.pub.CiDiAppUtils;
import xap.mw.core.data.BizException;

/**
 * 诊断事件
 * @author li_zheng
 *
 */
public class CiEventDOBP {
	
	public CiEventDO[] setCiEventDO(CiEventDO[] ciEventDO)throws BizException{
		if(ciEventDO == null || ciEventDO.length ==0) return  null;
		return CiDiAppUtils.getICieventCudService().save(ciEventDO);
	}

}
