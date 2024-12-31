package iih.en.pv.inpatient.s;
import iih.en.pv.inpatient.d.EntPatListDO;
import iih.en.pv.inpatient.d.desc.EntPatListDODesc;
import iih.en.pv.inpatient.i.IEntpatlistCudService;
import iih.en.pv.inpatient.i.IEntpatlistRService;

import java.util.Arrays;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 就诊患者列表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntpatlistCudService.class,IEntpatlistRService.class}, binding=Binding.JSONRPC)
public class EntpatlistCrudServiceImpl extends BaseDOService<EntPatListDO> implements IEntpatlistCudService,IEntpatlistRService {

    public EntpatlistCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntPatListDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] {
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(
						new EntPatListDO().getDODesc(),
						Arrays.asList(EntPatListDO.CODE, EntPatListDO.SORTNO)) };
    }
    
    @Override
    protected Validator[] getUpdateValidator(EntPatListDO[] oldDOs) {
    	return new Validator[] {
				new BDUniqueRuleValidate(),
				NullValueValidator.createMDNullValueValidator(
						new EntPatListDO().getDODesc(),
						Arrays.asList(EntPatListDO.CODE, EntPatListDO.SORTNO)) };
    }
}

