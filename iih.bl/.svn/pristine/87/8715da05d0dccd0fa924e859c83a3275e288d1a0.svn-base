package iih.bl.st.s.bp.ip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import iih.bl.cg.i.IBlCgCmdService;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.st.blstproxyhp.bp.BlStProxyhpBp;
import iih.bl.st.blstproxyhp.d.BlstproxyhpAggDO;
import iih.bl.st.ettoipsettle.d.EtToIpSettleInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.dto.proxyhp.d.StProxyhpDTO;
import iih.mi.itf.facade.InsureFacade;
import iih.mi.miinsurebiz.etsettleparam.d.EtSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 急诊转住院结算
 * 
 * @author LIM
 * @since 2019-07-02
 */
public class BlEtToIpStBP {

	/**
	 * 急诊转住院结算
	 * 
	 * @param entId
	 *            就诊id
	 * @param cgOepIds
	 *            门诊记账id
	 * @param propData
	 *            医保分摊结果
	 * @return
	 * @throws Exception
	 */
	public BlPrePayPatDO[] exec(EtToIpSettleInfoDTO stInfoDto, String[] cgOepIds, CommonPropDataDTO propData,EtSettleRtnValDTO hpPayRtnValDto)
			throws BizException {
		// 1.参数校验
		this.valid(stInfoDto, cgOepIds, propData);

		// 2.获取门诊记账数据
		BlCgItmOepDO[] blCgItmArr = this.getBlIpCgInfo(cgOepIds);
		// 3.生成预交金记录
		BlPrePayPatDO[] blPrePayPatDOArr = this.savePrePayPatInfo(stInfoDto.getEntid(), propData);
//		if (ArrayUtil.isEmpty(blPrePayPatDOArr)) {
//			throw new BizException("预交金数据为空");
//		}
		// 4.生成代报结算_门急转住院
		Map<String, String> preIdPmMap = this.getPreIdByPm(blPrePayPatDOArr);
		BlStProxyhpBp bp = new BlStProxyhpBp();
		BlstproxyhpAggDO[] blstproxyhpAggDOArr = bp.saveBlStProxyhpDO(stInfoDto, cgOepIds, propData, preIdPmMap);
		if (ArrayUtil.isEmpty(blstproxyhpAggDOArr)) {
			throw new BizException("代报结算_门急转住院 数据为空");
		}
		// 5.批量生成费用转移记录id
		String[] tfInids = new DBUtil().getOIDs(blCgItmArr.length);
		// 5.生成门诊转住院记账明细
		String id_st_proxyhp = blstproxyhpAggDOArr[0].getParentDO().getId_st_proxyhp();
		IBlCgCmdService ser = ServiceFinder.find(IBlCgCmdService.class);
		BlCgIpTfInDO[] blCgIpTfInDOArr = ser.saveBlIpTfInInfo(stInfoDto.getEntid(), blCgItmArr, tfInids, id_st_proxyhp);

		if (ArrayUtil.isEmpty(blCgIpTfInDOArr)) {
			throw new BizException("门诊转住院记账明细 数据为空");
		}
		// 6.生成门诊费用转移记录
		Map<String, String> cgOepTfInMap = this.getcgOepIdTfInMap(blCgItmArr, tfInids);
		ser.saveBlCgOepTfInfo(stInfoDto.getEntid(), cgOepTfInMap);

		// 保存医保分摊信息
		InsureContext insureContext = new InsureContext();
		insureContext.setIdHp(stInfoDto.getId_hp());
		InsureFacade facade = new InsureFacade(insureContext);
		
		StProxyhpDTO stProxyHpDto =new StProxyhpDTO();
		stProxyHpDto.setId_st_proxyhp(blstproxyhpAggDOArr[0].getParentDO().getId_st_proxyhp());
		stProxyHpDto.setCode_st(blstproxyhpAggDOArr[0].getParentDO().getCode_st());
		stProxyHpDto.setEu_direct(blstproxyhpAggDOArr[0].getParentDO().getEu_sttp());
		stProxyHpDto.setId_ent_tf(stInfoDto.getEntid());
		stProxyHpDto.setFg_canc(blstproxyhpAggDOArr[0].getParentDO().getFg_canc());
		facade.updateEtToIpPropData(hpPayRtnValDto, stProxyHpDto);
		
		return blPrePayPatDOArr;
	}

	/**
	 * 数据校验
	 * 
	 * @param entId
	 * @param cgOepIds
	 * @param propData
	 * @throws BizException
	 */
	private void valid(EtToIpSettleInfoDTO stInfoDto, String[] cgOepIds, CommonPropDataDTO propData)
			throws BizException {

		if (stInfoDto == null) {
			throw new BizException("结算信息不能为空");
		}

		if (StringUtil.isEmpty(stInfoDto.getEntid())) {
			throw new BizException("就诊ID不能为空！");
		}

		if (StringUtil.isEmpty(stInfoDto.getId_hp())) {
			throw new BizException("医保计划不能为空");
		}

		if (StringUtil.isEmpty(stInfoDto.getPatcaid())) {
			throw new BizException("患者分类不能为空");
		}

		if (ArrayUtil.isEmpty(cgOepIds)) {
			throw new BizException("门诊记账ID不能为空！");
		}
		if (propData == null || propData.getAmt_hp() == null || propData.getAmt_psn() == null) {
			throw new BizException("医保分摊数据不能为空！");
		}
	}

