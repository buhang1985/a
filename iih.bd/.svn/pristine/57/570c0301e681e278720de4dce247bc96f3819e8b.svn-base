package iih.bd.bc.medterm.s;
import java.util.Arrays;

import iih.bd.bc.medterm.d.SampCollectTimeDictDO;
import iih.bd.bc.medterm.d.desc.SampCollectTimeDictDODesc;
import iih.bd.bc.medterm.i.ISampcoltimedictCudService;
import iih.bd.bc.medterm.i.ISampcoltimedictRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.bdfw.validator.NullValueValidator;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 标本采集时间AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISampcoltimedictCudService.class,ISampcoltimedictRService.class}, binding=Binding.JSONRPC)
public class SampcoltimedictCrudServiceImpl extends BaseDOService<SampCollectTimeDictDO> implements ISampcoltimedictCudService,ISampcoltimedictRService {
    public SampcoltimedictCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SampCollectTimeDictDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { 
   				new BDUniqueRuleValidate(),
   				NullValueValidator.createMDNullValueValidator(new SampCollectTimeDictDO().getDODesc(), Arrays.asList(SampCollectTimeDictDO.NAME,SampCollectTimeDictDO.CODE))
   				};

	}

	@Override
	protected Validator[] getUpdateValidator(SampCollectTimeDictDO[] oldDOs) {
	    return new Validator[] { 
   				new BDUniqueRuleValidate(),
   				NullValueValidator.createMDNullValueValidator(new SampCollectTimeDictDO().getDODesc(), Arrays.asList(SampCollectTimeDictDO.NAME,SampCollectTimeDictDO.CODE))
   				};

	}
   
}
