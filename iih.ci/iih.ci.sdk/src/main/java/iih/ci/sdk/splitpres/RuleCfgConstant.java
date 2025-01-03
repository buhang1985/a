package iih.ci.sdk.splitpres;

/**
 * 规则配置常量
 * 
 * @author HUMS
 *
 */
public class RuleCfgConstant {

	/**
	 * 数值常量
	 */
	public final static String FIRST = "1";
	
	/**
	 * 配置结果中规则部分统一名称
	 */
	public final static String RULES = "rules";

	// 处方使用相关常量 start
	/**
	 * 处方类型
	 */
	public final static String PRES_TYPE = "presType";

	/**
	 * 当前设置处方类型
	 */
	public final static String CURR_PRES_TYPE = "currPresType";

	/**
	 * 处方字
	 */
	public final static String PRES_WORD = "presWord";

	/**
	 * 当前设置的处方字
	 */
	public final static String CURR_PRES_WORD = "currPresWord";

	/**
	 * 覆盖方式，0：保持不变，1：替换（有权重值的按权重替换，没有权重属性的直接替换） ，2：追加
	 */
	public final static String OVERWRITE_MODEL = "overWriteModel";

	/**
	 * 权重值，用于解决覆盖方式未替换时，按权重替换，权重值高的允许替换权重值低的数据
	 */
	public final static String WEIGHT = "weight";

	/**
	 * 是否允许拆分 1：允许拆分，0：不允许继续拆分
	 */
	public final static String IS_ALLOWED_SPLIT = "isAllowedSplit";
	
	/**
	 * 拒绝拆分条件
	 */
	public final static String REFUSE_SPLIT = "refuseSplit";

	/**
	 * 是否强制拆分 1：强制拆分，0：不强制拆分
	 */
	public final static String IS_FORCED_SPLIT = "isForcedSplit";

	/**
	 * 处方明细数量
	 */
	public final static String PRES_DETAIL_NUM = "presDetailNum";

	// 处方使用相关常量 end

	/**
	 * 校验失败是否停止校验 1 ： 停止， 0 不停止
	 */
	public final static String IS_BREAK_FAIL_VALIDATE = "isBreakFailValidate";

	/**
	 * 使用天数
	 */
	public final static String USE_DAYS = "useDays";

	/**
	 * 最大使用天数
	 */
	public final static String MAX_USE_DAYS = "maxUseDays";

	// 校验相关属性常量start
	
	/**
	 * 不在……内
	 */
	public final static String NOT_IN = "not_in";
	
	/**
	 * 在……内
	 */
	public final static String IN = "in";
	
	/**
	 * 以……开始开头
	 */
	public final static String START_WITH = "start_with";
	
	/**
	 * 服务分类编码
	 */
	public final static String CODE_SRVCA ="code_srvca";
	
	/**
	 * 检验标本类型编码
	 */
	public final static String SD_SAMPTP = "sd_samptp";

	// 校验相关属性常量end
}
