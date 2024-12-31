package iih.bd.srv.s.bp.event;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.pub.IBdSrvEventConst;
import iih.bd.srv.pub.listener.AbstractEvent4IEListener;
import iih.bd.srv.s.bp.iemsg.GetIEOpMsgInfo4DiagDictBP;
import iih.bd.srv.s.bp.iemsg.UtilsIE;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 医疗服务诊断新增后，进行IE集成平台事件触发监听器 （仅集成平台事件发送用）
 */
public class FireDiagDefInsertEvent4IeBP extends AbstractEvent4IEListener {

	@Override
	protected void sendIEMsg(Object[] newObjs, String eventType) throws BizException {

		DiagdefAggDO[] aggDOs = (DiagdefAggDO[]) newObjs;

		fireIEEvent4DiagDict(aggDOs, eventType);

	}

	@Override
	protected String getEventSourceid() throws BizException {

		return IBdSrvEventConst.DIAGDEF_ADDDELMOD_EVENT_SOURCEID;
	}

	/**
	 * MS035 ： 门诊诊断字典 </br>
	 * 诊断定义维护 事件发送 门诊诊断
	 * 
	 * @param newObjs
	 * @param eventType
	 * @throws BizException
	 */
	private void fireIEEvent4DiagDict(DiagdefAggDO[] newObjs, String eventType) throws BizException {

		// 生成集成平台诊断数据信息
		GetIEOpMsgInfo4DiagDictBP bp = new GetIEOpMsgInfo4DiagDictBP();
		BaseDTO[] msgdos = bp.exec(newObjs, eventType);
		if (ArrayUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, BusiType.NO_CAT, null, "0");
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode("new");
			userobj.setMsgObj(mbx);
			UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_DIAGDICT, IEventType.TYPE_UPDATE_AFTER,
					new BaseDTO[] { userobj });

		}

		// 触发事件
		//		UtilsIE.FireEvent(IBdSrvIEEventConst.EVENT_IE_OP_DIAGDICT, eventType,
		//				"01", msgdos);

	}

}
