package iih.ci.ord.s.ems.ip.ems.opr;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsOprViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.defsave.DefaultOprCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSingleSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderSrvList;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.OprOrContentParam;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单保存逻辑
 * @author Young
 *
 */
public class EmsOprSaveBP extends BaseIpEmsSingleSaveBP {
	
	public EmsOprSaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsOprValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultOprCreateOrderInfo());
	}
	
	public EmsOprSaveBP(IEmsValidate emsValidate) {
		super();
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultOprCreateOrderInfo());
	}
	
	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		EmsSaveRstInfo emsSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		ObjectList appList= new ObjectList();
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList()) ) {
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				// 手术申请单保存
				if (objAppSheetInfo instanceof CiorappsurgeryAggDO) { 
					((CiorappsurgeryAggDO) objAppSheetInfo).getParentDO().setId_or(opInfo.getOrderInfo().getId_or());
					appList.add( CiOrdAppUtils.getOrappsurgerytService().save(opInfo.getOrderAppSheetList().toArray(new CiorappsurgeryAggDO[] {}))[0]);
				}
			}
		}
		emsSaveInfo.szAppInfo = appList.toArray();
		return emsSaveInfo;
	}
	
	/**
	 * 合并用户数据到默认医嘱中
	 * @param ctx 就诊上下文
	 * @param szOrderPakageInfo 批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException 业务异常
	 */
	@Override
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) 
			throws BizException{
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			// 合并医嘱UI模型数据
			mergeOrderInfo(ctx, pInfo);
			OrderSrvMmList dellist = new OrderSrvMmList();
			// 合并服务UI模型数据
			for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
				if(!srvMmInfo.getOrderSrvInfo().getId_srv().equals(pInfo.getOrderInfo().getId_srv())){
					if(pInfo.getOrderInfo().getStatus()==DOStatus.NEW){
						dellist.add(srvMmInfo);
					}else{
						srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
					}
					continue;
				}

				// 合并服务信息
				mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
				// 处理其他信息
				afterMergeOrderSrvInfo(ctx,pInfo.getOrderInfo(),srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());

				if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())){
					mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(),srvMmInfo.getUiModel());
				}
			}
			if(pInfo.getUiModel() instanceof EmsOprViewDTO){
				EmsOprViewDTO ems = (EmsOprViewDTO)pInfo.getUiModel();
				if(dellist.size()>0){
					for (OrderSrvMmInfo srvMmInfo : dellist) {
						pInfo.getOrderSrvMmList().remove(srvMmInfo);
					}
				}
				if(!StringUtil.isEmpty(ems.getId_opex_srvs())){
					// 创建附加术服务信息
					getExOprSrvInfo(ctx,ems.getId_opex_srvs(),pInfo);
				}
			}
			//合并申请单信息
			if (!CiOrdUtils.isEmpty(pInfo.getOrderAppSheetList())){
				mergeOrderAppInfo(ctx,pInfo.getOrderAppSheetList().asArray(),pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
			// 多剂量多频次计算总量
			handleSrvQuan(pInfo.getOrderInfo(), pInfo.getOrderSrvList());
		}
		return szOrderPakageInfo;
	}

	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	@Override
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		// 手术申请单保存
		CiorappsurgeryAggDO[] szCiorappsurgeryAggDO = CiOrdAppUtils.getOrappsurgeryQrytService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappsurgeryAggDO)){
			return szCiorappsurgeryAggDO;
		}
		return null;
	}
	
	/**
	 * 附加术生成服务信息
	 * @param medsrvs
	 * @param orderInfo
	 * @param ctx
	 * @throws BizException
	 */
	private OrderSrvList assumbleExtOprInfo(CiEnContextDTO ctx, MedSrvDO[] medsrvs, CiOrderDO orderInfo) 
			throws BizException{
		OrderSrvList ordsrvlist = new OrderSrvList();
		int i = 1;
		for(MedSrvDO medsrv : medsrvs){
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_or(orderInfo.getId_or());
			srvdo.setId_org(ctx.getId_org());
			srvdo.setId_grp(ctx.getId_grp());
			srvdo.setId_pat(ctx.getId_pat());
			srvdo.setId_entp(ctx.getId_entp());
			srvdo.setCode_entp(ctx.getCode_entp());
			srvdo.setId_en(ctx.getId_en());
			srvdo.setId_srvtp(medsrv.getId_srvtp());
			srvdo.setSd_srvtp(medsrv.getSd_srvtp());
			srvdo.setId_srv(medsrv.getId_srv());
			srvdo.setName(medsrv.getName());
			srvdo.setFg_dose_anoma(null);
			srvdo.setQuan_medu(medsrv.getQuan_med());
			srvdo.setId_medu(medsrv.getId_unit_med());
			srvdo.setId_route(medsrv.getId_route());
			srvdo.setId_routedes(medsrv.getId_routedes());
			srvdo.setId_boil(medsrv.getId_boil());
			srvdo.setId_boildes(medsrv.getId_boildes());
			srvdo.setId_freq(medsrv.getId_freq()); 
			srvdo.setId_org_srv(ctx.getId_org());
			srvdo.setId_dep_srv(ctx.getId_dep_or());
			srvdo.setId_wg_or(ctx.getId_wg_or());
			srvdo.setId_emp_srv(ctx.getId_emp_or());
			srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

			srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(orderInfo.getId_dep_mp()));
			srvdo.setId_dep_mp(orderInfo.getId_dep_mp());
			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			srvdo.setQuan_total_medu(medsrv.getQuan_med());// 计算服务总量
			srvdo.setFg_or(medsrv.getFg_or());
			srvdo.setEu_blmd(medsrv.getEu_blmd());
			srvdo.setFg_mm(CiOrdUtils.nullHandle(medsrv.getFg_mm()));
			// 映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), medsrv.getId_srv(),
					medsrv.getId_primd(), srvdo);
			srvdo.setPri(medsrv.getPri());
			srvdo.setPri_std(medsrv.getPri());// 标准价
				
				// srvdo.setPri_ratio(medsrv.getPri_ratio());//价格系数??
