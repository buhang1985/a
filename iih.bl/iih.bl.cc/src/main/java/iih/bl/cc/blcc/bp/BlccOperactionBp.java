package iih.bl.cc.blcc.bp;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlCcIncCancDO;
import iih.bl.cc.blcc.d.BlCcIncDO;
import iih.bl.cc.blcc.d.BlCcIncReDO;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.blcc.i.IBlccMDORService;
import iih.bl.cc.blcc.i.IBlccRService;
import iih.bl.cc.ep.CcIncEP;
import iih.bl.cc.linstrener.event.BlCcRefEvent;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blinccanc.i.IBlinccancRService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.i.IBlincipMDOCudService;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.i.IBlincoepMDOCudService;
import iih.bl.inc.blincoep.i.IBlincoepMDORService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDOCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDORService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepMDOCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepMDORService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import iih.en.comm.validator.EnValidator;
//import iih.en.pv.s.bp.GetIpDocStationPatsBP;
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
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.orgfw.group.i.IGroupRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

public class BlccOperactionBp {
		
	/**
	 * 结账（变更）
	 **/
	public BlccAggDO[] doChechOutChange(BlccAggDO[] blccAggArr, String sd_cctp, 
			FDateTime end_time) throws BizException{
		for(BlccAggDO aggDO : blccAggArr){
			List<BlCcPmDO> blCcPmDOList = new ArrayList<BlCcPmDO>();
			if(aggDO.getBlCcPmDO() == null || aggDO.getBlCcPmDO().length == 0){
				continue;
			}else{
					for(BlCcPmDO blCcPmDO : aggDO.getBlCcPmDO()){
						if(blCcPmDO.getAmt().doubleValue() > 0 || blCcPmDO.getAmt_return().doubleValue() > 0){
							blCcPmDOList.add(blCcPmDO);
						}
					}
			}
			aggDO.setBlCcPmDO(blCcPmDOList.toArray(new BlCcPmDO[]{}));
		}
		IBlccCudService service = ServiceFinder.find(IBlccCudService.class);
		BlccAggDO[] blccAggDO1= service.save(blccAggArr);
		
		IBlccRService rservice = ServiceFinder.find(IBlccRService.class);
		List<String> idccList = new ArrayList<String>();
		for(BlccAggDO aggDO : blccAggDO1){
			idccList.add(aggDO.getParentDO().getId_cc());
			//修改结账标志
			this.setCheckoutStatus(aggDO.getParentDO().getId_cc(), Context.get().getStuffId(), Context.get().getOrgId(), sd_cctp, end_time);
		}
		BlccAggDO[] blccAggDOArr =  rservice.findByBIds(idccList.toArray(new String[]{}), FBoolean.FALSE);
		
		for(BlccAggDO aggDO : blccAggArr){
			aggDO.getParentDO().setAmt_dif(aggDO.getParentDO().getAmt().sub(aggDO.getParentDO().getAmt_return()));
		}
		
		//判断是否包含全部的收付款方式，否则补全
		this.setBlCcPmInfo(blccAggDOArr);
		
		//发送事件
		this.invokeAddEvent(blccAggDOArr[0]);
		
		return blccAggDOArr;
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
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZSF);
			this.setBlccDOIncnoInfo(id_user, id_org, sd_cctp, end_time, blccDO, incList, incancList,increList);//给结账对象添加发票信息
			this.setBlccDOAmtStinfo(id_user, id_org, sd_cctp, end_time, blccDO,map);//结算收退款信息
			
