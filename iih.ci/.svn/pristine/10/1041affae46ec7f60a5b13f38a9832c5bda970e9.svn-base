package iih.ci.ord.s.ems.ip.ems.treat;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsTreatViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.bp.quantum.times.QuanFirstDayMpBP;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsTreatCreateBP extends BaseIpEmsCreateBP {
	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException {
		EmsCrtDTO emsCrtDTO = szEms[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(emsCrtDTO.getId_srv());
		if (CiOrdUtils.isEmpty(medSrvInfo)) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsTreatViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
				emsCrtDTO.getId_srv());
		EmsTreatViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			emsViewDTO = new EmsTreatViewDTO();
			this.orderListViewInfoFrom(ctx, medSrvInfo, emsCrtDTO.getDriverInfo(), emsViewDTO);
			BDEmsInfoCache.PutCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
					emsCrtDTO.getId_srv(),emsViewDTO);
		}else{
			emsViewDTO = (EmsTreatViewDTO)cacheEmsViewDTO.clone();	
		}
		
		// 计算执行科室信息
		this.calcOrderWfDeptInfo(ctx, medSrvInfo, emsViewDTO);
		
		// 设置医生，科室，等可变信息
		this.setOrdDeptEmpInfo(ctx, emsViewDTO);
		
		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);
		
		//处理前台传入的默认值数据
		handleDefaultInfo(emsCrtDTO,emsViewDTO);

		// 医嘱编码
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		// 非物品单价
		emsViewDTO.setPri(OrderEmsPriceUtils.calculatePrice(medSrvInfo, ctx.getId_pripat()));
		//首日执行次数
		// bug 	0145851: 【工单】护士站—》护嘱—》绑定的费用首日执行次数需要和所绑定的医嘱一样 
		//因为在63行 处理前台传入默认值的方法里 （handleDefaultInfo）方法 已经针对前台传过来的参数赋值过(应用于护嘱-首日执行次数不为空的情况下) 
		//所以在此处 添加判断 如果为null再进行赋值
		if(emsViewDTO.getQuan_firday_mp() == null ){
			emsViewDTO.setQuan_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(emsViewDTO.getId_freq(), emsViewDTO.getDt_effe(),null, emsViewDTO.getSd_srvtp(), emsViewDTO.getCode_entp(), null, null));
		}
		emsViewDTO.setStatus(DOStatus.NEW);
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);
		rst.setDocument(this.handleReturnDocument(emsViewDTO));
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	

	@Override
	protected void orderListViewInfoFrom(CiEnContextDTO ctx, MedSrvDO medSrv, EmsDriverInfo driverInfo,
			OrderListViewDTO orderListViewDTO) throws BizException {
		super.orderListViewInfoFrom(ctx, medSrv, driverInfo, orderListViewDTO);
		if (CiOrdUtils.isTrue(orderListViewDTO.getFg_set())) {
			MedSrvSetItemDO[] medSrvSetItemDOs = BdSrvInfoUtils.QueryMedSrvSetItemBy(medSrv.getId_srv(), true);
			if (!CiOrdUtils.isEmpty(medSrvSetItemDOs)) {
				FArrayList setItemList = new FArrayList();
				for (MedSrvSetItemDO setItem : medSrvSetItemDOs) {
					setItemList.append(setItem);
				}
				orderListViewDTO.setExtInfoList(setItemList);
			}
		}
	}
	
}
