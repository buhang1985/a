package iih.bl.cc.ep;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cc.blcc.d.BlCcDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.d.desc.BlCcDODesc;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.blcc.i.IBlccMDORService;
import iih.bl.comm.log.BLTaskLogger;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 结账EP
 * @author yankan
 * @since 2017-06-19
 *
 */
public class CcEP {
	/*
	 * 设置结账开始日期
	 * */
	public FDateTime getBlccDODtbInfo(String id_user, String sd_cctp, FDateTime end_time) throws BizException{
		//结账开始日期
		FDateTime dt_b = null;
		StringBuffer sb = new StringBuffer();
		sb.append(" a0.id_emp = '").append(id_user).append("'")
//		  .append(" and a0.id_org = '").append(id_org).append("'")
		  .append(" and a0.sd_cctp = '").append(sd_cctp).append("'")
		  .append(" and a0.fg_canc = 'N'");
		IBlccMDORService service = ServiceFinder.find(IBlccMDORService.class);
		BlCcDO[] blccDOArr = service.find(sb.toString(), " a0.dt_e desc", FBoolean.FALSE);
		if(blccDOArr != null && blccDOArr.length > 0){
			dt_b = blccDOArr[0].getDt_e();
		}		
		return dt_b;
	}	
	
	/**
	 * 保存空结账记录
	 * @param id_user 待结账人员id
	 * @param sd_cctp 结账类型
	 * @param end_time 结账日期
	 * @param ccPsn 已结账人员id
	 * @throws BizException 
	 */
	public void saveEmptyBlccAggDO(String[] id_user,List<String> sdCctpList ,FDateTime end_time,List<String> ccPsn) throws BizException{
		//获取人员信息
		PsnDocDO[] psnArr=this.getPsn(id_user);
		if(ArrayUtil.isEmpty(psnArr))
			return;
		for(PsnDocDO psn : psnArr){
			//如果操作员没参与此次自动结账，则生成一条空的结账记录
			if(!ccPsn.contains(psn.getId_psndoc())){
				//如果参数中人员未参与此次结账，则生成结账数据
				BLTaskLogger.info(String.format("人员%s(%s)自动结账开始", psn.getName(), psn.getCode()));
				for(String sd_cctp :sdCctpList){
					BlccAggDO blccAggDO=this.setEmptyBlccAggDO(psn, sd_cctp, end_time);
					IBlccCudService blccService = ServiceFinder.find(IBlccCudService.class);
					blccService.save(new BlccAggDO[]{blccAggDO});
				}	
				BLTaskLogger.info(String.format("人员%s(%s)自动结账结束", psn.getName(), psn.getCode()));
			}
		}
	}
	/**
	 * 设置空do，没有结账数据时也保存一条结账记录
	 * @return
	 * @throws BizException 
	 */
	private BlccAggDO setEmptyBlccAggDO(PsnDocDO psn,String sd_cctp ,FDateTime end_time) throws BizException{
		
		BlccAggDO blccAggDO= new BlccAggDO();
		//结账
		BlCcDO blccDO = new BlCcDO();
		blccDO.setId_org(psn.getId_org());//机构		
		blccDO.setId_grp(psn.getId_group());
		blccDO.setCode_cc(this.getCode_cc(blccDO, end_time));
		blccDO.setSd_cctp(sd_cctp);//结账类型编码
		blccDO.setId_cctp(this.convertSdCctpToIdCctp(sd_cctp));
		blccDO.setId_emp(psn.getId_psndoc());//操作员	
		blccDO.setDt_b(this.getBlccDODtbInfo(psn.getId_psndoc(), sd_cctp, end_time));//结账结束日期
		blccDO.setDt_e(end_time);//结账结束日期
		blccDO.setAmt(new FDouble());//收款金额
		blccDO.setAmt_return(new FDouble());//退款金额

		blccDO.setIncnos("");//使用结算发票号信息串
		blccDO.setInccn(0);
		blccDO.setIncnos_canc("");//作废结算发票号信息串
		blccDO.setInccn_canc(0);
		blccDO.setAmt_st(new FDouble());
		blccDO.setAmt_return(new FDouble());
		blccDO.setAmt_pvprepay(new FDouble());//收款金额
		blccDO.setAmt_pvprepay_ret(new FDouble());//退款金额
		
		blccDO.setAmt_entprepay(new FDouble());
		blccDO.setAmt_entprepay_ret(new FDouble());
		blccDO.setIncnos_pvprepay("");//住院押金收据使用号码串
		blccDO.setIncnos_pvprepay_ret("");//住院押金收据收回号码串
		blccDO.setInccn_pvprepay(0);
		blccDO.setInccn_pvprepay_ret(0);
		
		blccDO.setIncnos_re("");//退费发票号信息串
		blccDO.setChqnos("");//支票号信息串
		blccDO.setChqcn(0);
		blccDO.setInccn_re(0);
		blccDO.setDt_canc(null);
		blccDO.setFg_canc(FBoolean.FALSE);//结账取消标志
		blccDO.setDt_cc(new FDateTime());//结账日期时间
		blccDO.setFg_fi(FBoolean.FALSE);//财务交割标志
		blccDO.setDt_fi(null);//财务交割日期
		blccDO.setId_fi(null);//财务交割
		blccDO.setAmt_dif(blccDO.getAmt().sub(blccDO.getAmt_return()));
		blccDO.setStatus(DOStatus.NEW);//设置对象为新增数据
		blccAggDO.setParentDO(blccDO);
		return blccAggDO;
	}
	
