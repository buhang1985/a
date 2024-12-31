package iih.bd.srv.condi.s;
import iih.bd.srv.condi.d.ConDiDO;
import iih.bd.srv.condi.d.desc.ConDiDODesc;
import iih.bd.srv.condi.i.ICondiCudService;
import iih.bd.srv.condi.i.ICondiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 传染病对应诊断AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICondiCudService.class,ICondiRService.class}, binding=Binding.JSONRPC)
public class CondiCrudServiceImpl extends BaseDOService<ConDiDO> implements ICondiCudService,ICondiRService {
    public CondiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConDiDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}
