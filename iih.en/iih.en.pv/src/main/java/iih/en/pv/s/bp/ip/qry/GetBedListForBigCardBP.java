package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.i.IBedMDORService;
import iih.bl.et.etaccountdto.d.ETAccountDTO;
import iih.bl.pay.i.IBlPayOutQryService;
import iih.en.comm.IEnConst;
import iih.en.comm.ep.EnTagtpEP;
import iih.en.comm.ep.EntStateEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enclin.d.EntStateDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.inpatient.dto.d.BedBigCardDTO;
import iih.en.pv.inpatient.dto.d.BedQryModDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.ip.GetBalanceBP;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDORService;

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

/**
 * 床位查询BP
 * @author renying
 *
 */
public class GetBedListForBigCardBP {
	public GetBedListForBigCardBP(){}
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
		this.setEmgStayAcc(inpatientList);
		Bdbed[] bdBed = this.getBedInNur(qryMod);
		inpatientList = this.getAllbigCardDtoList(inpatientList, bdBed,qryMod);
		if (EnValidator.isEmpty(inpatientList))
			return null;
	
		this.setAge(inpatientList);
		this.setPatPag(inpatientList);//设置患者标签
		this.handleAllergy(inpatientList);//设置过敏史信息
		
		return inpatientList.toArray(new BedBigCardDTO[]{});  
	}
	
	/****
	 * 设置患者标签
	 * @param list
	 * @throws BizException
	 */
	private void setPatPag(List<BedBigCardDTO> list) throws BizException {
		if(EnValidator.isEmpty(list)){
			return;
		}
		new EnTagtpEP().essemly(list.toArray(new BedBigCardDTO[0]), "Id_ent", "Code_pat_pag", "Name_pat_pag");
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
		strb.append(" where ent.Id_dep_nur  =  ? ");
		strb.append("   and ent.fg_canc ='N' "); // and
															// isnull(ent.fg_ip,'Y')='Y'
		SqlParam parm = new SqlParam();
		parm.addParam(qryMod.getId_loginuser());
		parm.addParam(qryMod.getId_dep_nur());
		strb.append("   and ip.sd_status in ('22','25')");
		if(qryMod.getCode_entp() != null){
			strb.append(" and ent.code_entp = ? ");
			parm.addParam(qryMod.getCode_entp());
		}else{
			strb.append(" and ent.code_entp in (?,?) ");
			parm.addParam(IEnDictCodeConst.SD_ENTP_INPATIENT);
			parm.addParam(IEnDictCodeConst.SD_ENTP_IPPRE);
		}
		strb.append(" order by name_pat ");
		@SuppressWarnings("unchecked")
		List<BedBigCardDTO> reList = (List<BedBigCardDTO>) new DAFacade()
				.execQuery(strb.toString(), parm, new BeanListHandler(
						BedBigCardDTO.class));
		if (EnValidator.isEmpty(reList))
			return null;
		return reList;
	}
	
	
	private void getBedInfo(List<BedBigCardDTO> list) throws BizException{
		if(EnValidator.isEmpty(list))
			return ;
		
		//查询产科业务线科室
		List<DeptDO> deptDOs = this.getNbDepl();
		if (!EnValidator.isEmpty(deptDOs)) {
			Map<String, DeptDO> map = new HashMap<>();
			for(DeptDO deptDO : deptDOs){
				if (!EnValidator.isEmpty(deptDO.getId_dep())) {
					map.put(deptDO.getId_dep(), deptDO);
				}
			}
			if (map.size() > 0) {
				for(BedBigCardDTO cardDTO :list)
				{
					//为产科业务线标志赋值
					if (IPiDictCodeConst.SD_SEX_FEMALE.equals(cardDTO.getCode_sex()) && 
						!EnValidator.isEmpty(cardDTO.getId_dep_phy()) && map.containsKey(cardDTO.getId_dep_phy())){
						cardDTO.setFg_nb_depl(FBoolean.TRUE);
					}
				}	
			}
		}
		
		List<String> idList = new ArrayList<String>();
		for(BedBigCardDTO cardDTO :list)
		{
			idList.add(cardDTO.getId_bed());
		}
		//1、查找病区被占用的床位  获得idlist
		IBedMDORService bedService = ServiceFinder.find(IBedMDORService.class);
		//0133056  解决in内数据量大于1000  modified by lilei
		Bdbed[] bdBeds = bedService.findByIds(idList.toArray(new String[0]), FBoolean.FALSE);//本病区入院占用和包床的床位
		Map<String, Bdbed> map = new HashMap<>();
		if(EnValidator.isEmpty(bdBeds)){
			throw new BizException("");
		}else {
			for(Bdbed bdbed : bdBeds){
				if (EnValidator.isEmpty(bdbed.getId_bed()) || map.containsKey(bdbed.getId_bed())) {
					continue;
				}
				map.put(bdbed.getId_bed(), bdbed);
			}
		}
		if (map.size() > 0) {
			for(BedBigCardDTO cardDTO :list)
			{
				if(!EnValidator.isEmpty(cardDTO.getId_bed()) && map.containsKey(cardDTO.getId_bed()))
				{
					cardDTO.setName_bed(map.get(cardDTO.getId_bed()).getName());
					cardDTO.setSd_bedtp(map.get(cardDTO.getId_bed()).getSd_bedtp());//床位类型编码 - zhangpp
					cardDTO.setSd_bedsu(map.get(cardDTO.getId_bed()).getSd_bedsu());
					cardDTO.setFg_apt(map.get(cardDTO.getId_bed()).getFg_appt());
					cardDTO.setId_bltpl(map.get(cardDTO.getId_bed()).getId_bltpl());
					cardDTO.setSd_bedsex(map.get(cardDTO.getId_bed()).getSd_bedsexlimit());
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
         strb.append(" ent.id_emp_nur ,");
         strb.append(" ent.id_ent,");
         strb.append(" ent.code code_ent,");
         strb.append(" ent.dt_birth_pat,");
         strb.append(" ent.sd_sex_pat code_sex,");
         strb.append(" ent.id_sex_pat id_sex_pat,");
         strb.append(" ent.name_pat,");
         strb.append(" ent.id_dep_nur,");
         strb.append(" ent.id_dep_phy,");
         strb.append(" ent.fg_ip,");
         strb.append(" ent.dt_acpt,");
         strb.append(" ent.dt_entry,");//renzhi 护士工作站按入院时间排序 需要
         strb.append(" ent.id_pat,");
         strb.append(" ent.id_emp_phy ,");
         strb.append(" ent.id_emp_nur ,");
         strb.append(" ent.code_hpmedkind ,");
         strb.append(" ip.id_level_dise,");
         strb.append(" ip.id_level_nur,");
         strb.append(" ip.id_level_nutr,");
         strb.append(" ip.id_inpatient,");
         strb.append(" ip.sd_level_dise,");
         strb.append(" ip.sd_level_nur,");
         strb.append(" ip.sd_level_nutr,");
         strb.append(" ip.fg_surg,");
         strb.append(" ip.times_ip,");
         strb.append(" ip.fg_newborn as fg_nb,");
         strb.append(" ent.dt_birth_pat as Dt_birth_bb,");
         strb.append(" ent.sd_mari_pat,");
         strb.append(" ip.code_amr_ip,");
         strb.append(" ip.sd_status ,");
         strb.append(" ip.eu_incp,");
         //strb.append(" pat.photo, ");//患者真实头像-zhangpp 2019.07.05 
         strb.append(" pat.pycode as pycode,");
         strb.append(" pat.code as code_pat,");
         strb.append(" pat.dt_birth_hms as Dt_birth_hms,");
         strb.append(" case ");
         strb.append(" when (ip.sd_status = '22' or (ip.fg_newborn ='Y' and nb.fg_sepa = 'N' ) or ip.fg_blrecall = 'Y') then ");
         strb.append("     ip.id_bed ");
         strb.append(" else entbed.id_bed ");
         strb.append(" end as id_bed ,");
         strb.append(" phy.name name_emp_phy,");
         strb.append(" nur.name name_emp_nur,");
         strb.append(" phydep.name name_dep_phy,");
         strb.append(" nurdep.name name_dep_nur,");
         strb.append(" ca.id_patca,");
         strb.append(" ca.code sd_patca,");
         strb.append(" ca.name name_patca,");
         strb.append(" (area.fullname || addr.street) as Addr_pat,");
         strb.append(" nvl(pat.mob,pat.tel) as phone,");
         strb.append(" enenthp.no_hp,");//医保号
         strb.append(" enenthp.fg_fundpay,");//基金支付标志
         strb.append(" enenthp.fg_hp_card,");//持卡标志
         strb.append(" enenthp.fg_hpspcl,");//特病标志
         strb.append(" hppatca.name_hppatca,");//医保身份
         strb.append(" hpkind.name_hpkind,");//险种名称
         strb.append(" case when flw.id_entflw is not null then 'Y' else 'N' end fg_marked");
         strb.append(" from en_ent ent");
         strb.append(" inner join en_ent_ip ip");
         strb.append("  on ent.id_ent = ip.id_ent");         
         strb.append(" left join en_ent_bed entbed");
         strb.append(" on entbed.id_ent = ip.id_ent");
         strb.append(" and nvl(entbed.dt_e, '~') = '~'");
         strb.append(" left outer join bd_psndoc phy");
         strb.append(" on ent.id_emp_phy = phy.id_psndoc");
         strb.append(" left outer join bd_psndoc nur");
         strb.append(" on ent.id_emp_nur = nur.id_psndoc");
         strb.append(" left outer join bd_dep phydep");
         strb.append("  on ent.id_dep_phy = phydep.id_dep");
         strb.append(" left outer join bd_dep nurdep");
         strb.append(" on ent.id_dep_nur = nurdep.id_dep");         
         strb.append(" left outer join pi_pat pat");
         strb.append(" on pat.id_pat = ent.id_pat");
         strb.append(" left outer join en_ent_flw flw");
         strb.append(" on flw.id_ent = ent.id_ent and flw.id_emp = ?");
         strb.append(" left outer join pi_pat_ca ca");
         strb.append(" on ca.id_patca = ent.id_patca");
         strb.append(" left join pi_pat_addr addr on addr.id_pat = pat.id_pat and addr.sd_addrtp = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' ");
         strb.append(" left join bd_adminarea area on area.id_adminarea = addr.id_admdiv ");
         strb.append(" left join en_ent_hp enenthp on enenthp.id_hp = ent.id_hp and enenthp.id_ent = ent.id_ent ");
         strb.append(" left join bd_hp_patca hppatca on hppatca.id_hp = ent.id_hp and hppatca.code_hppatca = enenthp.code_hppatca ");
         strb.append(" left join bd_hp_kind hpkind on hpkind.id_hp = ent.id_hp and hpkind.code_hpkind = enenthp.code_hpkind ");
         strb.append(" left join en_ent_nb nb on nb.id_ent_bb = ent.id_ent ");
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
		if (EnValidator.isEmpty(map)) {
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
 * @throws BizException 
    */
   private List<BedBigCardDTO> getAllbigCardDtoList(List<BedBigCardDTO> exitBedBigCardDTOList,Bdbed[] allbedArray,BedQryModDTO qryMod) throws BizException
   {
       if (EnValidator.isEmpty(allbedArray))
       {
    	   return exitBedBigCardDTOList;
       }
       if ( EnValidator.isEmpty(exitBedBigCardDTOList))
       {
    	   exitBedBigCardDTOList = new ArrayList<>();
       }
       //判断是否显示虚床
       if (FBoolean.TRUE.equals(qryMod.getFg_showvoid())) {
    	   	for (Bdbed beddo : allbedArray) {
    	   		if (IBdResDictCodeConst.SD_BEDSU_EMPTY.equals(beddo.getSd_bedsu())) {
    	   			BedBigCardDTO cardDTO = new BedBigCardDTO();
    	   			cardDTO.setId_bed(beddo.getId_bed());
    	   			cardDTO.setName_bed(beddo.getName());
    	   			cardDTO.setSd_bedtp(beddo.getSd_bedtp());//床位类型编码 - zhangpp
    	   			cardDTO.setSd_bedsu(beddo.getSd_bedsu());
    	   			cardDTO.setFg_apt(beddo.getFg_appt());
    	   			cardDTO.setId_bltpl(beddo.getId_bltpl());
    	   			cardDTO.setId_dep_nur(beddo.getId_dep_belong());
    	   			cardDTO.setSd_bedsex(beddo.getSd_bedsexlimit());
    	   			exitBedBigCardDTOList.add(cardDTO);
    	   		}
   			}
		}else {
			for (Bdbed beddo : allbedArray) {
				if (IBdResDictCodeConst.SD_BEDSU_EMPTY.equals(beddo.getSd_bedsu()) && 
						!IBdResDictCodeConst.SD_BEDTYPE_VIRTUAL.equals(beddo.getSd_bedtp())) {
					BedBigCardDTO cardDTO = new BedBigCardDTO();
					cardDTO.setId_bed(beddo.getId_bed());
					cardDTO.setName_bed(beddo.getName());
					cardDTO.setSd_bedtp(beddo.getSd_bedtp());//床位类型编码 - zhangpp
					cardDTO.setSd_bedsu(beddo.getSd_bedsu());
					cardDTO.setFg_apt(beddo.getFg_appt());
					cardDTO.setId_bltpl(beddo.getId_bltpl());
					cardDTO.setId_dep_nur(beddo.getId_dep_belong());
					cardDTO.setSd_bedsex(beddo.getSd_bedsexlimit());
					exitBedBigCardDTOList.add(cardDTO);
				}
			}
		}
           return exitBedBigCardDTOList;
       }
   
	/**
	 * 查找年龄
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	private void setAge( List<BedBigCardDTO>  inpatientList ) throws BizException{
		if(EnValidator.isEmpty(inpatientList))
			return;
		/*for(BedBigCardDTO obj: inpatientList){
			//if(obj.getDt_birth_pat()== null)
			//	continue;
			//obj.setAge_pat(AgeCalcUtil.getAge(obj.getDt_birth_pat()));
			if(obj.getDt_birth_hms()== null)
					continue;
			obj.setAge_pat(AgeCalcUtil.getAge(obj.getDt_birth_hms()));
			EnAgeCalcUtil.setDoAges(new BedBigCardDTO[]{obj}, "Id_ent", "Age_pat");
		}*/
		EnAgeCalcUtil.setDoAges(inpatientList.toArray(new BedBigCardDTO[]{}), "Id_ent", "Age_pat");
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
	/**
	 * 处理过敏史
	 * 
	 * @param inpatientList
	 * @throws BizException
	 */
	private void handleAllergy(List<BedBigCardDTO> list) throws BizException{
		if (EnValidator.isEmpty(list))
			return;
		String[] patIds = EnAppUtils.getKeyPropArrayFromDO("Id_pat", list.toArray(new BedBigCardDTO[0]));
		if(EnValidator.isEmpty(patIds))
			return;
		IPiPatAlDORService serv = ServiceFinder.find(IPiPatAlDORService.class);
		PiPatAlDO[] alDos = serv.findByAttrValStrings(PiPatAlDO.ID_PAT, patIds);
		if(EnValidator.isEmpty(alDos))
			return;
		Map<String, List<PiPatAlDO>> map = EnFMapUtils.getMapList(PiPatAlDO.ID_PAT, alDos);
		for(BedBigCardDTO card : list){
			if(!EnValidator.isEmpty(card.getId_pat())
					&& map != null && map.containsKey(card.getId_pat())){
				List<PiPatAlDO> patAls = map.get(card.getId_pat());
				if(EnValidator.isEmpty(patAls))
					continue;
				StringBuilder allergy = new StringBuilder();
				boolean isFirst = true;
				for (PiPatAlDO piPatAlDO : patAls) {
					//String val = !EnValidator.isEmpty(piPatAlDO.getMm_name()) ? piPatAlDO.getMm_name() : piPatAlDO.getName_alcla();
					String val = null;
					if (!EnValidator.isEmpty(piPatAlDO.getMm_name())) {
						val = piPatAlDO.getMm_name();
					}else if (!EnValidator.isEmpty(piPatAlDO.getName_srv())) {
						val = piPatAlDO.getName_srv();
					}else {
						val = piPatAlDO.getName_alcla();
					}
					if(EnValidator.isEmpty(val))
						continue;
					if(!isFirst){
						allergy.append(",");
					}else{
						isFirst = false;
					}
					allergy.append(val);
				}
				card.setAllergyhis(allergy.toString());
			}
		}
	}
	
	/**
	 * 设置留观费用信息,fanlq-2019-06-05
	 * @param list
	 * @throws BizException 
	 */
	private void setEmgStayAcc(List<BedBigCardDTO> list) throws BizException{
		if(EnValidator.isEmpty(list))
			return;
		List<String> idEnts = new ArrayList<String>();
		for(BedBigCardDTO beddto : list){
			if(!EnValidator.isEmpty(beddto.getId_ent()) && !idEnts.contains(beddto.getId_ent())){
				idEnts.add(beddto.getId_ent());
			}
		}
		PatiVisitDO[] patiVisitDOs  = new PvEP().getPVs(idEnts);
		List<PatiVisitDO> patiVisitDOList = new ArrayList<PatiVisitDO>();
		if(patiVisitDOs != null && patiVisitDOs.length > 0){
			for(PatiVisitDO pv : patiVisitDOs){
				if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(pv.getCode_entp())){
					patiVisitDOList.add(pv);
				}
			}
		}
		PatiVisitDO[] emgPvDOs = EnValidator.isEmpty(patiVisitDOList) ? null : patiVisitDOList.toArray(new PatiVisitDO[0]);
		if(emgPvDOs == null || emgPvDOs.length <= 0)
			return;
		IBlPayOutQryService service = ServiceFinder.find(IBlPayOutQryService.class);
		Map<String,ETAccountDTO>  map = service.getETAccountByEnts(emgPvDOs);
		for(BedBigCardDTO bedBigCard : list){
			String entId = bedBigCard.getId_ent();
			if(map != null && map.containsKey(entId)){
				ETAccountDTO etAcc = map.get(entId);
				bedBigCard.setAmt_prepay(etAcc.getAmt_prepay());
				bedBigCard.setAmt_uncg(etAcc.getAcc_lock());
				bedBigCard.setBalance(etAcc.getAmt_bal());
				bedBigCard.setAmt_cred(etAcc.getCred());
			}
		}
	}
}
