package iih.bd.mhi.hpunpasscompareinfo.s;
import iih.bd.mhi.hpunpasscompareinfo.d.HpUnPassCompareInfoDO;
import iih.bd.mhi.hpunpasscompareinfo.d.desc.HpUnPassCompareInfoDODesc;
import iih.bd.mhi.hpunpasscompareinfo.i.IHpunpasscompareinfoCudService;
import iih.bd.mhi.hpunpasscompareinfo.i.IHpunpasscompareinfoRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保对照_未通过对照信息AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHpunpasscompareinfoCudService.class,IHpunpasscompareinfoRService.class}, binding=Binding.JSONRPC)
public class HpunpasscompareinfoCrudServiceImpl extends BaseDOService<HpUnPassCompareInfoDO> implements IHpunpasscompareinfoCudService,IHpunpasscompareinfoRService {
    public HpunpasscompareinfoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpUnPassCompareInfoDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}
