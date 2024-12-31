package iih.en.pv.enres.s;
import iih.en.pv.enres.d.EnAuthDO;
import iih.en.pv.enres.d.desc.EnAuthDODesc;
import iih.en.pv.enres.i.IEnauthCudService;
import iih.en.pv.enres.i.IEnauthRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者授权AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnauthCudService.class,IEnauthRService.class}, binding=Binding.JSONRPC)
public class EnauthCrudServiceImpl extends BaseDOService<EnAuthDO> implements IEnauthCudService,IEnauthRService {
    public EnauthCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnAuthDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
}
