package iih.bd.srv.srvpkg.s;
import iih.bd.srv.srvpkg.d.SrvPkgDO;
import iih.bd.srv.srvpkg.d.SrvpkgAggDO;
import iih.bd.srv.srvpkg.d.desc.SrvPkgDODesc;
import iih.bd.srv.srvpkg.i.ISrvpkgCudService;
import iih.bd.srv.srvpkg.i.ISrvpkgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务包AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvpkgCudService.class,ISrvpkgRService.class}, binding=Binding.JSONRPC)
public class SrvpkgCrudServiceImpl extends BaseAggService<SrvpkgAggDO,SrvPkgDO> implements ISrvpkgCudService,ISrvpkgRService {

    public SrvpkgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvPkgDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}

