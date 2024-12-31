package iih.bl.cc.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcIncCancDO;
import iih.bl.cc.blcc.d.BlCcIncDO;
import iih.bl.cc.blcc.d.BlCcIncReDO;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.ep.CcEP;
import iih.bl.cc.ep.CcElecIncEP;
import iih.bl.cc.ep.CcIncEP;
import iih.bl.cc.ep.CcPmEP;
import iih.bl.comm.util.BlIncNumStrUtil;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.orgfw.group.i.IGroupRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
/**
 * 结账数据预览
 * @author LIM
 *
 */
public class GetPreviewChechOutBP {
	/**
	 * 
	 * @param id_user
	 * @param id_org
	 * @param sd_cctp
	 * @param end_time
	 * @return
	 * @throws BizException
	 */
	public BlccAggDO[] exec(String id_user, String id_org, String sd_cctp,
			FDateTime end_time) throws BizException{
		//检查是否有预交金数据和结算收付款数据
		FBoolean result = this.checkTradData(id_user, id_org, sd_cctp, end_time);
		if(!result.booleanValue()){
			return null;
		}
		
		BlccAggDO[] blccAggArr = this.assembleChechOut(id_user, id_org, sd_cctp, end_time);
		
		//判断是否包含全部的收付款方式，否则补全
		CcPmEP ccPm = new CcPmEP();
		ccPm.setBlCcPmInfo(blccAggArr);
		
		return blccAggArr;
	}
	/**
	 * 检查是否有预交金数据和结算收付款数据
	 * */
	public FBoolean checkTradData(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		String code_entp="";
		GetCheckBlPrePatInfoBP getInfo=new GetCheckBlPrePatInfoBP();
		
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊预交金  门诊收费合并后增加
			//检查是否存在门诊预交金数据
			flag = getInfo.exec(id_user, id_org, IBlDictCodeConst.SD_CCTP_MZYJJ, end_time);
			if(flag.booleanValue()){
				return flag;
			}
			//增加判断票据记录信息
			code_entp=IBdFcDictCodeConst.SD_CODE_ENTP_OP;
			flag=this.checkBlRcptInfo(id_user, id_org, end_time,code_entp);
			if(flag.booleanValue()){
				return flag;
			}
		}
		
		if(IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//门诊预交金  门诊收费合并后增加
			//检查是否存在住院预交金数据
			flag = getInfo.exec(id_user, id_org, IBlDictCodeConst.SD_CCTP_ZYYJJ, end_time);
			if(flag.booleanValue()){
				return flag;
			}
			code_entp=IBdFcDictCodeConst.SD_CODE_ENTP_IP;
			//住院增加判断是否存在票据记录信息
			flag=this.checkBlRcptInfo(id_user, id_org, end_time,code_entp);
			if(flag.booleanValue()){
				return flag;
			}
		}
		
