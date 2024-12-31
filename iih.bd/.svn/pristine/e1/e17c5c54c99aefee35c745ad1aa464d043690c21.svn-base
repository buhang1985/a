package iih.bd.mhi.hpregion.s;
import iih.bd.mhi.hpregion.d.HpRegionDO;
import iih.bd.mhi.hpregion.d.desc.HpRegionDODesc;
import iih.bd.mhi.hpregion.i.IHpregionCudService;
import iih.bd.mhi.hpregion.i.IHpregionRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医保产品_地区目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpregionCudService.class,IHpregionRService.class}, binding=Binding.JSONRPC)
public class HpregionCrudServiceImpl extends BaseDOService<HpRegionDO> implements IHpregionCudService,IHpregionRService {
    public HpregionCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpRegionDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
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
	protected Validator[] getUpdateValidator(HpRegionDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
