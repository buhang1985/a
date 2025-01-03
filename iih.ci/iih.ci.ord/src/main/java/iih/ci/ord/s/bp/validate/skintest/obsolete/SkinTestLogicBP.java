package iih.ci.ord.s.bp.validate.skintest.obsolete;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.pi.reg.pat.d.PatDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

/**
 * 旧模式下，医嘱复制时，皮试处理逻辑
 * @author zhangwq
 *
 */
public class SkinTestLogicBP {
	public static String CheckSrvSkinLogic(OrdSrvDO srvdo,String id_srvskin) throws BizException {
			SkinTestParamDTO param = new SkinTestParamDTO();
	        param.setId_mm(srvdo.getId_mm());
	        param.setId_org(Context.get().getOrgId()); 
	        param.setId_pi(srvdo.getId_pat());
	        PatDO piPatDO = CiOrdAppUtils.getIPatiMDORService().findById(srvdo.getId_pat());
	        if(piPatDO!=null)param.setDt_birth(piPatDO.getDt_birth());
	        param.setId_srv(srvdo.getId_srv());
	        if(CiOrdUtils.isEmpty(id_srvskin)){
	        	MeterialDO skinMMDO = getMeterialMDORService().findById(srvdo.getId_mm());
	        	if(skinMMDO != null ){
	        		id_srvskin = skinMMDO.getId_srvskin();
	        	}
	        }
	        param.setId_skinsrv(id_srvskin);
	        SkinTestRstDTO retDTO = CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
	        String code = String.valueOf(retDTO.getAllergicpharmhandlemode());
	        //禁用
	        if (code.equals("0"))
	        {
	        	return "患者于" + retDTO.getDt_act() + "对" + srvdo.getName() + "过敏！";
	        }//再皮试1;皮试逻辑，3
	        else if (code.equals("1") || code.equals("3"))
	        {
	        	srvdo.setSd_reltp(ICiDictCodeConst.CODE_SKIN_SKIN);
	        	srvdo.setFg_skintest(FBoolean.TRUE);
	        	return srvdo.getName()+"需皮试，请手动开立!";
	        }//强制使用2
	        else if (code.equals("2"))
	        {
	        	return "强制使用需要医生填写强制使用原因，要抛到前台去";
	        }//直接使用，不皮试4
	        else if (code.equals("4"))
	        {
	        	srvdo.setSd_reltp(ICiDictCodeConst.CODE_SKIN_FORCEUSE);
	        	srvdo.setFg_skintest(FBoolean.FALSE);
	        }//测试了，未出结果5
	        else if (code.equals("5"))
	        {
	        	srvdo.setSd_reltp(ICiDictCodeConst.CODE_SKIN_NORESULT);
	        	srvdo.setFg_skintest(FBoolean.TRUE);
	        	srvdo.setId_or_rel(retDTO.getId_skinor());
	        }
	        if(FBoolean.TRUE.equals(srvdo.getFg_skintest()) && StringUtils.isEmpty(srvdo.getId_or_rel())){
	        	return srvdo.getName()+"需皮试，请手动开立!";
	        }
	        return "";
	}
	public static IMeterialMDORService getMeterialMDORService() {
		IMeterialMDORService mmRService = ServiceFinder.find(IMeterialMDORService.class);
		return mmRService;
	}
}
