package iih.ci.ord.s.ems.ip.ems.icons;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsConsViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsIConsCreateBP extends BaseIpEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException {
		EmsCrtDTO ems = szEms[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ems.getId_srv());
		if (CiOrdUtils.isEmpty(medSrvInfo)) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsConsViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, ems.getDriverInfo().getId_ems(), ems.getId_srv());
		EmsConsViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			emsViewDTO = emsModelFrom(medSrvInfo);
			this.orderListViewInfoFrom(ctx, medSrvInfo, ems.getDriverInfo(), emsViewDTO);
			BDEmsInfoCache.PutCache(ctx, ems.getDriverInfo().getId_ems(), ems.getId_srv(), emsViewDTO);
		}else{
			emsViewDTO = (EmsConsViewDTO)cacheEmsViewDTO.clone();
		}
		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);
		
		this.calcOrderWfDeptInfo(ctx, medSrvInfo, emsViewDTO);
		this.setOrdDeptEmpInfo(ctx, emsViewDTO);
		emsViewDTO.setDt_effe(OrderEmsDtUtils.GetEffeDateTime(ctx.getId_en(), ctx.getDt_open()));// 开始时间赋值
		// 医嘱编码
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());

		emsViewDTO.setDt_plan(emsViewDTO.getDt_effe()); // 计划会诊时间 SINGLE
														// FDateTime
		// 住院 会诊地点是患者床旁 就诊科室+就诊病区+床号
		emsViewDTO.setPlace(ctx.getName_dep_en() + ctx.getName_dep_ns()
				+ ctx.getName_bed()); // 申请地点名称 
		// 价格
		emsViewDTO.setPri(OrderEmsPriceUtils.calculatePrice(medSrvInfo, ctx.getId_pripat()));
		emsViewDTO.setStatus(DOStatus.NEW);
		// 返回值处理
		rst.setDocument(handleReturnDocument(emsViewDTO));
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	/**
	 * 构造会诊模型主数据
	 * 
	 * @param ctx
	 * @param med
	 * @return
	 * @throws BizException
	 */
	protected EmsConsViewDTO emsModelFrom(MedSrvDO med) throws BizException {
		EmsConsViewDTO ems = new EmsConsViewDTO();

		MedSrvConsDO srvcons = getMedSrvConsDO(med.getId_srv());
		if (srvcons != null) {
			ems.setFg_inorg(srvcons.getFg_inorg());// 是否院内会诊
			ems.setFg_deps(srvcons.getFg_deps());// 是否多科室会诊
			ems.setId_emptitle(srvcons.getId_emptitle());// 受邀医生最低职称
			ems.setSd_emptitle(srvcons.getSd_emptitle());// 受邀医生最低职称编码
			ems.setFg_emptitlelimit(srvcons.getFg_emptitlelimit());// 受邀医生是否职称限制
			ems.setFg_audit_clidep(srvcons.getFg_audit_clidep());// 是否需科室审批
			ems.setFg_audit_admdep(srvcons.getFg_audit_admdep());// 是否需医务部审批
		}
		return ems;
	}

	/**
	 * 获取会诊服务DO
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvConsDO getMedSrvConsDO(String id_srv) throws BizException {
		MedSrvConsDO[] conslist = ServiceFinder.find(IMedSrvConsDORService.class).find(" id_srv='" + id_srv + "'", null,
				FBoolean.FALSE);
		if (conslist == null || conslist.length == 0)
			return null;
		return conslist[0];
	}
}
