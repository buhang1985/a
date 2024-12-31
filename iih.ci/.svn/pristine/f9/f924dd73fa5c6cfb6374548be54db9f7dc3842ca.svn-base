package iih.ci.mr.cimrbt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.cimrbt.d.desc.CiMrBtDODesc;
import iih.ci.mr.cimrbt.d.CiMrBtDO;
import iih.ci.mr.cimrbt.i.ICimrbtCudService;
import iih.ci.mr.cimrbt.i.ICimrbtRService;


/**
 * 病历业务分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrbtCudService.class,ICimrbtRService.class}, binding=Binding.JSONRPC)
public class CimrbtCrudServiceImpl extends BaseDOService<CiMrBtDO> implements ICimrbtCudService,ICimrbtRService {
    public CimrbtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrBtDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
