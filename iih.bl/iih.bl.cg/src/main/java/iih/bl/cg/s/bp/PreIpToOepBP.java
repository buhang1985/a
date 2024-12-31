package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.dto.accsrvrelat.d.AccSrvRelatDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.external.provide.IBdPpBlQryService;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import iih.bl.cg.blcgipprelogdo.d.BlCgIppreLogDO;
import iih.bl.cg.blcgipprelogdo.i.IBlcgipprelogdoCudService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.dto.d.BlPreIpParamDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预住院转门诊
 * @author hanjq
 *
 */
public class PreIpToOepBP {
	/**
	 * 参数：BLCG0037
		参数名：预住院终止时，预住院费用结算模式
		参数描述：
		1：转门诊费用，按门诊结算；
		2：按原数据，进行住院结算；
		3：将费用转为自费，按住院自费结算
	 */
	private final Integer BLCG0037;
	
	/**
	 * 参数：BLCG0038
		参数名：预住院费用转门诊费用，记账时间设置
		参数描述：
		1：记账时间为当前时间；
		2：记账时间为原始时间
	 */
	private final Integer BlCG0038;
	
	private final String Note;
	
	private final String Id_emp_oper;
	
	private final IBlcgoepCudService cgOepCudService;
	private final IBlcgipprelogdoCudService logService;
	private final IBlcgqueryCudService cgIpService;
	
	private Map<String,IncCaItmRelDO> incMap ;
	private Map<String,AccSrvRelatDTO> relMap;
	
	private List<BlCgIpDO> newRedCgIps;
	public PreIpToOepBP(){
		BLCG0037 = BlParams.BLCG0037();
		BlCG0038 = BlParams.BLCG0038();
		Note = "预住院转门诊费用";
		cgOepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		logService = ServiceFinder.find(IBlcgipprelogdoCudService.class);
		cgIpService = ServiceFinder.find(IBlcgqueryCudService.class);
		Id_emp_oper = Context.get().getUserId();
		
		incMap = new HashMap<>();
		relMap = new HashMap<>();
		newRedCgIps = new ArrayList<>();
	}

	public FBoolean exec(BlPreIpParamDTO blPreIpParamDto) throws BizException {
		FDateTime dt_end = blPreIpParamDto.getDt_e();
		boolean hasData = preIpToOepPar(blPreIpParamDto,dt_end);//转有父子记录
		boolean hasData2 = preIpToOepItm(blPreIpParamDto,dt_end);//转剩余记录
		if(newRedCgIps != null && newRedCgIps.size() > 0){
			cgIpService.save(newRedCgIps.toArray(new BlCgIpDO[0]));
		}
		//return cgOep == null ? FBoolean.FALSE : FBoolean.TRUE;
		return hasData || hasData2 ? FBoolean.TRUE : FBoolean.FALSE;
	}
	
	/**
	 * 预住院转门诊明细-有父子关系
	 * @param blPreIpParamDto
	 * @param dt_end
	 * @return
	 * @throws BizException 
	 */
	private boolean preIpToOepPar(BlPreIpParamDTO blPreIpParamDto, FDateTime dt_end) throws BizException {
		
		boolean hasData =  false;
		while(true){
			List<BlCgIpDO> parList = this.getCgDos(blPreIpParamDto, 50, FBoolean.TRUE,null);
			if(parList == null || parList.size() == 0){
				break;
			}
			hasData = true;
			this.SetIncAndRelMap(parList);
			for(int i = 0 , size = parList.size() ; i < size ; i++){
				BlCgIpDO cgIp = parList.get(i);
				//1.转入门诊-父
				BlCgItmOepDO itm = this.preIpToOepItm(cgIp, null, dt_end);
				//2.保存日志-父
				this.saveLog(cgIp, itm);
				
				//3.移除子-确保子全部转入门诊
				List<BlCgIpDO> list = getCgDos(blPreIpParamDto, 500, FBoolean.FALSE, cgIp.getId_cgip());
				while((list != null && list.size() > 0)){
					this.preIpListToOepItms(list, dt_end, itm.getId_cgitmoep());
					list = getCgDos(blPreIpParamDto, 500, FBoolean.FALSE, cgIp.getId_cgip());					
				}				
				//3.红冲预住院-父
				this.toRedPreIp(cgIp);
			}
		}
		
		return hasData;
	}
	
