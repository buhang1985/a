package iih.ci.ord.s.ems.ip.ems.transdept;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsTransDeptViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.base.bizline.GetDeptsStr8DepWardRelBlTpBP;
import iih.ci.ord.s.ems.defsave.DefaultTransDeptCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSingleSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.TransOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

public class EmsTransDeptSaveBP extends BaseIpEmsSingleSaveBP {
	public EmsTransDeptSaveBP() {
		// 设置有效性检查
		setEmsValidate(new EmsTransDeptValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultTransDeptCreateOrderInfo());
	}

	public EmsTransDeptSaveBP(IEmsValidate emsValidate) {
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultTransDeptCreateOrderInfo());
	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		EmsSaveRstInfo emsSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		ObjectList appList = new ObjectList();
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {

				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				if (objAppSheetInfo instanceof OrdApTransDO) {// 转科申请单保存
					((OrdApTransDO) objAppSheetInfo).setId_or(opInfo.getOrderInfo().getId_or());
					appList.add(CiOrdAppUtils.getOrapptransdepService().save(opInfo.getOrderAppSheetList()
							.toArray(new OrdApTransDO[opInfo.getOrderAppSheetList().size()]))[0]);
				}
			}
		}
		emsSaveInfo.szAppInfo = appList.toArray();
		return emsSaveInfo;
	}

	/**
	 * 合并医嘱
	 * 
	 * @param orderInfo
	 * @param uiModel
	 * @throws BizException
	 */
	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo) throws BizException {
		super.mergeOrderInfo(ctx, pInfo);
		CiOrderDO orderInfo = pInfo.getOrderInfo();
		orderInfo.setTimes_mp_in(null);
		orderInfo.setOr_total_pri(null);
		// EmsTransViewDTO emsTransDto = (EmsTransViewDTO)uiModel;
	}

	/**
	 * 合并服务
	 * 
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);
		srvInfo.setId_dep_wh(null); // 物资流向科室为空
		srvInfo.setPri(null);
		// EmsTransViewDTO emsTransDto = (EmsTransViewDTO) uiModel;
	}

	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		OrderListViewDTO viewDTO = (OrderListViewDTO) uiModel;
		for (Object obj : appSheetList) {
			OrdApTransDO transdo = (OrdApTransDO) obj;
			// transdo.setId_ortrans();//医嘱转科申请主键标识
			transdo.setId_or(viewDTO.getId_or());// 医嘱 REF 临床医嘱
			transdo.setId_dep_to(viewDTO.getId_extend());// 目标科室 REF 部门
			transdo.setId_dep_from(ctx.getId_dep_or());// 原科室 REF 部门 id_d
			transdo.setId_dep_nur_from(ctx.getId_dep_ns());// 原病区 REF 部门 id_d
			if (viewDTO.getStatus() == DOStatus.NEW) {
				transdo.setId_su_trans(ICiDictCodeConst.ID_TRANSE_STATUS_OPEN);// 转科过程状态
				transdo.setSd_su_trans(ICiDictCodeConst.SD_TRANSE_STATUS_OPEN);// 转科过程状态编码
			}

			// transdo.setDes_rea_canc();//转科申请原因 SINGLE
			transdo.setFg_tech_trans(FBoolean.FALSE);// 转医技科室 SINGLE FBoo
			// transdo.setFg_crossdept();//跨科标识 SINGLE FBoo
			// transdo.setDt_effe();//跨科生效时间 SINGLE
			// transdo.setDt_end();//跨科失效时间 SINGLE
			transdo.setDt_trans_apply(viewDTO.getDt_effe());// 转科申请时间 SINGLE
			transdo.setStatus(viewDTO.getStatus());
			if (OrderPrescribeModuleEnum.ORDERLIST.equals(viewDTO.getEu_orderPrescribeModule())) {
//				transdo.setId_dep_nur_to(getDeptRelNur(viewDTO.getId_extend(), ctx.getId_org()));// 目标病区
			}
			if (OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())) {
				EmsTransDeptViewDTO transDto = (EmsTransDeptViewDTO) viewDTO;
				transdo.setId_dep_to(transDto.getId_dep_to());// 目标科室 REF 部门
				transdo.setId_dep_nur_to(transDto.getId_dep_nur_to());// 目标病区
				transdo.setDt_trans_apply(transDto.getDt_trans_apply());// 转科申请时间
				transdo.setId_transreason(transDto.getId_transreason());// 转科原因参照主键
				transdo.setTransreason(transDto.getTransreason());// 转科原因参照
			}
		}

	}

	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx, Object uiModel) {
		OrderListViewDTO uidto = (OrderListViewDTO) uiModel;
		TransOrContentParam param = new TransOrContentParam();
		param.setName_srv(uidto.getName_srv());
		param.setSd_srvtp(uidto.getSd_srvtp());
		param.setSd_nodispense(uidto.getSd_nodispense());
		if (uidto instanceof EmsTransDeptViewDTO) {
			param.setName_dep_to(((EmsTransDeptViewDTO) uidto).getName_dep_to()); //
			param.setName_dep_nur_to(((EmsTransDeptViewDTO) uidto).getName_dep_nur_to());
		} else {
			param.setName_dep_to(uidto.getExtend());
		}
		return CiOrContentUtils.create(param);
	}

	// private String getId_dep_nur_to(String id_dep_to) throws BizException{
	// String sql="select id_dep from bd_dep where id_parent=?";
	// SqlParam param = new SqlParam();
	// param.addParam(id_dep_to);
	// List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sql, param);
	// return sqlRst == null || sqlRst.size() <= 0 ? null : (String)
	// sqlRst.get(0).get("id_dep");
	// }
	private String getDeptRelNur(String id_dep_to, String id_org) throws BizException {
		GetDeptsStr8DepWardRelBlTpBP bp = new GetDeptsStr8DepWardRelBlTpBP();
		String id_nurs = bp.exec(id_org, id_dep_to, FBoolean.TRUE);
		if (CiOrdUtils.isEmpty(id_nurs))
			return null;
		String[] nurs = id_nurs.split(",");
		return nurs[0];
	}
}
