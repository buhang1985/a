package iih.bl.cg.blrefundaudit.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.cg.blrefundaudit.d.desc.BlRefundAuditDODesc;
import iih.bl.cg.blrefundaudit.d.BlRefundAuditDO;
import iih.bl.cg.blrefundaudit.i.IBlrefundauditCudService;
import iih.bl.cg.blrefundaudit.i.IBlrefundauditRService;


/**
 * 退费审核AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlrefundauditCudService.class,IBlrefundauditRService.class}, binding=Binding.JSONRPC)
public class BlrefundauditCrudServiceImpl extends BaseDOService<BlRefundAuditDO> implements IBlrefundauditCudService,IBlrefundauditRService {
    public BlrefundauditCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlRefundAuditDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}
