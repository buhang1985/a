package iih.bl.inc.blecinctrans.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import iih.bl.inc.blecinctrans.d.desc.BlEcIncTransDODesc;
import iih.bl.inc.blecinctrans.d.BlEcIncTransDO;
import iih.bl.inc.blecinctrans.i.IBlecinctransCudService;
import iih.bl.inc.blecinctrans.i.IBlecinctransRService;


/**
 * 电子票据交易记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlecinctransCudService.class,IBlecinctransRService.class}, binding=Binding.JSONRPC)
public class BlecinctransCrudServiceImpl extends BaseDOService<BlEcIncTransDO> implements IBlecinctransCudService,IBlecinctransRService {
    public BlecinctransCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlEcIncTransDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
}
