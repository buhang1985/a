package iih.ci.ord.s.ems.op.order.copy;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
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
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.CiOrContentUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.meta.PathologyContentParam;

/**
 * 复制病理
 * @author Young
 *
 */
public class OrderPathgyCopyBP extends OrderBaseCopyBP {
	/**
	 * 重新组装医嘱内容
	 * @param aggDOs
	 * @param mapTeamSrvDOs
	 * @throws BizException 
	 */
	@Override
	protected void content_or(CiorderAggDO[]aggDOs,Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException {
		for (CiorderAggDO aggDO : aggDOs) {
			ICiorapplisRService iCiorapplisRService = ServiceFinder.find(ICiorapplisRService.class);
			
			ICiorderMDORService iCiorderMDORService = ServiceFinder.find(ICiorderMDORService .class);
			CiOrderDO[] ciOrderDOs = iCiorderMDORService.findByAttrValStrings("Id_or",this.mapIdors.keySet().toArray(new String[] {}));
			String id_or_old = "";
			for (CiOrderDO ciOrderDO : ciOrderDOs) {
				if (aggDO.getParentDO().getId_srv().equals(ciOrderDO.getId_srv())) {
					id_or_old = ciOrderDO.getId_or();
				}
			}
			PathologyContentParam param = new PathologyContentParam(id_or_old, aggDO);
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,param};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_RIS_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			aggDO.getParentDO().setContent_or(contentdo==null?"":contentdo.toString());
//				aggDO.getParentDO()
//						.setContent_or(CiOrContentUtils.create(id_or_old,aggDO.getParentDO().getSd_srvtp(),aggDO.getParentDO().getName_or(),aggDO.getParentDO().getFg_set(),aggDO.getParentDO().getFg_urgent()).toString());
				

		
		}
	}
	/**
	 * 复制病理申请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		CiorapppathgyAggDO[] apppathgyAggDOs = getCiorapppathgyAggDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return false;
		setCiorapppathgyAggDOs(apppathgyAggDOs,mapIdors);
		return saveCiorapppathgyAggDOs(apppathgyAggDOs);
	}

	/**
	 * 查询CiorapppathgyAggDO
	 * 
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private CiorapppathgyAggDO[] getCiorapppathgyAggDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrapppathgyQryService().find(
				OrdApPathgyDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}

	/**
	 * 设置CiorapppathgyAggDO
	 * 
	 * @param apppathgyAggDOs
	 * @param mapIdors
	 * @throws BizException 
	 */
	private void setCiorapppathgyAggDOs(CiorapppathgyAggDO[] apppathgyAggDOs, Map<String, String> mapIdors) throws BizException {
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return;
		for (CiorapppathgyAggDO apppathgyAggDO : apppathgyAggDOs) {
			OrdApPathgyDO ordApPathgyDO = apppathgyAggDO.getParentDO();
			ordApPathgyDO.setId_appathgy(null);
			ordApPathgyDO.setId_or(mapIdors.get(ordApPathgyDO.getId_or()));
			ordApPathgyDO.setNo_applyform(this.getApplyNo(ordApPathgyDO.getId_or()));
			//病情描述
			ordApPathgyDO.setDes_sympsign(apppathgyAggDO.getParentDO().getDes_sympsign());
			ordApPathgyDO.setClinicalzztz(null);
			ordApPathgyDO.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YSQ);
			ordApPathgyDO.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YSQ);
			//临床症状及体征
			CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
			String clinicalzztzFrom = CiOrdUtils.DiseaseDescription(context.getId_en());
			if (clinicalzztzFrom!=null&&!"".equals(clinicalzztzFrom)) {
				ordApPathgyDO.setClinicalzztz(clinicalzztzFrom); // 病情描述
			}else{
				OrdApPathgyDO ordApPathgyDO1 = getOrdApPathgyDO("id_en", context.getId_en());
				if (ordApPathgyDO!=null && ordApPathgyDO1 !=null) {
					ordApPathgyDO.setClinicalzztz(ordApPathgyDO1.getClinicalzztz());
				}
			}
			//诊断
			DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(context.getId_en());
			if (diagOutlineInfo != null) {
				ordApPathgyDO.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断的主项目id
				ordApPathgyDO.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			}
			ordApPathgyDO.setStatus(DOStatus.NEW);
			if(this.getTeampAggs()!=null && this.getTeampAggs().containsKey(ordApPathgyDO.getId_or())){
				ordApPathgyDO.setFg_urgent(this.getTeampAggs().get(ordApPathgyDO.getId_or()).getParentDO().getFg_urgent());
			}
			OrdApPathgySampDO[] pathgySampDOs = apppathgyAggDO.getOrdApPathgySampDO();
			if (CiOrdUtils.isEmpty(pathgySampDOs))
				continue;
			for (OrdApPathgySampDO pathgySampDO : pathgySampDOs) {
				pathgySampDO.setId_appathgysamp(null);
				pathgySampDO.setStatus(DOStatus.NEW);
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
	public  OrdApPathgyDO getOrdApPathgyDO(String column,String columnValue) throws BizException {

		if (StringUtil.isEmpty(columnValue))
			return null;

		//String sql = "select * from ci_order where "+ column +" = ? ";
		String  sql="select * from (select rownum as sn,t.* from (select o.* from ci_ap_pathgy o where o.id_or in"
				+ "(select id_or from ci_order where "+ column +" = ?)"
				+ "order by o.createdtime desc) t) where sn=1";

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(columnValue);

		OrdApPathgyDO ordDO = (OrdApPathgyDO) new DAFacade().execQuery(sql, sqlParam, new BeanHandler(OrdApPathgyDO.class));
		System.out.println("ordDo:"+(ordDO==null?"null":ordDO.toString()));
		return ordDO;
	}
	/**
	 * 保存CiorapppathgyAggDO
	 * 
	 * @param apppathgyAggDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveCiorapppathgyAggDOs(CiorapppathgyAggDO[] apppathgyAggDOs) throws BizException {
		if (CiOrdUtils.isEmpty(apppathgyAggDOs))
			return false;
		apppathgyAggDOs = CiOrdAppUtils.getOrapppathgyService().save(apppathgyAggDOs);
		return !CiOrdUtils.isEmpty(apppathgyAggDOs);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI);
	}
	
}
