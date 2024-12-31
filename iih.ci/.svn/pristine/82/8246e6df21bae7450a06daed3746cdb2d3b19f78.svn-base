package iih.ci.ord.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrSignListener;
import iih.ci.ord.pub.listener.ICiEventConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 会诊医嘱自动核对操作
 * @author zhangwq
 *
 */
public class OrdConsAutoChkListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		FBoolean isAutoChk = FBoolean.FALSE;
		try{
			isAutoChk = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),
					ICiOrdNSysParamConst.SYS_PARAM_CONS_TO_CHECK);
		}catch(Exception ex){
			isAutoChk = FBoolean.FALSE;
		}
		//不用核对时，自动核对
		if(FBoolean.FALSE.equals(isAutoChk)){
			for (CiOrderDO ciOrderDO : ors) {
				ciOrderDO.setFg_chk(FBoolean.TRUE);
				ciOrderDO.setSd_su_or("20");
				ciOrderDO.setDt_chk(CiOrdAppUtils.getServerDateTime());
			}
			new DAFacade().updateDOArray(ors, new String[]{CiOrderDO.FG_CHK,CiOrderDO.SD_SU_OR,CiOrderDO.DT_CHK});
			//发送确认事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,ors);
			//发送确认事件 0169785: 住院医生站下会诊医嘱，没有向平台发送会诊申请医嘱的消息  之前调用的是旧的逻辑
			CiOrdUtils.fireBDEvent(IOrdEventSources.OP_IP_SIGN_ENTER,IEventType.TYPE_UPDATE_AFTER,ors);
		}
	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(or.getCode_entp())&&IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS.equals(or.getSd_srvtp())){
			return true;
		}
		return false;
	}
	
}
