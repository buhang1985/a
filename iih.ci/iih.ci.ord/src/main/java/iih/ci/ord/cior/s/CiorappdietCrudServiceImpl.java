package iih.ci.ord.cior.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.cior.d.desc.OrdApDietDODesc;
import iih.ci.ord.cior.d.OrdApDietDO;
import iih.ci.ord.cior.i.ICiorappdietCudService;
import iih.ci.ord.cior.i.ICiorappdietRService;


/**
 * 膳食医嘱申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiorappdietCudService.class,ICiorappdietRService.class}, binding=Binding.JSONRPC)
public class CiorappdietCrudServiceImpl extends BaseDOService<OrdApDietDO> implements ICiorappdietCudService,ICiorappdietRService {
    public CiorappdietCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrdApDietDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
