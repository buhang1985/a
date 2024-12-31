package iih.bd.bc.param;

/**
 * 基础数据.医疗物品参数编码定义
 * 
 * @author hao_wu
 *
 */
public interface IBdMmParamCodeConst {
	/**
	 * 分页大小
	 */
	public static final String PAGESIZE = "pagesize";
	/**
	 * 开启仓库数据权限
	 */
	public static final String OPENDATAPERMISSIONS_WH = "MM0001";
	/**
	 * 采购发票需要审批
	 */
	public static final String NEEDAPPROVED_PURCHASEINVOICE = "MM0002";
	/**
	 * 皮试必填
	 */
	public static final String SKINTESTREQUIRED = "BDMM0003";
	/**
	 * 药品用药属性管理模式
	 */
	public static final String DRUGMCPROPMM = "BDMM0004";
	
	/**
	 * 药品用医基换算系数是否允许修改
	 */
	public static final String MMMEDFACTORCANUPDATE = "BDMM0005";
}
