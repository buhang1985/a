package iih.ci.ord.s.listener;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrCancelCheckListener;
import iih.ci.ord.pub.listener.AbstractOrSignCancelListener;
import iih.ci.ord.pub.listener.AbstractOrSignListener;
import iih.ci.ord.pub.listener.ICiEventConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 会诊医嘱自动作废确认操作
 * @author zhangwq
 *
 */
public class OrdConsCancelListener extends AbstractOrSignCancelListener {
	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		if(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS.equals(or.getSd_srvtp())){
			return true;
		}
		return false;
	}

	@Override
	protected void doYourActionAfterOrSignCancel(CiOrderDO[] ors) throws BizException {
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
				ciOrderDO.setFg_chk_canc(FBoolean.TRUE);
				ciOrderDO.setSd_su_or("80");
				ciOrderDO.setSd_su_mp("0");
				ciOrderDO.setDt_chk_canc(CiOrdAppUtils.getServerDateTime());
			}
			new DAFacade().updateDOArray(ors, new String[]{CiOrderDO.FG_CHK_CANC,CiOrderDO.SD_SU_OR,CiOrderDO.SD_SU_MP,CiOrderDO.DT_CHK_CANC});
			//发送确认事件
			CiOrdUtils.fireBDEvent(IOrdEventSources.IP_CANCEL_ENTER,IEventType.TYPE_UPDATE_AFTER,ors);
		}
	}
	
}
