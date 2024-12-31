package iih.bd.res.usergrpdept.s;
import iih.bd.res.usergrpdept.d.UserGrpAndDeptDO;
import iih.bd.res.usergrpdept.d.desc.UserGrpAndDeptDODesc;
import iih.bd.res.usergrpdept.i.IUsergrpdeptCudService;
import iih.bd.res.usergrpdept.i.IUsergrpdeptRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 用户组和部门关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IUsergrpdeptCudService.class,IUsergrpdeptRService.class}, binding=Binding.JSONRPC)
public class UsergrpdeptCrudServiceImpl extends BaseDOService<UserGrpAndDeptDO> implements IUsergrpdeptCudService,IUsergrpdeptRService {

    public UsergrpdeptCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(UserGrpAndDeptDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

