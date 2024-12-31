package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppRisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.d.CiapprissheetAggDO;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.app.i.ICiapprissheetRService;
import iih.ci.ord.ciappdiriveorreldo.d.CiAppDiriveOrRelDO;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoCudService;
import iih.ci.ord.ciappdiriveorreldo.i.ICiappdiriveorreldoRService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.op.order.ICiOpOrderMainService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除检查打印数据
 * 
 * @author YANG
 *
 */
public class CiprnDeleteAppRisDataBP {
	
	// 检查申请单查询接口
	private ICiorapprisRService risRService;
	// 检查打印单查询接口
	private ICiapprissheetRService rissheetRService;
	// 检查打印单更新接口
	private ICiapprissheetCudService rissheetCudService;
	
	public CiprnDeleteAppRisDataBP(){
		risRService = ServiceFinder.find(ICiorapprisRService.class);
		rissheetRService = ServiceFinder.find(ICiapprissheetRService.class);
		rissheetCudService = ServiceFinder.find(ICiapprissheetCudService.class);		
	}

	public FBoolean exec(String[] id_ors) throws BizException {
		if (id_ors == null || id_ors.length <= 0)
			return FBoolean.TRUE;
		
		delRissheetAggByIdors(id_ors);
		
		return FBoolean.TRUE;
	}

	/**
	 * 跟医嘱id删除检查打印单合单结果
	 * @param id_ors
	 * @throws BizException
	 */
	public void delRissheetAggByIdors(String[] id_ors) throws BizException {
		
		// 待删除的打印单明细对应的id_or集合
		List<String> idOrList = Arrays.asList(id_ors);
		
		// 待删除agg对象的，如果检查申请单明细的id_or都在删除医嘱集合（idors）中，直接删除agg对象，否则更新agg对象
		List<CiapprissheetAggDO> delRisAggList = new ArrayList<CiapprissheetAggDO>();
		
		// 待更新的打印申请单，删除部门明细
		List<CiapprissheetAggDO> delRisAggChildrenList = new ArrayList<CiapprissheetAggDO>();
				
		String inWhereStr = CiOrdUtils.getSqlInStrsWithOutIn(id_ors);
		CiapprissheetAggDO[] rissheetAggs = rissheetRService.find("Id_ciapprissheet in (select Id_ciapprissheet from ci_app_ris_or where id_or in ("+ inWhereStr +"))",null, FBoolean.FALSE);

		for (CiapprissheetAggDO rissheetAgg : rissheetAggs) {
			
			CiAppRisSheetOrDO[] risSheetOrs = rissheetAgg.getCiAppRisSheetOrDO();

			// 判断是否需要直接删除agg对象，当明细都删除时，删除整个agg对象
			boolean idDelRissheetAgg = true;

			// 打印申请单明细如果不在传入删除的id_or集合中，就不需要删除整个agg对象
			for (CiAppRisSheetOrDO risSheetOr : risSheetOrs) {
				if(idOrList.contains(risSheetOr.getId_or())){
					risSheetOr.setStatus(DOStatus.DELETED);
				}else{
					idDelRissheetAgg = false;
				}
			}

			if (idDelRissheetAgg) {
				delRisAggList.add(rissheetAgg);
			}else{
				delRisAggChildrenList.add(rissheetAgg);
			}
		}

		// 1. 当子项需要全部删除的，删除整个Agg对象
		if (delRisAggList.size() > 0) {
			rissheetCudService.delete(delRisAggList.toArray(new CiapprissheetAggDO[delRisAggList.size()]));
			List<String> idappsheeets = new ArrayList<String>();
			for (CiapprissheetAggDO aggDO : delRisAggList) {
				CiAppRisSheetDO sheet = aggDO.getParentDO();
				idappsheeets.add(sheet.getId_ciapprissheet());
			}
			deleteImageTextFees(idappsheeets);
		}
		// 2. 当子项不全删除时，将待删除的子项设置为删除状态，保存agg对象
		if (delRisAggChildrenList.size() > 0) {
			rissheetCudService.update(delRisAggChildrenList.toArray(new CiapprissheetAggDO[delRisAggChildrenList.size()]));
		}	
	}
	
