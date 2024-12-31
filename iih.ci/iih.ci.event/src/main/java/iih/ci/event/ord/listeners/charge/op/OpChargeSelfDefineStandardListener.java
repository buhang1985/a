package iih.ci.event.ord.listeners.charge.op;

import java.util.Hashtable;

import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 普通门诊 收费入口标准版
 * @author F
 *
 * @date 2019年9月10日下午5:36:44
 *
 * @classpath iih.ci.event.ord.listeners.charge.op.OpChargeSelfDefineStandardListener
 */
public class OpChargeSelfDefineStandardListener extends OpChargeEnterListener{

	/**
	 * 普通门诊、急诊流水、急诊抢救数据筛选
	 */
	@Override
	protected boolean isOpData(CiOrderDO ordo) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版,筛选普通门诊数据");
		if(OrdEventUtil.isEmpty(ordo.getCode_entp())||!OrdEventUtil.OP.equals(ordo.getCode_entp())) {//普通门诊
			return false;
		}
		return true;
	}
	
	/**
	 * 定义医嘱类型
	 */
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费,进入定义医嘱类型");
		return OrdEventUtil.getOpOrdTypeBySdSrvtp(sd_srvtp);
	}

	/**
	 * 根据定义的医嘱类型触发消息
	 */
	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版 htors8ieevent:"+htors8ieevent.toString());
		//普通门诊收费检查BS002
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版-检查id_ors:"+htors8ieevent.get(IOrdEventSources.OP_RIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_RIS), IOrdEventSources.OP_RIS_CHARGE, IEventType.TYPE_UPDATE_AFTER);
		
		//普通门诊收费病理BS452
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版-病理id_ors:"+htors8ieevent.get(IOrdEventSources.OP_PATH));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_PATH), IOrdEventSources.OP_PATH_CHARGE, IEventType.TYPE_UPDATE_AFTER);
				
		//普通门诊收费检验BS006
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版-检验id_ors:"+htors8ieevent.get(IOrdEventSources.OP_LIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_LIS), IOrdEventSources.OP_LIS_CHARGE, IEventType.TYPE_UPDATE_AFTER);
		
		//普通门诊收费治疗BS303 治疗以后不发消息在收费时
//		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版-治疗id_ors:"+htors8ieevent.get(IOrdEventSources.OP_TREAT));
//		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_TREAT), IOrdEventSources.OP_TREAT_CHARGE, IEventType.TYPE_UPDATE_AFTER);
		
		//普通门诊收费手术BS007(现在没有手术收费这一说 这一版先做出来 先注释掉)
//		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊收费标准版-手术id_ors:"+htors8ieevent.get(IOrdEventSources.OP_OPERATION));
//		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_OPERATION), IOrdEventSources.OP_OP_CHARGE, IEventType.TYPE_UPDATE_AFTER);
		
	}

}
