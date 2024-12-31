package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIncItem4CmlIncDTOQry implements ITransQry{

	String billNo;
	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetIncItem4CmlIncDTOQry(String billNo, String codePat) throws BizException {
		
		this.billNo = billNo;
		this.codePat = codePat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(billNo);
		
		return param;
	}
	

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		// selfpay --自费
				// hospitalbreaks --医院减免--
				// xyao --西药
				// zchyao --中成药
				// zcyao --中草药
				// examinecost --检查费
				// radiate --放射
				// bultrasonic --B超
				// nmr --核磁
				// testcost --治疗费
				// materialscost --材料费
				// operationcost --手术费
				// oxygencost --输氧费
				// bloodcost --输血费
				// orthodonticcost --正畸费--
				// inserttoothcost --镶牙费--
				// sfjdcost --司法鉴定--
				// othercost --其他项目
				// diagnosticcost --诊察费--
				// treatcost --化验费
				// medicalservcost --医事服务费
				// consultationcost --一般诊疗费
				// registrationcost --挂号费
				// othermzcost --其他门诊收费--
				sql.append("SELECT * FROM ( ");
				sql.append("SELECT  ");
				sql.append("DECODE(itm.code_inccaitm, ");
				sql.append("'002','examinecost', ");//--检查费                              
				sql.append("'003','treatcost',  ");//--化验费                                  
				sql.append("'004','testcost',  ");//--治疗费                                   
				sql.append("'005','zchyao',  ");//--中成药费                                   
				sql.append("'006','zcyao', ");//--中草药费                                   
				sql.append("'008','operationcost', ");//--手术费                               
				sql.append("'010','bloodcost', ");//--输血费                                   
				sql.append("'011','oxygencost',  ");//--输氧费                                 
				sql.append("'014','nmr',  ");//--核磁费                                        
				sql.append("'018','bultrasonic', ");//--B超费                                  
				sql.append("'019','othercost',");//-- 其它                                     
				sql.append("'062','materialscost',  ");//--材料费                              
				sql.append("'063','consultationcost', ");//--诊疗费                            
				sql.append("'070','medicalservcost', ");//--诊察费/医事服务费               
				sql.append("'001','xyao',  ");//--西药费                                       
				sql.append("'009','radiate',   ");//--放射费                                   
				sql.append("'020','selfpay', ");//--自费项目                                   
				sql.append("'060','registrationcost',   ");//--挂号费                          
				sql.append("'othercost')  as INCODE,sum(cg.eu_direct * itm.amt_ratio) as AMT");
				sql.append(" from Bl_cg_itm_oep itm   ");
				sql.append(" inner join Bl_cg_oep cg  ");
				sql.append("    on itm.id_cgoep = cg.id_cgoep ");
				sql.append(" inner join    BL_INC_OEP inc ");
				sql.append("on  itm.id_stoep=inc.id_stoep ");
				sql.append(" where incno=? ");
				sql.append(" group by itm.code_inccaitm ");
				sql.append(") PIVOT (SUM(AMT) FOR INCODE IN (  ");
				sql.append("'examinecost' as examinecost, ");
				sql.append("'treatcost' as treatcost, ");
				sql.append("'testcost' as testcost, ");
				sql.append("'zchyao' as zchyao, ");
				sql.append("'zcyao' as zcyao,  ");
				sql.append("'operationcost' as operationcost, ");
				sql.append("'bloodcost' as bloodcost,");
				sql.append("'oxygencost' as oxygencost,  ");
				sql.append("'nmr' as nmr,  ");
				sql.append("'bultrasonic' as bultrasonic,  ");
				sql.append("'othercost' as othercost, ");
				sql.append("'materialscost' as materialscost,  ");
				sql.append("'consultationcost' as consultationcost, ");
				sql.append("'medicalservcost' as medicalservcost,  ");
				sql.append("'xyao' as xyao, ");
				sql.append("'radiate' as radiate, ");
				sql.append("'selfpay' as selfpay,  ");
				sql.append("'registrationcost' as registrationcost");
				sql.append("))");
		
		return sql.toString();
	}

}
