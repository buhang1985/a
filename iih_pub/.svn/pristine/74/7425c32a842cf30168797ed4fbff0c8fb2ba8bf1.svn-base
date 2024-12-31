package iih.bd.mhi.hpentpcomp.i;

import iih.bd.mhi.dto.d.HpEnTpCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 医保产品就诊类型对照扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IHpentpcompExtRService {

	/**
	 * 根据医保产品主键和条件语句查询就诊类型对照分页信息
	 * 
	 * @param hpId
	 *            医保产品主键
	 * @param wherePart
	 *            条件语句
	 * @param orderStr
	 *            排序语句
	 * @param pg
	 *            就诊类型对照分页信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<HpEnTpCompDTO> findEntpCompPagingByHpIdAndWherePart(String hpId, String wherePart,
			String orderStr, PaginationInfo pg) throws BizException;
}
