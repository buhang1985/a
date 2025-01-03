package iih.ci.ord.s.ems.op.order.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.cior.i.IOrdApSugViewItemDOCudService;
import iih.ci.ord.cior.i.IOrdApSugViewItemDORService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 复制手术
 * @author Young
 *
 */
public class OrderOpCopyBP extends OrderBaseCopyBP {
	
	/**
	 * 复制手术申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		OrdApOpDO[] OrdApOpDOs = getOrdApLabOpDOs(mapIdors.keySet().toArray(new String[] {}));
		
		if (CiOrdUtils.isEmpty(OrdApOpDOs))
			return false;
		setOrdApLabDOs(OrdApOpDOs, mapIdors);
		saveOrdApOpDOs(OrdApOpDOs);
		
		// 创建并保存动态指标
		saveOrdApOpViewItemDos(OrdApOpDOs, mapIdors);
		return true;
	}
	
	/**
	 * 创建并保存动态指标
	 * @param ordApOpDOs
	 * @param mapIdors 
	 * @throws BizException
	 */
	private void saveOrdApOpViewItemDos(OrdApOpDO[] ordApOpDOs, Map<String, String> mapIdors) throws BizException {
		List<OrdApSugViewItemDO> viewItemList = new ArrayList<>();
		OrdApOpDO[] apOpDOs = getOrdApLabOpDOs(mapIdors.keySet().toArray(new String[] {}));
		// 创建动态指标
		for (OrdApOpDO item : ordApOpDOs) {
			// 查找源手术申请
			OrdApOpDO source = new OrdApOpDO();
			for (OrdApOpDO apOp : apOpDOs) {
				if (mapIdors.get(apOp.getId_or()).equals(item.getId_or())) {
					source = apOp;
					break;
				}
			}
			List<OrdApSugViewItemDO> viewItemDOs = ordApSugViewItemListFrom(item, source);
			if (viewItemDOs == null || viewItemDOs.size() == 0) {
				continue;
			}
			viewItemList.addAll(viewItemDOs);
		}
		
		if (viewItemList == null || viewItemList.size() == 0) {
			return;
		}
		// 保存动态指标
		ServiceFinder.find(IOrdApSugViewItemDOCudService.class).save(viewItemList.toArray(new OrdApSugViewItemDO[0]));
	}

