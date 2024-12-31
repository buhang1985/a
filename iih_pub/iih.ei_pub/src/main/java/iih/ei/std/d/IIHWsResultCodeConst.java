package iih.ei.std.d;

/**
 * IIHWebService结果编码常量定义
 * 
 * @author hao_wu 2019-9-3
 *
 */
public class IIHWsResultCodeConst {

	/**
	 * 获取结果信息
	 * 
	 * @param resultCode
	 * @return
	 */
	public static String getResultMsg(String resultCode) {
		String resultMsg = null;
		switch (resultCode) {
		case Success:
			resultMsg = "成功";
			break;
		case Error_Itf_NotRegister:
			resultMsg = "接口未注册";
			break;
		case Error_Itf_NotFactive:
			resultMsg = "接口未启用";
			break;
		case Error_DeSerialize_ServiceParam:
			resultMsg = "框架服务参数反序列化错误";
			break;
		case Error_DeSerialize_BusinessParam:
			resultMsg = "业务参数反序列化错误";
			break;
		case Error_Business_NotFound_ItfClass:
			resultMsg = "找不到接口类";
			break;
		case Error_Business_NotFound_ImplService:
			resultMsg = "找不到接口实现类";
			break;
		case Error_Business_NotFound_Method:
			resultMsg = "找不到接口中方法";
			break;
		case Error_Business_Param_Count:
			resultMsg = "业务参数个数错误";
			break;
		case Error_Business_Param_Type:
			resultMsg = "业务参数类型错误，参数类型必须是DO";
			break;
		case Error_Business:
			resultMsg = "业务错误";
			break;
		case Error_Business_Other:
			resultMsg = "业务其他异常";
			break;
		case Error_Param_UserCode:
			resultMsg = "用户编码不允许为空";
			break;
		case Error_Param_UserCode_NOTExist:
			resultMsg = "根据用户编码未查询到用户信息";
			break;
		case Error_Param_UserCode_Repeat:
			resultMsg = "根据用户编码查询到多个用户信息";
			break;
		case Error_Param_DepCode_NOTExist:
			resultMsg = "根据部门编码未查询到部门信息";
			break;
		case Error_Param_DepCode_Repeat:
			resultMsg = "根据部门编码查询到多个部门信息";
			break;
		case Error_PARAM_EXCode:
			resultMsg = "外部编码不允许为空";
			break;
		case Error_Other:
			resultMsg = "框架未定义的其他异常";
			break;
		default:
			resultMsg = String.format("未知编码:%s", resultCode);
			break;
		}
		return resultMsg;
	}

	/**
	 * 成功
	 */
	public final static String Success = "0";

	/**
	 * 接口未注册
	 */
	public final static String Error_Itf_NotRegister = "1101";

	/**
	 * 接口未启用
	 */
	public final static String Error_Itf_NotFactive = "1102";

	/**
	 * 框架服务参数反序列化错误
	 */
	public final static String Error_DeSerialize_ServiceParam = "1201";

	/**
	 * 业务参数反序列化错误
	 */
	public final static String Error_DeSerialize_BusinessParam = "1202";

	/**
	 * 找不到接口类
	 */
	public final static String Error_Business_NotFound_ItfClass = "130101";

	/**
	 * 找不到接口实现类
	 */
	public final static String Error_Business_NotFound_ImplService = "130102";

	/**
	 * 找不到接口中方法
	 */
	public final static String Error_Business_NotFound_Method = "130103";

	/**
	 * 业务参数个数错误
	 */
	public final static String Error_Business_Param_Count = "130201";

	/**
	 * 业务参数类型错误，参数类型必须是DO
	 */
	public final static String Error_Business_Param_Type = "130202";

	/**
	 * 业务错误</br>
	 * BizException
	 */
	public final static String Error_Business = "15";

	/**
	 * 业务其他异常</br>
	 * 除BizException
	 */
	public final static String Error_Business_Other = "1599";

	/**
	 * 用户编码异常</br>
	 * BizException
	 */
	public final static String Error_Param_UserCode = "1601";

	/**
	 * 用户编码不存在</br>
	 * BizException
	 */
	public final static String Error_Param_UserCode_NOTExist = "160101";

	/**
	 * 用户编码重复</br>
	 * BizException
	 */
	public final static String Error_Param_UserCode_Repeat = "160102";

	/**
	 * 科室编码不存在</br>
	 * BizException
	 */
	public final static String Error_Param_DepCode_NOTExist = "160201";

	/**
	 * 科室编码重复</br>
	 * BizException
	 */
	public final static String Error_Param_DepCode_Repeat = "160202";

	/**
	 * 外部编码异常</br>
	 * BizException
	 */
	public final static String Error_PARAM_EXCode = "1603";

	/**
	 * 框架未定义的其他异常
	 */
	public final static String Error_Other = "99";
}
