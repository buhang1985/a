package iih.ci.event.ord.listeners.cancel.ip;

import java.util.Hashtable;

import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 急诊留观作废标准版 定义医嘱类型以及根据定义的医嘱类型发送事件
 * @author F
 *
 * @date 2019年11月26日上午11:45:18
 *
 * @classpath iih.ci.event.ord.listeners.cancel.ip.IpObsCancelSelfDefineStandardListener
 */
public class IpObsCancelSelfDefineStandardListener extends IpCancelEnterListener{

	/**
	 * 普通住院、急诊留观数据筛选
	 */
	@Override
	protected boolean isIpData(CiOrderDO ordo) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观作废标准版,筛选急诊留观数据");
		if(OrdEventUtil.isEmpty(ordo.getCode_entp())||!OrdEventUtil.LG.equals(ordo.getCode_entp())) {//急诊留观
			return false;
		}
		return true;
	}

	/**
	 * 根据sd_srvtp定义医嘱类型
	 */
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观作废,进入定义医嘱类型");
		return IOrdEventSources.IP_CANCEL;
	}
	/**
	 * 根据医嘱类型 ,定义所需要发送的消息
	 */
	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观作废根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观作废 htors8ieevent:"+htors8ieevent.toString());
		//急诊留观作废BS005
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观作废id_ors:"+htors8ieevent.get(IOrdEventSources.IP_CANCEL));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_CANCEL), IOrdEventSources.IP_CANCEL_SIGN, IEventType.TYPE_UPDATE_AFTER);
	}

}
