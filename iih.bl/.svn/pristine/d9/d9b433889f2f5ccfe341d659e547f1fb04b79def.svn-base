package iih.bl.vv.s.bp;

import iih.bl.vv.cpn.d.BlCpnDO;
import iih.bl.vv.cpn.i.ICpnCudService;
import iih.bl.vv.cpn.i.ICpnRService;
import iih.bl.vv.dto.blcpnout.d.BlCpnOutDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 *  删除患者优惠券信息
 *  @author houll
 *
 */
public class PatCpnOutDleBP {
	/**
	 * 
	 * @param dto
	 * 删除 患者拥有的优惠券记录
	 * @throws BizException
	 */
	public void exec(BlCpnOutDTO dto) throws BizException {
		// 1.判断当前优惠券是否使用 如果使用 提示 “选择的优惠券已经被使用，禁止删除！”
		BlCpnDO setDo = verifyData(dto);
		// 2.创建患者优惠券服务
		ICpnCudService cSer = ServiceFinder.find(ICpnCudService.class);
		// 3.对优惠券DO赋值主键
		setDo.setFg_iss(FBoolean.FALSE);
		setDo.setDt_iss(null);
		setDo.setId_emp_iss(null);
		setDo.setId_pat_own(null);
		setDo.setStatus(DOStatus.UPDATED);

		// 4.修改患者优惠券
		cSer.update(new BlCpnDO[] { setDo });
	}

	/**
	 * 验证优惠券数据
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private BlCpnDO verifyData(BlCpnOutDTO dto) throws BizException {
		ICpnRService rSer = ServiceFinder.find(ICpnRService.class);
		BlCpnDO setDo = rSer.findById(dto.getId_blcpnout());
		if (setDo == null) {
			throw new BizException("未找到对应的优惠券信息，无法执行删除！");
		}
		if (FBoolean.TRUE.equals(setDo.getFg_used())) {
			throw new BizException("选择的优惠券已经被使用，禁止删除！");
		}
		return setDo;
	}
}
