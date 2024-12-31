package iih.bl.cg.oep.s;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.oep.i.IOpSettlementQryService;
import iih.bl.cg.oep.s.bp.GetIncDataOpBp;
import iih.bl.cg.oep.s.bp.GetNoBookkeepingCiSrvBP;
import iih.bl.st.dto.d.IncDataInfoOepDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;


/**
 * 门诊结算业务查询服务
 * @author yangyang
 */
@Service(serviceInterfaces = { IOpSettlementQryService.class }, binding = Binding.JSONRPC)
public class OpSettlementQryServiceImpl implements IOpSettlementQryService {

	@Override
	public IncDataInfoOepDTO[] getIncData(String strIdPat,String dtBegin ,String dtEnd) throws BizException {	
		GetIncDataOpBp handlerBp=new GetIncDataOpBp();
		return handlerBp.exec(strIdPat,dtBegin,dtEnd);
	}
	
	/**
	 * 获取未记账医嘱信息
	 */
	public BlOrderAppendBillParamDTO[] getNoBookkeepingCiSrv(String patId) throws BizException {
		GetNoBookkeepingCiSrvBP bp =  new GetNoBookkeepingCiSrvBP();
		return bp.exec(patId);
	}


}
