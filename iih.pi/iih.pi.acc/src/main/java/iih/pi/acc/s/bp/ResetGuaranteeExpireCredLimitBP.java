package iih.pi.acc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import iih.bd.base.utils.SqlUtils;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.en.pv.enfee.d.EntAccActDO;
import iih.en.pv.enfee.i.IEnaccountMDOCudService;
import iih.en.pv.enfee.i.IEnaccountMDORService;
import iih.en.pv.enfee.i.IEntAccActDOCudService;
import iih.en.pv.enfee.i.IEntAccActDORService;
import iih.pi.acc.account.d.PiPatAccActDO;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IAccountMDOCudService;
import iih.pi.acc.account.i.IAccountMDORService;
import iih.pi.acc.account.i.IPiPatAccActDOCudService;
import iih.pi.acc.account.i.IPiPatAccActDORService;
import iih.pi.acc.dto.d.ResetGuaranteeExpireCredLimitDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 重置担保到期信用额度定时任务BP
 * @author yzh
 * @date 2020年4月21日16:54:31
 */
public class ResetGuaranteeExpireCredLimitBP {

	/**
	 * 重置担保到期信用额度定时任务BP
	 * @param map
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException{
		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));
		this.mainTaskProcess();
	}
	
	/**
	 * 主业务处理
	 * @throws BizException
	 */
	private void mainTaskProcess()throws BizException{
		//1. 获取患者信用度数据
		ResetGuaranteeExpireCredLimitDTO[] patAccActInfos = this.getPatAccActInfos();
		//1.1 对数据根据id_acc进行分组
		Map<String,List<BaseDO>> patAccMap = this.extractObjMapFromObjs("Id_acc", patAccActInfos);
		//1.2 患者信用度担保重置
		this.resetPatAccCred(patAccMap);
		//2. 患者留观信用度数据
		ResetGuaranteeExpireCredLimitDTO[] patEmgstayAccActInfos = this.getPatEmgstayAccActInfos();
		//2.1 对数据根据id_acc进行分组
		Map<String,List<BaseDO>> patEmgstayAccMap = this.extractObjMapFromObjs("Id_acc", patEmgstayAccActInfos);
		//2.2  患者留观信用度担保重置
		this.resetPatEmgstayAccCred(patEmgstayAccMap);
		//3. 获取就诊信用度数据
		ResetGuaranteeExpireCredLimitDTO[] entAccActInfos = this.getEntAccActInfos();
		//4.1对数据根据id_acc进行分组
		Map<String,List<BaseDO>> entAccMap = this.extractObjMapFromObjs("Id_acc", entAccActInfos);
		//4.2. 就诊信用度担保重置
		this.resetEntAccCred(entAccMap);
	}
	/**
	 * 获取患者信用额度明细数据
	 * @return
	 * @throws DAException
	 */
	private ResetGuaranteeExpireCredLimitDTO[] getPatAccActInfos() throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select acc.id_patacc as id_acc,");
		sql.append( "acc.cred as acc_cred,");
		sql.append(" act.operate_direct,");
		sql.append(" act.cred as operate_cred,");
		sql.append(" act.id_patacccretact as id_acc_act");
		sql.append(" from pi_pat_acc acc");
		sql.append(" left join pi_pat_acc_act act on acc.id_patacc = act.id_patacc");
		sql.append(" where act.fg_cred_reset = ? and act.dt_guarantee <= ?");
		sql.append(" and act.cred > 0 ");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.FALSE);
		param.addParam(this.getServerDateTime());
		DAFacade dafacade = new DAFacade();
		List<ResetGuaranteeExpireCredLimitDTO> patAccActList = (List<ResetGuaranteeExpireCredLimitDTO>) dafacade.execQuery(sql.toString(), param, new BeanListHandler(ResetGuaranteeExpireCredLimitDTO.class));
		return patAccActList.toArray(new ResetGuaranteeExpireCredLimitDTO[0]);
	}
	
	/**
	 * 获取就诊信用额度明细数据
	 * @return
	 * @throws DAException
	 */
	private ResetGuaranteeExpireCredLimitDTO[] getEntAccActInfos() throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select enacc.id_entacc as id_acc,");
		sql.append(" enacc.amt_cred  as acc_cred,");
		sql.append(" act.newcret   as operate_direct,");
		sql.append(" act.cred      as operate_cred,");
		sql.append(" act.id_entaccact as id_acc_act");
		sql.append(" from en_ent_acc enacc");
		sql.append(" left join en_ent_acc_act act on enacc.id_entacc = act.id_entacc");
		sql.append(" where act.fg_cred_reset = ? and act.dt_guarantee <= ? and enacc.amt_cred > 0");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.FALSE);
		param.addParam(this.getServerDateTime());
		DAFacade dafacade = new DAFacade();
		List<ResetGuaranteeExpireCredLimitDTO> patAccActList = (List<ResetGuaranteeExpireCredLimitDTO>) dafacade.execQuery(sql.toString(), param, new BeanListHandler(ResetGuaranteeExpireCredLimitDTO.class));
		return patAccActList.toArray(new ResetGuaranteeExpireCredLimitDTO[0]);
	}
	
	/**
	 * 获取患者留观信用额度明细数据
	 * @return
	 * @throws DAException
	 */
	private ResetGuaranteeExpireCredLimitDTO[] getPatEmgstayAccActInfos() throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append(" select acc.id_patacc as id_acc,");
		sql.append( "acc.cred_emgstay as acc_cred,");
		sql.append(" act.operate_direct,");
		sql.append(" act.cred_emgstay as operate_cred,");
		sql.append(" act.id_patacccretact as id_acc_act");
		sql.append(" from pi_pat_acc acc");
		sql.append(" left join pi_pat_acc_act act on acc.id_patacc = act.id_patacc");
		sql.append(" where act.fg_cred_reset = ? and act.dt_guarantee <= ? and act.cred_emgstay > 0");
		SqlParam param = new SqlParam();
		param.addParam(FBoolean.FALSE);
		param.addParam(this.getServerDateTime());
		DAFacade dafacade = new DAFacade();
		List<ResetGuaranteeExpireCredLimitDTO> patAccActList = (List<ResetGuaranteeExpireCredLimitDTO>) dafacade.execQuery(sql.toString(), param, new BeanListHandler(ResetGuaranteeExpireCredLimitDTO.class));
		return patAccActList.toArray(new ResetGuaranteeExpireCredLimitDTO[0]);
	}
	/**
	 * 患者信用度重置
	 * @param patAccMap
	 * @throws BizException 
	 */
	private void resetPatAccCred(Map<String,List<BaseDO>> patAccMap) throws BizException{
		Iterator<Entry<String, List<BaseDO>>> iterator = patAccMap.entrySet().iterator();
		List<String> idAccList = new ArrayList<String>();
		List<String> idAccActList = new ArrayList<String>();
		Map<String,FDouble> resultMap = new HashMap<String,FDouble>();
	    while (iterator.hasNext()) {
	    	Entry<String, List<BaseDO>> entry = iterator.next();
	        List<BaseDO> dtoList = entry.getValue();
	        if(ListUtil.isEmpty(dtoList)) continue;
	        String id_acc = entry.getKey();
	        idAccList.add(id_acc);
	        FDouble acc_cred = ((ResetGuaranteeExpireCredLimitDTO) dtoList.get(0)).getAcc_cred();
	        for (BaseDO baseDto : dtoList) {
	        	ResetGuaranteeExpireCredLimitDTO dto = (ResetGuaranteeExpireCredLimitDTO) baseDto;
	        	FDouble acc_cred_temp = new FDouble(dto.getOperate_direct()).multiply(dto.getOperate_cred());
	        	acc_cred = acc_cred.sub(acc_cred_temp);
	        	idAccActList.add(dto.getId_acc_act());
			}
	        resultMap.put(id_acc, acc_cred);
	    }
	    IAccountMDORService iaccountmdorservice = ServiceFinder.find(IAccountMDORService.class);
	    String whereStr = SqlUtils.getInSqlByIds(PiPatAccDO.ID_PATACC, idAccList);
	    PiPatAccDO[] patAccDos = iaccountmdorservice.find(whereStr, null, FBoolean.FALSE);
	    if(ArrayUtil.isEmpty(patAccDos)) return;
	    for (PiPatAccDO piPatAccDO : patAccDos) {
			String id_acc = piPatAccDO.getId_patacc();
			if(resultMap.containsKey(id_acc)){
				//修改患者信用额度
				FDouble acc_cred = resultMap.get(id_acc);
				piPatAccDO.setCred(acc_cred);
				piPatAccDO.setStatus(DOStatus.UPDATED);
			}
		}
	    IAccountMDOCudService iaccountmdocudservice = ServiceFinder.find(IAccountMDOCudService.class);
	    iaccountmdocudservice.save(patAccDos);
	    // Fg_cred_reset 重置标志为Y
	    whereStr = SqlUtils.getInSqlByIds(PiPatAccActDO.ID_PATACCCRETACT, idAccActList);
	    IPiPatAccActDORService ipipataccactdorservice = ServiceFinder.find(IPiPatAccActDORService.class);
	    PiPatAccActDO[] patAccActDos = ipipataccactdorservice.find(whereStr, null, FBoolean.FALSE);
	    for (PiPatAccActDO piPatAccActDO : patAccActDos) {
	    	piPatAccActDO.setFg_cred_reset(FBoolean.TRUE);
	    	piPatAccActDO.setStatus(DOStatus.UPDATED);
		}
	    IPiPatAccActDOCudService ipipataccactdocudservice = ServiceFinder.find(IPiPatAccActDOCudService.class);
	    ipipataccactdocudservice.save(patAccActDos);
	}
	/**
	 * 患者留观信用度重置
	 * @param patEmgstayAccMap
	 * @throws BizException 
	 */
	private void resetPatEmgstayAccCred(Map<String,List<BaseDO>> patEmgstayAccMap) throws BizException{
		Iterator<Entry<String, List<BaseDO>>> iterator = patEmgstayAccMap.entrySet().iterator();
		List<String> idAccList = new ArrayList<String>();
		List<String> idAccActList = new ArrayList<String>();
		Map<String,FDouble> resultMap = new HashMap<String,FDouble>();
	    while (iterator.hasNext()) {
	    	Entry<String, List<BaseDO>> entry = iterator.next();
	        List<BaseDO> dtoList = entry.getValue();
	        if(ListUtil.isEmpty(dtoList)) continue;
	        String id_acc = entry.getKey();
	        idAccList.add(id_acc);
	        FDouble acc_cred = ((ResetGuaranteeExpireCredLimitDTO) dtoList.get(0)).getAcc_cred();
	        for (BaseDO baseDto : dtoList) {
	        	ResetGuaranteeExpireCredLimitDTO dto = (ResetGuaranteeExpireCredLimitDTO) baseDto;
	        	FDouble acc_cred_temp = new FDouble(dto.getOperate_direct()).multiply(dto.getOperate_cred());
	        	acc_cred = acc_cred.sub(acc_cred_temp);
	        	idAccActList.add(dto.getId_acc_act());
			}
	        resultMap.put(id_acc, acc_cred);
	    }
	    IAccountMDORService iaccountmdorservice = ServiceFinder.find(IAccountMDORService.class);
	    String whereStr = SqlUtils.getInSqlByIds(PiPatAccDO.ID_PATACC, idAccList);
	    PiPatAccDO[] patAccDos = iaccountmdorservice.find(whereStr, null, FBoolean.FALSE);
	    if(ArrayUtil.isEmpty(patAccDos)) return;
	    for (PiPatAccDO piPatAccDO : patAccDos) {
			String id_acc = piPatAccDO.getId_patacc();
			if(resultMap.containsKey(id_acc)){
				FDouble acc_cred = resultMap.get(id_acc);
				//修改患者留观信用额度
				piPatAccDO.setCred_emgstay(acc_cred);
				piPatAccDO.setStatus(DOStatus.UPDATED);
			}
		}
	    IAccountMDOCudService iaccountmdocudservice = ServiceFinder.find(IAccountMDOCudService.class);
	    iaccountmdocudservice.save(patAccDos);
	    // Fg_cred_reset 重置标志为Y
	    whereStr = SqlUtils.getInSqlByIds(PiPatAccActDO.ID_PATACCCRETACT, idAccActList);
	    IPiPatAccActDORService ipipataccactdorservice = ServiceFinder.find(IPiPatAccActDORService.class);
	    PiPatAccActDO[] patAccActDos = ipipataccactdorservice.find(whereStr, null, FBoolean.FALSE);
	    for (PiPatAccActDO piPatAccActDO : patAccActDos) {
	    	piPatAccActDO.setFg_cred_reset(FBoolean.TRUE);
	    	piPatAccActDO.setStatus(DOStatus.UPDATED);
		}
	    IPiPatAccActDOCudService ipipataccactdocudservice = ServiceFinder.find(IPiPatAccActDOCudService.class);
	    ipipataccactdocudservice.save(patAccActDos);
	}
	/**
	 * 就诊信用度重置
	 * @param EntAccMap
	 * @throws BizException 
	 */
	private void resetEntAccCred(Map<String,List<BaseDO>> EntAccMap) throws BizException{
		Iterator<Entry<String, List<BaseDO>>> iterator = EntAccMap.entrySet().iterator();
		List<String> idAccList = new ArrayList<String>();
		List<String> idAccActList = new ArrayList<String>();
		Map<String,FDouble> resultMap = new HashMap<String,FDouble>();
	    while (iterator.hasNext()) {
	    	Entry<String, List<BaseDO>> entry = iterator.next();
	        List<BaseDO> dtoList = entry.getValue();
	        if(ListUtil.isEmpty(dtoList)) continue;
	        String id_acc = entry.getKey();
	        idAccList.add(id_acc);
	        FDouble acc_cred = ((ResetGuaranteeExpireCredLimitDTO) dtoList.get(0)).getAcc_cred();
	        for (BaseDO baseDto : dtoList) {
	        	ResetGuaranteeExpireCredLimitDTO dto = (ResetGuaranteeExpireCredLimitDTO) baseDto;
	        	FDouble acc_cred_temp = new FDouble(dto.getOperate_direct()).multiply(dto.getOperate_cred());
	        	acc_cred = acc_cred.sub(acc_cred_temp);
	        	idAccActList.add(dto.getId_acc_act());
			}
	        resultMap.put(id_acc, acc_cred);
	    }
	    IEnaccountMDORService ienaccountmdorservice = ServiceFinder.find(IEnaccountMDORService.class);
	    String whereStr = SqlUtils.getInSqlByIds(EnAccountDO.ID_ENTACC, idAccList);
	    EnAccountDO[] entAccDos = ienaccountmdorservice.find(whereStr, null, FBoolean.FALSE);
	    if(ArrayUtil.isEmpty(entAccDos)) return;
	    for (EnAccountDO entAccDO : entAccDos) {
			String id_acc = entAccDO.getId_entacc();
			if(resultMap.containsKey(id_acc)){
				FDouble acc_cred = resultMap.get(id_acc);
				//修改患者就诊信用额度
				entAccDO.setAmt_cred(acc_cred);
				entAccDO.setStatus(DOStatus.UPDATED);
			}
		}
	    IEnaccountMDOCudService ienaccountmdocudservice = ServiceFinder.find(IEnaccountMDOCudService.class);
	    ienaccountmdocudservice.save(entAccDos);
	    // Fg_cred_reset 重置标志为Y
	    whereStr = SqlUtils.getInSqlByIds(EntAccActDO.ID_ENTACCACT, idAccActList);
	    IEntAccActDORService ientaccactdorservice = ServiceFinder.find(IEntAccActDORService.class);
	    EntAccActDO[] entAccActDos = ientaccactdorservice.find(whereStr, null, FBoolean.FALSE);
	    for (EntAccActDO entAccActDO : entAccActDos) {
	    	entAccActDO.setFg_cred_reset(FBoolean.TRUE);
	    	entAccActDO.setStatus(DOStatus.UPDATED);
		}
	    IEntAccActDOCudService ientaccactdocudservice = ServiceFinder.find(IEntAccActDOCudService.class);
	    ientaccactdocudservice.save(entAccActDos);
	}
	
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	private FDateTime getServerDateTime() {
		TimeService ts = ServiceFinder.find(TimeService.class);
		return ts.getUFDateTime();
	}
	
	/**
	 * 用以将数组中的数据根据一个key值分组
	 * @param keyFieldName
	 * @param valFieldName
	 * @param objs
	 * @author yzh
	 * @return
	 */
	private Map<String,List<BaseDO>> extractObjMapFromObjs(String keyFieldName,BaseDO[] objs){
		Map<String,List<BaseDO>> resultMap = new HashMap<String,List<BaseDO>>();
		for (BaseDO obj : objs) {
			if (resultMap.containsKey((String)obj.getAttrVal(keyFieldName))) {
				resultMap.get((String)obj.getAttrVal(keyFieldName)).add(obj);
			}else{
				List<BaseDO> list = new ArrayList<BaseDO>();
				list.add(obj);
				resultMap.put((String)obj.getAttrVal(keyFieldName), list);
			}
		}
		return resultMap;
	}
}
