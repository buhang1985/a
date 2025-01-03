package iih.en.pv.s.bp.ippre.qry;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.springframework.transaction.TransactionStatus;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.DeptEP;
import iih.en.comm.ep.PsnDocEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.appfw.orm.dataaccess.TmpTableFactory;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获取预住院信息
 * 
 * @author liubin
 *
 */
public abstract class GetIpPreInfoAbstact {
	
	/**
	 * 获取预住院患者信息
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	protected EnIppreInfoDTO[] getIpPreByEntIds(String[] entIds) throws BizException{
		if(ArrayUtil.isEmpty(entIds))
			return null;
		//查询预住院信息
		EnIppreInfoDTO[] enIppreInfos = getInfos(entIds);
		//处理预住院信息
		assemly(enIppreInfos);
		return enIppreInfos;
	}

	/**
	 * 处理预住院信息数据
	 * 
	 * @param enIppreInfos
	 * @throws BizException
	 */
	protected void assemly(EnIppreInfoDTO[] enIppreInfos) throws BizException{
		
		if (!ArrayUtil.isEmptyNoNull(enIppreInfos)) {
			//设置年龄
			for (EnIppreInfoDTO enIppreInfoDTO : enIppreInfos) {
				enIppreInfoDTO.setAge(AgeCalcUtil.getAge(enIppreInfoDTO.getDt_birth()));
			}
			//查询人员信息
			this.getPsnInfo(enIppreInfos);
			//查询部门信息
			this.getDepInfo(enIppreInfos);
		}
	}
	
	/**
	 * 获取排序语句
	 * 
	 * @return
	 */
	protected String getOrderByStr(){
		return "ENT.DT_ACPT";
	}
	
