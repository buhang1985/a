package iih.bl.cg.bp.ippre;

import java.util.ArrayList;
import java.util.List;

import com.core.AppUtils;
import com.enterprisewechat.cp.util.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgipprelogdo.d.BlCgIppreLogDO;
import iih.bl.cg.blcgipprelogdo.i.IBlcgipprelogdoCudService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.params.BlParams;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预住院转住院后的费用处理
 * @author xb 2020/02/13
 *
 */
public class TrunIpPreToIpBp {
	
	public static final Integer BLCG0039_CurrentDt = 1;
	public static final Integer BLCG0039_OldDt = 2;
	public static final Integer BlCg0037_ToIpOnlySelfPay = 3;
	
	/**
	 * 预住院转住院后的费用处理
	 * 
	 * 【使用场景】：
	 * 		预住院转住院。 
	 * 【业务逻辑】：
	 * 		（1）对预住院产生的记账明细进行全红冲（产生的红冲数据code_entp同原始记录） 
	 * 		（2）红冲后，需要产生新的记账明细，其中：
	 * 			1）code_entp: 10（住院就诊类型编码） 
	 * 			2）id_entp: 住院就诊类型ID
	 * 			3）dt_cg：根据参数“BLCG0039”的配置来决定， 若配置为（1：记账时间为当前时间），则dt_cg为：入参传入的预住院转住院时间；
	 * 		若配置为（2：记账时间为原始时间）, 则dt_cg为：原始记账时间。
	 * 			4）dt_srv：同dt_cg 
	 * 			5）note: 预住院转住院费用
	 * 			6）fg_selfpay：若BLCG0037配置为“3”，则需要将fg_selfpay设置为‘Y’。
	 * 		（3）对每条转的记账均需要：存入预住院费用转出日志 bl_cg_ippre_log，参见数据表中对各字段描述。
	 * @param id_ent 就诊ID
	 * @param dtIpPreToIp 预住院转住院时间
	 * @return 布尔型 Y: 转入成功 N：转入失败 
	 * @throws BizException
	 * @author xb 2020/02/13
	 */
	@SuppressWarnings("unchecked")
	public FBoolean exec(String id_ent, FDateTime dtIpPreToIp) throws BizException {
		// 1. 检查入参
		IsParamOk(id_ent, dtIpPreToIp);

		// 2. 对预住院产生的记账明细进行全红冲
		// 2.1 查询预住院期间的所有记账数据
		BlCgIpDO[] ipPreCgArr = getCgIpPreDatas(id_ent);
		if(ArrayUtil.isEmpty(ipPreCgArr))
			return FBoolean.FALSE;
		

		// 2.2 对所有预住院记账信息进行红冲处理
		BlCgIpDO[] redIpPreCg = getRedIpPreDatas(ipPreCgArr);
		IBlcgqueryCudService cgService = ServiceFinder.find(IBlcgqueryCudService.class);
		redIpPreCg = cgService.save(redIpPreCg);

		// 3. 产生新的记账明细
		BlCgIpDO[] newIpCg = getIpPreToIpCgDatas(ipPreCgArr, dtIpPreToIp);
		newIpCg = cgService.save(newIpCg);
		
		// 4. 记录Bl_cg_ippre_log
		BlCgIppreLogDO[] logArr = getIpPreToIpLog(ipPreCgArr); 
		IBlcgipprelogdoCudService logService = ServiceFinder.find(IBlcgipprelogdoCudService.class);
		logArr = logService.save(logArr);
		
		return FBoolean.TRUE;
	}
	
	/**
	 * 对入参进行校验
	 * @param id_ent 就诊ID
	 * @param dtIpPreToIp 转住院的时间
	 * @throws BizException
	 */
	private void IsParamOk(String id_ent, FDateTime dtIpPreToIp) throws BizException {
		if (StringUtils.isBlank(id_ent)) {
			throw new BizException("【预住院转住院】就诊ID不可为空！");
		}

		if (dtIpPreToIp == null) {
			throw new BizException("【预住院转住院】预住院转住院时间不可为空！");
		}

		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDo = service.findById(id_ent);
		
		if (patiVisitDo == null){
			throw new BizException("【预住院转住院】患者就诊信息不存在！");
		}

		if (!IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE.equals(patiVisitDo.getCode_entp())) {
			throw new BizException("【预住院转住院】就诊类型必须为预住院！");
		}
	}
	
