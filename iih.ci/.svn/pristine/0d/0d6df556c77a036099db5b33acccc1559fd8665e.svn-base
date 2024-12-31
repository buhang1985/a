package iih.ci.mrqc.concerndep.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.concerndep.d.desc.ConcernDepDODesc;
import iih.ci.mrqc.concerndep.d.ConcernDepDO;
import iih.ci.mrqc.concerndep.i.IConcerndepCudService;
import iih.ci.mrqc.concerndep.i.IConcerndepRService;


/**
 * 门诊质控科室关注AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConcerndepCudService.class,IConcerndepRService.class}, binding=Binding.JSONRPC)
public class ConcerndepCrudServiceImpl extends BaseDOService<ConcernDepDO> implements IConcerndepCudService,IConcerndepRService {
    public ConcerndepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConcernDepDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}
