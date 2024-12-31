package iih.bd.srv.emrsourceprop.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.srv.emrsourceprop.d.desc.EmrSourcePropDODesc;
import iih.bd.srv.emrsourceprop.d.EmrSourcePropDO;
import iih.bd.srv.emrsourceprop.i.IEmrsourcepropCudService;
import iih.bd.srv.emrsourceprop.i.IEmrsourcepropRService;


/**
 * 病历(源+属性主表)AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmrsourcepropCudService.class,IEmrsourcepropRService.class}, binding=Binding.JSONRPC)
public class EmrsourcepropCrudServiceImpl extends BaseDOService<EmrSourcePropDO> implements IEmrsourcepropCudService,IEmrsourcepropRService {
    public EmrsourcepropCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrSourcePropDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
