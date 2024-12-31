package iih.bd.srv.emrterm.s;
import iih.bd.srv.emrterm.d.EmrTermCaDO;
import iih.bd.srv.emrterm.d.EmrtermcaAggDO;
import iih.bd.srv.emrterm.d.desc.EmrTermCaDODesc;
import iih.bd.srv.emrterm.i.IEmrtermcaCudService;
import iih.bd.srv.emrterm.i.IEmrtermcaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 病历术语分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEmrtermcaCudService.class,IEmrtermcaRService.class}, binding=Binding.JSONRPC)
public class EmrtermcaCrudServiceImpl extends BaseAggService<EmrtermcaAggDO,EmrTermCaDO> implements IEmrtermcaCudService,IEmrtermcaRService {
    public EmrtermcaCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrTermCaDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
    
	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(EmrtermcaAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { AggBDReferenceChecker.getInstance() };
	}
}