	/**
	 * 查询本次就诊预住院记账数据
	 * 
	 * @param entId 就诊ID
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlCgIpDO[] getCgIpPreDatas(String id_ent) throws BizException {

		if (StringUtil.isEmpty(id_ent)) {
			throw new BizException("【预住院转住院】就诊ID不可为空！");
		}

		String sql = " select id_cgip,id_dep_nur from bl_cg_ip where " + " eu_direct = 1 and fg_refund = 'N' "
				+ " code_entp = ? " + " and id_ent = ? ";
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		param.addParam(id_ent);

		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sql, param,
				new BeanListHandler(BlCgIpDO.class));

		if (ListUtil.isEmpty(list))
			return null;
		return list.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 得到红冲预住院记账数据
	 * @param ipPreCgArr 预住院记账数据
	 * @return
	 */
	private BlCgIpDO[] getRedIpPreDatas(BlCgIpDO[] ipPreCgArr) {
		if (ArrayUtil.isEmpty(ipPreCgArr))
			return null;
		
		List<BlCgIpDO> list = new ArrayList<BlCgIpDO>();
		int nCgNum = ipPreCgArr.length;
		for (int i = 0; i < nCgNum; i++) {
			BlCgIpDO oldCgIpPre = ipPreCgArr[i];
			BlCgIpDO reCgIpPre = oldCgIpPre;
			reCgIpPre.setId_cgip(null);
			reCgIpPre.setEu_direct(oldCgIpPre.getEu_direct() * (-1));
			reCgIpPre.setId_par(oldCgIpPre.getId_cgip());
			reCgIpPre.setStatus(DOStatus.NEW);
			list.add(reCgIpPre);
		}

		if (ListUtil.isEmpty(list))
			return null;
		return list.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 得到预住院转住院后的新记账数据
	 * 
	 * @param ipPreCgArr 预住院的原始记账
	 * @param dtIpPreToIp 预住院转住院时间
	 *            预住院记账数据 
	 *            1）code_entp: 10（住院就诊类型编码） 
	 *            2）id_entp: 住院就诊类型ID
	 *            3）dt_cg：根据参数“BLCG0039”的配置来决定，
	 *            若配置为（1：记账时间为当前时间），则dt_cg为：入参传入的预住院转住院时间；
	 *            若配置为（2：记账时间为原始时间）, 则dt_cg为：原始记账时间。
	 *            4）dt_srv：同dt_cg 
	 *            5）note: 预住院转住院费用
	 *            6）fg_selfpay：若BLCG0037配置为“3”，则需要将fg_selfpay设置为‘Y’。
	 * @return
	 * @throws BizException 
	 */
	private BlCgIpDO[] getIpPreToIpCgDatas(BlCgIpDO[] ipPreCgArr, FDateTime dtIpPreToIp) throws BizException {
		if (ArrayUtil.isEmpty(ipPreCgArr))
			return null;

		Integer nBLCG0037 = BlParams.BLCG0037();
		Integer nBLCG0039 = BlParams.BLCG0039();
		if (nBLCG0037 == null) {
			throw new BizException("【预住院转住院】BLCG0037不可为空！");
		}
		if (nBLCG0039 == null) {
			throw new BizException("【预住院转住院】BLCG0039不可为空！");
		}
		if (nBLCG0039.equals(BLCG0039_CurrentDt) && dtIpPreToIp == null) {
			throw new BizException("【预住院转住院】预住院转住院时间不可为空！");
		}
		
		String strNote = getNoteByBlCg0037();

		List<BlCgIpDO> list = new ArrayList<BlCgIpDO>();
		int nCgNum = ipPreCgArr.length;
		for (int i = 0; i < nCgNum; i++) {
			BlCgIpDO oldCgIpPre = ipPreCgArr[i];
			BlCgIpDO newCgIp = oldCgIpPre;
			newCgIp.setId_cgip(null);
			newCgIp.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			newCgIp.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			if (nBLCG0039.equals(BLCG0039_CurrentDt)) {
				newCgIp.setDt_cg(dtIpPreToIp);
			} else if (nBLCG0039.equals(BLCG0039_OldDt)) {
				newCgIp.setDt_cg(oldCgIpPre.getDt_cg());
			}
			newCgIp.setDt_srv(newCgIp.getDt_cg());
			newCgIp.setNote(strNote);
			if (nBLCG0037.equals(BlCg0037_ToIpOnlySelfPay)) {
				newCgIp.setFg_selfpay(FBoolean.TRUE);
			}
			newCgIp.setId_par(oldCgIpPre.getId_cgip());
			newCgIp.setStatus(DOStatus.NEW);

			list.add(newCgIp);
		}

		if (ListUtil.isEmpty(list))
			return null;
		return list.toArray(new BlCgIpDO[0]);
	}
	
	/**
	 * 得到存入预住院费用转出日志
	 * @param ipPreCgArr
	 * @return
	 * @throws BizException
	 */
	private BlCgIppreLogDO[] getIpPreToIpLog(BlCgIpDO[] ipCgArr) throws BizException{
		if (ArrayUtil.isEmpty(ipCgArr))
			return null;
		
		String strNote = getNoteByBlCg0037();
		FDateTime nowDt = AppUtils.getServerDateTime();
		
		List<BlCgIppreLogDO> list = new ArrayList<BlCgIppreLogDO>();
		int nCgNum = ipCgArr.length;
		for(int i= 0; i<nCgNum; i++ )
		{
			BlCgIpDO newCgIpDo = ipCgArr[i];
			BlCgIppreLogDO logDo = new BlCgIppreLogDO();
			
			logDo.setId_cgip_pre(newCgIpDo.getId_par());
			logDo.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			logDo.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			logDo.setId_cgip_new(newCgIpDo.getId_cgip());
			logDo.setId_emp_oper(Context.get().getStuffId());
			logDo.setDt_oper(nowDt);
			logDo.setNote(strNote);
			logDo.setStatus(DOStatus.NEW);

			list.add(logDo);
		}
		
		if (ListUtil.isEmpty(list))
			return null;
		return list.toArray(new BlCgIppreLogDO[0]);
	}
	
	private String getNoteByBlCg0037() throws BizException
	{
		String strNote = "预住院费用转住院费用";
		Integer nBLCG0037 = BlParams.BLCG0037();
		if (nBLCG0037 == null) {
			throw new BizException("【预住院转住院】BLCG0037不可为空！");
		}

		if (nBLCG0037.equals(BlCg0037_ToIpOnlySelfPay)) {
			strNote = "预住院费用转住院费用，自费";
		}
		return strNote;
	}
}