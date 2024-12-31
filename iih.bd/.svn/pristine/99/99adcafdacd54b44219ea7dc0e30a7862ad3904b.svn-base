package iih.bd.srv.mrctmca.s;

import iih.bd.srv.mrctmca.d.MrCtmCaDO;
import iih.bd.srv.mrctmca.d.desc.MrCtmCaDODesc;
import iih.bd.srv.mrctmca.i.IMrctmcaMDOCudService;
import iih.bd.srv.mrctmca.i.IMrctmcaMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗记录类型自定义分类主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrctmcaMDOCudService.class,IMrctmcaMDORService.class}, binding=Binding.JSONRPC)
public class MrctmcaMDOCrudServiceImpl extends TreeBaseDOService<MrCtmCaDO> implements IMrctmcaMDOCudService,IMrctmcaMDORService {

    public MrctmcaMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrCtmCaDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(MrCtmCaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
