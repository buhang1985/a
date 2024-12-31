package iih.ei.varp.quoteset.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ei.varp.quoteset.d.desc.EiVarpQuoteSetDODesc;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.ei.varp.quoteset.d.EiVarpQuoteSetDO;
import iih.ei.varp.quoteset.i.IQuotesetCudService;
import iih.ei.varp.quoteset.i.IQuotesetRService;


/**
 * 评价器设置AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQuotesetCudService.class,IQuotesetRService.class}, binding=Binding.JSONRPC)
public class QuotesetCrudServiceImpl extends BaseDOService<EiVarpQuoteSetDO> implements IQuotesetCudService,IQuotesetRService {
    public QuotesetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EiVarpQuoteSetDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
    
    @Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(EiVarpQuoteSetDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
    
}
