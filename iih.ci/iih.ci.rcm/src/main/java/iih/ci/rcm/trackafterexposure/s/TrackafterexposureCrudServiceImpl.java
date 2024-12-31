package iih.ci.rcm.trackafterexposure.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import iih.ci.rcm.trackafterexposure.d.TrackAfterExposureDO;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import iih.ci.rcm.trackafterexposure.d.desc.TrackAfterExposureDODesc;
import iih.ci.rcm.trackafterexposure.d.TrackafterexposureAggDO;
import iih.ci.rcm.trackafterexposure.i.ITrackafterexposureCudService;
import iih.ci.rcm.trackafterexposure.i.ITrackafterexposureRService;


/**
 * 暴露后追踪记录登记表AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITrackafterexposureCudService.class,ITrackafterexposureRService.class}, binding=Binding.JSONRPC)
public class TrackafterexposureCrudServiceImpl extends BaseAggService<TrackafterexposureAggDO,TrackAfterExposureDO> implements ITrackafterexposureCudService,ITrackafterexposureRService {
    public TrackafterexposureCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(TrackAfterExposureDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
}
