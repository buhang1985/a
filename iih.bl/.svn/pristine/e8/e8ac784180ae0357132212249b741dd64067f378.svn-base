package iih.bl.pay.prepayacctrans.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import iih.pi.acc.account.i.IAccountMDORService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/** 文件头注释
* ==============================================================================
* @Filename: PrepayacctransBp   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author li_pengying
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description: 预交金转移节点所用接口中各个方法的实现类
* ==============================================================================
*/
public class PrepayacctransBp {

	/**
	 *
	 * 通过患者的id和就诊类型id找到患者的门诊或者住院的所有就诊的预交金数据
	 * @param id_pat
	 * @param id_enttp
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[]  getBlPrePayPatDOByQuery(String id_pat,String id_enttp) throws BizException {
		StringBuffer sb=new StringBuffer();
		sb.append("select t.id_paypat ,t.id_grp,t.id_org,t.id_paytp,t.sd_paytp,t.id_pat,t.id_enttp,t.code_enttp,t.id_ent,t.eu_direct,t.amt,t.id_pm,t.sd_pm,t.id_bank,t.bankno,t.paymodenode,t.dt_pay,t.id_org_pay,t.id_dep_pay,t.id_emp_pay,t.id_cc,t.id_incca,t.code_incca,t.code_rep,t.fg_rep_return,t.dt_return,t.id_emp_return,t.id_st_mid,t.fg_canc,t.id_emp_canc,t.ds,t.sv,t.fg_cc from bl_prepay_pat t  where t.id_ent=? and t.id_enttp=? order by dt_pay desc");
		SqlParam sp=new SqlParam();
		sp.addParam(id_pat);
		sp.addParam(id_enttp);
		List<BlPrePayPatDO> list= (List<BlPrePayPatDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(BlPrePayPatDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 BlPrePayPatDO[] bldos= list.toArray(new BlPrePayPatDO[0]);
			 return bldos; 
		 }else {
			 return null;
		 }
		}
	
	/**
	 * 门诊账户对应的预交金
	 * 通过患者banner所提供的id_pat,sd_paytp来得到患者的门诊账户的收付款明细信息， ,sd_paytp 应该是门诊类型的即为“11” 或者“21”,用于显示门诊明细（左侧表格）
     * @param id_pat
     * @param sd_paytp
	 * @return  
	 * @throws BizException
	 */
	public BlPrePayPatDO[]  getBlPrePayPatDOsByIds(String id_pat,String sd_paytp)throws BizException{   // 门诊账户（左侧余额）
		StringBuffer sb=new StringBuffer();
		sb.append(" select t1.id_paypat ,t1.id_grp,t1.id_org,t1.id_paytp,t1.sd_paytp,t1.id_pat,t1.id_enttp,t1.code_enttp, "); 
		sb.append(" t1.id_ent,t1.eu_direct,t1.amt,t1.id_pm,t1.sd_pm,t1.id_bank,t1.bankno,t1.paymodenode,t1.dt_pay,t1.id_org_pay, "); 
        sb.append(" t1.id_dep_pay,t1.id_emp_pay,t1.id_cc,t1.id_incca,t1.code_incca,t1.code_rep,t1.fg_rep_return,t1.dt_return, "); 
        sb.append(" t1.id_emp_return,t1.id_st_mid,t1.fg_canc,t1.id_emp_canc,"); 
        sb.append(" t1.ds,t1.sv,t1.fg_cc, "); 
        sb.append(" t6.name as paymodename,t6.code as paymodecode,t2.name as emp_name,t2.code as emp_code "); 
		sb.append(" FROM BL_PREPAY_PAT t1 ");
		sb.append(" join bd_pri_pm t6    on  t1.id_pm = t6.id_pm  ");
		sb.append(" join  bd_psndoc t2   on  t1.id_emp_pay = t2.id_psndoc");
		//sb.append(" WHERE t1.ID_PAT = ? AND t1.SD_PAYTP =?  order by t1.dt_pay  desc");
		sb.append(" WHERE t1.ID_PAT = ? AND (t1.SD_PAYTP ='11' or t1.SD_PAYTP ='21')  order by t1.dt_pay  desc");
		
		
	    SqlParam sp=new SqlParam();
		sp.addParam(id_pat);
		//sp.addParam(sd_paytp); //此参数不用传入了，直接在sql里加入了参数取值
	    List<BlPrePayPatDO> list= (List<BlPrePayPatDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(BlPrePayPatDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 BlPrePayPatDO[] bldos= list.toArray(new BlPrePayPatDO[0]);
			 return bldos;   
		 }else {
			 return null;
		 }
	}

	/**
	 * 
	 * 通过患者banner所提供id_ent,id_pat来得到患者的门诊账户的余额信息， 用于显示门诊账户（左侧余额）
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public PiPatAccDO  getPiPatAccDOByIdpat(String id_pat)throws BizException{   // 门诊账户（左侧余额）
		StringBuffer sb=new StringBuffer();
	    sb.append("	select  t1.id_patacc,t1.id_pat,t1.id_accsta,t1.acc_lock,t1.code,t1.name,t1.prepay,t1.cred,t1.fg_active,t1.createdby,t1.createdtime,t1.sd_accsta,t1.ds,t1.modifiedby,t1.modifiedtime");
		sb.append("	FROM PI_PAT_ACC t1");
	    sb.append("	WHERE ID_PAT = ?");
	    SqlParam sp=new SqlParam();
		sp.addParam(id_pat);
	    List<PiPatAccDO> list= (List<PiPatAccDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(PiPatAccDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 PiPatAccDO[] bldos= list.toArray(new PiPatAccDO[0]);
			 return bldos[0]; 
		 }else {
			 return null;
		 }
	}
   
	/**
	 * 住院账户对应的预交金
	 * 通过患者banner所提供id_ent,id_pat来得到患者的当前就诊的住院就诊所包含的所有收付款信息， 用于显示  【住院明细（右侧表格）】
	 * @param id_pat
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[]  getBlPrePayPatDOsByIdpatident(String id_pat,String id_ent)throws BizException{   // 住院明细（右侧表格）
		StringBuffer sb=new StringBuffer();
		sb.append(" select t1.id_paypat ,t1.id_grp,t1.id_org,t1.id_paytp,t1.sd_paytp,t1.id_pat,t1.id_enttp,t1.code_enttp, "); 
		sb.append(" t1.id_ent,t1.eu_direct,t1.amt,t1.id_pm,t1.sd_pm,t1.id_bank,t1.bankno,t1.paymodenode,t1.dt_pay,t1.id_org_pay, "); 
        sb.append(" t1.id_dep_pay,t1.id_emp_pay,t1.id_cc,t1.id_incca,t1.code_incca,t1.code_rep,t1.fg_rep_return,t1.dt_return, "); 
        sb.append(" t1.id_emp_return,t1.id_st_mid,t1.fg_canc,t1.id_emp_canc,"); 
        sb.append(" t1.ds,t1.sv,t1.fg_cc, "); 
	    sb.append(" t6.name as paymodename,t6.code as paymodecode,t2.name as emp_name,t2.code as emp_code "); 
		sb.append(" FROM BL_PREPAY_PAT t1 ");
		sb.append(" join bd_pri_pm t6    on  t1.id_pm = t6.id_pm  ");
		sb.append(" join  bd_psndoc t2   on  t1.id_emp_pay = t2.id_psndoc");
		sb.append(" WHERE t1.ID_PAT = ? AND t1.id_ent =?  order by t1.dt_pay  desc");
		
	    SqlParam sp=new SqlParam();
	    sp.addParam(id_pat);
		sp.addParam(id_ent);
	    List<BlPrePayPatDO> list= (List<BlPrePayPatDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(BlPrePayPatDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 BlPrePayPatDO[] bldos= list.toArray(new BlPrePayPatDO[0]);
			 return bldos; 
		 }else {
			 return null;
		 }
	}
	
	/**
	 * 通过患者banner所提供id_ent,id_pat来得到患者的门诊账户的收付款明细信息，即得到门诊账户下的所有收付款信息，用于显示【住院账户（右侧余额）】
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public EnAccountDO  getEnAccountDOByIdentidpat(String id_ent,String id_pat)throws BizException{   // 住院账户（右侧余额）
        StringBuffer sb=new StringBuffer();
	  
	    sb.append("	SELECT  B.amt_cred,B.amt_owelimit,B.amt_prepay,B.amt_uncg,B.ds,B.dt_backcg,B.dt_backcglastact,B.id_ent,B.id_entacc,B.id_pat,B.sv ");
		sb.append("	FROM EN_ENT A");
	    sb.append("	JOIN EN_ENT_ACC B ON A.ID_ENT = B.ID_ENT  WHERE  A.ID_ENT =? AND A.ID_PAT =? ");
	    SqlParam sp=new SqlParam();
	    sp.addParam(id_ent);
		sp.addParam(id_pat);
	    List<EnAccountDO> list= (List<EnAccountDO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler(EnAccountDO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 EnAccountDO[] bldos= list.toArray(new EnAccountDO[0]);
			 return bldos[0]; 
		 }else {
			  return null;
		 }
	}
	
	/**
	 * 通过患者的id查找到患者的门诊和住院账户的余额
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public PrepayAccTransDTO[] getBalanceByIds(String id_pat)throws BizException  {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("select t1.prepay,t1.acc_lock,(t1.prepay-t1.acc_lock)as balance_pipatacc, t2.amt_prepay,t2.amt_uncg,(t2.amt_prepay-t2.amt_uncg)as balance_enentacc from pi_pat_acc t1 , en_ent_acc t2 where t1.id_pat= t2.id_pat and t1.id_pat=?");
		SqlParam sp=new SqlParam();
		sp.addParam(id_pat);
		List< PrepayAccTransDTO> list= (List< PrepayAccTransDTO>)new DAFacade().execQuery(sb.toString(),sp,new BeanListHandler( PrepayAccTransDTO.class));
		 if(!(list.isEmpty())&&list.size()>0){
			 PrepayAccTransDTO[] bldos= list.toArray(new  PrepayAccTransDTO[0]);
			 return bldos; 
		 }else {
			 return null;
		 }
	}
  
	

/**
 * 通过患者的主键id从住院就诊账户中找到该患者的所有就诊账户
 * @param id_pat
 * @param orderStr
 * @return
 * @throws BizException
 */
public EnAccountDO[] getEnAccountDOsByIdpat(String id_pat, String orderStr)throws BizException {
	// TODO Auto-generated method stub
	StringBuilder queryStr = new StringBuilder();
	queryStr.append("select t.amt_cred,t.amt_owelimit,t.amt_prepay,t.amt_uncg,t.ds,t.dt_backcg,t.dt_backcglastact,t.id_ent,t.id_entacc,t.id_pat,t.sv from en_ent_acc t where id_pat=? order by ?");
	SqlParam sp=new SqlParam();
	sp.addParam(id_pat);
	sp.addParam(orderStr);
	List<EnAccountDO> list= (List<EnAccountDO>)new DAFacade().execQuery(queryStr.toString(),sp,new BeanListHandler(EnAccountDO.class));
	 if(!(list.isEmpty())&&list.size()>0){
		 EnAccountDO[] bldos= list.toArray(new  EnAccountDO[0]);
		 return bldos; 
	 }else {
		 return null;
	 }
}

public PiPatAccDO[] getPiPatAccDOsByIdent(String id_ent, String orderStr)throws BizException  {
	// TODO Auto-generated method stub
	StringBuilder queryStr = new StringBuilder();
	queryStr.append("  select   t1.id_patacc,t1.id_pat,t1.id_accsta,t1.acc_lock,t1.code,t1.name,t1.prepay,t1.cred,t1.fg_active,t1.createdby,t1.createdtime,t1.sd_accsta,t1.ds,t1.modifiedby,t1.modifiedtime, ");
	queryStr.append("  t2.id_pat,t2.id_ent from pi_pat_acc t1  left join en_ent t2 on t1.id_pat=t2.id_pat  where id_ent=? order by ?");
	SqlParam sp=new SqlParam();
	sp.addParam(id_ent);
	sp.addParam(orderStr);
	List<PiPatAccDO> list= (List<PiPatAccDO>)new DAFacade().execQuery(queryStr.toString(),sp,new BeanListHandler(PiPatAccDO.class));
	 if(!(list.isEmpty())&&list.size()>0){
		 PiPatAccDO[] bldos= list.toArray(new PiPatAccDO[0]);
		 return bldos; 
	 }else {
		 return null;
	 }
}

/**
 *  这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
 * 更新患者门诊账户和就诊账户信息，向患者收付款明细中插入两条转入转出记录,当 【门诊账户转入住院账户时】  调用
 * @param blpreppDO
 * @param ppatDTO
 * @param pipatdo
 * @param eacdo
 * @throws BizException
 */
public void PrepayAcctransProcessingOepToIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)throws BizException {
	// TODO Auto-generated method stub
	//门诊账户信息修改
	  this.updatePiPatAccInfo_OepTOIp(ppatDTO.getAmt_trans(),pipatdo);
	  //本次住院就诊账户信息修改
	  this.updateEnAccountInfo_OepTOIp(ppatDTO.getAmt_trans(),eacdo);
	  //门诊账户转入住院账户时-插入一条【门诊转住院的预交金数据】转入记录，
	  this.inSertBlPreypaypatInfo_transin_OepTOIp(blpreppDO,ppatDTO, pipatdo, eacdo);
	  //门诊账户转入住院账户时-插入一条【门诊转出记录的预交金数据】记录
	  this.inSertBlPrepaypatInfo_transout_OepTOIp(blpreppDO,ppatDTO,pipatdo, eacdo);
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
private void inSertBlPreypaypatInfo_transin_OepTOIp(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)  throws BizException{
	// TODO Auto-generated method stub
	BlPrePayPatDO blprepaypatdo=new BlPrePayPatDO();
	blprepaypatdo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
	blprepaypatdo.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
	blprepaypatdo.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
	blprepaypatdo.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
	blprepaypatdo.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_CHARGE));
	  if(ppatDTO!=null){
		  blprepaypatdo.setAmt(ppatDTO.getAmt_trans());
	    }
	
