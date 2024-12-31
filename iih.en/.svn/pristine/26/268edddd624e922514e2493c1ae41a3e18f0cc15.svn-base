package iih.en.pv.s.bp.ip.ws;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.ws.bean.EntDepTransBean;
import iih.en.pv.out.ws.bean.IpDetailInfoBean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查找住院转科信息
 * 
 * @author liubin
 *
 */
public class GetIpEntDepTransInfoBP extends AbstractGetIpDetailInfoBP<EntDepTransBean> {

	@Override
	protected Set<IpDetailInfoBean<EntDepTransBean>> assemlyDetail(String[] entIds)
			throws BizException {
		List<IpDetailInfoBean<EntDepTransBean>> list = this.getIpDetailInfoBeanInfo(entIds);
		List<EntDepTransBean> entDepTransBeans = this.getEntDepTransBeanSql(entIds);
		return this.getSet(list, entDepTransBeans);
	}
	
	/**
     * 查询医保详细信息
     * 
     * @param list
     * @param entIds
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
	private List<EntDepTransBean> getEntDepTransBeanSql(String[] entIds) throws BizException {
    	if(EnValidator.isEmpty(entIds))
    		return null;
    	StringBuilder sqlSBuilder = new StringBuilder();
    	SqlParam param = new SqlParam();
        sqlSBuilder.append(" SELECT TRANS.ID_ENT AS ID_ENT,");//就诊iD
        sqlSBuilder.append(" DEP.CODE  AS CODE_DEP_FROM,");//原科室编码
        sqlSBuilder.append(" DEP.NAME  AS NAME_DEP_FROM ,");//原科室名称
        sqlSBuilder.append(" DEPNUR.CODE AS CODE_NUR_FROM ,");//原病区编码
        sqlSBuilder.append(" DEPNUR.NAME AS NAME_NUR_FROM ,");//原病区名称
        sqlSBuilder.append(" DEPBED.CODE AS CODE_BED_FROM,");//原床位编码
        sqlSBuilder.append(" DEPBED.NAME AS NAME_BED_FROM,");//原床位名称
        sqlSBuilder.append(" DEPTO.CODE AS CODE_DEP_TO,");//目标科室编码
        sqlSBuilder.append(" DEPTO.NAME AS NAME_DEP_TO,");//目标科室名称
        sqlSBuilder.append(" DEPNURTO.CODE AS CODE_NUR_TO,");//目标病区编码
        sqlSBuilder.append(" DEPNURTO.NAME AS NAME_NUR_TO ,");//目标病区名称
        sqlSBuilder.append(" DEPBEDTO.CODE AS CODE_BED_TO ,");//目标床位编码
        sqlSBuilder.append(" DEPBEDTO.NAME AS NAME_BED_TO ,");//目标床位名称
        sqlSBuilder.append(" TRANS.DT_APPLY,");//转科申请时间
        sqlSBuilder.append(" TRANS.DT_ACPT,");//转科接收时间
        sqlSBuilder.append(" PSNDOCFROM.CODE AS CODE_EMP_APPL,");//申请人操作编码
        sqlSBuilder.append(" PSNDOCFROM.NAME AS NAME_EMP_APPL,");//申请操作人名称
        sqlSBuilder.append(" PSNDOCTO.CODE AS CODE_EMP_ACPT,");//接受操作人编码
        sqlSBuilder.append(" PSNDOCTO.NAME AS NAME_EMP_ACPT ");//接受操作人名称
        
        sqlSBuilder.append(" FROM EN_DEP_TRANS TRANS ");
        sqlSBuilder.append(" LEFT JOIN BD_DEP DEP ON  DEP.ID_DEP = TRANS.ID_DEP_FROM ");
        sqlSBuilder.append(" LEFT JOIN BD_DEP DEPNUR ON DEPNUR.ID_DEP = TRANS.ID_DEP_NUR_FROM  ");
        sqlSBuilder.append(" LEFT JOIN BD_BED DEPBED ON DEPBED.ID_BED = TRANS.ID_BED_FROM ");
        
        sqlSBuilder.append(" LEFT JOIN BD_DEP DEPTO ON  DEPTO.ID_DEP = TRANS.ID_DEP_TO  ");
        sqlSBuilder.append(" LEFT JOIN BD_DEP DEPNURTO ON DEPNURTO.ID_DEP = TRANS.ID_DEP_NUR_TO ");
        sqlSBuilder.append(" LEFT JOIN BD_BED DEPBEDTO ON DEPBEDTO.ID_BED = TRANS.ID_BED_TO ");
        
        sqlSBuilder.append(" LEFT JOIN BD_PSNDOC PSNDOCFROM  ON PSNDOCFROM.ID_PSNDOC = TRANS.ID_EMP_APPL ");
        sqlSBuilder.append(" LEFT JOIN BD_PSNDOC PSNDOCTO  ON PSNDOCTO.ID_PSNDOC = TRANS.ID_EMP_APPL ");
        sqlSBuilder.append(" WHERE ").append(EnSqlUtils.getInSqlByIds(" TRANS.ID_ENT ", entIds));
        sqlSBuilder.append(" AND TRANS.EU_TRANS = '1' ");
        List<EntDepTransBean> results = (List<EntDepTransBean>) new DAFacade().execQuery(sqlSBuilder.toString(), param, new BeanListHandler(EntDepTransBean.class));
        return results;
    }


	
	private Set<IpDetailInfoBean<EntDepTransBean>> getSet(List<IpDetailInfoBean<EntDepTransBean>> ipDetailInfoBean, List<EntDepTransBean> t) {
		Set<IpDetailInfoBean<EntDepTransBean>> sBeans = new HashSet<>();
		if(!EnValidator.isEmpty(ipDetailInfoBean)){
			for (IpDetailInfoBean<EntDepTransBean> ipDetailInfoBean2 : ipDetailInfoBean) {
				Set<EntDepTransBean> sEntDiBeans = new HashSet<>();
				if(!EnValidator.isEmpty(t)){
					for (EntDepTransBean entdiBean:t) {
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
