package iih.bd.srv.chnmeddiseasesymptom.s;
import iih.bd.srv.chnmeddiseasesymptom.d.ChnmeddiseasesymptomDO;
import iih.bd.srv.chnmeddiseasesymptom.d.desc.ChnmeddiseasesymptomDODesc;
import iih.bd.srv.chnmeddiseasesymptom.i.IChnmeddiseasesymptomCudService;
import iih.bd.srv.chnmeddiseasesymptom.i.IChnmeddiseasesymptomRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 中医疾病症候关系AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IChnmeddiseasesymptomCudService.class,IChnmeddiseasesymptomRService.class}, binding=Binding.JSONRPC)
public class ChnmeddiseasesymptomCrudServiceImpl extends BaseDOService<ChnmeddiseasesymptomDO> implements IChnmeddiseasesymptomCudService,IChnmeddiseasesymptomRService {
    public ChnmeddiseasesymptomCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ChnmeddiseasesymptomDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
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
    protected Validator[] getUpdateValidator(ChnmeddiseasesymptomDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
}
