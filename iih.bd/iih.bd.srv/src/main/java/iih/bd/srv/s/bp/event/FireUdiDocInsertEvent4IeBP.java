package iih.bd.srv.s.bp.event;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4DosageBP;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4PoisBP;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4BodyBP;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4PresBP;
import iih.bd.srv.s.bp.iemsg.UtilsIE;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 自定义档案数据新增后，进行IE集成平台事件触发监听器 （仅集成平台事件发送用）
 */
public class FireUdiDocInsertEvent4IeBP extends AbstractEvent4IEListener {

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType)
			throws BizException {

		UdidocDO[] udis = (UdidocDO[]) newObjs;
		if(udis==null||udis.length==0)return;
		UdidocDO udi = udis[0];
		if(udi==null||udi.getId_udidoclist()==null)return;
		switch (udi.getId_udidoclist()) {
		case IBdSrvDictCodeTypeConst.SD_PRES_ID:
			// 发送处方类型集成平台事件
			fireIEEvent4Pres(udis, eventType);
			break;
		case IBdSrvDictCodeTypeConst.SD_BODY_ID:
			// 发送检查部位集成平台事件
			fireIEEvent4Body(udis, eventType);
			break;
		case IBdSrvDictCodeTypeConst.SD_POIS_ID:
			fireIEEvent4Pois(udis, eventType);
			break;
		case IBdSrvDictCodeTypeConst.SD_DOSAGE_ID:
			fireIEEvent4Dosage(udis, eventType);
			break;
		}

	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.UDIDOC_ADDDELMOD_EVENT_SOURCEID;
	}

	/**
	 * 事件发送 处方类型
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4Pres(UdidocDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		GetIEOpMsgInfo4PresBP bp = new GetIEOpMsgInfo4PresBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,"0",null,"0");//"01"
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_PRESTYPE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_PRESTYPE, eventType,
//				"01", msgdos);
	}

	/**
	 * 事件发送 检查部位
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4Body(UdidocDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		GetIEOpMsgInfo4BodyBP bp = new GetIEOpMsgInfo4BodyBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,"0",null,"0");//"01"
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_RISBODYPART, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_RISBODYPART,
//				eventType, "01", msgdos);
	}

	/**
	 * 事件发送 毒痳
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4Pois(UdidocDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		GetIEIpMsgInfo4PoisBP bp = new GetIEIpMsgInfo4PoisBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");//"01"
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_POIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_POIS, eventType, "02",
//				msgdos);
	}

	/**
	 * 事件发送 药品剂型
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4Dosage(UdidocDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台药品剂型数据信息
		GetIEIpMsgInfo4DosageBP bp = new GetIEIpMsgInfo4DosageBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,"0",null,"0");//"02"
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_DOSAGE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_DOSAGE, eventType,
//				"02", msgdos);
	}

}