package iih.bd.pp.pripat.s;
import iih.bd.pp.pripat.d.PriPatSrvOrCaDO;
import iih.bd.pp.pripat.d.desc.PriPatSrvOrCaDODesc;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDOCudService;
import iih.bd.pp.pripat.i.IPriPatSrvOrCaDORService;
import iih.bd.pp.pripat.s.rule.PriPatSrvOrCaDOInsertBeforeRule;
import iih.bd.pp.pripat.s.validator.PriPatSrvOrCaInsertValidator;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 患者价格分类主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPriPatSrvOrCaDOCudService.class,IPriPatSrvOrCaDORService.class}, binding=Binding.JSONRPC)
public class PriPatSrvOrCaDOCrudServiceImpl extends BaseDOService<PriPatSrvOrCaDO> implements IPriPatSrvOrCaDOCudService,IPriPatSrvOrCaDORService {

    public PriPatSrvOrCaDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PriPatSrvOrCaDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{ new PriPatSrvOrCaInsertValidator() };
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertBeforeRule(AroundProcesser<PriPatSrvOrCaDO> processer) {
    	super.addInsertBeforeRule(processer);
    	processer.addBeforeRule(new PriPatSrvOrCaDOInsertBeforeRule());
    }
}

