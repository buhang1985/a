package iih.ci.ord.s.ems.ip.ems.lis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsLisViewItemDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验医疗单创建逻辑
 * 
 * @author Young
 *
 */
public class EmsLisCreateBP extends BaseIpEmsCreateBP {

	/**
	 * 创建检验医疗单对象集合
	 */
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException {
		EmsCrtDTO emsCrtDTO = szEms[0];
		EmsRstDTO emsRstDTO = new EmsRstDTO();

		MedSrvDO medSrvDO = ServiceFinder.find(IMedsrvMDORService.class).findById(emsCrtDTO.getId_srv());
		if (medSrvDO == null) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("查询主服务信息失败！");
			emsRstDTO.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { emsRstDTO };
		}
		// 合成主UI模型对象
		
		EmsLisViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
				emsCrtDTO.getId_srv());
		//在取缓存的情况时 多线程并发会出现申请单号重复的问题  解决方式 克隆出一个新对象不再共用一个对象
		EmsLisViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
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
			emsViewDTO  = (EmsLisViewDTO) cacheEmsViewDTO.clone();
		}
		
		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);

		// 命中缓存，则更新相关信息
		this.calcOrderWfDeptInfo(ctx, medSrvDO, emsViewDTO);
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
	 * 组装检验医疗单模型信息
	 * 
	 * @param ctx
	 * @param med
	 * @return
	 * @throws BizException
	 */
	private EmsLisViewDTO emsModelFrom(CiEnContextDTO ctx, MedSrvDO medSrv, EmsCrtDTO emsCrt) throws BizException {
		MedSrvLisDO[] medSrvLisDOs = ServiceFinder.find(IMedSrvLisDORService.class)
				.find(String.format("a1.id_srv='%s'", medSrv.getId_srv()), "", FBoolean.FALSE);
		if (null == medSrvLisDOs || medSrvLisDOs.length == 0) {
			return null;
		}
		EmsLisViewDTO emsLisViewDTO = new EmsLisViewDTO();
		super.orderListViewInfoFrom(ctx, medSrv, emsCrt.getDriverInfo(), emsLisViewDTO);
		emsLisViewDTO.setId_samptp(medSrvLisDOs[0].getId_samptp());// 标本类型ID
		emsLisViewDTO.setSd_samptp(medSrvLisDOs[0].getSd_samptp());// 标本类型编码
		emsLisViewDTO.setName_samptp(medSrvLisDOs[0].getSamptp_name());// 标本类型
		emsLisViewDTO.setId_extend(medSrvLisDOs[0].getId_samptp());// 标本类型ID
		emsLisViewDTO.setSd_extend(medSrvLisDOs[0].getSd_samptp());// 标本类型编码
		emsLisViewDTO.setExtend(medSrvLisDOs[0].getSamptp_name());// 标本类型
		emsLisViewDTO.setId_sampcoltime(medSrvLisDOs[0].getId_sampcoltime()); // 标本采集时间ID
		emsLisViewDTO.setName_sampcoltime(medSrvLisDOs[0].getName_sampcoltime()); // 标本采集时间
		emsLisViewDTO.setId_sampcollecttimetp(medSrvLisDOs[0].getId_sampcollecttimetp()); // 标本采集时间类型ID
		emsLisViewDTO.setSd_sampcollecttimetp(medSrvLisDOs[0].getSd_sampcollecttimetp()); // 标本采集时间类型编码
		emsLisViewDTO.setLen_sampcoltime(medSrvLisDOs[0].getLen_sampcoltime()); // 标本采集时长
		emsLisViewDTO.setId_unit_sampcoltime(medSrvLisDOs[0].getId_unit_sampcoltime()); // 标本采集时长单位
		// 设置检验套内项目
		this.setSrvsetInfo4EmsLis(medSrv.getId_srv(), emsLisViewDTO);

		return emsLisViewDTO;
	}

	/**
	 * 设置检验套内项目
	 * 
	 * @param id_srv
	 * @param emsLisViewDTO
	 * @throws BizException
	 */
	private void setSrvsetInfo4EmsLis(String id_srv, EmsLisViewDTO emsLisViewDTO) throws BizException {
		Map<String, MedSrvSetItemDO> mapSrvSetItemDOs = new HashMap<String, MedSrvSetItemDO>();
		List<String> idsrvs = new ArrayList<String>();
		if (FBoolean.TRUE.equals(emsLisViewDTO.getFg_set())) {
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
		} else {
			idsrvs.add(id_srv);
		}

		// 获取套内项目的基础服务定义信息
		MedsrvAggDO[] medsrvAggDOs = ServiceFinder.find(IMedsrvRService.class)
				.findByIds(idsrvs.toArray(new String[] {}), FBoolean.FALSE);
		FArrayList setItemList = new FArrayList();
		for (MedsrvAggDO agg : medsrvAggDOs) {
			MedSrvLisDO[] medSrvLisDOs = agg.getMedSrvLisDO();
			if (medSrvLisDOs == null || medSrvLisDOs.length <= 0)
				continue;
			for (MedSrvLisDO medSrvLisDO : medSrvLisDOs) {
				EmsLisViewItemDTO emsLisViewItemDTO = new EmsLisViewItemDTO();
				if (mapSrvSetItemDOs.size() > 0) {
					if (mapSrvSetItemDOs.containsKey(medSrvLisDO.getId_srv())) {
						MedSrvSetItemDO item = mapSrvSetItemDOs.get(medSrvLisDO.getId_srv());
						emsLisViewItemDTO.setFg_edit(item.getFg_edit());// 套内项可编辑标识
						// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
						emsLisViewItemDTO.setFg_check(new FBoolean(
								CiOrdUtils.isTrue(item.getFg_clinical()) && !CiOrdUtils.isTrue(item.getFg_edit())));
					}
				} else {
					emsLisViewItemDTO.setFg_edit(FBoolean.FALSE);// 套内项可编辑标识
					emsLisViewItemDTO.setFg_check(FBoolean.TRUE);// 临床项目可选标志

				}
				emsLisViewItemDTO.setId_srv(medSrvLisDO.getId_srv());// 套内项服务ID
				emsLisViewItemDTO.setName_srv(agg.getParentDO().getName());// 套内项服务
				emsLisViewItemDTO.setId_primd(agg.getParentDO().getId_primd());// 定价模式
				// emsRisViewItemDTO.setId_or_srv(Id_or_srv);//医嘱服务
				setItemList.append(emsLisViewItemDTO);
			}
		}
		emsLisViewDTO.setExtInfoList(setItemList);
	}
}
