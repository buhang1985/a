package iih.ei.std.s.v1.bp.mp.pivas.qry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpOrdersQry implements ITransQry {

	private PivasIpOrderParamDTO param;
	public GetIpOrdersQry(PivasIpOrderParamDTO paramDTO) {
		this.param = paramDTO;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whrStr) {
		SqlParam param = new SqlParam();
		whrStr.append(" where ((ci.sd_srvtp like '01%' and orsrv.fg_or='Y') or (ci.sd_srvtp not like '01%' and ci.id_srv=orsrv.id_srv)) ");
		whrStr.append(" and ent.code_entp= '" + IEnDictCodeConst.SD_ENTP_INPATIENT + "' ");
		if(!StringUtils.isEmpty(this.param.getFg_ip())){
			whrStr.append("and ent.fg_ip= ? ");
			param.addParam(this.param.getFg_ip());
		}
		if(!StringUtils.isBlank(this.param.getCode_pat())){
			whrStr.append("and pat.code= ? ");
			param.addParam(this.param.getCode_pat());
		}
		if(this.param.getTimes_ip() != null){
			whrStr.append("and entip.times_ip= ? ");
			param.addParam(this.param.getTimes_ip());
		}
		if(!StringUtils.isEmpty(this.param.getFg_long())){
			whrStr.append("and ci.fg_long= ? ");
			param.addParam(this.param.getFg_long());
		}
		if(!StringUtils.isEmpty(this.param.getCode_or())){
			whrStr.append("and ci.code_or = ? ");
			param.addParam(this.param.getCode_or());
		}
		if(!StringUtils.isEmpty(this.param.getCode_emp_or())){
			whrStr.append("and oremp.code = ? ");
			param.addParam(this.param.getCode_emp_or());
		}
		if(!StringUtils.isEmpty(this.param.getCode_dep_nur_or())){
			whrStr.append("and nurdep.code = ? ");
			param.addParam(this.param.getCode_dep_nur_or());
		}
		if(!StringUtils.isEmpty(this.param.getFg_sign())){
			whrStr.append("and ci.fg_sign = ? ");
			param.addParam(this.param.getFg_sign());
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk())){
			whrStr.append("and ci.fg_chk = ? ");
			param.addParam(this.param.getFg_chk());
		}
		if(!StringUtils.isEmpty(this.param.getFg_stop())){
			whrStr.append("and ci.fg_stop =? ");
			param.addParam(this.param.getFg_stop());
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk_stop())){
			whrStr.append("and ci.fg_chk_stop = ? ");
			param.addParam(this.param.getFg_chk_stop());
		}
		if(!StringUtils.isEmpty(this.param.getFg_canc())){
			whrStr.append("and ci.fg_canc = ? ");
			param.addParam(this.param.getFg_canc());
		}
		if(!StringUtils.isEmpty(this.param.getFg_chk_canc())){
			whrStr.append("and ci.fg_chk_canc = ? ");
			param.addParam(this.param.getFg_chk_canc());
		}
		if(!StringUtils.isEmpty(this.param.getSd_su_or())){
			whrStr.append("and ci.sd_su_or = ? ");
			param.addParam(this.param.getSd_su_or());
		}
		if(!StringUtils.isEmpty(this.param.getCode_wh())){
			whrStr.append("and wh.code = ? ");
			param.addParam(this.param.getCode_wh());
		}
		if(!StringUtils.isEmpty(this.param.getDt_b_search()) && !StringUtils.isEmpty(this.param.getDt_e_search())){
			whrStr.append("  and (");
			if(!StringUtils.isEmpty(this.param.getDt_b_search())){
				whrStr.append(" ( ci.dt_chk >= ? ");
				param.addParam(this.param.getDt_b_search());
			}
			if(!StringUtils.isEmpty(this.param.getDt_e_search())){
				whrStr.append(" and ci.dt_chk <= ? ").append(")");
				param.addParam(this.param.getDt_e_search());
			}
			if(!StringUtils.isEmpty(this.param.getDt_b_search())){
				whrStr.append(" or  ( ci.dt_chk_canc >= ? ");
				param.addParam(this.param.getDt_b_search());
			}
			if(!StringUtils.isEmpty(this.param.getDt_e_search())){
				whrStr.append(" and ci.dt_chk_canc <= ? ").append(")");
				param.addParam(this.param.getDt_e_search());
			}
			if(!StringUtils.isEmpty(this.param.getDt_b_search())){
				whrStr.append(" or  ( ci.dt_chk_stop >= ? ");
				param.addParam(this.param.getDt_b_search());
			}
			if(!StringUtils.isEmpty(this.param.getDt_e_search())){
				whrStr.append(" and ci.dt_chk_stop <= ? ").append(" ) ");
				param.addParam(this.param.getDt_e_search());
			}
			whrStr.append(" ) ");
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return this._getQrySQLStr();
	}

	private String _getQrySQLStr() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select ");
		SqlStr.append(" pat.code as code_pat, ");//患者编码
		SqlStr.append(" entip.code_amr_ip as code_amr_ip, ");//住院病案编码(住院号)
		SqlStr.append(" entip.times_ip, ");//住院次数
		SqlStr.append(" entip.name_bed, ");//床位号
		SqlStr.append(" pat.name as name_pat, ");//患者姓名
		SqlStr.append(" sexdoc.name as name_sex_pat, ");//性别
		SqlStr.append(" ent.dt_birth_pat as dt_birth_pat, ");//出生日期
		SqlStr.append(" ci.code_or as code_or, ");//医嘱号
		SqlStr.append(" ci.code_or || orsrv.sortno as code_or_itm, ");//医嘱下服务号
		SqlStr.append(" ci.sd_su_or, ");//医嘱状态编码
		SqlStr.append(" ci.fg_long, ");//长期临时标志
		SqlStr.append(" decode(substr(ci.sd_srvtp,0,2),'01',orsrv.name,ci.name_or) as name_or, ");//医嘱名称
		SqlStr.append(" freq.code as code_freq, ");//频次编码
		SqlStr.append(" freq.name as name_freq, ");//频次名称
		SqlStr.append(" decode(substr(ci.sd_srvtp,0,2),'01',bdmm.code,bdsrv.code) as code_or_srv, ");//服务编码
		SqlStr.append(" bdmm.spec, ");//规格
		SqlStr.append(" orsrv.quan_medu, ");//剂量
		SqlStr.append(" measdoc.name as name_medu, ");//剂量单位名称
		SqlStr.append(" ci.dt_effe, ");//医嘱开始时间
		SqlStr.append(" (case ci.fg_chk_stop when 'Y' then ci.dt_end else null end) as dt_end, ");//医嘱结束时间
		SqlStr.append(" oremp.code as code_emp_or, ");//开单医生编码
		SqlStr.append(" oremp.name as name_emp_or, ");//开单医生名称
		SqlStr.append(" nurdep.code as code_dep_nur_or, ");//开单所在病区编码
		SqlStr.append(" nurdep.name as name_dep_nur_or, ");//开单所在病区名称
		SqlStr.append(" chkemp.code as code_emp_chk, ");//签署确认护士编码
		SqlStr.append(" chkemp.name as name_emp_chk, ");//签署确认护士名称
		SqlStr.append(" ci.fg_stop, ");//停止标识
		SqlStr.append(" stopemp.name as name_emp_stop, ");//停止医生名称
		SqlStr.append(" ci.fg_canc, ");//作废标识
		SqlStr.append(" srvmm.QUAN_NUM_BASE, ");//单次数量_分子
		SqlStr.append(" srvmm.QUAN_DEN_BASE, ");//单次数量_分母
		SqlStr.append(" bm.name as name_pgku_base, ");//基本包装单位名称
		SqlStr.append(" route.name as name_route, ");//给药方式名称
		SqlStr.append(" decode(orsrv.sd_nodispense,'1','Y','N') as fg_nodispense ");//嘱托标识
		SqlStr.append(" from ");
		SqlStr.append(" ci_order ci ");
		SqlStr.append(" left join ci_or_srv orsrv on ci.id_or = orsrv.id_or ");
		SqlStr.append(" left join ci_or_srv_mm srvmm on orsrv.id_orsrv = srvmm.id_orsrv ");
		SqlStr.append(" left join en_ent ent on ci.id_en = ent.id_ent ");
		SqlStr.append(" left join bd_freq freq on freq.id_freq = ci.id_freq ");
		SqlStr.append(" left join bd_srv bdsrv on bdsrv.id_srv = orsrv.id_srv ");
		SqlStr.append(" left join bd_mm bdmm on bdmm.id_mm = srvmm.id_mm ");
		SqlStr.append(" left join bd_measdoc measdoc on measdoc.id_measdoc=orsrv.id_medu ");
		SqlStr.append(" left join bd_route route on route.id_route = ci.id_route ");
		SqlStr.append(" left join bd_psndoc oremp on oremp.id_psndoc = ci.id_emp_or ");
		SqlStr.append(" left join bd_psndoc chkemp on chkemp.id_psndoc = ci.id_emp_chk ");
		SqlStr.append(" left join bd_psndoc stopemp on stopemp.id_psndoc = ci.id_emp_sign ");
		SqlStr.append(" left join bd_dep nurdep on nurdep.id_dep = ent.id_dep_nur ");
		SqlStr.append(" left join pi_pat pat on pat.id_pat = ci.id_pat ");
		SqlStr.append(" left join en_ent_ip entip on ent.id_ent = entip.id_ent ");
		SqlStr.append(" left join bd_udidoc sexdoc on sexdoc.id_udidoc = ent.id_sex_pat ");
		SqlStr.append(" left join bd_measdoc bm on srvmm.id_pgku_base=bm.id_measdoc ");
		SqlStr.append(" left join bd_dep wh on wh.id_dep=orsrv.id_dep_wh ");
		return SqlStr.toString();
	}
}