	/**
	 * 预住院转门诊明细-无父子关系
	 * @param cgOep 
	 * @param list
	 * @param dt_end 
	 * @return 
	 * @throws BizException 
	 */
	private boolean preIpToOepItm(BlPreIpParamDTO blPreIpParamDto, FDateTime dt_end) throws BizException {
		
		boolean hasData =  false;
		
		while(true){
			List<BlCgIpDO> list = getCgDos(blPreIpParamDto, 500, null,null);
			if(list == null || list.size() == 0){
				break;
			}
			hasData = true;
			this.SetIncAndRelMap(list);
			preIpListToOepItms(list, dt_end, null);
		}
		
		return hasData;
	}
	
	/**
	 * 转list到门诊
	 * @param list
	 * @param cgOep
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	private void preIpListToOepItms(List<BlCgIpDO> list, FDateTime dt_end,String idPar) throws BizException{
		
		for(BlCgIpDO cgIp : list){
			//1.转入门诊
			BlCgItmOepDO itm = this.preIpToOepItm(cgIp, idPar, dt_end);
			//2.保存日志
			this.saveLog(cgIp, itm);
			//3.红冲预住院
			this.toRedPreIp(cgIp);
		}
	}
	
	/**
	 * 红冲预住院
	 * @param cgIp
	 * @throws BizException 
	 */
	private void toRedPreIp(BlCgIpDO cgIp) throws BizException {
		BlCgIpDO newCg = (BlCgIpDO) cgIp.clone();
		FDouble quanRet = newCg.getQuan_ret() == null ? FDouble.ZERO_DBL : newCg.getQuan_ret();
		FDouble quan = newCg.getQuan().sub(quanRet);
		if(FBoolean.FALSE.equals(newCg.getFg_refund()) && newCg.getEu_direct() == 1 && quan.doubleValue() > 0){
			newCg.setId_cgip(null);
			newCg.setStatus(DOStatus.NEW);
			newCg.setId_par(cgIp.getId_cgip());
			newCg.setEu_direct(newCg.getEu_direct() * -1);
			newCg.setFg_real(FBoolean.FALSE);
			newCg.setQuan(quan);
			newCg.setQuan_ret(FDouble.ZERO_DBL);
			newRedCgIps.add(newCg);
//			cgIpService.save(new BlCgIpDO[]{newCg});
			
			cgIp.setQuan_ret(cgIp.getQuan());
			cgIp.setFg_refund(FBoolean.TRUE);
			cgIp.setFg_real(FBoolean.TRUE);
			cgIp.setStatus(DOStatus.UPDATED);
			cgIpService.update(new BlCgIpDO[]{cgIp});
		}
		
		
	}

	/**
	 * 保存日志
	 * @param cgIp
	 * @param itm
	 * @throws BizException
	 */
	private void saveLog(BlCgIpDO cgIp,BlCgItmOepDO itm) throws BizException{
		BlCgIppreLogDO log = new BlCgIppreLogDO();
		log.setId_cgip_pre(cgIp.getId_cgip());
		if(1 == BLCG0037){
			log.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			log.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		}else{
			log.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			log.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		}
		log.setId_cgip_new(itm.getId_cgitmoep());
		log.setId_emp_oper(Id_emp_oper);
		log.setNote(Note);
		log.setStatus(DOStatus.NEW);
		logService.save(new BlCgIppreLogDO[]{log});
	}
	
