package iih.ei.std.s.v1.bp.en;

import com.mysql.jdbc.StringUtils;

import iih.ei.std.d.v1.en.makeaptandpay.d.MakeAptAndPayParamDTO;
import iih.ei.std.d.v1.en.makeaptandpay.d.MakeAptAndPayResultDTO;
import iih.ei.std.d.v1.en.payforapt.d.PayForAptParamDTO;
import iih.ei.std.d.v1.en.payforapt.d.PayForAptResultDTO;
import iih.ei.std.d.v1.en.regpricing.d.RegPricingParamDTO;
import iih.ei.std.d.v1.en.regpricing.d.RegPricingResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.AptExChlDO;
import iih.sc.apt.scapt.i.IAptexchlRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/***
 * 预约并划价付费
 * @author fanlq
 * @date: 2019年10月14日 下午1:31:44
 */
public class MakeAptAndPayBP  extends IIHServiceBaseBP<MakeAptAndPayParamDTO, MakeAptAndPayResultDTO> {

	@Override
	protected void checkParam(MakeAptAndPayParamDTO param) throws BizException {
		//1.校验必填项
		this.voledateNotNullParam(param);
		//2.校验是否存在重复预约码
		this.volidateAptCode(param.getCode_exapt());
	}

	@Override
	protected MakeAptAndPayResultDTO process(MakeAptAndPayParamDTO param) throws BizException {
		//1.预约
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		RegResultDTO regResult =  serv.aptForWechatNew(this.assemly(param));
		//2.划价
		RegPricingParamDTO pricingParam = this.wrapPricingParam(param);
		RegPricingResultDTO pricingResult = new RegPricingBP().process(pricingParam);
		//2.付费
		PayForAptParamDTO payParam = this.wrapPayParam(param, regResult, pricingResult);
		PayForAptResultDTO payResult = new PayForAptBP().process(payParam);
		return wrapResult(regResult,payResult);
	}

	/***
	 * @Description:校验必填项
	 * @param param
	 * @throws BizException 
	 */
	private void voledateNotNullParam(MakeAptAndPayParamDTO param) throws BizException{
		if(StringUtils.isNullOrEmpty(param.getCode_pat()))
			throw new BizException("患者编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_exapt()))
			throw new BizException("外部预约码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_chltp()))
			throw new BizException("渠道编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getId_sch()))
			throw new BizException("预约排班不能为空！");
		if (StringUtils.isNullOrEmpty(param.getCode_paytp()))
			throw new BizException("支付方式不能为空！");
		if (StringUtils.isNullOrEmpty(param.getMoney_pay()))
			throw new BizException("支付金额不能为空！");
		if (StringUtils.isNullOrEmpty(param.getCode_opr()))
			throw new BizException("操作员编码不能为空！");
		if(StringUtils.isNullOrEmpty(param.getCode_scsrv()))
			throw new BizException("排班服务编码不能为空！");
	}

	/**
	 * 验证是否存在重复预约码
	 * 
	 * @param aptCode
	 * @throws BizException 
	 */
	private void volidateAptCode(String aptCode) throws BizException{
		IAptexchlRService serv = ServiceFinder.find(IAptexchlRService.class);
		AptExChlDO[] aptExs = serv.findByAttrValString(AptExChlDO.CODE_APT, aptCode);
		if(aptExs != null && aptExs.length > 0)
			throw new BizException("已经存在该预约码！");
	}
	/**
	 * 组装预约入参MakeAptDTO
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private MakeAptDTO assemly(MakeAptAndPayParamDTO param) throws BizException {
		MakeAptDTO makeAptDTO = new MakeAptDTO();
		makeAptDTO.setPatCode(param.getCode_pat());
		makeAptDTO.setAptCode(param.getCode_exapt());
		makeAptDTO.setChlType(param.getCode_chltp());
		makeAptDTO.setAgentCode(param.getCode_agentpat());
		makeAptDTO.setSchId(param.getId_sch());
		makeAptDTO.setOprCode(param.getCode_opr());
		makeAptDTO.setTransFlag(param.getFg_trans());
		makeAptDTO.setTickCode(param.getCode_ticket());
		return makeAptDTO;
	}
	/**
	 * 组装返回值
	 * 
	 * @param aptResult
	 * @return
	 */
	private MakeAptAndPayResultDTO wrapResult(RegResultDTO aptResult,PayForAptResultDTO payResult){
		MakeAptAndPayResultDTO data = new MakeAptAndPayResultDTO();
		data.setId_apt(aptResult.getId_apt());
		data.setCode_ticket(aptResult.getSequenceNumber());
		data.setTimes_op(aptResult.getTimes());
		data.setSugest_exmint(aptResult.getSuggestExmint() == null ? null:aptResult.getSuggestExmint().toString());
		data.setOp_place(aptResult.getPlaceOfVisit());
		data.setD_entry(aptResult.getEntDate());
		data.setTime_ent(aptResult.getVisitingTime());
		data.setId_stoep(payResult.getId_stoep());
		data.setCode_st(payResult.getCode_st());
		data.setDt_st(payResult.getDt_st());
		return data;
	}
	/***
	 * @Description:组装划价入参
	 * @param param
	 * @return
	 */
	private RegPricingParamDTO wrapPricingParam(MakeAptAndPayParamDTO param){
		RegPricingParamDTO pricingParam = new RegPricingParamDTO();
		pricingParam.setCode_pat(param.getCode_pat());
		pricingParam.setCode_scsrv(param.getCode_scsrv());
		pricingParam.setCode_hp(param.getCode_hp());
		pricingParam.setCode_dep_oper(param.getCode_dep_oper());
		pricingParam.setCode_opr(param.getCode_opr());
		return pricingParam;
	}
	/***
	 * @Description:组装付费入参
	 * @param param
	 * @return
	 */
	private PayForAptParamDTO wrapPayParam(MakeAptAndPayParamDTO param,RegResultDTO regResult,RegPricingResultDTO pricingResult) throws BizException{
		//验证划价金额和入参的输入金额
		if(new FDouble(pricingResult.getAmt_ticket()).compareTo(new FDouble(param.getMoney_pay())) == 1 ){
			throw new BizException(String.format("支付金额不足，应支付%.2f，实际支付%.2f", new FDouble(pricingResult.getAmt_ticket()).toDouble(),new FDouble(param.getMoney_pay()).toDouble()));
		}
		PayForAptParamDTO payParam = new PayForAptParamDTO();
		payParam.setId_apt(regResult.getId_apt());
		payParam.setCode_pat(param.getCode_pat());
		payParam.setCode_chltp(param.getCode_chltp());
		payParam.setPaymodenode(param.getPaymodenode());
		payParam.setBankno(param.getBankno());
		payParam.setCode_paytp(param.getCode_paytp());
		payParam.setMoney_pay(pricingResult.getAmt_ticket());
		payParam.setCode_opr(param.getCode_opr());
		payParam.setDt_st(regResult.getDt_st());
		payParam.setId_stoep(pricingResult.getId_stoep());
		payParam.setCode_hp(param.getCode_hp());
		payParam.setFg_takeaptno(param.getFg_takeaptno());
		payParam.setHpinfo(param.getHpinfo());
		return payParam;
	}
	
}
