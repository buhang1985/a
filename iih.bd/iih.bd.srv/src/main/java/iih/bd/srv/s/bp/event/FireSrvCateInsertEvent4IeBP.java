package iih.bd.srv.s.bp.event;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.srv.s.bp.iemsg.GetIEIpMsgInfo4OrCateBP;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4LisItemCateBP;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4RisItemCateBP;
import iih.bd.srv.s.bp.iemsg.UtilsIE;
import iih.bd.srv.srvcate.d.SrvCateDO;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 医疗服务类型新增后，进行IE集成平台事件触发监听器 （仅集成平台事件发送用）
 */
public class FireSrvCateInsertEvent4IeBP extends AbstractEvent4IEListener {

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType)
			throws BizException {

		SrvCateDO[] cates = (SrvCateDO[]) newObjs;
		SrvCateDO cate = cates[0];
		String strCode = cate.getSd_srvtp()==null?"":cate.getSd_srvtp().substring(0, 2);
		switch (strCode) {

		case "02":
			fireIEEvent4RisItemCate(cates, eventType);
			break;
		case "03":
			fireIEEvent4LisItemCate(cates, eventType);
			break;

		}

		fireIEEvent4OrCate(cates, eventType);
		
		ServiceFinder.find(ICiCacheClearMainService.class).ClearAll();
		
	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.SRVCATE_ADDDELMOD_EVENT_SOURCEID;
	}

	/**
	 * 事件发送 检验项目分类
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4LisItemCate(SrvCateDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台检验类型医嘱服务数据信息
		GetIEOpMsgInfo4LisItemCateBP bp = new GetIEOpMsgInfo4LisItemCateBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_LISITMCATE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_LISITMCATE, eventType,
//				"01", msgdos);
	}

	/**
	 * 事件发送 检查项目分类
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4RisItemCate(SrvCateDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台检查医嘱服务数据信息
		GetIEOpMsgInfo4RisItemCateBP bp = new GetIEOpMsgInfo4RisItemCateBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_RISITMCATE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_RISITMCATE, eventType,
//				"01", msgdos);
	}

	/**
	 * 事件发送 医嘱分类
	 * 
	 * @param newObjs
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireIEEvent4OrCate(SrvCateDO[] newObjs, String eventType)
			throws BizException {
		// 生成集成平台医嘱类型数据信息
		GetIEIpMsgInfo4OrCateBP bp = new GetIEIpMsgInfo4OrCateBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d,BusiType.NO_CAT,null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);	
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_ORTYPE, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		
		// 触发事件
//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_IP_ORTYPE, eventType,
//				"02", msgdos);
	}

}
