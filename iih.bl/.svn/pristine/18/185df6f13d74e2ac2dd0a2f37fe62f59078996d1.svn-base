package iih.bl.hp.s.bp;


import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.lang3.ArrayUtils;

import iih.bd.base.utils.DateTimeUtils;
import iih.bl.hp.i.IBlHpQryService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.EnDiInfo4BlDTO;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mi.bd.d.DischargedStatusCompDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import iih.mi.bd.i.IMiBdQryService;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
* @author xy.zhou 
* @date 2018年4月10日
* @Description 出院登记入参组装
 */
public class GetOutHosRegBp {
	/**
	 * 
	* @Description: 出院登记入参组装
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return OutHosRegInParamDTO    
	* @throws
	 */
	public OutHosRegInParamDTO exec(String entId) throws BizException {
		OutHosRegInParamDTO oDto=new OutHosRegInParamDTO();
		//获取登记
		IpHpRegistDTO iDto = getIpHpRegistDTO(entId);
		//获取诊断
		EnDiInfo4BlDTO enDiinfo = getEnDiInfo4BlDTO(entId);
		oDto.setBiz_type("1");//交易状态 0.入院1.出院
		oDto.setDt_out(new FDateTime());//出院时间
		//oDto.setDt_out(iDto.getDt_end());//出院时间
		oDto.setDt_in(iDto.getDt_entry());//入院时间
		Integer integer = DateTimeUtils.getNatDaysBetween(iDto.getDt_entry(),iDto.getDt_end());//
		oDto.setDays(integer+1);//实际住院天数
		oDto.setIn_depcode(iDto.getCode_dep_phyadm());//入院科室编码
		oDto.setIn_depname(iDto.getName_dep_phyadm());//入院科室名称
		oDto.setOuthos_depcode(iDto.getCode_dep_phy());//出院院科室编码
		oDto.setOuthos_depname(iDto.getName_dep_phy());//出院科室名称
		oDto.setDoctor_code(iDto.getCode_emp_phy());//医生编码
		oDto.setDoctor_name(iDto.getName_emp_phy());//医生姓名
		oDto.setInhos_status(iDto.getCode_level_diseadm());//入院病情编码
		oDto.setInhos_dicode(iDto.getCode_diag_op());//入院诊断编码
		oDto.setOuthos_dicode(enDiinfo.getId_didef_code());//出院 诊断编码
		oDto.setOuthos_status(this.getOuthos_status(entId));//出院情况及出院状态 
		oDto.setPatname(iDto.getName_pat());//患者姓名
		oDto.setSex(iDto.getCode_sex());//患者性别编码
		//年龄处理
		String str = iDto.getAge();
		String age = str.replace("岁","");
		//oDto.setAge(Integer.valueOf(age));//患者年龄
		oDto.setBirthday(new FDateTime(iDto.getDt_birth().getMillis()));//出生日期
		if(iDto.getDt_birth() != null){
			oDto.setAge(new FDate().getYear() - iDto.getDt_birth().getYear());
		}
		
		/*************************************/
		//获取就诊
		RuralPersonInfoDTO rInfoDTO = getRuralPersonInfoDTO(entId);
		oDto.setChareacode(rInfoDTO.getCh_areacode());//患者参合地编码
		oDto.setInpno(rInfoDTO.getHp_serialno());//住院号
		if (rInfoDTO.getPersoncode().isEmpty()) {
	    oDto.setPersoncode(rInfoDTO.getPatname());//个人编号（患者姓名）
		}else {
		oDto.setPersoncode(rInfoDTO.getPersoncode());//个人编号
		}
		oDto.setIdcard(rInfoDTO.getIdcard());//身份证号
		oDto.setMedicalcode(rInfoDTO.getMedicalcode());//医疗证号
		oDto.setPhone(rInfoDTO.getPatphone());//患者联系电话
		oDto.setAddress(rInfoDTO.getAddress());//身份证号存储
		oDto.setAtonce_sign("1");//即使上报标志
		return oDto;
	}
	/**
	 * 
	* @Description: 获取患者住院登记医保信息
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return IpHpRegistDTO    
	* @throws
	 */
	private IpHpRegistDTO getIpHpRegistDTO(String entId) throws BizException{
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		IpHpRegistDTO ipHpRegistDTO = service.getIpHpRegist(entId);
		return ipHpRegistDTO;
	}
//	/**
//	 * 获取医保转诊单信息
//	* @Description:
//	* @param @param entId
//	* @param @return
//	* @param @throws BizException    
//	* @return EnHpReferralDO[]    
//	* @throws
//	 */
//	private EnHpReferralDO[] getEnHpReferralDOs(String entId) throws BizException{
//		IEnhpreferralRService referralService=ServiceFinder.find(IEnhpreferralRService.class);
//		EnHpReferralDO[] referralDoArr=referralService.findByAttrValString("Id_ent",entId);//转诊单
//		return referralDoArr;
//	}
	/**|
	 * 获取诊断信息
	 * @Title: getEnDiInfo4BlDTO   
	 * @Description: TODO  
	 * @param: @param idEnt
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: EnDiInfo4BlDTO[]      
	 * @throws
	 */
	private EnDiInfo4BlDTO  getEnDiInfo4BlDTO(String idEnt) throws BizException{
		ICiOrdBlService service = ServiceFinder.find(ICiOrdBlService.class);
		EnDiInfo4BlDTO[] dtOs = service.getEnDiInfo4BlDTOs(idEnt);
		EnDiInfo4BlDTO enDiiInfo=null;
		for (EnDiInfo4BlDTO enDiInfo4BlDTO : dtOs) {
			if (enDiInfo4BlDTO.getFg_majdi().booleanValue()) {
				enDiiInfo=enDiInfo4BlDTO;
			}
		}
		return enDiiInfo;
	}
	/**
	 * 
	* @Description:获取就诊信息
	* @param @param idEnt
	* @param @return
	* @param @throws BizException    
	* @return RuralPersonInfoDTO    
	* @throws
	 */
	private RuralPersonInfoDTO getRuralPersonInfoDTO(String idEnt)throws BizException{
		IBlHpQryService service = ServiceFinder.find(IBlHpQryService.class);
		RuralPersonInfoDTO dto = service.getRuralPersonInfo(idEnt);
		return dto;
	}
	/**
	 * 获取出院状态
	 * @param idEnt
	 * @return
	 * @throws BizException 
	 */
	private String getOuthos_status (String idEnt) throws BizException {
		//1、从出院医嘱表中获取患者 出院状态
		StringBuilder sql = new StringBuilder();
		sql.append(" select ap_out.def2 ");
		sql.append(" from ci_order or_der ");
		sql.append(" inner join ci_ap_out ap_out ");
		sql.append("  on ap_out.id_or = or_der.id_or ");
		sql.append(" where or_der.fg_canc = 'N' ");
		sql.append(" and or_der.id_en = ? ");
		sql.append(" and rownum = 1 ");
		sql.append(" order by ap_out.dt_timeout desc ");
		SqlParam param = new SqlParam();
		param.addParam(idEnt);
		
		@SuppressWarnings("unchecked")
		List<String> hisoutstatus =(List<String>)new DAFacade().execQuery(sql.toString(), param ,new ColumnListHandler<String>());		
		if(!ListUtil.isEmpty(hisoutstatus)) {
			IMiBdDirCompQryService service  =ServiceFinder.find(IMiBdDirCompQryService.class);
			//河南新农合报表医保产品ID是HA0002
			DischargedStatusCompDTO[] hpOutStatusArr =service.findDischargedStatusCompByHisCodes(this.getHpId(),hisoutstatus.toArray(new String[0]));
			if(ArrayUtils.isEmpty(hpOutStatusArr))throw new BizException("未查询到患者的医保出院状态");			
			return hpOutStatusArr[0].getCode();
		}	
		return  null;
	}
	
	/**
	 *获取河南新农合医保产品主键
	 * @return
	 * @throws DAException
	 */
	private String getHpId() throws DAException {
		String sql = " select id_hp from bd_hp where code = 'HA0002' ";
		String idHp = (String)new DAFacade().execQuery(sql, new ColumnHandler());
		return idHp;
	}
}
