package iih.ci.ord.s.ems.ip.ems.dead;

import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.dws.ip.ems.d.EmsDeadViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsLoadBP;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

public class EmsDeadLoadBP extends BaseIpEmsLoadBP{

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		OrderPackageInfo[] szOrderPackageInfo = this.orderPakageInfoArrayFrom(new String[] { arg.getId_or() });
		if (CiOrdUtils.isEmpty(szOrderPackageInfo)) {
			FArrayList errorEmsList = new FArrayList();
			errorEmsList.append("获取医疗单信息失败！");
			rst.setErrorEmsList(errorEmsList);
			return new EmsRstDTO[] { rst };
		}
		OrderPackageInfo opInfo = szOrderPackageInfo[0];
		EmsDeadViewDTO ems = modelFrom(ctx, opInfo);
		if(!CiOrdUtils.isEmpty(arg.getDocument())){
			OrderListViewDTO srcdto=(OrderListViewDTO)arg.getDocument().get(0);
			this.mergeModelInfo(srcdto, ems);
		}
		//医疗单驱动
		ems.setDriverInfo(arg.getDriverInfo());
		// 医疗单模型文档
		rst.setDocument(handleReturnDocument(ems));
		// 医疗单类型
		// rst.setEmsDriver(EmsType.COMMON.toString());
		return rsts;
	}
	public EmsDeadViewDTO modelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo) throws BizException {
		EmsDeadViewDTO emsDeathDto=new EmsDeadViewDTO();
		OrdApOutDO outDo=(OrdApOutDO)opInfo.getOrderAppSheetList().get(0);
		this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), this.mainSrvInfoFrom(opInfo), emsDeathDto);
		emsDeathDto.setStatus(DOStatus.UPDATED);
		emsDeathDto.setDt_timeout(outDo.getDt_timeout());
		emsDeathDto.setDes_outtp(outDo.getDes_outtp());
		return emsDeathDto;
	}
}
