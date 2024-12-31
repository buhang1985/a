package iih.mi.mibd.dosage.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.dosage.d.desc.DosageDODesc;
import iih.mi.mibd.dosage.d.DosageDO;
import iih.mi.mibd.dosage.i.IDosageCudService;
import iih.mi.mibd.dosage.i.IDosageRService;


/**
 * 医保平台_剂型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDosageCudService.class,IDosageRService.class}, binding=Binding.JSONRPC)
public class DosageCrudServiceImpl extends BaseDOService<DosageDO> implements IDosageCudService,IDosageRService {
    public DosageCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DosageDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    
    @Override
   	protected Validator[] getInsertValidator() {
   		return new Validator[] { new BDUniqueRuleValidate(), };
   	}

   	@Override
   	protected Validator[] getUpdateValidator(DosageDO[] oldDOs) {
   		return new Validator[] { new BDUniqueRuleValidate() };
   	}
   	@Override
   	protected Validator[] getDeleteValidator() {
   		return new Validator[] { BDReferenceChecker.getInstance() };
   	}
}
