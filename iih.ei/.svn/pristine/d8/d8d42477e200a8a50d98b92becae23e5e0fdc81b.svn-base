package iih.ei.varp.quoteevalrlt.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ei.varp.quoteevalrlt.d.desc.EiVarpQuoteEvalRltDODesc;
import iih.ei.varp.quoteevalrlt.d.EiVarpQuoteEvalRltDO;
import iih.ei.varp.quoteevalrlt.i.IQuoteevalrltCudService;
import iih.ei.varp.quoteevalrlt.i.IQuoteevalrltRService;

/**
 * 报价器评价结果AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IQuoteevalrltCudService.class,IQuoteevalrltRService.class}, binding=Binding.JSONRPC)
public class QuoteevalrltCrudServiceImpl extends BaseDOService<EiVarpQuoteEvalRltDO> implements IQuoteevalrltCudService,IQuoteevalrltRService {
    public QuoteevalrltCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EiVarpQuoteEvalRltDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
