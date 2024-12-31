package iih.ci.mr.cimrsfmsec.s;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecAggDO;
import iih.ci.mr.cimrsfmsec.d.CimrsfmsecDO;
import iih.ci.mr.cimrsfmsec.d.desc.CimrsfmsecDODesc;
import iih.ci.mr.cimrsfmsec.i.ICimrsfmsecCudService;
import iih.ci.mr.cimrsfmsec.i.ICimrsfmsecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗记录智能表单段落AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrsfmsecCudService.class,ICimrsfmsecRService.class}, binding=Binding.JSONRPC)
public class CimrsfmsecCrudServiceImpl extends BaseAggService<CimrsfmsecAggDO,CimrsfmsecDO> implements ICimrsfmsecCudService,ICimrsfmsecRService {

    public CimrsfmsecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CimrsfmsecDODesc.class),IAppFwTempTbl.tmp_iaw_15.name()); 
    }
}

