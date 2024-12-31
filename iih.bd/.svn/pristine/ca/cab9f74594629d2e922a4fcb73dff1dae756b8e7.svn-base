package iih.bd.pp.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.dto.itmnoline.d.BdItmNoOnlineHitDTO;
import iih.bd.pp.itmpaynoonline.d.ItmpaynoonlineDO;
import iih.bd.pp.itmpaynoonline.i.IItmpaynoonlineRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 命中非线上支付服务项目
 * @author ly 2018/05/16
 *
 */
public class BdHitNoOnlineItmBP {

	/**
	 * 命中非线上支付服务项目
	 * @param dtos 服务信息
	 * @return
	 * @throws BizException
	 */
	public BdItmNoOnlineHitDTO[] exec(BdItmNoOnlineHitDTO[] dtos) throws BizException{
		
		if(ArrayUtil.isEmpty(dtos))
			return null;
		
		List<String> srvIdList = new ArrayList<String>();
		for (BdItmNoOnlineHitDTO dto : dtos) {
			srvIdList.add(dto.getId_srv());
		}
		
		IItmpaynoonlineRService rService = ServiceFinder.find(IItmpaynoonlineRService.class);
		ItmpaynoonlineDO[] onlineDos = rService.findByAttrValStrings(
				ItmpaynoonlineDO.ID_SRV, srvIdList.toArray(new String[0]));
		
		if(ArrayUtil.isEmpty(onlineDos))
			return null;
		
		List<BdItmNoOnlineHitDTO> hitList = new ArrayList<BdItmNoOnlineHitDTO>();
		for (BdItmNoOnlineHitDTO dto : dtos) {
			for (ItmpaynoonlineDO onlineDO : onlineDos) {
				
				//服务未命中
				if(!dto.getId_srv().equals(onlineDO.getId_srv()))
					continue;
				
				//科室未命中
				if(StringUtil.isEmpty(onlineDO.getId_dep_or()) || 
						!onlineDO.getId_dep_or().contains(dto.getId_dep_or()))
					continue;
				
				//患者分类未命中
				if(StringUtil.isEmpty(onlineDO.getId_patca()) || 
						!onlineDO.getId_patca().contains(dto.getId_patca()))
					continue;
				
				//就诊类型未命中
				FBoolean fgEntp = FBoolean.FALSE;
				switch (dto.getCode_entp()) {
				case IBdFcDictCodeConst.SD_CODE_ENTP_OP:
					fgEntp = onlineDO.getFg_entp_op();
					break;
				case IBdFcDictCodeConst.SD_CODE_ENTP_ET:
					fgEntp = onlineDO.getFg_entp_er();
					break;
				case IBdFcDictCodeConst.SD_CODE_ENTP_PE:
					fgEntp = onlineDO.getFg_entp_pe();
					break;
				case IBdFcDictCodeConst.SD_CODE_ENTP_IP:
					fgEntp = onlineDO.getFg_entp_ip();
					break;
				case IBdFcDictCodeConst.SD_CODE_ENTP_FA:
					fgEntp = onlineDO.getFg_entp_fm();
					break;
				}
				
				if(!FBoolean.TRUE.equals(fgEntp))
					continue;
				
				hitList.add(dto);
			}
		}
		
		return hitList.toArray(new BdItmNoOnlineHitDTO[0]);
	}
}
