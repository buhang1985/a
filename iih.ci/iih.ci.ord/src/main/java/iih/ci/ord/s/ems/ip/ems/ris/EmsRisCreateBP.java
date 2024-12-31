package iih.ci.ord.s.ems.ip.ems.ris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查医疗单创建逻辑
 * 
 * @author Young
 *
 */
public class EmsRisCreateBP extends BaseIpEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsCrtDTOs) throws BizException {
		EmsCrtDTO emsCrtDTO = emsCrtDTOs[0];
		EmsRstDTO emsRstDTO = new EmsRstDTO();

		MedSrvDO medSrvDO = ServiceFinder.find(IMedsrvMDORService.class).findById(emsCrtDTO.getId_srv());
		if (medSrvDO == null) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("查询主服务信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}
		// 尝试缓存命中
		EmsRisViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
				emsCrtDTO.getId_srv());
		//在取缓存的情况时 多线程并发会出现申请单号重复的问题  解决方式 克隆出一个新对象不再共用一个对象
		EmsRisViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			// 没有命中缓存，则需要计算模型信息
			emsViewDTO = emsModelFrom(ctx, medSrvDO, emsCrtDTO);
			if (emsViewDTO == null) {
				FArrayList errorEmsList = new FArrayList();
				errorEmsList.append(String.format("没有查到【%s】服务的属性信息", medSrvDO.getName()));
				emsRstDTO.setErrorEmsList(errorEmsList);
				return new EmsRstDTO[] { emsRstDTO };
			}
			BDEmsInfoCache.PutCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
					emsCrtDTO.getId_srv(),emsViewDTO);
		}else{
			emsViewDTO  = (EmsRisViewDTO) cacheEmsViewDTO.clone();
		}

		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);

		// 计算执行科室信息
		this.calcOrderWfDeptInfo(ctx, medSrvDO, emsViewDTO);
		
		// 设置UI对象中的可变信息：科室，开立医生 等等
		this.setOrdDeptEmpInfo(ctx, emsViewDTO);

		emsViewDTO.setDt_effe(OrderEmsDtUtils.GetEffeDateTime(ctx.getId_en(), ctx.getDt_open()));// 开始时间赋值
		
		//处理前台传入的默认值数据
		handleDefaultInfo(emsCrtDTO,emsViewDTO);
				
				
		// 医嘱编码
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());

		// 诊断
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			emsViewDTO.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			emsViewDTO.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsViewDTO.setName_diitm(diagOutlineInfo.getName_diag());// 主诊断名称
		}
		// 非物品单价
		emsViewDTO.setPri(OrderEmsPriceUtils.calculatePrice(medSrvDO, ctx.getId_pripat()));
		// 设置对象结构的状态为【新建】
		emsViewDTO.setStatus(DOStatus.NEW);

		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);

		emsRstDTO.setDocument(this.handleReturnDocument(emsViewDTO));
		return new EmsRstDTO[] { emsRstDTO };
	}

	/**
	 * 创建主模型对象
	 * 
	 * @param medSrv
	 * @return
	 * @throws BizException
	 */
	protected EmsRisViewDTO emsModelFrom(CiEnContextDTO ctx, MedSrvDO medSrv, EmsCrtDTO emsCrtDTO) throws BizException {
		EmsRisViewDTO emsRisViewDTO = new EmsRisViewDTO();
		super.orderListViewInfoFrom(ctx, medSrv, emsCrtDTO.getDriverInfo(), emsRisViewDTO);
		emsRisViewDTO.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);// 检查目的ID
		emsRisViewDTO.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);// 检查目的编码
		emsRisViewDTO.setName_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE);// 检查目的：协助诊断
		// emsRisViewDTO.setId_di(Id_di);//临床诊断ID
		// emsRisViewDTO.setId_diitm(Id_diitm);//诊断子项ID
		// emsRisViewDTO.setName_diitm(Name_diitm);//临床诊断
		emsRisViewDTO.setNo_applyform(CiOrdUtils.getApplyNo(medSrv.getSd_srvtp()));// 申请单号
		// emsRisViewDTO.setFg_set(medSrv.getFg_set());//服务套标识
		// emsRisViewDTO.set(medSrv.getFg_setradio());//服务套单选标识
		emsRisViewDTO.setClinicalzztz(OrderUtils.getClinicalzztzInfo(ctx.getId_en()));// 临床症状体征
		// 设置检查套内项目
		this.setSrvsetInfo4EmsRis(medSrv.getId_srv(), emsRisViewDTO);

		return emsRisViewDTO;
	}

	/**
	 * 设置检查套内项目
	 * 
	 * @param id_srv
	 * @param emsRisViewDTO
	 * @throws BizException
	 */
	private void setSrvsetInfo4EmsRis(String id_srv, EmsRisViewDTO emsRisViewDTO) throws BizException {
		Map<String, MedSrvSetItemDO> mapSrvSetItemDOs = new HashMap<String, MedSrvSetItemDO>();
		List<String> idsrvs = new ArrayList<String>();
		if (FBoolean.TRUE.equals(emsRisViewDTO.getFg_set())) {
			// 服务套项目
			MedSrvSetItemDO[] medSrvSetItemDOs = ServiceFinder.find(IMedSrvSetItemDORService.class).find(
					String.format("a8.id_srv='%s' and a8.fg_clinical='Y' and a8.fg_active='Y'", id_srv), "",
					FBoolean.FALSE);
			if (null == medSrvSetItemDOs || medSrvSetItemDOs.length == 0) {
				return;
			}

			for (MedSrvSetItemDO item : medSrvSetItemDOs) {
				idsrvs.add(item.getId_srv_itm());
				mapSrvSetItemDOs.put(item.getId_srv_itm(), item);
			}
		}
		// else {
		// idsrvs.add(id_srv);
		// }

		if (idsrvs.size() <= 0)
			return;
		// 获取套内项目的基础服务定义信息
		MedsrvAggDO[] medsrvAggDOs = ServiceFinder.find(IMedsrvRService.class)
				.findByIds(idsrvs.toArray(new String[] {}), FBoolean.FALSE);
		FArrayList setItemList = new FArrayList();
		for (MedsrvAggDO agg : medsrvAggDOs) {
			MedSrvRisDO[] medSrvRisDOs = agg.getMedSrvRisDO();
			if (medSrvRisDOs == null || medSrvRisDOs.length <= 0)
				continue;
			for (MedSrvRisDO medSrvRisDO : medSrvRisDOs) {
				EmsRisViewItemDTO emsRisViewItemDTO = new EmsRisViewItemDTO();
				if (mapSrvSetItemDOs.size() > 0) {
					if (mapSrvSetItemDOs.containsKey(medSrvRisDO.getId_srv())) {
						MedSrvSetItemDO item = mapSrvSetItemDOs.get(medSrvRisDO.getId_srv());
						emsRisViewItemDTO.setFg_edit(item.getFg_edit());// 套内项可编辑标识
						// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
						if (CiOrdUtils.isTrue(emsRisViewDTO.getFg_setradio())) {
							emsRisViewItemDTO.setFg_check(FBoolean.FALSE);
						} else {
							emsRisViewItemDTO.setFg_check(new FBoolean(
									CiOrdUtils.isTrue(item.getFg_clinical()) && !CiOrdUtils.isTrue(item.getFg_edit())));
						}
					}
				} else {
					emsRisViewItemDTO.setFg_edit(FBoolean.FALSE);// 套内项可编辑标识
					emsRisViewItemDTO.setFg_check(FBoolean.TRUE);// 临床项目可选标志

				}
				emsRisViewItemDTO.setId_srv(medSrvRisDO.getId_srv());// 套内项服务ID
				emsRisViewItemDTO.setName_srv(agg.getParentDO().getName());// 套内项服务
				emsRisViewItemDTO.setId_primd(agg.getParentDO().getId_primd());// 套内项定价模式
				emsRisViewItemDTO.setId_body(medSrvRisDO.getId_body());// 检查部位ID
				emsRisViewItemDTO.setSd_body(medSrvRisDO.getSd_body());// 检查部位编码
				emsRisViewItemDTO.setName_body(medSrvRisDO.getName_body());// 检查部位
				emsRisViewItemDTO.setId_pos(medSrvRisDO.getId_pos());// 检查方位ID
				emsRisViewItemDTO.setSd_pos(medSrvRisDO.getSd_pos());// 检查方位编码
				emsRisViewItemDTO.setName_pos(medSrvRisDO.getName_pos());// 检查方位
				// emsRisViewItemDTO.setId_or_srv(Id_or_srv);//医嘱服务
				setItemList.add(emsRisViewItemDTO);
			}
		}
		emsRisViewDTO.setExtInfoList(setItemList);
	}
}
