package iih.en.pv.s.bp.op;

import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.ep.EnTagtpEP;
import iih.en.comm.ep.EnVipEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.PatTagDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 就诊是否为绿色通道
 * 
 * @author zhengcm
 *
 */
public class CheckIsGcVipBP {
	/**
	 * 就诊是否为绿色通道
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId) throws BizException {
		// 检查参数
 		EnValidator.validateParam("entId", entId);
		// 匹配价格分类和排班服务
		FBoolean isMatch = FBoolean.FALSE;
		PatiVisitDO enDO = new PvEP().getPvByPK(entId);
		if (this.matchPrica(entId) || this.matchScsrv(entId) || this.matchExtVip(entId) ||
				this.matchPatTab(entId) || this.matchDept(enDO) ) {
			isMatch = FBoolean.TRUE;
		}		
		return isMatch;
	}

	/**
	 * 匹配价格分类
	 *
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean matchPrica(String entId) throws BizException {
		boolean isMatch = false;
		// 获取绿色通道支持的患者价格分类参数
		String pricaIds = EnParamUtils.getEnGcvipPriccaIds();
		if (!EnValidator.isEmpty(pricaIds)) {
			// 获取就诊DO,//如果为空，无需查询EN

			PatiVisitDO entDO = new PvEP().getPvByPK(entId);
			if (null != entDO && !EnValidator.isEmpty(entDO.getId_pripat())) {
				if (pricaIds.contains(entDO.getId_pripat())) {
					isMatch = true;
				}
			}
		}	

		return isMatch;
	}

	/**
	 * 匹配排班服务
	 *
	 * @param entId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	private boolean matchScsrv(String entId) throws BizException {
		boolean isMatch = false;
		// 获取绿色通道支持的排班服务
		String scsrvIds = EnParamUtils.getEnGcvipScsrvIds();
		// 如果为空，无需查询OP
		if (!EnValidator.isEmpty(scsrvIds)) {
			// 获取就诊OpDO	
			OutpatientDO opDO = new OpEP().getOpByEntIdWithOutRef(entId);			
			if (null != opDO && !EnValidator.isEmpty(opDO.getId_scsrv())) {
				if (scsrvIds.contains(opDO.getId_scsrv())) {
					isMatch = true;
				}
			}
		}
		return isMatch;
	}
	
	/**
	 * 匹配En_EXT_VIP表
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean matchExtVip(String entId) throws BizException {
		Map<String, FBoolean> extVipMap = new EnVipEP().getIsExtVipMap(new String[] {entId});
		if(extVipMap == null || extVipMap.isEmpty())
			return false;
		return FBoolean.TRUE.equals(extVipMap.get(entId));
	}
	
	/**
	 * 匹配患者标签vip标识
	 *
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean matchPatTab(String entId) throws BizException {
		boolean isMatch = false;
		//1.根据就诊id获取患者标签对象
		String[] strs = {entId};
		PatTagDTO[] patTagDTOS = new EnTagtpEP().getTagTps(strs);
		//2.判断是否有vip标识
		if(!EnValidator.isEmpty(patTagDTOS)){
			for (PatTagDTO patTagDTO : patTagDTOS) {
				if (IBdFcDictCodeConst.SD_TAGTP_VIP.equals(patTagDTO.getSd_tagtp())) {
					return true;
				}
			}
		}
		return isMatch;
	}
	
	/**
	 * 匹配科室或病区
	 *
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean matchDept(PatiVisitDO entDO) throws BizException {
		boolean isMatch = false;
		if(entDO == null)
			return isMatch; 
		// 获取VIP科室或病区
		String depIds = EnParamUtils.getEnGcvipDepIds();
		if (!StringUtil.isEmptyWithTrim(depIds)) {
			if (!StringUtil.isEmptyWithTrim(entDO.getId_dep_phy())) {
				if (depIds.contains(entDO.getId_dep_phy())) {
					isMatch = true;
				}
			}
			if (!StringUtil.isEmptyWithTrim(entDO.getId_dep_nur())) {
				if (depIds.contains(entDO.getId_dep_nur())) {
					isMatch = true;
				}
			}
		}	
		return isMatch;
	}
	
}
