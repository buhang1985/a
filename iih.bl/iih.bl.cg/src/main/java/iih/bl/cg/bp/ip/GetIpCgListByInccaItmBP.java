package iih.bl.cg.bp.ip;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bl.cg.bp.ip.qry.GetIpCgListByInccaItmQry;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.bd.d.ThreeDirCompInfoDTO;
import iih.mi.bd.i.IMiBdDirCompQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * @author 
 *
 */
public class GetIpCgListByInccaItmBP {
	/**
	 * 获取账单项的记账信息
	 * 
	 * @param entId 就诊id
	 * @param inccaItmCode 账单项编码
	 * @param cgDate 记账日期
	 * @return
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlIpCgDTO[] exec(String entId,BlInccaItmDTO inccaItmDto) throws BizException{
		
		BlIpCgDTO[] BlIpCgDTOs = (BlIpCgDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpCgListByInccaItmQry(entId,inccaItmDto), BlIpCgDTO.class);
		//设置收费等级
		if(StringUtil.isEmpty(entId)){
			return BlIpCgDTOs;
		}
		//查询患者医保计划
		String hpId="";
		PatiVisitDO entInfo =(PatiVisitDO) new DAFacade().findByPK(PatiVisitDO.class, entId, new String[]{PatiVisitDO.ID_HP});
		if(StringUtil.isEmpty(entInfo.getId_hp())){
			//查询默认医保计划
			List<HPDO> hpList=(List<HPDO>)new DAFacade().findByCond(HPDO.class, "fg_default='Y'", new String[]{HPDO.ID_HP});
			if(!ListUtil.isEmpty(hpList)){
				hpId=hpList.get(0).getId_hp();
			}
		}else{
			hpId=entInfo.getId_hp();
		}

		if(StringUtil.isEmpty(hpId)){
			return BlIpCgDTOs;
		}
		
		List<String> srvList=new ArrayList<>();
		List<String> mmList=new ArrayList<>();
		
		for (BlIpCgDTO blIpCgDTO : BlIpCgDTOs) {
			if(FBoolean.TRUE.equals(blIpCgDTO.getFg_mm())){
				mmList.add(blIpCgDTO.getId_mm());
			}else{
				srvList.add(blIpCgDTO.getId_srv());
			}
		}
		IMiBdDirCompQryService dirCompService=ServiceFinder.find(IMiBdDirCompQryService.class);
		ThreeDirCompInfoDTO[] dirArr = dirCompService.findThreeDirCompByHisSrvIdsAndDrugIds(hpId,srvList.toArray(new String[0]),mmList.toArray(new String[0]));
		if(ArrayUtil.isEmpty(dirArr)){
			return BlIpCgDTOs;
		}
		//循环给收费等级赋值
		for (BlIpCgDTO blIpCgDTO : BlIpCgDTOs) {
			for (ThreeDirCompInfoDTO threeDirCompInfoDTO : dirArr) {
				if(FBoolean.TRUE.equals(blIpCgDTO.getFg_mm())){
					if(threeDirCompInfoDTO.getId_drug().equals(blIpCgDTO.getId_mm())){
						blIpCgDTO.setSd_hpsrvtp(threeDirCompInfoDTO.getSd_hpsrvtp());
						break;
					}
				}else{
					if(threeDirCompInfoDTO.getId_srv().equals(blIpCgDTO.getId_srv())){
						blIpCgDTO.setSd_hpsrvtp(threeDirCompInfoDTO.getSd_hpsrvtp());
						break;
					}
				}
			}
		}
		
		return BlIpCgDTOs;
	}
}