		if(!IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp) && !IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp))
		{
//			if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
//				flag = getInfo.exec(id_user, id_org, sd_cctp, end_time);
//				if(flag.booleanValue()){
//					return flag;
//				}
//				//住院增加判断是否存在票据记录信息
//				flag=this.checkBlRcptInfo(id_user, id_org, end_time);
//				if(flag.booleanValue()){
//					return flag;
//				}
//			}
			//检查是否存在门诊/住院收退款数据
			CcPmEP ccPmEp= new CcPmEP();
			flag = ccPmEp.checkBlPayPatInfo(id_user, id_org, sd_cctp, end_time);
			if(flag.booleanValue()){
				return flag;
			}
			//检查是否有发票信息
			flag = this.checkBlIncInfo(id_user, id_org, sd_cctp, end_time);
			if(flag.booleanValue()){
				return flag;
			}
			//检查是否有空白作废发票
			CcIncEP  incEP= new CcIncEP();
			flag = incEP.checkBlIncCancInfo(id_user, id_org, sd_cctp, end_time);
		}
		return flag;
	}	
	/**
	 * 结账数据组装
	 * */
	public BlccAggDO[] assembleChechOut(String id_user, String id_org, String sd_cctp,
			FDateTime end_time) throws BizException{

		id_org = Context.get().getOrgId();
		GroupDO groupDO = this.getGroupInfoById(Context.get().getGroupId());
		OrgDO orrgDO= this.getORGInfoById(id_org);
		
		BlccAggDO blccAggDO = new BlccAggDO();
		
		//结账
		BlCcDO blccDO = new BlCcDO();
		blccDO.setId_org(id_org);//机构
		blccDO.setCode_org(orrgDO.getCode());
		blccDO.setName_org(orrgDO.getName());		
		blccDO.setId_grp(Context.get().getGroupId());
		blccDO.setCode_grp(groupDO.getCode());
		blccDO.setName_grp(groupDO.getName());
		blccDO.setSd_cctp(sd_cctp);//结账类型编码
		//结账类型
		Map<String,BlCcPmDO> map = new HashMap<String,BlCcPmDO>();//结账收付款详情
		List<BlCcIncDO> incList = new ArrayList<BlCcIncDO>();//结账_发票信息
		List<BlCcIncCancDO> incancList = new ArrayList<BlCcIncCancDO>();//结账_作废发票明细
		List<BlCcIncReDO> increList = new ArrayList<BlCcIncReDO>();//结账_退费发票明细
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){
				blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZSF);
			}else{
				blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZLC);
			}
			CcIncEP ccInc= new CcIncEP();
			ccInc.setBlccDOIncnoInfo(id_user, id_org, sd_cctp, end_time, blccDO, incList, incancList, increList);//给结账对象添加发票信息
			//电子票
			CcElecIncEP ccElecIncEP= new CcElecIncEP();
			ccElecIncEP.setBlccDOIncnoInfo(id_user, id_org, sd_cctp, end_time, blccDO, incList, incancList, increList);//给结账对象添加发票信息
			SetBlccDOAmtStinfoBP blccDOAmt= new SetBlccDOAmtStinfoBP();
			blccDOAmt.exec(id_user, id_org, sd_cctp, end_time, blccDO,map);//结算收退款信息
			
			blccDO.setAmt(blccDO.getAmt_st());//收款金额
			blccDO.setAmt_return(blccDO.getAmt_st_ret());//退款金额
			blccDO.setIncnos(this.setNumberReformNew(blccDO.getIncnos()));//使用结算发票号信息串
			blccDO.setIncnos_canc(this.setNumberReformNew(blccDO.getIncnos_canc()));//作废结算发票号信息串
			blccDO.setIncnos_re(this.setNumberReformNew(blccDO.getIncnos_re()));//退费发票号信息串
			blccDO.setIncnos_paper(this.setNumberReformNew(blccDO.getIncnos_paper()));//使用结算发票号信息串
			blccDO.setIncnos_canc_paper(this.setNumberReformNew(blccDO.getIncnos_canc_paper()));//作废结算发票号信息串
			blccDO.setIncnos_re_paper(this.setNumberReformNew(blccDO.getIncnos_re_paper()));//退费发票号信息串
			//门诊收费与预交金结账合并，如果后续再分开，将此方法调用注销掉即可 by lim 2017-10-25
			//增加门诊流程结账
			if(IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){
				setBlccDoByPrePay(id_user, id_org, IBlDictCodeConst.SD_CCTP_MZYJJ, end_time, blccDO,map);
			}
		}else if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			blccDO.setAmt(new FDouble());//收款金额
			blccDO.setAmt_return(new FDouble());//退款金额
			setBlccDoByPrePay(id_user, id_org, IBlDictCodeConst.SD_CCTP_MZYJJ, end_time, blccDO,map);
			blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZYJJ);
