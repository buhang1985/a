package iih.ci.event.ord.listeners;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
/**
 * 住院入口公共监听类
 * @author F
 *
 * @date 2019年9月2日下午5:17:18
 *
 * @classpath iih.ci.event.ord.listeners.IpEnterCommonListener
 */
public abstract class IpEnterCommonListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(IpEnterCommonListener.class.getSimpleName(), "住院、急诊留观 公共入口监听");
		if(OrdEventUtil.isEmpty(event)) {return;}
		//是否满足事件源和事件类型
		if(!isMatchSourceIdAndEventType(event)) return;
		
		//转换获取到的数据
		CiOrderDO[] ors = transformData(event);
		if(OrdEventUtil.isEmpty(ors)) {return;}
		
		//组织数据
		Hashtable<String,Hashtable<String,String>> htors8ieevent=new Hashtable<String,Hashtable<String,String>>();
		Hashtable<String,String> htor=new Hashtable<String,String>();
		orGrpHandle4IeEvent(htors8ieevent,htor,ors);
		
		//发送事件
		fireEvent4Ie8Pv(htors8ieevent,htor);
	}
	/**
	 * 是否满足事件源和事件类型
	 * @param event
	 * @return
	 * @throws BizException
	 */
	public abstract boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException;
	
	/**
	 * 转换获取到的数据
	 * @param event
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO[] transformData(IBusinessEvent event)throws BizException{
		BDCommonEvent dbevent=(BDCommonEvent) event;	
		Object[] newObjs=dbevent.getNewObjs();
		if(OrdEventUtil.isEmpty(newObjs)){return null;}
		//转换数据
		CiOrderDO[] ors=transformNewObjs(newObjs);
		return ors;
	}
	/**
	 * 转换数据为CiorderDo[]
	 * @param newObjs
	 * @return
	 */
	private  CiOrderDO[] transformNewObjs(Object[] newObjs) {
		if(OrdEventUtil.isEmpty(newObjs)) {
			return null;
		}
		CiOrderDO ordo;
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();
		for(Object obj:newObjs) {
			ordo=(CiOrderDO) obj;
			//普通住院、急诊留观数据筛选
			if(!isIpData(ordo))continue;
			rtn.add(ordo);
		}
		if(OrdEventUtil.isEmpty(rtn))return null;
		return rtn.toArray(new CiOrderDO[0]);
	}
	/**
	 * 普通住院、急诊留观数据筛选
	 * @param ordo
	 * @return
	 */
	protected abstract boolean isIpData(CiOrderDO ordo);
	//region-------------------------------------组织数据------------------------------------------------------
	/**
	 * 组织数据
	 * @param htors8ieevent
	 * @param htor
	 * @param ors
	 */
	public void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> htors8ieevent,Hashtable<String, String> htor, CiOrderDO[] ors) {
		for (CiOrderDO ciOrderDO:ors) {
			// 获得分组数据
			orGrpHandle4IeEvent(htors8ieevent, htor, ciOrderDO);
		}
	}
	/**
	 * 医嘱数据组织
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	public void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> htors8ieevent,Hashtable<String,String> htor,CiOrderDO or){
		//事件类型获得
		String ieeventtype=defineOrdTypeBySdSrvtp(or.getSd_srvtp());//OrdEventUtil.getIeEventTypeStr(or.getSd_srvtp());
		//就诊数据组织
		if(!htor.containsKey(or.getId_en())){htor.put(or.getId_en(), or.getId_or());}
		//医嘱数据组织
		orGrpHandle4IeEvent(htors8ieevent,or,ieeventtype);
	}
	/**
	 * 根据sd_srvtp定义医嘱类型
	 * @param sd_srvtp
	 * @return
	 */
    public abstract String defineOrdTypeBySdSrvtp(String sd_srvtp); 
    /**
	 * 组织医嘱数据
	 * @param htors8ieevent
	 * @param htor
	 * @param ors
	 */
	private void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> htors8ieevent,CiOrderDO or,String ieeventtype){
		//有效性校验
		if(OrdEventUtil.isEmpty(ieeventtype))return;
		String id_en=or.getId_en();
		if(htors8ieevent.containsKey(id_en)){
			Hashtable<String,String> ht0=htors8ieevent.get(id_en);
			htEventTypeHandle(ieeventtype,ht0, or);
			htors8ieevent.put(id_en, ht0);
		}else{
			Hashtable<String,String> ht0=new Hashtable<String,String>();
			htEventTypeHandle(ieeventtype,ht0, or);
			htors8ieevent.put(id_en, ht0);
		}
	}
	/**
	 * 按事件类型处理逻辑
	 * @param ieeventtype
	 * @param ht
	 * @param or
	 */
	private void htEventTypeHandle(String ieeventtype,Hashtable<String,String> ht,CiOrderDO or){
		if(ht.containsKey(ieeventtype)){
			String ors=ht.get(ieeventtype)+OrdEventUtil.COMMA_STR+or.getId_or();
			ht.put(ieeventtype, ors);
		}else{
			ht.put(ieeventtype, or.getId_or());
			ht.put(OrdEventUtil.EVENT_IE_ID_ENT, or.getId_en());//就诊信息
		}
	}
	//endregion---------------------组织数据-----------------------------------------------------------------------
	
	
	//region------------------发送事件--------------------------------------------------------------------------------------
	/**
	 * 发送事件
	 * @param htors8ieevent
	 * @param htor
	 * @throws BizException
	 */
	public void fireEvent4Ie8Pv(Hashtable<String,Hashtable<String,String>> htors8ieevent,Hashtable<String, String> htor)throws BizException{
		//有效性校验 
		if(OrdEventUtil.isEmpty(htors8ieevent))return;//htors8ieevent{('idor','idor1,idor2'),'触发器事件源','idor1,idor2','iden','iden'}
		//参数设置
        Enumeration<String> en1 = htors8ieevent.keys();
        String key="";
        //遍历
        while(en1.hasMoreElements()) {
        	key=en1.nextElement();
        	fireEvent4Ie(htors8ieevent.get(key),htor.get(key));
       }
	}
	/**
	 * 发送事件
	 * @param htors8ieevent
	 * @param id_or
	 * @throws BizException
	 */
	private void fireEvent4Ie(Hashtable<String,String> htors8ieevent,String id_or)throws BizException {
		//发送事件 id_or暂时先不用这个 将逻辑改到后面了
		//通过医嘱类型分类发送消息
		if(OrdEventUtil.isEmpty(htors8ieevent)) {
			return;
		}
		fireMessageByOrdType(htors8ieevent);
	}
	/**
	  * 根据医嘱类型 ,定义所需要发送的消息
	 * @param htors8ieevent
	 * @throws BizException
	 */
	public abstract void fireMessageByOrdType(Hashtable<String, String> htors8ieevent)throws BizException;
	//endregion-------------------发送事件------------------------------------------------------------------------------------
}
