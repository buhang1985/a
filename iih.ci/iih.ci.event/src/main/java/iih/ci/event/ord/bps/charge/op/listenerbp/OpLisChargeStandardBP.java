package iih.ci.event.ord.bps.charge.op.listenerbp;

import iih.ci.event.ord.bps.charge.op.logicbp.OpLisChargeLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 门诊检验收费标准版BS006
 * @author F
 *
 * @date 2019年9月11日下午2:00:58
 *
 * @classpath iih.ci.event.ord.bps.charge.op.listenerbp.OpLisChargeStandardBP
 */
public class OpLisChargeStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊检验收费判断事件源和事件类型");
		if(!(IOrdEventSources.OP_LIS_CHARGE.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入组装门诊检验收费数据方法，id_ors:"+firedto.getIdors());
		OpLisChargeLogicDealWithBP bp=new OpLisChargeLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入门诊检验收费发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊 检验 收费 msgDtoString:"+baseDTO.serializeJson()+",");
			IEOpLisOrEnDTO ielisdto = (IEOpLisOrEnDTO) baseDTO;
			IEOpLisOrDTO ielisordto = null;
			IEOpLisOrItmDTO ielisitemdto=null;
			String iemsgcaString=null;
			String execDeptString=null;
			String sampleId=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(ielisdto.getId_ielisors())) {
				ielisordto = (IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
				iemsgcaString=ielisordto.getIemsgca_code();//集成分类
				if(!OrdEventUtil.isEmpty(ielisordto.getId_ielisoritms())) {
					ielisitemdto = (IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
					mbx.setExtendSubId(ielisitemdto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
					execDeptString=ielisitemdto.getExec_code();//执行科室
					sampleId = ielisitemdto.getSample_id();//标本号
				}
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDeptString,iemsgcaString);
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setApplyUnitId(ielisdto.getApply_unit());// 第四位申请科室遍码
			mbx.setSpecimenNO(sampleId);
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ielisdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_LIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊收费检验 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
