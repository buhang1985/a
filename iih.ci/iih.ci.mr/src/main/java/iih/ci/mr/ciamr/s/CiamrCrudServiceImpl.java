package iih.ci.mr.ciamr.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.ciamr.d.desc.AMrDODesc;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiamrCudService.class,ICiamrRService.class}, binding=Binding.JSONRPC)
public class CiamrCrudServiceImpl extends BaseDOService<AMrDO> implements ICiamrCudService,ICiamrRService {
    public CiamrCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AMrDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
