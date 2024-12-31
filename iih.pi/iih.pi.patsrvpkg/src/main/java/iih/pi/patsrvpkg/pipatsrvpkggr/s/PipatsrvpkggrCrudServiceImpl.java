package iih.pi.patsrvpkg.pipatsrvpkggr.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.patsrvpkg.pipatsrvpkggr.d.desc.PiPatSrvPkggrDODesc;
import iih.pi.patsrvpkg.pipatsrvpkggr.d.PiPatSrvPkggrDO;
import iih.pi.patsrvpkg.pipatsrvpkggr.i.IPipatsrvpkggrCudService;
import iih.pi.patsrvpkg.pipatsrvpkggr.i.IPipatsrvpkggrRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPipatsrvpkggrCudService.class,IPipatsrvpkggrRService.class}, binding=Binding.JSONRPC)
public class PipatsrvpkggrCrudServiceImpl extends BaseDOService<PiPatSrvPkggrDO> implements IPipatsrvpkggrCudService,IPipatsrvpkggrRService {
    public PipatsrvpkggrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatSrvPkggrDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
