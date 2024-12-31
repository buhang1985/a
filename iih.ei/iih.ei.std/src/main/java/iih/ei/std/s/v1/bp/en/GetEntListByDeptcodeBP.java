package iih.ei.std.s.v1.bp.en;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.entlistbydeptcode.d.EntListByDeptcodeDTO;
import iih.ei.std.d.v1.en.entlistbydeptcode.d.EntListByDeptcodeParamDTO;
import iih.ei.std.d.v1.en.entlistbydeptcode.d.EntListByDeptcodeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取本次就诊患者分类  BP
 * 
 * @author li.wm
 */
public class GetEntListByDeptcodeBP extends IIHServiceBaseBP<EntListByDeptcodeParamDTO, EntListByDeptcodeResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(EntListByDeptcodeParamDTO param) throws BizException {
		
		if (param.getDt_begin() == null) {
			throw new BizException("开始时间不能为空！");
		}
		param.setDt_begin(param.getDt_begin().substring(0, 10) + " 00:00:00");
		if (param.getDt_end() == null) {
			throw new BizException("结束时间不能为空！");
		}
		param.setDt_end(param.getDt_end().substring(0, 10) + " 00:00:00");
	}

	@Override
	protected EntListByDeptcodeResultDTO process(EntListByDeptcodeParamDTO param) throws BizException {
		EntListByDeptcodeResultDTO resultDTO = new EntListByDeptcodeResultDTO();
		
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<EntListByDeptcodeDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, EntListByDeptcodeDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setEntlistbydeptcode(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	
	/***
	 * @Description:获取sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(EntListByDeptcodeParamDTO param,SqlParam sqlParam){
		StringBuilder sqlSb = new StringBuilder();
        sqlSb.append("select distinct pat.code as code_pat,");
        sqlSb.append("op.times_op as times_op,");
        sqlSb.append("ip.times_ip as times_ip,");
        sqlSb.append("ent.code_entp as code_entp,");
        sqlSb.append("ent.dt_acpt as dt_acpt,");
        sqlSb.append("ca.code as code_patca,");
        sqlSb.append("pri.code as code_patpri,");
        sqlSb.append("hp.no_hp as hp_no,");
        sqlSb.append("case when op.fg_first = 'Y' then 1 else 0 end as fg_first,");
        sqlSb.append("srv.code as code_srvtp,");
        sqlSb.append("srv.name as name_srvtp,");
        sqlSb.append("dep.code as code_dept,");
        sqlSb.append("doc.code as code_empphy,");
        sqlSb.append("doc.name as name_emp_phy,");
        sqlSb.append("substr(ent.dt_entry,0,10) as dt_entry,");
        sqlSb.append("case when aop.id_en = '~' then  0 else 1 end as  is_apt,");
        sqlSb.append("case when dayslot.code = '1001' then 'am' when dayslot.code = '1003' then 'pm' end as ampm,");
        sqlSb.append("case when ent.fg_canc = 'N' then 0 when ent.fg_canc = 'Y' then 1 end as fg_canc,");//退号标志，fanlq-2018-04-25
        sqlSb.append("op.ticketno as tick_no,nvl(op.sd_status,ip.sd_status) as code_status, ");
        sqlSb.append("ent.code as code_ent ");
        sqlSb.append(" from en_ent ent ");
        sqlSb.append(" left join pi_pat pat on pat.id_pat = ent.id_pat");
        sqlSb.append(" left join bd_dep dep on dep.id_dep = ent.id_dep_phy");
        sqlSb.append(" left join en_ent_op op on op.id_ent = ent.id_ent");
        sqlSb.append(" left join en_ent_ip ip on ip.id_ent = ent.id_ent");
        sqlSb.append(" left join pi_pat_ca ca on ca.id_patca = ent.id_patca");
        sqlSb.append(" left join bd_pri_pat pri on pri.id_pripat = pat.id_patpritp");
        sqlSb.append(" left join pi_pat_hp hp on hp.id_pat = pat.id_pat");
        sqlSb.append(" left join sc_srv srv on srv.id_scsrv = op.id_scsrv");
        sqlSb.append(" left join bd_psndoc doc on op.id_emp_reg = doc.id_psndoc");
        sqlSb.append(" left join sc_apt apt on apt.id_pat = ent.id_pat");
        sqlSb.append(" left join sc_apt_op aop on aop.id_apt = apt.id_apt");
        sqlSb.append(" left join bd_dayslot dayslot on dayslot.id_dayslot = op.id_dateslot");
        sqlSb.append(" where 1=1 ");
        if(!StringUtils.isNullOrEmpty(param.getDt_begin())){
        	sqlSb.append(" and ent.dt_entry >= ? ");
        	sqlParam.addParam(param.getDt_begin());
        }
        if(!StringUtils.isNullOrEmpty(param.getDt_end())){
        	sqlSb.append(" and ent.dt_entry <= ?");
        	sqlParam.addParam(param.getDt_end());
        }
        if(!StringUtils.isNullOrEmpty(param.getCode_dept())){
        	sqlSb.append(" and dep.code = ? ");
        	sqlParam.addParam(param.getCode_dept());
        }
        if(!StringUtils.isNullOrEmpty(param.getCode_ent())){
        	sqlSb.append(" and ent.code = ? ");
        	sqlParam.addParam(param.getCode_ent());
        }
        if(!StringUtils.isNullOrEmpty(param.getCode_entp())){
        	sqlSb.append(" and ent.code_entp = ? ");
        	sqlParam.addParam(param.getCode_entp());
        }
        sqlSb.append(" order by dt_entry desc ");
		
		return sqlSb.toString();
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,EntListByDeptcodeResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
	
}
