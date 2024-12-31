package iih.mi.mc.mimcspec.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mc.mimcspec.d.desc.MiMcSpecDODesc;
import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.i.IMimcspecMDOCudService;
import iih.mi.mc.mimcspec.i.IMimcspecMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医保特殊病主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMimcspecMDOCudService.class,IMimcspecMDORService.class}, binding=Binding.JSONRPC)
public class MimcspecMDOCrudServiceImpl extends BaseDOService<MiMcSpecDO> implements IMimcspecMDOCudService,IMimcspecMDORService {

    public MimcspecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcSpecDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(MiMcSpecDO[] oldDOs) {
    	return new Validator[]{ new BDUniqueRuleValidate() };
    }
    
    
}

