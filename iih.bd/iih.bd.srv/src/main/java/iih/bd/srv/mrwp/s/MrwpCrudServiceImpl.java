package iih.bd.srv.mrwp.s;

import iih.bd.srv.mrwp.d.MrWritePowerDO;
import iih.bd.srv.mrwp.d.MrwpAggDO;
import iih.bd.srv.mrwp.d.desc.MrWritePowerDODesc;
import iih.bd.srv.mrwp.i.IMrwpCudService;
import iih.bd.srv.mrwp.i.IMrwpRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * mrwpAggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrwpCudService.class,IMrwpRService.class}, binding=Binding.JSONRPC)
public class MrwpCrudServiceImpl extends BaseAggService<MrwpAggDO,MrWritePowerDO> implements IMrwpCudService,IMrwpRService {
    public MrwpCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrWritePowerDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
}
