package iih.bl.pay.service.s;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.bp.BlpaypatCrudBp;
import iih.bl.pay.blpaypat.bp.SavePrePayInfoBp;
import iih.bl.pay.blpaypat.bp.et.RefundPrepayETBp;
import iih.bl.pay.blpaypat.bp.ip.SavePrepayInfoIpBp;
import iih.bl.pay.blpaypat.bp.ip.RefundPrepayIpBp;
import iih.bl.pay.blpaypat.bp.op.OpAbolishBp;
import iih.bl.pay.blpaypat.bp.op.PrepayPatOpBp;
import iih.bl.pay.blpaypat.bp.op.RefundPrepayOpBp;
import iih.bl.pay.blpaypat.bp.op.TransferBalanceToPatAccBp;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blprepay.ep.BlPrepayPatDOEp;
import iih.bl.pay.blprepay.ep.SetBlPrePayRefundEp;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.designedfundspkgcollect.bp.DesignedFundsPkgCollectBp;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.bl.pay.prepayacctrans.bp.IpToOepPrepayAcctransBp;
import iih.bl.pay.prepayacctrans.bp.OepToIpPrepayAccTransBp;
import iih.bl.pay.prepayacctrans.bp.PrepayacctransBp;
import iih.bl.pay.service.i.IBLPayMaintainService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.patsrvpkg.dto.PiPatSrvPkgTotalDTO;
import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;


@Service(serviceInterfaces={IBLPayMaintainService.class}, binding=Binding.JSONRPC)
public class BLPayMaintainServiceImpl implements IBLPayMaintainService {

	/**
	 * 收预交金数据的保存，门诊/住院公用，根据支付类型来区分是门诊/住院
	 */
	@Override
	public BlPrePayPatDO[] saveBlPayPatItem(BlPayPatItemDTO blPayPatItemDTO,
			BlPrePayPatDO blPayPatDO, String payType) throws BizException {
	//	PrepayPatIpBp bp  =new PrepayPatIpBp();
	//	return  bp.saveBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
		
		
		SavePrePayInfoBp savebp = new SavePrePayInfoBp();
		return savebp.execSaveBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//return blpaypatCrudBp.saveBlPayPatInfo(blPayPatItemDTO, blPayPatDO, payType);
	}
	
	/**
	 * 目前供门诊收费节点，退费节点，住院收付款节点使用：
	 * 收、退费方式为预交金，即在预交金中增加相关一条预交金操作记录，并修改预交金账户金额
	 * @param payment_prepay_amt 支付的预交金金额
	 * @param id_pat 患者ID
	 * @param operatorInfoDTO 操作员信息
	 * @param eu_direct 预交金收付款方向
	 * @param entType 就诊类型
	 * @param sd_paytp 收付款方式SD
	 * @param id_paytp 收付款方式iD
	 * @param note 备注
	 * @return
	 * @throws BizException    
	 */
	@Override
	public  BlPrePayPatDO[] saveBlPayPatInfoByPay(FDouble payment_prepay_amt,String id_pat,OperatorInfoDTO operatorInfoDTO,Integer eu_direct,String entType,String sd_paytp,String id_paytp,String note) throws BizException
	{
		PrepayPatOpBp  prepaybp =new PrepayPatOpBp();
		BlPrePayPatDO[] doArr=	prepaybp.saveBlPayPatInfoRefund( payment_prepay_amt, id_pat, operatorInfoDTO, eu_direct, entType, sd_paytp, id_paytp, note);
     	return doArr;
		
	//	BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
	//	return blpaypatCrudBp.saveBlPayPatInfoRefund( payment_prepay_amt, id_pat, operatorInfoDTO, eu_direct, entType, sd_paytp, id_paytp, note);

	}
	
	
	public  BlPrePayPatDO[] TransferBalanceToPatacc(BlPayItmPatOepDO blPayItmPatOepdo,String id_pat,OperatorInfoDTO operatorInfoDTO,String entType,String note) throws BizException
	{
		TransferBalanceToPatAccBp  bp=new  TransferBalanceToPatAccBp();
		return bp.transferBalanceToPatAcc(blPayItmPatOepdo, id_pat, operatorInfoDTO, entType, note);
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//return blpaypatCrudBp.transferBalanceToPatAcc(blPayItmPatOepdo, id_pat, operatorInfoDTO, entType, note);
	}
	
