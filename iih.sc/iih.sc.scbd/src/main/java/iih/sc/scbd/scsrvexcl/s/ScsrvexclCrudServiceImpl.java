package iih.sc.scbd.scsrvexcl.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.scsrvexcl.d.desc.ScSrvExclDODesc;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scsrvexcl.d.ScSrvExclDO;
import iih.sc.scbd.scsrvexcl.i.IScsrvexclCudService;
import iih.sc.scbd.scsrvexcl.i.IScsrvexclRService;


/**
 * 服务互斥AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScsrvexclCudService.class,IScsrvexclRService.class}, binding=Binding.JSONRPC)
public class ScsrvexclCrudServiceImpl extends BaseDOService<ScSrvExclDO> implements IScsrvexclCudService,IScsrvexclRService {
    public ScsrvexclCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSrvExclDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
