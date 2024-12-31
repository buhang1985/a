package iih.ci.rcm.nosoinfection.i;

import iih.ci.rcm.trackafterexposuredto.d.TrackAfterExposureDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ITrackAfExposureService {

	public abstract PagingRtnData<TrackAfterExposureDTO> getTrackAfExposureList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

}
