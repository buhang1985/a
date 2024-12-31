package iih.ci.preop.order.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.preop.order.dto.OrdPreopDTO;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.d.CiTsOrSrvDO;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.d.desc.CiTsOrDODesc;
import iih.ci.tsip.i.ICiTsOrSrvDOCudService;
import iih.ci.tsip.i.ICiTsOrSrvSetDOCudService;
import iih.ci.tsip.i.ICitsorderMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
/**
 * 预住院复制逻辑基类
 * @author zhangwq
 *
 */
public class BasePreopCopyBP {
	private Map<String,OrdPreopDTO> ordPreopMap;
	private IPreopValidate preopValidate;
	private CiEnContextDTO ctx;
	private FDateTime dateTime;
	public BasePreopCopyBP(){
		ordPreopMap = new HashMap<String,OrdPreopDTO>();
		dateTime = CiOrdAppUtils.getServerDateTime();
	}
	/**
	 * 复制
	 */
	public OrderRstDTO copy(CiEnContextDTO ctx,List<CitsorderAggDO> ordAggs) throws BizException{
		//复制医嘱
		copyOrders(ordAggs);
		//复制服务
		copyOrSrvDO();
		this.copySrvSets();
		//复制申请单
		this.copyApSheet();
		//校验逻辑
		if(preopValidate !=null){
			List<OrdPreopDTO> preopList = new ArrayList<OrdPreopDTO>();
			preopList.addAll(ordPreopMap.values());
			OrderRstDTO rst = preopValidate.validate(ctx, preopList);
			if(FBoolean.FALSE.equals(rst.getIsSuccess())){
				return rst;
			}
		}
		this.save();
		OrderRstDTO orderRstDTO = new OrderRstDTO();
		orderRstDTO.setIsSuccess(FBoolean.TRUE);
		return orderRstDTO;
	}
	/**
	 * 保存复制后的数据
	 * @throws BizException
	 */
	protected void save() throws BizException {
		Set<String> keys = ordPreopMap.keySet();
		List<CiTsOrDO> ciTsOrs = new ArrayList<CiTsOrDO>();
		List<CiTsOrSrvDO> ciTsOrSrvs = new ArrayList<CiTsOrSrvDO>();
		List<CiTsOrSrvSetDO> ciTsOrSrvSets = new ArrayList<CiTsOrSrvSetDO>();
		for (String sourceIdOr : keys) {
			OrdPreopDTO ordPreopDTO =  ordPreopMap.get(sourceIdOr);
			CiTsOrDO ciTsOrDO = ordPreopDTO.getCiTsOrDO();
			ciTsOrs.add(ciTsOrDO);
			ciTsOrSrvs.addAll(ordPreopDTO.getCiTsOrSrvDO());
			List<CiTsOrSrvSetDO> srvSets = ordPreopDTO.getCiTsOrSrvSetDO();
			if(srvSets != null){
				ciTsOrSrvSets.addAll(srvSets);
			}
		}
		ICitsorderMDOCudService orderMService = ServiceFinder.find(ICitsorderMDOCudService.class);
		orderMService.save(ciTsOrs.toArray(new CiTsOrDO[0]));
		
		ICiTsOrSrvDOCudService srvMService = ServiceFinder.find(ICiTsOrSrvDOCudService.class);
		srvMService.save(ciTsOrSrvs.toArray(new CiTsOrSrvDO[0]));
		if(ciTsOrSrvSets.size() > 0){
			ICiTsOrSrvSetDOCudService srvSetMService = ServiceFinder.find(ICiTsOrSrvSetDOCudService.class);
			srvSetMService.save(ciTsOrSrvs.toArray(new CiTsOrSrvSetDO[0]));
		}
	}
	/**
	 * 复制医嘱项目
	 * @param ordAggs
	 * @throws BizException
	 */
	protected void copyOrders(List<CitsorderAggDO> ordAggs) throws BizException{
		String[] idors = new DBUtil().getOIDs(ordAggs.size());
		int index = 0;
		for (CitsorderAggDO citsorderAggDO : ordAggs) {
			OrdPreopDTO ordPreopDTO = createOrdPreopDTO();
			CiTsOrDO sourceCiTsOrDO = citsorderAggDO.getParentDO();
			CiTsOrDO copyOrder = (CiTsOrDO)sourceCiTsOrDO.clone();
			copyOrder.setStatus(DOStatus.NEW);
			copyOrder.setCode_or(CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiTsOrDODesc.CLASS_FULLNAME));
			copyOrder.setId_en(ctx.getId_en());
			copyOrder.setId_tsor(idors[index++]);
			
			copyOrder.setDt_create(dateTime);
			copyOrder.setDt_effe(dateTime);
			if(sourceCiTsOrDO.getDt_end() != null){
				copyOrder.setDt_end(new FDateTime(copyOrder.getDt_effe().getMillis() + (sourceCiTsOrDO.getDt_end().getMillis() - sourceCiTsOrDO.getDt_effe().getMillis())));
			}
			
			copyOrder.setId_org_create(ctx.getId_org());
			copyOrder.setId_dep_create(ctx.getId_dep_or());
			copyOrder.setId_dep_nur_create(ctx.getId_dep_ns());
			copyOrder.setId_emp_create(ctx.getId_emp_or());
			copyOrder.setId_wg_create(ctx.getId_wg_or());
			
			copyOrder.setFg_sign(FBoolean.FALSE);
			copyOrder.setFg_canc(FBoolean.FALSE);
			copyOrder.setId_emp_canc(null);
			copyOrder.setDt_canc(null);
			
			ordPreopDTO.setCiTsOrDO(copyOrder);
			ordPreopDTO.setSourceCitsorderAggDO(citsorderAggDO);
			if(!this.ordPreopMap.containsKey(sourceCiTsOrDO.getId_tsor())){
				this.ordPreopMap.put(sourceCiTsOrDO.getId_tsor(), ordPreopDTO);
			}
		}
	}
	/**
	 * 治疗方案医嘱服务项目
	 */
	protected void copyOrSrvDO() {
		Set<String> keys = ordPreopMap.keySet();
		for (String sourceIdOr : keys) {
			OrdPreopDTO ordPreopDTO =  ordPreopMap.get(sourceIdOr);
			CitsorderAggDO sourceAgg = ordPreopDTO.getSourceCitsorderAggDO();
			CiTsOrSrvDO[] ciTsOrSrvDOs = sourceAgg.getCiTsOrSrvDO();
			List<CiTsOrSrvDO> ciTsOrSrvs = new ArrayList<CiTsOrSrvDO>();
			for(CiTsOrSrvDO sourceSrv : ciTsOrSrvDOs){
				CiTsOrSrvDO srv = (CiTsOrSrvDO)sourceSrv.clone();
				srv.setStatus(DOStatus.NEW);
				
				srv.setId_en(ctx.getId_en());
				srv.setId_tsor(ordPreopDTO.getCiTsOrDO().getId_tsor());
                srv.setId_org_srv(ctx.getId_org());
				srv.setId_dep_srv(ctx.getId_dep_or());
				srv.setId_dep_nur_srv(ctx.getId_dep_ns());
				srv.setId_emp_srv(ctx.getId_emp_or());
				srv.setId_wg_or(ctx.getId_wg_or());
				

				srv.setDt_create(dateTime);
				srv.setModifiedby(null);
				srv.setModifiedtime(null);
				//TODO 执行科室待完善
				//srv.setId_dep_mp("");
				ciTsOrSrvs.add(srv);
			}
			ordPreopDTO.setCiTsOrSrvDO(ciTsOrSrvs);
		}
	}
	/**
	 * 治疗方案医嘱项目服务套
	 */
	protected void copySrvSets(){

		Set<String> keys = ordPreopMap.keySet();
		for (String sourceIdOr : keys) {
			OrdPreopDTO ordPreopDTO =  ordPreopMap.get(sourceIdOr);
			CitsorderAggDO sourceAgg = ordPreopDTO.getSourceCitsorderAggDO();
			CiTsOrSrvSetDO[] ciTsOrSrvSetDOs = sourceAgg.getCiTsOrSrvSetDO();
			List<CiTsOrSrvSetDO> ciTsOrSrvSets = new ArrayList<CiTsOrSrvSetDO>();
			for(CiTsOrSrvSetDO sourceSrvSet : ciTsOrSrvSetDOs){
				CiTsOrSrvSetDO srvset = (CiTsOrSrvSetDO)sourceSrvSet.clone();
				srvset.setStatus(DOStatus.NEW);
				
				srvset.setId_tsor(ordPreopDTO.getCiTsOrDO().getId_tsor());
				srvset.setId_tsorsrv(null);
				ciTsOrSrvSets.add(srvset);
			}
			ordPreopDTO.setCiTsOrSrvSetDO(ciTsOrSrvSets);
		}
	
	}
	/**
	 * 复制申请单
	 * @throws BizException
	 */
	protected void copyApSheet() throws BizException  {
		
	}
	/**
	 * 创建预住院医嘱结合体
	 * @return
	 */
	protected OrdPreopDTO createOrdPreopDTO(){
		return new OrdPreopDTO();
	}
	public IPreopValidate getPreopValidate() {
		return preopValidate;
	}
	public void setPreopValidate(IPreopValidate preopValidate) {
		this.preopValidate = preopValidate;
	}
	public Map<String, OrdPreopDTO> getOrdPreopMap() {
		return ordPreopMap;
	}
	public void setOrdPreopMap(Map<String, OrdPreopDTO> ordPreopMap) {
		this.ordPreopMap = ordPreopMap;
	}
	public CiEnContextDTO getCtx() {
		return ctx;
	}
	public void setCtx(CiEnContextDTO ctx) {
		this.ctx = ctx;
	}
	
}
