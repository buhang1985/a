package iih.sc.apt.s.listener;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.apache.commons.collections.MapUtils;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.sc.apt.s.listener.bp.OpLisRisRefundNewBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 检查检验退费事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 * 
 * @author yzh
 *
 */
public class OpLisRisRefundNewListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OEP_REFUND)
				&& event.getEventType().equals(IBlEventConst.EVENT_TYPE_OEP_REFUND)))
			return;
		// 退费成功的服务项目数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();
		if (newObjs == null)
			return;
		BlPayOepRefundEventDTO refundDTO = getRefundDTOs(newObjs);
		if (refundDTO == null)
			return;
		// List<OpRefund4IpEsDTO[]> pickRefunds = pickRefundSrv(refundDTOs);
		// Hashtable<String, List<OpRefund4IpEsDTO>> hashtable = pickRefundSrv(refundDTO.getActualRefundCgAggData());
		// 费用组数据传递有误，此处为患者的全部医嘱数据，目前费用无法解决，暂用错误数据
		Hashtable<String, List<OpRefund4IpEsDTO>> hashtable = pickRefundSrv(refundDTO.getRedCgData());
		if(MapUtils.isEmpty(hashtable)){
			return;
		}
		// 检查和检验
		lisRisRefundAction(hashtable);
		
	}

	/**
	 * 分拣处方类型
	 * 
	 * @param refundDTOs
	 * @return
	 */
	public Hashtable<String, List<OpRefund4IpEsDTO>> pickRefundSrv(BlcgoepAggDO[] blcgoers) {
		Hashtable<String, List<OpRefund4IpEsDTO>> hashtable = new Hashtable<String, List<OpRefund4IpEsDTO>>();
		OpRefund4IpEsDTO ipesDTO;
		for (BlcgoepAggDO blcgoer : blcgoers) {
			for (BlCgItmOepDO oepDO : blcgoer.getBlCgItmOepDO()) {
				//门诊、急诊流水、急诊抢救数据筛选
				if(!isOpData(oepDO)) continue;
				String presType = oepDO.getCode_applytp();
				//数据转换
				ipesDTO = convrtDTO(blcgoer.getParentDO(), oepDO);
				if (StringUtil.isEmpty(presType)) {
					continue;
				}
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
		return hashtable;
	}

	private boolean isOpData(BlCgItmOepDO oepDO) {
		if(StringUtil.isEmpty(oepDO.getCode_enttp())||!IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(oepDO.getCode_enttp())) {//门诊退费
			return false;
		}
		return true;
	}
	/**
	 * 检查和检验类，组装集成平台的数据，并发送事件
	 * 
	 * @param refundsIpEs
	 * @throws BizException
	 */
	private void lisRisRefundAction(Hashtable<String, List<OpRefund4IpEsDTO>> hashtable) throws BizException {
		OpLisRisRefundNewBP lisRisBp = new OpLisRisRefundNewBP();
		lisRisBp.exec(hashtable);
	}

	
	/*List<OpRefund4IpEsDTO> allDtos=new ArrayList<OpRefund4IpEsDTO>();
	String[] typesArr=types.split(COMMA_STR);
	for(String type:typesArr) {
		List<OpRefund4IpEsDTO> everyDtos=hashtable.get(type);
		if(!isEmpty(everyDtos)) {
			allDtos.addAll(everyDtos);
		}
	}*/
	

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
