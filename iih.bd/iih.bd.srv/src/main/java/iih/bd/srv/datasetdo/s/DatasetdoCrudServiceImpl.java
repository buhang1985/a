package iih.bd.srv.datasetdo.s;
import iih.bd.srv.datasetdo.d.DataSetDO;
import iih.bd.srv.datasetdo.d.desc.DataSetDODesc;
import iih.bd.srv.datasetdo.i.IDatasetdoCudService;
import iih.bd.srv.datasetdo.i.IDatasetdoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDatasetdoCudService.class,IDatasetdoRService.class}, binding=Binding.JSONRPC)
public class DatasetdoCrudServiceImpl extends BaseDOService<DataSetDO> implements IDatasetdoCudService,IDatasetdoRService {

    public DatasetdoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DataSetDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

