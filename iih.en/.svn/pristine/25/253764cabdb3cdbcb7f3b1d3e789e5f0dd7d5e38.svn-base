package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnOrgDO;
import iih.en.pv.enres.d.desc.EnOrgDODesc;
import iih.en.pv.enres.i.IEnorgCudService;
import iih.en.pv.enres.i.IEnorgRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnorgCudService.class,IEnorgRService.class}, binding=Binding.JSONRPC)
public class EnorgCrudServiceImpl extends BaseDOService<EnOrgDO> implements IEnorgCudService,IEnorgRService {

    public EnorgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnOrgDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
}

