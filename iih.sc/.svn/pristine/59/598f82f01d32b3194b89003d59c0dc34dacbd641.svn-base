package iih.sc.scbd.log.s;
import iih.sc.comm.rule.GrpOrgInitRule;
import iih.sc.scbd.log.d.ScLogSettingDO;
import iih.sc.scbd.log.d.desc.ScLogSettingDODesc;
import iih.sc.scbd.log.i.ISclogsettingCudService;
import iih.sc.scbd.log.i.ISclogsettingRService;
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
 * 日志设置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISclogsettingCudService.class,ISclogsettingRService.class}, binding=Binding.JSONRPC)
public class SclogsettingCrudServiceImpl extends BaseDOService<ScLogSettingDO> implements ISclogsettingCudService,ISclogsettingRService {

    public SclogsettingCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScLogSettingDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
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

