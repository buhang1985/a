package iih.ci.ord.s.ems.copy.op.fullcopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.cior.i.ICiorappbuRService;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.copy.dto.BuCopyDTO;
import iih.ci.ord.copy.dto.DrugCopyDTO;
import iih.ci.ord.copy.dto.LisCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.RisCopyDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验完全复制逻辑
 * @author zhangwq
 *
 */
public class BuCopyBP extends BaseCopyBP {
	
	/**
	 * 保存数据
	 */
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<OrdAppBtUseDO> newdos = new ArrayList<OrdAppBtUseDO>();
		for (String sourceIdOr : keys) {
			BuCopyDTO buCopyDTO  = (BuCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(buCopyDTO.getOrdAppBtUseDO());
		}
		ICiorappbuCudService service = ServiceFinder.find(ICiorappbuCudService.class);
		service.save(newdos.toArray(new OrdAppBtUseDO[0]));
	}
	/**
	 * 复制申请单数据
	 */
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		ICiorappbuRService service = ServiceFinder.find(ICiorappbuRService.class);
		OrdAppBtUseDO[] ordApObss = service.findByAttrValStrings(OrdAppBtUseDO.ID_OR, id_ors);
		if(ordApObss == null || ordApObss.length ==0){
			return;
		}
		for (OrdAppBtUseDO btusedo : ordApObss) {
			OrdAppBtUseDO copydo = (OrdAppBtUseDO)btusedo.clone();
			BuCopyDTO buCopyDTO  = (BuCopyDTO)this.getOrdCopyMap().get(btusedo.getId_or());
			copydo.setStatus(DOStatus.NEW);
			copydo.setId_or(buCopyDTO.getCiOrderDO().getId_or());
			copydo.setId_apbu(null);
			copydo.setNo_applyform(buCopyDTO.getCiOrderDO().getApplyno());
			
			buCopyDTO.setOrdAppBtUseDO(copydo);
		}
	}
	@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new BuCopyDTO();
	}
	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE);
	}
}
