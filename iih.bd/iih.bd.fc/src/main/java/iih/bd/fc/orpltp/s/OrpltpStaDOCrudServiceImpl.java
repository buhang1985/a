package iih.bd.fc.orpltp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.fc.orpltp.d.desc.OrpltpStaDODesc;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpStaDOCudService;
import iih.bd.fc.orpltp.i.IOrpltpStaDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱执行计划状态主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpStaDOCudService.class,IOrpltpStaDORService.class}, binding=Binding.JSONRPC)
public class OrpltpStaDOCrudServiceImpl extends BaseDOService<OrpltpStaDO> implements IOrpltpStaDOCudService,IOrpltpStaDORService {

    public OrpltpStaDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpStaDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    

}

