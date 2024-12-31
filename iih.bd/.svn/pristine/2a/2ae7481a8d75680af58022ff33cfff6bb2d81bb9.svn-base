package iih.bd.fc.orpltpstamsp.s;
import java.util.Arrays;

import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstamsp.d.desc.OrpltpStaMapDODesc;
import iih.bd.fc.orpltpstamsp.i.IOrpltpstamspCudService;
import iih.bd.fc.orpltpstamsp.i.IOrpltpstamspRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医嘱闭环状态第三方厂商对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpstamspCudService.class,IOrpltpstamspRService.class}, binding=Binding.JSONRPC)
public class OrpltpstamspCrudServiceImpl extends BaseDOService<OrpltpStaMapDO> implements IOrpltpstamspCudService,IOrpltpstamspRService {
    public OrpltpstamspCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpStaMapDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    @Override
    protected Validator[] getInsertValidator() {
    	return new Validator[] { 
    			new BDUniqueRuleValidate(),
    			NullValueValidator.createMDNullValueValidator(new OrpltpStaMapDO().getDODesc(), Arrays.asList(OrpltpStaMapDO.ID_ORPLTPSTA,OrpltpStaMapDO.ID_MAP_ORG,OrpltpStaMapDO.ID_MAP_PRODUCT))
    	};
    }
    @Override
    protected Validator[] getUpdateValidator(OrpltpStaMapDO[] oldDOs) {
    	return new Validator[] { 
    			new BDUniqueRuleValidate(),
    			NullValueValidator.createMDNullValueValidator(new OrpltpStaMapDO().getDODesc(), Arrays.asList(OrpltpStaMapDO.ID_ORPLTPSTA,OrpltpStaMapDO.ID_MAP_ORG,OrpltpStaMapDO.ID_MAP_PRODUCT))
    	};
    }
}