	/**
	 * 门诊作废预交金数据，目前只供门诊的使用，
	 */
	@Override
	public void abolishBlPayPat(BlPrePayPatDO blPayPatDO, BlPrePayPatDO abolishDO,
			String payType) throws BizException {
		OpAbolishBp bp=new OpAbolishBp();
	    bp.execAbolishInfo(blPayPatDO, abolishDO, payType);
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//blpaypatCrudBp.abolishBlPayPatInfo(blPayPatDO, abolishDO, payType);
	}

/**
 * 预交金账户转移：门诊转住院
 */
	@Override
	public String PrepayAcctransProcessingOepToIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo,EnAccountDO eacdo)
			throws BizException {
		// TODO Auto-generated method stub
		//PrepayacctransBp bp=new PrepayacctransBp();
	    //bp.PrepayAcctransProcessingOepToIp(blpreppDO,ppatDTO,pipatdo,eacdo);
	    
	    OepToIpPrepayAccTransBp transbp = new OepToIpPrepayAccTransBp();
	    return transbp.execAccTransOepToIp(blpreppDO,ppatDTO,pipatdo,eacdo);
	}
	
/**
 * 住院转门诊：预交金账户转移
 */
	@Override
	public void PrepayAcctransProcessingIpToOep(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO, PiPatAccDO pipatdo, EnAccountDO eacdo)
			throws BizException {
		// TODO Auto-generated method stub
		//PrepayacctransBp bp=new PrepayacctransBp();
	    //bp.PrepayAcctransProcessingIpToOep(blpreppDO,ppatDTO,pipatdo,eacdo);
	    
	    IpToOepPrepayAcctransBp transbp = new IpToOepPrepayAcctransBp();
	    transbp.execAccTransIpToOep(blpreppDO,ppatDTO,pipatdo,eacdo);
	}

	
	/**
	 *门诊 预交金退款   ，给刘羽提供接口用
	 * @param blpreppDO 
	 * */
	@Override
	public FBoolean doBlPrePayRefund(BlPrePayPatDO blpreppDO)
			throws BizException {
		SetBlPrePayRefundEp  ep=new SetBlPrePayRefundEp();
		return  ep.setBlPrePayRefund(blpreppDO);
		
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//return blpaypatCrudBp.setBlPrePayRefund(blpreppDO);
	}

	
	/**
	 * 用于优惠包销售（专用款收款节点），更新患者领域的数据，对新增的患者域数据 、bl域数据插入数据库并保存，目前在用
	 * author: li_pengying
	 */
	@Override
	public   FBoolean doSaveNewAndUpdateData(PiPatSrvPkgDO[] ppspDOArr, PiPatSrvPkgTotalDTO[] pkgs, BlPrePayPatDO[]  blpppDOArr,
            BlspclpatAggDO[] blspclpatAggDOArr, BlpayspclAggDO blpayspclAggDO) throws BizException{
		DesignedFundsPkgCollectBp bp=new DesignedFundsPkgCollectBp();
		return bp.doSaveNewAndUpdateData(ppspDOArr,pkgs,blpppDOArr, blspclpatAggDOArr, blpayspclAggDO);
	}

/**
 * 门诊预交金退款
 */
	@Override
	public BlPrePayPatDO doBlPayPatInfoRefund(BlPayPatItemDTO blPayPatItemDTO, String id_pat,String sd_pttp) throws BizException {
		RefundPrepayOpBp  bp = new RefundPrepayOpBp();
		return  bp.execRefundOpInfo(blPayPatItemDTO, id_pat,sd_pttp); //menzhen
		
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//return blpaypatCrudBp.refundBlPayPatInfo(blPayPatItemDTO, id_pat,sd_pttp);
	}
	
	/**
     * 留观预交金退款
     */
	public BlPrePayPatDO doBlPayPatETInfoRefund(BlPayPatItemDTO blPayPatItemDTO, String id_pat,String sd_pttp) throws BizException {
		RefundPrepayETBp  bp = new RefundPrepayETBp();
		return  bp.execRefundETInfo(blPayPatItemDTO, id_pat,sd_pttp); //menzhen
	}
	
     /**
      * 住院预交金退款
      */
	@Override
	public FBoolean doBlPayPatIpInfoRefund(BlPrePayPatDO blPrePayPatDO,
			BlPayPatItemDTO blPayPatItemDTO) throws BizException {
		RefundPrepayIpBp  rebp=new RefundPrepayIpBp();
	    return 	rebp.execRefundIpInfo(blPrePayPatDO, blPayPatItemDTO);//zhuyuan
		
		//BlpaypatCrudBp blpaypatCrudBp = new BlpaypatCrudBp();
		//return blpaypatCrudBp.refundIpBlPrePayInfo(blPrePayPatDO, blPayPatItemDTO);
	}


	
}
