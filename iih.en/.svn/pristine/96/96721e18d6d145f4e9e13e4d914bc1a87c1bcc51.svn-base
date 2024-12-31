package iih.en.pv.s.bp.op.st;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;

import java.util.Iterator;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 加载资源的结算价格
 * 
 * @author yank
 */
public class LoadResPriceFromCgBP {
	/**
	 * 加载资源的结算价格
	 * 
	 * @param resDTO 挂号资源
	 * @param cgId 结算id
	 * @return
	 * @throws BizException
	 */
	public RegResDTO exec(RegResDTO resDTO, String cgId) throws BizException {
		if (resDTO == null || EnValidator.isEmpty(cgId)) {
			return resDTO;
		}

		// 1、加载标准金额，结算中无法得到医保分摊结果，只能从支付明细获取
		this.loadSrvCgDetail(resDTO, cgId);

		// 2、加载支付明细
		this.loadPayDetail(resDTO, cgId);

		return resDTO;
	}

	/**
	 * 根据结算信息加载标准价格和服务明细
	 * 
	 * @param resDTO 挂号资源
	 * @param cgId 结算id
	 * @throws BizException
	 */
	private void loadSrvCgDetail(RegResDTO resDTO, String cgId) throws BizException {
		resDTO.setAmt_st(FDouble.ZERO_DBL);// 标准金额
		IBlCgItmOepDORService blCgItmService = ServiceFinder.find(IBlCgItmOepDORService.class);
		String whereStr = String.format("ID_CGOEP='%s'", cgId);
		BlCgItmOepDO[] cgItms = blCgItmService.find(whereStr, null, FBoolean.TRUE);
		for (BlCgItmOepDO cgItm : cgItms) {
			resDTO.setAmt_st(resDTO.getAmt_st().add(cgItm.getAmt_std()));// 标准金额
			//resDTO.setDiagfee(resDTO.getAmt_st());
			if(resDTO.getSrvarray() != null){
				Iterator<RelSrvDTO> iteractor = resDTO.getSrvarray().iterator();
				while (iteractor.hasNext()){
					RelSrvDTO srvDTO = iteractor.next();
					if (srvDTO == null){
						continue;
					}
					if (srvDTO.getId_srv().equals(cgItm.getId_srv())){
						srvDTO.setAmt_st(cgItm.getAmt_std());// 标准金额
					}
				}
			}else{
				resDTO.setDiagfee(resDTO.getAmt_st());
			}
		}
	}

	/**
	 * 加载支付明细
	 * 
	 * @param resDTO 资源
	 * @param cgId 结算ID
	 * @throws BizException
	 */
	private void loadPayDetail(RegResDTO resDTO, String cgId) throws BizException {
		// 设置默认值
		resDTO.setAmt_hp(FDouble.ZERO_DBL);// 医保基金
		resDTO.setAmt_insuracc(FDouble.ZERO_DBL);// 医保个人账户
		resDTO.setAmt_pat(FDouble.ZERO_DBL);// 此字段只是医保分解时临时赋值，不需要
		resDTO.setAmt(FDouble.ZERO_DBL);// 支付金额
		resDTO.setAmt_orig(FDouble.ZERO_DBL);//已支付金额
		resDTO.setAmt_hpcmcl(FDouble.ZERO_DBL);//高端商保

		IBlPayOutQryService payQryService = ServiceFinder.find(IBlPayOutQryService.class);
		BlPayPmDTO[] payPmDTOs = payQryService.getOpRegPayDetailBP(cgId);
		if (EnValidator.isEmpty(payPmDTOs)) {
//			throw new BizException(IEnMsgConst.ERROR_OP_REG_GET_PAYSTYLE);
		} else {
			FArrayList payList = new FArrayList();
			for (BlPayPmDTO payPm : payPmDTOs) {
				FDouble amt = payPm.getAmt();
				if (IBlDictCodeConst.SD_DIRECT_REFUND.equals(payPm.getPm_eu_direct().toString())) {
					amt = amt.multiply(-1);// 如果退费，则取反
				}

				if (IBdPripmCodeConst.CODE_PRI_PM_INSUR.equals(payPm.getSd_pm())) {
					resDTO.setAmt_hp(resDTO.getAmt_hp().add(amt));// 医保基金
				} else if (IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT.equals(payPm.getSd_pm())) {
					resDTO.setAmt_insuracc(resDTO.getAmt_insuracc().add(amt));// 医保个人账户
				} else if(IBdPripmCodeConst.CODE_PRI_PM_BUSINESS.equals(payPm.getSd_pm())){
					resDTO.setAmt_hpcmcl(resDTO.getAmt_hpcmcl().add(amt));//高端商保 
					resDTO.setId_hpcmcl(payPm.getId_cust());//支付客户id
					resDTO.setName_hpcmcl(payPm.getId_cust_name());//支付客户
				}else {
					resDTO.setAmt_pat(resDTO.getAmt_pat().add(amt));// 个人承担
					// 挂号除医保、医保个人账户外，只支持一种支付方式，只处理收费部分
					if (IBlDictCodeConst.SD_DIRECT_CHARGE.equals(payPm.getPm_eu_direct().toString())) {
						//支付方式为空，或者支付金额大于0
						if (EnValidator.isEmpty(resDTO.getId_pm()) || FDoubleUtils.isMoreThanZero(payPm.getAmt())) {
							resDTO.setId_pm(payPm.getId_pm());// 付款方式id
							resDTO.setSd_pm(payPm.getSd_pm());// 付款方式编码
							resDTO.setName_pm(payPm.getName());// 付款方式名称
							resDTO.setPaycred(payPm.getPaymodenode());// 支付凭证
						}
					}
				}
				resDTO.setAmt(resDTO.getAmt().add(amt));// 支付合计
				resDTO.setAmt_orig(resDTO.getAmt());//已支付金额
				payList.add(payPm);
			}
			resDTO.setDetails_pay(payList);
		}
	}
}
