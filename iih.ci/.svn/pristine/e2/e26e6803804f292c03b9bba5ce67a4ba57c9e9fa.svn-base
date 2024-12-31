package iih.ci.mrqc.concernemp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.concernemp.d.desc.ConcernEmpDODesc;
import iih.ci.mrqc.concernemp.d.ConcernEmpDO;
import iih.ci.mrqc.concernemp.i.IConcernempCudService;
import iih.ci.mrqc.concernemp.i.IConcernempRService;


/**
 * 门诊质控人员关注AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConcernempCudService.class,IConcernempRService.class}, binding=Binding.JSONRPC)
public class ConcernempCrudServiceImpl extends BaseDOService<ConcernEmpDO> implements IConcernempCudService,IConcernempRService {
    public ConcernempCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConcernEmpDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
