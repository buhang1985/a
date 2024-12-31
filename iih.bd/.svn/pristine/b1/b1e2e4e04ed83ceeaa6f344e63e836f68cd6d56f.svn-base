package iih.bd.srv.deptsrvlimit.s;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitDO;
import iih.bd.srv.deptsrvlimit.d.DeptsrvlimitAggDO;
import iih.bd.srv.deptsrvlimit.d.desc.DeptSrvLimitDODesc;
import iih.bd.srv.deptsrvlimit.i.IDeptsrvlimitCudService;
import iih.bd.srv.deptsrvlimit.i.IDeptsrvlimitRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 科室服务白黑名单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IDeptsrvlimitCudService.class,IDeptsrvlimitRService.class}, binding=Binding.JSONRPC)
public class DeptsrvlimitCrudServiceImpl extends BaseAggService<DeptsrvlimitAggDO,DeptSrvLimitDO> implements IDeptsrvlimitCudService,IDeptsrvlimitRService {

    public DeptsrvlimitCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DeptSrvLimitDODesc.class),IAppFwTempTbl.tmp_iaw_28.name()); 
    }
}