	/**
	 * 查询OrdApLabDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private OrdApOpDO[] getOrdApLabOpDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		ICiorappsurgeryMDORService iCiorappsurgeryMDORService = CiOrdAppUtils.getICiorappsurgeryMDORService(); 
		return iCiorappsurgeryMDORService
				.find(OrdApOpDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "",
						FBoolean.FALSE);
	}
	
	/**
	 * 设置OrdApLabDO
	 * @param ordApLabDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setOrdApLabDOs(OrdApOpDO[] ordApOpDOs, Map<String, String> mapIdors) throws BizException{
		if (CiOrdUtils.isEmpty(ordApOpDOs))
			return;
		for (OrdApOpDO ordApOpDO : ordApOpDOs) {
			ordApOpDO.setId_apop(null);
			ordApOpDO.setId_or(mapIdors.get(ordApOpDO.getId_or()));
			ordApOpDO.setNo_applyform(this.getApplyNo(ordApOpDO.getId_or()));
			ordApOpDO.setId_su_op(ICiDictCodeConst.ID_CI_OPER_YSQ);//手术申请状态
			ordApOpDO.setSd_su_op(ICiDictCodeConst.SD_CI_OPER_YSQ);//手术申请状态编码
			if(this.getTeampAggs()!=null && this.getTeampAggs().containsKey(ordApOpDO.getId_or())){
				ordApOpDO.setDt_plan(this.getTeampAggs().get(ordApOpDO.getId_or()).getParentDO().getDt_effe());
			}
			ordApOpDO.setFg_prn(FBoolean.FALSE);
			ordApOpDO.setCnt_prn(null);
			//诊断
			CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(context.getId_en());
			if (diagOutlineInfo != null) {
				ordApOpDO.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断的主项目id
				ordApOpDO.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			}
			ordApOpDO.setStatus(DOStatus.NEW);
		}
	}
	
	/**
	 * 保存OrdApLabDO
	 * @param ordApLabDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveOrdApOpDOs(OrdApOpDO[] OrdApOpDOs) throws BizException{
		if (CiOrdUtils.isEmpty(OrdApOpDOs))
			return false;
		OrdApOpDOs = CiOrdAppUtils.getICiorappsurgeryMDOCudService().save(OrdApOpDOs);
		return !CiOrdUtils.isEmpty(OrdApOpDOs);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_OP);
	}

	/**
	 * 创建动态指标
	 * 
	 * 根据手术医疗单的创建逻辑改定。
	 * 
	 * @param ordApOpDO
	 * @param source 
	 * @return
	 * @throws BizException
	 */
	protected List<OrdApSugViewItemDO> ordApSugViewItemListFrom(OrdApOpDO ordApOpDO, OrdApOpDO source) throws BizException {
		// 获取医疗单维护 -- 医疗单注册服务
		IEmsregistryRService emsMgrService = ServiceFinder.find(IEmsregistryRService.class);
		if (null == emsMgrService)
			return null;
		// 获取原医嘱DO
		CiorderAggDO[] aggDOs = CiOrdAppUtils.getOrAggQryService().findByIds(new String[] {ordApOpDO.getId_or()}, FBoolean.FALSE);
		if (aggDOs == null || aggDOs.length == 0){
			return null;
		}
		CiOrderDO orderDO = aggDOs[0].getParentDO();
		// 查询医疗单维护信息
		EmsregistryAggDO emsRegAggDo = emsMgrService.findById(orderDO.getId_srvof());
		if (null == emsRegAggDo) {
			return null;
		}
		if (emsRegAggDo.getParentDO() == null)
			return null;

		FBoolean fg_dyncitm_en = emsRegAggDo.getParentDO().getFg_dyncitm_crossentp();
		Integer eu_dyncitmunit = emsRegAggDo.getParentDO().getEu_dyncitmunit();// 指标周期类型
		Integer dyncitmunitct = emsRegAggDo.getParentDO().getCnt_dyncitmunit();

		EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
		paramDto.setId_ems(orderDO.getId_srvof());
		paramDto.setFg_dyncitm_en(fg_dyncitm_en.booleanValue());
		paramDto.setEu_dyncitmunit(eu_dyncitmunit);
		paramDto.setId_ent(orderDO.getId_en());
		paramDto.setId_pat(orderDO.getId_pat());
		paramDto.setDyncitmunitct(dyncitmunitct);

		IBdSrvQryService qryService = ServiceFinder.find(IBdSrvQryService.class);
		if (null == qryService) {
			return null;
		}
		// 查询动态指标定义
		EmsDynamicIndexDTO[] dtos = qryService.getEmsDynamicIndexInfos(paramDto);
		OrdApSugViewItemDO[] sugViewItemDOs = ServiceFinder.find(IOrdApSugViewItemDORService.class).findByAttrValString(OrdApSugViewItemDO.ID_APOP, source.getId_apop());
		// 创建动态指标
		List<OrdApSugViewItemDO> rstList = new ArrayList<OrdApSugViewItemDO>();
		for (EmsDynamicIndexDTO dto : dtos) {
			OrdApSugViewItemDO item = new OrdApSugViewItemDO();
			String[] ids = new DBUtil().getOIDs(1);
			item.setId_apopobsindex(ids[0]);
			item.setVal_rstrptla(dto.getIndexval() == null ? "" : dto.getIndexval());
			item.setVal_restrptlab(dto.getEnumvalues() == null ? "" : "|" + dto.getEnumvalues().replace(',', '|'));
			item.setSd_restrptlabtp(dto.getDatatype());
			item.setName_srv(dto.getShowname());
			item.setName_unit(dto.getUnitname());
			item.setId_unit(dto.getId_unit());
			item.setId_srv(dto.getId_srv());
			item.setId_apop(ordApOpDO.getId_apop());
			item.setStatus(DOStatus.NEW);
			if (!ObjectUtils.isEmpty(sugViewItemDOs)) {
				// 复制动态指标值
				for (OrdApSugViewItemDO sugViewItem : sugViewItemDOs) {
					if (sugViewItem.getId_srv().equals(item.getId_srv())) {
						item.setVal_rstrptla(sugViewItem.getVal_rstrptla());
						item.setVal_restrptlab(sugViewItem.getVal_restrptlab());
						item.setSd_restrptlabtp(sugViewItem.getSd_restrptlabtp());
					}
				}				
			}
			
			rstList.add(item);
		}
		

		return rstList;
	}
}
