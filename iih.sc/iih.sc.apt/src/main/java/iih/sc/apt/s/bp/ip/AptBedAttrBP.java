package iih.sc.apt.s.bp.ip;

import iih.bd.res.bed.d.BedAttrDO;
import iih.bd.res.bed.d.BedDTO;
import iih.bd.res.bed.i.IBedAttrDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院手动预约床位特征校验
 * @author zhouliming
 *
 */
public class AptBedAttrBP {
	/**
	 * 床位特征校验
	 * @param aptDTO
	 * @param bedDTO
	 * @throws BizException
	 */
	public Boolean exec(AptIpDTO aptDTO,BedDTO bedDTO) throws BizException{
		if(aptDTO == null || bedDTO == null){
			throw new BizException(IScMsgConst.SC_APT_IP_NO_EXIST_BEDORIP);//申请单或床位为空，请重新操作！
		}
		String id_bed = bedDTO.getId_bed();
		String bedAttrsStr = aptDTO.getBed_attrs_str();
		if(bedAttrsStr == null) return true;
		String[] attrIp = bedAttrsStr.split(" ");//住院申请床位特征结合
		
		//判断申请的床位特征是否和床位的特征一致，如果不一致，给出提示， 用户选择继续预约还是取消预约
		if(attrIp != null && attrIp.length != 0){
			IBedAttrDORService service = ServiceFinder.find(IBedAttrDORService.class);
			BedAttrDO[] bedAttrDO = service.find("id_bed = '"+id_bed+"'", "", FBoolean.FALSE);
			if(bedAttrDO == null || bedAttrDO.length == 0){
				return false;
			}
			StringBuffer attrBed = new StringBuffer();
			for(int i = 0; i < bedAttrDO.length; i++){
				attrBed.append(bedAttrDO[i].getSd_bedattr_tp()+","+bedAttrDO[i].getVal()+(i == bedAttrDO.length-1 ? "" : " "));
			}
			String[] bedAttrs = attrBed.toString().split(" ");//当前选中床位特征集合
			int flag = 0;
			for(int i = 0; i < attrIp.length; i++){
				for(int j = 0; j < bedAttrs.length; j++){
					if(attrIp[i].equals(bedAttrs[j])){
						flag++;
						continue;
					}
				}
			}
			if(flag != attrIp.length){
				return false;
			}
		}
		return true;
	}
}
