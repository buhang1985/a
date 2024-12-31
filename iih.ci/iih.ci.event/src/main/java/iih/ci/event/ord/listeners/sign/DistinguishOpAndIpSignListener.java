package iih.ci.event.ord.listeners.sign;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 门诊 住院 签署 总入口监听
 * @author F
 *
 * @date 2019年8月19日上午10:08:36
 *
 * @classpath iih.ci.event.ord.listeners.sign.DistinguishOpAndIpSignListener
 */
public class DistinguishOpAndIpSignListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(DistinguishOpAndIpSignListener.class.getSimpleName(), "门诊住院 签署 总入口");
//		StackTraceElement[] mStacks = Thread.currentThread().getStackTrace();
//		if(!OrdEventUtil.isEmpty(mStacks)) {
//			 OrdEventLogger.info(this.getClass().getSimpleName(), "签署总入口调用堆栈信息");
//			for(StackTraceElement s: mStacks){
//			     OrdEventLogger.info("类名："+s.getClassName(), "方法名："+s.getMethodName()+"; 行数："+s.getLineNumber()+"; 文件名："+s.getFileName()+"; "+s);
//			  }
//		}
		if(OrdEventUtil.isEmpty(event)) {return;}
		//事件源及事件类型判断    
		if(!(IOrdEventSources.OP_IP_SIGN_ENTER.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){return;}
		//签署成功的医嘱数据及空判断逻辑
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs)){return;}
		String allString="";
		CiOrderDO ord;
		for(Object object:newObjs) {
			ord=(CiOrderDO) object;
			allString+=(ord.serializeJson()+", ");
		}
		OrdEventLogger.info(this.getClass().getSimpleName(), "获取到的所有签署数据:"+allString);
		//区分门诊(普通门诊、急诊流水、急诊抢救)、住院(普通住院、急诊留观)数据
		String[] opCodeEntpArr= {OrdEventUtil.OP,OrdEventUtil.LS,OrdEventUtil.QJ};
		String[] IpCodeEntpArr= {OrdEventUtil.IP,OrdEventUtil.LG};
		CiOrderDO[] opCiOrderDOs=selectOrderDOsByCodeEntp(newObjs, opCodeEntpArr);
		CiOrderDO[] ipCiOrderDOs=selectOrderDOsByCodeEntp(newObjs, IpCodeEntpArr);
		//调用门诊或者住院
		transferOp$Ip(opCiOrderDOs,ipCiOrderDOs);
	}
	/**
	 * 调用门诊或者住院
	 * @param opCiOrderDOs
	 * @param ipCiOrderDOs
	 * @throws BizException
	 */
	private void transferOp$Ip(CiOrderDO[] opCiOrderDOs,CiOrderDO[] ipCiOrderDOs)throws BizException{
		if(!OrdEventUtil.isEmpty(opCiOrderDOs)) {
			//调用门诊逻辑
			OrdEventUtil.fireBDEvent(IOrdEventSources.OP_SIGN_ENTER, IEventType.TYPE_UPDATE_AFTER, opCiOrderDOs);
		}
		if(!OrdEventUtil.isEmpty(ipCiOrderDOs)) {
			//调用住院逻辑
			OrdEventUtil.fireBDEvent(IOrdEventSources.IP_SIGN_ENTER, IEventType.TYPE_UPDATE_AFTER, ipCiOrderDOs);
		}
	}
	/**
	 * 通过就诊类型区分门诊 住院
	 * @param ors
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO[] selectOrderDOsByCodeEntp(Object[] ors,String[] codeEntp)throws BizException{
		if(OrdEventUtil.isEmpty(ors)||OrdEventUtil.isEmpty(codeEntp)) {
			return null;
		}
		CiOrderDO orderDO;
		List<CiOrderDO> ciOrderDOs=new ArrayList<CiOrderDO>();
		for(Object object:ors) {
			orderDO=(CiOrderDO) object;
			for(String code:codeEntp) {
				if(StringUtils.isNotEmpty(orderDO.getCode_entp())&&code.equals(orderDO.getCode_entp())) {
					ciOrderDOs.add(orderDO);
				}
			}
		}
		if(!OrdEventUtil.isEmpty(ciOrderDOs)) {
			return ciOrderDOs.toArray(new CiOrderDO[0]);
		}
		return null;
	}
	
}

