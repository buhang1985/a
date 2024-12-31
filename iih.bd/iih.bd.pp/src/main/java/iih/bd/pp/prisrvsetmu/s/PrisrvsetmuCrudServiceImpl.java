package iih.bd.pp.prisrvsetmu.s;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import iih.bd.pp.prisrvsetmu.d.desc.PriSrvSetMuDODesc;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuCudService;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 服务套数量加收AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPrisrvsetmuCudService.class,IPrisrvsetmuRService.class}, binding=Binding.JSONRPC)
public class PrisrvsetmuCrudServiceImpl extends BaseDOService<PriSrvSetMuDO> implements IPrisrvsetmuCudService,IPrisrvsetmuRService {

    public PrisrvsetmuCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PriSrvSetMuDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}

