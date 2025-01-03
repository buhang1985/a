package iih.bl.inc.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.i.IBlincissCudService;
import iih.bl.inc.blinciss.i.IBlincissRService;
import iih.bl.inc.blinctf.d.BlIncTfDO;
import iih.bl.inc.blinctf.i.IBlinctfCudService;
import iih.bl.inc.dto.blinctf.d.BlIncIssDTO;
import iih.bl.inc.dto.blinctf.d.BlIncTfCondDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 撤销发票票据转移
 * 
 * @author houll
 * @throw BizException
 *
 */
public class IncTransferRevokeBP {

	@SuppressWarnings("unchecked")
	public void exec(BlIncTfCondDTO cond) throws BizException {
		// 空校验
		this.validata(cond);

		List<BlIncIssDTO> issIdList = new ArrayList<BlIncIssDTO>();
		issIdList.addAll(cond.getInclist());

		// 1.检索转移记录数据并检验转移后的记录是否被使用
//		IBlinctfRService incrservice = ServiceFinder.find(IBlinctfRService.class);
//		BlIncTfDO blIncTfDO = incrservice.findById(issIdList.get(0).getId_iss_tf());
		
		DAFacade daf=new DAFacade();
		 List<BlIncTfDO> blIncTfDOList = (List<BlIncTfDO>) daf.findByAttrValString(BlIncTfDO.class, BlIncTfDO.ID_INCTF, issIdList.get(0).getId_iss_tf(), null);
		if(ListUtil.isEmpty(blIncTfDOList)){
			throw new BizException("转移记录信息为空");
		}
		//this.isUse(blIncTfDOList.get(0), cond);
		// 2.还原原始的票据记录(检索原领用数据，并修改fg_active)
		IBlincissRService iblincservice = ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO BlIncIssDO = iblincservice.findById(blIncTfDOList.get(0).getId_inc_iss());
		BlIncIssDO.setFg_active(FBoolean.TRUE);
		BlIncIssDO.setStatus(DOStatus.UPDATED);
		daf.updateDO(BlIncIssDO);

		// 3.删除转移后的新增票据记录

		IBlincissRService blincissRService = ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO blIncIssDO = blincissRService.findById(blIncTfDOList.get(0).getId_inc_iss_tf());
		if (blIncIssDO == null) {
			return;
		}
		IBlincissCudService cudservice = ServiceFinder.find(IBlincissCudService.class);
		cudservice.delete(new BlIncIssDO[] { blIncIssDO });
		// 4.删除转移记录
		IBlinctfCudService inctfservice = ServiceFinder.find(IBlinctfCudService.class);
		inctfservice.delete(new BlIncTfDO[] { blIncTfDOList.get(0) });
		
	}

	/**
	 * 校验参数
	 * 
	 * @param invoiceNo
	 * @param strCodeIncca
	 * @throws BizException
	 */
	private void validata(BlIncTfCondDTO cond) throws BizException {
		if (cond == null || cond.getInclist() == null || cond.getInclist().size() == 0) {
			throw new BizException("发票票据转移信息不能为空！");
		}
	}

	/**
	 * 校验转移后的票据记录是否已经使用
	 * 
	 * @param blIncTfDO
	 * @param cond
	 * @throws BizException
	 */
	private void isUse(BlIncTfDO blIncTfDO, BlIncTfCondDTO cond) throws BizException {

		// 1.1校验是否转移
		if (StringUtils.isEmpty(blIncTfDO.getId_inctf())) {
			throw new BizException("票据转移记录为空！");
		}
		// 1.2校验原票据领用人和原领用计算是否和条件中的一致
		if (!blIncTfDO.getId_emp_iss().equals(cond.getId_emp_iss()) && !blIncTfDO.getId_pc().equals(cond.getId_pc())) {
			return;
		}
	}

}
