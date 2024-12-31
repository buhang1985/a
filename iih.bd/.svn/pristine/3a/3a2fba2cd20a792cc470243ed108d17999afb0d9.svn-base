package iih.bd.srv.nurmrtpl.s;
import iih.bd.srv.nurmrtpl.d.NurMrConTplDO;
import iih.bd.srv.nurmrtpl.d.desc.NurMrConTplDODesc;
import iih.bd.srv.nurmrtpl.i.INurmrtplCudService;
import iih.bd.srv.nurmrtpl.i.INurmrtplRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 护理记录内容模板AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={INurmrtplCudService.class,INurmrtplRService.class}, binding=Binding.JSONRPC)
public class NurmrtplCrudServiceImpl extends BaseDOService<NurMrConTplDO> implements INurmrtplCudService,INurmrtplRService {

    public NurmrtplCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(NurMrConTplDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}

