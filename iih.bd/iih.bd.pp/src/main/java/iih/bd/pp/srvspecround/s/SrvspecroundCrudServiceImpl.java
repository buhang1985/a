package iih.bd.pp.srvspecround.s;
import iih.bd.pp.srvspecround.d.SrvSpecRoundDO;
import iih.bd.pp.srvspecround.d.desc.SrvSpecRoundDODesc;
import iih.bd.pp.srvspecround.i.ISrvspecroundCudService;
import iih.bd.pp.srvspecround.i.ISrvspecroundRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 项目计费特殊取整方式AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvspecroundCudService.class,ISrvspecroundRService.class}, binding=Binding.JSONRPC)
public class SrvspecroundCrudServiceImpl extends BaseDOService<SrvSpecRoundDO> implements ISrvspecroundCudService,ISrvspecroundRService {
    public SrvspecroundCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvSpecRoundDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
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
	protected Validator[] getUpdateValidator(SrvSpecRoundDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
