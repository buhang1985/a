package iih.sc.att.sctaskexec.s;
import iih.sc.att.sctaskexec.d.SctaskexecDO;
import iih.sc.att.sctaskexec.d.desc.SctaskexecDODesc;
import iih.sc.att.sctaskexec.i.ISctaskexecCudService;
import iih.sc.att.sctaskexec.i.ISctaskexecRService;
import iih.sc.comm.rule.GrpOrgInitRule;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 考勤执行AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskexecCudService.class,ISctaskexecRService.class}, binding=Binding.JSONRPC)
public class SctaskexecCrudServiceImpl extends BaseDOService<SctaskexecDO> implements ISctaskexecCudService,ISctaskexecRService {

    public SctaskexecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SctaskexecDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }    
}

