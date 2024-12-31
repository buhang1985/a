package iih.ci.event.ord.bps.sign.op.listenerbp;

import iih.ci.event.ord.bps.sign.op.logicbp.OpPathSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpPathApplyDTO;
import iih.ci.ord.iemsg.d.IEOpPathEntDTO;
import iih.ci.ord.iemsg.d.IEOpPathOrdDTO;
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
 *  门诊签署病理标准版BS452
 * @author F
 *
 * @date 2020年1月17日上午10:29:38
 *
 * @classpath iih.ci.event.ord.bps.sign.op.listenerbp.OpPathSignStandardBP
 */
public class OpPathSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-门诊签署病理判断事件源和事件类型");
		if(!(IOrdEventSources.OP_PATH_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-进入组装门诊病理签署数据方法，id_ors:"+firedto.getIdors());
		OpPathSignLogicDealWithBP bp=new OpPathSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-进入门诊病理签署发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-门诊 病理 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			//消息头格式:49101588-X:BS008:01:0:1010000:S001:099:01001
			//消息头的第一位内容为机构编码（49101588-X)，第二位服务名称(BS001),
			//第三位域ID，第四位申请科室遍码，第五位执行科室编码，第六位消息发送者ID,第七位消息分类，第八位收费标志位(0表示未收费，1表示收费)
			//1,2,6应该是集成组负责赋值
			//获取执行科室
			IEOpPathEntDTO entDTO =(IEOpPathEntDTO) baseDTO;
			IEOpPathApplyDTO applyDTO=null;
			IEOpPathOrdDTO ordDTO=null;
			String execDeptString=null;
			//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威  标准版这种判断本不应存在 应该武威去客开，现在留着因为这个版本并没有
			String isWuWei="";
			try {
				isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
			} catch (Exception e) {
				isWuWei="0";//出异常 默认不是武威
			}
			String isFourString="";
		    String iemsgca_code="099";
			if(isWuWei.equals("1")) {//代表武威
				try {
					isFourString=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "BLCG0002");
				} catch (Exception e) {
					isFourString="1";//出异常 默认不执行记账
				}
			}
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(entDTO.getId_applylists())) {
				applyDTO=(IEOpPathApplyDTO) (entDTO.getId_applylists()).get(0);
				if(!OrdEventUtil.isEmpty(applyDTO.getId_orlists())) {
					ordDTO=(IEOpPathOrdDTO) (applyDTO.getId_orlists()).get(0);
					mbx.setOrderNO(ordDTO.getOrderlid());
					if(isFourString.equals("4")) {//执行记账
						iemsgca_code=ordDTO.getIemsgca_code();//集成分类
					}
				}
				execDeptString=applyDTO.getExecutivedept();
				mbx.setApplyNO(applyDTO.getRequestno());
			}
			mbx.setExtendSubId(entDTO.getSd_su_bl());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDeptString,iemsgca_code);//(业务对象,域id,第五位执行科室编码,填写正确的医嘱小分类（第七位消息分类))
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(entDTO.getPatientlid());
			mbx.setEntimes(Integer.parseInt(entDTO.getVisittimes()));
			mbx.setEnNO(entDTO.getVisitno());
			mbx.setApplyUnitId(entDTO.getOrderdept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", entDTO.getVisittypecode());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_PATH, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS452-门诊签署病理 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
