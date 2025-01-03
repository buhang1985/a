package iih.mi.mc.i;

import iih.mi.mc.dto.d.MiHpPatSpecDrugDTO;
import iih.mi.mc.dto.miselfpayreduce.d.MiSelfPayReduceDTO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保管控查询服务
 * @author Administrator
 * @date 2019-6-15
 *
 */
public interface IMiMcQryService {
	 /**
	  * 医保特殊病药品增量维护查询药品
	  * @param mimcpatspecdo
	  * @return
	  */
	 public abstract MiHpPatSpecDrugDTO[] quaryPatSpecDrug(MiMcPatSpecDiDO mimcpatspecdido) throws BizException;
	 
	 /**
	  * 获取医保自付减免后金额
	  * @param miSelfPaydto 医保自付dto
	  * @return FMap <idSrv+idMM,减免后金额>
	  * @throws BizException
	  * @author liming06
	  * @since 2019-12-10
	  */
	 public abstract FMap getMiSelfPayReduceAmt(MiSelfPayReduceDTO miSelfPaydto) throws BizException;
	 
	/**
	 * 获取医保对应的重复开药排斥剂型
	 * @param id_hp 医保计划id
	 * @return
	 */
	public abstract String[] getControlHpDosage(String id_hp)throws BizException;
	
	/**
	 * 获取医保对应的单次执行频次
	 * @param id_hp 医保计划id
	 * @return
	 */
	public abstract String[] getControlHpFreq(String id_hp)throws BizException;
	
	/**
	 * 判断当日是否有该药品(医保)的退药记录
	 * @param patId 患者id
	 * @param mmId 物品id
	 * @param hpId 医保计划id
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean hasOpRefundRecord(String patId, String hpId, String mmId) throws BizException;

}
	 
