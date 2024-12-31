package iih.en.pv.s.bp.op.st;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLCiOrderToBlCgService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.RelSrvDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 划价
 * 
 * @author yank
 */
public class PricingBP {
	/**
	 * 划价
	 * 
	 * @param regInfo 挂号信息
	 * @param fgAcc 只记账标志
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */
	public RegInfoDTO exec(RegInfoDTO regInfo, FBoolean fgAcc, FBoolean fgPrint)
			throws BizException {
		// 1、验证参数
		this.validateParam(regInfo, fgAcc);

		// 2、 划价
		// 是否打印发票号,前端根据场景进行设定
		// FBoolean fgPrint = FBoolean.FALSE;
		// if (!FBoolean.TRUE.equals(fgAcc)) {
		// fgPrint = new FBoolean(EnParamUtils.isPrintInvoice());//
		// 如果不是后付费模式，则从参数中获取
		// }
		BlCgOepAggDTO cgOepAggDTO = this.pricingByBl(regInfo, fgAcc, fgPrint);

		// 3、验证划价结果
		this.validatePricedInfo(cgOepAggDTO);

		// 4、更新挂号信息
		// 4.1 划价信息需要传递给前端，结算需要
		BlcgoepAggDO oepAggDO = (BlcgoepAggDO) cgOepAggDTO.getBlcgoepAggDO().get(0);
		regInfo.setPricedinfo(EnAppUtils.aggDoArray2List(oepAggDO));
		// 4.2 根据划价结果更新资源信息
		RegResDTO resDTO = (RegResDTO) regInfo.getRegresarray().get(0);
		this.updateResByPricedInfo(resDTO, oepAggDO.getBlCgItmOepDO());
		return regInfo;
	}

