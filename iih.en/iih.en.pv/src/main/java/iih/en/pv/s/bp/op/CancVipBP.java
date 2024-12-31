package iih.en.pv.s.bp.op;

import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EnVipEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.pv.enres.d.EnExtVipDO;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
/**
 * 取消VIP
 * 
 * @author liubin
 *
 */
public class CancVipBP {
    /**
     * 取消VIP
     * 
     * @param entId
     */
	public RegListDTO exec(String entId) throws BizException {
		//1.修改EN_ENT_VIP记录
		this.setExtVip(entId);
		//2.修改EN_ENT_TAG标签
		this.setEntTag(entId);
		//3.查询当前操作的对象
		GetSetUpVipListBP getSetUpVipListBP = new GetSetUpVipListBP();
		RegListDTO result = getSetUpVipListBP.findRegListDTOByEntId(entId);
		return result;
	}
	/**
	 * 修改EN_ENT_VIP记录
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void setExtVip(String entId) throws BizException {
		EnVipEP ep = new EnVipEP();
		EnExtVipDO[] extVips = ep.getValidExiVip(entId);
		if(ArrayUtil.isEmpty(extVips))
			return;
		for(EnExtVipDO vip : extVips){
			vip.setStatus(DOStatus.UPDATED);
			vip.setDt_canc(EnAppUtils.getServerDateTime());
			vip.setFg_valid(FBoolean.FALSE);
			vip.setId_emp_canc(EnContextUtils.getPsnId());
		}
		new EnVipEP().save(extVips);
	}
	/**
	 * 修改EN_ENT_TAG标签
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void setEntTag(String entId) throws BizException {
		new EnPatTpEP().setEntVipTag(entId, FBoolean.FALSE);
	}
}
