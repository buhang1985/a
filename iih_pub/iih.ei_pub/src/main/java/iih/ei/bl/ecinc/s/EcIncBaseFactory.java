package iih.ei.bl.ecinc.s;

import iih.ei.bl.ecinc.i.IEcIncBlAssistService;
import iih.ei.bl.ecinc.i.IEcIncBlFlowService;
import iih.ei.bl.ecinc.i.IEcIncDataCheckService;
import iih.ei.bl.ecinc.i.IEcIncFactory;
import iih.ei.bl.ecinc.i.IEcIncFinanceService;
import iih.ei.bl.ecinc.i.IEcIncManageService;
import iih.ei.bl.ecinc.i.IEcIncPaperService;
import xap.mw.core.data.BizException;

/**
 * 电子发票基础工厂
 * @author ly 2019/12/02
 *
 */
public class EcIncBaseFactory implements IEcIncFactory{

	/**
	 * 创建电子票据费用流程实例
	 * @return
	 * @throws BizException
	 */
	@Override
	public IEcIncBlFlowService createBlFlowInstance() throws BizException {
		return new EcIncBlFlowBaseServiceImpl();
	}

	/**
	 * 创建电子票据费用辅助实例
	 * @return
	 * @throws BizException
	 */
	@Override
	public IEcIncBlAssistService createBlAssistInstance() throws BizException {
		return new EcIncBlAssistBaseServiceImpl();
	}

	/**
	 * 创建电子票纸质票据操作实例
	 * @return
	 * @throws BizException
	 */
	@Override
	public IEcIncPaperService createPaperInstance() throws BizException {
		return new EcIncPaperBaseServiceImpl();
	}

	/**
	 * 创建电子票据票据管理实例
	 * @return
	 * @throws BizException
	 */
	@Override
	public IEcIncManageService createManageInstance() throws BizException {
		return new EcIncManageBaseServiceImpl();
	}

	/**
	 * 创建电子票据数据核对实例
	 * @return
	 * @throws BizException
	 */
	@Override
	public IEcIncDataCheckService createDataCheckInstance() throws BizException {
		return new EcIncDataCheckBaseServiceImpl();
	}

	/**
	 * 创建电子票据财务实例
	 * @return
	 * @throws BizException
	 */
	@Override
	public IEcIncFinanceService createFinanceInstance() throws BizException {
		return new EcIncFinanceBaseServiceImpl();
	}
}
