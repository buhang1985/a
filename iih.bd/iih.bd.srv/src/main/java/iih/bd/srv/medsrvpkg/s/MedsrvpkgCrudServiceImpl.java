package iih.bd.srv.medsrvpkg.s;
import iih.bd.srv.medsrvpkg.d.MedSrvPkgDO;
import iih.bd.srv.medsrvpkg.d.MedsrvpkgAggDO;
import iih.bd.srv.medsrvpkg.d.desc.MedSrvPkgDODesc;
import iih.bd.srv.medsrvpkg.i.IMedsrvpkgCudService;
import iih.bd.srv.medsrvpkg.i.IMedsrvpkgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务包AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedsrvpkgCudService.class,IMedsrvpkgRService.class}, binding=Binding.JSONRPC)
public class MedsrvpkgCrudServiceImpl extends BaseAggService<MedsrvpkgAggDO,MedSrvPkgDO> implements IMedsrvpkgCudService,IMedsrvpkgRService {

    public MedsrvpkgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvPkgDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}

