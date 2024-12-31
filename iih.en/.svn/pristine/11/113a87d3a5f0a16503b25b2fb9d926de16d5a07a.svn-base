package iih.en.pv.entplan.s;
import iih.en.pv.entplan.d.EntCpDO;
import iih.en.pv.entplan.d.desc.EntCpDODesc;
import iih.en.pv.entplan.i.IEntcpCudService;
import iih.en.pv.entplan.i.IEntcpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 就诊临床路径AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IEntcpCudService.class,IEntcpRService.class}, binding=Binding.JSONRPC)
public class EntcpCrudServiceImpl extends BaseDOService<EntCpDO> implements IEntcpCudService,IEntcpRService {

    public EntcpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EntCpDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}

