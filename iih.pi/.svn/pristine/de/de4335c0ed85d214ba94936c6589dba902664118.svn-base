package iih.pi.patsrvpkg.pipatsrvpkgitem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PiPatSrvPkgItmDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc.PiPatSrvPkgItmDODesc;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.PipatsrvpkgitemAggDO;
import iih.pi.patsrvpkg.pipatsrvpkgitem.i.IPipatsrvpkgitemCudService;
import iih.pi.patsrvpkg.pipatsrvpkgitem.i.IPipatsrvpkgitemRService;


/**
 * 患者服务包服务项目对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPipatsrvpkgitemCudService.class,IPipatsrvpkgitemRService.class}, binding=Binding.JSONRPC)
public class PipatsrvpkgitemCrudServiceImpl extends BaseAggService<PipatsrvpkgitemAggDO,PiPatSrvPkgItmDO> implements IPipatsrvpkgitemCudService,IPipatsrvpkgitemRService {
    public PipatsrvpkgitemCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatSrvPkgItmDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
