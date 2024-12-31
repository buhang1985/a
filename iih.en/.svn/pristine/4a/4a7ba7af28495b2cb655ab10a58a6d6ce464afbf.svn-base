package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleDO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.querule.d.RuleCtrlTp;
import iih.bd.fc.querule.i.IQueRuleItmDORService;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;
import iih.pi.reg.pat.d.PatDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 校验规则
 * @author Sarah
 *
 */
public class IsMatchRuleBP {
	/**
	 * 校验规则
	 * @param patDo
	 * @param schId
	 * @param patcaID
	 * @return
	 * @throws BizException 
	 */
	public ResultDTO exec(PatDO patDo, String schId,String patcaID,String dt_birth,String sexId,String queId) throws BizException{	
		 //1.新建结果DO
		 ResultDTO rstDTO = new ResultDTO();
		 rstDTO.setFlag(FBoolean.TRUE);
		 //2.查询计划对应的规则
		 QueRuleDO querule =null;
		 if(EnValidator.isEmpty(schId)){
			  querule =this.getRuleItmWithOutSch(queId);
		 }else{
		  querule =this.getRuleItm(schId);
		 }
		 if(querule == null ) return rstDTO;   
		 //3.验证是否符合规则
		  this.MatchRule(rstDTO,querule,patDo,schId,patcaID,dt_birth,sexId);
		 return rstDTO;
	}
   
	
	/**
	 * 验证是否符合规则
	 * @param rstDTO
	 * @param ruleItms
	 * @param patDo
	 * @param schId
	 * @param patcaID
	 * @throws BizException 
	 */
	private void MatchRule( ResultDTO rstDTO,QueRuleDO querule,PatDO patDo, String schId,String patcaID,String dt_birth,String id_sex) throws BizException{
		// 1.查询 队列规则明细
		QueRuleItmDO[] ruleItms = ServiceFinder.find(IQueRuleItmDORService.class).find(
				"id_querule ='" + querule.getId_querule() + "'", QueRuleItmDO.CODE,FBoolean.FALSE);
		if (EnValidator.isEmpty(ruleItms))
			return;
		IBdFcQryService service = ServiceFinder.find(IBdFcQryService.class);
		boolean isMatch = false; 
		boolean isALLOWENTRY = true;
		for (QueRuleItmDO ruleItm : ruleItms) {
			PriorityDTO priDTO = new PriorityDTO();			
			priDTO.setId_patca(patcaID);
			if(patDo!=null){
				priDTO.setD_birth(patDo.getDt_birth());
				priDTO.setId_sex(patDo.getId_sex());				
			}
			if(!EnValidator.isEmpty(id_sex)){
				priDTO.setId_sex(id_sex);
			}		
			
			if(!EnValidator.isEmpty(dt_birth)){
				priDTO.setD_birth(new FDate(dt_birth));
			}
			boolean allow= service.IsMatchRulesMatchRule(
					IBdFcDictCodeConst.SD_QUETP_OPRULE, ruleItm, priDTO);
			if(RuleCtrlTp.ALLOWENTRY.equals(ruleItm.getEu_ctrltp())){//允许进入队列	 符合任何一个规则就可以挂号				
				isMatch = isMatch || allow;	
				isALLOWENTRY  =true;
			}			
			if(RuleCtrlTp.FORBIDENTRY.equals(ruleItm.getEu_ctrltp())){//禁止进入队列 ，符合任何一个规则就不能挂号
				isMatch = isMatch || allow;	
				isALLOWENTRY = false;
			}
		
		}	
		if(isALLOWENTRY){//允许进入队列
			if(!isMatch){
				rstDTO.setFlag(FBoolean.FALSE);
				rstDTO.setMsg(querule.getRsn_refuse());
				return;
				}					
		}else{
			if(isMatch){
				rstDTO.setFlag(FBoolean.FALSE);
				rstDTO.setMsg(querule.getRsn_refuse());
				return;
				}		
		}

	
	}
	
	/**
	 * 获取规则DO
	 * @param schId
	 * @return
	 * @throws DAException
	 */
	private QueRuleDO getRuleItm(String schId) throws DAException{
		StringBuilder sb = new StringBuilder();		
		sb.append(" select querule.id_querule, querule.id_grp, querule.id_org, ");
		sb.append(" querule.sd_queruletype, querule.code, querule.name, ");
		sb.append(" querule.quan_wait, querule.id_fun, querule.id_quebentp, querule.sd_quebentp, ");
		sb.append(" querule.wbcode, querule.pycode, querule.mnecode, querule.rsn_refuse, ");
		sb.append(" querule.createdby, querule.createdtime, querule.modifiedby, querule.modifiedtime, querule.ds, querule.sv ");
		sb.append(" from sc_sch sch ");
		sb.append(" inner join sc_pl pl ");
		sb.append(" on pl.id_scpl = sch.id_scpl");
		sb.append(" inner join bd_que_rule querule ");
		sb.append(" on querule.id_querule = pl.id_querule ");
		sb.append(" inner join bd_que_rule_itm itm ");
		sb.append(" on itm.id_querule = querule.id_querule");
		sb.append(" where id_sch =?");
		SqlParam param = new SqlParam();
		param.addParam(schId);
		
		@SuppressWarnings("unchecked")
		List<QueRuleDO> itemList =(List<QueRuleDO>) new DAFacade().execQuery(sb.toString(), 
				param,new BeanListHandler(QueRuleDO.class));	
		if (EnValidator.isEmpty(itemList)) return null ;
		return itemList.get(0);		
	}
	 /**
     * 
     * @param rstDTO
     * @param querule
     * @param patDo
     * @param queId
     * @param patcaID
     * @param dt_birth
     * @param id_sex
     * @throws BizException
     */
	private QueRuleDO getRuleItmWithOutSch(String queId) throws BizException{
		StringBuilder sb = new StringBuilder();		
		sb.append(" select querule.id_querule, querule.id_grp, querule.id_org, ");
		sb.append(" querule.sd_queruletype, querule.code, querule.name, ");
		sb.append(" querule.quan_wait, querule.id_fun, querule.id_quebentp, querule.sd_quebentp, ");
		sb.append(" querule.wbcode, querule.pycode, querule.mnecode, querule.rsn_refuse, ");
		sb.append(" querule.createdby, querule.createdtime, querule.modifiedby, querule.modifiedtime, querule.ds, querule.sv ");
		sb.append(" from  sc_pl  pl ");
		sb.append(" inner join bd_que que ");
		sb.append(" on  pl.id_dep = que.id_dep ");
		sb.append(" and pl.id_scres = que.id_scres");
		sb.append(" and pl.id_scsrv = que.id_scsrv ");
		sb.append(" and pl.id_queben = que.id_queben"); 
		sb.append(" inner join bd_que_rule querule "); 
		sb.append(" on querule.id_querule = pl.id_querule "); 
		sb.append(" inner join bd_que_rule_itm itm "); 
		sb.append(" on itm.id_querule = querule.id_querule"); 
		sb.append(" where que.id_que = ?");
		SqlParam param = new SqlParam();
		param.addParam(queId);
		
		@SuppressWarnings("unchecked")
		List<QueRuleDO> itemList =(List<QueRuleDO>) new DAFacade().execQuery(sb.toString(), 
				param,new BeanListHandler(QueRuleDO.class));	
		if (EnValidator.isEmpty(itemList)) return null ;
		return itemList.get(0);		
	}
	
}
