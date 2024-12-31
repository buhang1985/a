package iih.ci.ord.consrpt.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.ord.consrpt.d.desc.CiOrdConsRptDODesc;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.consrpt.d.CiOrdConsRptDO;
import iih.ci.ord.consrpt.i.IConsrptCudService;
import iih.ci.ord.consrpt.i.IConsrptRService;
import iih.ci.ord.s.bp.SaveCompleteConsultAggDOBP;


/**
 * 组件AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IConsrptCudService.class,IConsrptRService.class}, binding=Binding.JSONRPC)
public class ConsrptCrudServiceImpl extends BaseDOService<CiOrdConsRptDO> implements IConsrptCudService,IConsrptRService {
    public ConsrptCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiOrdConsRptDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }

	
/**
   	 * 完成会诊状态撤回到科室审批 6状态
   	 * 
   	 * @param aggs
   	 *            会诊的记录信息
   	 * @return
   	 * @throws BizException
   	 */
   	@Override
   	public OrdApConsDO revokeAggDo(OrdApConsDO aggdos) throws BizException {
   		if (aggdos == null )
   			throw new BizException("没有会诊信息");

   		SaveCompleteConsultAggDOBP bp = new SaveCompleteConsultAggDOBP();
   		return bp.exe1(aggdos);
   	}
}
