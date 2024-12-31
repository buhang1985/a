package iih.ci.ord.s.ems.mdsstation.order;

import java.util.Arrays;

import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.OrConfirmBP;
import iih.ci.ord.s.ems.meta.StringList;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 医技医嘱确认操作
 * @author zhangwq
 *
 */
public final class MdsOrConfirmBP extends OrConfirmBP {
	public String confirm(CiOrderDO[] szOrderInfo) throws BizException {
		if (szOrderInfo == null || szOrderInfo.length == 0) {
			return null;
		}
		try {
			StringList idList = new StringList();
			for (CiOrderDO ord : szOrderInfo) {
				idList.add(ord.getId_or());
			}
			CiOrderDO[] ciorders = getCiOrderDOs(idList);
			// 确认操作
			ciOrderCheck(Arrays.asList(ciorders));
			//执行科室等于当前开单科室的时候触发消息
			CiOrdUtils.fireBDEvent(IOrdEventSources.OP_IP_SIGN_ENTER,IEventType.TYPE_UPDATE_AFTER, ciorders);
			// 发送医嘱确认更新数据库后置事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciorders);
		} catch (Exception e) {
			return e.getMessage();
		}

		return null;
	}
}
