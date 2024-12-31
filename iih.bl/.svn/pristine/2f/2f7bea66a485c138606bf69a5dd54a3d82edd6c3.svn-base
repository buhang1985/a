package iih.bl.cg.s.bp.ip;

import iih.bl.cg.dto.d.BlIpPatDTO;
import iih.en.pv.dto.d.TransDepPatDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import sun.print.resources.serviceui;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 转科患者查询
 * @author xy.zhou
 * @date 2018年6月27日
 */
public class BlIPFindOutPatLIstInHosBp {
	/**
	 * 
	 * @Title: exec   
	 * @Description: 转科患者就诊信息
	 * @param: @param idOldNur
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlIpPatDTO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	public BlIpPatDTO [] exec(String idOldNur)throws BizException{
		
		//调用就诊查询
		IEn4BlQryService iEn4BlQryService=ServiceFinder.find(IEn4BlQryService.class);
		TransDepPatDTO[] transDepPatInfos = iEn4BlQryService.getTransDepPatInfo(idOldNur);
		//赋值
		BlIpPatDTO [] blIpPatDTOs=new BlIpPatDTO[transDepPatInfos.length];
		for (int i = 0; i < transDepPatInfos.length; i++) {
			BlIpPatDTO blIpPatDTO=new BlIpPatDTO();
			blIpPatDTO.setId_ent(transDepPatInfos[i].getId_ent());
			blIpPatDTO.setCode_ent(transDepPatInfos[i].getEnt_code());
			blIpPatDTO.setId_pat(transDepPatInfos[i].getId_pat());
			blIpPatDTO.setName_pat(transDepPatInfos[i].getName_pat());
			blIpPatDTO.setCode_pat(transDepPatInfos[i].getCode_pat());
			blIpPatDTO.setName_bed(transDepPatInfos[i].getName_bed());
			blIpPatDTO.setCode_amr_ip(transDepPatInfos[i].getCode_amr_ip());
			blIpPatDTO.setDt_entry(transDepPatInfos[i].getDt_entry());
			blIpPatDTO.setName_dep_nur(transDepPatInfos[i].getName_dep_nur());
			blIpPatDTO.setId_dep_nur(transDepPatInfos[i].getId_dep_nur());
			blIpPatDTO.setName_dep_phy(transDepPatInfos[i].getName_dep_phy());
			blIpPatDTO.setId_dep_phy(transDepPatInfos[i].getId_dep_phy());
			blIpPatDTO.setFg_ip(FBoolean.TRUE);
			blIpPatDTOs[i]=blIpPatDTO;
		}
		return blIpPatDTOs;
	}
}
