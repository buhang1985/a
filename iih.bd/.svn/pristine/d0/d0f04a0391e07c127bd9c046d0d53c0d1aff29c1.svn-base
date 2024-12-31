package iih.bd.srv.mrtplvst.s;
import iih.bd.srv.mrtplvst.d.BdMrtplVstItmDO;
import iih.bd.srv.mrtplvst.d.desc.BdMrtplVstItmDODesc;
import iih.bd.srv.mrtplvst.i.IBdMrtplVstItmDOCudService;
import iih.bd.srv.mrtplvst.i.IBdMrtplVstItmDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 生命体征模版主实体CRUD服务实现
 */
@Service(serviceInterfaces={IBdMrtplVstItmDOCudService.class,IBdMrtplVstItmDORService.class}, binding=Binding.JSONRPC)
public class BdMrtplVstItmDOCrudServiceImpl extends BaseDOService<BdMrtplVstItmDO> implements IBdMrtplVstItmDOCudService,IBdMrtplVstItmDORService {

    public BdMrtplVstItmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdMrtplVstItmDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

