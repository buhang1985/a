package iih.bl.hp.s.bp.qry;



import iih.bl.params.BlParams;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.mi.itf.bizgrpitf.constant.BdMhiParamValueConst;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询住院记账明细(条件查询)
 * Title: GetIpBillItmDtosQryPag.java
 * @author zhang.hw
 * @date 2019年4月29日  
 * @version 1.0
 */
public class GetIpBillItmDtosQryPag implements ITransQry {

	String id_ent;
	String id_ent_mom;
	//住院结算id
	String id_stip;
	FBoolean isUploaded = FBoolean.FALSE;
	
	private String uploadMode;
	private String _wherePart;
	private FBoolean BLHP000023;//是否使用医嘱中的fg_selfpay字段
	
	public GetIpBillItmDtosQryPag(String strIdEnt,String idStip,FBoolean isUpload,String uploadMode,String wherePart) throws BizException {
		//判断母婴是否合并结算
		FBoolean isMerge = BlParams.BLSTIP0005();
		this.BLHP000023 = BlParams.BLHP000023();
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO enNewBorn = enService.getNewbornDO(strIdEnt);
		if(FBoolean.TRUE.equals(isMerge) && enNewBorn == null){
			this.id_ent_mom = strIdEnt;
		} 
		this.id_ent = strIdEnt;
		
		this.id_stip = idStip;
		this.isUploaded = isUpload;
		this.uploadMode = uploadMode;
		this._wherePart = wherePart;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer stringbuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this.isUploaded);
		if (!StringUtil.isEmptyWithTrim(this.id_stip)) {
			sqlParam.addParam(this.id_stip);
		}
		if (!StringUtil.isEmptyWithTrim(this.id_ent)) {
			sqlParam.addParam(this.id_ent);
		}
		if (!StringUtil.isEmptyWithTrim(this.id_ent_mom)) {
			sqlParam.addParam(this.id_ent_mom);
		}
		
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBF = new StringBuilder();
		
		sqlBF.append(" SELECT ");
		sqlBF.append(" CGIP.ID_ENT  ID_ENT,CGIP.ID_PAT,CGIP.CODE_CG,PAT.NAME  NAME_PAT,CGIP.ID_CGIP,CGIP.PRICE, ");
		sqlBF.append(" ENT.CODE  CODE_ENT,CGIP.PRICE_RATIO,CGIP.ID_SRV,CGIP.SRVU,MEASDOC.NAME  NAME_SRVU, ");
		sqlBF.append(" PSNDOC.CODE  ID_EMP_OR,PSNDOC.NAME  NAME_EMP_OR,CGIP.ID_DEP_OR,DEP.NAME  NAME_DEP_OR,  dep.code Code_dep_or,");
		sqlBF.append(" CGIP.FG_HP,CGIP.EU_DIRECT,  CASE  CGIP.EU_DIRECT  WHEN  1  THEN  '记费'  WHEN  -1  THEN  '退费'  END  EU_NAME,  CGIP.CODE_MM,CGIP.ID_SRVTP,CGIP.DT_SRV, ");
		sqlBF.append(" CGIP.DT_CG,CGIP.SD_SRVTP,CGIP.ID_MM,CGIP.NAME_MM,CGIP.ID_ORSRV,CGIP.CODE_INCCAITM,CGIP.NAME_INCCAITM, ");
		sqlBF.append(" CGIP.FG_BB,CGIP.ID_ENT_MOM,CGIP.NAME_SRV,CGIP.CODE_SRV,CGIP.FG_MM,CGIP.ID_PAR  ID_CGPAR ,CGIP.FG_REFUND, ");
		sqlBF.append(" mpdep.id_dep id_dep_mp,mpdep.name Name_dep_mp,mpdep.code Code_dep_mp, ");
		
		if(FBoolean.TRUE.equals(this.BLHP000023)){
			sqlBF.append(" nvl(orsrv.fg_selfpay,CGIP.fg_selfpay) fg_selfpay, ");
		}else{
			sqlBF.append(" CGIP.fg_selfpay Fg_selfpay, ");
		}
		
