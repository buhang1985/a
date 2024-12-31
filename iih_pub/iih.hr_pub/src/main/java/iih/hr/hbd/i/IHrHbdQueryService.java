package iih.hr.hbd.i;

import iih.hr.hbd.dto.hrpsnqryfield.d.HrPsnQryFieldDTO;
import iih.hr.hbd.dto.psnqrydto.d.HrPsnQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 人员档案公共查询接口
 * 
 * @author lijm
 * @date 2018-11-29
 */
public interface IHrHbdQueryService {

	/**
	 * 人员综合查询
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HrPsnQryDTO> synthQryPsn(PaginationInfo pg,QryRootNodeDTO qryRootNodeDTO, String orderStr) throws BizException;

	/**
	 * 获取人员综合查询字段集合
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract HrPsnQryFieldDTO[] getHrPsnQryDTOField() throws BizException;

}
