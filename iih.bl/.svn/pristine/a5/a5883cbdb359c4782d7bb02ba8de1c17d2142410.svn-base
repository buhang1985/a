package iih.bl.inc.s.task;

import java.util.List;

import iih.bl.inc.blecinctrans.d.BlEcIncTransDO;
import iih.bl.inc.blecinctrans.d.EcIncTransTryeEnum;
import iih.bl.inc.blecinctrans.d.EcIncTypeEnum;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.s.ep.BlEcIncTransEP;
import iih.bl.inc.s.ep.IncOepEP;
import iih.bl.inc.s.listener.help.BlEcIncOepRedInvoiceBP;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 电子票据异常数据处理
 * @author ly 2020/01/20
 *
 */
public class EcIncExceptionDealTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		
		PreAlertObject obj = new PreAlertObject();
		
		//暂时只处理门诊红冲失败票据
		this.dealOpRedIncException();
		
		
		return obj;
	}
	
	/**
	 * 处理门诊红冲失败票据
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void dealOpRedIncException() throws BizException {
		
		//查询红冲异常数据
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select * from bl_inc_oep ");
		sqlSb.append("where fg_ec_inc = 'Y' ");
		//sqlSb.append("and eu_direct = -1 ");
		sqlSb.append("and ec_inc_code is null ");
		sqlSb.append("and id_incoep not in (select id_inc from bl_ec_inc_tras where eu_transtype = 2) ");
		
		DAFacade daf = new DAFacade();
		List<BlIncOepDO> incList =  (List<BlIncOepDO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(BlIncOepDO.class));
		if(ListUtil.isEmpty(incList))
			return;
		
		BlEcIncTransEP ecIncEp = new BlEcIncTransEP();
		IncOepEP incEp = new IncOepEP();
		BlEcIncOepRedInvoiceBP redBp = new BlEcIncOepRedInvoiceBP();
		
		for (BlIncOepDO blIncOepDO : incList) {
			
			if(blIncOepDO.getEu_direct() == -1){
				BlStOepDO redStDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, blIncOepDO.getId_stoep());
				BlStOepDO oldStDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, redStDO.getId_par());
				
				List<BlIncOepDO> oldIncList = (List<BlIncOepDO>)daf.findByAttrValString(BlIncOepDO.class, BlIncOepDO.ID_STOEP, oldStDO.getId_stoep(), null);
				
				Context.get().setGroupId(blIncOepDO.getId_grp());
				Context.get().setOrgId(blIncOepDO.getId_org());
				Context.get().setStuffId(redStDO.getId_emp_st());
				Context.get().setDeptId(redStDO.getId_dep_st());
				
				BlEcIncTransDO redTransDO = ecIncEp.createNewTransDO();
				redTransDO.setEu_inctype(EcIncTypeEnum.OEP);
				redTransDO.setEu_transtype(EcIncTransTryeEnum.ECREDINVOICE);
				redTransDO.setBizno(redStDO.getCode_st());
				redTransDO.setId_pat(redStDO.getId_pat());
				redTransDO.setId_ent(redStDO.getId_ent());
				redTransDO.setId_st(redStDO.getId_stoep());
				redTransDO.setId_inc(blIncOepDO.getId_incoep());
				redTransDO = ecIncEp.insertNewTransDO(redTransDO);
				
				EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redRlt = redBp.exec(oldIncList.get(0), blIncOepDO);
				redTransDO.setInputinfo(redRlt.getInparam());
				redTransDO.setOutputinfo(redRlt.getOutparam());
				if(FBoolean.FALSE.equals(redRlt.getFg_success())){
					ecIncEp.updateFail(redTransDO);
				}else{
					EcIncBlFlowRedInvoiceOutDTO redOutParam = redRlt.getData();
					
					blIncOepDO.setIncno(redOutParam.getEcincno());
					blIncOepDO.setEc_inc_code(redOutParam.getEcinc_code());
					blIncOepDO.setEc_inc_checkno(redOutParam.getEcinc_checkno());
					blIncOepDO.setEc_url(redOutParam.getEcinc_url());
					blIncOepDO.setEc_net_url(redOutParam.getEcinc_neturl());
					incEp.writebackEcIncInfo(blIncOepDO);
					
					ecIncEp.updateSuccess(redTransDO);
				}
			}else{
				
				BlStOepDO newStDO = (BlStOepDO)daf.findByPK(BlStOepDO.class, blIncOepDO.getId_stoep());
				
				BlEcIncTransDO newTransDO = ecIncEp.createNewTransDO();
				newTransDO.setEu_inctype(EcIncTypeEnum.OEP);
				newTransDO.setEu_transtype(EcIncTransTryeEnum.ECINVOICE);
				newTransDO.setBizno(newStDO.getCode_st());
				newTransDO.setId_pat(newStDO.getId_pat());
				newTransDO.setId_ent(newStDO.getId_ent());
				newTransDO.setId_st(newStDO.getId_stoep());
				newTransDO.setId_inc(blIncOepDO.getId_stoep());
				newTransDO = ecIncEp.insertNewTransDO(newTransDO);
				
				EcIncBlFlowInvoiceInDTO inDto = new EcIncBlFlowInvoiceInDTO();
				inDto.setId_pat(newStDO.getId_pat());
				inDto.setId_ent(newStDO.getId_ent());
				inDto.setId_st(newStDO.getId_stoep());
				inDto.setId_pay(newStDO.getId_paypatoep());
				inDto.setId_inc(blIncOepDO.getId_incoep());
				inDto.setInctype(StTypeEnum.ST_OEP_REG.equals(newStDO.getEu_sttp()) ? iih.ei.bl.ecinc.d.EcIncTypeEnum.INCREGISTER : iih.ei.bl.ecinc.d.EcIncTypeEnum.INCOEP);
				
				EcIncFacade incFacade = new EcIncFacade();
				EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = incFacade.invoice(inDto);
				
				newTransDO.setInputinfo(rlt.getInparam());
				newTransDO.setOutputinfo(rlt.getOutparam());
				if(FBoolean.FALSE.equals(rlt.getFg_success())){
					ecIncEp.updateFail(newTransDO);
				}else{
					EcIncBlFlowInvoiceOutDTO outParam = rlt.getData();
					blIncOepDO.setIncno(outParam.getEcincno());
					blIncOepDO.setEc_inc_code(outParam.getEcinc_code());
					blIncOepDO.setEc_inc_checkno(outParam.getEcinc_checkno());
					blIncOepDO.setEc_url(outParam.getEcinc_url());
					blIncOepDO.setEc_net_url(outParam.getEcinc_neturl());
					
					incEp.writebackEcIncInfo(blIncOepDO);
					
					newTransDO.setEc_qrcode_pic(outParam.getEc_qrcode_pic());
					ecIncEp.updateSuccess(newTransDO);
				}
			}
		}
	}
}
