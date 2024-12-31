package iih.bl.cg.s.bp.ip.ipoutpatprice;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetCheckSrvDataDayQry;
import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetCheckSrvDataQry;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.params.BlParams;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;

import org.apache.commons.lang.ArrayUtils;
import org.apache.cxf.common.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
/**
 * 校验按时间收费的项目，不能超过在院时间
 * @author LIM
 *
 */
public class GetCheckSrvDataBP {
	public BlIpOutPatPriDTO exec(String id_ent, FDateTime dt_end) throws BizException {
		GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
		BlIpOutPatPriDTO blIpOutPatPriDTO= new BlIpOutPatPriDTO();
		String message="";
		String sIdSrvListHour = BlParams.BLCG0018();
		String sIdSrvListMinutes = BlParams.BLCG0019();
		//获取按分钟、小时计算数量大于在院时间的服务
		if (!StringUtils.isEmpty(sIdSrvListHour) || !StringUtils.isEmpty(sIdSrvListMinutes)) {
			BlCgIpDO[] blCgIpDOArr = (BlCgIpDO[]) AppFwUtil.getDORstWithDao(
					new GetCheckSrvDataQry(id_ent, dt_end, sIdSrvListHour, sIdSrvListMinutes), BlCgIpDO.class);
			if (ArrayUtils.isNotEmpty(blCgIpDOArr)) {
				for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
					message += BlMsgUtils.GetCheckSrvDataMsg(blCgIpDO.getName_srv(), blCgIpDO.getQuan(),
							blCgIpDO.getNote());
				}
			}
		}
		
		//获取按天计算的服务ID
		String sIdSrvList = BlParams.BLCG0017();
		if(!StringUtils.isEmpty(sIdSrvList)){
			//获取按天计算数量大于在院时间的服务
			BlCgIpDO[] blCgIpDOArr2 = (BlCgIpDO[]) AppFwUtil.getDORstWithDao(new GetCheckSrvDataDayQry(id_ent,dt_end, sIdSrvList), BlCgIpDO.class);		
			if(ArrayUtils.isNotEmpty(blCgIpDOArr2)){
				for(BlCgIpDO blCgIpDO: blCgIpDOArr2){
					message += BlMsgUtils.GetCheckSrvDataMsg(blCgIpDO.getName_srv(), blCgIpDO.getQuan(),blCgIpDO.getNote());
				}
			}
		}
		if(!StringUtils.isEmpty(message)){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_TOTALQUAN, FBoolean.FALSE, message);
		}else{
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_TOTALQUAN, FBoolean.TRUE, message);
		}
		return blIpOutPatPriDTO;
	}
}
