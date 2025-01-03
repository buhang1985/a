package iih.bl.pay.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;
import iih.bl.cg.service.IBlcgqueryService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blincquerydto.d.BlInvoicePmDTO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.params.BlParamsAnalysisUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.prepay.d.BlPrepayCDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.ep.IpPayPatEP;
import iih.bl.pay.event.IpRcvPayPatEvent;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.d.BlIncIpEntHpInfoDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStIpInccanoDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.bl.st.dto.d.BlstipInvoiceHeadInfoDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.xapformula.vo.pub.formulaset.MoneyFormat;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;


/**
 * 住院收付款BP
 * 
 * @author liwq
 * @since 2017-7-13 11:26:38
 *
 */
public class DoIpPaymentBP {

	public BlStIpPayInvoceInfoDTO exec(OperatorInfoDTO operator,
			BlPayPatIpDO ipPayDo, BlPrePayPatDO[] ipPrepayDoArr,
			BlPayItmPatIpDO[] ipPayItmDoArr, BlCgIpDO[] reductionCgDoArr,
			BlStIpInccanoDTO incAndPayNo, FBoolean isArrears,
			FBoolean isTransfer,FBoolean isPrintInvoice) throws BizException {
		if(FBoolean.TRUE.equals(isPrintInvoice) && FBoolean.TRUE.equals(isArrears) && FBoolean.FALSE.equals(BlParams.BLSTIP0037())){
			isPrintInvoice = FBoolean.FALSE;
		}
		//1. 验证住院发票号和住院押金条号是否可用
		//TODO review by yangyang 这里不做票据的校验了，改到医保交易前做校验。
//		IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
//		String code_incno = incService.GetInvoiceNo(operator.getId_emp(), IBdInccaCodeConst.CODE_INHOS_INVOICE);
//
//		if (incAndPayNo.getIncno() != null && !incAndPayNo.getIncno().endsWith(code_incno)) {
//			throw new BizException("当前住院发票号码已被他人修改，请刷新界面，重做业务！");
//		}
//		String code_payno = incService.GetInvoiceNo(operator.getId_emp(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
//
//		if (incAndPayNo.getPayno() != null && !incAndPayNo.getPayno().endsWith(code_payno)) {
//			throw new BizException("当前住院押金条号码已被他人修改，请刷新界面，重做业务！");
//		}
		
		//校验付款时预交金集合是否有两条相同的预交金数据(只校验充值的预交金数据，不校验找零的数据)
		if(!ArrayUtil.isEmpty(ipPayItmDoArr)){
			Set<String> set = new HashSet<String>();
			for (BlPayItmPatIpDO itm : ipPayItmDoArr) {
				if(!StringUtil.isEmpty(itm.getId_paypat()) && BookRtnDirectEnum.CHARGE.equals(itm.getEu_direct())){
					if(!set.add(itm.getId_paypat())){
						throw new BizException("该患者有两条相同的预交金数据，请排查");
					}
				}
			}
		}
		
		//结转数据主键
		String id_PayPatCarryOver = null;
		
		Map<String,Object> map = this.setPrePayPatKey(ipPrepayDoArr,id_PayPatCarryOver);
		
		if(map != null && map.get("id_PayPatCarryOver") != null){
			id_PayPatCarryOver = map.get("id_PayPatCarryOver").toString();
		}
		
		
		//为结转数据提前生成主键
		if(map != null && map.get("ipPrepayDoArr") != null){
			ipPrepayDoArr= (BlPrePayPatDO[]) map.get("ipPrepayDoArr");
		}
		
		
		//2. 获取结算信息 且将收付款方式金额更新回st结算表
		BlStIpDO stIpDO = this.getStIpDO(ipPayDo.getId_stip());	
		//3. 获取就诊信息
		PatiVisitDO entDo = this.getEntDoInfo(ipPayDo.getId_ent());		
		//4. 获取收付款减免的金额及类型 
		FArrayList2 arr = this.getFreeAmt(ipPayItmDoArr);
		int eu_free = (int)arr.get(0); //  1:金额减免2:项目减免
		FDouble amt_free = (FDouble)arr.get(1);
		//5. 住院发票记录
		BlincipAggDO blincipAggDO = this.saveInccaInfo(operator, stIpDO, incAndPayNo.getIncno(), reductionCgDoArr, eu_free, amt_free,isPrintInvoice,ipPayDo.getSd_pttp());
		
		//6. 结算收付款记录
		BlpaypatipAggDO blPayPatIpAggDO = this.setBlStIpPayInfo(operator, stIpDO, ipPayDo, ipPayItmDoArr,ipPrepayDoArr,isTransfer);
		//7. 修改结算数据
		this.updateBlStIpInfo(stIpDO, isArrears, isTransfer, entDo);
		//8. 修改预交金数据
		this.setBlPrePayInfo(operator, blPayPatIpAggDO, ipPrepayDoArr, stIpDO, ipPayDo.getSd_pttp());
		//9. 修改记账数据，更新记账表中fg_free为Y 
		this.updateBlCgIpInfo(reductionCgDoArr);
		//10. 修改就诊账户数据(已调用新的消费和结转接口，在内部已处理账户余额,但仍然需要处理锁定额的问题)
		this.updateEnAccountInfo(ipPayDo.getId_ent(), ipPrepayDoArr, stIpDO);
		//11. 组装发票数据
		BlStIpPayInvoceInfoDTO invoceDTO = this.setBlStIpPayInncaInfo(entDo, stIpDO, blincipAggDO, blPayPatIpAggDO, ipPrepayDoArr);
		invoceDTO.getHeadInfoDTO().setId_paypat(id_PayPatCarryOver);//结转数据主键
		
		//12.修改就诊付款标识
		if(StTypeEnum.ST_INP.equals(stIpDO.getEu_sttp())){
			this.upEntFgPay(entDo);
		}
		
		// 发送事件
		this.invokePayEvent(entDo, stIpDO, blPayPatIpAggDO, blincipAggDO);

		return invoceDTO;
	}
	
