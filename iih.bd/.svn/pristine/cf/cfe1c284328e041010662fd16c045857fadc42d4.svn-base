package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvOfDyncItm;
import iih.bd.srv.medsrv.d.desc.MedSrvOfDyncItmDesc;
import iih.bd.srv.medsrv.i.IMedSrvOfDyncItmCudService;
import iih.bd.srv.medsrv.i.IMedSrvOfDyncItmRService;
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
@Service(serviceInterfaces={IMedSrvOfDyncItmCudService.class,IMedSrvOfDyncItmRService.class}, binding=Binding.JSONRPC)
public class MedSrvOfDyncItmCrudServiceImpl extends BaseDOService<MedSrvOfDyncItm> implements IMedSrvOfDyncItmCudService,IMedSrvOfDyncItmRService {

    public MedSrvOfDyncItmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvOfDyncItmDesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

