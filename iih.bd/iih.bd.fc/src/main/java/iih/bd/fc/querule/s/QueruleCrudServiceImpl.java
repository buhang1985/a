package iih.bd.fc.querule.s;
import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.fc.querule.d.QueruleAggDO;
import iih.bd.fc.querule.d.desc.QueRuleDODesc;
import iih.bd.fc.querule.i.IQueruleCudService;
import iih.bd.fc.querule.i.IQueruleRService;
import iih.bd.fc.querule.s.validate.QueruleEuctrltpValidate;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 队列规则AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQueruleCudService.class,IQueruleRService.class}, binding=Binding.JSONRPC)
public class QueruleCrudServiceImpl extends BaseAggService<QueruleAggDO,QueRuleDO> implements IQueruleCudService,IQueruleRService {
    public QueruleCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(QueRuleDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] {new QueruleEuctrltpValidate() };
    }
    
    @Override
    protected Validator[] getUpdateValidator(QueruleAggDO[] oldDOs) {
    	return new Validator[] {new QueruleEuctrltpValidate() };
    }
}
