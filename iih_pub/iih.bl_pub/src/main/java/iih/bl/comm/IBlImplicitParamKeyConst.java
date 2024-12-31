package iih.bl.comm;

/**
 * 费用域隐式传参常量key
 * 用于dto中直接getAttrVal，setAttrVal传值
 * 只用于接口参数处理，内部业务处理慎用
 * @author ly 2018/08/23
 *
 */
public interface IBlImplicitParamKeyConst {

	/**
	 * 就诊床位id
	 */
	public static final String BL_ID_ENTBED = "bl_id_entbed";
	
	/**
	 * 就诊固定费用id
	 */
	public static final String BL_ID_ENTDCG = "bl_id_entdcg";
	
	/**
	 * 体检流水号
	 */
	public static final String BL_PECODE = "bl_pecode";
}
