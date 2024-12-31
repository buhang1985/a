package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.ci.ord.ciordems.d.OrConfirm;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.qry.getCiOrdConfirmQry2;

/**
 * 医嘱确认节点，查询待确认的医嘱</br> 
 * 签署，停止，作废确认
 */
public class getCiOrdConfirmBP {
	
	public OrConfirm[] exec(OrConfirm confirm)throws BizException{
		
		ITransQry qry = new getCiOrdConfirmQry2(confirm);
		OrConfirm[] rtn = (OrConfirm[]) AppFwUtil.getDORstWithDao(qry,OrConfirm.class);
		return dataconvert(rtn);
		
	}
	
	
	
	private OrConfirm[] dataconvert(OrConfirm[] rtn) throws BizException{
		 FDateTime	e1=CiOrdAppUtils.getServerDateTime();
		 List<OrConfirm> notshowList = new ArrayList<OrConfirm>();
		 List<OrConfirm> confirmList = new ArrayList<OrConfirm>();
		 ICiOrdQryService qryservice = ServiceFinder.find(ICiOrdQryService.class);
		 Integer num = qryservice.getIntSystemParam(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_OrStopChkMaxLeadTime);
		 Integer signnum = qryservice.getIntSystemParam(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_OrSignChkMaxLeadTime);
        for (OrConfirm orConfirm : rtn) {
        	confirmList.add(orConfirm);
        	 if (SetSorNameValue(orConfirm, e1, num,signnum))
                 notshowList.add(orConfirm);
		}
        confirmList.removeAll(notshowList);
		return confirmList.toArray(new OrConfirm[0]);
	}
	
	
	 private Boolean SetSorNameValue(OrConfirm confirm, FDateTime e1,Integer num,Integer signnum) 
     {
		 if (FBoolean.TRUE.equals(confirm.getFg_stop()) && FBoolean.FALSE.equals(confirm.getFg_chk_stop()) &&
             FBoolean.FALSE.equals(confirm.getFg_canc()) && FBoolean.TRUE.equals(confirm.getFg_pres_outp()) && FBoolean.TRUE.equals( confirm.getFg_chk()))
             return true;

         if ( FBoolean.TRUE.equals(confirm.getFg_stop()) &&  FBoolean.FALSE.equals(confirm.getFg_chk_stop()) &&
             FBoolean.FALSE.equals(confirm.getFg_canc()) && FBoolean.TRUE.equals(confirm.getFg_chk()))
         {
             if (num!=null&&num > 0)
             {
            	
            	 FDateTime f1=e1.addSeconds(num*60);
            	 if(confirm.getDt_end().compareTo(f1)>0)
                     return true;
             }
         }

         else if (FBoolean.FALSE.equals(confirm.getFg_stop()))
         {
             confirm.setDt_end(null);
             confirm.setName_emp_stop(null);
         }
         if (FBoolean.TRUE.equals(confirm.getFg_sign()) && FBoolean.FALSE.equals( confirm.getFg_chk()))
         {
           if(signnum!=null&&signnum>0){
        	   FDateTime f1=e1.addSeconds(signnum*60);
        	   if(confirm.getDt_effe().compareTo(f1)>0)
                   return true;
           }
         }

         if (FBoolean.TRUE.equals(confirm.getFg_sign()) && FBoolean.FALSE.equals(confirm.getFg_chk()))
         {
             confirm.setName_su_or("签署待确认") ;
         }
         else if (FBoolean.TRUE.equals(confirm.getFg_canc()) && FBoolean.FALSE.equals( confirm.getFg_chk_canc()))
         {
             confirm.setName_su_or("作废待确认")  ;
         }
         else if(FBoolean.TRUE.equals(confirm.getFg_stop()) && FBoolean.FALSE.equals(confirm.getFg_chk_stop()) &&
                 FBoolean.FALSE.equals(confirm.getFg_canc()) && FBoolean.TRUE.equals(confirm.getFg_chk()))
         {
             confirm.setName_su_or("停止待确认")  ;
         }else{
        	 
        	 return true;
         }


         if (confirm.getSd_sex() != null && confirm.getSd_sex().equals(IPiDictCodeConst.SD_SEX_MALE))
         {
             confirm.setName_sex_pat( "男") ;
         }
         else if (confirm.getSd_sex() != null && confirm.getSd_sex().equals(IPiDictCodeConst.SD_SEX_FEMALE))
         {
             confirm.setName_sex_pat("女") ;
         }
         else
         {
             confirm.setName_sex_pat("未知性别") ;
         }

         if (confirm.getFg_long() != null && FBoolean.TRUE.equals(confirm.getFg_long()))
         {
             confirm.setStr_long("长期");
         }
         else
         {
             confirm.setStr_long("临时");
         }
         String agestr = null;
         if (confirm.getAge_pat() != null)
         {
             if (confirm.getAge_pat().length() != 0)
             {
            	 agestr = AgeCalcUtil.getAge(new FDate(confirm.getAge_pat()));
                
             }
         }
         confirm.setName_pat(confirm.getName_pat() + "|" + confirm.getName_sex_pat() + "|" + agestr);
         return false;
     }
	
	
	
	
	

}
