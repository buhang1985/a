package iih.ci.mrqc.mrborrowapply.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrqc.mrborrowapply.d.desc.AmrBorrowApplyDODesc;
import iih.ci.mrqc.mrborrowapply.d.AmrBorrowApplyDO;
import iih.ci.mrqc.mrborrowapply.i.IMrborrowapplyCudService;
import iih.ci.mrqc.mrborrowapply.i.IMrborrowapplyRService;


/**
 * 病案借阅申请AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrborrowapplyCudService.class,IMrborrowapplyRService.class}, binding=Binding.JSONRPC)
public class MrborrowapplyCrudServiceImpl extends BaseDOService<AmrBorrowApplyDO> implements IMrborrowapplyCudService,IMrborrowapplyRService {

    public MrborrowapplyCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(AmrBorrowApplyDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
}

