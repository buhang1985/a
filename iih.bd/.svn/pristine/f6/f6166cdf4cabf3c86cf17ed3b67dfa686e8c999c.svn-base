package iih.bd.srv.mrmtype.s;
import iih.bd.srv.mrmtype.d.MrmTypeDO;
import iih.bd.srv.mrmtype.d.MrmtypeAggDO;
import iih.bd.srv.mrmtype.d.desc.MrmTypeDODesc;
import iih.bd.srv.mrmtype.i.IMrmtypeCudService;
import iih.bd.srv.mrmtype.i.IMrmtypeRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 病案分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrmtypeCudService.class,IMrmtypeRService.class}, binding=Binding.JSONRPC)
public class MrmtypeCrudServiceImpl extends BaseAggService<MrmtypeAggDO,MrmTypeDO> implements IMrmtypeCudService,IMrmtypeRService {
    public MrmtypeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrmTypeDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
    protected Validator[] getDeleteValidator() {
    	return new Validator[] { AggBDReferenceChecker.getInstance() };
}
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(MrmtypeAggDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
}