	blprepaypatdo.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
	blprepaypatdo.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
	TimeService timeService = new TimeServiceImpl();
    FDateTime Timenow =timeService.getUFDateTime();
    blprepaypatdo.setDt_pay(Timenow);
    blprepaypatdo.setFg_cc(FBoolean.FALSE);
    blprepaypatdo.setId_cc(null);
    blprepaypatdo.setId_bank(null);
    blprepaypatdo.setBankno(null);
    blprepaypatdo.setPaymodecode(null);
    blprepaypatdo.setFg_canc(FBoolean.FALSE);
    
    if(eacdo!=null&&eacdo.ID_ENT!=null){
    	 blprepaypatdo.setId_ent(eacdo.getId_ent());	
    }else{
    	 blprepaypatdo.setId_ent("");
    }
    blprepaypatdo.setId_pat(pipatdo.getId_pat());
    if(pipatdo!=null&&pipatdo.ID_PAT!=null){
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
    IBLInvoiceService incService=(IBLInvoiceService)ServiceFinder.find(IBLInvoiceService.class);
    String strincno= incService.GetInvoiceNo(blpreppDO.getId_emp_pay(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
    blprepaypatdo.setCode_rep(strincno);
    blprepaypatdo.setFg_rep_return(null);
    blprepaypatdo.setSd_rep_lost(null);
    blprepaypatdo.setDt_return(null);
    blprepaypatdo.setId_emp_return(null);
    blprepaypatdo.setId_par(null);
    blprepaypatdo.setId_st_mid(null);
    blprepaypatdo.setId_emp_canc(null);
    blprepaypatdo.setDt_canc(null);
    blprepaypatdo.setNote("门诊预交金转住院-转入记录");
   //当前登录用户的机构名称、用户名、操作员、操作员所属部门、当前就诊的id_ent值都需要从前台获取，之后传到后台中通过service保存
    IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
    blprepaypatdo.setStatus(DOStatus.NEW);
	payService.save(new BlPrePayPatDO[]{blprepaypatdo});	
      
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
	blprepaypatdo.setId_enttp("");
	blprepaypatdo.setCode_enttp("");
	blprepaypatdo.setId_ent("");    //门诊类型的预交金不需要
	blprepaypatdo.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_REFUND));
	
	  if(ppatDTO!=null){
		  blprepaypatdo.setAmt(ppatDTO.getAmt_trans());
	    }
	blprepaypatdo.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
	blprepaypatdo.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
	TimeService timeService = new TimeServiceImpl();
    FDateTime Timenow =timeService.getUFDateTime();
    blprepaypatdo.setDt_pay(Timenow);
    blprepaypatdo.setFg_cc(FBoolean.FALSE);
    blprepaypatdo.setFg_rep_return(FBoolean.FALSE);
    blprepaypatdo.setFg_canc(FBoolean.FALSE);
    blprepaypatdo.setId_grp(Context.get().getGroupId());
    blprepaypatdo.setId_org(Context.get().getOrgId());
    blprepaypatdo.setId_org_pay(blpreppDO.getId_org_pay());
    blprepaypatdo.setId_dep_pay(blpreppDO.getId_dep_pay());
    blprepaypatdo.setId_emp_pay(blpreppDO.getId_emp_pay());
    blprepaypatdo.setId_cc(null);
    blprepaypatdo.setId_incca(null);
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
    
    
    if(pipatdo!=null&&pipatdo.ID_PAT!=null){
    	 blprepaypatdo.setId_pat(pipatdo.getId_pat());	
    }else{
    	blprepaypatdo.setId_pat("");
    }
   
    //当前登录用户的机构名称、用户名、操作员、操作员所属部门、当前就诊的id_ent值都需要从前台获取，之后传到后台中通过service保存
    IBlpaypatCudService payService = (IBlpaypatCudService)ServiceFinder.find(IBlpaypatCudService.class);
    blprepaypatdo.setStatus(DOStatus.NEW);
	payService.save(new BlPrePayPatDO[]{blprepaypatdo});	
}

/**
 * 当门诊账户转入住院时调用,更新患者住院的本次就诊账户信息，
 * @param amt_trans
 *
 * @param eacdo
 */
private void updateEnAccountInfo_OepTOIp(FDouble amt_trans,EnAccountDO eacdo)throws BizException{
	// TODO Auto-generated method stub

	 IEnOutCmdService enservice=ServiceFinder.find(IEnOutCmdService.class);
	
	enservice.recharge(eacdo.getId_ent(),amt_trans);
	
	//患者收到了一笔住院预交金，在前台打印了押金条，需要将票号后移，调用票号后移接口
	/*IBLInvoiceService incSer=ServiceFinder.find(IBLInvoiceService.class);
	incSer.NextInvoiceNoUpdateCurNo(Context.get().getStuffId(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);*/

	IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
	incService.nextInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT);
}