			blccDO.setAmt(blccDO.getAmt_st());//收款金额
			blccDO.setAmt_return(blccDO.getAmt_st_ret());//退款金额
			blccDO.setIncnos(this.setNumberReform(blccDO.getIncnos()));//使用结算发票号信息串
			blccDO.setIncnos_canc(this.setNumberReform(blccDO.getIncnos_canc()));//作废结算发票号信息串
			blccDO.setIncnos_re(this.setNumberReform(blccDO.getIncnos_re()));//退费发票号信息串
		}else if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_MZYJJ);
			this.setBlccDOPayInfo(id_user, id_org, sd_cctp, end_time, blccDO);//门诊预交金
			this.getBlCcPmDOList(id_user, id_org, sd_cctp, end_time,map);//预交金付款方式
			
			blccDO.setAmt(blccDO.getAmt_entprepay());//收款金额
			blccDO.setAmt_return(blccDO.getAmt_entprepay_ret());//退款金额
			blccDO.setChqnos(blccDO.getChqnos());//支票号信息串
			blccDO.setIncnos_pvprepay(this.setNumberReform(blccDO.getIncnos_pvprepay()));//住院押金收据使用号码串
			blccDO.setIncnos_pvprepay_ret(this.setNumberReform(blccDO.getIncnos_pvprepay_ret()));//住院押金收据收回号码串
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			blccDO.setId_cctp(IBlDictCodeConst.SD_CCTP_ID_ZYLC);
			this.setBlccDOIncnoInfo(id_user, id_org, sd_cctp, end_time, blccDO, incList, incancList,increList);//给结账对象添加发票信息
			this.setBlccDOAmtStinfo(id_user, id_org, sd_cctp, end_time, blccDO,map);//结算收退款信息
			this.setBlccDOPayInfo(id_user, id_org, sd_cctp, end_time, blccDO);//住院预交金
			this.getBlCcPmDOList(id_user, id_org, sd_cctp, end_time,map);//预交金付款方式
			
			blccDO.setAmt(blccDO.getAmt_pvprepay().add(blccDO.getAmt_st()));//收款金额
			blccDO.setAmt_return(blccDO.getAmt_pvprepay_ret().add(blccDO.getAmt_st_ret()));//退款金额
			blccDO.setIncnos(this.setNumberReform(blccDO.getIncnos()));//使用结算发票号信息串
			blccDO.setIncnos_canc(this.setNumberReform(blccDO.getIncnos_canc()));//作废结算发票号信息串
			blccDO.setIncnos_re(this.setNumberReform(blccDO.getIncnos_re()));//退费发票号信息串
			blccDO.setChqnos(blccDO.getChqnos());//支票号信息串
			blccDO.setIncnos_pvprepay(this.setNumberReform(blccDO.getIncnos_pvprepay()));//住院押金收据使用号码串
			blccDO.setIncnos_pvprepay_ret(this.setNumberReform(blccDO.getIncnos_pvprepay_ret()));//住院押金收据收回号码串
		}
		//this.setBlccDOAmtInfo(id_user, id_org, sd_cctp, end_time, blccDO);//收退款金额

		blccDO.setId_emp(id_user);//操作员		
		this.setBlccDODtbInfo(id_user, id_org, sd_cctp, end_time, blccDO);//结账开始日期
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
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){
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
	 * 结账数据预览
	 * */
	public BlccAggDO[] previewChechOut(String id_user, String id_org, String sd_cctp,
			FDateTime end_time) throws BizException{
		//检查是否有预交金数据和结算收付款数据
		FBoolean result = this.checkTradData(id_user, id_org, sd_cctp, end_time);
		if(!result.booleanValue()){
			return null;
		}
		
		BlccAggDO[] blccAggArr = this.assembleChechOut(id_user, id_org, sd_cctp, end_time);
		
		//判断是否包含全部的收付款方式，否则补全
		this.setBlCcPmInfo(blccAggArr);
		
		return blccAggArr;
	}
	
	/**
	 * 检查是否有预交金数据和结算收付款数据
	 * */
	public FBoolean checkTradData(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			//检查是否存在预交金数据
			flag = this.checkBlPrePatInfo(id_user, id_org, sd_cctp, end_time);
		}else{
			if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
				flag = this.checkBlPrePatInfo(id_user, id_org, sd_cctp, end_time);
				if(flag.booleanValue()){
					return flag;
				}
			}
			//检查是否存在门诊/住院收退款数据
			flag = this.checkBlPayPatInfo(id_user, id_org, sd_cctp, end_time);
			if(flag.booleanValue()){
				return flag;
			}
			//检查是否有发票信息
			flag = this.checkBlIncInfo(id_user, id_org, sd_cctp, end_time);
			if(flag.booleanValue()){
				return flag;
			}
			//检查是否有空白作废发票
			flag = this.checkBlIncCancInfo(id_user, id_org, sd_cctp, end_time);
		}
		return flag;
	}
	
	/**
	 * 检查是否存在预交金数据
	 * */
	public FBoolean checkBlPrePatInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		IBlpaypatRService payService = ServiceFinder.find(IBlpaypatRService.class);
		StringBuffer sb = new StringBuffer();
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			sb.append(" a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_OPPREPAY).append("'");
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			sb.append(" a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_IPPREPAY).append("'");
		}
		sb.append(" and a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		BlPrePayPatDO[] patDOArr = payService.find(sb.toString(), null, FBoolean.FALSE);
		if(patDOArr != null && patDOArr.length > 0){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	/**
	 * 检查是否存在门诊/住院收退款数据
	 * */
	public FBoolean checkBlPayPatInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		StringBuffer sf = new StringBuffer();
		sf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//					  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			IBlpaypatoepRService oepService = ServiceFinder.find(IBlpaypatoepRService.class);
			BlpaypatoepAggDO[] oepAggDOArr = oepService.find(sf.toString(), null, FBoolean.FALSE);
			if(oepAggDOArr != null && oepAggDOArr.length > 0){
				for(BlpaypatoepAggDO aggDO : oepAggDOArr){
					if(aggDO.getBlPayItmPatOepDO() != null && aggDO.getBlPayItmPatOepDO().length > 0){
						flag = FBoolean.TRUE;
						break;
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			IBlpaypatipRService ipService = ServiceFinder.find(IBlpaypatipRService.class);
			BlpaypatipAggDO[] ipAggDOArr = ipService.find(sf.toString(), null, FBoolean.FALSE);
			if(ipAggDOArr != null && ipAggDOArr.length > 0){
				for(BlpaypatipAggDO aggDO : ipAggDOArr){
					if(aggDO.getBlPayItmPatIpDO() != null && aggDO.getBlPayItmPatIpDO().length > 0){
						flag = FBoolean.TRUE;
						break;
					}
				}
			}
		}
		return flag;
	}
	
	/**
	 * 检查是否有发票信息
	 * @throws BizException 
	 * */
	public FBoolean checkBlIncInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		CcIncEP ccInc= new CcIncEP();
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			BlIncOepDO[] blIncOepDOArr = ccInc.getBlIncOepDOInfosBP(id_user, end_time);
			if(blIncOepDOArr != null && blIncOepDOArr.length > 0){
				flag = FBoolean.TRUE;
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			BlIncIpDO[] blIncIpDOArr = ccInc.getBlIncIpDOInfos(id_user, end_time);
			if(blIncIpDOArr != null && blIncIpDOArr.length > 0){
				flag = FBoolean.TRUE;
			}
		}
		return flag;
	}
	
	/**
	 * 检查是否有空白作废发票
	 * */
	public FBoolean checkBlIncCancInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		StringBuffer tb = new StringBuffer();
		tb.append(" a0.fg_cc = 'N'")
		  .append(" and a0.id_emp_canc = '").append(id_user).append("'")
		  .append(" and a0.dt_canc < '").append(end_time).append("'");
		IBlinccancRService canService = ServiceFinder.find(IBlinccancRService.class);
		BlIncCancDO[] blIncCancDOArr = canService.find(tb.toString(), null, FBoolean.FALSE);
		if(blIncCancDOArr != null && blIncCancDOArr.length > 0){
			flag = FBoolean.TRUE;
		}
		return flag;
	}
	/*
	 * 补全收款方式
	 * */
	public void setBlCcPmInfo(BlccAggDO[] blccAggDOArr) throws BizException{
		IPripmRService pmService = ServiceFinder.find(IPripmRService.class);
		PriPmDO[] priPmDOArr = pmService.find(" 1 = 1 and id_pm <> '1001Z7100000000H1L91'", null, FBoolean.FALSE);
		
		for(BlccAggDO aggDO : blccAggDOArr){
			List<BlCcPmDO> blCcPmDOList = new ArrayList<BlCcPmDO>();
			if(aggDO.getBlCcPmDO() == null || aggDO.getBlCcPmDO().length == 0){
				for(PriPmDO priPmDO : priPmDOArr){
					BlCcPmDO blCcPmDO = new BlCcPmDO();
					blCcPmDO.setId_pm(priPmDO.getId_pm());
					blCcPmDO.setCode(priPmDO.getCode());
					blCcPmDO.setName(priPmDO.getName());
					blCcPmDO.setAmt(new FDouble(0.00,2));
					blCcPmDO.setCn_amt(0);
					blCcPmDO.setAmt_return(new FDouble(0.00,2));
					blCcPmDO.setCn_amtreturn(0);
					blCcPmDOList.add(blCcPmDO);
				}
			}else{
				for(PriPmDO priPmDO : priPmDOArr){
					Boolean flag = false;
					for(BlCcPmDO blCcPmDO : aggDO.getBlCcPmDO()){
						if(blCcPmDO.getId_pm().equals(priPmDO.getId_pm())){
							flag = true;
							blCcPmDOList.add(blCcPmDO);
							break;
						}
					}
					if(!flag){
						BlCcPmDO blCcPmDO = new BlCcPmDO();
						blCcPmDO.setId_pm(priPmDO.getId_pm());
						blCcPmDO.setCode(priPmDO.getCode());
						blCcPmDO.setName(priPmDO.getName());
						blCcPmDO.setAmt(new FDouble(0.00,2));
						blCcPmDO.setCn_amt(0);
						blCcPmDO.setAmt_return(new FDouble(0.00,2));
						blCcPmDO.setCn_amtreturn(0);
						blCcPmDOList.add(blCcPmDO);
					}
				}
			}
			aggDO.setBlCcPmDO(blCcPmDOList.toArray(new BlCcPmDO[]{}));
			TimeService timeService = new TimeServiceImpl();
			aggDO.getParentDO().setDt_pt(timeService.getUFDateTime());
		}
	}
	
	/*
	 * 获取结账开始日期
	 * */
	public void setBlccDODtbInfo(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO) throws BizException{
		//结账开始日期
		FDateTime dt_b = null;
		StringBuffer sb = new StringBuffer();
		sb.append(" a0.id_emp = '").append(id_user).append("'")
//		  .append(" and a0.id_org = '").append(id_org).append("'")
		  .append(" and a0.sd_cctp = '").append(sd_cctp).append("'")
		  .append(" and a0.fg_canc = 'N'");
		IBlccMDORService service = ServiceFinder.find(IBlccMDORService.class);
		BlCcDO[] blccDOArr = service.find(sb.toString(), " a0.dt_e desc", FBoolean.FALSE);
		if(blccDOArr != null && blccDOArr.length > 0){
			dt_b = blccDOArr[0].getDt_e();
		}
		blccDO.setDt_b(dt_b);
	}
	
	/*
	 * 收退款金额
	 * */
	public void setBlccDOAmtInfo(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO) throws BizException{
		//收退款金额
		FDouble amt = new FDouble(0);//收款总金额
		FDouble amt_return = new FDouble(0);//退款总金额
		IBlpaypatRService payService = ServiceFinder.find(IBlpaypatRService.class);
		String sd_paytp = "";
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			sd_paytp = IBlDictCodeConst.SD_PAYTP_OPPREPAY;
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			sd_paytp = IBlDictCodeConst.SD_PAYTP_IPPREPAY;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" a0.SD_PAYTP = '").append(sd_paytp).append("'")
		  .append(" and a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		BlPrePayPatDO[] patDOArr = payService.find(sb.toString(), null, FBoolean.FALSE);
		
		if(patDOArr != null && patDOArr.length > 0){
			for(BlPrePayPatDO patDO : patDOArr){
				if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){
					amt = amt.add(patDO.getAmt());
				}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){
					amt_return = amt_return.add(patDO.getAmt());
				}
			}
		}
		blccDO.setAmt(amt);//收款总金额
		blccDO.setAmt_return(amt_return);//退款总金额
	}
	
	/*
	 * 结算收退款
	 * */
	public void setBlccDOAmtStinfo(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO,Map<String,BlCcPmDO> map) throws BizException{
		//结算
		StringBuffer sf = new StringBuffer();
		sf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		FDouble amt_st = new FDouble(0); // 结算_收款
		FDouble amt_st_ret = new FDouble(0);//结算_退款
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			IBlpaypatoepRService oepService = ServiceFinder.find(IBlpaypatoepRService.class);
			BlpaypatoepAggDO[] oepAggDOArr = oepService.find(sf.toString(), null, FBoolean.FALSE);
			if(oepAggDOArr != null){
				for(BlpaypatoepAggDO aggDO : oepAggDOArr){
					if(aggDO.getParentDO().getAmt() == null){
						throw new BizException("门诊结算收退款费用异常，结账失败！");
					}		
					
					if(BookRtnDirectEnum.CHARGE == aggDO.getParentDO().getEu_direct()){
						for(BlPayItmPatOepDO blPayItemDO : aggDO.getBlPayItmPatOepDO()){
							//唐婵懿增加：实收（退）付款段标志取值为true参与计算
							if(blPayItemDO.getFg_realpay()!=null && !blPayItemDO.getFg_realpay().booleanValue())
							{
								continue; //不计算非真实交易
							}
							if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPayItemDO.getSd_pm())){
								if(blccDO.getChqcn() == null){
									blccDO.setChqcn(1);//支票张数
									blccDO.setChqnos(blPayItemDO.getPaymodenode());//支票号
								}else{
									blccDO.setChqcn(blccDO.getChqcn() + 1);//支票张数
									blccDO.setChqnos(blccDO.getChqnos() + "," + blPayItemDO.getPaymodenode());//支票号
								}
							}
						}
					}
					if(aggDO.getBlPayItmPatOepDO() != null && aggDO.getBlPayItmPatOepDO().length > 0){
						for(BlPayItmPatOepDO patDO : aggDO.getBlPayItmPatOepDO()){
							if(patDO.getAmt() == null){
								throw new BizException("门诊结算收退款明细费用异常，结账失败！");
							}
							//唐婵懿增加：实收（退）付款段标志取值为true参与计算
							if(patDO.getFg_realpay()!=null  && !patDO.getFg_realpay().booleanValue())
							{
								continue; //不计算非真实交易
							}

							if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
								amt_st = amt_st.add(patDO.getAmt());
							}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
								amt_st_ret = amt_st_ret.add(patDO.getAmt());
							}
							if(patDO.getId_pm() == null || patDO.getId_pm().isEmpty() || "~".equals(patDO.getId_pm())){
								throw new BizException("收付款方式为空，请检查数据");
							}
							if(map.get(patDO.getId_pm()) == null){
								BlCcPmDO blccPmDO = new BlCcPmDO();
								blccPmDO.setId_org(id_org);
								blccPmDO.setId_pm(patDO.getId_pm());
								blccPmDO.setCode(patDO.getPm_code());
								blccPmDO.setName(patDO.getPm_name());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									blccPmDO.setAmt(patDO.getAmt());
									blccPmDO.setCn_amt(1);
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									blccPmDO.setAmt_return(patDO.getAmt());
									blccPmDO.setCn_amtreturn(1);
								}
								blccPmDO.setStatus(DOStatus.NEW);
								map.put(patDO.getId_pm(), blccPmDO);
							}else{
								BlCcPmDO blccPmDO = map.get(patDO.getId_pm());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									FDouble amt = blccPmDO.getAmt();
									if(amt == null) amt = new FDouble(0);
									blccPmDO.setAmt(amt.add(patDO.getAmt()));
									if(String.valueOf(blccPmDO.getCn_amt()).compareTo("null")==0 || String.valueOf(blccPmDO.getCn_amt()).trim().compareTo("") ==0)
									{
										blccPmDO.setCn_amt(1);
									}
									else
									{
										blccPmDO.setCn_amt(blccPmDO.getCn_amt() + 1);
									}
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									FDouble amt_return = blccPmDO.getAmt_return();
									if(amt_return == null) amt_return = new FDouble(0);
									blccPmDO.setAmt_return(amt_return.add(patDO.getAmt()));
									if(blccPmDO.getCn_amtreturn() == null){
										blccPmDO.setCn_amtreturn(1);
									}else{
										blccPmDO.setCn_amtreturn(blccPmDO.getCn_amtreturn() + 1);
									}
								}
							}
						}
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			IBlpaypatipRService ipService = ServiceFinder.find(IBlpaypatipRService.class);
			BlpaypatipAggDO[] ipAggDOArr = ipService.find(sf.toString(), null, FBoolean.FALSE);
			if(ipAggDOArr != null){
				for(BlpaypatipAggDO aggDO : ipAggDOArr){
					if(aggDO.getParentDO().getAmt() == null){
						throw new BizException("住院结算收退款费用异常，结账失败！");
					}
					if(BookRtnDirectEnum.CHARGE == aggDO.getParentDO().getEu_direct()){//收费
						amt_st = amt_st.add(aggDO.getParentDO().getAmt());
					}else if(BookRtnDirectEnum.RETURNS == aggDO.getParentDO().getEu_direct()){//退费
						amt_st_ret = amt_st_ret.add(aggDO.getParentDO().getAmt());
					}
					if(BookRtnDirectEnum.CHARGE == aggDO.getParentDO().getEu_direct()){
						for(BlPayItmPatIpDO blPayItemDO : aggDO.getBlPayItmPatIpDO()){
							if(IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPayItemDO.getSd_pm())){
								if(blccDO.getChqcn() == null){
									blccDO.setChqcn(1);//支票张数
									blccDO.setChqnos(blPayItemDO.getPaymodenode());//支票号
								}else{
									blccDO.setChqcn(blccDO.getChqcn() + 1);//支票张数
									blccDO.setChqnos(blccDO.getChqnos() + "," + blPayItemDO.getPaymodenode());//支票号
								}
							}
						}
					}
					if(aggDO.getBlPayItmPatIpDO() != null && aggDO.getBlPayItmPatIpDO().length > 0){
						for(BlPayItmPatIpDO patDO : aggDO.getBlPayItmPatIpDO()){
							if(aggDO.getParentDO().getAmt() == null){
								throw new BizException("住院结算收退款明细费用异常，结账失败！");
							}
							if(map.get(patDO.getId_pm()) == null){
								BlCcPmDO blccPmDO = new BlCcPmDO();
								blccPmDO.setId_org(id_org);
								blccPmDO.setId_pm(patDO.getId_pm());
								blccPmDO.setCode(patDO.getPm_code());
								blccPmDO.setName(patDO.getPm_name());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									blccPmDO.setAmt(patDO.getAmt());
									blccPmDO.setCn_amt(1);
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									blccPmDO.setAmt_return(patDO.getAmt());
									blccPmDO.setCn_amtreturn(1);
								}
								blccPmDO.setStatus(DOStatus.NEW);
								map.put(patDO.getId_pm(), blccPmDO);
							}else{
								BlCcPmDO blccPmDO = map.get(patDO.getId_pm());
								if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
									FDouble amt = blccPmDO.getAmt();
									if(amt == null) amt = new FDouble(0);
									blccPmDO.setAmt(amt.add(patDO.getAmt()));
									if(String.valueOf(blccPmDO.getCn_amt()).compareTo("null")==0 || String.valueOf(blccPmDO.getCn_amt()).trim().compareTo("") ==0)
									{
										blccPmDO.setCn_amt(1);
									}
									else
									{
										blccPmDO.setCn_amt(blccPmDO.getCn_amt() + 1);
									}
								}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
									FDouble amt_return = blccPmDO.getAmt_return();
									if(amt_return == null) amt_return = new FDouble(0);
									blccPmDO.setAmt_return(amt_return.add(patDO.getAmt()));
									if(blccPmDO.getCn_amtreturn() == null){
										blccPmDO.setCn_amtreturn(1);
									}else{
										blccPmDO.setCn_amtreturn(blccPmDO.getCn_amtreturn() + 1);
									}
								}
							}
						}
					}
				}
			}
		}

		blccDO.setAmt_st(amt_st);//结算_收款
		blccDO.setAmt_st_ret(amt_st_ret);//结算_退款
	}
	
	/*
	 * 住院、门诊预交金
	 * */
	public void setBlccDOPayInfo(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO) throws BizException{
		//住院、门诊预交金
		FDouble amt_pvprepay = new FDouble(0);//住院押金_收款
		FDouble amt_pvprepay_ret = new FDouble(0);//住院押金_退款
		FDouble amt_entprepay = new FDouble(0);//患者预交金_收款
		FDouble amt_entprepay_ret = new FDouble(0);//患者预交金_退款
		StringBuffer incnos_pvprepay = new StringBuffer();//住院押金收据使用号码串
		StringBuffer incnos_pvprepay_ret = new StringBuffer();//住院押金收据收回号码串
		Integer inccn_pvprepay = 0;//住院押金收据发出张数
		Integer inccn_pvprepay_ret = 0;//住院押金收据收回张数
		IBlpaypatRService blPayService = ServiceFinder.find(IBlpaypatRService.class);
		StringBuffer bf = new StringBuffer();
		bf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.id_emp_pay = '").append(id_user).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		BlPrePayPatDO[] blPrePayArr = null;
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			bf.append(" and a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_OPPREPAY).append("'");
			blPrePayArr = blPayService.find(bf.toString(), null, FBoolean.FALSE);
			if(blPrePayArr != null){
				for(BlPrePayPatDO blPrePayPatDO:blPrePayArr){
					if(blPrePayPatDO.getAmt() == null){
						throw new BizException("门诊预交金数据错误，结账失败！");
					}
					if(BookRtnDirectEnum.CHARGE == blPrePayPatDO.getEu_direct()){//收费
						amt_entprepay = amt_entprepay.add(blPrePayPatDO.getAmt());
					}else if(BookRtnDirectEnum.RETURNS == blPrePayPatDO.getEu_direct()){//退费
						amt_entprepay_ret = amt_entprepay_ret.add(blPrePayPatDO.getAmt());
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			bf.append(" and a0.SD_PAYTP = '").append(IBlDictCodeConst.SD_PAYTP_IPPREPAY).append("'");
			blPrePayArr = blPayService.find(bf.toString(), null, FBoolean.FALSE);
			if(blPrePayArr != null){
				for(BlPrePayPatDO blPrePayPatDO:blPrePayArr){
					if(blPrePayPatDO.getAmt() == null){
						throw new BizException("住院预交金数据错误，结账失败！");
					}
					if(BookRtnDirectEnum.CHARGE == blPrePayPatDO.getEu_direct()){//收费
						amt_pvprepay = amt_pvprepay.add(blPrePayPatDO.getAmt());
						if(blPrePayPatDO.getCode_rep() == null){
							continue;
						}
						if(incnos_pvprepay.length() != 0){
							incnos_pvprepay.append(",");
						}
						incnos_pvprepay.append(blPrePayPatDO.getCode_rep());
						inccn_pvprepay++;
					}else if(BookRtnDirectEnum.RETURNS == blPrePayPatDO.getEu_direct()){//退费
						amt_pvprepay_ret = amt_pvprepay_ret.add(blPrePayPatDO.getAmt());
						if(blPrePayPatDO.getCode_rep() == null){
							continue;
						}
						if(incnos_pvprepay_ret.length() != 0){
							incnos_pvprepay_ret.append(",");
						}
						incnos_pvprepay_ret.append(blPrePayPatDO.getCode_rep());
						inccn_pvprepay_ret++;
					}
				}
			}
		}
		//计算支票数据
		if(blPrePayArr != null){
			for(BlPrePayPatDO blPrePayPatDO:blPrePayArr){
				if(BookRtnDirectEnum.CHARGE.equals(blPrePayPatDO.getEu_direct()) &&
						IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPrePayPatDO.getSd_pm())){
					if(blccDO.getChqcn() == null){
						blccDO.setChqcn(1);//支票张数
						blccDO.setChqnos(blPrePayPatDO.getPaymodenode());//支票号
					}else{
						blccDO.setChqcn(blccDO.getChqcn() + 1);//支票张数
						blccDO.setChqnos(blccDO.getChqnos() + "," + blPrePayPatDO.getPaymodenode());//支票号
					}
				}
			}
		}

		blccDO.setAmt_pvprepay(amt_pvprepay);//住院押金_收款
		blccDO.setAmt_pvprepay_ret(amt_pvprepay_ret);//住院押金_退款
		blccDO.setAmt_entprepay(amt_entprepay);//患者预交金_收款
		blccDO.setAmt_entprepay_ret(amt_entprepay_ret);//患者预交金_退款
		blccDO.setIncnos_pvprepay(incnos_pvprepay.toString());//住院押金收据使用号码串
		blccDO.setIncnos_pvprepay_ret(incnos_pvprepay_ret.toString());//住院押金收据收回号码串
		blccDO.setInccn_pvprepay(inccn_pvprepay);//住院押金收据发出张数
		blccDO.setInccn_pvprepay_ret(inccn_pvprepay_ret);//住院押金收据收回张数
	}
	
	/*
	 * 给结账对象添加发票信息
	 * */
	public void setBlccDOIncnoInfo(String id_user, String id_org, String sd_cctp, FDateTime end_time, BlCcDO blccDO, List<BlCcIncDO> incList, List<BlCcIncCancDO> incancList, List<BlCcIncReDO> increList) throws BizException{
		StringBuffer incnos = new StringBuffer();//使用结算发票号信息串
		Integer inccn = 0;//发票张数
		StringBuffer incnos_canc = new StringBuffer();//作废结算发票号信息串
		Integer inccn_canc = 0;//作废结算发票张数
		Integer inccn_re = 0;//退费发票张数
		StringBuffer incnos_re = new StringBuffer();//退费发票号信息串
		Map<String,BlCcIncDO> incMap = new HashMap<String,BlCcIncDO>();//记录结账_发票信息
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			BlIncOepDO[] list = this.getBlIncOepDOInfos(id_user, end_time);
			if(list != null && list.length > 0){
				for(BlIncOepDO blIncOepDO : list){
					if(blIncOepDO.getIncno() == null){
						//throw new BizException("门诊发票为空！");
						continue;
					}
					if(blIncOepDO.getFg_canc().booleanValue()){
						if(incnos_re.length() > 0){
							incnos_re.append(",");
						}
						incnos_re.append(blIncOepDO.getIncno());
						inccn_re++;
					}else{
						if(incnos.length() > 0){
							incnos.append(",");
						}
						incnos.append(blIncOepDO.getIncno());
						inccn++;
					}

					//记录发票
					BlCcIncDO incDO = incMap.get(blIncOepDO.getCode_incpkg());
					if(incDO == null){
						BlCcIncDO blccIncDO = new BlCcIncDO();
						//by lim 将code改为存id
						//blccIncDO.setId_incca(IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);//门诊发票
						blccIncDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);//门诊发票
						blccIncDO.setCode_incpkg(blIncOepDO.getCode_incpkg());
						blccIncDO.setNum_b(blIncOepDO.getIncno());
						blccIncDO.setNum_e(blIncOepDO.getIncno());
						if(blIncOepDO.getFg_canc().booleanValue()){
							blccIncDO.setIncnos_canc(blIncOepDO.getIncno());
						}
						blccIncDO.setStatus(DOStatus.NEW);
						incMap.put(blIncOepDO.getCode_incpkg(), blccIncDO);
					}else{
						if(blIncOepDO.getIncno().compareTo(incDO.getNum_b()) < 0){
							incDO.setNum_b(blIncOepDO.getIncno());
						}
						if(blIncOepDO.getIncno().compareTo(incDO.getNum_e()) > 0){
							incDO.setNum_e(blIncOepDO.getIncno());
						}
						if(blIncOepDO.getFg_canc().booleanValue()){
							StringBuffer incSt = new StringBuffer();
							if(incDO.getIncnos_canc() != null){
								incSt.append(incDO.getIncnos_canc()).append(",").append(blIncOepDO.getIncno());
							}else{
								incSt.append(blIncOepDO.getIncno());
							}
							incDO.setIncnos_canc(incSt.toString());
						}
					}
					//作废发票明细
					if(blIncOepDO.getFg_canc().booleanValue()){
//						BlCcIncCancDO blccIncCancDO = new BlCcIncCancDO();
//						blccIncCancDO.setId_org(id_org);
//						blccIncCancDO.setId_grp(Context.get().getGroupId());
//						blccIncCancDO.setIncno_canc(blIncOepDO.getIncno());
//						blccIncCancDO.setDt_canc(blIncOepDO.getDt_canc());
//						blccIncCancDO.setNote_canc(blIncOepDO.getDes_reason_canc());
//						blccIncCancDO.setStatus(DOStatus.NEW);
//						incancList.add(blccIncCancDO);
						BlCcIncReDO blccIncReDo = new BlCcIncReDO();
						blccIncReDo.setId_org(id_org);
						blccIncReDo.setId_grp(Context.get().getGroupId());
						blccIncReDo.setId_incca(blIncOepDO.getId_incca());
						blccIncReDo.setIncno_re(blIncOepDO.getIncno());
						blccIncReDo.setDt_re(blIncOepDO.getDt_canc());
						increList.add(blccIncReDo);
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){
			BlIncIpDO[] list = this.getBlIncIpDOInfos(id_user, end_time);
			if(list != null && list.length > 0){
				for(BlIncIpDO blIncIpDO : list){
					if(blIncIpDO.getIncno() == null){
						continue;
					}
					if(blIncIpDO.getFg_canc().booleanValue()){
						if(incnos_re.length() > 0){
							incnos_re.append(",");
						}
						incnos_re.append(blIncIpDO.getIncno());
						inccn_re++;
					}else{
						if(incnos.length() > 0){
							incnos.append(",");
						}
						incnos.append(blIncIpDO.getIncno());
						inccn++;
					}
					//记录发票
					BlCcIncDO incDO = incMap.get(blIncIpDO.getCode_incpkg());
					if(incDO == null){
						BlCcIncDO blccIncDO = new BlCcIncDO();
						blccIncDO.setId_incca(IBdInccaCodeConst.CODE_INHOS_INVOICE);//住院发票
						blccIncDO.setCode_incpkg(blIncIpDO.getCode_incpkg());
						blccIncDO.setNum_b(blIncIpDO.getIncno());
						blccIncDO.setNum_e(blIncIpDO.getIncno());
						if(blIncIpDO.getFg_canc().booleanValue()){
							blccIncDO.setIncnos_canc(blIncIpDO.getIncno());
						}
						blccIncDO.setStatus(DOStatus.NEW);
						incMap.put(blIncIpDO.getCode_incpkg(), blccIncDO);
					}else{
						if(blIncIpDO.getIncno().compareTo(incDO.getNum_b()) < 0){
							incDO.setNum_b(blIncIpDO.getIncno());
						}
						if(blIncIpDO.getIncno().compareTo(incDO.getNum_e()) > 0){
							incDO.setNum_e(blIncIpDO.getIncno());
						}
						if(blIncIpDO.getFg_canc().booleanValue()){
							StringBuffer incSt = new StringBuffer();
							if(incDO.getIncnos_canc() != null){
								incSt.append(incDO.getIncnos_canc()).append(",").append(blIncIpDO.getIncno());
							}else{
								incSt.append(blIncIpDO.getIncno());
							}
							incDO.setIncnos_canc(incSt.toString());
						}
					}
					//作废发票明细
					if(blIncIpDO.getFg_canc().booleanValue()){
//						BlCcIncCancDO blccIncCancDO = new BlCcIncCancDO();
//						blccIncCancDO.setId_org(id_org);
//						blccIncCancDO.setId_grp(Context.get().getGroupId());
//						blccIncCancDO.setIncno_canc(blIncIpDO.getIncno());
//						blccIncCancDO.setDt_canc(blIncIpDO.getDt_canc());
//						blccIncCancDO.setNote_canc(blIncIpDO.getDes_reason_canc());
//						blccIncCancDO.setStatus(DOStatus.NEW);
//						incancList.add(blccIncCancDO);
						BlCcIncReDO blccIncReDo = new BlCcIncReDO();
						blccIncReDo.setId_org(id_org);
						blccIncReDo.setId_grp(Context.get().getGroupId());
						blccIncReDo.setId_incca(blIncIpDO.getId_incca());
						blccIncReDo.setIncno_re(blIncIpDO.getIncno());
						blccIncReDo.setDt_re(blIncIpDO.getDt_canc());
						increList.add(blccIncReDo);
					}
				}
			}
		}
		blccDO.setIncnos(incnos.toString());//使用结算发票号信息串
		blccDO.setInccn(inccn);//发票张数
		blccDO.setInccn_re(inccn_re);//退费发票张数
		blccDO.setIncnos_re(incnos_re.toString());//退费发票号信息串
		
		//添加空白发票
		StringBuffer tb = new StringBuffer();
		tb.append(" a0.fg_cc = 'N'")
		  .append(" and a0.id_emp_canc = '").append(id_user).append("'")
		  .append(" and a0.dt_canc < '").append(end_time).append("'");
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			tb.append(" and a0.id_incca = '").append(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE).append("'");
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			tb.append(" and a0.id_incca = '").append(IBdInccaCodeConst.ID_INHOS_INVOICE).append("'");
		}
		IBlinccancRService canService = ServiceFinder.find(IBlinccancRService.class);
		BlIncCancDO[] blIncCancDOArr = canService.find(tb.toString(), null, FBoolean.FALSE);
		if(blIncCancDOArr != null){
			String id_incca = null;
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
				id_incca = IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE;
			}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
				id_incca = IBdInccaCodeConst.CODE_INHOS_INVOICE;
			}
			for(BlIncCancDO blIncCancDO : blIncCancDOArr){
				if(incnos_canc.length() > 0){
					incnos_canc.append(",");
				}
				incnos_canc.append(blIncCancDO.getIncno());
				inccn_canc++;
				if(incMap.get(blIncCancDO.getCode_incpkg()) == null){
					BlCcIncDO blccIncDO = new BlCcIncDO();
					blccIncDO.setId_incca(id_incca);//门诊发票
					blccIncDO.setCode_incpkg(blIncCancDO.getCode_incpkg());
					blccIncDO.setNum_b(blIncCancDO.getIncno());
					blccIncDO.setNum_e(blIncCancDO.getIncno());
					blccIncDO.setIncnos_canc(blIncCancDO.getIncno());

					blccIncDO.setStatus(DOStatus.NEW);
					incMap.put(blIncCancDO.getCode_incpkg(), blccIncDO);
				}else{
					if(blIncCancDO.getIncno().compareTo(incMap.get(blIncCancDO.getCode_incpkg()).getNum_b()) < 0){
						incMap.get(blIncCancDO.getCode_incpkg()).setNum_b(blIncCancDO.getIncno());
					}
					if(blIncCancDO.getIncno().compareTo(incMap.get(blIncCancDO.getCode_incpkg()).getNum_e()) > 0){
						incMap.get(blIncCancDO.getCode_incpkg()).setNum_e(blIncCancDO.getIncno());
					}
					StringBuffer incSt = new StringBuffer();
					if(incMap.get(blIncCancDO.getCode_incpkg()).getIncnos_canc() != null){
						incSt.append(incMap.get(blIncCancDO.getCode_incpkg()).getIncnos_canc());
					}
					if(blIncCancDO.getIncno() != null){
						incSt.append(",").append(blIncCancDO.getIncno());
					}
					incMap.get(blIncCancDO.getCode_incpkg()).setIncnos_canc(incSt.toString());
				}
				//作废发票明细
				BlCcIncCancDO blccIncCancDO = new BlCcIncCancDO();
				blccIncCancDO.setId_org(id_org);
				blccIncCancDO.setId_grp(Context.get().getGroupId());
				blccIncCancDO.setIncno_canc(blIncCancDO.getIncno());
				blccIncCancDO.setDt_canc(blIncCancDO.getDt_canc());
				blccIncCancDO.setNote_canc(blIncCancDO.getSd_reason_canc());
				blccIncCancDO.setStatus(DOStatus.NEW);
				incancList.add(blccIncCancDO);
			}
		}
		blccDO.setIncnos_canc(incnos_canc.toString());//作废结算发票号信息串
		blccDO.setInccn_canc(inccn_canc);//作废结算发票张数
		for(String key : incMap.keySet()){
			BlCcIncDO blccIncDO = incMap.get(key);
			blccIncDO.setId_org(id_org);
			blccIncDO.setId_grp(Context.get().getGroupId());
			incList.add(blccIncDO);
		}
	}
	
	/*
	 * 预交金付款方式
	 * */
	public void getBlCcPmDOList(String id_user, String id_org, String sd_cctp, FDateTime end_time,Map<String,BlCcPmDO> map) throws BizException{
		IBlpaypatRService service = ServiceFinder.find(IBlpaypatRService.class);
		String sd_paytp = "";
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊（患者）
			sd_paytp = IBlDictCodeConst.SD_PAYTP_OPPREPAY;
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			sd_paytp = IBlDictCodeConst.SD_PAYTP_IPPREPAY;
		}
		StringBuffer sb = new StringBuffer();
		sb.append(" a0.SD_PAYTP = '").append(sd_paytp).append("'")
		  .append(" and a0.id_emp_pay = '").append(id_user).append("'")
