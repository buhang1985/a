package iih.bd.srv.s.bp.event;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4MedUsageBP;
import iih.bd.srv.s.bp.iemsg.UtilsIE;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

public class FireMedUsageInsertEvent4IeBP extends AbstractEvent4IEListener {

	/**
	 * 用药途径 MS017
	 */
	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType)
			throws BizException {

		MedUsageDO[] usages = (MedUsageDO[]) newObjs;

		fireIEEvent4Usage(usages, eventType);

		ServiceFinder.find(ICiCacheClearMainService.class).ClearAll();
	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.MEDUSAGE_ADDDELMOD_EVENT_SOURCEID;
	}

	/**
	 * 事件发送 用法
	 * 
	 * @param newObjs
	 * @param eventType
	 * @throws BizException
	 */
	private void fireIEEvent4Usage(MedUsageDO[] newObjs, String eventType)
			throws BizException {

		// 生成集成平台用法数据信息
		GetIEIpMsgInfo4MedUsageBP bp = new GetIEIpMsgInfo4MedUsageBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_ROUTE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_ROUTE, eventType,
//				"02", msgdos);

	}
}
