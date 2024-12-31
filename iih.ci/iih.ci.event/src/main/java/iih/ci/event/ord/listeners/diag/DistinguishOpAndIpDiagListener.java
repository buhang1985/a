package iih.ci.event.ord.listeners.diag;

import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 门诊住院 诊断 总入口
 * @author F
 *
 * @date 2019年9月18日下午2:54:45
 *
 * @classpath iih.ci.event.ord.listeners.diag.DistinguishOpAndIpDiagListener
 */
public class DistinguishOpAndIpDiagListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "门诊住院 诊断 总入口");
		if(OrdEventUtil.isEmpty(event)) {return;}
		//事件源及事件类型判断    
		if(!(IOrdEventSources.OP_IP_DIAG_ENTER.equals(event.getSourceID()) && IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){return;}
		//转换数据
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs)||newObjs.length != 2){return;}
		CidiagAggDO ret=(CidiagAggDO)newObjs[0];
		CiEnContextDTO ctx=(CiEnContextDTO)newObjs[1];
		if(OrdEventUtil.isEmpty(ret)||OrdEventUtil.isEmpty(ret.getParentDO())||OrdEventUtil.isEmpty(ctx)) {
			return;
		}	
		OrdEventLogger.info(DistinguishOpAndIpDiagListener.class.getSimpleName(), "门诊住院诊断CidiagAggDO ret:"+ret.serializeJson());
		OrdEventLogger.info(DistinguishOpAndIpDiagListener.class.getSimpleName(), "门诊住院诊断CiEnContextDTO ctx:"+ctx.serializeJson());
		//实现自身业务
		doYourAction(ret,ctx);
	}
	/**
	 * 实现自身业务
	 * @param ret
	 * @param ctx
	 * @throws BizException
	 */
	private void doYourAction(CidiagAggDO ret,CiEnContextDTO ctx)throws BizException{
		//区分门诊、急诊流水、急诊抢救，急诊留观、住院诊断 这里只分成两类 一是门诊类(门诊 急诊流水 急诊抢救) 一是住院类(住院 急诊留观)，不细分，含义不一样
		if(ret != null && ret.getParentDO() != null && ret.getParentDO().getCode_entp() != null) {
			String codeEntpString = ret.getParentDO().getCode_entp();
			switch (codeEntpString) {
			case OrdEventUtil.OP://门诊
			case OrdEventUtil.LS://急诊流水
			case OrdEventUtil.QJ://急诊抢救
				OrdEventUtil.fireBDEvent(IOrdEventSources.OP_DIAG_ENTER, IEventType.TYPE_UPDATE_AFTER, ret,ctx);
				break;
			case OrdEventUtil.LG://急诊留观
			case OrdEventUtil.IP://住院
				OrdEventUtil.fireBDEvent(IOrdEventSources.IP_DIAG_ENTER, IEventType.TYPE_UPDATE_AFTER, ret,ctx);
				break;
			default:
				break;
			}
		}
	}

}
