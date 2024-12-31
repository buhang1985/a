package iih.en.doc.pregdoc.s;
import iih.en.doc.pregdoc.d.PregDocDO;
import iih.en.doc.pregdoc.d.desc.PregDocDODesc;
import iih.en.doc.pregdoc.i.IPregdocMDOCudService;
import iih.en.doc.pregdoc.i.IPregdocMDORService;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;

/**
 * 产科建档主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPregdocMDOCudService.class,IPregdocMDORService.class}, binding=Binding.JSONRPC)
public class PregdocMDOCrudServiceImpl extends BaseDOService<PregDocDO> implements IPregdocMDOCudService,IPregdocMDORService {

    public PregdocMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PregDocDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

