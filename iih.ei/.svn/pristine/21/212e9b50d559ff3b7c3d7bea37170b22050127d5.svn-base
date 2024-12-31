package iih.ei.std.s.v1.bp.bl.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bl.comm.IBlFlowKeyConst;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 标准接口金额转换校验工具类
 * @author shaokx 2019/09/25
 *
 */
public class BlAmtConverUtil {
	
	private static String[] TMINAL_TYPE_RANGE;//终端类型值范围
	
	static{
		TMINAL_TYPE_RANGE = new String[] { IBlDictCodeConst.SD_PTTP_WINDOW, 
				IBlDictCodeConst.SD_PTTP_SELF_TERMINAL,
				IBlDictCodeConst.SD_PTTP_WEIXIN, 
				IBlDictCodeConst.SD_PTTP_PHONE_APP,IBlDictCodeConst.SD_PTTP_H5 };
	}
	
	/**
	 * 校验是否为数字
	 * @param amt
	 * @return
	 */
	public static boolean isNumeric(String amt){
		return StringUtils.isNumeric(amt);
	}
	
	/**
	 * 转换为内部处理类型
	 * 由分转换为元
	 * @param amt
	 * @return
	 */
	public static FDouble toFDouble(String amt){
		Double i = Double.parseDouble(amt);
		return new FDouble(i / 100, 2);
	}
	
	/**
	 * 转为外部提供类型
	 * 由元转换为分
	 * @param amt
	 */
	public static String toXmlString(FDouble amt){
		
		BigDecimal bg = new BigDecimal(amt.doubleValue() * 100);

        double doubleValue = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

		return decimalFormat.format(doubleValue);
		
//      return  String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12 会变为12.0
		//下面这个转换会损失精度，如amt为0.6666会变为67
//		Double d = amt.doubleValue();
//		return Integer.toString((int)Math.ceil(d*100));
	}
	
	/**
	 * 校验xml入参终端类型
	 * @param value
	 * @return
	 */
	public static Boolean checkTerminalType(String value) {
		
		for (String str : TMINAL_TYPE_RANGE) {
			if(str.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 查询人员信息
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public static PsnDocDO getPsnInfo(String code) throws BizException{
		IPsndocMDORService rService = ServiceFinder.find(IPsndocMDORService.class);
		PsnDocDO[] dos = rService.findByAttrValString(PsnDocDO.CODE, code);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		return dos[0];
	}
	
	/**
	 * 获取上下文当前时间
	 * @return
	 */
	public static FDateTime getNowTime() {
		if(Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_NOW) == null){
			Context.get().setAttribute(IBlFlowKeyConst.BL_FLOW_KEY_NOW, AppUtils.getServerDateTime());
		}
		return (FDateTime)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_NOW);
	}
	
	/**
	 * 获取操作员信息
	 * @param code_psn
	 * @throws DAException 
	 */
	public static PsnDocDO getPsnDocDO(String code_psn) throws DAException{
		String[] psn = { "Id_psndoc","Code","Name" };
		@SuppressWarnings("unchecked")
		List<PsnDocDO> psnList = (List<PsnDocDO>) new DAFacade().findByCond(PsnDocDO.class, "code='" + code_psn + "' or id_psndoc='" + code_psn + "'",
				"1", psn);
		if (psnList == null || psnList.size() <= 0) {
			return null;
		}
		return psnList.get(0);
	}
	
	/**
	 * 查询医保产品
	 * @param codeHp
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static HPDO queryHpDO(String codeHp) throws BizException{
		//查询医保相关数据
		DAFacade daf = new DAFacade();
		List<HPDO> hpList = (List<HPDO>)daf.findByAttrValString(HPDO.class, HPDO.CODE, codeHp, new String[]{HPDO.ID_HP});
		
		if(ListUtil.isEmpty(hpList)){
			throw new BizException("根据医保编码未查询到医保产品信息，医保编码:" + codeHp);
		}
		
		return hpList.get(0);
	}
	
	/**
	 * 查询患者分类数据
	 * @param hpId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static PiPatCaDO[] queryPatCa(String hpId) throws BizException{
		
		String sql = "select id_hp,id_patca from pi_pat_ca_hp where id_hp = ? ";
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);
		
		List<PiPatCaDO> patCaList = (List<PiPatCaDO>)new DAFacade().execQuery(sql, param, new BeanListHandler(PiPatCaDO.class));
		if(ListUtil.isEmpty(patCaList)){
			throw new BizException("未查询到医保产品id对应的患者分类，医保产品id" + hpId);
		}
		
		return patCaList.toArray(new PiPatCaDO[0]);
	}
}
