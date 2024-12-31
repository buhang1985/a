package iih.bl.cg.s.bp.ip;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.BLCgIpOutInfoDTO;
import iih.bl.cg.dto.d.BLCgIpOutQryDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院记账费用总金额
 * @author hanjq
 *
 */
public class GetCgIpAmtRatioBP {

	public BLCgIpOutInfoDTO[] exec(BLCgIpOutQryDTO qryDto) throws BizException {
		this.checkParam(qryDto);
		SqlParam param = getSqlParam(qryDto);
		String sql = getSql(qryDto);
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BLCgIpOutInfoDTO> result= (List<BLCgIpOutInfoDTO>) daf.execQuery(sql, param, new BeanListHandler(BLCgIpOutInfoDTO.class));
		BLCgIpOutInfoDTO[] array = new BLCgIpOutInfoDTO[0];
		if(result != null && result.size() > 0){
			return result.toArray(array);
		}
		return array;
	}
	
	/**
	 * 检查参数是否合法
	 * @param qryDto
	 * @throws BizException
	 */
	private void checkParam(BLCgIpOutQryDTO qryDto) throws BizException{
		if(qryDto == null || StringUtils.isBlank(qryDto.getId_ent())){
			throw new BizException("查询条件为空");
		}
	}
	
	/**
	 * 获取查询条件
	 * @param qryDto
	 * @return
	 */
	private SqlParam getSqlParam(BLCgIpOutQryDTO qryDto){
		SqlParam param = new SqlParam();
		if(StringUtils.isNotBlank(qryDto.getId_ent())){
			param.addParam(qryDto.getId_ent());
		}
		if(StringUtils.isNotBlank(qryDto.getId_stip())){
			param.addParam(qryDto.getId_stip());
		}
		if(StringUtils.isNotBlank(qryDto.getFg_st())){
			param.addParam(qryDto.getFg_st());
		}
		return param;
	}
	
	/**
	 * 获取查询sql
	 * @param qryDto
	 * @return
	 */
	private String getSql(BLCgIpOutQryDTO qryDto){
		StringBuilder sql = new StringBuilder();
		sql.append("select id_or, sum(a0.Amt*eu_direct)  amt,        sum(a0.Amt_ratio*eu_direct) amt_ratio  ");
		sql.append("from bl_cg_ip a0	");
		sql.append("where a0.fg_real = 'Y'		");
		if(StringUtils.isNotBlank(qryDto.getId_ent())){
			sql.append("and a0.id_ent = ?	");
		}
		if(StringUtils.isNotBlank(qryDto.getId_stip())){
			sql.append("and a0.id_stip = ?	");
		}
		if(StringUtils.isNotBlank(qryDto.getFg_st())){
			sql.append("and a0.fg_st = ?	");
		}
		if(qryDto.getId_ors() != null && qryDto.getId_ors().size() > 0){
			FArrayList idOrs = qryDto.getId_ors();
			ArrayList<String> idOrList = new ArrayList<>(qryDto.getId_ors().size());
			for(Object obj : idOrs){
				idOrList.add((String) obj);
			}
			sql.append("and a0.id_or in	(").append(SqlUtils.arrayToStr(idOrList.toArray(new String[0]))).append(")");
		}
		sql.append(" group by a0.id_or	");
		return sql.toString();
	}
	
}
