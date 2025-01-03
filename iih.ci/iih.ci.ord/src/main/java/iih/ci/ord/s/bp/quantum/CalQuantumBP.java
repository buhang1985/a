package iih.ci.ord.s.bp.quantum;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.ci.ord.ciordems.d.QuantumParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.exception.CalQuantumMupakguException;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
/**
 * 计算总量类
 * @author 张万青
 *
 */
public class CalQuantumBP {
	/**
	 * 计算总量
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FDouble getQuantum(QuantumParamDTO param) throws BizException{
		if(CiOrdUtils.isEmpty(param.getFg_mm())||!param.getFg_mm().booleanValue()||(!CiOrdUtils.isEmpty(param.getSd_srvtp())&&param.getSd_srvtp().equals(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE))){
			return this.getUnMMQuantum(param);
		}else{
			return getMMQuantum(param);
		}
	}
	/**
	 * 物品类计算总量
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FDouble getMMQuantum(QuantumParamDTO param) throws BizException{
		String id_mm = param.getId_mm();
		MeterialAggDO mmagg = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
		MeterialDO parentDO = mmagg.getParentDO();
		MMPackageUnitDO[] mmpackageUnits = mmagg.getMMPackageUnitDO();
		//根据就诊类型获得取整模式
		String sd_mupakgu=getSdMupakgu(param.getCode_entp(),param.getFg_pres_outp(),parentDO);//取整模式
		//医基换算系数
		FDouble factor_mb = parentDO.getFactor_mb();
		//总量单位对基本包装单位的换算系数
		FDouble factor = getFactorForUnitBaseToUnitSale(mmpackageUnits,param.getId_unit_sale());
		//医嘱执行总次数
		GetTotalTimesBP bp = new GetTotalTimesBP();
		Integer times = bp.getTotalTimesBP(param);
		FDouble quan_medu = param.getQuan_medu();
		return this.getMMQuantum(sd_mupakgu, quan_medu, factor_mb, factor, times);
	}
	/**
	 * 物品类计算总量
	 * @param code_entp 就诊类型
	 * @param fg_pres_outp 是否出院带药
	 * @param dt_effe 开始时间 空，默认取当前系统时间
	 * @param use_day 使用天数
	 * @param id_freq 频次
	 * @param id_mm 物品id
	 * @param id_unit_sale 总量单位id
	 * @param quan_medu 单次剂量
	 * @return
	 * @throws BizException
	 */
	public FDouble getMMQuantum(String code_entp,FBoolean fg_pres_outp,FDateTime dt_effe,Integer use_day,String id_freq,String id_mm,String id_unit_sale,FDouble quan_medu) throws BizException{
		if(CiOrdUtils.isEmpty(use_day)||CiOrdUtils.isEmpty(quan_medu))
			return FDouble.ZERO_DBL;
		MeterialAggDO mmagg = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
		MeterialDO parentDO = mmagg.getParentDO();
		MMPackageUnitDO[] mmpackageUnits = mmagg.getMMPackageUnitDO();
		//根据就诊类型获得取整模式
		String sd_mupakgu=getSdMupakgu(code_entp,fg_pres_outp,parentDO);//取整模式
		//医基换算系数
		FDouble factor_mb = parentDO.getFactor_mb();
		//总量单位对基本包装单位的换算系数
		FDouble factor = getFactorForUnitBaseToUnitSale(mmpackageUnits,id_unit_sale);
		//医嘱执行总次数
		GetTotalTimesBP bp = new GetTotalTimesBP();
		Integer times = bp.getTotalTimes(dt_effe,id_freq,use_day);
		return this.getMMQuantum(sd_mupakgu, quan_medu, factor_mb, factor, times);
	}
	/**
	 * 物品类计算总量(已经知道总次数)
	 * @param code_entp 就诊类型
	 * @param fg_pres_outp 是否出院带药
	 * @param times 总次数
	 * @param id_mm 物品id
	 * @param id_unit_sale 总量单位id
	 * @param quan_medu 单次剂量
	 * @return
	 * @throws BizException
	 */
	public FDouble getMMQuantum(String code_entp,FBoolean fg_pres_outp,Integer times,String id_mm,String id_unit_sale,FDouble quan_medu) throws BizException{
		MeterialAggDO mmagg = CiOrdAppUtils.getIMeterialRService().findById(id_mm);
		MeterialDO parentDO = mmagg.getParentDO();
		MMPackageUnitDO[] mmpackageUnits = mmagg.getMMPackageUnitDO();
		//根据就诊类型获得取整模式
		String sd_mupakgu=getSdMupakgu(code_entp,fg_pres_outp,parentDO);//取整模式
		//医基换算系数
		FDouble factor_mb = parentDO.getFactor_mb();
		//总量单位对基本包装单位的换算系数
		FDouble factor = getFactorForUnitBaseToUnitSale(mmpackageUnits,id_unit_sale);
		return this.getMMQuantum(sd_mupakgu, quan_medu, factor_mb, factor, times);
	}
	 
