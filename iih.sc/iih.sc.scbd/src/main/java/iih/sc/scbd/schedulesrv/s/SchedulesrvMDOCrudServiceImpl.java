package iih.sc.scbd.schedulesrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.schedulesrv.d.desc.ScheduleSrvDODesc;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.SchedulesrvAggDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDOCudService;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISchedulesrvMDOCudService.class,ISchedulesrvMDORService.class}, binding=Binding.JSONRPC)
public class SchedulesrvMDOCrudServiceImpl extends TreeBaseDOService<ScheduleSrvDO> implements ISchedulesrvMDOCudService,ISchedulesrvMDORService {

	
	
    public SchedulesrvMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScheduleSrvDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    /**
     * 删除校验规则
     */
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

