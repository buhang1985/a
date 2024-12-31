package iih.ci.ord.s.ems.copy.op.fullcopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.RisCopyDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验完全复制逻辑
 * @author zhangwq
 *
 */
public class RisCopyBP extends DrugsCopyBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<OrdApObsDO> newObsdos = new ArrayList<OrdApObsDO>();
		List<OrdSrvMmDO> ordSrvMMs = new ArrayList<OrdSrvMmDO>();
		for (String sourceIdOr : keys) {
			RisCopyDTO lisCopyDTO  = (RisCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newObsdos.add(lisCopyDTO.getOrdApLabDO());
			if(lisCopyDTO.getOrdSrvMmDO() != null && lisCopyDTO.getOrdSrvMmDO().size() >0){
				ordSrvMMs.addAll(lisCopyDTO.getOrdSrvMmDO());
			}
		}
		ICiorapprisCudService service = ServiceFinder.find(ICiorapprisCudService.class);
		service.save(newObsdos.toArray(new OrdApObsDO[0]));
		if(ordSrvMMs.size() > 0){
			IOrdsrvmmCudService mmService = ServiceFinder.find(IOrdsrvmmCudService.class);
			mmService.save(ordSrvMMs.toArray(new OrdSrvMmDO[0]));	
		}
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorapprisRService service = ServiceFinder.find(ICiorapprisRService.class);
		OrdApObsDO[] ordApObss = service.findByAttrValStrings(OrdApObsDO.ID_OR, id_ors);
		if(ordApObss == null || ordApObss.length ==0){
			return;
		}
		for (OrdApObsDO ordApObsDO : ordApObss) {
			OrdApObsDO copydo = (OrdApObsDO)ordApObsDO.clone();
			RisCopyDTO lisCopyDTO  = (RisCopyDTO)this.getOrdCopyMap().get(ordApObsDO.getId_or());
			copydo.setStatus(DOStatus.NEW);
			copydo.setId_or(lisCopyDTO.getCiOrderDO().getId_or());
			copydo.setId_orobs(null);
			copydo.setNo_applyform(lisCopyDTO.getCiOrderDO().getApplyno());
			
			lisCopyDTO.setOrdApObsDO(copydo);
		}
		
		List<CiorderAggDO> sourceAggs = this.getSourceOrdAggs();
		List<String> sourceIdorsrvs = new ArrayList<String>();
		for (CiorderAggDO aggDo : sourceAggs) {
			OrdSrvDO[] ordSrvDOs = aggDo.getOrdSrvDO();
			if(ordSrvDOs == null || ordSrvDOs.length == 0){
				continue;
			}
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				if(FBoolean.TRUE.equals(ordSrvDO.getFg_mm())){
					sourceIdorsrvs.add(ordSrvDO.getId_orsrv());
				}
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
			RisCopyDTO ordCopyDTO =  (RisCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
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
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new RisCopyDTO();
	}
	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_RIS);
	}
}
