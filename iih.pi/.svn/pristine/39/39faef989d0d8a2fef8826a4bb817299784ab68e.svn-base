package iih.pi.reg.s.ws;

import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.pi.reg.dto.d.PiPatRepeatDTO;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 丰富重复数据
 * @author ly 2017/09/15
 *
 */
public class RichRepeatPatData {

	/**
	 * 丰富重复数据
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public PiPatRepeatDTO exec(PiPatRepeatDTO dto) throws BizException{
		
		if(dto == null)
			return null;
		
		//性别
		UdidocDO sexDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SEX_CODE, dto.getSd_sex());
		if(sexDoc != null){
			dto.setId_sex(sexDoc.getId_udidoc());
			dto.setName_sex(sexDoc.getName());
		}
		
		//婚姻
		UdidocDO marryDoc = GetUdidocDOUtil.getDocByIE(IPiDictCodeTypeConst.SD_MARRY, dto.getMarry_code());
		if(marryDoc != null){
			dto.setId_marry(marryDoc.getId_udidoc());
			dto.setMarry_code(marryDoc.getCode());
			dto.setMarry_code_name(marryDoc.getName());
		}
		
		//职业
		UdidocDO occuDoc = GetUdidocDOUtil.getDocByIE(IPiDictCodeTypeConst.SD_OCCU, dto.getSd_occu());
		if(occuDoc != null){
			dto.setId_occu(occuDoc.getId_udidoc());
			dto.setSd_occu(occuDoc.getCode());
			dto.setOccupation_type_name(occuDoc.getName());
		}
		
		//民族
		UdidocDO nationDoc = GetUdidocDOUtil.getDocByIE(IPiDictCodeTypeConst.SD_NATION, dto.getSd_nation());
		if(nationDoc != null){
			dto.setId_nation(nationDoc.getId_udidoc());
			dto.setSd_nation(nationDoc.getCode());
			dto.setNation_code_name(nationDoc.getName());
		}
		
		//学历
		UdidocDO educDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_EDUC, dto.getSd_educ());
		if(educDoc != null){
			dto.setId_educ(educDoc.getId_udidoc());
			dto.setSd_educ(educDoc.getCode());
			dto.setEducation_code_name(educDoc.getName());
		}
		
		//国家
		if(!StringUtil.isEmpty(dto.getSd_country())){
			String whereSql = " a0.code = '" + dto.getSd_country() + "' ";
			ICountryzoneRService countrySrv = ServiceFinder.find(ICountryzoneRService.class);
			CountryZoneDO[] czones = countrySrv.find(whereSql, "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(czones)){
				CountryZoneDO zone = czones[0];
				dto.setId_country(zone.getId_countryzone());
				dto.setCountry_code_name(zone.getName());
			}
		}
		
		//联系人
		UdidocDO contDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_CONTTP, dto.getRelation_code());
		if(contDoc != null){
			dto.setId_conttp(contDoc.getId_udidoc());
			dto.setRelation_code(contDoc.getCode());
			dto.setRelation_code_name(contDoc.getName());
		}
		
		return dto;
	}
}
