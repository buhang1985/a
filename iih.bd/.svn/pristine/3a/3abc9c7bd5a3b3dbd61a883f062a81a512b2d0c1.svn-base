package iih.bd.srv.emrimg.s;
import iih.bd.srv.emrimg.d.EmrImgAliasDO;
import iih.bd.srv.emrimg.d.desc.EmrImgAliasDODesc;
import iih.bd.srv.emrimg.i.IEmrImgAliasDOCudService;
import iih.bd.srv.emrimg.i.IEmrImgAliasDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 医疗记录图片库管理主实体CRUD服务实现
 */
@Service(serviceInterfaces={IEmrImgAliasDOCudService.class,IEmrImgAliasDORService.class}, binding=Binding.JSONRPC)
public class EmrImgAliasDOCrudServiceImpl extends BaseDOService<EmrImgAliasDO> implements IEmrImgAliasDOCudService,IEmrImgAliasDORService {

    public EmrImgAliasDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(EmrImgAliasDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

