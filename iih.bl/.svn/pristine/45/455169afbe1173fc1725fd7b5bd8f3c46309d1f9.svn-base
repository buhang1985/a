package iih.bl.pay.ip.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.s.bp.DoIpPaymentBP;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院发票重打，原发票号作为空白票作废，使用新发票
 * @author yangyang
 */
public class IpIncRePrintBp {
	public BlStIpPayInvoceInfoDTO exec(String strCodest,OperatorInfoDTO operatorInfoDto) throws BizException
	{
		if (StringUtil.isEmpty(strCodest)) {
			throw new BizException("没有传入结算流水号！");
		}
		// 查找原结算信息
		IBlstipRService iBlstIpRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] blStIpDOArr = iBlstIpRService.findByAttrValString("Code_st", strCodest);
		if (ArrayUtil.isEmpty(blStIpDOArr))
			throw new BizException("未找到结算信息，请核对结算流水号是否正确！");
		// 1.操作合法性校验，判断是否可以重打印发票
		// 校验原发票信息是否已经结账，如果已经结账，则不再可以重打，应该不会出现该问题，一般重打是因为打印机卡纸
		IBlincipRService iBlincIpRService = ServiceFinder.find(IBlincipRService.class);
		BlincipAggDO[] blincIpAggDOArr = iBlincIpRService.findByAttrValString(BlIncIpDO.ID_STIP, blStIpDOArr[0].getId_stip());
		
		// 原发票信息
		BlIncIpDO blincIpDo = null;
		if (!ArrayUtil.isEmpty(blincIpAggDOArr)) {
			blincIpDo = blincIpAggDOArr[0].getParentDO();
		}
		// 校验发票信息，只能处理未记账以及本人开立的发票
		if (blincIpDo.getFg_cc_out().booleanValue())
			throw new BizException("该发票已经结账，不能再补打发票！");
		
		// 非本人开具不能补打
		if (!blincIpDo.getId_emp_inc().equals(operatorInfoDto.getId_emp()))
			throw new BizException("该发票非本人开具，请找相关开票人员补打！");
		
		// 2.作废原发票
		IBLInvoiceService incService = ServiceFinder.find(IBLInvoiceService.class);
		// 考虑到分票的情况，一次结算对应多张发票，则对于原发票单独处理
		for (BlincipAggDO incAggdo : blincIpAggDOArr) {
			// 原发票
			BlIncIpDO blIncIpDO = incAggdo.getParentDO();
			// 作废空白票
			BlIncCancDO blIncCancDO = new BlIncCancDO();
			blIncCancDO.setCode_incpkg(blIncIpDO.getCode_incpkg());
			blIncCancDO.setIncno(blIncIpDO.getIncno());
			blIncCancDO.setId_emp_canc(operatorInfoDto.getId_emp());
			blIncCancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
			blIncCancDO.setId_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
			blIncCancDO.setId_incca(IBdPpCodeTypeConst.ID_INHOS_INVOICE);
			blIncCancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_OTHER);
			blIncCancDO.setDt_canc(AppUtils.getServerDateTime());
			blIncCancDO.setFg_canc(FBoolean.TRUE);
			blIncCancDO.setId_grp(operatorInfoDto.getId_grp());
			blIncCancDO.setId_org(operatorInfoDto.getId_org());
			blIncCancDO.setStatus(DOStatus.NEW);
			// 原发票作为空白票作废
			incService.AddBlIncCanc(operatorInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_INHOS_INVOICE, blIncCancDO);

			// 更新原发票信息
			// 获取最新发票信息
			BlIncissOepDTO incIssOepDto = incService.useReceipt(operatorInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_INHOS_INVOICE);
			// 更新的门诊发票
			blIncIpDO.setIncno(incIssOepDto.getIncno_cur());
			blIncIpDO.setCode_incpkg(incIssOepDto.getCode_incpkg());
			blIncIpDO.setDt_inc(AppUtils.getServerDateTime());
			blIncIpDO.setStatus(DOStatus.UPDATED);

		}
		IBlincipCudService iBlincIpCudService = ServiceFinder.find(IBlincipCudService.class);
		BlincipAggDO[] blincIpAggDOArrUpdated = iBlincIpCudService.save(blincIpAggDOArr);
		
		//获取收款信息,住院涉及到欠款结算，所以结算对收付款可以是1对多
		IBlpaypatipRService paypatIpRService=ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO[] paypatIpAggDoArr=paypatIpRService.findByAttrValString(BlPayPatIpDO.ID_STIP,blStIpDOArr[0].getId_stip());
		
		IPativisitRService entService=ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(blStIpDOArr[0].getId_ent());
		
		List<String> lstPaypat=new ArrayList<String>();
		for(BlpaypatipAggDO aggDo:paypatIpAggDoArr)
		{
			BlPayItmPatIpDO[] paypatItmDoArr=aggDo.getBlPayItmPatIpDO();
			for(BlPayItmPatIpDO payItmpatDo:paypatItmDoArr)
			{
				if(IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(payItmpatDo.getSd_pm()))
				{
					lstPaypat.add(payItmpatDo.getId_paypat());
				}
			}
		}
		//获取预交金使用记录
		IBlpaypatRService paypatRService=ServiceFinder.find(IBlpaypatRService.class);
		BlPrePayPatDO[] prepayDoArr=paypatRService.findByIds(lstPaypat.toArray(new String[lstPaypat.size()]), FBoolean.FALSE);
		//组装发票
		DoIpPaymentBP ipPayBp=new DoIpPaymentBP();
		return ipPayBp.setBlStIpPayInncaInfo(patiVisitDO,blStIpDOArr[0],blincIpAggDOArrUpdated[0],paypatIpAggDoArr[0],prepayDoArr);
	}
}