//				srvdo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());// 患者价格分类
//			}
			srvdo.setFg_set(CiOrdUtils.nullHandle(medsrv.getFg_set()));
			// srvdo.setFg_indic((medsrv.getFg_hpindicjudged()));//之前关闭，现在打开了（zhangwq）//???字段类型不符合
			// srvdo.setFg_propc(CiOrdUtils.nullHandle(medsrv.getFg_propc()));
			// srvdo.setFg_self(CiOrdUtils.nullHandle(srvInfo.getFg_self()));
			// srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(null));//--
			srvdo.setNote_srv(medsrv.getDes());
			srvdo.setId_srvca(medsrv.getId_srvca());
			srvdo.setFg_bl(CiOrdUtils.nullHandle(medsrv.getFg_bl()));
			srvdo.setCode_srv(medsrv.getCode());
//			srvdo.setEu_sourcemd(Integer.parseInt(ctx.getEu_orsrcmdtp()));
			srvdo.setId_primd(medsrv.getId_primd());
			
			// srvdo.setId_reltp(srvInfo.getId_reltp());//2016-03-25 新增 关联类型
			// srvdo.setFg_hpindicjudged(srvInfo.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
			// srvdo.setFg_extdispense(srvInfo.getFg_extdispense());//外配药标识
			if (CiOrdUtils.isTrue(srvdo.getFg_skintest())) {
				srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
			} else {
				// srvdo.setSd_reltp(srvInfo.getSd_reltp());//2016-03-25 新增 关联类型编码
			}
			// srvdo.setId_or_rel(srvInfo.getId_or_rel());//2016-03-25 新增 对应关联医嘱id
			srvdo.setFg_selfsrv(medsrv.getFg_ctm());
			// srvdo.setId_srv_src(srvInfo.getId_srv_src());
			 srvdo.setQuan_total_medu(medsrv.getQuan_med());
			 srvdo.setFg_selfpay(FBoolean.TRUE);//2016-07-08新增自费标识
			srvdo.setId_hp(ctx.getId_hp());// 2016-07-12新增医保相关信息
			// srvdo.setId_hpsrvtp(ctx.getId_hpsrvtp());
			// srvdo.setSd_hpsrvtp(ctx.getSd_hpsrvtp());
			// srvdo.setDes_hplimit(ctx.getLimit());

			// srvdo.setId_dep_mp(srvInfo.getId_mp_dep());
			// srvdo.setId_dep_wh(mmdo.getId_dep_wh());
			// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
			// srvdo.setFg_base(srvInfo.getFg_base());//???
			srvdo.setInnercode_srvca(medsrv.getSrvca_innercode());
			srvdo.setFg_feertnable(FBoolean.TRUE); // 可退费标识
			srvdo.setStatus(DOStatus.NEW);
			srvdo.setSortno(i);
			srvdo.setDt_last_bl(orderInfo.getDt_effe());
			ordsrvlist.add(srvdo);
			i++;
		}
		return ordsrvlist;
		
	}

	/**
	 * 合并申请单
	 */
	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException{
		OrderListViewDTO srvdto = (OrderListViewDTO) uiModel;
		for (Object obj : appSheetList) {
			CiorappsurgeryAggDO aggdo = (CiorappsurgeryAggDO) obj;
			ordOpInfoFrom(srvdto, aggdo.getParentDO());
			List<OrdApSugViewItemDO> invitecons = new ArrayList<OrdApSugViewItemDO>();
			// 动态指标处理
			if (srvdto.getExtInfoList() == null)
				return;
			for (Object itemdo : srvdto.getExtInfoList()) {
				OrdApSugViewItemDO consitem = (OrdApSugViewItemDO) itemdo;
				invitecons.add(consitem);
			}
			if (invitecons.size() > 0) {
				aggdo.setOrdApSugViewItemDO(invitecons.toArray(new OrdApSugViewItemDO[] {}));
			}
		}
	}

	/**
	 * 手术申请单映射
	 * @param ordop
	 * @return
	 */
	private void ordOpInfoFrom(OrderListViewDTO viewDTO, OrdApOpDO opInfo){
		//		opInfo.setId_apop();
		opInfo.setId_or(viewDTO.getId_or());
//		opInfo.setId_di(ordop.getId_di());	
//		opInfo.setStr_id_diitm(ordop.getStr_id_diitm());
//		opInfo.setStr_code_di(ordop.getStr_code_di());
//		opInfo.setStr_name_di(ordop.getStr_name_di());
		opInfo.setNo_applyform(viewDTO.getNo_applyform());
		opInfo.setDt_plan(viewDTO.getDt_effe());
		opInfo.setId_anestp(viewDTO.getId_extend());
		opInfo.setSd_anestp(viewDTO.getSd_extend());
		opInfo.setId_srv(viewDTO.getId_srv());
//		opInfo.setId_srv_code(ordop);
		
		opInfo.setStatus(viewDTO.getStatus());
		if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
			EmsOprViewDTO ordop = (EmsOprViewDTO) viewDTO;
			opInfo.setDt_plan(ordop.getDt_plan());
//			opInfo.setSugplantime(ordop.get);//???
			opInfo.setId_lvlsug(ordop.getId_lvlsug());
			opInfo.setSd_lvlsug(ordop.getSd_lvlsug());
			opInfo.setId_anestp(ordop.getId_anestp());
			opInfo.setSd_anestp(ordop.getSd_anestp());
//			opInfo.setId_incitp(ordop.getId_incitp());
//			opInfo.setSd_incitp(ordop.getSd_incitp());
			opInfo.setFg_allergy(ordop.getFg_allergy());
			opInfo.setFg_patho(ordop.getFg_patho());
//			opInfo.setId_su_op(ordop.getId_su());
//			opInfo.setSd_su_op(ordop.getSd_su());
			opInfo.setAnnouncements(ordop.getAnnouncements());
			opInfo.setQuan_bt_paln(ordop.getQuan_bt_paln());
			opInfo.setId_emp_operate(ordop.getId_emp_operator());	
			opInfo.setId_emp_helper(ordop.getId_emp_helper());
//			opInfo.setId_sugbody(ordop.getId_sugbodycod());
//			opInfo.setSd_sugbody(ordop.getSd_sugbodycod());
//			opInfo.setSpecialreq(ordop.getSpecialreq());
//			opInfo.setSpecialinstrument(ordop.getSpecialinstrument());	
//			opInfo.setSpecialdes(ordop.getSpecialdes());
//			opInfo.setFg_er_sug(new FBoolean(ordop.getOptime_limit() == "2"));
//			opInfo.setFg_xq_sug(new FBoolean(ordop.getOptime_limit() == "1"));
//			opInfo.setFg_zq_sug(new FBoolean(ordop.getOptime_limit() == "0"));
//			opInfo.setFg_new_sug(ordop.getFg_new_sug());
			//		opInfo.setApopemp(ordop.geta);	
			//		opInfo.setApopmm();
			//		opInfo.setApopobsindex();
//			opInfo.setName_diag(ordop.getName_diag());
//			opInfo.setId_diitm(ordop.getId_diitm());
			opInfo.setId_lvlsug(ordop.getId_lvlsug());
			opInfo.setName_lvlsug(ordop.getName_lvlsug());
		}
		if(CiOrdUtils.isTrue(viewDTO.getFg_urgent())){
			opInfo.setId_datelimittype(ICiDictCodeConst.ID_OPDATE_LIMITTP_ER);;//手术时限
			opInfo.setSd_datelimittype(ICiDictCodeConst.SD_OPDATE_LIMITTP_ER);//手术时限
			opInfo.setName_datelimittp(ICiDictCodeConst.NAME_OPDATE_LIMITTP_ER);//手术时限
		}else{
			opInfo.setId_datelimittype(ICiDictCodeConst.ID_OPDATE_LIMITTP_ZQ);;//手术时限
			opInfo.setSd_datelimittype(ICiDictCodeConst.SD_OPDATE_LIMITTP_ZQ);//手术时限
			opInfo.setName_datelimittp(ICiDictCodeConst.NAME_OPDATE_LIMITTP_ZQ);//手术时限
		}
	}

	private void getExOprSrvInfo(CiEnContextDTO ctx, String id_opex_srvs, OrderPackageInfo pInfo) 
			throws BizException {
		// 查询附加术服务信息
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(id_opex_srvs.split(","), FBoolean.FALSE);
		OrderSrvList orsrvlst = assumbleExtOprInfo(ctx, szMedSrvInfo, pInfo.getOrderInfo());
		if (CiOrdUtils.isEmpty(pInfo.getOrderSrvMmList())) {
			pInfo.setOrderSrvMmList(new OrderSrvMmList(orsrvlst.asArray()));
		} else {
			pInfo.getOrderSrvMmList().append(orsrvlst.asArray());
		}
	}
	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx,Object uiModel){
		OrderListViewDTO uidto=(OrderListViewDTO)uiModel;
		OprOrContentParam param=new OprOrContentParam();
		param.setSd_srvtp(uidto.getSd_srvtp());
		param.setName_srv(uidto.getName_srv());
		param.setFg_urgent(uidto.getFg_urgent());
		param.setName_anestp(uidto.getExtend());
		param.setDt_begin(uidto.getDt_effe());
		param.setSd_nodispense(uidto.getSd_nodispense());
		if(uidto instanceof EmsOprViewDTO){
			if(!CiOrdUtils.isEmpty(((EmsOprViewDTO)uidto).getName_opex_srvs()))
			param.setName_opex("+"+((EmsOprViewDTO)uidto).getName_opex_srvs().replace(",", "+"));
		}
		return CiOrContentUtils.create(param);
	}
}
