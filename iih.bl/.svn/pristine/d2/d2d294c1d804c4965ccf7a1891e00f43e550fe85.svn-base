package iih.bl.pay.s.bp;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.prop.i.IBlPropCmdService;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.dto.d.BlStIpInccanoDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 安徽医保患者HIS结算
 * @author liwq
 * @since 2017-9-26 10:14:00
 */
public class DoInsurSettledPaymentBp {
	public BlStIpPayInvoceInfoDTO exec(InsureContext insureContext,OperatorInfoDTO operator, BlPayPatIpDO ipPayDo, BlPrePayPatDO[] ipPrepayDoArr,
			BlPayItmPatIpDO[] ipPayItmDoArr, BlCgIpDO[] reductionCgDoArr,BlStIpInccanoDTO incAndPayNo, FBoolean isArrears,
			FBoolean isTransfer,FBoolean isPrintInvoice,BlPropIpDO ipPropDO,BlproparipAggDO ipPropArAggDO,InpPayRtnValDTO hpPayRtnValDto) throws BizException {
		//1. 保存住院医保分摊数据
		if( ipPropDO  != null && ipPropArAggDO != null) {
			IBlPropCmdService propCmdService = ServiceFinder.find(IBlPropCmdService.class);
			FMap2 map=propCmdService.saveIpPropData(ipPropDO, ipPropArAggDO);
			BlproparipAggDO[] arIpAggdoArr=(BlproparipAggDO[])map.get("proparip");
			InsureFacade facade=new InsureFacade(insureContext);
			HisPropertyRefHpDTO propertyRefDto=new HisPropertyRefHpDTO();
			propertyRefDto.setId_ref(arIpAggdoArr[0].getParentDO().getId_proparip());
			propertyRefDto.setId_ref_preflow(ipPayDo.getId_stip());
			if(hpPayRtnValDto != null){
				hpPayRtnValDto.setId_ent(ipPayDo.getId_ent());
			}
			facade.savePayPropDataIp(hpPayRtnValDto, propertyRefDto);
		}		
		//2. HIS结算付款
		DoIpPaymentBP ipPaymentBp = new DoIpPaymentBP();
		BlStIpPayInvoceInfoDTO rtnInvioceInfo = ipPaymentBp.exec(operator, ipPayDo, ipPrepayDoArr, ipPayItmDoArr, reductionCgDoArr, incAndPayNo, isArrears, isTransfer,isPrintInvoice);
		return rtnInvioceInfo;
	}
	
}