package iih.bl.itf.bltransblankaccinfo.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bl.itf.bltransblankaccinfo.d.desc.BlTransBlankAccInfoDODesc;
import iih.bl.itf.bltransblankaccinfo.d.BlTransBlankAccInfoDO;
import iih.bl.itf.bltransblankaccinfo.i.IBltransblankaccinfoCudService;
import iih.bl.itf.bltransblankaccinfo.i.IBltransblankaccinfoRService;


/**
 * 转账信息表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBltransblankaccinfoCudService.class,IBltransblankaccinfoRService.class}, binding=Binding.JSONRPC)
public class BltransblankaccinfoCrudServiceImpl extends BaseDOService<BlTransBlankAccInfoDO> implements IBltransblankaccinfoCudService,IBltransblankaccinfoRService {
    public BltransblankaccinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlTransBlankAccInfoDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
