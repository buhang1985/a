package iih.ci.preip.imp;

import iih.ci.preip.imp.bp.ImportPreIPOrdersBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;

/**
 * 预住院医嘱导入为正式医嘱服务接口实现类
 * @author mkp
 *
 */
@Service(serviceInterfaces = { ICiPreIPImpOrderMainService.class }, binding = Binding.JSONRPC)
public class CiPreIPImpOrderMainServiceImpl implements ICiPreIPImpOrderMainService {

    @Override
    public CiPreIPImpRst importOrders(String id_en, FDateTime dt_acpt, FDateTime dt_oper, String id_dep_oper,
            String id_emp_oper) throws BizException {
        return new ImportPreIPOrdersBP().exec(id_en, dt_acpt, dt_oper, id_dep_oper, id_emp_oper);
    }

}
