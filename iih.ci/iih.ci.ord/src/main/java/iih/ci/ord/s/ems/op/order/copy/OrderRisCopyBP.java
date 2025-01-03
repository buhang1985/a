package iih.ci.ord.s.ems.op.order.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.orcontent.meta.RisOrContentParam;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 复制检查
 * @author Young
 *
 */
public class OrderRisCopyBP extends OrderBaseCopyBP {
	
	private OrdApObsDO[] ordApObsDOs;
	
	private String Id_or;
	
	public String getId_or() {
		return Id_or;
	}

	public void setId_or(String id_or) {
		Id_or = id_or;
	}
	/**
	 * 复制检查申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		ordApObsDOs = getOrdApObsDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ordApObsDOs))
			return false;
		setOrdApObsDOs(ordApObsDOs, mapIdors, dt);
		return saveOrdApObsDOs(ordApObsDOs);
	}

	/**
	 * 查询OrdApObsDO
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	protected OrdApObsDO[] getOrdApObsDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrapprisQryService().find(
				OrdApObsDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}

	/**
	 * 设置OrdApObsDO
	 * 
	 * @param OrdApObsDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApObsDOs(OrdApObsDO[] OrdApObsDOs, Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(OrdApObsDOs))
			return;
		for (OrdApObsDO ordApObsDO : OrdApObsDOs) {
			ordApObsDO.setId_orobs(null);
			ordApObsDO.setId_or(mapIdors.get(ordApObsDO.getId_or()));
			ordApObsDO.setNo_applyform(this.getApplyNo(ordApObsDO.getId_or()));
			ordApObsDO.setStatus(DOStatus.NEW);
			ordApObsDO.setDt_plan(dt);//计划时间
			// 获取上下文信息
			ordApObsDO.setClinicalzztz(null);
			ordApObsDO.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
			ordApObsDO.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
			CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			String clinicalzztzFrom = CiOrdUtils.DiseaseDescription(context.getId_en());
			if (clinicalzztzFrom!=null&&!"".equals(clinicalzztzFrom)) {
				ordApObsDO.setClinicalzztz(clinicalzztzFrom); // 病情描述
			}else{
				OrdApObsDO ordApObsDO1 = getOrdApObsDO("id_en",context.getId_en());
				if (ordApObsDO1!=null&&ordApObsDO1.getClinicalzztz()!=null) {
					ordApObsDO.setClinicalzztz(ordApObsDO1.getClinicalzztz());
				}
			}
			//诊断
			DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(context.getId_en());
			if (diagOutlineInfo != null) {
				ordApObsDO.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断的主项目id
				ordApObsDO.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			}
			if(this.getTeampAggs()!=null && this.getTeampAggs().containsKey(ordApObsDO.getId_or())){
				ordApObsDO.setFg_urgent(this.getTeampAggs().get(ordApObsDO.getId_or()).getParentDO().getFg_urgent());
			}
		}
	}
	/**
	   *    根据传的字段 和字段值 查询医嘱(该方法经测试只反一条  库里多条时也是一条 不适用反多条该方法)
	 * @param column
	 * @param columnValue
	 * @return
	 * @throws BizException
	 */
	public  OrdApObsDO getOrdApObsDO(String column,String columnValue) throws BizException {

		if (StringUtil.isEmpty(columnValue))
			return null;

		//String sql = "select * from ci_order where "+ column +" = ? ";
		String  sql="select * from (select rownum as sn,t.* from (select o.* from ci_ap_obs o where o.id_or in"
				+ "(select id_or from ci_order where "+ column +" = ?)"
				+ "order by o.createdtime desc) t) where sn=1";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(columnValue);

		OrdApObsDO ordDO = (OrdApObsDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(OrdApObsDO.class));
		System.out.println("ordDo:"+(ordDO==null?"null":ordDO.toString()));
		return ordDO;
	}

