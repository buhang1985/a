package iih.ei.std.s.v1.bp.en;

import java.util.List;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import iih.ei.std.d.v1.en.entlistbypatcode.d.EntListByPatcodeDTO;
import iih.ei.std.d.v1.en.entlistbypatcode.d.EntListByPatcodeParamDTO;
import iih.ei.std.d.v1.en.entlistbypatcode.d.EntListByPatcodeResultDTO;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取本次就诊患者分类  BP
 * 
 * @author li.wm
 */
public class GetEntListByPatcodeBP extends IIHServiceBaseBP<EntListByPatcodeParamDTO, EntListByPatcodeResultDTO>{
	/**
	 * 入参检查
	 * */
	@Override
	protected void checkParam(EntListByPatcodeParamDTO param) throws BizException {
		
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
	protected EntListByPatcodeResultDTO process(EntListByPatcodeParamDTO param) throws BizException {
		EntListByPatcodeResultDTO resultDTO = new EntListByPatcodeResultDTO();
		
		//获取SQL
		SqlParam sqlParam = new SqlParam();
		String sql = getSql(param,sqlParam);
		//获取分页信息执行SQl
		PageInfoDTO pageInfoDto = (PageInfoDTO) param.getPageinfo().get(0);
		List<EntListByPatcodeDTO> list = this.findPagingData(pageInfoDto,sql, sqlParam, EntListByPatcodeDTO.class);
		if(ListUtil.isEmpty(list)){
			return resultDTO;
		}
		//返回值设置分页信息
		setPageInfo(pageInfoDto,resultDTO);
		resultDTO.setEntlistbypatcode(ArrayListUtil.ConvertToFArrayList(list));
		return resultDTO;
	}
	
	/***
	 * @Description:获取sql
	 * @param param
	 * @param sqlParam
	 * @return
	 * @throws BizException 
	 */
	private String getSql(EntListByPatcodeParamDTO param,SqlParam sqlParam){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select");
		sqlSb.append(" ? as code_pat,");
		sqlParam.addParam(param.getCode_pat());
		sqlSb.append(" op.times_op    times_op,");
		sqlSb.append(" null as times_ip,");
		sqlSb.append(" ent.dt_acpt    dt_acpt,");
		sqlSb.append(" ent.id_ent     id_ent,");
		sqlSb.append(" ent.code_entp  code_entp,");
		sqlSb.append(" ent.name_pat   name_pat,");
		sqlSb.append(" ent.id_dep_phy id_dep_phy,");
		sqlSb.append(" dep.code       code_dep_phy,");
		sqlSb.append(" op.sd_status   code_status");
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_op op on ent.id_ent = op.id_ent");
		sqlSb.append(" left  join bd_dep dep on ent.id_dep_phy = dep.id_dep");
		sqlSb.append(" where ent.id_pat in (select id_pat from pi_pat where code = ?)");
		sqlParam.addParam(param.getCode_pat());
		sqlSb.append(" and ent.fg_canc = 'N'");
		sqlSb.append(" and ent.dt_entry >= ?");
		sqlParam.addParam(param.getDt_begin());
		sqlSb.append(" and ent.dt_entry < ?");
		sqlParam.addParam(param.getDt_end());
		if (!StringUtil.isEmpty(param.getCode_entp())) {
			sqlSb.append(" and ent.code_entp = ?");
			sqlParam.addParam(param.getCode_entp());
		}
		sqlSb.append(" union");
		sqlSb.append(" select");
		sqlSb.append(" ? as code_pat,");
		sqlParam.addParam(param.getCode_pat());
		sqlSb.append(" null as times_op,");
		sqlSb.append(" ip.times_ip    times_ip,");
		sqlSb.append(" ent.dt_acpt    dt_acpt,");
		sqlSb.append(" ent.id_ent     id_ent,");
		sqlSb.append(" ent.code_entp  code_entp,");
		sqlSb.append(" ent.name_pat   name_pat,");
		sqlSb.append(" ent.id_dep_phy id_dep_phy,");
		sqlSb.append(" dep.code       code_dep_phy,");
		sqlSb.append(" ip.sd_status   code_status");
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent");
		sqlSb.append(" left  join bd_dep dep on ent.id_dep_phy = dep.id_dep");
		sqlSb.append(" where ent.id_pat in (select id_pat from pi_pat where code = ?)");
		sqlParam.addParam(param.getCode_pat());
		sqlSb.append(" and ent.fg_canc = 'N'");
		sqlSb.append(" and ent.dt_entry >= ?");
		sqlParam.addParam(param.getDt_begin());
		sqlSb.append(" and ent.dt_entry < ?");
		sqlParam.addParam(param.getDt_end());
		if (!StringUtil.isEmpty(param.getCode_entp())) {
			sqlSb.append(" and ent.code_entp = ?");
			sqlParam.addParam(param.getCode_entp());
		}
		
		return sqlSb.toString();
	}
	
	/***
	 * @Description:设置分页信息
	 * @param pageInfoDto
	 * @param resultDto
	 */
	@SuppressWarnings("unchecked")
	private void setPageInfo(PageInfoDTO pageInfoDto,EntListByPatcodeResultDTO resultDto){
		FArrayList pageInfoList = new FArrayList();
		pageInfoList.add(pageInfoDto);
		resultDto.setPageinfo(pageInfoList);
	}
}
