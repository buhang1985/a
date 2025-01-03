package iih.bl.itf.std.bp.ipprepay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.itf.bltranscall.d.BlTransCalledRcdDO;
import iih.bl.itf.bltranscall.d.ItfTypeEnum;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamPrepay;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamPrepayInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultInfoPrepay;
import iih.bl.itf.std.bean.output.prepay.WsResultPrepay;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamPrepayValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.lock.PKLock;

/**
 * 住院押金充值
 * 
 * @author ly 2018/7/20
 *
 */
public class IpRechargePrepayBP extends BlItfBaseBP<WsParamPrepay,WsResultPrepay> {
	
	@Override
	protected String getBusiness() {
		return "住院预交金充值";
	}

	@Override
	protected void checkParam(WsParamPrepay param) throws BizException {
		WsParamPrepayValidator validator = new WsParamPrepayValidator();
		validator.validate(param);
		
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("住院预交金充值:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		Context.get().setDeptId(psndocDO.getId_dep());
	}

	/**
	 * 创建交易记录
	 * 在dowork前调用，可将部分数据初始化挪至该处理
	 * @param xml
	 * @param tData
	 * @return
	 * @throws BizException
	 */
	@Override
	protected BlTransCalledRcdDO createTransRcd(String xml, WsParamPrepay param) throws BizException{
		
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		
		BlTransCalledRcdDO rcdDO = new BlTransCalledRcdDO();
		rcdDO.setId_org(Context.get().getOrgId());
		rcdDO.setId_grp(Context.get().getGroupId());
		rcdDO.setEu_itftp(ItfTypeEnum.IPPREPAYRECHARGE);
		rcdDO.setId_pat(null);
		rcdDO.setId_ent(null);
		rcdDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		rcdDO.setId_pm(prepayInfo.getPaymentMethod());//临时保存入参原始值
		rcdDO.setVoucher_no(prepayInfo.getDocumentNumber());
		rcdDO.setOrder_no(prepayInfo.getOrderNumber());
		rcdDO.setFg_success(FBoolean.FALSE);
		rcdDO.setId_emp_oper(Context.get().getStuffId());
		rcdDO.setDt_oper(BlFlowContextUtil.getNowTime());
		rcdDO.setInput(xml);
		rcdDO.setStatus(DOStatus.NEW);
		
		return rcdDO;
	}
	
	@Override
	protected WsResultPrepay doWork(WsParamPrepay param) throws BizException {
		WsParamPrepayInfo prepayInfo = param.getPrepay();

		// 查询患者信息
		String entId = this.findPat(prepayInfo);

		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDO = entService.findById(entId);
		
		//充值之前先判断患者是否退院，如果退院，则不让充值（退院和取消登记都不让充值）
		if(entDO != null && entDO.getFg_canc() != null && entDO.getFg_canc().booleanValue()){
			throw new BizException("住院预交金充值：该患者已退院，不能充值");
		}
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrepayRDTO pDto = new BlPrepayRDTO();

		pDto.setId_ent(entDO.getId_ent());
		pDto.setId_pat(entDO.getId_pat());
		pDto.setAmt(BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney()));
		pDto.setSd_pttp(prepayInfo.getTerminalType());
		pDto.setId_pm(this.findPmId(prepayInfo.getPaymentMethod()));
		pDto.setSd_pm(prepayInfo.getPaymentMethod());
		pDto.setBankno(prepayInfo.getDocumentNumber());
		pDto.setPaymodenode(prepayInfo.getOrderNumber());
		pDto.setId_emp_pay(Context.get().getStuffId());
		pDto.setEu_direct(BookRtnDirectEnum.CHARGE);
		pDto.setBankcardno(prepayInfo.getBankCardNo());

		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_print(FBoolean.TRUE);//打印票据
		setDto.setFg_accupdate(FBoolean.TRUE);//是否更新账户
		if(!StringUtil.isEmpty(prepayInfo.getIncType())){
			if("01".equals(prepayInfo.getIncType()) && !StringUtil.isEmpty(prepayInfo.getIncPayNo())){
				setDto.setFg_useinc(FBoolean.FALSE);//凭证模式下，不走票据包，使用自助机自己传进来的号码
				pDto.setCode_req(prepayInfo.getIncPayNo());
			}else if("01".equals(prepayInfo.getIncType()) && StringUtil.isEmpty(prepayInfo.getIncPayNo())){
				throw new BizException("住院预交金充值:凭证模式下，自助机传入的收据编码不能为空");
			}else{
				setDto.setFg_useinc(FBoolean.TRUE);//其他情况，走票据包
			}
		}
		

		// 患者是否在院
		FBoolean fg_ip = entDO.getFg_ip();

		Boolean isRcByOutPay = this.canRcByOutPay(entDO.getId_ent(), fg_ip);
		// 充值之前判断一下如果患者出院并且付款之后，则不让充值
		if (isRcByOutPay) {
			// 组织返回值
			WsResultPrepay rlt = new WsResultPrepay();
			WsResultMsg rltMsg = new WsResultMsg();
			rltMsg.setCode(IBlWsConst.RLT_FAIL);
			rltMsg.setMessage("出院并且收付款完成后不可充值");
			rlt.setRltMsg(rltMsg);
			this.writebackTransFail("出院并且收付款完成后不可充值");
			return rlt;
		}

		// 充值之前首先得判断一下充值的订单号是否和库的一样，如果有相同的，则不让充值
		FBoolean isReCharge = this.canReCharge(prepayInfo,entDO);
//		String checkMsg = "";
//		// 1订单号重复 2流水凭证号重复 3两个号都重复
//		if (isReCharge == 1) {
//			checkMsg = "订单号重复";
//		} else if (isReCharge == 2) {
//			checkMsg = "流水凭证号重复";
//		} else if (isReCharge == 3) {
//			checkMsg = "订单号和流水凭证号都重复";
//		}
		
		if(isReCharge.booleanValue()){
			WsResultPrepay rlt = new WsResultPrepay();
			WsResultMsg rltMsg = new WsResultMsg();
			rltMsg.setCode(IBlWsConst.RLT_FAIL);
			rltMsg.setMessage("订单号或者流水凭证号重复");
			rlt.setRltMsg(rltMsg);
			this.writebackTransFail("订单号或者流水凭证号重复");
			return rlt;
		}

		// 充值
		BlPrePayPatDO prepayDO = prepayService.recharge(pDto, setDto);

		IEnOutQryService accService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO accInfo = accService.getBalanceDTO(entDO.getId_ent());

		// 组织返回值
		WsResultPrepay rlt = new WsResultPrepay();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);

