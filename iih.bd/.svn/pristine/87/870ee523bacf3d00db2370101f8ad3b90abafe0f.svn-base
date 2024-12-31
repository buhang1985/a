package iih.bd.mm.mmgrp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.mm.mmgrp.d.desc.MmGrpDODesc;
import iih.bd.mm.mmgrp.d.MmGrpDO;
import iih.bd.mm.mmgrp.i.IMmgrpCudService;
import iih.bd.mm.mmgrp.i.IMmgrpRService;


/**
 * 物品分组AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMmgrpCudService.class,IMmgrpRService.class}, binding=Binding.JSONRPC)
public class MmgrpCrudServiceImpl extends BaseDOService<MmGrpDO> implements IMmgrpCudService,IMmgrpRService {
    public MmgrpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MmGrpDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
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
    protected Validator[] getUpdateValidator(MmGrpDO[] oldDOs) {
    	return new Validator[] { new BDUniqueRuleValidate() };
    }
}
