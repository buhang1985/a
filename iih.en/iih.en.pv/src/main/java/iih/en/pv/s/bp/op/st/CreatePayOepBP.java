package iih.en.pv.s.bp.op.st;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.PayInfoDTO;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.sc.sch.reg.dto.d.RegResDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 创建患者收款信息
 * 
 * @author yank
 * @since 2015-12-08
 *
 */
public class CreatePayOepBP {
	/**
	 * 创建患者收款信息 (此方法用于医保支付时的个人医保账户支付的情况，并且会产生个人账户的支付明细信息)
	 * 
	 * @param patId 患者id
	 * @param payInfoDTO 付款信息
	 * @author regInfo 挂号信息
	 * @return
	 * @throws BizException
	 */
	public BlpaypatoepAggDO exec(String patId, PayInfoDTO payInfoDTO, RegInfoDTO regInfo) throws BizException {
		if (EnValidator.isEmpty(payInfoDTO.getPaystyle())) {
			throw new BizException("支付方式不能为空！");
		}

		// 收付款信息
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
		BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		blPayPatOepDO.setId_grp(EnContextUtils.getGrpId());// 集团
		blPayPatOepDO.setId_org(EnContextUtils.getOrgId());// 组织
		blPayPatOepDO.setSd_pttp(payInfoDTO.getSd_pttp()); // 收付款终端类型编码
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(regInfo.getCode_entp())) {
			// 默认就诊类型为门诊
			blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_ET);// 就诊类型id
			blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_ET);// 就诊类型
		} else {
			// 默认就诊类型为门诊
			blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);// 就诊类型id
			blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// 就诊类型
		}
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);// 支付类型--结算
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);// 支付类型--结算编码
		blPayPatOepDO.setId_pat(patId);// 患者id
		blPayPatOepDO.setEu_direct(PayDirectEnum.CHARGE);// 收款
		blPayPatOepDO.setAmt(payInfoDTO.getAmt());// 付款合计
		blPayPatOepDO.setId_org_pay(EnContextUtils.getOrgId());// 支付组织
		blPayPatOepDO.setId_dep_pay(EnContextUtils.getDeptId());// 支付部门
		blPayPatOepDO.setId_emp_pay(EnContextUtils.getPsnId());// 操作员
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		if(!EnValidator.isEmpty(payInfoDTO.getDt_st())){
			blPayPatOepDO.setDt_pay(new FDateTime(payInfoDTO.getDt_st()));//交易时间
		}
		blPayPatOepDO.setStatus(DOStatus.NEW);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);

		//如果实际支付为空，则需个人应付
		if(payInfoDTO.getRelpay()==null){
			payInfoDTO.setRelpay(payInfoDTO.getAmt_pat());
		}
		
		List<BlPayItmPatOepDO> payItmList = new ArrayList<BlPayItmPatOepDO>();
		// 将之前支付明细加入到当前支付明细中
		if (isRefundOrSupplement(payInfoDTO)) {
			this.addOrigPayItmList(regInfo, payItmList);
		}
		// 1、医保支付
		if (FDoubleUtils.isMoreThanZero(payInfoDTO.getAmt_hp())) {
			// 基金账户支付大于0，需要增加对应明细记录
			BlPayItmPatOepDO insurPayItm = this.createPayItmDO(IBdPripmCodeConst.ID_PRI_PM_INSUR,
					IBdPripmCodeConst.CODE_PRI_PM_INSUR, payInfoDTO.getAmt_hp(), IBlDictCodeConst.SD_DIRECT_CHARGE,
					null, null, null, null, FBoolean.TRUE);
			payItmList.add(insurPayItm);
		}
		// 2、医保个人账户
		if (FDoubleUtils.isMoreThanZero(payInfoDTO.getAmt_ct())) {
			// 个人医保账户支付大于0，需要增加对应明细记录
			BlPayItmPatOepDO insActPayItm = this.createPayItmDO(IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT,
					IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT, payInfoDTO.getAmt_ct(),
					IBlDictCodeConst.SD_DIRECT_CHARGE, null, null, null, null, FBoolean.TRUE);
			payItmList.add(insActPayItm);
		}

		// 3、高端商业保险
		if (FBoolean.TRUE.equals(payInfoDTO.getFg_highhpcmcl())) {
			BlPayItmPatOepDO insActPayItm = this.createPayItmDO(IBdPripmCodeConst.ID_PRI_PM_BUSINESS,
					IBdPripmCodeConst.CODE_PRI_PM_BUSINESS, payInfoDTO.getAmt_hpcmcl(),
					IBlDictCodeConst.SD_DIRECT_CHARGE, null, null, payInfoDTO.getId_hpcmcl(), null, FBoolean.TRUE);
			payItmList.add(insActPayItm);
		}
		
		// 4、除个人账户、高端商保外的另外一种支付方式
		if (!IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT.equals(payInfoDTO.getPaystyle())
				&& !IBdPripmCodeConst.CODE_PRI_PM_BUSINESS.equals(payInfoDTO.getPaystyle())) {
			// 支付金额，其他，如：预交金、现金、支付宝、微信、 内部转账等

			if(EnValidator.isEmpty(payInfoDTO.getId_patstyle())){
				String pmId = this.getPmId(payInfoDTO.getPaystyle());
				payInfoDTO.setId_patstyle(pmId);
			}
			//如果支付金额为0，且原支付方式不为空，则不记入明细
			if(!(FDoubleUtils.isNullOrZero(payInfoDTO.getRelpay()) && !EnValidator.isEmpty(payInfoDTO.getPaystyle_originstyle()))){
				BlPayItmPatOepDO payItm = this.createPayItmDO(payInfoDTO.getId_patstyle(), payInfoDTO.getPaystyle(),
						payInfoDTO.getRelpay(), IBlDictCodeConst.SD_DIRECT_CHARGE, payInfoDTO.getId_bank(),
						payInfoDTO.getNo_bank(), payInfoDTO.getId_cust(), payInfoDTO.getPaycred(), FBoolean.TRUE);
				//设置订单号和交易号，fanlq-2019-04-29
				if(EnValidator.isEmpty(payInfoDTO.getNo_bank())){
					payItm.setBankno(payInfoDTO.getBusiness_code());
				}else{
					payItm.setBankno(payInfoDTO.getNo_bank());
				}
				payItmList.add(payItm);
			}

			// 找零，是否可找零是在付款方式中设置
			if (FDoubleUtils.isNotNullOrZero(payInfoDTO.getChange())) {
				BlPayItmPatOepDO chargePayItm = this.createPayItmDO(payInfoDTO.getId_patstyle(),
						payInfoDTO.getPaystyle(), payInfoDTO.getChange(), IBlDictCodeConst.SD_DIRECT_REFUND,
						payInfoDTO.getId_bank(), payInfoDTO.getNo_bank(), payInfoDTO.getId_cust(),
						payInfoDTO.getPaycred(), FBoolean.TRUE);
				//设置订单号和交易号，fanlq-2019-04-29
				if(EnValidator.isEmpty(payInfoDTO.getNo_bank())){
					chargePayItm.setBankno(payInfoDTO.getBusiness_code());
				}else{
					chargePayItm.setBankno(payInfoDTO.getNo_bank());
				}
				payItmList.add(chargePayItm);
			}
		}

		blpaypatoepAggDO.setBlPayItmPatOepDO(payItmList.toArray(new BlPayItmPatOepDO[0]));
		return blpaypatoepAggDO;
	}

	/**
	 * 创建付款明细DO
	 * 
	 * @param pmId 付款方式ID
	 * @param pmCode 付款方式编码
	 * @param amt 金额
	 * @param direct 支付方向
	 * @param bankId 银行ID
	 * @param bankNo 银行账号
	 * @param custId 支付客户
	 * @param payRemark 支付凭证
	 * @return
	 */
	private BlPayItmPatOepDO createPayItmDO(String pmId, String pmCode, FDouble amt, String direct, String bankId,
			String bankNo, String custId, String payRemark, FBoolean isRealPay) {
		BlPayItmPatOepDO payItmDO = new BlPayItmPatOepDO();
		payItmDO.setEu_direct(Integer.parseInt(direct));
		payItmDO.setAmt(amt == null ? FDouble.ZERO_DBL : amt);
		payItmDO.setSd_pm(pmCode);// 支付方式编码
		payItmDO.setId_pm(pmId);// 支付方式ID
		payItmDO.setId_bank(bankId);// 银行
		payItmDO.setBankno(bankNo);// 账号，含微信、支付宝
		payItmDO.setId_cust(custId);// 支付客户
		payItmDO.setPaymodenode(payRemark);// 支付凭证，付款方备注，订单号
		payItmDO.setFg_realpay(isRealPay);
		payItmDO.setId_grp(EnContextUtils.getGrpId());
		payItmDO.setId_org(EnContextUtils.getOrgId());
		payItmDO.setStatus(DOStatus.NEW);
		return payItmDO;
	}

	/**
	 * 获得对应的支付方式
	 * 
	 * @param pmCode 支付方式代码
	 * @return 支付方式名称
	 */
	private String getPmId(String pmCode) {
		String payId = null;
		switch (pmCode) {
		case IBdPripmCodeConst.CODE_PRI_PM_CASH:
			payId = IBdPripmCodeConst.ID_PRI_PM_CASH;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_CREDIT:
			payId = IBdPripmCodeConst.ID_PRI_PM_CREDIT;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_CHECK:
			payId = IBdPripmCodeConst.ID_PRI_PM_CHECK;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_DEAFT:
			payId = IBdPripmCodeConst.ID_PRI_PM_DEAFT;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_PAY:
			payId = IBdPripmCodeConst.ID_PRI_PM_PAY;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_COUPON:
			payId=IBdPripmCodeConst.ID_PRI_PM_COUPON;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_SPECIALFUNDS:
			payId = IBdPripmCodeConst.ID_PRI_PM_SPECIALFUNDS;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_MISPOS:
			payId = IBdPripmCodeConst.ID_PRI_PM_MISPOS;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_COMPANY:
			payId = IBdPripmCodeConst.ID_PRI_PM_COMPANY;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_ACCOUNT:
			payId = IBdPripmCodeConst.ID_PRI_PM_ACCOUNT;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_ALIPAY:
			payId = IBdPripmCodeConst.ID_PRI_PM_ALIPAY;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_WECHAT:
			payId = IBdPripmCodeConst.ID_PRI_PM_WECHAT;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT:
			payId = IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_INSUR:
			payId = IBdPripmCodeConst.ID_PRI_PM_INSUR;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION:
			payId = IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION:
			payId = IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION;
			break;
		case IBdPripmCodeConst.CODE_PRI_PM_TRANSFE:
			payId = IBdPripmCodeConst.ID_PRI_PM_TRANSFE;
			break;
		default:
			break;
		}
		return payId;
	}

	/**
	 * 获取支付方式ID
	 * 
	 * @param pmCode 支付方式编码
	 * @return
	 * @throws BizException
	 */
	private String getPmIdFromDb(String pmCode) throws BizException {
		if (!EnValidator.isEmpty(pmCode)) {
			IPripmRService serv = ServiceFinder.find(IPripmRService.class);
			PriPmDO[] prido = serv.findByAttrValString(PriPmDO.CODE, pmCode);
			if (!EnValidator.isEmpty(prido))
				return prido[0].getId_pm();
		}
		throw new BizException("支付方式未定义！");
	}

	/**
	 * 是否补退费
	 * 
	 * 如果之前支付方式不为空，且与当前支付方式相同 或者只是找零(实际支付金额为0)，则认为是补退费
	 * 
	 * @param payInfoDTO
	 * @return
	 * @throws BizException
	 */
	private boolean isRefundOrSupplement(PayInfoDTO payInfoDTO) throws BizException {
		if (!EnValidator.isEmpty(payInfoDTO.getPaystyle_originstyle())) {
			if ((payInfoDTO.getPaystyle_originstyle().equals(payInfoDTO.getPaystyle()) 
					&& !FDoubleUtils.isMoreThanZero(payInfoDTO.getAmt_orig_refund()))
					|| FDoubleUtils.isNullOrZero(payInfoDTO.getRelpay())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 添加原来的支付明细
	 * 
	 * @param regInfoDTO 挂号信息
	 * @param payItmList 支付明细集合
	 * @throws BizException
	 */
	private void addOrigPayItmList(RegInfoDTO regInfoDTO, List<BlPayItmPatOepDO> payItmList) throws BizException {
		RegResDTO resDTO = (RegResDTO) regInfoDTO.getRegresarray().get(0);
		FArrayList payDetails = resDTO.getDetails_pay();
		int size = payDetails == null ? 0 : payDetails.size();
		for (int i = 0; i < size; i++) {
			BlPayPmDTO papDetailDTO = (BlPayPmDTO) payDetails.get(i);
			BlPayItmPatOepDO payItmDO = this.createPayItmDO(papDetailDTO.getId_pm(), papDetailDTO.getSd_pm(),
					papDetailDTO.getAmt(), papDetailDTO.getPm_eu_direct().toString(), papDetailDTO.getId_bank(),
					papDetailDTO.getBankno(), papDetailDTO.getId_cust(), papDetailDTO.getPaymodenode(), FBoolean.FALSE);
			payItmList.add(payItmDO);
		}
	}
}
