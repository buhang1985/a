package iih.bl.st.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.st.dto.d.IncDataInfoOepDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取门诊收费信息【打印诊间结算付款凭证用】
 * @author hanjq
 *
 */
public class GetStOepDataBP {

	public PagingRtnData<IncDataInfoOepDTO> exec(PaginationInfo pageInfo, BlincQueryDTO qryDto) throws BizException {
		if(qryDto == null || StringUtils.isBlank(qryDto.getId_pat())){
			throw new BizException("查询条件不能为空！");
		}
		/**
		 * select 
				st.id_stoep,
				st.eu_sttp,
				st.code_st,
				st.eu_direct,
				st.amt_ratio as amt_all,
				st.fg_cc as fg_cc_out,
				st.dt_st,
				decode(st.eu_sttp,31,'Y','N') as fg_reg,
				inc.id_incoep,
				inc.incno,
				inc.amt_ratio as amt_inc,
				inc.id_emp_inc,
				inc.dt_inc,
				inc.fg_print
			from bl_st_oep st
			join bl_inc_oep inc on inc.id_stoep = st.id_stoep
			join bl_pay_pat_oep pay on pay.id_paypatoep = st.id_paypatoep
			where st.id_pat = ?
				and pay.sd_pttp = ?
				and st.dt_st >= ?
				and st.dt_st <= ?
				and st.fg_canc = 'N'
		 */
		PagingServiceImpl<IncDataInfoOepDTO> service =new PagingServiceImpl<IncDataInfoOepDTO>();
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append("select		");
		sql.append("	st.id_stoep,	");
		sql.append("	st.eu_sttp,	");
		sql.append("	st.code_st,	");
		sql.append("	st.eu_direct,	");
		sql.append("	st.amt_ratio as amt_all,	");
		sql.append("	st.fg_cc as fg_cc_out,	");
		sql.append("	st.dt_st,	");
		sql.append("	decode(st.eu_sttp,31,'Y','N') as fg_reg,	");
		sql.append("	inc.id_incoep,	");
		sql.append("	inc.incno,	");
		sql.append("	inc.amt_ratio as amt_inc,	");
		sql.append("	inc.id_emp_inc,	");
		sql.append("	inc.dt_inc,	");
		sql.append("	inc.fg_print	");
		sql.append("from bl_st_oep st		");
		sql.append("join bl_inc_oep inc on inc.id_stoep = st.id_stoep		");
		sql.append("join bl_pay_pat_oep pay on pay.id_paypatoep = st.id_paypatoep		");
		sql.append("where st.id_pat = ?		");
		param.addParam(qryDto.getId_pat());
		if(StringUtils.isNotBlank(qryDto.getSd_pttp())){
			sql.append("	and pay.sd_pttp = ?	");
			param.addParam(qryDto.getSd_pttp());
		}
		if(qryDto.getDt_cgstart() != null ){
			sql.append("	and st.dt_st >= ?	");
			param.addParam(qryDto.getDt_cgstart());
		}
		if(qryDto.getDt_cgstart() != null ){
			sql.append("	and st.dt_st <= ?	");
			param.addParam(qryDto.getDt_dgend());
		}
		sql.append("	and st.fg_canc = 'N'	");
		sql.append("order by st.dt_st desc ,st.id_stoep,inc.incno		");
		PagingRtnData<IncDataInfoOepDTO> pageDto = service.findByPageInfo(new IncDataInfoOepDTO(), pageInfo, sql.toString(), "", param);
		
		return pageDto;
	}

}
