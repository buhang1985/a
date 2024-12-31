package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.SyphilisDODesc;
import iih.ci.rcm.contagion.d.SyphilisDO;
import iih.ci.rcm.contagion.i.ISyphilisDOCudService;
import iih.ci.rcm.contagion.i.ISyphilisDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={ISyphilisDOCudService.class,ISyphilisDORService.class}, binding=Binding.JSONRPC)
public class SyphilisDOCrudServiceImpl extends BaseDOService<SyphilisDO> implements ISyphilisDOCudService,ISyphilisDORService {

    public SyphilisDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(SyphilisDODesc.class),IAppFwTempTbl.tmp_iaw_26.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

