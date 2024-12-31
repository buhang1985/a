package iih.bl.cg.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.cg.blcgipprelogdo.d.BlCgIppreLogDO;
import iih.bl.cg.blcgipprelogdo.i.IBlcgipprelogdoCudService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.dto.d.BlPreIpParamDTO;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预住院转门诊（只转移正向数据）
 * 按PreIpToOepBP定义出入参处理
 * @author ly 2020/05/08
 *
 */
public class PreIpToOepBP2 {

	private static final String NOTE = "预住院转门诊费用";
	
	private Integer BLCG0037;
	private Integer BlCG0038;
	
	private final IBlcgoepCudService cgOepCudService;
	private final IBlcgipprelogdoCudService logService;
	private final IBlcgqueryCudService cgIpService;
	
	public PreIpToOepBP2(){
		
		BLCG0037 = BlParams.BLCG0037();
		BlCG0038 = BlParams.BLCG0038();
		
		cgOepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		logService = ServiceFinder.find(IBlcgipprelogdoCudService.class);
		cgIpService = ServiceFinder.find(IBlcgqueryCudService.class);
		
	}
	
	/**
	 * 转移逻辑
	 * @param blPreIpParamDto
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(BlPreIpParamDTO blPreIpParamDto) throws BizException {
		
		FBoolean hasData = FBoolean.FALSE;
		//查询待转移记录
		while(true){
		
			List<BlCgIpDO> list = this.getCgDos(blPreIpParamDto, 500);
			if(list == null || list.size() == 0){
				break;
			}
			hasData = FBoolean.TRUE;
			this.preIpListToOepItms(list);
		}
		
		return hasData;
	}
	
	/**
	 * 查询住院记账数据
	 * @param paramDto
	 * @param rowno
	 * @return
	 * @throws DAException
	 */
	private List<BlCgIpDO> getCgDos(BlPreIpParamDTO paramDto,Integer rowno) throws DAException{
		StringBuilder sql = new StringBuilder();
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		this.setSqlAndParam(sql, paramDto, param, rowno);
		@SuppressWarnings("unchecked")
		List<BlCgIpDO> list = (List<BlCgIpDO>) daf.execQuery(sql.toString(), param, new BeanListHandler(BlCgIpDO.class));
		return list;
	}
	
	/**
	 * 设置sql和param
	 * @param paramDto
	 * @param param
	 */
	private void setSqlAndParam(StringBuilder sql,BlPreIpParamDTO paramDto, SqlParam param, Integer rowno){
		
		sql.append("select * from (");
		sql.append("select	");
		sql.append("	rownum row_no, cg.*	");
		sql.append("from bl_cg_ip cg ");

		sql.append("left join ci_order cor on cor.id_or = cg.id_or ");
		sql.append("where cg.code_enttp = ?	");
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		sql.append("and cg.id_ent = ?	");
		param.addParam(paramDto.getId_ent());		
		sql.append("and not EXISTS(SELECT plg.id_cgip_pre FROM bl_cg_ippre_log plg where plg.id_cgip_pre = cg.id_cgip)	");
		sql.append("and cg.fg_real = 'Y'	");
		sql.append("and cg.fg_refund = 'N'	");
		sql.append("and cg.eu_direct = 1 ");
		
		//排序父-
		sql.append(" order by cg.id_cgip ");
	
		sql.append(" )  ");
		if(rowno != null){
			sql.append(" where row_no < ? ");
			param.addParam(rowno);
		}
	}

	/**
	 * 转移数据
	 * @param list
	 * @param dt_end
	 * @throws BizException
	 */
	private void preIpListToOepItms(List<BlCgIpDO> list) throws BizException{
		
		List<BlcgoepAggDO> oepAggList = new ArrayList<BlcgoepAggDO>();
		List<BlCgIppreLogDO> preLogList = new ArrayList<BlCgIppreLogDO>();
		List<BlCgIpDO> cgIpList = new ArrayList<BlCgIpDO>();
		
		String[] keys =  new DBUtil().getOIDs(list.size());
		for (int i = 0; i < list.size(); i++) {
			BlCgIpDO cgIpDO = list.get(i);
			String key = keys[i];
					
			BlcgoepAggDO cgOepAggDO = this.createCgOepAggDO(cgIpDO, key);
			oepAggList.add(cgOepAggDO);
			
			BlCgIppreLogDO preLogDO =  this.createPreLogDO(cgIpDO, cgOepAggDO.getBlCgItmOepDO()[0]);
			preLogList.add(preLogDO);
			
			BlCgIpDO redCgIpDO = this.redCgIpDO(cgIpDO);
			cgIpList.add(redCgIpDO);
			
			cgIpDO.setQuan_ret(cgIpDO.getQuan());
			cgIpDO.setFg_refund(FBoolean.TRUE);
			cgIpDO.setStatus(DOStatus.UPDATED);
		}
		
		cgOepCudService.insert(oepAggList.toArray(new BlcgoepAggDO[0]));
		logService.insert(preLogList.toArray(new BlCgIppreLogDO[0]));
		cgIpService.insert(cgIpList.toArray(new BlCgIpDO[0]));
		cgIpService.update(list.toArray(new BlCgIpDO[0]));
	}
	
