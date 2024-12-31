package iih.bd.fc.enstate.s;
import iih.bd.fc.enstate.d.BdEnStateDO;
import iih.bd.fc.enstate.d.desc.BdEnStateDODesc;
import iih.bd.fc.enstate.i.IEnstateCudService;
import iih.bd.fc.enstate.i.IEnstateRService;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 就诊状况AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEnstateCudService.class,IEnstateRService.class}, binding=Binding.JSONRPC)
public class EnstateCrudServiceImpl extends BaseDOService<BdEnStateDO> implements IEnstateCudService,IEnstateRService {

    public EnstateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdEnStateDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
    public BdEnStateDO[] save(BdEnStateDO... dos) throws BizException {
    	// TODO Auto-generated method stub
    	for(BdEnStateDO stateDO: dos){
    		stateDO.setWbcode(CnToWB.getWBCode(stateDO.getName()));
    		stateDO.setMnecode(CnToPy.getPyFirstCode(stateDO.getName()));
    		stateDO.setPycode(CnToPy.getPyFirstCode(stateDO.getName()));
    	}
    	return super.save(dos);
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
	protected Validator[] getUpdateValidator(BdEnStateDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}

