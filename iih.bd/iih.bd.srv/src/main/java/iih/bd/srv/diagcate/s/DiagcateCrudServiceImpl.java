package iih.bd.srv.diagcate.s;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.d.DiagcateAggDO;
import iih.bd.srv.diagcate.d.desc.DiagCateDODesc;
import iih.bd.srv.diagcate.i.IDiagcateCudService;
import iih.bd.srv.diagcate.i.IDiagcateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 疾病诊断分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDiagcateCudService.class,IDiagcateRService.class}, binding=Binding.JSONRPC)
public class DiagcateCrudServiceImpl extends BaseAggService<DiagcateAggDO,DiagCateDO> implements IDiagcateCudService,IDiagcateRService {

    public DiagcateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DiagCateDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(DiagcateAggDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
    }
}

