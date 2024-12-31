package iih.bd.srv.s;

import iih.bd.srv.d.CostCheckDTO;
import iih.bd.srv.i.ICostCheckService;
import iih.bd.srv.s.bp.qry.GetCostCheckQry;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.utils.AppFwUtil;


@Service(serviceInterfaces={ICostCheckService.class}, binding=Binding.JSONRPC)
public class CostCheckServiceImpl implements ICostCheckService {

	@Override
	public CostCheckDTO[] getCostCheck(String id_srv) throws BizException {
		// TODO Auto-generated method stub
		GetCostCheckQry qry = new GetCostCheckQry(id_srv);
		CostCheckDTO[] costCheck = (CostCheckDTO[]) AppFwUtil.getDORstWithDao(qry, CostCheckDTO.class);
		return costCheck;
	}

}
