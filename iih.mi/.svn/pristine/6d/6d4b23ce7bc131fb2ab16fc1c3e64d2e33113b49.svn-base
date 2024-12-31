package iih.mi.bd.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.bd.didefcompinfo.d.DiDefCompInfoDTO;
import iih.mi.bd.s.bp.sql.FindDiDefCompInfoQry;
import iih.mi.bd.util.HpIdRecursionUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 诊断对照
 * @author liwenqing 2018.10.29
 *
 */
public class FindDiDefCompInfoBp {

	/**
	 * 诊断对照主方法
	 * @param hpId
	 * @param diDefCodes
	 * @return
	 * @throws BizException 
	 */
	public DiDefCompInfoDTO[] exec(String hpId,String[] diDefCodes) throws BizException{
		if(StringUtil.isEmpty(hpId))
			return null;
		
		String hpIdNew = HpIdRecursionUtil.getHpIdRecursion(hpId);
		
		FindDiDefCompInfoQry qry = new FindDiDefCompInfoQry(hpIdNew,diDefCodes);
		DiDefCompInfoDTO[] rlt = (DiDefCompInfoDTO[]) AppFwUtil
				.getDORstWithDao(qry, DiDefCompInfoDTO.class);		
		
		return rlt;
	}
	
}
