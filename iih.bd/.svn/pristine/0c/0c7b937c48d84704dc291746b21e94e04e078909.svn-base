package iih.bd.srv.medsrv.s;
import java.util.Arrays;

import iih.bd.srv.medsrv.d.MedSrvAliasDO;
import iih.bd.srv.medsrv.d.desc.MedSrvAliasDODesc;
import iih.bd.srv.medsrv.i.IMedSrvAliasDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvAliasDORService;
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
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedSrvAliasDOCudService.class,IMedSrvAliasDORService.class}, binding=Binding.JSONRPC)
public class MedSrvAliasDOCrudServiceImpl extends BaseDOService<MedSrvAliasDO> implements IMedSrvAliasDOCudService,IMedSrvAliasDORService {

    public MedSrvAliasDOCrudServiceImpl() {
    	super(DescManager.getInstance().getDODesc(MedSrvAliasDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
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
				NullValueValidator.createMDNullValueValidator(new MedSrvAliasDO().getDODesc(), Arrays.asList(MedSrvAliasDO.ALIAS))

				};
		
}
	@Override
	protected Validator[] getUpdateValidator(MedSrvAliasDO[] oldDOs) {
		return new Validator[] { 
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(new MedSrvAliasDO().getDODesc(), Arrays.asList(MedSrvAliasDO.ALIAS))
				};

	}
}

