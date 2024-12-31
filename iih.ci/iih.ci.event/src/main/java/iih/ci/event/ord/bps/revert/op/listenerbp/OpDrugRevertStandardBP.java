package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpDrugRevertLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊撤回 处方标准版BS302
 * @author F
 *
 * @date 2019年9月11日下午1:14:53
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpDrugRevertStandardBP
 */
public class OpDrugRevertStandardBP extends OPIPSendIECommonListener {

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-门诊撤回 药品/处方判断事件源和事件类型");
		if (!(IOrdEventSources.OP_DRUG_REVERT.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-进入组装门诊处方撤回数据方法，"
				+ "id_wc_ors:"+firedto.getIdwcors()+",id_herb_ors:"+firedto.getIdherbors()+",iden:"+firedto.getIdent());
		OpDrugRevertLogicDealWithBP bp = new OpDrugRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-进入门诊处方撤回发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-门诊 处方 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			// 获取执行科室
			IEOpPharmOrEnDTO endo = (IEOpPharmOrEnDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ, null, "0");
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.isEmpty(endo.getId_iepharmpreses()) ? OrdEventUtil.DELETE:OrdEventUtil.NEW);
			mbx.setPatientCode(endo.getPatientid());
			mbx.setEntimes(Integer.parseInt(endo.getTimes()));
			mbx.setEnNO(endo.getP_bar_code());
			mbx.setApplyUnitId(endo.getApplydeptcode());// 第四位申请科室遍码
			mbx.setExtendSubId("0");//收费标识
			FMap2 params = new FMap2();
			params.put("VISIT_TYPE", endo.getVisittypecode());// 第三位域ID（就诊类别）
			mbx.setExtras(params);
			userobj.setMsgObj(mbx);
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_DRUG, IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS302-门诊撤回处方 往集成平台每次发送的数据:"+userobj.serializeJson());
		}

	}

}
