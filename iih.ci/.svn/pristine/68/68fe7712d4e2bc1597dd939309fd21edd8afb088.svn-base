package iih.ci.ord.s.ems.ip.ems.dead;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsDeadViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.save.ip.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.ems.defsave.DefaultOuthospCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSingleSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.DeathOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 死亡医疗单医嘱保存逻辑处理
 * @author wangqingzhu
 *
 */
public class EmsDeadSaveBP extends BaseIpEmsSingleSaveBP {

	/**
	 * 构造方法，设置有效性校验业务处理对象
	 */
	public EmsDeadSaveBP() {
		// 设置有效性检查
		setEmsValidate(new EmsDeadValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultOuthospCreateOrderInfo());
	}

	public EmsDeadSaveBP(IEmsValidate emsValidate) {
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultOuthospCreateOrderInfo());
	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		EmsSaveRstInfo emsSaveRstInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);

		ObjectList appList = new ObjectList();
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {

				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				
				if (objAppSheetInfo instanceof OrdApOutDO) {// 转科申请单保存
					((OrdApOutDO)objAppSheetInfo).setId_or(opInfo.getOrderInfo().getId_or());
					appList.add( CiOrdAppUtils.getOrappoutService().save(opInfo.getOrderAppSheetList()
							.toArray(new OrdApOutDO[opInfo.getOrderAppSheetList().size()]))[0]);
				}
			}
		}
		emsSaveRstInfo.szAppInfo = appList.toArray();
		return emsSaveRstInfo;
	}

	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		OrderListViewDTO viewDTO = (OrderListViewDTO) uiModel;
		for (Object obj : appSheetList) {
			OrdApOutDO outDo = (OrdApOutDO) obj;
			// outDo.setId_orout(); //离院申请
//			 outDo.setId_or(deathDto.getId_or()); //医嘱
			outDo.setId_outtp(ICiDictCodeConst.ID_OUTTP_5); // 离院方式
			outDo.setSd_outtp(ICiDictCodeConst.SD_OUTTP_5); // 离院方式编码
			outDo.setDt_timeout(viewDTO.getDt_effe()); // 离院时间
			outDo.setId_dep_out(ctx.getId_dep_or()); // 离院时科室
			outDo.setId_dep_nur_out(ctx.getId_dep_ns()); // 离院时病区
			outDo.setId_bed_out(ctx.getId_bed()); // 离院时床位
			outDo.setFg_death(FBoolean.TRUE); // 是否死亡
			outDo.setFg_autopsy(FBoolean.FALSE); // 死亡尸检标识
			// outDo.setFg_again31(); //31日内再次计划住院标识
			// outDo.setD es_again31(); //31日内再入院目的
			outDo.setStatus(viewDTO.getStatus());
			if(OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())){
				EmsDeadViewDTO deathDto = (EmsDeadViewDTO) uiModel;
				outDo.setDt_timeout(deathDto.getDt_timeout()); // 离院时间
				outDo.setDes_outtp(deathDto.getDes_outtp()); // 离院描述
			}
		}

	}

	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, final CiOrderDO orderInfo, OrdSrvDO srvInfo,
			Object uiModel) throws BizException {
		OrderListViewDTO emsDeathDto = (OrderListViewDTO) uiModel;
		CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();
		srvInfo.setId_dep_mp(orderInfo.getId_dep_mp());
		srvInfo.setDt_last_bl(orderInfo.getDt_effe());
	}

	@Override
	protected int GetSrvObjStatus(Object uiModel) {
		return ((OrderListViewDTO) uiModel).getStatus();
	}
	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx,Object uiModel){
		OrderListViewDTO uidto=(OrderListViewDTO)uiModel;
		DeathOrContentParam param=new DeathOrContentParam();
		param.setName_srv(uidto.getName_srv());
		param.setDt_timeout(uidto.getDt_effe().toString());
		param.setSd_nodispense(uidto.getSd_nodispense());
		return CiOrContentUtils.create(param);
	}
}
