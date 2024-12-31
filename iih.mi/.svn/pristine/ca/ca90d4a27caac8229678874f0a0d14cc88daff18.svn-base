package iih.mi.mc.mimcspec.s;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.d.desc.MiMcSpecDrugDODesc;
import iih.mi.mc.mimcspec.i.IMiMcSpecDrugDOCudService;
import iih.mi.mc.mimcspec.i.IMiMcSpecDrugDORService;
import iih.mi.mc.mimcspec.s.bp.MiMcSpecDrugCuBeforeBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 医保特殊病主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMiMcSpecDrugDOCudService.class,IMiMcSpecDrugDORService.class}, binding=Binding.JSONRPC)
public class MiMcSpecDrugDOCrudServiceImpl extends BaseDOService<MiMcSpecDrugDO> implements IMiMcSpecDrugDOCudService,IMiMcSpecDrugDORService {

    public MiMcSpecDrugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcSpecDrugDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
//    @Override
//	protected Validator[] getDeleteValidator() {
//		return new Validator[] {
//				BDReferenceChecker.getInstance()
//		};
//	}
//    
//    @Override
//    protected Validator[] getInsertValidator() {
//    	return new Validator[]{ new BDUniqueRuleValidate() };
//    }
//    
//    @Override
//    protected Validator[] getUpdateValidator(MiMcSpecDrugDO[] oldDOs) {
//    	return new Validator[]{ new BDUniqueRuleValidate() };
//    }
    @SuppressWarnings("unchecked")
    @Override
    protected void addInsertBeforeRule(AroundProcesser<MiMcSpecDrugDO> processer){
    	super.addInsertBeforeRule(processer);
    	processer.addBeforeRule(new IRule<MiMcSpecDrugDO>() {
			@Override
			public void process(MiMcSpecDrugDO... dos) throws BizException {
				for (MiMcSpecDrugDO miMcSpecDrugDO : dos) {
					
					processBeforeInsertOrUpdate(miMcSpecDrugDO);
				}
			}
    	});
    }
    
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MiMcSpecDrugDO> processer, MiMcSpecDrugDO[] originvos){
    	super.addUpdateBeforeRule(processer, originvos);
    	processer.addBeforeRule(new IRule<MiMcSpecDrugDO>() {
			@Override
			public void process(MiMcSpecDrugDO... dos) throws BizException {
				for (MiMcSpecDrugDO miMcSpecDrugDO : dos) {
					
					processBeforeInsertOrUpdate(miMcSpecDrugDO);
				}
			}
    	});
    }
	
    protected void processBeforeInsertOrUpdate(MiMcSpecDrugDO miMcSpecDrugDO) throws BizException{

    	MiMcSpecDrugCuBeforeBp bp = new MiMcSpecDrugCuBeforeBp();
    	bp.exec(miMcSpecDrugDO);
    }
}

