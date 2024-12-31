package iih.mp.orm.i;

import iih.mp.orm.surgqry.d.SurgInfoCondDTO;
import iih.mp.orm.surgqry.d.SurgInfoDTO;
import xap.lui.core.dataset.PaginationInfo;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 执行域通用手术相关查询服务
 * 
 * @author yy.zhao 2020年1月8日10:51:19
 *
 */
public interface IMpOrmQryService {

	/**
	 * 获取手术医嘱补费信息
	 * @param id_or
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble getSupplementFee(String id_or,String code_entp) throws BizException;
	
	/**
	 * 获取手术历史信息
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<SurgInfoDTO> getSurgInfo(SurgInfoCondDTO qryCond,PaginationInfo pg) throws BizException;
	
}
