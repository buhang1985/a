package iih.bd.pp.singlediamt.s;
import iih.bd.pp.singlediamt.d.SingleDiAmtDO;
import iih.bd.pp.singlediamt.d.SinglediamtAggDO;
import iih.bd.pp.singlediamt.d.desc.SingleDiAmtDODesc;
import iih.bd.pp.singlediamt.i.ISinglediamtCudService;
import iih.bd.pp.singlediamt.i.ISinglediamtRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保计划单病种控费AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISinglediamtCudService.class,ISinglediamtRService.class}, binding=Binding.JSONRPC)
public class SinglediamtCrudServiceImpl extends BaseAggService<SinglediamtAggDO,SingleDiAmtDO> implements ISinglediamtCudService,ISinglediamtRService {
    public SinglediamtCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SingleDiAmtDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
}
