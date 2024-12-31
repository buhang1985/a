package iih.bl.pay.prepayacctrans.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import iih.pi.acc.account.i.IAccountMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 住院账户转门诊账户-预交金账户转移
 * @author li_pengying
 *
 */
public class IpToOepPrepayAcctransBp {
	/**
	 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * 更新患者门诊账户和就诊账户信息，向患者收付款表中插入两条转入、转出记录，当【住院就诊账户转入患者门诊账户时】调用
	 * @param blpreppDO
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 */
	public void  execAccTransIpToOep(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)throws BizException {
		// TODO Auto-generated method stub
		//更新患者门诊账户信息-住院转入门诊账户
			this.updatePiPatAccInfo_IpToOep(ppatDTO.getAmt_trans(),pipatdo);
		    //更新本次就诊的住院账户信息-住院转入门诊账户时
			this.updateEnAccountInfo_IpToOep(ppatDTO.getAmt_trans(),eacdo);
			//转入或者转出数据保存
			this.inSertBlPreypaypatInfo_transin_IpToOep(blpreppDO,ppatDTO,pipatdo,eacdo);
			this.inSertBlPrepaypatInfo_transout_IpToOep(blpreppDO,ppatDTO,pipatdo,eacdo);
	}
	
	/**
	 * 当[住院就诊账户转入患者门诊账户]时调用,更新患者门诊账户信息，
	 * @param amt_trans
	 * @param pipatdo
	 * @throws BizException
	 */
	private void updatePiPatAccInfo_IpToOep(FDouble amt_trans, PiPatAccDO pipatdo)throws BizException {
		// TODO Auto-generated method stub
	  
		FDouble  prepay_new= pipatdo.getPrepay().add(amt_trans);
		StringBuilder queryStr = new StringBuilder();
		queryStr.append(" a0.id_pat = '").append(pipatdo.getId_pat()).append("'");
		
		IAccountMDOCudService accDService = (IAccountMDOCudService)ServiceFinder.find(IAccountMDOCudService.class);
		IAccountMDORService accRService = (IAccountMDORService)ServiceFinder.find(IAccountMDORService.class);
		PiPatAccDO[] accountArr = accRService.find(queryStr.toString(),"",FBoolean.FALSE);
		for(PiPatAccDO piPatAccDO:accountArr){
			piPatAccDO.setPrepay(prepay_new);
			piPatAccDO.setStatus(DOStatus.UPDATED);
			}
		accDService.save(accountArr);
	}
	
	/**
	 * 当[住院就诊账户转入患者门诊账户]时调用,更新住院就诊账户信息
	 * 
	 * @param amt_trans
	 * @param eacdo
	 * @throws BizException
	 */
	private void updateEnAccountInfo_IpToOep(FDouble amt_trans, EnAccountDO eacdo)throws BizException {
		// TODO Auto-generated method stub
    	IEnOutCmdService enservice=ServiceFinder.find(IEnOutCmdService.class);
		FDouble dd=amt_trans.multiply(-1);
		enservice.recharge(eacdo.getId_ent(),dd);
		
	}
	
