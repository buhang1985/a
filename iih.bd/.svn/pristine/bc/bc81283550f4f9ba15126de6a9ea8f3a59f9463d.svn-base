package iih.bd.srv.ortpl.s;
import iih.bd.srv.ortpl.d.RegularOrRelSrvDO;
import iih.bd.srv.ortpl.d.desc.RegularOrRelSrvDODesc;
import iih.bd.srv.ortpl.i.IRegularorrelsrvCudService;
import iih.bd.srv.ortpl.i.IRegularorrelsrvRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 常规医嘱关联服务AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRegularorrelsrvCudService.class,IRegularorrelsrvRService.class}, binding=Binding.JSONRPC)
public class RegularorrelsrvCrudServiceImpl extends BaseDOService<RegularOrRelSrvDO> implements IRegularorrelsrvCudService,IRegularorrelsrvRService {

    public RegularorrelsrvCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(RegularOrRelSrvDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

