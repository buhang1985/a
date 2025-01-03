package iih.ci.event.ord.listeners.sign.op;

import java.util.Hashtable;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
/**
 *  急诊流水签署标准版 定义医嘱类型以及根据定义的医嘱类型发送事件
 * @author F
 *
 * @date 2019年11月25日下午5:11:45
 *
 * @classpath iih.ci.event.ord.listeners.sign.op.OpFlowSignSelfDefineStandardListener
 */
public class OpFlowSignSelfDefineStandardListener extends OpSignEnterListener{

	/**
	 * 门诊、急诊流水、急诊抢救数据筛选
	 */
	@Override
	protected boolean isOpData(CiOrderDO or){
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版,筛选急诊流水数据");
		if(OrdEventUtil.isEmpty(or.getCode_entp())||!OrdEventUtil.LS.equals(or.getCode_entp())) {//急诊流水
			return false;
		}
		return true;
	}
	
	/**
	 * 定义医嘱类型
	 */
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版,进入定义医嘱类型");
		return OrdEventUtil.getOpOrdTypeBySdSrvtp(sd_srvtp);
	}
	/**
	 * 门诊根据上面定义的医嘱类型 得到对应的医嘱id 调用发送消息逻辑
	 */
	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版 htors8ieevent:"+htors8ieevent.toString());
		// 门诊处方签署BS302 发送所有签署或者签署收费的 new
		String herbIdors=htors8ieevent.get(IOrdEventSources.OP_HERB);
		String wcIdors=htors8ieevent.get(IOrdEventSources.OP_WC);
		String id_ent=htors8ieevent.get(OrdEventUtil.EVENT_IE_ID_ENT);
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-草药id_ors:"+herbIdors+",西药id_ors:"+wcIdors+",id_ent:"+id_ent);
		if(!OrdEventUtil.isEmpty(id_ent)&&(StringUtils.isNotEmpty(herbIdors)||StringUtils.isNotEmpty(wcIdors))) {
			//调用处方/药品
			OrdEventFireDTO dto=new OrdEventFireDTO();
			dto.setIdherbors(herbIdors);
			dto.setIdwcors(wcIdors);
			dto.setIdent(id_ent);
			OrdEventUtil.fireBDEvent(IOrdEventSources.OP_DRUG_SIGN, IEventType.TYPE_UPDATE_AFTER, dto);
		}
		//急诊流水签署检查BS002
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-检查id_ors:"+htors8ieevent.get(IOrdEventSources.OP_RIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_RIS), IOrdEventSources.OP_RIS_SIGN, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊流水签署病理BS452
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-病理id_ors:"+htors8ieevent.get(IOrdEventSources.OP_PATH));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_PATH), IOrdEventSources.OP_PATH_SIGN, IEventType.TYPE_UPDATE_AFTER);
				
		//急诊流水签署检验BS006
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-检验id_ors:"+htors8ieevent.get(IOrdEventSources.OP_LIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_LIS), IOrdEventSources.OP_LIS_SIGN, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊流水签署手术BS007
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-手术id_ors:"+htors8ieevent.get(IOrdEventSources.OP_OPERATION));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_OPERATION), IOrdEventSources.OP_OP_SIGN, IEventType.TYPE_UPDATE_AFTER);
		
		//门诊备血BS008
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-备血id_ors:"+htors8ieevent.get(IOrdEventSources.OP_BT));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_BT), IOrdEventSources.OP_BT_SIGN, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊流水签署用血BS309
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-用血id_ors:"+htors8ieevent.get(IOrdEventSources.OP_BU));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_BU), IOrdEventSources.OP_BU_SIGN, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊流水签署治疗BS303
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-治疗id_ors:"+htors8ieevent.get(IOrdEventSources.OP_TREAT));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_TREAT), IOrdEventSources.OP_TREAT_SIGN, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊流水签署治疗BS318
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水签署标准版-会诊id_ors:"+htors8ieevent.get(IOrdEventSources.OP_CON));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_CON), IOrdEventSources.OP_CON_SIGN, IEventType.TYPE_UPDATE_AFTER);
	}
}
