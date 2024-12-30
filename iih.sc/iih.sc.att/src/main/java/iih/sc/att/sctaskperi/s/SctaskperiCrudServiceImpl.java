package iih.sc.att.sctaskperi.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.att.sctaskperi.d.desc.SctaskperiDODesc;
import iih.sc.att.sctaskperi.d.SctaskperiDO;
import iih.sc.att.sctaskperi.i.ISctaskperiCudService;
import iih.sc.att.sctaskperi.i.ISctaskperiRService;
import iih.sc.att.sctaskpl.d.ScTaskPlDO;
import iih.sc.comm.rule.GrpOrgInitRule;


/**
 * 考勤区间定义AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISctaskperiCudService.class,ISctaskperiRService.class}, binding=Binding.JSONRPC)
public class SctaskperiCrudServiceImpl extends BaseDOService<SctaskperiDO> implements ISctaskperiCudService,ISctaskperiRService {
    public SctaskperiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SctaskperiDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}

