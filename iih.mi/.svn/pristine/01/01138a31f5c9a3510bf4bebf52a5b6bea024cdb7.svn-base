package iih.mi.mibd.stdsrvtp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.mi.mibd.stdsrvtp.d.desc.HpsrvtpDODesc;
import iih.mi.mibd.stdsrvtp.d.HpsrvtpDO;
import iih.mi.mibd.stdsrvtp.i.IStdsrvtpCudService;
import iih.mi.mibd.stdsrvtp.i.IStdsrvtpRService;


/**
 * 医保计划下医保目录等级对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IStdsrvtpCudService.class,IStdsrvtpRService.class}, binding=Binding.JSONRPC)
public class StdsrvtpCrudServiceImpl extends BaseDOService<HpsrvtpDO> implements IStdsrvtpCudService,IStdsrvtpRService {
    public StdsrvtpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpsrvtpDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
