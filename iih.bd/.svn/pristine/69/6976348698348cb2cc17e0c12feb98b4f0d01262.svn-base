package iih.bd.pp.baseprisrv.s.bp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import iih.bd.base.utils.DoUtils;
import iih.bd.pp.baseprisrv.d.BaseprisrvAggDO;
import iih.bd.pp.baseprisrv.d.PriSrvDO;
import iih.bd.pp.baseprisrv.d.SrvPriDO;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.listener.d.PriSrvEventDTO;
import iih.bd.pp.medsrvrealpriceqry.i.IMedSrvRealPriceQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 
 * 基础价表事件处理器
 * 
 * @author hao_wu
 * @date 2020年3月13日
 *
 */
public class BasePriSrvEventHandler {

	/**
	 * 发送事件
	 * 
	 * @param basePriSrvs
	 * @param priceMap
	 * @param eventType
	 * @throws BizException
	 */
	public void fireEvent(MedSrvDO[] basePriSrvs, Map<String, FDouble> priceMap, String eventType) throws BizException {
		PriSrvEventDTO[] eventDtos = getMedSrvEventDTOs(basePriSrvs, priceMap, eventType);
		fireEvent(eventDtos, eventType);
	}

	/**
	 * 发送事件
	 * 
	 * @param basePriSrvs
	 * @param priceFMap
	 * @param eventType
	 * @throws BizException
	 */
	public void fireEvent(MedSrvDO[] basePriSrvs, FMap priceFMap, String eventType) throws BizException {
		Map<String, FDouble> priceMap = new HashMap<String, FDouble>(priceFMap.size());
		for (String medSrvId : priceFMap.keySet()) {
			priceMap.put(medSrvId, (FDouble) priceFMap.get(medSrvId));
		}
		fireEvent(basePriSrvs, priceMap, eventType);
	}

	/**
	 * 发送事件
	 * 
	 * @param basePriSrv
	 * @param price
	 * @param eventType
	 * @throws BizException
	 */
	public void fireEvent(MedSrvDO basePriSrv, FDouble price, String eventType) throws BizException {
		Map<String, FDouble> priceMap = new HashMap<String, FDouble>(1);
		priceMap.put(basePriSrv.getId_srv(), price);
		fireEvent(new MedSrvDO[] { basePriSrv }, priceMap, eventType);
	}

	/**
	 * 发送事件
	 * 
	 * @param aggs
	 * @param eventType
	 * @throws BizException
	 */
	public void fireEvent(BaseprisrvAggDO[] aggs, String eventType) throws BizException {
		PriSrvEventDTO[] eventDtos = getMedSrvEventDTOs(aggs, eventType);
		fireEvent(eventDtos, eventType);
	}

	/**
	 * 发送事件
	 * 
	 * @param medSrvDos
	 * @param eventType
	 * @throws BizException
	 */
	public void fireEvent(MedSrvDO[] medSrvDos, String eventType) throws BizException {
		String[] srvIds = DoUtils.getAttrValArr(medSrvDos, MedSrvDO.ID_SRV, String.class);
		// 查询价格
		IMedSrvRealPriceQryService medSrvRealPriceQryService = ServiceFinder.find(IMedSrvRealPriceQryService.class);
		FMap priMap = medSrvRealPriceQryService.findMedSrvRefPriMapByIds(srvIds);
		fireEvent(medSrvDos, priMap, eventType);

	}

