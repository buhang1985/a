package iih.en.doc.pregdoc.s;
import iih.en.doc.pregdoc.d.PregDocStatDO;
import iih.en.doc.pregdoc.d.desc.PregDocStatDODesc;
import iih.en.doc.pregdoc.i.IPregDocStatDOCudService;
import iih.en.doc.pregdoc.i.IPregDocStatDORService;
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
@Service(serviceInterfaces={IPregDocStatDOCudService.class,IPregDocStatDORService.class}, binding=Binding.JSONRPC)
public class PregDocStatDOCrudServiceImpl extends BaseDOService<PregDocStatDO> implements IPregDocStatDOCudService,IPregDocStatDORService {

    public PregDocStatDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PregDocStatDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