	/**
	 * 非物品计算总量
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FDouble getUnMMQuantum(QuantumParamDTO param) throws BizException{
		GetTotalTimesBP bp = new GetTotalTimesBP();
		Integer times = bp.getTotalTimesBP(param);
		if(times!=null&&param.getQuan_medu()!=null) return param.getQuan_medu().multiply(times);
		return new FDouble(0);
	}
	/**
	 * 非物品计算总量
	 * @param dt_effe 开始时间  空，默认取当前系统时间
	 * @param id_freq
	 * @param use_day
	 * @param quan_medu 单次剂量
	 * @return
	 * @throws BizException
	 */
	public FDouble getUnMMQuantum(FDateTime dt_effe,String id_freq,Integer use_day,FDouble quan_medu) throws BizException{
		if(CiOrdUtils.isEmpty(id_freq)||CiOrdUtils.isEmpty(use_day)||CiOrdUtils.isEmpty(quan_medu)){
			return FDouble.ZERO_DBL;
		}
		GetTotalTimesBP bp = new GetTotalTimesBP();
		Integer times = bp.getTotalTimes(dt_effe,id_freq,use_day);
		return times==null?new FDouble(0):new FDouble(times).multiply(quan_medu);
	}
	/**
	 * 计算总量（非物品）,知道总次数和单次剂量
	 * @param quan_medu 单次剂量
	 * @param times_cur 总次数
	 * @return
	 */
	public FDouble getQuantum(FDouble quan_medu,Integer times_cur){
		if(CiOrdUtils.isEmpty(quan_medu)||CiOrdUtils.isEmpty(times_cur))
			return FDouble.ZERO_DBL;
		return quan_medu.multiply(new FDouble(times_cur));
	}
	/**
	 * 获得物品的取整模式
	 * @param code_entp 就诊类型
	 * @param fg_pres_outp 是否出院带药
	 * @param MeterialDO mmDO
	 * @return
	 * @throws BizException 
	 */
	public String getSdMupakgu(String code_entp,FBoolean fg_pres_outp,MeterialDO mmDO) throws BizException{
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)||(!CiOrdUtils.isEmpty(fg_pres_outp)&&fg_pres_outp.booleanValue())){
			return mmDO.getSd_opmutp();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){
			return mmDO.getSd_mupkgutp();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)){
			return mmDO.getSd_ermutp();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)){
			return mmDO.getSd_er1mutp();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)){
			return mmDO.getSd_er2mutp();
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(code_entp)){
			return mmDO.getSd_pipmutp();
		}else{
		
			throw new BizException("计算物品总量，传入的就诊类型无法匹配取整模式！");
		}
	}
	/**
	 * 总量单位对基本包装单位的换算系数
	 * @param mmpackageUnits 
	 * @param id_unit_sale
	 * @return
	 * @throws BizException 
	 */
	public FDouble getFactorForUnitBaseToUnitSale(MMPackageUnitDO[] mmpackageUnits,String id_unit_sale) throws BizException{
		if(CiOrdUtils.isEmpty(id_unit_sale)){
			throw new BizException("计算物品总量，传入总量单位为空！");
		}
		FDouble factor = new FDouble(0);
		for(MMPackageUnitDO mmPackageUnit : mmpackageUnits){
			if(id_unit_sale.equals(mmPackageUnit.getId_unit_pkg())){
				factor = mmPackageUnit.getFactor();
				break;
			}
		}
		if(factor.intValue()==0){
			throw new BizException("计算物品总量,总量单位对基本包装单位的换算系数配置错误！");
		}else{
			return factor;
		}
	}
	/**
	 * 物品计算总量的核心算法
	 * @param sd_mupakgu 取整模式
	 * @param quan_medu 单次剂量
	 * @param factor_mb 医基换算系数
	 * @param factor 基本包装单位对总量单位换算系数
	 * @param times 总次数
	 * @return
	 * @throws BizException
	 */
	public FDouble getMMQuantum(String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor, Integer times)
			throws BizException {
		if (CiOrdUtils.isEmpty(sd_mupakgu) || CiOrdUtils.isEmpty(quan_medu) || CiOrdUtils.isEmpty(factor_mb) || CiOrdUtils.isEmpty(factor)) return new FDouble(0);
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
			throw new CalQuantumMupakguException("计算物品总量，取整模式配置错误，无法计算！");
		}
	}
	/**
	 * 物品计算总量的核心算法
	 * @param sd_mupakgu 取整模式
	 * @param quan_medu 单次剂量
	 * @param factor_mb 医基换算系数
	 * @param factor 基本包装单位对总量单位换算系数
	 * @param times 总次数
	 * @return
	 * @throws BizException
	 */
	public FDouble getMMQuantum(String sd_srvtp,String sd_mupakgu, FDouble quan_medu, FDouble factor_mb, FDouble factor, Integer times)
			throws BizException {
		if (CiOrdUtils.isEmpty(sd_mupakgu) || CiOrdUtils.isEmpty(quan_medu) || CiOrdUtils.isEmpty(factor_mb) || CiOrdUtils.isEmpty(factor)) return new FDouble(0);
		if(sd_srvtp.startsWith("01")){
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
				throw new CalQuantumMupakguException("计算物品总量，取整模式配置错误，无法计算！");
			}
		}else{
			return quan_medu.multiply(times).div((factor_mb.multiply(factor)));
		}
		
	}
	/**
	 * 计算物品总量
	 * @param sd_mupkgutp 取整模式
	 * @param quan_med 剂量
	 * @param factor_mb 医基换算系数
	 * @param factor_cb 换算系数
	 * @param dt_effe 开始时间 空，默认取当前系统时间
	 * @param useDays 使用天数
	 * @param id_freq 频次
	 * @throws BizException 
	 */
	public FDouble getMMQuantum(String sd_mupkgutp, FDouble quan_med, FDouble factor_mb, FDouble factor,FDateTime dt_effe,
			Integer use_day, String id_freq) throws BizException {
		Integer times1 = 0;
		GetTotalTimesBP bp = new GetTotalTimesBP();
		try {
			 times1 = bp.getTotalTimes(dt_effe,id_freq,use_day);
		} catch (BizException e) {
			return FDouble.ZERO_DBL;
		}
		return getMMQuantum(sd_mupkgutp, quan_med, factor_mb, factor, times1);
	}
	/**
	 * 计算物品总量
	 * @param sd_mupkgutp 取整模式
	 * @param quan_med 剂量
	 * @param factor_mb 医基换算系数
	 * @param factor_cb 换算系数
	 * @param dt_effe 开始时间 空，默认取当前系统时间
	 * @param useDays 使用天数
	 * @param id_freq 频次
	 * @throws BizException 
	 */
	public FDouble getMMQuantum(String sd_srvtp,String sd_mupkgutp, FDouble quan_med, FDouble factor_mb, FDouble factor,FDateTime dt_effe,
			Integer use_day, String id_freq) throws BizException {
		Integer times1 = 0;
		GetTotalTimesBP bp = new GetTotalTimesBP();
		try {
			 times1 = bp.getTotalTimes(dt_effe,id_freq,use_day);
		} catch (BizException e) {
			return FDouble.ZERO_DBL;
		}
		return getMMQuantum(sd_srvtp,sd_mupkgutp, quan_med, factor_mb, factor, times1);
	}
}
