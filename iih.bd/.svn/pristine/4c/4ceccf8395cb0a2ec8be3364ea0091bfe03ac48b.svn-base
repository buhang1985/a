package iih.bd.srv.mrtplstblsec.s;
import iih.bd.srv.mrtplstblsec.d.MrTplSTblSecDO;
import iih.bd.srv.mrtplstblsec.d.desc.MrTplSTblSecDODesc;
import iih.bd.srv.mrtplstblsec.i.IMrtplstblsecMDOCudService;
import iih.bd.srv.mrtplstblsec.i.IMrtplstblsecMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录模板智能表格段落AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplstblsecMDOCudService.class,IMrtplstblsecMDORService.class}, binding=Binding.JSONRPC)
public class MrtplstblsecMDOCrudServiceImpl extends BaseDOService<MrTplSTblSecDO> implements IMrtplstblsecMDOCudService,IMrtplstblsecMDORService {

    public MrtplstblsecMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrTplSTblSecDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

