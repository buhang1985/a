package iih.ci.mr.nu.i;

import iih.ci.mr.nu.dto.babyskinriskass.d.BabySkinRiskAssDTO;
import iih.ci.mr.nu.dto.prescforoperdto.d.PrescforoperDTO;
import iih.ci.mr.nu.ipevalsigle.d.IpevalsigleAggDO;
import iih.ci.mr.nu.newbabyskinriskass.d.NewBabySkinAssDO;
import iih.ci.mr.nu.opermatlist.d.OpermatlistAggDO;
import iih.ci.mr.nu.prescforoper.d.PrescforDO;
import iih.ci.mr.nu.regformfordeliver.d.RegformfordeliverAggDO;
import xap.mw.core.data.BizException;

public interface ICimrNuMaintainService {

	/**
	 * 新生儿皮肤风险评估单保存
	 * 
	 * @param skinAssDO
	 * @param riskAssDTOs
	 * @throws BizException
	 */
	public NewBabySkinAssDO saveBabySkinAssData(NewBabySkinAssDO skinAssDO, BabySkinRiskAssDTO[] riskAssDTOs) throws BizException;

	/**
	 * 住院患者健康教育评价单 lijm
	 * 
	 * @param aggdo
	 * @param 医疗记录自定义分类编码
	 * @param 医疗记录类型编码
	 * @return
	 * @throws BizException
	 */
	public IpevalsigleAggDO saveIpevalsigle(IpevalsigleAggDO aggdo, String fun_code) throws BizException;

	/**
	 * 手术患者压疮危险因素评分数据保存
	 * 
	 * @param pforDO
	 * @param pforDTOs
	 * @return
	 * @throws BizException
	 */
	public PrescforDO savePrescforperData(PrescforDO pforDO, PrescforoperDTO[] pforDTOs) throws BizException;

	/***
	 * 分娩登记表 保存逻辑 yy.zhao_2017年9月8日13:49:44
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	public RegformfordeliverAggDO saveRegformDB(RegformfordeliverAggDO aggdo) throws BizException;

	/***
	 * 手术患者术中物品清点单 保存逻辑 yy.zhao_2017年9月8日13:51:01
	 * 
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	public OpermatlistAggDO saveOpermatlistDB(OpermatlistAggDO aggdo) throws BizException;
}
