package iih.ei.std.s.v1.bp.bl;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.ei.std.d.v1.bl.opaccountinfo.d.OpAccountInfoParamDTO;
import iih.ei.std.d.v1.bl.opaccountinfo.d.OpAccountInfoResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
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

/***
 * 门诊账户信息查询
 * 
 * @author shaokx
 * @date: 2019.09.29
 */
public class GetOpAccountInfoBP extends IIHServiceBaseBP<OpAccountInfoParamDTO, OpAccountInfoResultDTO>{

	@Override
	protected void checkParam(OpAccountInfoParamDTO param) throws BizException {
		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("入参就诊类型为空");
		}

		if (!IBlWsConst.ENTP_OP.equals(param.getCode_enttp())) {
			throw new BizException("就诊类型值不正确");
		}

		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum())) {
			throw new BizException("门诊账户信息查询入参关键信息全为空:患者编码,就诊卡号,身份证号");
		}
		
	}

	@Override
	protected OpAccountInfoResultDTO process(OpAccountInfoParamDTO param) throws BizException {

		// 查询患者信息
		PatDO patInfo = this.findPat(param);

		// 查询患者账户信息
		IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO accInfo = accService.GetPatRelAmountInfo(patInfo.getId_pat());

		String cardStatus="";
		//查询卡信息
		if(!StringUtil.isEmpty(param.getCode_card())){
			IPiPatCardDORService cardRService=ServiceFinder.find(IPiPatCardDORService.class);
			PiPatCardDO[] cardDDArr=cardRService.find("code= '"+param.getCode_card()+"'", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(cardDDArr)){
				for (int i = 0; i < cardDDArr.length; i++) {
					if(StringUtil.isEmpty(cardDDArr[i].getEu_cardsu().toString())){
						cardStatus=cardDDArr[i].getEu_cardsu().toString();
						break;
					}
				}
			}
		}
		
		// 组织返回值
		OpAccountInfoResultDTO rlt1 = new OpAccountInfoResultDTO();
		rlt1.setCode_pat(patInfo.getCode());
		rlt1.setName_pat(patInfo.getName());
		rlt1.setSex_pat(patInfo.getSd_sex());
		rlt1.setDt_birth(patInfo.getDt_birth().toString());
		rlt1.setCode_idnum(patInfo.getId_code());
		rlt1.setStatus_card(cardStatus);
			String amtStr=BlAmtConverUtil.toXmlString(accInfo.getPrepay());
			rlt1.setAmt_balance(amtStr);

		return rlt1;
	}
	
	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private PatDO findPat(OpAccountInfoParamDTO param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());
		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("门诊预交金查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO();
	}

}