	/**
	 * 根据医嘱id删除检查打印单数据
	 * 废弃了。验证结束后删除该方法，临时保留
	 * @param idors
	 * @throws BizException
	 */
	@Deprecated
	public void delRissheetAggByIdors2(String[] idors) throws BizException {

		// 待删除的打印单明细对应的id_or集合
		List<String> idOrList = Arrays.asList(idors);

		// 待删除agg对象的，如果检查申请单明细的id_or都在删除医嘱集合（idors）中，直接删除agg对象，否则更新agg对象
		List<CiapprissheetAggDO> delRissheetAggList = new ArrayList<CiapprissheetAggDO>();
		// 待更新的打印申请单，删除部门明细
		List<CiapprissheetAggDO> updateRissheetAggList = new ArrayList<CiapprissheetAggDO>();
		// 1.查询出待更新的检查打印申请单id
		List<String> idCiapprissheetList = new ArrayList<String>();

		StringBuffer idOrBuffer = new StringBuffer();
		for (String id_or : idors) {
			idOrBuffer.append(",'" + id_or + "'");
		}

		// 3. 根据检查打印申请单id查询出检查打印申请单，查询出医嘱，检查申请单，更新检查打印单中的属性
		// 查询出待更新到检查打印申请单中数据的医嘱、检查申请单
		Map<String, CiOrderDO> ciOrderMap = null;//this.getCiOrderMap(idors);
		Map<String, OrdApObsDO> ordApObsMap = null;

		CiapprissheetAggDO[] rissheetAggs = rissheetRService.find("Id_ciapprissheet in (select Id_ciapprissheet from ci_app_ris_or where id_or in ("+ idOrBuffer.substring(1)+"))",null, FBoolean.FALSE);

		for (CiapprissheetAggDO rissheetAgg : rissheetAggs) {
			CiAppRisSheetOrDO[] risSheetOrs = rissheetAgg.getCiAppRisSheetOrDO();

			// 判断是否需要直接删除agg对象，当明细都删除时，删除整个agg对象
			boolean idDelRissheetAgg = true;

			// 打印申请单明细如果不在传入删除的id_or集合中，就不需要删除整个agg对象
			for (CiAppRisSheetOrDO risSheetOr : risSheetOrs) {
				if (!idOrList.contains(risSheetOr.getId_or())) {
					idDelRissheetAgg = false;
					break;
				}
			}

			if (idDelRissheetAgg) {
				delRissheetAggList.add(rissheetAgg);
			} else {
				updateRissheetAggList.add(rissheetAgg);
			}
		}

		// 1. 当子项需要全部删除的，删除整个Agg对象
		if (delRissheetAggList.size() > 0) {
			rissheetCudService.delete(delRissheetAggList.toArray(new CiapprissheetAggDO[delRissheetAggList.size()]));
			List<String> idappsheeets = new ArrayList<String>();
			for (CiapprissheetAggDO aggDO : delRissheetAggList) {
				CiAppRisSheetDO sheet = aggDO.getParentDO();
				idappsheeets.add(sheet.getId_ciapprissheet());
			}
			deleteImageTextFees(idappsheeets);
		}

		// 记录用于获取更新检查打印单的医嘱id,检查打印单信息来源于明细中排序号最大的医嘱和检查申请单
		List<String> risSheetIdOrList = new ArrayList<String>();
		// key 检查打印单id, value:id_or
		Map<String, String> risSheetOrMap = new HashMap<String, String>();
		if (updateRissheetAggList.size() == 0) {
			return;
		}
		
		for (CiapprissheetAggDO rissheetAgg : updateRissheetAggList) {

			idCiapprissheetList.add(rissheetAgg.getParentDO().getId_ciapprissheet());

			CiAppRisSheetOrDO[] risSheetOrs = rissheetAgg.getCiAppRisSheetOrDO();

			// 医嘱按医嘱号排序
			Arrays.sort(risSheetOrs, new Comparator<CiAppRisSheetOrDO>() {
				@Override
				public int compare(CiAppRisSheetOrDO itm1, CiAppRisSheetOrDO itm2) {
					if (CiOrdUtils.isEmpty(itm2.getSortno())) {
						return 1;
					}
					if (CiOrdUtils.isEmpty(itm1.getSortno())) {
						return -1;
					}
					return itm2.getSortno() - itm1.getSortno();
				}
			});

			for (CiAppRisSheetOrDO risSheetOr : risSheetOrs) {

				if (idOrList.contains(risSheetOr.getId_or())) { // 如果在根据id_or删除明细的集合中，设置检查打印单明显为删除状态
					risSheetOr.setStatus(DOStatus.DELETED);
				} else if (!risSheetIdOrList.contains(risSheetOr.getId_or())) { // 如果不时待删除的明显，
																				// 记录排序号最大的医嘱id,用药重新给检查打印单赋值
					risSheetIdOrList.add(risSheetOr.getId_or());
					risSheetOrMap.put(risSheetOr.getId_ciapprissheet(), risSheetOr.getId_or());
				}
			}

			ciOrderMap = this.getCiOrderMap(risSheetIdOrList.toArray(new String[0]));
			ordApObsMap = this.getOrdApObsMap(risSheetIdOrList.toArray(new String[0]));
			this.setRisSheetAgg(rissheetAgg, ciOrderMap, ordApObsMap);
		}
		
		rissheetCudService.update(updateRissheetAggList.toArray(new CiapprissheetAggDO[updateRissheetAggList.size()]));	
	}

