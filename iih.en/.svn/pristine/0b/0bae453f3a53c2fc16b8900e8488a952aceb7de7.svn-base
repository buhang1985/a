package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.EntDiBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找住院诊断信息
 * 
 * @author liubin
 *
 */
public class GetIpEntDiInfoBP extends AbstractGetIpDetailInfoBP<EntDiBean> {

	@Override
	protected Set<IpDetailInfoBean<EntDiBean>> assemlyDetail(String[] entIds)
			throws BizException {
		List<IpDetailInfoBean<EntDiBean>> list = this.getIpDetailInfoBeanInfo(entIds);
		List<EntDiBean> EntDiBeans = this.getEntDiBeanSql(entIds);
		return this.getSet(list, EntDiBeans);
	}
	
	
	 /**
     * 查询诊断详细信息
     * 
     * @param list
     * @param entIds
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	private List<EntDiBean> getEntDiBeanSql(String[] entIds) throws BizException {
    	if(EnValidator.isEmpty(entIds))
    		return null;
    	StringBuilder sqlSBuilder = new StringBuilder();
    	SqlParam param = new SqlParam();
        sqlSBuilder.append(" SELECT ENTDI.ID_ENT AS ID_ENT,");//就诊iD
        sqlSBuilder.append(" ENTDI.SORTNO AS SORTNO,");//就诊编号
        sqlSBuilder.append(" UDIDOC.CODE AS SD_CDSYSTP ,");//诊断学科类型编码
        sqlSBuilder.append(" UDIDOC.NAME AS NAME_CDSYSTP ,");//诊断学科类型名称
        sqlSBuilder.append(" DIDEF.CODE AS CODE_DIDEF_DIS ,");//诊断编码
        sqlSBuilder.append(" DIDEF.NAME AS NAME_DIDEF_DIS,");//诊断名称
        sqlSBuilder.append(" ENTDI.SUPPLEMENT,");//诊断补充说明
        sqlSBuilder.append(" ENTDI.FG_MAJ,");//主要诊断标识
        sqlSBuilder.append(" ENTDI.DT_DIAG,");//诊断时间
        sqlSBuilder.append(" PSNDOC.CODE AS CODE_EMP_PHY,");//诊断医生编码
        sqlSBuilder.append(" PSNDOC.NAME AS NAME_EMP_PHY,");//诊断医生名称
        sqlSBuilder.append(" ENTDI.FG_CURED,");//治愈标识
        sqlSBuilder.append(" DITP.CODE AS SD_DITP,");//诊断过程编码
        sqlSBuilder.append(" DITP.NAME AS NAME_DITP,");//诊断过程状态名称
        sqlSBuilder.append(" ENTDI.FG_SUSPDI,");//疑似诊断表示
        sqlSBuilder.append(" ENTDI.ID_DIDEF_SYN,");//证候诊断编码
        sqlSBuilder.append(" ENTDI.NAME_DIDEF_SYN,");//证候诊断名称
        sqlSBuilder.append(" DEP.CODE AS CODE_DEP  ,");//诊断科室编码
        sqlSBuilder.append(" DEP.NAME AS NAME_DEP,");//诊断科室名称
        sqlSBuilder.append(" ENTDI.FG_SELF ,");//自定义标识
        sqlSBuilder.append(" ENTDI.FG_CHRONIC,");//慢性病标识
        sqlSBuilder.append(" ENTDI.FG_SPECIAL,");//特种病标识
        sqlSBuilder.append(" INFECTIONTP.CODE AS SD_INFECTIONTP,");//特种病标识
        sqlSBuilder.append(" INFECTIONTP.NAME AS NAME_INFECTIONTP,");//特殊病名称
        sqlSBuilder.append(" ENTDI.FG_UR ");//上传标识
        sqlSBuilder.append(" FROM EN_ENT_DI ENTDI");
        sqlSBuilder.append(" LEFT JOIN BD_DI_DEP DIDEP  ON  ENTDI.ID_ENT = DIDEP.ID_DEP ");
        sqlSBuilder.append(" LEFT JOIN BD_PSNDOC PSNDOC ON PSNDOC.ID_PSNDOC = ENTDI.ID_EMP_PHY ");
        sqlSBuilder.append(" LEFT JOIN BD_DI_DEF DIDEF ON DIDEF.ID_DIDEF = ENTDI.ID_DIDEF_DIS");
        sqlSBuilder.append(" LEFT JOIN BD_UDIDOC UDIDOC ON UDIDOC.ID_UDIDOC = ENTDI.ID_CDSYSTP ");
        sqlSBuilder.append(" LEFT JOIN BD_UDIDOC DITP ON DITP.ID_UDIDOC = ENTDI.ID_DITP ");
        sqlSBuilder.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP = ENTDI.ID_DEP ");
        sqlSBuilder.append(" LEFT JOIN BD_UDIDOC INFECTIONTP ON INFECTIONTP.ID_UDIDOC = ENTDI.ID_INFECTIONTP ");
        sqlSBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds(" ENTDI.ID_ENT ", entIds));
        List<EntDiBean> results = (List<EntDiBean>) new DAFacade().execQuery(sqlSBuilder.toString(), param, new BeanListHandler(EntDiBean.class));
        return results;
    }


	
	private Set<IpDetailInfoBean<EntDiBean>> getSet(List<IpDetailInfoBean<EntDiBean>> ipDetailInfoBean, List<EntDiBean> t) {
		Set<IpDetailInfoBean<EntDiBean>> sBeans = new HashSet<>();
		if(!EnValidator.isEmpty(ipDetailInfoBean)){
			for (IpDetailInfoBean<EntDiBean> ipDetailInfoBean2 : ipDetailInfoBean) {
				Set<EntDiBean> sEntDiBeans = new HashSet<>();
				if(!EnValidator.isEmpty(t)){
					for (EntDiBean entdiBean:t) {
						if(ipDetailInfoBean2.getId_ent().equals(entdiBean.getId_ent())){
							sEntDiBeans.add(entdiBean);
						}
					}
				}
				ipDetailInfoBean2.setItem(sEntDiBeans);
				sBeans.add(ipDetailInfoBean2);
			}
		}
		return sBeans;
	}
	
    
}
