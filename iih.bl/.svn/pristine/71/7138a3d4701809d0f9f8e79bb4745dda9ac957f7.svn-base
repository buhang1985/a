package iih.bl.hp.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import iih.en.pv.enhpreferral.i.IEnhpreferralRService;
import iih.en.pv.hpdto.d.IpHpRegistDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/** 医保患者就诊信息
 * @author yangyang
 * @date 2018-03-20
 */
public class GetRuralEntPersonInfoBp {
	public RuralPersonInfoDTO exec(String strIdEnt) throws BizException
	{
		RuralPersonInfoDTO personInfo=new RuralPersonInfoDTO();
		//1、获取该患者医保登记信息
		IHpentcodeRService rservice=ServiceFinder.find(IHpentcodeRService.class);
		String strWhere=String.format(" id_ent='%s' and fg_active='Y'", strIdEnt);
		HpEntCodeDO[] hpEntCodeDoArr=rservice.find(strWhere, "", FBoolean.TRUE);
	
		//2、查询农合新益华患者转诊单信息
		IEnhpreferralRService referralService=ServiceFinder.find(IEnhpreferralRService.class);
		EnHpReferralDO[] referralDoArr=referralService.findByAttrValString("Id_ent",strIdEnt);
		//3、拼装数据
		if(ArrayUtils.isEmpty(hpEntCodeDoArr)){
			throw new BizException("未找到该患者的医保登记信息，请确认已经做过医保登记！");
		}else if(!ArrayUtils.isEmpty(referralDoArr)&&!ArrayUtils.isEmpty(referralDoArr)){//新农合。新益华
			//转诊单
			personInfo.setId_ent(strIdEnt);
			personInfo.setPatname(referralDoArr[0].getPatname());//患者姓名
			personInfo.setSexcode(referralDoArr[0].getSd_sex());//患者性别代码
			personInfo.setSexname(referralDoArr[0].getName_sex());//患者性别名称
			personInfo.setIdcard(referralDoArr[0].getIdcard());//身份证号		
			personInfo.setMedicalcode(referralDoArr[0].getMedicalcode());//医疗证号
			personInfo.setEnt_code(referralDoArr[0].getEnt_code());//住院号
			personInfo.setDt_entry(referralDoArr[0].getDt_entry());//入院日期
			personInfo.setCh_areacode(referralDoArr[0].getChareacode());//参合地区编码
			personInfo.setCh_areaname(referralDoArr[0].getChareaname());//参合地区名称
			personInfo.setPersoncode(referralDoArr[0].getPersoncode());//个人编号
			personInfo.setPatphone(referralDoArr[0].getPatphone());//患者电话
			personInfo.setAddress(referralDoArr[0].getIdcardstore());//地址
			//医保登记流水号
			personInfo.setHp_serialno(hpEntCodeDoArr[0].getHp_ent_serial_no());
			//住院医保登记信息
			IEnOutQryService ieService=ServiceFinder.find(IEnOutQryService.class);
			IpHpRegistDTO ipHpRegistDTO = ieService.getIpHpRegist(strIdEnt);
			FDateTime dt_end = ipHpRegistDTO.getDt_end();
			personInfo.setDt_end(dt_end);//出院日期
			// TODO 根据需要添加字段
			
//			//调用根据就诊类型编码集合查询就诊类型基础信息集合接口
//			String id_hp=ipHpRegistDTO.getId_hp();
//			String code=ipHpRegistDTO.getCode_entp();
//			EnTpBaseInfoDTO[] findEnTpsByCodes=null;
//			if(id_hp!=null&&code!=null){
//				IMiBdQryService imibService = ServiceFinder.find(IMiBdQryService.class);
//				String[]code_enntp={code};
//				findEnTpsByCodes = imibService.findEnTpsByCodes(id_hp,code_enntp);
//			}
		}else if(ArrayUtils.isEmpty(hpEntCodeDoArr)&&!ArrayUtils.isEmpty(referralDoArr)&&
				!hpEntCodeDoArr[0].getHp_ent_serial_no().isEmpty()){   //省市
			//医保登记流水号
			personInfo.setHp_serialno(hpEntCodeDoArr[0].getHp_ent_serial_no());
		}else {
			throw new BizException("缺少转诊单数据！");
		}
		return personInfo;
	}
}
