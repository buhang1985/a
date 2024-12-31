package iih.en.pv.s.bp.op;

import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EnVipEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.pv.enres.d.EnExtVipDO;
import iih.en.pv.outpatient.dto.d.RegListDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
/**
 * 设置VIP
 * 
 * @author liubin
 *
 */
public class SetUpVipBP {

    /**
     * 设置VIP
     * 
     * @param entId
     * @param reason
     */
	public RegListDTO exec(String entId, String reason) throws BizException {
		//1.添加EN_ENT_VIP记录
		this.setExtVip(entId, reason);
		//2.保存EN_ENT_TAG标签
		this.setEntTag(entId);
		//3.查询当前操作的对象
		GetSetUpVipListBP getSetUpVipListBP = new GetSetUpVipListBP();
		RegListDTO result = getSetUpVipListBP.findRegListDTOByEntId(entId);
		return result;
	}
	/**
	 * 添加EN_ENT_VIP记录
	 * 
	 * @param entId
	 * @param reason
	 * @throws BizException
	 */
	private void setExtVip(String entId, String reason) throws BizException {
		EnExtVipDO vip = new EnExtVipDO();
		vip.setStatus(DOStatus.NEW);
		vip.setId_ent(entId);
		vip.setReason(reason);
		vip.setDt_b(EnAppUtils.getServerDateTime());
		vip.setFg_valid(FBoolean.TRUE);
		vip.setId_emp_insert(EnContextUtils.getPsnId());
		new EnVipEP().save(new EnExtVipDO[]{vip});
	}
	/**
	 * 保存EN_ENT_TAG标签
	 * 
	 * @param entId
	 * @throws BizException
	 */
	private void setEntTag(String entId) throws BizException {
		new EnPatTpEP().setEntVipTag(entId, FBoolean.TRUE);
	}
}
