package iih.bd.pp.prepayverifytp.s;
import iih.bd.pp.prepayverifytp.d.PrepayverifytpDO;
import iih.bd.pp.prepayverifytp.d.desc.PrepayverifytpDODesc;
import iih.bd.pp.prepayverifytp.i.IPrepayverifytpCudService;
import iih.bd.pp.prepayverifytp.i.IPrepayverifytpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 预交金支付身份校验类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPrepayverifytpCudService.class,IPrepayverifytpRService.class}, binding=Binding.JSONRPC)
public class PrepayverifytpCrudServiceImpl extends BaseDOService<PrepayverifytpDO> implements IPrepayverifytpCudService,IPrepayverifytpRService {
    public PrepayverifytpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PrepayverifytpDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
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
	protected Validator[] getUpdateValidator(PrepayverifytpDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
