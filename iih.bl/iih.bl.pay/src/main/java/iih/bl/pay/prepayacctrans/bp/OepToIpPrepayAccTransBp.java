package iih.bl.pay.prepayacctrans.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blprepay.ep.UpdateAccInfoEp;
import iih.bl.pay.bp.qry.GetInvoiceInfoBP;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.s.ep.PrepayPatRcptEP;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.d.PiPatAccDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**门诊账户转住院账户
 * 
 * @author li_pengying
 *
 */
public class OepToIpPrepayAccTransBp {
	
	/**
	 *  这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * 更新患者门诊账户和就诊账户信息，向患者收付款明细中插入两条转入转出记录,当 【门诊账户转入住院账户时】  调用
	 * @param blpreppDO  前台带过来的一条预交金数据，
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 * @throws BizException
	 */
	public String execAccTransOepToIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)throws BizException {
		// 1.修改该患者的门诊账户金额  2.修改该患者的本次住院账户金额  3.插入一条门诊转住院的转入记录   4.插入一条门诊转住院的转出预交金记录
		
		   //1.门诊账户信息修改
		  this.updatePiPatAccInfo_OepTOIp(ppatDTO.getAmt_trans(),pipatdo);
		  //2。本次住院就诊账户信息修改
		  this.updateEnAccountInfo_OepTOIp(ppatDTO.getAmt_trans(),eacdo);
		  //3.门诊账户转入住院账户时-插入一条【门诊转住院的预交金数据】转入记录，
		  String id_pay = this.inSertBlPreypaypatInfo_transin_OepTOIp(blpreppDO,ppatDTO, pipatdo, eacdo);
		  //4.门诊账户转入住院账户时-插入一条【门诊转出记录的预交金数据】记录
		  this.inSertBlPrepaypatInfo_transout_OepTOIp(blpreppDO,ppatDTO,pipatdo, eacdo);
		  
		  return id_pay;
	}
	
	/**
	 * 当门诊账户转入住院时调用,更新患者门诊账户信息，门诊账户里金额减少amt元
	 * @param amt
	 * @param pipatdo
	 */
	private void updatePiPatAccInfo_OepTOIp(FDouble amt, PiPatAccDO pipatdo)throws BizException
	{
    	BlPrePayPatDO newdo= new BlPrePayPatDO();
		newdo.setId_pat(pipatdo.getId_pat());
		UpdateAccInfoEp updateEp = new UpdateAccInfoEp();
		double amttrans =  (amt.multiply(-1)).doubleValue() ;
		updateEp.updatePiPatAccInfo(amttrans, newdo, IBdFcDictCodeConst.ID_CODE_ENTP_OP);
	}
	
	
	/**
	 * 当门诊账户转入住院时调用,更新患者住院的本次就诊账户信息，
	 * @param amt_trans
	 *
	 * @param eacdo
	 */
	private void updateEnAccountInfo_OepTOIp(FDouble amt_trans,EnAccountDO eacdo)throws BizException{
		// 1.更新本次住院账户余额  2.将票号后移一位
		
		// 1.更新本次住院账户余额
		 IEnOutCmdService enservice=ServiceFinder.find(IEnOutCmdService.class);
		 enservice.recharge(eacdo.getId_ent(),amt_trans);
		//2.将票号后移一位
		//患者收到了一笔住院预交金，在前台打印了押金条，需要将票号后移，调用票号后移接口
		/*IBLInvoiceService incSer=ServiceFinder.find(IBLInvoiceService.class);
		incSer.NextInvoiceNoUpdateCurNo(Context.get().getStuffId(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);*/
		 
//		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
//		incService.nextInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT);
	}
	
	/**
	 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * 向Bl_prepay_pat插入一条    门诊转入住院的转入记录：当门诊转住院后需要插入   【转入记录】  时调用,此时生成的这条预交金数据的付款类型为【住院（流程）就诊预交金】
	 * @param blpreppDO
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 * @throws BizException
	 */
	private String inSertBlPreypaypatInfo_transin_OepTOIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)  throws BizException{
		
		BlPrePayPatDO blprepaypatdo=new BlPrePayPatDO();
		blprepaypatdo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYTRANSFERFROMOP);
		blprepaypatdo.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYTRANSFERFROMOP);
		blprepaypatdo.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		blprepaypatdo.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		
		blprepaypatdo.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_CHARGE));
		  if(ppatDTO!=null){
			  blprepaypatdo.setAmt(ppatDTO.getAmt_trans());
		    }
		
		blprepaypatdo.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		blprepaypatdo.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
        blprepaypatdo.setDt_pay(AppUtils.getServerDateTime());
	    blprepaypatdo.setFg_cc(FBoolean.FALSE);
	    blprepaypatdo.setId_cc(null);
	    blprepaypatdo.setId_bank(null);
	    blprepaypatdo.setBankno(null);
	    blprepaypatdo.setPaymodecode(null);
	    blprepaypatdo.setFg_canc(FBoolean.FALSE);
	    
	    if(eacdo!=null&&eacdo.getId_ent()!=null){
	    	 blprepaypatdo.setId_ent(eacdo.getId_ent());	
	    }else{
	    	 blprepaypatdo.setId_ent("");
	    }
	    blprepaypatdo.setId_pat(pipatdo.getId_pat());
	    if(pipatdo!=null&&pipatdo.getId_pat()!=null){
	   	 blprepaypatdo.setId_pat(pipatdo.getId_pat());	
	   }else{
	   	blprepaypatdo.setId_pat("");
	   }
	  
	    blprepaypatdo.setId_grp(Context.get().getGroupId());
	    blprepaypatdo.setId_org(Context.get().getOrgId());
	    blprepaypatdo.setId_org_pay(blpreppDO.getId_org_pay());
	    blprepaypatdo.setId_dep_pay(blpreppDO.getId_dep_pay());
	    blprepaypatdo.setId_emp_pay(blpreppDO.getId_emp_pay());
	    blprepaypatdo.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
	    //添加票据类型编码
	    blprepaypatdo.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
	    blprepaypatdo.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		if (FBoolean.TRUE.equals(BlParams.BLINC0018())) {
			blprepaypatdo.setCode_rep(BlCodeUtils.generateIpPrepayCode());
		} else {
			GetInvoiceInfoBP incbp = new GetInvoiceInfoBP();
			blprepaypatdo.setCode_rep(incbp.getInvoiceInfo(blpreppDO.getId_emp_pay(), IBdFcDictCodeConst.ID_CODE_ENTP_IP));
		}
	    blprepaypatdo.setFg_rep_return(null);
	    blprepaypatdo.setSd_rep_lost(null);
	    blprepaypatdo.setDt_return(null);
	    blprepaypatdo.setId_emp_return(null);
	    blprepaypatdo.setId_par(null);
	    blprepaypatdo.setId_st_mid(null);
	    blprepaypatdo.setId_emp_canc(null);
	    blprepaypatdo.setDt_canc(null);
	    blprepaypatdo.setNote("门诊预交金转住院-转入记录");
	    
	    blprepaypatdo.setStatus(DOStatus.NEW);
	   //当前登录用户的机构名称、用户名、操作员、操作员所属部门、当前就诊的id_ent值都需要从前台获取，之后传到后台中通过service保存
	    IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
	    BlPrePayPatDO[] blPrePayPatDOs = payService.save(new BlPrePayPatDO[]{blprepaypatdo});
	    
	    if(!ArrayUtil.isEmpty(blPrePayPatDOs)){
	    	PrepayPatRcptEP ep = new PrepayPatRcptEP();
	    	ep.saveRcptPrint(blPrePayPatDOs[0],null);
	    	return blPrePayPatDOs[0].getId_paypat();
	    }
	    return null;
	}
	
	/**
	 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * 向Bl_prepay_pat插入一条门诊转住院的转出记录，当门诊转入住院账户后需要插入【转出记录】时调用，此时生成的这条预交金数据的付款类型为【患者【门诊】预交金】
	 * @param blpreppDO
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 */
	private void inSertBlPrepaypatInfo_transout_OepTOIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)  throws BizException{
		// TODO Auto-generated method stub
		BlPrePayPatDO blprepaypatdo=new BlPrePayPatDO();
		blprepaypatdo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		blprepaypatdo.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		blprepaypatdo.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		blprepaypatdo.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		blprepaypatdo.setId_ent("");    //门诊类型的预交金不需要
		blprepaypatdo.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_REFUND));
		
		  if(ppatDTO!=null){
			  blprepaypatdo.setAmt(ppatDTO.getAmt_trans());
		    }
		blprepaypatdo.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		blprepaypatdo.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
        blprepaypatdo.setDt_pay(AppUtils.getServerDateTime());
	    blprepaypatdo.setFg_cc(FBoolean.FALSE);
	    blprepaypatdo.setFg_rep_return(FBoolean.FALSE);
	    blprepaypatdo.setFg_canc(FBoolean.FALSE);
	    blprepaypatdo.setId_grp(Context.get().getGroupId());
	    blprepaypatdo.setId_org(Context.get().getOrgId());
	    blprepaypatdo.setId_org_pay(blpreppDO.getId_org_pay());
	    blprepaypatdo.setId_dep_pay(blpreppDO.getId_dep_pay());
	    blprepaypatdo.setId_emp_pay(blpreppDO.getId_emp_pay());
	    blprepaypatdo.setId_cc(null);
	    blprepaypatdo.setCode_rep(null);
	    blprepaypatdo.setFg_rep_return(FBoolean.FALSE);
	    blprepaypatdo.setSd_rep_lost(null);
	    blprepaypatdo.setDt_return(null);
	    blprepaypatdo.setId_emp_return(null);
	    blprepaypatdo.setId_par(null);
	    blprepaypatdo.setId_st_mid(null);
	    blprepaypatdo.setId_emp_canc(null);
	    blprepaypatdo.setDt_canc(null);
	    blprepaypatdo.setNote("门诊预交金转住院-转出记录");
	    
	    //添加 票据类型赋值 
	    blprepaypatdo.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_DEPOSIT);
	    blprepaypatdo.setCode_incca(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT);
	    blprepaypatdo.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
	    if(pipatdo!=null&&pipatdo.getId_pat()!=null){
	    	 blprepaypatdo.setId_pat(pipatdo.getId_pat());	
	    }else{
	    	blprepaypatdo.setId_pat("");
	    }
	    
	    PrepayPatRcptEP ep = new PrepayPatRcptEP();
	    BlPrepayPatRcptDO rcptDO = ep.saveRcptPrint(blprepaypatdo,null);
	    
	    blprepaypatdo.setCode_rep(rcptDO.getCode_rep());
	    blprepaypatdo.setStatus(DOStatus.NEW);
	    
	    IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
		payService.save(new BlPrePayPatDO[]{blprepaypatdo});
	}

}
