package iih.ci.ord.s.ems.copy.op.fullcopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.cior.i.ICiorappsurgeryCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.copy.dto.DrugCopyDTO;
import iih.ci.ord.copy.dto.LisCopyDTO;
import iih.ci.ord.copy.dto.OpSugCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.RisCopyDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 手术完全复制逻辑
 * @author zhangwq
 *
 */
public class OpsugCopyBP extends BaseCopyBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<CiorappsurgeryAggDO> newdos = new ArrayList<CiorappsurgeryAggDO>();
		for (String sourceIdOr : keys) {
			OpSugCopyDTO lisCopyDTO  = (OpSugCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(lisCopyDTO.getCiorappsurgeryAggDO());
		}
		ICiorappsurgeryCudService service = ServiceFinder.find(ICiorappsurgeryCudService.class);
		service.save(newdos.toArray(new CiorappsurgeryAggDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorappsurgeryRService service = ServiceFinder.find(ICiorappsurgeryRService.class);
		CiorappsurgeryAggDO[] apdos = service.findByAttrValStrings(OrdApOpDO.ID_OR, id_ors);
		if(apdos == null || apdos.length ==0){
			return;
		}
		String[] id_sugs = new DBUtil().getOIDs(apdos.length);
		int index = 0;
		for (CiorappsurgeryAggDO agg : apdos) {
			CiorappsurgeryAggDO copyAggdo = (CiorappsurgeryAggDO)agg.clone();
			OpSugCopyDTO copydto  = (OpSugCopyDTO)this.getOrdCopyMap().get(agg.getParentDO().getId_or());
			
			copyAggdo.getParentDO().setStatus(DOStatus.NEW);
			copyAggdo.getParentDO().setId_or(copydto.getCiOrderDO().getId_or());
			copyAggdo.getParentDO().setId_apop(id_sugs[index++]);
			copyAggdo.getParentDO().setNo_applyform(copydto.getCiOrderDO().getApplyno());
			//手术人员
			OrdOpEmpDO[] ordOpEmps = copyAggdo.getOrdOpEmpDO();
			if(ordOpEmps != null &&ordOpEmps.length >0){
				for (OrdOpEmpDO ordOpEmpDO : ordOpEmps) {
					ordOpEmpDO.setStatus(DOStatus.NEW);
					ordOpEmpDO.setId_apop(copyAggdo.getParentDO().getId_apop());
					
					ordOpEmpDO.setId_apopemp(null);
				}
			}
			//动态指标
			OrdApSugViewItemDO[] viewItems = copyAggdo.getOrdApSugViewItemDO();
			if(viewItems != null &&viewItems.length >0){
				for (OrdApSugViewItemDO item : viewItems) {
					item.setStatus(DOStatus.NEW);
					item.setId_apop(copyAggdo.getParentDO().getId_apop());
					
					item.setId_apopobsindex(null);
				}
			}
			//卫材
			OrdOpMmDO[] ordOpMmDOs = copyAggdo.getOrdOpMmDO();
			if(ordOpMmDOs != null &&ordOpMmDOs.length >0){
				for (OrdOpMmDO opmm : ordOpMmDOs) {
					opmm.setStatus(DOStatus.NEW);
					opmm.setId_apop(copyAggdo.getParentDO().getId_apop());
					
					opmm.setId_apopmm(null);
				}
			}
			//二次手术申请
			copyAggdo.setOrdApOpAgainDO(null);
			
			copydto.setCiorappsurgeryAggDO(copyAggdo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new OpSugCopyDTO();
	}
	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_OP);
	}
}
