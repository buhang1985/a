package iih.bl.hp.bp;

import java.util.HashMap;

import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.FBooleanUtils;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bl.hp.dto.d.DiStatsDTO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
/**
 * 分析诊断信息是否包含慢病和行动不便
 * @param ciDiItmList 诊断列表
 * @author LIM
 *
 */
public class AnalysisDiBP {
	private static final String KEY_DI_DIFFICALT_TO_MOVE = "行动不便";
	public DiStatsDTO exec(FArrayList2 ciDiItmList) {
		DiStatsDTO statsDTO = new DiStatsDTO();
		if (CollectionUtils.isEmpty(ciDiItmList)) {
			return statsDTO;
		}
		for (Object diItmObj : ciDiItmList.toArray()) {
			if (diItmObj == null)
				continue;
			String nameStr="";
			FBoolean fgChronic=FBoolean.FALSE;
			//开单校验和诊断依赖校验所传入对象区分diItmObj
			if(diItmObj.getClass().equals(DiagDefDO.class)){
				DiagDefDO diItm= (DiagDefDO)diItmObj;
				nameStr=diItm.getName();
				fgChronic=diItm.getFg_chronic();
			}
			else if(diItmObj.getClass().equals(CiDiagItemDO.class)){
				CiDiagItemDO diItm= (CiDiagItemDO)diItmObj;
				nameStr=diItm.getId_didef_name();
				fgChronic=diItm.getFg_chronic();
			}else {
				continue;
			}
		
			if (FBooleanUtils.isTrue(fgChronic)) {
				statsDTO.setFg_haschronic(FBoolean.TRUE);// 慢病
			}else if (!StringUtil.isEmpty(nameStr)
					&& nameStr.contains(KEY_DI_DIFFICALT_TO_MOVE)) {
				statsDTO.setFg_hasmovediff(FBoolean.TRUE);// 行动不便
			}
		}
		return statsDTO;
	}
}
