package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.enres.d.desc.EnDepDODesc;
import iih.en.pv.enres.i.IEndepCudService;
import iih.en.pv.enres.i.IEndepRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEndepCudService.class,IEndepRService.class}, binding=Binding.JSONRPC)
public class EndepCrudServiceImpl extends BaseDOService<EnDepDO> implements IEndepCudService,IEndepRService {

    public EndepCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnDepDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

