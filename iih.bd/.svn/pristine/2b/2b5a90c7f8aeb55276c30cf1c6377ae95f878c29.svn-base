package iih.bd.srv.srvortplcate.s;
import iih.bd.srv.srvortplcate.d.SrvOrTplCateDO;
import iih.bd.srv.srvortplcate.d.desc.SrvOrTplCateDODesc;
import iih.bd.srv.srvortplcate.i.ISrvortplcateCudService;
import iih.bd.srv.srvortplcate.i.ISrvortplcateRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗服务医嘱模板分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ISrvortplcateCudService.class,ISrvortplcateRService.class}, binding=Binding.JSONRPC)
public class SrvortplcateCrudServiceImpl extends BaseDOService<SrvOrTplCateDO> implements ISrvortplcateCudService,ISrvortplcateRService {

    public SrvortplcateCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SrvOrTplCateDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
}

