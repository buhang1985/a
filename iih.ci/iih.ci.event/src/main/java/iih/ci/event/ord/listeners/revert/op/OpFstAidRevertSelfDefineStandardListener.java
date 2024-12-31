package iih.ci.event.ord.listeners.revert.op;

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
 * 急诊抢救撤回标准版 定义医嘱类型以及根据定义的医嘱类型发送事件
 * @author F
 *
 * @date 2019年11月26日上午11:19:32
 *
 * @classpath iih.ci.event.ord.listeners.revert.op.OpFstAidRevertSelfDefineStandardListener
 */
public class OpFstAidRevertSelfDefineStandardListener extends OpRevertEnterListener{

	/**
	 *  普通门诊、急诊抢救、急诊抢救数据筛选
	 */
	@Override
	protected boolean isOpData(CiOrderDO or){
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版,筛选急诊抢救数据");
		if(OrdEventUtil.isEmpty(or.getCode_entp())||!OrdEventUtil.QJ.equals(or.getCode_entp())) {//急诊抢救
			return false;
		}
		return true;
	}
	
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版,进入定义医嘱类型");
		return OrdEventUtil.getOpOrdTypeBySdSrvtp(sd_srvtp);
	}

	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版 htors8ieevent:"+htors8ieevent.toString());
		//急诊抢救撤回处方BS302 发送除了撤回的所有的(收费、未收费) 且new
		String herbIdors=htors8ieevent.get(IOrdEventSources.OP_HERB);
		String wcIdors=htors8ieevent.get(IOrdEventSources.OP_WC);
		String id_ent=htors8ieevent.get(OrdEventUtil.EVENT_IE_ID_ENT);
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-草药id_ors:"+herbIdors+",西药id_ors:"+wcIdors+",id_ent:"+id_ent);
		if(StringUtils.isNotEmpty(herbIdors)||StringUtils.isNotEmpty(wcIdors)) {
			//调用处方/药品
			OrdEventFireDTO dto=new OrdEventFireDTO();
			dto.setIdherbors(herbIdors);
			dto.setIdwcors(wcIdors);
			dto.setIdent(id_ent);
			OrdEventUtil.fireBDEvent(IOrdEventSources.OP_DRUG_REVERT, IEventType.TYPE_UPDATE_AFTER, dto);
		}
		
		//急诊抢救撤回检查BS002
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-检查id_ors:"+htors8ieevent.get(IOrdEventSources.OP_RIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_RIS), IOrdEventSources.OP_RIS_REVERT, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊抢救撤回病理BS452
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-病理id_ors:"+htors8ieevent.get(IOrdEventSources.OP_PATH));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_PATH), IOrdEventSources.OP_PATH_REVERT, IEventType.TYPE_UPDATE_AFTER);
				
		//急诊抢救撤回检验BS006
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-检验id_ors:"+htors8ieevent.get(IOrdEventSources.OP_LIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_LIS), IOrdEventSources.OP_LIS_REVERT, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊抢救撤回手术BS005
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-手术id_ors:"+htors8ieevent.get(IOrdEventSources.OP_OPERATION));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_OPERATION), IOrdEventSources.OP_OP_REVERT, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊抢救撤回治疗BS303
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-治疗id_ors:"+htors8ieevent.get(IOrdEventSources.OP_TREAT));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_TREAT), IOrdEventSources.OP_TREAT_REVERT, IEventType.TYPE_UPDATE_AFTER);
		
		//急诊抢救撤回备血BS008
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-备血id_ors:"+htors8ieevent.get(IOrdEventSources.OP_BT));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_BT), IOrdEventSources.OP_BT_REVERT, IEventType.TYPE_UPDATE_AFTER);

		//急诊抢救撤回用血BS309
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-用血id_ors:"+htors8ieevent.get(IOrdEventSources.OP_BU));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_BU), IOrdEventSources.OP_BU_REVERT, IEventType.TYPE_UPDATE_AFTER);

		//急诊抢救撤回会诊BS318
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊抢救撤回标准版-会诊id_ors:"+htors8ieevent.get(IOrdEventSources.OP_CON));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.OP_CON), IOrdEventSources.OP_CON_REVERT, IEventType.TYPE_UPDATE_AFTER);
	}
}
