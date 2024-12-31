package iih.ci.event.ord.listeners.cancel.ip;

import java.util.Hashtable;

import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 普通住院作废标准版 定义医嘱类型以及根据定义的医嘱类型发送事件
 * @author F
 *
 * @date 2019年9月11日上午10:19:09
 *
 * @classpath iih.ci.event.ord.listeners.cancel.ip.IpCancelSelfDefineStandardListener
 */
public class IpCancelSelfDefineStandardListener extends IpCancelEnterListener{

	/**
	 * 普通住院、急诊留观数据筛选
	 */
	@Override
	protected boolean isIpData(CiOrderDO ordo) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通住院作废标准版,筛选普通住院数据");
		if(OrdEventUtil.isEmpty(ordo.getCode_entp())||!OrdEventUtil.IP.equals(ordo.getCode_entp())) {//普通住院
			return false;
		}
		return true;
	}

	/**
	 * 根据sd_srvtp定义医嘱类型
	 */
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通住院作废,进入定义医嘱类型");
		return IOrdEventSources.IP_CANCEL;
	}
	/**
	 * 根据医嘱类型 ,定义所需要发送的消息
	 */
	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通住院作废根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通住院作废 htors8ieevent:"+htors8ieevent.toString());
		//普通住院作废BS005
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通住院作废id_ors:"+htors8ieevent.get(IOrdEventSources.IP_CANCEL));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_CANCEL), IOrdEventSources.IP_CANCEL_SIGN, IEventType.TYPE_UPDATE_AFTER);
	}

}
