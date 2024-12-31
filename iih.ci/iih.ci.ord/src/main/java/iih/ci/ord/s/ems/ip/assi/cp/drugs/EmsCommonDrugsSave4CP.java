package iih.ci.ord.s.ems.ip.assi.cp.drugs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsSaveBP;
import iih.ci.ord.s.ems.ip.ems.commondrugs.EmsCommonDrugsValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.utils.GetOrdValidateInfoBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsCommonDrugsSave4CP extends EmsCommonDrugsSaveBP{
	
	StringBuilder errorsb=new StringBuilder();	
	
	public EmsCommonDrugsSave4CP() {
		super();
		this.setEmsValidate(new CpDrugsValidateBp());
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}
    @Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		EmsSaveRstInfo emsSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);
		validateErroInfo( ctx, orderPackageInfoList);
		Map<String,OrderPackageInfo> rst=arr2map(orderPackageInfoList.asArray());
		CiOrderDO[] ords=emsSaveInfo.szOrderInfo;
		for (CiOrderDO ciOrderDO : ords) {
			OrderPackageInfo pkg=rst.get(ciOrderDO.getId_or());
			ciOrderDO.setError_des(pkg.getOrderInfo().getError_des());
			ciOrderDO.setError_level(pkg.getOrderInfo().getError_level());
			ciOrderDO.setStatus(DOStatus.UPDATED);
			if(!"E".equals(ciOrderDO.getError_level())) {
				try {
					ErrorEmsList errorlist=new CpDrugsValidateBp().afterSaveValidate(ctx,emsSaveInfo.szOrderInfo,emsSaveInfo.szOrderSrvInfo,emsSaveInfo.szOrderSrvMmInfo,emsSaveInfo.szAppInfo);
	    			if (!CiOrdUtils.isEmpty(errorlist)) {
	        			//存在错误信息
	        			setErroInfo( errorlist,pkg);
	        			ciOrderDO.setError_des(pkg.getOrderInfo().getError_des());
	        			ciOrderDO.setError_level(pkg.getOrderInfo().getError_level());
	        			ciOrderDO.setStatus(DOStatus.UPDATED);
	        		}
				}catch(Exception ex) {
					Logger.error(ex);
					ciOrderDO.setError_des(ciOrderDO.getError_des()+ex.getMessage());
        			ciOrderDO.setError_level("E");
        			ciOrderDO.setStatus(DOStatus.UPDATED);
				}
				
			}
			try {
			CiorderAggDO agg=new CiorderAggDO();
			agg.setParentDO(ciOrderDO);
			agg.setOrdSrvDO(pkg.getOrderSrvList());
			String msg=new GetOrdValidateInfoBP().getOrdWhDeptValidateInfo(new CiorderAggDO[] {agg});
			if(msg!=null&&msg.trim().length()>0) {
				ciOrderDO.setError_des(ciOrderDO.getError_des()+msg);
    			ciOrderDO.setError_level("E");
    			ciOrderDO.setStatus(DOStatus.UPDATED);
			}
			}catch(Exception ex) {
				ciOrderDO.setError_des(ciOrderDO.getError_des()+ex.getMessage());
    			ciOrderDO.setError_level("E");
    			ciOrderDO.setStatus(DOStatus.UPDATED);
			}
    		if(this.errorsb.length()>0) {
    			ciOrderDO.setError_des(ciOrderDO.getError_des()+this.errorsb.toString());
    			ciOrderDO.setError_level("E");
    			ciOrderDO.setStatus(DOStatus.UPDATED);
    		}
			
		}
		if (!CiOrdUtils.isEmpty(ords)) {
			emsSaveInfo.szOrderInfo = ServiceFinder.find(ICiorderMDOCudService.class).save(ords);
		}
		return emsSaveInfo;
	}
    
    private void validateErroInfo(CiEnContextDTO ctx,OrderPackageInfoList orderPackageInfoList) throws BizException {
    	OrderPackageInfo[] pkgs=orderPackageInfoList.asArray();
    	for (OrderPackageInfo orderPackageInfo : pkgs) {  
    		ArrayList obj=(ArrayList)orderPackageInfo.getUiModel();
    		try {
    			ErrorEmsList errorlist=new EmsCommonDrugsValidate().viewModelValidate(obj.toArray(), ctx);
        		if (!CiOrdUtils.isEmpty(errorlist)) {
        			//存在错误信息
        			setErroInfo( errorlist,orderPackageInfo);
//        			CiOrContentDO orcontent=this.getOrderContent2(ctx, obj,orderPackageInfo.getOrderInfo());
//        			orderPackageInfo.getOrderInfo().setContent_or(orcontent.toString());
        		}
    		}catch(Exception ex) {
    			Logger.error(ex);
    			this.errorsb.append(ex.getMessage());
    		}
    		
    		

    		
		}
    	
    }
    
    private void setErroInfo(ErrorEmsList errorAllList,OrderPackageInfo orderPackageInfo) {
    	String error_des = "";
    	if(orderPackageInfo.getOrderInfo().getError_des()!=null)
    	 error_des =  orderPackageInfo.getOrderInfo().getError_des();
    	for(ErrorEmsDTO error:errorAllList){
    		error_des += error.getError_message();
		}
    	orderPackageInfo.getOrderInfo().setError_level(errorAllList.get(0).getError_level());
		orderPackageInfo.getOrderInfo().setError_des(error_des);
    }
    @Override
	protected void handleSrvQuan(CiOrderDO order, OrdSrvDO[] ordsrvs) throws BizException {
		// TODO Auto-generated method stub
		try {
			super.handleSrvQuan(order, ordsrvs);
		}catch(Exception ex) {
			this.errorsb.append(ex.getMessage());
    		Logger.error(ex);
		}
		
	}
    private Map<String,OrderPackageInfo> arr2map(OrderPackageInfo[] arr){
    	Map<String,OrderPackageInfo> rst=new HashMap<>();
    	for (OrderPackageInfo baseDO : arr) {

			rst.put(baseDO.getOrderInfo().getId_or(), baseDO);
		}
    	return rst;
    }
    
}
