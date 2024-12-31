package iih.en.er.bp.oupati;

import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErOutPatinQuirDTO;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 急诊就诊查询
 * @author 黄炎
 *
 */
public class GetEnErOutPatinQuirlnfoBP {

	/**
	 * 查询患者
	 * 
	 * @param enErOutPatinQuir
	 *            查询卡方案
	 * @return
	 * @throws BizException
	 * @throws ParseException 
	 */
	
	public PagingRtnData<EnErOutPatinQuirDTO> exec(EnErOutPatinQuirDTO enErOutPatinQuir, PaginationInfo pageInfo) throws BizException {
		
				SqlParam param = new SqlParam();
				//1.拼接Sql语句
		        String sql = this.getSql(enErOutPatinQuir, param);
		        //2.执行分页
		        PagingRtnData<EnErOutPatinQuirDTO> ret = this.getRtnData(pageInfo, sql, param);
			    FArrayList list = ret.getPageData();
			    IUdidocServiceExt  iUdidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
				Map<String, String> sexmap = this.getUdidocMap(iUdidocServiceExt.findByUdidoclistCode(IPiDictCodeTypeConst.SD_SEX_CODE));
				//分诊分级的获取
			    ErPreEP erPreEP = new ErPreEP();
				erPreEP.setErScoleName((EnErOutPatinQuirDTO[])list.toArray(new EnErOutPatinQuirDTO[]{}), "Sd_scale_triage", "Name_scale_triage");
				if (ret != null) {
					for(Object obj: list) {
						EnErOutPatinQuirDTO outDTO = (EnErOutPatinQuirDTO)obj;
			    		//计算年龄
			            this.getPatAge(outDTO);
			            //处理患者性别
			            this.getNameSex(outDTO, sexmap);
		            }
			    } 
		return ret;
	}

	private String getSql(EnErOutPatinQuirDTO enErOutPatinQuir, SqlParam param) throws BizException {
		String sql = "";
	    StringBuilder sqlBuilder = new StringBuilder();
	    sqlBuilder.append("select ent.id_ent, ");//查询就诊ID
	    sqlBuilder.append("pi.id_pat, ");//患者ID
	    sqlBuilder.append("ent.code_entp, ");//就诊类型ID编码
	    sqlBuilder.append("ent.name_pat, ");//患者姓名
	    sqlBuilder.append("pi.id_sex, ");//性别ID
	    sqlBuilder.append("pi.sd_sex, ");//性别编码
	    sqlBuilder.append("ent.dt_birth_pat as dt_birth, ");//出生日期
	    sqlBuilder.append("er.sd_scale_triage as sd_scale_triage, ");//分诊分级
	    sqlBuilder.append("pre.dt_entry, ");//到院时间
	    sqlBuilder.append("phy.id_dep as id_dep_phy, ");//科室ID
	    sqlBuilder.append("phy.name as name_dep_phy, ");//科室名称
	    sqlBuilder.append("nur.id_dep as id_dep_nur, ");//病区ID
	    sqlBuilder.append("nur.name as name_dep_nur, ");//病区名称
	    sqlBuilder.append("bed.id_bed, ");//床位ID
	    sqlBuilder.append("bed.name as name_bed, ");//床位名称
	    sqlBuilder.append("psndoc.id_psndoc as id_emp_phy, ");//医生ID
	    sqlBuilder.append("psndoc.name as name_emp_phy, ");//医生名称
	    sqlBuilder.append("op.sd_status ");//患者状态
	    sqlBuilder.append("from en_erpre pre ");
	    sqlBuilder.append("inner join en_ent_op_er er on er.id_erpre = pre.id_erpre ");
	    sqlBuilder.append("inner join en_ent ent on ent.id_ent = er.id_ent ");
	    sqlBuilder.append("inner join en_ent_op op on op.id_ent = er.id_ent ");
	    sqlBuilder.append("inner join pi_pat pi on pi.id_pat = ent.id_pat ");
	    sqlBuilder.append("left join bd_dep phy on phy.id_dep = ent.id_dep_phy ");
	    sqlBuilder.append("left join bd_dep nur on nur.id_dep = ent.id_dep_nur ");
	    sqlBuilder.append("left join bd_bed bed on bed.id_bed = er.id_bed ");
	    sqlBuilder.append("left join bd_psndoc psndoc on psndoc.id_psndoc = ent.id_emp_phy ");
	    sqlBuilder.append(" where ");
	    sqlBuilder.append(" 1 = 1 ");
	    /**
	     * 开始时间
	     */
	    if (!EnValidator.isEmpty(enErOutPatinQuir.getBegin_time())) {
			sqlBuilder.append(" And pre.dt_entry >= ? ");
			param.addParam(enErOutPatinQuir.getBegin_time());
		}   
	    /**
	     * 结束时间
	     */
	    if (!EnValidator.isEmpty(enErOutPatinQuir.getEnd_time())) {
			sqlBuilder.append(" And pre.dt_entry < ? ");
			param.addParam(enErOutPatinQuir.getEnd_time().getDateAfter(1));
		} 
	    /**
	     * 患者姓名、编码、条码号
	     */
	    if (!EnValidator.isEmpty(enErOutPatinQuir.getValue_pat())) {
			sqlBuilder.append(String.format(" And %s ? ", enErOutPatinQuir.getKey_pat()));
			param.addParam(enErOutPatinQuir.getValue_pat());
		}
	    
	    /**
	     * 科室ID
	     */
	    if (enErOutPatinQuir.getId_dep_phy_ref() != null) {
			sqlBuilder.append(" And ent.id_dep_phy = ? ");
		    param.addParam(enErOutPatinQuir.getId_dep_phy_ref());
		}
	    
	    /**
	     * 病区ID
	     */
	    if (enErOutPatinQuir.getId_dep_nur_ref() != null) {
			sqlBuilder.append(" And ent.id_dep_nur = ? ");
			param.addParam(enErOutPatinQuir.getId_dep_nur_ref());
		}
	    
	    return sqlBuilder.toString();
	}
	
	private PagingRtnData<EnErOutPatinQuirDTO> getRtnData(PaginationInfo pageInfo, String sql, SqlParam param) throws BizException {
		PagingServiceImpl<EnErOutPatinQuirDTO> pageQryService = new PagingServiceImpl<EnErOutPatinQuirDTO>();
		return pageQryService.findByPageInfo(new EnErOutPatinQuirDTO(), pageInfo, sql, null, param);
	}

	/**
	 * 获得患者年龄
	 */
	private void getPatAge(EnErOutPatinQuirDTO outDTO) {
		if(!EnValidator.isEmpty(outDTO.getDt_birth())){
			outDTO.setAge_pat(AgeCalcUtil.getAge(new FDate(outDTO.getDt_birth())));
		}
	}

	/**
	 * 获得患者性别名称
	 * @param outDTO
	 * @param udidocDOs
	 * @throws BizException
	 */
	private void getNameSex(EnErOutPatinQuirDTO outDTO, Map<String, String> map) throws BizException {
	    if (outDTO.getId_sex() != null) {
		    	outDTO.setName_sex(map.get(outDTO.getId_sex()));
			}
	}
	
    /**
     * 将bd_udidoc数组转换为map
     */
	private Map<String, String> getUdidocMap(UdidocDO[] udidocDOs) {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < udidocDOs.length; i++) {
			map.put(udidocDOs[i].getId_udidoc(), udidocDOs[i].getName());
		}
		return map;
	}
}
