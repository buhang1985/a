package iih.en.pv.s.bp.ippre.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取入科患者列表
 * @author ltf
 *
 */
public class GetEnDepBP extends GetIpPreInfoAbstact {

	/**
	 * 主流程
	 * @param id_dep
	 * @param pageInfo 
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EnIppreInfoDTO> exec(String id_dep, PaginationInfo pageInfo) throws BizException {
		// 1.校验参数
		if(StringUtil.isEmptyWithTrim(id_dep))
			return null;
		// 2.根据当前科室获取就诊id集合
		PagingRtnData<EnIppreInfoDTO> pageDatas = getEntIds(id_dep, pageInfo);
		String[] entIds =  IpPreUtils.pageConvertEntIds(pageDatas);
		// 3.获取数据
		EnIppreInfoDTO[] data = getIpPreByEntIds(entIds);
		if(ArrayUtil.isEmpty(data)){
			return pageDatas;
		}
		// 4.组装数据
		pageDatas.setPageData(EnAppUtils.doArray2List(data));
		return pageDatas;
	}
	
	/**
	 * 重写排序方法
	 */
	@Override
	protected String getOrderByStr() {
		return "trans.dt_acpt desc";
	}
	
	/**
	 * 获取入科患者就诊id集合
	 * @param id_dep
	 * @param pageInfo 
	 * @param pageInfo 
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<EnIppreInfoDTO> getEntIds(String id_dep, PaginationInfo pageInfo) throws BizException {
		StringBuilder str = new StringBuilder();
        SqlParam param = new SqlParam();
		str.append(" select distinct ent.id_ent from en_ent ent");
		str.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent");
		str.append(" inner join en_ippre ippre on ent.id_ent = ippre.id_ent");
		str.append(" where ippre.sd_status = ?");  // 3代表入科 
		str.append(" and (ent.id_dep_phy = ? or ent.id_dep_nur= ?)");
		param.addParam(IEnDictCodeConst.SD_STATUS_IPPRE_DEP_ENTER);
		param.addParam(id_dep);
		param.addParam(id_dep);
		PagingServiceImpl<EnIppreInfoDTO> pageQryService = new PagingServiceImpl<EnIppreInfoDTO>();
        return pageQryService.findByPageInfo(new EnIppreInfoDTO(), pageInfo, str.toString(), null, param);
	}
}
