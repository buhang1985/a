package iih.bd.mhi.hpentpcomp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.dto.d.HpEnTpCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 根据医保产品主键和条件语句查询就诊类型对照分页信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindEntpCompPagingByHpIdAndWherePartBp {

	public PagingRtnData<HpEnTpCompDTO> exec(String hpId, String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		String whereStr = getWherePart(hpId, wherePart);
		PagingRtnData<HpEnTpCompDTO> result = findEntpCompPagingByWherePart(whereStr, orderStr, pg);
		return result;
	}

	/**
	 * 根据查询条件查询医保就诊类型对照分页数据
	 * 
	 * @param whereStr
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<HpEnTpCompDTO> findEntpCompPagingByWherePart(String whereStr, String orderStr,
			PaginationInfo pg) throws BizException {
		FindHpEnTpCompByWherePartQry qrp = new FindHpEnTpCompByWherePartQry(whereStr);

		PagingServiceImpl<HpEnTpCompDTO> pagingServiceImpl = new PagingServiceImpl<HpEnTpCompDTO>();
		PagingRtnData<HpEnTpCompDTO> result = pagingServiceImpl.findByPageInfo(new HpEnTpCompDTO(), pg,
				qrp.getQrySQLStr(), orderStr, qrp.getQryParameter(null));
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param hpId
	 * @param wherePart
	 * @return
	 */
	private String getWherePart(String hpId, String wherePart) {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1");
		if (StringUtils.isNotEmpty(hpId)) {
			String whereStr = String.format(" AND ID_HP = '%s' ", hpId);
			wherePartBuilder.append(whereStr);
		}

		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

}
