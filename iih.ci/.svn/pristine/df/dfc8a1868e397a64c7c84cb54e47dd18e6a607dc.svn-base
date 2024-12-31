package iih.ci.ord.s.bp.order.check.tl;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.CiOrSufInfo4ScAptApplBp;
import iih.ci.ord.s.bp.event.FireOrNsCheckEvent4IeBP;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import iih.ci.ord.s.bp.orsms.lis.ip.IpMergeTubeSendToMPBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.MergeTubeSendToMPBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.IEventType;

/**
 *  临床医嘱的签署核对、作废核对、停止核对操作BP
 */
public class CiOrderSCSCheckBP {
	/**
	 * 临床医嘱的核对（签署核对、作废核对、停止核对）
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @param id_emp_second_chk 医嘱确认第二核对人
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_sign_ors,String[] id_canc_ors,String[] id_stop_ors,String id_emp_second_chk,FDateTime dt_chk_stop) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_sign_ors) && CiOrdUtils.isEmpty(id_canc_ors) && CiOrdUtils.isEmpty(id_stop_ors) ){
			
			throw new CiOrOperatorCheckException();
			//return null;
		}
		
		
		//2016-08-19      集成平台事件新增逻辑
		Hashtable<String,Hashtable<String,String>> htors8ieevent=new Hashtable<String,Hashtable<String,String>>();
		Hashtable<String,String> htor=new Hashtable<String,String>();
		String id_or=null;
		String signConfirmMsgString="";
		String stopConfirmMsgString="";
		String cancelConfirmMsgString="";
		List<CiOrderDO> signList=new ArrayList<CiOrderDO>();
		List<CiOrderDO> CancRisAppList = new ArrayList<CiOrderDO>();
		List<CiOrderDO> stopList = new ArrayList<CiOrderDO>();
		List<CiOrderDO> orders=new ArrayList<CiOrderDO>();
		CiOrderDO[] chkOrders = null;
		if(id_sign_ors!=null&&id_sign_ors.length>0){
			CiOrderCheckBP bp=new CiOrderCheckBP();
			chkOrders=bp.exec(id_sign_ors,id_emp_second_chk);
			for (CiOrderDO ciOrderDO : chkOrders) {
				signConfirmMsgString+=(ciOrderDO.serializeJson()+" || ");
				signList.add(ciOrderDO);
				orders.add(ciOrderDO);
				orGrpHandle4IeEvent(htors8ieevent,ciOrderDO,false,"0",htor);//2016-08-19      集成平台事件新增逻辑
			}
			presOutLongOrdersCheckStop(chkOrders,id_emp_second_chk);
		}
		if(id_canc_ors!=null&&id_canc_ors.length>0){
			CiOrderCancChkBP bp=new CiOrderCancChkBP();
			CiOrderDO[] ors=bp.exec(id_canc_ors);
			for (CiOrderDO ciOrderDO : ors) {
				cancelConfirmMsgString+=(ciOrderDO.serializeJson()+" || ");
				CancRisAppList.add(ciOrderDO);
				orders.add(ciOrderDO);
				orGrpHandle4IeEvent(htors8ieevent,ciOrderDO,true,"1",htor);//2016-08-19      集成平台事件新增逻辑
			}
		
		}
		if(id_stop_ors!=null&&id_stop_ors.length>0){
			CiOrderStopChkBP bp=new CiOrderStopChkBP();
			CiOrderDO[] ors=bp.exec(id_stop_ors,dt_chk_stop);
			for (CiOrderDO ciOrderDO : ors) {
				stopConfirmMsgString+=(ciOrderDO.serializeJson()+" || ");
				stopList.add(ciOrderDO);
				orders.add(ciOrderDO);
				orGrpHandle4IeEvent(htors8ieevent,ciOrderDO,true,"2",htor);//2016-08-19      集成平台事件新增逻辑
			}
			
		}
		// 调用预约接口向预约发送删除的手术信息
		CiOrderDO[] ciors = (CiOrderDO[]) CancRisAppList.toArray(new CiOrderDO[CancRisAppList.size()]);
		CiOrSufInfo4ScAptApplBp sufInfo4ScAptApplBp = new CiOrSufInfo4ScAptApplBp();
		sufInfo4ScAptApplBp.sendSugInfo4ScAptAppl(null, ciors);
		CiOrderDO[] rtn=orders.toArray(new CiOrderDO[1]);
	
		//按就诊触发事件 集成平台事件   2016-08-19  新增逻辑       集成平台有问题，暂时注掉 
		//fireEvent4Ie8Pv(htors8ieevent,htor);   
		if(signList!=null && signList.size()>0) {//住院签署入口-集成平台
			OrdBizLogger.info(null, "+++++++++++++++++++护士签署确认所有医嘱数据SignConfrimMsgString++++++++++++++++++:"+signConfirmMsgString);
			String signLiString="";
			for(CiOrderDO ci:signList) {
				signLiString+=(ci+",|,");
			}
			OrdBizLogger.info(null, "+++++++++++++++++++signList拼接++++++++++++++++++:"+signLiString);
			CiOrdUtils.fireBDEvent(IOrdEventSources.OP_IP_SIGN_ENTER,IEventType.TYPE_UPDATE_AFTER,signList.toArray(new CiOrderDO[0]));
		}
		if(CancRisAppList!=null && CancRisAppList.size()>0) {//住院作废入口-集成平台
			OrdBizLogger.info(null, "+++++++++++++++++++护士作废确认所有医嘱数据cancelConfirmMsgString++++++++++++++++++:"+cancelConfirmMsgString);
			CiOrdUtils.fireBDEvent(IOrdEventSources.IP_CANCEL_ENTER,IEventType.TYPE_UPDATE_AFTER,CancRisAppList.toArray(new CiOrderDO[0]));
		}
        if(stopList!=null && stopList.size()>0) {//住院停止入口-集成平台
        	OrdBizLogger.info(null, "+++++++++++++++++++护士停止确认所有医嘱数据stopConfirmMsgString++++++++++++++++++:"+stopConfirmMsgString);
        	CiOrdUtils.fireBDEvent(IOrdEventSources.IP_STOP_ENTER,IEventType.TYPE_UPDATE_AFTER,stopList.toArray(new CiOrderDO[0]));
		}
		//ICiEventConst.CIOR_STATUS_EVENT_SOURCEID   2016-08-26forlc
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,rtn);
		//包含检验合单数据时，发送执行域
		MergeTubeSendToMP(chkOrders);
		OrdBizLogger.info(null, "医嘱确认结束");
		return rtn;
	}
	
	/**
	 * 触发事件
	 * 集成平台事件
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie8Pv(Hashtable<String,Hashtable<String,String>> htors8ieevent,Hashtable<String,String> htor) throws BizException{
		//有效性校验 
		if(CiOrdUtils.isEmpty(htors8ieevent))return;
		
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
	 * 触发事件
	 * 集成平台事件
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie(Hashtable<String,String> htors8ieevent,String id_or) throws BizException{
		FireOrNsCheckEvent4IeBP bp=new FireOrNsCheckEvent4IeBP();
		bp.exec(htors8ieevent,id_or);
	}
	
	/**
	 * 医嘱数据组织
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	private void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> ht,CiOrderDO or,boolean iscancStp,String signStr,Hashtable<String,String> htor){
		String ieeventtype="";
		
		//事件类型获得
		if(iscancStp){ieeventtype=ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CANC_STOP;}
		else{ieeventtype=CiOrdUtils.getIeEventTypeStr(or.getSd_srvtp());}
		
		//就诊数据组织
		if(!htor.containsKey(or.getId_en())){htor.put(or.getId_en(), signStr+or.getId_or());}
		
		//医嘱数据组织
		orGrpHandle4IeEvent(ht,or,ieeventtype);
	}
	
	
	/**
	 * 医嘱数据组织
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> ht,CiOrderDO or,String ieeventtype){
		//有效性校验
		if(CiOrdUtils.isEmpty(ieeventtype))return;
		String id_en=or.getId_en();
		if(ht.containsKey(id_en)){
			Hashtable<String,String> ht0=ht.get(id_en);
			htEventTypeHandle(ieeventtype,ht0, or);
			ht.put(id_en, ht0);
		}else{
			Hashtable<String,String> ht0=new Hashtable<String,String>();
			htEventTypeHandle(ieeventtype,ht0, or);
			ht.put(id_en, ht0);
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
			String ors=ht.get(ieeventtype)+CiOrdUtils.COMMA_STR+or.getId_or();
			ht.put(ieeventtype, ors);
		}else{
			ht.put(ieeventtype, or.getId_or());
		}
	}
	/***
	 * 出院带药医嘱，长期，确认时调用停止确认逻辑
	 * @param ors
	 * @param id_emp_second_chk
	 * @throws BizException
	 */
	private void presOutLongOrdersCheckStop(CiOrderDO[] ors,String id_emp_second_chk) throws BizException{
		if(CiOrdUtils.isEmpty(ors)){
			return;
		}
		List<String> checkStopIds = new ArrayList<String>();
		//出院带药医嘱，医嘱确认时长期医嘱需要调用停止确认逻辑
		for(CiOrderDO order : ors){
			if(FBoolean.TRUE.equals(order.getFg_pres_outp())&&FBoolean.TRUE.equals(order.getFg_long())&&FBoolean.TRUE.equals(order.getFg_stop())){
				checkStopIds.add(order.getId_or());
			}
		}
		if(checkStopIds.size()>0){
			this.exec(null, null, checkStopIds.toArray(new String[0]), id_emp_second_chk,null);
		}
	}
	/**
	 * 住院检验合单同步到执行域
	 * @param ciors
	 * @throws BizException
	 */
	private void MergeTubeSendToMP(CiOrderDO[] ciors) throws BizException {
		if(ciors == null || ciors.length==0){
			return;
		}
		//筛选出检验医嘱
		List<String> orderList = new ArrayList<String>();
		if(ciors != null && ciors.length>0){
			for (CiOrderDO ciOrderDO : ciors) {
				if(StringUtils.isNotEmpty(ciOrderDO.getSd_srvtp())&&ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
					orderList.add(ciOrderDO.getId_or());
				}
			}
		}
		if(orderList.size()>0){
			MergeTubeSendToMPBP bp = new IpMergeTubeSendToMPBP();
			bp.exec(orderList);
		}
	}
}
