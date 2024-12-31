package iih.bd.mhi.hpadmstatusdircomp.s;
import iih.bd.mhi.hpadmstatusdircomp.d.HpAdmstatusDirCompDO;
import iih.bd.mhi.hpadmstatusdircomp.d.desc.HpAdmstatusDirCompDODesc;
import iih.bd.mhi.hpadmstatusdircomp.i.IHpadmstatusdircompCudService;
import iih.bd.mhi.hpadmstatusdircomp.i.IHpadmstatusdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 入院状态对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpadmstatusdircompCudService.class,IHpadmstatusdircompRService.class}, binding=Binding.JSONRPC)
public class HpadmstatusdircompCrudServiceImpl extends BaseDOService<HpAdmstatusDirCompDO> implements IHpadmstatusdircompCudService,IHpadmstatusdircompRService {
    public HpadmstatusdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpAdmstatusDirCompDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