		WsResultInfoPrepay rltInfo = new WsResultInfoPrepay();
		rltInfo.setIncCode(prepayDO.getCode_rep());
		rltInfo.setBalance(BlAmtConverUtil.toXmlString(accInfo.getAmt_bal()));

		rlt.setRltMsg(rltMsg);
		rlt.setRltInfo(rltInfo);

		String output = rlt.serialize();
		this.writebackTransSuccess(prepayDO, output);
		return rlt;
	}

	/**
	 * 充值之前判断一下如果患者出院并且付款之后，则不让充值
	 * 
	 * @return
	 * @throws BizException
	 */
	private Boolean canRcByOutPay(String entId, FBoolean fg_ip) throws BizException {
		// 最终返回值
		Boolean fg_final = false;
		// 是否收付款
		FBoolean fg_pay = FBoolean.FALSE;

		IBlstipRService iBlStIpService = ServiceFinder.find(IBlstipRService.class);
		//出院结算判断是否收付款 
		BlStIpDO[] blStDOs = iBlStIpService.find(" id_ent = '" + entId + "' and eu_sttp = '10' and fg_canc = 'N' ", "", FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(blStDOs)) {
			fg_pay = blStDOs[0].getFg_pay();
		}

		if (!fg_ip.booleanValue() && fg_pay.booleanValue()) {
			fg_final = true;
		}

		return fg_final;
	}

	/**
	 * 充值之前首先得判断一下充值的订单号是否和库的一样，如果有相同的，则不让充值
	 * 
	 * @throws BizException
	 */
	private FBoolean canReCharge(WsParamPrepayInfo prepayInfo,PatiVisitDO entDO) throws BizException {
		BLThirdItfLogger.info("住院预交金充值开始校验:" + entDO.getId_pat() + "流水号：" + prepayInfo.getDocumentNumber() + "订单号：" + prepayInfo.getOrderNumber());
		Set<String> lockKeyList = new HashSet<String>();

		//锁定订单号和凭证号
		lockKeyList.add(entDO.getId_pat() + prepayInfo.getDocumentNumber());
		lockKeyList.add(entDO.getId_pat() + prepayInfo.getOrderNumber());
		
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 0);
		if(!lock){
			throw new BizException("其他用户正锁定表BL_PREPAY_PAT中的相关记录，请稍后重试!");
		}
		
		BLThirdItfLogger.info("加锁了，住院预交金充值开始校验:" + entDO.getId_pat() + "流水号：" + prepayInfo.getDocumentNumber() + "订单号：" + prepayInfo.getOrderNumber());
		// 1、查预交金库
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" paymodenode,bankno ");
		sql.append(" from bl_prepay_pat pre ");
		sql.append(" where  (pre.paymodenode = ? or pre.bankno = ?) and pre.sd_pttp <> ? and pre.sd_paytp = ?  ");
	

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(prepayInfo.getOrderNumber());
		sp.addParam(prepayInfo.getDocumentNumber());
		sp.addParam(IBlDictCodeConst.SD_PTTP_WINDOW);
		sp.addParam(IBlDictCodeConst.SD_PAYTP_IPPREPAY);

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<BlPrePayPatDO> list = (List<BlPrePayPatDO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BlPrePayPatDO.class));

		
		BLThirdItfLogger.info("查询了，住院预交金充值:" + entDO.getId_pat() + "流水号：" + prepayInfo.getDocumentNumber() + "订单号：" + prepayInfo.getOrderNumber());

		if(ListUtil.isEmpty(list)){
			return FBoolean.FALSE;
		}
		
		return FBoolean.TRUE;
		//		int isReCharge = 0;