/**
 * 当门诊账户转入住院时调用,更新患者门诊账户信息，
 * @param amt
 * @param pipatdo
 */
public void updatePiPatAccInfo_OepTOIp(FDouble amt, PiPatAccDO pipatdo)throws BizException{
	FDouble  prepay_new= pipatdo.getPrepay().sub(amt);
	
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
 * 这里的BlPrePayPatDO参数是为了接到从前台传的当前登录的用户、机构、部门、操作人员等字段信息保存到新插入的预交金数据中
 * 更新患者门诊账户和就诊账户信息，向患者收付款表中插入两条转入、转出记录，当【住院就诊账户转入患者门诊账户时】调用
 * @param blpreppDO
 * @param ppatDTO
 * @param pipatdo
 * @param eacdo
 */
public void PrepayAcctransProcessingIpToOep(BlPrePayPatDO blpreppDO,PrepayAccTransDTO ppatDTO,PiPatAccDO pipatdo, EnAccountDO eacdo)throws BizException {
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
	blprepaypatdo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
	blprepaypatdo.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
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
    
    if(pipatdo!=null&&pipatdo.ID_PAT!=null){
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
    if(pipatdo!=null&&pipatdo.ID_PAT!=null){
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
 * 当[住院就诊账户转入患者门诊账户]时调用,更新住院就诊账户信息
 * 
 * @param amt_trans
 * @param eacdo
 * @throws BizException
 */
private void updateEnAccountInfo_IpToOep(FDouble amt_trans, EnAccountDO eacdo)throws BizException {
	// TODO Auto-generated method stub
//	FDouble amt_prepay_new=eacdo.getAmt_prepay().sub(amt_trans);
//	StringBuilder queryStr = new StringBuilder();
//	queryStr.append(" a0.id_ent = '").append(eacdo.getId_ent()).append("'");
//	
//	IEnaccountMDOCudService enaccCudService=ServiceFinder.find(IEnaccountMDOCudService.class);
//	IEnaccountMDORService enaccRService=ServiceFinder.find(IEnaccountMDORService.class);
//	EnAccountDO[] enaccdos=enaccRService.find(queryStr.toString(),"",FBoolean.FALSE);
//	for(EnAccountDO enaccountdo:enaccdos){
//		enaccountdo.setAmt_prepay(amt_prepay_new);
//		enaccountdo.setStatus(DOStatus.UPDATED);
//	}
//	enaccCudService.save(enaccdos);
	
	IEnOutCmdService enservice=ServiceFinder.find(IEnOutCmdService.class);
	FDouble dd=amt_trans.multiply(-1);
	enservice.recharge(eacdo.getId_ent(),dd);
	
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



}
