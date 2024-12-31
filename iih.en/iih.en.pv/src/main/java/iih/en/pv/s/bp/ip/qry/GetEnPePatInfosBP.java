package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.EnPePatInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询团检单位患者信息
 * @author renying
 *
 */
public class GetEnPePatInfosBP {
	   
    /**
     * 查询团检单位患者信息
     * @param pecmpyId
     * @return enPePatInfoDTOs
     * @throws BizException
     */
	@SuppressWarnings("unchecked")
    public EnPePatInfoDTO[] exec(String pecmpyId)throws BizException{
	    
    	if(EnValidator.isEmpty(pecmpyId))
    		return null;
    	SqlParam param = new SqlParam();
    	String sql = this.getSql(pecmpyId,param);  	
    	List<EnPePatInfoDTO> dtoList=  (List<EnPePatInfoDTO>) new DAFacade().execQuery(sql,param,new BeanListHandler(EnPePatInfoDTO.class)); 
    	if (EnValidator.isEmpty(dtoList)) {
 			return null;
 		}
    	EnPePatInfoDTO[]  enPePatInfoDTOs = dtoList.toArray(new EnPePatInfoDTO[0]);
    	this.getPatAge(enPePatInfoDTOs);
 	    return enPePatInfoDTOs;
    }
	/**
	 * 查询团检单位患者信息 分页
	 * @param pecmpyId
	 * @param pageInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EnPePatInfoDTO> pageexec(String pecmpyId,PaginationInfo pageInfo) throws BizException{
		if (EnValidator.isEmpty(pecmpyId))
    		return null;
    	SqlParam param = new SqlParam();
    	String sql = this.getSql(pecmpyId, param);
		PagingRtnData<EnPePatInfoDTO> ret = this.getRtnData(pageInfo, sql, param);
		if (ret != null && ret.getPageData() != null && ret.getPageData().size() > 0) 
			this.getPatAge(ret);
		return ret;
	}
	
	/**
	 * 查询数据 分页
	 * @param pg
	 * @param sql
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<EnPePatInfoDTO> getRtnData(PaginationInfo pg, String sql, SqlParam param)
			throws BizException {
		PagingServiceImpl<EnPePatInfoDTO> pageQryService = new PagingServiceImpl<EnPePatInfoDTO>();
		return pageQryService.findByPageInfo(new EnPePatInfoDTO(), pg, sql, null, param);
	}
	
    /**
     * 查询sql
     * @param pecmpyId
     * @return sql.toString()
     */
    private String getSql(String pecmpyId,SqlParam param){
    	StringBuilder sql = new StringBuilder();
    	sql.append(" select  ");
    	sql.append(" cmpy.id_pecmpy ");
    	sql.append(" ,cmpy.times_pe "); //体检次数
    	sql.append(" ,cmpy.dt_b ");	//入院日期
    	sql.append(" ,cmpy.eu_status "); //团检状态
    	sql.append(" ,ent.id_ent ");  //就诊id
    	sql.append(" ,ent.name_pat "); //姓名
    	sql.append(" ,ent.fg_st "); //结算标志
    	sql.append(" ,bdsex.name as name_sex_pat "); //性别
    	sql.append(" ,ent.dt_birth_pat "); //出生日期
    	sql.append(" ,depphy.name as name_dep_phyadm "); //科室
    	sql.append(" ,depnur.name as name_dep_nuradm "); //病区
    	sql.append(" ,entip.code_amr_ip "); //住院档案号
    	sql.append(" from ");
    	sql.append(" en_pe_cmpy_itm itm ");
    	sql.append(" inner join en_pe_cmpy cmpy on itm.id_pecmpy = cmpy.id_pecmpy ");
    	sql.append(" left join en_ent ent on itm.id_ent = ent.id_ent ");
    	sql.append(" left join en_ent_ip entip on ent.id_ent = entip.id_ent ");
    	sql.append(" left join bd_udidoc bdsex on ent.id_sex_pat = bdsex.id_udidoc ");
    	sql.append(" left join bd_dep depphy on entip.id_dep_phyadm = depphy.id_dep ");
    	sql.append(" left join bd_dep depnur on entip.id_dep_nuradm = depnur.id_dep ");
    	sql.append(" where 1=1 ");
    	sql.append(" and  itm.id_pecmpy = ? ");
    	param.addParam(pecmpyId);
    	sql.append(" and ent.fg_canc = ? ");
    	param.addParam(FBoolean.FALSE);  
    	sql.append(" order by  entip.code_amr_ip desc");
    	return sql.toString();
    }
    
    /**
     * 查找患者年龄
     * @param ret
     * @throws BizException 
     */
    private void getPatAge(PagingRtnData<EnPePatInfoDTO> ret) throws BizException{
    	FArrayList arrList = ret.getPageData();
    	if (arrList != null && arrList.size() > 0){
    		/*for (Object obj : arrList) {
				EnPePatInfoDTO pePatInfoDTO = (EnPePatInfoDTO)obj;
				//pePatInfoDTO.setAge_pat(AgeCalcUtil.getAge(pePatInfoDTO.getDt_birth_pat()));
			}*/
    		EnAgeCalcUtil.setDoAges((EnPePatInfoDTO[]) arrList.toArray(new EnPePatInfoDTO[]{}), "Id_ent", "Age_pat");
    	}
    }
   /**
     * 查找患者年龄
     * @param enPePatInfoDTOs
     * @return
 * @throws BizException 
     */
    private void getPatAge(EnPePatInfoDTO[] enPePatInfoDTOs) throws BizException{
    	if (enPePatInfoDTOs == null || enPePatInfoDTOs.length == 0)
    		return;   		
    	/*for (EnPePatInfoDTO enPePatInfoDTO : enPePatInfoDTOs) {
    		enPePatInfoDTO.setAge_pat(AgeCalcUtil.getAge(enPePatInfoDTO.getDt_birth_pat()));
		}*/
    	EnAgeCalcUtil.setDoAges(enPePatInfoDTOs, "Id_ent", "Age_pat");
    }
    
}
