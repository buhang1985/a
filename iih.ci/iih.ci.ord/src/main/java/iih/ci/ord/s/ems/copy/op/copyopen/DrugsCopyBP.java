package iih.ci.ord.s.ems.copy.op.copyopen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.copy.dto.DrugCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品复制开立逻辑
 * @author zhangwq
 *
 */
public class DrugsCopyBP extends BaseCopyOpenBP {
	

	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<OrdSrvMmDO> ordSrvMMs = new ArrayList<OrdSrvMmDO>();
		for (String sourceIdOr : keys) {
			DrugCopyDTO ordCopyDTO =  (DrugCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			if(ordCopyDTO.getOrdSrvMmDO() != null && ordCopyDTO.getOrdSrvMmDO().size() >0){
				ordSrvMMs.addAll(ordCopyDTO.getOrdSrvMmDO());
			}
		}
		IOrdsrvmmCudService service = ServiceFinder.find(IOrdsrvmmCudService.class);
		service.save(ordSrvMMs.toArray(new OrdSrvMmDO[0]));
	}
	@Override
	protected void copyApSheet() throws BizException {
		List<CiorderAggDO> sourceAggs = this.getSourceOrdAggs();
		List<String> sourceIdorsrvs = new ArrayList<String>();
		for (CiorderAggDO aggDo : sourceAggs) {
			OrdSrvDO[] ordSrvDOs = aggDo.getOrdSrvDO();
			if(ordSrvDOs == null || ordSrvDOs.length == 0){
				continue;
			}
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				sourceIdorsrvs.add(ordSrvDO.getId_orsrv());
			}
		}
		if(sourceIdorsrvs.size() == 0){
			return;
		}
		IOrdsrvmmRService mRService = ServiceFinder.find(IOrdsrvmmRService.class);
		OrdSrvMmDO[] srvMmArrays = mRService.findByAttrValStrings(OrdSrvMmDO.ID_ORSRV, sourceIdorsrvs.toArray(new String[0]));
		if(srvMmArrays == null || srvMmArrays.length == 0){
			return;
		}
		Map<String,OrdSrvMmDO> mmMap = cfMM(srvMmArrays);
		Set<String> keys = this.getOrdCopyMap().keySet();
		for (String sourceIdOr : keys) {
			DrugCopyDTO ordCopyDTO =  (DrugCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			CiorderAggDO sourceAgg = ordCopyDTO.getSourceCiorderAggDO();
			OrdSrvDO[] sourceSrvDOs = sourceAgg.getOrdSrvDO();
			List<OrdSrvMmDO> srvmms = new ArrayList<OrdSrvMmDO>();
			for (OrdSrvDO ordSrvDO : sourceSrvDOs) {
				String id_orsrv = ordSrvDO.getId_orsrv();
				if(mmMap.containsKey(id_orsrv)){
					OrdSrvMmDO sourceMMdo = mmMap.get(id_orsrv);
					OrdSrvMmDO copyMmdo = (OrdSrvMmDO)sourceMMdo.clone();
					
					copyMmdo.setStatus(DOStatus.NEW);
					copyMmdo.setId_orsrv(ordCopyDTO.getMapIdorsrv().get(id_orsrv));
					copyMmdo.setId_orsrvmm(null);
					
					srvmms.add(copyMmdo);
				}
			}
			ordCopyDTO.setOrdSrvMmDO(srvmms);
		}
	}
	/**
	 * 将物品放入键值对中
	 * @param srvMmArrays
	 * @return
	 */
	private Map<String,OrdSrvMmDO> cfMM(OrdSrvMmDO[] srvMmArrays){
		Map<String,OrdSrvMmDO> map = new HashMap<String,OrdSrvMmDO>();
		for (OrdSrvMmDO ordSrvMmDO : srvMmArrays) {
			map.put(ordSrvMmDO.getId_orsrv(), ordSrvMmDO);
		}
		return map;
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new DrugCopyDTO();
	}

}
