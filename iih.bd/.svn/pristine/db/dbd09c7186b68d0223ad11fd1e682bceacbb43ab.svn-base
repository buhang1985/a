package iih.bd.pp.samppri.s;
import iih.bd.pp.samppri.d.SampPriDO;
import iih.bd.pp.samppri.d.SamppriAggDO;
import iih.bd.pp.samppri.d.desc.SampPriDODesc;
import iih.bd.pp.samppri.i.ISamppriCudService;
import iih.bd.pp.samppri.i.ISamppriRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 标本费用对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISamppriCudService.class,ISamppriRService.class}, binding=Binding.JSONRPC)
public class SamppriCrudServiceImpl extends BaseAggService<SamppriAggDO,SampPriDO> implements ISamppriCudService,ISamppriRService {
    public SamppriCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SampPriDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
}
