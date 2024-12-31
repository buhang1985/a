package iih.ci.event.ord.listeners.refund.op;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
/**
 * 门诊退费入口监听
 * @author F
 *
 * @date 2019年9月16日下午1:36:26
 *
 * @classpath iih.ci.event.ord.listeners.refund.op.OpRefundEnterListener
 */
public abstract class OpRefundEnterListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		OrdEventLogger.info(OpRefundEnterListener.class.getSimpleName(), "普通门诊、急诊流水、急诊抢救退费入口监听");
		// 事件源及事件类型判断
		if (!IBlEventConst.EVENT_SOURCE_OEP_REFUND.equals(event.getSourceID()))
			return;
		// 退费成功的服务项目数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();
		if (OrdEventUtil.isEmpty(newObjs))
			return;
		BlPayOepRefundEventDTO refundDTO = getRefundDTOs(newObjs);
		if (OrdEventUtil.isEmpty(refundDTO))
			return;
		Hashtable<String, List<OpRefund4IpEsDTO>> hashtable = pickRefundSrv(refundDTO.getRedCgData());
		// 触发消息逻辑
		if(OrdEventUtil.isEmpty(hashtable)) {
			return;
		}
		fireMessageByCode_applytp(hashtable);
	}

	/**
	 * 触发消息逻辑 hashtable key(取得code_applytp)值:01处方，02检查，03检验，04诊疗，05?
	 * 
	 * @param hashtable
	 * @throws BizException
	 */
	public abstract void fireMessageByCode_applytp(Hashtable<String, List<OpRefund4IpEsDTO>> hashtable) throws BizException;

	/**
	 * 获得事件中的入参DTO
	 * 
	 * @param newObjs
	 * @return
	 */
	public BlPayOepRefundEventDTO getRefundDTOs(Object newObjs) {
		BusinessUserObj business = (BusinessUserObj) newObjs;
		BlPayOepRefundEventDTO bloeps = (BlPayOepRefundEventDTO) business.getUserObj();
		return bloeps;
	}

	/**
	 * 分拣处方类型
	 * 
	 * @param refundDTOs
	 * @return
	 */
	public Hashtable<String, List<OpRefund4IpEsDTO>> pickRefundSrv(BlcgoepAggDO[] blcgoers) {
		if(blcgoers == null){
			return null;
		}
		Hashtable<String, List<OpRefund4IpEsDTO>> hashtable = new Hashtable<String, List<OpRefund4IpEsDTO>>();
		OpRefund4IpEsDTO ipesDTO;
		for (BlcgoepAggDO blcgoer : blcgoers) {
			for (BlCgItmOepDO oepDO : blcgoer.getBlCgItmOepDO()) {
				OrdEventLogger.info(OpRefundEnterListener.class.getSimpleName(), "BlCgItmOepDO:"+oepDO);
				//门诊、急诊流水、急诊抢救数据筛选
				if(!isOpData(oepDO)) continue;
				String presType = oepDO.getCode_applytp();
				//数据转换
				ipesDTO = convrtDTO(blcgoer.getParentDO(), oepDO);
				if (OrdEventUtil.isEmpty(presType)) {
					continue;
				}
				OrdEventLogger.info(OpRefundEnterListener.class.getSimpleName(), "Code_applytp:"+presType);
				if (hashtable.containsKey(presType)) {
					List<OpRefund4IpEsDTO> list = hashtable.get(presType);
					list.add(ipesDTO);
					hashtable.put(presType, list);
				} else {
					List<OpRefund4IpEsDTO> list = new ArrayList<OpRefund4IpEsDTO>();
					list.add(ipesDTO);
					hashtable.put(presType, list);
				}
			}
		}
		OrdEventLogger.info(OpRefundEnterListener.class.getSimpleName(), "普通门诊、急诊流水、急诊抢救退费hashtable:"+hashtable);
		return hashtable;
	}
	protected abstract boolean isOpData(BlCgItmOepDO oepDO);
	/**
	 * 数据转换
	 * @param blcgoepdo
	 * @param oepDO
	 * @return
	 */
	private OpRefund4IpEsDTO convrtDTO(BlCgOepDO blcgoepdo, BlCgItmOepDO oepDO) {
		OpRefund4IpEsDTO ipesDTO = new OpRefund4IpEsDTO();
		ipesDTO.setCode_apply(oepDO.getCode_apply());
		ipesDTO.setCode_applytp(oepDO.getCode_applytp());
		// ipesDTO.setCode_pres();
		ipesDTO.setDt_refund(blcgoepdo.getDt_cg());
		ipesDTO.setId_cgitm(oepDO.getId_cgitmoep());
		ipesDTO.setId_emp_refund(blcgoepdo.getId_emp_cg());
		ipesDTO.setId_or(oepDO.getId_or());
		ipesDTO.setId_orsrv(oepDO.getId_orsrv());
		ipesDTO.setId_pat(blcgoepdo.getId_pat());
		ipesDTO.setId_pres(oepDO.getId_pres());
		ipesDTO.setQuan(oepDO.getQuan());
		ipesDTO.setReason(oepDO.getNote());
		// ipesDTO.setSd_prestp(Sd_prestp);
		return ipesDTO;
	}
}
