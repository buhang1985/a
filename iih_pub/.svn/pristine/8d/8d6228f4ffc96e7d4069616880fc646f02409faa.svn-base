package iih.ei.bl.ecinc.i;

import xap.mw.core.data.BizException;

/**
 * 电子发票接口工厂
 * @author ly 2019/12/02
 *
 */
public interface IEcIncFactory {

	/**
	 * 创建电子票据费用流程实例
	 * @return
	 * @throws BizException
	 */
	public abstract IEcIncBlFlowService createBlFlowInstance() throws BizException;

	/**
	 * 创建电子票据费用辅助实例
	 * @return
	 * @throws BizException
	 */
	public abstract IEcIncBlAssistService createBlAssistInstance() throws BizException;
	
	/**
	 * 创建电子票纸质票据操作实例
	 * @return
	 * @throws BizException
	 */
	public abstract IEcIncPaperService createPaperInstance() throws BizException;

	/**
	 * 创建电子票据票据管理实例
	 * @return
	 * @throws BizException
	 */
	public abstract IEcIncManageService createManageInstance() throws BizException;
	
	/**
	 * 创建电子票据数据核对实例
	 * @return
	 * @throws BizException
	 */
	public abstract IEcIncDataCheckService createDataCheckInstance() throws BizException;
	
	/**
	 * 创建电子票据财务实例
	 * @return
	 * @throws BizException
	 */
	public abstract IEcIncFinanceService createFinanceInstance() throws BizException;
	
}
