package iih.pi.acc.piaccbank.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.acc.piaccbank.d.desc.PiPatCredBankDODesc;
import iih.pi.acc.piaccbank.d.PiPatCredBankDO;
import iih.pi.acc.piaccbank.i.IPiaccbankCudService;
import iih.pi.acc.piaccbank.i.IPiaccbankRService;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IPiaccbankCudService.class,IPiaccbankRService.class}, binding=Binding.JSONRPC)
public class PiaccbankCrudServiceImpl extends BaseDOService<PiPatCredBankDO> implements IPiaccbankCudService,IPiaccbankRService {

    public PiaccbankCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCredBankDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }
}

