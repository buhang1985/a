package iih.bd.srv.deptsrvlimit.s;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitItemDO;
import iih.bd.srv.deptsrvlimit.d.desc.DeptSrvLimitItemDODesc;
import iih.bd.srv.deptsrvlimit.i.IDeptSrvLimitItemDOCudService;
import iih.bd.srv.deptsrvlimit.i.IDeptSrvLimitItemDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 科室服务白黑名单主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDeptSrvLimitItemDOCudService.class,IDeptSrvLimitItemDORService.class}, binding=Binding.JSONRPC)
public class DeptSrvLimitItemDOCrudServiceImpl extends BaseDOService<DeptSrvLimitItemDO> implements IDeptSrvLimitItemDOCudService,IDeptSrvLimitItemDORService {

    public DeptSrvLimitItemDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DeptSrvLimitItemDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
}

