package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpRisRevertLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 门诊 检查撤回 标准版BS002
 * @author F
 *
 * @date 2019年9月11日下午1:14:16
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpRisRevertStandardBP
 */
public class OpRisRevertStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-门诊撤回检查 判断事件源和事件类型");
		if(!(IOrdEventSources.OP_RIS_REVERT.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-进入组装 门诊检查撤回数据方法，id_ors:"+firedto.getIdors());
		OpRisRevertLogicDealWithBP bp = new OpRisRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-进入门诊检查撤回发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-门诊 检查 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			String isWuWei="";
			String iemsgca_code="099";
			try {
				isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
			} catch (Exception e) {
				isWuWei="0";//出异常 默认不是武威
			}
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) baseDTO;
			IEOpRisOrDTO ierisordto=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(ierisdto.getIerisors())) {
				ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
				if(isWuWei.equals("1")) {//武威
					iemsgca_code=ierisordto.getIemsgca_code();
				}
				if(!OrdEventUtil.isEmpty(ierisordto.getId_ierisoritms())) {
					IEOpRisOrItmDTO itmDto = (IEOpRisOrItmDTO)ierisordto.getId_ierisoritms().get(0);
					mbx.setExtendSubId(itmDto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
				}
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,ierisordto.getSqd_deptcode(),iemsgca_code);
			mbx.setInteractionCode(OrdEventUtil.DELETE);
			mbx.setPatientCode(ierisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));	
			mbx.setEnNO(ierisdto.getP_bar_code());
			mbx.setApplyNO(ierisordto.getApply_serial());
			mbx.setSpecimenNO(ierisordto.getSamp_bar_code());
			mbx.setApplyUnitId(ierisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ierisdto.getVisittypecode());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_RIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-门诊撤回检查 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
