package iih.en.er.bp.inouttransmgr;

import iih.en.er.dto.d.UrgInOutTransMgrDTO;
import iih.en.er.dto.d.UrgMrgQueryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
/**
 * 急诊 入出转查询
 * 
 * @author liubin
 *
 */
public interface IGetInOutTransMgr {
	/**
	 * 获取急诊患者入出转信息
	 * 
	 * @param condition
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	PagingRtnData<UrgInOutTransMgrDTO> exec(UrgMrgQueryDTO condition, PaginationInfo pageInfo) throws BizException;
	/**
	 * 获取患者入出转信息
	 * 
	 * @param entId
	 * @return
	 */
	UrgInOutTransMgrDTO exec(String entId) throws BizException;
	/**
	 * 获取患者入出转信息
	 * 
	 * @param condition
	 * @return
	 */
	UrgInOutTransMgrDTO[] exec(UrgMrgQueryDTO condition) throws BizException;
	/**
	 * 获取患者入出转信息
	 * 
	 * @param entIds
	 * @return
	 */
	UrgInOutTransMgrDTO[] exec(String[] entIds) throws BizException;
}
