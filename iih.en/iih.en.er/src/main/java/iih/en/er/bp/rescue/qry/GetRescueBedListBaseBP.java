package iih.en.er.bp.rescue.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDORService;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.s.bp.ip.GetBalanceBP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

public class GetRescueBedListBaseBP {
	/**
	 * 查询床位列表
	 * @param qryMod 查询模板
	 * @return
	 * @throws BizException
	 */
	public BedBigCardDTO[] getBedListForBigCard(BedQryModDTO qryMod) throws BizException{
		//1.查找入院患者信息
		List<BedBigCardDTO> inpatientList = this.getPatientList(qryMod);
		this.setEnstates(inpatientList);
		this.SetUdidocList(inpatientList);
		this.getBedInfo(inpatientList);
		this.setAcc(inpatientList);
		Bdbed[] bdBed = this.getBedInNur(qryMod);
		inpatientList = this.getAllbigCardDtoList(inpatientList, bdBed);
		if (EnValidator.isEmpty(inpatientList))
			return new BedBigCardDTO[]{};
		return inpatientList.toArray(new BedBigCardDTO[]{});  
	}
		
	
	/**
	 * 查找病人列表(已入科)
	 * @param qryMod
	 * @return
	 * @throws BizException
	 */
	private List<BedBigCardDTO> getPatientList(BedQryModDTO qryMod) throws BizException
	{
		StringBuilder strb = this.getSql();
		SqlParam parm = new SqlParam();
		strb.append(" where 1=1 ");
		parm.addParam(qryMod.getId_loginuser());
		if(!EnValidator.isEmpty(qryMod.getId_dep_nur())){
			strb.append(" and ent.Id_dep_nur  =  ? ");
			parm.addParam(qryMod.getId_dep_nur());
		}else if(!EnValidator.isEmpty(qryMod.getId_dep_phy())){
			strb.append(" and ent.Id_dep_phy  =  ? ");
			parm.addParam(qryMod.getId_dep_phy());
		}
		strb.append(" and ent.dt_end is null "); 
		strb.append(" and isnull(ent.fg_canc,'N')='N'"); 
		//strb.append(" and "+EnSqlUtils.getInSqlByIds("ent.code_entp", EnParamUtils.getErTpNoComm())); 
		strb.append(" and ent.code_entp = '"+IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID+"'"); 
		strb.append(" order by bed.name,name_pat ");
		@SuppressWarnings("unchecked")
		List<BedBigCardDTO> reList = (List<BedBigCardDTO>) new DAFacade()
				.execQuery(strb.toString(), parm, new BeanListHandler(
						BedBigCardDTO.class));
		if (EnValidator.isEmpty(reList))
			return new ArrayList<BedBigCardDTO>();
		return reList;
	}
	
	
	private void getBedInfo(List<BedBigCardDTO> list) throws BizException{
		if(EnValidator.isEmpty(list))
			return ;
		List<String> idList = new ArrayList<String>();
		//查询产科业务线科室
		List<DeptDO> deptDOs = this.getNbDepl();
		for(BedBigCardDTO cardDTO :list)
		{
			//为产科业务线标志赋值
			if (!EnValidator.isEmpty(deptDOs)) {
				for (DeptDO deptDO : deptDOs) {
					if (deptDO.getId_dep().equals(cardDTO.getId_dep_phy()) && IPiDictCodeConst.SD_SEX_FEMALE.equals(cardDTO.getCode_sex())) {
						cardDTO.setFg_nb_depl(FBoolean.TRUE);
					}
				}
			}
			idList.add(cardDTO.getId_bed());
		}

		//1、查找病区被占用的床位  获得idlist
		IBedMDORService bedService = ServiceFinder.find(IBedMDORService.class);
		Bdbed[] bdBeds = bedService.findByIds(idList.toArray(new String[0]), FBoolean.FALSE);
		if(EnValidator.isEmpty(bdBeds)){
			throw new BizException("");
		}
		for(BedBigCardDTO cardDTO :list)
		{
			for(Bdbed bdBed :bdBeds ){
				if(bdBed.getId_bed().equals(cardDTO.getId_bed()))
				{
					cardDTO.setName_bed(bdBed.getName());
					cardDTO.setSd_bedsu(bdBed.getSd_bedsu());
					cardDTO.setFg_apt(bdBed.getFg_appt());
					cardDTO.setId_bltpl(bdBed.getId_bltpl());
					cardDTO.setSd_bedsex(bdBed.getSd_bedsexlimit());
				}
			}		
		}
		
	}
	

