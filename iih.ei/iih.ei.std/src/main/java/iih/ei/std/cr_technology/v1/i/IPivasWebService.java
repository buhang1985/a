package iih.ei.std.cr_technology.v1.i;

/**
 * 提供给静脉药物配置中心WebService接口
 * 
 * @author hao_wu 2018-5-29
 * @author hao_wu 2018-6-26 新增查询药品执行计划接口
 *
 */
public interface IPivasWebService {

	/**
	 * 发药</br>
	 * Pivas发药
	 * 
	 * @param inputParam 入参
	 * @return
	 */
	public abstract String dispDrug(String inputParam);

	/**
	 * 批量发药
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String dispDrugBat(String inputParam);

	/**
	 * 查询药品执行计划
	 * 
	 * @param inputParam 入参
	 * @return 药品执行计划
	 */
	public abstract String findMpPlans(String inputParam);

	/**
	 * 药品基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findDrugDic(String inputParam);

	/**
	 * 药品药理分类信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findPharlogyTypeDic(String inputParam);

	/**
	 * 医生基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findDoctorDic(String inputParam);

	/**
	 * 在院病人基本信息接口
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findPatDic(String inputParam);

	/**
	 * 科室基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findDeptDic(String inputParam);

	/**
	 * 药局(房)基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findPharmacyDic(String inputParam);

	/**
	 * 给药方式基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findDrugAdmiDic(String inputParam);

	/**
	 * 在院病人床位基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findPatBedDic(String inputParam);

	/**
	 * 操作员基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findOperatorDic(String inputParam);

	/**
	 * 药局(房)库存基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findPharmStockDic(String inputParam);

	/**
	 * 医嘱用法资料信息接口
	 * 
	 * @param inputParam
	 * @return
	 */
	public abstract String findOrdAdviceDic(String inputParam);

}
