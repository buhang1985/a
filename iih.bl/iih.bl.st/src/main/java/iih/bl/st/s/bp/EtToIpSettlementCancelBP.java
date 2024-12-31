package iih.bl.st.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cg.blcgoeptf.d.BlCgItmOepTfRcdDO;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfCudService;
import iih.bl.cg.blcgoeptf.i.IBlcgoeptfRService;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.bliptfin.i.IBliptfinCudService;
import iih.bl.cg.bliptfin.i.IBliptfinRService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.st.blstproxyhp.d.BlStProxyhpDO;
import iih.bl.st.blstproxyhp.d.BlStProxyhpItmDO;
import iih.bl.st.blstproxyhp.d.BlstproxyhpAggDO;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpCudService;
import iih.bl.st.blstproxyhp.i.IBlstproxyhpRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 急诊转住院结算撤销
 * 
 * @author wq.li
 *
 */
public class EtToIpSettlementCancelBP {

	/**
	 * 急诊转住院结算撤销
	 * 
	 * @param stPropxyHpId
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] exec(String stPropxyHpId) throws BizException {
		if (StringUtil.isEmpty(stPropxyHpId)) {
			throw new BizException("代报结算id为空，不能撤销结算");
		}

		IBlstproxyhpRService stService = ServiceFinder.find(IBlstproxyhpRService.class);
		BlstproxyhpAggDO stOldAgg = stService.findById(stPropxyHpId);
		if (stOldAgg == null) {
			throw new BizException("未查询到代报结算信息");
		}
		// 红冲原数据
		BlstproxyhpAggDO stNewAgg = this.backStproxyAgg(stOldAgg);

		// 作废原结算记录
		stOldAgg = this.nullifyStproxyhp(stOldAgg);

		IBliptfinRService rService = ServiceFinder.find(IBliptfinRService.class);
		BlCgIpTfInDO[] oldcgIpTfArr = rService.findByAttrValString(BlCgIpTfInDO.ID_ST_PROXYHP, stPropxyHpId);
		if (ArrayUtil.isEmpty(oldcgIpTfArr)) {
			throw new BizException("为查询到原转移明细信息");
		}
		// 红冲原转移明细信息
		BlCgIpTfInDO[] newCgTfInArr = this.backCgIpTfIn(oldcgIpTfArr, stNewAgg.getParentDO().getId_st_proxyhp());

		// 作废原转移明细信息
		oldcgIpTfArr = this.nullifyCgIpTfIn(oldcgIpTfArr);

		// 作废转移记录
		BlCgItmOepTfRcdDO[] cgItmTfArr = this.nullifyCgTfRcd(oldcgIpTfArr);

		// 退预交金
		BlPrePayPatDO[] preArr = this.refundPrePayPat(stOldAgg);

		//throw new BizException("his处理完成");
		
		return preArr;
	}

	/**
	 * 退预交金
	 * 
	 * @param stOldAgg
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO[] refundPrePayPat(BlstproxyhpAggDO stOldAgg) throws BizException {
		if (stOldAgg == null) {
			return null;
		}

		BlStProxyhpItmDO[] itmDoArr = stOldAgg.getBlStProxyhpItmDO();

		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);

		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_accupdate(FBoolean.TRUE);
		setDto.setFg_checkacc(FBoolean.FALSE);
		setDto.setFg_print(FBoolean.TRUE);

		List<BlPrePayPatDO> preList = new ArrayList<>();
		for (BlStProxyhpItmDO itm : itmDoArr) {
			if (!StringUtil.isEmpty(itm.getId_paypat())) {
				BlPrepayRDTO rDto = new BlPrepayRDTO();
				rDto.setId_prepay_old(itm.getId_paypat());
				rDto.setId_ent(stOldAgg.getParentDO().getId_ent_tf());
				rDto.setAmt(itm.getAmt());
				rDto.setId_pm(itm.getId_pm());
				rDto.setSd_pm(itm.getPm_code());
				rDto.setEu_direct(-1);
				rDto.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);//窗口
				BlPrePayPatDO preDo = prepayService.refund(rDto, setDto);
				if (preDo != null) {
					preList.add(preDo);
				}
			}
		}

		return preList.toArray(new BlPrePayPatDO[0]);
	}

	/**
	 * 作废原转移明细信息
	 * 
	 * @param oldcgIpTfArr
	 * @return
	 * @throws BizException
	 */
	private BlCgIpTfInDO[] nullifyCgIpTfIn(BlCgIpTfInDO[] oldcgIpTfArr) throws BizException {
		if (ArrayUtil.isEmpty(oldcgIpTfArr)) {
			return null;
		}

		for (BlCgIpTfInDO itm : oldcgIpTfArr) {
			itm.setFg_canc(FBoolean.TRUE);
			itm.setId_emp_canc(Context.get().getStuffId());
			itm.setDt_canc(new FDateTime());
			itm.setStatus(DOStatus.UPDATED);
		}
		IBliptfinCudService cudService = ServiceFinder.find(IBliptfinCudService.class);
		return cudService.save(oldcgIpTfArr);

	}