	/**
	 * 根据医嘱id获取医嘱map集合
	 * 
	 * @param idOrList
	 * @return
	 * @throws BizException
	 */
	private Map<String, CiOrderDO> getCiOrderMap(String[] idors) throws BizException {

		Map<String, CiOrderDO> ciOrderMap = new HashMap<String, CiOrderDO>();

		ICiorderMDORService ciorderRService = CiOrdAppUtils.getOrQryService();
		CiOrderDO[] ciOrders = ciorderRService.findByIds(idors, FBoolean.FALSE);

		for (CiOrderDO ciOrder : ciOrders) {
			ciOrderMap.put(ciOrder.getId_or(), ciOrder);
		}

		return ciOrderMap;
	}

	/**
	 * 获取检查申请单集合
	 * 
	 * @param idOrList
	 * @return
	 * @throws BizException
	 */
	private Map<String, OrdApObsDO> getOrdApObsMap(String[] idors) throws BizException {

		Map<String, OrdApObsDO> ordApObsMap = new HashMap<String, OrdApObsDO>();

		
		OrdApObsDO[] orApObsArr = risRService.findByAttrValStrings(OrdApObsDO.ID_OR, idors);
		for (OrdApObsDO ordApObs : orApObsArr) {
			ordApObsMap.put(ordApObs.getId_or(), ordApObs);
		}

		return ordApObsMap;
	}

