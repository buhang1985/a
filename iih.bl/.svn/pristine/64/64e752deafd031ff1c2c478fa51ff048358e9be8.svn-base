package iih.bl.inc.s.bp.ecinc;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import iih.bl.inc.blecinctrans.d.BlEcIncTransDO;
import iih.bl.inc.blecinctrans.d.EcIncTransStateEnum;
import iih.bl.inc.blecinctrans.d.EcIncTransTryeEnum;
import iih.bl.inc.blecinctrans.d.EcIncTypeEnum;
import iih.bl.inc.blecinctrans.i.IBlecinctransRService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.s.ep.BlEcIncTransEP;
import iih.bl.inc.s.ep.IncIpEP;
import iih.bl.inc.s.ep.IncOepEP;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 电子发票异常记录处理
 * @author ly 2019/12/24
 *
 */
public class BlEcincTransEcptDealBP {

	/**
	 * 电子发票异常记录处理
	 * @param transIds
	 * @throws BizException
	 */
	public void exec(String[] transIds) throws BizException{
		
		if(ArrayUtil.isEmpty(transIds))
			return;
		
		IBlecinctransRService transRService = ServiceFinder.find(IBlecinctransRService.class);
		BlEcIncTransDO[] transDos = transRService.findByIds(transIds, FBoolean.FALSE);
		
		List<BlEcIncTransDO> opTransList = new ArrayList<BlEcIncTransDO>();
		List<BlEcIncTransDO> ipTransList = new ArrayList<BlEcIncTransDO>();

		for (BlEcIncTransDO transDO : transDos) {
			
			if(EcIncTransStateEnum.SUCCESS.equals(transDO.getEu_transstatus()))
				continue;
			
			if(EcIncTypeEnum.OEP.equals(transDO.getEu_inctype())){
				opTransList.add(transDO);
			}else{
				ipTransList.add(transDO);
			}
		}
		
		if(!ListUtil.isEmpty(opTransList)){
			this.dealOp(opTransList);
		}
		
		if(!ListUtil.isEmpty(ipTransList)){
			this.dealIp(ipTransList);
		}
	}
	
