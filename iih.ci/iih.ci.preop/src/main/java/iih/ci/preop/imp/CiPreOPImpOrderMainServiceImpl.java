package iih.ci.preop.imp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.preop.imp.bp.ImportPreIpApplyItemBP;
import iih.ci.preop.imp.bp.OrderLoadBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 预住院申请导入预住院医嘱接口实现
 * 
 * @author mkp
 *
 */
@Service(serviceInterfaces = { ICiPreOPImpOrderMainService.class }, binding = Binding.JSONRPC)
public class CiPreOPImpOrderMainServiceImpl implements ICiPreOPImpOrderMainService {

    @Override
    public CiPreOPImpRst importApplyItem(String id_en_op, String id_en_pre, String id_dep_oper, String id_emp_oper,
            FDateTime dt_oper) throws BizException {
        return new ImportPreIpApplyItemBP().importByEnt(id_en_op, id_en_pre, id_dep_oper, id_emp_oper, dt_oper);
    }

    @Override
    public CiPreOPImpRst importApplyItemByTsIds(String id_en_pre, String[] tsOrIds) throws BizException {
        return new ImportPreIpApplyItemBP().importByTsIds(id_en_pre, tsOrIds);
    }

    @Override
    public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException {
        return new OrderRstDTO(FBoolean.TRUE,new OrderLoadBP().exec(ctx.getId_en(), ctx.getCode_entp()));
    }
}
