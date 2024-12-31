package iih.bd.srv.s.bp.event;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4DrugNameDictBP;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4OrDictBP;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4LisItemDictBP;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4RisItemDictBP;
import iih.bd.srv.s.bp.iemsg.UtilsIE;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 医疗服务新增后，进行IE集成平台事件触发监听器 （仅集成平台事件发送用）
 */
public class FireMedSrvInsertEvent4IeBP extends AbstractEvent4IEListener {

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType)
			throws BizException {

		MedsrvAggDO[] aggDOs = (MedsrvAggDO[]) newObjs;
		MedsrvAggDO srv = aggDOs[0];

		// if(srv.getParentDO().getFg_bl().booleanValue())
		// return;

		String strCode = srv.getParentDO().getSd_srvtp().substring(0, 2);
		if (strCode.equals(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
			fireIEEvent4DrugNameDict(aggDOs, eventType);// 药品名称字典(住院)
		else {
			fireIEEvent4OrDict(aggDOs, eventType);// 医嘱字典(非药品服务项目)(住院)

			switch (strCode) {

			case IBdSrvDictCodeConst.SD_SRVTP_RIS:
				fireIEEvent4RisItemDict(aggDOs, eventType);// 检查项目字典(门诊)
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_LIS:
				fireIEEvent4LisItemDict(aggDOs, eventType);// 检验项目字典(门诊)
				break;
			}
		}

		ServiceFinder.find(ICiCacheClearMainService.class).ClearAll();
	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.MEDSRV_ADDDELMOD_EVENT_SOURCEID;
	}

	/**
	 * 门诊事件发送 检验项目字典
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4LisItemDict(MedsrvAggDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台检验医嘱服务数据信息
		GetIEOpMsgInfo4LisItemDictBP bp = new GetIEOpMsgInfo4LisItemDictBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_LISITMDICT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
	}

	/**
	 * 门诊事件发送 检查项目字典
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4RisItemDict(MedsrvAggDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台检查医嘱服务数据信息
		GetIEOpMsgInfo4RisItemDictBP bp = new GetIEOpMsgInfo4RisItemDictBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_RISITMDICT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_RISITMDICT, eventType,
//				"01", msgdos);
	}

	/**
	 * 住院事件发送 药品名称字典
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4DrugNameDict(MedsrvAggDO[] newObjs,
			String eventType) throws BizException {
		// 生成集成平台药品名称数据信息
		GetIEIpMsgInfo4DrugNameDictBP bp = new GetIEIpMsgInfo4DrugNameDictBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_DRUGNAMEDICT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_DRUGNAMEDICT,
//				eventType, "02", msgdos);
	}

	/**
	 * 住院事件发送 医嘱字典(非药品服务项目)
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4OrDict(MedsrvAggDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台医嘱字典信息
		GetIEIpMsgInfo4OrDictBP bp = new GetIEIpMsgInfo4OrDictBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_ORDICT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_ORDICT, eventType,
//				"02", msgdos);
	}

}