	/**
	 * 保存OrdApObsDO
	 * 
	 * @param ordApObsDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApObsDOs(OrdApObsDO[] ordApObsDOs) throws BizException {
		if (CiOrdUtils.isEmpty(ordApObsDOs))
			return false;
		ordApObsDOs = CiOrdAppUtils.getOrapprisService().save(ordApObsDOs);
		return !CiOrdUtils.isEmpty(ordApObsDOs);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_RIS);
	}

	@Override
	protected void setCopyCiEmsDTOInfo(CiEmsDTO ciEmsDTO) throws BizException {
		FMap map = ciEmsDTO.getOrapplysheet();
		if(map!=null){
			OrdApObsDO obs = (OrdApObsDO)map.get(EmsType.RIS.toString());
			if(obs!=null){
				obs.setStatus(DOStatus.NEW);
				obs.setId_orobs(null);
				obs.setDt_plan(ciEmsDTO.getDt_begin());
				obs.setId_or(null);
				obs.setNo_applyform(this.getApplyNo());
				obs.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
				obs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
			}
		}
	}
	/**
	 * 重新组装医嘱内容
	 * 
	 * @param aggDOs
	 * @param mapTeamSrvDOs
	 * @throws BizException
	 */
	protected void content_or(CiorderAggDO[] aggDOs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException {
		for (CiorderAggDO aggDO : aggDOs) {
			String id_or_old = mapNewOldKeys.get(aggDO.getParentDO().getId_or());
				OrdApObsDO[] ordApObsDOs = getOrdApObsDOs(new String[] {id_or_old});
			//RisOrContentParam  risOrContentParam = new RisOrContentParam(aggDO.getParentDO().getName_or(),aggDO.getParentDO().getSd_srvtp(),ordApObsDOs[0].getId_or(),ordApObsDOs[0].getId_body(),aggDO.getParentDO().getFg_urgent(),aggDO.getParentDO().getFg_set());
			RisOrContentParam  risOrContentParam = new RisOrContentParam(aggDO.getParentDO(),ordApObsDOs[0],id_or_old,aggDO.getOrdSrvDO());
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,risOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_RIS_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			aggDO.getParentDO().setContent_or(contentdo==null?"":contentdo.toString());
			//aggDO.getParentDO().setContent_or(CiOrContentUtils.create(risOrContentParam).toString());
		}

	}
	@Override
	protected CiEmsDTO createCiEmsDTO(ICiOrdQryService ordQryService, CiorderAggDO aggdo, boolean isAddExt,
			OrdSrvDO[] ordSrvDOs) throws BizException {
		CiEmsDTO ciEmsDTO =  super.createCiEmsDTO(ordQryService, aggdo, isAddExt, ordSrvDOs);
		FMap fMap = ciEmsDTO.getOrapplysheet();
		if(fMap != null){
			OrdApObsDO apobs = (OrdApObsDO)fMap.get(""+ciEmsDTO.getEmstype());
			apobs.setDt_plan(ciEmsDTO.getDt_begin());
			apobs.setNo_applyform(aggdo.getParentDO().getApplyno());
			apobs.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
			apobs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
			CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			String clinicalzztzFrom = CiOrdUtils.DiseaseDescription(context.getId_en());
			if (StringUtil.isEmpty(clinicalzztzFrom)) {
				OrdApObsDO ordApObsDO1 = getOrdApObsDO("id_en",context.getId_en());
				if (ordApObsDO1!=null&&ordApObsDO1.getClinicalzztz()!=null) {
					clinicalzztzFrom = ordApObsDO1.getClinicalzztz();
				}
			}
			apobs.setClinicalzztz(clinicalzztzFrom);
		} 
		return ciEmsDTO;
	}
	
	/**
	 * 	保存后信息完整性校验
	 * @param aggDOs
	 */
	@Override
	protected String afterSaveValidate(FArrayList errorEmsList, CiorderAggDO[] aggDOs) throws BizException{
		return checkClinicalzztz(ordApObsDOs);
	}
	
	/**
	 *	检查临床症状及体征是否为空
	 * 	0188169: 【验证版】门急诊医生站，患者历史既往调入检查，临床病史体征没有校验必填配置
	 * 
	 * @param ordApObsDOs
	 * @throws BizException
	 */
	private String checkClinicalzztz(OrdApObsDO[] ordApObsDOs) throws BizException {
		return null;
	}

	@Override
	protected void validateAppInfo(CiorderAggDO[] aggDOs) throws BizException {
		FBoolean flag = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_CLINICAL_VALIDATE);
		if(FBoolean.TRUE.equals(flag)){
			CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			String clinicalzztzFrom = CiOrdUtils.DiseaseDescription(context.getId_en());
			if (StringUtil.isEmpty(clinicalzztzFrom)) {
				OrdApObsDO ordApObsDO1 = getOrdApObsDO("id_en",context.getId_en());
				if (ordApObsDO1!=null&&ordApObsDO1.getClinicalzztz()!=null) {
					clinicalzztzFrom = ordApObsDO1.getClinicalzztz();
				}
			}
			if(StringUtil.isEmpty(clinicalzztzFrom)){
				ICiOrdQryService ordQryService = ServiceFinder.find(ICiOrdQryService.class);
				for(CiorderAggDO aggdo : aggDOs){
					if(this.getCiOrderAggs().contains(aggdo)){
						this.getCiOrderAggs().remove(aggdo);
					}
					this.setErrorInfo(aggdo.getParentDO().getName_or()+"医疗单临床病症及体征信息不完整");
					CiEmsDTO ciEmsDTO=createCiEmsDTO(ordQryService,aggdo,false,aggdo.getOrdSrvDO());//创建医疗单
					this.getErrorEmsList().append(ciEmsDTO);
				}
			}
		}
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
