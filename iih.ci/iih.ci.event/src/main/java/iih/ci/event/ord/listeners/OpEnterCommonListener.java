package iih.ci.event.ord.listeners;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 门诊公共入口监听类
 * @author F
 *
 * @date 2019年9月4日上午9:57:33
 *
 * @classpath iih.ci.event.ord.listeners.OpEnterCommonListener
 */
public abstract class OpEnterCommonListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(OpEnterCommonListener.class.getSimpleName(), "普通门诊、急诊流水、急诊留观 公共入口监听");
		if(OrdEventUtil.isEmpty(event))return;
		//是否满足事件源和事件类型
		if(!isMatchSourceIdAndEventType(event)) return;
		
		//转换获取到的数据
		CiOrderDO[] ors = transformData(event);
		if (OrdEventUtil.isEmpty(ors)) {return;}
		
		// 医嘱数据组织
		Hashtable<String, String> htors8ieevent = new Hashtable<String, String>(); // 参数定义 //htors8ieevent{('idor','idor1,idor2'),'触发器事件源','idor1,idor2','iden','iden'}
		orGrpHandle4IeEvent(htors8ieevent, ors);
		if(OrdEventUtil.isEmpty(htors8ieevent)) {
			return;
		}
		
		//发送消息
		fireMessageByOrdType(htors8ieevent);
	}
	/**
	 * 是否满足事件源和事件类型
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public abstract boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException;
	
	
	//region-----------------------------转换数据-----------------------------------
	/**
	 * 转换获取到的数据
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] transformData(IBusinessEvent event)throws BizException;

	/**
	 * 筛选 获得签署医嘱信息
	 * @param newObjs
	 * @return
	 */
	protected CiOrderDO[] getOrdInfo8Status(Object[] newObjs){
		CiOrderDO ordo;
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();
		//遍历
		for(Object obj: newObjs ){
			ordo=(CiOrderDO) obj;
			//门诊、急诊流水、急诊抢救数据筛选 ，放最上面 不符合没必要执行下面操作
			if(!isOpData(ordo))continue;
			//是否为下达医嘱
			if(!isOrStatusCheck(ordo))continue;
			//是否为特定类型医嘱
			if(!isSpecificOrder(ordo))continue;
			//加入列表中
			rtn.add(ordo);
		}
		//空判断
		if(OrdEventUtil.isEmpty(rtn))return null;
		//返回值
		return rtn.toArray(new CiOrderDO[0]);
	}
	/**
	 * 是否为特定医嘱判断
	 * 用户可重写该方法
	 * 判断逻辑可调用CiOrPubUtils.getCiOrderType(or)
	 * @param ors
	 * @return
	 */
	protected abstract boolean isSpecificOrder(CiOrderDO or);
	
	/**
	 * 按医嘱状态过滤检查
	 * @param ordo
	 * @return
	 */
	protected abstract boolean isOrStatusCheck(CiOrderDO ordo);
	/**
	 * 门诊、急诊流水、急诊抢救数据筛选
	 * @param or
	 * @return
	 */
	protected abstract boolean isOpData(CiOrderDO or);
	//endregion----------------------------转换数据----------------------------------------------------
	
	//region----------------------------组织数据---------------------------------------------
	/**
	 * 医嘱数据分组组织
	 * 
	 * @param htors8ieevent
	 * @param ors
	 * @return
	 */
	public void orGrpHandle4IeEvent(Hashtable<String, String> htors8ieevent, CiOrderDO[] ors) {
		for (CiOrderDO ciOrderDO:ors) {
			// 获得分组数据
			orGrpHandle4IeEvent(htors8ieevent, ciOrderDO);
		}
		htors8ieevent.put(OrdEventUtil.EVENT_IE_ID_ENT, ors[0].getId_en());
	}
	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or) {//IOrdEventSources.EVENT_IE_CIOR_OP_CANC_STOP;
		String ieeventtype = defineOrdTypeBySdSrvtp(or.getSd_srvtp());//OrdEventUtil.getIeOpEventTypeStr(or.getSd_srvtp());
		orGrpHandle4IeEvent(ht, or, ieeventtype);
	}
	/**
	 *根据sd_srvtp定义医嘱类型
	 * @param sd_srvtp
	 * @return
	 */
    public abstract String defineOrdTypeBySdSrvtp(String sd_srvtp); 
    /**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or, String ieeventtype) {
		// 有效性校验
		if (OrdEventUtil.isEmpty(ieeventtype))
			return;
		if (ht.containsKey(ieeventtype)) {
			String ors = ht.get(ieeventtype) + OrdEventUtil.COMMA_STR + or.getId_or();
			ht.put(ieeventtype, ors);
		} else {
			ht.put(ieeventtype, or.getId_or());
		}
	}
	//endregion--------------------------------组织数据----------------------------------------------------
	
	
	/**
	 * 根据医嘱类型,定义所需发送的消息
	 * @param htors8ieevent
	 * @throws BizException
	 */
	public abstract void fireMessageByOrdType(Hashtable<String, String> htors8ieevent)throws BizException;
}
