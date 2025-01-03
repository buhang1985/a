package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.res.bed.d.Bdbed;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.ep.EnTagtpEP;
import iih.en.comm.ep.EntEmpEP;
import iih.en.comm.ep.HpEP;
import iih.en.comm.ep.PsnDocEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegQrySchmDTO;
import iih.en.pv.inpatient.dto.d.IpStatusEnum;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.sc.pub.ScGroupControlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询住院登记信息
 * @author renying
 *
 */
public class GetIpRegListBP {
	
	//未付款
	public static final String LVHOS_NOTPAY = "28b";
	//付款
	public static final String LVHOS_PAY = "28c";
	//全部
	public static final String CONDITION_ALL = "0";
		
	/**
	 * 查询住院登记信息
	 * @param qrySchm 查询模板
	 * @return
	 * @throws BizException
	 * @author renying
	 */
	public PagingRtnData<IpRegInfoDTO> exec(IpRegQrySchmDTO qrySchm, PaginationInfo pageInfo) throws BizException{
		//UpdatePS.update();
		PagingRtnData<IpRegInfoDTO> pageBedDTO = new PagingRtnData<IpRegInfoDTO>();
		PagingServiceImpl<IpRegInfoDTO> service =new PagingServiceImpl();
		SqlParam param = new SqlParam();
		if(qrySchm == null){
			return pageBedDTO;
		}
		String sql = getSql(qrySchm,param);
		pageBedDTO = service.findByPageInfo(new IpRegInfoDTO(), pageInfo, sql, "", param);		
		//1.批量查询年龄
		this.getAge(pageBedDTO);
		//2.批量查询部门
		this.getDepInfo(pageBedDTO);
		//3.批量查询床位
		this.getBedInfo(pageBedDTO);
		//4.批量查询人员
		this.getPsnInfo(pageBedDTO);
		//5.批量查询自定义档案状态
		this.getUdidocInfo(pageBedDTO);
		//6。批量查询医保
		this.getHpInfo(pageBedDTO);
		//7.查询患者标签
		this.getPatEntTagtp(pageBedDTO);
		//8.查询主治医师
		this.getPatEntEmpZZ(pageBedDTO);
		return pageBedDTO;
	}
	
