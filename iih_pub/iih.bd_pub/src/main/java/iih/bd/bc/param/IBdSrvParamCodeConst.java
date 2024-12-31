package iih.bd.bc.param;

/**
 * 基础数据.医疗物品参数编码定义
 * 
 * @author hao_wu
 *
 */
public interface IBdSrvParamCodeConst {
	/**
	 * 检查医疗服务编码长度标识
	 */
	public static final String FGCHECKSRVCODELENGTH = "BDSRV0007";

	/**
	 * 诊断标准和诊断字典是否同步停用
	 */
	public static final String ISDIANDSTDSTOPTOGETHER = "BDSRV0009";

	/**
	 * 医疗服务是否进行临床启用校验
	 */
	public static final String ISVALIDATETREATENABLEBYCI = "BDSRV0010";

	/**
	 * 上下文参数_是否检查用法</br>
	 * 药品通用名保存时因为主DO和子DO分开保存，保存主DO时需要不检查用法
	 */
	public static final String CHECKROUTEFLAG = "CheckRouteFlag";
}
