package iih.pis.ivx.invoice.i;

public interface IVendorAPIService {

	/**
	 * 1
	 * 商户获取授权页ticket
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String getTicket() throws Exception;

	/**
	 * 2
	 * 商户获取授权页链接
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String getAuthUrl(String jsonString) throws Exception;
	
	/**
	 * 3
	 * 空实现
	 * 小程序打开授权页
	 * 小程序需要先使用小程序账号调用获取授权页链接接口，获取到授权连接，才能打开授权页。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void navigateToMiniProgram() throws Exception;
	
	/**
	 * 4
	 * 空实现
	 * ios客户端打开授权页
	 * ios客户端需要先使用open账号调用获取授权页链接接口，获取到授权连接，才能打开授权页。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void iosSendReq() throws Exception;
	
	/**
	 * 5
	 * 空实现
	 * android客户端打开授权页
	 * android客户端需要先调用获取授权页链接接口，获取到授权连接，才能打开授权页。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void androidSendReq() throws Exception;
	
	/**
	 * 6
	 * 空实现
	 * 收取授权完成事件推送
	 * 在用户授权同意发票存入自己微信账户后，商户可以收到授权完成的状态推送。
	 * 收到推送后，可以将order_id连同开票信息一并发送给开票平台，以便开票平台在开票成功后将电子发票插入用户卡包。
	 * 该事件将发送至开发者填写的URL（登录公众平台进入【开发者中心设置】，如果是open账号，也得用公众号账号来接，参考商户接口列表）。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void collectPush() throws Exception;
	
	/**
	 * 7
	 * 查询授权完成状态
	 * 本接口的调用场景包括两个：
	 * 一、若商户在某次向用户展示授权页后经过较长时间仍未收到授权完成状态推送，可以使用本接口主动查询用户是否实际上已完成授权，只是由于网络等原因未收到授权完成事件；
	 * 二、若商户向用户展示的授权页为type=1类型，商户在收到授权完成事件推送后需要进一步获取用户的开票信息，也可以调用本接口
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String getAuthData(String jsonString) throws Exception;
	
	/**
	 * 8
	 * 拒绝开票
	 * 用户完成授权后，商户若发现用户提交信息错误、或者发生了退款时，可以调用该接口拒绝开票并告知用户。
	 * 拒绝开票后，该订单无法向用户再次开票。已经拒绝开票的订单，无法再次使用，如果要重新开票，需使用新的order_id，获取授权链接，让用户再次授权。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String rejectInsert(String jsonString) throws Exception;
	
	/**
	 * 9
	 * 传"set_auth_field"
	 * 设置授权页字段信息
	 * 当用户使用type=1的类型的授权页时，可以使用本接口设置授权页上需要用户填写的信息。
	 * 若使用type=0或type=2类型的授权页，无需调用本接口。本接口为一次性设置，后续除非在需要调整页面字段时才需要再次调用。
	 * 注意，设置为显示状态的字段均为必填字段，用户若不填写将无法进入后续流程
	 * 
	 * 10
	 * 传"get_auth_field"
	 * 查询授权页字段信息
	 * 商户可以通过本接口查询到授权页的字段设置情况
	 * 
	 * 11
	 * 传"set_pay_mch"
	 * 关联商户号与开票平台
	 * 商户使用支付后开票，需要先将自身的商户号和开票平台的识别号进行关联，开票平台识别号由开票平台根据微信规则生成后告知商户。
	 * 本接口为一次性设置，后续一般在遇到开票平台识别号变更，或者商户更换开票平台时才需要调用本接口重设对应关系。
	 * 若商户已经实现电子发票的微信卡包送达方案，调用本接口前，建议在微信支付商户平台中确认商户号所绑定的公众号和拉起授权页的公众号是同一个。
	 * 若不是同一个，仍需重新使用商户号所绑定公众号去调通拉取授权页的接口。
	 * 
	 * 12
	 * 传"get_pay_mch"
	 * 查询商户号与开票平台关联情况
	 * 商户可以通过本接口查询到与开票平台的绑定情况。
	 * 
	 * 17
	 * 传"set_contact"
	 * 设置商户联系方式
	 * 商户获取授权链接之前，需要先设置商户的联系方式
	 * 
	 * 18
	 * 传"get_contact"
	 * 查询商户联系方式
	 * 商户获取授权链接之前，需要先设置商户的联系方式
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String setBizAttr(String action, String jsonString) throws Exception;
	
	/**
	 * 13
	 * 空实现
	 * 指定单笔交易支持支付后开票
	 * 对于可以开具电子发票的商户，完成了微信商户号与开票平台的关联设置后，可以以单笔支付为单位，
	 * 指定在支付成功消息上是否出现开发票的入口。让用户可以通过该入口发起开票。
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void receipt() throws Exception;
	
	/**
	 * 14
	 * 统一开票接口-开具蓝票
	 * 对于使用微信电子发票开票接入能力的商户，在公众号后台选择任何一家开票平台的套餐，都可以使用本接口实现电子发票的开具。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String makeOutInvoice(String jsonString) throws Exception;
	
	/**
	 * 15
	 * 统一开票接口-发票冲红
	 * 对于使用微信电子发票开票接入能力的商户，在公众号后台选择任何一家开票平台的套餐，都可以使用本接口实现电子发票的冲红。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String clearOutInvoice(String jsonString) throws Exception;
	
	/**
	 * 16
	 * 统一开票接口-查询已开发票
	 * 对于使用微信电子发票开票接入能力的商户，在公众号后台选择任何一家开票平台的套餐，都可以使用本接口实现已开具电子发票的查询。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String queryInvoceInfo(String jsonString) throws Exception;
	
	/**
	 * 19
	 * 空实现
	 * 统一开票接口-异步通知开票结果
	 * 在用户授权同意发票存入自己微信账户后，商户可以收到授权完成的状态推送。
	 * 收到推送后，可以将order_id连同开票信息一并发送给开票平台，以便开票平台在开票成功后将电子发票插入用户卡包。
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void asynchronousNotification() throws Exception;
	
}
