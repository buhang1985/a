package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpBtSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
/**
 * 住院 备血 签署 标准版逻辑BS008
 * @author F
 *
 * @date 2019年8月28日上午11:49:13
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpBtSignStandardBP
 */
public class IpBtSignStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-住院签署备血判断事件源和事件类型");
		if(!(IOrdEventSources.IP_BT_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;	
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-进入组装住院备血签署数据方法，id_ors:"+firedto.getIdors());
		IpBtSignLogicDealWithBP bp=new IpBtSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-进入 住院备血签署 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-住院 备血 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室
			IEOpBtOrEnDTO iebtdto =(IEOpBtOrEnDTO) baseDTO;			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,iebtdto.getExec_code(),iebtdto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(iebtdto.getPatientid());
			mbx.setEntimes(Integer.parseInt(iebtdto.getTimes()));
			mbx.setEnNO(iebtdto.getPbarcode());
			mbx.setApplyNO(iebtdto.getApplyno());
			mbx.setOrderNO(iebtdto.getYz_no());
			mbx.setExtendSubId(iebtdto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebtdto.getApplydept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", iebtdto.getJztype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_PBT, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });	
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS008-住院签署备血 往集成平台每次发送的数据:"+userobj.serializeJson());
		}		
	}

}
