package iih.en.pv.enflw.s;
import iih.en.pv.enflw.d.EnFlwDO;
import iih.en.pv.enflw.d.desc.EnFlwDODesc;
import iih.en.pv.enflw.i.IEnflwCudService;
import iih.en.pv.enflw.i.IEnflwRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 关注医生AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnflwCudService.class,IEnflwRService.class}, binding=Binding.JSONRPC)
public class EnflwCrudServiceImpl extends BaseDOService<EnFlwDO> implements IEnflwCudService,IEnflwRService {
    public EnflwCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EnFlwDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
