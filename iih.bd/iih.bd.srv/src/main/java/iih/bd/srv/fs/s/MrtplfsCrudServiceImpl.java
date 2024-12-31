package iih.bd.srv.fs.s;
import iih.bd.srv.fs.d.MrtplFSDO;
import iih.bd.srv.fs.d.desc.MrtplFSDODesc;
import iih.bd.srv.fs.i.IMrtplfsCudService;
import iih.bd.srv.fs.i.IMrtplfsRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplfsCudService.class,IMrtplfsRService.class}, binding=Binding.JSONRPC)
public class MrtplfsCrudServiceImpl extends BaseDOService<MrtplFSDO> implements IMrtplfsCudService,IMrtplfsRService {

    public MrtplfsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrtplFSDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
}


