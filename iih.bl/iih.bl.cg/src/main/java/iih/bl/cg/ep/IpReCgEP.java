package iih.bl.cg.ep;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blrecgip.d.BlRecgIpDO;
import iih.bl.cg.blrecgip.i.IBlrecgipCudService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.en.pv.i.IEnOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院重划价EP
 * @author yankan
 * @since 2017-06-19
 *
 */
public class IpReCgEP {

	/**
	 * 修改就诊账户的消费额度
	 * 
	 * @param id_ent
	 *            就诊ID
	 * @param orginAccAmt
	 *            红冲的总金额
	 * @param newAccAmt
	 *            重收的总金额
	 */
	public void updateEntAccAmt(String id_ent, FDouble orginAccAmt,	FDouble newAccAmt) throws BizException {
		// sql中采用的加，因此先还原以前的消费额在减去新额度
		IEnOutCmdService enAccService = ServiceFinder.find(IEnOutCmdService.class);
		enAccService.consume(id_ent, orginAccAmt.multiply(-1).add(newAccAmt));
	}
	
	/**
	 * 保存重划价记录
	 * @param from 原价格分类id
	 * @param to	新价格分类id
	 * @param operatorInfo
	 * @return
	 * @author liwq
	 * @throws BizException
	 */
	public BlRecgIpDO saveRecgIpRecrod(String from,String to,OperatorInfoDTO operatorInfo) throws BizException  {
		BlRecgIpDO blRecgIpDO = new BlRecgIpDO();
		FDateTime strDateTime = AppUtils.getServerDateTime();
		blRecgIpDO.setId_recg_ip(null);
		blRecgIpDO.setDt_recg(strDateTime);
		blRecgIpDO.setId_pripat_from(from);
		blRecgIpDO.setId_pripat_to(to);
		blRecgIpDO.setId_emp_recg(operatorInfo.getId_emp());
		blRecgIpDO.setId_org(operatorInfo.getId_org());
		blRecgIpDO.setId_grp(operatorInfo.getId_grp());
		blRecgIpDO.setStatus(DOStatus.NEW);
		IBlrecgipCudService iBlrecgipCudService = ServiceFinder.find(IBlrecgipCudService.class);
		BlRecgIpDO[] blRecgIpDOArr1 = new BlRecgIpDO[] { blRecgIpDO };
		BlRecgIpDO[] recgIpDOArr = iBlrecgipCudService.save(blRecgIpDOArr1);
		if (ArrayUtil.isEmpty(recgIpDOArr)) {
			throw new BizException("保存重划价记录失败！");
		}
		return recgIpDOArr[0];
	}
}