	/**
	 * 更新就诊付款标识
	 * @param entDo
	 * @throws DAException
	 */
	private void upEntFgPay(PatiVisitDO entDo) throws DAException{
		DAFacade daf = new DAFacade();
		entDo.setFg_pay(FBoolean.TRUE);
		entDo.setStatus(DOStatus.UPDATED);
		daf.updateDO(entDo, new String[]{PatiVisitDO.FG_PAY});
	}
	
	private Map<String,Object> setPrePayPatKey(BlPrePayPatDO[] ipPrepayDoArr,String id_PayPatCarryOver ){
		
		if(ArrayUtil.isEmpty(ipPrepayDoArr)){
			return null;
		}

		Map<String,Object> map = new HashMap<String,Object>();
		for (BlPrePayPatDO blPrePayPatDO : ipPrepayDoArr) {
			if(StringUtil.isEmpty(blPrePayPatDO.getId_paypat())){
				blPrePayPatDO.setId_paypat(new DBUtil().getOIDs(1)[0]);
				blPrePayPatDO.setStatus(DOStatus.NEW);
				//获得结转数据主键，兰陵住院收付款结转数据只有一个，所以这种写法可用，如果其他项目结转数据不是一个的话，这种写法有问题
				id_PayPatCarryOver = blPrePayPatDO.getId_paypat();
			}
		}
		//预交金数组
		map.put("ipPrepayDoArr", ipPrepayDoArr);
		//结转数据主键
		map.put("id_PayPatCarryOver", id_PayPatCarryOver);
		return map;
	}
	
	/**
	 * 获取结算DO信息
	 * 
	 * @param id_stip
	 * @return
	 * @throws BizException
	 */
	private BlStIpDO getStIpDO(String id_stip) throws BizException {
		IpPayPatEP ipPayPatEp = new IpPayPatEP();
		BlStIpDO stIpDO = ipPayPatEp.getSettleInfo(id_stip);
		return stIpDO;
	}
	
