package iih.ci.ord.s.ems.copy.op.fullcopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cior.i.ICiorapppathgyCudService;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.copy.dto.DrugCopyDTO;
import iih.ci.ord.copy.dto.LisCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.PathgyCopyDTO;
import iih.ci.ord.copy.dto.RisCopyDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 病理完全复制逻辑
 * @author zhangwq
 *
 */
public class PathgyCopyBP extends BaseCopyBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<CiorapppathgyAggDO> newdos = new ArrayList<CiorapppathgyAggDO>();
		for (String sourceIdOr : keys) {
			PathgyCopyDTO lisCopyDTO  = (PathgyCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(lisCopyDTO.getCiorapppathgyAggDO());
		}
		ICiorapppathgyCudService service = ServiceFinder.find(ICiorapppathgyCudService.class);
		service.save(newdos.toArray(new CiorapppathgyAggDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorapppathgyRService service = ServiceFinder.find(ICiorapppathgyRService.class);
		CiorapppathgyAggDO[] pathgyAggs = service.findByAttrValStrings(OrdApPathgyDO.ID_OR, id_ors);
		if(pathgyAggs == null || pathgyAggs.length ==0){
			return;
		}
		String[] id_appathgys = new DBUtil().getOIDs(pathgyAggs.length);
		int index = 0;
		for (CiorapppathgyAggDO pathgyAggDO : pathgyAggs) {
			CiorapppathgyAggDO copydo = (CiorapppathgyAggDO)pathgyAggDO.clone();
			PathgyCopyDTO pathgyCopyDTO  = (PathgyCopyDTO)this.getOrdCopyMap().get(pathgyAggDO.getParentDO().getId_or());
			copydo.getParentDO().setStatus(DOStatus.NEW);
			copydo.getParentDO().setId_or(pathgyCopyDTO.getCiOrderDO().getId_or());
			copydo.getParentDO().setId_appathgy(id_appathgys[index++]);
			copydo.getParentDO().setNo_applyform(pathgyCopyDTO.getCiOrderDO().getApplyno());
			
			OrdApPathgySampDO[] copySampDOs =  copydo.getOrdApPathgySampDO();
			if(copySampDOs != null && copySampDOs.length > 0){
				for (OrdApPathgySampDO ordApPathgySampDO : copySampDOs) {
					ordApPathgySampDO.setStatus(DOStatus.NEW);
					ordApPathgySampDO.setId_appathgy(copydo.getParentDO().getId_appathgy());
					ordApPathgySampDO.setId_appathgysamp(null);
				}
			}
			
			pathgyCopyDTO.setCiorapppathgyAggDO(copydo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new PathgyCopyDTO();
	}
	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI);
	}
}
