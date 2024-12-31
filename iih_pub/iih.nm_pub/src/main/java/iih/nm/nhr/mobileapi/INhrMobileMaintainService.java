package iih.nm.nhr.mobileapi;

import xap.mw.core.data.BizException;

/**
 * 对外（移动端）访问审批流程审批接口
 * 
 * @author lijm
 * @TIME 2019-5-8 21:13:10
 *
 */
public interface INhrMobileMaintainService {

	/**
	 * 单据提交
	 * 
	 * @param billId
	 * @throws BizException
	 */
	public void billSubmit(String billId, String flowtype) throws BizException;

	/**
	 * 单据撤回
	 * 
	 * @param billId
	 * @throws BizException
	 */
	public void billBack(String billId, String flowtype) throws BizException;

	/**
	 * 单据通过
	 * 
	 * @param billId
	 * @throws BizException
	 */
	public void billAccept(String billId, String flowtype,String opinion) throws BizException;

	/**
	 * 单据驳回
	 * 
	 * @param billId
	 * @throws BizException
	 */
	public void billReject(String billId, String flowtype,String opinion) throws BizException;

}