	/**
	 * 发送集成平台消息
	 * 
	 * @param eventDtos
	 * @param eventType
	 * @throws BizException
	 */
	private void fireEvent(PriSrvEventDTO[] eventDtos, String eventType) throws BizException {
		DomainBusinessUserObj buo = new DomainBusinessUserObj(Arrays.asList(eventDtos), BusiType.NO_CAT, null, "0");
		BusinessEvent bizEvent = new BusinessEvent(MedSrvEventDTO.class.getName(), eventType, buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

	/**
	 * 获取集成平台action
	 * 
	 * @param eventType
	 * @return
	 */
	private String getAction(String eventType) {
		if (eventType.equals(IEventType.TYPE_INSERT_AFTER)) {
			return "insert";
		} else if (eventType.equals(IEventType.TYPE_UPDATE_AFTER)) {
			return "update";
		} else if (eventType.equals(IEventType.TYPE_DELETE_AFTER)) {
			return "delete";
		}
		return null;
	}

	/**
	 * 获取服务价格
	 * 
	 * @param srvPriDOs
	 * @return
	 */
	private FDouble getPrice(SrvPriDO[] srvPriDOs) {
		FDateTime endTime = new FDateTime("2099-12-31 23:59:59");
		for (SrvPriDO srvPriDO : srvPriDOs) {
			if (endTime.equals(srvPriDO.getDt_e())) {
				return srvPriDO.getPrice();
			}
		}
		return null;
	}

	/**
	 * 基础价表Agg数据转事件DTO
	 * 
	 * @param basePriSrvAggDos
	 * @param eventType
	 * @return
	 */
	private PriSrvEventDTO[] getMedSrvEventDTOs(BaseprisrvAggDO[] basePriSrvAggDos, String eventType) {
		String action = getAction(eventType);

		PriSrvEventDTO[] eventDtos = new PriSrvEventDTO[basePriSrvAggDos.length];
		for (int i = 0; i < basePriSrvAggDos.length; i++) {
			PriSrvDO priSrvDO = basePriSrvAggDos[i].getParentDO();
			PriSrvEventDTO priSrvEventDTO = new PriSrvEventDTO();
			priSrvEventDTO.setAction(action);
			priSrvEventDTO.setCode(priSrvDO.getCode());
			priSrvEventDTO.setName(priSrvDO.getName());
//			priSrvEventDTO.setPrint_name(priSrvDO.getName());
			priSrvEventDTO.setPy_code(priSrvDO.getPycode());
//			priSrvEventDTO.setAudit_code(priSrvDO.getId_srvca());
//			priSrvEventDTO.setZy_bill_item(priSrvDO.getId_incca_ip());
//			priSrvEventDTO.setMz_bill_item(priSrvDO.getId_incca_op());

			FDouble price = getPrice(basePriSrvAggDos[i].getSrvPriDO());
			if (price == null) {
				price = FDouble.ZERO_DBL;
			}

			priSrvEventDTO.setCharge_price(price.toString());
			priSrvEventDTO.setEffective_price(price.toString());
			eventDtos[i] = priSrvEventDTO;
		}
		return eventDtos;
	}

	/**
	 * 医疗服务转事件DTO
	 * 
	 * @param basePriSrvs
	 * @param priceMap
	 * @param eventType
	 * @return
	 */
	private PriSrvEventDTO[] getMedSrvEventDTOs(MedSrvDO[] basePriSrvs, Map<String, FDouble> priceMap,
			String eventType) {
		String action = getAction(eventType);

		PriSrvEventDTO[] eventDtos = new PriSrvEventDTO[basePriSrvs.length];
		for (int i = 0; i < basePriSrvs.length; i++) {
			MedSrvDO medSrvDo = basePriSrvs[i];
			PriSrvEventDTO priSrvEventDTO = new PriSrvEventDTO();
			priSrvEventDTO.setAction(action);
			priSrvEventDTO.setCode(medSrvDo.getCode());
			priSrvEventDTO.setName(medSrvDo.getName());
//			priSrvEventDTO.setPrint_name(medSrvDo.getName());
			priSrvEventDTO.setPy_code(medSrvDo.getPycode());
//			priSrvEventDTO.setAudit_code(medSrvDo.getId_srvca());
//			priSrvEventDTO.setZy_bill_item(medSrvDo.getIncca_ip());
//			priSrvEventDTO.setMz_bill_item(medSrvDo.getIncca_op());

			FDouble price = FDouble.ZERO_DBL;
			if (priceMap.containsKey(medSrvDo.getId_srv())) {
				price = priceMap.get(medSrvDo.getId_srv());
			}

			priSrvEventDTO.setCharge_price(price.toString());
//			priSrvEventDTO.setEffective_price(price.toString());
			eventDtos[i] = priSrvEventDTO;
		}
		return eventDtos;
	}

	/**
	 * 发送事件
	 * 
	 * @param srvId
	 * @param eventType
	 * @throws BizException
	 */
	public void fireEvent(String srvId, String eventType) throws BizException {
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO medSrvDO = medsrvMDORService.findById(srvId);
		fireEvent(new MedSrvDO[] { medSrvDO }, eventType);
	}
}
