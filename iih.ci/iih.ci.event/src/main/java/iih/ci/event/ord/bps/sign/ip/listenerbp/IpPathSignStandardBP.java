package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpPathSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEIpPathApplyDTO;
import iih.ci.ord.iemsg.d.IEIpPathEntDTO;
import iih.ci.ord.iemsg.d.IEIpPathOrdDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院签署病理标准版BS452
 * @author F
 *
 * @date 2020年1月20日下午1:38:44
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpPathSignStandardBP
 */
public class IpPathSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-住院签署病理判断事件源和事件类型");
		if(!(IOrdEventSources.IP_PATH_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-进入组装住院病理签署数据方法，id_ors:"+firedto.getIdors());
		IpPathSignLogicDealWithBP bp=new IpPathSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-进入住院病理签署发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-住院 病理 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			//消息头格式:49101588-X:BS008:01:0:1010000:S001:099:01001
			//消息头的第一位内容为机构编码（49101588-X)，第二位服务名称(BS001),
			//第三位域ID，第四位申请科室遍码，第五位执行科室编码，第六位消息发送者ID,第七位消息分类，第八位收费标志位(0表示未收费，1表示收费)
			//1,2,6应该是集成组负责赋值
			//获取执行科室
			IEIpPathEntDTO entDTO =(IEIpPathEntDTO) baseDTO;
			IEIpPathApplyDTO applyDTO=null;
			IEIpPathOrdDTO ordDTO=null;
			String execDeptString=null;
		    String iemsgca_code=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(entDTO.getId_applylists())) {
				applyDTO=(IEIpPathApplyDTO) (entDTO.getId_applylists()).get(0);
				if(!OrdEventUtil.isEmpty(applyDTO.getId_orlists())) {
					ordDTO=(IEIpPathOrdDTO) (applyDTO.getId_orlists()).get(0);
					mbx.setOrderNO(ordDTO.getOrderlid());
					iemsgca_code=ordDTO.getIemsgca_code();//集成分类
				}
				execDeptString=applyDTO.getExecutivedept();
				mbx.setApplyNO(applyDTO.getRequestno());
			}
			mbx.setExtendSubId(entDTO.getSd_su_bl());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,execDeptString,iemsgca_code);//(业务对象,域id,第五位执行科室编码,填写正确的医嘱小分类（第七位消息分类))
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(entDTO.getPatientlid());
			mbx.setEntimes(Integer.parseInt(entDTO.getVisittimes()));
			mbx.setEnNO(entDTO.getVisitno());
			mbx.setApplyUnitId(entDTO.getOrderdept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", entDTO.getVisittypecode());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_IP_PATH, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-住院签署病理 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}
}
