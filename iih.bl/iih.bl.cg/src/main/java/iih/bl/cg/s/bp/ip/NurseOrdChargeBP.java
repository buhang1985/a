package iih.bl.cg.s.bp.ip;

import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.i.IPripatRService;
import iih.bl.cg.dto.d.IpCgPatDTO;
import iih.bl.cg.s.bp.ip.backcg.ChargeNurseBP;
import iih.bl.cg.s.bp.ip.backcg.GetNeedCgPatListBP;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 护理医嘱计费
 * @author yankan
 * @since 2017-11-06
 *
 */
public class NurseOrdChargeBP {
	/**
	 * 护理医嘱计费
	 * @param patId 患者ID
	 * @param ordIds 医嘱ID集合
	 * @param cgEndTime 记账截止时间
	 * @throws BizException
	 * @author yankan
	 */
	public void exec(String patId,String[] ordIds,FDateTime cgEndTime) throws BizException{
		//1、获取患者住院信息
		GetNeedCgPatListBP getPatListBP = new GetNeedCgPatListBP();
		List<IpCgPatDTO> patList = getPatListBP.exec(cgEndTime, patId, null);
		if(ListUtil.isEmpty(patList)){
			return;
		}
		IpCgPatDTO patInfo = patList.get(0);
		
		//2、获取患者价格分类
		PripatAggDO pripatAgg = this.getPriPat(patInfo.getId_pripat());
		if(pripatAgg==null){
			throw new BizException("患者价格分类不存在！");
		}
		
		//3、记账
		ChargeNurseBP chargeBP = new ChargeNurseBP();
		chargeBP.exec(patInfo, pripatAgg, cgEndTime, ordIds);
	}
	/**
	 * 获取患者价格分类
	 * @param priPatId 患者价格分类ID
	 * @return
	 * @throws BizException
	 */
	private PripatAggDO getPriPat(String priPatId) throws BizException{
		IPripatRService pripatRService = ServiceFinder.find(IPripatRService.class);
		return pripatRService.findById(priPatId);
	}
}