	/**
	 * 预住院转门诊明细
	 * @param cgIp
	 * @param Id_cgoep
	 * @param idPar
	 * @param dt_cg
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepDO preIpToOepItm(BlCgIpDO cgIp,String idPar,FDateTime dt_cg) throws BizException{
		BlCgItmOepDO itm = new BlCgItmOepDO();
		String[] itmNames = itm.getAttrNames();
		List<String> ipNames = Arrays.asList(cgIp.getAttrNames());
		for(String name : itmNames){
			if(ipNames.contains(name)){
				itm.setAttrVal(name, cgIp.getAttrVal(name));
			}
		}
		itm.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE);
		itm.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		itm.setId_par(idPar);
		if(1 == BlCG0038){
			itm.setDt_cg(dt_cg);
			itm.setDt_srv(dt_cg);
		}
		itm.setNote(Note);
		itm.setStatus(DOStatus.NEW);
		
//		if(IBdPpCodeTypeConst.SD_OUTREGISTER_INVIOCE.equals(regInccaCode) && 
//				FeeOriginEnum.ENCOUNTER_FEE.equals(itm.getEu_srctp())){
//			IncCaItmRelDO incRelDO = incRegMap.get(itm.getId_srv());
//			if(incRelDO != null){
//				itm.setCode_inccaitm(incRelDO.getInccaitm_code());
//				itm.setName_inccaitm(incRelDO.getInccaitm_name());
//			}
//		}else{
//			
//		}
		IncCaItmRelDO incRelDO = incMap.get(itm.getId_srv());
		if(incRelDO != null){
			itm.setCode_inccaitm(incRelDO.getInccaitm_code());
			itm.setName_inccaitm(incRelDO.getInccaitm_name());
		}
		
		AccSrvRelatDTO accRelDto = relMap.get(itm.getId_srv());
		if(accRelDto != null){
			itm.setCode_account(accRelDto.getCode_acc());
			itm.setName_account(accRelDto.getName_acc());
		}
		
		BlCgOepDO cgOepDO = this.preIpToOep(cgIp, dt_cg);
		BlcgoepAggDO aggDO = new BlcgoepAggDO();
		aggDO.setParentDO(cgOepDO);
		aggDO.setBlCgItmOepDO(new BlCgItmOepDO[]{itm});
		
		aggDO = cgOepCudService.save(new BlcgoepAggDO[]{aggDO})[0];
		
		return aggDO.getBlCgItmOepDO()[0];		
	}
	
	/**
	 * 预住院转门诊-主表
	 * @param list
	 * @throws BizException 
	 */
	private BlCgOepDO preIpToOep(BlCgIpDO cgIp,FDateTime dt_cg) throws BizException {
		
		BlCgOepDO cgOep = new BlCgOepDO();
		cgOep.setId_grp(cgIp.getId_grp());
		cgOep.setId_org(cgIp.getId_org());
		cgOep.setId_org_cg(cgIp.getId_org_cg());
		cgOep.setId_pat(cgIp.getId_pat());
		cgOep.setId_dep_cg(cgIp.getId_dep_cg());
		cgOep.setId_emp_cg(cgIp.getId_emp_cg());
		cgOep.setCode_cg(cgIp.getCode_cg());
		cgOep.setEu_direct(cgIp.getEu_direct());
		if(2 == BlCG0038){
			cgOep.setDt_cg(cgIp.getDt_cg());
		}else{
			cgOep.setDt_cg(dt_cg);
		}
		
//		cgOep.setEnt_invoiceno(cgIp.get);
//		cgOep.setHas_saveindb(FBoolean.TRUE);
//		cgOep.setSt_first_incno(St_first_incno);
//		cgOep.setEnt_invoice_empname(Ent_invoice_empname);
//		cgOep.setEnt_invoice_pkgcode(Ent_invoice_pkgcode);
//		cgOep.setStoep_invoicename(Stoep_invoicename);
//		cgOep.setStoep_invoiceno(Stoep_invoiceno);
		
		cgOep.setStatus(DOStatus.NEW);
		
		return cgOep;		
	}

	/**
	 * 获取待转入集合
	 * @param blPreIpParamDto
	 * @param rowno
	 * @return
	 * @throws DAException
	 */
	private List<BlCgIpDO> getCgDos(BlPreIpParamDTO paramDto,Integer rowno,FBoolean fgPar,String idPar) throws DAException{
		StringBuilder sql = new StringBuilder();
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		this.SetSqlAndParam(sql, paramDto, param, rowno,fgPar,idPar);
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> list = (List<BlCgIpDO>) daf.execQuery(sql.toString(), param, new BeanListHandler(BlCgIpDO.class));
		return list;
	}
	
