package iih.bd.res.dayslot.s;
import iih.bd.res.dayslot.d.DaysLotTimeDO;
import iih.bd.res.dayslot.d.desc.DaysLotTimeDODesc;
import iih.bd.res.dayslot.i.IDaysLotTimeDOCudService;
import iih.bd.res.dayslot.i.IDaysLotTimeDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 日期分组主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDaysLotTimeDOCudService.class,IDaysLotTimeDORService.class}, binding=Binding.JSONRPC)
public class DaysLotTimeDOCrudServiceImpl extends BaseDOService<DaysLotTimeDO> implements IDaysLotTimeDOCudService,IDaysLotTimeDORService {

    public DaysLotTimeDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DaysLotTimeDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
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
	protected Validator[] getUpdateValidator(DaysLotTimeDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}

