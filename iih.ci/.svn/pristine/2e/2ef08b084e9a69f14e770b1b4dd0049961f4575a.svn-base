package iih.ci.ord.s.ems.ip.assi.cp.opr;

import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseCpValidate;
import iih.ci.ord.s.ems.defsave.DefaultOprCreateOrderInfo;
import iih.ci.ord.s.ems.ip.ems.opr.EmsOprSaveBP;
import iih.ci.ord.s.ems.ip.ems.opr.EmsOprValidate;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsOprSave4CP extends EmsOprSaveBP{
	
	 StringBuilder errorsb=new StringBuilder();	
	
	public EmsOprSave4CP() {
		super();
		// 设置有效性检查
		setEmsValidate(new CpOprValidateBp());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultOprCreateOrderInfo());
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
						ErrorEmsList errorlist=new CpOprValidateBp().afterSaveValidate(ctx,emsSaveInfo.szOrderInfo,emsSaveInfo.szOrderSrvInfo,emsSaveInfo.szOrderSrvMmInfo,emsSaveInfo.szAppInfo);
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
	    		try {
	    			ErrorEmsList errorlist=new EmsOprValidate().viewModelValidate(new Object[] {orderPackageInfo.getUiModel()}, ctx);
		    		if (!CiOrdUtils.isEmpty(errorlist)) {
		    			//存在错误信息
		    			setErroInfo( errorlist,orderPackageInfo);
		    		}
	    		}catch(Exception ex) {
	    			this.errorsb.append(ex.getMessage());
		    		Logger.error(ex);
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
	    
	    private Map<String,OrderPackageInfo> arr2map(OrderPackageInfo[] arr){
	    	Map<String,OrderPackageInfo> rst=new HashMap<>();
	    	for (OrderPackageInfo baseDO : arr) {

				rst.put(baseDO.getOrderInfo().getId_or(), baseDO);
			}
	    	return rst;
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

}
