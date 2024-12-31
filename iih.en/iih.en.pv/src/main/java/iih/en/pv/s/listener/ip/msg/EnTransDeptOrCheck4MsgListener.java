package iih.en.pv.s.listener.ip.msg;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.listener.TransDeptOrCheckListener;
import iih.en.comm.validator.EnValidator;
import iih.en.pub.IEnSysMsgConst;
import iih.en.pv.inpatient.dto.d.IpSysMsgDTO;
import iih.en.pv.s.listener.ip.msg.bp.AssemblySysMsgBP;
import iih.en.pv.s.listener.ip.msg.bp.FireSysMsgEventBP;
import xap.mw.core.data.BizException;

/**
 * 转科医嘱确认事件监听器
 * 发送消息给住院转出节点
 * 
 * @author liubin
 *
 */
public class EnTransDeptOrCheck4MsgListener extends TransDeptOrCheckListener {
	@Override
	protected void doYourActionAfterOrCheck(CiOrderDO[] ors)
			throws BizException {
		if(EnValidator.isEmpty(ors))
			return;
		AssemblySysMsgBP assemblySysMsg = new AssemblySysMsgBP();
		FireSysMsgEventBP fireSysMsgEvent = new FireSysMsgEventBP(IEnSysMsgConst.MSG_TRANSOUT_DEPT);
		for(CiOrderDO or : ors){
			IpSysMsgDTO ipSysMsg = assemblySysMsg.assemblySysMsgByTransOr(or);
			if(ipSysMsg != null)
				fireSysMsgEvent.exec(ipSysMsg);
		}
	}
}
