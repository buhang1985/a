package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.i.IOrderCopy;
import iih.ci.ord.copy.i.IOrderValidate;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

public abstract class BaseCopyOpenBP implements IOrderCopy {
	private IOrderValidate orderValidate;
	private Map<String,OrderCopyDTO> ordCopyMap;
	private List<CiorderAggDO> sourceOrdAggs;
	private OrderOperateDTO orderOperateDTO;
	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, List<CiorderAggDO> ordAggs) throws BizException {
		this.sourceOrdAggs = ordAggs;
		// 复制医嘱
		copyOrders(ordAggs);
		// 复制服务
		copyOrSrvDO();
		this.copySrvSets();
		// 复制申请单
		this.copyApSheet();
		// 校验逻辑
		if (orderValidate != null) {
			
		}
		this.save();
		OrderRstDTO orderRstDTO = new OrderRstDTO();
		orderRstDTO.setIsSuccess(FBoolean.TRUE);
		return orderRstDTO;
	}
	/**
	 * 保存医嘱开始
	 * @throws BizException
	 */
	protected void save() throws BizException {
		Set<String> keys = ordCopyMap.keySet();
		List<CiorderAggDO> newAggDOs = new ArrayList<CiorderAggDO>();
		for (String sourceIdOr : keys) {
			OrderCopyDTO ordCopyDTO =  ordCopyMap.get(sourceIdOr);
			CiorderAggDO aggdo = new CiorderAggDO();
			aggdo.setParentDO(ordCopyDTO.getCiOrderDO());
			aggdo.setOrdSrvDO(ordCopyDTO.getOrdSrvDO().toArray(new OrdSrvDO[0]));
			newAggDOs.add(aggdo);
		}
		ICiorderCudService service = ServiceFinder.find(ICiorderCudService.class);
		service.save(newAggDOs.toArray(new CiorderAggDO[0]));
	}

	protected void copyApSheet() throws BizException  {

	}
	/**
	 * 复制套数据
	 * @throws BizException
	 */
	protected void copySrvSets() throws BizException {
		String[] id_ors = this.ordCopyMap.keySet().toArray(new String[0]);
		IOrdsrvsetRService setRService = ServiceFinder.find(IOrdsrvsetRService.class);
		OrdSrvSetDO[] ordSrvSets = setRService.findByAttrValStrings(OrdSrvSetDO.ID_OR, id_ors);
		if(ordSrvSets == null || ordSrvSets.length ==0){
			return;
		}
		Map<String,List<OrdSrvSetDO>> map = new HashMap<String,List<OrdSrvSetDO>>();
		for (OrdSrvSetDO ordSrvSetDO : ordSrvSets) {
			if(map.containsKey(ordSrvSetDO.getId_or())){
				map.get(ordSrvSetDO.getId_or()).add(ordSrvSetDO);
			}else{
				List<OrdSrvSetDO> list = new ArrayList<OrdSrvSetDO>();
				list.add(ordSrvSetDO);
				map.put(ordSrvSetDO.getId_or(),list);
			}
		}
		Iterator<String> keyIterator = map.keySet().iterator();
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			OrderCopyDTO ordCopyDTO = this.ordCopyMap.get(key);
			List<OrdSrvSetDO> setList = map.get(key);
			List<OrdSrvSetDO> copySetList = new ArrayList<OrdSrvSetDO>();
			for (OrdSrvSetDO ordSrvSetDO : setList) {
				OrdSrvSetDO copySetDO = (OrdSrvSetDO)ordSrvSetDO.clone();
				copySetDO.setStatus(DOStatus.NEW);
				copySetDO.setId_or(ordCopyDTO.getCiOrderDO().getId_or());
				copySetDO.setId_orsrvset(null);
				
				copySetList.add(copySetDO);
			}
			ordCopyDTO.setOrdSrvSetDO(copySetList);
		}
	}

	protected void copyOrSrvDO() {
		Set<String> keys = ordCopyMap.keySet();
		for (String sourceIdOr : keys) {
			OrderCopyDTO ordCopyDTO =  ordCopyMap.get(sourceIdOr);
			CiorderAggDO sourceAgg = ordCopyDTO.getSourceCiorderAggDO();
			OrdSrvDO[] OrSrvDOs = sourceAgg.getOrdSrvDO();
			String[] idors = new DBUtil().getOIDs(OrSrvDOs.length);
			List<OrdSrvDO> ciOrSrvs = new ArrayList<OrdSrvDO>();
			int index = 0;
			Map<String,String> mapIdorsrvs  = new HashMap<String,String>();
			for(OrdSrvDO sourceSrv : OrSrvDOs){
				OrdSrvDO srv = (OrdSrvDO)sourceSrv.clone();
				srv.setStatus(DOStatus.NEW);
				
				srv.setId_or(ordCopyDTO.getCiOrderDO().getId_or());
				srv.setId_orsrv(idors[index++]);
				
				mapIdorsrvs.put(sourceSrv.getId_orsrv(), srv.getId_orsrv());

				ciOrSrvs.add(srv);
			}
			ordCopyDTO.setMapIdorsrv(mapIdorsrvs);
			ordCopyDTO.setOrdSrvDO(ciOrSrvs);
		}
	}
	/**
	 * 复制医嘱
	 * @param ordAggs
	 * @throws BizException 
	 */
	protected void copyOrders(List<CiorderAggDO> ordAggs) throws BizException {
		String[] idors = new DBUtil().getOIDs(ordAggs.size());
		int index = 0;
		for (CiorderAggDO orderAggDO : ordAggs) {
			OrderCopyDTO ordCopyDTO = createOrdCopyDTO();
			CiOrderDO sourceCiOrderDO = orderAggDO.getParentDO();
			CiOrderDO copyOrder = (CiOrderDO)sourceCiOrderDO.clone();
			copyOrder.setStatus(DOStatus.NEW);
			copyOrder.setCode_or(CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
			copyOrder.setApplyno(getApplyNo());
			copyOrder.setId_or(idors[index++]);
			
			copyOrder.setId_emp_sign(null);
			copyOrder.setId_emp_canc(null);
			copyOrder.setId_dep_sign(null);
			
			copyOrder.setDt_sign(null);
			copyOrder.setDt_canc(null);
			
			copyOrder.setFg_sign(FBoolean.FALSE);
			copyOrder.setFg_canc(FBoolean.FALSE);
			copyOrder.setId_emp_canc(null);
			copyOrder.setDt_canc(null);
			
			ordCopyDTO.setCiOrderDO(copyOrder);
			ordCopyDTO.setSourceCiorderAggDO(orderAggDO);
			if(!this.ordCopyMap.containsKey(sourceCiOrderDO.getId_or())){
				this.ordCopyMap.put(sourceCiOrderDO.getId_or(), ordCopyDTO);
			}
		}
	}
	/**
	 * 创建复制的数据载体
	 * @return
	 */
	protected OrderCopyDTO createOrdCopyDTO() {
		return new OrderCopyDTO();
	}
	/**
	 * 获取医嘱申请单号
	 * @return
	 */
	protected String getApplyNo(){
		return "";
	}

	public IOrderValidate getOrderValidate() {
		return orderValidate;
	}

	public void setOrderValidate(IOrderValidate orderValidate) {
		this.orderValidate = orderValidate;
	}

	public Map<String, OrderCopyDTO> getOrdCopyMap() {
		return ordCopyMap;
	}

	public void setOrdCopyMap(Map<String, OrderCopyDTO> ordCopyMap) {
		this.ordCopyMap = ordCopyMap;
	}

	public List<CiorderAggDO> getSourceOrdAggs() {
		return sourceOrdAggs;
	}

	public void setSourceOrdAggs(List<CiorderAggDO> sourceOrdAggs) {
		this.sourceOrdAggs = sourceOrdAggs;
	}
	public OrderOperateDTO getOrderOperateDTO() {
		return orderOperateDTO;
	}
	public void setOrderOperateDTO(OrderOperateDTO orderOperateDTO) {
		this.orderOperateDTO = orderOperateDTO;
	}

}
