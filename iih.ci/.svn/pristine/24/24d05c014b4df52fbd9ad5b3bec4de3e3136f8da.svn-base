package iih.ci.ord.s.ems.ip.ems.dead;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.dws.ip.ems.d.EmsDeadViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsCreateBP;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsDeadCreateBP extends BaseIpEmsCreateBP {

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
		String cacheKey = String.format("%s-%s", ctx.getCode_entp(),emsCrtDTO.getId_srv());
		EmsDeadViewDTO cacheEmsViewDTO = BDEmsInfoCache.GetCache(ctx, cacheKey, emsCrtDTO.getId_srv());
		EmsDeadViewDTO emsViewDTO = null;
		if (null == cacheEmsViewDTO) {
			emsViewDTO = new EmsDeadViewDTO();
			this.orderListViewInfoFrom(ctx, medSrvInfo, emsCrtDTO.getDriverInfo(), emsViewDTO);
			BDEmsInfoCache.PutCache(ctx, cacheKey, emsCrtDTO.getId_srv(),emsViewDTO);
		}else{
			emsViewDTO = (EmsDeadViewDTO)cacheEmsViewDTO.clone();
		}

		// 处理特殊场景的频次数据
		handleMtOrderInfo(ctx, emsViewDTO);

		this.calcOrderWfDeptInfo(ctx, medSrvInfo, emsViewDTO);
		this.setOrdDeptEmpInfo(ctx, emsViewDTO);

		// 医嘱编码
//		emsViewDTO.setCode_or(
//				CiOrdAppUtils.getIBillcodeManager().getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME));
		emsViewDTO.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
		emsViewDTO.setDt_timeout(emsViewDTO.getDt_effe());// 死亡时间
		emsViewDTO.setStatus(DOStatus.NEW);
		setEmsDriverInfo(emsCrtDTO.getDriverInfo(), emsViewDTO);
		rst.setDocument(this.handleReturnDocument(emsViewDTO));
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

}
