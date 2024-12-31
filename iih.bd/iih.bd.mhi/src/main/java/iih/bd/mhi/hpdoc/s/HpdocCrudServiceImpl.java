package iih.bd.mhi.hpdoc.s;
import iih.bd.mhi.hpdoc.d.HpDocDO;
import iih.bd.mhi.hpdoc.d.desc.HpDocDODesc;
import iih.bd.mhi.hpdoc.i.IHpdocCudService;
import iih.bd.mhi.hpdoc.i.IHpdocRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保档案AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpdocCudService.class,IHpdocRService.class}, binding=Binding.JSONRPC)
public class HpdocCrudServiceImpl extends BaseDOService<HpDocDO> implements IHpdocCudService,IHpdocRService {
    public HpdocCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpDocDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
}
