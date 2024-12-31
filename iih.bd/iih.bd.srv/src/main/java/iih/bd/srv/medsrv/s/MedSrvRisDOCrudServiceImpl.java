package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.desc.MedSrvRisDODesc;
import iih.bd.srv.medsrv.i.IMedSrvRisDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IMedSrvRisDOCudService.class,IMedSrvRisDORService.class}, binding=Binding.JSONRPC)
public class MedSrvRisDOCrudServiceImpl extends BaseDOService<MedSrvRisDO> implements IMedSrvRisDOCudService,IMedSrvRisDORService {

    public MedSrvRisDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvRisDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

