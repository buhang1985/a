package iih.ei.bl.ecinc.bosssoft.v2.s;

import iih.ei.bl.ecinc.i.IEcIncBlAssistService;
import iih.ei.bl.ecinc.i.IEcIncBlFlowService;
import iih.ei.bl.ecinc.i.IEcIncManageService;
import iih.ei.bl.ecinc.i.IEcIncPaperService;
import iih.ei.bl.ecinc.s.EcIncBaseFactory;
import xap.mw.core.data.BizException;

/**
 * 博思电子发票工厂类
 * @author ly 2019/12/03
 *
 */
public class BossSoftEcIncFactory extends EcIncBaseFactory{

	@Override
	public IEcIncBlFlowService createBlFlowInstance() throws BizException {
		return BossSoftEcIncBlFlowServiceImpl.getInstance();
	}
	
	@Override
	public IEcIncBlAssistService createBlAssistInstance() throws BizException {
		return BossSoftEcIncBlAssistServiceImpl.getInstance();
	}
	
	@Override
	public IEcIncPaperService createPaperInstance() throws BizException {
		return BossSoftEcIncPaperServiceImpl.getInstance();
	}
	
	@Override
	public IEcIncManageService createManageInstance() throws BizException {
		return new BossSoftEcIncManageServiceImpl();
	}
}
