package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnAuthListDTO;
import iih.en.pv.dto.d.EnAuthQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 获取患者授权信息
 * @author zhangpp
 *
 */
public class GetEnAuthBP {

	public PagingRtnData<EnAuthListDTO> exec(EnAuthQryDTO qryDto, PaginationInfo pageInfo) throws BizException {
       
        //校验入参
      	this.checkParam(qryDto);
        SqlParam param = new SqlParam();
        String sql = this.getSql(qryDto, param);
        PagingRtnData<EnAuthListDTO> ret = this.getRtnData(pageInfo, sql, param);
        return ret;
        
    }
	
	/**
	 * 校验入参
	 * @param qryDto
	 * @throws BizException
	 */
	private void checkParam(EnAuthQryDTO qryDto) throws BizException {
		
		if (qryDto.getDt_begin() == null) {
			throw new BizException("开始日期不允许为空");
		}
		if(qryDto.getDt_end() == null) {
			throw new BizException("结束日期不允许为空");
		}
		
	}
	
	/**
	 * 查询sql
	 * @param qryDto
	 * @param param
	 * @return
	 */
	private String getSql(EnAuthQryDTO qryDto, SqlParam param) {
        StringBuilder str= new StringBuilder();
        
        str.append(" select ");
        str.append(" dep1.name as name_dep_from, ");
        str.append(" psn1.name as name_emp_from, ");
        str.append(" ent.name_pat, ");
        str.append(" dep3.name as name_nur, ");
        str.append(" ip.name_bed as name_bed, ");
        str.append(" dep2.name as name_dep_to, ");
        str.append(" psn2.name as name_emp_to, ");
        str.append(" auth.dt_begin, ");
        str.append(" auth.dt_end, ");
        str.append(" auth.reason ");
        str.append(" from en_ent_auth auth ");
        str.append(" inner join en_ent ent on auth.id_ent = ent.id_ent ");
        str.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
        str.append(" left join bd_dep dep1 on auth.id_dep_from = dep1.id_dep ");
        str.append(" left join bd_psndoc psn1 on auth.id_emp_from = psn1.id_psndoc ");
        str.append(" left join bd_dep dep2 on auth.id_dep_to = dep2.id_dep ");
        str.append(" left join bd_psndoc psn2 on auth.id_emp_to = psn2.id_psndoc ");
        str.append(" left join bd_dep dep3 on ent.id_dep_nur = dep3.id_dep ");
        str.append(" where ");
        //开始日期
        str.append(" auth.dt_begin <= ? ");
        param.addParam(qryDto.getDt_end());
        //结束日期
        str.append(" and auth.dt_end >= ? ");
        param.addParam(qryDto.getDt_begin());
        //目标科室
        if (!EnValidator.isEmpty(qryDto.getId_dep_to())) {
			str.append(" and auth.id_dep_to = ? ");
			param.addParam(qryDto.getId_dep_to());
		}
        //目标医生
        if (!EnValidator.isEmpty(qryDto.getId_emp_to())) {
			str.append(" and auth.id_emp_to = ? ");
			param.addParam(qryDto.getId_emp_to());
		}
        //原科室
        if (!EnValidator.isEmpty(qryDto.getId_dep_from())) {
        	str.append(" and auth.id_dep_from = ? ");
			param.addParam(qryDto.getId_dep_from());
		}
        //原医生
        if (!EnValidator.isEmpty(qryDto.getId_emp_from())) {
        	str.append(" and auth.id_emp_from = ? ");
			param.addParam(qryDto.getId_emp_from());
		}
        
        return str.toString();
    }
	
	/**
     * 查询数据 分页
     * @param pg
     * @param sql
     * @param param
     * @return
     * @throws BizException
     */
    private PagingRtnData<EnAuthListDTO> getRtnData(PaginationInfo pg, String sql, SqlParam param)
            throws BizException {
        PagingServiceImpl<EnAuthListDTO> pageQryService = new PagingServiceImpl<EnAuthListDTO>();
        return pageQryService.findByPageInfo(new EnAuthListDTO(), pg, sql, null, param);
    }
}
