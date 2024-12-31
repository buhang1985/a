package iih.ci.event.ord.listeners.repres.op;

import java.util.Hashtable;

import org.apache.commons.lang.StringUtils;

import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 急诊流水 处方 重新分方入口标准版
 * @author F
 *
 * @date 2019年11月25日下午6:27:45
 *
 * @classpath iih.ci.event.ord.listeners.repres.op.OpFlowRePresSelfDefineStandardListener
 */
public class OpFlowRePresSelfDefineStandardListener extends OpRePresEnterListener{

	/**
	 * 普通门诊、急诊流水、急诊抢救数据筛选
	 */
	@Override
	protected boolean isOpData(CiOrderDO ordo) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水重新分方标准版,筛选急诊流水数据");
		if(OrdEventUtil.isEmpty(ordo.getCode_entp())||!OrdEventUtil.LS.equals(ordo.getCode_entp())) {//急诊流水
			return false;
		}
		return true;
	}
	
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水重新分方,进入定义医嘱类型");
		return OrdEventUtil.getOpOrdTypeBySdSrvtp(sd_srvtp);
	}

	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水重新分方根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水重新分方 htors8ieevent:"+htors8ieevent.toString());
		//急诊流水处方重新分方BS302
		String herbIdors=htors8ieevent.get(IOrdEventSources.OP_HERB);
		String wcIdors=htors8ieevent.get(IOrdEventSources.OP_WC);
		String id_ent=htors8ieevent.get(OrdEventUtil.EVENT_IE_ID_ENT);
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊流水重新分方标准版-草药id_ors:"+herbIdors+",西药id_ors:"+wcIdors+",id_ent:"+id_ent);
		if(!OrdEventUtil.isEmpty(id_ent)&&(StringUtils.isNotEmpty(herbIdors)||StringUtils.isNotEmpty(wcIdors))) {
			//调用重新分方
			OrdEventFireDTO dto=new OrdEventFireDTO();
			dto.setIdherbors(herbIdors);
			dto.setIdwcors(wcIdors);
			dto.setIdent(id_ent);
			OrdEventUtil.fireBDEvent(IOrdEventSources.OP_DRUG_REPRES, IEventType.TYPE_UPDATE_AFTER, dto);
		}
		
	}
}
