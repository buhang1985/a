package iih.ci.rcm.conpastreport.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.conpastreport.d.desc.ConPastReportDODesc;
import iih.ci.rcm.conpastreport.d.ConPastReportDO;
import iih.ci.rcm.conpastreport.i.IConpastreportCudService;
import iih.ci.rcm.conpastreport.i.IConpastreportRService;


/**
 * 既往已报AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConpastreportCudService.class,IConpastreportRService.class}, binding=Binding.JSONRPC)
public class ConpastreportCrudServiceImpl extends BaseDOService<ConPastReportDO> implements IConpastreportCudService,IConpastreportRService {
    public ConpastreportCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ConPastReportDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}
