package iih.bd.cmp.marplan.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.cmp.marplan.d.desc.BdCmpMarPlanDODesc;

import java.util.Arrays;

import iih.bd.cmp.marplan.d.BdCmpMarPlanDO;
import iih.bd.cmp.marplan.i.IMarplanMDOCudService;
import iih.bd.cmp.marplan.i.IMarplanMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 营销方案主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMarplanMDOCudService.class,IMarplanMDORService.class}, binding=Binding.JSONRPC)
public class MarplanMDOCrudServiceImpl extends BaseDOService<BdCmpMarPlanDO> implements IMarplanMDOCudService,IMarplanMDORService {

    public MarplanMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdCmpMarPlanDODesc.class),IAppFwTempTbl.tmp_iaw_12.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
   	protected Validator[] getInsertValidator() {
   		return new Validator[] { 
      				new BDUniqueRuleValidate(),
      				NullValueValidator.createMDNullValueValidator(new BdCmpMarPlanDO().getDODesc(), Arrays.asList(BdCmpMarPlanDO.NAME,BdCmpMarPlanDO.CODE))
      				};
   	}

   	@Override
   	protected Validator[] getUpdateValidator(BdCmpMarPlanDO[] oldDOs) {
   		return new Validator[] { 
      				new BDUniqueRuleValidate(),
      				NullValueValidator.createMDNullValueValidator(new BdCmpMarPlanDO().getDODesc(), Arrays.asList(BdCmpMarPlanDO.NAME,BdCmpMarPlanDO.CODE))
      				};
   	}

}

