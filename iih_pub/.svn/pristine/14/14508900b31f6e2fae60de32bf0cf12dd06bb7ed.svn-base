package iih.pis.ivx.invoice.i;

public interface IInvoicingPlatformAPIService {
	
	/**
	 * 1
	 * 开票平台获取自身的开票平台识别码
	 * 开票平台可以通过此接口获得本开票平台的预开票url，进而获取s_pappid。
	 * 开票平台将该s_pappid并透传给商户，商户可以通过该s_pappid参数在微信电子发票方案中标识出为自身提供开票服务的开票平台。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String setUrl() throws Exception;
	
	/**
	 * 2
	 * 开票平台创建发票卡券模板
	 * 通过本接口可以为创建一个商户的发票卡券模板，为该商户配置发票卡券模板上的自定义栏位。
	 * 创建发票卡券模板生成的card_id将在创建发票卡券时被引用，故创建发票卡券模板是创建发票卡券的基础。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String createCard(String jsonString) throws Exception;
	
	/**
	 * 3
	 * 商户或开票平台可以通过该接口上传PDF。
	 * PDF上传成功后将获得发票文件的标识，后续可以通过插卡接口将PDF关联到用户的发票卡券上，一并插入到收票用户的卡包中。
	 * 注意：若上传成功的PDF在三天内没有被关联到发票卡券发送到用户卡包上，将会被清理。
	 * 若商户或开票平台需要在三天后再关联发票卡券的话，需要重新上传。
	 * @author chen.zhao
	 * @since 2019/11/07
	 *
	 */
	public String setPdf(String fileString) throws Exception;
	
	/**
	 * 4
	 * 用于供发票PDF的上传方查询已经上传的发票或消费凭证PDF
	 * @author chen.zhao
	 * @since 2019/11/07
	 *
	 */
	public String getPdf(String jsonString) throws Exception;
	
	/**
	 * 5
	 * 将电子发票卡券插入用户卡包
	 * 本接口由开票平台或自建平台商户调用。对用户已经授权过的开票请求，开票平台可以使用本接口将发票制成发票卡券放入用户的微信卡包中。
	 * 值得关注的是，如果授权页由商户拉起，而插卡递送发票的动作由开票平台来完成的话，商户需要将需要存入微信卡包的标识和order_id在开票请求中发送给开票平台。
     * 注意：需要使用之前调用获取s_pappid接口时的开票平台公众号appid调用本接口，否则会造成报错，插卡失败。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String insert(String jsonString) throws Exception;
	
	/**
	 * 6
	 * 更新发票卡券状态
	 * 发票平台在获知发票状态变化（如被冲红、被报销）时，需更新在用户卡包中发票卡券的状态。确保发票卡券可用性，避免无效报销、重复报销。
	 * 本接口主要用于发票平台更新从其他渠道或者的发票报销状态变更，企业报销接口请见企业报销电子发票章节。
	 * 目前电子发票冲红在微信中表现为对应的发票卡券被核销，调用该接口并将发票卡券状态置为“INVOICE_REIMBURSE_CANCEL”即可
	 * 具体发票状态见发票状态一览表。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String updateStatus(String jsonString) throws Exception;
	
	/**
	 * 7
	 * 空实现
	 * 发票状态更新事件推送
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void updatePush() throws Exception;
	
	/**
	 * 8
	 * 解码code接口
	 * 为了满足商户基于发票本身的扩展诉求，允许发票内页添加url跳转外链(创建发票字段中的promotion_url和custom_url)。
	 * 带有的的字段有encrypt_code、card_id。
	 * 假如指定的url为：http://www.qq.com 用户点击时，跳转的url则为：http://www.qq.com?encrypt_code=ENCRYPT_CODE&card_id=CARDID
	 * encrypt_code为加密码，需调用接口解码方可得到真实的code。
	 * 获取到的真实code和调用插卡接口返回的code相同。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String decrypt(String jsonString) throws Exception;
	
}