	/**
	 * 查询sql
	 * @param qrySchm
	 * @param param
	 * @return
	 */
	private String getSql(IpRegQrySchmDTO qrySchm,SqlParam param){
		StringBuffer strBuffer = new StringBuffer();		
		strBuffer.append(" 	select pi.id_pat, ");
		strBuffer.append(" ent.id_ent ,");
		strBuffer.append(" pi.id_code,");//
		strBuffer.append(" ent.name_pat,");
		strBuffer.append(" ent.dt_birth_pat Dt_birth,");
		strBuffer.append(" ent.telno_pat,");
		strBuffer.append(" ent.fg_st,");
		strBuffer.append(" ip.code_amr_ip,");
		strBuffer.append(" pi.code code_pat,");
		strBuffer.append(" ent.id_dep_phy ,");
		//strBuffer.append(" di.name_didef_dis name_didef_dis ,");
		strBuffer.append(" itm.id_didef_name name_didef_dis ,");
		strBuffer.append(" hp.no_hp as code_hp,");
		strBuffer.append(" ent.id_dep_nur,");
		strBuffer.append(" ip.id_dep_phyadm,");
		strBuffer.append(" ip.id_dep_nuradm,");
		strBuffer.append(" ip.id_bed,");
		strBuffer.append(" ip.sd_status ,");
		strBuffer.append(" ent.id_emp_entry,");
		strBuffer.append(" ent.id_hp,");
		strBuffer.append(" ent.dt_entry,");
		strBuffer.append(" ent.dt_acpt,");
		strBuffer.append(" ent.dt_end,");
		strBuffer.append(" payip.dt_pay paytime,");
		strBuffer.append(" ent.fg_canc fg_discharge,");
		strBuffer.append(" ent.code code_ent,");
		strBuffer.append(" ent.note,");
		strBuffer.append(" ca.name as name_patca,");//renzhi 添加患者分类 2018年05月30
		strBuffer.append(" scip.id_emp_phy_op,");
		strBuffer.append(" bed.name as name_bed,");
		strBuffer.append(" sex.name as name_sex,");
		strBuffer.append(" (area.fullname || addr.street) as Addar,");
		strBuffer.append(" stdoc.name Name_emp_pay,  ");
		strBuffer.append(" stip.fg_pay, ");
		strBuffer.append(" stip.id_emp_st as id_psn_st, ");
		strBuffer.append(" stip.dt_st, ");
		strBuffer.append(" nvl(scip.name_emp_phy_op,opdoc.name) as name_emp_phy_op,");//0138257-fanlq-add-2018-11-24
		strBuffer.append(" HPCA.NAME_HPPATCA AS NAME_HPPATCA,");//医保计划
		strBuffer.append(" payip.amt");
		strBuffer.append(" from en_ent ent");
		strBuffer.append(" inner join pi_pat pi");
		strBuffer.append(" on ent.id_pat = pi.id_pat");
		strBuffer.append(" inner join en_ent_ip ip");
		strBuffer.append(" on ip.id_ent = ent.id_ent");
		strBuffer.append(" left join en_ent_hp hp");
		strBuffer.append(" on hp.id_ent = ent.id_ent");
		//唯一主诊断-fanlq-2018-10-26
		strBuffer.append(" left join (select c.id_di,c.id_en,row_number() over(partition by c.id_en order by c.dt_sign desc) rn from ci_di c ) di on di.id_en=ent.id_ent and di.rn=1 ");
		strBuffer.append(" left join ci_di_itm itm on itm.id_di = di.id_di and itm.fg_majdi = 'Y'");
		//strBuffer.append(" left join en_ent_di di");
		//strBuffer.append(" on di.id_ent = ent.id_ent");
		//strBuffer.append(" and di.fg_maj ='Y'");
		strBuffer.append(" left join sc_apt_ip scip");
		strBuffer.append(" on scip.id_entip = ip.id_ent");
		strBuffer.append(" left join bd_psndoc opdoc ");
		strBuffer.append(" on opdoc.id_psndoc = ip.id_emp_opapply");
		strBuffer.append(" left join pi_pat_ca ca ");//renzhi 添加患者分类 2018年05月30
		strBuffer.append(" on ca.id_patca = ent.id_patca ");//renzhi 添加患者分类 2018年05月30
		strBuffer.append(" left join bd_bed bed on bed.id_bed = ip.id_bed ");//fanlq
		strBuffer.append(" left join bd_udidoc sex on sex.id_udidoc = pi.id_sex ");//fanlq
		strBuffer.append(" left join pi_pat_addr addr on addr.id_pat = pi.id_pat and addr.sd_addrtp = ? ");//fanlq
		strBuffer.append(" left join bd_adminarea area on area.id_adminarea = addr.id_admdiv ");//fanlq
		strBuffer.append(" LEFT JOIN EN_ENT_HP ENHP ON ENHP.ID_ENT = ENT.ID_ENT ");
		strBuffer.append(" LEFT JOIN BD_HP_PATCA HPCA ON (HPCA.CODE_HPPATCA = ENHP.CODE_HPPATCA AND HPCA.ID_HP = ENHP.ID_HP) ");
		strBuffer.append(" left join ( select stip.id_ent,stip.fg_pay,  max(stip.dt_st) as dt_st,sum(payip.amt) as amt "
				+ "from  bl_st_ip stip  left join bl_pay_pat_ip payip  on payip.id_stip = stip.id_stip  "
				+ "where   stip.eu_sttp in (?,?)  and stip.fg_canc = ?   "
				+ "and stip.eu_direct = ?  group by stip.id_ent,stip.fg_pay ) "
				+ "payip  on payip.id_ent = ent.id_ent ");
		strBuffer.append(" left join bl_st_ip stip  ");
		strBuffer.append(" on stip.id_ent = ip.id_ent "); 
		strBuffer.append(" and stip.eu_sttp =?"); 
		strBuffer.append(" and stip.fg_canc =?"); 
		strBuffer.append(" and  stip.eu_direct = ?");
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(StTypeEnum.ST_INP);
		param.addParam(StTypeEnum.ST_INP_MIDWAY);
		param.addParam(FBoolean.FALSE);
		param.addParam(BookRtnDirectEnum.CHARGE);
		param.addParam(StTypeEnum.ST_INP);
		param.addParam(FBoolean.FALSE);
		param.addParam(BookRtnDirectEnum.CHARGE);
		strBuffer.append(" left join bl_pay_pat_ip  payip");
		strBuffer.append(" on payip.id_stip = stip.id_stip");

		strBuffer.append(" left join bd_psndoc stdoc");
		strBuffer.append(" on payip.id_emp_pay = stdoc.id_psndoc");
			
		strBuffer.append(" where 1=1 ");
		strBuffer.append(" and " + ScGroupControlUtils.getGroupControlFitler(new PatiVisitDO(), "ent") + " ");
		if(qrySchm.getEnt_ip_status() !=null &&  IpStatusEnum.INHOS.equals(qrySchm.getEnt_ip_status())){
			if (qrySchm.getD_begin()!=null) {
				strBuffer.append("  and ent.dt_entry >=   ?");
				param.addParam(qrySchm.getD_begin());
			}
			if (qrySchm.getD_end()!=null) {
				strBuffer.append(" and ent.dt_entry <= ?");
				param.addParam(qrySchm.getD_end());
			}
		}
			
		if(qrySchm.getEnt_ip_status() !=null &&  IpStatusEnum.LEAVEHOS.equals(qrySchm.getEnt_ip_status())){
			if (qrySchm.getD_begin()!=null) {
				strBuffer.append("  and ent.dt_end>=   ?");
				param.addParam(qrySchm.getD_begin());
			}
			if (qrySchm.getD_end()!=null) {
				strBuffer.append(" and ent.dt_end <= ?");
				param.addParam(qrySchm.getD_end());
			}
		}
		
		if(qrySchm.getEnt_ip_status() !=null &&  IpStatusEnum.PAY.equals(qrySchm.getEnt_ip_status())){
			if (qrySchm.getD_begin()!=null) {
				strBuffer.append("  and payip.dt_pay>=   ?");
				param.addParam(qrySchm.getD_begin());
			}
			if (qrySchm.getD_end()!=null) {
				strBuffer.append(" and payip.dt_pay <= ?");
				param.addParam(qrySchm.getD_end());
			}
		}
		
		
		if (!EnValidator.isEmpty(qrySchm.getId_dep_phyadm())) {
			strBuffer.append(" and ip.id_dep_phyadm =?");
			param.addParam(qrySchm.getId_dep_phyadm());
		}
		if (!EnValidator.isEmpty(qrySchm.getId_dep_nuradm())) {
			strBuffer.append(" and ip.id_dep_nuradm = ?");
			param.addParam(qrySchm.getId_dep_nuradm());
		}
		if (!EnValidator.isEmpty(qrySchm.getId_dep_phy())) {
			strBuffer.append(" and ent.id_dep_phy = ?");
			param.addParam(qrySchm.getId_dep_phy());
		}
		if (!EnValidator.isEmpty(qrySchm.getId_dep_nur())) {
			strBuffer.append(" and ent.id_dep_nur =?");
			param.addParam(qrySchm.getId_dep_nur());
		}
		if (!EnValidator.isEmpty(qrySchm.getName_pat())) {
			strBuffer.append(" and (ent.name_pat like ? ");
			param.addParam("%" + qrySchm.getName_pat() + "%");			
			strBuffer.append("OR PI.PYCODE =  ?) ");
			param.addParam(qrySchm.getName_pat().toUpperCase()+".");
		}
		if (!EnValidator.isEmpty(qrySchm.getCode_pat())) {
			strBuffer.append(" and pi.code =?");
			param.addParam(qrySchm.getCode_pat());
		}
		if (!EnValidator.isEmpty(qrySchm.getId_emp_entry())) {
			strBuffer.append(" and ent.id_emp_entry =?");
			param.addParam(qrySchm.getId_emp_entry());
		}//renzhi 2018年5月29日 添加 患者身份查询条件
		if (!EnValidator.isEmpty(qrySchm.getId_patca())) {
            strBuffer.append(" and ent.id_patca =?");
            param.addParam(qrySchm.getId_patca());
        }
		//医保身份查询
		if (!EnValidator.isEmpty(qrySchm.getId_hppatca())) {
            strBuffer.append(" and hpca.id_hppatca = ? ");
            param.addParam(qrySchm.getId_hppatca());
        }
		//根据住院号查询
		if (!EnValidator.isEmpty(qrySchm.getCode_amr_ip())) {
            strBuffer.append(" and ip.code_amr_ip =?");
            param.addParam(qrySchm.getCode_amr_ip());
        }
		//根据床号查询
		if (!EnValidator.isEmpty(qrySchm.getName_bed())) {
            strBuffer.append(" and bed.name = ? ");
            param.addParam(qrySchm.getName_bed());
        }
		//根据性别查询
		if (!EnValidator.isEmpty(qrySchm.getName_sex())) {
            strBuffer.append(" and sex.name like ? ");
            param.addParam("%"+qrySchm.getName_sex()+"%");
        }
		//支付人员查询
		if(!EnValidator.isEmpty(qrySchm.getId_emp_pay())){
			 strBuffer.append(" and payip.id_emp_pay =? ");
			 param.addParam(qrySchm.getId_emp_pay());
		}
		if(!EnValidator.isEmpty(qrySchm.getAddr())){
			 strBuffer.append(" and (area.fullname like ?  or  addr.street like ?) ");
			 param.addParam("%" +qrySchm.getAddr()+"%");
			 param.addParam("%"+qrySchm.getAddr()+"%");
		}

		if (!EnValidator.isEmpty(qrySchm.getSd_status())&& !qrySchm.getSd_status().equals(this.CONDITION_ALL) ) {
			strBuffer.append(" and ip.sd_status = ?");
			if (qrySchm.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT)) {
				strBuffer.append(" and ent.fg_st = ?");
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
				param.addParam(FBoolean.FALSE);
			} else if(qrySchm.getSd_status().equals(LVHOS_NOTPAY)){
				strBuffer.append("  and stip.fg_pay =?");
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
				param.addParam( FBoolean.FALSE);
			}else if(qrySchm.getSd_status().equals(LVHOS_PAY)){
				strBuffer.append("  and stip.fg_pay =?");
				param.addParam(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT);
				param.addParam( FBoolean.TRUE);
			}else {
				param.addParam(qrySchm.getSd_status());
			}
		}
	 
