package iih.mi.mibd.didircomp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.didircomp.d.desc.DidircompDODesc;
import iih.mi.mibd.didircomp.d.DidircompDO;
import iih.mi.mibd.didircomp.i.IDidircompCudService;
import iih.mi.mibd.didircomp.i.IDidircompRService;


/**
 * 医保平台_病种对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDidircompCudService.class,IDidircompRService.class}, binding=Binding.JSONRPC)
public class DidircompCrudServiceImpl extends BaseDOService<DidircompDO> implements IDidircompCudService,IDidircompRService {
    public DidircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DidircompDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}