	/**
	 * 结账类型编码转换成id
	 * @param sd_cctp
	 * @return
	 */
	private  String convertSdCctpToIdCctp(String sd_cctp){
		String id_cctp="";
		switch (sd_cctp) {
			case IBlDictCodeConst.SD_CCTP_ZYLC://住院流程结账
				id_cctp=IBlDictCodeConst.SD_CCTP_ID_ZYLC;
				break;
			case IBlDictCodeConst.SD_CCTP_ZYYJJ://住院预交金结账
				id_cctp=IBlDictCodeConst.SD_CCTP_ID_ZYYJJ;
				break;	
			case IBlDictCodeConst.SD_CCTP_ZYSF://住院收费结账
				id_cctp=IBlDictCodeConst.SD_CCTP_ID_ZYSF;
				break;
			case IBlDictCodeConst.SD_CCTP_MZLC://门诊流程结账
				id_cctp=IBlDictCodeConst.SD_CCTP_ID_MZLC;
				break;
			case IBlDictCodeConst.SD_CCTP_MZSF://门诊收费结账
				id_cctp=IBlDictCodeConst.SD_CCTP_ID_MZSF;
				break;	
			case IBlDictCodeConst.SD_CCTP_MZYJJ://门诊预交金结账
				id_cctp=IBlDictCodeConst.SD_CCTP_ID_MZYJJ;
				break;					
			default:
				break;
		}
		return id_cctp;
	}

	/**
	 * 获取参数中的人员数据
	 * 
	 * @param idPsnArr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PsnDocDO[] getPsn(String[] idPsnArr) throws BizException {
		DAFacade daf = new DAFacade();
		StringBuilder sqlWhere = new StringBuilder();

		sqlWhere.append("SELECT DISTINCT BD_PSNDOC.ID_PSNDOC,  ");
		sqlWhere.append("BD_PSNDOC.CODE, ");
		sqlWhere.append("BD_PSNDOC.NAME, ");
		sqlWhere.append("BD_PSNDOC.ID_GROUP, ");
		sqlWhere.append("BD_PSNDOC.ID_ORG, ");
		sqlWhere.append("BD_PSNDOC.ID_DEP ");
		sqlWhere.append(" FROM BD_PSNDOC ");
		sqlWhere.append(" WHERE ");
		sqlWhere.append(SqlUtils.getInSqlByIds("ID_PSNDOC", idPsnArr));
		
		List<PsnDocDO> list = (List<PsnDocDO>) daf.execQuery(sqlWhere.toString(), new BeanListHandler(PsnDocDO.class));
		if (list != null)
			return list.toArray(new PsnDocDO[list.size()]);
		return null;
	}
	
	/**
	 * 根据操作员和结账日期和结账类型和编码规则获取结账号
	 * @param ccDo
	 * @return
	 * @author hanJQ 2019年3月18日
	 * @throws BizException 
	 */
	private String getCode_cc(BlCcDO ccDo ,FDateTime end_time) throws BizException{
		String Code_cc = null;
		
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		Code_cc = codeManage.getBillCode_RequiresNew(BlCcDODesc.CLASS_FULLNAME,ccDo);
		if(StringUtils.isBlank(Code_cc)){
			StringBuilder sf = new StringBuilder();
			sf.append("SELECT count(1) FROM BL_CC WHERE ID_EMP = ? AND ID_CCTP = ? AND DT_CC >= ? AND DT_CC <= ?;");
			SqlParam sp = new SqlParam();
			sp.addParam(ccDo.getId_emp());
			sp.addParam(ccDo.getId_cctp());
			sp.addParam(end_time.getDate()+" 00:00:00");
			sp.addParam(end_time.getDate()+" 23:59:59");
			int count=(int) new DAFacade().execQuery(sf.toString(),sp, new ColumnHandler());		
			Code_cc = (count+1)+"";
		}
		return Code_cc;
	}
}
