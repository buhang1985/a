package iih.bd.fc.mdwfor.s;

import iih.bd.fc.mdwfor.d.MdWfOrDO;
import iih.bd.fc.mdwfor.i.IMdwforQryRService;
import iih.bd.fc.mdwfor.s.bp.GetMdwforDosBP;
import iih.bd.fc.wforqry.d.WforQryCondDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医嘱流向开立参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMdwforQryRService.class}, binding=Binding.JSONRPC)

public class MdwforQryRServiceImpl implements IMdwforQryRService  {
	/**
	 * 根据医嘱开立查询条件获得医嘱开立表信息
	 * @param cond  医嘱开立查询条件DTO
	 * @return 医嘱开立信息
	 * @throws BizException
	 */
	@Override
	public  MdWfOrDO[] getMdwfOrDos(WforQryCondDTO cond)
		throws BizException {
		GetMdwforDosBP bp=new GetMdwforDosBP();
			return bp.exec(cond);
		}
		

}