	private void setRisSheetAgg(CiapprissheetAggDO rissheetAgg, Map<String, CiOrderDO> ciOrderMap,
			Map<String, OrdApObsDO> ordApObsMap) throws BizException {

		// 检查打印单赋值，按符合规则的一组医嘱进行赋值，除服务名称，金额外，使用医嘱中排序号最大的一条进行赋值
		// 服务名称使用多条医嘱的name_or进行拼接，金额为多条医嘱的金额合计

		// 保留检查合单分组后的医嘱中，排序号最大的医嘱对象
		CiOrderDO ciOrder = null;
		// 保留检查合单分组后的医嘱中，排序号最大的医嘱对应的检查申请单
		OrdApObsDO ordApObs = null;

		StringBuffer idOrBuffer = new StringBuffer();
		StringBuffer nameOrBuffer = new StringBuffer();

		CiAppRisSheetDO risSheet = rissheetAgg.getParentDO();
		CiAppRisSheetOrDO[] risSheetOrs = rissheetAgg.getCiAppRisSheetOrDO();

		for (CiAppRisSheetOrDO risSheetOr : risSheetOrs) {

			if (risSheetOr.getStatus() == DOStatus.DELETED) {
				continue;
			}

			CiOrderDO tempCiOrder = ciOrderMap.get(risSheetOr.getId_or());
			OrdApObsDO tempOrdApObs = ordApObsMap.get(risSheetOr.getId_or());

			if (ciOrder == null) {
				ciOrder = tempCiOrder;
				ordApObs = tempOrdApObs;
			}

			idOrBuffer.append("," + tempCiOrder.getId_or());
			nameOrBuffer.append("," + tempCiOrder.getName_or());
		}

		// 更新检查打印单中属性，只更新医嘱，检查申请单信息，不更新就诊信息
		risSheet.setCode_entp(ciOrder.getCode_entp());
		risSheet.setId_en(ciOrder.getId_en());
		risSheet.setFg_hp(ciOrder.getFg_orhp());
		risSheet.setFg_bb(ciOrder.getFg_bb());
		risSheet.setNo_bb(ciOrder.getNo_bb());

		// risSheet.setFg_opspecial(CiprnUtils.GetFg_opspecial(ciOrder.getId_en()));
		// // 特需门诊标识 一次就诊应该获取一次

		risSheet.setId_or(ciOrder.getId_or());
		risSheet.setId_orobs(ordApObs.getId_orobs());
		risSheet.setId_srv(ciOrder.getId_srv());
		risSheet.setFg_set(ciOrder.getFg_set());
		risSheet.setNo_applyform(ordApObs.getNo_applyform());
		// risSheet.setCode_app(code_app);
		risSheet.setName_app(nameOrBuffer.substring(1));
		risSheet.setId_di(ordApObs.getId_di());
		risSheet.setId_diitm(ordApObs.getId_diitm());
		risSheet.setStr_id_diitm(ordApObs.getStr_id_diitm());
		risSheet.setStr_code_di(ordApObs.getStr_code_di());
		risSheet.setStr_name_di(ordApObs.getStr_name_di());
		risSheet.setName_diag(ordApObs.getName_diag());
		risSheet.setId_org(ciOrder.getId_org());
		risSheet.setId_grp(ciOrder.getId_grp());
		risSheet.setDt_plan(ordApObs.getDt_plan());
		risSheet.setFg_urgent(ordApObs.getFg_urgent());
		risSheet.setId_org_app(ciOrder.getId_org_or());
		risSheet.setId_dep_app(ciOrder.getId_dep_sign());
		risSheet.setId_emp_app(ciOrder.getId_emp_sign());
		risSheet.setDt_app(ciOrder.getDt_sign());
		risSheet.setId_dep_mp(ciOrder.getId_dep_mp());
		risSheet.setBiopsy(ordApObs.getBiopsy());
		risSheet.setDes_sympsign(ordApObs.getDes_sympsign());
		risSheet.setClinicalzztz(ordApObs.getClinicalzztz());
		risSheet.setAuximtexam(ordApObs.getAuximtexam());
		risSheet.setPastillness(ordApObs.getPastillness());
		risSheet.setId_pps(ordApObs.getId_pps());
		risSheet.setSd_pps(ordApObs.getSd_pps());
		risSheet.setDes_pps(ordApObs.getDes_pps());
		// risSheet.setId_body((ordApObs.getId_body()));
		// risSheet.setSd_body((ordApObs.getSd_body()));
		// risSheet.setId_pos((ordApObs.getId_pos()));
		// risSheet.setSd_pos((ordApObs.getSd_pos()));
		// risSheet.setFg_mp_bed((ordApObs.getFg_mp_bed()));
		risSheet.setAnnouncements(ordApObs.getAnnouncements());
		/*
		 * if( (ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
		 * ctx.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) &&
		 * banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
		 * risSheet.setFg_hecominsur(FBoolean.TRUE);
		 * risSheet.setHecominsurinfo(banner.getName_pat()+":"+CiOrdAppUtils.
		 * getServerDateTime()); }else{
		 * risSheet.setFg_hecominsur(FBoolean.FALSE); }
		 */

		risSheet.setFg_prepay(ciOrder.getFg_prepay());
		risSheet.setFg_vip(ciOrder.getFg_vip());
		// risSheet.setFg_hpbirth(FBoolean.FALSE);
		// risSheet.setResearchinfo("");
		// risSheet.setFg_blsettled(FBoolean.FALSE);
		risSheet.setAmt_app(CiprnUtils.GetAmt_app(idOrBuffer.substring(1)));
		// risSheet.setFg_prn(FBoolean.FALSE);
		// risSheet.setCnt_prn(0);
		// risSheet.setId_session(id_ciorsession); // 医嘱签署的sessionId 对应
		// CiOrSessionDO中的id_ciorsession
		risSheet.setDef1((ordApObs.getDef1()));
		risSheet.setDef2((ordApObs.getDef2()));
		risSheet.setDef3((ordApObs.getDef3()));
		risSheet.setDef4((ordApObs.getDef4()));
		risSheet.setDef5((ordApObs.getDef5()));
		risSheet.setDef6((ordApObs.getDef6()));
		risSheet.setDef7((ordApObs.getDef7()));
		risSheet.setDef8((ordApObs.getDef8()));
		risSheet.setDef9((ordApObs.getDef9()));
		risSheet.setDef10((ordApObs.getDef10()));
		risSheet.setDef11((ordApObs.getDef11()));
		risSheet.setDef12((ordApObs.getDef12()));
		risSheet.setDef13((ordApObs.getDef13()));
		risSheet.setDef14((ordApObs.getDef14()));
		risSheet.setDef15((ordApObs.getDef15()));
		risSheet.setDef16((ordApObs.getDef16()));
		risSheet.setDef17((ordApObs.getDef17()));
		risSheet.setDef18((ordApObs.getDef18()));
		risSheet.setDef19((ordApObs.getDef19()));
		risSheet.setDef20((ordApObs.getDef20()));
		risSheet.setDef21((ordApObs.getDef21()));
		risSheet.setDef22((ordApObs.getDef22()));
		risSheet.setDef23((ordApObs.getDef23()));
		risSheet.setDef24((ordApObs.getDef24()));
		risSheet.setDef25((ordApObs.getDef25()));
		risSheet.setDef26((ordApObs.getDef26()));
		risSheet.setDef27((ordApObs.getDef27()));
		risSheet.setDef28((ordApObs.getDef28()));
		risSheet.setDef29((ordApObs.getDef29()));
		risSheet.setDef30((ordApObs.getDef30()));
		risSheet.setDef31((ordApObs.getDef31()));
		risSheet.setDef32((ordApObs.getDef32()));
		risSheet.setDef33((ordApObs.getDef33()));
		risSheet.setDef34((ordApObs.getDef34()));
		risSheet.setDef35((ordApObs.getDef35()));
		risSheet.setDef36((ordApObs.getDef36()));
		risSheet.setDef37((ordApObs.getDef37()));
		risSheet.setDef38((ordApObs.getDef38()));
		risSheet.setDef39((ordApObs.getDef39()));
		risSheet.setDef40((ordApObs.getDef40()));
		risSheet.setDef41((ordApObs.getDef41()));
		risSheet.setDef42((ordApObs.getDef42()));
		risSheet.setDef43((ordApObs.getDef43()));
		risSheet.setDef44((ordApObs.getDef44()));
		risSheet.setDef45((ordApObs.getDef45()));
		risSheet.setDef46((ordApObs.getDef46()));
		risSheet.setDef47((ordApObs.getDef47()));
		risSheet.setDef48((ordApObs.getDef48()));
		risSheet.setDef49((ordApObs.getDef49()));
		risSheet.setDef50((ordApObs.getDef50()));
		risSheet.setStatus(DOStatus.UPDATED);

	}
	/**
	 * 删除图文报告费
	 * 
	 * @param id_appsheets
	 * @throws BizException
	 */
	private void deleteImageTextFees(List<String> id_appsheets) throws BizException {
		if (id_appsheets == null || id_appsheets.size() == 0) {
			return;
		}
		String sql = " select id_or from CI_APP_DIRIVE_OR_REL rel "
				+ "inner join ci_order ci on rel.id_relor = ci.id_or where rel.id_app in ('"
				+ CiOrdUtils.ConcatInSqlMark(id_appsheets) + "') and ci.sd_su_bl<>'1' ";
		SqlParam param = new SqlParam();
		List<String> orders = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		// 删除关联单据
		deleteDirive(id_appsheets);
		ICiorderMDORService ciorderRService = CiOrdAppUtils.getOrQryService();
		CiOrderDO[] ciOrders = ciorderRService.findByIds(orders.toArray(new String[orders.size()]), FBoolean.FALSE);
		if (orders != null && orders.size() > 0) {
			// 发送消息通知其他域医嘱已经撤回
			CiOrdUtils.fireBDEvent(IOrdEventSources.OP_REVERT_ENTER, IEventType.TYPE_UPDATE_AFTER, ciOrders);//门诊撤回会入口-集成平台
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_SIGN2OPEN_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, ciOrders);
			this.deleteOrders(orders);
		}
	}
	/**
	 * 删除医嘱的操作
	 * 
	 * @param id_ors
	 * @throws BizException
	 */
	private void deleteOrders(List<String> id_ors) throws BizException {
		ICiOpOrderMainService service = ServiceFinder.find(ICiOpOrderMainService.class);
		OrderOperateDTO arg = new OrderOperateDTO();
		FArrayList list = new FArrayList();
		list.addAll(id_ors);
		arg.setDocument(list);
		service.delete(new CiEnContextDTO(), arg);
	}

	/**
	 * 删除关联单据
	 * 
	 * @param idappsheeets
	 * @throws BizException
	 */
	private void deleteDirive(List<String> idappsheeets) throws BizException {
		if (idappsheeets == null || idappsheeets.size() == 0) {
			return;
		}
		ICiappdiriveorreldoCudService service = ServiceFinder.find(ICiappdiriveorreldoCudService.class);
		ICiappdiriveorreldoRService rService = ServiceFinder.find(ICiappdiriveorreldoRService.class);
		CiAppDiriveOrRelDO[] rels = rService.findByAttrValStrings(CiAppDiriveOrRelDO.ID_APP,
				idappsheeets.toArray(new String[0]));
		service.delete(rels);
	}
}
