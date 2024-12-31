package iih.en.pv.s.bp.ip.ws;

import iih.bd.utils.WsXmlUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpRegAllInfoDTO;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;
import iih.en.pv.out.ws.bean.IpAllInfoBean;
import iih.en.pv.out.ws.bean.IpInfoBean;
import iih.en.pv.out.ws.bean.request.GetIpInfoRequestBean;
import iih.en.pv.out.ws.bean.result.IpAllInfoReturnBean;
import iih.en.pv.s.bp.ip.ws.comm.GetIpInfoUtils;
import iih.en.pv.s.bp.ip.ws.param.GetIpInfoParam;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 查询所有住院信息基类
 * 
 * @author liubin
 *
 */
public abstract class AbstractGetAllIpInfoBP extends AbstractGetIpInfoBaseBP {
	
	private GetIpInfoUtils getIpInfoUtils = new GetIpInfoUtils();
	/**
	 * 查询所有住院信息
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
    public String exec(String requestXML) {
    	//记录日志
    	log(requestXML);
    	IpAllInfoReturnBean returnBean = new IpAllInfoReturnBean();
    	try {
    		//1.解析Xml入参
    		GetIpInfoRequestBean requstParam = deSerializeRequestXml(requestXML);
    		//2.组装入参
    		GetIpInfoParam inParam = assemlyInParam(requstParam);
    		//3.查询住院患者id_ent
            String[] entIds = this.getEntIds(inParam);
            //4.查询住院详细信息
            IpRegInfoDTO[] IpRegInfos = getIpInfoUtils.getIpRegInfoDTO(entIds);//住院和急诊留观数据
            IpRegAllInfoDTO[] IpRegOtherInfoDTO = getIpOtherInfo(entIds);//其余住院信息
            //5.进行数据组装
            Set<IpAllInfoBean> hashSet = this.allaseemly(IpRegInfos,IpRegOtherInfoDTO);
            returnBean.setData(hashSet);
        } catch (BizException e ) {
            returnBean.setException(e);
        }
        return WsXmlUtils.serialize(returnBean);
    }
	//组装住院所有数据
	protected Set<IpAllInfoBean> allaseemly(IpRegInfoDTO[] ipRegInfos, IpRegAllInfoDTO[] ipRegOtherInfoDTO) throws BizException {
		if(EnValidator.isEmpty(ipRegInfos))
    		return null;
		if(EnValidator.isEmpty(ipRegOtherInfoDTO))
    		return null;
		//住院和急诊留观数据
        Map<String, IpInfoBean> dtoMap = getIpInfoUtils.aseemly(ipRegInfos);
        //组装科室病区信息
        Map<String, DeptDO> depMap = getIpInfoUtils.assemlyDeptMap(null, ipRegOtherInfoDTO);
        //组装医生护士信息
        Map<String, PsnDocDO> empMap = getIpInfoUtils.assemlyEmpMap(null, ipRegOtherInfoDTO);
        //组装自定义档案基本信息
        Map<String, UdidocDO> udiMap = getIpInfoUtils.assemlyUdMap(ipRegOtherInfoDTO);
        Set<IpAllInfoBean> hashSet = new HashSet<IpAllInfoBean>(ipRegOtherInfoDTO.length);
    	for(IpRegAllInfoDTO bean : ipRegOtherInfoDTO){
    		IpAllInfoBean ipAllbean = new IpAllInfoBean();
    		if(udiMap != null && !EnValidator.isEmpty(bean.getId_marry()) && udiMap.containsKey(bean.getId_marry())){
    			UdidocDO udi = udiMap.get(bean.getId_marry());
            	//婚姻
            	ipAllbean.setCode_mari_pat(getIpInfoUtils.toString(udi.getCode()));
            }
    		if(udiMap != null && !EnValidator.isEmpty(bean.getId_nation()) && udiMap.containsKey(bean.getId_nation())){
    			UdidocDO udi = udiMap.get(bean.getId_nation());
            	//民族
            	ipAllbean.setSd_nation(getIpInfoUtils.toString(udi.getCode()));
            	ipAllbean.setName_nation(getIpInfoUtils.toString(udi.getName()));
            }
    		if(udiMap != null && !EnValidator.isEmpty(bean.getId_country()) && udiMap.containsKey(bean.getId_country())){
    			UdidocDO udi = udiMap.get(bean.getId_country());
            	//国籍
            	ipAllbean.setSd_country(getIpInfoUtils.toString(udi.getCode()));
            	ipAllbean.setName_country(getIpInfoUtils.toString(udi.getName()));
            }
    		if(udiMap != null && !EnValidator.isEmpty(bean.getId_srcregiontp()) && udiMap.containsKey(bean.getId_srcregiontp())){
    			UdidocDO udi = udiMap.get(bean.getId_srcregiontp());
            	//户籍
            	ipAllbean.setSd_srcregiontp(getIpInfoUtils.toString(udi.getCode()));
            	ipAllbean.setName_srcregiontp(getIpInfoUtils.toString(udi.getName()));
            }
    		if(udiMap != null && !EnValidator.isEmpty(bean.getId_occu()) && udiMap.containsKey(bean.getId_occu())){
    			UdidocDO udi = udiMap.get(bean.getId_occu());
            	//职业
            	ipAllbean.setSd_occu(getIpInfoUtils.toString(udi.getCode()));
            	ipAllbean.setName_occu(getIpInfoUtils.toString(udi.getName()));
            }
    		if(udiMap != null && !EnValidator.isEmpty(bean.getId_educ()) && udiMap.containsKey(bean.getId_educ())){
    			UdidocDO udi = udiMap.get(bean.getId_educ());
            	//文化程度
            	ipAllbean.setSd_educ(getIpInfoUtils.toString(udi.getCode()));
            	ipAllbean.setName_educ(getIpInfoUtils.toString(udi.getName()));
            }
    		if(empMap != null && !EnValidator.isEmpty(bean.getId_emp_phy()) && empMap.containsKey(bean.getId_emp_phy())){
            	PsnDocDO emp = empMap.get(bean.getId_emp_phy());
            	//责任医生
            	ipAllbean.setName_emp_phy(getIpInfoUtils.toString(emp.getName()));
            }
            if(empMap != null && !EnValidator.isEmpty(bean.getId_emp_nur()) && empMap.containsKey(bean.getId_emp_nur())){
            	PsnDocDO emp = empMap.get(bean.getId_emp_nur());
            	//责任护士
            	ipAllbean.setName_emp_nur(getIpInfoUtils.toString(emp.getName()));
            }
            if(empMap != null && !EnValidator.isEmpty(bean.getId_emp_phy_op()) && empMap.containsKey(bean.getId_emp_phy_op())){
            	PsnDocDO emp = empMap.get(bean.getId_emp_phy_op());
            	//入院门诊医生
            	ipAllbean.setCode_emp_opapply(getIpInfoUtils.toString(emp.getName()));
            	ipAllbean.setName_emp_opapply(getIpInfoUtils.toString(emp.getName()));
            }
    		//入院科室
            if(depMap != null && !EnValidator.isEmpty(bean.getId_dep_phyadm()) && depMap.containsKey(bean.getId_dep_phyadm())){
            	DeptDO dept = depMap.get(bean.getId_dep_phyadm());
                //科室code
            	ipAllbean.setDepCode_adm(getIpInfoUtils.toString(dept.getCode()));	
                //科室名称
            	ipAllbean.setDepName_adm(getIpInfoUtils.toString(dept.getName()));	
            }
            //入院病区
            if(depMap != null && !EnValidator.isEmpty(bean.getId_dep_nuradm()) && depMap.containsKey(bean.getId_dep_nuradm())){
            	DeptDO dept = depMap.get(bean.getId_dep_nuradm());
                //病区code
            	ipAllbean.setDepCode_nur_adm(getIpInfoUtils.toString(dept.getCode()));	
                //病区名称
            	ipAllbean.setDepName_nur_adm(getIpInfoUtils.toString(dept.getName()));	
            }
            //出院科室
            if(depMap != null && !EnValidator.isEmpty(bean.getId_dep_out()) && depMap.containsKey(bean.getId_dep_out())){
            	DeptDO dept = depMap.get(bean.getId_dep_out());
                //科室code
            	ipAllbean.setDepCode_disc(getIpInfoUtils.toString(dept.getCode()));	
                //科室名称
            	ipAllbean.setDepName_disc(getIpInfoUtils.toString(dept.getName()));	
            }
            //出院病区
            if(depMap != null && !EnValidator.isEmpty(bean.getId_dep_nur_out()) && depMap.containsKey(bean.getId_dep_nur_out())){
            	DeptDO dept = depMap.get(bean.getId_dep_nur_out());
                //病区code
            	ipAllbean.setDepCode_nur_disc(getIpInfoUtils.toString(dept.getCode()));	
                //病区名称
            	ipAllbean.setDepName_nur_disc(getIpInfoUtils.toString(dept.getName()));	
            }
    		//组装住院和急诊留观数据
            if(dtoMap != null && !EnValidator.isEmpty(bean.getId_ent()) && dtoMap.containsKey(bean.getId_ent())){
            	IpInfoBean dto = dtoMap.get(bean.getId_ent());
            	//病人编码
				ipAllbean.setPatCode(dto.getPatCode());
				//住院号
				ipAllbean.setCode_amr_ip(dto.getCode_amr_ip());
				//住院次数
				ipAllbean.setTimes_ip(dto.getTimes_ip());
				//住院天数
				ipAllbean.setTotalDays(dto.getTotalDays());
				//姓名
				ipAllbean.setName_pat(dto.getName_pat());
				//黑名单标志
				ipAllbean.setFlag_black(dto.getFlag_black());
				//性别
				ipAllbean.setSex(dto.getSex());
				//出生日期
				ipAllbean.setDt_birth_date(dto.getDt_birth_date());
				//电话
				ipAllbean.setMob(dto.getMob());
				//患者分类编码
				ipAllbean.setSd_patca(dto.getSd_patca());
				//患者分类名称
				ipAllbean.setName_patca(dto.getName_patca());
				//价格分类编码
				ipAllbean.setSd_pripat(dto.getSd_pripat());
				//价格分类名称
				ipAllbean.setName_pripat(dto.getName_pripat());
				//医保编码
				ipAllbean.setCode_hp(dto.getCode_hp());
				//医保名称
				ipAllbean.setName_hp(dto.getName_hp());
				//医保卡号
				ipAllbean.setNo_hp(dto.getNo_hp());
				//床号
				ipAllbean.setBedCode(dto.getBedCode());
				//科室
				ipAllbean.setDepCode(dto.getDepCode());
				//科室名称
				ipAllbean.setDepName(dto.getDepName());
				//病区
				ipAllbean.setDepCode_nur(dto.getDepCode_nur());
				//病区名称
				ipAllbean.setDepName_nur(dto.getDepName_nur());
				//入院日期
				ipAllbean.setDt_entry(dto.getDt_entry());
				//住院日期
				ipAllbean.setDt_acpt(dto.getDt_acpt());
				//出院日期
				ipAllbean.setDt_end(dto.getDt_end());
				//护理级别
				ipAllbean.setSd_level_nur(dto.getSd_level_nur());
				//家庭住址
				ipAllbean.setAddr_pat(dto.getAddr_pat());
				//证件类型
				ipAllbean.setIdType(dto.getIdType());
				//证件号
				ipAllbean.setCode_id(dto.getCode_id());
				//状态
				ipAllbean.setStatus(dto.getStatus());
				//结算标志
				ipAllbean.setFg_st(dto.getFg_st());
				//责任护士
				ipAllbean.setCode_emp_nur(dto.getCode_emp_nur());
				//责任医生
				ipAllbean.setCode_emp_phy(dto.getCode_emp_phy());
				//开通手机app标志
				ipAllbean.setFg_mobapp(dto.getFg_mobapp());
				//就诊类型
				ipAllbean.setCode_entp(dto.getCode_entp());
				//就诊编码
				ipAllbean.setCode_ent(dto.getCode_ent());
				//更新时间
				ipAllbean.setUpdate_time(dto.getUpdate_time());
            }
    		//出生日期时分秒
    		ipAllbean.setDt_birth_hms(getIpInfoUtils.toString(bean.getDt_birth_hms()));
    		//工作单位
    		ipAllbean.setWorkunit(getIpInfoUtils.toString(bean.getWorkunit()));
    		//条码号
    		ipAllbean.setBarcode_chis(getIpInfoUtils.toString(bean.getBarcode_chis()));
    		//现住址区县码
    		ipAllbean.setSd_admdiv_addr(getIpInfoUtils.toString(bean.getSd_admdiv_addr()));
    		//信用分类编码
    		ipAllbean.setSd_patcret(getIpInfoUtils.toString(bean.getSd_patcret()));
    		//信用分类名称
    		ipAllbean.setName_patcret(getIpInfoUtils.toString(bean.getName_patcret()));
    		//病情
    		ipAllbean.setSd_level_dise(getIpInfoUtils.toString(bean.getPatient_status()));
    		//营养
    		ipAllbean.setSd_level_nutr(getIpInfoUtils.toString(bean.getSd_level_nutr()));
    		//来院方式
    		ipAllbean.setSd_referalsrc(getIpInfoUtils.toString(bean.getSd_referalsrc()));
    		//离院转归
    		ipAllbean.setSd_gowhere(getIpInfoUtils.toString(bean.getSd_gowhere()));
    		//是否手术标识
    		ipAllbean.setFg_surg(getIpInfoUtils.toString(bean.getFg_surg()));
    		//新生儿标识
    		ipAllbean.setFg_newborn(getIpInfoUtils.toString(bean.getFg_newborn()));
    		//死亡时间
    		ipAllbean.setDt_death(getIpInfoUtils.toString(bean.getDt_death()));
    		//是否在临床路径中
    		ipAllbean.setFg_incp(getIpInfoUtils.toString(bean.getFg_incp()));
    		//临床路径状态
    		ipAllbean.setEu_incp(getIpInfoUtils.toString(bean.getEu_incp()));
    		//门诊诊断编码
    		ipAllbean.setCode_diag_op(getIpInfoUtils.toString(bean.getCode_diag_op()));
    		//门诊诊断名称
    		ipAllbean.setName_diag_op(getIpInfoUtils.toString(bean.getName_diag_op()));
    		//主要联系人姓名
    		ipAllbean.setCont_name(getIpInfoUtils.toString(bean.getCont_name()));
    		//主要联系人电话
    		ipAllbean.setCont_tel(getIpInfoUtils.toString(bean.getCont_tel()));
    		//信用额度
    		ipAllbean.setAmt_cret(getIpInfoUtils.toString(bean.getAmt_cret()));
    		//就诊预交金
    		ipAllbean.setAmt_prepay(getIpInfoUtils.toString(bean.getAmt_prepay()));
    		//就诊未结算费用
    		ipAllbean.setAmt_uncg(getIpInfoUtils.toString(bean.getAmt_uncg()));
    		//欠费下限
    		ipAllbean.setAmt_owelimit(getIpInfoUtils.toString(bean.getAmt_owelimit()));
    		//可报销医保额度
    		ipAllbean.setAmt_hp(getIpInfoUtils.toString(bean.getAmt_hp()));
    		//封账标志
    		ipAllbean.setFg_freeze(getIpInfoUtils.toString(bean.getFg_freeze()));
    		hashSet.add(ipAllbean);
    	}
    	return hashSet;
	}
	/**
	 * 查询所有住院信息
	 * @param entIds
	 * @return
	 * @throws DAException 
	 */
	protected IpRegAllInfoDTO[] getIpOtherInfo(String[] entIds) throws DAException {
		if(EnValidator.isEmpty(entIds))
    		return null;
    	SqlParam param = new SqlParam();
    	StringBuilder sql = new StringBuilder();
    	sql.append(" SELECT PAT.ID_MARRY,");//婚姻id	1
    	sql.append(" ENT.ID_ENT,");//就诊id
    	sql.append(" PAT.DT_BIRTH_HMS DT_BIRTH_HMS,");//-- 出生日期时分秒
    	sql.append(" ENT.CODE CODE_ENT,");//就诊编码
    	sql.append(" PAT.ID_NATION,");//民族id
    	sql.append(" PAT.ID_COUNTRY,");//国籍id	1
    	sql.append(" PAT.ID_SRCREGIONTP,");//户籍类型id		1
    	sql.append(" PAT.ID_OCCU,");//职业id		1
    	sql.append(" PAT.WORKUNIT WORKUNIT,");//工作单位
    	sql.append(" PAT.ID_EDUC,");//文化程度
    	sql.append(" PAT.BARCODE_CHIS BARCODE_CHIS,");//条码号
    	sql.append(" ENT.SD_ADMDIV_ADDR SD_ADMDIV_ADDR,");//现住址区县码
    	sql.append(" CRET.CODE SD_PATCRET,");//信用分类编码
    	sql.append(" CRET.NAME NAME_PATCRET,");//信用分类名称
    	sql.append(" IP.ID_DEP_PHYADM,");//入院科室id
    	sql.append(" IP.ID_DEP_NURADM,");//入院病区id
    	sql.append(" IP.ID_DEP_PHYDISC ID_DEP_OUT,");//出院科室id
    	sql.append(" IP.ID_DEP_NURDISC ID_DEP_NUR_OUT,");//出院病区id
    	sql.append(" IP.SD_LEVEL_DISE PATIENT_STATUS,");//病情
    	sql.append(" IP.SD_LEVEL_NUTR SD_LEVEL_NUTR,");//营养
    	sql.append(" IP.SD_REFERALSRC SD_REFERALSRC,");//来院方式
    	sql.append(" IP.SD_GOWHERE SD_GOWHERE,");//离院转归
    	sql.append(" IP.FG_SURG FG_SURG,");//是否手术标识
	    sql.append(" IP.FG_NEWBORN FG_NEWBORN,");//新手儿标识
	    sql.append(" IP.DT_DEATH DT_DEATH,");//死亡时间
	    sql.append(" IP.FG_INCP FG_INCP,");//是否在临床路径中
	    sql.append(" IP.EU_INCP EU_INCP,");//临床路径状态
	    sql.append(" BDYL.CODE CODE_DIAG_OP,");//门诊诊断编码
	    sql.append(" BDYL.NAME NAME_DIAG_OP,");//门诊诊断名称
	    sql.append(" IP.ID_EMP_OPAPPLY ID_EMP_PHY_OP,");//入院门诊医生id
	    sql.append(" CO.NAME CONT_NAME,");//主要联系人姓名
	    sql.append(" CO.CONTTEL CONT_TEL,");//主要联系人电话
	    sql.append(" ACC.AMT_CRED AMT_CRET,");//信用额度
	    sql.append(" ACC.AMT_PREPAY AMT_PREPAY,");//就诊预交金
	    sql.append(" ACC.AMT_UNCG AMT_UNCG,");//就诊未结算费用
	    sql.append(" ACC.AMT_OWELIMIT AMT_OWELIMIT,");//欠费下限
	    sql.append(" ACC.AMT_HP AMT_HP,");//可报销医保额度
	    sql.append(" ACC.FG_FREEZE FG_FREEZE, ");//封帐标志
	    sql.append(" CASE WHEN ENT.SV > IP.SV THEN ENT.SV ELSE IP.SV END UPDATE_TIME ");//更新时间
	    sql.append(" FROM EN_ENT ENT");
	    sql.append(" INNER JOIN PI_PAT PAT ON PAT.ID_PAT = ENT.ID_PAT");
	    sql.append(" INNER JOIN EN_ENT_IP IP ON IP.ID_ENT = ENT.ID_ENT");
	    sql.append(" LEFT JOIN PI_PAT_CRET CRET ON CRET.ID_PATCRET = PAT.ID_PATCRETTP");
	    sql.append(" LEFT JOIN BD_DI_DEF BDYL ON BDYL.ID_DIDEF = IP.ID_DIAG_OP");
	    sql.append(" LEFT JOIN EN_ENT_CONT CO ON CO.ID_ENT = ENT.ID_ENT AND CO.EU_ENTCONTTP = '1'");
	    sql.append(" LEFT JOIN EN_ENT_ACC ACC ON ACC.ID_ENT = ENT.ID_ENT");     		
    	sql.append(" WHERE ").append(EnSqlUtils.getInSqlByIds(" ENT.ID_ENT ", entIds));
        @SuppressWarnings("unchecked")
		List<IpRegAllInfoDTO> results = (List<IpRegAllInfoDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(IpRegAllInfoDTO.class));
        return EnValidator.isEmpty(results) ? null : results.toArray(new IpRegAllInfoDTO[0]);			   
	}
}