		if(BdMhiParamValueConst.BDMHI2009_ONLYFORWARD.equals(this.uploadMode)){
			sqlBF.append(" CGIP.QUAN - CGIP.QUAN_RET QUAN, ");
			sqlBF.append(" (CGIP.QUAN - CGIP.QUAN_RET) * PRICE_RATIO AMT_RATIO, ");
		}else{
			sqlBF.append(" CGIP.QUAN * CGIP.EU_DIRECT  QUAN, ");
			sqlBF.append(" CGIP.AMT_RATIO*CGIP.EU_DIRECT  AMT_RATIO, ");
		}
		
		sqlBF.append(" CGITM_IP.AMT_PAYZL  AMT_PAT  ,CGITM_IP.AMT_PAYZF  AMT_PAYZF  ,CGITM_IP.AMT_CXJ_PAYZF  AMT_CXJ_PAYZF, ");
		sqlBF.append(" CGITM_IP.RATE_PAYZL  RATE_PAYZL,CGITM_IP.SD_HPSRVTP  NAME_CHARGEGRADE  ,  CGITM_IP.HP_SRVCODE  HP_SRVCODE, ");
		sqlBF.append(" sum(CGIP.AMT_RATIO * CGIP.EU_DIRECT) over() amtsum, ");
		sqlBF.append(" sum(CGITM_IP.AMT_PAYZF) over() zfamtsum, ");
		sqlBF.append(" sum(CGITM_IP.AMT_PAYZL) over() zlamtsum, ");
		sqlBF.append(" sum(CGITM_IP.AMT_CXJ_PAYZF) over() cxjamtsum ");
		sqlBF.append(" FROM  BL_CG_IP  CGIP ");
		sqlBF.append(" INNER  JOIN  PI_PAT  PAT  ON  CGIP.ID_PAT=PAT.ID_PAT ");
		sqlBF.append(" INNER  JOIN  EN_ENT  ENT  ON  ENT.ID_ENT=CGIP.ID_ENT ");
		sqlBF.append(" LEFT  JOIN  BD_MEASDOC  MEASDOC  ON  CGIP.SRVU=MEASDOC.ID_MEASDOC ");
		sqlBF.append(" LEFT  JOIN  BD_PSNDOC  PSNDOC  ON  CGIP.ID_EMP_OR=PSNDOC.ID_PSNDOC ");
		sqlBF.append(" LEFT  JOIN  BD_DEP  DEP  ON  CGIP.ID_DEP_OR=DEP.ID_DEP ");
		sqlBF.append(" LEFT  JOIN  BL_HP_CGITM_IP  CGITM_IP  ON  CGITM_IP.ID_CGIP=CGIP.ID_CGIP ");
		sqlBF.append("  left join bd_dep mpdep on mpdep.id_dep=cgip.id_dep_mp ");
		if(FBoolean.TRUE.equals(this.BLHP000023)){
			sqlBF.append(" left join ci_or_srv orsrv on CGIP.id_orsrv = orsrv.id_orsrv ");
		}
		
		sqlBF.append(" WHERE  cgip.fg_hp = ? ");
		if(!StringUtils.isEmptyWithTrim(this.id_stip)) {
			sqlBF.append(" and cgip.id_stip = ? ");
		}
		else{
			sqlBF.append(" and cgip.fg_st='N' ");
		}
		
		if(BdMhiParamValueConst.BDMHI2009_ONLYFORWARD.equals(this.uploadMode)){
			sqlBF.append(" AND CGIP.EU_DIRECT = 1 ");
			sqlBF.append(" AND CGIP.FG_REFUND = 'N' ");
		}
		
		if (!StringUtil.isEmptyWithTrim(this.id_ent_mom)) {
			sqlBF.append(" AND (CGIP.ID_ENT = ? or cgip.ID_ENT_mom = ? )");
		} else {
			sqlBF.append(" AND (CGIP.ID_ENT = ?  )");
		}
		if (this._wherePart != null) {
			sqlBF.append(" AND ");
			sqlBF.append(this._wherePart);
		}
		if(this.isUploaded.booleanValue()) {
			sqlBF.append("  ORDER BY CGIP.EU_DIRECT ,CGIP.CODE_SRV,CGIP.ID_CGIP,CGIP.DT_CG,CGIP.ID_PAR ");
		} else {
			sqlBF.append("  ORDER BY CGIP.EU_DIRECT DESC,CGIP.CODE_SRV,CGIP.ID_CGIP, CGIP.DT_CG,CGIP.ID_PAR ");
		}
		

		return sqlBF.toString();
	}
}
