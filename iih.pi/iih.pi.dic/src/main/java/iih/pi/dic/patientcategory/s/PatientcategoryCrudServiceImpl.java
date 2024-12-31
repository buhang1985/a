package iih.pi.dic.patientcategory.s;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import iih.pi.dic.patientcategory.i.IPatientcategoryCudService;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.dic.patientcategory.s.bp.PatCateHpDeleteBP;
import iih.pi.dic.patientcategory.s.bp.PatCateHpInsertBP;
import iih.pi.dic.patientcategory.s.bp.PatCateHpQryBP;
import iih.pi.dic.patientcategory.s.bp.PatCateHpUpdateBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;


/**
 * 患者分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatientcategoryCudService.class,IPatientcategoryRService.class}, binding=Binding.JSONRPC)
public class PatientcategoryCrudServiceImpl extends TreeBaseDOService<PiPatCaDO> implements IPatientcategoryCudService,IPatientcategoryRService {

    public PatientcategoryCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCaDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
  	protected Validator[] getDeleteValidator() {
  		return new Validator[] {
  				BDReferenceChecker.getInstance(new String[]{"pi_pat_ca_hp"})
  		};
  	}
    
    @Override
    public PiPatCaDO[] findByIds(String[] ids, FBoolean isLazy)
    		throws BizException {
    	
    	PiPatCaDO[] result = super.findByIds(ids, isLazy);
    	
    	PatCateHpQryBP hpQryBp = new PatCateHpQryBP();
    	hpQryBp.exec(result);
    	
    	return result;
    }
    
    @Override
    public PiPatCaDO[] find(String whereStr, String orderStr, FBoolean isLazy)
    		throws BizException {
    	PiPatCaDO[] result = super.find(whereStr, orderStr, isLazy);
    	
    	PatCateHpQryBP hpQryBp = new PatCateHpQryBP();
    	hpQryBp.exec(result);
    	
    	return result;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addInsertAfterRule(AroundProcesser<PiPatCaDO> processor) {
    	super.addInsertAfterRule(processor);
    	processor.addAfterRule(new IRule<PiPatCaDO>() {
    		@Override
			public void process(PiPatCaDO... dos) throws BizException{
    			
    			PatCateHpInsertBP insertBp = new PatCateHpInsertBP();
    			for (PiPatCaDO piPatCaDO : dos) {
    				insertBp.exec(piPatCaDO);
				}
    		}
    	});
    }
    
    @Override
    protected void addUpdateAfterRule(
    		CompareAroundProcesser<PiPatCaDO> processor, PiPatCaDO[] originvos) {
    	super.addUpdateAfterRule(processor, originvos);
    	
    	processor.addAfterRule(new IRule<PiPatCaDO>() {
			@Override
			public void process(PiPatCaDO... dos) throws BizException {
				PatCateHpInsertBP insertBp = new PatCateHpInsertBP();
				PatCateHpUpdateBP updateBp = new PatCateHpUpdateBP();
				
				for (PiPatCaDO piPatCaDO : dos) {
					if(StringUtil.isEmpty(piPatCaDO.getId_patcahp())){
						insertBp.exec(piPatCaDO);
					}else{
						updateBp.exec(piPatCaDO);
					}
				}
			}
    	});
    }
    
    @SuppressWarnings("unchecked")
	@Override
    protected void addRealDeleteAfterRule(AroundProcesser<PiPatCaDO> processor) {
    	super.addRealDeleteAfterRule(processor);
    	
    	processor.addAfterRule(new IRule<PiPatCaDO>() {
			@Override
			public void process(PiPatCaDO... dos) throws BizException {
				PatCateHpDeleteBP deleteBp = new PatCateHpDeleteBP();
				
				for (PiPatCaDO piPatCaDO : dos) {
					if(!StringUtil.isEmpty(piPatCaDO.getId_patcahp())){
						deleteBp.exec(piPatCaDO);
					}
				}
			}
    	});
    }
}

