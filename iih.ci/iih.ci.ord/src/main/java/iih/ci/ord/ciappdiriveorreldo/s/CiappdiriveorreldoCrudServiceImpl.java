package iih.ci.ord.ciappdiriveorreldo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.ciappdiriveorreldo.d.desc.CiAppDiriveOrRelDODesc;
import iih.ci.ord.ciappdiriveorreldo.d.CiAppDiriveOrRelDO;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoCudService;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoRService;


/**
 * 管理单据派生医嘱关联关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiappdiriveorreldoCudService.class,ICiappdiriveorreldoRService.class}, binding=Binding.JSONRPC)
public class CiappdiriveorreldoCrudServiceImpl extends BaseDOService<CiAppDiriveOrRelDO> implements ICiappdiriveorreldoCudService,ICiappdiriveorreldoRService {
    public CiappdiriveorreldoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppDiriveOrRelDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
