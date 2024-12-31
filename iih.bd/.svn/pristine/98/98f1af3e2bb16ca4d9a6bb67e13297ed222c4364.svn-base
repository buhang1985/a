package iih.bd.srv.s.bp.event;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4FreqBP;
import iih.bd.srv.s.bp.iemsg.UtilsIE;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

public class FireFreqDefInsertEvent4IeBP extends AbstractEvent4IEListener {

	/**
	 * 常用频率 MS059
	 */
	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType)
			throws BizException {

		FreqdefAggDO[] aggDOs = (FreqdefAggDO[]) newObjs;

		fireIEEvent4Freq(aggDOs, eventType);

		ServiceFinder.find(ICiCacheClearMainService.class).ClearAll();
	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.FREQDEF_ADDDELMOD_EVENT_SOURCEID;
	}

	/**
	 * 事件发送 频次
	 * 
	 * @param newObjs
	 * @param eventType
	 * @throws BizException
	 */
	private void fireIEEvent4Freq(FreqdefAggDO[] newObjs, String eventType)
			throws BizException {

		// 生成集成平台频次数据信息
		GetIEIpMsgInfo4FreqBP bp = new GetIEIpMsgInfo4FreqBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_FREQDICT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_FREQDICT, eventType,
//				"02", msgdos);

	}
}
