package iih.bd.res.bddepparado.s;
import iih.bd.res.bddepparado.d.BdDepParaDO;
import iih.bd.res.bddepparado.d.desc.BdDepParaDODesc;
import iih.bd.res.bddepparado.i.IBddepparadoCudService;
import iih.bd.res.bddepparado.i.IBddepparadoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医院资源_部门_参数AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBddepparadoCudService.class,IBddepparadoRService.class}, binding=Binding.JSONRPC)
public class BddepparadoCrudServiceImpl extends BaseDOService<BdDepParaDO> implements IBddepparadoCudService,IBddepparadoRService {
    public BddepparadoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdDepParaDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
}
