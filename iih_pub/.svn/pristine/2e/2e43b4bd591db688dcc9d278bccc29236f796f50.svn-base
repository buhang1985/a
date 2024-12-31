package iih.ci.mr.nu.i;

import iih.bd.srv.nurmrtpl.d.NurMrConTplDO;
import iih.ci.mr.nu.babybirrecord.d.BabyBirRecordDO;
import iih.ci.mr.nu.dto.babyskinriskass.d.BabySkinRiskAssDTO;
import iih.ci.mr.nu.dto.pipeslipdto.d.PipeSlipDTO;
import iih.ci.mr.nu.dto.prescforoperdto.d.PrescforoperDTO;
import iih.ci.mr.nu.intervopre.d.IntervopreAggDO;
import iih.ci.mr.nu.ipevalsigle.d.IpevalsigleAggDO;
import iih.ci.mr.nu.newborn24hobsrec.d.Newborn24hobsrecAggDO;
import iih.ci.mr.nu.opermatlist.d.OpermatlistAggDO;
import iih.ci.mr.nu.regformfordeliver.d.RegformfordeliverAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.xbd.udi.d.UdidocDO;

public interface ICimrNuQueryService {

	/**
	 * 实例化护理文书实体，赋初始值
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList initData(String id_ent, String fullClassName) throws BizException;

	/**
	 * 根据节气名称返回字典信息
	 * 
	 * @param name
	 * @return
	 * @throws BizException
	 */
	public abstract UdidocDO getSolarTermsInfo(String name) throws BizException;

	/**
	 * 获取护理护理内容模板内容
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract NurMrConTplDO[] getMrContpls() throws BizException;

	/**
	 * 刷新和编辑时刷新患者的数据
	 * 
	 * @param baseDO
	 * @return
	 * @throws BizException
	 */
	public FArrayList refreshData(BaseDO baseDO) throws BizException;

	/**
	 * 评分结果匹配
	 * 
	 * @param id_ent
	 * @param fullClassName
	 * @return
	 * @throws BizException
	 */
	public UdidocDO calculateResult(FDouble score, String code_udidoc, FBoolean fg_left_close, FBoolean fg_right_close) throws BizException;

	/**
	 * 获取默认评分列表
	 * 
	 * @param id_babyskinass
	 * @return
	 * @throws BizException
	 */
	public BabySkinRiskAssDTO[] getBabySkinRiskAssDTOs(String id_babyskinass) throws BizException;

	/***
	 * 管道滑脱危险因素评估单 获取危险因素DTO yy.zhao_2017年9月8日14:02:37
	 * 
	 * @param id_pipe_slipe
	 * @return
	 * @throws BizException
	 */
	public abstract PipeSlipDTO[] getPipeSlipDTO(String id_pipe_slipe) throws BizException;

	/***
	 * 手术患者术中物品清点单 根据ID获取AggDO yy.zhao_2017年9月8日14:03:44
	 * 
	 * @param id_opermatlist
	 * @return
	 * @throws BizException
	 */
	public abstract OpermatlistAggDO getOpermatlistAggDo(String id_opermatlist) throws BizException;

	/**
	 * 获取住院患者及健康教育评价单
	 * 
	 * @param Id_ent
	 *            就诊 ID
	 * @param code_udi
	 *            自定义档案编码
	 * @return
	 * @throws BizException
	 * @author lijm
	 */
	public IpevalsigleAggDO getIpevalsigle(String Id_ent, String code_udi) throws BizException;

	/**
	 * 获取介入手术材料
	 * 
	 * @param Id_ent
	 * @return
	 * @throws BizException
	 * @author pengkd
	 */
	public IntervopreAggDO[] getIntervopre(String Id_ent) throws BizException;

	/**
	 * 获取默认手术室患者压疮危险因素评估项目列表
	 */

	public PrescforoperDTO[] getPrescforoperDTOs(String id_prescfor) throws BizException;

	/**
	 * 获取手术患者术中物品清点单默认初始数据 yy.zhao 2017年9月5日09:28:37
	 * 
	 * @return
	 * @throws BizException
	 */
	public OpermatlistAggDO getDefaultData() throws BizException;

	/***
	 * 根据主键获取AggDO信息yy.zhao
	 * 
	 * @param id_regform
	 *            2017年9月5日09:28:32
	 * @return
	 * @throws BizException
	 */
	public RegformfordeliverAggDO getRegformAggDO(String id_regform) throws BizException;

	/**
	 * 获取新生儿24观察记录单时间 pengkd
	 * 
	 * @param Id_ent
	 * @return
	 * @throws BizException
	 */
	public Newborn24hobsrecAggDO[] getNewbornResTime(String Id_ent) throws BizException;

	/**
	 * 查询对应的产时类别封装到婴儿产时记录 并返回
	 * 
	 * @return
	 */
	public BabyBirRecordDO[] getBabyBirRecordDo() throws BizException;
}
