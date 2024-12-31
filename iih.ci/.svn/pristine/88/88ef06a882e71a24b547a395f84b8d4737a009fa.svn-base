package iih.ci.mr.cimracrecords.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.mr.cimracrecords.d.CiMrACBaseDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.mr.cimracrecords.d.desc.CiMrACBaseDODesc;
import iih.ci.mr.cimracrecords.d.CimracrecordsAggDO;
import iih.ci.mr.cimracrecords.i.ICimracrecordsCudService;
import iih.ci.mr.cimracrecords.i.ICimracrecordsRService;


/**
 * 产程数据记录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimracrecordsCudService.class,ICimracrecordsRService.class}, binding=Binding.JSONRPC)
public class CimracrecordsCrudServiceImpl extends BaseAggService<CimracrecordsAggDO,CiMrACBaseDO> implements ICimracrecordsCudService,ICimracrecordsRService {
    public CimracrecordsCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrACBaseDODesc.class),IAppFwTempTbl.tmp_iaw_08.name()); 
    }
}
