package iih.bl.st.s.event;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;

/**
 * 门诊收退费事件
 * @author ly 2018/12/14
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
	 * @param allRefund
	 * @param oldCgAggDos
	 * @param oldStDO
	 * @param oldPayAggDO
	 * @param oldIncAggDos
	 * @param redCgAggDos
	 * @param redStDO
	 * @param redPayAggDO
	 * @param redIncAggDos
	 * @param newCgAggDos
	 * @param newStDO
	 * @param newPayAggDO
	 * @param newIncAggDos
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static void invokeRefund(FBoolean allRefund, BlCgItmOepDO[] actualCgData,
			BlcgoepAggDO[] oldCgAggDos, BlStOepDO oldStDO, BlpaypatoepAggDO oldPayAggDO, BlincoepAggDO[] oldIncAggDos,
			BlcgoepAggDO[] redCgAggDos, BlStOepDO redStDO, BlpaypatoepAggDO redPayAggDO, BlincoepAggDO[] redIncAggDos,
			BlcgoepAggDO[] newCgAggDos, BlStOepDO newStDO, BlpaypatoepAggDO newPayAggDO, BlincoepAggDO[] newIncAggDos) throws BizException{
		
		BlPayOepRefundEventDTO eventDto = new BlPayOepRefundEventDTO();
		eventDto.setFg_allRefund(allRefund);
		eventDto.setOldCgData(oldCgAggDos);
		eventDto.setOldStData(oldStDO);
		eventDto.setOldPayData(oldPayAggDO);
		eventDto.setOldIncData(oldIncAggDos);
		eventDto.setRedCgData(redCgAggDos);
		eventDto.setRedStData(redStDO);
		eventDto.setRedPayData(redPayAggDO);
		eventDto.setRedIncData(redIncAggDos);
		eventDto.setNewCgData(newCgAggDos);
		eventDto.setNewStData(newStDO);
		eventDto.setNewPayData(newPayAggDO);
		eventDto.setNewIncData(newIncAggDos);
		eventDto.setActualRefundCgData(actualCgData);
		
		if(oldStDO.getId_stoep().equals(redStDO.getId_rootst())){
			eventDto.setOriginStData(oldStDO);
			eventDto.setOriginPayData(oldPayAggDO);
		}else{
			DAFacade daf = new DAFacade();
			BlStOepDO oriStDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, redStDO.getId_rootst());
			
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
