package iih.ci.ord.s.bp.order.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.dto.confirm.OrConfirmRstDTO;
import iih.ci.ord.dto.confirm.OrConfirmVerifyParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 医嘱确认校验
 * @author 张万青
 *
 */
public class OrConfirmVerifyChkAction extends OrConfirmVerifyAction{
	
	private ICiorderMDORService orderRService;

	public OrConfirmVerifyChkAction(OrConfirmVerifyParamDTO verifyParam) {
		super(verifyParam);
		orderRService = ServiceFinder.find(ICiorderMDORService.class);
	}

	@Override
	public OrConfirmRstDTO exec() throws BizException {
		FArrayList id_ors_chk = this.getVerifyParam().getId_ors_chk();
		if(id_ors_chk == null || id_ors_chk.size()==0){
			return null;
		}
		CiOrderDO[] orders =  orderRService.findByBIds((String[])id_ors_chk.toArray(new String[0]), FBoolean.FALSE);
		//筛选出检验医嘱
		List<String> orderList = new ArrayList<String>();
		if(orders != null && orders.length>0){
			for (CiOrderDO ciOrderDO : orders) {
				if(StringUtils.isNotEmpty(ciOrderDO.getSd_srvtp())&&ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){
					orderList.add(ciOrderDO.getId_or());
				}
			}
		}
		if(orderList.size()>0){
			Map<String,RelMergeOrdersBean> relMergeOrderMap = getRelMergeOrders(orderList);
			if(relMergeOrderMap != null){
				FArrayList id_ors_error = new FArrayList();
				StringBuilder errorStr = new StringBuilder();
				for (String idor : orderList) {
					if(relMergeOrderMap.containsKey(idor)){
						RelMergeOrdersBean relMerge = relMergeOrderMap.get(idor);
						List<String> allRelOrs = relMerge.getLisOrs();
						if(!orderList.containsAll(allRelOrs)){
							id_ors_error.add(idor);
							String errorMessage = "【"+ relMerge.getStrOrdNames()+"】";
							if(errorStr.indexOf(errorMessage) == -1){
								errorStr.append(errorMessage);
							}
						}
					}
				}
				if(id_ors_error.size()>0){
					OrConfirmRstDTO rst = new OrConfirmRstDTO();
					errorStr.append(",医嘱已合单需要一起确认");
					rst.setError_message(errorStr.toString());
					rst.setId_ors_error(id_ors_error);
					return rst;
				}
			}
		}
		return null;
	}
	/**
	 * 获取合单医嘱的所有医嘱
	 * @param ids
	 * @return
	 * @throws DAException 
	 */
	private Map<String,RelMergeOrdersBean> getRelMergeOrders(List<String> ids) throws DAException{
		String sql = "select lisor.id_or as chkidor,c.id_or,c.name_or,lisor.id_ciapplissheet from ci_app_lis_or lisor inner join ci_app_lis_or lisor1 on lisor.id_ciapplissheet = lisor1.id_ciapplissheet inner join ci_order c on c.id_or = lisor1.id_or where c.fg_chk ='N' and ";
		sql += SqlUtils.getInSqlByIds("lisor.id_or", ids);
		DAFacade facade = new DAFacade();
		List<Map<String,Object>> lisMaps = (List<Map<String,Object>>)facade.execQuery(sql, new MapListHandler());
		if(lisMaps != null && lisMaps.size() > 0){
			Map<String,RelMergeOrdersBean> tempBean = new HashMap<String,RelMergeOrdersBean>();
			Map<String,RelMergeOrdersBean> chkOrtempBean = new HashMap<String,RelMergeOrdersBean>();
			for (Map<String, Object> map : lisMaps) {
				String chkidor = map.get("chkidor").toString();
				String id_or = map.get("id_or").toString();
				String name_or = map.get("name_or").toString();
				String id_ciapplissheet = map.get("id_ciapplissheet").toString();
				if(tempBean.containsKey(id_ciapplissheet)){
					tempBean.get(id_ciapplissheet).getLisOrs().add(id_or);
					tempBean.get(id_ciapplissheet).setStrOrdNames(tempBean.get(id_ciapplissheet).getStrOrdNames()+","+name_or);
				}else{
					RelMergeOrdersBean dto = new RelMergeOrdersBean();
					dto.setId_ciapplissheet(id_ciapplissheet);
					List<String> idors = new ArrayList<String>();
					idors.add(id_or);
					dto.setLisOrs(idors);
					dto.setStrOrdNames(name_or);
					tempBean.put(id_ciapplissheet,dto);
				}
				if(!chkOrtempBean.containsKey(chkidor)){
					chkOrtempBean.put(chkidor, tempBean.get(id_ciapplissheet));
				}
			}
			return chkOrtempBean;
		}
		return null;
	}
	public class RelMergeOrdersBean{
		//一个单据中所有的医嘱
		private List<String> lisOrs;
		//所属单据
		private String id_ciapplissheet;
		//一个单据中所有医嘱名称的拼接
		private String strOrdNames;
		public List<String> getLisOrs() {
			return lisOrs;
		}
		public void setLisOrs(List<String> lisOrs) {
			this.lisOrs = lisOrs;
		}
		public String getId_ciapplissheet() {
			return id_ciapplissheet;
		}
		public void setId_ciapplissheet(String id_ciapplissheet) {
			this.id_ciapplissheet = id_ciapplissheet;
		}
		public String getStrOrdNames() {
			return strOrdNames;
		}
		public void setStrOrdNames(String strOrdNames) {
			this.strOrdNames = strOrdNames;
		}
		
	}
}
