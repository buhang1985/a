package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.app.d.desc.CiAppBuSheetDODesc;
import iih.ci.ord.app.d.CiAppBuSheetDO;
import iih.ci.ord.app.i.ICiappbusheetCudService;
import iih.ci.ord.app.i.ICiappbusheetRService;


/**
 * 取血打印申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiappbusheetCudService.class,ICiappbusheetRService.class}, binding=Binding.JSONRPC)
public class CiappbusheetCrudServiceImpl extends BaseDOService<CiAppBuSheetDO> implements ICiappbusheetCudService,ICiappbusheetRService {
    public CiappbusheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppBuSheetDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
}
