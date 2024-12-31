package iih.bl.cg.bp.ip;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bl.cg.bp.ip.qry.GetIpInccaItmSumQry;
import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

/**
 * 
 * @author
 *
 */
public class GetIpInccaItmSumBP {
	/**
	 * 获取住院账单项汇总信息
	 * @param entId 就诊id
	 * @param fgSt 是否结算
	 * @param stId 结算id
	 * @return 账单项集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlInccaItmDTO[] exec(String entId,FBoolean fgSt,String stId) throws BizException{
		if(FBoolean.FALSE.equals(fgSt)){
			stId="~";
		}		
		//查询该患者该次就真的费用信息,如果未结算查询id_st="~"的所有数据
		BlInccaItmDTO[] BlInccaItmDTOs = (BlInccaItmDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpInccaItmSumQry(entId,fgSt,stId), BlInccaItmDTO.class);
		return BlInccaItmDTOs;
	}
}