	/**
	 * 获取就诊DO信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEntDoInfo(String id_ent) throws BizException {
		IpPayPatEP ipPayPatEp = new IpPayPatEP();
		PatiVisitDO entDo = ipPayPatEp.getEntInfoDo(id_ent);
		return entDo;
	}
	
	/**
	 * 根据收付款明细获取减免金额及减免类型
	 * @param payItmPatIpDOArr
	 * @return
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private FArrayList2 getFreeAmt(BlPayItmPatIpDO[] payItmPatIpDOArr) {
		int eu_free = 0;		
		FDouble amt_free = FDouble.ZERO_DBL;
		
		int eu_free2 = 0;		
		FDouble amt_free2 = FDouble.ZERO_DBL;
		FArrayList2 arr = new FArrayList2();
		for (BlPayItmPatIpDO blPayItmPatIpDO : payItmPatIpDOArr) {
			if (IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getId_pm())) {// 金额减免
				eu_free = BlFreeMdEnum.AMT_FREE_MD;
				amt_free = blPayItmPatIpDO.getAmt();
				break;
			} else if (IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getId_pm())) {// 项目减免
				eu_free = BlFreeMdEnum.ITM_FREE_MD;
				amt_free = blPayItmPatIpDO.getAmt();
				break;
			}else if (IBdPripmCodeConst.ID_HP_SELF_FREE.equals(blPayItmPatIpDO.getId_pm())) {// 医保自付减免
				eu_free2 = BlFreeMdEnum.HP_SELF_FREE;
				amt_free2 = blPayItmPatIpDO.getAmt();
				break;
			}
		}
		//设置项目减免+医保自付减免
		if(eu_free == BlFreeMdEnum.ITM_FREE_MD && eu_free2 == BlFreeMdEnum.HP_SELF_FREE){
			eu_free = BlFreeMdEnum.ITM_AND_HP_SELF;
			amt_free = amt_free.add(amt_free2);
		}
		arr.add(eu_free);
		arr.add(amt_free);
		return arr;		
	}
	
	/**
	 * 住院发票记录
	 * */
	public BlincipAggDO saveInccaInfo(OperatorInfoDTO operator, BlStIpDO stIpDO,
			String incno, BlCgIpDO[] reductionDoArr, int eu_free,
			FDouble amt_free,FBoolean isPrint,String sdPttp) throws BizException {	
		IpPayPatEP ipPayPatEP = new IpPayPatEP();
		//1.组装住院发票主表
		BlIncIpDO ipIncDO = ipPayPatEP.setIncIpDo(operator, stIpDO,reductionDoArr, amt_free, incno, eu_free,isPrint);
		
		//2.组装发票明细记录
		BlIncItmIpDO[] incItmIpDoArr = ipPayPatEP.setIncItmInfo(reductionDoArr,eu_free,stIpDO.getId_stip(), amt_free);

		//3.票据编码修改
		// 判断是否开启电子发票
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(IBdInccaCodeConst.ID_INHOS_INVOICE);
		if(FBoolean.TRUE.equals(isPrint) && FBoolean.FALSE.equals(fgEcInc))
		{
			FDouble amt_pay = stIpDO.getAmt().sub(amt_free);
			if (amt_pay.doubleValue() > 0 || FBoolean.TRUE.equals(BlParams.BLSTIP0006())) {
				IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
				if(IBlDictCodeConst.SD_PTTP_BEDSIDE.equals(sdPttp)){
					incService.nextInvoiceNoBySdPttp(operator.getId_emp(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_INVOICE ,sdPttp);
				}else{
					incService.nextInvoiceNo(operator.getId_emp(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_INVOICE);
				}
			}
		}
		
		//4.组装住院结算与发票关系
		BlStIncIpDO[] stIncIpDOArr = ipPayPatEP.setStIncInfo(stIpDO.getId_stip());
		//5.组装AGG并保存
		BlincipAggDO incIpAggDO = new BlincipAggDO();
		incIpAggDO.setParentDO(ipIncDO);
		incIpAggDO.setBlIncItmIpDO(incItmIpDoArr);
		incIpAggDO.setBlStIncIpDO(stIncIpDOArr);		
		IBlincipCudService incIpCudService = ServiceFinder.find(IBlincipCudService.class);
		incIpCudService.save(new BlincipAggDO[]{incIpAggDO});
		return incIpAggDO;
	}
	/**
	 * 结算收付款记录
	 * @param isTransfer 
	 * @param ipPrepayDoArr 
	 * */
	public BlpaypatipAggDO setBlStIpPayInfo(OperatorInfoDTO operator, BlStIpDO stIpDO, BlPayPatIpDO ipPayDo, BlPayItmPatIpDO[] ipPayItmDoArr, BlPrePayPatDO[] ipPrepayDoArr, FBoolean isTransfer)
			throws BizException {
		FDateTime dateTime = AppUtils.getServerDateTime();	
		IBlpaypatipCudService payCService = ServiceFinder.find(IBlpaypatipCudService.class);
		BlpaypatipAggDO blPayPatIpAggDO = new BlpaypatipAggDO();
		// 1.组装主表数据
		ipPayDo.setId_org(operator.getId_org());
		ipPayDo.setId_grp(operator.getId_grp());
		//ipPayDo.setId_stip(stIpDO.getId_stip()); 前台已赋值
		if (StTypeEnum.ST_INP.equals(stIpDO.getEu_sttp())) {// 出院结算
			ipPayDo.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
			ipPayDo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		} else if (StTypeEnum.ST_INP_MIDWAY.equals(stIpDO.getEu_sttp())) {// 中途结算
			ipPayDo.setId_paytp(IBlDictCodeConst.ID_PAYTP_MIDST);
			ipPayDo.setSd_paytp(IBlDictCodeConst.SD_PAYTP_MIDST);
		}
		ipPayDo.setId_enttp(stIpDO.getId_enttp());
		ipPayDo.setCode_enttp(stIpDO.getCode_enttp());
		ipPayDo.setEu_direct(BookRtnDirectEnum.CHARGE);
		ipPayDo.setDt_pay(dateTime);
		ipPayDo.setId_org_pay(operator.getId_org());
		ipPayDo.setId_dep_pay(operator.getId_dep());
		ipPayDo.setId_emp_pay(operator.getId_emp());
		ipPayDo.setId_cc(null);
		ipPayDo.setFg_cc(FBoolean.FALSE);		
		//ipPayDo.setNote(stIpDO.getAmt().sub(ipPayDo.getAmt()).toString());
		ipPayDo.setStatus(DOStatus.NEW);
		blPayPatIpAggDO.setParentDO(ipPayDo);

		// 2.组装子表数据
		for (BlPayItmPatIpDO blPayItmPatIpDO : ipPayItmDoArr) {
			blPayItmPatIpDO.setId_org(operator.getId_org());
			blPayItmPatIpDO.setFg_realpay(FBoolean.TRUE);// 新加字段
			blPayItmPatIpDO.setStatus(DOStatus.NEW);
			//找零
			if(blPayItmPatIpDO.getEu_direct().equals(BookRtnDirectEnum.RETURNS)){
				//如果有结转数据，关联结转预交金和收付款
				if(isTransfer!=null && isTransfer.booleanValue()){
					for( BlPrePayPatDO prepaypat : ipPrepayDoArr) {
						if(DOStatus.NEW == prepaypat.getStatus()){//结转预交金
							blPayItmPatIpDO.setId_paypat(prepaypat.getId_paypat());
						}
					}
				}
			}
			
			
		}
		blPayPatIpAggDO.setBlPayItmPatIpDO(ipPayItmDoArr);
		// 3.组装AGG
		BlpaypatipAggDO[] blpaypatipAggDOArr = payCService.save(new BlpaypatipAggDO[] { blPayPatIpAggDO });
		if (ArrayUtil.isEmptyNoNull(blpaypatipAggDOArr)) {
			throw new BizException("结算收付款记录保存失败！");
		}
		blPayPatIpAggDO = blpaypatipAggDOArr[0];
		return blPayPatIpAggDO;
	}

	/**
	 * 修改结算数据
	 * 
	 * @throws BizException
	 * */
	public void updateBlStIpInfo(BlStIpDO blStIpDO , FBoolean isArrears, FBoolean isTransfer,PatiVisitDO entDo) throws BizException {
		IBlstipCudService stCService = ServiceFinder.find(IBlstipCudService.class);
		if (isArrears.booleanValue()) {// 欠费结算
			blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_ARREARAGE);
			blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_ARREARAGE);
		} else if (isTransfer.booleanValue()) {// 存款结算
			blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_DEPOSIT);
			blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_DEPOSIT);
		} else {
			blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
			blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		}	
		if (isArrears.booleanValue()) {// 欠费结清标志
			blStIpDO.setFg_arclear(FBoolean.FALSE);
		} else {
			blStIpDO.setFg_arclear(FBoolean.TRUE);
		}
		blStIpDO.setFg_pay(FBoolean.TRUE);// 患者收付款
		blStIpDO.setId_hp(entDo.getId_hp());
		blStIpDO.setId_patca(entDo.getId_patca());
		
		blStIpDO.setStatus(DOStatus.UPDATED);
		BlStIpDO[] blStIpDOArr = stCService.save(new BlStIpDO[] { blStIpDO });
		if (blStIpDOArr == null || blStIpDOArr.length == 0) {
			throw new BizException("结算数据修改失败！");
		}
		blStIpDO = blStIpDOArr[0];
	}
	
	/**
	 * 修改预交金数据&&如果有结转，添加新预交金数据
	 * */
	public void setBlPrePayInfo(OperatorInfoDTO operatorInfoDTO, BlpaypatipAggDO blPayPatIpAggDO, BlPrePayPatDO[] blPrePayPatDOArr, BlStIpDO blStIpDO, String sd_pttp)
			throws BizException {
		if (blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0) {
			return;
		}
		List<BlPrePayPatDO> blPrePayPatDOList = new ArrayList<BlPrePayPatDO>();
		FDouble amt = new FDouble(0);
		FBoolean isTransfer =  FBoolean.FALSE;
		FDateTime dateTime = AppUtils.getServerDateTime();
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		
		List<String> consumeList = new ArrayList<String>(); //消费预交金id
		List<BlPrepaySTDTO> prepayStDtoList = new ArrayList<BlPrepaySTDTO>(); //结转 
		
		for (BlPrePayPatDO payIpPmDto : blPrePayPatDOArr) {
			if(DOStatus.NEW==payIpPmDto.getStatus()){
				BlPrepaySTDTO stDto = new BlPrepaySTDTO();
				stDto.setId_ent(blStIpDO.getId_ent());
				//stDto.setId_pecmpy(stDO.getId_pecmpy());
				stDto.setId_pm(payIpPmDto.getId_pm());
				stDto.setSd_pm(payIpPmDto.getSd_pm());
				stDto.setSd_pttp(payIpPmDto.getSd_pttp());
				stDto.setAmt(payIpPmDto.getAmt());
				//为结转预交金提前生成主键
				stDto.setId_prepay_new(payIpPmDto.getId_paypat());
				stDto.setId_st(blStIpDO.getId_stip());
				stDto.setId_emp_pay(operatorInfoDTO.getId_emp());
				prepayStDtoList.add(stDto);
			}else{
				consumeList.add(payIpPmDto.getId_paypat());
			}
		}

		if (consumeList.size() > 0) {
			BlPrepayCDTO cDto = new BlPrepayCDTO();
			cDto.setId_ent(blStIpDO.getId_ent());
			//cDto.setId_pecmpy(stDO.getId_pecmpy());
			cDto.setSd_pttp(sd_pttp);
			FArrayList idList = new FArrayList();
			idList.addAll(consumeList);
			cDto.setPrepayids(idList);
			cDto.setId_emp(operatorInfoDTO.getId_emp());
			BlPrepaySetDTO setDto = new BlPrepaySetDTO();
			setDto.setFg_accupdate(FBoolean.TRUE);
			setDto.setFg_print(FBoolean.FALSE);
			
			prepayService.consume(cDto, setDto);
		}

		if (prepayStDtoList.size() > 0) {

			BlPrepaySetDTO setDto = new BlPrepaySetDTO();
			setDto.setFg_accupdate(FBoolean.TRUE);
			setDto.setFg_print(FBoolean.TRUE);
			
			BlPrePayPatDO[] transferDtos = prepayService.stTransfer(
					prepayStDtoList.toArray(new BlPrepaySTDTO[0]), setDto);
			String[] tPrepayIds = new String[transferDtos.length];
			for (int i = 0; i < transferDtos.length; i++) {
				tPrepayIds[i] = transferDtos[i].getId_paypat();
			}
		
		}
//		for (BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr) {
//			//1.预交金主键为空时，则表示是结转数据，否则是使用预交金付款数据
//			if (blPrePayPatDO.getId_paypat() != null) {
//				blPrePayPatDO.setFg_rep_return(FBoolean.TRUE);
//				blPrePayPatDO.setDt_return(dateTime);
//				blPrePayPatDO.setId_emp_return(operatorInfoDTO.getId_emp());
//				//blPrePayPatDO.setId_st_mid(blStIpDO.getId_stip());
//				blPrePayPatDO.setNote("预交金已消费");
//				blPrePayPatDO.setStatus(DOStatus.UPDATED);
//				blPrePayPatDOList.add(blPrePayPatDO);
//				
//				//2、 添加每一张预交金对应的红冲数据			
//				BlPrePayPatDO blPrePay = new BlPrePayPatDO();
//				blPrePay.setAmt(blPrePayPatDO.getAmt());
//				blPrePay.setId_grp(operatorInfoDTO.getId_grp());
//				blPrePay.setId_org(operatorInfoDTO.getId_org());
//				blPrePay.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYCONSUME);
//				blPrePay.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYCONSUME);
//				blPrePay.setId_pat(blStIpDO.getId_pat());
//				blPrePay.setId_enttp(blStIpDO.getId_enttp());
//				blPrePay.setCode_enttp(blStIpDO.getCode_enttp());
//				blPrePay.setId_ent(blStIpDO.getId_ent());
//				blPrePay.setEu_direct(BookRtnDirectEnum.RETURNS);
//				blPrePay.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
//				blPrePay.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
//				blPrePay.setDt_pay(dateTime);
//				blPrePay.setId_org_pay(operatorInfoDTO.getId_org());
//				blPrePay.setId_dep_pay(operatorInfoDTO.getId_dep());
//				blPrePay.setId_emp_pay(operatorInfoDTO.getId_emp());
//				blPrePay.setFg_rep_return(FBoolean.FALSE);
//				blPrePay.setFg_cc(FBoolean.FALSE);
//				blPrePay.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);// 票据分类(住院预交金收据分类的ID)
//				blPrePay.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
//				blPrePay.setId_par(blPrePayPatDO.getId_paypat());
//				//blPrePay.setId_st_mid(blStIpDO.getId_stip());
//				blPrePay.setSd_pttp(sd_pttp);
//				blPrePay.setNote("预交金票据回收");
//				blPrePay.setStatus(DOStatus.NEW);
//				blPrePayPatDOList.add(blPrePay);
//				
//			} else {
//				blPrePayPatDO.setId_grp(operatorInfoDTO.getId_grp());
//				blPrePayPatDO.setId_org(operatorInfoDTO.getId_org());
//				blPrePayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
//				blPrePayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
//				blPrePayPatDO.setId_pat(blStIpDO.getId_pat());
//				blPrePayPatDO.setId_enttp(blStIpDO.getId_enttp());
//				blPrePayPatDO.setCode_enttp(blStIpDO.getCode_enttp());
//				blPrePayPatDO.setId_ent(blStIpDO.getId_ent());
//				blPrePayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);
//				blPrePayPatDO.setDt_pay(dateTime);
//				blPrePayPatDO.setId_org_pay(operatorInfoDTO.getId_org());
//				blPrePayPatDO.setId_dep_pay(operatorInfoDTO.getId_dep());
//				blPrePayPatDO.setId_emp_pay(operatorInfoDTO.getId_emp());
//				blPrePayPatDO.setFg_rep_return(FBoolean.FALSE);
//				blPrePayPatDO.setFg_cc(FBoolean.FALSE);
//				blPrePayPatDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);// 票据分类(住院预交金收据分类的ID)
//				blPrePayPatDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
//				blPrePayPatDO.setId_st_mid(blStIpDO.getId_stip());
//				blPrePayPatDO.setSd_pttp(sd_pttp);
//				blPrePayPatDO.setNote("找零结转");
//				blPrePayPatDO.setStatus(DOStatus.NEW);
//				blPrePayPatDOList.add((BlPrePayPatDO) blPrePayPatDO.clone());
//				//是否结转，进而判断是否要更新预交金票据号
//				isTransfer = FBoolean.TRUE;
//			}			
//		}
//
//		IBlpaypatCudService preCService = ServiceFinder.find(IBlpaypatCudService.class);
//		preCService.save(blPrePayPatDOList.toArray(new BlPrePayPatDO[] {}));
//		
//		// 票据编码修改
//		if(isTransfer.booleanValue()) {
//			/*IpPayPatEP ipPayPatEP = new IpPayPatEP();
//			ipPayPatEP.updateNextBillNo(operatorInfoDTO.getId_emp(),IBdInccaCodeConst.CODE_INHOS_DEPOSIT);*/
//			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
//			incService.nextInvoiceNo(operatorInfoDTO.getId_emp(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT);
//		}
	}
	
	/**
	 * 修改记账数据
	 * */
	public void updateBlCgIpInfo(BlCgIpDO[] blCgIpDOArr) throws BizException {
		if (ArrayUtil.isEmptyNoNull(blCgIpDOArr)) {
			return;
		}
		HashMap<String, BlCgIpDO> map = new HashMap<>();
		HashSet<String> idCgIpSet = new HashSet<>();
		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
			if(StringUtils.isNotBlank(blCgIpDO.getId_cgip())){
				map.put(blCgIpDO.getId_cgip(), blCgIpDO);
			}
		}
		if(idCgIpSet.size() == 0){
			return;
		}
		IBlcgqueryRService cgRService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blCgIpDOs = cgRService.findByIds(idCgIpSet.toArray(new String[0]), FBoolean.FALSE);
		
		IBlcgqueryCudService cgCService = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO tmp = null;
		for (BlCgIpDO blCgIpDO : blCgIpDOs) {
			tmp = map.get(blCgIpDO.getId_cgip());
			blCgIpDO.setFg_free(FBoolean.TRUE);
			blCgIpDO.setAmt_hp_free(tmp.getAmt_hp_free());
			blCgIpDO.setAmt_pat_free(tmp.getAmt_pat_free());
			blCgIpDO.setStatus(DOStatus.UPDATED);
		}
		BlCgIpDO[] arr = cgCService.update(blCgIpDOs);
		if(ArrayUtil.isEmptyNoNull(arr)) {
			throw new BizException("更新记账明细失败！");
		}
	}

	/**
	 * 修改就诊账户
	 * */
	public void updateEnAccountInfo(String id_ent, BlPrePayPatDO[] blPrePayPatDOArr, BlStIpDO blStIpDO ) throws BizException {
		
		FDouble amt = new FDouble();
		if (blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0) {
			for (BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr) {
				if (blPrePayPatDO.getId_paypat() != null) {
					amt = amt.sub(blPrePayPatDO.getAmt());// 就诊预交金(原数值减去本次选择的预交金总金额)
				} else {
					amt = amt.add(blPrePayPatDO.getAmt());// 就诊预交金(原数值加上转结的预交金金额)
				}
			}
		}
		IEnOutCmdService inpPatAccImpls = ServiceFinder.find(IEnOutCmdService.class);
//		//修改预交金总额
//		inpPatAccImpls.recharge(id_ent, amt);
		// 处理婴儿单独结算
		IEn4BlQryService enService = ServiceFinder.find(IEn4BlQryService.class);
		EnMomBabyInfoDTO[] dtos = enService.getMomBabyInfos(new String[] { id_ent });
		// 母亲entid
		String entId_Mom = null;
		FBoolean isBb = FBoolean.FALSE;

		if (ArrayUtil.isEmpty(dtos)) {
			isBb = FBoolean.FALSE;
		} else {
			for (EnMomBabyInfoDTO dto : dtos) {
				if (id_ent.equals(dto.getId_ent_bb())) {
					isBb = FBoolean.TRUE;
					entId_Mom = dto.getId_ent_mom();
					continue;
				}
			}
		}
		// 婴儿是否使用母亲账户
		FBoolean isUseMmAcc = BlParams.BLSTIP0026();

		if (FBoolean.TRUE.equals(isBb) && FBoolean.TRUE.equals(isUseMmAcc)) {
			// 更新母亲账户锁定
			if (!StringUtil.isEmpty(entId_Mom)) {
				inpPatAccImpls.consume(entId_Mom, new FDouble(0).sub(blStIpDO.getAmt_ratio()));
			} else {
				throw new BizException("婴儿：" + id_ent + " 对应的母亲就诊信息为空");
			}
		} else {
			// 修改消费金额
			inpPatAccImpls.consume(id_ent, new FDouble(0).sub(blStIpDO.getAmt_ratio()));
		}
	}

	/**
	 * 组装发票数据
	 * 
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpPayInvoceInfoDTO setBlStIpPayInncaInfo(PatiVisitDO entDO, BlStIpDO blStIpDO, BlincipAggDO incIpAggDO,BlpaypatipAggDO blPayPatIpAggDO,BlPrePayPatDO[] ipPrepayDoArr) throws BizException {
		BlStIpPayInvoceInfoDTO blStIpPayInvoceInfoDTO = null;
		IpPayPatEP ipPayPatEP = new IpPayPatEP();
		BlIncIpDO blIncIpDO = incIpAggDO.getParentDO();
		if (blIncIpDO == null) {
			throw new BizException("发票信息不存在！");
		}
		BlStIpInccaInfoDTO[] bodyDTOArr = ipPayPatEP.getBlStIpPayIncInfoBySt(blIncIpDO.getId_incip());	
		if (ArrayUtil.isEmptyNoNull(bodyDTOArr)) {
			throw new BizException("结算项目明细数据为空！");
		}

		BlstipInvoiceHeadInfoDTO headDTO = new BlstipInvoiceHeadInfoDTO();
		headDTO.setId_stip(blStIpDO.getId_stip());// 住院结算标识
		headDTO.setCode_st(blStIpDO.getCode_st());// 业务流水号BL_ST_IP.CODE_ST
		headDTO.setCode_ent(entDO.getCode());// 住院号EN_ENT.CODE
		String hospitalType = BlParams.BLHP000001();
		headDTO.setName_orgtp(hospitalType);// 医疗机构类型（暂空）
		headDTO.setName_pat(entDO.getName_pat());// 患者姓名EN_ENT.NAME_PAT
		headDTO.setSd_sex(entDO.getName_sex());//患者性别EN_ENT.SD_SEX
		headDTO.setName_dep_phy(entDO.getName_dep_phy());
		headDTO.setName_dep_nur(entDO.getName_dep_nur());

		//查询医保计划
		List<EntHpDO> entHpDO = (List<EntHpDO>)new DAFacade().findByAttrValString(EntHpDO.class, "Id_ent", entDO.getId_ent(), null);
		if(entHpDO != null && !StringUtils.isEmpty(entHpDO.get(0).getCode_hppatca())) {
			if ("21".equals(entHpDO.get(0).getCode_hppatca())
					|| "31".equals(entHpDO.get(0).getCode_hppatca())
					|| "11".equals(entHpDO.get(0).getCode_hppatca())) {
				headDTO.setName_hp("职工医疗"); // 医保类型 安徽医保：居民、职工
			} else {
				headDTO.setName_hp("居民医疗");
			}
			headDTO.setCode_hp(entHpDO.get(0).getNo_hp()); // 社会保障号码：个人编号
			headDTO.setCode_hppatca(entHpDO.get(0).getCode_hppatca());
		}else {
			headDTO.setName_hp("自费医疗");
			headDTO.setCode_hp(null);
		}
		
		//获取参保区
		List<BlIncIpEntHpInfoDTO> listEntHp = this.getBdHpInfoByIdEnt(entDO.getId_ent());
		if(!ListUtil.isEmpty(listEntHp) && !StringUtils.isEmpty(listEntHp.get(0).getHpregion())) {
			headDTO.setHpregion(listEntHp.get(0).getHpregion());
		}
		
		BlPayItmPatIpDO[] payItmDOs = blPayPatIpAggDO.getBlPayItmPatIpDO();
		FDouble amt_hp = new FDouble(0);
		FDouble amt_psnacc = new FDouble(0);
		FDouble amt_self = new FDouble(0);
		FDouble amt_other = new FDouble(0);
		FDouble amt_pre = new FDouble(0);
//		FDouble amt_fill = new FDouble(0); //补缴金额
//		FDouble amt_ret = new FDouble(0);
		// 应收
		if (!StringUtil.isEmpty(entDO.getId_hp())) {
			// 传患者分摊信息
			BlPropArIpDO propArDo = this.getPropArInfo(blStIpDO.getId_stip());
			if (propArDo != null) {
				amt_hp = propArDo.getAmt_hp() == null ? FDouble.ZERO_DBL : propArDo.getAmt_hp();
				amt_self = propArDo.getAmt_cash() == null ? FDouble.ZERO_DBL : propArDo.getAmt_cash();
				amt_psnacc = propArDo.getAmt_psnacc() == null ? FDouble.ZERO_DBL : propArDo.getAmt_psnacc();
				amt_other = propArDo.getAmt_all().sub(amt_hp).sub(amt_self).sub(amt_psnacc);
			}
		}

		FDouble amt_hp_pay = FDouble.ZERO_DBL;
		FDouble amt_other_pay = FDouble.ZERO_DBL;
		FDouble amt_psnacc_pay = FDouble.ZERO_DBL;
		FDouble amt_hpbalance = FDouble.ZERO_DBL;//医保差额

		// 收付款
		for (BlPayItmPatIpDO itm : payItmDOs) {
			switch (itm.getSd_pm()) {
			case IBdPripmCodeConst.CODE_PRI_PM_INSUR: // 医保统筹支付
				amt_hp_pay = amt_hp_pay.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT: // 个人账户支付
				amt_psnacc_pay = amt_psnacc_pay.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_SERIOUSILL: // 大病支付
			case IBdPripmCodeConst.CODE_PRI_PM_BIGCIVILSERVICE: // 大额支付
			case IBdPripmCodeConst.CODE_PRI_PM_SALVAGE: // 救助金支付
			case IBdPripmCodeConst.CODE_PRI_PM_CIVILSERVICE: // 公务员补助支付
				amt_other_pay = amt_other_pay.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_PAY:
				amt_pre = amt_pre.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS:// 减免
				amt_hp_pay = amt_hp_pay.add(itm.getAmt());
				amt_hp = amt_hp.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_INSUR_DIFF://医保差额
				amt_hpbalance = amt_hpbalance.add(itm.getAmt().multiply(itm.getEu_direct()));
				break;
			default:
				// 铜陵不使用这种算法
				// if (itm.getEu_direct() == 1)
				// amt_fill = amt_fill.add(itm.getAmt());
				// else
				// amt_ret = amt_ret.add(itm.getAmt());
				break;
			}
		}
		//个人自付金额
		//amt_self = blStIpDO.getAmt_ratio().sub(amt_psnacc).sub(amt_other).sub(amt_hp);//.sub(amt_hp),.sub(amt_other)
		headDTO.setAmt_cap( MoneyFormat.getChineseValue(String.valueOf(blIncIpDO.getAmt_ratio().doubleValue()), "simpchn"));// 合计（大写）		
		headDTO.setAmt(blIncIpDO.getAmt_ratio());// 合计
		headDTO.setAmt_hp(amt_hp);// 医保统筹支付
		headDTO.setAmt_own_acc(amt_psnacc);// 个人账户支付
		headDTO.setAmt_hp_otr(amt_other);// 其它医保支付
		headDTO.setAmt_own(amt_self);// 个人支付
		headDTO.setAmt_hpbalance(amt_hpbalance);//医保差额
		if(StringUtils.isNotBlank(blIncIpDO.getId_emp_inc())){
			//获取操作员编码
			List<PsnDocDO> psnDo = (List<PsnDocDO>)new DAFacade().findByAttrValString(PsnDocDO.class, "Id_psndoc",blIncIpDO.getId_emp_inc(),null);
			headDTO.setName_emp_inc(psnDo.get(0).getCode());// 收款人BL_INC_IP.ID_EMP_INC
			
		}
		
		headDTO.setDt_inc(blIncIpDO.getDt_inc());// 收款日期BL_INC_IP.DT_INC
		headDTO.setIncno(blIncIpDO.getIncno());// 发票号码 BL_INC_IP.INCNO 只显示，不打印
		headDTO.setDt_acpt(entDO.getDt_acpt());// 入院时间EN_ENT.DT_ACPT
		headDTO.setDt_end(entDO.getDt_end());// 出院时间EN_ENT.DT_END
		//出院日期为空时代表是中途结算则出院时间为当前时间
		//入院时间全部取BL_ST_IP.DT_START时间，第一次结算 BL_ST_IP.DT_START为入科时间，第二次结算储存为上一次的结算时间
		if (entDO.getDt_end() == null ) {
			int days = blStIpDO.getDt_end().getBeginDate().getDaysAfter(blStIpDO.getDt_start().getBeginDate());//住院天数
			headDTO.setNum_day_ent(days == 0 ? 1 : days);
		} else if(entDO.getDt_end().compareTo(blStIpDO.getDt_end())<=0) {
			int days = entDO.getDt_end().getBeginDate().getDaysAfter(blStIpDO.getDt_start().getBeginDate());//住院天数
			headDTO.setNum_day_ent(days == 0 ? 1 : days);
		} else { 
			int days = blStIpDO.getDt_end().getBeginDate().getDaysAfter(blStIpDO.getDt_start().getBeginDate());//住院天数
			headDTO.setNum_day_ent(days == 0 ? 1 : days);
		}
		
		headDTO.setMrno(entDO.getCode());// 病历号（和住院号相同）
		headDTO.setAmt_pre(amt_pre.setScale(-2, BigDecimal.ROUND_HALF_UP));// 预缴金额
//		铜陵不使用
//		headDTO.setAmt_fill(amt_fill.setScale(-2, BigDecimal.ROUND_HALF_UP));// 补缴金额		
//		headDTO.setAmt_ret(amt_ret.setScale(-2, BigDecimal.ROUND_HALF_UP));// 退费金额
		// 退费金额
		FDouble amt_result = blStIpDO.getAmt_ratio().sub(amt_pre).sub(amt_other_pay).sub(amt_psnacc_pay)
				.sub(amt_hp_pay);// .sub(amt_hp)
		if (amt_result.compareTo(new FDouble(0)) >= 0) {
			headDTO.setAmt_fill(amt_result.setScale(-2, BigDecimal.ROUND_HALF_UP)); // 补缴只补
																					// 差额，找零不计入补缴之内（铜陵）
			headDTO.setAmt_ret(new FDouble(0).setScale(-2, BigDecimal.ROUND_HALF_UP));			
		} else {
			headDTO.setAmt_fill(new FDouble(0).setScale(-2, BigDecimal.ROUND_HALF_UP));
			headDTO.setAmt_ret(amt_result.setScale(-2, BigDecimal.ROUND_HALF_UP).multiply(new FDouble(-1)));			
		}
		

		FArrayList invList = new FArrayList();
		for (BlStIpInccaInfoDTO info : bodyDTOArr) {
			invList.add(info);
		}

		// 结算明细
		IBlcgqueryService cgQueService = ServiceFinder.find(IBlcgqueryService.class);
		BlCgZyQueryDTO[] stHeadDTOArr = cgQueService.BlCgZyFindByQCond(" and d.id_ent = '" + blStIpDO.getId_ent() + "'", null, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(stHeadDTOArr)) {
			throw new BizException("患者就诊信息不存在！");
		}
//		// 获取本次结算对应的记账明细
//		IBlcgqueryRService cgMRService = ServiceFinder.find(IBlcgqueryRService.class);
//		BlCgIpDO[] blCgIpDOArr = cgMRService.find(" a0.id_stip = '" + blStIpDO.getId_stip() + "'", null, FBoolean.FALSE);
//		if (ArrayUtil.isEmptyNoNull(blCgIpDOArr)) {
//			throw new BizException("结算明细信息为空！");
//		}
//		FArrayList blCgIpDOList = new FArrayList();
//		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
//			blCgIpDOList.add(blCgIpDO);
//		}
		
		//查询收付款数据
		IBlpaypatipRService payService = ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO[] payAggDos = payService.findByAttrValString(BlPayPatIpDO.ID_STIP, blStIpDO.getId_stip());
		
		FArrayList payList = new FArrayList();
		if(!ArrayUtil.isEmpty(payAggDos)){
			for (BlPayItmPatIpDO payItmDO : payAggDos[0].getBlPayItmPatIpDO()) {
				BlInvoicePmDTO pmDto = new BlInvoicePmDTO();
				pmDto.setId_pm(payItmDO.getId_pm());
				pmDto.setSd_pm(payItmDO.getSd_pm());
				pmDto.setName_pm(payItmDO.getPm_name());
				pmDto.setEu_direct(payItmDO.getEu_direct());
				pmDto.setAmt(payItmDO.getAmt());
				pmDto.setFg_realpay(payItmDO.getFg_realpay());
				pmDto.setId_payitmpatip(payItmDO.getId_payitmpatip());
				pmDto.setId_paypat(payItmDO.getId_paypat());
				payList.add(pmDto);
			}
		}

		blStIpPayInvoceInfoDTO = new BlStIpPayInvoceInfoDTO();
		blStIpPayInvoceInfoDTO.setHeadInfoDTO(headDTO);
		blStIpPayInvoceInfoDTO.setBodyInfoDTO(invList);
		blStIpPayInvoceInfoDTO.setStHeadInfoDTO(stHeadDTOArr[0]);
//		blStIpPayInvoceInfoDTO.setStBodyInfoArr(blCgIpDOList);
		blStIpPayInvoceInfoDTO.setBlInvoicePmDTOList(payList);
		return blStIpPayInvoceInfoDTO;
	}

	
	/**
	 * 查询患者的应付信息
	 * @param stid
	 * @return
	 * @throws BizException
	 */
	private BlPropArIpDO getPropArInfo(String stid) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select propar.* from bl_prop_ar_ip propar                        ");
		sql.append("inner join bl_prop_ip prop on prop.id_propip=propar.id_propip    ");
		sql.append("where prop.id_stip=?                                           ");
		SqlParam param=new SqlParam();
		param.addParam(stid);
		List<BlPropArIpDO> list = (List<BlPropArIpDO>) new DAFacade().execQuery(sql.toString(),param,
				new BeanListHandler(BlPropArIpDO.class));
		if(ListUtil.isEmpty(list)){
			return null;
		}
		return list.get(0);

	}
	
	/**
	 * 住院结算收付款发送事件
	 * 
	 * @throws BizException
	 * */
	public void invokePayEvent(PatiVisitDO patiVisitDO, BlStIpDO blStIpDO, BlpaypatipAggDO blPayPatIpAggDO, BlincipAggDO blincipAggDO) throws BizException {
		// 发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
		blEventInfoDTO.setBlpaypatipAggDO(blPayPatIpAggDO);
		blEventInfoDTO.setBlStIpDO(blStIpDO);
		blEventInfoDTO.setBlincipAggDO(blincipAggDO);

		IpRcvPayPatEvent ipRcvPayPatEvent = new IpRcvPayPatEvent();
		ipRcvPayPatEvent.invokePay(blEventInfoDTO);
	}

	/**
	 * 获取就诊相关的医保计划信息
	 * */
	@SuppressWarnings("unchecked")
	public List<BlIncIpEntHpInfoDTO> getBdHpInfoByIdEnt(String id_ent) throws BizException {
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" SELECT  ENT_HP.ID_ENT, ");
		sqlSB.append("         ENT_HP.FG_MAJ, ");
		sqlSB.append("         B.CODE  AS  CODE_HP, ");
		sqlSB.append("         B.NAME  AS  NAME_HP, ");
		sqlSB.append("         BDREGION.NAME  AS  HPREGION ");
		sqlSB.append("     FROM  EN_ENT_HP  ENT_HP ");
		sqlSB.append("     LEFT  JOIN  BD_MHI_REGION  BDREGION ");
		sqlSB.append("         ON  BDREGION.CODE  =  ENT_HP.CODE_HPAREA ");
		sqlSB.append("     LEFT  JOIN  BD_HP  B ");
		sqlSB.append("         ON  ENT_HP.ID_HP  =  B.ID_HP ");
		sqlSB.append("   WHERE  ENT_HP.ID_ENT  = ? ");
		sqlSB.append("   ORDER  BY  B.CODE ");
		SqlParam param=new SqlParam();
		param.addParam(id_ent);
		List<BlIncIpEntHpInfoDTO> list = (List<BlIncIpEntHpInfoDTO>) new DAFacade().execQuery(sqlSB.toString(),param, new BeanListHandler(BlIncIpEntHpInfoDTO.class));
		return list;
	}
	
	
}
