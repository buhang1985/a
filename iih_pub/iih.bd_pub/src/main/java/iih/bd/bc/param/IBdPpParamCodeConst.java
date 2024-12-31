package iih.bd.bc.param;

/**
 * /** 基础数据.付款策略参数编码定义
 * 
 * @author hao_wu
 *
 */
public interface IBdPpParamCodeConst {
	/**
	 * 价表维护时计量单位是否可空
	 */
	public static final String BD_PP_FG_NULL_UNIT_PRICE = "BDPP0001";
	/**
	 * 优惠券分类编码长度
	 * 
	 */
	public static final String BD_PP_CPNCATE_CODELENGTH = "BDPP0002";
	/**
	 * 医保药品名称类型
	 */
	public static final String BD_PP_MI_DRUGNAMETYPE = "BDPP0003";

	/**
	 * 特殊项目调价是否强制使用调价计划
	 */
	public static final String BD_PP_USE_MODIFYPRICEPLAN = "BDPP0004";

	/**
	 * 价表维护节点:新增项目时，其医嘱标识的默认值
	 */
	public static final String BD_PP_DEFAULT_FGOR = "BDPP0006";

	/**
	 * 是否使用IIH的财务核算体系
	 */
	public static final String BL_AC_USEACCOUNTSYSTEMFLAG = "BLAC000001";

	/**
	 * 是否共用一套核算体系
	 */
	public static final String BL_AC_SHAREACCOUNTSYSTEM = "BLAC000002";

	/**
	 * 是否使用IIH的财务核算体系</br>
	 * 此定义已过时，请使用BL_AC_USEACCOUNTSYSTEMFLAG
	 */
	@Deprecated
	public static final String BL_AC_IFIIHACSYSTEM = "BLAC000001";

	/**
	 * 是否共用一套核算体系</br>
	 * 此定义已过时，请使用BL_AC_SHAREACCOUNTSYSTEM
	 */
	@Deprecated
	public static final String BL_AC_IFSHAREACSYSTEM = "BLAC000002";

	/**
	 * 调价计划调价标识Key</br>
	 * 上下文参数
	 */
	public static final String BD_PP_CONTEXT_BGTASKMODIFYPRIFLAGKEY = "BgTaskModifyPriFlag";
}
