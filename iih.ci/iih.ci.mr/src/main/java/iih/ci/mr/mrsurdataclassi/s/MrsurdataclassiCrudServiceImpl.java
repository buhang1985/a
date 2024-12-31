package iih.ci.mr.mrsurdataclassi.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.mrsurdataclassi.d.desc.MrSurDataClassiDODesc;
import iih.ci.mr.mrsurdataclassi.d.MrSurDataClassiDO;
import iih.ci.mr.mrsurdataclassi.i.IMrsurdataclassiCudService;
import iih.ci.mr.mrsurdataclassi.i.IMrsurdataclassiRService;


/**
 * 病历手术资料分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMrsurdataclassiCudService.class,IMrsurdataclassiRService.class}, binding=Binding.JSONRPC)
public class MrsurdataclassiCrudServiceImpl extends BaseDOService<MrSurDataClassiDO> implements IMrsurdataclassiCudService,IMrsurdataclassiRService {
    public MrsurdataclassiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MrSurDataClassiDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
}
