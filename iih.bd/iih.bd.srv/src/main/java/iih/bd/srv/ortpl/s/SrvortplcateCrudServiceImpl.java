package iih.bd.srv.ortpl.s;
import java.util.Arrays;

import iih.bd.srv.ortpl.d.OrTplCaDO;
import iih.bd.srv.ortpl.d.desc.OrTplCaDODesc;
import iih.bd.srv.ortpl.i.ISrvortplcateCudService;
import iih.bd.srv.ortpl.i.ISrvortplcateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 医嘱模板分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplcateCudService.class,ISrvortplcateRService.class}, binding=Binding.JSONRPC)
public class SrvortplcateCrudServiceImpl extends TreeBaseDOService<OrTplCaDO> implements ISrvortplcateCudService,ISrvortplcateRService {

    public SrvortplcateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrTplCaDODesc.class),IAppFwTempTbl.tmp_iaw_23.name()); 
    }

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { 
   				new BDUniqueRuleValidate(),
   				NullValueValidator.createMDNullValueValidator(new OrTplCaDO().getDODesc(), Arrays.asList(OrTplCaDO.NAME,OrTplCaDO.SD_SRVORRT))
   				};
	}

	@Override
	protected Validator[] getUpdateValidator(OrTplCaDO[] oldDOs) {
		return new Validator[] { 
   				new BDUniqueRuleValidate(),
   				NullValueValidator.createMDNullValueValidator(new OrTplCaDO().getDODesc(), Arrays.asList(OrTplCaDO.NAME,OrTplCaDO.SD_SRVORRT))
   				};

	}
    
}

