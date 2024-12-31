package iih.bl.itf.std.bp.opprepay;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
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
import iih.bl.itf.std.bp.validator.WsParamPrepayRefundValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDORService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊退预交金
 * @author ly 2019/11/21
 *
 */
public class OpRefundPrepayBP extends BlItfBaseBP<WsParamPrepay,WsResultPrepay>{

	protected String patId;
	protected BlPrePayPatDO oriPrepayDO;
	
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
		rcdDO.setEu_itftp(ItfTypeEnum.OPPREPAYREFUND);
		rcdDO.setId_pat(null);
		rcdDO.setId_ent(null);
		rcdDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		rcdDO.setId_pm(prepayInfo.getPaymentMethod());//临时保存入参原始值
		rcdDO.setVoucher_no(prepayInfo.getDocumentNumberOri());
		rcdDO.setOrder_no(prepayInfo.getOrderNumberOri());
		rcdDO.setFg_success(FBoolean.FALSE);
		rcdDO.setId_emp_oper(Context.get().getStuffId());
		rcdDO.setDt_oper(BlFlowContextUtil.getNowTime());
		rcdDO.setInput(xml);
		rcdDO.setStatus(DOStatus.NEW);
		
		return rcdDO;
	}
	
	@Override
	protected void checkParam(WsParamPrepay param) throws BizException {
		
		WsParamPrepayRefundValidator validator = new WsParamPrepayRefundValidator();
		validator.validate(param);
		
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		//设置人员上下文
		PsnDocDO psndocDO = super.getPsnInfo(prepayInfo.getOperaCode());
		if (psndocDO == null) {
			throw new BizException("门诊预交金退充值:未查询到人员信息");
		}
		Context.get().setStuffId(psndocDO.getId_psndoc());
		Context.get().setDeptId(psndocDO.getId_dep());
	}
	
	@Override
	protected WsResultPrepay doWork(WsParamPrepay param) throws BizException {
		
		WsParamPrepayInfo prepayInfo = param.getPrepay();
		
		//查询患者信息
		this.patId = this.findPat(prepayInfo);
		
		//获取原充值记录
		this.oriPrepayDO = this.getOriPrepay(this.patId, prepayInfo);
		
		if(FBoolean.TRUE.equals(this.oriPrepayDO.getFg_canc())){
			throw new BizException("门诊预交金退充值:原充值记录已经取消");
		}
		
		if(FBoolean.TRUE.equals(this.oriPrepayDO.getFg_rep_return())){
			throw new BizException("门诊预交金退充值:原充值记录已经退费");
		}
		
		if(!prepayInfo.getPaymentMethod().equals(this.oriPrepayDO.getSd_pm())){
			throw new BizException("门诊预交金退充值:支付方式同原支付方式不同");
		}
		
		//查询账户
		IAccountMDORService accService = ServiceFinder.find(IAccountMDORService.class);
		PiPatAccDO[] accDos = accService.findByAttrValString(PiPatAccDO.ID_PAT, this.patId);
		if(ArrayUtil.isEmpty(accDos)){
			throw new BizException("门诊预交金退充值:未查到患者账户");
		}
		PiPatAccDO accDO = accDos[0];
		
		FDouble refundAmt = BlAmtConverUtil.toFDouble(prepayInfo.getPayMoney());
		FDouble accRemain = accDO.getPrepay().sub(accDO.getAcc_lock());
		if(refundAmt.compareTo(accRemain) > 0){
			throw new BizException("门诊预交金退充值:账户余额不足，无法退费。余额:" + accRemain.toString());
		}
		
		FDouble refundCheck = refundAmt.add(this.oriPrepayDO.getAmt_ret() == null ? FDouble.ZERO_DBL : this.oriPrepayDO.getAmt_ret());
		if(refundCheck.compareTo(this.oriPrepayDO.getAmt()) > 0){
			throw new BizException("门诊预交金退充值:总退费金额大于该笔充值金额，无法退费");
		}
		
		//退充值
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		
		BlPrepayRDTO prepayDto = new BlPrepayRDTO();
		prepayDto.setId_pat(this.patId);
		prepayDto.setAmt(refundAmt);
		prepayDto.setSd_pttp(prepayInfo.getTerminalType());
		PriPmDO pmDO = super.getPmByCode(prepayInfo.getPaymentMethod());
		if(pmDO != null){
			prepayDto.setId_pm(pmDO.getId_pm());
		}
		prepayDto.setSd_pm(prepayInfo.getPaymentMethod());
		prepayDto.setBankno(prepayInfo.getDocumentNumber());
		prepayDto.setPaymodenode(prepayInfo.getOrderNumber());
		prepayDto.setId_emp_pay(Context.get().getStuffId());
		prepayDto.setEu_direct(-1);
		if(refundAmt.compareTo(this.oriPrepayDO.getAmt()) == 0){
			prepayDto.setIshalfrefund(FBoolean.FALSE);
		}else{
			prepayDto.setIshalfrefund(FBoolean.TRUE);
		}
		prepayDto.setId_prepay_old(this.oriPrepayDO.getId_paypat());
		
		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_print(FBoolean.FALSE);
		setDto.setFg_accupdate(FBoolean.TRUE);
		setDto.setFg_checkacc(FBoolean.TRUE);

		BlPrePayPatDO prepayDO = prepayService.refund(prepayDto, setDto);
		
		WsResultPrepay rlt = new WsResultPrepay();
		WsResultMsg rltMsg = new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		
		accDos = accService.findByAttrValString(PiPatAccDO.ID_PAT, this.patId);
		accDO = accDos[0];
		
		WsResultInfoPrepay rltInfo = new WsResultInfoPrepay();
		rltInfo.setBalance(BlAmtConverUtil.toXmlString(accDO.getPrepay().sub(accDO.getAcc_lock())));
		
		rlt.setRltMsg(rltMsg);
		rlt.setRltInfo(rltInfo);
		
		String output = rlt.serialize();
		this.writebackTransSuccess(prepayDO, output);
		
		return rlt;
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
		this.transRcdDO.setId_pay(prepayDO.getId_paypat());
		this.transRcdDO.setId_pm(prepayDO.getId_pm());
		this.transRcdDO.setOutput(output);
	}
	
	/**
	 * 查询患者
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamPrepayInfo prepayInfo)throws BizException {
	
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(prepayInfo.getPatCode());
		condDto.setId_code(prepayInfo.getSdCode());
		condDto.setCard_code(prepayInfo.getCardCode());
		
		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if(ArrayUtil.isEmpty(patiAggs)){
			throw new BizException("门诊退预交金充值:未查询到患者信息");
		}
		
		return patiAggs[0].getParentDO().getId_pat();
	}

	/**
	 * 获取原交易数据
	 * @param patId
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlPrePayPatDO getOriPrepay(String patId, WsParamPrepayInfo prepayInfo) throws BizException{
		
		String sql = "select * from bl_prepay_pat where id_pat = ? and paymodenode = ? and eu_direct = 1";
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(prepayInfo.getOrderNumberOri());
		
		List<BlPrePayPatDO> prepayList = (List<BlPrePayPatDO>)daf.execQuery(sql, param, new BeanListHandler(BlPrePayPatDO.class));
		if(ListUtil.isEmpty(prepayList)){
			throw new BizException("门诊预交金退充值:为查询到原订单交易。订单号:" + prepayInfo.getOrderNumberOri());
		}
		
		if(prepayList.size() > 1){
			throw new BizException("门诊预交金退充值:查询到原充值数据有多条。订单号:" + prepayInfo.getOrderNumberOri());
		}
		
		return prepayList.get(0);
	}

	@Override
	protected String getBusiness() {
		return "门诊预交金退充值";
	}
}
