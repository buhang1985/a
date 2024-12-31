package iih.mi.bd.s.bp;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.mi.bd.d.DosageCompInfoDTO;
import iih.mi.bd.s.bp.sql.FindDosageCompInfoQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 
 * 医保剂型对照查询
 * @author ly 2018/09/13
 *
 */
public class FindDosageCompInfoBP {

	/**
	 * 查询剂型对照
	 * @param hpId 医保id
	 * @param dosageCodes 剂型编码数组
	 * @return 对照数据
	 * @throws BizException
	 */
	public DosageCompInfoDTO[] exec(String hpId, String[] dosageCodes) throws BizException {
		
		if(StringUtil.isEmpty(hpId))
			return null;
		
		String hpIdNew = this.getHpIdRecursion(hpId);
		
		FindDosageCompInfoQry qry = new FindDosageCompInfoQry(hpIdNew,dosageCodes);
		DosageCompInfoDTO[] rlt = (DosageCompInfoDTO[]) AppFwUtil
				.getDORstWithDao(qry, DosageCompInfoDTO.class);		
		
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