	/**
	 * 查找就诊状态并赋值
	 * @param list
	 * @throws BizException
	 */
	private void setEnstates( List<BedBigCardDTO> list) throws BizException
	{
		if(EnValidator.isEmpty(list))
			return;
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO("Id_ent", list.toArray(new BedBigCardDTO[0]));
		EntStateEP ep = new EntStateEP();
		Map<String,Map<String, EntStateDO>> map = ep.getEntStateDOMap(entIds, null);
	    if(map == null)
	    	return;
		for(BedBigCardDTO bedBigCard: list){
			String entId = bedBigCard.getId_ent();
		    if(EnValidator.isEmpty(entId)){
		    	continue;
		    }
		    if(map.containsKey(entId) && map.get(entId) != null)
		    {
		    	Map<String, EntStateDO> stateMap = map.get(entId);
		    	bedBigCard.setEnstatelist(EnAppUtils.doArray2List(stateMap.values().toArray(new EntStateDO[0])));
		    }
		}
	}
	
	
	/**
	 * 查询sql 不带查询条件
	 * @return
	 */
	private StringBuilder getSql()
	{
		 StringBuilder strb = new StringBuilder();		
         strb.append(" select  ent.id_emp_phy ,");
         strb.append("state.name name_level_nur, ");
         strb.append(" lev.shortname name_level, ");
         strb.append(" ent.id_emp_nur ,");
         strb.append(" ent.id_ent,");
         strb.append(" ent.dt_birth_pat,");
         strb.append(" ent.sd_sex_pat code_sex,");
         strb.append(" ent.id_sex_pat id_sex_pat,");
         strb.append(" ent.name_pat,");
         strb.append(" ent.id_dep_nur,");
         strb.append(" ent.id_dep_phy,");
         strb.append(" ent.fg_ip,");
         strb.append(" ent.dt_acpt,");
         strb.append(" ent.id_pat,");
         strb.append(" ent.id_emp_phy ,");
         strb.append(" ent.id_emp_nur ,");
         strb.append(" ent.code_hpmedkind ,");
         strb.append(" ent.code_entp ,");
         strb.append(" ent.sd_mari_pat,");
         strb.append(" ent.dt_entry dt_erentry,");
         strb.append(" pat.code_amr_ip,");
         strb.append(" pat.pycode as pycode,");
         strb.append(" pat.code as code_pat,");
         strb.append(" oper.id_bed as id_bed ,");
         strb.append(" phy.name name_emp_phy,");
         strb.append(" nur.name name_emp_nur,");
         strb.append(" phydep.name name_dep_phy,");
         strb.append(" nurdep.name name_dep_nur,");
         strb.append(" ca.id_patca,");
         strb.append(" ca.code sd_patca,");
         strb.append(" ca.name name_patca,");
         strb.append(" bed.id_bed Id_bed,");
         strb.append(" case when flw.id_entflw is not null then 'Y' else 'N' end fg_marked ");
         strb.append(" from en_ent ent");
         strb.append(" inner join en_ent_op op on ent.id_ent = op.id_ent ");
         strb.append(" inner join en_ent_op_er oper on oper.id_ent = ent.id_ent ");
         strb.append(" inner join en_erpre pre on pre.id_ent_last = ent.id_ent ");
         //strb.append(" left join en_ent_bed entbed on entbed.id_ent = ent.id_ent and nvl(entbed.dt_e, '~') = '~'");
         strb.append(" left join bd_bed bed on bed.id_bed = oper.id_bed ");
         strb.append(" left outer join bd_psndoc phy on pre.id_emp_pre = phy.id_psndoc ");
         strb.append(" left outer join bd_psndoc nur on ent.id_emp_nur = nur.id_psndoc ");
         strb.append(" left outer join bd_dep phydep on ent.id_dep_phy = phydep.id_dep");
         strb.append(" left outer join bd_dep nurdep on ent.id_dep_nur = nurdep.id_dep");
         strb.append(" left outer join pi_pat pat on pat.id_pat = ent.id_pat ");
         strb.append(" left outer join en_ent_flw flw on flw.id_ent = ent.id_ent and flw.id_emp = ? ");
         strb.append(" left outer join pi_pat_ca ca on ca.id_patca = ent.id_patca ");
         strb.append(" left join bd_udidoc state on state.id_udidoc = oper.id_level_nur ");
         strb.append(" left join bd_udidoc lev on lev.id_udidoc = oper.id_scale_triage ");
         return strb;
	}
		
	
	