//
//		for (BlPrePayPatDO itm : list) {
//			if (itm.getPaymodenode() != null && itm.getBankno() != null
//					&& itm.getPaymodenode().equals(prepayInfo.getOrderNumber())
//					&& itm.getBankno().equals(prepayInfo.getDocumentNumber())) {
//				// 订单号和流水凭证号都重复
//				isReCharge = 3;
//				break;
//			}
//			if (itm.getPaymodenode() != null && itm.getPaymodenode().equals(prepayInfo.getOrderNumber())) {
//				// 订单号重复
//				isReCharge = 1;
//				break;
//			}
//			if (itm.getBankno() != null && itm.getBankno().equals(prepayInfo.getDocumentNumber())) {
//				// 流水凭证号重复
//				isReCharge = 2;
//				break;
//			}
//
//		}
//		return isReCharge;
	}

	/**
	 * 查询患者id
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamPrepayInfo prepayInfo) throws BizException {

		IInpatientRService service = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] entIpDos = service.findByAttrValString(InpatientDO.CODE_AMR_IP, prepayInfo.getIPCode());
		// InpatientDO[] entIpDos =
		// service.find("Code_amr_ip='"+prepayInfo.getIPCode()+"' and
		// times_ip="+prepayInfo.getEnTimes()+"", "", FBoolean.FALSE);

		if (ArrayUtil.isEmpty(entIpDos)) {
			throw new BizException("住院预交金充值:未查询到患者住院信息");
		}

		// 最大住院次数数据
		String entId = null;
		int max = 0;
		for (InpatientDO inpatientDO : entIpDos) {
			if (inpatientDO.getTimes_ip() >= max) {
				max = inpatientDO.getTimes_ip();
				entId = inpatientDO.getId_ent();
			}
		}

		return entId;
	}

	/**
	 * 查询付款方式
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private String findPmId(String code) throws BizException{
		IPripmRService pmService = ServiceFinder.find(IPripmRService.class);
		PriPmDO[] dos = pmService.findByAttrValString(PriPmDO.CODE, code);
		if(ArrayUtil.isEmpty(dos)){
			throw new BizException("住院预交金充值:未查询到支付方式信息");
		}
		
		return dos[0].getId_pm();
	}

	/**
	 * 成功后回写交易记录
	 * @param prepayDO
	 * @throws BizException
	 */
	private void writebackTransSuccess(BlPrePayPatDO prepayDO, String output) throws BizException {
		
		if(this.transRcdDO == null)
			return;
		
		this.transRcdDO.setFg_success(FBoolean.TRUE);
		this.transRcdDO.setId_pat(prepayDO.getId_pat());
		this.transRcdDO.setId_ent(prepayDO.getId_ent());
		this.transRcdDO.setId_pay(prepayDO.getId_paypat());
		this.transRcdDO.setId_pm(prepayDO.getId_pm());
		this.transRcdDO.setOutput(output);
	}
	
	/**
	 * 失败后回写交易记录
	 * @param msg
	 * @throws BizException
	 */
	private void writebackTransFail(String msg) throws BizException {
		
		if(this.transRcdDO == null)
			return;
		
		this.transRcdDO.setFg_success(FBoolean.FALSE);
		this.transRcdDO.setError_msg(msg);
	}
}
