package iih.ci.mrfp.cimrfpquickfinddo.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.cimrfpquickfinddo.d.desc.CiMrFpQuickFindDODesc;
import iih.ci.mrfp.cimrfpquickfinddo.d.CiMrFpQuickFindDO;
import iih.ci.mrfp.cimrfpquickfinddo.i.ICimrfpquickfinddoCudService;
import iih.ci.mrfp.cimrfpquickfinddo.i.ICimrfpquickfinddoRService;

/**
 * 病案首页快速查询AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICimrfpquickfinddoCudService.class,ICimrfpquickfinddoRService.class}, binding=Binding.JSONRPC)
public class CimrfpquickfinddoCrudServiceImpl extends BaseDOService<CiMrFpQuickFindDO> implements ICimrfpquickfinddoCudService,ICimrfpquickfinddoRService {
    public CimrfpquickfinddoCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrFpQuickFindDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
}
