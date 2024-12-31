package iih.bl.hp.s.miparampack.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUploadInpDetailsParamQry implements ITransQry{
	
	String ent =null;
	String stip=null;
	public GetUploadInpDetailsParamQry(String ent,String stip){
		this.ent=ent;
		this.stip=stip;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (!StringUtil.isEmpty(ent)) {
			sqlParam.addParam(ent);
		}
		if (!StringUtil.isEmpty(stip)) {
			sqlParam.addParam(stip);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		                                                                        
		sb.append("SELECT CGIP.CODE_INCCAITM FEETP_CODE,/*账单项编码*/ ");//his系统项目编码
		sb.append("CGIP.NAME_INCCAITM FEETP_NAME,/*账单项名称*/ ");//his系统项目名称
		sb.append("CGIP.ID_CGIP BILLITEMNO,/*记账主键*/ ");//项目序号
		sb.append("(CASE WHEN CGIP.FG_MM='Y' THEN CGIP.CODE_MM ELSE CGIP.CODE_SRV END)HISITEMCODE,/*服务项目编码&&物品编码*/  "); //费用类别编码
		sb.append("(CASE WHEN CGIP.FG_MM='Y' THEN CGIP.NAME_MM ELSE CGIP.NAME_SRV END)HISITEMNAME,/*服务项目名称&&物品名称*/  ");//费用类别名称
		sb.append("CGIP.SD_SRVTP SRVTP,/*服务项目分类编码*/ ");//项目类别
		sb.append("CGIP.AMT_Ratio*CGIP.EU_DIRECT AMT,/*折扣金额*记退费方向*/ ");//金额
		sb.append("CGIP.AMT_Ratio*CGIP.EU_DIRECT AMT_HP,/*折扣金额*记退费方向*/ ");//可报销金额
		sb.append("CGIP.SRVU,/*服务项目单位*/ ");//单位
		sb.append("CGIP.PRICE,/*价格*/  ");//单价
		sb.append("CGIP.QUAN*CGIP.EU_DIRECT QUAN,/*数量*记退费方向*/  ");//数量
		sb.append("CGIP.SPEC,/*物品规格*/  ");//规格
		sb.append("CGIP.QUAN*CGIP.EU_DIRECT ORDERS,/*数量*记退费方向*/  ");//付数
		sb.append("CGIP.ID_CGIP PRESNO,/*记账主键*/  ");//处方号
		sb.append("CGIP.DT_SRV PRESDATE,/*服务项目发生日期*/  ");//处方日期
//		sb.append("CGIP.RATIO_HP RATIO_SELF,/*自付比例*/   ");
//		sb.append("CGIP.AMT_RATIO AMT_DEDUCT,/*明细扣款金额*/ ");
//		sb.append("nvl(ORD.ORDERS_BOIL,0) ORDERS,/*付数*/  ");
		sb.append("CGIP.DT_CG,/*记账日期时间*/  ");//计费日期
		sb.append("CGIP.FG_MM HIS_FG_DRUG,/*物品标志*/ ");//是否药品
		//sb.append("ORD.ID_FREQ FREQ,/*频次*/  ");
//		sb.append("MHI.CODE HPITEMCODE,/*医保项目代码*/  ");
//		sb.append("MHI.NAME HPITEMNAME, /*医保项目名称*/   ");
		sb.append("PSNDOC1.NAME DOCTORNAME, /*医生姓名*/   ");
		sb.append("PSNDOC1.CODE DOCTORCODE, /*处方医师编码*/  ");
//		sb.append("ORG.CODE HOSPCODE, /*就医机构代码*/  ");
//		sb.append("ORG.NAME HOSPNAME, /*就医机构名称*/   ");
		sb.append("DEP.CODE DEPCODE, /*科别编码*/   ");
		sb.append("DEP.NAME DEPNAME, /*科别名称*/     ");
		sb.append("AH.HP_ENT_SERIAL_NO INNPO/*就诊流水号*/ " );//住院流水号
//		sb.append("PSNDOC2.NAME OPERATORNAME /*经办人*/   ");
		
		sb.append("FROM BL_CG_IP CGIP /*记账表*/   ");
		sb.append("LEFT JOIN CI_ORDER ORD ON CGIP.ID_OR=ORD.ID_OR  /*医嘱表*/  ");
		sb.append("LEFT JOIN 	BD_MHI_HP MHI ON CGIP.ID_HP=MHI.ID_HP /*医保类别字典*/  ");
		sb.append("LEFT JOIN 	BD_PSNDOC PSNDOC1 ON CGIP.ID_EMP_OR=PSNDOC1.ID_PSNDOC /*人员基本信息1*/  ");
		sb.append("LEFT JOIN 	BD_PSNDOC PSNDOC2 ON CGIP.ID_EMP_CG=PSNDOC2.ID_PSNDOC /*人员基本信息2*/  ");
		sb.append("LEFT JOIN  BD_ORG ORG ON CGIP.ID_ORG_OR=ORG.ID_ORG /*组织*/   ");
		sb.append("LEFT JOIN  BD_DEP DEP ON CGIP.ID_DEP_OR=DEP.ID_DEP /*部门*/  ");
		sb.append("LEFT JOIN  BL_HP_ENTCODE_AH AH ON CGIP.ID_ENT=AH.ID_ENT /*患者医保登记信息*/  ");
		sb.append("LEFT JOIN BD_MEASDOC MEASDOC ON CGIP.SRVU=MEASDOC.ID_MEASDOC ");
		sb.append("WHERE 1=1 ");
		if(!StringUtil.isEmpty(this.ent)){
			sb.append(" AND CGIP.ID_ENT =?  ");
		}
		if(!StringUtil.isEmpty(this.stip)){
			sb.append(" AND CGIP.ID_STIP=?  ");
		}
		return sb.toString();
	}	
}
