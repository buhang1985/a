package iih.pi.concern.concern.s.bp;

import iih.pi.concern.concern.s.bp.qry.PiRecommendIndQry;
import iih.pi.concern.indinfodto.d.IndInfoDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
 
public class GetPiRecommendIndBP {
	
	public IndInfoDTO[] exec(String id_pat) throws BizException   
	{
		if(!isValidate(id_pat))return null;
		
		PiRecommendIndQry qry=new PiRecommendIndQry(id_pat);
		IndInfoDTO[] rtn=(IndInfoDTO[])AppFwUtil.getDORstWithDao(qry, IndInfoDTO.class);
		return rtn;
	}
	
	
	/**
	 * 有效性校验
	 * @param cond
	 * @return
	 */
	private boolean isValidate(String id_pat){
		if(id_pat==null)
			return false;
		return true;
	}

}
