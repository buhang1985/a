package iih.bl.cg.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlPreIpParamDTO;
import iih.bl.cg.dto.d.BlPreIpSummayDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FType;
import xap.mw.coreitf.d.FTypeManager;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预住院记账数据查询
 * @author hanjq
 *
 */
public class GetPreIpBP {

	/**
	 * 获取预住院汇总
	 * @param paramDto
	 * @return
	 * @throws BizException 
	 */
	public BlPreIpSummayDTO exec(BlPreIpParamDTO paramDto) throws BizException {
		this.validate(paramDto);
		BlPreIpSummayDTO sum = new BlPreIpSummayDTO();
		sum.setAmt_already(this.getAmtReady(paramDto.getId_ent()));
		sum.setAmt_hasnot(this.getAmt(FBoolean.FALSE, paramDto));
		return sum;
	}
	
	/**
	 * 查询已转入金额
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private FDouble getAmtReady(String entId) throws BizException {
		
		String sql = "select nvl(sum (amt),0.00) from bl_cg_ippre_log where id_ent = ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		DAFacade daf = new DAFacade();
		Object rlt = daf.execQuery(sql, param, new ColumnHandler());
		return (FDouble)FTypeManager.convert2FType(FType.FDouble, rlt);
	}
	
	private FDouble getAmt(FBoolean fgTramsf,BlPreIpParamDTO paramDto) throws DAException{
		StringBuilder sql = new StringBuilder();
		sql.append("select	nvl(sum(round((cg.quan -cg.quan_ret) * cg.price_ratio,2)),0.00) amt_ratio ");
		SqlParam param = new SqlParam();
		paramDto.setFg_transf(fgTramsf);
		this.SetSqlAndParam(paramDto, sql, param);
		DAFacade daf = new DAFacade();
		BlCgIpDO amt1 = (BlCgIpDO) daf.execQuery(sql.toString(), param, new BeanHandler(BlCgIpDO.class));
		return  amt1== null ? FDouble.ZERO_DBL :amt1.getAmt_ratio();
	}

	/**
	 * 获取预住院记账明细
	 * @param pgInfo
	 * @param paramDto
	 * @return
	 * @throws BizException 
	 */
	public PagingRtnData<BlIpCgDTO> exec(PaginationInfo pgInfo, BlPreIpParamDTO paramDto) throws BizException {
		this.validate(paramDto);
		StringBuilder sql = new StringBuilder();
		sql.append("select	");
		sql.append("	cg.id_or, cor.name_or,cor.code_or,							");
		sql.append("	cg.id_srv,cg.name_srv,cg.code_srv,							");
		sql.append("	cg.id_mm,cg.name_mm,cg.code_mm,								");
		sql.append("	cg.id_dep_or,depor.name name_dep_or,depor.code code_dep_or,	");
		sql.append("	cg.id_dep_mp,depmp.name name_dep_mp,depmp.code code_dep_mp,	");
		
		if(FBoolean.FALSE.equals(paramDto.getFg_transf())){
			sql.append("	cg.spec,cg.quan - cg.quan_ret quan_mend,	");
			sql.append("	round((cg.quan -cg.quan_ret) * cg.price_ratio,2) amt_ratio,	");
		}else{
			sql.append("	plg.quan quan_mend, " );
			sql.append("	plg.amt amt_ratio, " );
		}
		
		sql.append("     cg.price_ratio,cg.dt_cg ");
		SqlParam param = new SqlParam();
		this.SetSqlAndParam(paramDto, sql, param);
		PagingServiceImpl<BlIpCgDTO> pageService = new PagingServiceImpl<BlIpCgDTO>();
		PagingRtnData<BlIpCgDTO> pageData = pageService.findByPageInfo(new BlIpCgDTO(), pgInfo, sql.toString(), "", param);
		return pageData;
	}
	
	/**
	 * 校验参数
	 * @param paramDto
	 * @throws BizException
	 */
	private void validate(BlPreIpParamDTO paramDto) throws BizException{
		if(paramDto == null || StringUtils.isBlank(paramDto.getId_ent())){
			throw new BizException("就诊主键不能为空");
		}
	}
	
	/**
	 * 设置参数和sql
	 * @param paramDto
	 * @param sql
	 * @param param
	 */
	private void SetSqlAndParam(BlPreIpParamDTO paramDto,StringBuilder sql,SqlParam param){
		/**
		 * select
			  cg.id_or, cor.name_or,cor.code_or,
			  cg.id_srv,cg.name_srv,cg.code_srv,
			  cg.id_mm,cg.name_mm,cg.code_mm,
			  cg.spec,cg.quan * cg.eu_direct quan_mend,cg.price_ratio,
			  cg.amt_ratio,
			  cg.id_dep_or,depor.name name_dep_or,depor.code code_dep_or,
			  cg.id_dep_mp,depmp.name name_dep_mp,depmp.code code_dep_mp,
			  cg.dt_cg
			from bl_cg_ip cg
			left join ci_order cor on cor.id_or = cg.id_or
			left join bd_dep depor on depor.id_dep = cg.id_dep_or
			left join bd_dep depmp on depmp.id_dep = cg.id_dep_mp
			where cg.code_enttp = '11'
			and cg.id_ent = ''
			and cg.fg_real = 'Y'
		 */
		
		sql.append("from bl_cg_ip cg	");
		sql.append("left join ci_order cor on cor.id_or = cg.id_or			");
		sql.append("left join bd_dep depor on depor.id_dep = cg.id_dep_or	");
		sql.append("left join bd_dep depmp on depmp.id_dep = cg.id_dep_mp	");
		if(FBoolean.TRUE.equals(paramDto.getFg_transf())){
			sql.append("inner join bl_cg_ippre_log plg on plg.id_cgip_pre = cg.id_cgip and plg.fg_active = 'Y' ");
		}
		sql.append("where cg.code_enttp = '11'	");
		sql.append("and cg.id_ent = ?	");
		param.addParam(paramDto.getId_ent());
		
		if(FBoolean.FALSE.equals(paramDto.getFg_transf())){
			sql.append("and not EXISTS(SELECT plg.id_cgip_pre FROM bl_cg_ippre_log plg where plg.id_cgip_pre = cg.id_cgip and plg.fg_active = 'Y')	");
			sql.append("and cg.fg_refund = 'N'	");
			sql.append("and cg.fg_real = 'Y'	");
			sql.append("and cg.eu_direct = 1	");
		}
		
		if(paramDto.getDt_e() != null){
			sql.append("and cg.dt_cg <= ?	");
			param.addParam(paramDto.getDt_e());
		}
	}

}
