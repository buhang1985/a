package iih.ci.ord.s.ems.ip.assi.cp.drugs;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsSaveBP;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class CpCommonDrugSaveBP extends EmsCommonDrugsSaveBP{
	
	public CpCommonDrugSaveBP() {
		this.setEmsValidate(new CpDrugsValidateBp());
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}
    @Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
    	EmsSaveRstInfo emsSaveRstInfo = new EmsSaveRstInfo();

		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);

		// 保存医嘱服务物品信息
		OrdSrvMmDO[] szOrdSrvMmInfo = orderPackageInfoList.asOrderSrvMmArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvMmInfo)) {
			emsSaveRstInfo.szOrderSrvMmInfo = CiOrdAppUtils.getOrsrvmmService().save(szOrdSrvMmInfo);
		}

		// 保存医嘱服务信息
		OrdSrvDO[] szOrdSrvInfo = orderPackageInfoList.asOrderSrvArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvInfo)) {
			emsSaveRstInfo.szOrderSrvInfo = ServiceFinder.find(IOrdSrvDOCudService.class).save(szOrdSrvInfo);
		}

		// 保存医嘱信息
		CiOrderDO[] szOrderInfo = orderPackageInfoList.asOrderArray();
		validateErroInfo( ctx, orderPackageInfoList);
		this.setOrdSortno(szOrderInfo, ctx.getId_en());// 设置医嘱序号
		if (!CiOrdUtils.isEmpty(szOrderInfo)) {
			emsSaveRstInfo.szOrderInfo = ServiceFinder.find(ICiorderMDOCudService.class).save(szOrderInfo);
		}
		return emsSaveRstInfo;
	}
    
    private void validateErroInfo(CiEnContextDTO ctx,OrderPackageInfoList orderPackageInfoList) throws BizException {
    	OrderPackageInfo[] pkgs=orderPackageInfoList.asArray();
    	for (OrderPackageInfo orderPackageInfo : pkgs) {  
    		ArrayList obj=(ArrayList)orderPackageInfo.getUiModel();
    		ErrorEmsList errorlist=new EmsCommonDrugsValidate().viewModelValidate(obj.toArray(), ctx);
    		if (!CiOrdUtils.isEmpty(errorlist)) {
    			//存在错误信息
    			setErroInfo( errorlist,orderPackageInfo);
    		}
    		
		}
    	
    }
    
    private void setErroInfo(ErrorEmsList errorAllList,OrderPackageInfo orderPackageInfo) {
    	String error_des = "";
    	for(ErrorEmsDTO error:errorAllList){
    		error_des += error.getError_message();
		}
    	orderPackageInfo.getOrderInfo().setError_level(errorAllList.get(0).getError_level());
		orderPackageInfo.getOrderInfo().setError_des(error_des);
    }
}