	/**
	 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * 向Bl_prepay_pat插入一条    [住院就诊账户转入患者门诊账户]的转入记录：当【住院就诊账户转入患者门诊账户时】需要插入   【转入记录】  时调用，此时收付款类型为【患者门诊预交金】
	 * @param blpreppDO
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 * @throws BizException
	 */
	private void inSertBlPreypaypatInfo_transin_IpToOep(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)throws BizException {
		// TODO Auto-generated method stub
		BlPrePayPatDO  blprepaypatdo=new BlPrePayPatDO();
		blprepaypatdo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		blprepaypatdo.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		blprepaypatdo.setId_enttp("");
		blprepaypatdo.setCode_enttp("");
		blprepaypatdo.setId_ent("");
		blprepaypatdo.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_CHARGE));
		blprepaypatdo.setAmt(ppatDTO.getAmt_trans());
		blprepaypatdo.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		blprepaypatdo.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
		TimeService timeService = new TimeServiceImpl();
	    FDateTime Timenow =timeService.getUFDateTime();
	    blprepaypatdo.setDt_pay(Timenow);
	    blprepaypatdo.setFg_cc(FBoolean.FALSE);
	    blprepaypatdo.setFg_canc(FBoolean.FALSE);
	    if(pipatdo!=null&&pipatdo.getId_pat() !=null){
	   	 blprepaypatdo.setId_pat(pipatdo.getId_pat());	
	   }else{
	   	blprepaypatdo.setId_pat("");
	   }
	  
	    blprepaypatdo.setId_grp(Context.get().getGroupId());
	    blprepaypatdo.setId_org(Context.get().getOrgId());
	    blprepaypatdo.setId_org_pay(blpreppDO.getId_org_pay());
	    blprepaypatdo.setId_dep_pay(blpreppDO.getId_dep_pay());
	    blprepaypatdo.setId_emp_pay(blpreppDO.getId_emp_pay());
	   //当前登录用户的机构名称、用户名、操作员、操作员所属部门、当前就诊的id_ent值都需要从前台获取，之后传到后台中通过service保存
	    IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
	    blprepaypatdo.setStatus(DOStatus.NEW);
		payService.save(new BlPrePayPatDO[]{blprepaypatdo});
	}

	
	/**
	 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
	 * 向Bl_prepay_pat插入一条[住院就诊账户转入患者门诊账户]的转出记录，当【住院就诊账户转入患者门诊账户时】需要插入【转出记录】时调用，此时收付款类型为【住院流程预交金】
	 * @param blpreppDO
	 * @param ppatDTO
	 * @param pipatdo
	 * @param eacdo
	 * @throws BizException
	 */
	private void inSertBlPrepaypatInfo_transout_IpToOep(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)throws BizException {
		// TODO Auto-generated method stub
		BlPrePayPatDO  blprepaypatdo=new BlPrePayPatDO();
		blprepaypatdo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		blprepaypatdo.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		blprepaypatdo.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		blprepaypatdo.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		blprepaypatdo.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_REFUND));
		blprepaypatdo.setAmt(ppatDTO.getAmt_trans());
		blprepaypatdo.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
		blprepaypatdo.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
		TimeService timeService = new TimeServiceImpl();
	    FDateTime Timenow =timeService.getUFDateTime();
	    blprepaypatdo.setDt_pay(Timenow);
	    blprepaypatdo.setFg_cc(FBoolean.FALSE);
	    blprepaypatdo.setFg_rep_return(FBoolean.FALSE);
	    blprepaypatdo.setFg_canc(FBoolean.FALSE);
	    blprepaypatdo.setId_ent(eacdo.getId_ent());
	    
	    if(pipatdo!=null&&pipatdo.getId_pat()!=null)
	    {
	   	 blprepaypatdo.setId_pat(pipatdo.getId_pat());	
	    }else
	      {
	   	    blprepaypatdo.setId_pat("");
	      }
	  
	    blprepaypatdo.setId_grp(Context.get().getGroupId());
	    blprepaypatdo.setId_org(Context.get().getOrgId());
	    blprepaypatdo.setId_org_pay(blpreppDO.getId_org_pay());
	    blprepaypatdo.setId_dep_pay(blpreppDO.getId_dep_pay());
	    blprepaypatdo.setId_emp_pay(blpreppDO.getId_emp_pay());
	  //当前登录用户的机构名称、用户名、操作员、操作员所属部门、当前就诊的id_ent值都需要从前台获取，之后传到后台中通过service保存
	    IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
	    blprepaypatdo.setStatus(DOStatus.NEW);
		payService.save(new BlPrePayPatDO[]{blprepaypatdo});	
	}

}
