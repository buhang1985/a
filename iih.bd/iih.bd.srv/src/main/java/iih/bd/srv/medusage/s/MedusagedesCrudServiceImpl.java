package iih.bd.srv.medusage.s;
import java.util.Arrays;

import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.d.desc.MedUsageDesDODesc;
import iih.bd.srv.medusage.i.IMedusagedesCudService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.bd.srv.medusage.validator.SrvReferenceValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医疗服务要求AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMedusagedesCudService.class,IMedusagedesRService.class}, binding=Binding.JSONRPC)
public class MedusagedesCrudServiceImpl extends BaseDOService<MedUsageDesDO> implements IMedusagedesCudService,IMedusagedesRService {

    public MedusagedesCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedUsageDesDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
	@Override
	protected Validator[] getInsertValidator() {
	//	 TODO Auto-generated method stub
		

		return new Validator[] { 
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(new MedUsageDesDO().getDODesc(), Arrays.asList(MedUsageDesDO.NAME,MedUsageDesDO.CODE))

				};
		
	}
//
	@Override
	protected Validator[] getUpdateValidator(MedUsageDesDO[] oldDOs) {
		
		return new Validator[] { 
				new BDUniqueRuleValidate(),
				new SrvReferenceValidator(),
				NullValueValidator.createMDNullValueValidator(new MedUsageDesDO().getDODesc(), Arrays.asList(MedUsageDesDO.NAME,MedUsageDesDO.CODE))
				};

	}
	
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
			
		};
	}
}