	/**
	 * 作废原代报结算记录
	 * 
	 * @param oldcgIpTfArr
	 * @return
	 * @throws BizException
	 */
	private BlstproxyhpAggDO nullifyStproxyhp(BlstproxyhpAggDO stOldAgg) throws BizException {
		if (stOldAgg == null) {
			return null;
		}

		BlStProxyhpDO proxyhpDo = stOldAgg.getParentDO();
		proxyhpDo.setFg_canc(FBoolean.TRUE);
		proxyhpDo.setId_emp_canc(Context.get().getStuffId());
		proxyhpDo.setDt_canc(new FDateTime());
		proxyhpDo.setStatus(DOStatus.UPDATED);

		IBlstproxyhpCudService cudService = ServiceFinder.find(IBlstproxyhpCudService.class);
		BlstproxyhpAggDO[] doArr = cudService.save(new BlstproxyhpAggDO[] { stOldAgg });

		if (ArrayUtil.isEmpty(doArr)) {
			return null;
		}

		return doArr[0];
	}

	/**
	 * 作废转移记录
	 * 
	 * @param cgIpTfArr
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepTfRcdDO[] nullifyCgTfRcd(BlCgIpTfInDO[] cgIpTfArr) throws BizException {
		if (ArrayUtil.isEmpty(cgIpTfArr)) {
			return null;
		}

		List<String> tfInIdList = new ArrayList<>();
		for (BlCgIpTfInDO itm : cgIpTfArr) {
			if (!StringUtil.isEmpty(itm.getId_cgip_tfin())) {
				tfInIdList.add(itm.getId_cgip_tfin());
			}
		}

		if (ListUtil.isEmpty(tfInIdList)) {
			return null;
		}

		// 查询转移明细
		IBlcgoeptfRService rService = ServiceFinder.find(IBlcgoeptfRService.class);
		BlCgItmOepTfRcdDO[] redArr = rService.findByAttrValStrings(BlCgItmOepTfRcdDO.ID_CGTFIN,
				tfInIdList.toArray(new String[0]));
		if (ArrayUtil.isEmpty(redArr)) {
			return null;
		}

		for (BlCgItmOepTfRcdDO itm : redArr) {
			itm.setFg_active(FBoolean.FALSE);
			itm.setStatus(DOStatus.UPDATED);
			itm.setId_emp_tf_canc(Context.get().getStuffId());
			itm.setId_dep_tf_canc(Context.get().getDeptId());
			itm.setDt_tf_canc(new FDateTime());
		}

		IBlcgoeptfCudService cudService = ServiceFinder.find(IBlcgoeptfCudService.class);

		return cudService.save(redArr);
	}

	/**
	 * 红冲转移明细
	 * 
	 * @return
	 * @throws BizException
	 */
	private BlCgIpTfInDO[] backCgIpTfIn(BlCgIpTfInDO[] cgIpTfArr, String stnewId) throws BizException {

		List<BlCgIpTfInDO> cgIpTfNewList = new ArrayList<>();
		
		for (BlCgIpTfInDO itm : cgIpTfArr) {
			BlCgIpTfInDO inDo=(BlCgIpTfInDO)itm.clone();
			inDo.setId_par(itm.getId_cgip_tfin());
			inDo.setId_cgip_tfin(null);
			inDo.setEu_direct(-1);
			inDo.setId_st_proxyhp(stnewId);
			inDo.setStatus(DOStatus.NEW);
			cgIpTfNewList.add(inDo);
		}

		IBliptfinCudService cudService = ServiceFinder.find(IBliptfinCudService.class);
		return cudService.save(cgIpTfNewList.toArray(new BlCgIpTfInDO[0]));

	}

	/**
	 * 红冲结算数据
	 * 
	 * @param aggDo
	 * @return
	 * @throws BizException
	 */
	private BlstproxyhpAggDO backStproxyAgg(BlstproxyhpAggDO aggDo) throws BizException {
		BlstproxyhpAggDO newAggDo = (BlstproxyhpAggDO) aggDo.clone();

		BlStProxyhpDO proxyDo = (BlStProxyhpDO) newAggDo.getParent();
		
		proxyDo.setId_par(""+proxyDo.getId_st_proxyhp());
		proxyDo.setId_st_proxyhp(null);
		proxyDo.setEu_direct(-1);
		proxyDo.setStatus(DOStatus.NEW);

		BlStProxyhpItmDO[] itmArr = newAggDo.getBlStProxyhpItmDO();
		if (!ArrayUtil.isEmpty(itmArr)) {
			for (BlStProxyhpItmDO itm : itmArr) {
				itm.setId_st_proxyhp(null);
				itm.setId_st_proxyhp_itm(null);
				itm.setEu_direct(-1);
			}
		}
		IBlstproxyhpCudService stCudService = ServiceFinder.find(IBlstproxyhpCudService.class);
		BlstproxyhpAggDO[] newAggDoArr = stCudService.save(new BlstproxyhpAggDO[] { newAggDo });
		return newAggDoArr[0];
	}

}