	/**
	 * 查询数据
	 * 
	 * @param tmpTableName
	 * @return
	 * @throws BizException
	 */
	private EnIppreInfoDTO[] query(String tmpTableName) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" select ent.id_ent, ");
		sqlBuilder.append(" ippre.sd_status, ");
		sqlBuilder.append(" decode(ippre.sd_status,'1','入院登记','2','入院准备中心','3','入科','8','出院','9','中止住院') as name_status, ");
		sqlBuilder.append(" ippre.fg_transdep, ");
		sqlBuilder.append(" pat.name as name_pat, ");
		sqlBuilder.append(" pat.id_pat, ");
		sqlBuilder.append(" pat.id_sex, ");
		sqlBuilder.append(" sex.code as sd_sex, ");
		sqlBuilder.append(" sex.name as sex, ");
		sqlBuilder.append(" pat.code as code_pat, ");
		sqlBuilder.append(" pat.dt_birth, ");
		sqlBuilder.append(" ip.times_ip as times_ip, ");//住院次数
		sqlBuilder.append(" area.fullname || addr.street as cur_addr_pat, ");
		sqlBuilder.append(" ip.id_emp_opapply id_emp_opapply, ");//主管医生
		sqlBuilder.append(" emp.id_emp id_emp_nurse, ");//责任护士
		sqlBuilder.append(" ent.id_emp_nur id_emp_nur_last, ");//责任护士最后一次
		sqlBuilder.append(" ent.fg_st, ");//主管医生
		sqlBuilder.append(" ip.id_bed, ");
		sqlBuilder.append(" ip.name_bed, ");
		sqlBuilder.append(" ip.code_amr_ip, ");
		sqlBuilder.append(" ent.dt_entry, ");//入院时间
		sqlBuilder.append(" ent.code_entp, ");//就诊类型
		/*sqlBuilder.append(" ippre.id_dep_phy cur_id_dep_phy, ");
		sqlBuilder.append(" ippre.id_dep_ward cur_id_dep_nur, ");
		sqlBuilder.append(" ent.id_dep_phy id_dep_phy, ");
		sqlBuilder.append(" ent.id_dep_nur id_dep_nur, ");*/
		sqlBuilder.append(" ippre.id_dep_phy id_dep_phy, ");
		sqlBuilder.append(" ippre.id_dep_ward id_dep_nur, ");
		sqlBuilder.append(" ent.id_dep_phy cur_id_dep_phy, ");
		sqlBuilder.append(" ent.id_dep_nur cur_id_dep_nur, ");
		sqlBuilder.append(" ip.id_dep_phyadm id_dep_phyadm, ");
		sqlBuilder.append(" ip.id_dep_nuradm id_dep_nuradm, ");
		sqlBuilder.append(" ent.dt_end as exit_times, ");//出院时间
		sqlBuilder.append(" ent.dt_acpt, ");//入科时间
		sqlBuilder.append(" ent.dt_entry, ");//入院登记时间
		sqlBuilder.append(" ent.id_emp_entry, ");//登记人
		sqlBuilder.append(" ippre.fg_done_mt, ");
		sqlBuilder.append(" ippre.fg_done_anest, ");
		sqlBuilder.append(" ippre.fg_done_dep, ");
		sqlBuilder.append(" ippre.fg_done_bed, ");
		sqlBuilder.append(" ippre.dt_acpt_ippre, ");//预住院时间
		sqlBuilder.append(" ippre.id_emp_acpt as id_emp_ippre, ");//接收预住院人
		sqlBuilder.append(" trans.id_dep_from, ");
		sqlBuilder.append(" trans.id_dep_nur_from, ");
		sqlBuilder.append(" trans.dt_acpt as dt_trans, ");//转科时间
		sqlBuilder.append(" bed.sd_bedsu, ");
		sqlBuilder.append(" ent.telno_pat as tel_nopat, ");
		sqlBuilder.append(" ipkind.name as name_ipkind, ");
		sqlBuilder.append(" nvl(apt.name_didef_op, apt.supplement_di) as name_didef_op ");
		sqlBuilder.append(" from en_ent ent ");
		sqlBuilder.append(" inner join ").append(tmpTableName).append(" temptable on ent.id_ent = temptable.id1 ");
		sqlBuilder.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sqlBuilder.append(" inner join en_ippre ippre on ent.id_ent = ippre.id_ent ");
		sqlBuilder.append(" inner join pi_pat pat on pat.id_pat = ent.id_pat ");
		sqlBuilder.append(" inner join bd_bed bed on bed.id_bed = ip.id_bed ");
		sqlBuilder.append(" left join sc_apt_ip apt on apt.id_entip = ent.id_ent ");
		sqlBuilder.append(" left join bd_udidoc ipkind on ipkind.id_udidoc = apt.id_kind ");
		sqlBuilder.append(" left join en_ent_emp emp on (emp.id_ent = ent.id_ent and  emp.sd_emprole = '20' and nvl(dt_e,'~') = '~')");
		sqlBuilder.append(" left join bd_udidoc sex on sex.id_udidoc = pat.id_sex ");//性别
		sqlBuilder.append(" left join en_dep_trans trans on trans.id_ent = ent.id_ent and trans.fg_ippre = 'Y'");
		sqlBuilder.append(" LEFT JOIN PI_PAT_ADDR ADDR ON ADDR.ID_PAT = PAT.ID_PAT AND ADDR.SD_ADDRTP = '"+IPiDictCodeConst.SD_ADDR_TYPE_NOW+"' " );
		sqlBuilder.append(" LEFT JOIN BD_ADMINAREA AREA ON AREA.ID_ADMINAREA = ADDR.ID_ADMDIV " );
		String orderByStr = getOrderByStr();
		if(EnValidator.isNotEmptyIgnoreBlank(orderByStr))
			sqlBuilder.append(" ORDER BY ").append(orderByStr);
		@SuppressWarnings("unchecked")
		List<EnIppreInfoDTO> list = (List<EnIppreInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(EnIppreInfoDTO.class));
		
		return ListUtil.isEmpty(list) ? null : list.toArray(new EnIppreInfoDTO[list.size()]);
	}
	
	/**
	 * 临时表查询数据
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	private EnIppreInfoDTO[] getInfos(final String[] entIds) throws BizException{
		return TransactionExecutor.executeRequired(new TransactionalOperation<EnIppreInfoDTO[]>() {
			@Override
			public EnIppreInfoDTO[] doInTransaction(TransactionStatus status) {
				String tmpTableName = null;
			    try{
			    	// 生成临时表
				    tmpTableName = new TmpTableFactory().get(entIds);
					// 查询数据
				    return query(tmpTableName);
			    }catch (BizException e) {
					throw new BizRuntimeException(e.getMessage());
				}
			}
		});
	}
	
	/**
	 * 查询人员信息
	 * @param enIppreInfos
	 * @throws BizException 
	 */
	@SuppressWarnings("unused")
	private void getPsnInfo(EnIppreInfoDTO[] enIppreInfos) throws BizException {
		//组装set
		Set<String> idSet = new HashSet<String>();
		for (EnIppreInfoDTO dto : enIppreInfos) {
			if(!StringUtil.isEmptyWithTrim(dto.getId_emp_opapply())){//主管医生
				idSet.add(dto.getId_emp_opapply());
			}
			if(!StringUtil.isEmptyWithTrim(dto.getId_emp_nurse())){//责任护士
				idSet.add(dto.getId_emp_nurse());
			}
			if(!StringUtil.isEmptyWithTrim(dto.getId_emp_nur_last())){//责任护士最后一次
				idSet.add(dto.getId_emp_nur_last());
			}
			if(!StringUtil.isEmptyWithTrim(dto.getId_emp_entry())){//登记人
				idSet.add(dto.getId_emp_entry());
			}
			if(!StringUtil.isEmptyWithTrim(dto.getId_emp_ippre())){//接收预住院人
				idSet.add(dto.getId_emp_ippre());
			}
		}
		if(idSet==null && idSet.size()==0)
			return;
		//根据查询结果返回map
		PsnDocEP ep = new PsnDocEP();
		Map<String,PsnDocDO> map= ep.getPsnByIdSet(idSet);
		if(MapUtils.isEmpty(map)){
			return;
		}
		for (EnIppreInfoDTO dto : enIppreInfos) {
			if(map.containsKey(dto.getId_emp_opapply()) && map.get(dto.getId_emp_opapply()) != null){
				dto.setName_emp_opapply(map.get(dto.getId_emp_opapply()).getName());//主管医生
			}
			if(map.containsKey(dto.getId_emp_nurse()) && map.get(dto.getId_emp_nurse()) != null){
				dto.setName_emp_nurse(map.get(dto.getId_emp_nurse()).getName());//责任护士
			}
			if(map.containsKey(dto.getId_emp_nur_last()) && map.get(dto.getId_emp_nur_last()) != null){
				dto.setName_emp_nur_last(map.get(dto.getId_emp_nur_last()).getName());//责任护士最后一次
			}
			if(map.containsKey(dto.getId_emp_entry()) && map.get(dto.getId_emp_entry()) != null){
				dto.setName_emp_entry(map.get(dto.getId_emp_entry()).getName());//登记人
			}
			if(map.containsKey(dto.getId_emp_ippre()) && map.get(dto.getId_emp_ippre()) != null){
				dto.setName_emp_ippre(map.get(dto.getId_emp_ippre()).getName());//接收预住院人
			}
		}
	}

	/**
	 * 查询部门信息
	 * @param enIppreInfos
	 * @throws BizException 
	 */
	@SuppressWarnings("unused")
	private void getDepInfo(EnIppreInfoDTO[] enIppreInfos) throws BizException {
		if(enIppreInfos == null)
			return;
		//1.组装成set 批量查询
		Set<String> idSet = new HashSet<String>();
		for(EnIppreInfoDTO obj: enIppreInfos){
			if(!StringUtil.isEmptyWithTrim(obj.getCur_id_dep_phy()))
				idSet.add(obj.getCur_id_dep_phy());
			if(!StringUtil.isEmptyWithTrim(obj.getCur_id_dep_nur()))
				idSet.add(obj.getCur_id_dep_nur());
			if(!StringUtil.isEmptyWithTrim(obj.getId_dep_phy()))
				idSet.add(obj.getId_dep_phy());
			if(!StringUtil.isEmptyWithTrim(obj.getId_dep_nur()))
				idSet.add(obj.getId_dep_nur());
			if(!StringUtil.isEmptyWithTrim(obj.getId_dep_phyadm()))
				idSet.add(obj.getId_dep_phyadm());
			if(!StringUtil.isEmptyWithTrim(obj.getId_dep_nuradm()))
				idSet.add(obj.getId_dep_nuradm());
			if(!StringUtil.isEmptyWithTrim(obj.getId_dep_from()))
				idSet.add(obj.getId_dep_from());
			if(!StringUtil.isEmptyWithTrim(obj.getId_dep_nur_from()))
				idSet.add(obj.getId_dep_nur_from());
		}
		
		if(idSet==null && idSet.size()==0)
			return;
		//2.查询结果返回map
		DeptEP ep = new DeptEP();
		Map<String,DeptDO> map= ep.getDeptMapSet(idSet);
		if(MapUtils.isEmpty(map)){
			return;
		}
		for(EnIppreInfoDTO obj: enIppreInfos){
			if(map.containsKey(obj.getCur_id_dep_phy()) && map.get(obj.getCur_id_dep_phy())!=null){
				obj.setCur_name_dep_phy(map.get(obj.getCur_id_dep_phy()).getName());
			}
			if(map.containsKey(obj.getCur_id_dep_nur()) && map.get(obj.getCur_id_dep_nur())!=null){
				obj.setCur_name_dep_nur(map.get(obj.getCur_id_dep_nur()).getName());
			}
			if(map.containsKey(obj.getId_dep_phy()) && map.get(obj.getId_dep_phy())!=null){
				obj.setName_dep_phy(map.get(obj.getId_dep_phy()).getName());
			}
			if(map.containsKey(obj.getId_dep_nur()) && map.get(obj.getId_dep_nur())!=null){
				obj.setName_dep_nur(map.get(obj.getId_dep_nur()).getName());
			}
			if(map.containsKey(obj.getId_dep_phyadm()) && map.get(obj.getId_dep_phyadm())!=null){
				obj.setName_dep_phyadm(map.get(obj.getId_dep_phyadm()).getName());
			}
			if(map.containsKey(obj.getId_dep_nuradm()) && map.get(obj.getId_dep_nuradm())!=null){
				obj.setName_dep_nuradm(map.get(obj.getId_dep_nuradm()).getName());
			}
			if(map.containsKey(obj.getId_dep_from()) && map.get(obj.getId_dep_from())!=null){
				obj.setName_dep_from(map.get(obj.getId_dep_from()).getName());
			}
			if(map.containsKey(obj.getId_dep_nur_from()) && map.get(obj.getId_dep_nur_from())!=null){
				obj.setName_dep_nur_from(map.get(obj.getId_dep_nur_from()).getName());
			}
		}
	}
}
