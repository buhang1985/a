package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.en.comm.ep.EntDiEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.inpatient.dto.d.PatientsDTO;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院医生站患者列表（转科患者BP）
 * 
 * @author liubin
 *
 */
public class TransOutPatsBP {

	/**
     * 获取转科患者集合
     * @param deptId 科室id
     * @param begin 开始日期
     * @param end 结束日期
     * @return
     * @throws BizException
     */
    public PatientsDTO[] getTransOutPats(String deptId,FDate begin,FDate end) throws BizException{
    	StringBuilder builder = new StringBuilder();
		builder.append("SELECT DISTINCT ");
		builder.append("EN.ID_ENT AS ID_ENT,"); //就诊ID
		builder.append("EN.CODE AS CODE,"); //住院号
		builder.append("EN.DT_ACPT AS DT_ACPT,"); //入科时间
		builder.append("EN.NAME_PAT AS NAME_PAT,"); //姓名
		builder.append("IP.NAME_BED AS NAME_BED,"); //床位
		builder.append("EN.ID_DEP_PHY AS ID_DEP_PHY,"); //科室
		builder.append("EN.ID_EMP_PHY AS ID_EMP_PHY,"); //主治大夫
		builder.append("EN.ID_PAT AS ID_PAT,"); //患者ID
		builder.append("EN.ID_ENTP AS ID_ENTP,"); //就诊类型ID
		builder.append("EN.CODE_ENTP AS CODE_ENTP,"); //就诊类型Code
		builder.append("SEX.NAME AS SEX_PAT,"); //性别
		builder.append("EN.ID_SEX_PAT AS ID_SEX_PAT,"); //性别ID
		builder.append("EN.DT_BIRTH_PAT AS DT_BIRTH_PAT,");//出生日期
		builder.append("IP.SD_LEVEL_DISE AS SD_LEVEL_DISE,"); //病情级别
		builder.append("LVL.NAME AS NAME_LEVEL_DISE,"); //病情级别
		builder.append("EN.ID_WG_PHY AS ID_WG_PHY,"); //医疗组
		builder.append("EN.ID_DEP_NUR AS ID_DEP_NUR,"); //病区
		builder.append("IP.ID_BED AS ID_BED,"); //床位ID
		builder.append("DEP.ID_DEP AS ID_DEP_TO,");
		builder.append("DEPT.NAME AS NAME_DEP_TO,");
		builder.append("DEP.DT_B AS DT_B ");
		builder.append("FROM EN_ENT EN "); //
		builder.append("INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		builder.append("INNER JOIN EN_ENT_DEP DEP ON EN.ID_ENT = DEP.ID_ENT ");
		builder.append("LEFT JOIN BD_UDIDOC SEX ON EN.ID_SEX_PAT = SEX.ID_UDIDOC ");
		builder.append("LEFT JOIN BD_DEP DEPT ON DEP.ID_DEP = DEPT.ID_DEP ");
		builder.append("LEFT JOIN BD_UDIDOC LVL ON IP.ID_LEVEL_DISE = LVL.ID_UDIDOC ");
		builder.append("WHERE DEP.SD_ENTDEPROLE = ? ");
		builder.append("AND DEP.ID_DEP_FROM = ? ");
		builder.append("AND DEP.DT_B >= ? ");
		builder.append("AND DEP.DT_B <= ? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(IEnDictCodeConst.SD_ENTDEPROLE_DEP);
		param.addParam(deptId);
		param.addParam(begin);
		Calendar cal = Calendar.getInstance();
		cal.setTime(end.toDate());
		cal.add(Calendar.DATE, 1);//加1天
		param.addParam(new FDate(cal.getTime()));
		@SuppressWarnings("unchecked")
		List<PatientsDTO> list = (List<PatientsDTO>) new DAFacade().execQuery(sql,param, new BeanListHandler(PatientsDTO.class));
		if(!EnValidator.isEmpty(list)){
			//查询主诊断
			EntDiDO[] entDiDOs = new EntDiEP().getEntMajDiList(getStrList(list));
			if(!EnValidator.isEmpty(entDiDOs)){
				for(PatientsDTO dto : list){
					for(EntDiDO entDiDO : entDiDOs){
						if(entDiDO.getId_ent()!=null&&entDiDO.getId_ent().equals(dto.getId_ent())){
							dto.setName_di(entDiDO.getName_didef_dis());
							dto.setSd_disunjtp(entDiDO.getSd_cdsystp());
							break;
						}
					}
				}
			}
			return list.toArray(new PatientsDTO[0]);
		}
		return null;
    }
    
    private List<String> getStrList(List<PatientsDTO> list){
    	int len = list.size();
    	String[] entIds = new String[len];
    	for(int i=0;i<len;i++){
    		entIds[i] = list.get(i).getId_ent();
    	}
    	return Arrays.asList(entIds);
    }
}
