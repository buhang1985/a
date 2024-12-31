package iih.bl.inc.s.bp.ecinc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.inc.blecinctrans.d.BlEcIncTransDO;
import iih.bl.inc.blecinctrans.d.EcIncTransTryeEnum;
import iih.bl.inc.blecinctrans.d.EcIncTypeEnum;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.s.ep.BlEcIncTransEP;
import iih.bl.inc.s.ep.IncOepEP;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 未打印发票转换为电子发票(门诊)
 * @author ly 2020/01/10
 *
 */
public class BlEcIncChangeNotPirntIncToEcOpBP {

	/**
	 * 未打印发票转换为电子发票(门诊)
	 * @param stIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlincoepAggDO[] exec(String[] stIds) throws BizException{
	
		if(ArrayUtil.isEmpty(stIds))
			return null;
		
		// 查询票据数据
		DAFacade daf = new DAFacade();
		List<BlIncOepDO> incList = (List<BlIncOepDO>)daf.findByAttrValStrings(BlIncOepDO.class, BlIncOepDO.ID_STOEP, stIds, null);
		
		// 校验分票情况 ...暂不支持分票
		Map<String, List<BlIncOepDO>> incMap = new HashMap<String, List<BlIncOepDO>>();
		for (BlIncOepDO blIncOepDO : incList) {
			
			List<BlIncOepDO> incMapList = null;
			if(incMap.containsKey(blIncOepDO.getId_stoep())){
				incMapList = incMap.get(blIncOepDO.getId_stoep());
			}else{
				incMapList = new ArrayList<BlIncOepDO>();
				incMap.put(blIncOepDO.getId_stoep(), incMapList);
			}
			incMapList.add(blIncOepDO);
		}
		
		// 校验是否有分票情况
		for (List<BlIncOepDO> incMapList : incMap.values()) {
			if(incMapList.size() > 1){
				throw new BizException("一次结算多张发票暂不支持开具电子发票");
			}
		}
		
		List<BlStOepDO> stDOList = (List<BlStOepDO>) daf.findByPKs(BlStOepDO.class, stIds);
		Map<String, BlStOepDO> stMap = new HashMap<String, BlStOepDO>();
		for (BlStOepDO blStOepDO : stDOList) {
			stMap.put(blStOepDO.getId_stoep(), blStOepDO);
		}
		
		List<String> incIdList = new ArrayList<String>();
		for (BlIncOepDO blIncOepDO : incList) {
			
			incIdList.add(blIncOepDO.getId_incoep());
			if(FBoolean.TRUE.equals(blIncOepDO.getFg_print()))
				continue;
			
			BlStOepDO stDO = stMap.get(blIncOepDO.getId_stoep());
			
			BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
			BlEcIncTransDO transDO = ecIncEp.createNewTransDO();
			transDO.setEu_inctype(EcIncTypeEnum.OEP);
			transDO.setEu_transtype(EcIncTransTryeEnum.ECINVOICE);
			transDO.setBizno(stDO.getCode_st());
			transDO.setId_pat(stDO.getId_pat());
			transDO.setId_ent(stDO.getId_ent());
			transDO.setId_st(stDO.getId_stoep());
			transDO.setId_inc(blIncOepDO.getId_incoep());
			transDO = ecIncEp.insertNewTransDO(transDO);
			
			EcIncBlFlowInvoiceInDTO inDto = new EcIncBlFlowInvoiceInDTO();
			inDto.setId_pat(stDO.getId_pat());
			inDto.setId_ent(stDO.getId_ent());
			inDto.setId_st(stDO.getId_stoep());
			inDto.setId_pay(stDO.getId_paypatoep());
			inDto.setId_inc(blIncOepDO.getId_incoep());
			inDto.setInctype(StTypeEnum.ST_OEP_REG.equals(stDO.getEu_sttp()) ? iih.ei.bl.ecinc.d.EcIncTypeEnum.INCREGISTER : iih.ei.bl.ecinc.d.EcIncTypeEnum.INCOEP);
			
			EcIncFacade incFacade = new EcIncFacade();
			EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = incFacade.invoice(inDto);
			
			transDO.setInputinfo(rlt.getInparam());
			transDO.setOutputinfo(rlt.getOutparam());
			if(FBoolean.FALSE.equals(rlt.getFg_success())){
				ecIncEp.updateFail(transDO);
			}else{
				EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
				IncOepEP incEp = new IncOepEP();
				blIncOepDO.setFg_ec_inc(FBoolean.TRUE);
				blIncOepDO.setIncno(outParam.getEcincno());
				blIncOepDO.setEc_inc_code(outParam.getEcinc_code());
				blIncOepDO.setEc_inc_checkno(outParam.getEcinc_checkno());
				blIncOepDO.setEc_url(outParam.getEcinc_url());
				blIncOepDO.setEc_net_url(outParam.getEcinc_neturl());
				incEp.writebackEcIncInfo(blIncOepDO);
				
				transDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
				ecIncEp.updateSuccess(transDO);
			}
		}
		
		IBlincoepRService incRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] incAggDos = incRService.findByBIds(incIdList.toArray(new String[0]), FBoolean.FALSE);
		
		return incAggDos;
	}
}
