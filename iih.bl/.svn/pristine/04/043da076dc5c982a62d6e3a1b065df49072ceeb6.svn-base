package iih.bl.cg.s.bp.ip.ipoutpatprice;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.cxf.common.util.StringUtils;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetCheckTotalFeeQry;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/*
 * 检索是否有总数为负的项目
 */
public class GetCheckTotalFeeBP {
	/**
	 * 检索是否有总数为负的项目
	 * @param id_ent 就诊id
	 * @param dt_end 出院日期
	 * @return
	 * @throws BizException
	 */
	public BlIpOutPatPriDTO exec(String id_ent, FDateTime dt_end) throws BizException {
		BlIpOutPatPriDTO blIpOutPatPriDTO= new BlIpOutPatPriDTO();	
		String message="";
		//1.查询总数为负数的数据
		BlCgIpDO[] blCgIpDOArr=(BlCgIpDO[]) AppFwUtil.getDORstWithDao(new GetCheckTotalFeeQry(id_ent), BlCgIpDO.class);
		if(!ArrayUtils.isEmpty(blCgIpDOArr)){
			for(BlCgIpDO blCgIpDO:blCgIpDOArr){
				message +=BlMsgUtils.GetCheckTotalFeeMsg(blCgIpDO.getName_srv(), blCgIpDO.getQuan());
			}			
		}
		//2.组织返回数据
		GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
		if(!StringUtils.isEmpty(message)){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_TOTALFEE, FBoolean.FALSE, message);
		}else{
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_TOTALFEE, FBoolean.TRUE, message);
		}
		return blIpOutPatPriDTO;
	}
}