	/**
	 * 验证参数
	 * 
	 * @param regInfo 挂号信息
	 * @param fgAcc 记账标志
	 * @throws BizException
	 */
	private void validateParam(RegInfoDTO regInfo, FBoolean fgAcc) throws BizException {
		EnValidator.validateParam("挂号信息", regInfo);
		if (regInfo.getRegresarray() == null || regInfo.getRegresarray().size() <= 0) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_REGINFO_HAS_NO_RES);
		}
	}

	/**
	 * 费用划价
	 * 
	 * @param regInfo 挂号信息
	 * @param fgAcc 记账标识
	 * @param fgPrint 是否打印发票
	 * @return
	 * @throws BizException
	 */
	private BlCgOepAggDTO pricingByBl(RegInfoDTO regInfo, FBoolean fgAcc, FBoolean fgPrint)
			throws BizException {
		PatiVisitDO pvDO = constructPvDO(regInfo);

		// 1、构造结算明细
		GetBalanceDetailBP getBlDetailBP = new GetBalanceDetailBP();
		ArrayList<BlOrderAppendBillParamDTO> balanceDetail = getBlDetailBP.exec(regInfo, pvDO,
				fgAcc);
		List<BlOrderAppendBillParamDTO> blList = new ArrayList<BlOrderAppendBillParamDTO>();
		blList.addAll(balanceDetail);
		BlOrderAppendBillParamDTO[] billArray = blList.toArray(new BlOrderAppendBillParamDTO[blList
				.size()]);

		// 2、构造操作员信息
		ConstructOprBP constructBP = new ConstructOprBP();
		OperatorInfoDTO oprDTO = constructBP.exec();

		// 3、划价
		IBLCiOrderToBlCgService blcgservice = ServiceFinder.find(IBLCiOrderToBlCgService.class);
		BlCgOepAggDTO oepAggDTO = blcgservice.SetCiOrderToPrice(billArray, oprDTO, fgPrint);

		return oepAggDTO;
	}

	/**
	 * 构造就诊DO
	 * 
	 * @param regInfo 挂号信息
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO constructPvDO(RegInfoDTO regInfo) throws BizException {
		PatiVisitDO pvDO = new PatiVisitDO();
		pvDO.setId_pat(regInfo.getId_pat());
		pvDO.setStatus(DOStatus.NEW);
		pvDO.setId_grp(EnContextUtils.getGrpId());// 集团
		pvDO.setId_org(EnContextUtils.getOrgId()); // 机构
		// 挂号资源
		RegResDTO resDTO = (RegResDTO) regInfo.getRegresarray().get(0);
		pvDO.setId_dep_phy(resDTO.getId_dep());// 挂号科室
		if (!EnValidator.isEmpty(regInfo.getCode_entp())) {
			pvDO.setCode_entp(regInfo.getCode_entp());
			pvDO.setId_entp(new PvEP().getEntpId(regInfo.getCode_entp()));
		} else {
			// 默认就诊类型为门诊
			pvDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);// 就诊类型
			pvDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// 就诊类型
		}
		pvDO.setDes("");
		pvDO.setDt_entry(EnAppUtils.getServerDateTime());
		pvDO.setId_emp_entry(EnContextUtils.getPsnId());
		pvDO.setId_pripat(regInfo.getId_pripat());// 患者价格分类
		pvDO.setId_hp(regInfo.getId_hp());// 医保计划
		return pvDO;
	}

	/**
	 * 验证划价信息
	 * 
	 * @param cgOepAggDTO
	 * @return
	 * @throws BizException
	 */
	private void validatePricedInfo(BlCgOepAggDTO cgOepAggDTO) throws BizException {
		if (cgOepAggDTO == null || cgOepAggDTO.getBlcgoepAggDO() == null
				&& cgOepAggDTO.getBlcgoepAggDO().size() == 0) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_PRICING_BL_FAILED);
		}
		BlcgoepAggDO oepAggDO = (BlcgoepAggDO) cgOepAggDTO.getBlcgoepAggDO().get(0);
		if (oepAggDO == null || EnValidator.isEmpty(oepAggDO.getBlCgItmOepDO())) {
			throw new BizException(IEnMsgConst.ERROR_OP_REG_PRICING_BL_FAILED);
		}
	}

	/**
	 * 根据划价结果更新资源信息
	 * 
	 * @param resDTO 挂号资源
	 * @param cgItms 划价结果信息
	 * @throws BizException
	 */
	private void updateResByPricedInfo(RegResDTO resDTO, BlCgItmOepDO[] cgItms) throws BizException {
		resDTO.setAmt_st(FDouble.ZERO_DBL);
		resDTO.setAmt_hp(FDouble.ZERO_DBL);
		resDTO.setAmt_pat(FDouble.ZERO_DBL);
		resDTO.setAmt(FDouble.ZERO_DBL);
		if (resDTO.getSrvarray() != null && resDTO.getSrvarray().size() > 0) {
			for (BlCgItmOepDO cgItem : cgItms) {
				for (int i = 0; i < resDTO.getSrvarray().size(); i++) {
					RelSrvDTO srvDTO = (RelSrvDTO) resDTO.getSrvarray().get(i);
					if (srvDTO.getId_srv().equals(cgItem.getId_srv())) {
						srvDTO.setAmt_st(cgItem.getAmt_std());
						srvDTO.setAmt_hp(cgItem.getAmt_hp());
						srvDTO.setAmt_pat(cgItem.getAmt_pat());
						srvDTO.setAmt(cgItem.getAmt());
						// 更新挂号资源价格
						resDTO.setAmt_st(resDTO.getAmt_st().add(srvDTO.getAmt_st()));
						resDTO.setAmt_hp(resDTO.getAmt_hp().add(srvDTO.getAmt_hp()));
						resDTO.setAmt_pat(resDTO.getAmt_pat().add(srvDTO.getAmt_pat()));
						resDTO.setAmt(resDTO.getAmt().add(srvDTO.getAmt()));
						break;
					}
				}
			}
		}
	}

}
