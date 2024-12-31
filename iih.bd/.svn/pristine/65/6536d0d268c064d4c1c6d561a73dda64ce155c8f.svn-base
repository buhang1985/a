package iih.bd.pp.patcadup.s;
import iih.bd.pp.patcadup.d.BdPatcaDupItmPriDO;
import iih.bd.pp.patcadup.d.desc.BdPatcaDupItmPriDODesc;
import iih.bd.pp.patcadup.i.IPatcadupCudService;
import iih.bd.pp.patcadup.i.IPatcadupRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 患者分类重复收费项目AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPatcadupCudService.class,IPatcadupRService.class}, binding=Binding.JSONRPC)
public class PatcadupCrudServiceImpl extends BaseDOService<BdPatcaDupItmPriDO> implements IPatcadupCudService,IPatcadupRService {
    public PatcadupCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPatcaDupItmPriDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
    
    @Override
    protected Validator[] getUpdateValidator(BdPatcaDupItmPriDO[] oldDOs) {
    	return new Validator[]{new BDUniqueRuleValidate()};
    }
}
