package iih.bl.inc.s.listener;

import com.core.AppUtils;

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
import iih.bl.inc.s.listener.help.BlEcIncIpRedInvoiceBP;
import iih.bl.inc.s.listener.help.BlEcIncOepInvoiceBP;
import iih.bl.inc.s.listener.help.BlEcIncOepRedInvoiceBP;
import iih.bl.params.BlParams;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.blpayoep.d.BlPayOepRefundEventDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

/**
 * 电子发票红冲监听
 * @author ly 2019/12/06
 *
 */
public class BlEcIncRedInvoiceListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		BLThirdItfLogger.info(String.format("红冲电子发票监听：%s",AppUtils.getServerDateTime()));
		if(!IBlEventConst.EVENT_SOURCE_OEP_REFUND.equals(event.getSourceID()) && 
				!IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS.equals(event.getSourceID()))
			return;
		
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();

		if(IBlEventConst.EVENT_SOURCE_OEP_REFUND.equals(event.getSourceID())){
			this.dealOpInc(bizUserObj);
		}else if(IBlEventConst.EVENT_BL_ST_IP_PAY_CLASS.equals(event.getSourceID())){
			this.dealIpInc(bizUserObj);
		}
	}

	/**
	 * 处理门诊
	 * @param bizUserObj
	 * @throws BizException
	 */
	private void dealOpInc(BusinessUserObj bizUserObj) throws BizException {
		
		BlPayOepRefundEventDTO data = (BlPayOepRefundEventDTO)bizUserObj.getUserObj();
		
		// 红冲
		BlincoepAggDO[] oldIncAggDos = data.getOldIncData();
		if(ArrayUtil.isEmpty(oldIncAggDos)){
			
		}
		BlIncOepDO oldIncDO = oldIncAggDos[0].getParentDO();
		BlStOepDO redStDO = data.getRedStData();
		BlincoepAggDO[] redIncAggDos = data.getRedIncData();
		BlIncOepDO redIncDO = redIncAggDos[0].getParentDO();
		
		if(FBoolean.FALSE.equals(BlParams.BLSTOEP0008())){
			if(redStDO.getAmt_ratio().equals(FDouble.ZERO_DBL))
				return;
		}
		
		IncOepEP incEp = new IncOepEP();
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		
		if(FBoolean.TRUE.equals(oldIncDO.getFg_ec_inc())){
			
			BlEcIncTransDO redTransDO = ecIncEp.createNewTransDO();
			redTransDO.setEu_inctype(EcIncTypeEnum.OEP);
			redTransDO.setEu_transtype(EcIncTransTryeEnum.ECREDINVOICE);
			redTransDO.setBizno(redStDO.getCode_st());
			redTransDO.setId_pat(redStDO.getId_pat());
			redTransDO.setId_ent(redStDO.getId_ent());
			redTransDO.setId_st(redStDO.getId_stoep());
			redTransDO.setId_inc(redIncDO.getId_incoep());
			redTransDO = ecIncEp.insertNewTransDO(redTransDO);
			
			BlEcIncOepRedInvoiceBP redBp = new BlEcIncOepRedInvoiceBP();
			EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redRlt = redBp.exec(oldIncDO, redIncDO);
			redTransDO.setInputinfo(redRlt.getInparam());
			redTransDO.setOutputinfo(redRlt.getOutparam());
			if(FBoolean.FALSE.equals(redRlt.getFg_success())){
				ecIncEp.updateFail(redTransDO);
			}else{
				EcIncBlFlowRedInvoiceOutDTO redOutParam = redRlt.getData();
				
				redIncDO.setIncno(redOutParam.getEcincno());
				redIncDO.setEc_inc_code(redOutParam.getEcinc_code());
				redIncDO.setEc_inc_checkno(redOutParam.getEcinc_checkno());
				redIncDO.setEc_url(redOutParam.getEcinc_url());
				redIncDO.setEc_net_url(redOutParam.getEcinc_neturl());
				redIncDO.setId_emp_inc(redStDO.getId_emp_st());
				incEp.writebackEcIncInfo(redIncDO);
				
				ecIncEp.updateSuccess(redTransDO);
			}
		}
		
		// 重收
		if(data.getNewStData() != null){
		
			BlcgoepAggDO[] newCgAggDos = data.getNewCgData();
			BlStOepDO newStDO = data.getNewStData();
			BlpaypatoepAggDO newPayAggDO = data.getNewPayData();
			BlincoepAggDO[] newIncAggDos = data.getNewIncData();
			BlincoepAggDO newIncAggDO = newIncAggDos[0];
			
			if(FBoolean.TRUE.equals(newIncAggDO.getParentDO().getFg_ec_inc())){
				
				BlEcIncTransDO newTransDO = ecIncEp.createNewTransDO();
				newTransDO.setEu_inctype(EcIncTypeEnum.OEP);
				newTransDO.setEu_transtype(EcIncTransTryeEnum.ECINVOICE);
				newTransDO.setBizno(newStDO.getCode_st());
				newTransDO.setId_pat(newStDO.getId_pat());
				newTransDO.setId_ent(newStDO.getId_ent());
				newTransDO.setId_st(newStDO.getId_stoep());
				newTransDO.setId_inc(newIncAggDO.getParentDO().getId_incoep());
				newTransDO = ecIncEp.insertNewTransDO(newTransDO);
				
				BlEcIncOepInvoiceBP newBp = new BlEcIncOepInvoiceBP();
				EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = newBp.exec(newCgAggDos, newStDO, newPayAggDO, newIncAggDos);
				newTransDO.setInputinfo(rlt.getInparam());
				newTransDO.setOutputinfo(rlt.getOutparam());
				if(FBoolean.FALSE.equals(rlt.getFg_success())){
					ecIncEp.updateFail(newTransDO);
				}else{
					EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
					BlIncOepDO incOepDO = newIncAggDO.getParentDO();
					incOepDO.setIncno(outParam.getEcincno());
					incOepDO.setEc_inc_code(outParam.getEcinc_code());
					incOepDO.setEc_inc_checkno(outParam.getEcinc_checkno());
					incOepDO.setEc_url(outParam.getEcinc_url());
					incOepDO.setEc_net_url(outParam.getEcinc_neturl());
					incEp.writebackEcIncInfo(incOepDO);
					
					newTransDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
					ecIncEp.updateSuccess(newTransDO);
				}
			}
		}
	}

	/**
	 * 处理住院
	 * @param bizUserObj
	 * @throws BizException
	 */
	private void dealIpInc(BusinessUserObj bizUserObj) throws BizException {
		
		BlEventInfoDTO data = (BlEventInfoDTO)bizUserObj.getUserObj();
		BlStIpDO reStDO = data.getBlStIpDO();
		//查询原票据信息
		IncIpEP incEp = new IncIpEP();
		BlincipAggDO[] oldAggDos = incEp.findIncByStId(reStDO.getId_par());
		BlIncIpDO oldIncDO = oldAggDos[0].getParentDO();
		
		if(FBoolean.FALSE.equals(oldIncDO.getFg_ec_inc()))
			return;
		
		//查询红冲票据信息
		BlincipAggDO[] redAggDos = incEp.findIncByStId(reStDO.getId_stip());
		if(ArrayUtil.isEmpty(redAggDos)){
			BLThirdItfLogger.info(String.format("没有查询到红冲票据信息：%s",reStDO.getId_stip()));
		}
		BlIncIpDO redIncDO = redAggDos[0].getParentDO();
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		BlEcIncTransDO transDO = ecIncEp.createNewTransDO();
		transDO.setEu_inctype(EcIncTypeEnum.IP);
		transDO.setEu_transtype(EcIncTransTryeEnum.ECREDINVOICE);
		transDO.setBizno(reStDO.getCode_st());
		transDO.setId_pat(reStDO.getId_pat());
		transDO.setId_ent(reStDO.getId_ent());
		transDO.setId_st(reStDO.getId_stip());
		transDO.setId_inc(redIncDO.getId_incip());
		transDO = ecIncEp.insertNewTransDO(transDO);
		
		BlEcIncIpRedInvoiceBP bp = new BlEcIncIpRedInvoiceBP();
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = bp.exec(oldIncDO, redIncDO);
		transDO.setInputinfo(rlt.getInparam());
		transDO.setOutputinfo(rlt.getOutparam());
		if(FBoolean.FALSE.equals(rlt.getFg_success())){
			ecIncEp.updateFail(transDO);
			return;
		}
		
		EcIncBlFlowRedInvoiceOutDTO outParam = rlt.getData();
		redIncDO.setIncno(outParam.getEcincno());
		redIncDO.setEc_inc_code(outParam.getEcinc_code());
		redIncDO.setEc_inc_checkno(outParam.getEcinc_checkno());
		redIncDO.setEc_url(outParam.getEcinc_url());
		redIncDO.setEc_net_url(outParam.getEcinc_neturl());
		incEp.writebackEcIncInfo(redIncDO);
		ecIncEp.updateSuccess(transDO);
	}
}
