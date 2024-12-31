package iih.bd.srv.mrtplvs.s;
import iih.bd.srv.mrtplvs.d.BdMrtplVsDO;
import iih.bd.srv.mrtplvs.d.desc.BdMrtplVsDODesc;
import iih.bd.srv.mrtplvs.i.IMrtplvsMDOCudService;
import iih.bd.srv.mrtplvs.i.IMrtplvsMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 生命体征项主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMrtplvsMDOCudService.class,IMrtplvsMDORService.class}, binding=Binding.JSONRPC)
public class MrtplvsMDOCrudServiceImpl extends BaseDOService<BdMrtplVsDO> implements IMrtplvsMDOCudService,IMrtplvsMDORService {

    public MrtplvsMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrtplVsDODesc.class),IAppFwTempTbl.tmp_iaw_24.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

