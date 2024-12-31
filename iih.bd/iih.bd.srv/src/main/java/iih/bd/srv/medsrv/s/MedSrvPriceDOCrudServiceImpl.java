package iih.bd.srv.medsrv.s;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.desc.MedSrvPriceDODesc;
import iih.bd.srv.medsrv.i.IMedSrvPriceDOCudService;
import iih.bd.srv.medsrv.i.IMedSrvPriceDORService;
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
@Service(serviceInterfaces={IMedSrvPriceDOCudService.class,IMedSrvPriceDORService.class}, binding=Binding.JSONRPC)
public class MedSrvPriceDOCrudServiceImpl extends BaseDOService<MedSrvPriceDO> implements IMedSrvPriceDOCudService,IMedSrvPriceDORService {

    public MedSrvPriceDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MedSrvPriceDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

