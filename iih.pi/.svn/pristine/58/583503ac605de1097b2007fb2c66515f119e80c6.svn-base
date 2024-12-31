package iih.pi.patsrvpkg.patsrvpkg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.patsrvpkg.patsrvpkg.d.desc.PiPatSrvPkgDODesc;
import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import iih.pi.patsrvpkg.patsrvpkg.i.IPatsrvpkgCudService;
import iih.pi.patsrvpkg.patsrvpkg.i.IPatsrvpkgRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatsrvpkgCudService.class,IPatsrvpkgRService.class}, binding=Binding.JSONRPC)
public class PatsrvpkgCrudServiceImpl extends BaseDOService<PiPatSrvPkgDO> implements IPatsrvpkgCudService,IPatsrvpkgRService {

    public PatsrvpkgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatSrvPkgDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

