package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.bp.ippre.GetCheckOepUnStUnPayFeeQry;
import iih.bl.cg.bp.ippre.GetCheckUnIpPreToOepFeeQry;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class GetIpPreToOpCheckBP {
	
	/**
	 * 检查转门诊的预住院患是否可以出院
	 * @param id_ent 就诊id
	 * @param dt_end 出院日期
	 * @return
	 * @throws BizException
	 */
	public BlIpOutPatPriDTO[] exec(String id_ent, FDateTime dt_end) throws BizException {
		
		List<BlIpOutPatPriDTO> blIpOutPatPriDTOArr= new ArrayList<BlIpOutPatPriDTO>();	
		String message="";
		// 1. 预住院费用是否全部转门诊费用
		// 预住院患者住院表中的费用之和为0
				
		if(BlParamValueConst.ENIP0302_OP.equals(BlParams.ENIP0302())){
		
			BlCgIpDO[] blCgIpDOArr=(BlCgIpDO[]) AppFwUtil.getDORstWithDao(new GetCheckUnIpPreToOepFeeQry(id_ent), BlCgIpDO.class);
			if(blCgIpDOArr != null && blCgIpDOArr.length > 0){
				message = "存在：";
				for(BlCgIpDO cgDo : blCgIpDOArr){
					message += (cgDo.getName_srv() + ",");
				}
				message += " 未从预住院转入门诊。";
				GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
				blIpOutPatPriDTOArr.add(blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_IPPreToOepUnAllTruned, FBoolean.FALSE, message));
			}else{
				GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
				blIpOutPatPriDTOArr.add(blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_IPPreToOepUnAllTruned, FBoolean.TRUE, null));
			}
	
			// 2. 预住院转入门诊的费用是否全部结算且收付款
	
			// 门诊的未结算费用之和为0
			
			// 同时满足这两个校验，才可以进行“预住院出院”
			BlCgItmOepDO[] blCgOeDOArr=(BlCgItmOepDO[]) AppFwUtil.getDORstWithDao(new GetCheckOepUnStUnPayFeeQry(id_ent), BlCgItmOepDO.class);
			if(blCgOeDOArr != null && blCgOeDOArr.length > 0){
				message = "存在：";
				for(BlCgItmOepDO cgDo : blCgOeDOArr){
					message += (cgDo.getName_srv() + ",");
				}
				message += " 转入门诊后未结算或未付款。";
				GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
				blIpOutPatPriDTOArr.add(blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_IPPreToOepUnSt, FBoolean.FALSE, message));
			}else{
				GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
				blIpOutPatPriDTOArr.add(blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_IPPreToOepUnSt, FBoolean.TRUE, null));
			}
		}

		return blIpOutPatPriDTOArr.toArray(new BlIpOutPatPriDTO[0]);
	}
}
