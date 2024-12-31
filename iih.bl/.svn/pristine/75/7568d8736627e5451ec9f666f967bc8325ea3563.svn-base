package iih.bl.cg.bp.self;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.org.d.OrgDO;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.api.d.OpPayReturn;
import iih.bl.cg.api.d.PrepayTradeRecord;
import iih.bl.cg.api.d.RechargeInfo;
import iih.bl.cg.api.d.RechargeResult;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.service.i.IBLPayMaintainService;
import iih.pi.reg.pat.d.PatDO;

public class SaveBlPayPatItemBp {
	/**
	 * 预交金充值（现金、支付宝、微信）
	 * @return
	 * @throws BizException
	 */
	public RechargeResult exec(RechargeInfo param) throws BizException{
		String id_paymod="";
		if(param == null ){
			throw new BizException("传入的参数不能为空！");
		}
		if(param.getPatCode() == null || param.getOrgCode()==null || param.getPatName() == null ||param.getTradeNo() == null 
				||param.getAmt() <=0 ||param.getPmCode() ==null || param.getAccountNum()==null|| param.getOperatorCode()==null ||param.getEntpCode()==null) {
			throw new BizException("传入的参数不能为空！");
		}
		RechargeResult rtnInfo = new RechargeResult();
		rtnInfo.setResultCode("1");
		rtnInfo.setErrorMsg("操作失败！");
		
		//1.判断传入的就诊类型是否正确 00 门诊，01 急诊，10 住院
		if(param.getEntpCode()!="00" && param.getEntpCode()!="01" && param.getEntpCode()!="10")
		{
			rtnInfo.setErrorMsg("就诊类型不正确！");
			return rtnInfo;
		}
		//2.支付方式编码是否正确 1 支付宝，2 微信，3 预交金，4 银行卡，6医保个人账户
		if(param.getPmCode()!="1" && param.getPmCode()!="2" && param.getPmCode()!="3" && param.getPmCode()!="4" && param.getPmCode()!="6")
		{
			rtnInfo.setErrorMsg("支付方式不正确！");
			return rtnInfo;
		}else{
			//List<PriPmDO> patDoList = (List<PriPmDO>)new DAFacade().findByCond(PriPmDO.class, "code = '"+patCode+"' ","Id_pat", pat);   
			switch (param.getPmCode()){
				case "1":
					id_paymod=IBdPripmCodeConst.ID_PRI_PM_ALIPAY;
					break;
				case "2":
					id_paymod=IBdPripmCodeConst.ID_PRI_PM_WECHAT;
					break;	
				case "3":
					id_paymod=IBdPripmCodeConst.ID_PRI_PM_PAY;
					break;	
				case "4":
					id_paymod=IBdPripmCodeConst.ID_PRI_PM_CREDIT;
					break;	
				case "6":
					id_paymod=IBdPripmCodeConst.ID_PRI_PM_INSUR;
					break;						
				default:
					break;				
			}
		}
		String patCode = param.getPatCode();
		//3.根据患者code查询患者id_pat
		String[] pat = {"Id_pat"};
		List<PatDO> patDoList = (List<PatDO>)new DAFacade().findByCond(PatDO.class, "code = '"+patCode+"' ","1", pat);  
		
		if(patDoList == null || patDoList.size() <= 0)
		{
			rtnInfo.setErrorMsg("该患者不存在！");
			return rtnInfo;
		}
		//4.判断机构是否存在
		String[] org={"Id_org"};
		List<OrgDO> orgList = (List<OrgDO>) new DAFacade().findByCond(OrgDO.class,"code='"+ param.getOrgCode() +"'","1",org);
		if(orgList == null || orgList.size() <= 0)
		{
			rtnInfo.setErrorMsg("该机构编码不存在！");
			return rtnInfo;
		}
		//5.判断操作员是否存在
		String[] psn={"Id_psndoc"};
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class,"code='"+ param.getOperatorCode() +"'","1",psn);
		if(psnList == null || psnList.size() <= 0)
		{
			rtnInfo.setErrorMsg("该操作员不存在！");
			return rtnInfo;
		}	
		//6.组织数据
		BlPayPatItemDTO payPreDTO= new BlPayPatItemDTO();
		//payPreDTO.setCode_rep(param.getTradeNo());
		payPreDTO.setAmt( new FDouble(param.getAmt()));
		payPreDTO.setId_paymod(id_paymod);
			//payPreDTO.setId_bank();
		payPreDTO.setBankno(param.getAccountNum());
		payPreDTO.setPaymodeno(param.getTradeNo());
		
		BlPrePayPatDO  prePayDO= new BlPrePayPatDO();
		prePayDO.setId_emp_pay(psnList.get(0).getId_psndoc());
		prePayDO.setId_org(psnList.get(0).getId_org());
		prePayDO.setId_grp(psnList.get(0).getId_group());
		prePayDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_OPPREPAY);
		prePayDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
		prePayDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_SELF_TERMINAL);//自助机
		//7.调用预交金保存接口
		IBLPayMaintainService payPreService = ServiceFinder.find(IBLPayMaintainService.class);
		BlPrePayPatDO[] blPreDo= payPreService.saveBlPayPatItem(payPreDTO, prePayDO, param.getEntpCode());
		if(blPreDo!=null && blPreDo.length>0) {
			rtnInfo.setResultCode("0");
			rtnInfo.setErrorMsg("操作成功！");
			rtnInfo.setBalance(blPreDo[0].getAmt().toDouble());
			rtnInfo.setRechargeTime(blPreDo[0].getCreatedtime().toString());
			rtnInfo.setIncNo(blPreDo[0].getId_paypat());
		}		
		return rtnInfo;
	}

}
