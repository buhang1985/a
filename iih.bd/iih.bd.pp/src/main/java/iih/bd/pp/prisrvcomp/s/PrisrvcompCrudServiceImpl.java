package iih.bd.pp.prisrvcomp.s;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.d.desc.PriSrvCompDODesc;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompCudService;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPrisrvcompCudService.class,IPrisrvcompRService.class}, binding=Binding.JSONRPC)
public class PrisrvcompCrudServiceImpl extends BaseDOService<PriSrvCompDO> implements IPrisrvcompCudService,IPrisrvcompRService {

    public PrisrvcompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PriSrvCompDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}

