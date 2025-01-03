package iih.ci.ord.s.ems.copy.op.fullcopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrConsApAuditDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.i.ICiorappconsultCudService;
import iih.ci.ord.copy.dto.ConsCopyDTO;
import iih.ci.ord.copy.dto.OrderCopyDTO;
import iih.ci.ord.copy.dto.RisCopyDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 会诊医嘱完全复制
 * @author zhangwq
 *
 */
public class ConsCopyBP extends BaseCopyBP {
	

	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdCopyMap().keySet();
		List<CiorappconsultAggDO> newdos = new ArrayList<CiorappconsultAggDO>();
		for (String sourceIdOr : keys) {
			ConsCopyDTO CopyDTO  = (ConsCopyDTO)this.getOrdCopyMap().get(sourceIdOr);
			newdos.add(CopyDTO.getCiorappconsultAggDO());
		}
		ICiorappconsultCudService service = ServiceFinder.find(ICiorappconsultCudService.class);
		service.save(newdos.toArray(new CiorappconsultAggDO[0]));
	}
	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdCopyMap().keySet().toArray(new String[0]);
		if(id_ors == null || id_ors.length ==0){
			return;
		}
		CiorappconsultAggDO[] consaggs = getCiorappconsultAggDOs(id_ors);
		if(consaggs == null || consaggs.length ==0){
			return;
		}
		String[] id_apcons = new DBUtil().getOIDs(consaggs.length);
		int index = 0;
		for (CiorappconsultAggDO consagg : consaggs) {
			CiorappconsultAggDO copyagg = (CiorappconsultAggDO)consagg.clone();
			ConsCopyDTO consCopyDTO  = (ConsCopyDTO)this.getOrdCopyMap().get(consagg.getParentDO().getId_or());
			OrdApConsDO copyConsDO = copyagg.getParentDO();
			copyConsDO.setStatus(DOStatus.NEW);
			copyConsDO.setId_or(consCopyDTO.getCiOrderDO().getId_or());
			copyConsDO.setId_apcons(id_apcons[index++]);
			copyConsDO.setNo_applyform(consCopyDTO.getCiOrderDO().getApplyno());
			
			CiordInviteConsDO[] copyInvites = copyagg.getCiordInviteConsDO();
			if(copyInvites != null && copyInvites.length >0){
				for (CiordInviteConsDO ciordInviteConsDO : copyInvites) {
					ciordInviteConsDO.setId_invitecons(null);
					ciordInviteConsDO.setId_apcons(copyConsDO.getId_apcons());
					ciordInviteConsDO.setStatus(DOStatus.NEW);
				}
			}
			OrConsApAuditDO[] apAudits = copyagg.getOrConsApAuditDO();
			if(apAudits != null && apAudits.length >0){
				for (OrConsApAuditDO apAuditDO : apAudits) {
					apAuditDO.setId_reviewcons(null);
					apAuditDO.setId_apcons(copyConsDO.getId_apcons());
					apAuditDO.setStatus(DOStatus.NEW);
				}
			}
			consCopyDTO.setCiorappconsultAggDO(copyagg);
		}
	}
	/**
	 * 查询CiorappconsultAggDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private CiorappconsultAggDO[] getCiorappconsultAggDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrappconsultQryService().find(
				OrdApConsDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}@Override
	protected OrderCopyDTO createOrdCopyDTO() {
		return new ConsCopyDTO();
	}
	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS);
	}
}
