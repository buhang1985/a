package iih.ci.event.ord.listeners.revert.op;

import iih.ci.event.ord.listeners.OpEnterCommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 门诊撤回入口监听类
 * @author F
 *
 * @date 2019年9月11日上午11:35:41
 *
 * @classpath iih.ci.event.ord.listeners.revert.op.OpRevertEnterListener
 */
public abstract class OpRevertEnterListener extends OpEnterCommonListener{

	/**
	 * 是否满足事件源和事件类型
	 * @param event
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(OpRevertEnterListener.class.getSimpleName(), "门诊撤回入口监听");
		if(!(IOrdEventSources.OP_REVERT_ENTER.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))){
			return false;
		}
		return true;
	}
	/**
	 * 转换获取到的数据
	 */
	@Override
	public CiOrderDO[] transformData(IBusinessEvent event)throws BizException{
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs)){return null;}
		CiOrderDO[] ors=getOrdInfo8Status(newObjs);
		return ors;
	}

	/**
	 * 是否为特定医嘱判断
	 * 用户可重写该方法
	 * 判断逻辑可调用CiOrPubUtils.getCiOrderType(or)
	 * @param ors
	 * @return
	 */
	@Override
	protected boolean isSpecificOrder(CiOrderDO or){
		return true;
	}
	
	/**
	 * 按医嘱状态过滤检查
	 * @param ordo
	 * @return
	 */
	@Override
	protected boolean isOrStatusCheck(CiOrderDO ordo) {
		return true;
	}
	
}
