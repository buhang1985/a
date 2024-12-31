package iih.ci.event.ord.bps.sign.ip.listenerbp;

import iih.ci.event.ord.bps.sign.ip.logicbp.IpDrugSignLogicDealWithBP;
import iih.ci.event.ord.listeners.OPIPSendIECommonListener;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEPharmWcOrDTO;
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
 * 住院 用药 签署 标准版逻辑BS311
 * @author F
 *
 * @date 2019年8月29日下午5:06:49
 *
 * @classpath iih.ci.event.ord.bps.sign.ip.listenerbp.IpDrugSignStandardBP
 */
public class IpDrugSignStandardBP extends OPIPSendIECommonListener{

	//任意西药或者草药id
	private String id_or="";
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS311-住院签署 用药医嘱 判断事件源和事件类型");
		if(!(IOrdEventSources.IP_DRUG_SIGN.equals(event.getSourceID())&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}
	
	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
	    if(!OrdEventUtil.isEmpty(firedto.getIdwcors())) {
	    	id_or=firedto.getIdwcors().split(OrdEventUtil.COMMA_STR)[0];
	    }else {
	    	id_or=firedto.getIdherbors().split(OrdEventUtil.COMMA_STR)[0];
		}
	    firedto.setIdor(id_or);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS311-进入组装 住院用药签署 数据方法，"
				+ "id_wc_ors:"+firedto.getIdwcors()+",id_herb_ors:"+firedto.getIdherbors()+",id_or:"+id_or);
		IpDrugSignLogicDealWithBP bp=new IpDrugSignLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS311-进入 住院用药签署 发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS311-住院 用药 签署 msgDtoString:"+baseDTO.serializeJson()+",");
			//获取执行科室（就诊科室）
			IEPharmOrEnDTO endo=(IEPharmOrEnDTO) baseDTO;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.ZY,null,"0");//集成平台服务分类 用药的没法给
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode(OrdEventUtil.NEW);
			mbx.setPatientCode(endo.getPatientid());
			mbx.setEntimes(Integer.parseInt(endo.getAdmiss_times()));
			//收费状态标识
			OrdSrvDO[] ordSrvDOs=null;
			try {
				ordSrvDOs = OrdEventHelper.getOrdSrvDO(id_or);
				if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
					mbx.setExtendSubId(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				mbx.setExtendSubId("");
				e.printStackTrace();
			}
			mbx.setApplyUnitId(endo.getApply_dept_code());//第四位 申请科室取签署科室
			mbx.setEnNO(endo.getPatientseqnum());//就诊号
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", endo.getVisite_type_code());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			userobj.setDeptId(getDepId(endo));
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_NSCHK_DRUG, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS311-住院签署用药 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}
	/**
	 * 获取执行科室编码
	 * @param endo
	 * @return
	 */
	private String getDepId(IEPharmOrEnDTO endo){
		//西药集合
		FArrayList2 wsList = endo.getId_iepharmwcors();
		if(wsList != null && wsList.size() >0){
			IEPharmWcOrDTO wcOrDto = (IEPharmWcOrDTO)wsList.get(0);
			return wcOrDto.getXy_zcy_exe_dept_code();
		}
		FArrayList2 herbList = endo.getId_iepharmors();
		if(herbList != null && herbList.size() >0){
			IEPharmHerbOrDTO herbOrDto = (IEPharmHerbOrDTO)herbList.get(0);
			return herbOrDto.getXy_zcy_exe_dept_code();
		}
		return "";
	}

}
