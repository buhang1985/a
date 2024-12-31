package iih.bd.srv.oth.s;
import iih.bd.srv.oth.d.ExternFuncRegDO;
import iih.bd.srv.oth.d.desc.ExternFuncRegDODesc;
import iih.bd.srv.oth.i.IExternfuncregCudService;
import iih.bd.srv.oth.i.IExternfuncregRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 外挂函数注册AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IExternfuncregCudService.class,IExternfuncregRService.class}, binding=Binding.JSONRPC)
public class ExternfuncregCrudServiceImpl extends BaseDOService<ExternFuncRegDO> implements IExternfuncregCudService,IExternfuncregRService {
    public ExternfuncregCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ExternFuncRegDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
}

