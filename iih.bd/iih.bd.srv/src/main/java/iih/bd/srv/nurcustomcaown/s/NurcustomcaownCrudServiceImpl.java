package iih.bd.srv.nurcustomcaown.s;
import iih.bd.srv.nurcustomcaown.d.NuOwnDO;
import iih.bd.srv.nurcustomcaown.d.desc.NuOwnDODesc;
import iih.bd.srv.nurcustomcaown.i.INurcustomcaownCudService;
import iih.bd.srv.nurcustomcaown.i.INurcustomcaownRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录_护理文书所属AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={INurcustomcaownCudService.class,INurcustomcaownRService.class}, binding=Binding.JSONRPC)
public class NurcustomcaownCrudServiceImpl extends BaseDOService<NuOwnDO> implements INurcustomcaownCudService,INurcustomcaownRService {
    public NurcustomcaownCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NuOwnDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
