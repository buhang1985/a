package iih.bd.fc.orpltpstafunc.s;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstafunc.d.desc.OrpltpStaFuncDODesc;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncCudService;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医嘱闭环状态功能触发对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpstafuncCudService.class,IOrpltpstafuncRService.class}, binding=Binding.JSONRPC)
public class OrpltpstafuncCrudServiceImpl extends BaseDOService<OrpltpStaFuncDO> implements IOrpltpstafuncCudService,IOrpltpstafuncRService {
    public OrpltpstafuncCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpStaFuncDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
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
	protected Validator[] getUpdateValidator(OrpltpStaFuncDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
