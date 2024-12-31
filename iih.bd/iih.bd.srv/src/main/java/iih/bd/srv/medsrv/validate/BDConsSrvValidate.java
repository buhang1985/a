package iih.bd.srv.medsrv.validate;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 会诊服务基础信息检查
 * @author wangqzh
 *
 */
public class BDConsSrvValidate extends BDSetSrvValidate {

	@Override
	public Boolean CheckValidate(MedSrvDO medsrv, List<BDErrorInfo> errorList) throws BizException {
		BDErrorInfo info = new BDErrorInfo(medsrv.getId_srv(), medsrv.getName());
		if (!super.CheckValidate(medsrv, errorList))
			info = errorList.get(errorList.size() - 1);
		
		MedSrvConsDO[] szMedSrvConsDO = ServiceFinder.find(IMedSrvConsDORService.class).find(String.format(" id_srv = '%s'",medsrv.getId_srv()) ,"", FBoolean.FALSE);
		if (szMedSrvConsDO==null || szMedSrvConsDO.length<=0){
			info.getDescList().add("会诊属性表为空");
		}
		else{
			CheckConsInfo(szMedSrvConsDO[0], info.getDescList());
		}
		if ((info.getDescList().size() > 0||info.getSubItems().size()>0)&&!errorList.contains(info)){
			errorList.add(info);
		}

		return info.getDescList().size() == 0&&info.getSubItems().size() == 0;
	}
	protected void CheckConsInfo(MedSrvConsDO s, List<String> e) {
		//会诊类型废弃不用
//		if (StringUtil.isEmpty(s.getId_constp()))
//        {
//            e.add("会诊类型为空");
//        }
//        if (StringUtil.isEmpty(s.getSd_constp()))
//        {
//            e.add("会诊类型编码为空");
//        }
        if(s.getFg_inorg().equals(null)){
        	e.add("是否院内会诊标识为空");
        }
        if(s.getFg_deps().equals(null)){
        	e.add("是否多科室会诊标识为空");
        }
        if(s.getFg_audit_clidep().equals(null)){
        	e.add("是否需科室审批标识为空");
        }
        if(s.getFg_audit_admdep().equals(null)){
        	e.add("是否需医务部审批标识为空");
        }
        // 以下暂时屏蔽 -- PO
//        if (s.getQuan_constimelimit().equals(null))
//        {
//            e.add("会诊时效为空");
//        }
//        if (StringUtil.isEmpty(s.getId_unit()))
//        {
//            e.add("时效单位为空");
//        }
//        if (s.getQuan_urg_constimelimit().equals(null))
//        {
//            e.add("加急时效为空");
//        }
//        if (StringUtil.isEmpty(s.getId_unit_urg()))
//        {
//            e.add("加急时效单位为空");
//        }
	}

}
