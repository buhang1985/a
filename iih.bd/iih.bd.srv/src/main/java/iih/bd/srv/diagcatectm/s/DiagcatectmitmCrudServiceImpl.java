package iih.bd.srv.diagcatectm.s;
import iih.bd.srv.diagcatectm.d.DiCaCtmItmDO;
import iih.bd.srv.diagcatectm.d.DiagcatectmitmAggDO;
import iih.bd.srv.diagcatectm.d.desc.DiCaCtmItmDODesc;
import iih.bd.srv.diagcatectm.i.IDiagcatectmitmCudService;
import iih.bd.srv.diagcatectm.i.IDiagcatectmitmRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 疾病诊断自定义分类项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDiagcatectmitmCudService.class,IDiagcatectmitmRService.class}, binding=Binding.JSONRPC)
public class DiagcatectmitmCrudServiceImpl extends BaseAggService<DiagcatectmitmAggDO,DiCaCtmItmDO> implements IDiagcatectmitmCudService,IDiagcatectmitmRService {
    public DiagcatectmitmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DiCaCtmItmDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DiagcatectmitmAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
