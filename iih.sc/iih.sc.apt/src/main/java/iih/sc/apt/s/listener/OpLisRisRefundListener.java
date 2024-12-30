package iih.sc.apt.s.listener;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.sc.apt.s.listener.bp.OpLisRisRefundBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 检查检验退费事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 * 
 * @author yzh
 *
 */
public class OpLisRisRefundListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OP_REFUND_FOR_IP)
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER)))
			return;
		// 退费成功的服务项目数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();
		if (newObjs == null)
			return;
		OpRefund4IpEsDTO[] refundDTOs = getRefundDTOs(newObjs);
		if (refundDTOs == null || refundDTOs.length == 0)
			return;
		List<OpRefund4IpEsDTO[]> pickRefunds = pickRefundSrv(refundDTOs);
	
		// 检查和检验
		lisRisRefundAction(pickRefunds.get(1));
		
	}

	


	/**
	 * 检查和检验类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void lisRisRefundAction(OpRefund4IpEsDTO[] refundsIpEs) throws BizException {
		OpLisRisRefundBP lisRisBp = new OpLisRisRefundBP();
		lisRisBp.exec(refundsIpEs);
	}

	/**
	 * 分拣处方类型
	 * 
	 * @param refundDTOs
	 * @return
	 */
	private List<OpRefund4IpEsDTO[]> pickRefundSrv(OpRefund4IpEsDTO[] refundDTOs) {
		List<OpRefund4IpEsDTO> drugs = new ArrayList<OpRefund4IpEsDTO>();// 处方类
		List<OpRefund4IpEsDTO> lisRiss = new ArrayList<OpRefund4IpEsDTO>();// 检查检验类
		List<OpRefund4IpEsDTO> treats = new ArrayList<OpRefund4IpEsDTO>();// 诊疗类
		for (OpRefund4IpEsDTO refund : refundDTOs) {
			String presType = refund.getCode_applytp();
			if (StringUtil.isEmpty(presType)) {
				continue;
			}
			// 药品
			if (presType.equals("01")) {
				drugs.add(refund);
			} else if (presType.equals("02") || presType.equals("03")) {// 检查或检验
				lisRiss.add(refund);
			} else if (presType.equals("04")) {// 诊疗
				treats.add(refund);
			}
		}
		List<OpRefund4IpEsDTO[]> pickSrvs = new ArrayList<OpRefund4IpEsDTO[]>();
		pickSrvs.add(drugs.toArray(new OpRefund4IpEsDTO[0]));
		pickSrvs.add(lisRiss.toArray(new OpRefund4IpEsDTO[0]));
		pickSrvs.add(treats.toArray(new OpRefund4IpEsDTO[0]));
		return pickSrvs;
	}

	/**
	 * 获得事件中的入参DTO
	 * 
	 * @param newObjs
	 * @return
	 */
	private OpRefund4IpEsDTO[] getRefundDTOs(Object newObjs) {
		BusinessUserObj business = (BusinessUserObj) newObjs;
		OpRefund4IpEsDTO[] bloeps = (OpRefund4IpEsDTO[]) business.getUserObj();
		return bloeps;
	}

	
}