	/**
	 * 设置自定义档案的值
	 * @param bedBigCardDTOs
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void SetUdidocList(List<BedBigCardDTO>  bedBigCardDTOs) throws BizException{
		UdiDocEP docEp = new UdiDocEP();
		FArrayList idlist = new FArrayList();
		idlist.add(IEnDictCodeTypeConst.SD_STATUS_NUR);
		idlist.add(IEnDictCodeTypeConst.SD_STATUS_DISE);
		idlist.add(IEnDictCodeTypeConst.SD_STATUS_NUTR);
		idlist.add(IPiDictCodeTypeConst.SD_SEX_CODE);			
		Map<String, UdidocDO> map = docEp.getUdiDocsByCodes(idlist);
		if (map == null || map.size() <= 0) {
			return;
		}
		if(EnValidator.isEmpty(bedBigCardDTOs))
			return;
		for(BedBigCardDTO bigCardDTO :bedBigCardDTOs ){
			if (map.get(bigCardDTO.getId_level_dise())!= null) {
				bigCardDTO.setName_level_dise(map.get(bigCardDTO.getId_level_dise()).getName());
			}
			if (map.get(bigCardDTO.getId_level_nur())!= null) {
				bigCardDTO.setName_level_nur(map.get(bigCardDTO.getId_level_nur()).getName());
			}
			if (map.get(bigCardDTO.getId_level_nutr())!= null) {
				bigCardDTO.setName_level_nutr(map.get(bigCardDTO.getId_level_nutr()).getName());
			}
			if (map.get(bigCardDTO.getId_sex_pat())!= null) {
				bigCardDTO.setName_sex(map.get(bigCardDTO.getId_sex_pat()).getName());
			}
		}
	}
	
	/**
	 * 查询床位数据
	 * @param qryMod
	 * @throws BizException
	 */
   private  Bdbed[]  getBedInNur(BedQryModDTO qryMod) throws BizException{
	   IBedMDORService bedService = ServiceFinder.find(IBedMDORService.class);
       String wherestr = "id_dep_belong ='" + qryMod.getId_dep_nur() + "' and fg_act ='"+FBoolean.TRUE+"'";
       Bdbed[]  allbedArray = bedService.find(wherestr, "name asc", FBoolean.FALSE);
       return  allbedArray;
   }
   
   /**
    * 得到所有dto的list 大集合(把空床包含进去)(组装卡片需要的DTO)
    * @param exitBedBigCardDTOList
    * @param allbedArray
    * @return
    */
   private List<BedBigCardDTO> getAllbigCardDtoList(List<BedBigCardDTO>  exitBedBigCardDTOList, Bdbed[]  allbedArray )
   {
       if (EnValidator.isEmpty(allbedArray))
       {
    	   return exitBedBigCardDTOList;
       }
       if ( EnValidator.isEmpty(exitBedBigCardDTOList))
       {
    	   exitBedBigCardDTOList = new ArrayList<>();
       }
		for (Bdbed beddo : allbedArray) {
			if (IBdResDictCodeConst.SD_BEDSU_EMPTY.equals(beddo.getSd_bedsu())) {
				BedBigCardDTO cardDTO = new BedBigCardDTO();
				cardDTO.setId_bed(beddo.getId_bed());
				cardDTO.setName_bed(beddo.getName());
				cardDTO.setSd_bedsu(beddo.getSd_bedsu());
				cardDTO.setFg_apt(beddo.getFg_appt());
				cardDTO.setId_bltpl(beddo.getId_bltpl());
				cardDTO.setSd_bedsex(beddo.getSd_bedsexlimit());
				cardDTO.setId_dep_nur(beddo.getId_dep_belong());
				exitBedBigCardDTOList.add(cardDTO);
			}
		}
           return exitBedBigCardDTOList;
       }

	/**
	 * 设置金额信息
	 * 
	 * @param list
	 * @throws BizException
	 */
	private void setAcc(List<BedBigCardDTO> list)throws BizException{
		if(EnValidator.isEmpty(list))
			return;
		Set<String> set = new HashSet<>();
		for(BedBigCardDTO bedBigCard : list)
			set.add(bedBigCard.getId_ent());
		GetBalanceBP balanceBp = new GetBalanceBP();
		Map<String, BalanceDTO> balenceMap = new HashMap<>();
		BalanceDTO[] balences = balanceBp.exec(set.toArray(new String[0]));
		if(!EnValidator.isEmpty(balences)){
			for(BalanceDTO balence : balences)
				balenceMap.put(balence.getId_ent(), balence);
		}
		for(BedBigCardDTO bedBigCard : list){
			String entId = bedBigCard.getId_ent();
			if(balenceMap.containsKey(entId)){
				BalanceDTO balence = balenceMap.get(entId);
				bedBigCard.setAmt_cred(balence.getAmt_cred());
				bedBigCard.setAmt_prepay(balence.getAmt_prepay());
				bedBigCard.setAmt_uncg(balence.getAmt_uncg());
				bedBigCard.setBalance(balence.getAmt_bal());
				bedBigCard.setAmt_hp(balence.getAmt_hp());
			}
		}
	}
	
	/**
	 * 查询产科业务线科室
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<DeptDO> getNbDepl() throws BizException {
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append(" Select b.id_dep");
		sb.append(" from bd_depl a");
		sb.append(" inner join bd_depl_dep b on a.id_depl = b.id_depl");
		sb.append(" where a.sd_deptltp = ?");
		param.addParam(IEnConst.SD_DEPL_NB);
		return (List<DeptDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(DeptDO.class));
	}

}

