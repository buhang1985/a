package iih.bl.cg.ip.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import iih.bd.pp.priusg.d.PriUsgDO;
import iih.bl.cg.dto.d.BoilDesReferBillDTO;
import iih.bl.cg.dto.d.SrvBoilDesInfoDTO;
import iih.bl.cg.ip.i.IExecuChargeService;
import iih.bl.cg.ip.i.IUsageWithBillService;
import iih.bl.cg.ip.s.bp.BoilDesWithBillBp;
import iih.bl.cg.ip.s.bp.UsageWithBillStrategyBp;

/**
 * 用法关联费用策略
 * note:该接口是针对用法关联费用过程中特殊项目无法单凭维护带入解决的情况。例如静脉滴注用法关联输液费，但一天内输入多组药，那输液费只能
 * 收取一次，这里是策略的叠加
 * @author yangyang 
 * @Date 2017-10-21 
 */
@Service(serviceInterfaces = { IUsageWithBillService.class }, binding = Binding.JSONRPC)
public class UsageWithBillServiceImpl implements IUsageWithBillService {

	@Override
	public PriUsgDO[] judgeUsageWithBillitm(String strIdRoute,String strIdOrg,String strIdDept) throws BizException {
		UsageWithBillStrategyBp handlerBp=new UsageWithBillStrategyBp();
		return handlerBp.exec(strIdRoute,strIdOrg,strIdDept);
	}

	@Override
	public BoilDesReferBillDTO[] getBoilDesRefbill(SrvBoilDesInfoDTO[] srvBoildesDtoArr) throws BizException {
		BoilDesWithBillBp handlerBp=new BoilDesWithBillBp();
		return handlerBp.exec(srvBoildesDtoArr);
	}

}