//		  .append(" and a0.id_org = '").append(id_org).append("'")
		  .append(" and a0.fg_cc = 'N'")
		  .append(" and a0.dt_pay < '").append(end_time).append("'");
		BlPrePayPatDO[] patDOArr = service.find(sb.toString(), null, FBoolean.FALSE);
		if(patDOArr != null){
			for(BlPrePayPatDO patDO : patDOArr){
				if(map.get(patDO.getId_pm()) == null){
					BlCcPmDO blccPmDO = new BlCcPmDO();
					blccPmDO.setId_org(id_org);
					blccPmDO.setId_pm(patDO.getId_pm());
					blccPmDO.setCode(patDO.getPaymodecode());
					blccPmDO.setName(patDO.getPaymodename());
					if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
						blccPmDO.setAmt(patDO.getAmt());
						blccPmDO.setCn_amt(1);
					}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
						blccPmDO.setAmt_return(patDO.getAmt());
						blccPmDO.setCn_amtreturn(1);
					}
					blccPmDO.setStatus(DOStatus.NEW);
					map.put(patDO.getId_pm(), blccPmDO);
				}else{
					BlCcPmDO blccPmDO = map.get(patDO.getId_pm());
					if(BookRtnDirectEnum.CHARGE == patDO.getEu_direct()){//收费
						FDouble amt = blccPmDO.getAmt();
						if(amt == null) amt = new FDouble(0);
						blccPmDO.setAmt(amt.add(patDO.getAmt()));
						if(String.valueOf(blccPmDO.getCn_amt()).compareTo("null")==0 || String.valueOf(blccPmDO.getCn_amt()).trim().compareTo("") ==0)
						{
							blccPmDO.setCn_amt(1);
						}
						else
						{
							blccPmDO.setCn_amt(blccPmDO.getCn_amt() + 1);
						}
					}else if(BookRtnDirectEnum.RETURNS == patDO.getEu_direct()){//退费
						FDouble amt_return = blccPmDO.getAmt_return();
						if(amt_return == null) amt_return = new FDouble(0);
						blccPmDO.setAmt_return(amt_return.add(patDO.getAmt()));
						if(blccPmDO.getCn_amtreturn() == null){
							blccPmDO.setCn_amtreturn(1);
						}else{
							blccPmDO.setCn_amtreturn(blccPmDO.getCn_amtreturn() + 1);
						}
					}
				}
			}
		}
	}
	
	/*
	 * 修改结账标志
	 * */
	public void setCheckoutStatus(String id_cc, String id_user, String id_org, String sd_cctp, FDateTime end_time) throws BizException{
		//修改结算收付款(门诊/住院)表的结算标示
		//by li 用StringBuilder替换StringBuffer
		//StringBuffer sf = new StringBuffer();
		StringBuilder sf= new StringBuilder();
		sf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			//修改门诊结算表的结账标示
			this.setCheckoutStatusOfBlStOep(id_cc, id_user, end_time);
			
			IBlpaypatoepMDORService peRService = ServiceFinder.find(IBlpaypatoepMDORService.class);
			IBlpaypatoepMDOCudService peCService = ServiceFinder.find(IBlpaypatoepMDOCudService.class);
			BlPayPatOepDO[] blPayPatOepDOArr = peRService.find(sf.toString(), null, FBoolean.FALSE);
			if(blPayPatOepDOArr != null && blPayPatOepDOArr.length > 0){
				for(BlPayPatOepDO blPayPatOepDO : blPayPatOepDOArr){
					blPayPatOepDO.setId_cc(id_cc);
					blPayPatOepDO.setFg_cc(FBoolean.TRUE);
					blPayPatOepDO.setStatus(DOStatus.UPDATED);
				}
				peCService.save(blPayPatOepDOArr);
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			//修改住院结算表的结账标示
			this.setCheckoutStatusOfBlStIp(id_cc, id_user, end_time);
			
			IBlpaypatipMDORService piRService = ServiceFinder.find(IBlpaypatipMDORService.class);
			IBlpaypatipMDOCudService piCService = ServiceFinder.find(IBlpaypatipMDOCudService.class);
			BlPayPatIpDO[] blPayPatIpDOArr = piRService.find(sf.toString(), null, FBoolean.FALSE);
			if(blPayPatIpDOArr != null && blPayPatIpDOArr.length > 0){
				for(BlPayPatIpDO blPayPatIpDO : blPayPatIpDOArr){
					blPayPatIpDO.setId_cc(id_cc);
					blPayPatIpDO.setFg_cc(FBoolean.TRUE);
					blPayPatIpDO.setStatus(DOStatus.UPDATED);
				}
				piCService.save(blPayPatIpDOArr);
			}
		}
		//修改预交金表(BL_PREPAY_PAT)中结账标志为未结账
		String sd_paytp = "";
		if(IBlDictCodeConst.SD_CCTP_MZYJJ.equals(sd_cctp)){//门诊预交金
			sd_paytp = IBlDictCodeConst.SD_PAYTP_OPPREPAY;
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			sd_paytp = IBlDictCodeConst.SD_PAYTP_IPPREPAY;
		}
		StringBuffer paySql = new StringBuffer();
		paySql.append(" a0.SD_PAYTP = '").append(sd_paytp).append("'")
		      .append(" and a0.FG_CC = 'N'")
//		      .append(" and a0.ID_ORG = '").append(id_org).append("'")
		      .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
		      .append(" and a0.DT_PAY < '").append(end_time).append("'");
		IBlpaypatRService payRService = ServiceFinder.find(IBlpaypatRService.class);
		IBlpaypatCudService payCService = ServiceFinder.find(IBlpaypatCudService.class);
		BlPrePayPatDO[] blPrePayPatDOArr = payRService.find(paySql.toString(), null, FBoolean.FALSE);
		if(blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0){
			for(BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr){
				blPrePayPatDO.setId_cc(id_cc);
				blPrePayPatDO.setFg_cc(FBoolean.TRUE);
				blPrePayPatDO.setStatus(DOStatus.UPDATED);
			}
			payCService.save(blPrePayPatDOArr);
		}
		//修改发票信息（BL_INC_OEP/BL_INC_IP）
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)){//门诊（患者）
			BlIncOepDO[] blIncOepDOArr = this.getBlIncOepDOInfos(id_user, end_time);
			IBlincoepMDOCudService oepCService = ServiceFinder.find(IBlincoepMDOCudService.class);
			if(blIncOepDOArr != null && blIncOepDOArr.length > 0){
				for(BlIncOepDO blIncOepDO : blIncOepDOArr){
					blIncOepDO.setStatus(DOStatus.UPDATED);
					if(!blIncOepDO.getFg_canc().booleanValue()){
						blIncOepDO.setFg_cc_out(FBoolean.TRUE);
						blIncOepDO.setId_cc_out(id_cc);
					}else{
						// by lim 结账时，判断开票人是否是当前操作员，防止结账人和开票人不一致，替别人结账 2017-06-29
						if(!blIncOepDO.getFg_cc_out().booleanValue() && blIncOepDO.getId_emp_inc()==id_user){
							blIncOepDO.setFg_cc_out(FBoolean.TRUE);
							blIncOepDO.setId_cc_out(id_cc);
						}
						blIncOepDO.setFg_cc_in(FBoolean.TRUE);
						blIncOepDO.setId_cc_in(id_cc);
					}
				}
				oepCService.save(blIncOepDOArr);
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			BlIncIpDO[] blIncIpDOArr = this.getBlIncIpDOInfos(id_user, end_time);
			IBlincipMDOCudService ipCService = ServiceFinder.find(IBlincipMDOCudService.class);
			if(blIncIpDOArr != null && blIncIpDOArr.length > 0){
				for(BlIncIpDO blIncIpDO : blIncIpDOArr){
					blIncIpDO.setStatus(DOStatus.UPDATED);
					if(!blIncIpDO.getFg_canc().booleanValue()){
						blIncIpDO.setFg_cc_out(FBoolean.TRUE);
						blIncIpDO.setId_cc_out(id_cc);
					}else{
						if(!blIncIpDO.getFg_cc_out().booleanValue()){
							blIncIpDO.setFg_cc_out(FBoolean.TRUE);
							blIncIpDO.setId_cc_out(id_cc);
						}
						blIncIpDO.setFg_cc_in(FBoolean.TRUE);
						blIncIpDO.setId_cc_in(id_cc);
					}
				}
				ipCService.save(blIncIpDOArr);
			}
		}
		//修改空白作废票据表(BL_INC_CANC)中结账标志为未结账
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//门诊预交金
			StringBuffer incSql = new StringBuffer();
//			incSql.append(" a0.ID_ORG = '").append(id_org).append("'")
			incSql.append(" a0.ID_EMP_CANC = '").append(id_user).append("'")
			        .append(" and a0.DT_CANC < '").append(end_time).append("'");
			IBlinccancRService incRService = ServiceFinder.find(IBlinccancRService.class);
			IBlinccancCudService incCService = ServiceFinder.find(IBlinccancCudService.class);
			BlIncCancDO[] blIncCancDOArr = incRService.find(incSql.toString(), null, FBoolean.FALSE);
			if(blIncCancDOArr != null && blIncCancDOArr.length > 0){
				for(BlIncCancDO blIncCancDO : blIncCancDOArr){
					blIncCancDO.setId_cc(id_cc);
					blIncCancDO.setFg_cc(FBoolean.TRUE);
					blIncCancDO.setStatus(DOStatus.UPDATED);
				}
				incCService.save(blIncCancDOArr);
			}
		}
		
	}
	
	/**
	 * 修改门诊结算表的结账标示
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public void setCheckoutStatusOfBlStOep(String id_cc, String id_user, FDateTime end_time) throws BizException{
		StringBuilder sf = new StringBuilder();
		sf.append("select s.* from bl_st_oep s")
		  .append(" inner join bl_pay_pat_oep p on s.id_paypatoep = p.id_paypatoep")
		  .append(" where p.FG_CC = 'N'")
		  .append(" and p.ID_EMP_PAY = ?")
		  .append(" and p.DT_PAY < ?");
		SqlParam sp=new SqlParam();
		sp.addParam(id_user);
		sp.addParam(end_time);
		List<BlStOepDO> blStOepDOList = (List<BlStOepDO>)new DAFacade().execQuery(sf.toString(), sp, new BeanListHandler(BlStOepDO.class));
		if(blStOepDOList != null && blStOepDOList.size() > 0){
			IBlstoepCudService stOepCService = ServiceFinder.find(IBlstoepCudService.class);
			for(BlStOepDO blStOepDO : blStOepDOList){
				blStOepDO.setId_cc(id_cc);
				blStOepDO.setFg_cc(FBoolean.TRUE);
				blStOepDO.setStatus(DOStatus.UPDATED);
			}
			stOepCService.save(blStOepDOList.toArray(new BlStOepDO[]{}));
		}
	}
	/**
	 *  获取门诊发票信息
	 * @param id_user
	 * @param end_time
	 * @return
	 * @throws BizException
	 * @author LIM
	 */
	public BlIncOepDO[] getBlIncOepDOInfos(String id_user, FDateTime end_time) throws BizException{
		StringBuffer oepStr = new StringBuffer();
		oepStr.append(" (a0.fg_print = 'Y' and a0.fg_cc_out = 'N' and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
				   .append(" or (a0.fg_canc = 'Y' and a0.fg_cc_in = 'N' and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("') ");
		IBlincoepMDORService incOepService = ServiceFinder.find(IBlincoepMDORService.class);
		BlIncOepDO[] blIncOepDOArr = incOepService.find(oepStr.toString(), null, FBoolean.FALSE);
		return blIncOepDOArr;
	}		
	/**
	 * 结账-获取住院发票信息
	 * @param id_user
	 * @param end_time
	 * @return
	 * @throws BizException
	 */
	public BlIncIpDO[] getBlIncIpDOInfos(String id_user, FDateTime end_time) throws BizException{
		StringBuffer ipStr = new StringBuffer();
		ipStr.append(" (a0.fg_print = 'Y' and a0.fg_cc_out = 'N' and a0.id_emp_inc = '").append(id_user).append("' and a0.dt_inc <= '").append(end_time).append("') ")
		   .append(" or (a0.fg_canc = 'Y' and a0.fg_cc_in = 'N' and a0.id_emp_canc = '").append(id_user).append("' and a0.dt_canc <= '").append(end_time).append("') ");
		IBlincipMDORService incIpService = ServiceFinder.find(IBlincipMDORService.class);
		BlIncIpDO[] blIncIpDOArr = incIpService.find(ipStr.toString(), null, FBoolean.FALSE);
		return blIncIpDOArr;
	}
	
	/**
	 * 修改住院结算表的结账标示
	 * @throws BizException 
	 * */
	@SuppressWarnings("unchecked")
	public void setCheckoutStatusOfBlStIp(String id_cc, String id_user, FDateTime end_time) throws BizException{
		StringBuffer sf = new StringBuffer();
		sf.append("select s.* from bl_st_ip s")
		  .append(" inner join bl_pay_pat_ip p on s.id_stip = p.id_stip")
		  .append(" where p.FG_CC = 'N'")
		  .append(" and p.ID_EMP_PAY = ?")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and p.DT_PAY < ?");
		SqlParam sp=new SqlParam();
		sp.addParam(id_user);
		sp.addParam(end_time);
		List<BlStIpDO> blStIpDOList = (List<BlStIpDO>)new DAFacade().execQuery(sf.toString(), sp, new BeanListHandler(BlStIpDO.class));
		if(blStIpDOList != null && blStIpDOList.size() > 0){
			IBlstipCudService stIpCService = ServiceFinder.find(IBlstipCudService.class);
			for(BlStIpDO blStIpDO : blStIpDOList){
				blStIpDO.setId_cc(id_cc);
				blStIpDO.setFg_cc(FBoolean.TRUE);
				blStIpDO.setStatus(DOStatus.UPDATED);
			}
			stIpCService.save(blStIpDOList.toArray(new BlStIpDO[]{}));
		}
	}
	
	/*
	 * 判断是否可以取消结账
	 * */
	public FBoolean checkBlccDOCancel(BlCcDO blccDo) throws BizException{
		StringBuffer quStr = new StringBuffer();
		quStr.append(" a0.id_emp = '").append(blccDo.getId_emp()).append("'")
		     .append(" and a0.id_cctp = '").append(blccDo.getId_cctp()).append("'")
		     .append(" and a0.fg_canc = 'N' ")
		     .append(" and a0.dt_e > '").append(blccDo.getDt_e()).append("'");
		IBlccMDORService service = ServiceFinder.find(IBlccMDORService.class);
		BlCcDO[] blCcDOArr = service.find(quStr.toString(), null, FBoolean.FALSE);
		if(blCcDOArr != null && blCcDOArr.length > 0){
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}
	
	/*
	 * 取消结账
	 * */
	public BlccAggDO[] setCancelCheckout(String id_user, String id_org, BlccAggDO[] blccAggDOArr) throws BizException{
		if(blccAggDOArr == null){
			return null;
		}
		for(BlccAggDO blccAggDO : blccAggDOArr){
			StringBuffer sqlStr = new StringBuffer();
			sqlStr.append(" a0.id_cc = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
			
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(blccAggDO.getParentDO().getSd_cctp())){//门诊（患者）
				//修改结算表(BL_ST_OEP)中结账标志为未结账
				IBlstoepRService stOepRService = ServiceFinder.find(IBlstoepRService.class);
				IBlstoepCudService stOepCService = ServiceFinder.find(IBlstoepCudService.class);
				BlStOepDO[] blStOepDOArr = stOepRService.find(sqlStr.toString(), null, FBoolean.FALSE);
				if(blStOepDOArr != null && blStOepDOArr.length > 0){
					for(BlStOepDO blStOepDO : blStOepDOArr){
						blStOepDO.setId_cc(null);
						blStOepDO.setFg_cc(FBoolean.FALSE);
						blStOepDO.setStatus(DOStatus.UPDATED);
					}
					stOepCService.save(blStOepDOArr);
				}
				//修改结算收付款表(BL_PAY_PAT_OEP)中结账标志为未结账
				IBlpaypatoepMDORService payOepService = ServiceFinder.find(IBlpaypatoepMDORService.class);//门诊
				IBlpaypatoepMDOCudService patOepService = ServiceFinder.find(IBlpaypatoepMDOCudService.class);
				BlPayPatOepDO[] blPayPatOepDOArr = payOepService.find(sqlStr.toString(), null, FBoolean.FALSE);
				if(blPayPatOepDOArr != null && blPayPatOepDOArr.length > 0){
					for(BlPayPatOepDO blPayPatOepDO : blPayPatOepDOArr){
						blPayPatOepDO.setId_cc(null);
						blPayPatOepDO.setFg_cc(FBoolean.FALSE);
						blPayPatOepDO.setStatus(DOStatus.UPDATED);
					}
					patOepService.save(blPayPatOepDOArr);
				}
			}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(blccAggDO.getParentDO().getSd_cctp())){//住院
				//修改结算表(BL_ST_IP)中结账标志为未结账
				IBlstipRService stIpRService = ServiceFinder.find(IBlstipRService.class);
				IBlstipCudService stIpCService = ServiceFinder.find(IBlstipCudService.class);
				BlStIpDO[] blStIpDOArr = stIpRService.find(sqlStr.toString(), null, FBoolean.FALSE);
				if(blStIpDOArr != null && blStIpDOArr.length > 0){
					for(BlStIpDO blStIpDO : blStIpDOArr){
						blStIpDO.setId_cc(null);
						blStIpDO.setFg_cc(FBoolean.FALSE);
						blStIpDO.setStatus(DOStatus.UPDATED);
					}
					stIpCService.save(blStIpDOArr);
				}
				//修改结算收付款表(BL_PAY_PAT_IP)中结账标志为未结账
				IBlpaypatipMDORService payIpService = ServiceFinder.find(IBlpaypatipMDORService.class);//住院
				IBlpaypatipMDOCudService patIpService = ServiceFinder.find(IBlpaypatipMDOCudService.class);
				BlPayPatIpDO[] blPayPatIpDOArr = payIpService.find(sqlStr.toString(), null, FBoolean.FALSE);
				if(blPayPatIpDOArr != null && blPayPatIpDOArr.length > 0){
					for(BlPayPatIpDO blPayPatIpDO : blPayPatIpDOArr){
						blPayPatIpDO.setId_cc(null);
						blPayPatIpDO.setFg_cc(FBoolean.FALSE);
						blPayPatIpDO.setStatus(DOStatus.UPDATED);
					}
					patIpService.save(blPayPatIpDOArr);
				}
			}
			
			//修改预交金表(BL_PREPAY_PAT)中结账标志为未结账
			IBlpaypatRService payRService = ServiceFinder.find(IBlpaypatRService.class);
			IBlpaypatCudService payCService = ServiceFinder.find(IBlpaypatCudService.class);
			BlPrePayPatDO[] blPrePayPatDOArr = payRService.find(sqlStr.toString(), null, FBoolean.FALSE);
			if(blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0){
				for(BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr){
					blPrePayPatDO.setId_cc(null);
					blPrePayPatDO.setFg_cc(FBoolean.FALSE);
					blPrePayPatDO.setStatus(DOStatus.UPDATED);
				}
				payCService.save(blPrePayPatDOArr);
			}
			
			//修改门诊/住院发票表（BL_INC_OEP/BL_INC_IP）中结账标志为未结账----新加
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(blccAggDO.getParentDO().getSd_cctp())){//门诊（患者）
				StringBuffer oepStr = new StringBuffer();
				oepStr.append(" a0.id_cc_out = '").append(blccAggDO.getParentDO().getId_cc()).append("'")
						   .append(" or a0.id_cc_in = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
				IBlincoepMDORService incOepService = ServiceFinder.find(IBlincoepMDORService.class);
				BlIncOepDO[] blIncOepDOArr = incOepService.find(oepStr.toString(), null, FBoolean.FALSE);
				IBlincoepMDOCudService oepCService = ServiceFinder.find(IBlincoepMDOCudService.class);
				if(blIncOepDOArr != null && blIncOepDOArr.length > 0){
					for(BlIncOepDO blIncOepDO : blIncOepDOArr){
						blIncOepDO.setStatus(DOStatus.UPDATED);
						if(blccAggDO.getParentDO().getId_cc().equals(blIncOepDO.getId_cc_out())){
							blIncOepDO.setFg_cc_out(FBoolean.FALSE);
							blIncOepDO.setId_cc_out("~");
						}
						if(blccAggDO.getParentDO().getId_cc().equals(blIncOepDO.getId_cc_in())){
							blIncOepDO.setFg_cc_in(FBoolean.FALSE);
							blIncOepDO.setId_cc_in("~");
						}
					}
					oepCService.save(blIncOepDOArr);
				}
			}else if(IBlDictCodeConst.SD_CCTP_ZYLC.equals(blccAggDO.getParentDO().getSd_cctp())){//住院
				StringBuffer ipStr = new StringBuffer();
				ipStr.append(" a0.id_cc_out = '").append(blccAggDO.getParentDO().getId_cc()).append("'")
				       .append(" or a0.id_cc_in = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
				IBlincipMDORService incIpService = ServiceFinder.find(IBlincipMDORService.class);
				BlIncIpDO[] blIncIpDOArr = incIpService.find(ipStr.toString(), null, FBoolean.FALSE);
				IBlincipMDOCudService ipCService = ServiceFinder.find(IBlincipMDOCudService.class);
				if(blIncIpDOArr != null && blIncIpDOArr.length > 0){
					for(BlIncIpDO blIncIpDO : blIncIpDOArr){
						blIncIpDO.setStatus(DOStatus.UPDATED);
						if(blccAggDO.getParentDO().getId_cc().equals(blIncIpDO.getId_cc_out())){
							blIncIpDO.setFg_cc_out(FBoolean.FALSE);
							blIncIpDO.setId_cc_out("~");
						}
						if(blccAggDO.getParentDO().getId_cc().equals(blIncIpDO.getId_cc_in())){
							blIncIpDO.setFg_cc_in(FBoolean.FALSE);
							blIncIpDO.setId_cc_in("~");
						}
					}
					ipCService.save(blIncIpDOArr);
				}
			}
			
			//修改空白作废票据表(BL_INC_CANC)中结账标志为未结账
			IBlinccancRService incRService = ServiceFinder.find(IBlinccancRService.class);
			IBlinccancCudService incCService = ServiceFinder.find(IBlinccancCudService.class);
			BlIncCancDO[] blIncCancDOArr = incRService.find(sqlStr.toString(), null, FBoolean.FALSE);
			if(blIncCancDOArr != null && blIncCancDOArr.length > 0){
				for(BlIncCancDO blIncCancDO : blIncCancDOArr){
					blIncCancDO.setId_cc(null);
					blIncCancDO.setFg_cc(FBoolean.FALSE);
					blIncCancDO.setStatus(DOStatus.UPDATED);
				}
				incCService.save(blIncCancDOArr);
			}
			blccAggDO.getParentDO().setFg_canc(FBoolean.TRUE);
			blccAggDO.getParentDO().setDt_canc(new FDateTime());
			blccAggDO.getParentDO().setStatus(DOStatus.UPDATED);
		}
		//设置取消结账标志为已取消
		IBlccCudService blccService = ServiceFinder.find(IBlccCudService.class);
		blccAggDOArr = blccService.save(blccAggDOArr);
		
		//发送事件
		this.invokeDelEvent(blccAggDOArr[0]);
		
		return blccAggDOArr;
	}
	
	/*
	 * 票号排序重整
	 * */
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
	 * 结账发送事件
	 * @throws BizException 
	 * */
	public void invokeAddEvent(BlccAggDO blccAggDO) throws BizException{
		//发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setBlccAggDO(blccAggDO);
		
		BlCcRefEvent blStIpEvent = new BlCcRefEvent();
		blStIpEvent.invokeAdd(blEventInfoDTO);
	}
	
	/**
	 * 取消结账发送事件
	 * @throws BizException 
	 * */
	public void invokeDelEvent(BlccAggDO blccAggDO) throws BizException{
		//发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setBlccAggDO(blccAggDO);
		
		BlCcRefEvent blStIpEvent = new BlCcRefEvent();
		blStIpEvent.invokeAdd(blEventInfoDTO);
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
	/**
	 * 结账后打印时，检验数据有效性（防止取消结账后，打印已取消的结账数据）
	 * @param id_cc
	 * @return
	 * @throws BizException
	 * @author Liwq
	 */
	public FBoolean checkDataValidity_Print(String id_cc) throws BizException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("select id_cc from bl_cc where fg_canc = 'N' and id_cc='");
		
		IBlccMDORService iBlccMDORService = ServiceFinder.find(IBlccMDORService.class);
		BlCcDO[] blCcDoArr = iBlccMDORService.find(" fg_canc = 'N' and id_cc = '" + id_cc +"'", "",FBoolean.TRUE);
		
		if(blCcDoArr == null || blCcDoArr.length <= 0)
		{
			return FBoolean.FALSE;
		}
		else {
			return FBoolean.TRUE;
		}	
	}
}
