package iih.sc.att.sctaskexecemp.s;
import iih.sc.att.sctaskexecemp.d.ScTaskExecEmpDO;
import iih.sc.att.sctaskexecemp.d.desc.ScTaskExecEmpDODesc;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempCudService;
import iih.sc.att.sctaskexecemp.i.ISctaskexecempRService;
import iih.sc.comm.rule.GrpOrgInitRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskexecempCudService.class,ISctaskexecempRService.class}, binding=Binding.JSONRPC)
public class SctaskexecempCrudServiceImpl extends BaseDOService<ScTaskExecEmpDO> implements ISctaskexecempCudService,ISctaskexecempRService {

    public SctaskexecempCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScTaskExecEmpDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}

