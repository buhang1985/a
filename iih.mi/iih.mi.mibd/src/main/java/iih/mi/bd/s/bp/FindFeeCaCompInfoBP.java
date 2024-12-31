package iih.mi.bd.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.bd.d.FeeCaCompInfoDTO;
import iih.mi.bd.s.bp.sql.FindFeeCaCompInfoQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 
 * 医保费别对照查询
 * @author ly 2018/09/13
 *
 */
public class FindFeeCaCompInfoBP {

	/**
	 * 查询费别对照
	 * @param hpId 医保id
	 * @param inccaId 票据分类id
	 * @param codeInccaItms 票据分类项目编码数组
	 * @return 对照数据
	 * @throws BizException
	 */
	public FeeCaCompInfoDTO[] exec(String hpId, String inccaId, String[] codeInccaItms) throws BizException{
	
		if(StringUtil.isEmpty(hpId))
			return null;
		
		String hpIdNew = this.getHpIdRecursion(hpId);
		
		FindFeeCaCompInfoQry qry = new FindFeeCaCompInfoQry(hpIdNew, inccaId, codeInccaItms);
		FeeCaCompInfoDTO[] rlt = (FeeCaCompInfoDTO[]) AppFwUtil
				.getDORstWithDao(qry, FeeCaCompInfoDTO.class);		
		
		return rlt;
	}
	
	/**
	 * 递归获取复用医保计划id
	 * @param hpId
	 * @return
	 */
	private String getHpIdRecursion(String hpId) throws BizException {
		String idPar = this.getIdRef(hpId);
		if (!StringUtil.isEmpty(idPar)) {
			return getHpIdRecursion(idPar);
		}
		return hpId;
	}
	
	/**
	 * 获取复用医保主键
	 * 
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);

		return hpdo!=null?hpdo.getId_refhp():"";
	}
}
