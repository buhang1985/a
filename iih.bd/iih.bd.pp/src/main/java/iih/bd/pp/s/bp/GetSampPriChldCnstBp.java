package iih.bd.pp.s.bp;

import iih.bd.pp.s.bp.qry.GetSampPriChldCnstQry;
import iih.bd.pp.samppricnstdto.d.SampPricnstDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * @Description: 儿童采集费用对照查询服务
 * @author: xu_xing@founder.com.cn
 * @version：2019年6月13日 下午6:07:18 创建
 */
public class GetSampPriChldCnstBp {

	/**
	 * 主入口
	 * 
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SampPricnstDTO> exec(PaginationInfo pg, SampPricnstDTO param) throws BizException {
		GetSampPriChldCnstQry sql = new GetSampPriChldCnstQry(param.getSamppri_id_srv(), param.getContrast_id_srv());
		PagingServiceImpl<SampPricnstDTO> serviceImpl = new PagingServiceImpl<SampPricnstDTO>();
		PagingRtnData<SampPricnstDTO> data = serviceImpl.findByPageInfo(new SampPricnstDTO(), pg, sql.getQrySQLStr(), "", sql.getQryParameter(null));
		return data;
	}
}