	 	//是否显示新生儿
		if (FBoolean.TRUE.equals(qrySchm.getFg_shownb())) {
			strBuffer.append(" and ip.fg_newborn = 'Y' ");
		}else{
			strBuffer.append(" and ip.fg_newborn = 'N' ");
		}
		//是否显示患者标签
		if (!EnValidator.isEmpty(qrySchm.getId_tagtp())) {
			strBuffer.append(" and (exists(select patag.id_pat from pi_pat_tag patag inner join bd_tag_tp tagtp on tagtp.id_tagtp = patag.id_pattagtp where patag.id_pat = ent.id_pat and tagtp.fg_active = 'Y' and tagtp.fg_ip = 'Y' and patag.id_pattagtp = '"+qrySchm.getId_tagtp()+"') ");
			strBuffer.append(" or exists(select entag.id_ent from en_ent_tagtp entag inner join bd_tag_tp tagtp on tagtp.id_tagtp = entag.id_tagtp where entag.id_ent = ent.id_ent  and tagtp.fg_active = 'Y' and tagtp.fg_ip = 'Y' and entag.id_tagtp = '"+qrySchm.getId_tagtp()+"'))");
		}
		strBuffer.append(" order by ent.name_pat ");
		return strBuffer.toString();
	}
	
	/**
	 * 查找年龄
	 * @param pageBedDTO
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void getAge( PagingRtnData pageBedDTO ) throws BizException{
		FArrayList list = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(list))
			return;
		/*for(Object obj: list){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			//regdto.setAge(AgeCalcUtil.getAge(regdto.getDt_birth()));
		}*/
		EnAgeCalcUtil.setDoAges((IpRegInfoDTO[])list.toArray(new IpRegInfoDTO[]{}), "Id_ent", "Age");
	}
	/**
	 * 查找部门
	 * @param pageBedDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void getDepInfo( PagingRtnData pageBedDTO) throws BizException{
		FArrayList regInfolist = pageBedDTO.getPageData();
		if(EnValidator.isEmpty(regInfolist))
			return;
		//1.组装成list 批量查询
		List<String> idlist = new ArrayList<String>();
		for(Object obj: regInfolist){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if(!regInfolist.contains(regdto.getId_dep_phy()) && !EnValidator.isEmpty(regdto.getId_dep_phy()))
			idlist.add(regdto.getId_dep_phy());
			if(!regInfolist.contains(regdto.getId_dep_nur())&& !EnValidator.isEmpty(regdto.getId_dep_nur()))
			idlist.add(regdto.getId_dep_nur());
			if(!regInfolist.contains(regdto.getId_dep_phyadm())&& !EnValidator.isEmpty(regdto.getId_dep_phyadm()))
			idlist.add(regdto.getId_dep_phyadm());
			if(!regInfolist.contains(regdto.getId_dep_nuradm())&& !EnValidator.isEmpty(regdto.getId_dep_nuradm()))
			idlist.add(regdto.getId_dep_nuradm());
	
		}
		
		if(EnValidator.isEmpty(idlist))
			return;
		//2.查询结果返回map
		DeptEP ep = new DeptEP();
		Map<String,DeptDO> map= ep.getDeptMap(idlist);
		if(EnValidator.isEmpty(map)){
			return;
		}
		for(Object obj: regInfolist){
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if(map.get(regdto.getId_dep_phy())!=null){
				regdto.setName_dep_phy(map.get(regdto.getId_dep_phy()).getName());
			}
			if(map.get(regdto.getId_dep_nur())!=null){
				regdto.setName_dep_nur(map.get(regdto.getId_dep_nur()).getName());
			}
			if(map.get(regdto.getId_dep_phyadm())!=null){
				regdto.setName_dep_phyadm(map.get(regdto.getId_dep_phyadm()).getName());
			}
			if(map.get(regdto.getId_dep_nuradm())!=null){
				regdto.setName_dep_nuradm(map.get(regdto.getId_dep_nuradm()).getName());
			}
		}
		
	}

	/**
	 * 批量查询床位名称
	 * 
	 * @param pageBedDTO
	 * @throws BizException
	 */
	private void getBedInfo(PagingRtnData pageBedDTO) throws BizException {
		List<String> idlist = new ArrayList<String>();
		FArrayList regInfolist = pageBedDTO.getPageData();
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (!idlist.contains(regdto.getId_bed())&& !EnValidator.isEmpty(regdto.getId_bed()))
				idlist.add(regdto.getId_bed());
		}
		if(EnValidator.isEmpty(idlist))
			return;
		BedEP ep = new BedEP();
		Map<String, Bdbed> map = ep.getBeds(idlist);
		if (EnValidator.isEmpty(map)) {
			return;
		}
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (map.get(regdto.getId_bed()) != null) {
				regdto.setName_bed(map.get(regdto.getId_bed()).getName());
			}
		}

	}
	/**
	 * 批量查询人员数据
	 * @param pageBedDTO
	 * @throws BizException
	 */
	private void getPsnInfo(PagingRtnData pageBedDTO) throws BizException{
		List<String> idlist = new ArrayList<String>();
		FArrayList regInfolist = pageBedDTO.getPageData();
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (!idlist.contains(regdto.getId_emp_entry())&&!EnValidator.isEmpty(regdto.getId_emp_entry()))
				idlist.add(regdto.getId_emp_entry());
			if (!idlist.contains(regdto.getId_psn_st())&&!EnValidator.isEmpty(regdto.getId_psn_st()))
				idlist.add(regdto.getId_psn_st());
		}
		if(EnValidator.isEmpty(idlist))
			return;
		PsnDocEP ep = new PsnDocEP();
		Map<String, PsnDocDO> map = ep.getPsnByIdList(idlist);
		if (EnValidator.isEmpty(map)) {
			return;
		}
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (map.get(regdto.getId_emp_entry()) != null) {
				regdto.setName_emp_entry(map.get(regdto.getId_emp_entry()).getName());
			}
			if (map.get(regdto.getId_psn_st()) != null) {
				regdto.setName_psn_st(map.get(regdto.getId_psn_st()).getName());
			}
		}
	}
	
	/**
	 * 批量查询人员数据
	 * @param pageBedDTO
	 * @throws BizException
	 */
	private void getUdidocInfo(PagingRtnData pageBedDTO) throws BizException{
		List<String> idlist = new ArrayList<String>();
		FArrayList regInfolist = pageBedDTO.getPageData();
	
		UdiDocEP ep = new UdiDocEP();
		Map<String, UdidocDO> map = ep.getUdiDocsByCode(IEnDictCodeTypeConst.SD_STATUS);
		if (EnValidator.isEmpty(map)) {
			return;
		}
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (map.get(regdto.getSd_status()) != null) {
				if (regdto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT)) {
					 if(regdto.getFg_pay()!=null && regdto.getFg_pay().booleanValue()){
						regdto.setName_status("出院结算已付款");
						regdto.setSd_status(this.LVHOS_PAY);
					}
					else if(regdto.getFg_pay()!=null && !regdto.getFg_pay().booleanValue()){
						regdto.setName_status("出院结算未付款");
						regdto.setSd_status(LVHOS_NOTPAY);
					} 
					else {
						regdto.setName_status("出院未结算");
					} 
				} else {
					regdto.setName_status(map.get(regdto.getSd_status()).getName());
				}
							
			}
		}
	}
	
	/**
	 * 批量查询人员数据
	 * @param pageBedDTO
	 * @throws BizException
	 */
	private void getHpInfo(PagingRtnData pageBedDTO) throws BizException{
	
		List<String> idlist = new ArrayList<String>();
		FArrayList regInfolist = pageBedDTO.getPageData();
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (!idlist.contains(regdto.getId_hp())&& !EnValidator.isEmpty(regdto.getId_hp()))
				idlist.add(regdto.getId_hp());
		}
		if(EnValidator.isEmpty(idlist))
			return;
		HpEP ep = new HpEP();
		Map<String, HPDO> map = ep.getHpDOs(idlist);
		if (EnValidator.isEmpty(map)) {
			return;
		}
		for (Object obj : regInfolist) {
			IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
			if (map.get(regdto.getId_hp()) != null) {
				regdto.setName_hp(map.get(regdto.getId_hp()).getName());
			}
		}
	
	}
	
	/**
	 * 查询患者标签,fanlq-2019-05-10
	 * @param pageBedDTO
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	private void getPatEntTagtp(PagingRtnData pageBedDTO) throws BizException{
		
		FArrayList regInfolist = pageBedDTO.getPageData();
		List<String> entList = new ArrayList<String>();
		if(regInfolist != null && regInfolist.size() > 0){
			for (Object obj : regInfolist) {
				IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
				if(!EnValidator.isEmpty(regdto.getId_ent()) && !entList.contains(regdto.getId_ent())){
					entList.add(regdto.getId_ent());
				}
			}
			Map<String, String> tagMap = new EnTagtpEP().getTagTpStr(entList.toArray(new String[0]));
			if(tagMap == null || tagMap.isEmpty()){
				return;
			}
			for(Object obj : regInfolist){
				IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
				String entId = regdto.getId_ent();
			    if(EnValidator.isEmpty(entId)){
			    	continue;
			    }	    
			    if(!EnValidator.isEmpty(tagMap.get(entId)))
			    {
			    	regdto.setName_tagtp(tagMap.get(entId));
			    }
			}
		}
	}

	/**
	 * 查询主治医师,fanlq-2019-05-10
	 * @param pageBedDTO
	 * @throws BizException
	 */
	private void getPatEntEmpZZ(PagingRtnData pageBedDTO) throws BizException{
		EntEmpEP ep = new EntEmpEP();
		FArrayList regInfolist = pageBedDTO.getPageData();
		IPsndocMDORService service = ServiceFinder.find(IPsndocMDORService.class); 
		if(regInfolist != null && regInfolist.size() > 0){
			for (Object obj : regInfolist) {
				IpRegInfoDTO regdto = (IpRegInfoDTO) obj;
				EnPsnDO enPsnDO = ep.getEnEmpByRole(regdto.getId_ent(),IEnDictCodeConst.SD_EMPROLE_ZZDOC);
				if(enPsnDO != null){
					PsnDocDO psn = service.findById(enPsnDO.getId_emp());
					if(psn != null){
						regdto.setName_emp_dire(psn.getName());
					}
				}
			}
		}
	}
	
}
