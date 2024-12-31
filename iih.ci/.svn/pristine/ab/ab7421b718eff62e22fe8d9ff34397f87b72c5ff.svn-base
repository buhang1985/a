package iih.ci.mr.cimrstblsec.s;
import iih.ci.mr.cimrstblsec.d.CiMrSTblSecDO;
import iih.ci.mr.cimrstblsec.d.CimrstblsecAggDO;
import iih.ci.mr.cimrstblsec.d.desc.CiMrSTblSecDODesc;
import iih.ci.mr.cimrstblsec.i.ICimrstblsecCudService;
import iih.ci.mr.cimrstblsec.i.ICimrstblsecRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 临床医疗记录智能表格段落AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrstblsecCudService.class,ICimrstblsecRService.class}, binding=Binding.JSONRPC)
public class CimrstblsecCrudServiceImpl extends BaseAggService<CimrstblsecAggDO,CiMrSTblSecDO> implements ICimrstblsecCudService,ICimrstblsecRService {

    public CimrstblsecCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSTblSecDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
}

