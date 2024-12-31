package iih.bd.srv.emrterm.s;
import iih.bd.srv.emrterm.d.EmrEtCompRelDO;
import iih.bd.srv.emrterm.d.desc.EmrEtCompRelDODesc;
import iih.bd.srv.emrterm.i.IEmretcomprelCudService;
import iih.bd.srv.emrterm.i.IEmretcomprelRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 病历辅助录入事件组件关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmretcomprelCudService.class,IEmretcomprelRService.class}, binding=Binding.JSONRPC)
public class EmretcomprelCrudServiceImpl extends BaseDOService<EmrEtCompRelDO> implements IEmretcomprelCudService,IEmretcomprelRService {
    public EmretcomprelCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrEtCompRelDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
}
