package iih.ei.std.s.v1.bp.bl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.ei.std.d.v1.bl.iprechargedto.d.IpRechargeParamDTO;
import iih.ei.std.d.v1.bl.iprechargedto.d.IpRechargeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
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

/***
 * 门诊押金充值
 * 
 * @author shaokx
 * @date: 2019.10.11
 */
public class IpRechargeBP extends IIHServiceBaseBP<IpRechargeParamDTO, IpRechargeResultDTO>{

	@Override
	protected void checkParam(IpRechargeParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("入参为空");
		}
		
		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}
		
		if(StringUtil.isEmpty(param.getCode_enttp())){
			throw new BizException("预交金充值入参就诊类型为空");
		}
		
		if(!IBlWsConst.ENTP_IP.equals(param.getCode_enttp())){
			throw new BizException("预交金充值入参就诊类型值不正确");
		}
		
		if (StringUtil.isEmpty(param.getCode_amr_ip())) {
			throw new BizException("入参关键信息为空：住院号");
		}
		
		if(StringUtil.isEmpty(param.getCode_pm())){
			throw new BizException("预交金充值入参支付方式为空");
		}
		
		if(StringUtil.isEmpty(param.getAmt())){
			throw new BizException("预交金充值入参支付金额为空");
		}
		
		if(!BlAmtConverUtil.isNumeric(param.getAmt())){
			throw new BizException("预交金充值入参支付金额值不正确");
		}
		
		if(StringUtil.isEmpty(param.getCode_opera())){
			throw new BizException("预交金充值入参操作员编码为空");
		}
		
        if(!StringUtil.isEmpty(param.getCode_pm()) && IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(param.getCode_pm())){
			
		}else{
			if(StringUtil.isEmpty(param.getBankno()) && StringUtil.isEmpty(param.getPaymodenode())){
				throw new BizException("订单号和流水号都为空");
			}
		}
        
        if(StringUtil.isEmpty(param.getSd_pttp())){
			throw new BizException("预交金充值入参终端类型为空");
		}
		
		if(!BlAmtConverUtil.checkTerminalType(param.getSd_pttp())){
			throw new BizException("预交金充值入参终端类型值不正确");
		}
		
		PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_opera());
		if (psndocDO == null) {
			throw new BizException("住院预交金充值:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		Context.get().setDeptId(psndocDO.getId_dep());
		
	}

	@Override
	protected IpRechargeResultDTO process(IpRechargeParamDTO param) throws BizException {

		// 查询患者信息
		String entId = this.findPat(param);

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
		pDto.setAmt(BlAmtConverUtil.toFDouble(param.getAmt()));
		pDto.setSd_pttp(param.getSd_pttp());
		pDto.setId_pm(this.findPmId(param.getCode_pm()));
		pDto.setSd_pm(param.getCode_pm());
		pDto.setBankno(param.getBankno());
		pDto.setPaymodenode(param.getPaymodenode());
		pDto.setBankcardno(param.getBankcardno());
		pDto.setId_emp_pay(Context.get().getStuffId());
		pDto.setEu_direct(BookRtnDirectEnum.CHARGE);

		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_print(FBoolean.TRUE);//打印票据
		setDto.setFg_accupdate(FBoolean.TRUE);//是否更新账户
		if(!StringUtil.isEmpty(param.getInc_type())){
			if("01".equals(param.getInc_type()) && !StringUtil.isEmpty(param.getCode_req())){
				setDto.setFg_useinc(FBoolean.FALSE);//凭证模式下，不走票据包，使用自助机自己传进来的号码
				pDto.setCode_req(param.getCode_req());
			}else if("01".equals(param.getInc_type()) && StringUtil.isEmpty(param.getCode_req())){
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
			//this.writebackTransFail("出院并且收付款完成后不可充值");
            throw new BizException("出院并且收付款完成后不可充值");
		}

		// 充值之前首先得判断一下充值的订单号是否和库的一样，如果有相同的，则不让充值
		FBoolean isReCharge = this.canReCharge(param,entDO);

		if(isReCharge.booleanValue()){
			//this.writebackTransFail("订单号或者流水凭证号重复");
			throw new BizException("订单号或者流水凭证号重复");
		}

		// 充值
		BlPrePayPatDO prepayDO = prepayService.recharge(pDto, setDto);

		IEnOutQryService accService = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO accInfo = accService.getBalanceDTO(entDO.getId_ent());

		// 组织返回值
		IpRechargeResultDTO rlt1 = new IpRechargeResultDTO();

		rlt1.setCode_req(prepayDO.getCode_rep());
		rlt1.setAmt_balance(BlAmtConverUtil.toXmlString(accInfo.getAmt_bal()));

		//String output = rlt.serialize();
		//this.writebackTransSuccess(prepayDO, output);
		
		return rlt1;
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
	private FBoolean canReCharge(IpRechargeParamDTO param,PatiVisitDO entDO) throws BizException {

		Set<String> lockKeyList = new HashSet<String>();

		//锁定订单号和凭证号
		lockKeyList.add(entDO.getId_pat() + param.getBankno());
		lockKeyList.add(entDO.getId_pat() + param.getPaymodenode());
		
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 0);
		if(!lock){
			throw new BizException("其他用户正锁定表BL_PREPAY_PAT中的相关记录，请稍后重试!");
		}
		
		// 1、查预交金库
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" paymodenode,bankno ");
		sql.append(" from bl_prepay_pat pre ");
		sql.append(" where  (pre.paymodenode = ? or pre.bankno = ?) and pre.sd_pttp <> ? and pre.sd_paytp = ?  ");
	
		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(param.getPaymodenode());
		sp.addParam(param.getBankno());
		sp.addParam(IBlDictCodeConst.SD_PTTP_WINDOW);
		sp.addParam(IBlDictCodeConst.SD_PAYTP_IPPREPAY);

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<BlPrePayPatDO> list = (List<BlPrePayPatDO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(BlPrePayPatDO.class));

		if(ListUtil.isEmpty(list)){
			return FBoolean.FALSE;
		}
		
		return FBoolean.TRUE;
	}

	/**
	 * 查询患者id
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(IpRechargeParamDTO param) throws BizException {

		IInpatientRService service = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] entIpDos = service.findByAttrValString(InpatientDO.CODE_AMR_IP, param.getCode_amr_ip());
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

//	/**
//	 * 成功后回写交易记录
//	 * @param prepayDO
//	 * @throws BizException
//	 */
//	private void writebackTransSuccess(BlPrePayPatDO prepayDO, String output) throws BizException {
//		
//		if(this.transRcdDO == null)
//			return;
//		
//		this.transRcdDO.setFg_success(FBoolean.TRUE);
//		this.transRcdDO.setId_pat(prepayDO.getId_pat());
//		this.transRcdDO.setId_ent(prepayDO.getId_ent());
//		this.transRcdDO.setId_pay(prepayDO.getId_paypat());
//		this.transRcdDO.setId_pm(prepayDO.getId_pm());
//		this.transRcdDO.setOutput(output);
//	}
	
//	/**
//	 * 失败后回写交易记录
//	 * @param msg
//	 * @throws BizException
//	 */
//	private void writebackTransFail(String msg) throws BizException {
//		
//		if(this.transRcdDO == null)
//			return;
//		
//		this.transRcdDO.setFg_success(FBoolean.FALSE);
//		this.transRcdDO.setError_msg(msg);
//	}

}
