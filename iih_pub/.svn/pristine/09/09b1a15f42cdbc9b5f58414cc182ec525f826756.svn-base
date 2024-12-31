package iih.ci.mrqc.i;

import java.util.List;

import iih.ci.mrqc.randomcheck.d.CiMrQcRandomRecordDO;
import iih.ci.mrqc.randomqc.d.MrQcRandomItmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IOutMrQcMaintainServiceExt {
	
	/**
	 * 门诊科室质控记录抽查记录主表
	 * @param qryRootNodeDTO
	 * @return
	 */
    public abstract CiMrQcRandomRecordDO[] getOutDepQcRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO) throws BizException;
    
    /**
	 * 门诊部质控记录抽查记录主表
	 * @param qryRootNodeDTO
	 * @return
	 */
    public  CiMrQcRandomRecordDO[] getOutOpdQcRandomRecordQryList(QryRootNodeDTO qryRootNodeDTO) throws BizException;
	
    /**
	 * 门诊科室质控记录已抽查记录明细表
	 * @param qryRootNodeDTO
	 * @return
	 */
    public MrQcRandomItmDTO[] getMrQcOutRandomItmList(String id_random_itm)throws BizException;
}
