package iih.ci.ord.s.bp.event;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoRefund4LisRisBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoRefund4PresBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfoRefund4TreatBP;
import xap.ip.cfg.XipCfg;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 检查检验退费事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 * 
 * @author 张万青
 *
 */
public class FireOpOrLisRisRefundEvent4IeListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		// 事件源及事件类型判断
		if (!event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OEP_REFUND))
			return;
		// 退费成功的服务项目数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();
		if (newObjs == null)
			return;
		BlPayOepRefundEventDTO refundDTO = getRefundDTOs(newObjs);
		if (refundDTO == null)
			return;
		List<OpRefund4IpEsDTO[]> pickRefunds = pickRefundSrv(refundDTO.getRedCgData());
		// 处方类
		presRefundAction(pickRefunds.get(0));
		// 检查和检验
		lisRisRefundAction(pickRefunds.get(1));
		// 诊疗类
		treatRefundAction(pickRefunds.get(2));
	}

	/**
	 * 诊疗类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void treatRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		 GetIEOpMsgInfoRefund4TreatBP presBp = new GetIEOpMsgInfoRefund4TreatBP();
		 BaseDTO[] msgdos = presBp.exec(refundsIpEs);
		 if (CiOrdUtils.isEmpty(msgdos))
		 return;
		 // 触发事件
		 for (BaseDTO d : msgdos) {
		 // 获取执行科室
		 IEOpTreatOrEnDTO ierisdto = (IEOpTreatOrEnDTO) d;
		 DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",
		 ierisdto.getExec_sn(),
		 "0");
		 MsgObj mbx = new MsgObj();
		 mbx.setInteractionCode("renew");
		 userobj.setMsgObj(mbx);
		 CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT,
		 IEventType.TYPE_UPDATE_AFTER,
		 new BaseDTO[] { userobj });
		 }
//		String id_ors = getIdOrs(refundsIpEs);
//		// 生成集成平台药品医嘱服务数据信息
//		GetIEOpMsgInfo4TreatNBP bp = new GetIEOpMsgInfo4TreatNBP();
//		BaseDTO[] msgdos = bp.exec(id_ors);
//		if (CiOrdUtils.isEmpty(msgdos))
//			return;
//		for (BaseDTO d : msgdos) {
//			// 获取执行科室
//			IEOpTreatOrEnDTO ielisdto = (IEOpTreatOrEnDTO) d;
//			IEOpTreatOrDTO ielisordto = (IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);
//			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01", ielisordto.getExec_sn(), "099");
//			MsgObj mbx = new MsgObj();
//			mbx.setInteractionCode("delete");
//			userobj.setMsgObj(mbx);
//			CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT, IEventType.TYPE_UPDATE_AFTER,
//					new BaseDTO[] { userobj });
//		}
	}

	/**
	 * 药品类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void presRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		GetIEOpMsgInfoRefund4PresBP presBp = new GetIEOpMsgInfoRefund4PresBP();
		BaseDTO[] msgdos = presBp.exec(refundsIpEs);
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			// 获取执行科室
			IEOpPharmOrEnDTO ierisdto = (IEOpPharmOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01", ierisdto.getDept_code(), "0");
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode("renew");
			userobj.setMsgObj(mbx);
			CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG, IEventType.TYPE_UPDATE_AFTER,
					new BaseDTO[] { userobj });
		}
	}

	/**
	 * 检查和检验类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void lisRisRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		GetIEOpMsgInfoRefund4LisRisBP lisRisBp = new GetIEOpMsgInfoRefund4LisRisBP();
		// 将传入参数进行分类 检查检验类
		BaseDTO[] msgdos = lisRisBp.exec(refundsIpEs);
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			// 获取执行科室
			IEOpOrCancStpEnDTO ierisdto = (IEOpOrCancStpEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01", ierisdto.getExec_unit(),
					ierisdto.getIemsgca_code());
			MsgObj mbx = new MsgObj();
			mbx.setInteractionCode("cancel");
			userobj.setMsgObj(mbx);
			//检查、检验退费发送消息
			CiOrdUtils.fireEvent(ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP, IEventType.TYPE_UPDATE_AFTER,
					new BaseDTO[] { userobj });
		}
	}

	/**
	 * 分拣处方类型
	 * 
	 * @param refundDTOs
	 * @return
	 */
	private List<OpRefund4IpEsDTO[]> pickRefundSrv(BlcgoepAggDO[] blcgoers) {
		List<OpRefund4IpEsDTO> drugs = new ArrayList<OpRefund4IpEsDTO>();// 处方类
		List<OpRefund4IpEsDTO> lisRiss = new ArrayList<OpRefund4IpEsDTO>();// 检查检验类
		List<OpRefund4IpEsDTO> treats = new ArrayList<OpRefund4IpEsDTO>();// 诊疗类
		OpRefund4IpEsDTO ipesDTO;
		for (BlcgoepAggDO blcgoer : blcgoers) {
			for(BlCgItmOepDO oepDO : blcgoer.getBlCgItmOepDO()){
				String presType = oepDO.getCode_applytp();
				ipesDTO = convrtDTO(blcgoer.getParentDO(),oepDO);
				if (CiOrdUtils.isEmpty(presType)) {
					continue;
				}
				
				if (presType.equals("01")) {// 药品
					drugs.add(ipesDTO);
				} else if (presType.equals("02") || presType.equals("03")) {// 检查或检验
					lisRiss.add(ipesDTO);
				} else if (presType.equals("04")) {// 诊疗
					treats.add(ipesDTO);
				}
			}
		}
		List<OpRefund4IpEsDTO[]> pickSrvs = new ArrayList<OpRefund4IpEsDTO[]>();
		pickSrvs.add(drugs.toArray(new OpRefund4IpEsDTO[0]));
		pickSrvs.add(lisRiss.toArray(new OpRefund4IpEsDTO[0]));
		pickSrvs.add(treats.toArray(new OpRefund4IpEsDTO[0]));
		return pickSrvs;
	}

	private OpRefund4IpEsDTO convrtDTO(BlCgOepDO blcgoepdo,BlCgItmOepDO oepDO){
		OpRefund4IpEsDTO ipesDTO = new OpRefund4IpEsDTO();
		ipesDTO.setCode_apply(oepDO.getCode_apply());
		ipesDTO.setCode_applytp(oepDO.getCode_applytp());
		//ipesDTO.setCode_pres();
		ipesDTO.setDt_refund(blcgoepdo.getDt_cg());
		ipesDTO.setId_cgitm(oepDO.getId_cgitmoep());
		ipesDTO.setId_emp_refund(blcgoepdo.getId_emp_cg());
		ipesDTO.setId_or(oepDO.getId_or());
		ipesDTO.setId_orsrv(oepDO.getId_orsrv());
		ipesDTO.setId_pat(blcgoepdo.getId_pat());
		ipesDTO.setId_pres(oepDO.getId_pres());
		ipesDTO.setQuan(oepDO.getQuan());
		ipesDTO.setReason(oepDO.getNote());
		//ipesDTO.setSd_prestp(Sd_prestp);
		
		return ipesDTO;
	}
	/**
	 * 获得事件中的入参DTO
	 * 
	 * @param newObjs
	 * @return
	 */
	private BlPayOepRefundEventDTO getRefundDTOs(Object newObjs) {
		BusinessUserObj business = (BusinessUserObj) newObjs;
		BlPayOepRefundEventDTO bloeps = (BlPayOepRefundEventDTO) business.getUserObj();
		return bloeps;
	}

	/**
	 * 获得医嘱id_or，以，隔开
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	private String getIdOrs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idors = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idors += es.getId_or() + CiOrdUtils.COMMA_STR;
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
}
