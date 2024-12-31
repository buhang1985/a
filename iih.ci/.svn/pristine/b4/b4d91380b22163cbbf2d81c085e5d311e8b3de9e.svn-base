package iih.ci.mrm.healthsystem.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrm.healthsystem.d.desc.DocContrastDODesc;
import iih.ci.mrm.healthsystem.d.DocContrastDO;
import iih.ci.mrm.healthsystem.i.IDocContrastDOCudService;
import iih.ci.mrm.healthsystem.i.IDocContrastDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 数据抽取任务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IDocContrastDOCudService.class,IDocContrastDORService.class}, binding=Binding.JSONRPC)
public class DocContrastDOCrudServiceImpl extends BaseDOService<DocContrastDO> implements IDocContrastDOCudService,IDocContrastDORService {

    public DocContrastDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(DocContrastDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

