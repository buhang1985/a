package iih.bd.srv.ems.s;
import iih.bd.srv.ems.d.EmsDO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.d.desc.EmsDODesc;
import iih.bd.srv.ems.i.IEmsregistryCudService;
import iih.bd.srv.ems.i.IEmsregistryRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医疗单注册AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmsregistryCudService.class,IEmsregistryRService.class}, binding=Binding.JSONRPC)
public class EmsregistryCrudServiceImpl extends BaseAggService<EmsregistryAggDO,EmsDO> implements IEmsregistryCudService,IEmsregistryRService {
	public EmsregistryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmsDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
	}
	
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EmsregistryAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
