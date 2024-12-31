package iih.ci.ord.s.ems.utils;

import java.util.List;

import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

public class OrderEmsHpInfoUtils {
	/**
	 * 废弃，改为使用接口 ICiOrdMedicalInsuranceService。getSpecialDiseasesJudgeRst
	 * 判断特殊病是否需要提示信息
	 * @param ctx
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public static String judgeSpecillFlag(CiEnContextDTO ctx,String id_mm) throws BizException{
		IBLCancelSettlement blservice = CiOrdAppUtils.getIBLCancelSettlement();
		ICiOrdQryService ciordqryservice = CiOrdAppUtils.getCiOrdQryService();
		//Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		String info = "";
		//非医保或患者非特病返回false
		if(CiOrdUtils.isEmpty(ctx.getId_hp())||ctx.getFg_hpspcl()==null||!ctx.getFg_hpspcl().booleanValue()) return "";
		List<CijudgeSpecillDTO> specils = blservice.JudgeSpecillFlag(ctx.getNo_hp(), ctx.getId_hp(), new String[]{id_mm});
		if(!CiOrdUtils.isEmpty(specils)&&specils.size()>0){
			CijudgeSpecillDTO specill =  specils.get(0);
			FMap2 diagmap = specill.getDiagmap();
			if(!CiOrdUtils.isEmpty(specill.getFg_mmspecill())&&specill.getFg_mmspecill().booleanValue()&&!CiOrdUtils.isEmpty(diagmap)){
				EntDiDO[] entdis = ciordqryservice.getEntDiDOList(ctx.getId_en());
				if(!CiOrdUtils.isEmpty(entdis)){
					boolean flag = true;
					for(EntDiDO entdi : entdis){
						String code_di = entdi.getCode_didef_dis();
						if(diagmap.containsKey(code_di)){
							flag =  false;
							break;
						}
					}
					if(flag){
						return getMapName(diagmap);
					}
					return info;
				}
			}
		}
		return info;
	}	
	/**
	 * 特殊病诊断集合
	 * @param diagmap
	 * @return
	 */
	private static String getMapName(FMap2 diagmap){
		 StringBuffer sb = new StringBuffer();
		if(diagmap != null){
			for(Object key:diagmap.keySet()){
				sb.append(key+" " +diagmap.get(key)+", ");
			}
		}
		return sb.toString();
	}
}
