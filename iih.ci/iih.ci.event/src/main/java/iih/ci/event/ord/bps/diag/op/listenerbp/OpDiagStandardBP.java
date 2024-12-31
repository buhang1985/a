package iih.ci.event.ord.bps.diag.op.listenerbp;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.event.ord.bps.diag.op.logicbp.OpDiagLogicDealWithBP;
import iih.ci.event.ord.listeners.diag.ip.IpDiagEnterListener;
import iih.ci.event.ord.listeners.diag.op.OpDiagEnterListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊 诊断标准版BS301
 * @author F
 *
 * @date 2019年9月18日下午1:59:35
 *
 * @classpath iih.ci.event.ord.bps.diag.op.listenerbp.OpDiagStandardBP
 */
public class OpDiagStandardBP extends OpDiagEnterListener{
	/**
	 * 门诊、急诊流水、急诊抢救数据筛选
	 * @param or
	 * @return
	 */
	public boolean isOpData(CiDiagDO ciDiagDO)throws BizException{
		OrdEventLogger.info(IpDiagEnterListener.class.getSimpleName(), "BS301门诊诊断筛选门诊数据");
		if(!OrdEventUtil.isEmpty(ciDiagDO)&&!OrdEventUtil.isEmpty(ciDiagDO.getCode_entp())&&OrdEventUtil.OP.equals(ciDiagDO.getCode_entp())) {
			return true;
		}
		return false;
	}
	@Override
	public IEOpPvDiagEnDTO[] assemableDate(CidiagAggDO aggDO, CiEnContextDTO ctx) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS301-进入组装门诊诊断数据方法, CidiagAggDO aggDO"
				+ aggDO.serializeJson() + " &&&& CiEnContextDTO ctx:" + ctx.serializeJson());
		OpDiagLogicDealWithBP bp=new OpDiagLogicDealWithBP();
		return bp.IEOpPvDiagEnDTO(aggDO,ctx);
	}

	@Override
	public void sendMessagesToIE(IEOpPvDiagEnDTO[] OpPvDiagDTO) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS301-进入 门诊诊断 发往集成平台方法");
		for (IEOpPvDiagEnDTO d : OpPvDiagDTO) {
			OrdEventLogger.info(this.getClass().getSimpleName(),"BS301-门诊 诊断 IEOpPvDiagEnDTO:" + d.serializeJson() + ",");
			DomainBusinessUserObj buo = new DomainBusinessUserObj(d, BusiType.MZ, "0", "0");
			MsgObj msg = new MsgObj();
			msg.setApplyUnitId(d.getDeptcode());// 第四位申请科室遍码 用的签署科室编码
			msg.setInteractionCode(OrdEventUtil.NEW);
			buo.setMsgObj(msg);
			BusinessEvent event = new BusinessEvent(IOrdEventSources.EVENT_IE_CIDIAG_OP_SIGN,
					IEventType.TYPE_UPDATE_AFTER, buo);
			EventDispatcher.fireEvent(event);
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS301门诊诊断每次发往集成平台数据:"+buo.serializeJson());
		}
	}

}