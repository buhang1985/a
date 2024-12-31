package iih.bl.inc.i;

import iih.bl.inc.dto.blelecbillcheckdto.d.BlecIncCheckDTO;
import iih.bl.inc.dto.blelecbillcheckdto.d.CheckTotalDataDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 电子票据查询服务
 * @author ly 2019/12/04
 *
 */
public interface IBlEcIncQryService {
	/**
	 * 电子票据数据核对总票数&总金额核对
	 * 
	 */
	CheckTotalDataDTO checkPlatAndIihSum(QryRootNodeDTO qry) throws BizException;
	/**
	 * 正常数据根据查询方案展示
	 * @param qry
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<BlecIncCheckDTO> qryNormalDatas(QryRootNodeDTO qry, PaginationInfo pg) throws BizException;
	/**
	 * 异常数据根据查询方案展示
	 * @param qry
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<BlecIncCheckDTO> qryAbnormalDatas(QryRootNodeDTO qry, PaginationInfo pg) throws BizException;
	
}
