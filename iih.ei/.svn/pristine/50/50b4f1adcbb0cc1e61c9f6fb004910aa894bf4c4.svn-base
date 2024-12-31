package iih.ei.std.s.v1.bp.bl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bd.utils.WsXmlUtils;
import iih.bl.itf.bltranscall.d.BlTransCalledRcdDO;
import iih.bl.itf.bltranscall.d.ItfTypeEnum;
import iih.bl.itf.bltranscall.i.IBltranscallCudService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamPrepayInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultInfoPrepay;
import iih.bl.itf.std.bean.output.prepay.WsResultPrepay;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.ei.std.d.v1.bl.oprechargedto.d.OpRechargeParamDTO;
import iih.ei.std.d.v1.bl.oprechargedto.d.OpRechargeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
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

/***
 * 门诊押金充值
 * 
 * @author shaokx
 * @date: 2019.10.10
 */
public class OpRechargeBP extends IIHServiceBaseBP<OpRechargeParamDTO, OpRechargeResultDTO>{

	BlTransCalledRcdDO transRcdDO;
	IBltranscallCudService transService = ServiceFinder.find(IBltranscallCudService.class);
	
	@Override
	protected void checkParam(OpRechargeParamDTO param) throws BizException {
		
		if (param == null) {
			throw new BizException("入参为空");
		}
		
		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}
		
		if(StringUtil.isEmpty(param.getCode_enttp())){
			throw new BizException("预交金充值入参就诊类型为空");
		}
		
		if(!IBlWsConst.ENTP_OP.equals(param.getCode_enttp())){
			throw new BizException("预交金充值入参就诊类型值不正确");
		}
		
		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum())) {
			throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
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
		
		//设置人员上下文
		PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_opera());
		if (psndocDO == null) {
			throw new BizException("门诊预交金充值:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		Context.get().setDeptId(psndocDO.getId_dep());
		
	}

//	@Override
//	protected void beforeProcess(OpRechargeParamDTO param) throws BizException {
//		
//		transRcdDO = new BlTransCalledRcdDO();
//		transRcdDO.setId_org(Context.get().getOrgId());
//		transRcdDO.setId_grp(Context.get().getGroupId());
//		transRcdDO.setEu_itftp(ItfTypeEnum.OPPREPAYRECHARGE);
//		transRcdDO.setId_pat(null);
//		transRcdDO.setId_ent(null);
//		transRcdDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
//		transRcdDO.setId_pm(param.getCode_pm());//临时保存入参原始值
//		transRcdDO.setVoucher_no(param.getBankno());
//		transRcdDO.setOrder_no(param.getPaymodenode());
//		transRcdDO.setFg_success(FBoolean.FALSE);
//		transRcdDO.setId_emp_oper(Context.get().getStuffId());
//		transRcdDO.setDt_oper(BlAmtConverUtil.getNowTime());
//		//transRcdDO.setInput(WsXmlUtils.serialize(param));
//		transRcdDO.setStatus(DOStatus.NEW);
//		
//		transService.insert(new BlTransCalledRcdDO[] { transRcdDO });
//	}

	@Override
	protected OpRechargeResultDTO process(OpRechargeParamDTO param) throws BizException {

		//查询患者信息
		String patId = this.findPat(param);
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrepayRDTO pDto = new BlPrepayRDTO();
		//组织入参
		pDto.setId_pat(patId);
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
		setDto.setFg_print(FBoolean.TRUE);
		setDto.setFg_accupdate(FBoolean.TRUE);
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
		
		// 充值之前首先得判断一下充值的订单号是否和库的一样，如果有相同的，则不让充值
		FBoolean isReCharge = this.canReCharge(param,patId);
		
		if(isReCharge.booleanValue()){
			//this.writebackTransFail("订单号或者流水凭证号重复");
			throw new BizException("订单号或者流水凭证号重复");
		}
		
		//充值
		BlPrePayPatDO prepayDO = prepayService.recharge(pDto, setDto);
		
		IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO accInfo = accService.GetPatRelAmountInfo(patId);
		
		//组织返回值
		OpRechargeResultDTO rlt1 = new OpRechargeResultDTO();

		rlt1.setCode_req(prepayDO.getCode_rep());
		rlt1.setAmt_balance(BlAmtConverUtil.toXmlString(accInfo.getPrepay().sub(accInfo.getAcc_lock())));
		

		//String output = WsXmlUtils.serialize(rlt1);
		//this.writebackTransSuccess(prepayDO);
		return rlt1;
	}
	
	/**
	 * 充值之前首先得判断一下充值的订单号是否和库的一样，如果有相同的，则不让充值
	 * 
	 * @throws BizException
	 */
	private FBoolean canReCharge(OpRechargeParamDTO param,String patId) throws BizException {
		
		Set<String> lockKeyList = new HashSet<String>();

		//锁定订单号和凭证号
		lockKeyList.add(patId + param.getBankno());
		lockKeyList.add(patId + param.getPaymodenode());
		
		boolean lock = PKLock.getInstance().addBatchDynamicLock(lockKeyList.toArray(new String[0]), 0);
		if(!lock){
			throw new BizException("其他用户正锁定表BL_PREPAY_PAT中的相关记录，请稍后重试!");
		}
		
		// 1、查预交金库
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" paymodenode,bankno ");
		sql.append(" from bl_prepay_pat pre");
		sql.append(" where  (pre.paymodenode = ? or pre.bankno = ?) and pre.sd_pttp <> ? and pre.sd_paytp = ? ");

		SqlParam sp = new SqlParam();
		sp.addParam(param.getPaymodenode());
		sp.addParam(param.getBankno());
		sp.addParam(IBlDictCodeConst.SD_PTTP_WINDOW);
		sp.addParam(IBlDictCodeConst.SD_PAYTP_OPPREPAY);
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
	 * 查询患者
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(OpRechargeParamDTO param)throws BizException {
	
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());
		
		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if(ArrayUtil.isEmpty(patiAggs)){
			throw new BizException("门诊预交金充值:未查询到患者信息");
		}
		
		return patiAggs[0].getParentDO().getId_pat();
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
			throw new BizException("门诊预交金充值:未查询到支付方式信息");
		}
		
		return dos[0].getId_pm();
	}

//	/**
//	 * 成功后回写交易记录
//	 * @param prepayDO
//	 * @throws BizException
//	 */
//	private void writebackTransSuccess(BlPrePayPatDO prepayDO) throws BizException {
//		
//		if(this.transRcdDO == null)
//			return;
//		
//		this.transRcdDO.setFg_success(FBoolean.TRUE);
//		this.transRcdDO.setId_pat(prepayDO.getId_pat());
//		this.transRcdDO.setId_pay(prepayDO.getId_paypat());
//		this.transRcdDO.setId_pm(prepayDO.getId_pm());
//		//this.transRcdDO.setOutput(output);
//		
//		this.transService.update(new BlTransCalledRcdDO[] { this.transRcdDO });
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
//		this.transService.update(new BlTransCalledRcdDO[] { this.transRcdDO });
//	}

}
