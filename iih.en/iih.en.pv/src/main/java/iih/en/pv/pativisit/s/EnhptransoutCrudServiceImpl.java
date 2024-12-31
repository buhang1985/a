package iih.en.pv.pativisit.s;
import iih.en.pv.pativisit.d.EnHpTransoutDO;
import iih.en.pv.pativisit.d.desc.EnHpTransoutDODesc;
import iih.en.pv.pativisit.i.IEnhptransoutCudService;
import iih.en.pv.pativisit.i.IEnhptransoutRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnhptransoutCudService.class,IEnhptransoutRService.class}, binding=Binding.JSONRPC)
public class EnhptransoutCrudServiceImpl extends BaseDOService<EnHpTransoutDO> implements IEnhptransoutCudService,IEnhptransoutRService {
    public EnhptransoutCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnHpTransoutDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
