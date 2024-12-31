package iih.ci.event.ord.bps.sign.op.listenerbp;

import iih.ci.event.ord.bps.sign.op.logicbp.OpLisSignLogicDealWithBP;
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
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 门诊 检验 签署 标准版逻辑BS006
 * @author F
 *
 * @date 2019年8月19日上午10:13:10
 *
 * @classpath iih.ci.event.ord.bps.sign.op.listenerbp.OpLisSignStandardBP
 */
public class OpLisSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊签署检验判断事件源和事件类型");
		if(!(IOrdEventSources.OP_LIS_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入组装门诊检验签署数据方法，id_ors:"+firedto.getIdors());
		OpLisSignLogicDealWithBP bp=new OpLisSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] msgdtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入门诊检验签署发往集成平台方法");
		for(BaseDTO baseDTO:msgdtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊 检验 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) baseDTO;
			IEOpLisOrDTO ielisordto=null;
			IEOpLisOrItmDTO ielisitemdto=null;
			String applyno=null;//申请单编号
			String execDept=null;//执行科室
			String yzno=null;//医嘱编码
			String sampleId=null;//标本号
			String payFlag=null;//收费标识
			//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威
			String isWuWei="";
			try {
				isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
			} catch (Exception e) {
				isWuWei="0";//出异常 默认不是武威
			}
			String isFourString="";
		    String iemsgca_code="099";//集成分类
			if(isWuWei.equals("1")) {//代表武威
				try {
					isFourString=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "BLCG0002");
				} catch (Exception e) {
					isFourString="1";//出异常 默认不执行记账
				}
			}
			if(!OrdEventUtil.isEmpty(ielisdto.getId_ielisors())) {
				ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
				applyno=ielisordto.getJy_applyserial1();
				if(isFourString.equals("4")) {//执行记账
					iemsgca_code=ielisordto.getIemsgca_code();
				}
				if(!OrdEventUtil.isEmpty(ielisordto.getId_ielisoritms())) {
					ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
					execDept=ielisitemdto.getExec_code();
					yzno=ielisitemdto.getYz_no();
					sampleId=ielisitemdto.getSample_id();
					payFlag=ielisitemdto.getPayflag();
				}
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDept,iemsgca_code);
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ielisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ielisdto.getTimes()));
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setApplyNO(applyno);
			mbx.setOrderNO(yzno);
			mbx.setSpecimenNO(sampleId);
			mbx.setExtendSubId(payFlag);// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ielisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ielisdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_LIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊签署检验 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}
