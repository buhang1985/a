package iih.ei.std.bd.v1.i;

/**
 * 基础数据Web服务Xml标签定义
 * 
 * @author hao_wu 2019-2-27
 *
 */
public interface BdWebXmlKeyConst {

	/**
	 * 请求
	 */
	public final String REQUEST = "request";

	/**
	 * 接口编码
	 */
	public final String REQUEST_ITFCODE = "itfcode";

	/**
	 * 分页信息
	 */
	public final String REQUEST_PAGEINFO = "pageinfo";
	/**
	 * 页大小
	 */
	public final String REQUEST_PAGEINFO_PAGESIZE = "pagesize";
	/**
	 * 页号
	 */
	public final String REQUEST_PAGEINFO_PAGEINDEX = "pageindex";

	/**
	 * 参数列表
	 */
	public final String REQUEST_PARAMLIST = "paramlist";

	/**
	 * 响应
	 */
	public final String RESPONSE = "response";
	/**
	 * 编码
	 */
	public final String RESPONSE_CODE = "code";
	/**
	 * 消息
	 */
	public final String RESPONSE_MSG = "msg";
	/**
	 * 数据列表
	 */
	public final String RESPONSE_DATALIST = "datalist";
	/**
	 * 数据
	 */
	public final String RESPONSE_DATA = "data";
	/**
	 * 分页信息
	 */
	public final String RESPONSE_PAGEINFO = "pageinfo";
	/**
	 * 分页大小
	 */
	public final String RESPONSE_PAGEINFO_PAGESIZE = "pagesize";
	/**
	 * 页数
	 */
	public final String RESPONSE_PAGEINFO_PAGECOUNT = "pagecount";
	/**
	 * 页号(从0开始)
	 */
	public final String RESPONSE_PAGEINFO_PAGEINDEX = "pageindex";
	/**
	 * 记录总数
	 */
	public final String RESPONSE_PAGEINFO_RECORDSCOUNT = "recordsCount";
}
