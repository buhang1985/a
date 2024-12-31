package iih.ci.ord.s.external.blood.ruimei.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.external.blood.ruimei.d.IEOpBtUbCancelOrEnParamDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.idvproperty.d.IdVProperty;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;

public class SaveWriteBackCancleUbPbDataBp {
	

	
	
	public boolean exec(IEOpBtUbCancelOrEnParamDTO param) throws BizException {
		if(param==null)throw new BizException("参数为空！");
		ICiorderMDORService service=ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ords=service.find(" Applyno ='"+param.getApplyno()+"' and fg_chk='Y'", "", FBoolean.FALSE);
		if(ords==null)throw new BizException("未查询到符合要求的数据！");
		if(ords.length>1)throw new BizException("该申请单号对应多条数据！");
        if(ords[0].getFg_canc().booleanValue()) {
        	return true;
        }
		// 作废医生
		IPsndocRService psndocservice = ServiceFinder.find(IPsndocRService.class);
		PsndocAggDO[] docAggDO = psndocservice.find("code='" + param.getCode_emp_canc()+ "'", null, FBoolean.FALSE);
		if (docAggDO == null || docAggDO.length < 1) {
			throw new BizException("未填写作废医生，请填写!");
		}
		IdVProperty	idsv=new IdVProperty();
		idsv.setId(ords[0].getId_or());
		idsv.setVer(ords[0].getSv());
		ServiceFinder.find(ICiOrdMaintainService.class).updateOrdStatusInfo(new IdVProperty[] {idsv}, new FDateTime(param.getDt_canc()), ICiDictCodeConst.SD_SU_CANCEL);
		CiOrderDO ord=ServiceFinder.find(ICiorderMDORService.class).findById(ords[0].getId_or());
		if(ord.getFg_canc().booleanValue()) {
			return true;
		}else {
			return false;
		}
	}



}
