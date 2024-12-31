package iih.ci.ord.s.ems.op.ems.calcpri;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.op.tools.ICalculateTotal;
import iih.ci.ord.i.op.tools.TotalParameterDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class CalculateTotalBP implements ICalculateTotal {

	@Override
	public Integer getTotalTimes(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		// TODO Auto-generated method stub
		GetTotalTimesBP bp = new GetTotalTimesBP();
		return bp.getTotalTimes(totalParameterDTO.getDt_effe(),totalParameterDTO.getId_freq(), totalParameterDTO.getUse_day());
	}

	@Override
	public Integer getDaysAvalidate(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException {
		// TODO Auto-generated method stub
		GetTotalTimesBP bp = new GetTotalTimesBP();
		return bp.getDaysAvalidate(totalParameterDTO.getSd_mupakgu(), totalParameterDTO.getQuen_cur(),
				totalParameterDTO.getQuan_medu(), totalParameterDTO.getFactor(), totalParameterDTO.getFactor_mb(),
				totalParameterDTO.getId_freq());
	}

	@Override
	public FDouble getMMQuantum(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		// TODO Auto-generated method stub
		return CalculateMMTotalQuan(CiEnContext, totalParameterDTO);
	}

	@Override
	public FDouble getUnMMQuantum(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		// TODO Auto-generated method stub
		return UnMMTotalQuan(CiEnContext, totalParameterDTO);
	}

	/**
	 * 非物品计算总量
	 * 
	 * @param id_freq
	 * @param use_day
	 * @param quan_medu
	 *            单次剂量
	 * @return
	 * @throws BizException
	 */
	private FDouble UnMMTotalQuan(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO) throws BizException {
		GetTotalTimesBP bp = new GetTotalTimesBP();
		Integer times = bp.getTotalTimes(totalParameterDTO.getDt_effe(),totalParameterDTO.getId_freq(), totalParameterDTO.getUse_day());
		return (times == null ? new FDouble(0) : new FDouble(times))
				.multiply(totalParameterDTO.getQuan_medu() == null ? new FDouble(0) : totalParameterDTO.getQuan_medu());
	}

	/**
	 * 物品类计算总量(已经知道总次数)
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param fg_pres_outp
	 *            是否出院带药
	 * @param times
	 *            总次数
	 * @param id_mm
	 *            物品id
	 * @param id_unit_sale
	 *            总量单位id
	 * @param quan_medu
	 *            单次剂量
	 * @return
	 * @throws BizException
	 */
	private FDouble CalculateMMTotalQuan(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException {
		MeterialAggDO mmagg = CiOrdAppUtils.getIMeterialRService().findById(totalParameterDTO.getId_mm());
		MeterialDO parentDO = mmagg.getParentDO();
		MMPackageUnitDO[] mmpackageUnits = mmagg.getMMPackageUnitDO();
		// 根据就诊类型获得取整模式
		String sd_mupakgu = this.getSdMupakgu(CiEnContext.getCode_entp(), totalParameterDTO.getFg_pres_outp(),
				parentDO.getSd_mupkgutp(), parentDO.getSd_opmutp());// 取整模式
		// 医基换算系数
		FDouble factor_mb = parentDO.getFactor_mb();
		// 总量单位对基本包装单位的换算系数
		FDouble factor = this.getFactorForUnitBaseToUnitSale(mmpackageUnits, totalParameterDTO.getId_unit_sale());
		return this.getCalculateMMQuantum(sd_mupakgu, totalParameterDTO.getQuan_medu(), factor_mb, factor,
				totalParameterDTO.getTimes());
	}

	/**
	 * 获得物品的取整模式
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param fg_pres_outp
	 *            是否出院带药
	 * @param sd_ipmutp
	 *            门诊取整模式
	 * @param sd_opmutp
	 *            住院的取整模式
	 * @return
	 * @throws BizException
	 */
	private String getSdMupakgu(String code_entp, FBoolean fg_pres_outp, String sd_ipmutp, String sd_opmutp)
			throws BizException {
		if (CiOrdUtils.isOpUrgentWf(code_entp) || (!CiOrdUtils.isEmpty(fg_pres_outp) && fg_pres_outp.booleanValue())) {
			return sd_opmutp;
		} else if (CiOrdUtils.isIpWf(code_entp)) {
			return sd_ipmutp;
		} else {
			throw new BizException("计算物品总量，传入的就诊类型无法匹配取整模式！");
		}
	}

	/**
	 * 总量单位对基本包装单位的换算系数
	 * 
	 * @param mmpackageUnits
	 * @param id_unit_sale
	 * @return
	 * @throws BizException
	 */
	private FDouble getFactorForUnitBaseToUnitSale(MMPackageUnitDO[] mmpackageUnits, String id_unit_sale)
			throws BizException {
		if (CiOrdUtils.isEmpty(id_unit_sale)) {
			throw new BizException("计算物品总量，传入总量单位为空！");
		}
		FDouble factor = new FDouble(0);
		for (MMPackageUnitDO mmPackageUnit : mmpackageUnits) {
			if (id_unit_sale.equals(mmPackageUnit.getId_unit_pkg())) {
				factor = mmPackageUnit.getFactor();
				break;
			}
		}
		if (factor.intValue() == 0) {
			throw new BizException("计算物品总量,总量单位对基本包装单位的换算系数配置错误！");
		} else {
			return factor;
		}
	}

	/**
	 * 物品计算总量的核心算法
	 * 
	 * @param sd_mupakgu
	 *            取整模式
	 * @param quan_medu
	 *            单次剂量
	 * @param factor_mb
	 *            医基换算系数
	 * @param factor
	 *            基本包装单位对总量单位换算系数
	 * @param times
	 *            总次数
	 * @return
	 * @throws BizException
	 */
	public FDouble getCalculateMMQuantum(String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor,
			Integer times) throws BizException {
		if (CiOrdUtils.isEmpty(sd_mupakgu) || CiOrdUtils.isEmpty(quan_medu) || CiOrdUtils.isEmpty(factor_mb)
				|| CiOrdUtils.isEmpty(factor))
			return new FDouble(0);
		// 按次取整
		if (sd_mupakgu.equals("0")) {
			return new FDouble(Math.ceil(quan_medu.div(factor_mb.multiply(factor)).getDouble()) * times);
		}
		// 按批取整
		else if (sd_mupakgu.equals("1")) {
			return new FDouble(Math.ceil(quan_medu.multiply(times).div((factor_mb.multiply(factor))).doubleValue()));
		}
		// 不取整
		else if (sd_mupakgu.equals("4")) {
			return quan_medu.multiply(times).div((factor_mb.multiply(factor)));
		} else {
			throw new BizException("计算物品总量，取整模式配置错误，无法计算！");
		}
	}

}
