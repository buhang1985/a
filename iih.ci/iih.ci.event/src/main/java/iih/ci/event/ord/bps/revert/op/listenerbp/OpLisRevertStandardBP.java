package iih.ci.event.ord.bps.revert.op.listenerbp;

import iih.ci.event.ord.bps.revert.op.logicbp.OpLisRevertLogicDealWithBP;
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
 * 门诊检验撤回 标准版BS006
 * @author F
 *
 * @date 2019年9月11日下午1:14:40
 *
 * @classpath iih.ci.event.ord.bps.revert.op.listenerbp.OpLisRevertStandardBP
 */
public class OpLisRevertStandardBP extends OPIPSendIECommonListener{

	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊撤回 检验判断事件源和事件类型");
		if (!(IOrdEventSources.OP_LIS_REVERT.equals(event.getSourceID())
				&& IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))) {
			return false;
		}
		return true;
	}

	@Override
	public BaseDTO[] assembleData(BaseDTO baseDTO) throws BizException {
		OrdEventFireDTO firedto=(OrdEventFireDTO)baseDTO;
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入组装 门诊检验撤回数据方法，id_ors:"+firedto.getIdors());
		OpLisRevertLogicDealWithBP bp=new OpLisRevertLogicDealWithBP();
		return bp.exec(firedto);
	}

	@Override
	public void sendMessagesToIE(BaseDTO[] dtos) throws BizException {
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-进入门诊检验撤回发往集成平台方法");
		for (BaseDTO baseDTO : dtos) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊 检验 撤回 msgDtoString:"+baseDTO.serializeJson()+",");
			//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威  武威撤回时为具体医嘱分类
			String isWuWei="";
			String iemsgca_code="099";
			try {
				isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
			} catch (Exception e) {
				isWuWei="0";//出异常 默认不是武威
			}
			//获取执行科室
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) baseDTO;
			IEOpLisOrDTO ielisordto=null;
			IEOpLisOrItmDTO ielisitemdto=null;
			String execDept=null;
			MsgObj mbx=new MsgObj();
			if(!OrdEventUtil.isEmpty(ielisdto.getId_ielisors())) {
				ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
				if(isWuWei.equals("1")) {//武威
					iemsgca_code=ielisordto.getIemsgca_code();
				}
				if(!OrdEventUtil.isEmpty(ielisordto.getId_ielisoritms())) {
					ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
					execDept=ielisitemdto.getExec_code();
					mbx.setOrderNO(ielisitemdto.getYz_no());
					mbx.setSpecimenNO(ielisitemdto.getSample_id());
					mbx.setExtendSubId(ielisitemdto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
				}
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,execDept,iemsgca_code);
			mbx.setInteractionCode(OrdEventUtil.DELETE);
			mbx.setPatientCode(ielisdto.getPatient_id());
			mbx.setEntimes(Integer.parseInt(ielisdto.getTimes()));
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setApplyNO(ielisordto.getJy_applyserial1());
			mbx.setApplyUnitId(ielisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", ielisdto.getVisittype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdEventUtil.fireEvent(IOrdEventSources.EVENT_IE_CIOR_OP_LIS, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS006-门诊撤回检验 往集成平台每次发送的数据:"+userobj.serializeJson());
		}
		
	}

}
