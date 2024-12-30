package iih.sc.scbd.scprtcfg.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.scprtcfg.d.desc.ScPrtCfgDODesc;
import iih.sc.scbd.scprtcfg.d.ScPrtCfgDO;
import iih.sc.scbd.scprtcfg.i.IScprtcfgCudService;
import iih.sc.scbd.scprtcfg.i.IScprtcfgRService;
import iih.sc.scbd.scprttmpl.d.ScPrtTmplDO;


/**
 * 打印模板项目配置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScprtcfgCudService.class,IScprtcfgRService.class}, binding=Binding.JSONRPC)
public class ScprtcfgCrudServiceImpl extends BaseDOService<ScPrtCfgDO> implements IScprtcfgCudService,IScprtcfgRService {
    public ScprtcfgCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScPrtCfgDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(ScPrtCfgDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
    
}
