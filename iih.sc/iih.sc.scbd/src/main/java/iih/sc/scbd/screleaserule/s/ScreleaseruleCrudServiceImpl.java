package iih.sc.scbd.screleaserule.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

import java.util.Arrays;

import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.sc.scbd.schedulechl.d.desc.ScChlPeriodDODesc;
import iih.sc.scbd.screleaserule.d.ScReleaseRuleDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.sc.scbd.screleaserule.d.desc.ScReleaseRuleDODesc;
import iih.sc.scbd.screleaserule.d.ScreleaseruleAggDO;
import iih.sc.scbd.screleaserule.i.IScreleaseruleCudService;
import iih.sc.scbd.screleaserule.i.IScreleaseruleRService;


/**
 * 排班释放规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IScreleaseruleCudService.class,IScreleaseruleRService.class}, binding=Binding.JSONRPC)
public class ScreleaseruleCrudServiceImpl extends BaseAggService<ScreleaseruleAggDO,ScReleaseRuleDO> implements IScreleaseruleCudService,IScreleaseruleRService {
    public ScreleaseruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScReleaseRuleDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { 
   				new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(ScreleaseruleAggDO[] oldDOs) {
    	return new Validator[] { 
   				new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
		return new Validator[] {
				AggBDReferenceChecker.getInstance(new String[]{ScReleaseRuleDODesc.TABLE_NAME},true,false)
			};
    }
    
}
