package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtAppQryDTO;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOptApplBP {
	public MtAppDTO[] exec (MtAppQryDTO appDTO,String sd_sctp, FBoolean undoneApt, FBoolean doneApt)throws BizException{
		StringBuilder sql = this.getSql();
		SqlParam param = new SqlParam();
	    if(FBoolean.TRUE.equals(undoneApt) && FBoolean.TRUE.equals(doneApt))
		{
//			//未预约 + 已预约
//			if(ScParamUtils.getScOptDepApprove()){//获取手术预约前是否需要临床科室确认
//				sql.append(" and (appl.code_entp = '10' and opt.fg_need_confirm='Y' and opt.fg_confirm_phy='Y')");
//			}
		}
		// 未预约
		else if (FBoolean.TRUE.equals(undoneApt))
		{
			sql.append("     and appl.fg_comfirm = 'N' ");
		}
		else if (FBoolean.TRUE.equals(doneApt))
		{
			//已预约
			sql.append("     and appl.fg_comfirm = 'Y' ");
		}
		else
		{
			//都未选择
			return null;
		}
		
		sql.append(" and appl.fg_canc = 'N'  ");
		//手术类型
		sql.append(" and appl.sd_sctp = ? ");
		param.addParam(IScDictCodeConst.SD_SCTP_OT);
		//执行科室
		sql.append(" and appl.id_dep_mp = ? ");
		param.addParam(appDTO.getId_dep());
		//时间
		sql.append(" and appl.d_b = ?");
		param.addParam(appDTO.getD_begin());
		//就诊类型:留观、门诊
		String sd_entps = ScSqlUtils.arrayToStr(this.getEnttpSelected(appDTO));
		sql.append(" and (appl.code_entp in (" + sd_entps + ") ");
		//就诊类型：急诊（急诊流水、急诊抢救、急诊留观）
		if(appDTO.getFg_et().booleanValue()){
			sql.append("or appl.code_entp like (?)");
			param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET + "%");
		}
		// 就诊类型：住院
		if(appDTO.getFg_ip().booleanValue()){
			if(ScParamUtils.getScOptDepApprove()){//获取组织参数 SC0300 手术预约前是否需要临床科室确认,只针对住院
				sql.append(" or (appl.code_entp = '10' and opt.fg_need_confirm='Y' and opt.fg_confirm_phy='Y')");
			} else {
				sql.append(" or (appl.code_entp = '10')");
			}
		}
		sql.append(" ) order by dep.code,appl.dt_appl ");//fanlq-2018-12-08-add-0141871
		@SuppressWarnings("unchecked")
		List<MtAppDTO> list = (List<MtAppDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(MtAppDTO.class));
		List<MtAppDTO> result = new ArrayList<MtAppDTO>();
		//设置就诊类型 过滤费用
		if(list.size()>0)
		{
			Map<String,Boolean> checkFeeMap = new HashMap<String,Boolean>();
			for (MtAppDTO mtAppDTO : list) {
				boolean isCheckFee = false;
				if(checkFeeMap.containsKey(mtAppDTO.getId_dep_mp())){
				 isCheckFee = checkFeeMap.get(mtAppDTO.getId_dep_mp());
				}else{
				 isCheckFee = ScParamUtils.getScAptMtChkFee(mtAppDTO.getId_dep_mp());
				 checkFeeMap.put(mtAppDTO.getId_dep_mp(), isCheckFee);
				}
				if(isCheckFee){
					if(mtAppDTO.getFg_bl() != null && mtAppDTO.getFg_bl().booleanValue()){
						result.add(mtAppDTO);
					}else{
						continue;
					}
				}else{
					result.add(mtAppDTO);
				}
				mtAppDTO.setAge(AgeCalcUtil.getAge(mtAppDTO.getDt_birth_pat())); //计算年龄
				if(IPiDictCodeConst.ID_SEX_FEMALE.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_FEMALE);
				}
				else if(IPiDictCodeConst.ID_SEX_MALE.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_MALE);
				}
				else if(IPiDictCodeConst.ID_SEX_UNEXPLAIN.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);
				}
				else if(IPiDictCodeConst.ID_SEX_UNKNOW.equals(mtAppDTO.getId_sex()))
				{
					mtAppDTO.setName_sex(IPiDictCodeConst.NAME_SEX_UNKNOW);
				}
				
				mtAppDTO.setName_enttp(this.getEnttpName(mtAppDTO.getSd_enttp()));
			}
		}
		return result.toArray(new MtAppDTO[0]);
	}
	/**
	 * 获取sql语句
	 * @return
	 */
	public StringBuilder getSql()
	{
		StringBuilder sql = new StringBuilder();
		sql.append(" select decode(apt.sd_status, '1', '约', '3', '毕','5','约') fg_apt,");
		sql.append(" res.name name_scres,");
		sql.append(" apt.queno,");
		sql.append(" ip.name_bed as  name_bed,");
		sql.append(" pi.dt_birth dt_birth_pat,");
		sql.append(" appl.id_sex,");
		sql.append(" pi.mnecode code_pat,");
		sql.append(" war.name name_dep_war,");
		sql.append(" ip.code_amr_ip inpatient_no,");
		sql.append(" appl.id_aptappl id_apt_appl,");
		sql.append(" appl.id_ent id_ent,");
		sql.append(" appl.piname name_pat,");
		sql.append(" appl.id_pi id_pat,");
		sql.append(" appl.id_or id_or,");
		sql.append(" appl.name content_or,");
		sql.append(" appl.id_dep_appl id_dep_apply,");
		sql.append(" dep.name name_dep_apply,");
		sql.append(" psn.name as name_emp_apply,");//申请医生
		sql.append(" appl.dt_appl dt_apply,");
		sql.append(" appl.dt_appl dt_plan,");
		sql.append(" appl.dt_effe_or ,");
		sql.append(" apt.sd_status as Apt_status,");
		sql.append(" appl.code_entp sd_enttp,");
		sql.append(" appl.fg_urgent fg_urgent,");
		sql.append(" opt.fg_infection,");//是否感染手术
		sql.append(" surgical.name as name_surgical_site,");
		sql.append(" opt.name_di,");
		sql.append(" opt.code_di,");
		sql.append(" appl.eu_aptmd as sd_aptmd,");
		sql.append(" anestp.name name_anestp,");
		sql.append(" appl.id_dep_mp,");
		sql.append(" mp.name name_dep_mp,");
		sql.append(" appl.id_srv,");
		// 就诊类型
		sql.append(" decode(substr(appl.code_entp, '0', '2'),'00','门诊','01','急诊','10','住院','02','体检','20','家庭病床') as name_enttp,");
		sql.append(" case when appl.code_entp='10' then (acc.amt_prepay-acc.amt_uncg) else null end as balance,");
		sql.append(" opt.sortno_depphy,appl.fg_bl");
		sql.append(" from sc_apt_appl appl");
		sql.append(" inner join bd_dep dep on dep.id_dep = appl.id_dep_appl");
		sql.append(" inner join pi_pat pi on pi.id_pat = appl.id_pi");
		sql.append(" left join bd_dep mp on mp.id_dep = appl.id_dep_mp");//执行科室
		sql.append(" left outer join sc_apt apt on apt.id_apt = appl.id_scapt and apt.fg_canc = 'N'");
		sql.append(" left outer join sc_res res on res.id_scres = apt.id_scres");
		sql.append(" left outer join en_ent_ip ip on ip.id_ent = appl.id_ent");
		sql.append(" left join bd_dep war on war.id_dep = ip.id_dep_nuradm");
		sql.append(" left outer join sc_apt_appl_opt opt on appl.id_aptappl = opt.id_aptappl");
		sql.append(" left join bd_udidoc anestp on anestp.id_udidoc = opt.id_anestp");
		sql.append(" left join bd_udidoc surgical on surgical.id_udidoc = appl.id_surgical_site");
		sql.append(" left join en_ent_acc acc on appl.id_ent=acc.id_ent");
		sql.append(" left join bd_psndoc psn on psn.id_psndoc = appl.id_emp_appl ");//申请医生
		sql.append("     where appl.fg_canc = 'N' ");
		return sql;
	}	
	/**
	 * 获取选中的就诊类型编码
	 *
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public String[] getEnttpSelected(MtAppQryDTO qryDTO) throws BizException {
		List<String> enttps = new ArrayList<String>();
		if (qryDTO.getFg_es().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ES);// 留观
		}
//		if (qryDTO.getFg_et().booleanValue()) {
//			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET);// 急诊
//		}
//		if (qryDTO.getFg_ip().booleanValue()) {
//			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 住院
//		}
		if (qryDTO.getFg_op().booleanValue()) {
			enttps.add(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// 门诊
		}
		return enttps.toArray(new String[0]);
	}
	/**
	 * 获取就诊类型
	 * @param code_enttp
	 * @return
	 */
	public String getEnttpName(String code_enttp)
	{
		if(StringUtil.isEmpty(code_enttp))
		{
			return "";
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ES.equals(code_enttp))
		{
			return "留观";
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_enttp))
		{
			return "流水";
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_enttp))
		{
			return "抢救";
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_enttp))
		{
			return "留观";
		}
//		else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_enttp) || IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_enttp) || IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_enttp))
//		{
//			return "急诊";
//		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_enttp))
		{
			return "住院";
		}
		else if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_enttp))
		{
			return "门诊";
		}
		return "";
	}
}
