package iih.mi.mc.s;

import iih.mi.mc.dto.d.MiHpPatSpecDrugDTO;
import iih.mi.mc.dto.miselfpayreduce.d.MiSelfPayReduceDTO;
import iih.mi.mc.i.IMiMcQryService;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import iih.mi.mc.s.bp.MiGetControlHpDosage;
import iih.mi.mc.s.bp.MiGetControlHpFreq;
import iih.mi.mc.s.bp.MiHpPatSpecDrugQueryBP;
import iih.mi.mc.s.bp.MiMcBlCgHasOpRefundRecordBP;
import iih.mi.mc.s.bp.MiSelfPayReduceAmtBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
/**
 * 医保管控查询服务
 * @author Administrator
 * @date 2019-6-15
 *
 */

@Service(serviceInterfaces = { IMiMcQryService.class }, binding = Binding.JSONRPC)
public class IMiMcQryServiceImpl implements IMiMcQryService {

	@Override
	public MiHpPatSpecDrugDTO[] quaryPatSpecDrug(MiMcPatSpecDiDO mimcpatspecdido) throws BizException {
		MiHpPatSpecDrugQueryBP bp = new MiHpPatSpecDrugQueryBP();
		return bp.exec(mimcpatspecdido);
	}
	 /**
	  * 获取医保自付减免后金额
	  * @param miSelfPaydto 医保自付dto
	  * @return FMap <idSrv+idMM,减免后金额>
	  * @throws BizException
	  */
	@Override
	public FMap getMiSelfPayReduceAmt(MiSelfPayReduceDTO miSelfPaydto) throws BizException {
		MiSelfPayReduceAmtBP bp= new MiSelfPayReduceAmtBP();
		return bp.exec(miSelfPaydto);
	}

	/**
	 * 获取医保对应的重复开药排斥剂型
	 * @param id_hp 医保计划id
	 * @return
	 * @throws BizException 
	 */
	@Override
	public String[] getControlHpDosage(String id_hp) throws BizException {
		MiGetControlHpDosage bp= new MiGetControlHpDosage();
		return bp.exec(id_hp);
	}

	/**
	 * 获取医保对应的单次执行频次
	 * @param id_hp 医保计划id
	 * @return
	 */
	@Override
	public String[] getControlHpFreq(String id_hp) throws BizException {
		MiGetControlHpFreq bp = new MiGetControlHpFreq();
		return bp.exec(id_hp);
	}
	
	/**
	 * 判断当日是否有该药品(医保)的退药记录
	 * 
	 * @param patId
	 *            患者id
	 * @param mmId
	 *            物品id
	 * @param hpId
	 *            医保计划id
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean hasOpRefundRecord(String patId, String hpId, String mmId) throws BizException {
		MiMcBlCgHasOpRefundRecordBP bp = new MiMcBlCgHasOpRefundRecordBP();
		return bp.exec(patId, hpId, mmId);
	}
}
