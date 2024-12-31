package iih.bl.cg.service.s.event;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;

/**
 * 门诊收退费事件(用于旧收付款逻辑)
 * @author ly 2018/12/14=>2019年1月22日 Copy
 *
 */
public class BlOpPayEvent {

	/**
	 * 门诊收费事件
	 * @param cgAggDos
	 * @param stDO
	 * @param payAggDO
	 * @param incAggDos
	 * @throws BizException
	 */
	public static void invokePay(BlcgoepAggDO[] cgAggDos, BlStOepDO stDO,
			BlpaypatoepAggDO payAggDO, BlincoepAggDO[] incAggDos) throws BizException{
		
		BlPayOepEventDTO eventDto = new BlPayOepEventDTO();
		eventDto.setCgData(cgAggDos);
		eventDto.setStData(stDO);
		eventDto.setPayData(payAggDO);
		eventDto.setIncData(incAggDos);
		
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_OEP_CHARGE,
				IBlEventConst.EVENT_TYPE_OEP_CHARGE, eventDto);
		EventDispatcher.fireEvent(event);
	}
	
	/**
	 * 门诊退费事件
	 * @param oldCgAggDos
	 * @param oldStDO
	 * @param oldPayAggDO
	 * @param oldIncAggDos
	 * @param redCgAggDos
	 * @param redStDO
	 * @param redPayAggDO
	 * @param redIncAggDos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static void invokeRefund(BlPayOepRefundEventDTO eventDto) throws BizException{

		//补充原始结算收付款信息
		if(eventDto.getOldStData().getId_stoep().equals(eventDto.getRedStData().getId_rootst())){
			eventDto.setOriginStData(eventDto.getOldStData());
			eventDto.setOriginPayData(eventDto.getOldPayData());
		}else{
			DAFacade daf = new DAFacade();
			BlStOepDO oriStDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, eventDto.getOldStData().getId_rootst());
			
			BlpaypatoepAggDO oriPayAggDO = new BlpaypatoepAggDO();
			BlPayPatOepDO oriPayDO = (BlPayPatOepDO)daf.findByPK(BlPayPatOepDO.class, oriStDO.getId_paypatoep());
			
			List<BlPayItmPatOepDO> oriPayItmList = (List<BlPayItmPatOepDO>)daf.findByAttrValString(
					BlPayItmPatOepDO.class,BlPayItmPatOepDO.ID_PAYPATOEP, oriStDO.getId_paypatoep(), null);
			
			oriPayAggDO.setParentDO(oriPayDO);
			oriPayAggDO.setBlPayItmPatOepDO(oriPayItmList.toArray(new BlPayItmPatOepDO[0]));
			
			eventDto.setOriginStData(oriStDO);
			eventDto.setOriginPayData(oriPayAggDO);
		}
		
		BusinessEvent event = new BusinessEvent(
				IBlEventConst.EVENT_SOURCE_OEP_REFUND,
				IBlEventConst.EVENT_TYPE_OEP_REFUND, eventDto);
		EventDispatcher.fireEvent(event);
	}
}
