package iih.ci.event.ord.bps.charge.op.listenerbp;

import iih.ci.event.ord.bps.charge.op.logicbp.OpRisChargeLogicDealWithBP;
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
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊检查收费标准版BS002
 * @author F
 *
 * @date 2019年9月11日下午2:03:42
 *
 * @classpath iih.ci.event.ord.bps.charge.op.listenerbp.OpRisChargeStandardBP
 */
public class OpRisChargeStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-门诊检查收费判断事件源和事件类型");
		if(!(IOrdEventSources.OP_RIS_CHARGE.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-进入组装门诊检查收费数据方法，id_ors:"+firedto.getIdors());
		OpRisChargeLogicDealWithBP bp=new OpRisChargeLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-进入门诊检查收费发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-门诊 检查 收费 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) baseDTO;
			IEOpRisOrDTO ierisordto=null;
			MsgObj mbx=new MsgObj();
			String execDeptString=null;
			String iemsgcaString=null;
			if(!OrdEventUtil.isEmpty(ierisdto.getIerisors())) {
				ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
				execDeptString=ierisordto.getSqd_deptcode();//执行科室
				iemsgcaString=ierisordto.getIemsgca_code();//集成平台小分类
				mbx.setApplyNO(ierisordto.getApply_serial());//申请单号
				mbx.setSpecimenNO(ierisordto.getSamp_bar_code());//标本号
				if(!OrdEventUtil.isEmpty(ierisordto.getId_ierisoritms())) {
					IEOpRisOrItmDTO itmDto = (IEOpRisOrItmDTO)ierisordto.getId_ierisoritms().get(0);
					mbx.setExtendSubId(itmDto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
				}
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDeptString,iemsgcaString);
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ierisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));
			mbx.setEnNO(ierisdto.getP_bar_code());
			mbx.setApplyUnitId(ierisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ierisdto.getVisittypecode());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_RIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS002-门诊收费检查 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
