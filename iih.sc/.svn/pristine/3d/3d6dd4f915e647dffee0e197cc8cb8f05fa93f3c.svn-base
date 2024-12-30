package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptDto;
import iih.sc.apt.scaptmgr.d.ScaptmgrDTO;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊和医技预约管理dto
 * @author ccj
 *
 */
public class GetAptOpAndMtMgrDtoBp {
	/**
	 * 获取门诊和医技预约管理dto
	 * @param AptDto 预约dto
	 * @throws BizException
	 */
	public ScaptmgrDTO[] exec(AptDto aptDto) throws BizException{
		if(aptDto == null || StringUtils.isEmpty(aptDto.getSd_sctp())) return null;
		SqlParam param = new SqlParam();
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append("select pat.name as name_pat,pat.sd_sex,pat.id_sex,pat.dt_birth,pat.mob,apt.dt_b,apt.dt_e,apt.id_dateslot,");
		sqlStr.append("apt.id_dep_appt,apt.id_scchl,apt.id_scres,apt.id_scsrv,apt.id_emp_appt,apt.dt_appt,apt.sd_status,apt.id_status,");
		sqlStr.append("apt.dt_canc,apt.queno,apt.id_emp_canc as id_canc,apt.id_apt");
		if(IScDictCodeConst.SD_SCTP_MT.equals(aptDto.getSd_sctp())){
			sqlStr.append(",mt.Id_or");
			sqlStr.append(" from pi_pat pat inner join sc_apt apt on pat.id_pat = apt.id_pat ");
			sqlStr.append("inner join sc_apt_mt mt on mt.id_apt = apt.id_apt ");
		}else if(IScDictCodeConst.SD_SCTP_OP.equals(aptDto.getSd_sctp())){
			sqlStr.append(",op.id_en id_ent");
			sqlStr.append(" from pi_pat pat inner join sc_apt apt on pat.id_pat = apt.id_pat ");
			sqlStr.append("inner join sc_apt_op op on op.id_apt = apt.id_apt ");
		}
		sqlStr.append("and apt.sd_sctp = ? ");
		param.addParam(aptDto.getSd_sctp());
		if(StringUtils.isNotBlank(aptDto.getId_scres())){
			sqlStr.append(" and apt.id_scres= ? ");
			param.addParam(aptDto.getId_scres());
		}
		if(StringUtils.isNotBlank(aptDto.getId_scsrv())){
			sqlStr.append(" and apt.id_scsrv= ? ");
			param.addParam(aptDto.getId_scsrv());
		}
		if(StringUtils.isNotBlank(aptDto.getName_pat())){
			sqlStr.append(" and pat.name like '%"+aptDto.getName_pat()+"%'");
		}
		if(StringUtils.isNotEmpty(aptDto.getQuery_begin_date()) && StringUtils.isEmpty(aptDto.getQuery_end_date())){
			sqlStr.append(" and apt.dt_b>= ? ");
			param.addParam(aptDto.getQuery_begin_date());
		}else if(StringUtils.isEmpty(aptDto.getQuery_begin_date()) && StringUtils.isNotEmpty(aptDto.getQuery_end_date())){
			sqlStr.append(" and apt.dt_e<= ? ");
			param.addParam(aptDto.getQuery_end_date()+"23:59:59");
		}else if(StringUtils.isNotEmpty(aptDto.getQuery_begin_date()) && StringUtils.isNotEmpty(aptDto.getQuery_end_date())){
			sqlStr.append(" and apt.dt_b>= ? and apt.dt_e<= ? ");
			param.addParam(aptDto.getQuery_begin_date());
			param.addParam(aptDto.getQuery_end_date()+"23:59:59");
		}
		sqlStr.append("order by apt.dt_appt desc");
		List<ScaptmgrDTO> reList = (List<ScaptmgrDTO>)new DAFacade().execQuery(sqlStr.toString(),param,new BeanListHandler(ScaptmgrDTO.class));
		if(CollectionUtils.isEmpty(reList)) return null;
		return reList.toArray(new ScaptmgrDTO[reList.size()]);
	}
}
