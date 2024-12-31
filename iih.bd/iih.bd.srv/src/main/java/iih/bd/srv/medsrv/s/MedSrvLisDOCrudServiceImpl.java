package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.desc.MedSrvLisDODesc;
import iih.bd.srv.medsrv.i.IMedSrvLisDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
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
@Service(serviceInterfaces={IMedSrvLisDOCudService.class,IMedSrvLisDORService.class}, binding=Binding.JSONRPC)
public class MedSrvLisDOCrudServiceImpl extends BaseDOService<MedSrvLisDO> implements IMedSrvLisDOCudService,IMedSrvLisDORService {

    public MedSrvLisDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvLisDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

