package iih.ci.rcm.catheter.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.catheter.d.desc.CatheterDODesc;
import iih.ci.rcm.catheter.d.CatheterDO;
import iih.ci.rcm.catheter.i.ICatheterCudService;
import iih.ci.rcm.catheter.i.ICatheterRService;


/**
 * ICU病例监测_导管AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICatheterCudService.class,ICatheterRService.class}, binding=Binding.JSONRPC)
public class CatheterCrudServiceImpl extends BaseDOService<CatheterDO> implements ICatheterCudService,ICatheterRService {
    public CatheterCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CatheterDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
