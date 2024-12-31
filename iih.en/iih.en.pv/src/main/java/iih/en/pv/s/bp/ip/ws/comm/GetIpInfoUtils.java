package iih.en.pv.s.bp.ip.ws.comm;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegAllInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.out.ws.bean.IpInfoBean;
import iih.en.pv.s.bp.ip.CalculateHosDaysBP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询住院患者基本信息基类
 * @author ltf
 *
 */
public class GetIpInfoUtils {
	/**
     * 查询住院和急诊留观详细信息
     * 
     * @param list
     * @param entIds
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	public IpRegInfoDTO[] getIpRegInfoDTO(String[] entIds) throws BizException {
    	if(EnValidator.isEmpty(entIds))
    		return null;
    	StringBuilder sqlSBuilder = this.getSql();
    	SqlParam param = new SqlParam();
        sqlSBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds(" ENT.ID_ENT ", entIds));
        List<IpRegInfoDTO> results = (List<IpRegInfoDTO>) new DAFacade().execQuery(sqlSBuilder.toString(), param, new BeanListHandler(IpRegInfoDTO.class));
        return EnValidator.isEmpty(results) ? null : results.toArray(new IpRegInfoDTO[0]);
    }
    /**
     * 获取查询住院和急诊留观完整sql
     * @return
     */
    public StringBuilder getSql(){
    	StringBuilder sqlField = this.getFieldSql();
    	StringBuilder sql = this.getTableSql(sqlField);
    	return sql;
    }
    /**
     * 获取sql的表连接
     * @param sqlSBuilder
     * @return
     */
    public StringBuilder getTableSql(StringBuilder sqlSBuilder){
        sqlSBuilder.append(" FROM EN_ENT ENT");
        sqlSBuilder.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
        sqlSBuilder.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
        sqlSBuilder.append(" LEFT JOIN  PI_PAT_CA CA ON CA.ID_PATCA = ENT.ID_PATCA");
        sqlSBuilder.append(" LEFT JOIN BD_PRI_PAT PRI_PAT ON PRI_PAT.ID_PRIPAT = ENT.ID_PRIPAT");
        sqlSBuilder.append(" LEFT JOIN BD_HP HP ON HP.ID_HP = ENT.ID_HP ");
        sqlSBuilder.append(" LEFT JOIN EN_ENT_HP ENHP ON ENHP.ID_ENT = ENT.ID_ENT AND ENHP.FG_MAJ = 'Y' ");
        sqlSBuilder.append(" LEFT JOIN BD_DI_DEF DI ON IP.ID_DIAG_OP = DI.ID_DIDEF ");
        return sqlSBuilder;	   
    }
    /**
     * 获取sql字段
     * @return
     */
    public StringBuilder getFieldSql(){
    	StringBuilder sqlSBuilder = new StringBuilder();
    	sqlSBuilder.append(" SELECT ENT.CODE_ENTP AS CODE_ENTP,");//就诊类型
    	sqlSBuilder.append(" ENT.CODE CODE_ENT,");//就诊编码
    	sqlSBuilder.append(" ENT.ID_ENT AS ID_ENT,");//就诊id
        sqlSBuilder.append(" ENT.ID_PAT AS ID_PAT,");//患者id
        sqlSBuilder.append(" ENT.ID_DEP_PHY AS ID_DEP_PHY,");//科室ID
        sqlSBuilder.append(" ENT.ID_DEP_NUR AS ID_DEP_NUR,");//病区ID
        sqlSBuilder.append(" ENT.ID_EMP_PHY AS ID_EMP_PHY,");//责任医生ID
        sqlSBuilder.append(" ENT.ID_EMP_NUR AS ID_EMP_NUR,");//责任护士ID
        sqlSBuilder.append(" ENT.DT_ENTRY AS DT_ENTRY,");//入院登记时间//renzhi 2018年07月26日
        sqlSBuilder.append(" ENT.DT_ACPT,");//住院日期
        sqlSBuilder.append(" ENT.DT_END,");//出院日期
        sqlSBuilder.append(" ENT.FG_ST,");//结算标识
        sqlSBuilder.append(" ENT.ADDR_PAT,");//家庭住址
        sqlSBuilder.append(" PAT.CODE AS CODE_PAT,");//患者编码
        sqlSBuilder.append(" PAT.SD_IDTP AS ID_IDTP,");//证件类型
        sqlSBuilder.append(" PAT.ID_CODE,");//证件号
        sqlSBuilder.append(" PAT.NAME AS NAME_PAT,");//姓名
        sqlSBuilder.append(" PAT.SD_SEX,");//性别
        sqlSBuilder.append(" PAT.DT_BIRTH AS DT_BIRTH,");//出生日期
        sqlSBuilder.append(" PAT.MOB AS TELNO_PAT,");//电话
        sqlSBuilder.append(" IP.CODE_AMR_IP AS CODE_AMR_IP,");//住院号
        sqlSBuilder.append(" IP.TIMES_IP AS TIMES_IP,");//住院次数
        sqlSBuilder.append(" IP.NAME_BED AS NAME_BED,");//床号
        sqlSBuilder.append(" IP.ID_LEVEL_NUR,");//护理登记
        sqlSBuilder.append(" IP.SD_LEVEL_NUR AS SD_LEVEL_NUR,");//护理登记CODE
        sqlSBuilder.append(" IP.SD_STATUS AS SD_STATUS,");//就诊状态
        sqlSBuilder.append(" IP.FG_MOBAPP AS FG_MOBAPP,");//开通手机app标志
        sqlSBuilder.append(" IP.ID_DEP_PHYADM AS ID_DEP_PHYADM,");//入院科室
        sqlSBuilder.append(" IP.ID_DEP_NURADM AS ID_DEP_NURADM,");//入院病区
        sqlSBuilder.append(" DI.CODE AS ID_DIDEF_DIS,");// 门诊诊断编码
        sqlSBuilder.append(" DI.NAME AS NAME_DIDEF_DIS,");//门诊诊断
        sqlSBuilder.append(" CA.CODE AS SD_PATCA,");//患者分类编码
        sqlSBuilder.append(" CA.NAME AS NAME_PATCA,");//患者分类name
        sqlSBuilder.append(" PRI_PAT.CODE AS SD_PRIPAT,");//价格分类code
        sqlSBuilder.append(" PRI_PAT.NAME AS NAME_PRIPAT,");//价格分类name
        sqlSBuilder.append(" HP.CODE AS ID_HP,");//医保编码
        sqlSBuilder.append(" HP.NAME AS NAME_HP,");//医保名称
        sqlSBuilder.append(" ENHP.NO_HP AS CODE_HP, ");//医保卡号
        sqlSBuilder.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
        return sqlSBuilder;
    }
    /**
     * 组装返回值数据
     * 
     * @param ipRegInfos
     * @return
     * @throws BizException
     */
    public Map<String, IpInfoBean> aseemly(IpRegInfoDTO[] ipRegInfos) throws BizException {
    	if(EnValidator.isEmpty(ipRegInfos))
    		return null;
    	Map<String, IpInfoBean> map = new HashMap<String,IpInfoBean>();
    	Map<String, DeptDO> depMap = assemlyDeptMap(ipRegInfos, null);
    	Map<String, PsnDocDO> empMap = assemlyEmpMap(ipRegInfos, null);
    	Map<String, IpRegInfoDTO> bbrMap = assemlyBbrMap(ipRegInfos);
    	CalculateHosDaysBP daysBP = new CalculateHosDaysBP();
    	FDateTime curDate = EnAppUtils.getServerDateTime();
    	for(IpRegInfoDTO dto : ipRegInfos){
    		IpInfoBean bean = new IpInfoBean();
            //住院天数
            FDateTime dt_end = dto.getDt_end() == null ? curDate : dto.getDt_end();
            bean.setTotalDays(toString(daysBP.calculate(dto.getDt_acpt(), dt_end, FBoolean.FALSE)));
            //黑名单标准
            if(bbrMap != null && !EnValidator.isEmpty(dto.getId_pat()) && bbrMap.containsKey(dto.getId_pat())){
            	IpRegInfoDTO bbr = bbrMap.get(dto.getId_pat());
            	bean.setFlag_black(toString(bbr.getCount_bbr()!=null && bbr.getCount_bbr() > 0 ? FBoolean.TRUE : FBoolean.FALSE));
            }else{
            	bean.setFlag_black(toString(FBoolean.FALSE));
            }
            //入院科室
            if(depMap != null && !EnValidator.isEmpty(dto.getId_dep_phyadm()) && depMap.containsKey(dto.getId_dep_phyadm())){
            	DeptDO dept = depMap.get(dto.getId_dep_phyadm());
                //科室code
                bean.setDepCode_adm(toString(dept.getCode()));	
                //科室名称
                bean.setDepName_adm(toString(dept.getName()));	
            }
            //入院病区
            if(depMap != null && !EnValidator.isEmpty(dto.getId_dep_nuradm()) && depMap.containsKey(dto.getId_dep_nuradm())){
            	DeptDO dept = depMap.get(dto.getId_dep_nuradm());
                //科室code
                bean.setDepCode_nur_adm(toString(dept.getCode()));	
                //科室名称
                bean.setDepName_nur_adm(toString(dept.getName()));	
            }
            //当前科室
            if(depMap != null && !EnValidator.isEmpty(dto.getId_dep_phy()) && depMap.containsKey(dto.getId_dep_phy())){
            	DeptDO dept = depMap.get(dto.getId_dep_phy());
                //科室code
                bean.setDepCode(toString(dept.getCode()));	
                //科室名称
                bean.setDepName(toString(dept.getName()));	
            }
            //当前病区
            if(depMap != null && !EnValidator.isEmpty(dto.getId_dep_nur()) && depMap.containsKey(dto.getId_dep_nur())){
            	DeptDO dept = depMap.get(dto.getId_dep_nur());
                //科室code
                bean.setDepCode_nur(toString(dept.getCode()));	
                //科室名称
                bean.setDepName_nur(toString(dept.getName()));	
            }
            if(empMap != null && !EnValidator.isEmpty(dto.getId_emp_phy()) && empMap.containsKey(dto.getId_emp_phy())){
            	PsnDocDO emp = empMap.get(dto.getId_emp_phy());
            	//责任医生
            	bean.setCode_emp_phy(toString(emp.getCode()));
            	bean.setName_emp_phy(toString(emp.getName()));
            }
            if(empMap != null && !EnValidator.isEmpty(dto.getId_emp_phy()) && empMap.containsKey(dto.getId_emp_nur())){
            	PsnDocDO emp = empMap.get(dto.getId_emp_nur());
            	//责任护士
            	bean.setCode_emp_nur(toString(emp.getCode()));
            	bean.setName_emp_nur(toString(emp.getName()));
            }
            //患者编码
            bean.setPatCode(toString(dto.getCode_pat()));	
            //住院号
            bean.setCode_amr_ip(toString(dto.getCode_amr_ip()));	
            //住院次数
            bean.setTimes_ip(toString(dto.getTimes_ip()));	
            //姓名
            bean.setName_pat(toString(dto.getName_pat()));	
            //性别
            bean.setSex(toString(dto.getSd_sex()));
            //出生日期
            bean.setDt_birth_date(toString(dto.getDt_birth()));
            //入院登记时间
            bean.setDt_entry(toString(dto.getDt_entry()));
            //患者分类编码
            bean.setSd_patca(toString(dto.getSd_patca()));	
            //患者分类名称
            bean.setName_patca(toString(dto.getName_patca()));	
            //价格分类编码
            bean.setSd_pripat(toString(dto.getSd_pripat()));	
            //价格分类名称
            bean.setName_pripat(toString(dto.getName_pripat()));	
            //医保编码
            bean.setCode_hp(toString(dto.getId_hp()));	
            //医保名称
            bean.setName_hp(toString(dto.getName_hp()));	
            //医保卡号
            bean.setNo_hp(toString(dto.getCode_hp()));	
            //电话
            bean.setMob(toString(dto.getTelno_pat()));	
            //床号
            bean.setBedCode(toString(dto.getName_bed()));
            //住院日期
            bean.setDt_acpt(toString(dto.getDt_acpt()));
            //出院时间
            bean.setDt_end(toString(dto.getDt_end()));
            //护理级别
            bean.setSd_level_nur(toString(dto.getSd_level_nur()));	
            //家庭住址
            bean.setAddr_pat(toString(dto.getAddr_pat()));	
            //证件类型
            bean.setIdType(toString(dto.getId_idtp()));	
            //证件号
            bean.setCode_id(toString(dto.getId_code()));	
            //状态
            bean.setStatus(toString(dto.getSd_status()));	
            //结算标志
            bean.setFg_st(toString(new FBoolean(FBoolean.TRUE.equals(dto.getFg_st()))));	
            //开通手机app标志
            bean.setFg_mobapp(toString(new FBoolean(FBoolean.TRUE.equals(dto.getFg_mobapp()))));
            //就诊类型
            bean.setCode_entp(toString(dto.getCode_entp()));
            //就诊id
            bean.setId_ent(toString(dto.getId_ent()));
            //就诊编码
            bean.setCode_ent(toString(dto.getCode_ent()));
            //入院门诊诊断编码
            bean.setCode_diag_op(toString(dto.getId_didef_dis()));
            //入院门诊诊断
            bean.setName_diag_op(toString(dto.getName_didef_dis()));
            //更新时间
            bean.setUpdate_time(toString(dto.getUpdate_time()));
            map.put(bean.getId_ent(), bean);
    	}
    	return map;
    }
    /**
     * 组装科室信息
     * 
     * @param ipRegInfos
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	public Map<String, DeptDO> assemlyDeptMap(IpRegInfoDTO[] ipRegInfos, IpRegAllInfoDTO[] ipRegAllInfos) throws BizException {
    	Map<String, DeptDO> map = new HashMap<String, DeptDO>();	
    	//入院科室
    	String[] id_dep_phyadms = EnAppUtils.getKeyPropArrayFromDO("Id_dep_phyadm", ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
    	//入院病区
    	String[] id_dep_nuradms = EnAppUtils.getKeyPropArrayFromDO("Id_dep_nuradm", ipRegInfos != null ? ipRegInfos : ipRegAllInfos);
    	//当前科室
    	String[] Id_dep_phys = EnAppUtils.getKeyPropArrayFromDO("Id_dep_phy", ipRegInfos);
    	//当前病区
    	String[] Id_dep_nurs = EnAppUtils.getKeyPropArrayFromDO("Id_dep_nur", ipRegInfos);
    	//出院科室
    	String[] id_dep_phydiscs = EnAppUtils.getKeyPropArrayFromDO("Id_dep_out", ipRegAllInfos);
    	//出院病区
    	String[] id_dep_nurdiscs = EnAppUtils.getKeyPropArrayFromDO("Id_dep_nur_out", ipRegAllInfos);
    	
    	Set<String> set = new HashSet<String>();
    	if(!EnValidator.isEmpty(id_dep_phyadms))
    		set.addAll(Arrays.asList(id_dep_phyadms));
    	if(!EnValidator.isEmpty(id_dep_nuradms))
    		set.addAll(Arrays.asList(id_dep_nuradms));
    	if(!EnValidator.isEmpty(Id_dep_phys))
    		set.addAll(Arrays.asList(Id_dep_phys));
    	if(!EnValidator.isEmpty(Id_dep_nurs))
    		set.addAll(Arrays.asList(Id_dep_nurs));
    	if(!EnValidator.isEmpty(id_dep_phydiscs))
    		set.addAll(Arrays.asList(id_dep_phydiscs));
    	if(!EnValidator.isEmpty(id_dep_nurdiscs))
    		set.addAll(Arrays.asList(id_dep_nurdiscs));
    	if(set.isEmpty())
    		return map;
    	
    	List<DeptDO> list = (List<DeptDO>) new DAFacade().findByPKs(DeptDO.class, set.toArray(new String[0]));
    	if(!EnValidator.isEmpty(list)){
    		return EnFMapUtils.getMap(DeptDO.ID_DEP, list.toArray(new DeptDO[0]));
    	}
    	return map;
    }
    /**
     * 组装人员信息
     * 
     * @param ipRegInfos
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	public Map<String, PsnDocDO> assemlyEmpMap(IpRegInfoDTO[] ipRegInfos, IpRegAllInfoDTO[] ipRegAllInfos) throws BizException {
    	Map<String, PsnDocDO> map = new HashMap<String, PsnDocDO>();
    	//责任医生
    	String[] phyIds = EnAppUtils.getKeyPropArrayFromDO("Id_emp_phy", ipRegInfos);
    	//责任护士
    	String[] nurIds = EnAppUtils.getKeyPropArrayFromDO("Id_emp_nur", ipRegInfos);
    	//入院门诊医生
    	String[] phyOpIds = EnAppUtils.getKeyPropArrayFromDO("Id_emp_phy_op", ipRegAllInfos); 
    	Set<String> set = new HashSet<String>();
    	if(!EnValidator.isEmpty(phyIds))
    		set.addAll(Arrays.asList(phyIds));
    	if(!EnValidator.isEmpty(nurIds))
    		set.addAll(Arrays.asList(nurIds));
    	if(!EnValidator.isEmpty(phyOpIds))
    		set.addAll(Arrays.asList(phyOpIds));
    	if(set.isEmpty())
    		return map;
    	List<PsnDocDO> list = (List<PsnDocDO>) new DAFacade().findByPKs(PsnDocDO.class, set.toArray(new String[0]));
    	if(!EnValidator.isEmpty(list)){
    		return EnFMapUtils.getMap(PsnDocDO.ID_PSNDOC, list.toArray(new PsnDocDO[0]));
    	}
    	return map;
    }
    /**
     * 组装自定义档案基本信息
     * @param ipRegInfos
     * @param ipRegAllInfos
     * @return
     * @throws DAException 
     */
    @SuppressWarnings("unchecked")
	public Map<String, UdidocDO> assemlyUdMap(IpRegAllInfoDTO[] ipRegAllInfos) throws DAException{
    	Map<String, UdidocDO> map = new HashMap<String, UdidocDO>();
    	//婚姻
    	String[] marryIds = EnAppUtils.getKeyPropArrayFromDO("Id_marry", ipRegAllInfos);
    	//民族
    	String[] nationIds = EnAppUtils.getKeyPropArrayFromDO("Id_nation", ipRegAllInfos);
    	//国籍
    	String[] countryIds = EnAppUtils.getKeyPropArrayFromDO("Id_country", ipRegAllInfos);
    	//户籍
    	String[] srcregiontpIds = EnAppUtils.getKeyPropArrayFromDO("Id_srcregiontp", ipRegAllInfos);
    	//职业
    	String[] occuIds = EnAppUtils.getKeyPropArrayFromDO("Id_occu", ipRegAllInfos);
    	//文化
    	String[] educIds = EnAppUtils.getKeyPropArrayFromDO("Id_educ", ipRegAllInfos);
    	Set<String> set = new HashSet<String>();
    	if(!EnValidator.isEmpty(marryIds))
    		set.addAll(Arrays.asList(marryIds));
    	if(!EnValidator.isEmpty(nationIds))
    		set.addAll(Arrays.asList(nationIds));
    	if(!EnValidator.isEmpty(countryIds))
    		set.addAll(Arrays.asList(countryIds));
    	if(!EnValidator.isEmpty(srcregiontpIds))
    		set.addAll(Arrays.asList(srcregiontpIds));
    	if(!EnValidator.isEmpty(occuIds))
    		set.addAll(Arrays.asList(occuIds));
    	if(!EnValidator.isEmpty(educIds))
    		set.addAll(Arrays.asList(educIds));
    	if(set.isEmpty())
    		return map;
    	List<UdidocDO> list = (List<UdidocDO>) new DAFacade().findByPKs(UdidocDO.class, set.toArray(new String[0]));
    	if(!EnValidator.isEmpty(list)){
    		return EnFMapUtils.getMap(UdidocDO.ID_UDIDOC, list.toArray(new UdidocDO[0]));
    	}
    	return map;
    }
    /**
     * 组装黑名单map
     * 
     * @param ipRegInfos
     * @return
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	public Map<String, IpRegInfoDTO> assemlyBbrMap(IpRegInfoDTO[] ipRegInfos) throws BizException {
    	Map<String, IpRegInfoDTO> map = new HashMap<String, IpRegInfoDTO>();
    	String[] patIds = EnAppUtils.getKeyPropArrayFromDO("Id_pat", ipRegInfos);
    	StringBuilder sqlBuilder = new StringBuilder();
    	sqlBuilder.append(" SELECT BBR.ID_PAT,COUNT(BBR.ID_PAT) AS COUNT_BBR ");
    	sqlBuilder.append(" FROM PI_PAT_BBR BBR WHERE BBR.FG_ACTIVE = 'Y' ");
    	sqlBuilder.append(EnSqlUtils.getInSqlByIds(" AND BBR.ID_PAT ", patIds));
    	sqlBuilder.append(" GROUP BY BBR.ID_PAT ");
    	List<IpRegInfoDTO> list = (List<IpRegInfoDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(IpRegInfoDTO.class));
    	if(!EnValidator.isEmpty(list))
    		return EnFMapUtils.getMap("Id_pat", list.toArray(new IpRegInfoDTO[0]));
    	return map;
    }
    /**
     * 转换为String
     * 
     * @param obj
     * @return
     * @throws BizException
     */
    public String toString(Object obj) throws BizException {
    	if(obj == null)
    		return "";
    	return obj.toString();
    }
}
