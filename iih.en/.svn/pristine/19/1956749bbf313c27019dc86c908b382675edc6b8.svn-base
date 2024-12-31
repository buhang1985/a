package iih.en.er.op.s;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.op.d.desc.EnEntOpErDODesc;
import iih.en.er.op.i.IEnentoperCudService;
import iih.en.er.op.i.IEnentoperRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 门诊_急诊AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnentoperCudService.class,IEnentoperRService.class}, binding=Binding.JSONRPC)
public class EnentoperCrudServiceImpl extends BaseDOService<EnEntOpErDO> implements IEnentoperCudService,IEnentoperRService {
    public EnentoperCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnEntOpErDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