	/**
	 * 组装门诊记账数据
	 * @param cgIpDO
	 * @param key
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO createCgOepAggDO(BlCgIpDO cgIpDO,String key) throws BizException{
		
		BlCgItmOepDO itm = new BlCgItmOepDO();
		String[] itmNames = itm.getAttrNames();
		List<String> ipNames = Arrays.asList(cgIpDO.getAttrNames());
		for(String name : itmNames){
			if(ipNames.contains(name)){
				itm.setAttrVal(name, cgIpDO.getAttrVal(name));
			}
		}
		itm.setId_cgitmoep(key);
		itm.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE);
		itm.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		if(1 == BlCG0038){
			itm.setDt_cg(BlFlowContextUtil.getNowTime());
			itm.setDt_srv(BlFlowContextUtil.getNowTime());
		}
		itm.setNote(NOTE);
		itm.setStatus(DOStatus.NEW);
		
		//清空账单项及核算项
		itm.setCode_inccaitm(null);
		itm.setName_inccaitm(null);
		itm.setCode_account(null);
		itm.setName_account(null);
		
		if(cgIpDO.getQuan_ret().compareTo(FDouble.ZERO_DBL) > 0){
			FDouble quan = cgIpDO.getQuan().sub(cgIpDO.getQuan_ret());
			itm.setQuan(quan);
			itm.setAmt_std(itm.getPrice().multiply(quan,IBlConst.PRECISION_AMOUNT));
			itm.setAmt_ratio(itm.getPrice_ratio().multiply(quan, IBlConst.PRECISION_AMOUNT));
			itm.setAmt(itm.getAmt_ratio());
			itm.setAmt_pat(itm.getAmt_ratio());
			itm.setAmt_hp(FDouble.ZERO_DBL);
		}
		
		BlCgOepDO cgOepDO = new BlCgOepDO();
		cgOepDO.setId_grp(cgIpDO.getId_grp());
		cgOepDO.setId_org(cgIpDO.getId_org());
		cgOepDO.setId_org_cg(cgIpDO.getId_org_cg());
		cgOepDO.setId_pat(cgIpDO.getId_pat());
		cgOepDO.setId_dep_cg(cgIpDO.getId_dep_cg());
		cgOepDO.setId_emp_cg(cgIpDO.getId_emp_cg());
		cgOepDO.setCode_cg(cgIpDO.getCode_cg());
		cgOepDO.setEu_direct(cgIpDO.getEu_direct());
		if(2 == BlCG0038){
			cgOepDO.setDt_cg(cgIpDO.getDt_cg());
		}else{
			cgOepDO.setDt_cg(BlFlowContextUtil.getNowTime());
		}
		cgOepDO.setStatus(DOStatus.NEW);
		
		BlcgoepAggDO aggDO = new BlcgoepAggDO();
		aggDO.setParentDO(cgOepDO);
		aggDO.setBlCgItmOepDO(new BlCgItmOepDO[]{itm});
		return aggDO;
	}
	
	/**
	 * 组装转移记录数据
	 * @param cgIpDO
	 * @param cgOepItmDO
	 * @return
	 * @throws BizException
	 */
	private BlCgIppreLogDO createPreLogDO(BlCgIpDO cgIpDO,BlCgItmOepDO cgOepItmDO) throws BizException{
		
		BlCgIppreLogDO log = new BlCgIppreLogDO();
		log.setId_cgip_pre(cgIpDO.getId_cgip());
		if(1 == BLCG0037){
			log.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			log.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		}else{
			log.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			log.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		}
		log.setId_ent(cgIpDO.getId_ent());
		log.setId_cgip_new(cgOepItmDO.getId_cgitmoep());
		log.setQuan(cgOepItmDO.getQuan());
		log.setAmt(cgOepItmDO.getAmt_ratio());
		log.setId_emp_oper(Context.get().getStuffId());
		log.setDt_oper(BlFlowContextUtil.getNowTime());
		log.setFg_active(FBoolean.TRUE);
		log.setNote(NOTE);
		log.setStatus(DOStatus.NEW);
		
		return log;
	}
	
	/**
	 * 退记账
	 * @param cgIpDO
	 * @return
	 * @throws BizException
	 */
	private BlCgIpDO redCgIpDO(BlCgIpDO cgIpDO) throws BizException{
		
		BlCgIpDO newCgIpDO = (BlCgIpDO)cgIpDO.clone();
		newCgIpDO.setId_cgip(null);
		newCgIpDO.setId_par(cgIpDO.getId_cgip());
		newCgIpDO.setEu_direct(cgIpDO.getEu_direct() * -1);
		newCgIpDO.setFg_real(FBoolean.FALSE);
		newCgIpDO.setQuan_ret(FDouble.ZERO_DBL);
		
		if(cgIpDO.getQuan_ret().compareTo(FDouble.ZERO_DBL) > 0){
			//重新计算退数量及金额
			FDouble quan = cgIpDO.getQuan().sub(cgIpDO.getQuan_ret());
			newCgIpDO.setAmt_std(newCgIpDO.getPrice().multiply(quan,IBlConst.PRECISION_AMOUNT));
			newCgIpDO.setAmt_ratio(newCgIpDO.getPrice_ratio().multiply(quan, IBlConst.PRECISION_AMOUNT));
			newCgIpDO.setAmt(newCgIpDO.getAmt_ratio());
			newCgIpDO.setAmt_pat(newCgIpDO.getAmt_ratio());
			newCgIpDO.setAmt_hp(FDouble.ZERO_DBL);
			newCgIpDO.setQuan(quan);
		}
		newCgIpDO.setDt_oper_cg(BlFlowContextUtil.getNowTime());
		newCgIpDO.setStatus(DOStatus.NEW);
		return newCgIpDO;
	}
}
