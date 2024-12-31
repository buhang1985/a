package iih.ci.event.ord.listeners.oprsign.ip;

import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.event.pub.IScEventConst;
import iih.ci.event.ord.listeners.IpEnterCommonListener;
import iih.ci.event.ord.listeners.sign.ip.IpSignEnterListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 住院科室手术审批入口监听类
 * @author F
 *
 * @date 2020年5月12日
 *
 * @classpath iih.ci.event.ord.listeners.oprapt.ip.IpOpAptSignEnterListener
 */
public class IpOpAptSignEnterListener extends IpEnterCommonListener{

	/**
	 * 是否满足事件源和事件类型
	 * @param event
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(IpSignEnterListener.class.getSimpleName(), "科室手术审批手术签署入口");
		if(!(IScEventConst.EVENT_SOURCE_SC_OPT_APT.equals(event.getSourceID())&& IScEventConst.EVENT_SC_OPT_APT_CONFIRM.equals(event.getEventType()))){
			return false;
		}
		return true;
	}
	/**
	 * 转换获取到的数据
	 * @param event
	 * @return
	 * @throws BizException
	 */
	@Override
	protected CiOrderDO[] transformData(IBusinessEvent event)throws BizException{
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		if(OrdEventUtil.isEmpty(bizUserObj)){return null;}
		@SuppressWarnings("unchecked")
		List<OptApt4OrmDTO> eventSourceDTO = (List<OptApt4OrmDTO>) bizUserObj.getUserObj();
		if(OrdEventUtil.isEmpty(eventSourceDTO)){return null;}

		String whereStr = CiOrderDODesc.TABLE_ALIAS_NAME + ".id_or in (";
		for(int i=0; i<eventSourceDTO.size(); i++){
			OptApt4OrmDTO itm = eventSourceDTO.get(i);
			if(i == 0){
				whereStr = whereStr + "'" + itm.getId_or() + "'";
			}else{
				whereStr = whereStr + ",'" + itm.getId_or() + "'";
			}
		}
		whereStr = whereStr + ")";
		ICiorderMDORService server = (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ordos = server.find(whereStr, "", FBoolean.FALSE);
		if(OrdEventUtil.isEmpty(ordos)){return null;}
		return ordos;
	}
	/**
	 * 普通住院、急诊留观数据筛选
	 */
	@Override
	protected boolean isIpData(CiOrderDO ordo) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "科室手术审批,筛选普通住院急诊留观数据");
		return true;
	}
	/**
	 * 定义医嘱类型
	 */
	@Override
	public String defineOrdTypeBySdSrvtp(String sd_srvtp) {
		OrdEventLogger.info(this.getClass().getSimpleName(), "科室手术审批手术签署,进入定义医嘱类型");
		return OrdEventUtil.getIpOrdTypeBySdSrvtp(sd_srvtp);
	}
	/**
	 * 科室手术审批根据上面定义的医嘱类型 得到对应的医嘱id 调用发送消息逻辑
	 */
	@Override
	public void fireMessageByOrdType(Hashtable<String, String> htors8ieevent)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "科室手术审批手术签署根据定义的医嘱类型,调用发送消息逻辑");
		OrdEventLogger.info(this.getClass().getSimpleName(), "科室手术审批手术 htors8ieevent:"+htors8ieevent.toString());
		//普通住院手术BS007
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通住院签署-手术id_ors:"+htors8ieevent.get(IOrdEventSources.IP_OPERATION));
		OrdEventUtil.fireSelfDefineMessage(htors8ieevent.get(IOrdEventSources.IP_OPERATION),IOrdEventSources.IP_OP_APT_SIGN,IEventType.TYPE_UPDATE_AFTER);
	}
}
