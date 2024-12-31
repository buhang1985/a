package iih.bd.srv.scanformat.s;
import iih.bd.srv.scanformat.d.ScanFormatDO;
import iih.bd.srv.scanformat.d.desc.ScanFormatDODesc;
import iih.bd.srv.scanformat.i.IScanformatCudService;
import iih.bd.srv.scanformat.i.IScanformatRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 扫描格式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScanformatCudService.class,IScanformatRService.class}, binding=Binding.JSONRPC)
public class ScanformatCrudServiceImpl extends BaseDOService<ScanFormatDO> implements IScanformatCudService,IScanformatRService {
    public ScanformatCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScanFormatDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(ScanFormatDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { BDReferenceChecker.getInstance() };
    }
}
