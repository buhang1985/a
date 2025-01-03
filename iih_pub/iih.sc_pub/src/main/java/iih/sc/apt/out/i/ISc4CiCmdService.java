package iih.sc.apt.out.i;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.out.ci.d.MtAptParamDTO;
import iih.sc.apt.out.ci.d.MtAptResDTO;
import iih.sc.apt.out.ci.d.ScAddApplInParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 *
 * 为CI提供查询服务
 *
 * @author liubin
 *
 * 下午4:08:37
 */
public interface ISc4CiCmdService {

	/**
	 *
	 * 增加预约申请(手术、医技) 单个
	 *
	 * @param scAddApplInParam 增加预约申请(手术、医技)  sd_sctp	医嘱类型	03-医技 04-手术
	 * @param scAptOptEmps 手术角色人员
	 * @throws BizException
	 */
	public void addScAptAppl(ScAddApplInParamDTO scAddApplInParam) throws BizException;

	/**
	 *
	 * 增加预约申请(手术、医技)批量
	 *
	 * @param scAddApplInParam 增加预约申请(手术、医技)  sd_sctp	医嘱类型	03-医技 04-手术
	 * @param scAptOptEmps 手术角色人员
	 * @throws BizException
	 */
	public void addBatchScAptAppl(FArrayList scAddApplInParams) throws BizException;

	/**
	 *
	 * 撤销预约申请(医技、手术)
	 *
	 * @param id_or 医嘱id
	 * @param id_emp_canc 取消人员
	 * @param dt_canc 取消时间
	 * @param sd_su_or 医嘱状态
	 * @throws BizException
	 */
	public void cancScAptAppl(String id_or, String id_emp_canc, FDateTime dt_canc, String sd_su_or) throws BizException;

	/**
	 * 自动预约接口
	 * @param appDTP  id_or(医嘱id),id_scch(渠道) 不能为空
	 * @return  预约时间
	 */
	public MtAptResDTO saveAutoApt4Ci(MtAppDTO appDTO) throws BizException;

	/**
	 * 第三方调用预约(医生站)
	 * @param appDTP  id_or(医嘱id),id_scch(渠道) 不能为空
	 * @return  预约结果相关信息
	 */
	public MtAptResDTO saveApt4Ci(MtAptParamDTO appDTO) throws BizException;

	/****
	 * 手术申请单确认、取消确认之后以及术前确认，修改手术预约状态
	 * fanlq-2018-09-16
	 * @param applNo
	 * @param isFinish
	 * @param isBefConf 是否术前确认
	 */
	public void updateAptStatusForOpt(String applNo,FBoolean isFinish,FBoolean isBefConf) throws BizException;

	/****
	 * 门诊医生站撤回、删除医技医嘱是否已确认判断
	 * @author yu.b 2020-07-20
	 * @param idOrs 医嘱id
	 * @return FMap key为msg,value为已预约医嘱错误信息，可为空；其他key为医嘱id，value为是否可撤回bool值
	 */
	public FMap getAptNotConfirm4CI(FArrayList idOrs) throws BizException;
}