	/**
	 * 设置sql和param
	 * @param paramDto
	 * @param param
	 */
	private void SetSqlAndParam(StringBuilder sql,BlPreIpParamDTO paramDto,SqlParam param,Integer rowno ,FBoolean fgPar,String idPar){
		sql.append("select * from (");
		sql.append("select	");
		sql.append("	rownum row_no, cg.*							");
		sql.append("from bl_cg_ip cg	");

		sql.append("left join ci_order cor on cor.id_or = cg.id_or			");
		sql.append("where cg.code_enttp = ?	");
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		sql.append("and cg.id_ent = ?	");
		param.addParam(paramDto.getId_ent());		
		sql.append("and not EXISTS(SELECT plg.id_cgip_pre FROM bl_cg_ippre_log plg where plg.id_cgip_pre = cg.id_cgip)	");
		//sql.append("and not EXISTS(SELECT plg.id_cgip_pre FROM bl_cg_ippre_log plg where plg.id_cgip_pre = cg.id_par)	");
		//查询父
		if(FBoolean.TRUE.equals(fgPar)){
			sql.append("and EXISTS(select 1 from bl_cg_ip cgip2 where cgip2.id_par = cg.id_cgip ) ");
		}
		sql.append("and cg.fg_real = 'Y'	");
		sql.append("and cg.fg_refund = 'N'	");
		//查询子
		if(FBoolean.FALSE.equals(fgPar)){
			sql.append("and cg.id_par= ?	");
			param.addParam(idPar);
		}
		if(paramDto.getDt_e() != null){
			sql.append("and cg.dt_cg <= ?	");
			param.addParam(paramDto.getDt_e());
		}
		//排序父-
		if(FBoolean.TRUE.equals(fgPar)){
			sql.append(" order by cg.id_cgip	");
		}
		//排序子
		if(FBoolean.FALSE.equals(fgPar)){
			sql.append(" order by cg.id_par	");
		}
		sql.append(" )  ");
		if(rowno != null){
			sql.append(" where row_no < ? ");
			param.addParam(rowno);
		}
		
	}
	
	/**
	 * 设置张单项和核算关系
	 * @param cgIpList
	 * @throws BizException
	 */
	private void SetIncAndRelMap(List<BlCgIpDO> cgIpList) throws BizException{
		List<String> incSrvIdList = new ArrayList<String>();//有账单信息则不再获取
		List<String> accSrvIdList = new ArrayList<String>();//有核算信息则不再获取
		for (BlCgIpDO itm : cgIpList) {
			if(!this.incMap.containsKey(itm.getId_srv()) && !incSrvIdList.contains(itm.getId_srv())){
				incSrvIdList.add(itm.getId_srv());
			}
			
			if(!this.relMap.containsKey(itm.getId_srv()) && !accSrvIdList.contains(itm.getId_srv())){
				accSrvIdList.add(itm.getId_srv());
			}
		}
		
		//取得账单关系
		if(incSrvIdList.size() > 0){
			Map<String,IncCaItmRelDO> incMapTmp = this.getIncItmRelat(incSrvIdList.toArray(new String[0]),IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
			this.incMap.putAll(incMapTmp);
		}
		//取得核算关系
		if(accSrvIdList.size() > 0){
			Map<String,AccSrvRelatDTO> relMapTmp = this.getAcSrvRelat(accSrvIdList.toArray(new String[0]));
			this.relMap.putAll(relMapTmp);
		}
		
	}
	
	

	/**
	 * 取得核算关系
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private Map<String,AccSrvRelatDTO> getAcSrvRelat(String[] srvIds) throws BizException {
		
		Map<String,AccSrvRelatDTO> map = new HashMap<String,AccSrvRelatDTO>();
		if(ArrayUtil.isEmpty(srvIds))
			return map;
		
		IBdPpQryService ppQryService = ServiceFinder.find(IBdPpQryService.class);
		AccSrvRelatDTO[] relDtos = ppQryService.getAccSrvRelat(srvIds, IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		if(ArrayUtil.isEmpty(relDtos)){
			return map;
		}
		
		for (AccSrvRelatDTO dto : relDtos) {
			map.put(dto.getId_srv(), dto);
		}
		
		return map;
	}
	
	/**
	 * 获取票据分类对照
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private Map<String, IncCaItmRelDO> getIncItmRelat(String[] srvIds,String inccaCode) throws BizException {
		
		Map<String,IncCaItmRelDO> map = new HashMap<String,IncCaItmRelDO>();
		if(ArrayUtil.isEmpty(srvIds))
			return map;
		
		IBdPpBlQryService rService = ServiceFinder.find(IBdPpBlQryService.class);
		IncCaItmRelDO[] dos = rService.findCaItmRelBySrv(inccaCode, srvIds);
	
		if(ArrayUtil.isEmpty(dos)){
			return map;
		}
		
		for (IncCaItmRelDO itmDO : dos) {
			map.put(itmDO.getId_srv(), itmDO);
		}
		
		return map;
	}


}
