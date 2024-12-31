package iih.en.pv.s.listener.ip.msg;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.OutHospOrCheckListener;
import iih.en.comm.validator.EnValidator;
import iih.en.pub.IEnSysMsgConst;
import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;
import iih.en.pv.s.listener.ip.msg.bp.AssemblySysMsgBP;
import iih.en.pv.s.listener.ip.msg.bp.FireSysMsgEventBP;
import xap.mw.core.data.BizException;

/**
 * 出院医嘱确认监听
 * 发送消息给出院节点
 * 
 * @author liubin
 *
 */
public class EnOutHospOrCheck4MsgListener extends OutHospOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors)
			throws BizException {
		if(EnValidator.isEmpty(ors))
			return;
		AssemblySysMsgBP assemblySysMsg = new AssemblySysMsgBP();
		FireSysMsgEventBP fireSysMsgEvent = new FireSysMsgEventBP(IEnSysMsgConst.MSG_OUT_HOSPITAL);
		for(CiOrderDO or : ors){
			IpSysMsgDTO ipSysMsg = assemblySysMsg.assemblySysMsgByOutHospOr(or);
			if(ipSysMsg != null)
				fireSysMsgEvent.exec(ipSysMsg);
		}
	}
}
