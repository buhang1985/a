package iih.pi.params;


import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.log.Log;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 患者域参数
 * @author ly 2017/05/15
 *
 */
public class PiParams {

	private Context ctx = Context.get();
	
	/**
	 * 是否开启chis患者创建及同步功能
	 * @return
	 */
	public FBoolean PIPAT0002(){
		
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0002");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 是否开启empi功能
	 * @return
	 */
	public FBoolean PIPAT0005(){
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0005");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * chis建档webservice地址
	 * @return
	 */
	public String PIPAT0006(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), "PIPAT0006");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * 是否同步数据到chis
	 * @return
	 */
	public FBoolean PIPAT0008(){
		
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0008");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 医保患者的默认患者分类
	 * @return
	 */
	public String ENOP0170(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), "ENOP0170");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	/**
	 * 患者默认现住址
	 * @return
	 */
	public String PIPAT0014(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), "PIPAT0014");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	/**
	 * 体检团体对应的客户分类
	 * @return
	 */
	public String PIPAT0015(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), "PIPAT0015");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	/**
	 * 第三方患者建档是否实名
	 * @return
	 */
	public FBoolean PIPAT0016(){
		
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0016");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 患者注册是否可以绑定多张就诊卡
	 * @return
	 */
	public FBoolean PIPAT0020(){
		
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0020");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	
	/**
	 * 是否开启第三方平台患者唯一性管理
	 * @return
	 */
	public FBoolean PIPAT0021(){
		
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0021");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 身份证校验忽略的区县
	 * @return
	 */
	public String PIPAT0023(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), "PIPAT0023");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * 读身份证时是否保存uid
	 * @return
	 */
	public FBoolean PIPAT0024(){
		
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0024");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 身份证uid对应的卡类型
	 * @return
	 */
	public String PIPAT0025(){
		try {
			return ParamsetQryUtil.getParaString(ctx.getOrgId(), "PIPAT0025");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
	
	/**
	 * 是否开启卡库管理就诊卡
	 * @return
	 */
	public FBoolean PIPAT0027(){
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0027");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.TRUE;
	}
	
	/**
	 * 是否开启人员同步到患者功能
	 * @return
	 */
	public FBoolean PIPAT0029(){
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0029");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	
	/**
	 * 患者保存时是否对头像进行格式转换
	 * @return
	 */
	public FBoolean PIPAT0030(){
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0030");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	/**
	 * 患者注册时：对非实名认证的患者，其新增、修改或删除时是否发送EMPI消息
	 * @description:
	 * @author:hanjq  2020年7月20日
	 * @return
	 */
	public FBoolean PIPAT0033(){
		try {
			return ParamsetQryUtil.getParaBoolean(ctx.getOrgId(), "PIPAT0033");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 患者导入时的数据配置
	 * @return
	 */
	public String PIPAT9999(){
		try {
			return ParamsetQryUtil.getParaString("GLOBLE00000000000000", "PIPAT9999");
		} catch (BizException e) {
			e.printStackTrace();
			Log.error(e);
		}
		return null;
	}
}
