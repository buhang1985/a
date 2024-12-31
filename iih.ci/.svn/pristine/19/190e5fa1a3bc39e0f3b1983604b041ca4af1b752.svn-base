package iih.ci.ord.app.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.ord.app.d.CiAppBtSheetDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.ord.app.d.desc.CiAppBtSheetDODesc;
import iih.ci.ord.app.d.CiappbtsheetAggDO;
import iih.ci.ord.app.i.ICiappbtsheetCudService;
import iih.ci.ord.app.i.ICiappbtsheetRService;


/**
 * 备血打印申请单AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICiappbtsheetCudService.class,ICiappbtsheetRService.class}, binding=Binding.JSONRPC)
public class CiappbtsheetCrudServiceImpl extends BaseAggService<CiappbtsheetAggDO,CiAppBtSheetDO> implements ICiappbtsheetCudService,ICiappbtsheetRService {
    public CiappbtsheetCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiAppBtSheetDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
}
