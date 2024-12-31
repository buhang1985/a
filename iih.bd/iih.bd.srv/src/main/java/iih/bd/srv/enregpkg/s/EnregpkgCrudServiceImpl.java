package iih.bd.srv.enregpkg.s;
import iih.bd.srv.enregpkg.d.SrvEnRegPkgDO;
import iih.bd.srv.enregpkg.d.desc.SrvEnRegPkgDODesc;
import iih.bd.srv.enregpkg.i.IEnregpkgCudService;
import iih.bd.srv.enregpkg.i.IEnregpkgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务就诊登记包AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnregpkgCudService.class,IEnregpkgRService.class}, binding=Binding.JSONRPC)
public class EnregpkgCrudServiceImpl extends BaseDOService<SrvEnRegPkgDO> implements IEnregpkgCudService,IEnregpkgRService {

    public EnregpkgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvEnRegPkgDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}

