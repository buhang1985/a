package iih.ci.ord.s.ems.ip.ems.transdept;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsTransDeptViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.utils.OrderEmsDtUtils;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsTransDeptCreateBP extends BaseIpEmsCreateBP {
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
		EmsTransDeptViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
				emsCrtDTO.getId_srv());
		EmsTransDeptViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			emsViewDTO = new EmsTransDeptViewDTO();
			this.orderListViewInfoFrom(ctx, medSrvInfo, emsCrtDTO.getDriverInfo(), emsViewDTO);
			BDEmsInfoCache.PutCache(ctx, emsCrtDTO.getDriverInfo().getId_ems(),
					emsCrtDTO.getId_srv(),emsViewDTO);
		}else{
			emsViewDTO = (EmsTransDeptViewDTO)cacheEmsViewDTO.clone();
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
		emsViewDTO.setDt_trans_apply(emsViewDTO.getDt_effe());
		emsViewDTO.setStatus(DOStatus.NEW);
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);
		// 主服务对象
		rst.setDocument(this.handleReturnDocument(emsViewDTO));
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

}
