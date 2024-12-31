package iih.ci.event.ord.listeners.sign.ip;

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
 * 急诊留观签署标准版 定义医嘱类型以及根据定义的医嘱类型发送事件
 * @author F
 *
 * @date 2019年11月26日上午11:35:52
 *
 * @classpath iih.ci.event.ord.listeners.sign.ip.IpObsSignSelfDefineStandardListener
 */
public class IpObsSignSelfDefineStandardListener extends IpSignEnterListener{

	/**
	 * 普通住院、急诊留观数据筛选
	 */
	@Override
	protected boolean isIpData(CiOrderDO ordo) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署标准版,筛选急诊留观数据");
		if(OrdEventUtil.isEmpty(ordo.getCode_entp())||!OrdEventUtil.LG.equals(ordo.getCode_entp())) {//急诊留观
			return false;
		}
		return true;
	}
	
	/**
	 * 定义医嘱类型
	 */
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署,进入定义医嘱类型");
		return OrdEventUtil.getIpOrdTypeBySdSrvtp(sd_srvtp);
	}
	/**
	 * 住院根据上面定义的医嘱类型 得到对应的医嘱id 调用发送消息逻辑
	 */
	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署 htors8ieevent:"+htors8ieevent.toString());
		//急诊留观用药BS311
		String wcIdors=htors8ieevent.get(IOrdEventSources.IP_WC);
		String herbIdors=htors8ieevent.get(IOrdEventSources.IP_HERB);
		String id_ent=htors8ieevent.get(OrdEventUtil.EVENT_IE_ID_ENT);
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-西药id_ors:"+wcIdors+",草药id_ors:"+herbIdors+",id_ent:"+id_ent);
		if(StringUtils.isNotEmpty(wcIdors)||StringUtils.isNotEmpty(herbIdors)) {
			//调用用药
			OrdEventFireDTO dto=new OrdEventFireDTO();
			dto.setIdwcors(wcIdors);
			dto.setIdherbors(herbIdors);
			OrdEventUtil.fireBDEvent(IOrdEventSources.IP_DRUG_SIGN, IEventType.TYPE_UPDATE_AFTER, dto);
		}
		//急诊留观检验BS006
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-检验id_ors:"+htors8ieevent.get(IOrdEventSources.IP_LIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_LIS),IOrdEventSources.IP_LIS_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观其他BS305
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-其他id_ors:"+htors8ieevent.get(IOrdEventSources.IP_OTHER));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_OTHER),IOrdEventSources.IP_OTHER_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观检查BS002
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-检查id_ors:"+htors8ieevent.get(IOrdEventSources.IP_RIS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_RIS),IOrdEventSources.IP_RIS_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观病理BS452
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-病理id_ors:"+htors8ieevent.get(IOrdEventSources.IP_PATH));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_PATH), IOrdEventSources.IP_PATH_SIGN, IEventType.TYPE_UPDATE_AFTER);
				
		//急诊留观手术BS007
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-手术id_ors:"+htors8ieevent.get(IOrdEventSources.IP_OPERATION));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_OPERATION),IOrdEventSources.IP_OP_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观会诊BS318
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-会诊id_ors:"+htors8ieevent.get(IOrdEventSources.IP_CON));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_CON),IOrdEventSources.IP_CON_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观备血BS008
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-备血id_ors:"+htors8ieevent.get(IOrdEventSources.IP_BT));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_BT),IOrdEventSources.IP_BT_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观用血BS309
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-用血id_ors:"+htors8ieevent.get(IOrdEventSources.IP_BU));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_BU),IOrdEventSources.IP_BU_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观护理BS304
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-护理id_ors:"+htors8ieevent.get(IOrdEventSources.IP_NS));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_NS),IOrdEventSources.IP_NS_SIGN,IEventType.TYPE_UPDATE_AFTER);
		
		//急诊留观治疗BS303
		OrdEventLogger.info(this.getClass().getSimpleName(), "急诊留观签署-治疗id_ors:"+htors8ieevent.get(IOrdEventSources.IP_TREAT));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_TREAT),IOrdEventSources.IP_TREAT_SIGN,IEventType.TYPE_UPDATE_AFTER);
	}

}