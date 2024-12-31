package iih.ci.mrqc.randomqc.i;

import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface IMrQcOutRandomItmQryService {
    /**
	*  获取门诊科室质控患者列表
	*/
    public abstract  PagingRtnData<MrQcRandomItmDTO> getMrQcOutRandomItmListDtos(String id_random_itm,PaginationInfo paginationInfo) throws BizException;
    /**
	*  获取门诊部质控患者列表
	*/
    public abstract  PagingRtnData<MrQcRandomItmDTO> getMrQcOpdOutRandomItmListDtos(String id_random_itm,PaginationInfo paginationInfo) throws BizException;
}
