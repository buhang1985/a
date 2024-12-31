package iih.bd.pp.inccasplit.s;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import iih.bd.pp.inccasplit.d.desc.BdInccaSplitDODesc;
import iih.bd.pp.inccasplit.i.IInccasplitCudService;
import iih.bd.pp.inccasplit.i.IInccasplitRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 票据分票设置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IInccasplitCudService.class,IInccasplitRService.class}, binding=Binding.JSONRPC)
public class InccasplitCrudServiceImpl extends BaseDOService<BdInccaSplitDO> implements IInccasplitCudService,IInccasplitRService {
    public InccasplitCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdInccaSplitDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
