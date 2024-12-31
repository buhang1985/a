package iih.ci.mrqc.outqamedpatlist.i;

import iih.ci.mrqc.outqamedpatlist.d.OutQaMedPatListDTO;
import iih.ci.mrqc.qrydto.d.OutQaPatQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IOutQaMedPatListQryService {
	  /**
		*  获取门诊质控患者列表
		*/
	    public abstract  PagingRtnData<OutQaMedPatListDTO> getOutQaPatListDtos(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;

	    /**
		*  获取门诊抽查患者列表
		*/
	    public abstract  PagingRtnData<OutQaMedPatListDTO> getOutQaToRandomPatListDtos(OutQaPatQryDTO qryDTO,PaginationInfo paginationInfo) throws BizException;
	    /**
		*  获取门诊抽查患者列表
		*/
	    public abstract  PagingRtnData<OutQaMedPatListDTO> getOutQaHasRandomPatListDtos(OutQaPatQryDTO qryDTO,PaginationInfo paginationInfo) throws BizException;
	    /**
		*  获取门诊抽查患者列表
		*/
	    public abstract  PagingRtnData<OutQaMedPatListDTO> getOutQaTracePatListDtos(OutQaPatQryDTO qryDTO,PaginationInfo paginationInfo) throws BizException;
	}
