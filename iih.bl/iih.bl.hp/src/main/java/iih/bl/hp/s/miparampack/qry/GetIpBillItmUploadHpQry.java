package iih.bl.hp.s.miparampack.qry;

import iih.bl.params.BlParams;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpBillItmUploadHpQry implements ITransQry{
	String id_ent;
	String id_ent_mom;
	//住院结算id
	String id_stip;
	
	public GetIpBillItmUploadHpQry(String strIdEnt,String idStip) throws BizException
	{
		//判断母婴是否合并结算
		FBoolean isMerge = BlParams.BLSTIP0005();
		IEnOutQryService enService = ServiceFinder.find(IEnOutQryService.class);
		NewbornDO enNewBorn = enService.getNewbornDO(strIdEnt);
		if(FBoolean.TRUE.equals(isMerge) && enNewBorn != null){
			this.id_ent_mom = strIdEnt;
		} 
		this.id_ent = strIdEnt;
		
		this.id_stip = idStip;

	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
	
		if (!StringUtil.isEmpty(this.id_stip)) {
			sqlParam.addParam(this.id_stip);
		}
		if (!StringUtil.isEmpty(this.id_ent)) {
			sqlParam.addParam(this.id_ent);
		}
		if (!StringUtil.isEmpty(this.id_ent_mom)) {
			sqlParam.addParam(this.id_ent_mom);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append("CGIP.ID_ENT ID_ENT, /*记账主键*/ " );//记账主键
		sb.append("CGIP.ID_PAT, /*患者主键*/ "); //患者主键
		sb.append("PAT.NAME NAME_PAT, /*患者姓名*/ ");//患者姓名
		sb.append("CGIP.ID_CGIP, /*记账主键*/ ");//记账主键
		sb.append("CGIP.PRICE, /*价格*/ ");//标准单价
		sb.append("CGIP.PRICE_RATIO, /*价格_折扣*/ ");//折扣价格
		sb.append("CGIP.QUAN*CGIP.EU_DIRECT QUAN, /*数量*记退费方向*/ ");//数量
		sb.append("CGIP.ID_SRV, /*服务项目*/ ");//服务主键
		sb.append("CGIP.SPEC SPEC, /*规格*/ ");//规格
		sb.append("DOC.NAME NAME_SRVU, /*服务项目单位*/ ");//单位
		sb.append(" (CASE WHEN PSNDOC1.NAME IS NULL THEN PSNDOC2.NAME ELSE PSNDOC1.NAME END) NAME_EMP_OR, /*医生姓名*/   ");//医生姓名
		sb.append(" (CASE WHEN PSNDOC1.CODE IS NULL THEN PSNDOC2.CODE ELSE PSNDOC1.CODE END) ID_EMP_OR, /*医生编码*/  ");//医生主键
		sb.append("DEP.CODE CODE_DEP_OR, /*开立科室*/ ");//科别编码
		sb.append("DEP.NAME NAME_DEP_OR, /*科室名称*/ ");//开单科室
		sb.append("CGIP.AMT_RATIO*CGIP.EU_DIRECT AMT_RATIO , ");//金额
		sb.append("CGIP.FG_HP, /*记账上传医保标志*/ ");//是否上传医保
		sb.append("CGIP.EU_DIRECT, /*记退费方向*/ ");//方向
		sb.append("CASE CGIP.EU_DIRECT WHEN 1 THEN '记费' WHEN -1 THEN '退费' END EU_NAME, /**/ ");//方向名称
		sb.append("CGIP.CODE_MM, /*物品编码*/ ");//物品编码
		sb.append("CGIP.NAME_MM, /*物品名称*/ ");//物品名称
		sb.append("CGIP.ID_SRVTP, /*服务项目类型*/ ");//服务主键
		sb.append("CGIP.DT_SRV, /*服务项目发生日期*/ ");//服务日期
		sb.append("CGIP.SD_SRVTP, /*服务项目分类编码*/ ");//服务类型编码
		sb.append("CGIP.ID_MM, /*物品*/ ");//物品主键
		sb.append("CGIP.ID_ORSRV, /*医嘱服务*/ ");//医嘱服务主键
		sb.append("CGIP.CODE_INCCAITM, /*账单项编码*/ ");//账单项编码
		sb.append("CGIP.NAME_INCCAITM, /*账单项名称*/ ");//账单项名称
		sb.append("CGIP.FG_BB, /*是否新生儿*/ ");//是否新生儿
		sb.append("CGIP.ID_ENT_MOM, /*母亲就诊主键*/ ");//母亲就诊主键
		sb.append("CGIP.NAME_SRV, /*服务项目名称*/ ");//服务名称
		sb.append("CGIP.CODE_SRV, /*服务项目编码*/ ");//服务编码
		sb.append("CGIP.FG_MM, /*物品标识*/ ");//物品标识
		sb.append("CGIP.ID_PAR ID_CGPAR, /*退费关联记账主键*/ ");//记账关系ID
		sb.append("CGIP.DT_CG, /*记账日期时间*/ ");//计费时间
		sb.append("CGIP.fg_selfpay Fg_selfpay, ");//自费标识
		sb.append("ENT.CODE CODE_ENT  /*就诊编码*/ ");//就诊号
		
		sb.append(" FROM BL_CG_IP CGIP ");
		sb.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=CGIP.ID_ENT ");
		sb.append(" INNER JOIN PI_PAT PAT ON CGIP.ID_PAT=PAT.ID_PAT ");
		sb.append(" LEFT JOIN BD_PSNDOC PSNDOC1 ON CGIP.ID_EMP_OR=PSNDOC1.ID_PSNDOC /*人员基本信息1*/  ");
		sb.append(" LEFT JOIN BD_PSNDOC PSNDOC2 ON CGIP.ID_EMP_CG=PSNDOC2.ID_PSNDOC /*人员基本信息1*/  ");
		sb.append(" INNER JOIN BD_MEASDOC DOC ON CGIP.SRVU=DOC.ID_MEASDOC ");//计量单位
		sb.append(" LEFT JOIN  BD_DEP DEP ON CGIP.ID_DEP_OR=DEP.ID_DEP /*部门*/  ");
		sb.append(" WHERE   CGIP.FG_HP = 'N' ");
		sb.append(" AND CGIP.FG_ST='N' ");
		if (!StringUtil.isEmpty(this.id_stip)) {
			sb.append(" AND CGIP.ID_STIP=? ");
		}
		if (!StringUtil.isEmpty(this.id_ent_mom)) {
			sb.append(" AND (CGIP.ID_ENT = ? OR CGIP.ID_ENT_MOM = ? )");
		} else {
			sb.append(" AND (CGIP.ID_ENT = ?  )");
		}
		sb.append("  ORDER BY CGIP.DT_CG,CGIP.ID_PAR ");
		return sb.toString();
	}
	
}
