package iih.bd.srv.mropgrouppower.s.bp;

import iih.bd.srv.mropgrouppower.d.MrOpGroupPowerDO;
import iih.bd.srv.mropgrouppower.i.IMropgrouppowerCudService;
import iih.bd.srv.mropgrouppower.i.IMropgrouppowerRService;
import iih.bd.srv.mropgrouppowerdetail.d.MrOpGroupPowerDetailDO;
import iih.bd.srv.mropgrouppowerdetail.i.IMropgrouppowerdetailCudService;
import iih.bd.srv.mropgrouppowerdetail.i.IMropgrouppowerdetailRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class deletePowerBp {

	//删除所有业务组权限

	public boolean deletegrouppower(String Idmropgroup)throws BizException{
		
		IMropgrouppowerRService grouppowerRService = ServiceFinder.find(IMropgrouppowerRService.class);
		IMropgrouppowerCudService groupCudService = ServiceFinder.find(IMropgrouppowerCudService.class);
		
		MrOpGroupPowerDO [] powerdo = grouppowerRService.find("Idmropgroup = '"+ Idmropgroup +"'", "", FBoolean.FALSE);
		if(powerdo != null && powerdo.length > 0){
			IMropgrouppowerdetailRService detailRService = ServiceFinder.find(IMropgrouppowerdetailRService.class);
			IMropgrouppowerdetailCudService detailCudService = ServiceFinder.find(IMropgrouppowerdetailCudService.class);
			for(MrOpGroupPowerDO power : powerdo){
				power.setStatus(DOStatus.DELETED);
				MrOpGroupPowerDetailDO [] detaildo = detailRService.find("idmropgrouppower = '"+ power.getIdmropgrouppower() +"'", "", FBoolean.FALSE);
				if(detaildo != null && detaildo.length > 0){
					for(MrOpGroupPowerDetailDO detail : detaildo){
						detail.setStatus(DOStatus.DELETED);
					}
					detailCudService.delete(detaildo);
				}
				
			}
			groupCudService.delete(powerdo);
			return true;
		}
		
		return false;
	}
	
	//删除业务组层级下所有权限
	public boolean deletedetail(String Idmropgroup,String Idmropgrouplevel)throws BizException{
		IMropgrouppowerRService grouppowerRService = ServiceFinder.find(IMropgrouppowerRService.class);
		IMropgrouppowerCudService groupCudService = ServiceFinder.find(IMropgrouppowerCudService.class);
		
		MrOpGroupPowerDO [] powerdo = grouppowerRService.find(" Idmropgroup = '"+ Idmropgroup +"' and Idmropgrouplevel = '"+ Idmropgrouplevel +"'", "", FBoolean.FALSE);
		if(powerdo != null && powerdo.length > 0){
			IMropgrouppowerdetailRService detailRService = ServiceFinder.find(IMropgrouppowerdetailRService.class);
			IMropgrouppowerdetailCudService detailCudService = ServiceFinder.find(IMropgrouppowerdetailCudService.class);
			for(MrOpGroupPowerDO power : powerdo){
				power.setStatus(DOStatus.DELETED);
				MrOpGroupPowerDetailDO [] detaildo = detailRService.find("idmropgrouppower = '"+ power.getIdmropgrouppower() +"'", "", FBoolean.FALSE);
				if(detaildo != null && detaildo.length > 0){
					for(MrOpGroupPowerDetailDO detail : detaildo){
						detail.setStatus(DOStatus.DELETED);
					}
					
					detailCudService.delete(detaildo);
				}
			}
			groupCudService.delete(powerdo);
			return true;
		}
		return false;
	}
}
