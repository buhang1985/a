package iih.bl.inc.s.listener;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.inc.blecinctrans.d.BlEcIncTransDO;
import iih.bl.inc.blecinctrans.d.EcIncTransTryeEnum;
import iih.bl.inc.blecinctrans.d.EcIncTypeEnum;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.s.ep.BlEcIncTransEP;
import iih.bl.inc.s.ep.IncIpEP;
import iih.bl.inc.s.ep.IncOepEP;
import iih.bl.inc.s.listener.help.BlEcIncIpInvoiceBP;
import iih.bl.inc.s.listener.help.BlEcIncOepInvoiceBP;
import iih.bl.params.BlParams;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

import com.core.AppUtils;

/**
 * 电子发票开具监听
 * @author ly 2019/12/06
 *
 */
public class BlEcIncInvoiceListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		BLThirdItfLogger.info(String.format("开立电子发票监听：%s",AppUtils.getServerDateTime()));
		if(!IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equals(event.getSourceID()) && 
				!IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS.equals(event.getSourceID()))
			return;
		
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		
		if(IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equals(event.getSourceID())){
			this.dealOpInc(bizUserObj);
		}else if(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS.equals(event.getSourceID())){
			this.dealIpInc(bizUserObj);
		}
	}
	
	/**
	 * 处理门诊电子发票
	 * @param event
	 * @throws BizException
	 */
	private void dealOpInc(BusinessUserObj bizUserObj)  throws BizException {
		
		BlPayOepEventDTO data = (BlPayOepEventDTO)bizUserObj.getUserObj();
		BlcgoepAggDO[] cgAggDos = data.getCgData();
		BlStOepDO stDO = data.getStData();
		BlpaypatoepAggDO payAggDO = data.getPayData();
		BlincoepAggDO[] incAggDos = data.getIncData();
		BlincoepAggDO incAggDO = incAggDos[0];
		
		if(FBoolean.FALSE.equals(incAggDO.getParentDO().getFg_ec_inc()))
			return;
		
		if(FBoolean.FALSE.equals(BlParams.BLSTOEP0008())){
			if(stDO.getAmt_ratio().equals(FDouble.ZERO_DBL))
				return;
		}
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		BlEcIncTransDO transDO = ecIncEp.createNewTransDO();
		transDO.setEu_inctype(EcIncTypeEnum.OEP);
		transDO.setEu_transtype(EcIncTransTryeEnum.ECINVOICE);
		transDO.setBizno(stDO.getCode_st());
		transDO.setId_pat(stDO.getId_pat());
		transDO.setId_ent(stDO.getId_ent());
		transDO.setId_st(stDO.getId_stoep());
		transDO.setId_inc(incAggDO.getParentDO().getId_incoep());
		transDO = ecIncEp.insertNewTransDO(transDO);
		
		BlEcIncOepInvoiceBP bp = new BlEcIncOepInvoiceBP();
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = bp.exec(cgAggDos, stDO, payAggDO, incAggDos);
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
		IncOepEP incEp = new IncOepEP();
		BlIncOepDO incOepDO = incAggDO.getParentDO();
		incOepDO.setIncno(outParam.getEcincno());
		incOepDO.setEc_inc_code(outParam.getEcinc_code());
		incOepDO.setEc_inc_checkno(outParam.getEcinc_checkno());
		incOepDO.setEc_url(outParam.getEcinc_url());
		incOepDO.setEc_net_url(outParam.getEcinc_neturl());
		incOepDO.setId_emp_inc(stDO.getId_emp_st());
		incEp.writebackEcIncInfo(incOepDO);
		
		transDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
		ecIncEp.updateSuccess(transDO);
	}
	
	/**
	 * 处理住院电子发票
	 * @param event
	 * @throws BizException
	 */
	private void dealIpInc(BusinessUserObj bizUserObj)  throws BizException {
		
		BlEventInfoDTO data =  (BlEventInfoDTO)bizUserObj.getUserObj();
		PatiVisitDO enEntDO = data.getPatiVisitDO();
		BlStIpDO blStIpDO = data.getBlStIpDO();
		BlpaypatipAggDO payAggDO = data.getBlpaypatipAggDO();
		BlincipAggDO incAggDO = data.getBlincipAggDO();
		
		if(FBoolean.FALSE.equals(incAggDO.getParentDO().getFg_ec_inc()))
			return;
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		BlEcIncTransDO transDO = ecIncEp.createNewTransDO();
		transDO.setEu_inctype(EcIncTypeEnum.IP);
		transDO.setEu_transtype(EcIncTransTryeEnum.ECINVOICE);
		transDO.setBizno(blStIpDO.getCode_st());
		transDO.setId_pat(enEntDO.getId_pat());
		transDO.setId_ent(enEntDO.getId_ent());
		transDO.setId_st(blStIpDO.getId_stip());
		transDO.setId_inc(incAggDO.getParentDO().getId_incip());
		transDO = ecIncEp.insertNewTransDO(transDO);
		
		BlEcIncIpInvoiceBP bp = new BlEcIncIpInvoiceBP();
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = bp.exec(enEntDO, blStIpDO, payAggDO, incAggDO);
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
		IncIpEP incEp = new IncIpEP();
		BlIncIpDO incIpDO = incAggDO.getParentDO();
		incIpDO.setIncno(outParam.getEcincno());
		incIpDO.setEc_inc_code(outParam.getEcinc_code());
		incIpDO.setEc_inc_checkno(outParam.getEcinc_checkno());
		incIpDO.setEc_url(outParam.getEcinc_url());
		incIpDO.setEc_net_url(outParam.getEcinc_neturl());
		incEp.writebackEcIncInfo(incIpDO);
		
		transDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
		ecIncEp.updateSuccess(transDO);
	}
}
