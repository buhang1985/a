package iih.bd.cmp.marplanca.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.cmp.marplanca.d.desc.MarPlanCaDODesc;

import java.util.Arrays;

import iih.bd.cmp.marplan.d.BdCmpMarPlanDO;
import iih.bd.cmp.marplanca.d.MarPlanCaDO;
import iih.bd.cmp.marplanca.i.IMarplancaCudService;
import iih.bd.cmp.marplanca.i.IMarplancaRService;


/**
 * 营销方案分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMarplancaCudService.class,IMarplancaRService.class}, binding=Binding.JSONRPC)
public class MarplancaCrudServiceImpl extends BaseDOService<MarPlanCaDO> implements IMarplancaCudService,IMarplancaRService {
    public MarplancaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MarPlanCaDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
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
        				NullValueValidator.createMDNullValueValidator(new MarPlanCaDO().getDODesc(), Arrays.asList(MarPlanCaDO.NAME,MarPlanCaDO.CODE))
        				};
     	}

     	@Override
     	protected Validator[] getUpdateValidator(MarPlanCaDO[] oldDOs) {
     		return new Validator[] { 
        				new BDUniqueRuleValidate(),
        				NullValueValidator.createMDNullValueValidator(new MarPlanCaDO().getDODesc(), Arrays.asList(MarPlanCaDO.NAME,MarPlanCaDO.CODE))
        				};
     	}

}