	/**
	 * 保存预交金数据
	 * 
	 * @param entId
	 * @param propData
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO[] savePrePayPatInfo(String entId, CommonPropDataDTO propData) throws BizException {
		List<BlPrePayPatDO> blPrePayPatDOList = new ArrayList<BlPrePayPatDO>();
		// 1.获取住院就诊信息
		PatiVisitDO enEnt = BlBaseInfoUtils.getIpEntInfo(entId);
		// 2.组织数据
		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_print(FBoolean.TRUE);
		setDto.setFg_accupdate(FBoolean.TRUE);
		// 3.判断医保基金是否有值
		if (propData.getAmt_hp() != null && propData.getAmt_hp().compareTo(FDouble.ZERO_DBL) > 0) {
			BlPrepayRDTO blPrepayRDTO = this.setBlPrePayPatDO(enEnt, IBdPripmCodeConst.CODE_PRI_PM_INSUR,
					propData.getAmt_hp());
			BlPrePayPatDO blPrePayPatDO = this.savePrePayPatDo(blPrepayRDTO, setDto);
			blPrePayPatDOList.add(blPrePayPatDO);
		}
		// 4.判断个人账户是否有值
		if (propData.getAmt_psn() != null && propData.getAmt_psn().compareTo(FDouble.ZERO_DBL) > 0) {
			BlPrepayRDTO blPrepayRDTO = this.setBlPrePayPatDO(enEnt, IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT,
					propData.getAmt_psn());
			BlPrePayPatDO blPrePayPatDO = this.savePrePayPatDo(blPrepayRDTO, setDto);
			blPrePayPatDOList.add(blPrePayPatDO);
		}
		return blPrePayPatDOList.toArray(new BlPrePayPatDO[] {});
	}

	/**
	 * 保存预交金数据
	 * 
	 * @param blPrepayRDTO
	 * @param setDto
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO savePrePayPatDo(BlPrepayRDTO blPrepayRDTO, BlPrepaySetDTO setDto) throws BizException {
		IBlPrepayCmdService ser = ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrePayPatDO blPrePayPatDO = ser.recharge(blPrepayRDTO, setDto);
		return blPrePayPatDO;
	}

	/**
	 * 组织预交金数据
	 * 
	 * @param enEnt
	 * @param sd_pm
	 * @param amt
	 * @return
	 */
	private BlPrepayRDTO setBlPrePayPatDO(PatiVisitDO enEnt, String sd_pm, FDouble amt) {
		BlPrepayRDTO blPrepayRDTO = new BlPrepayRDTO();
		blPrepayRDTO.setId_pat(enEnt.getId_pat());
		blPrepayRDTO.setId_ent(enEnt.getId_ent());
		blPrepayRDTO.setEu_direct(BookRtnDirectEnum.CHARGES);
		blPrepayRDTO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		blPrepayRDTO.setAmt(amt);
		if (IBdPripmCodeConst.CODE_PRI_PM_INSUR.equals(sd_pm)) {
			// 医保基金
			blPrepayRDTO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSUR);
			blPrepayRDTO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_INSUR);
		} else if (IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT.equals(sd_pm)) {
			// 个人账户
			blPrepayRDTO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT);
			blPrepayRDTO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT);
		}
		return blPrepayRDTO;
	}

	/**
	 * 根据预交金表获取支付方式对应的id
	 * 
	 * @param blPrePayPatDOArr
	 * @return
	 */
	private Map<String, String> getPreIdByPm(BlPrePayPatDO[] blPrePayPatDOArr) {
		Map<String, String> preIdPmMap = new HashMap<String, String>();
		
		if(ArrayUtil.isEmpty(blPrePayPatDOArr))
		{
			return preIdPmMap;
		}
		
		for (BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr) {
			if (!preIdPmMap.containsKey(blPrePayPatDO.getSd_pm())) {
				preIdPmMap.put(blPrePayPatDO.getSd_pm(), blPrePayPatDO.getId_paypat());
			}
		}
		return preIdPmMap;
	}

	/**
	 * 获取门诊记账信息
	 * 
	 * @param cgOepIds
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepDO[] getBlIpCgInfo(String[] cgOepIds) throws BizException {
		IBlCgItmOepDORService ser = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] blcgDOArr = ser.findByAttrValStrings(BlCgItmOepDO.ID_CGITMOEP, cgOepIds);
		if (ArrayUtil.isEmpty(blcgDOArr)) {
			throw new BizException("未获取到门诊记账数据");
		}
		return blcgDOArr;
	}

	/**
	 * 映射门诊记账表的id与生成的转移表id的关系
	 * 
	 * @param blCgItmOepDOArr
	 * @param tfInids
	 * @return
	 */
	private Map<String, String> getcgOepIdTfInMap(BlCgItmOepDO[] blCgItmOepDOArr, String[] tfInids) {
		Map<String, String> cgOepIdTfInMap = new HashMap<String, String>();
		for (int i = 0; i < blCgItmOepDOArr.length; i++) {
			cgOepIdTfInMap.put(blCgItmOepDOArr[i].getId_cgitmoep(), tfInids[i]);
		}
		return cgOepIdTfInMap;
	}
}
