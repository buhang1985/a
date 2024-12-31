package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.desc.MedSrvConsDODesc;
import iih.bd.srv.medsrv.i.IMedSrvConsDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
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
@Service(serviceInterfaces={IMedSrvConsDOCudService.class,IMedSrvConsDORService.class}, binding=Binding.JSONRPC)
public class MedSrvConsDOCrudServiceImpl extends BaseDOService<MedSrvConsDO> implements IMedSrvConsDOCudService,IMedSrvConsDORService {

    public MedSrvConsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvConsDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

