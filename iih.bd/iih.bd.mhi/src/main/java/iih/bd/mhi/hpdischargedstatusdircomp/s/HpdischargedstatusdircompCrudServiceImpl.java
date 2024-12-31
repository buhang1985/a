package iih.bd.mhi.hpdischargedstatusdircomp.s;
import iih.bd.mhi.hpdischargedstatusdircomp.d.HpDischargedStatusDircompDO;
import iih.bd.mhi.hpdischargedstatusdircomp.d.desc.HpDischargedStatusDircompDODesc;
import iih.bd.mhi.hpdischargedstatusdircomp.i.IHpdischargedstatusdircompCudService;
import iih.bd.mhi.hpdischargedstatusdircomp.i.IHpdischargedstatusdircompRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 出院状态对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdischargedstatusdircompCudService.class,IHpdischargedstatusdircompRService.class}, binding=Binding.JSONRPC)
public class HpdischargedstatusdircompCrudServiceImpl extends BaseDOService<HpDischargedStatusDircompDO> implements IHpdischargedstatusdircompCudService,IHpdischargedstatusdircompRService {
    public HpdischargedstatusdircompCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDischargedStatusDircompDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
