package iih.ci.mrqc.autoqc.s.bp;

import java.util.ArrayList;
import java.util.List;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.srv.autoitm.d.AutoItmDO;
import iih.bd.srv.autoitm.i.IAutoitmRService;
import iih.bd.srv.qcevent.d.QcEventDO;
import iih.bd.srv.qcevent.i.IQceventRService;
import iih.ci.mrqc.autoqc.rulemethod.AutoQcMethodForMIsHaveRefValue;
import iih.ci.mrqc.autoqc.rulemethod.AutoQcMethodForMOne;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForIsHaveMrBP;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForIsHaveMrLimitDayBP;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForIsMrTimeOutAfterBP;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForIsMrTimeOutAfterOrNoneBP;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForIsMrTimeOutBeforeBP;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForIsMrTimeOutBeforeOrNoneBP;
import iih.ci.mrqc.autoqc.rulemethod.bp.AutoQcForRegionIsHaveTimesMrBP;
import iih.ci.mrqc.qaflt.d.QaFltDO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetAutoQcDivideDosBP {

	public  void exec( String id_ent,String id_qc_type,Boolean isDocAutoQcSelf,String qcTypeCode) throws BizException{
    	DAFacade daf=new DAFacade();
    	if(id_qc_type.equals(ICiMrDictCodeConst.ID_EXEC_AUTOMATIC)){
    		if(isDocAutoQcSelf){
    			String strSql = " ID_ENT='"+id_ent+"' and ID_QA_TY = '"+id_qc_type+"' and ds='0' and ID_REVISION = 'DOCTORAUTOQCSELF' ";
    			daf.deleteByWhere(QaFltDO.class, strSql);
    		}else{
        		String strSql = " ID_ENT='"+id_ent+"' and ID_QA_TY = '"+id_qc_type+"' and ds='0' and (ID_REVISION is null or ID_REVISION = '~')";
    			daf.deleteByWhere(QaFltDO.class, strSql);
    		}
    	}
		
		IQceventRService qceventService=ServiceFinder.find(IQceventRService.class);
		IAutoitmRService autoService =ServiceFinder.find(IAutoitmRService.class);
		StringBuilder sb = new StringBuilder();
		sb.append("select bqaic.Fg_loop,bqaic.Hours_dead,bqaic.Id_mr_types,bqaic.Event_type_code,bqaic.Id_mrtp_change,bqaic.Id_qa_itm,bqaic.Req,bd_mrtp.name as Mr_types_name,ci_qa_itm.sd_qa as sd_mr_op_type  ");
		sb.append("from bd_qa_auto_itm_config bqaic left join ci_qa_itm on bqaic.id_qa_itm = ci_qa_itm.id_qa_itm left join bd_mrtp on bqaic.id_mr_types = bd_mrtp.id_mrtp");
		sb.append(" where ci_qa_itm.FG_AUTO_QA = 'Y' and bqaic.ds = '0' order by bqaic.Createdtime asc");
		List<AutoItmDO> autoItmDOList=(List<AutoItmDO>) daf.execQuery(sb.toString(), new BeanListHandler(AutoItmDO.class));
		if(autoItmDOList == null || autoItmDOList.size() < 0)
    		return;
		AutoItmDO[] autoItmDOArr=null;
		//筛选相应质控类型的质控项
		if(null!=qcTypeCode){
		List<AutoItmDO> autoItmDOListNew=new ArrayList<AutoItmDO>();
		for (AutoItmDO autoItmDO : autoItmDOList) {
			if(autoItmDO.getSd_mr_op_type().contains(qcTypeCode)){
				autoItmDOListNew.add(autoItmDO);
			}
		}
            autoItmDOArr= autoItmDOListNew.toArray(new AutoItmDO[]{});
		}else{
			autoItmDOArr= autoItmDOList.toArray(new AutoItmDO[]{});
		}
    	for (int i = 0; i < autoItmDOArr.length; i++) {
    		QcEventDO eventdo= qceventService.findById(autoItmDOArr[i].getEvent_type_code());
    		try
    		{
    			
        		//文书有无 
    			if(eventdo.getMethod().equals(ICiMrDictCodeConst.ID_MR_AUTOQC_ISHAVEMR)){
    				AutoQcMethodForMOne mOne=new AutoQcMethodForMOne();
    				mOne.exec(id_ent,eventdo, autoItmDOArr[i],isDocAutoQcSelf);
    			}
    			//内容有无
    			if(eventdo.getMethod().equals(ICiMrDictCodeConst.ID_MR_AUTOQC_ISHAVEMRELEMENT)){
    				//AutoQcMethodForMTwo mTwo=new AutoQcMethodForMTwo();
    				AutoQcMethodForMIsHaveRefValue mTwo=new  AutoQcMethodForMIsHaveRefValue();
    				mTwo.exec(id_ent,eventdo, autoItmDOArr[i], isDocAutoQcSelf);
    			}
        		//文书是否存在
        		if(ICiMrDictCodeConst.SD_ISHAVEMR.equals(eventdo.getMethod_code())){
        			AutoQcForIsHaveMrBP autoQcForIsHaveMrBP = new AutoQcForIsHaveMrBP();
        			autoQcForIsHaveMrBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}
        		//文书是否当日存在
        		if(ICiMrDictCodeConst.SD_ISHAVEMRLIMIT.equals(eventdo.getMethod_code())){
        			AutoQcForIsHaveMrLimitDayBP autoQcForIsHaveMrLimitDayBP = new AutoQcForIsHaveMrLimitDayBP();
        			autoQcForIsHaveMrLimitDayBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}
        		//文书存在是否超时（向后）
        		if(ICiMrDictCodeConst.SD_ISHAVEMRAFTER.equals(eventdo.getMethod_code())){
        			AutoQcForIsMrTimeOutAfterBP autoQcForIsMrTimeOutAfterBP = new AutoQcForIsMrTimeOutAfterBP();
        			autoQcForIsMrTimeOutAfterBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}
        		//文书不存在或超时（向后）
        		if(ICiMrDictCodeConst.SD_ISHAVEMRAFTERORNONE.equals(eventdo.getMethod_code())){
        			AutoQcForIsMrTimeOutAfterOrNoneBP autoQcForIsMrTimeOutAfterOrNoneBP = new AutoQcForIsMrTimeOutAfterOrNoneBP();
        			autoQcForIsMrTimeOutAfterOrNoneBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}
        		//文书存在是否超时（向前）
        		if(ICiMrDictCodeConst.SD_ISHAVEMRBEFORE.equals(eventdo.getMethod_code())){
        			AutoQcForIsMrTimeOutBeforeBP autoQcForIsMrTimeOutBeforeBP = new AutoQcForIsMrTimeOutBeforeBP();
        			autoQcForIsMrTimeOutBeforeBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}
        		//文书不存在或超时（向前）
        		if(ICiMrDictCodeConst.SD_ISHAVEMRBEFOREORNONE.equals(eventdo.getMethod_code())){
        			AutoQcForIsMrTimeOutBeforeOrNoneBP autoQcForIsMrTimeOutBeforeOrNoneBP = new AutoQcForIsMrTimeOutBeforeOrNoneBP();
        			autoQcForIsMrTimeOutBeforeOrNoneBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}
        		//区间内是否存在指定份数文书
        		if(ICiMrDictCodeConst.SD_ISHAVETIMESMR.equals(eventdo.getMethod_code())){
        			AutoQcForRegionIsHaveTimesMrBP autoQcForRegionIsHaveTimesMrBP = new AutoQcForRegionIsHaveTimesMrBP();
        			autoQcForRegionIsHaveTimesMrBP.exec(id_ent, eventdo, autoItmDOArr[i], isDocAutoQcSelf);
        		}    			
    		}
    		catch(Exception ex)
    		{
    			throw new BizException("【质控事件注册】中名称为：“"+eventdo.getName()+"”的事件配置错误");
    		}
    		
		}
	}
}
