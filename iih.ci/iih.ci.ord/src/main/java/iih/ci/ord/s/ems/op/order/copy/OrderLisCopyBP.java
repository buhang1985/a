package iih.ci.ord.s.ems.op.order.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.xbd.udi.d.UdidocDO;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.meta.LisOrContentParam;
import iih.ci.ord.s.external.thirdws.utils.UdidocUtils;

/**
 * 检验复制
 * @author Young
 *
 */
public class OrderLisCopyBP extends OrderBaseCopyBP {
	
	private String Id_or;
	
	public String getId_or() {
		return Id_or;
	}

	public void setId_or(String id_or) {
		Id_or = id_or;
	}

	/**
	 * 复制检验申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdApLabDO[] ordApLabDOs = getOrdApLabDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordApLabDOs))
			return false;
		setOrdApLabDOs(ordApLabDOs, mapIdors,dt);
		return saveOrdApLabDOs(ordApLabDOs);
	}
	
	/**
	 * 查询OrdApLabDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	protected OrdApLabDO[] getOrdApLabDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrapplisQryService()
				.find(OrdApLabDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "",
						FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdApLabDO
	 * @param ordApLabDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApLabDOs(OrdApLabDO[] ordApLabDOs, Map<String, String> mapIdors, FDateTime dt) throws BizException{
		if (CiOrdUtils.isEmpty(ordApLabDOs))
			return;
		for (OrdApLabDO ordApLabDO : ordApLabDOs) {
			ordApLabDO.setId_orlab(null);
			ordApLabDO.setId_or(mapIdors.get(ordApLabDO.getId_or()));
			this.setId_or(mapIdors.get(ordApLabDO.getId_or()));
			ordApLabDO.setNo_applyform(this.getApplyNo(ordApLabDO.getId_or()));
			ordApLabDO.setStatus(DOStatus.NEW);
			ordApLabDO.setDt_plan(CiOrdAppUtils.getServerDateTime());//计划时间
			//诊断
			CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(context.getId_en());
			if (diagOutlineInfo != null) {
				ordApLabDO.setId_diitm(diagOutlineInfo.getId_diitm());
				ordApLabDO.setName_diag(diagOutlineInfo.getName_diag());
			}
			ordApLabDO.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);
			ordApLabDO.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);
			if(this.getTeampAggs()!=null && this.getTeampAggs().containsKey(ordApLabDO.getId_or())){
				ordApLabDO.setFg_urgent(this.getTeampAggs().get(ordApLabDO.getId_or()).getParentDO().getFg_urgent());
			}
		}
	}
	
	/**
	 * 保存OrdApLabDO
	 * @param ordApLabDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApLabDOs(OrdApLabDO[] ordApLabDOs) throws BizException{
		if (CiOrdUtils.isEmpty(ordApLabDOs))
			return false;
		ordApLabDOs = CiOrdAppUtils.getOrapplisService().save(ordApLabDOs);
		return !CiOrdUtils.isEmpty(ordApLabDOs);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_LIS);
	}

	@Override
	protected void setCopyCiEmsDTOInfo(CiEmsDTO ciEmsDTO) throws BizException {
		FMap map = ciEmsDTO.getOrapplysheet();
		if(map!=null){
			OrdApLabDO lab = (OrdApLabDO)map.get(EmsType.LIS.toString());
			if(lab!=null){
				lab.setStatus(DOStatus.NEW);
				lab.setId_orlab(null);
				lab.setDt_plan(CiOrdAppUtils.getServerDateTime());// 0177532: 住院医生站，从历史记录里面开立医嘱，医疗单的默认时间需要改为现在的时间 // liyuelong 2019-11-26 修改：ciEmsDTO.getDt_begin()-->CiOrdAppUtils.getServerDateTime()
				lab.setId_or(null);
				lab.setNo_applyform(this.getApplyNo());
				lab.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);
				lab.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);
			}
		}
	}
	/**
	 * 重新组装医嘱内容
	 * @param aggDOs
	 * @param mapTeamSrvDOs
	 * @throws BizException 
	 */
	@Override
	protected void content_or(CiorderAggDO[]aggDOs,Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException {
		for (CiorderAggDO aggDO : aggDOs) {
			String id_or_old = mapNewOldKeys.get(aggDO.getParentDO().getId_or());
				OrdApLabDO[] ordApLabDOs = getOrdApLabDOs(new String[] {id_or_old});
				 //OrdApLabDO[] ordApLabDOs = iCiorapplisRService.findByAttrValString("Id_or", this.getId_or());
				//标本
				UdidocDO biaoben = UdidocUtils.getUdidocByCode("BD.SRV.0555", ordApLabDOs[0].getSd_samptp());
				//LisOrContentParam lisOrContentParam = new LisOrContentParam(ordApLabDOs[0].getId_or(),aggDO.getParentDO().getSd_srvtp(),aggDO.getParentDO().getName_or(),aggDO.getParentDO().getFg_urgent(),biaoben.getName(),aggDO.getParentDO().getDes_or(),aggDO.getParentDO().getFg_set(),getOrContentDTOs(aggDO.getOrdSrvDO(), mapTeamSrvDOs));
				LisOrContentParam lisOrContentParam = new LisOrContentParam(ordApLabDOs[0],aggDO.getParentDO(),biaoben,getOrContentDTOs(aggDO.getOrdSrvDO(), mapTeamSrvDOs));
				CiOrContentDO contentdo=new CiOrContentDO();
				Object[] params = new Object[]{contentdo,lisOrContentParam};
				BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_LIS_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
				EventDispatcher.fireEvent(event);
				aggDO.getParentDO().setContent_or(contentdo==null?"":contentdo.toString());//CiOrContentUtils.create(lisOrContentParam).toString()
		}
	}

	@Override
	protected CiEmsDTO createCiEmsDTO(ICiOrdQryService ordQryService, CiorderAggDO aggdo, boolean isAddExt,
			OrdSrvDO[] ordSrvDOs) throws BizException {
		CiEmsDTO ciEmsDTO =  super.createCiEmsDTO(ordQryService, aggdo, isAddExt, ordSrvDOs);
		FMap fMap = ciEmsDTO.getOrapplysheet();
		if(fMap != null){
			OrdApLabDO aplab = (OrdApLabDO)fMap.get(""+ciEmsDTO.getEmstype());
			aplab.setDt_plan(ciEmsDTO.getDt_begin());
			aplab.setNo_applyform(aggdo.getParentDO().getApplyno());
			aplab.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);
			aplab.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);
		} 
		return ciEmsDTO;
	}

	//0191247: 组套项目的子项及价格变更后，从历史里选择变更前的项目带出来仍是未调整的旧项目，导致费用错误
	@Override
	protected List<CiEmsSrvDTO> aggCiOrderTransferObs(CiEmsDTO ems) throws BizException {
		Map<String, MedSrvDO> mapMedSrvDOs = new HashMap<String, MedSrvDO>();
		List<CiEmsSrvDTO> ciEmsSrvList = new ArrayList<CiEmsSrvDTO>();
		List<String> headIdsrvList = new ArrayList<String>();
		FArrayList srvsList = ems.getEmssrvs();
		CiEmsSrvDTO emsMainDTO = null;
		if(!CiOrdUtils.isEmpty(srvsList)) {
			Map<String, OrdSrvSetDO> mapSrvsetitms = new HashMap<String, OrdSrvSetDO>();
			if(ems.getFg_set() != null && ems.getFg_set().equals(FBoolean.TRUE)){
				FArrayList srvSetItemList = (FArrayList) ems.getSrvsetitms().get(ems.getId_srv());
				for(Object srvSetItem : srvSetItemList){
					OrdSrvSetDO ordSrvSetDO = (OrdSrvSetDO)srvSetItem;
					if(!mapSrvsetitms.containsKey(ordSrvSetDO.getId_srvset())){
						headIdsrvList.add(ordSrvSetDO.getId_srvset());
						mapSrvsetitms.put(ordSrvSetDO.getId_srvset(), ordSrvSetDO);
					}
				}
			}
			MedSrvDO[] medSrvDOs = getMedSrvDOs(headIdsrvList);
			if(medSrvDOs != null){
				for(MedSrvDO medSrvDO : medSrvDOs){
					mapMedSrvDOs.put(medSrvDO.getId_srv(), medSrvDO);
				}
			}
			List<CiEmsSrvDTO> newDTOList = new ArrayList<CiEmsSrvDTO>();
			for(int iSrv=0;iSrv<srvsList.size();iSrv++) {
				CiEmsSrvDTO ciEmsSrvDTO = (CiEmsSrvDTO)ems.getEmssrvs().get(iSrv);						
				if(!CiOrdUtils.isEmpty(ciEmsSrvDTO) && !ems.getId_srv().equals(ciEmsSrvDTO.getId_srv())) {
					ciEmsSrvDTO.setStatus(DOStatus.DELETED);
					if(ems.getSrvsetitms() == null){
						continue;
					}
					if(mapSrvsetitms.containsKey(ciEmsSrvDTO.getId_srv())){
						CiEmsSrvDTO newDTOItem = new CiEmsSrvDTO();
						newDTOItem = (CiEmsSrvDTO)ciEmsSrvDTO.clone();
						newDTOItem.setId_srv_set(ems.getId_srv());
						newDTOItem.setStatus(DOStatus.NEW);
						newDTOList.add(newDTOItem);
						mapSrvsetitms.remove(ciEmsSrvDTO.getId_srv());
					}
				}else{
					if(ciEmsSrvDTO.getFg_set().equals(FBoolean.TRUE)){
						ciEmsSrvDTO.setStatus(DOStatus.NEW);
						newDTOList.add(ciEmsSrvDTO);
					}else{
						ciEmsSrvDTO.setStatus(DOStatus.UPDATED);
					}
					emsMainDTO = ciEmsSrvDTO;
				}
			}
			for(Object key : mapSrvsetitms.keySet()){
				OrdSrvSetDO ordSrvSetDO = mapSrvsetitms.get(key);
				MedSrvDO medSrvDO = mapMedSrvDOs.get(key);
				CiEmsSrvDTO newDTOItem = new CiEmsSrvDTO();
	            newDTOItem.setId_srv(medSrvDO.getId_srv());
	            newDTOItem.setId_freq(medSrvDO.getId_freq());
	            newDTOItem.setId_srvca(medSrvDO.getId_srvca());
	            newDTOItem.setSd_srvtp(medSrvDO.getSd_srvtp());
	            newDTOItem.setEu_blmd(medSrvDO.getEu_blmd());
	            newDTOItem.setFg_or(medSrvDO.getFg_or());
	            newDTOItem.setCode_srv(medSrvDO.getCode());
	            newDTOItem.setFg_bl(medSrvDO.getFg_bl());
	            newDTOItem.setId_srvtp(medSrvDO.getId_srvtp());
	            newDTOItem.setQuan_med(medSrvDO.getQuan_med());
	            newDTOItem.setId_unit_med(medSrvDO.getId_unit_med());
	            newDTOItem.setInnercode_srvca(medSrvDO.getSrvca_innercode());
	            newDTOItem.setId_primd(medSrvDO.getId_primd());
	            newDTOItem.setCode_srv(ordSrvSetDO.getCode());
	            newDTOItem.setQuan_cur(ordSrvSetDO.getQuan_medu());
	            newDTOItem.setId_unit_med(ordSrvSetDO.getId_medu());
				newDTOItem.setId_srv_set(emsMainDTO.getId_srv());
	            newDTOItem.setEu_sourcemd(emsMainDTO.getEu_sourcemd());
                newDTOItem.setSd_nodispense(emsMainDTO.getSd_nodispense());
                newDTOItem.setId_nodispense(emsMainDTO.getId_nodispense());
                newDTOItem.setName_nodispense(emsMainDTO.getName_nodispense());
                newDTOItem.setId_body(emsMainDTO.getId_body());
                newDTOItem.setSd_body(emsMainDTO.getSd_body());
                newDTOItem.setId_pos(emsMainDTO.getId_pos());
                newDTOItem.setSd_pos(emsMainDTO.getSd_pos());
				newDTOItem.setPrice(emsMainDTO.getPrice());
				newDTOItem.setId_or(ems.getId_or());
				newDTOItem.setStatus(DOStatus.NEW);
				newDTOList.add(newDTOItem);
			}
			for(CiEmsSrvDTO ciEmsSrvDTO : newDTOList){
				ciEmsSrvList.add(ciEmsSrvDTO);
			}
			return ciEmsSrvList;
		}
		return new ArrayList<CiEmsSrvDTO>();
	}
}
