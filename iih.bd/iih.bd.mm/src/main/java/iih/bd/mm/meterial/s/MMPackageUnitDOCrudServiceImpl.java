package iih.bd.mm.meterial.s;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.desc.MMPackageUnitDODesc;
import iih.bd.mm.meterial.i.IMMPackageUnitDOCudService;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.meterial.s.ds.MaterialCache;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗物品主实体CRUD服务实现
 */
public class MMPackageUnitDOCrudServiceImpl extends BaseDOService<MMPackageUnitDO> implements IMMPackageUnitDOCudService,IMMPackageUnitDORService {

    public MMPackageUnitDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MMPackageUnitDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
    
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<MMPackageUnitDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new IRule<MMPackageUnitDO>() {
			@Override
			public void process(MMPackageUnitDO... dos) throws BizException {
				for (MMPackageUnitDO mmPkgDO : dos) {
					processAfterInsertOrUpdate(mmPkgDO);
				}
			}
		});
	}

	@Override
	protected void addUpdateAfterRule(CompareAroundProcesser<MMPackageUnitDO> processer, MMPackageUnitDO[] originvos) {
		super.addUpdateAfterRule(processer, originvos);
		processer.addAfterRule(new IRule<MMPackageUnitDO>() {
			@Override
			public void process(MMPackageUnitDO... dos) throws BizException {
				for (MMPackageUnitDO mmPkgDO : dos) {
					processAfterInsertOrUpdate(mmPkgDO);
				}
			}
		});
	}
	
	private void processAfterInsertOrUpdate(MMPackageUnitDO mmPkgDO) throws BizException {
		MaterialCache.getInstance().updateMmPkgInfo(new MMPackageUnitDO[]{mmPkgDO});
	}
}

