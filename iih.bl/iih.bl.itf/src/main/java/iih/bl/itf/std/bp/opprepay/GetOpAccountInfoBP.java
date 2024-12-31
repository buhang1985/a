package iih.bl.itf.std.bp.opprepay;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamAccPatInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultGetOpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultInfoGetOpAcc;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultOpAccount;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamAccountInfoValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊账户查询
 * 
 * @author ly 2018/7/20
 *
 */
public class GetOpAccountInfoBP extends BlItfBaseBP<WsParamGetAccRecord,WsResultGetOpAcc> {

	@Override
	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "门诊账户查询";
	}

	@Override
	protected void checkParam(WsParamGetAccRecord param) throws BizException {
		WsParamAccountInfoValidator validator = new WsParamAccountInfoValidator();
		validator.validate(param);
	}

	@Override
	protected WsResultGetOpAcc doWork(WsParamGetAccRecord param) throws BizException {

		WsParamAccPatInfo paramInfo = param.getPatInfo();

		// 查询患者信息
		PatDO patInfo = this.findPat(paramInfo);

		// 查询患者账户信息
		IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO accInfo = accService.GetPatRelAmountInfo(patInfo.getId_pat());

		String cardStatus="";
		//查询卡信息
		if(!StringUtil.isEmpty(paramInfo.getCardCode())){
			IPiPatCardDORService cardRService=ServiceFinder.find(IPiPatCardDORService.class);
			PiPatCardDO[] cardDDArr=cardRService.find("code= '"+paramInfo.getCardCode()+"'", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(cardDDArr)){
				cardStatus=cardDDArr[0].getEu_cardsu().toString();
			}
		}
		
		// 组织返回值
		WsResultGetOpAcc rlt = new WsResultGetOpAcc();
		
		WsResultMsg rltMsg=new WsResultMsg();
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		
		WsResultInfoGetOpAcc rltInfo = new WsResultInfoGetOpAcc();
		WsResultOpAccount opAcc = new WsResultOpAccount();
		opAcc.setPatCode(patInfo.getCode());
		opAcc.setPatName(patInfo.getName());
		opAcc.setPatSex(patInfo.getSd_sex());
		opAcc.setPatBorthday(patInfo.getDt_birth().toString());
		opAcc.setSdCode(patInfo.getId_code());
		opAcc.setCardStatus(cardStatus);
		if(BlAmtConverUtil.isNumeric(accInfo.getPrepay().toString())){
			String amtStr=BlAmtConverUtil.toXmlString(accInfo.getPrepay());
			opAcc.setBalance(amtStr);
		}
		rltInfo.setAccInfo(opAcc);
		rlt.setRltMsg(rltMsg);
		rlt.setRltInfo(rltInfo);

		return rlt;
	}

	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private PatDO findPat(WsParamAccPatInfo paramInfo) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(paramInfo.getPatCode());
		condDto.setId_code(paramInfo.getSdCode());
		condDto.setCard_code(paramInfo.getCardCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("门诊预交金查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO();
	}
}
