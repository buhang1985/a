package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.RelSrvTacticDO;
import iih.bd.srv.medsrv.d.desc.RelSrvTacticDODesc;
import iih.bd.srv.medsrv.i.IRelsrvtacticsCudService;
import iih.bd.srv.medsrv.i.IRelsrvtacticsRService;
import iih.bd.srv.medsrv.validate.RelsrvtacticsValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 关联服务策略AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IRelsrvtacticsCudService.class,IRelsrvtacticsRService.class}, binding=Binding.JSONRPC)
public class RelsrvtacticsCrudServiceImpl extends BaseDOService<RelSrvTacticDO> implements IRelsrvtacticsCudService,IRelsrvtacticsRService {

    public RelsrvtacticsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(RelSrvTacticDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { new BDUniqueRuleValidate(), new RelsrvtacticsValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(RelSrvTacticDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate(), new RelsrvtacticsValidate() };
    }
}

