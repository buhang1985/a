package iih.bd.srv.diagstaca.s;
import iih.bd.srv.diagstaca.d.DiagStacaDO;
import iih.bd.srv.diagstaca.d.desc.DiagStacaDODesc;
import iih.bd.srv.diagstaca.i.IDiagstacaCudService;
import iih.bd.srv.diagstaca.i.IDiagstacaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDiagstacaCudService.class,IDiagstacaRService.class}, binding=Binding.JSONRPC)
public class DiagstacaCrudServiceImpl extends TreeBaseDOService<DiagStacaDO> implements IDiagstacaCudService,IDiagstacaRService {

    public DiagstacaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DiagStacaDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(DiagStacaDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate()};
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
