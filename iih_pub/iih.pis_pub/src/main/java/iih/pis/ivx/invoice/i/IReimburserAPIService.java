package iih.pis.ivx.invoice.i;

public interface IReimburserAPIService {

	/**
	 * 1
	 * 空实现
	 * 前端js调用
	 * 微信公众号拉起发票列表
	 * 本接口功能为在微信公众号拉起发票卡券列表，用户勾选需要提交报销的发票后，开发者获得所选发票的标识信息。
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void gzhChooseInvoice() throws Exception;
	
	/**
	 * 2
	 * 空实现
	 * 微信小程序拉起发票列表
	 * 本接口功能为在微信公众号拉起发票卡券列表，用户勾选需要提交报销的发票后，开发者获得所选发票的标识信息。
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void miniChooseInvoice() throws Exception;
	
	/**
	 * 3
	 * 空实现
	 * 企业微信拉起发票列表
	 * 本接口功能为在微信公众号拉起发票卡券列表，用户勾选需要提交报销的发票后，开发者获得所选发票的标识信息。
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void qywxChooseInvoice() throws Exception;
	
	/**
	 * 4
	 * 空实现
	 * 外部App拉起发票列表
	 * 本接口功能为在微信公众号拉起发票卡券列表，用户勾选需要提交报销的发票后，开发者获得所选发票的标识信息。
	 * 详情见文档
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public void outAppChooseInvoice() throws Exception;
	
	/**
	 * 5
	 * 查询报销发票信息
	 * 通过该接口查询电子发票的结构化信息，并获取发票PDF文件
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String getInvoiceInfo(String jsonString) throws Exception;
	
	/**
	 * 6
	 * 批量查询报销发票信息
	 * 通过该接口批量查询电子发票的结构化信息，并获取发票PDF文件
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String getInvoiceBatch(String jsonString) throws Exception;
	
	/**
	 * 7
	 * 报销方更新发票状态
	 * 报销企业和报销服务商可以通过该接口对某一张发票进行锁定、解锁和报销操作。
	 * 各操作的业务含义及在用户端的表现如下：
	 * 锁定：电子发票进入了企业的报销流程时应该执行锁定操作，执行锁定操作后的电子发票仍然会存在于用户卡包内，但无法重复提交报销。
	 * 解锁：当电子发票由于各种原因，无法完成报销流程时，应执行解锁操作。执行锁定操作后的电子发票将恢复可以被提交的状态。
	 * 报销：当电子发票报销完成后，应该使用本接口执行报销操作。
	 * 执行报销操作后的电子发票将从用户的卡包中移除，用户可以在卡包的消息中查看到电子发票的核销信息。
	 * 注意，报销为不可逆操作，请开发者慎重调用。
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String updateInvoiceStatus(String jsonString) throws Exception;
	
	/**
	 * 8
	 * 报销方批量更新发票状态
	 * 发票平台可以通过该接口对某一张发票进行锁定、解锁和报销操作，注意，报销状态为不可逆状态，请开发者慎重调用。
	 * 注意：
	 * 1 报销方须保证在报销、锁定、解锁后及时将状态同步至微信侧，保证用户发票可以正常使用
	 * 2 批量更新发票状态接口为事务性操作，如果其中一张发票更新失败，列表中的其它发票状态更新也会无法执行，恢复到接口调用前的状态
	 * @author chen.zhao
	 * @since 2019/11/06
	 *
	 */
	public String updateStatusBatch(String jsonString) throws Exception;
	
}