	/**
	 * 处理门诊异常
	 * @param opTransList
	 * @throws BizException
	 */
	private void dealOp(List<BlEcIncTransDO> opTransList) throws BizException{
		
		//暂时处理开立异常
		for (BlEcIncTransDO transDO : opTransList) {
			
			switch (transDO.getEu_transtype()) {
			case EcIncTransTryeEnum.ECINVOICE:
				//test(transDO);
				this.dealOpInvoice(transDO);
				break;
			case EcIncTransTryeEnum.ECREDINVOICE:
				this.dealOpRedInvoice(transDO);
				break;
			case EcIncTransTryeEnum.PAPERINVOICE:
				break;
			case EcIncTransTryeEnum.PAPERREDINVOICE:
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * 测试
	 * @param transDO
	 * @throws BizException
	 */
	private void test(BlEcIncTransDO transDO) throws BizException{
		
		String qrCode = "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";
		
		try {
			byte[] b = Base64.decode(qrCode.getBytes("UTF-8"));
			transDO.setEc_qrcode_pic(b);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		ecIncEp.updateFail(transDO);
	}
	
	/**
	 * 处理发票开具异常
	 * @param transDO
	 * @throws BizException
	 */
	private void dealOpInvoice(BlEcIncTransDO transDO) throws BizException{
		
		DAFacade daf = new DAFacade();
		BlStOepDO stDO = (BlStOepDO) daf.findByPK(BlStOepDO.class, transDO.getId_st(),
				new String[] { BlStOepDO.ID_PAT, BlStOepDO.ID_ENT, BlStOepDO.ID_STOEP, 
						BlStOepDO.ID_PAYPATOEP, BlStOepDO.EU_STTP, BlStOepDO.FG_CANC });
		
		if(stDO == null || FBoolean.TRUE.equals(stDO.getFg_canc())){
			transDO.setFg_active(FBoolean.FALSE);
			daf.updateDO(transDO, new String[] { BlEcIncTransDO.FG_ACTIVE });
			return;
		}
		
		EcIncBlFlowInvoiceInDTO inDto = new EcIncBlFlowInvoiceInDTO();
		inDto.setId_pat(stDO.getId_pat());
		inDto.setId_ent(stDO.getId_ent());
		inDto.setId_st(stDO.getId_stoep());
		inDto.setId_pay(stDO.getId_paypatoep());
		inDto.setId_inc(transDO.getId_inc());
		inDto.setInctype(StTypeEnum.ST_OEP_REG.equals(stDO.getEu_sttp()) ? iih.ei.bl.ecinc.d.EcIncTypeEnum.INCREGISTER : iih.ei.bl.ecinc.d.EcIncTypeEnum.INCOEP);
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = incFacade.invoice(inDto);
		
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
		BlIncOepDO incOepDO = new BlIncOepDO();
		incOepDO.setId_incoep(transDO.getId_inc());
		incOepDO.setIncno(outParam.getEcincno());
		incOepDO.setEc_inc_code(outParam.getEcinc_code());
		incOepDO.setEc_inc_checkno(outParam.getEcinc_checkno());
		incOepDO.setEc_url(outParam.getEcinc_url());
		incOepDO.setEc_net_url(outParam.getEcinc_neturl());
		incOepDO.setId_emp_inc(Context.get().getStuffId());
		
		IncOepEP incEp = new IncOepEP();
		incEp.writebackEcIncInfo(incOepDO);
		
		transDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
		ecIncEp.updateSuccess(transDO);
	}
	
	/**
	 * 处理发票红冲异常
	 * @param transDO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void dealOpRedInvoice(BlEcIncTransDO transDO) throws BizException{
		
		DAFacade daf = new DAFacade();
		
		BlStOepDO stDO = (BlStOepDO) daf.findByPK(BlStOepDO.class, transDO.getId_st(),
				new String[] { BlStOepDO.ID_PAT, BlStOepDO.ID_ENT, BlStOepDO.ID_STOEP, BlStOepDO.ID_PAR});
		
		List<BlIncOepDO> oldIncList = (List<BlIncOepDO>)daf.findByAttrValString(BlIncOepDO.class, BlIncOepDO.ID_STOEP, stDO.getId_par(), 
				new String[]{BlIncOepDO.ID_INCOEP,BlIncOepDO.ID_STOEP,BlIncOepDO.INCNO,BlIncOepDO.EC_INC_CODE,BlIncOepDO.EC_INC_CHECKNO});
		
		BlIncOepDO olcIncDO = oldIncList.get(0);
		
		EcIncBlFlowRedInvoiceInDTO inDto = new EcIncBlFlowRedInvoiceInDTO();
		inDto.setId_pat(stDO.getId_pat());
		inDto.setId_ent(stDO.getId_ent());
		inDto.setId_st_old(olcIncDO.getId_stoep());
		inDto.setId_inc_old(olcIncDO.getId_incoep());
		inDto.setId_st_red(transDO.getId_st());
		inDto.setId_inc_red(transDO.getId_inc());
		inDto.setEcincno(olcIncDO.getIncno());
		inDto.setEcinc_code(olcIncDO.getEc_inc_code());
		inDto.setInctype(StTypeEnum.ST_OEP_REG.equals(stDO.getEu_sttp()) ? iih.ei.bl.ecinc.d.EcIncTypeEnum.INCREGISTER : iih.ei.bl.ecinc.d.EcIncTypeEnum.INCOEP);
		inDto.setReason("退费");
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = incFacade.redInvoice(inDto);
		
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowRedInvoiceOutDTO redOutParam = rlt.getData();

		IncOepEP incEp = new IncOepEP();
		BlIncOepDO incOepDO = new BlIncOepDO();
		incOepDO.setId_incoep(transDO.getId_inc());
		incOepDO.setIncno(redOutParam.getEcincno());
		incOepDO.setEc_inc_code(redOutParam.getEcinc_code());
		incOepDO.setEc_inc_checkno(redOutParam.getEcinc_checkno());
		incOepDO.setEc_url(redOutParam.getEcinc_url());
		incOepDO.setEc_net_url(redOutParam.getEcinc_neturl());
		incOepDO.setId_emp_inc(Context.get().getStuffId());
		incEp.writebackEcIncInfo(incOepDO);
		
		ecIncEp.updateSuccess(transDO);
	}
	
	/**
	 * 处理住院异常
	 * @param ipTransList
	 * @throws BizException
	 */
	private void dealIp(List<BlEcIncTransDO> ipTransList)  throws BizException{
		//暂时处理开立异常
		for (BlEcIncTransDO transDO : ipTransList) {
			
			switch (transDO.getEu_transtype()) {
			case EcIncTransTryeEnum.ECINVOICE:
				//test(transDO);
				this.dealIpInvoice(transDO);
				break;
			case EcIncTransTryeEnum.ECREDINVOICE:
				this.dealIpRedInvoice(transDO);
				break;
			case EcIncTransTryeEnum.PAPERINVOICE:
				break;
			case EcIncTransTryeEnum.PAPERREDINVOICE:
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * 处理发票开具异常
	 * @param transDO
	 * @throws BizException
	 */
	private void dealIpInvoice(BlEcIncTransDO transDO) throws BizException{
		
		DAFacade daf = new DAFacade();
		BlStIpDO stDO = (BlStIpDO) daf.findByPK(BlStIpDO.class, transDO.getId_st(),
				new String[] { BlStIpDO.ID_PAT, BlStIpDO.ID_ENT, BlStIpDO.ID_STIP, 
								BlStIpDO.EU_STTP, BlStIpDO.FG_CANC });
		
		@SuppressWarnings("unchecked")
		List<BlPayPatIpDO> payDOList = (List<BlPayPatIpDO>)daf.findByAttrValString(BlPayPatIpDO.class, BlPayPatIpDO.ID_STIP, transDO.getId_st(), null);
		
		if(stDO == null || FBoolean.TRUE.equals(stDO.getFg_canc()) || ListUtil.isEmpty(payDOList)){
			transDO.setFg_active(FBoolean.FALSE);
			daf.updateDO(transDO, new String[] { BlEcIncTransDO.FG_ACTIVE });
			return;
		}
		
		EcIncBlFlowInvoiceInDTO inDto = new EcIncBlFlowInvoiceInDTO();
		inDto.setId_pat(stDO.getId_pat());
		inDto.setId_ent(stDO.getId_ent());
		inDto.setId_st(stDO.getId_stip());
		inDto.setId_pay(payDOList.get(0).getId_paypatip());
		inDto.setId_inc(transDO.getId_inc());
		inDto.setInctype(iih.ei.bl.ecinc.d.EcIncTypeEnum.INCIP);
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = incFacade.invoice(inDto);
		
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
		BlIncIpDO incIpDO = new BlIncIpDO();
		incIpDO.setId_incip(transDO.getId_inc());
		incIpDO.setIncno(outParam.getEcincno());
		incIpDO.setEc_inc_code(outParam.getEcinc_code());
		incIpDO.setEc_inc_checkno(outParam.getEcinc_checkno());
		incIpDO.setEc_url(outParam.getEcinc_url());
		incIpDO.setEc_net_url(outParam.getEcinc_neturl());
		incIpDO.setId_emp_inc(Context.get().getStuffId());
		
		IncIpEP incEp = new IncIpEP();
		incEp.writebackEcIncInfo(incIpDO);
		
		transDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
		ecIncEp.updateSuccess(transDO);
	}
	
	/**
	 * 处理发票红冲异常
	 * @param transDO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void dealIpRedInvoice(BlEcIncTransDO transDO) throws BizException{
		
		DAFacade daf = new DAFacade();
		
		BlStIpDO stDO = (BlStIpDO) daf.findByPK(BlStIpDO.class, transDO.getId_st(),
				new String[] { BlStIpDO.ID_PAT, BlStIpDO.ID_ENT, BlStIpDO.ID_STIP, BlStIpDO.ID_PAR});
		
		List<BlIncIpDO> oldIncList = (List<BlIncIpDO>)daf.findByAttrValString(BlIncIpDO.class, BlIncIpDO.ID_STIP, stDO.getId_par(), 
				new String[]{BlIncIpDO.ID_INCIP,BlIncIpDO.ID_STIP,BlIncIpDO.INCNO,BlIncIpDO.EC_INC_CODE,BlIncIpDO.EC_INC_CHECKNO});
		
		BlIncIpDO olcIncDO = oldIncList.get(0);
		
		EcIncBlFlowRedInvoiceInDTO inDto = new EcIncBlFlowRedInvoiceInDTO();
		inDto.setId_pat(stDO.getId_pat());
		inDto.setId_ent(stDO.getId_ent());
		inDto.setId_st_old(olcIncDO.getId_stip());
		inDto.setId_inc_old(olcIncDO.getId_incip());
		inDto.setId_st_red(transDO.getId_st());
		inDto.setId_inc_red(transDO.getId_inc());
		inDto.setEcincno(olcIncDO.getIncno());
		inDto.setEcinc_code(olcIncDO.getEc_inc_code());
		inDto.setInctype(iih.ei.bl.ecinc.d.EcIncTypeEnum.INCIP);
		inDto.setReason("退费");
		
		EcIncFacade incFacade = new EcIncFacade();
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = incFacade.redInvoice(inDto);
		
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowRedInvoiceOutDTO redOutParam = rlt.getData();

		IncIpEP incEp = new IncIpEP();
		BlIncIpDO incIpDO = new BlIncIpDO();
		incIpDO.setId_incip(transDO.getId_inc());
		incIpDO.setIncno(redOutParam.getEcincno());
		incIpDO.setEc_inc_code(redOutParam.getEcinc_code());
		incIpDO.setEc_inc_checkno(redOutParam.getEcinc_checkno());
		incIpDO.setEc_url(redOutParam.getEcinc_url());
		incIpDO.setEc_net_url(redOutParam.getEcinc_neturl());
		incIpDO.setId_emp_inc(Context.get().getStuffId());
		incEp.writebackEcIncInfo(incIpDO);
		
		ecIncEp.updateSuccess(transDO);
	}
}
