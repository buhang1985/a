package iih.ci.log.i;

import iih.ci.log.d.CiBizLogDO;
import iih.ci.log.d.CiBizLogQueryDTO;
import iih.ci.log.d.LogLevel;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface ICiBizLogService {

	/**
	 * 临床操作日志列表加载
	 * @param name_pat
	 * @param name_emp_or
	 * @param start
	 * @param end
	 * @return
	 * @throws BizException
	 */

	
	/*CiBizLogDO[] load(CiBizLogQueryDTO dto) throws BizException;*/
	
	CiBizLogDO[] SaveLoglevel(LogLevel loglv,CiEnContextDTO ctx,String msg) throws BizException;
	
	CiBizLogDO[] SaveLoglevel2(LogLevel loglv,CiEnContextDTO ctx,String msg,Throwable t) throws BizException;
	
	//分页
	PagingRtnData<CiBizLogDO> findByPageInfo2(CiBizLogQueryDTO dto,PaginationInfo pg) throws BizException;
	
	//导出
	void export()  throws BizException;
}
