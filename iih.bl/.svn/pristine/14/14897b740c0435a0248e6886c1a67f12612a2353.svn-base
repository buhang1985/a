package iih.bl.hp.hppatblacklist.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.bl.hp.hppatblacklist.d.desc.HpPatBlackListDODesc;
import iih.bl.hp.hppatblacklist.d.HpPatBlackListDO;
import iih.bl.hp.hppatblacklist.i.IHppatblacklistCudService;
import iih.bl.hp.hppatblacklist.i.IHppatblacklistRService;


/**
 * 医保患者黑名单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHppatblacklistCudService.class,IHppatblacklistRService.class}, binding=Binding.JSONRPC)
public class HppatblacklistCrudServiceImpl extends BaseDOService<HpPatBlackListDO> implements IHppatblacklistCudService,IHppatblacklistRService {
    public HppatblacklistCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpPatBlackListDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(HpPatBlackListDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}
}
