package iih.ci.ord.i.mi;

import java.util.List;
import java.util.Map;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.obtain.meta.hp.HpsrvtpQryParamDTO;
import iih.ci.ord.i.external.obtain.meta.hp.HpsrvtpQryRstDTO;
import iih.ci.ord.i.meta.MiVerifyParamDTO;
import iih.ci.ord.i.meta.MiVerifyRstDTO;
import iih.ci.ord.i.mi.meta.DefaultOrdHpInfoParamDTO;
import iih.ci.ord.i.mi.meta.DefaultOrdHpInfoRstDTO;
import iih.ci.ord.i.mi.meta.OrdHpRstDTO;
import iih.ci.ord.i.mi.meta.OrdHpVerifyRstDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;

/**
 * 临床业务域医保相关主接口
 * 
 * @author wangqingzhu
 *
 */
public interface ICiMiMainService {

	/**
	 * 医保细则校验
	 * 
	 * @param ctx
	 * @param param
	 * @return
	 */
	public MiVerifyRstDTO verifyMiRule(CiEnContextDTO ctx, MiVerifyParamDTO param);

	/**
	 * 获取医保适应症校验结果<br>
	 * 当适应症返回结果中存在01/11控制类型的，将更新到数据
	 * 
	 * @param ctx 当前就诊环境（含诊断）
	 * @param id_ors 医嘱id集合
	 * @return 医保适应症校验结果
	 * @throws BizException
	 */
	public OrdHpRstDTO getOrdHpIndicVerifyRst(CiEnContextDTO ctx, String[] id_ors) throws BizException;
	
	/**
	 * 根据医嘱id获取已经判断的医保自费判断结果
	 * @param ctx 当前患者就诊环境
	 * @param id_ors 获取已医保判断结果
	 * @return
	 * @throws BizException
	 */
	public OrdHpRstDTO getOrdHpVerifiedRst(CiEnContextDTO ctx, String[] id_ors) throws BizException;
	

	/**
	 * 获取医保目录
	 * 
	 * @param hpsrvtpParamList 获取医保目录类型参数集合
	 * @return 医保目录类型集合 key id_srv+id_mm ，value 医保目录类型对象
	 * @throws DAException
	 */
	public Map<String, HpsrvtpQryRstDTO> getHpsrvtpMap(CiEnContextDTO ctx, List<HpsrvtpQryParamDTO> hpsrvtpParamList) throws DAException;

	/**
	 * 获取医嘱医保默认值<br>
	 * 医保目录，默认的判断结果
	 * 
	 * @param ctx
	 * @param hpsrvtpParamList
	 * @return
	 * @throws DAException
	 */
	public Map<String, DefaultOrdHpInfoRstDTO> getDefaultOrdHpInfoList(CiEnContextDTO ctx, List<DefaultOrdHpInfoParamDTO> ordHpInfoList)
			throws DAException;

	/**
	 * 更新医保适应症结果
	 * 
	 * @param ctx 当前就诊环境
	 * @param ordSrvRsts 医保适应症判定结果集合
	 * @return
	 * @throws BizException 
	 */
	public OrdHpRstDTO saveOrdHpJudgeRst(CiEnContextDTO ctx, OrdHpVerifyRstDTO[] ordSrvRsts) throws BizException;
	
	/**
	 * 医保转自费
	 * @param ctx 当前患者就诊环境
	 * @param id_ors 医嘱id集合
	 * @return 医保结果
	 * @throws BizException
	 */
	public OrdHpRstDTO miTransferToSelfpay(CiEnContextDTO ctx,String[] id_ors) throws BizException;
	
	/**
	 * 自费转医保
	 * @param ctx 当前患者就诊环境
	 * @param id_ors 医嘱id集合
	 * @return 
	 * @throws BizException
	 */
	public OrdHpRstDTO selfpayTransferToMi(CiEnContextDTO ctx,String[] id_ors) throws BizException;

}
