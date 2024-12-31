package iih.bd.srv.srvpkggrpitm.s;
import iih.bd.srv.srvpkggrpitm.d.SrvPkgItmDO;
import iih.bd.srv.srvpkggrpitm.d.SrvpkggrpitmAggDO;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvPkgItmDODesc;
import iih.bd.srv.srvpkggrpitm.i.ISrvpkggrpitmCudService;
import iih.bd.srv.srvpkggrpitm.i.ISrvpkggrpitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务包分组项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvpkggrpitmCudService.class,ISrvpkggrpitmRService.class}, binding=Binding.JSONRPC)
public class SrvpkggrpitmCrudServiceImpl extends BaseAggService<SrvpkggrpitmAggDO,SrvPkgItmDO> implements ISrvpkggrpitmCudService,ISrvpkggrpitmRService {

    public SrvpkggrpitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgItmDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}

