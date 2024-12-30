package iih.sc.scbd.schedulechl.s;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.d.desc.SchedulechlDODesc;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDOCudService;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 排班预约渠道主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISchedulechlMDOCudService.class,ISchedulechlMDORService.class}, binding=Binding.JSONRPC)
public class SchedulechlMDOCrudServiceImpl extends BaseDOService<SchedulechlDO> implements ISchedulechlMDOCudService,ISchedulechlMDORService {

    public SchedulechlMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SchedulechlDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