//			SetBlccDOPayInfoBP setBlccPay = new SetBlccDOPayInfoBP();
//			setBlccPay.exec(id_user, id_org, sd_cctp, end_time, blccDO);//门诊预交金
//			//预交金付款方式
//			GetBlCcPmDOListBP getblCcPm = new GetBlCcPmDOListBP();
//			getblCcPm.exec(id_user, id_org, sd_cctp, end_time, map);
//			
//			blccDO.setAmt(blccDO.getAmt_entprepay());//收款金额
//			blccDO.setAmt_return(blccDO.getAmt_entprepay_ret());//退款金额
//			blccDO.setChqnos(blccDO.getChqnos());//支票号信息串
//			blccDO.setIncnos_pvprepay(this.setNumberReformNew(blccDO.getIncnos_pvprepay()));//住院押金收据使用号码串
//			blccDO.setIncnos_pvprepay_ret(this.setNumberReformNew(blccDO.getIncnos_pvprepay_ret()));//住院押金收据收回号码串
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)){
				blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_ZYSF);
			}else{
				blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_ZYLC);
			}	
			CcIncEP ccInc= new CcIncEP();
			ccInc.setBlccDOIncnoInfo(id_user, id_org, sd_cctp, end_time, blccDO, incList, incancList, increList);//给结账对象添加发票信息
			SetBlccDOAmtStinfoBP blccDOAmt= new SetBlccDOAmtStinfoBP();
			blccDOAmt.exec(id_user, id_org, sd_cctp, end_time, blccDO,map);//结算收退款信息
			if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){
				SetBlccDOPayInfoBP setBlccPay = new SetBlccDOPayInfoBP();
				setBlccPay.exec(id_user, id_org, sd_cctp, end_time, blccDO);//住院预交金
	
				//预交金付款方式
				GetBlCcPmDOListBP getblCcPm = new GetBlCcPmDOListBP();
				getblCcPm.exec(id_user, id_org, sd_cctp, end_time, map);
			}else{
				blccDO.setAmt_pvprepay(new FDouble());//收款金额
				blccDO.setAmt_pvprepay_ret(new FDouble());//退款金额
			}
			
			blccDO.setAmt(blccDO.getAmt_pvprepay().add(blccDO.getAmt_st()));//收款金额
			blccDO.setAmt_return(blccDO.getAmt_pvprepay_ret().add(blccDO.getAmt_st_ret()));//退款金额
			blccDO.setIncnos(this.setNumberReformNew(blccDO.getIncnos()));//使用结算发票号信息串
			blccDO.setIncnos_canc(this.setNumberReformNew(blccDO.getIncnos_canc()));//作废结算发票号信息串
			blccDO.setIncnos_re(this.setNumberReformNew(blccDO.getIncnos_re()));//退费发票号信息串
			blccDO.setChqnos(blccDO.getChqnos());//支票号信息串
			if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){
				blccDO.setIncnos_pvprepay(this.setNumberReformNew(blccDO.getIncnos_pvprepay()));//住院押金收据使用号码串
				blccDO.setIncnos_pvprepay_ret(this.setNumberReformNew(blccDO.getIncnos_pvprepay_ret()));//住院押金收据收回号码串
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYYJJ.equals(sd_cctp)){
			blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_ZYYJJ);
			SetBlccDOPayInfoBP setBlccPay = new SetBlccDOPayInfoBP();
			setBlccPay.exec(id_user, id_org, sd_cctp, end_time, blccDO);//住院预交金

			//预交金付款方式
			GetBlCcPmDOListBP getblCcPm = new GetBlCcPmDOListBP();
			getblCcPm.exec(id_user, id_org, sd_cctp, end_time, map);
			
			blccDO.setAmt(blccDO.getAmt_pvprepay());//收款金额
			blccDO.setAmt_return(blccDO.getAmt_pvprepay_ret());//退款金额
			blccDO.setChqnos(blccDO.getChqnos());//支票号信息串
			blccDO.setIncnos_pvprepay(this.setNumberReformNew(blccDO.getIncnos_pvprepay()));//住院押金收据使用号码串
			blccDO.setIncnos_pvprepay_ret(this.setNumberReformNew(blccDO.getIncnos_pvprepay_ret()));//住院押金收据收回号码串
		}
		//this.setBlccDOAmtInfo(id_user, id_org, sd_cctp, end_time, blccDO);//收退款金额

		blccDO.setId_emp(id_user);//操作员	
		CcEP ccEP = new CcEP();
		blccDO.setDt_b(ccEP.getBlccDODtbInfo(id_user, sd_cctp, end_time));
		blccDO.setDt_e(end_time);//结账结束日期
		blccDO.setFg_canc(FBoolean.FALSE);//结账取消标志
		blccDO.setDt_cc(new FDateTime());//结账日期时间
		blccDO.setFg_fi(FBoolean.FALSE);//财务交割标志
		blccDO.setDt_fi(null);//财务交割日期
		blccDO.setId_fi(null);//财务交割
		
		blccDO.setStatus(DOStatus.NEW);//设置对象为新增数据
		
		//blccDO.setChqnos(this.setNumberReform(blccDO.getChqnos()));//支票号信息串
		blccDO.setAmt_dif(blccDO.getAmt().sub(blccDO.getAmt_return()));
		blccAggDO.setParentDO(blccDO);
		
		//结账_付款方式
		List<BlCcPmDO> pmList = new ArrayList<BlCcPmDO>();
		for(String id_pm:map.keySet()){
			BlCcPmDO blCcPmDO = map.get(id_pm);
			blCcPmDO.setId_grp(Context.get().getGroupId());
			if(blCcPmDO.getAmt() == null){
				blCcPmDO.setAmt(new FDouble(0.00));
			}
			if(blCcPmDO.getCn_amt() == null){
				blCcPmDO.setCn_amt(0);
			}
			if(blCcPmDO.getAmt_return() == null){
				blCcPmDO.setAmt_return(new FDouble(0.00));
			}
			if(blCcPmDO.getCn_amtreturn() == null){
				blCcPmDO.setCn_amtreturn(0);
			}
			pmList.add(blCcPmDO);
		}
		
		blccAggDO.setBlCcPmDO(pmList.toArray(new BlCcPmDO[]{}));
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)
				||IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){
			//结账_发票信息
			blccAggDO.setBlCcIncDO(incList.toArray(new BlCcIncDO[]{}));
			//结账_作废发票明细
			blccAggDO.setBlCcIncCancDO(incancList.toArray(new BlCcIncCancDO[]{}));
			//结账_退费发票明细
			blccAggDO.setBlCcIncReDO(increList.toArray(new BlCcIncReDO[]{}));
		}
		return new BlccAggDO[]{blccAggDO};
	}	

	/**
	 * 检查是否有发票信息
	 * @throws BizException 
	 * */
	public FBoolean checkBlIncInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		CcIncEP getInfo= new CcIncEP();
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			
			BlIncOepDO[] blIncOepDOArr = getInfo.getBlIncOepDOInfosBP(id_user, end_time);
			if(blIncOepDOArr != null && blIncOepDOArr.length > 0){
				flag = FBoolean.TRUE;
			}
			//判断有没有电子票未结
			CcElecIncEP ccElecIncEP= new CcElecIncEP();
			BlIncOepPaperDO[] blIncOepPaperDOArr =ccElecIncEP.getBlElecIncOepDOInfosBP(id_user, end_time);
			if(!ArrayUtil.isEmpty(blIncOepPaperDOArr)){
				flag = FBoolean.TRUE;
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			BlIncIpDO[] blIncIpDOArr = getInfo.getBlIncIpDOInfos(id_user, end_time);
			if(blIncIpDOArr != null && blIncIpDOArr.length > 0){
				flag = FBoolean.TRUE;
			}
		}
		return flag;
	}	

	/**
	 * 查询住院/门诊是否存在未结账票据信息
	 * @param id_user
	 * @param id_org
	 * @param end_time
	 * @return
	 * @throws BizException 
	 */
	private FBoolean checkBlRcptInfo(String id_user, String id_org,FDateTime end_time,String code_entp) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		StringBuilder sb = new StringBuilder();
		sb.append("id_org='").append(id_org).append("'");
		sb.append(" and nvl(fg_cc_rcpt,'N')='N'");
		sb.append(" and code_entp='").append(code_entp).append("'");
		sb.append(" and ((Id_emp_rcpt='").append(id_user).append("'");
		sb.append(" and dt_receipt<='").append(end_time).append("')");
		sb.append(" or (id_emp_return='").append(id_user).append("'");
		sb.append(" and dt_return<='").append(end_time).append("'))");

		IPrepaypatrcptRService iPrepaypatrcptRService= ServiceFinder.find(IPrepaypatrcptRService.class);
		BlPrepayPatRcptDO[] blPrepayPatRcptDOArr=iPrepaypatrcptRService.find(sb.toString(), "", FBoolean.FALSE);
		if(blPrepayPatRcptDOArr!=null&& blPrepayPatRcptDOArr.length>0){
			flag=FBoolean.TRUE;
		}
		return flag;	
	}
	/**
	 * 获取集团信息
	 * */
	public GroupDO getGroupInfoById(String id_group) throws BizException{
		IGroupRService grpService = ServiceFinder.find(IGroupRService.class);
		GroupDO groupDO = grpService.findById(Context.get().getGroupId());
		if(groupDO == null){
			throw new BizException("组织"+id_group+"不存在！");
		}
		return groupDO;
	}
	/**
	 * 获取组织信息
	 * */
	public OrgDO getORGInfoById(String id_org) throws BizException{
		IOrgRService orgService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDO = orgService.findById(Context.get().getOrgId());
		if(orgDO == null){
			throw new BizException("组织"+id_org+"不存在！");
		}
		return orgDO;
	}	
	/*
	 * 票号排序重整
	 * */
	@Deprecated
	public String setNumberReform(String str){

		if(str == null || str.isEmpty() || str.length() == 0){
			return str;
		}
		
		String[] strArr = str.split(",");
		List<Long> list = new ArrayList<Long>();
		for(String st : strArr){
			if(!list.contains(Long.valueOf(st))){
				list.add(Long.valueOf(st));
			}
		}
		Collections.sort(list);
		
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < list.size(); i++){
			Long begin = list.get(i);
			Long end = null;
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(j - 1) + 1 == list.get(j)){
					end = list.get(j);
					i = j;
				}else{
					break;
				}
			}
			if(result.length() > 0){
				result.append(",");
			}
			if(end != null){
				result.append(begin + "--" + end);
			}else{
				result.append(begin.toString());
			}
		}
		return result.toString();
	}	
	
	/**
	 * 票号排序重整新 ly 2019/04/15
	 * @return
	 */
	public String setNumberReformNew(String str){
		
		if(str == null || str.isEmpty() || str.length() == 0){
			return str;
		}
		
		String[] strArr = str.split(",");
		Arrays.sort(strArr);
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < strArr.length; i++){
			
			String begin = strArr[i];
			String end = null;
			
			for(int j = i + 1; j < strArr.length; j++){
				
				String incS = strArr[j - 1];
				String incN = strArr[j];
				
				String[] incSStrs = BlIncNumStrUtil.splitComputable(incS);
				String[] incNStrs = BlIncNumStrUtil.splitComputable(incN);
				
				if(Long.parseLong(incSStrs[1]) + 1 == Long.parseLong(incNStrs[1]) ){
					end = incN;
					i = j;
				}else{
					break;
				}
			}
			if(result.length() > 0){
				result.append(",");
			}
			if(end != null){
				result.append(begin + "--" + end);
			}else{
				result.append(begin.toString());
			}
		}
		
		return result.toString();
	}
	
	//组织预交金结账数据
	private void setBlccDoByPrePay(String id_user, String id_org, String sd_cctp,
			FDateTime end_time,BlCcDO blccDO,Map<String,BlCcPmDO> map) throws BizException{
		SetBlccDOPayInfoBP setBlccPay = new SetBlccDOPayInfoBP();
		setBlccPay.exec(id_user, id_org, sd_cctp, end_time, blccDO);//门诊预交金
		//预交金付款方式
		GetBlCcPmDOListBP getblCcPm = new GetBlCcPmDOListBP();
		getblCcPm.exec(id_user, id_org, sd_cctp, end_time, map);
		
		blccDO.setAmt(blccDO.getAmt().add(blccDO.getAmt_entprepay()));//收款金额
		blccDO.setAmt_return(blccDO.getAmt_return().add(blccDO.getAmt_entprepay_ret()));//退款金额
		blccDO.setChqnos(blccDO.getChqnos());//支票号信息串
		blccDO.setIncnos_pvprepay(this.setNumberReformNew(blccDO.getIncnos_pvprepay()));//住院押金收据使用号码串
		blccDO.setIncnos_pvprepay_ret(this.setNumberReformNew(blccDO.getIncnos_pvprepay_ret()));//住院押金收据收回号码串
	}
}
