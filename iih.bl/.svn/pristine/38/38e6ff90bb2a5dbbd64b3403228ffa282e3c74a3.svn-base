package iih.bl.vv.s.bp;

import iih.bd.pp.bdcpnca.d.BdCpncaDO;
import iih.bd.pp.bdcpnca.i.IBdcpncaMDORService;
import iih.bl.vv.cpn.d.BlCpnDO;
import iih.bl.vv.cpn.i.ICpnCudService;
import iih.bl.vv.cpn.i.ICpnRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
        优惠券发放BP
 * @author houll
 *
 */
public class BlCpnGraBP {
	/**
	 * @param idPat
	 * @param cpnCode
	 * @throws BizException
	 */
	public void exec(String idPat, String cpnCode) throws BizException {

		// 1.判断优惠券状态
		BlCpnDO setDo = verifyDate(idPat, cpnCode);

		// 2.创建患者优惠券服务
		ICpnCudService cSer = ServiceFinder.find(ICpnCudService.class);

		// 3.对优惠券DO赋值主键
		setDo.setFg_iss(FBoolean.TRUE);
		setDo.setDt_iss(new FDateTime());
		setDo.setId_emp_iss(Context.get().getUserId());
		setDo.setId_pat_own(idPat);
		setDo.setStatus(DOStatus.UPDATED);

		// 4.发放患者优惠券
		cSer.update(new BlCpnDO[] { setDo });
	}

	/**
	 * 验证优惠券数据状态
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */

	private BlCpnDO verifyDate(String idPat, String cpnCode) throws BizException {
		ICpnRService rSer = ServiceFinder.find(ICpnRService.class);
		IBdcpncaMDORService cSert = ServiceFinder.find(IBdcpncaMDORService.class);
		// 得到对应的优惠卷
		BlCpnDO[] setDos = rSer.findByAttrValString(BlCpnDO.CODE, cpnCode);

		// 判断扫码对应的优惠券是否存在（BL_CPN），如果不存在则弹出提示"编码为XXXX的优惠券没有入库，无法发放！"并中止流程。
		if (setDos == null || setDos.length == 0) {
			throw new BizException("未找到对应的优惠券信息，无法进行发放，请检查是否输入错误或有空字符！");
		}
		//
		BlCpnDO setDo = setDos[0];
		// 通过优惠券获取对应优惠券分类
		BdCpncaDO[] bcado = cSert.find("id_cpnca ='" + setDo.getId_cpnca().trim() + "'", "", FBoolean.FALSE);
		// 判断扫码对应的优惠是否已经发放（BL_CPN.fg_iss），如果已经发放则弹出提示"编码为XXXX的优惠券已经发放，禁止重复发放！"并中止流程。
		if (FBoolean.TRUE.equals(setDo.getFg_iss())) {
			throw new BizException("选择的优惠券已经发放，禁止重复发放");
		}

		// 判断扫码对应的优惠券分类是否已经停用，如果是已经停用的优惠券则提示"该优惠券已经停用，不能发放！"，并中止流程。
		if (2 != bcado[0].getActive_state()) {
			throw new BizException("选择的优惠券分类未启用，禁止发放！");
		}

		// 判断扫码对应的优惠券是否为记名优惠券，如果是不记名优惠券则提示"该优惠券不是记名优惠券，不需要发放！"，并中止流程。
		if (!StringUtil.isEmpty(setDos[0].getId_pat_own())) {
			throw new BizException("选择的优惠券为记名优惠券，禁止发放！");
		}
		return setDo;

	}

}
