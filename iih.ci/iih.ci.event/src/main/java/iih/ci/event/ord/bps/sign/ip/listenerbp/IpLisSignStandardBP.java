package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpLisSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;

import java.util.Arrays;
import java.util.List;

import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院 检验 签署 标准版逻辑BS006
 * @author F
 *
 * @date 2019年8月23日下午4:34:18
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpLisSignStandardBP
 */
public class IpLisSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-住院签署检验判断事件源和事件类型");
		if(!(IOrdEventSources.IP_LIS_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入组装住院检验签署数据方法，id_ors:"+firedto.getIdors());
		IpLisSignLogicDealWithBP bp=new IpLisSignLogicDealWithBP();
		BaseDTO[] msgdtos=bp.exec(firedto);
		return msgdtos;
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] msgdtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入 住院检验签署 发往集成平台方法");
		//BS006偶发同一申请单号发送两遍问题，目前无法复现，日志获取分析问题
		StackTraceElement[] mStacks = Thread.currentThread().getStackTrace();
		if(!OrdEventUtil.isEmpty(mStacks)) {
			 OrdEventLogger.info(this.getClass().getSimpleName(),"BS006-进入 住院检验签署 发往集成平台方法-调用堆栈信息-开始"); 
			 for(StackTraceElement s: mStacks){
				 OrdEventLogger.info("类名："+s.getClassName(),"方法名："+s.getMethodName()+"; 行数："+s.getLineNumber()+"; 文件名："+s.getFileName() +"; "+s); 
			 }
			 OrdEventLogger.info(this.getClass().getSimpleName(),"BS006-进入 住院检验签署 发往集成平台方法-调用堆栈信息-结束"); 
		}
		for(BaseDTO baseDTO:msgdtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-住院 检验 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) baseDTO;
			IEOpLisOrDTO ielisordto=null;
			String execDeptString=null;
			IEOpLisOrItmDTO ielisitemdto=null;
			String iemsgcaString=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(ielisdto.getId_ielisors())) {
				ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
				iemsgcaString=ielisordto.getIemsgca_code();
				mbx.setApplyNO(ielisordto.getJy_applyserial1());
				if(!OrdEventUtil.isEmpty(ielisordto.getId_ielisoritms())) {
					ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
					execDeptString=ielisitemdto.getExec_code();
					mbx.setOrderNO(ielisitemdto.getYz_no());
					mbx.setSpecimenNO(ielisitemdto.getSample_id());
					mbx.setExtendSubId(ielisitemdto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
				}
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,execDeptString,iemsgcaString);
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(ielisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ielisdto.getTimes()));
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setApplyUnitId(ielisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ielisdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_LIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-住院签署检验 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
	}

}
